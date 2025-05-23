package com.tencent.midas.comm.log.internal;

import android.util.Log;
import com.tencent.midas.comm.APLogInfo;
import java.util.Locale;

/* loaded from: classes9.dex */
public class APLogger {
    public static final int LOG_LEVEL_DEBUG = 2;
    public static final int LOG_LEVEL_ERROR = 5;
    public static final int LOG_LEVEL_INFO = 3;
    public static final int LOG_LEVEL_SILENT = 6;
    public static final int LOG_LEVEL_VERBOSE = 1;
    public static final int LOG_LEVEL_WARN = 4;
    private APLogAppender appender = null;

    APLogger() {
    }

    public static void log(int i3, String str, String str2) {
        String substring;
        int i16 = 0;
        while (i16 < str2.length()) {
            try {
                int i17 = i16 + 3600;
                if (str2.length() <= i17) {
                    substring = str2.substring(i16);
                } else {
                    substring = str2.substring(i16, i17);
                }
                switch (i3) {
                    case 1:
                        Log.v(str, substring);
                        break;
                    case 2:
                        Log.d(str, substring);
                        break;
                    case 3:
                        Log.i(str, substring);
                        break;
                    case 4:
                        Log.w(str, substring);
                        break;
                    case 5:
                        Log.e(str, substring);
                        break;
                    case 6:
                        Log.e(str, substring);
                        break;
                }
                i16 = i17;
            } catch (Throwable th5) {
                Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "print log error: <%s>%s", th5.getClass().getName(), th5.getMessage()));
                return;
            }
        }
    }

    public static APLogger open() {
        APLogger aPLogger = new APLogger();
        aPLogger.openAppender();
        return aPLogger;
    }

    private void openAppender() {
        this.appender = APLogAppender.open();
    }

    public void flush() {
        try {
            APLogAppender aPLogAppender = this.appender;
            if (aPLogAppender != null) {
                aPLogAppender.flushAndWrite();
            }
        } catch (Throwable th5) {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "flush log error: %s\n, stackTrace: %s", th5.toString(), th5.getStackTrace()[3]));
        }
    }

    public void write(String str) {
        this.appender.append(str);
    }
}
