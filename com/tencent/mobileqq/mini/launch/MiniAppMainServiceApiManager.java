package com.tencent.mobileqq.mini.launch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.launch.IMiniAppMainServiceApi;
import com.tencent.mobileqq.mini.launch.MiniAppMainServiceApiManager;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.util.g;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import eipc.EIPCResult;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001$B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\n\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J$\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\"\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"J&\u0010#\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/mini/launch/MiniAppMainServiceApiManager;", "", "()V", "KEY_SERVICE_API_BINDER", "", "TAG", "mIsMainProcess", "", "mRemoteServiceApi", "Lcom/tencent/mobileqq/mini/launch/IMiniAppMainServiceApi;", "mServiceApiImpl", "getMServiceApiImpl", "()Lcom/tencent/mobileqq/mini/launch/IMiniAppMainServiceApi;", "mServiceApiImpl$delegate", "Lkotlin/Lazy;", "buildServiceApiEIPCResult", "Leipc/EIPCResult;", "fetchServiceApi", "getApi", "preloadMiniApp", "", "preloadMiniAppLibs", "sendCmd", "cmd", "bundle", "Landroid/os/Bundle;", "callback", "Lcom/tencent/mobileqq/mini/launch/CmdCallback;", "startMiniApp", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "appConfig", "Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;", "resultReceiver", "Landroid/os/ResultReceiver;", "startMiniAppAtOtherProcess", "MiniAppMainServiceApiImpl", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppMainServiceApiManager {
    public static final MiniAppMainServiceApiManager INSTANCE = new MiniAppMainServiceApiManager();
    private static final String KEY_SERVICE_API_BINDER = "service_api_binder";
    private static final String TAG = "MiniAppServiceApiManager";
    private static final boolean mIsMainProcess;
    private static IMiniAppMainServiceApi mRemoteServiceApi;

    /* renamed from: mServiceApiImpl$delegate, reason: from kotlin metadata */
    private static final Lazy mServiceApiImpl;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J$\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/mini/launch/MiniAppMainServiceApiManager$MiniAppMainServiceApiImpl;", "Lcom/tencent/mobileqq/mini/launch/IMiniAppMainServiceApi$Stub;", "()V", "preloadMiniApp", "", "preloadMiniAppLibs", "sendCmd", "cmd", "", "bundle", "Landroid/os/Bundle;", "callback", "Lcom/tencent/mobileqq/mini/launch/CmdCallback;", "startMiniApp", "appConfig", "Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;", "resultReceiver", "Landroid/os/ResultReceiver;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class MiniAppMainServiceApiImpl extends IMiniAppMainServiceApi.Stub {
        @Override // com.tencent.mobileqq.mini.launch.IMiniAppMainServiceApi
        public void preloadMiniApp() {
            AppBrandLaunchManager.g().preloadMiniApp();
        }

        @Override // com.tencent.mobileqq.mini.launch.IMiniAppMainServiceApi
        public void preloadMiniAppLibs() {
            AppBrandLaunchManager.g().updateBaseLib();
        }

        @Override // com.tencent.mobileqq.mini.launch.IMiniAppMainServiceApi
        public void sendCmd(String cmd, Bundle bundle, CmdCallback callback) {
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            AppBrandLaunchManager.g().sendCmd(cmd, bundle, callback);
        }

        @Override // com.tencent.mobileqq.mini.launch.IMiniAppMainServiceApi
        public void startMiniApp(MiniAppConfig appConfig, ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(appConfig, "appConfig");
            AppBrandLaunchManager.g().startMiniApp(null, appConfig, resultReceiver);
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniAppMainServiceApiImpl>() { // from class: com.tencent.mobileqq.mini.launch.MiniAppMainServiceApiManager$mServiceApiImpl$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniAppMainServiceApiManager.MiniAppMainServiceApiImpl invoke() {
                return new MiniAppMainServiceApiManager.MiniAppMainServiceApiImpl();
            }
        });
        mServiceApiImpl = lazy;
        mIsMainProcess = g.b();
    }

    MiniAppMainServiceApiManager() {
    }

    private final IMiniAppMainServiceApi fetchServiceApi() {
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_GET_MAIN_SERVICE_API, new Bundle());
        if (callServer != null) {
            try {
                IMiniAppMainServiceApi asInterface = IMiniAppMainServiceApi.Stub.asInterface(callServer.data.getBinder(KEY_SERVICE_API_BINDER));
                Intrinsics.checkNotNull(asInterface);
                return asInterface;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "fetchServiceApi failed --->", e16);
            }
        }
        QLog.e(TAG, 1, "fetchServiceApi but get null");
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x001e, code lost:
    
        if (r2 == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final IMiniAppMainServiceApi getApi() {
        IMiniAppMainServiceApi iMiniAppMainServiceApi;
        IBinder asBinder;
        if (mIsMainProcess) {
            iMiniAppMainServiceApi = getMServiceApiImpl();
        } else {
            IMiniAppMainServiceApi iMiniAppMainServiceApi2 = mRemoteServiceApi;
            if (iMiniAppMainServiceApi2 != null) {
                boolean z16 = false;
                if (iMiniAppMainServiceApi2 != null && (asBinder = iMiniAppMainServiceApi2.asBinder()) != null && asBinder.isBinderAlive()) {
                    z16 = true;
                }
            }
            mRemoteServiceApi = fetchServiceApi();
            iMiniAppMainServiceApi = mRemoteServiceApi;
        }
        if (iMiniAppMainServiceApi == null) {
            QLog.e(TAG, 1, "getApi return null, proc = " + g.a());
        }
        return iMiniAppMainServiceApi;
    }

    private final IMiniAppMainServiceApi getMServiceApiImpl() {
        return (IMiniAppMainServiceApi) mServiceApiImpl.getValue();
    }

    private final void startMiniAppAtOtherProcess(final Activity activity, MiniAppConfig appConfig, final ResultReceiver resultReceiver) {
        try {
            IMiniAppMainServiceApi api = getApi();
            if (api != null) {
                final Handler handler = new Handler(Looper.getMainLooper());
                api.startMiniApp(appConfig, new ResultReceiver(handler) { // from class: com.tencent.mobileqq.mini.launch.MiniAppMainServiceApiManager$startMiniAppAtOtherProcess$1
                    @Override // android.os.ResultReceiver
                    protected void onReceiveResult(int code, Bundle bundle) {
                        Intrinsics.checkNotNullParameter(bundle, "bundle");
                        super.onReceiveResult(code, bundle);
                        if (code != 1) {
                            return;
                        }
                        bundle.setClassLoader(MiniAppMainServiceApiManager$startMiniAppAtOtherProcess$1.class.getClassLoader());
                        try {
                            Intent intent = (Intent) bundle.getParcelable(IPCConst.KEY_LAUNCH_ACTIVITY_INTENT);
                            if (intent == null) {
                                QLog.e("MiniAppServiceApiManager", 1, "startMiniApp failed, intent = null");
                                return;
                            }
                            intent.setExtrasClassLoader(MiniAppMainServiceApiManager$startMiniAppAtOtherProcess$1.class.getClassLoader());
                            intent.putExtra("receiver", resultReceiver);
                            Activity activity2 = activity;
                            if (activity2 != null) {
                                activity2.startActivity(intent);
                                return;
                            }
                            BaseApplicationImpl application = BaseApplicationImpl.getApplication();
                            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type android.content.Context");
                            application.startActivity(intent);
                        } catch (Exception e16) {
                            QLog.e("MiniAppServiceApiManager", 1, "startMiniApp exception in cb --->", e16);
                        }
                    }
                });
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "startMiniApp exception --->", e16);
        }
    }

    public final EIPCResult buildServiceApiEIPCResult() {
        if (!mIsMainProcess) {
            QLog.e(TAG, 1, "should be called at main process");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBinder(KEY_SERVICE_API_BINDER, INSTANCE.getMServiceApiImpl().asBinder());
        return EIPCResult.createSuccessResult(bundle);
    }

    public final void preloadMiniApp() {
        try {
            IMiniAppMainServiceApi api = getApi();
            if (api != null) {
                api.preloadMiniApp();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "preloadMiniApp exception happened --->", e16);
        }
    }

    public final void preloadMiniAppLibs() {
        try {
            IMiniAppMainServiceApi api = getApi();
            if (api != null) {
                api.preloadMiniAppLibs();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "preloadMiniAppLibs exception happened --->", e16);
        }
    }

    @Deprecated(message = "sendCmd \u65b9\u5f0f\u4e0d\u5efa\u8bae\u7ee7\u7eed\u4f7f\u7528\uff0c\u6bcf\u4e2a\u63a5\u53e3\u90fd\u5e94\u8be5\u5355\u72ec\u58f0\u660e")
    public final void sendCmd(String cmd, Bundle bundle, CmdCallback callback) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        try {
            IMiniAppMainServiceApi api = getApi();
            if (api != null) {
                api.sendCmd(cmd, bundle, callback);
                return;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "sendCmd exception happened --->", e16);
        }
        if (callback != null) {
            callback.onCmdResult(false, new Bundle());
        }
    }

    public final void startMiniApp(Activity activity, MiniAppConfig appConfig, ResultReceiver resultReceiver) {
        Intrinsics.checkNotNullParameter(appConfig, "appConfig");
        if (mIsMainProcess) {
            AppBrandLaunchManager.g().startMiniApp(activity, appConfig, resultReceiver);
        } else {
            startMiniAppAtOtherProcess(activity, appConfig, resultReceiver);
        }
    }
}
