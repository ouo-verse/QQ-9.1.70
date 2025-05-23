package com.tencent.upload.utils;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadLog {
    static IPatchRedirector $redirector_ = null;
    public static final boolean ABSTRACT_ROUTE_STRATEGY_FLAG = true;
    public static final boolean DOMAIN_NAME_PARSER_FLAG = true;
    public static final boolean NATIVE_CONNECTION_FLAG = true;
    public static final boolean RECENT_ROUTE_SET_STORAGE_FLAG = true;
    public static final boolean SESSION_LOG_ENABLE = true;
    public static final boolean TASK_LOG_ENABLE = true;
    public static final boolean UPLOAD_CONFIGURATION_FLAG = true;
    public static final String UPLOAD_TAG_PREFIX = "[upload2] ";

    public UploadLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, String str2) {
        IUploadLog uploadLog = UploadGlobalConfig.getUploadLog();
        if (uploadLog == null) {
            Log.d(UPLOAD_TAG_PREFIX + str, str2);
            return;
        }
        uploadLog.d(UPLOAD_TAG_PREFIX + str, str2);
    }

    public static void e(String str, String str2) {
        IUploadLog uploadLog = UploadGlobalConfig.getUploadLog();
        if (uploadLog == null) {
            Log.e(UPLOAD_TAG_PREFIX + str, str2);
            return;
        }
        uploadLog.e(UPLOAD_TAG_PREFIX + str, str2);
    }

    public static void i(String str, String str2) {
        IUploadLog uploadLog = UploadGlobalConfig.getUploadLog();
        if (uploadLog == null) {
            Log.i(UPLOAD_TAG_PREFIX + str, str2);
            return;
        }
        uploadLog.i(UPLOAD_TAG_PREFIX + str, str2);
    }

    public static void v(String str, String str2) {
        IUploadLog uploadLog = UploadGlobalConfig.getUploadLog();
        if (uploadLog == null) {
            Log.v(UPLOAD_TAG_PREFIX + str, str2);
            return;
        }
        uploadLog.v(UPLOAD_TAG_PREFIX + str, str2);
    }

    public static void w(String str, String str2) {
        IUploadLog uploadLog = UploadGlobalConfig.getUploadLog();
        if (uploadLog == null) {
            Log.w(UPLOAD_TAG_PREFIX + str, str2);
            return;
        }
        uploadLog.w(UPLOAD_TAG_PREFIX + str, str2);
    }

    public static void d(String str, String str2, Throwable th5) {
        IUploadLog uploadLog = UploadGlobalConfig.getUploadLog();
        if (uploadLog == null) {
            Log.d(UPLOAD_TAG_PREFIX + str, str2, th5);
            return;
        }
        uploadLog.d(UPLOAD_TAG_PREFIX + str, str2, th5);
    }

    public static void e(String str, String str2, Throwable th5) {
        IUploadLog uploadLog = UploadGlobalConfig.getUploadLog();
        if (uploadLog == null) {
            Log.e(UPLOAD_TAG_PREFIX + str, str2, th5);
            return;
        }
        uploadLog.e(UPLOAD_TAG_PREFIX + str, str2, th5);
    }

    public static void i(String str, String str2, Throwable th5) {
        IUploadLog uploadLog = UploadGlobalConfig.getUploadLog();
        if (uploadLog == null) {
            Log.i(UPLOAD_TAG_PREFIX + str, str2, th5);
            return;
        }
        uploadLog.i(UPLOAD_TAG_PREFIX + str, str2, th5);
    }

    public static void v(String str, String str2, Throwable th5) {
        IUploadLog uploadLog = UploadGlobalConfig.getUploadLog();
        if (uploadLog == null) {
            Log.v(UPLOAD_TAG_PREFIX + str, str2, th5);
            return;
        }
        uploadLog.v(UPLOAD_TAG_PREFIX + str, str2, th5);
    }

    public static void w(String str, Throwable th5) {
        IUploadLog uploadLog = UploadGlobalConfig.getUploadLog();
        if (uploadLog == null) {
            Log.w(UPLOAD_TAG_PREFIX + str, th5);
            return;
        }
        uploadLog.w(UPLOAD_TAG_PREFIX + str, th5);
    }

    public static void w(String str, String str2, Throwable th5) {
        IUploadLog uploadLog = UploadGlobalConfig.getUploadLog();
        if (uploadLog == null) {
            Log.w(UPLOAD_TAG_PREFIX + str, str2, th5);
            return;
        }
        uploadLog.w(UPLOAD_TAG_PREFIX + str, str2, th5);
    }
}
