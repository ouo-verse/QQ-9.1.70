package com.tencent.qqmini.sdk.ipc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;
import com.tencent.qqmini.sdk.launcher.shell.IServiceEvent;

@MiniKeep
/* loaded from: classes23.dex */
public class AppBrandProxy implements IAppBrandProxy {
    private static final String TAG = "minisdk-start_AppBrandProxy";
    private Context mContext;
    private LaunchManagerClient mLaunchManagerClient;

    public AppBrandProxy() {
        AppBrandCmdProxy.g().setAppBrandProxy(this);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy
    public void init(Context context, IServiceEvent iServiceEvent) {
        this.mContext = context;
        this.mLaunchManagerClient = new LaunchManagerClient(this.mContext, iServiceEvent);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy
    public void notifyShareResult(MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.mLaunchManagerClient.notifyShareResult(miniAppInfo, bundle, resultReceiver);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy
    public void onAppBackground(MiniAppInfo miniAppInfo, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("PID", Process.myPid());
        this.mLaunchManagerClient.onAppLifecycle(3, AppLoaderFactory.g().getProcessName(), miniAppInfo, bundle);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy
    public void onAppDestroy(MiniAppInfo miniAppInfo, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("PID", Process.myPid());
        this.mLaunchManagerClient.onAppLifecycle(4, AppLoaderFactory.g().getProcessName(), miniAppInfo, bundle);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy
    public void onAppForeground(MiniAppInfo miniAppInfo, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("PID", Process.myPid());
        this.mLaunchManagerClient.onAppLifecycle(2, AppLoaderFactory.g().getProcessName(), miniAppInfo, bundle);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy
    public void onAppStart(MiniAppInfo miniAppInfo, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("PID", Process.myPid());
        this.mLaunchManagerClient.onAppLifecycle(1, AppLoaderFactory.g().getProcessName(), miniAppInfo, bundle);
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy
    public void preloadDownloadPackage(MiniAppInfo miniAppInfo, ResultReceiver resultReceiver) {
        QMLog.e(TAG, "preloadDownloadPackage. pName=" + AppLoaderFactory.g().getCurrentProcessName() + " miniAppInfo:" + miniAppInfo);
        if (!AppLoaderFactory.g().isMainProcess()) {
            this.mLaunchManagerClient.preloadPackage(miniAppInfo, resultReceiver);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy
    public Bundle requestAync(String str, String str2, Bundle bundle) {
        try {
            return this.mLaunchManagerClient.getService().requestAync(str, str2, bundle);
        } catch (RemoteException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public void sendCmd(String str, Bundle bundle, MiniCmdCallback miniCmdCallback) {
        LaunchManagerClient launchManagerClient;
        if (!AppLoaderFactory.g().isMainProcess() && (launchManagerClient = this.mLaunchManagerClient) != null) {
            launchManagerClient.sendCmd(str, bundle, miniCmdCallback);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy
    public void startMiniApp(Activity activity, MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) {
        QMLog.e(TAG, "startMiniApp. pName=" + AppLoaderFactory.g().getCurrentProcessName() + " miniAppInfo:" + miniAppInfo);
        if (!AppLoaderFactory.g().isMainProcess()) {
            this.mLaunchManagerClient.startMiniApp(activity, miniAppInfo, bundle, resultReceiver);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy
    public void stopAllMiniApp() {
        QMLog.e(TAG, "stopAllMiniApp. pName=" + AppLoaderFactory.g().getCurrentProcessName());
        if (!AppLoaderFactory.g().isMainProcess()) {
            this.mLaunchManagerClient.stopAllMiniApp();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy
    public void stopMiniApp(MiniAppInfo miniAppInfo) {
        QMLog.e(TAG, "stopMiniApp. pName=" + AppLoaderFactory.g().getCurrentProcessName() + " miniAppInfo:" + miniAppInfo);
        if (!AppLoaderFactory.g().isMainProcess()) {
            this.mLaunchManagerClient.stopMiniApp(miniAppInfo);
        }
    }
}
