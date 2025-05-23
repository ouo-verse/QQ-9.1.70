package com.tencent.qqmini.sdk.launcher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.launcher.Configuration;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniCodeProxy;
import com.tencent.qqmini.sdk.launcher.ipc.ILaunchManager;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniSDKImpl {
    public static final int LINKTYPE_FAKEURL = 0;
    public static final int LINKTYPE_MINICODE = 1;
    public static final int LINKTYPE_SCHEMA = 2;
    public static final String TAG = "minisdk-start_MiniSDKImpl";
    private Configuration mConfiguration;
    private volatile Context mContext;
    private ILaunchManager mLaunchManager;

    private static Configuration createConfiguration(Context context) {
        Configuration build = new Configuration.Builder(context).build();
        if (!isConfigurationValid(build)) {
            QMLog.e(TAG, "Failed to create invalid configuration");
            return null;
        }
        return build;
    }

    private ILaunchManager getLaunchManager() {
        IMiniServiceManager miniServiceManager;
        if (this.mLaunchManager == null && (miniServiceManager = AppLoaderFactory.g().getMiniServiceManager()) != null) {
            try {
                this.mLaunchManager = (ILaunchManager) miniServiceManager.getService(MiniSDK.LAUNCH_SERVICE);
            } catch (RemoteException e16) {
                QMLog.e(TAG, "Failed to getLaunchManager", e16);
            }
        }
        return this.mLaunchManager;
    }

    private static boolean isConfigurationValid(Configuration configuration) {
        List<Configuration.ProcessInfo> list;
        if (configuration != null && (list = configuration.processInfoList) != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    public void init(Context context) {
        if (context == null) {
            QMLog.e(TAG, "Failed to init MiniSDK. context is null");
            return;
        }
        if (this.mContext == null) {
            synchronized (this) {
                if (this.mContext == null) {
                    QMLog.i(TAG, "MiniSDK init context.");
                    this.mConfiguration = createConfiguration(context);
                    AppLoaderFactory.g().init(context, this.mConfiguration);
                    this.mContext = context;
                }
            }
        }
    }

    public void notifyPeriodicCacheUpdate(MiniAppInfo miniAppInfo) {
        if (AppLoaderFactory.g().isMainProcess()) {
            AppLoaderFactory.g().getMiniServer().sendCmdToMiniProcess(1002, new Bundle(), miniAppInfo, null);
        }
    }

    public void notifyShareResult(MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) {
        if (AppLoaderFactory.g().isMainProcess()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            AppLoaderFactory.g().getMiniServer().sendCmdToMiniProcess(1001, bundle, miniAppInfo, resultReceiver);
            return;
        }
        AppLoaderFactory.g().getAppBrandProxy().notifyShareResult(miniAppInfo, bundle, resultReceiver);
    }

    public void onHostAppBackground() {
        if (AppLoaderFactory.g().isMainProcess()) {
            AppLoaderFactory.g().getMiniServer().onHostAppBackground();
        }
    }

    public void preDownloadPkg(MiniAppInfo miniAppInfo, ResultReceiver resultReceiver) {
        if (AppLoaderFactory.g().isMainProcess()) {
            AppLoaderFactory.g().getMiniServer().preDownloadPkg(miniAppInfo, resultReceiver);
        } else {
            AppLoaderFactory.g().getAppBrandProxy().preloadDownloadPackage(miniAppInfo, resultReceiver);
        }
    }

    public void preloadMiniApp(Context context, Bundle bundle) {
        QMLog.i(TAG, "preloadMiniApp");
        if (AppLoaderFactory.g().isMainProcess()) {
            AppLoaderFactory.g().getMiniServer().preloadMiniApp(bundle);
        } else {
            QMLog.e(TAG, "preloadMiniApp should be called only in main process!!!");
        }
    }

    public String scanMiniCode(byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        try {
            return ((MiniCodeProxy) AppLoaderFactory.g().getProxyManager().get(MiniCodeProxy.class)).decode(bArr, i3, i16, i17, i18, i19, i26, i27);
        } catch (Throwable unused) {
            return "scanMiniCode error";
        }
    }

    public void setAudioMute(Context context, boolean z16) {
        if (context == null) {
            return;
        }
        if (AppLoaderFactory.g().isMainProcess()) {
            AppLoaderFactory.g().getMiniServer().setMute(z16);
        }
        Intent intent = new Intent();
        intent.setAction(MiniSDKConst.ACTION_AUDIO_MUTE);
        intent.putExtra("isMute", z16);
        context.sendBroadcast(intent);
    }

    public void startMiniApp(Activity activity, MiniAppInfo miniAppInfo, Bundle bundle, ResultReceiver resultReceiver) {
        QMLog.i(TAG, "startMiniApp miniappInfo:" + miniAppInfo);
        if (miniAppInfo != null) {
            StartupReportUtil.reportAppInfo(miniAppInfo);
        }
        if (AppLoaderFactory.g().isMainProcess()) {
            AppLoaderFactory.g().getMiniServer().startMiniApp(activity, miniAppInfo, bundle, resultReceiver);
        } else {
            AppLoaderFactory.g().getAppBrandProxy().startMiniApp(activity, miniAppInfo, bundle, resultReceiver);
        }
    }

    public void stopAllMiniApp() {
        QMLog.i(TAG, "stopAllMiniApp. pName=" + AppLoaderFactory.g().getCurrentProcessName());
        try {
            getLaunchManager().stopAllMiniApp();
        } catch (RemoteException e16) {
            QMLog.e(TAG, "Failed to stopAllMiniApp", e16);
        }
    }

    public void stopMiniApp(MiniAppInfo miniAppInfo) {
        QMLog.i(TAG, "stopMiniApp. pName=" + AppLoaderFactory.g().getCurrentProcessName() + " miniAppInfo:" + miniAppInfo);
        try {
            getLaunchManager().stopMiniApp(miniAppInfo);
        } catch (Throwable th5) {
            QMLog.e(TAG, "Failed to stopMiniApp", th5);
        }
    }
}
