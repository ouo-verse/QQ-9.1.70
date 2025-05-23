package com.tencent.qqmini.sdk.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WnsUtil {
    private static final String TAG = "WnsUtil";
    private static volatile int maxTopNum = -1;
    private static volatile int showFullScreen = -1;

    public static String defaultShareImg() {
        return WnsConfig.getConfig("qqtriton", "MiniGameDefaultShareImg", "https://qzonestyle.gtimg.cn/aoi/sola/20190510161934_LYAUVguqnV.png");
    }

    public static int getBannerAdMinWidth() {
        return WnsConfig.getConfig("qqtriton", "MiniGameBannerAdMinWidth", 300);
    }

    public static BaseLibInfo getGameBaseLibInfo() {
        String config = WnsConfig.getConfig("qqtriton", "MiniGameBaseLib", WnsConfig.DEFAULT_MINI_GAME_BASELIB);
        QMLog.i("minigame", "MiniEng getWnsGameBaseLibInfo " + config);
        if (!TextUtils.isEmpty(config)) {
            try {
                return BaseLibInfo.fromJSON(new JSONObject(config));
            } catch (Exception e16) {
                QMLog.e("minigame", "MiniEng getWnsGameBaseLibInfo failed", e16);
                return null;
            }
        }
        return null;
    }

    public static String getGameEngineVersion(String str) {
        return WnsConfig.getConfig("qqtriton", "MiniGameEngineVersion", str);
    }

    public static int getMaxTopNum() {
        if (maxTopNum == -1) {
            maxTopNum = WnsConfig.getConfig("qqminiapp", "miniappfullscreenminedatamaxnum", 50);
            QMLog.d(TAG, "[MiniAppUserAppInfoListManager].maxtopnum = " + maxTopNum);
        }
        return maxTopNum;
    }

    public static boolean needShowMiniAppFullScreen() {
        if (showFullScreen == -1) {
            try {
                String account = LoginManager.getInstance().getAccount();
                showFullScreen = AppLoaderFactory.g().getContext().getSharedPreferences(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppName(), 4).getInt(account + "_miniappshowfullscreen", 1);
            } catch (Exception unused) {
                showFullScreen = 1;
                QMLog.d(TAG, "[DesktopDataManager]. needShowMiniAppFullScreen Exception");
            }
            QMLog.d(TAG, "[DesktopDataManager].needShowMiniAppFullScreen, showFullScreen = " + showFullScreen);
        }
        if (showFullScreen == 1) {
            return true;
        }
        return false;
    }
}
