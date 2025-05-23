package com.tencent.mobileqq.zplan.mod.impl;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.WindowManager;
import com.tencent.avbiz.Constants;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams;
import com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchManager;
import com.tencent.mobileqq.zootopia.utils.m;
import com.tencent.mobileqq.zootopia.view.ZootopiaLoadingFragment;
import com.tencent.mobileqq.zootopia.view.z;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.api.ModChekerParams;
import com.tencent.mobileqq.zplan.mod.api.event.ModEnterSuccessEvent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.Foreground;
import mqq.util.WeakReference;
import si3.e;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002JM\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eH\u0002JU\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002JU\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J>\u0010#\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00192\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010\u0012\u001a\u00020\"H\u0016R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/zplan/mod/impl/ModEnterIPCImpl;", "Lsi3/d;", "", "dismissLoadingDialog", "Ljava/util/concurrent/atomic/AtomicBoolean;", "showLoadingDialog", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "", "checkResultCode", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "from", "", "fromSource", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "code", "callback", "handleStartMap", "Landroid/os/Bundle;", "extras", "doServerCheckAndStartEngine", "handleStartEngine", "onStartMapSuccess", "", "isInAudioCall", "setInSmallHome", "isLoadingV2SwitchOn", "modId", "source", "skipRedirect", "", "", "Lsi3/e;", "startMod", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zootopia/view/z;", "loadingDialog", "Lmqq/util/WeakReference;", "Ljava/util/concurrent/atomic/AtomicInteger;", "startEngineCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "Landroid/util/SparseArray;", "Lcom/tencent/zplan/engine/c;", "startEngineListenerPool", "Landroid/util/SparseArray;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ModEnterIPCImpl implements si3.d {
    public static final long DIALOG_SHOW_DELAY = 1000;
    public static final String TAG = "ModEnterIPCImpl";
    private WeakReference<z> loadingDialog;
    private final AtomicInteger startEngineCounter = new AtomicInteger(0);
    private final SparseArray<com.tencent.zplan.engine.c> startEngineListenerPool = new SparseArray<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/mod/impl/ModEnterIPCImpl$b", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "result", "", "c", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZootopiaEnterParams f334731b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZootopiaSource f334732c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f334733d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<Integer, Unit> f334734e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f334735f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f334736g;

        /* JADX WARN: Multi-variable type inference failed */
        b(ZootopiaEnterParams zootopiaEnterParams, ZootopiaSource zootopiaSource, Bundle bundle, Function1<? super Integer, Unit> function1, int i3, String str) {
            this.f334731b = zootopiaEnterParams;
            this.f334732c = zootopiaSource;
            this.f334733d = bundle;
            this.f334734e = function1;
            this.f334735f = i3;
            this.f334736g = str;
        }

        @Override // com.tencent.mobileqq.zplan.authorize.api.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(EnterModCheckResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result.isPassed()) {
                ModEnterIPCImpl.this.handleStartEngine(this.f334731b, this.f334732c, this.f334733d, this.f334734e, this.f334735f, this.f334736g);
                return;
            }
            Function1<Integer, Unit> function1 = this.f334734e;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(result.getResultCode()));
            }
        }

        @Override // com.tencent.mobileqq.zplan.authorize.api.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(EnterModCheckResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i(ModEnterIPCImpl.TAG, 1, "handleStartMap onCheckInterceptor");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/mod/impl/ModEnterIPCImpl$c", "Lcom/tencent/zplan/engine/c;", "", "success", "", "startEngineState", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.zplan.engine.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f334737a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZootopiaEnterParams f334738b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f334739c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ModEnterIPCImpl f334740d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZootopiaSource f334741e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bundle f334742f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function1<Integer, Unit> f334743g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f334744h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f334745i;

        /* JADX WARN: Multi-variable type inference failed */
        c(long j3, ZootopiaEnterParams zootopiaEnterParams, int i3, ModEnterIPCImpl modEnterIPCImpl, ZootopiaSource zootopiaSource, Bundle bundle, Function1<? super Integer, Unit> function1, int i16, String str) {
            this.f334737a = j3;
            this.f334738b = zootopiaEnterParams;
            this.f334739c = i3;
            this.f334740d = modEnterIPCImpl;
            this.f334741e = zootopiaSource;
            this.f334742f = bundle;
            this.f334743g = function1;
            this.f334744h = i16;
            this.f334745i = str;
        }

        @Override // com.tencent.zplan.engine.c
        public void a(boolean success, int startEngineState) {
            long currentTimeMillis = System.currentTimeMillis() - this.f334737a;
            long currentTimeMillis2 = System.currentTimeMillis() - this.f334738b.getStartTime();
            QLog.i(ModEnterIPCImpl.TAG, 1, "doServerCheckAndStartEngine handleStartMap:" + success + ", currentIndex:" + this.f334739c + " cost:" + currentTimeMillis + ", totalCost:" + currentTimeMillis2);
            this.f334740d.startEngineListenerPool.remove(this.f334739c);
            if (success) {
                this.f334740d.onStartMapSuccess(this.f334738b);
                ZootopiaUEActivity.Companion companion = ZootopiaUEActivity.INSTANCE;
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                companion.b(context, this.f334738b, this.f334741e, this.f334742f);
                Function1<Integer, Unit> function1 = this.f334743g;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(this.f334744h));
                }
            } else {
                Function1<Integer, Unit> function12 = this.f334743g;
                if (function12 != null) {
                    function12.invoke(19);
                }
            }
            com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.x(this.f334738b.getMapId(), this.f334745i, String.valueOf(currentTimeMillis), String.valueOf(currentTimeMillis2), success);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissLoadingDialog() {
        QLog.i(TAG, 1, "dismissLoadingDialog dialog = " + this.loadingDialog);
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.mod.impl.ModEnterIPCImpl$dismissLoadingDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WeakReference weakReference;
                z zVar;
                try {
                    weakReference = ModEnterIPCImpl.this.loadingDialog;
                    if (weakReference != null && (zVar = (z) weakReference.get()) != null) {
                        zVar.dismiss();
                    }
                    ZootopiaLoadingFragment.INSTANCE.a();
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleStartMap(ZootopiaEnterParams enterParams, int checkResultCode, ZootopiaSource from, String fromSource, Function1<? super Integer, Unit> callback) {
        if (isInAudioCall()) {
            Map<String, Object> ueParams = enterParams.getUeParams();
            if (ueParams instanceof HashMap) {
                QLog.i(TAG, 1, "handleStartMap set fromScene");
                Map<String, Object> ueParams2 = enterParams.getUeParams();
                Intrinsics.checkNotNull(ueParams2, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
                ((HashMap) ueParams2).put("FromScene", 1);
                setInSmallHome();
            } else if (ueParams == null) {
                enterParams.setUeParams(new HashMap());
                Map<String, Object> ueParams3 = enterParams.getUeParams();
                Intrinsics.checkNotNull(ueParams3, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
                ((HashMap) ueParams3).put("FromScene", 1);
                setInSmallHome();
            }
        }
        Bundle bundle = new Bundle();
        com.tencent.sqshow.zootopia.report.b.INSTANCE.c(bundle);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("zplan_mod_start_up_skip_engine", true);
        QLog.i(TAG, 1, "skipStartEngine:" + isSwitchOn);
        if (isSwitchOn) {
            ZootopiaMapLoadingParams loadingParams = enterParams.getLoadingParams();
            boolean z16 = false;
            if (loadingParams != null && loadingParams.getIsUseNewLoading()) {
                z16 = true;
            }
            if (z16) {
                QLog.i(TAG, 1, "use new loading,start activity");
                ZootopiaUEActivity.Companion companion = ZootopiaUEActivity.INSTANCE;
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                companion.b(context, enterParams, from, bundle);
                if (callback != null) {
                    callback.invoke(Integer.valueOf(checkResultCode));
                    return;
                }
                return;
            }
        }
        if (isLoadingV2SwitchOn()) {
            doServerCheckAndStartEngine(enterParams, from, bundle, callback, checkResultCode, fromSource);
        } else {
            handleStartEngine(enterParams, from, bundle, callback, checkResultCode, fromSource);
        }
    }

    private final boolean isInAudioCall() {
        EIPCResult callClient = QIPCServerHelper.getInstance().getServer().callClient(Constants.Process.VIDEO_PROCESS, 1, "QAVClientQIPCModule", "action_get_is_audio_type", null);
        if ((callClient != null ? callClient.data : null) == null) {
            QLog.i(TAG, 2, "isInAudioCall result is null");
            return false;
        }
        boolean z16 = callClient.data.getBoolean("isAudioType");
        QLog.i(TAG, 2, "isInAudioCall isAudioType:" + z16);
        return z16;
    }

    private final boolean isLoadingV2SwitchOn() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100472", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStartMapSuccess(ZootopiaEnterParams enterParams) {
        SimpleEventBus.getInstance().dispatchEvent(new ModEnterSuccessEvent(enterParams.getMapId()));
    }

    private final AtomicBoolean showLoadingDialog() {
        QLog.i(TAG, 1, "showLoadingDialog");
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        CommonExKt.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.mod.impl.ModEnterIPCImpl$showLoadingDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (atomicBoolean.get()) {
                    Activity topActivity = Foreground.getTopActivity();
                    if (Foreground.isCurrentProcessForeground() && topActivity != null && !topActivity.isFinishing() && !topActivity.isDestroyed()) {
                        QLog.i(ModEnterIPCImpl.TAG, 1, "showLoadingDialog by activity");
                        z zVar = new z(topActivity, true, true);
                        try {
                            zVar.show();
                        } catch (WindowManager.BadTokenException e16) {
                            e16.printStackTrace();
                        }
                        this.loadingDialog = new WeakReference(zVar);
                        return;
                    }
                    ZootopiaLoadingFragment.Companion companion = ZootopiaLoadingFragment.INSTANCE;
                    BaseApplication context = BaseApplication.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                    ZootopiaLoadingFragment.Companion.c(companion, context, false, false, false, 14, null);
                    QLog.i(ModEnterIPCImpl.TAG, 1, "showLoadingDialog by fragment");
                }
            }
        }, 1000L);
        return atomicBoolean;
    }

    private final void doServerCheckAndStartEngine(ZootopiaEnterParams enterParams, ZootopiaSource from, Bundle extras, Function1<? super Integer, Unit> callback, int checkResultCode, String fromSource) {
        QLog.i(TAG, 1, "doServerCheckAndStartEngine");
        ((com.tencent.mobileqq.zplan.authorize.api.c) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.authorize.api.c.class)).n0(enterParams.getMapId(), enterParams, from, new b(enterParams, from, extras, callback, checkResultCode, fromSource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleStartEngine(ZootopiaEnterParams enterParams, ZootopiaSource from, Bundle extras, Function1<? super Integer, Unit> callback, int checkResultCode, String fromSource) {
        QLog.i(TAG, 1, "start engine before start activity!");
        long currentTimeMillis = System.currentTimeMillis();
        int andIncrement = this.startEngineCounter.getAndIncrement();
        QLog.i(TAG, 1, "doServerCheckAndStartEngine begin startEngineWhenNotReady. currentIndex:" + andIncrement);
        c cVar = new c(currentTimeMillis, enterParams, andIncrement, this, from, extras, callback, checkResultCode, fromSource);
        this.startEngineListenerPool.put(andIncrement, cVar);
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).startEngineWhenNotReady(new WeakReference<>(cVar), "zootopia_startMap");
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.w(enterParams.getMapId(), fromSource);
    }

    private final void setInSmallHome() {
        QLog.i(TAG, 2, "setInSmallHome called");
        QIPCServerHelper.getInstance().getServer().callClient(Constants.Process.VIDEO_PROCESS, 1, "QAVClientQIPCModule", "action_set_in_small_home", null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28, types: [T, java.lang.String] */
    @Override // si3.d
    public void startMod(final int modId, final ZootopiaSource source, boolean skipRedirect, Map<String, ? extends Object> extras, final e callback) {
        Object obj;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i(TAG, 1, "startMod modId = " + modId);
        final AtomicBoolean showLoadingDialog = showLoadingDialog();
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = System.currentTimeMillis();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "0";
        if (extras != null && (obj = extras.get(IPublicAccountImageCollectionMainActivity.CLICK_SOURCE)) != null) {
            objectRef.element = obj.toString();
        }
        Object obj2 = extras != null ? extras.get("need_relaunch_by_scheme") : null;
        boolean booleanValue = obj2 instanceof Boolean ? ((Boolean) obj2).booleanValue() : false;
        com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> aVar = new com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult>() { // from class: com.tencent.mobileqq.zplan.mod.impl.ModEnterIPCImpl$startMod$checkCallback$1
            @Override // com.tencent.mobileqq.zplan.authorize.api.a
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public void b(final EnterModCheckResult result) {
                String str;
                Intrinsics.checkNotNullParameter(result, "result");
                QLog.i(ModEnterIPCImpl.TAG, 1, "startMod onCheckComplete result.code = " + result.getResultCode() + " check cost:" + (System.currentTimeMillis() - Ref.LongRef.this.element));
                Ref.LongRef.this.element = System.currentTimeMillis();
                if (result.isPassed()) {
                    qk3.a aVar2 = (qk3.a) i.INSTANCE.a(qk3.a.class);
                    int i3 = modId;
                    ZootopiaEnterParams enterParamsAfterCheck = result.getEnterParamsAfterCheck();
                    if (enterParamsAfterCheck == null || (str = enterParamsAfterCheck.getName()) == null) {
                        str = "";
                    }
                    aVar2.onModStart(i3, str, objectRef.element);
                    ZootopiaEnterParams enterParamsAfterCheck2 = result.getEnterParamsAfterCheck();
                    Intrinsics.checkNotNull(enterParamsAfterCheck2);
                    ModEnterIPCImpl modEnterIPCImpl = this;
                    int resultCode = result.getResultCode();
                    ZootopiaSource zootopiaSource = source;
                    String str2 = objectRef.element;
                    final ModEnterIPCImpl modEnterIPCImpl2 = this;
                    final AtomicBoolean atomicBoolean = showLoadingDialog;
                    final Ref.LongRef longRef2 = Ref.LongRef.this;
                    final int i16 = modId;
                    final e eVar = callback;
                    modEnterIPCImpl.handleStartMap(enterParamsAfterCheck2, resultCode, zootopiaSource, str2, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.mod.impl.ModEnterIPCImpl$startMod$checkCallback$1$onCheckComplete$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i17) {
                            ModEnterIPCImpl.this.dismissLoadingDialog();
                            atomicBoolean.set(false);
                            QLog.i(ModEnterIPCImpl.TAG, 1, "startMod handleStartMap engineAndServerCheckCode = " + i17 + " engine cost:" + (System.currentTimeMillis() - longRef2.element));
                            ((com.tencent.mobileqq.zplan.authorize.impl.helper.e) i.INSTANCE.a(com.tencent.mobileqq.zplan.authorize.impl.helper.e.class)).clearScheme(i16);
                            result.setResultCode(i17);
                            eVar.a(result);
                        }
                    });
                    return;
                }
                showLoadingDialog.set(false);
                this.dismissLoadingDialog();
                callback.a(result);
            }

            @Override // com.tencent.mobileqq.zplan.authorize.api.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void a(EnterModCheckResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                QLog.i(ModEnterIPCImpl.TAG, 1, "startMod onCheckInterceptor result.code = " + result.getResultCode() + " check cost:" + (System.currentTimeMillis() - Ref.LongRef.this.element));
                showLoadingDialog.set(false);
                this.dismissLoadingDialog();
            }
        };
        if (isLoadingV2SwitchOn()) {
            ((com.tencent.mobileqq.zplan.authorize.api.c) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.authorize.api.c.class)).D(modId, new ModChekerParams(source, (String) objectRef.element, skipRedirect, booleanValue, extras), aVar);
        } else {
            ((com.tencent.mobileqq.zplan.authorize.api.c) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.authorize.api.c.class)).U(modId, new ModChekerParams(source, (String) objectRef.element, skipRedirect, booleanValue, extras), aVar);
        }
        if (m.f329564a.a() == 1) {
            ZPlanModHotPatchManager.v(ZPlanModHotPatchManager.f328077a, "ModEnterIPCImpl#startMod", String.valueOf(modId), null, false, false, 28, null);
        } else {
            QLog.i(TAG, 1, "ModEnterIPCImpl#startMod not wifi");
        }
    }
}
