package com.tencent.superplayer.utils;

import com.tencent.superplayer.api.SuperPlayerSDKMgr;

/* compiled from: P */
/* loaded from: classes26.dex */
public class LogUtil {
    public static final String TAG = "SuperPlayer-";

    public static void d(String str, String str2) {
        if (SuperPlayerSDKMgr.getLogListener() != null) {
            SuperPlayerSDKMgr.getLogListener().d(TAG + str, str2);
        }
    }

    public static void e(String str, Throwable th5) {
        if (SuperPlayerSDKMgr.getLogListener() != null) {
            String message = th5.getMessage();
            if (message == null) {
                message = "";
            }
            SuperPlayerSDKMgr.getLogListener().e(TAG + str, message);
        }
    }

    public static void i(String str, String str2) {
        if (SuperPlayerSDKMgr.getLogListener() != null) {
            SuperPlayerSDKMgr.getLogListener().i(TAG + str, str2);
        }
    }

    public static void v(String str, String str2) {
        if (SuperPlayerSDKMgr.getLogListener() != null) {
            SuperPlayerSDKMgr.getLogListener().v(TAG + str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (SuperPlayerSDKMgr.getLogListener() != null) {
            SuperPlayerSDKMgr.getLogListener().w(TAG + str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (SuperPlayerSDKMgr.getLogListener() != null) {
            SuperPlayerSDKMgr.getLogListener().e(TAG + str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        if (SuperPlayerSDKMgr.getLogListener() != null) {
            SuperPlayerSDKMgr.getLogListener().e(str, str2 + " ," + th5.getLocalizedMessage());
        }
    }
}
