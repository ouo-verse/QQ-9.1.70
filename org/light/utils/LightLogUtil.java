package org.light.utils;

import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightLogUtil {
    private static final String TAG = "LightLogUtil";
    private static ILightLogger mLogger;
    private static int minPriority;

    public static void d(String str, String str2) {
        if (3 < minPriority) {
            return;
        }
        ILightLogger iLightLogger = mLogger;
        if (iLightLogger == null) {
            Log.d(str, str2);
        } else {
            iLightLogger.log(3, str, str2);
        }
    }

    public static void destroy() {
        nativeDestroy();
    }

    public static void e(String str, String str2) {
        if (6 < minPriority) {
            return;
        }
        ILightLogger iLightLogger = mLogger;
        if (iLightLogger == null) {
            Log.e(str, str2);
        } else {
            iLightLogger.log(6, str, str2);
        }
    }

    public static String getString(ByteBuffer byteBuffer) {
        try {
            return Charset.forName("UTF-8").decode(byteBuffer.asReadOnlyBuffer()).toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static void i(String str, String str2) {
        if (4 < minPriority) {
            return;
        }
        ILightLogger iLightLogger = mLogger;
        if (iLightLogger == null) {
            Log.i(str, str2);
        } else {
            iLightLogger.log(4, str, str2);
        }
    }

    public static void init(ILightLogger iLightLogger) {
        setLightLogger(iLightLogger);
        init();
    }

    private static native void nativeDestroy();

    private static native void nativeInit();

    private static native void nativeSetMinPriority(int i3);

    public static void setLightLogger(ILightLogger iLightLogger) {
        mLogger = iLightLogger;
    }

    public static void setLogInfo(int i3, ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        String str = new String(bArr);
        int indexOf = str.indexOf(":");
        if (indexOf == -1) {
            return;
        }
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + 1);
        if (i3 < minPriority) {
            return;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 == 6) {
                            e(substring, substring2);
                            return;
                        }
                        return;
                    }
                    w(substring, substring2);
                    return;
                }
                i(substring, substring2);
                return;
            }
            d(substring, substring2);
            return;
        }
        v(substring, substring2);
    }

    public static void setMinPriority(int i3) {
        minPriority = i3;
        nativeSetMinPriority(i3);
    }

    public static void v(String str, String str2) {
        if (2 < minPriority) {
            return;
        }
        ILightLogger iLightLogger = mLogger;
        if (iLightLogger == null) {
            Log.v(str, str2);
        } else {
            iLightLogger.log(2, str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (5 < minPriority) {
            return;
        }
        ILightLogger iLightLogger = mLogger;
        if (iLightLogger == null) {
            Log.w(str, str2);
        } else {
            iLightLogger.log(5, str, str2);
        }
    }

    public static void init() {
        nativeInit();
    }

    public static void d(String str, String str2, Throwable th5) {
        if (3 < minPriority) {
            return;
        }
        ILightLogger iLightLogger = mLogger;
        if (iLightLogger == null) {
            Log.d(str, str2, th5);
        } else {
            iLightLogger.log(3, str, str2, th5);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        if (6 < minPriority) {
            return;
        }
        ILightLogger iLightLogger = mLogger;
        if (iLightLogger == null) {
            Log.e(str, str2, th5);
        } else {
            iLightLogger.log(6, str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th5) {
        if (4 < minPriority) {
            return;
        }
        ILightLogger iLightLogger = mLogger;
        if (iLightLogger == null) {
            Log.i(str, str2, th5);
        } else {
            iLightLogger.log(4, str, str2, th5);
        }
    }

    public static void v(String str, String str2, Throwable th5) {
        if (2 < minPriority) {
            return;
        }
        ILightLogger iLightLogger = mLogger;
        if (iLightLogger == null) {
            Log.v(str, str2, th5);
        } else {
            iLightLogger.log(2, str, str2, th5);
        }
    }

    public static void w(String str, String str2, Throwable th5) {
        if (5 < minPriority) {
            return;
        }
        ILightLogger iLightLogger = mLogger;
        if (iLightLogger == null) {
            Log.w(str, str2, th5);
        } else {
            iLightLogger.log(5, str, str2, th5);
        }
    }

    public static void e(Throwable th5) {
        th5.printStackTrace();
    }
}
