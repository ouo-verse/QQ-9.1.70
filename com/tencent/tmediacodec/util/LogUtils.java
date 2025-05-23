package com.tencent.tmediacodec.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class LogUtils {
    static IPatchRedirector $redirector_;
    private static String GLOBAL_TAG;
    private static String TAG;
    private static boolean mLogEnable;
    private static int mLogLevel;
    private static ILogProxy mLogProxy;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61728);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TAG = "LogUtils";
        GLOBAL_TAG = "TMediaCodec";
        mLogLevel = 2;
        mLogEnable = true;
        mLogProxy = new ILogProxy() { // from class: com.tencent.tmediacodec.util.LogUtils.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.tmediacodec.util.ILogProxy
            public void d(@NonNull String str, @NonNull String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
                } else {
                    Log.d(str, str2);
                }
            }

            @Override // com.tencent.tmediacodec.util.ILogProxy
            public void e(@NonNull String str, @NonNull String str2, @Nullable Throwable th5) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, this, str, str2, th5);
                } else {
                    Log.e(str, str2, th5);
                }
            }

            @Override // com.tencent.tmediacodec.util.ILogProxy
            public void i(@NonNull String str, @NonNull String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
                } else {
                    Log.i(str, str2);
                }
            }

            @Override // com.tencent.tmediacodec.util.ILogProxy
            public void v(@NonNull String str, @NonNull String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
                } else {
                    Log.v(str, str2);
                }
            }

            @Override // com.tencent.tmediacodec.util.ILogProxy
            public void w(@NonNull String str, @NonNull String str2, @Nullable Throwable th5) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, this, str, str2, th5);
                } else {
                    Log.w(str, str2, th5);
                }
            }
        };
    }

    public LogUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(@NonNull String str, @NonNull String str2) {
        if (isEnableLog(3)) {
            mLogProxy.d(GLOBAL_TAG + "." + str, str2);
        }
    }

    public static void e(@NonNull String str, @NonNull String str2) {
        if (isEnableLog(6)) {
            mLogProxy.e(GLOBAL_TAG + "." + str, str2, null);
        }
    }

    public static void i(@NonNull String str, @NonNull String str2) {
        if (isEnableLog(4)) {
            mLogProxy.i(GLOBAL_TAG + "." + str, str2);
        }
    }

    public static boolean isEnableLog(int i3) {
        if (mLogEnable && i3 >= mLogLevel) {
            return true;
        }
        return false;
    }

    public static boolean isLogEnable() {
        return mLogEnable;
    }

    public static void setLogEnable(boolean z16) {
        mLogEnable = z16;
    }

    public static void setLogLevel(int i3) {
        mLogLevel = i3;
        Log.i(GLOBAL_TAG + ".LogUtils", "set LogLevel:" + i3);
    }

    public static void setLogProxy(@NonNull ILogProxy iLogProxy) {
        mLogProxy = iLogProxy;
    }

    public static void v(@NonNull String str, @NonNull String str2) {
        if (isEnableLog(2)) {
            mLogProxy.v(GLOBAL_TAG + "." + str, str2);
        }
    }

    public static void w(@NonNull String str, @NonNull String str2) {
        if (isEnableLog(5)) {
            mLogProxy.w(GLOBAL_TAG + "." + str, str2, null);
        }
    }

    public static void e(@NonNull String str, @NonNull String str2, @Nullable Throwable th5) {
        if (isEnableLog(6)) {
            mLogProxy.e(GLOBAL_TAG + "." + str, str2, th5);
        }
    }

    public static void w(@NonNull String str, @NonNull String str2, @Nullable Throwable th5) {
        if (isEnableLog(5)) {
            mLogProxy.w(GLOBAL_TAG + "." + str, str2, th5);
        }
    }
}
