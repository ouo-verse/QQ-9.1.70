package cooperation.qzone.util;

import android.util.Log;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZLog {
    public static final int CLR = 2;
    public static final String CRASH_TAG = "crash";
    public static final int DEV = 4;
    private static final boolean ENABLED = true;
    public static final String EXCEPTION_TAG = "exception";
    public static final String FEEDS_TAG = "Feeds";
    public static final String IMAGE_CACHE_TAG = "ImageCache";
    public static final String MEMORY_LEAK = "MemoryLeak";
    public static final String PICTURE_PREVIEW = "picture_preview";
    public static final String PUBLISH_QUEUE_TAG = "[upload2][outbox] PublishQueue";
    public static final String REPORT_QUEUE_TAG = "QZoneReportTaskQueue";
    public static final String REQUSET = "REQUSET";
    public static final String TO_DEVICE_TAG = "QZLog";
    public static final int USR = 1;
    public static final String WNS_HTML = "wns_html";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class LogBuilder {
        private static final int MAX_POOL_SIZE = 50;
        private static LogBuilder sPool;
        private static int sPoolSize;
        private static final Object sPoolSync = new Object();
        private LogBuilder next;
        private StringBuilder stringBuilder = new StringBuilder(128);

        LogBuilder() {
        }

        private void clearForRecycle() {
            StringBuilder sb5 = this.stringBuilder;
            sb5.delete(0, sb5.length());
        }

        public static LogBuilder obtain() {
            synchronized (sPoolSync) {
                LogBuilder logBuilder = sPool;
                if (logBuilder != null) {
                    sPool = logBuilder.next;
                    logBuilder.next = null;
                    sPoolSize--;
                    return logBuilder;
                }
                return new LogBuilder();
            }
        }

        public LogBuilder append(boolean z16) {
            this.stringBuilder.append(z16);
            return this;
        }

        public void recycle() {
            clearForRecycle();
            synchronized (sPoolSync) {
                int i3 = sPoolSize;
                if (i3 < 50) {
                    this.next = sPool;
                    sPool = this;
                    sPoolSize = i3 + 1;
                }
            }
        }

        public String toString() {
            return this.stringBuilder.toString();
        }

        public LogBuilder append(char c16) {
            this.stringBuilder.append(c16);
            return this;
        }

        public LogBuilder append(int i3) {
            this.stringBuilder.append(i3);
            return this;
        }

        public LogBuilder append(long j3) {
            this.stringBuilder.append(j3);
            return this;
        }

        public LogBuilder append(float f16) {
            this.stringBuilder.append(f16);
            return this;
        }

        public LogBuilder append(double d16) {
            this.stringBuilder.append(d16);
            return this;
        }

        public LogBuilder append(Object obj) {
            this.stringBuilder.append(obj);
            return this;
        }

        public LogBuilder append(String str) {
            this.stringBuilder.append(str);
            return this;
        }

        public LogBuilder append(StringBuffer stringBuffer) {
            this.stringBuilder.append(stringBuffer);
            return this;
        }

        public LogBuilder append(char[] cArr) {
            this.stringBuilder.append(cArr);
            return this;
        }

        public LogBuilder append(char[] cArr, int i3, int i16) {
            this.stringBuilder.append(cArr, i3, i16);
            return this;
        }

        public LogBuilder append(CharSequence charSequence) {
            this.stringBuilder.append(charSequence);
            return this;
        }

        public LogBuilder append(CharSequence charSequence, int i3, int i16) {
            this.stringBuilder.append(charSequence, i3, i16);
            return this;
        }
    }

    public static void d(String str, int i3, String str2) {
        QLog.d(str, getNewLevel(i3), str2);
    }

    public static void e(String str, String str2) {
        QLog.e(str, 1, str2);
    }

    public static String getStackTraceString(Throwable th5) {
        return Log.getStackTraceString(th5);
    }

    public static void i(String str, String str2) {
        QLog.i(str, 1, str2);
    }

    public static boolean isColorLevel() {
        return QLog.isColorLevel();
    }

    public static final boolean isDevelopLevel() {
        return QLog.isDevelopLevel();
    }

    private static boolean needPrintLog(int i3) {
        int i16;
        if (QLog.isDevelopLevel()) {
            i16 = 4;
        } else if (QLog.isColorLevel()) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        if (i16 >= i3) {
            return true;
        }
        return false;
    }

    public static void w(Throwable th5) {
        w("exception", "", th5);
    }

    public static void e(String str, String str2, Throwable th5) {
        QLog.e(str, 1, str2, th5);
    }

    public static void i(String str, int i3, String str2) {
        QLog.i(str, getNewLevel(i3), str2);
    }

    public static void w(String str, String str2) {
        QLog.w(str, 1, str2, null);
    }

    public static void d(String str, int i3, String str2, Throwable th5) {
        QLog.d(str, getNewLevel(i3), str2, th5);
    }

    public static void e(String str, int i3, Object... objArr) {
        e(str, getNewLevel(i3), null, objArr);
    }

    public static void w(String str, String str2, Throwable th5) {
        QLog.w(str, 1, str2, th5);
    }

    public static void i(String str, int i3, String str2, Throwable th5) {
        QLog.i(str, getNewLevel(i3), str2, th5);
    }

    public static void w(String str, int i3, Object... objArr) {
        w(str, getNewLevel(i3), null, objArr);
    }

    public static void d(String str, int i3, Object... objArr) {
        d(str, getNewLevel(i3), (Throwable) null, objArr);
    }

    public static void e(String str, int i3, Throwable th5, Object... objArr) {
        Object obj;
        int newLevel = getNewLevel(i3);
        if (objArr == null || objArr.length <= 0 || !needPrintLog(newLevel)) {
            return;
        }
        if (objArr.length == 1 && (obj = objArr[0]) != null) {
            QLog.e(str, newLevel, obj.toString(), th5);
            return;
        }
        LogBuilder obtain = LogBuilder.obtain();
        for (Object obj2 : objArr) {
            obtain.append(obj2);
        }
        QLog.e(str, newLevel, obtain.toString(), th5);
        obtain.recycle();
    }

    public static void i(String str, int i3, Object... objArr) {
        i(str, getNewLevel(i3), (Throwable) null, objArr);
    }

    public static void w(String str, int i3, Throwable th5, Object... objArr) {
        Object obj;
        int newLevel = getNewLevel(i3);
        if (objArr == null || objArr.length <= 0 || !needPrintLog(newLevel)) {
            return;
        }
        if (objArr.length == 1 && (obj = objArr[0]) != null) {
            QLog.w(str, newLevel, obj.toString());
            return;
        }
        LogBuilder obtain = LogBuilder.obtain();
        for (Object obj2 : objArr) {
            obtain.append(obj2);
        }
        QLog.w(str, newLevel, obtain.toString(), th5);
        obtain.recycle();
    }

    public static void d(String str, int i3, Throwable th5, Object... objArr) {
        Object obj;
        int newLevel = getNewLevel(i3);
        if (objArr == null || objArr.length <= 0 || !needPrintLog(newLevel)) {
            return;
        }
        if (objArr.length == 1 && (obj = objArr[0]) != null) {
            d(str, newLevel, obj.toString());
            return;
        }
        LogBuilder obtain = LogBuilder.obtain();
        for (Object obj2 : objArr) {
            obtain.append(obj2);
        }
        QLog.d(str, newLevel, obtain.toString(), th5);
        obtain.recycle();
    }

    public static void i(String str, int i3, Throwable th5, Object... objArr) {
        Object obj;
        int newLevel = getNewLevel(i3);
        if (objArr == null || objArr.length <= 0 || !needPrintLog(newLevel)) {
            return;
        }
        if (objArr.length == 1 && (obj = objArr[0]) != null) {
            i(str, newLevel, obj.toString());
            return;
        }
        LogBuilder obtain = LogBuilder.obtain();
        for (Object obj2 : objArr) {
            obtain.append(obj2);
        }
        QLog.i(str, newLevel, obtain.toString(), th5);
        obtain.recycle();
    }

    public static int getNewLevel(int i3) {
        return i3;
    }
}
