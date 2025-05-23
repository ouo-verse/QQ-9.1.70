package cooperation.qzone.util;

import android.util.Log;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneNumberUtil {
    private static final String TAG = "QZoneNumberUtil";

    public static int safeParseInt(String str, int i3) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "parse int error: " + str + ", " + Log.getStackTraceString(new Throwable()));
            }
            return i3;
        }
    }

    public static long safeParseLong(String str, long j3) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "parse long error: " + str + ", " + Log.getStackTraceString(new Throwable()));
            }
            return j3;
        }
    }
}
