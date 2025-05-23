package com.tencent.mobileqq.zplan.authorize.impl;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerIpc;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.ueloading.report.ZPlanUEReportData;
import com.tencent.mobileqq.zootopia.ueloading.report.ZPlanUEReportHelper;
import com.tencent.mobileqq.zplan.authorize.api.CheckResult;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.api.ModChekerParams;
import com.tencent.mobileqq.zplan.authorize.impl.checker.mod.EnterModCheckRequest;
import com.tencent.mobileqq.zplan.authorize.impl.checker.mod.MaintenanceChecker;
import com.tencent.mobileqq.zplan.authorize.impl.checker.mod.ModNativeStatusChecker;
import com.tencent.mobileqq.zplan.authorize.impl.checker.mod.ModServerChecker;
import com.tencent.mobileqq.zplan.authorize.impl.checker.mod.PhoneChecker;
import com.tencent.mobileqq.zplan.authorize.impl.checker.mod.UESoChecker;
import com.tencent.mobileqq.zplan.authorize.impl.checker.mod.UserModInfoChecker;
import com.tencent.mobileqq.zplan.authorize.impl.checker.mod.e;
import com.tencent.mobileqq.zplan.authorize.impl.checker.mod.f;
import com.tencent.mobileqq.zplan.authorize.impl.checker.scene.SceneCheckRequest;
import com.tencent.mobileqq.zplan.authorize.impl.checker.scene.ScenePhoneChecker;
import com.tencent.mobileqq.zplan.authorize.impl.helper.d;
import com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager;
import com.tencent.qphone.base.util.QLog;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J<\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J&\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J&\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J.\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J.\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u001a0\nH\u0016J.\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u000e2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/EntranceCheckImpl;", "Lcom/tencent/mobileqq/zplan/authorize/api/c;", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/a;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "checker", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "callback", "", "U0", "", "V0", "", "modId", "Lcom/tencent/mobileqq/zplan/authorize/api/ModChekerParams;", "params", "U", "D", "n0", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$EntryType;", "sceneType", "Lcom/tencent/mobileqq/zplan/authorize/api/CheckResult;", ExifInterface.LATITUDE_SOUTH, "needServerFullCheck", "I", "P", "<init>", "()V", "b", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class EntranceCheckImpl implements com.tencent.mobileqq.zplan.authorize.api.c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/EntranceCheckImpl$b", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "result", "", "c", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> f331388a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZootopiaEnterParams f331389b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZootopiaSource f331390c;

        b(com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> aVar, ZootopiaEnterParams zootopiaEnterParams, ZootopiaSource zootopiaSource) {
            this.f331388a = aVar;
            this.f331389b = zootopiaEnterParams;
            this.f331390c = zootopiaSource;
        }

        @Override // com.tencent.mobileqq.zplan.authorize.api.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(EnterModCheckResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ModEnterCheckImpl", 1, "enterCloudModCheck onCheckComplete result = " + result);
            this.f331388a.b(result);
            d.f331487a.e(this.f331389b, this.f331390c, result);
        }

        @Override // com.tencent.mobileqq.zplan.authorize.api.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(EnterModCheckResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ModEnterCheckImpl", 1, "enterCloudModCheck onCheckInterceptor result = " + result);
            this.f331388a.a(result);
            d.f331487a.f(this.f331389b, this.f331390c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/EntranceCheckImpl$c", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/CheckResult;", "result", "", "c", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zplan.authorize.api.a<CheckResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.authorize.api.a<CheckResult> f331391a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f331392b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CheckPhoneManager.EntryType f331393c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ZootopiaSource f331394d;

        c(com.tencent.mobileqq.zplan.authorize.api.a<CheckResult> aVar, int i3, CheckPhoneManager.EntryType entryType, ZootopiaSource zootopiaSource) {
            this.f331391a = aVar;
            this.f331392b = i3;
            this.f331393c = entryType;
            this.f331394d = zootopiaSource;
        }

        @Override // com.tencent.mobileqq.zplan.authorize.api.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(CheckResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ModEnterCheckImpl", 1, "enterSceneCheck onCheckComplete result.code = " + result.getResultCode());
            this.f331391a.b(result);
            d.f331487a.q(this.f331392b, this.f331393c, this.f331394d, result);
        }

        @Override // com.tencent.mobileqq.zplan.authorize.api.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(CheckResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ModEnterCheckImpl", 1, "enterSceneCheck onCheckInterceptor result.code = " + result.getResultCode());
            this.f331391a.a(result);
            d.f331487a.r(this.f331392b, this.f331393c, this.f331394d);
        }
    }

    private final boolean V0() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100472", true);
    }

    @Override // com.tencent.mobileqq.zplan.authorize.api.c
    public void I(ZootopiaEnterParams enterParams, ZootopiaSource source, boolean needServerFullCheck, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ModEnterCheckImpl", 1, "enterCloudModCheck mapId = " + enterParams.getMapId() + " mapName = " + enterParams.getName() + " ");
        com.tencent.mobileqq.zplan.authorize.impl.checker.a<EnterModCheckRequest, EnterModCheckResult> a16 = new com.tencent.mobileqq.zplan.authorize.impl.checker.a().a(new f()).a(new MaintenanceChecker()).a(new ne3.b()).a(new ne3.c());
        if (needServerFullCheck) {
            a16.a(new ne3.a());
        }
        a16.a(new com.tencent.mobileqq.zplan.authorize.impl.checker.mod.d());
        U0(enterParams, source, a16, new b(callback, enterParams, source));
        d.f331487a.g(enterParams, source);
    }

    @Override // com.tencent.mobileqq.zplan.authorize.api.c
    public void P() {
        CheckPhoneManager.f331491a.m();
    }

    @Override // com.tencent.mobileqq.zplan.authorize.api.c
    public void S(int sceneId, CheckPhoneManager.EntryType sceneType, ZootopiaSource source, com.tencent.mobileqq.zplan.authorize.api.a<CheckResult> callback) {
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ModEnterCheckImpl", 1, "enterSceneCheck sceneId=" + sceneId + " sceneType=" + sceneType);
        new com.tencent.mobileqq.zplan.authorize.impl.checker.a().a(new ScenePhoneChecker()).a(new com.tencent.mobileqq.zplan.authorize.impl.checker.scene.b()).b(new SceneCheckRequest(sceneId, sceneType), new CheckResult(0, source), new c(callback, sceneId, sceneType, source));
        d.f331487a.s(sceneId, sceneType, source);
    }

    @Override // com.tencent.mobileqq.zplan.authorize.api.c
    public void n0(final int modId, final ZootopiaEnterParams enterParams, final ZootopiaSource source, final com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final long currentTimeMillis = System.currentTimeMillis();
        U0(enterParams, source, new com.tencent.mobileqq.zplan.authorize.impl.checker.a().a(new ModServerChecker(false)), new com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.EntranceCheckImpl$enterModServerCheck$1
            @Override // com.tencent.mobileqq.zplan.authorize.api.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void b(final EnterModCheckResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                QLog.i("ModEnterCheckImpl", 1, "enterModCheck onCheckComplete result.code = " + result.getResultCode() + ", cost = " + currentTimeMillis2);
                callback.b(result);
                d.f331487a.n(modId, result, source, enterParams.getSource(), currentTimeMillis2);
                if (result.isPassed()) {
                    return;
                }
                ZootopiaDownloadManagerIpc zootopiaDownloadManagerIpc = ZootopiaDownloadManagerIpc.f328013a;
                final int i3 = modId;
                final ZootopiaEnterParams zootopiaEnterParams = enterParams;
                final ZootopiaSource zootopiaSource = source;
                zootopiaDownloadManagerIpc.g(i3, new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.EntranceCheckImpl$enterModServerCheck$1$onCheckComplete$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                        invoke2(zootopiaDownloadData);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                        ZootopiaResData resData;
                        boolean z16 = false;
                        if (zootopiaDownloadData != null && (resData = zootopiaDownloadData.getResData()) != null && resData.getDownloadStatus() == 5) {
                            z16 = true;
                        }
                        if (z16) {
                            ZPlanUEReportHelper.INSTANCE.d(new ZPlanUEReportData(zootopiaSource, i3, null, ZootopiaEnterParams.this.getSource(), ZootopiaEnterParams.this.getLoadingId(), result.getResultCode(), null, ZootopiaEnterParams.this.getStartTime(), 68, null));
                        }
                    }
                });
            }

            @Override // com.tencent.mobileqq.zplan.authorize.api.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(EnterModCheckResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                QLog.i("ModEnterCheckImpl", 1, "enterModCheck onCheckInterceptor result.code = " + result.getResultCode());
                callback.a(result);
                d.f331487a.o(modId, result, source, enterParams.getSource());
            }
        });
        d.f331487a.p(modId, source, enterParams.getSource());
    }

    private final void U0(ZootopiaEnterParams enterParams, ZootopiaSource source, com.tencent.mobileqq.zplan.authorize.impl.checker.a<EnterModCheckRequest, EnterModCheckResult> checker, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        QLog.i("ModEnterCheckImpl", 1, "createRequestAndCheck");
        checker.b(new EnterModCheckRequest(enterParams, source), new EnterModCheckResult(0, source, enterParams, 0, null, 24, null), callback);
    }

    @Override // com.tencent.mobileqq.zplan.authorize.api.c
    public void D(final int modId, final ModChekerParams params, final com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ModEnterCheckImpl", 1, "enterModNativeCheck mapId = " + modId + " , params = " + params);
        long currentTimeMillis = System.currentTimeMillis();
        String loadingId = ((ic3.a) i.INSTANCE.a(ic3.a.class)).getLoadingId(modId);
        final ZPlanUEReportData zPlanUEReportData = new ZPlanUEReportData(params.getSource(), modId, null, params.getFromSource(), loadingId, 0, null, currentTimeMillis, 100, null);
        ZootopiaDownloadManagerIpc.f328013a.g(modId, new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.EntranceCheckImpl$enterModNativeCheck$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                invoke2(zootopiaDownloadData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                ZootopiaResData resData;
                boolean z16 = false;
                if (zootopiaDownloadData != null && (resData = zootopiaDownloadData.getResData()) != null && resData.getDownloadStatus() == 5) {
                    z16 = true;
                }
                if (z16) {
                    ZPlanUEReportData.this.i(zootopiaDownloadData.getResData().getVersion());
                    ZPlanUEReportHelper.INSTANCE.c(ZPlanUEReportData.this);
                }
            }
        });
        final ZootopiaEnterParams a16 = ZootopiaEnterParams.INSTANCE.a(modId, loadingId);
        a16.setUeParams(params.getUeParams());
        a16.setStartTime(currentTimeMillis);
        a16.setSource(params.getFromSource());
        U0(a16, params.getSource(), new com.tencent.mobileqq.zplan.authorize.impl.checker.a().a(new ModNativeStatusChecker()).a(new f()).a(new PhoneChecker()).a(new com.tencent.mobileqq.zplan.authorize.impl.checker.mod.b(params.getNeedReLaunchByScheme())).a(new UESoChecker()).a(new e(params.getSkipRedirect(), params.getSource())), new com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.EntranceCheckImpl$enterModNativeCheck$2
            @Override // com.tencent.mobileqq.zplan.authorize.api.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void b(final EnterModCheckResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                long currentTimeMillis2 = System.currentTimeMillis() - ZootopiaEnterParams.this.getStartTime();
                QLog.i("ModEnterCheckImpl", 1, "enterModCheck onCheckComplete result.code = " + result.getResultCode() + ", cost = " + currentTimeMillis2);
                callback.b(result);
                d.f331487a.k(modId, result, params, currentTimeMillis2);
                if (result.isPassed()) {
                    return;
                }
                ZootopiaDownloadManagerIpc zootopiaDownloadManagerIpc = ZootopiaDownloadManagerIpc.f328013a;
                int i3 = modId;
                final ZPlanUEReportData zPlanUEReportData2 = zPlanUEReportData;
                zootopiaDownloadManagerIpc.g(i3, new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.EntranceCheckImpl$enterModNativeCheck$2$onCheckComplete$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                        invoke2(zootopiaDownloadData);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                        ZPlanUEReportData a17;
                        ZootopiaResData resData;
                        boolean z16 = false;
                        if (zootopiaDownloadData != null && (resData = zootopiaDownloadData.getResData()) != null && resData.getDownloadStatus() == 5) {
                            z16 = true;
                        }
                        if (z16) {
                            a17 = r1.a((r21 & 1) != 0 ? r1.source : null, (r21 & 2) != 0 ? r1.mapId : 0, (r21 & 4) != 0 ? r1.modVersion : null, (r21 & 8) != 0 ? r1.fromSource : null, (r21 & 16) != 0 ? r1.loadingId : null, (r21 & 32) != 0 ? r1.errorCode : 0, (r21 & 64) != 0 ? r1.errorMsg : null, (r21 & 128) != 0 ? ZPlanUEReportData.this.startTime : 0L);
                            a17.e(result.getResultCode());
                            ZPlanUEReportHelper.INSTANCE.d(a17);
                        }
                    }
                });
            }

            @Override // com.tencent.mobileqq.zplan.authorize.api.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(EnterModCheckResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                QLog.i("ModEnterCheckImpl", 1, "enterModCheck onCheckInterceptor result.code = " + result.getResultCode());
                callback.a(result);
                d.f331487a.l(modId, result, params);
            }
        });
        d.f331487a.m(modId, params);
    }

    @Override // com.tencent.mobileqq.zplan.authorize.api.c
    public void U(final int modId, final ModChekerParams params, final com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ModEnterCheckImpl", 1, "enterModCheck mapId = " + modId + " , params = " + params);
        long currentTimeMillis = System.currentTimeMillis();
        String loadingId = ((ic3.a) i.INSTANCE.a(ic3.a.class)).getLoadingId(modId);
        final ZPlanUEReportData zPlanUEReportData = new ZPlanUEReportData(params.getSource(), modId, null, params.getFromSource(), loadingId, 0, null, currentTimeMillis, 100, null);
        ZootopiaDownloadManagerIpc.f328013a.g(modId, new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.EntranceCheckImpl$enterModCheck$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                invoke2(zootopiaDownloadData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                ZootopiaResData resData;
                boolean z16 = false;
                if (zootopiaDownloadData != null && (resData = zootopiaDownloadData.getResData()) != null && resData.getDownloadStatus() == 5) {
                    z16 = true;
                }
                if (z16) {
                    ZPlanUEReportData.this.i(zootopiaDownloadData.getResData().getVersion());
                    ZPlanUEReportHelper.INSTANCE.c(ZPlanUEReportData.this);
                }
            }
        });
        final ZootopiaEnterParams a16 = ZootopiaEnterParams.INSTANCE.a(modId, loadingId);
        a16.setUeParams(params.getUeParams());
        a16.setStartTime(currentTimeMillis);
        a16.setSource(params.getFromSource());
        com.tencent.mobileqq.zplan.authorize.impl.checker.a<EnterModCheckRequest, EnterModCheckResult> a17 = new com.tencent.mobileqq.zplan.authorize.impl.checker.a().a(new ModNativeStatusChecker()).a(new f()).a(new PhoneChecker()).a(new com.tencent.mobileqq.zplan.authorize.impl.checker.mod.b(params.getNeedReLaunchByScheme())).a(new UESoChecker()).a(new e(params.getSkipRedirect(), params.getSource()));
        if (V0()) {
            a17.a(new ModServerChecker(false));
        } else {
            a17.a(new UserModInfoChecker()).a(new com.tencent.mobileqq.zplan.authorize.impl.checker.mod.d());
        }
        U0(a16, params.getSource(), a17, new com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.EntranceCheckImpl$enterModCheck$2
            @Override // com.tencent.mobileqq.zplan.authorize.api.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void b(final EnterModCheckResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                long currentTimeMillis2 = System.currentTimeMillis() - ZootopiaEnterParams.this.getStartTime();
                QLog.i("ModEnterCheckImpl", 1, "enterModCheck onCheckComplete result.code = " + result.getResultCode() + ", cost = " + currentTimeMillis2);
                callback.b(result);
                d.f331487a.h(modId, result, params, currentTimeMillis2);
                if (result.isPassed()) {
                    return;
                }
                ZootopiaDownloadManagerIpc zootopiaDownloadManagerIpc = ZootopiaDownloadManagerIpc.f328013a;
                int i3 = modId;
                final ZPlanUEReportData zPlanUEReportData2 = zPlanUEReportData;
                zootopiaDownloadManagerIpc.g(i3, new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.EntranceCheckImpl$enterModCheck$2$onCheckComplete$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                        invoke2(zootopiaDownloadData);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                        ZPlanUEReportData a18;
                        ZootopiaResData resData;
                        boolean z16 = false;
                        if (zootopiaDownloadData != null && (resData = zootopiaDownloadData.getResData()) != null && resData.getDownloadStatus() == 5) {
                            z16 = true;
                        }
                        if (z16) {
                            a18 = r1.a((r21 & 1) != 0 ? r1.source : null, (r21 & 2) != 0 ? r1.mapId : 0, (r21 & 4) != 0 ? r1.modVersion : null, (r21 & 8) != 0 ? r1.fromSource : null, (r21 & 16) != 0 ? r1.loadingId : null, (r21 & 32) != 0 ? r1.errorCode : 0, (r21 & 64) != 0 ? r1.errorMsg : null, (r21 & 128) != 0 ? ZPlanUEReportData.this.startTime : 0L);
                            a18.e(result.getResultCode());
                            ZPlanUEReportHelper.INSTANCE.d(a18);
                        }
                    }
                });
            }

            @Override // com.tencent.mobileqq.zplan.authorize.api.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(EnterModCheckResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                QLog.i("ModEnterCheckImpl", 1, "enterModCheck onCheckInterceptor result.code = " + result.getResultCode());
                callback.a(result);
                d.f331487a.i(modId, result, params);
            }
        });
        d.f331487a.j(modId, params);
    }
}
