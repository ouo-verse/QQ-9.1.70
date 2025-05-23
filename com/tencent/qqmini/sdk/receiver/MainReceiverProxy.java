package com.tencent.qqmini.sdk.receiver;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IReceiverProxy;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;

@MiniKeep
/* loaded from: classes23.dex */
public class MainReceiverProxy implements IReceiverProxy {
    @Override // com.tencent.qqmini.sdk.launcher.shell.IReceiverProxy
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (MiniSDKConst.ACTION_PRELOAD_APP.equals(action)) {
            QMLog.i(AppLoaderFactory.TAG, "\u9884\u52a0\u8f7d\u5c0f\u7a0b\u5e8f");
            Bundle extras = intent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putString(MiniAppConst.MINI_KEY_PRELOAD_TYPE, MiniAppConst.PRELOAD_TYPE_APP);
            AppRuntimeLoaderManager.g().preloadRuntime(extras);
            Bundle bundle = new Bundle();
            bundle.putString(MiniAppConst.MINI_KEY_PRELOAD_TYPE, MiniAppConst.PRELOAD_TYPE_APP);
            AppLoaderFactory.g().getAppBrandProxy().onAppStart(null, bundle);
            ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).preConnectDownloadHost();
        }
        if (MiniSDKConst.ACTION_PRELAUNCH_APP.equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 == null) {
                extras2 = new Bundle();
            }
            final MiniAppInfo miniAppInfo = (MiniAppInfo) extras2.getParcelable(MiniAppConst.MINI_KEY_APPINFO);
            if (miniAppInfo == null) {
                return;
            }
            QMLog.i(AppLoaderFactory.TAG, "\u9884\u52a0\u8f7d\u5c0f\u7a0b\u5e8f miniAppInfo:" + miniAppInfo);
            extras2.putString(MiniAppConst.MINI_KEY_PRELOAD_TYPE, MiniAppConst.PRELOAD_TYPE_APP);
            AppRuntimeLoaderManager.g().preLaunchRuntimeLoader(miniAppInfo, new BaseRuntimeLoader.OnAppRuntimeLoadListener() { // from class: com.tencent.qqmini.sdk.receiver.MainReceiverProxy.1
                @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.OnAppRuntimeLoadListener
                public void onResult(int i3, String str, BaseRuntimeLoader baseRuntimeLoader) {
                    QMLog.w(AppLoaderFactory.TAG, "\u9884\u52a0\u8f7dRuntime\u5b8c\u6210 " + miniAppInfo);
                }
            }, extras2);
            ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).preConnectDownloadHost();
            return;
        }
        if (MiniSDKConst.ACTION_PRELOAD_GAME.equals(action)) {
            QMLog.i(AppLoaderFactory.TAG, "\u9884\u52a0\u8f7d\u5c0f\u6e38\u620f");
            MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 605, "1");
            if (GameWnsUtils.gameEnable() && GameWnsUtils.enablePreloadGameBaseLib()) {
                Bundle extras3 = intent.getExtras();
                if (extras3 == null) {
                    extras3 = new Bundle();
                }
                extras3.putString(MiniAppConst.MINI_KEY_PRELOAD_TYPE, MiniAppConst.PRELOAD_TYPE_GAME);
                extras3.putLong("time_start_broadcast", intent.getLongExtra("time_start_broadcast", 0L));
                extras3.putLong("time_broadcast_receive", System.currentTimeMillis());
                AppRuntimeLoaderManager.g().preloadRuntime(extras3);
                Bundle bundle2 = new Bundle();
                bundle2.putString(MiniAppConst.MINI_KEY_PRELOAD_TYPE, MiniAppConst.PRELOAD_TYPE_GAME);
                AppLoaderFactory.g().getAppBrandProxy().onAppStart(null, bundle2);
            }
            ((DownloaderProxy) ProxyManager.get(DownloaderProxy.class)).preConnectDownloadHost();
        }
    }
}
