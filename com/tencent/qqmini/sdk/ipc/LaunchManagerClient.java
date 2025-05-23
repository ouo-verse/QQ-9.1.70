package com.tencent.qqmini.sdk.ipc;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.ipc.ProcessDeathNotifier;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareData;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.IServiceEvent;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import com.tencent.qqmini.sdk.launcher.utils.ProcessUtil;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.server.AppMainService;
import com.tencent.qqmini.sdk.utils.MiniLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LaunchManagerClient {
    public static final long SERVICE_BIND_TIMEOUT = 10000;
    private static final String TAG = "minisdk-start_AppBrandProxy";
    private static byte[] lock = new byte[0];
    private IServiceEvent initListener;
    private MiniAppInfo mAppConfig;
    private Messenger mClientMessenger;
    private Context mContext;
    private int mMiniAppStatus;
    private ILaunchManager mService;
    private Bundle mStartBundle;
    private boolean isConnecting = false;
    private long mBindServiceTime = 0;
    private boolean mNeedSyncStatus = false;
    private List<Runnable> mTaskAfterConnected = new ArrayList();
    private Handler.Callback mMessengerCallback = new Handler.Callback() { // from class: com.tencent.qqmini.sdk.ipc.LaunchManagerClient.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            message.getData().setClassLoader(LaunchManagerClient.this.mContext.getClassLoader());
            LaunchManagerClient.this.handleCmdFromMainProcess(i3, message.getData(), (MiniAppInfo) message.getData().getParcelable(IPCConst.KEY_APPINFO), (ResultReceiver) message.getData().getParcelable("receiver"));
            return false;
        }
    };
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.tencent.qqmini.sdk.ipc.LaunchManagerClient.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LaunchManagerClient.this.mService = ILaunchManager.Stub.asInterface(iBinder);
            QMLog.w(LaunchManagerClient.TAG, "onServiceConnected:" + LaunchManagerClient.this.mService);
            LaunchManagerClient.this.isConnecting = false;
            LaunchManagerClient.this.mBindServiceTime = 0L;
            LaunchManagerClient.this.doAfterServiceConnected();
            LaunchManagerClient.this.notifyToService();
            if (LaunchManagerClient.this.initListener != null) {
                LaunchManagerClient.this.initListener.onEvent(0);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LaunchManagerClient.this.mService = null;
            QMLog.w(LaunchManagerClient.TAG, "onServiceDisconnected.");
            LaunchManagerClient.this.isConnecting = false;
            LaunchManagerClient.this.mBindServiceTime = 0L;
            if (LaunchManagerClient.this.initListener != null) {
                LaunchManagerClient.this.initListener.onEvent(-1);
            }
        }
    };

    public LaunchManagerClient(Context context, IServiceEvent iServiceEvent) {
        this.initListener = null;
        this.mContext = context;
        this.initListener = iServiceEvent;
        if (!isMainProcess()) {
            this.mClientMessenger = new Messenger(new Handler(Looper.getMainLooper(), this.mMessengerCallback));
        }
        ensureService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAfterServiceConnected() {
        try {
            ArrayList arrayList = new ArrayList(this.mTaskAfterConnected);
            this.mTaskAfterConnected.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Runnable runnable = (Runnable) it.next();
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "doAfterServiceConnected exception!", th5);
        }
    }

    private synchronized boolean ensureService() {
        if (isMainProcess()) {
            IServiceEvent iServiceEvent = this.initListener;
            if (iServiceEvent != null) {
                iServiceEvent.onEvent(0);
            }
            return false;
        }
        if (this.mService != null) {
            return true;
        }
        if (this.isConnecting && System.currentTimeMillis() - this.mBindServiceTime < 10000) {
            return false;
        }
        if (this.mService == null) {
            QMLog.w(TAG, "mService is null! Begin Bind Service!");
            Intent intent = new Intent(this.mContext, (Class<?>) AppMainService.class);
            intent.setType(ProcessUtil.getSimpleProcessName());
            intent.putExtra("mini_process_name", AppLoaderFactory.g().getCurrentProcessName());
            intent.putExtra(IPCConst.BUNDLE_KEY_MESSENGER, this.mClientMessenger);
            this.mBindServiceTime = System.currentTimeMillis();
            this.isConnecting = true;
            try {
                this.mContext.bindService(intent, this.mConnection, 1);
            } catch (Throwable th5) {
                QMLog.w(TAG, "exception when bind lbs service!!!", th5);
            }
        }
        return false;
    }

    private static BaseRuntime getBaseRuntime(MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) {
        BaseRuntimeLoader queryAppRunTimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(miniAppInfo);
        if (queryAppRunTimeLoader == null) {
            QMLog.w(TAG, "handleCmdFromMainProcess. Ignore, runtime loader is null");
            sendResult(resultReceiver, -1, bundle);
            return null;
        }
        BaseRuntime runtime = queryAppRunTimeLoader.getRuntime();
        if (runtime == null) {
            QMLog.w(TAG, "handleCmdFromMainProcess. Ignore, runtime is null");
            sendResult(resultReceiver, -1, bundle);
            return null;
        }
        return runtime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCmdFromMainProcess(int i3, Bundle bundle, MiniAppInfo miniAppInfo, ResultReceiver resultReceiver) {
        QMLog.i(TAG, "Messenger handleCmdFromMainProcess cmd=" + i3);
        switch (i3) {
            case 1001:
                if (bundle == null) {
                    QMLog.w(TAG, "handleCmdFromMainProcess. Ignore MESSENGER_CMD_NOTIFY_SHARE_RESULT. bundle is null");
                    sendResult(resultReceiver, -1, bundle);
                    return;
                } else {
                    notifyShareResult(miniAppInfo, bundle, resultReceiver);
                    return;
                }
            case 1002:
                if (bundle == null) {
                    QMLog.w(TAG, "handleCmdFromMainProcess. Ignore MESSENGER_CMD_NOTIFY_PERIODIC_CACHE_UPDATE. bundle is null");
                    sendResult(resultReceiver, -1, bundle);
                    return;
                } else {
                    notifyPeriodicCacheUpdate(miniAppInfo, bundle, resultReceiver);
                    return;
                }
            case 1003:
                VirtualAppProxy virtualAppProxy = (VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class);
                if (virtualAppProxy != null) {
                    virtualAppProxy.notifyDownloadChange(bundle.getString(VirtualAppProxy.KEY_GAME_ID), bundle.getInt(VirtualAppProxy.KEY_DOWNLOAD_STATUS), bundle.getInt("progress"), bundle.getLong("downloadSize"), bundle.getLong(VirtualAppProxy.KEY_PKG_SIZE), "");
                    if (QMLog.isColorLevel()) {
                        QMLog.d(TAG, "handleCmdFromMainProcess. MESSENGER_CMD_NOTIFY_VA_DOWNLOAD_UPDATE");
                        return;
                    }
                    return;
                }
                return;
            case 1004:
                VirtualAppProxy virtualAppProxy2 = (VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class);
                if (virtualAppProxy2 != null && bundle != null) {
                    virtualAppProxy2.notifyHotfixDownloadChange(bundle.getString(VirtualAppProxy.KEY_GAME_ID), bundle.getInt(VirtualAppProxy.KEY_DOWNLOAD_STATUS, 0), bundle.getInt("progress", -1), bundle.getLong(VirtualAppProxy.KEY_PKG_SIZE, -1L), bundle.getInt("errorCode", 0));
                    return;
                } else {
                    QMLog.w(TAG, "handleCmdFromMainProcess. Ignore MESSENGER_CMD_NOTIFY_LETS_GO_RES_DOWNLOAD_UPDATE. VirtualAppProxy or bundle is null");
                    return;
                }
            default:
                return;
        }
    }

    private boolean isMainProcess() {
        return AppLoaderFactory.g().isMainProcess();
    }

    private void notifyLifeCycleLocked(int i3, String str, MiniAppInfo miniAppInfo, Bundle bundle) throws RemoteException {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable(IPCConst.KEY_CLIENT_PROCESS_DEATH_NOTIFIER, ProcessDeathNotifier.getInstance());
        bundle2.putInt(IPCConst.KEY_CLIENT_PROCESS_PID, Process.myPid());
        bundle2.putParcelableArrayList(IPCConst.KEY_BUNDLE_RUNTIME_LIST, AppRuntimeLoaderManager.g().getAllLoadedAppInfos());
        this.mService.onAppLifecycle(i3, str, miniAppInfo, bundle2);
    }

    private boolean notifySpecialShareResult(@NotNull BaseRuntime baseRuntime, @Nullable Bundle bundle) {
        JSONObject wrapCallbackFail;
        if (bundle != null && !bundle.isEmpty()) {
            String string = bundle.getString(MiniSDKConst.MESSENGER_KEY_NOTIFY_SHARE_EVENT);
            int i3 = bundle.getInt(MiniSDKConst.MESSENGER_KEY_NOTIFY_SHARE_CALLBACK_ID, -1);
            bundle.getString(MiniSDKConst.MESSENGER_KEY_NOTIFY_SUBSCRIBE_EVENT);
            if (!TextUtils.isEmpty(string) && i3 != -1) {
                IJsService jsService = baseRuntime.getJsService();
                if (jsService == null) {
                    QMLog.w(TAG, "handleCmdFromMainProcess. Ignore, jsService is null");
                    return false;
                }
                if (bundle.getInt(ShareData.KEY_SHARE_RESULT) == 0) {
                    wrapCallbackFail = ApiUtil.wrapCallbackOk(string, null);
                } else {
                    wrapCallbackFail = ApiUtil.wrapCallbackFail(string, null);
                }
                jsService.evaluateCallbackJs(i3, wrapCallbackFail.toString());
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyToService() {
        if (!this.mNeedSyncStatus) {
            return;
        }
        this.mNeedSyncStatus = false;
        try {
            String currentProcessName = AppLoaderFactory.g().getCurrentProcessName();
            if (queryIsMiniProcess()) {
                QMLog.w(TAG, "Sync Process Status=" + this.mMiniAppStatus);
                notifyLifeCycleLocked(1, currentProcessName, this.mAppConfig, this.mStartBundle);
                int i3 = this.mMiniAppStatus;
                if (i3 == 3) {
                    notifyLifeCycleLocked(3, currentProcessName, this.mAppConfig, null);
                } else if (i3 == 2) {
                    notifyLifeCycleLocked(2, currentProcessName, this.mAppConfig, null);
                }
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "onAppStart exception.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performStartMiniApp(final Activity activity, MiniAppInfo miniAppInfo, Bundle bundle, final ResultReceiver resultReceiver) {
        try {
            this.mService.startMiniApp(miniAppInfo, bundle, new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.qqmini.sdk.ipc.LaunchManagerClient.6
                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int i3, Bundle bundle2) {
                    super.onReceiveResult(i3, bundle2);
                    if (i3 == 1) {
                        bundle2.setClassLoader(getClass().getClassLoader());
                        try {
                            Intent intent = (Intent) bundle2.getParcelable(IPCConst.KEY_LAUNCH_ACTIVITY_INTENT);
                            intent.setExtrasClassLoader(getClass().getClassLoader());
                            intent.putExtra("receiver", resultReceiver);
                            Activity activity2 = activity;
                            if (activity2 != null) {
                                activity2.startActivity(intent);
                            } else {
                                MiniAppEnv.g().getContext().startActivity(intent);
                            }
                        } catch (Throwable th5) {
                            QMLog.e(LaunchManagerClient.TAG, "startMiniApp startActivity exception!", th5);
                        }
                    }
                }
            });
        } catch (Throwable th5) {
            QMLog.e(TAG, "startMiniApp exception.", th5);
        }
    }

    private static void sendResult(ResultReceiver resultReceiver, int i3, Bundle bundle) {
        if (resultReceiver == null) {
            return;
        }
        resultReceiver.send(i3, bundle);
    }

    public synchronized ILaunchManager getService() {
        ILaunchManager iLaunchManager = this.mService;
        if (iLaunchManager != null) {
            return iLaunchManager;
        }
        ensureService();
        return this.mService;
    }

    public void innerIPCToMainProcess(final Activity activity, final MiniAppInfo miniAppInfo, final Bundle bundle, final ResultReceiver resultReceiver) {
        if (getService() == null) {
            QMLog.e(TAG, "startMiniApp IAppBrandService Connection is Null.");
            this.mTaskAfterConnected.add(new Runnable() { // from class: com.tencent.qqmini.sdk.ipc.LaunchManagerClient.5
                @Override // java.lang.Runnable
                public void run() {
                    LaunchManagerClient.this.performStartMiniApp(activity, miniAppInfo, bundle, resultReceiver);
                }
            });
        } else {
            performStartMiniApp(activity, miniAppInfo, bundle, resultReceiver);
        }
    }

    public void notifyPeriodicCacheUpdate(MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) {
        BaseRuntimeLoader queryAppRunTimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(miniAppInfo);
        if (queryAppRunTimeLoader == null) {
            QMLog.w(TAG, "handleCmdFromMainProcess. Ignore, runtime loader is null");
            sendResult(resultReceiver, -1, bundle);
            return;
        }
        BaseRuntime runtime = queryAppRunTimeLoader.getRuntime();
        if (runtime == null) {
            QMLog.w(TAG, "handleCmdFromMainProcess. Ignore, runtime is null");
            sendResult(resultReceiver, -1, bundle);
            return;
        }
        IJsService jsService = runtime.getJsService();
        if (jsService == null) {
            QMLog.w(TAG, "handleCmdFromMainProcess. Ignore, jsService is null");
            sendResult(resultReceiver, -1, bundle);
            return;
        }
        QMLog.i(TAG, "evaluateSubscribeJS ON_BACKGROUND_FETCH_DATA appid:" + miniAppInfo.appId);
        jsService.evaluateSubscribeJS("onBackgroundFetchData", new JSONObject().toString(), 0);
        sendResult(resultReceiver, 0, bundle);
    }

    public void notifyShareResult(MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) {
        ShareState obtain;
        IJsService jsService;
        JSONObject wrapCallbackFail;
        BaseRuntimeLoader queryAppRunTimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(miniAppInfo);
        if (queryAppRunTimeLoader == null) {
            QMLog.w(TAG, "handleCmdFromMainProcess. Ignore, runtime loader is null");
            sendResult(resultReceiver, -1, bundle);
            return;
        }
        BaseRuntime runtime = queryAppRunTimeLoader.getRuntime();
        if (runtime == null) {
            QMLog.w(TAG, "handleCmdFromMainProcess. Ignore, runtime is null");
            sendResult(resultReceiver, -1, bundle);
            return;
        }
        if (!notifySpecialShareResult(runtime, bundle) && (obtain = GetShareState.obtain(runtime)) != null) {
            RequestEvent requestEvent = obtain.requestEvent;
            if (requestEvent != null) {
                jsService = requestEvent.jsService;
            } else {
                jsService = runtime.getJsService();
            }
            if (jsService == null) {
                QMLog.w(TAG, "handleCmdFromMainProcess. Ignore, jsService is null");
                sendResult(resultReceiver, -1, bundle);
            } else {
                if (bundle.getInt(ShareData.KEY_SHARE_RESULT) == 0) {
                    wrapCallbackFail = ApiUtil.wrapCallbackOk(obtain.shareEvent, null);
                } else {
                    wrapCallbackFail = ApiUtil.wrapCallbackFail(obtain.shareEvent, null);
                }
                jsService.evaluateCallbackJs(obtain.shareCallbackId, wrapCallbackFail.toString());
            }
        }
    }

    public void onAppLifecycle(int i3, String str, MiniAppInfo miniAppInfo, Bundle bundle) {
        this.mAppConfig = miniAppInfo;
        if (i3 == 1) {
            if (this.mMiniAppStatus < 1) {
                this.mMiniAppStatus = 1;
            }
            if (getService() == null) {
                this.mNeedSyncStatus = true;
                this.mStartBundle = bundle;
                QMLog.e(TAG, "onAppStart IAppBrandService Connection is Null.");
                return;
            }
            try {
                QMLog.i(TAG, "notify onAppStart");
                notifyLifeCycleLocked(1, str, miniAppInfo, bundle);
                if (miniAppInfo != null) {
                    QMLog.i(TAG, "notify onAppForeground after onAppStart");
                    notifyLifeCycleLocked(2, str, miniAppInfo, bundle);
                    return;
                }
                return;
            } catch (Throwable th5) {
                QMLog.e(TAG, "onAppStart exception.", th5);
                return;
            }
        }
        this.mMiniAppStatus = i3;
        if (getService() == null) {
            QMLog.e(TAG, "onAppLifecycle IAppBrandService Connection is Null. lifecycle:" + i3);
            return;
        }
        try {
            QMLog.i(TAG, "notify lifecycle:" + i3);
            notifyLifeCycleLocked(i3, str, miniAppInfo, bundle);
            if (i3 == 4) {
                releaseService();
            }
        } catch (Throwable th6) {
            QMLog.e(TAG, "onAppLifecycle exception. lifecycle:" + i3, th6);
        }
    }

    public void preloadPackage(final MiniAppInfo miniAppInfo, final ResultReceiver resultReceiver) {
        final ILaunchManager service = getService();
        Runnable runnable = new Runnable() { // from class: com.tencent.qqmini.sdk.ipc.LaunchManagerClient.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    service.preloadDownloadPackage(miniAppInfo, resultReceiver);
                } catch (RemoteException e16) {
                    QMLog.e(LaunchManagerClient.TAG, "preloadPackage exception.", e16);
                }
            }
        };
        if (service != null) {
            runnable.run();
        } else {
            this.mTaskAfterConnected.add(runnable);
        }
    }

    public boolean queryIsMiniProcess() {
        boolean z16 = false;
        if (getService() == null) {
            QMLog.e(TAG, "queryIsMiniProcess IAppBrandService Connection is Null.");
            return false;
        }
        try {
            Bundle requestAync = this.mService.requestAync(IPCConst.CMD_QUERY_IS_MINI_PROCESS, AppLoaderFactory.g().getCurrentProcessName(), null);
            if (requestAync != null) {
                z16 = requestAync.getBoolean("key_result");
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "queryiIsMiniProcess exception.", th5);
        }
        QMLog.i(TAG, "queryiIsMiniProcess " + z16);
        return z16;
    }

    protected void releaseService() {
        QMLog.w(TAG, "releaseService.");
        try {
            if (this.mService != null) {
                this.mContext.unbindService(this.mConnection);
                this.mService = null;
            }
        } catch (Throwable unused) {
            QMLog.w(TAG, "exception when releaseService.");
        }
    }

    public void sendCmd(final String str, final Bundle bundle, final MiniCmdCallback miniCmdCallback) {
        if (getService() == null) {
            if (!MiniLog.isLogStringContainerHighFrequencyEvent(str) && !FastClickUtils.isFastDoubleClick(TAG, 200L)) {
                QMLog.e(TAG, "sendCmd IAppBrandService Connection is Null. cmd=" + str);
            }
            this.mTaskAfterConnected.add(new Runnable() { // from class: com.tencent.qqmini.sdk.ipc.LaunchManagerClient.9
                @Override // java.lang.Runnable
                public void run() {
                    if (LaunchManagerClient.this.getService() == null) {
                        if (!MiniLog.isLogStringContainerHighFrequencyEvent(str) && !FastClickUtils.isFastDoubleClick(LaunchManagerClient.TAG, 200L)) {
                            QMLog.e(LaunchManagerClient.TAG, "sendCmd IAppBrandService Connection is Null 1. cmd=" + str);
                        }
                        MiniCmdCallback miniCmdCallback2 = miniCmdCallback;
                        if (miniCmdCallback2 != null) {
                            try {
                                miniCmdCallback2.onCmdResult(false, new Bundle());
                                return;
                            } catch (Throwable th5) {
                                QMLog.e(LaunchManagerClient.TAG, "sendCmd exception.", th5);
                                return;
                            }
                        }
                        return;
                    }
                    try {
                        LaunchManagerClient.this.mService.sendCmd(str, AppLoaderFactory.g().getCurrentProcessName(), bundle, miniCmdCallback);
                    } catch (Throwable th6) {
                        QMLog.e(LaunchManagerClient.TAG, "sendCmd exception.", th6);
                    }
                }
            });
            return;
        }
        try {
            this.mService.sendCmd(str, AppLoaderFactory.g().getCurrentProcessName(), bundle, miniCmdCallback);
        } catch (Throwable th5) {
            QMLog.e(TAG, "sendCmd exception.", th5);
        }
    }

    public void startMiniApp(final Activity activity, final MiniAppInfo miniAppInfo, final Bundle bundle, final ResultReceiver resultReceiver) {
        if (getService() == null) {
            QMLog.e(TAG, "startMiniApp IAppBrandService Connection is Null.");
            this.mTaskAfterConnected.add(new Runnable() { // from class: com.tencent.qqmini.sdk.ipc.LaunchManagerClient.4
                @Override // java.lang.Runnable
                public void run() {
                    LaunchManagerClient.this.performStartMiniApp(activity, miniAppInfo, bundle, resultReceiver);
                }
            });
        } else {
            performStartMiniApp(activity, miniAppInfo, bundle, resultReceiver);
        }
    }

    public void stopAllMiniApp() {
        if (getService() == null) {
            QMLog.e(TAG, "stopAllMiniApp IAppBrandService Connection is Null.");
            this.mTaskAfterConnected.add(new Runnable() { // from class: com.tencent.qqmini.sdk.ipc.LaunchManagerClient.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LaunchManagerClient.this.mService.stopAllMiniApp();
                    } catch (Throwable th5) {
                        QMLog.e(LaunchManagerClient.TAG, "stopMiniApp exception.", th5);
                    }
                }
            });
        } else {
            try {
                this.mService.stopAllMiniApp();
            } catch (Throwable th5) {
                QMLog.e(TAG, "stopMiniApp exception.", th5);
            }
        }
    }

    public void stopMiniApp(final MiniAppInfo miniAppInfo) {
        if (getService() == null) {
            QMLog.e(TAG, "stopMiniApp IAppBrandService Connection is Null.");
            this.mTaskAfterConnected.add(new Runnable() { // from class: com.tencent.qqmini.sdk.ipc.LaunchManagerClient.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LaunchManagerClient.this.mService.stopMiniApp(miniAppInfo);
                    } catch (Throwable th5) {
                        QMLog.e(LaunchManagerClient.TAG, "stopMiniApp exception.", th5);
                    }
                }
            });
        } else {
            try {
                this.mService.stopMiniApp(miniAppInfo);
            } catch (Throwable th5) {
                QMLog.e(TAG, "stopMiniApp exception.", th5);
            }
        }
    }
}
