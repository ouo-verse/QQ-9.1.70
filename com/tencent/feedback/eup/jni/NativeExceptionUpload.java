package com.tencent.feedback.eup.jni;

import com.tencent.bugly.proguard.av;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NativeExceptionUpload {
    static IPatchRedirector $redirector_ = null;
    public static final int ANDROID_LOG_DEBUG = 3;
    public static final int ANDROID_LOG_ERROR = 6;
    public static final int ANDROID_LOG_INFO = 4;
    public static final int ANDROID_LOG_WARN = 5;
    private static final String EXTRA_JNI_NATIVE_VERSION = "nativeRqd.2.1.0";
    public static final int JAR_JNI_VERSION = 1;
    protected static NativeExceptionHandler instance;
    public static AtomicBoolean isEnable;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20469);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            isEnable = new AtomicBoolean(true);
            instance = null;
        }
    }

    public NativeExceptionUpload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native boolean appendNativeLog(String str, String str2, String str3);

    public static native boolean appendWholeNativeLog(String str);

    public static boolean checkExtraJni(String str) {
        av.c("Check extra jni for RQD NDK: %s", str);
        String replace = EXTRA_JNI_NATIVE_VERSION.replace("nativeRqd.", "").replace(".", "");
        String replace2 = str.replace("nativeRqd.", "").replace(".", "");
        if (replace2.length() == 2) {
            replace2 = replace2 + "0";
        } else if (replace2.length() == 1) {
            replace2 = replace2 + "00";
        }
        try {
            if (Integer.parseInt(replace2) >= Integer.parseInt(replace)) {
                av.a("Extra RQD JNI can be accessed.", new Object[0]);
                return true;
            }
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
        }
        av.d("Extra RQD JNI can not be accessed.", new Object[0]);
        return false;
    }

    public static native void doNativeCrashForTest();

    public static native void enableHandler(boolean z16);

    public static native String getNativeKeyValueList();

    public static native String getNativeLog();

    public static synchronized NativeExceptionHandler getmHandler() {
        NativeExceptionHandler nativeExceptionHandler;
        synchronized (NativeExceptionUpload.class) {
            nativeExceptionHandler = instance;
        }
        return nativeExceptionHandler;
    }

    public static native boolean putNativeKeyValue(String str, String str2);

    public static native boolean registNativeExceptionHandler(String str, String str2, int i3);

    public static native String registNativeExceptionHandler2(String str, String str2, int i3, int i16);

    public static native String removeNativeKeyValue(String str);

    public static native void setLogMode(int i3);

    public static synchronized void setmHandler(NativeExceptionHandler nativeExceptionHandler) {
        synchronized (NativeExceptionUpload.class) {
            instance = nativeExceptionHandler;
        }
    }

    public static void testNativeCrash() {
        av.a("rqdp{ test native crash}", new Object[0]);
        doNativeCrashForTest();
    }
}
