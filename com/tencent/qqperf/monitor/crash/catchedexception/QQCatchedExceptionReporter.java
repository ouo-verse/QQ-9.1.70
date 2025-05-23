package com.tencent.qqperf.monitor.crash.catchedexception;

import com.tencent.component.media.image.ProgressTracer;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
@Deprecated
/* loaded from: classes25.dex */
public class QQCatchedExceptionReporter {
    private static final String TAG = "QQCatchedExceptionReport";
    private static Field sDetailMessageField;

    private static void addCatchedMsgTag(Throwable th5, String str) {
        try {
            if (sDetailMessageField == null) {
                sDetailMessageField = Throwable.class.getDeclaredField("detailMessage");
            }
            sDetailMessageField.setAccessible(true);
            sDetailMessageField.set(th5, str + ProgressTracer.SEPARATOR + th5.getMessage());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "addCatchedMsgTag failed : ", e16);
            }
        }
    }

    public static void reportQQCatchException(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("NativeMemoryMonitor", 2, "[tag]" + str + "[msg]" + str2);
        }
        reportQQCatchedException(new Exception("CatchedNativeException"), str, str2);
    }

    public static void reportQQCatchedException(Throwable th5, String str, String str2) {
        if (th5 != null && str != null && str2 != null) {
            addCatchedMsgTag(th5, str);
            CrashReport.handleCatchException(Thread.currentThread(), th5, str2, null);
        }
    }
}
