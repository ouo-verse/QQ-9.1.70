package cooperation.qzone.util;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SafeUtil {
    private static final void log(String str) {
        try {
            QLog.e("SafeUtil", 1, str);
        } catch (Exception unused) {
        }
    }

    public static int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            log("toInt convert error:" + str);
            return 0;
        } catch (Exception e16) {
            log("toInt convert error:" + e16.getMessage());
            return 0;
        }
    }
}
