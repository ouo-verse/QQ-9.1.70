package com.tencent.qqmini.sdk.utils;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class MiniSDKConst {
    public static final String APP_ROOT = "/data/data/com.tencent.mobileqq/";
    public static final int AUDIO_ROUTE_EARPIECE = 0;
    public static final int AUDIO_ROUTE_SPEAKER = 1;
    public static final int AUDIT = 2;
    public static final int AUDIT_PASS = 6;
    public static final int AUDIT_REJECT = 7;
    public static final String CONFIG_DEFAULT_BASE_LIB_VERSION = "1.74.3.00001";
    public static final int DELETED = 5;
    public static final int DEVELOP = 0;
    public static final String ENG_LOG_TAG = "[MiniEng]";
    public static final int EXPERIENCE = 1;
    public static final String GPKG_LOG_TAG = "[Gpkg]";
    public static final int GRAY_RELEASE = 8;
    public static final String INNER_JSSDK_ASSETS_PATH = "mini";
    public static final String KEY_BASELIB_LOCAL_URL = "downloadUrl";
    public static final String KEY_BASELIB_LOCAL_VERSION = "version";
    public static final String KEY_BASELIB_MIN_UPDATE_TIME = "baselib_min_update_time";
    public static final String MINI_FILE_LOG_PATH = "/Tencent/mini/files/";
    public static final String MINI_SDK_PATCH_VERSION = "0";
    public static final String MINI_SDK_VERSION = "1.83.3";
    public static final String MINI_TAG = "[mini] ";
    public static final int MULTI_ENTER_ROOM_RESULT_DEVICE_TAKE_UP = -2;
    public static final int MULTI_ENTER_ROOM_RESULT_DUPLICATE_CALL = -3;
    public static final int MULTI_ENTER_ROOM_RESULT_FAIL = -1;
    public static final int MULTI_ENTER_ROOM_RESULT_SUCCESS = 0;
    public static final int MULTI_ERROR_ENTER_ROOM_FAIL = 2;
    public static final int MULTI_ERROR_ENTER_ROOM_TIMEOUT = 1;
    public static final int MULTI_ERROR_INTERRUPT_BY_THIRD_CALL = 4;
    public static final int MULTI_ERROR_NET_ERROR = 3;
    public static final int OFFLINE = 9;
    public static final int ONLINE = 3;
    public static final String ON_APP_LOW_MEMORY = "onMemoryWarning";
    public static final int PREVIEW = 4;
    public static final int START_MODE_APPID = 1;
    public static final int START_MODE_LINK = 2;
    public static final int START_MODE_NORMAL = 0;
    public static final String TAG = "miniapp-start";
    public static final String TAG_CHROMIUM = "miniapp-chromium";
    public static final String TAG_JS = "miniapp-JS";
    public static final String TAG_PROCESSOR = "miniapp-process";
    public static final String TRITON_SDK_VERSION = "3.0.0.486.6d09724f2";
    public static final String URL_UPGRADE = "https://m.q.qq.com/upgrade/{appid}";
    public static final String STR_WXFILE = WnsConfig.getConfig("qqminiapp", "MiniAppFileString", "wxfile://");
    private static String gMiniCacheFilePath = "";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class AdConst {
        public static final HashMap<Integer, String> CODE_MSG_MAP = new HashMap<Integer, String>() { // from class: com.tencent.qqmini.sdk.utils.MiniSDKConst.AdConst.1
            {
                put(1000, AdConst.ERROR_MSG_SERVICE_FAIL);
                put(1001, AdConst.ERROR_MSG_PARAM_ERROR);
                put(1002, AdConst.ERROR_MSG_INVALID_ADUNITID);
                put(1003, AdConst.ERROR_MSG_INNER_ERROR);
                put(1004, AdConst.ERROR_MSG_NO_AD);
                put(1005, AdConst.ERROR_MSG_IN_REVIEW);
                put(1006, AdConst.ERROR_MSG_REJECTED);
                put(1007, AdConst.ERROR_MSG_BANNED);
                put(1008, AdConst.ERROR_MSG_CLOSED);
                put(1009, AdConst.ERROR_MSG_INVALID_POSITION);
            }
        };
        public static final int ERROR_CODE_BANNED = 1007;
        public static final int ERROR_CODE_CLOSED = 1008;
        public static final int ERROR_CODE_INNER_ERROR = 1003;
        public static final int ERROR_CODE_INVALID_ADUNITID = 1002;
        public static final int ERROR_CODE_INVALID_POSITION = 1009;
        public static final int ERROR_CODE_IN_REVIEW = 1005;
        public static final int ERROR_CODE_NO_AD = 1004;
        public static final int ERROR_CODE_PARAM_ERROR = 1001;
        public static final int ERROR_CODE_REJECTED = 1006;
        public static final int ERROR_CODE_SERVICE_FAIL = 1000;
        public static final String ERROR_MSG_BANNED = "\u5e7f\u544a\u7ec4\u4ef6\u88ab\u5c01\u7981";
        public static final String ERROR_MSG_CLOSED = "\u5e7f\u544a\u5355\u5143\u5df2\u5173\u95ed";
        public static final String ERROR_MSG_INNER_ERROR = "\u5185\u90e8\u9519\u8bef";
        public static final String ERROR_MSG_INVALID_ADUNITID = "\u5e7f\u544a\u5355\u5143\u65e0\u6548";
        public static final String ERROR_MSG_INVALID_POSITION = "\u5e7f\u544a\u4f4d\u7f6e\u8bbe\u7f6e\u6709\u8bef";
        public static final String ERROR_MSG_IN_REVIEW = "\u5e7f\u544a\u7ec4\u4ef6\u5ba1\u6838\u4e2d";
        public static final String ERROR_MSG_NO_AD = "\u65e0\u5408\u9002\u7684\u5e7f\u544a";
        public static final String ERROR_MSG_PARAM_ERROR = "\u53c2\u6570\u9519\u8bef";
        public static final String ERROR_MSG_REJECTED = "\u5e7f\u544a\u7ec4\u4ef6\u88ab\u9a73\u56de";
        public static final String ERROR_MSG_SERVICE_FAIL = "\u540e\u7aef\u63a5\u53e3\u8c03\u7528\u5931\u8d25";
        public static final int KERRADBLOCKED = -100100009;
        public static final int KERRADDELETED = -100100002;
        public static final int KERRADGDTNODATA = -100100008;
        public static final int KERRADNOTFOUND = -100100007;
        public static final int KERRADPOSITIONEXTISNIL = -100100005;
        public static final int KERRADPOSITIONISNIL = -100100004;
        public static final int KERRADSHUTDOWN = -100100001;
        public static final int KERRADSTATUSUNKOWN = -100100003;
        public static final int KERRAPPNOTFOUND = -100100006;

        public static int getRetCodeByServerResult(int i3) {
            if (i3 >= -100101009 && i3 <= -100101000) {
                return 1000;
            }
            switch (i3) {
                case -100100009:
                    return 1007;
                case -100100008:
                    return 1004;
                case -100100007:
                case -100100004:
                case -100100003:
                    return 1002;
                case -100100006:
                case -100100005:
                    return 1001;
                case -100100002:
                case -100100001:
                    return 1008;
                default:
                    return -1;
            }
        }
    }

    private static String getExternalPath() {
        File file;
        try {
            file = AppLoaderFactory.g().getContext().getExternalCacheDir();
        } catch (Throwable unused) {
            file = null;
        }
        if (file != null) {
            QMLog.e("MiniSDKConst", "getExternalPath : " + file.getParent());
            return file.getParent();
        }
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return null;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            QMLog.e("MiniSDKConst", "getExternalPath1 : " + externalStorageDirectory.getPath() + "/Android/data/com.tencent.mobileqq/");
            return externalStorageDirectory.getPath() + "/Android/data/com.tencent.mobileqq/";
        }
        File filesDir = AppLoaderFactory.g().getContext().getFilesDir();
        if (filesDir != null) {
            QMLog.e("MiniAppGlobal", "getExternalPath2 : " + filesDir.getParent());
            return filesDir.getParent();
        }
        QMLog.e("MiniAppGlobal", "getExternalPath3 : /data/data/com.tencent.mobileqq/");
        return "/data/data/com.tencent.mobileqq/";
    }

    public static String getMiniCacheFilePath() {
        if (TextUtils.isEmpty(gMiniCacheFilePath)) {
            gMiniCacheFilePath = getExternalPath() + "/Tencent/mini/files/";
        }
        return gMiniCacheFilePath;
    }
}
