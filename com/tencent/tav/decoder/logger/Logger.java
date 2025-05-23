package com.tencent.tav.decoder.logger;

import android.util.Log;
import com.tencent.tav.coremedia.Logger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes26.dex */
public class Logger {
    public static final int NO_LOG = Integer.MAX_VALUE;
    private static int level = 4;
    private static ILog logProxy = new DefaultLogProxy();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class DefaultLogProxy implements ILog {
        private static final String TAG = "TavCut-";

        DefaultLogProxy() {
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void d(String str, String str2) {
            Log.d(TAG + str, str2);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void e(String str, String str2) {
            Log.e(TAG + str, str2);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void i(String str, String str2) {
            Log.i(TAG + str, str2);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void v(String str, String str2) {
            Log.v(TAG + str, str2);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void w(String str, String str2) {
            Log.w(TAG + str, str2);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void e(String str, String str2, Throwable th5) {
            Log.e(TAG + str, str2, th5);
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface LogLevel {
    }

    static {
        com.tencent.tav.coremedia.Logger.setProxy(new Logger.ILoggerProxy() { // from class: com.tencent.tav.decoder.logger.Logger.1
            @Override // com.tencent.tav.coremedia.Logger.ILoggerProxy
            public void e(String str, String str2, Exception exc) {
                Logger.e(str, str2, exc);
            }
        });
    }

    public static void d(String str, String str2) {
        ILog iLog = logProxy;
        if (iLog != null && level <= 3) {
            iLog.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        ILog iLog = logProxy;
        if (iLog == null || level > 6) {
            return;
        }
        iLog.e(str, str2);
    }

    public static void i(String str, String str2) {
        ILog iLog = logProxy;
        if (iLog != null && level <= 4) {
            iLog.i(str, str2);
        }
    }

    public static void setLevel(int i3) {
        level = i3;
    }

    public static void setLogProxy(ILog iLog) {
        logProxy = iLog;
    }

    public static void v(String str, String str2) {
        ILog iLog = logProxy;
        if (iLog != null && level <= 2) {
            iLog.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        ILog iLog = logProxy;
        if (iLog != null && level <= 5) {
            iLog.w(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        ILog iLog = logProxy;
        if (iLog == null || level > 6) {
            return;
        }
        iLog.e(str, str2, th5);
    }
}
