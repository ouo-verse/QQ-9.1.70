package com.tencent.qqmini.sdk.utils;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.LoginManager;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GameWnsUtils {
    private static final int MINI_GAME_SHOW_RESTART_BTN = 1;
    private static final String TAG = "GameWnsUtils";
    private static final boolean sLogEnable = WnsConfig.getConfig("qqtriton", "MiniGameLogEnable", true);
    private static String[] OPENGL_ES3_BLACK_LIST = {"vivo Xplay5A", "vivo X7", "vivo X7Plus", "OPPO R9 Plusm A"};

    private static boolean buildModelEnable() {
        String config = WnsConfig.getConfig("QZoneSetting", "MiniGameBlackList", "[GT-I9502]");
        try {
            String phoneModel = DeviceInfoUtil.getPhoneModel();
            if (TextUtils.isEmpty(phoneModel)) {
                QMLog.e(TAG, "buildModelEnable model empty");
                return false;
            }
            QMLog.d(TAG, "build model is " + phoneModel);
            if (!TextUtils.isEmpty(config)) {
                if (config.contains("[" + phoneModel + "]")) {
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
        return WnsConfig.getConfig("qqtriton", "MiniGameDefaultPayShareImg", "https://sola.gtimg.cn/aoi/sola/20200615194538_YYA1zqPM8t.png");
    }

    public static String defaultPayShareTitle() {
        return WnsConfig.getConfig("qqtriton", "MiniGameDefaultPayShareTitle", "\u4eb2\u7231\u7684\uff0c\u62dc\u6258\u4f60\u5e2e\u6211\u4ee3\u4ed8\u4e00\u7b14\u8ba2\u5355\uff5e");
    }

    public static boolean enableDownloaderInSDK() {
        if (WnsConfig.getConfig("qqtriton", WnsConfig.SECONDARY_KEY_MINI_GAME_SDK_ENABLE_DOWNLOADER, 1) > 0) {
            return true;
        }
        return false;
    }

    public static boolean enableHotReload() {
        if (WnsConfig.getConfig("qqtriton", "MiniEnableHotReload", 1) > 0) {
            return true;
        }
        return false;
    }

    public static boolean enableInstructionsForMiniApp() {
        if (WnsConfig.getConfig("qqminiapp", "MiniAppEnableInstructions", 0) <= 0) {
            return false;
        }
        return true;
    }

    public static boolean enableOpengles3() {
        for (String str : OPENGL_ES3_BLACK_LIST) {
            if (DeviceInfoUtil.getPhoneModel().equalsIgnoreCase(str)) {
                return false;
            }
        }
        if (WnsConfig.getConfig("qqtriton", "enableOpengles3", 1) <= 0) {
            return false;
        }
        return true;
    }

    public static boolean enablePersistentDebugVersion() {
        if (WnsConfig.getConfig("qqtriton", "MiniGamePersistentDebugVersionEnable", 1) > 0) {
            return true;
        }
        return false;
    }

    public static boolean enablePreloadGameBaseLib() {
        if (WnsConfig.getConfig("qqtriton", "MiniGamePreloadBaseLibEnable", 1) > 0) {
            return true;
        }
        return false;
    }

    public static boolean enableStorageExceedDialog() {
        if (WnsConfig.getConfig("qqtriton", "MiniGameStorageExceedDialogEnable", 0) <= 0) {
            return false;
        }
        return true;
    }

    public static int enableStorageExceedLimit() {
        return WnsConfig.getConfig("qqtriton", "MiniGameStorageExceedLimit", 3);
    }

    public static String gameDisableHint() {
        return WnsConfig.getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, WnsConfig.SECONDARY_MINI_GAME_DISABLE_HINT, WnsConfig.DefaultValue.DEFAULT_MINI_GAME_DISABLE_HINT);
    }

    public static boolean gameEnable() {
        if (suffixEnable() && buildModelEnable() && gameSysVersionAllowed()) {
            return true;
        }
        return false;
    }

    public static boolean gameEnableDexLoader() {
        return WnsConfig.getConfig("qqtriton", "MiniGameDexEnable", true);
    }

    public static boolean gameEnableLog() {
        return sLogEnable;
    }

    private static boolean gameSysVersionAllowed() {
        if (Build.VERSION.SDK_INT >= WnsConfig.getConfig("QZoneSetting", "MiniGameMinSysVersion", 18)) {
            return true;
        }
        return false;
    }

    public static String getBackPressHint() {
        return WnsConfig.getConfig("qqtriton", "MiniGameBackPressHint", "\u518d\u6309\u4e00\u6b21\u8fd4\u56de\u952e\u9000\u51fa\u8be5\u7a0b\u5e8f");
    }

    public static String getCacheFreeContent() {
        return WnsConfig.getConfig("qqtriton", "MiniGameCacheFreeDialogContent", "\u6e38\u620f\u5b58\u50a8\u5f02\u5e38,\u662f\u5426\u6e05\u7f13\u5b58\u540e\u91cd\u542f\u6e38\u620f\uff1f");
    }

    public static int getCloseConfirmShowTimes() {
        return WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_GAME_EXIT_CONFIRM_ANIMATION_EXPOSURE_TIMES_THRESHOLD, 3);
    }

    public static String getFakeFristFrameUrl() {
        return WnsConfig.getConfig("qqtriton", "MiniGameFakeFirstFrameUrl", "");
    }

    public static int getFrameNoChangeLimit() {
        return WnsConfig.getConfig("qqtriton", "MiniGameFrameNoChangeLimit", 5);
    }

    public static boolean getGameEnableCodeCache() {
        return WnsConfig.getConfig("qqtriton", "MiniGameCodeCacheEnable", true);
    }

    public static int getGameErrorBlackDetectInterval() {
        return WnsConfig.getConfig("qqtriton", "MiniGameBlackDetectInterval", 3000);
    }

    public static String getGameErrorDialogContent() {
        return WnsConfig.getConfig("qqtriton", "MiniGameErrorDialogContent", "\u6e38\u620f\u5f02\u5e38\u505c\u6b62, \u662f\u5426\u9700\u8981\u91cd\u542f\u6e38\u620f?");
    }

    public static boolean getGameErrorDialogEnable() {
        if (WnsConfig.getConfig("qqtriton", "MiniGameErrorDialogEnable", 1) > 0) {
            return true;
        }
        return false;
    }

    public static boolean getGameErrorDialogIsBlack() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String lowerCase = str.toLowerCase();
        String config = WnsConfig.getConfig("qqtriton", "MiniGameErrorDialogBlack", "");
        if (TextUtils.isEmpty(config)) {
            return false;
        }
        return config.contains(lowerCase);
    }

    public static int getGameJsErrorDetectInterval() {
        return WnsConfig.getConfig("qqtriton", "MiniGameJsErrorDetectInterval", 5000);
    }

    public static String getGameLaunchFailContent() {
        return WnsConfig.getConfig("qqtriton", "MiniGameLaunchFailDialogContent", "\u6e38\u620f\u52a0\u8f7d\u5f02\u5e38\uff0c\u662f\u5426\u6e05\u7f13\u5b58\u540e\u91cd\u542f\u6e38\u620f\uff1f");
    }

    public static long getGameOnShowReportInterval() {
        return WnsConfig.getConfig("qqtriton", "MiniGameOnShowReportInterval", 2000L);
    }

    public static int getGamePresentDetectInterval() {
        return WnsConfig.getConfig("qqtriton", "MiniGamePresentDetectInterval", 1000);
    }

    public static String getGlobalConfig() {
        return "self = GameGlobal = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = {};\nself.wx = self.wx || {};\nself.WeixinNativeBuffer = Triton.WeixinNativeBuffer;\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {};\n__wxConfig.env.USER_DATA_PATH = '" + MiniSDKConst.STR_WXFILE + "usr';\n__wxConfig.platform = 'android';\n__wxConfig.QUA = '" + QUAUtil.getPlatformQUA() + "';\nwx.env = __wxConfig.env;\nvar __qqConfig = __wxConfig || {};\n";
    }

    public static int getNoPresentDurationLimit() {
        return WnsConfig.getConfig("qqtriton", "MiniGameNoPresentDurationLimit", 5000);
    }

    public static int getNoPresentTouchLimit() {
        return WnsConfig.getConfig("qqtriton", "MiniGameNoPresentTouchLimit", 3);
    }

    public static String getQQUpdateUrl() {
        return WnsConfig.getConfig("qqminiapp", "mini_app_upgrade_url", "https://m.q.qq.com/upgrade/{appid}");
    }

    public static long getRecordDurationInterval() {
        return WnsConfig.getConfig("qqtriton", "MiniRecordDurationInterval", 5000L);
    }

    public static long getReportDelayCheckDB() {
        return WnsConfig.getConfig("qqtriton", "MiniReportDelayCheckDB", 1000L);
    }

    public static long getReportDelayWaiting() {
        return WnsConfig.getConfig("qqtriton", "MiniReportDelayWaiting", 2000L);
    }

    public static long getShowTimeout() {
        return WnsConfig.getConfig("qqtriton", "MiniShowTimeout", 45000L);
    }

    public static boolean killAllGamesWhenDestroy() {
        if (WnsConfig.getConfig("qqtriton", "MiniGameKillAllGamesWhenDestroy", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean killAllGamesWhenReuse() {
        if (WnsConfig.getConfig("qqtriton", "MiniGameKillAllGamesWhenReuse", 0) != 0) {
            return false;
        }
        return true;
    }

    public static boolean needBackPressHint(String str) {
        String config = WnsConfig.getConfig("qqtriton", "MiniGameBackPressHintList", "1108292102");
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
                QMLog.e(TAG, "needBackPressHint exception", th5);
            }
        }
        return false;
    }

    public static int retryLoadSubpackageOnCompileCount() {
        return WnsConfig.getConfig("qqtriton", "MiniGameSubPackRetryOnCompileCount", 1);
    }

    public static boolean showRestartButton() {
        if (WnsConfig.getConfig("qqminiapp", "mini_game_capsule_show_restart_btn", 1) == 1) {
            return true;
        }
        return false;
    }

    private static boolean suffixEnable() {
        long j3;
        String[] split;
        String config = WnsConfig.getConfig("QZoneSetting", "MiniGameGaryRange", "0-100");
        int[] iArr = new int[2];
        try {
            if (!TextUtils.isEmpty(config) && (split = config.split("-")) != null && split.length >= 2) {
                iArr[0] = Integer.parseInt(split[0]);
                iArr[1] = Integer.parseInt(split[1]);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        try {
            j3 = Long.parseLong(LoginManager.getInstance().getAccount());
        } catch (Exception unused) {
            j3 = 0;
        }
        long j16 = j3 % 100;
        if (j16 >= iArr[0] && j16 < iArr[1]) {
            return true;
        }
        return false;
    }
}
