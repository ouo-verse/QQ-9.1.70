package com.tencent.thumbplayer.core.codec.tmediacodec.util;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class LogUtils {
    private static final String GLOBAL_TAG = "TMediaCodec";
    private static final String TAG = "LogUtils";
    private static ILogProxy mLogProxy = new ILogProxy() { // from class: com.tencent.thumbplayer.core.codec.tmediacodec.util.LogUtils.1
        @Override // com.tencent.thumbplayer.core.codec.tmediacodec.util.ILogProxy
        public void d(@NonNull String str, @NonNull String str2) {
            Log.d(str, str2);
        }

        @Override // com.tencent.thumbplayer.core.codec.tmediacodec.util.ILogProxy
        public void e(@NonNull String str, @NonNull String str2, @Nullable Throwable th5) {
            Log.e(str, str2, th5);
        }

        @Override // com.tencent.thumbplayer.core.codec.tmediacodec.util.ILogProxy
        public void i(@NonNull String str, @NonNull String str2) {
            Log.i(str, str2);
        }

        @Override // com.tencent.thumbplayer.core.codec.tmediacodec.util.ILogProxy
        public void v(@NonNull String str, @NonNull String str2) {
            Log.v(str, str2);
        }

        @Override // com.tencent.thumbplayer.core.codec.tmediacodec.util.ILogProxy
        public void w(@NonNull String str, @NonNull String str2, @Nullable Throwable th5) {
            Log.w(str, str2, th5);
        }
    };
    private static boolean sLogEnable = true;
    private static int sLogLevel = 2;

    public static void d(@NonNull String str, @NonNull String str2) {
        if (isEnableLog(3)) {
            mLogProxy.d("TMediaCodec." + str, str2);
        }
    }

    public static void e(@NonNull String str, @NonNull String str2) {
        if (isEnableLog(6)) {
            mLogProxy.e("TMediaCodec." + str, str2, null);
        }
    }

    public static void i(@NonNull String str, @NonNull String str2) {
        if (isEnableLog(4)) {
            mLogProxy.i("TMediaCodec." + str, str2);
        }
    }

    public static boolean isEnableLog(int i3) {
        if (sLogEnable && i3 >= sLogLevel) {
            return true;
        }
        return false;
    }

    public static boolean isLogEnable() {
        return sLogEnable;
    }

    public static void setLogEnable(boolean z16) {
        sLogEnable = z16;
    }

    public static void setLogLevel(int i3) {
        sLogLevel = i3;
        Log.i("TMediaCodec.LogUtils", "set LogLevel:" + i3);
    }

    public static void setLogProxy(@NonNull ILogProxy iLogProxy) {
        mLogProxy = iLogProxy;
    }

    public static void v(@NonNull String str, @NonNull String str2) {
        if (isEnableLog(2)) {
            mLogProxy.v("TMediaCodec." + str, str2);
        }
    }

    public static void w(@NonNull String str, @NonNull String str2) {
        if (isEnableLog(5)) {
            mLogProxy.w("TMediaCodec." + str, str2, null);
        }
    }

    public static void e(@NonNull String str, @NonNull String str2, @Nullable Throwable th5) {
        if (isEnableLog(6)) {
            mLogProxy.e("TMediaCodec." + str, str2, th5);
        }
    }

    public static void w(@NonNull String str, @NonNull String str2, @Nullable Throwable th5) {
        if (isEnableLog(5)) {
            mLogProxy.w("TMediaCodec." + str, str2, th5);
        }
    }
}
