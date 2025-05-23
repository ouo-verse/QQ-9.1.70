package com.tencent.qqmini.sdk.launcher;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgManager;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import java.io.File;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class MiniSDKConst {
    public static final String ACTION_AUDIO_MUTE = "action.qq.miniapp.audio.mute";
    public static final String ACTION_PRELAUNCH_APP = "mini_prelaunch_app";
    public static final String ACTION_PRELOAD_APP = "mini_preload_app";
    public static final String ACTION_PRELOAD_GAME = "mini_preload_game";
    public static final int AUDIT = 2;
    public static final int AUDIT_PASS = 6;
    public static final int AUDIT_REJECT = 7;
    public static final String BASE_LIB_PATH_DIR;
    public static final String CONFIG_DEFAULT_BASE_LIB_VERSION = "1.74.3.00001";
    public static final int DELETED = 5;
    public static final int DEVELOP = 0;
    public static final int DO_USE_SDK = 1;
    public static final String ENG_LOG_TAG = "[MiniEng]";
    public static final int EXPERIENCE = 1;
    public static final int GRAY_RELEASE = 8;
    public static final String KEY_BASELIB_LOCAL_URL = "downloadUrl";
    public static final String KEY_BASELIB_LOCAL_VERSION = "version";
    public static final String KEY_USE_SDK = "usersdk";
    public static final String LIB_SCRIPTX = "libscriptx.so";
    public static final String LIB_V8RT = "libtv8rt.so";
    public static final int MESSENGER_CMD_NOTIFY_LETS_GO_RES_DOWNLOAD_UPDATE = 1004;
    public static final int MESSENGER_CMD_NOTIFY_PERIODIC_CACHE_UPDATE = 1002;
    public static final int MESSENGER_CMD_NOTIFY_SHARE_RESULT = 1001;
    public static final int MESSENGER_CMD_NOTIFY_VA_DOWNLOAD_UPDATE = 1003;
    public static final String MESSENGER_KEY_NOTIFY_SHARE_CALLBACK_ID = "messenger_key_notify_share_callback_id";
    public static final String MESSENGER_KEY_NOTIFY_SHARE_EVENT = "messenger_key_notify_share_event";
    public static final String MESSENGER_KEY_NOTIFY_SUBSCRIBE_EVENT = "messenger_key_notify_subscribe_event";
    public static final String MINI_KEY_IS_MUTE = "isMute";
    public static final String NOTIFY_EVENT_ONPAUSE = "onPause";
    public static final String NOTIFY_EVENT_ONRESUME = "onResume";
    public static final int NOT_USE_SDK = 0;
    public static final int OFFLINE = 9;
    public static final int ONLINE = 3;
    public static final String PATH_WXAPKG_ROOT;
    public static final int PREVIEW = 4;
    public static final String SDK_CONF = "sdk_conf";
    public static final int START_MODE_APPID = 1;
    public static final int START_MODE_LINK = 2;
    public static final int START_MODE_NORMAL = 0;
    public static final String SUB_VER_ONLINE = "0";
    public static final String SUB_VER_PREVIEW = "1";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class PayMode {
        public static final int MIDAS_H5 = 2;
        public static final int MIDAS_NATIVE = 1;
    }

    static {
        String str = AppLoaderFactory.g().getContext().getFilesDir().getPath() + "/mini/";
        PATH_WXAPKG_ROOT = str;
        BASE_LIB_PATH_DIR = str + ".baseLib";
    }

    public static String getAppBaseLibDir(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                try {
                    str3 = MD5Utils.toMD5(str);
                } catch (Throwable unused) {
                    str3 = "";
                }
            } catch (Throwable unused2) {
                str3 = MD5Utils.encodeHexStr(str);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(BASE_LIB_PATH_DIR);
            String str4 = File.separator;
            sb5.append(str4);
            sb5.append(str3);
            sb5.append("_");
            sb5.append(str2);
            sb5.append(str4);
            return sb5.toString();
        }
        return null;
    }

    public static String getMiniAppV8rtPath() {
        return ApkgManager.RootPath.getRoot() + "/miniapptv8rt/" + LIB_V8RT;
    }

    public static String getQQAppBaseLibDir(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                try {
                    str3 = MD5Utils.toMD5(str);
                } catch (Throwable unused) {
                    str3 = "";
                }
            } catch (Throwable unused2) {
                str3 = MD5Utils.encodeHexStr(str);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(BASE_LIB_PATH_DIR);
            String str4 = File.separator;
            sb5.append(str4);
            sb5.append(str3);
            sb5.append("_");
            sb5.append(str2);
            sb5.append(str4);
            return sb5.toString();
        }
        return null;
    }

    public static String getScriptXPath() {
        return ApkgManager.RootPath.getRoot() + "/miniappscriptx/" + LIB_SCRIPTX;
    }
}
