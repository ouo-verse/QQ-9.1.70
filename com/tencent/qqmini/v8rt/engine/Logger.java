package com.tencent.qqmini.v8rt.engine;

import android.util.Log;
import com.tencent.qqmini.v8rt.anno.CallByNative;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Logger {
    private static ILog sDefLog = new ILog() { // from class: com.tencent.qqmini.v8rt.engine.Logger.1
        public static final String TAG = "TV8RT";

        @Override // com.tencent.qqmini.v8rt.engine.ILog
        public int d(String str, String str2) {
            return Log.d("TV8RT/" + str, str2);
        }

        @Override // com.tencent.qqmini.v8rt.engine.ILog
        public int e(String str, String str2) {
            return Log.e("TV8RT/" + str, str2);
        }

        @Override // com.tencent.qqmini.v8rt.engine.ILog
        public int i(String str, String str2) {
            return Log.i("TV8RT/" + str, str2);
        }

        @Override // com.tencent.qqmini.v8rt.engine.ILog
        public void printNativeLog(int i3, String str, String str2) {
            String str3 = "TV8RT/" + str;
            if (i3 >= 100) {
                i3 = (i3 - 100) + 3;
            }
            if (i3 <= 3) {
                Log.d(str3, str2);
                return;
            }
            if (i3 == 4) {
                Log.i(str3, str2);
            } else if (i3 == 5) {
                Log.w(str3, str2);
            } else if (i3 == 6) {
                Log.e(str3, str2);
            }
        }

        @Override // com.tencent.qqmini.v8rt.engine.ILog
        public int w(String str, String str2) {
            return Log.w("TV8RT/" + str, str2);
        }

        @Override // com.tencent.qqmini.v8rt.engine.ILog
        public int d(String str, String str2, Throwable th5) {
            return Log.d("TV8RT/" + str, str2, th5);
        }

        @Override // com.tencent.qqmini.v8rt.engine.ILog
        public int e(String str, String str2, Throwable th5) {
            return Log.e("TV8RT/" + str, str2, th5);
        }

        @Override // com.tencent.qqmini.v8rt.engine.ILog
        public int i(String str, String str2, Throwable th5) {
            return Log.i("TV8RT/" + str, str2, th5);
        }

        @Override // com.tencent.qqmini.v8rt.engine.ILog
        public int w(String str, String str2, Throwable th5) {
            return Log.w("TV8RT/" + str, str2, th5);
        }
    };
    private static ILog sLogProxy;

    public static int d(String str, String str2) {
        return getLog().d(str, str2);
    }

    public static int e(String str, String str2) {
        return getLog().e(str, str2);
    }

    public static ILog getLog() {
        ILog iLog = sLogProxy;
        if (iLog == null) {
            return sDefLog;
        }
        return iLog;
    }

    public static int i(String str, String str2) {
        return getLog().i(str, str2);
    }

    public static void init(ILog iLog) {
        sLogProxy = iLog;
    }

    @CallByNative
    public static void printNativeLog(int i3, byte[] bArr, byte[] bArr2) {
        getLog().printNativeLog(i3, new String(bArr), new String(bArr2));
    }

    public static int w(String str, String str2) {
        return getLog().w(str, str2);
    }

    public static int d(String str, String str2, Throwable th5) {
        return getLog().d(str, str2, th5);
    }

    public static int e(String str, String str2, Throwable th5) {
        return getLog().e(str, str2, th5);
    }

    public static int i(String str, String str2, Throwable th5) {
        return getLog().i(str, str2, th5);
    }

    public static int w(String str, String str2, Throwable th5) {
        return getLog().w(str, str2, th5);
    }
}
