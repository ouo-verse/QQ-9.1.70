package com.tencent.mobileqq.minigame.va.downloadui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.minibox.business.api.AsyncCallback;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.api.IMiniGameVAService;
import com.tencent.mobileqq.minigame.config.MiniGameCustomLoadingConfig;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.ui.loading.MiniGameCustomLoadingView;
import com.tencent.mobileqq.minigame.va.DownloadScene;
import com.tencent.mobileqq.minigame.va.IMiniGameVA;
import com.tencent.mobileqq.minigame.va.MiniGameVALaunchCache;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import fs3.MiniBoxInfo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 >2\u00020\u0001:\u0002>?B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u0018H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\bH\u0016J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010.\u001a\u00020\u0015H\u0016J\u0010\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020\u0015H\u0016J\b\u00103\u001a\u00020\u0015H\u0016J\u0010\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\bH\u0016J\b\u00106\u001a\u00020\u0015H\u0002J \u00107\u001a\u00020\u00152\u0006\u00108\u001a\u0002012\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\rH\u0002J\u0012\u0010;\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010<\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010=\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/downloadui/VAInstallAppLoadingFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "finishReceiver", "Lcom/tencent/mobileqq/minigame/va/downloadui/VAInstallAppLoadingFragment$LoadingFinishReceiver;", "finishRunnable", "Ljava/lang/Runnable;", "isLaunched", "", "isPauseInvoked", "loadingView", "Lcom/tencent/mobileqq/minigame/ui/loading/MiniGameCustomLoadingView;", "progress", "", "progressChangeRunnable", "showInstallTips", "uiHandler", "Landroid/os/Handler;", "vaStartData", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVAStartData;", "checkIfNeedStopBeforeStart", "", "data", "callback", "Lkotlin/Function1;", "", "getCallback", "Landroid/os/ResultReceiver;", "initWindowStyleAndAnimation", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "launchVA", "startData", "needStatusTrans", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onFail", "errorMsg", "", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "onWindowFocusChanged", "hasFocus", "postProgressChange", "reportLaunch", "gameAppId", "isSuccess", "errorCode", "setActivityFullScreen", "startVAApp", "updateProgressFinish", "Companion", "LoadingFinishReceiver", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class VAInstallAppLoadingFragment extends QPublicBaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long DELAY_FINISH_TIMEOUT = 15000;
    private static final String KEY_CALLBACK = "va_start_callback";
    private static final String KEY_DATA = "va_start_data";
    private static final long LAUNCH_DELAY = 100;
    private static final String RECEIVER_ACTION = "com.tencent.minibox.loading.finish";
    private static final String TAG = "MiniGameVALoading";
    private boolean isLaunched;
    private boolean isPauseInvoked;
    private MiniGameCustomLoadingView loadingView;
    private int progress;
    private boolean showInstallTips;
    private MiniGameVAStartData vaStartData;
    private final LoadingFinishReceiver finishReceiver = new LoadingFinishReceiver(this);
    private final Handler uiHandler = new Handler(Looper.getMainLooper());
    private final Runnable progressChangeRunnable = new Runnable() { // from class: com.tencent.mobileqq.minigame.va.downloadui.s
        @Override // java.lang.Runnable
        public final void run() {
            VAInstallAppLoadingFragment.progressChangeRunnable$lambda$0(VAInstallAppLoadingFragment.this);
        }
    };
    private final Runnable finishRunnable = new Runnable() { // from class: com.tencent.mobileqq.minigame.va.downloadui.t
        @Override // java.lang.Runnable
        public final void run() {
            VAInstallAppLoadingFragment.finishRunnable$lambda$7(VAInstallAppLoadingFragment.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/downloadui/VAInstallAppLoadingFragment$Companion;", "", "()V", "DELAY_FINISH_TIMEOUT", "", "KEY_CALLBACK", "", "KEY_DATA", "LAUNCH_DELAY", "RECEIVER_ACTION", "TAG", "startVA", "", "context", "Landroid/content/Context;", "startData", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVAStartData;", "callback", "Landroid/os/ResultReceiver;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startVA(Context context, MiniGameVAStartData startData, ResultReceiver callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(startData, "startData");
            Intent intent = new Intent();
            intent.putExtra(VAInstallAppLoadingFragment.KEY_DATA, startData);
            intent.putExtra(VAInstallAppLoadingFragment.KEY_CALLBACK, callback);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("public_fragment_window_feature", 1);
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, VAInstallAppLoadingFragment.class);
            MiniGameVALaunchCache.INSTANCE.onMiniGameVALaunch(startData);
        }

        Companion() {
        }

        public static /* synthetic */ void startVA$default(Companion companion, Context context, MiniGameVAStartData miniGameVAStartData, ResultReceiver resultReceiver, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                resultReceiver = null;
            }
            companion.startVA(context, miniGameVAStartData, resultReceiver);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/downloadui/VAInstallAppLoadingFragment$LoadingFinishReceiver;", "Landroid/content/BroadcastReceiver;", "fragment", "Lcom/tencent/mobileqq/minigame/va/downloadui/VAInstallAppLoadingFragment;", "(Lcom/tencent/mobileqq/minigame/va/downloadui/VAInstallAppLoadingFragment;)V", "fragmentRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class LoadingFinishReceiver extends BroadcastReceiver {
        private final WeakReference<VAInstallAppLoadingFragment> fragmentRef;

        public LoadingFinishReceiver(VAInstallAppLoadingFragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.fragmentRef = new WeakReference<>(fragment);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VAInstallAppLoadingFragment vAInstallAppLoadingFragment = this.fragmentRef.get();
            if (vAInstallAppLoadingFragment != null) {
                vAInstallAppLoadingFragment.updateProgressFinish();
                FragmentActivity activity = vAInstallAppLoadingFragment.getActivity();
                if (activity != null) {
                    activity.finish();
                }
                QLog.i(VAInstallAppLoadingFragment.TAG, 1, "receive finish event.");
            }
        }
    }

    private final void checkIfNeedStopBeforeStart(MiniGameVAStartData data, final Function1<? super Long, Unit> callback) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (MiniGameVAUtil.needStopBackgroundGame(data.getDataWrapper().getLaunchScene(), data.getDataWrapper().getData().getGameId())) {
            MiniBoxSDK.stopApp(data.getDataWrapper().getData().getPkgName(), new AsyncCallback() { // from class: com.tencent.mobileqq.minigame.va.downloadui.p
                @Override // com.tencent.minibox.business.api.AsyncCallback
                public final void onResult(Object obj) {
                    VAInstallAppLoadingFragment.checkIfNeedStopBeforeStart$lambda$3(Function1.this, currentTimeMillis, (String) obj);
                }
            });
        } else {
            callback.invoke(Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIfNeedStopBeforeStart$lambda$3(Function1 callback, long j3, String str) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.i(TAG, 1, "checkIfNeedStopBeforeStart: stopApp msg=" + str);
        callback.invoke(Long.valueOf(System.currentTimeMillis() - j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void finishRunnable$lambda$7(VAInstallAppLoadingFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(TAG, 1, "delay finishRunnable");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResultReceiver getCallback() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return (ResultReceiver) arguments.getParcelable(KEY_CALLBACK);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFail(final String errorMsg) {
        this.uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.downloadui.r
            @Override // java.lang.Runnable
            public final void run() {
                VAInstallAppLoadingFragment.onFail$lambda$5(VAInstallAppLoadingFragment.this, errorMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFail$lambda$5(VAInstallAppLoadingFragment this$0, String errorMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
        ResultReceiver callback = this$0.getCallback();
        if (callback != null) {
            Bundle bundle = new Bundle();
            bundle.putString("errorMessage", errorMsg);
            Unit unit = Unit.INSTANCE;
            callback.send(-1, bundle);
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$2(VAInstallAppLoadingFragment this$0, MiniGameVAStartData data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.checkIfNeedStopBeforeStart(data, new VAInstallAppLoadingFragment$onResume$1$1(this$0, data));
    }

    private final void postProgressChange() {
        this.uiHandler.removeCallbacks(this.progressChangeRunnable);
        if (this.progress < 99) {
            this.uiHandler.postDelayed(this.progressChangeRunnable, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void progressChangeRunnable$lambda$0(VAInstallAppLoadingFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = this$0.progress + 1;
        this$0.progress = i3;
        int min = Math.min(99, i3);
        this$0.progress = min;
        MiniGameCustomLoadingView miniGameCustomLoadingView = this$0.loadingView;
        if (miniGameCustomLoadingView != null) {
            miniGameCustomLoadingView.onLoadProgressChange(min, this$0.showInstallTips);
        }
        this$0.postProgressChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportLaunch(String gameAppId, boolean isSuccess, int errorCode) {
        String str = "1";
        WadlReportBuilder ext = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setGameAppId(gameAppId).setOperModule("9080").setOperId("989332").setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).setExt(11, "1");
        if (!isSuccess) {
            str = "2";
        }
        ext.setExt(7, str).setExt(4, "18").setExt(1, "908015").setExt(8, String.valueOf(errorCode)).report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startVAApp(final MiniGameVAStartData data) {
        QLog.i(TAG, 1, "startVAApp: needInstall=" + data.getNeedInstall());
        IMiniBoxLauncher iMiniBoxLauncher = (IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        iMiniBoxLauncher.init(context);
        if (!data.getNeedInstall()) {
            launchVA(data);
            return;
        }
        this.showInstallTips = true;
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMiniGameVAService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        IMiniGameVAService iMiniGameVAService = (IMiniGameVAService) runtimeService;
        final long currentTimeMillis = System.currentTimeMillis();
        data.getDataWrapper().setScene(DownloadScene.SCENE_INSTALL_IN_LOADING.getScene());
        IMiniGameVA.DefaultImpls.installVA$default(iMiniGameVAService, data.getDataWrapper(), new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.minigame.va.downloadui.VAInstallAppLoadingFragment$startVAApp$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public void invoke(boolean isSuccess, String errMsg) {
                HashMap hashMap = new HashMap();
                hashMap.put("ext8", isSuccess ? "0" : "1");
                hashMap.put("ext46", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "929235", "8", data.getConfig().getGameAppId(), hashMap);
                if (isSuccess) {
                    this.updateProgressFinish();
                    this.launchVA(data);
                    return;
                }
                QLog.e("MiniGameVALoading", 1, "install VA app failed, msg=" + errMsg);
                VAInstallAppLoadingFragment vAInstallAppLoadingFragment = this;
                if (errMsg == null) {
                    errMsg = "install VA App failed.";
                }
                vAInstallAppLoadingFragment.onFail(errMsg);
            }
        }, false, 4, null);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        setActivityFullScreen(activity);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        MiniGameCustomLoadingView miniGameCustomLoadingView;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation != 2 || (miniGameCustomLoadingView = this.loadingView) == null) {
            return;
        }
        miniGameCustomLoadingView.onScreenLandScape();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.registerReceiver(this.finishReceiver, new IntentFilter(RECEIVER_ACTION));
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String str;
        MiniGameVAInterceptConfig.VAInterceptConfig config;
        Map<String, MiniGameCustomLoadingConfig.LoadingBgConfig> bgConfigMap;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        MiniGameVAStartData miniGameVAStartData = arguments != null ? (MiniGameVAStartData) arguments.getParcelable(KEY_DATA) : null;
        if (miniGameVAStartData == null) {
            QLog.e(TAG, 1, "onCreateView: start data is null.");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            return null;
        }
        this.vaStartData = miniGameVAStartData;
        MiniGameCustomLoadingConfig miniGameCustomLoadingConfig = (MiniGameCustomLoadingConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameCustomLoadingConfig.CONFIG_ID);
        MiniGameCustomLoadingConfig.LoadingBgConfig loadingBgConfig = (miniGameCustomLoadingConfig == null || (bgConfigMap = miniGameCustomLoadingConfig.getBgConfigMap()) == null) ? null : bgConfigMap.get(miniGameVAStartData.getConfig().getMiniGameId());
        MiniGameVAStartData miniGameVAStartData2 = this.vaStartData;
        if (miniGameVAStartData2 == null || (config = miniGameVAStartData2.getConfig()) == null || (str = config.getGameAppId()) == null) {
            str = "";
        }
        MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989322", "8", str, null);
        if (loadingBgConfig != null) {
            this.loadingView = new MiniGameCustomLoadingView(getContext(), loadingBgConfig.getLoadingBgImgUrl(), loadingBgConfig.getLandscapeLoadingBgImgUrl(), true).setLaunchSource(1).setGameAppId(str);
            this.uiHandler.post(this.progressChangeRunnable);
            return this.loadingView;
        }
        QLog.w(TAG, 1, "onCreateView: use default loading view.");
        return null;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i(TAG, 1, "onDestroy call.");
        try {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.unregisterReceiver(this.finishReceiver);
            }
        } catch (Exception unused) {
        }
        getMainHandler().removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPauseInvoked = true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.isLaunched) {
            if (this.isPauseInvoked) {
                QLog.i(TAG, 1, "onResume twice finish!");
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            return;
        }
        final MiniGameVAStartData miniGameVAStartData = this.vaStartData;
        if (miniGameVAStartData == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.downloadui.q
            @Override // java.lang.Runnable
            public final void run() {
                VAInstallAppLoadingFragment.onResume$lambda$2(VAInstallAppLoadingFragment.this, miniGameVAStartData);
            }
        }, 64, null, false);
        this.isLaunched = true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        setActivityFullScreen(getActivity());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0072, code lost:
    
        r4 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void launchVA(MiniGameVAStartData startData) {
        Intent intent;
        Integer intOrNull;
        String pkgName = startData.getDataWrapper().getData().getPkgName();
        int i3 = 0;
        if (pkgName == null || pkgName.length() == 0) {
            QLog.e(TAG, 1, "launchVA: pkgName is null.");
            onFail("packageName is null.");
            return;
        }
        QLog.i(TAG, 1, "launchVA preload loginInfo pkgName:" + pkgName + ", scene=" + startData.getDataWrapper().getLaunchScene());
        String uriData = startData.getUriData();
        String pkgName2 = startData.getDataWrapper().getData().getPkgName();
        String versionCode = startData.getDataWrapper().getData().getVersionCode();
        if (versionCode != null && intOrNull != null) {
            i3 = intOrNull.intValue();
        }
        int i16 = i3;
        boolean isLandscape = startData.getConfig().isLandscape();
        if (uriData == null) {
            intent = null;
        } else {
            Intent intent2 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent2.setPackage(startData.getDataWrapper().getData().getPkgName());
            intent2.setData(Uri.parse(uriData));
            intent = intent2;
        }
        ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).launchVirtualApp(startData.getConfig().getMiniGameId(), new MiniBoxInfo(null, pkgName2, i16, null, null, null, true, isLandscape, Intrinsics.areEqual("com.tencent.letsgo", pkgName) ? ((IMetaDreamServiceApi) QRoute.api(IMetaDreamServiceApi.class)).getLaunchExtendBundle() : null, intent, startData.getDataWrapper().getLaunchScene(), startData.getDataWrapper().getLaunchVia(), 57, null), new VAInstallAppLoadingFragment$launchVA$launchCallback$1(pkgName, this, startData));
    }

    private final void setActivityFullScreen(Activity activity) {
        Window window;
        Window window2;
        Window window3;
        Window window4;
        Window window5;
        View decorView;
        Window window6;
        if (activity != null && (window6 = activity.getWindow()) != null) {
            window6.setFlags(1024, 1024);
        }
        int i3 = Build.VERSION.SDK_INT;
        if (activity != null && (window5 = activity.getWindow()) != null && (decorView = window5.getDecorView()) != null) {
            decorView.setSystemUiVisibility(7942);
        }
        if (activity != null && (window4 = activity.getWindow()) != null) {
            window4.addFlags(67108864);
        }
        if (activity != null && (window3 = activity.getWindow()) != null) {
            window3.addFlags(134218752);
        }
        if (i3 >= 28) {
            WindowManager.LayoutParams attributes = (activity == null || (window2 = activity.getWindow()) == null) ? null : window2.getAttributes();
            if (attributes != null) {
                attributes.layoutInDisplayCutoutMode = 3;
                if (activity == null || (window = activity.getWindow()) == null) {
                    return;
                }
                window.setAttributes(attributes);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateProgressFinish() {
        this.progress = 99;
        this.uiHandler.post(this.progressChangeRunnable);
    }
}
