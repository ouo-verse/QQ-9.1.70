package com.tencent.mobileqq.mini.utils;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGlobal {
    public static final String APP_ROOT = "/data/data/com.tencent.mobileqq/";
    public static final String CONFIG_DEFAULT_BASE_LIB_VERSION = "1.74.3.00001";
    public static final String DEFAULT_APPID_WHITE_LIST = "1108291530,1108164955,1108961705,1109048181";
    public static final String DEFAULT_OUTSITE_BLACK_LIST = "";
    public static final String INNER_JSSDK_ASSETS_PATH = "mini";
    public static final String MINI_FILE_LOG_PATH = "/Tencent/mini/files/";
    public static final int MSG_WHAT_APKG_FAIL = 315;
    public static final int MSG_WHAT_APKG_SUCC = 316;
    public static final int MSG_WHAT_APP_EVENT_APPROUTE_DONE = 317;
    public static final int MSG_WHAT_APP_EVEN_JSCORE_INIT_FINISH = 320;
    public static final int MSG_WHAT_APP_LOAD_TIMEOUT = 318;
    public static final int MSG_WHAT_APP_WEBVIEW_STARTED = 319;
    public static final int MSG_WHAT_BASE = 300;
    public static final int MSG_WHAT_BASELIB_LOAD_COMPLETED = 321;
    public static final int MSG_WHAT_BASELIB_LOAD_FAIL = 310;
    public static final int MSG_WHAT_BASELIB_LOAD_SUCC = 311;
    public static final int MSG_WHAT_SERVICE_INIT_TIMEOUT = 322;
    public static final int MSG_WHAT_X5_DOWNLOAD_FAIL = 302;
    public static final int MSG_WHAT_X5_DOWNLOAD_PROGRESS = 303;
    public static final int MSG_WHAT_X5_DOWNLOAD_SUCC = 301;
    public static final int MSG_WHAT_X5_INSTALL_FAIL = 305;
    public static final int MSG_WHAT_X5_INSTALL_SUCC = 304;
    public static final int MSG_WHAT_X5_TIMEOUT = 306;
    public static final String URL_UPGRADE = "https://m.q.qq.com/upgrade/{appid}";
    public static final String STR_WXFILE = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppFileString", "wxfile://");
    public static final String CAPSULE_CLOSE_URL = QzoneConfig.getInstance().getConfig("qqminiapp", "closebutton", (String) null);
    public static final String CAPSULE_CLOSE_DARK_URL = QzoneConfig.getInstance().getConfig("qqminiapp", "closebuttondark", (String) null);
    public static final String KINGCARD_GUIDE_TEXT = QzoneConfig.getInstance().getConfig("qqminiapp", "kingcardGuideText", "");
    public static final String KINGCARD_GUIDE_ICON = QzoneConfig.getInstance().getConfig("qqminiapp", "kingcardGuideIcon", "");
    public static final String KINGCARD_GUIDE_DARK_LOTTIE = QzoneConfig.getInstance().getConfig("qqminiapp", "kingcardGuideDarkLottie", "https://d3g.qq.com/sngapp/app/update/20191105162320_6114/kingCardDark.zip");
    public static final String KINGCARD_GUIDE_LOTTIE = QzoneConfig.getInstance().getConfig("qqminiapp", "kingcardGuideLottie", "https://d3g.qq.com/sngapp/app/update/20191105163020_3367/kingCard.zip");
    private static String gMiniCacheFilePath = "";

    public static String getMiniCacheFilePath() {
        if (TextUtils.isEmpty(gMiniCacheFilePath)) {
            gMiniCacheFilePath = getExternalPath() + "/Tencent/mini/files/";
        }
        return gMiniCacheFilePath;
    }

    private static String getExternalPath() {
        File file;
        try {
            file = BaseApplication.getContext().getExternalCacheDir();
        } catch (Throwable unused) {
            file = null;
        }
        if (file != null) {
            QLog.e("MiniAppGlobal", 1, "getExternalPath : " + file.getParent());
            return file.getParent();
        }
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return null;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            QLog.e("MiniAppGlobal", 1, "getExternalPath1 : " + externalStorageDirectory.getPath() + "/Android/data/com.tencent.mobileqq/");
            return externalStorageDirectory.getPath() + "/Android/data/com.tencent.mobileqq/";
        }
        File filesDir = BaseApplicationImpl.getApplication().getFilesDir();
        if (filesDir != null) {
            QLog.e("MiniAppGlobal", 1, "getExternalPath2 : " + filesDir.getParent());
            return filesDir.getParent();
        }
        QLog.e("MiniAppGlobal", 1, "getExternalPath3 : /data/data/com.tencent.mobileqq/");
        return "/data/data/com.tencent.mobileqq/";
    }
}
