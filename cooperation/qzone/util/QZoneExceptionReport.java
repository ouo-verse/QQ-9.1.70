package cooperation.qzone.util;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.a;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QZoneExceptionReport {
    public static final String STACK_TAG = "QzoneCatchedException:";
    private static final String TAG = "QZoneExceptionReport";
    private static Field detailMessageField;

    private static void addStackTag(Throwable th5) {
        try {
            if (detailMessageField == null) {
                detailMessageField = Throwable.class.getDeclaredField("detailMessage");
            }
            detailMessageField.setAccessible(true);
            detailMessageField.set(th5, STACK_TAG + th5.getMessage());
        } catch (Throwable th6) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "addStackTag failed", th6);
            }
        }
    }

    public static final void doReport(Throwable th5, String str) {
        if (th5 == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = Log.getStackTraceString(th5);
        }
        addStackTag(th5);
        QLog.d(TAG, 2, "", th5);
        a.c(th5, str);
    }
}
