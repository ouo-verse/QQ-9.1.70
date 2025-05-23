package com.tencent.mobileqq.zootopia.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zootopia.ZootopiaDownloadResData;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.binding.ui.BindingPermissionFragment;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerIpc;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadManagerFragment;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.mobileqq.zootopia.g;
import com.tencent.mobileqq.zootopia.ipc.f;
import com.tencent.mobileqq.zootopia.openid.ZootopiaOpenIdSilentHelper;
import com.tencent.mobileqq.zootopia.permission.SmallHomePermissionManagerFragment;
import com.tencent.mobileqq.zootopia.permission.follow.FollowAndFansPermissionFragment;
import com.tencent.mobileqq.zootopia.profile.customer.tips.BaseTipsView;
import com.tencent.mobileqq.zootopia.service.j;
import com.tencent.mobileqq.zootopia.utils.DataConvertUtil;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.push.ZPlanOIDBPushHandler;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.report.ZootopiaStartUpReport;
import com.tencent.sqshow.zootopia.utils.ah;
import cooperation.qzone.QzoneIPCModule;
import hw4.i;
import java.util.Date;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import s84.d;
import vj3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 I2\u00020\u0001:\u0001JB\u0007\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J2\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J@\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015H\u0016J&\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u00060\u0015H\u0016J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0016J;\u0010\u001d\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J*\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020(H\u0016J(\u00100\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020/H\u0016J \u00102\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00101\u001a\u00020-H\u0016J\b\u00103\u001a\u00020\u0006H\u0016J\b\u00104\u001a\u00020\u0002H\u0016J\b\u00105\u001a\u00020\u0006H\u0016J\b\u00106\u001a\u00020-H\u0016J\b\u00107\u001a\u00020\u0002H\u0016J\b\u00109\u001a\u000208H\u0016J\b\u0010:\u001a\u000208H\u0016J\b\u0010;\u001a\u00020\u0006H\u0016J\b\u0010<\u001a\u00020\u0006H\u0016J\b\u0010=\u001a\u00020\u0002H\u0016J\b\u0010>\u001a\u00020\u0002H\u0016JW\u0010F\u001a\u00020E2M\u0010D\u001aI\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0015\u0012\u0013\u0018\u00010-\u00a2\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(1\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(C\u0012\u0004\u0012\u00020\u00060?H\u0016\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/impl/ZootopiaApiImpl;", "Lcom/tencent/mobileqq/zootopia/api/IZootopiaApi;", "", "shouldHideSmallHomeEntry", "", "getSuperQQShowBeancurdId", "", "notifyAllConfigListener", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "startDemoActivity", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "startPortalActivity", "startMakeUpActivity", "startListActivity", "mapId", FavEmoConstant.ROAMING_TYPE_PANEL, "startDetailActivity", "Lkotlin/Function1;", "callback", "openMap", "Lcom/tencent/mobileqq/zootopia/h;", "queryDownloadStatus", "startProfileCustomerActivity", "sceneType", "subSceneType", "startSimpleAvatarFragment", "(Landroid/content/Context;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;ILjava/lang/Integer;Landroid/os/Bundle;)V", "startSmallHomePermissionManagerActivity", "startFollowAndFansSettingActivity", "startBindingSettingActivity", "startDownloadManagerActivity", "type", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lbd3/e;", "data", "Lbd3/c;", "Lbd3/b;", "createProfileCommonTips", "Lcom/tencent/common/app/AppInterface;", "app", "", "masterUin", "Lad3/a;", "checkSmallHomeVisitPermission", "uin", "startSmallHomeByUin", "preLoadCoreDatas", "isParadiseTabShow", "doWhenQQLogout", "getOIDBPushHandlerName", "isDownloadingModRes", "Lcom/tencent/rdelivery/reshub/api/i;", "getResHubInstance", "getTestResHubInstance", "onAccountChange", "onAvatarChange", "ignoreProfileCardCheckForDev", "enableZPlanAIOMakeGifEntrance", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuccess", QzoneIPCModule.RESULT_CODE, "onUpdate", "Lcom/tencent/mobileqq/app/BusinessObserver;", "createCardBusinessObserver", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaApiImpl implements IZootopiaApi {
    private static final String TAG = "ZootopiaApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/api/impl/ZootopiaApiImpl$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhw4/i;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements e<i> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ad3.a f327903d;

        b(ad3.a aVar) {
            this.f327903d = aVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(i result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f327903d.onResult(result.f406523a == 1);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f327903d.onError(error, message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/api/impl/ZootopiaApiImpl$c", "Lcom/tencent/mobileqq/app/CardObserver;", "", "isSuccess", "", "uin", "", QzoneIPCModule.RESULT_CODE, "", "onUpdateAvatar", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends CardObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function3<Boolean, String, Integer, Unit> f327904d;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function3<? super Boolean, ? super String, ? super Integer, Unit> function3) {
            this.f327904d = function3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.CardObserver
        public void onUpdateAvatar(boolean isSuccess, String uin, int resultCode) {
            super.onUpdateAvatar(isSuccess, uin, resultCode);
            this.f327904d.invoke(Boolean.valueOf(isSuccess), uin, Integer.valueOf(resultCode));
        }
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void checkSmallHomeVisitPermission(AppInterface app, String masterUin, int source, ad3.a callback) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(masterUin, "masterUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        new j(source).e(app, masterUin, new b(callback));
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public BusinessObserver createCardBusinessObserver(Function3<? super Boolean, ? super String, ? super Integer, Unit> onUpdate) {
        Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
        return new c(onUpdate);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public bd3.b createProfileCommonTips(int type, ViewGroup container, bd3.e data, bd3.c callback) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BaseTipsView a16 = BaseTipsView.INSTANCE.a(container.getContext(), type);
        if (a16 == null) {
            return null;
        }
        a16.g(container, data, callback);
        return a16;
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void doWhenQQLogout() {
        u84.a.b();
        vb3.a aVar = vb3.a.f441346a;
        ((ue3.b) aVar.a(ue3.b.class)).doWhenQQLogout();
        ((zi3.a) aVar.a(zi3.a.class)).doWhenQQLogout();
        ((gk3.a) aVar.a(gk3.a.class)).L0("mainProcess#doWhenQQLogout");
        if (Build.VERSION.SDK_INT != 23) {
            i.Companion companion = k74.i.INSTANCE;
            ((f) companion.a(f.class)).notifyHideFloatWindow(((f) companion.a(f.class)).getCurrentMapId(), true);
        }
        ((vj3.a) aVar.a(vj3.a.class)).doWhenQQLogout();
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public boolean enableZPlanAIOMakeGifEntrance() {
        return ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableZPlanAIOMakeGifEntrance() && !com.tencent.mobileqq.zplan.model.j.a(((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.SAME_STYLE), new Date());
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public String getOIDBPushHandlerName() {
        String name = ZPlanOIDBPushHandler.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "ZPlanOIDBPushHandler::class.java.name");
        return name;
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public com.tencent.rdelivery.reshub.api.i getResHubInstance() {
        vj3.a aVar = (vj3.a) vb3.a.f441346a.a(vj3.a.class);
        a.C11422a.a(aVar, false, 1, null);
        return a.C11422a.b(aVar, null, null, null, 7, null);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public int getSuperQQShowBeancurdId() {
        return 14;
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public com.tencent.rdelivery.reshub.api.i getTestResHubInstance() {
        vj3.a aVar = (vj3.a) vb3.a.f441346a.a(vj3.a.class);
        a.C11422a.a(aVar, false, 1, null);
        return a.C11422a.b(aVar, null, null, "1", 3, null);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public boolean ignoreProfileCardCheckForDev() {
        return g.f328305a.c(1001);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public boolean isDownloadingModRes() {
        boolean k06 = ZootopiaDownloadManager.f327992a.k0();
        QLog.i(TAG, 1, "isDownloadingModRes " + k06);
        return k06;
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public boolean isParadiseTabShow() {
        return ((qg3.a) vb3.a.f441346a.a(qg3.a.class)).isParadiseTabShow();
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void notifyAllConfigListener() {
        d.f433509a.e();
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void onAccountChange() {
        com.tencent.mobileqq.zootopia.helper.d.f328319a.d();
        u84.a.a();
        ((zi3.a) vb3.a.f441346a.a(zi3.a.class)).j0();
        i.Companion companion = k74.i.INSTANCE;
        ((f) companion.a(f.class)).notifyHideFloatWindow(((f) companion.a(f.class)).getCurrentMapId(), true);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void onAvatarChange() {
        com.tencent.mobileqq.zootopia.helper.d dVar = com.tencent.mobileqq.zootopia.helper.d.f328319a;
        dVar.d();
        dVar.i(2);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void openMap(Context context, int mapId, ZootopiaSource source, Bundle bundle, final Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        if (callback != null) {
            Bundle bundle2 = bundle != null ? bundle.getBundle("ueParams") : null;
            if (bundle != null) {
                bundle.getBoolean("innerHandle", true);
            }
            ((si3.c) vb3.a.f441346a.a(si3.c.class)).u(mapId, source, DataConvertUtil.f329546a.c(bundle2), new Function1<EnterModCheckResult, Unit>() { // from class: com.tencent.mobileqq.zootopia.api.impl.ZootopiaApiImpl$openMap$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(EnterModCheckResult enterModCheckResult) {
                    invoke2(enterModCheckResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(EnterModCheckResult it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    callback.invoke(Integer.valueOf(it.getResultCode()));
                }
            });
            return;
        }
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, ((ISchemeApi) QRoute.api(ISchemeApi.class)).buildMapScheme(source, mapId, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void preLoadCoreDatas() {
        vb3.a aVar = vb3.a.f441346a;
        ((com.tencent.mobileqq.zplan.authorize.api.c) aVar.a(com.tencent.mobileqq.zplan.authorize.api.c.class)).P();
        ZootopiaOpenIdSilentHelper.INSTANCE.a().s(new Function1<String, Unit>() { // from class: com.tencent.mobileqq.zootopia.api.impl.ZootopiaApiImpl$preLoadCoreDatas$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        });
        com.tencent.sqshow.zootopia.avatar.loading.recorder.e.f370046a.c();
        ((si3.b) aVar.a(si3.b.class)).Q("preLoadCoreDatas", false);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void queryDownloadStatus(final int mapId, final Function1<? super ZootopiaDownloadResData, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZootopiaDownloadManagerIpc.f328013a.i(mapId, new Function1<ZootopiaResData, Unit>() { // from class: com.tencent.mobileqq.zootopia.api.impl.ZootopiaApiImpl$queryDownloadStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaResData zootopiaResData) {
                invoke2(zootopiaResData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaResData zootopiaResData) {
                if (zootopiaResData == null) {
                    callback.invoke(null);
                } else {
                    callback.invoke(new ZootopiaDownloadResData(mapId, zootopiaResData.getDownloadStatus(), zootopiaResData.getVersion()));
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public boolean shouldHideSmallHomeEntry() {
        return w84.a.f445029a.e();
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void startBindingSettingActivity(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        BindingPermissionFragment.INSTANCE.a(context, bundle);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void startDemoActivity(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void startDetailActivity(Context context, int mapId, ZootopiaSource source, boolean needDownload, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("mapId", mapId);
        bundle.putBoolean(FavEmoConstant.ROAMING_TYPE_PANEL, needDownload);
        ZootopiaSource a16 = ah.a(source);
        if (a16 != null) {
            source = a16;
        }
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, ((ISchemeApi) QRoute.api(ISchemeApi.class)).buildPageScheme(source, 1, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void startDownloadManagerActivity(Context context, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        ZootopiaActivity.Companion companion = ZootopiaActivity.INSTANCE;
        Bundle bundle = new Bundle();
        bundle.putInt("tab", 1);
        Unit unit = Unit.INSTANCE;
        ZootopiaActivity.Companion.c(companion, context, ZootopiaDownloadManagerFragment.class, source, bundle, false, 16, null);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void startFollowAndFansSettingActivity(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        FollowAndFansPermissionFragment.INSTANCE.a(context, bundle);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void startListActivity(Context context, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        QRouteApi api = QRoute.api(IEntryApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IEntryApi::class.java)");
        IEntryApi.a.c((IEntryApi) api, context, source, null, 4, null);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void startMakeUpActivity(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        if (bundle == null) {
            bundle = new Bundle();
        }
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, ((ISchemeApi) QRoute.api(ISchemeApi.class)).buildMakeUpPageScheme(source, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void startPortalActivity(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        if (bundle == null) {
            bundle = new Bundle();
        }
        ZootopiaStartUpReport.f372678a.b(source, bundle);
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, ((ISchemeApi) QRoute.api(ISchemeApi.class)).buildAvatarScheme(source, 1, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void startProfileCustomerActivity(Context context, ZootopiaSource source, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, ((ISchemeApi) QRoute.api(ISchemeApi.class)).buildAvatarScheme(source, 10, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void startSimpleAvatarFragment(Context context, ZootopiaSource source, int sceneType, Integer subSceneType, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("sceneType", sceneType);
        if (subSceneType != null) {
            bundle.putInt("subSceneType", subSceneType.intValue());
        }
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, ((ISchemeApi) QRoute.api(ISchemeApi.class)).buildAvatarScheme(source, sceneType, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void startSmallHomeByUin(Context context, ZootopiaSource source, String uin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Bundle bundle = new Bundle();
        bundle.putBoolean("openDetailNotReady", true);
        bundle.putBoolean(FavEmoConstant.ROAMING_TYPE_PANEL, true);
        Bundle bundle2 = new Bundle();
        bundle2.putString("SceneType", "3");
        bundle2.putString("VisitUin", uin);
        bundle.putBundle("ueParams", bundle2);
        ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(context, ((ISchemeApi) QRoute.api(ISchemeApi.class)).buildMapScheme(source, AdMetricID.Click.SUCCESS, bundle));
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaApi
    public void startSmallHomePermissionManagerActivity(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intent intent = new Intent();
        intent.putExtras(bundle);
        QPublicFragmentActivity.start(context, intent, SmallHomePermissionManagerFragment.class);
    }
}
