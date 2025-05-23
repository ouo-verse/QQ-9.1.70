package com.tencent.liteav.base.datareport;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;

/* compiled from: P */
@JNINamespace("liteav")
/* loaded from: classes7.dex */
public class Event4XReporter {
    private static final int INVALID_INSTANCE = 0;
    public static final int REPORT_EVENT = 1;
    public static final int REPORT_STATUS = 2;
    private static final String TAG = "Event4XReporter";
    private long mNativeEvent4XReporterAndroid;

    public Event4XReporter(int i3, int i16, String str, boolean z16, int i17) {
        this.mNativeEvent4XReporterAndroid = 0L;
        this.mNativeEvent4XReporterAndroid = nativeCreate(i3, i16, str, z16, i17);
    }

    private static native long nativeCreate(int i3, int i16, String str, boolean z16, int i17);

    private static native void nativeDestroy(long j3);

    private static native int nativeGetColdDownTime(long j3);

    private static native void nativeSendReport(long j3);

    private static native void nativeSetCommonIntValue(long j3, String str, long j16);

    private static native void nativeSetCommonStringValue(long j3, String str, String str2);

    private static native void nativeSetEventIntValue(long j3, String str, long j16);

    private static native void nativeSetEventStringValue(long j3, String str, String str2);

    public synchronized void destroy() {
        long j3 = this.mNativeEvent4XReporterAndroid;
        if (j3 == 0) {
            return;
        }
        nativeDestroy(j3);
        this.mNativeEvent4XReporterAndroid = 0L;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public int getColdDownTime() {
        long j3 = this.mNativeEvent4XReporterAndroid;
        if (j3 == 0) {
            return 10000;
        }
        return nativeGetColdDownTime(j3);
    }

    public synchronized void reportDau(int i3, int i16, String str) {
        long j3 = this.mNativeEvent4XReporterAndroid;
        if (j3 == 0) {
            return;
        }
        nativeSetEventStringValue(j3, "event_id", String.valueOf(i3));
        nativeSetEventStringValue(this.mNativeEvent4XReporterAndroid, CheckForwardServlet.KEY_ERR_CODE, String.valueOf(i16));
        nativeSetEventStringValue(this.mNativeEvent4XReporterAndroid, "err_info", str);
        nativeSendReport(this.mNativeEvent4XReporterAndroid);
    }

    public synchronized void sendReport() {
        long j3 = this.mNativeEvent4XReporterAndroid;
        if (j3 == 0) {
            return;
        }
        nativeSendReport(j3);
    }

    public synchronized void setCommonIntValue(String str, long j3) {
        long j16 = this.mNativeEvent4XReporterAndroid;
        if (j16 != 0 && str != null) {
            nativeSetCommonIntValue(j16, str, j3);
        }
    }

    public synchronized void setCommonStringValue(String str, String str2) {
        long j3 = this.mNativeEvent4XReporterAndroid;
        if (j3 != 0 && str != null && str2 != null) {
            nativeSetCommonStringValue(j3, str, str2);
        }
    }

    public synchronized void setEventIntValue(String str, long j3) {
        long j16 = this.mNativeEvent4XReporterAndroid;
        if (j16 != 0 && str != null) {
            nativeSetEventIntValue(j16, str, j3);
        }
    }

    public synchronized void setEventStringValue(String str, String str2) {
        long j3 = this.mNativeEvent4XReporterAndroid;
        if (j3 != 0 && str != null && str2 != null) {
            nativeSetEventStringValue(j3, str, str2);
        }
    }
}
