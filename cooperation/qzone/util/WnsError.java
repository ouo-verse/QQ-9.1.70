package cooperation.qzone.util;

import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class WnsError {
    public static final boolean SHOW_RESULT_CODE = true;
    public static final int SUCCESS = 0;
    public static final int WNS_CODE_DIS_STAT_BEGIN = 2400;
    public static final int WNS_CODE_DIS_STAT_END = 2499;
    public static final int WNS_CODE_LOGIN_3GSVR_BUSY = 1902;
    public static final int WNS_CODE_LOGIN_A2_CHANGED = 1907;
    public static final int WNS_CODE_LOGIN_A2_EXPIRED = 1906;
    public static final int WNS_CODE_LOGIN_A2_ILLEGAL = 1903;
    public static final int WNS_CODE_LOGIN_B2_EXPIRED = 1910;
    public static final int WNS_CODE_LOGIN_CREATEUIDFAIL = 1909;
    public static final int WNS_CODE_LOGIN_ILLIGAL_APPID = 1912;
    public static final int WNS_CODE_LOGIN_NOTOKEN = 1908;
    public static final int WNS_CODE_LOGIN_PTLOGIN_BUSY = 1901;
    public static final int WNS_CODE_LOGIN_SID_EXPIRED = 1905;
    public static final int WNS_CODE_LOGIN_SID_ILLEGAL = 1904;
    public static final int WNS_CODE_SUCCESS = 0;
    public static final int WNS_CODE_WNS_NOT_WORKING = 3000;
    public static final int WNS_UID_ERROR = 3013;
    public static final String DEFAULT_ERROR_MESSAGE = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "WnsErrorMessage", "\u670d\u52a1\u5668\u7e41\u5fd9");
    public static final String DEFAULT_ERROR_MESSAGE_WAIT = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "WnsErrorMessageWait", "\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7b49\u5f85");
    public static final String DEFAULT_SUCCESS_MESSAGE = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "WnsSuccessMessage", "\u6210\u529f");
    public static final String DEFAULT_ERROR_MESSAGE_ILLIGAL_APPID = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "WnsErrorMessageIllegalAppid", "\u975e\u6cd5APPID");

    private static String __getErrorMessage(int i3) {
        if (i3 >= 2400 && i3 < 2499) {
            i3 = 2400;
        }
        if (i3 != 0) {
            if (i3 != 1912) {
                if (i3 != 2400) {
                    switch (i3) {
                        case WNS_CODE_LOGIN_PTLOGIN_BUSY /* 1901 */:
                        case WNS_CODE_LOGIN_3GSVR_BUSY /* 1902 */:
                        case WNS_CODE_LOGIN_A2_ILLEGAL /* 1903 */:
                        case WNS_CODE_LOGIN_SID_ILLEGAL /* 1904 */:
                        case WNS_CODE_LOGIN_SID_EXPIRED /* 1905 */:
                        case WNS_CODE_LOGIN_A2_EXPIRED /* 1906 */:
                        case WNS_CODE_LOGIN_A2_CHANGED /* 1907 */:
                        case WNS_CODE_LOGIN_NOTOKEN /* 1908 */:
                        case WNS_CODE_LOGIN_CREATEUIDFAIL /* 1909 */:
                        case WNS_CODE_LOGIN_B2_EXPIRED /* 1910 */:
                            break;
                        default:
                            return DEFAULT_ERROR_MESSAGE;
                    }
                }
                return DEFAULT_ERROR_MESSAGE_WAIT;
            }
            return DEFAULT_ERROR_MESSAGE_ILLIGAL_APPID;
        }
        return DEFAULT_SUCCESS_MESSAGE;
    }

    public static String getErrorMessage(int i3) {
        return __getErrorMessage(i3) + "  (" + String.valueOf(i3) + ")";
    }
}
