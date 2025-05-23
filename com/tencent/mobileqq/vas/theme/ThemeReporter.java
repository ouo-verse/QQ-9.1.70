package com.tencent.mobileqq.vas.theme;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeReporter {
    public static final int BASE_CODE = 5000;
    public static final String BUNDLE_KEY_FROM = "key_from";
    public static final String BUNDLE_KEY_TASK_ERR_CODE = "errCode";
    public static final String BUNDLE_KEY_TASK_GET_STATUS = "getStatus";
    public static final String BUNDLE_KEY_TASK_IS_JUMP_TOP = "isJumpTop";
    public static final String BUNDLE_KEY_WITHOUT_NET_TIPS = "withoutFlowTips";
    public static final int CODE_STEP_DOWNLOAD_ED = 257;
    public static final int CODE_STEP_DOWNLOAD_ING = 256;
    public static final int ERROR_CODE = -1;
    public static final int ERROR_CODE_DOWNLOADING_LOST_INFO = -37;
    public static final int ERROR_CODE_DOWNLOAD_FAILE = -14;
    public static final int ERROR_CODE_EXCEPTION = -35;
    public static final int ERROR_CODE_EXCEPTION_ERROR = -9;
    public static final int ERROR_CODE_FILE_NOT_EXIST = -19;
    public static final int ERROR_CODE_FILE_NUM_ERROR = -3;
    public static final int ERROR_CODE_GET_CONFIG_ERROR = -6;
    public static final int ERROR_CODE_INDATA_ERROR = -10;
    public static final int ERROR_CODE_IPC_WEB_RSP_DOWNLOAD_START = -34;
    public static final int ERROR_CODE_ISNOT_SUPPORT_THEME = -40;
    public static final int ERROR_CODE_JSON_EXCEPTION = -36;
    public static final int ERROR_CODE_NET_TYPE_ERROR = -41;
    public static final int ERROR_CODE_NIGHT_CONFIG_DOWNLOAD_FAIL = -33;
    public static final int ERROR_CODE_NO_NETWORK = -13;
    public static final int ERROR_CODE_NO_SSD = -11;
    public static final int ERROR_CODE_PARMS_ERROR = -8;
    public static final int ERROR_CODE_SET_SQLITE_FAIL = -44;
    public static final int ERROR_CODE_SP_CTID_IS_NULL = -43;
    public static final int ERROR_CODE_SSD_SPACE_ERROR = -12;
    public static final int ERROR_CODE_SWITCH_THEMEINFO_NULL = -53;
    public static final int ERROR_CODE_SWITCH_VERSION_NULL = -54;
    public static final int ERROR_CODE_THEMEINFO_NULL = -7;
    public static final int ERROR_CODE_THEME_SET_PATH_FAIL = -24;
    public static final int ERROR_CODE_THEME_SWITCH_FAIL = -23;
    public static final int ERROR_CODE_ZIP_NOT_EXIST = -29;
    public static final int ERROR_CODE_ZIP_SIZE_ERROR = -28;
    public static final int ERROR_CODE_ZIP_UNZIP_FAILE = -30;
    public static final String FROM_AUTH = "204";
    public static final String FROM_CLEANER = "210";
    public static final String FROM_DIR_COVER = "214";
    public static final String FROM_DIY = "201";
    public static final String FROM_ENGINE = "205";
    public static final String FROM_INIT_THEME = "206";
    public static final String FROM_MALL = "200";
    public static final String FROM_NIGHT = "202";
    public static final String FROM_NIGHT_ROAMING = "213";
    public static final String FROM_PUSH = "209";
    public static final String FROM_SERVER_SET_THEME = "207";
    public static final String FROM_SIMPLE = "211";
    public static final String FROM_SIMPLE_INIT = "212";
    public static final String FROM_UPDATE = "208";
    public static final String FROM_VIP = "215";
    public static final String FROM_WEEKLOOP = "203";
    public static final String PATH_DOWNLOAD = String.valueOf(153);
    public static final String PATH_SETPUP = String.valueOf(153);
    public static final int RESULT_CODE_FILES_NUM_ERROR = 101;
    public static final int RESULT_CODE_FILE_NOT_EXIST = 119;
    public static final int RESULT_CODE_THEME_ID_SP_NOT_EXIST = 137;
    public static final int RESULT_CODE_UNZIP2_RUNED = 136;
    public static final int RESULT_CODE_ZIP_ERROR = 135;
    public static final int STEP_AUTH = 157;
    public static final int STEP_DOWNLOAD = 153;
    public static final int STEP_ENTER = 150;
    public static final int STEP_GET_CONFIG = 151;
    public static final int STEP_INIT = 156;
    public static final int STEP_QUERY = 152;
    public static final int STEP_SETPUP = 155;
    public static final int STEP_SET_SP = 158;
    public static final int STEP_UNZIP = 154;
    public static final String SUBACTION_THEME = "theme_detail";
    public static final String SUBACTION_THEME_SPEED = "theme_speed";
    public static final String SUBACTION_THEME_SP_SPEED = "theme_sp_speed";
    public static final int SUCCESS_CODE = 1;
    public static final int SUCCESS_CODE_CONTINUE_IN_WIFI = 12;
    public static final int SUCCESS_CODE_DOWNLOADING = 4;
    public static final int SUCCESS_CODE_DOWNLOAD_OK = 9;
    public static final int SUCCESS_CODE_DOWNLOAD_OK_NEW = 35;
    public static final int SUCCESS_CODE_DOWNLOAD_REQ = 7;
    public static final int SUCCESS_CODE_DOWNLOAD_TASKS_TART = 8;
    public static final int SUCCESS_CODE_HAVE_FILES = 3;
    public static final int SUCCESS_CODE_HAVE_ZIP = 2;
    public static final int SUCCESS_CODE_IPC_RECIVE_DOWNLOAD_REQ = 20;
    public static final int SUCCESS_CODE_IPC_THEME_SWITCH_SUCCESS = 31;
    public static final int SUCCESS_CODE_IPC_WEB_RSP_DOWNLOAD_START = 34;
    public static final int SUCCESS_CODE_NIGHT_CONFIG_DOWNLOAD_REQ = 32;
    public static final int SUCCESS_CODE_NIGHT_CONFIG_DOWNLOAD_SUCCESS = 33;
    public static final int SUCCESS_CODE_PAUSE_FOR_ANOTHER = 16;
    public static final int SUCCESS_CODE_STOP_DOWNLOAD_REQ = 22;
    public static final int SUCCESS_CODE_STOP_DOWNLOAD_RSP = 21;
    public static final int SUCCESS_CODE_THEME_SWITCH_SUCCESS = 23;
    public static final int SUCCESS_CODE_USER_CANCEL_FOR_NETWORK = 10;
    public static final int SUCCESS_CODE_USER_CONTINUE_IN_NETWORK = 11;
    public static final int SUCCESS_CODE_USER_PAUSE = 15;
    public static final int SUCCESS_CODE_USER_REDOWN = 17;
    public static final int SUCCESS_CODE_ZIP_UNZIP_SUCCESS = 30;
    static final String TAG = "ThemeReporter";
    public static final String THEME_ID = "id";
    public static final String THEME_ISSOUND = "isSound";
    public static final String THEME_SIZE = "size";
    public static final String THEME_URL = "url";
    public static final String THEME_VERSION = "version";

    public static void reportTheme(AppRuntime appRuntime, String str, String str2, int i3, int i16, int i17, String str3, String str4, String str5, String str6) {
        if (i16 < 0) {
            NetworkUtil.getSystemNetwork(null);
        }
        try {
            if (TextUtils.isEmpty(str4)) {
                str4 = "1";
            }
            if (QLog.isColorLevel() && i17 < 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("ThemeReporterreportTheme Error data::");
                sb5.append(str + "|step:" + i3 + "|from:" + str2 + "|resultCode:" + i17 + "|id:" + str3 + "|version:" + str4);
                QLog.i(TAG, 2, sb5.toString());
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "ThemeReporter reportTheme Exception:" + e16.getMessage());
        }
    }
}
