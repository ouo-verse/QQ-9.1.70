package com.tencent.mobileqq.minigame.utils;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GameWnsUtils {
    private static final String TAG = "GameWnsUtils";
    private static final boolean sLogEnable;

    static {
        sLogEnable = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameLogEnable", 1) == 1;
    }

    private static boolean buildModelEnable() {
        String config = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameBlackList", "[GT-I9502]");
        try {
            String model = DeviceInfoMonitor.getModel();
            if (TextUtils.isEmpty(model)) {
                QZLog.e(TAG, 2, "buildModelEnable model empty");
                return false;
            }
            if (QZLog.isColorLevel()) {
                QZLog.d(TAG, 2, "build model is " + model);
            }
            if (!TextUtils.isEmpty(config)) {
                if (config.contains("[" + model + "]")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public static String defaultPayShareImg() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDefaultPayShareImg", "https://sola.gtimg.cn/aoi/sola/20200615194538_YYA1zqPM8t.png");
    }

    public static String defaultPayShareTitle() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDefaultPayShareTitle", "\u4eb2\u7231\u7684\uff0c\u62dc\u6258\u4f60\u5e2e\u6211\u4ee3\u4ed8\u4e00\u7b14\u8ba2\u5355\uff5e");
    }

    public static String defaultShareImg() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDefaultShareImg", "https://qzonestyle.gtimg.cn/aoi/sola/20190510161934_LYAUVguqnV.png");
    }

    public static String downloaderPreConnectHost() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_MINI_GAME_DOWNLOADER_PRE_CONNECT_HOST, QzoneConfig.DefaultValue.DEFAULT_MINI_GAME_DOWNLOADER_PRE_CONNECT_HOST);
    }

    public static boolean enableDownloaderPreConnect() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_MINI_GAME_ENABLE_DOWNLOADER_PRE_CONNECT, 1) > 0;
    }

    public static boolean enableGameruntimePreload() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_MINI_GAME_RUNTIME_PRELOAD, 0) > 0;
    }

    public static boolean enableGameruntimePreloadOnFirstFrame() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_MINI_GAME_RUNTIME_PRELOAD_ON_FIRST_FRAME, 1) > 0;
    }

    public static boolean enableHotReload() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniEnableHotReload", 1) > 0;
    }

    public static boolean enableHttp2() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_MINI_GAME_ENABLE_HTTP2, 1) > 0;
    }

    public static boolean enableInstructionsForMiniApp() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppEnableInstructions", 0) > 0;
    }

    public static boolean enableOpengles3() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "enableOpengles3", 1) > 0;
    }

    public static boolean enablePersistentDebugVersion() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePersistentDebugVersionEnable", 1) > 0;
    }

    public static boolean enablePreloadGameBaseLib() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePreloadBaseLibEnable", 1) > 0;
    }

    public static boolean enableStorageExceedDialog() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameStorageExceedDialogEnable", 0) > 0;
    }

    public static int enableStorageExceedLimit() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameStorageExceedLimit", 3);
    }

    public static String gameDisableHint() {
        return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, WnsConfig.SECONDARY_MINI_GAME_DISABLE_HINT, WnsConfig.DefaultValue.DEFAULT_MINI_GAME_DISABLE_HINT);
    }

    public static boolean gameEnable() {
        return suffixEnable() && buildModelEnable() && gameSysVersionAllowed();
    }

    public static boolean gameEnableDexLoader() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDexEnable", 1) == 1;
    }

    public static boolean gameEnableLog() {
        return sLogEnable;
    }

    private static boolean gameSysVersionAllowed() {
        return Build.VERSION.SDK_INT >= QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameMinSysVersion", 18);
    }

    public static String getBackPressHint() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameBackPressHint", "\u518d\u6309\u4e00\u6b21\u8fd4\u56de\u952e\u9000\u51fa\u8be5\u7a0b\u5e8f");
    }

    public static int getBannerAdMinWidth() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameBannerAdMinWidth", 300);
    }

    public static String getBattleGameShowAlertViewScenes() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_GAME_RETAIN_ALERT_VIEW_SCENE, "{\"2\": [\"2072\"],\"3\": [\"1037\"]}");
    }

    public static String getCacheFreeContent() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameCacheFreeDialogContent", "\u6e38\u620f\u5b58\u50a8\u5f02\u5e38,\u662f\u5426\u6e05\u7f13\u5b58\u540e\u91cd\u542f\u6e38\u620f\uff1f");
    }

    public static int getDownloaderMode() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_MINI_GAME_DOWNLOADER_MODE, 2);
    }

    public static int getDropGuideShowTimes() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.MINI_GAME_DROP_GUIDE_EXPOSURE_TIMES_THRESHOLD, 3);
    }

    public static String getFakeFristFrameUrl() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameFakeFirstFrameUrl", "");
    }

    public static int getFrameNoChangeLimit() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameFrameNoChangeLimit", 5);
    }

    public static BaseLibInfo getGameBaseLibInfo() {
        String config = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameBaseLib", QzoneConfig.DEFAULT_MINI_GAME_BASELIB);
        QLog.i("minigame", 1, "MiniEng getWnsGameBaseLibInfo " + config);
        if (TextUtils.isEmpty(config)) {
            return null;
        }
        try {
            return BaseLibInfo.fromJSON(new JSONObject(config));
        } catch (Exception e16) {
            QLog.e("minigame", 1, "MiniEng getWnsGameBaseLibInfo failed", e16);
            return null;
        }
    }

    public static String getGameEngineVersion(String str) {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameEngineVersion", str);
    }

    public static int getGameErrorBlackDetectInterval() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameBlackDetectInterval", 3000);
    }

    public static String getGameErrorDialogContent() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameErrorDialogContent", "\u6e38\u620f\u5f02\u5e38\u505c\u6b62, \u662f\u5426\u9700\u8981\u91cd\u542f\u6e38\u620f?");
    }

    public static boolean getGameErrorDialogEnable() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameErrorDialogEnable", 1) > 0;
    }

    public static boolean getGameErrorDialogIsBlack() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String lowerCase = str.toLowerCase();
        String config = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameErrorDialogBlack", "");
        if (TextUtils.isEmpty(config)) {
            return false;
        }
        return config.contains(lowerCase);
    }

    public static int getGameJsErrorDetectInterval() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameJsErrorDetectInterval", 5000);
    }

    public static String getGameLaunchFailContent() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameLaunchFailDialogContent", "\u6e38\u620f\u52a0\u8f7d\u5f02\u5e38\uff0c\u662f\u5426\u6e05\u7f13\u5b58\u540e\u91cd\u542f\u6e38\u620f\uff1f");
    }

    public static long getGameOnShowReportInterval() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameOnShowReportInterval", 2000L);
    }

    public static int getGamePresentDetectInterval() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGamePresentDetectInterval", 1000);
    }

    public static String getGameRetainConfirmImageUrl() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_GAME_RETAIN_CONFIRM_ANIMATION_IMAGE_URL, "https://sola.gtimg.cn/aoi/sola/20201023180719_cpjdc4WFx1.png");
    }

    public static int getMaxRangeNumber() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_MAX_RANGE_NUMBER, 4);
    }

    public static String getMiniGamePublicAccountGameStoreButtonUrl() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.MINI_GAME_PUBLIC_ACCOUNT_GAME_STORE_BUTTON_URL, "https://sola.gtimg.cn/aoi/sola/20200713192038_XEvd27FTxi.png");
    }

    public static int getNoPresentDurationLimit() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameNoPresentDurationLimit", 5000);
    }

    public static int getNoPresentTouchLimit() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameNoPresentTouchLimit", 3);
    }

    public static String getPayForFriendUrl() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_MINI_GAME_PAY_FOR_FRIEND_URL, QzoneConfig.DefaultValue.DEFAULT_MINI_GAME_PAY_FOR_FRIEND_URL);
    }

    public static String getPreConnectBlackAppIdList() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_MINI_GAME_PRE_CONNECT_BLACK_APPID_LIST, QzoneConfig.DefaultValue.DEFAULT_MINI_GAME_PRE_CONNECT_BLACK_APPID_LIST);
    }

    public static int getPreConnectNum() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_MINI_GAME_PRE_CONNECT_NUM, 5);
    }

    public static String getPreconnectMethod() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_MINI_GAME_PRECONNECT_METHOD, "HEAD");
    }

    public static long getPreconnectTimeInterval() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_MINI_GAME_PRECONNECT_TIME_INTERVAL, 43200L);
    }

    public static String getQQUpdateUrl() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_upgrade_url", "https://m.q.qq.com/upgrade/{appid}");
    }

    public static String getRangeModeNetworkLevel() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_RANGE_MODE_NETWORK_LEVEL, QzoneConfig.DEFAULT_RANGE_MODE_NETWORK_LEVEL);
    }

    public static String getRangeModePerfLevel() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_RANGE_MODE_PERF_LEVEL, QzoneConfig.DEFAULT_RANGE_MODE_PERF_LEVEL);
    }

    public static long getRangeSize() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_RANGE_SIZE, 524288L);
    }

    public static long getRecordDurationInterval() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniRecordDurationInterval", 5000L);
    }

    public static long getReportDelayCheckDB() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniReportDelayCheckDB", 1000L);
    }

    public static long getReportDelayWaiting() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniReportDelayWaiting", 2000L);
    }

    public static int getRetainConfirmInterval() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.MINI_GAME_RETAIN_CONFIRM_INTERVAL, 10);
    }

    public static int getRetainConfirmShowTimes() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.MINI_GAME_RETAIN_CONFIRM_EXPOSURE_TIMES_THRESHOLD, 3);
    }

    public static long getShowTimeout() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniShowTimeout", 45000L);
    }

    public static String getTritonDownloadBackUpUrl() {
        return QzoneConfig.getInstance().getConfig("qqtriton", QzoneConfig.SECONDARY_MINI_GAME_TRITON_BACKUP_URL, QzoneConfig.DefaultValue.DEFAULT_MINI_GAME_TRITON_BACKUP_URL);
    }

    public static String getWnsLogBlackList() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameAPILogBlackList");
    }

    public static String getWnsLogWhiteList() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameAPILogWhiteList");
    }

    public static boolean isCodeCacheEnable() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameCodeCacheEnable", 1) == 1;
    }

    public static boolean isDownloadOnRangeModeEnable() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_MINI_APP_DOWNLOAD_ON_RANGE_MODE, 1) == 1;
    }

    public static boolean isForceDownloadInMainProcess() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_GAME_FORCE_DOWNLOAD_IN_MAINPROCESS, 0) == 1;
    }

    public static boolean killAllGamesWhenDestroy() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameKillAllGamesWhenDestroy", 0) == 1;
    }

    public static boolean killAllGamesWhenReuse() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameKillAllGamesWhenReuse", 0) == 0;
    }

    public static boolean needBackPressHint(String str) {
        String config = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameBackPressHintList", "1108292102");
        if (!TextUtils.isEmpty(config)) {
            try {
                String[] split = config.split(",");
                if (split != null) {
                    for (int i3 = 0; i3 < split.length; i3++) {
                        if (!TextUtils.isEmpty(split[i3]) && split[i3].equals(str)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th5) {
                QZLog.e(TAG, 2, "needBackPressHint exception", th5);
            }
        }
        return false;
    }

    public static int retryLoadSubpackageOnCompileCount() {
        return QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameSubPackRetryOnCompileCount", 1);
    }

    private static boolean suffixEnable() {
        String[] split;
        String config = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameGaryRange", "0-100");
        int[] iArr = new int[2];
        try {
            if (!TextUtils.isEmpty(config) && (split = config.split("-")) != null && split.length >= 2) {
                iArr[0] = Integer.parseInt(split[0]);
                iArr[1] = Integer.parseInt(split[1]);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        long l3 = com.tencent.open.adapter.a.f().l() % 100;
        return l3 >= ((long) iArr[0]) && l3 < ((long) iArr[1]);
    }
}
