package com.tencent.qqmini.sdk.server;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.Configuration;
import com.tencent.qqmini.sdk.launcher.MiniProcessorConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniServiceFetcher;
import com.tencent.qqmini.sdk.launcher.shell.IMiniServer;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class MiniServer implements IMiniServer {
    private static final String TAG = "MiniServer";
    private Context mContext;
    private final IMiniServiceManager mMiniServiceManager = MiniServiceManagerService.asInterface();
    private final LaunchManagerService mLaunchManagerService = new LaunchManagerService();

    MiniServer() {
    }

    public static final MiniServer g() {
        return (MiniServer) AppLoaderFactory.g().getMiniServer();
    }

    private void processConfiguration(Configuration configuration) {
        if (this.mContext == null) {
            QMLog.e(TAG, "processConfiguration with Context is null!");
            return;
        }
        if (configuration == null) {
            QMLog.e(TAG, "processConfiguration with Configuration is null!");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Configuration.ProcessInfo processInfo : configuration.processInfoList) {
            MiniProcessorConfig miniProcessorConfig = new MiniProcessorConfig(processInfo.processType, processInfo.name, processInfo.uiClass, processInfo.internalUIClass, processInfo.receiverClass, processInfo.supportRuntimeType);
            QMLog.i(TAG, "createConfiguration. Add processor config: " + miniProcessorConfig);
            arrayList.add(miniProcessorConfig);
        }
        this.mLaunchManagerService.registerProcessInfo(arrayList);
    }

    private void registerMiniServices() {
        try {
            this.mLaunchManagerService.init(this.mContext);
            this.mMiniServiceManager.addService(MiniSDK.LAUNCH_SERVICE, this.mLaunchManagerService.getBinder());
        } catch (RemoteException unused) {
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniServer
    public IBinder getBinder() {
        return this.mLaunchManagerService.getBinder();
    }

    public LaunchManagerService getLaunchManagerService() {
        return this.mLaunchManagerService;
    }

    public MiniServiceFetcher getMiniServiceFetcher() {
        return new MiniServiceFetcher(this.mMiniServiceManager);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniServer
    public IMiniServiceManager getMiniServiceManager() {
        return this.mMiniServiceManager;
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniServer
    public synchronized void init(Context context, Configuration configuration) {
        boolean z16;
        if (this.mContext != null) {
            QMLog.d(TAG, "Already initialized");
            return;
        }
        if (context == null) {
            QMLog.e(TAG, "Failed to init MiniServer. context is null");
            return;
        }
        QMLog.i(TAG, "Init MiniServer. MiniSdkVersion:1.83.3_576_90d624bd9 QUA:" + QUAUtil.getQUA() + " PlatformQUA:" + QUAUtil.getPlatformQUA());
        this.mContext = context;
        processConfiguration(configuration);
        registerMiniServices();
        if (!QUAUtil.isQQMainApp()) {
            AdProxy adProxy = (AdProxy) ProxyManager.get(AdProxy.class);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("adProxy init=");
            if (adProxy != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QMLog.i(TAG, sb5.toString());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniServer
    public void onHostAppBackground() {
        this.mLaunchManagerService.onHostAppBackground();
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniServer
    public void preDownloadPkg(MiniAppInfo miniAppInfo, ResultReceiver resultReceiver) {
        this.mLaunchManagerService.preDownloadPkg(miniAppInfo, resultReceiver);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniServer
    public void preloadMiniApp(Bundle bundle) {
        this.mLaunchManagerService.preloadMiniApp(bundle);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniServer
    public void registerClientMessenger(String str, Messenger messenger) {
        this.mLaunchManagerService.registerClientMessenger(str, messenger);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniServer
    public boolean sendCmdToMiniProcess(int i3, Bundle bundle, MiniAppInfo miniAppInfo, ResultReceiver resultReceiver) {
        return this.mLaunchManagerService.sendCmdToMiniProcess(i3, bundle, miniAppInfo, resultReceiver);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniServer
    public void setMute(boolean z16) {
        this.mLaunchManagerService.setMute(z16);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IMiniServer
    public void startMiniApp(Activity activity, MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) {
        this.mLaunchManagerService.startMiniApp(activity, miniAppInfo, bundle, resultReceiver);
    }
}
