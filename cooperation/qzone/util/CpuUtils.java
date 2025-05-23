package cooperation.qzone.util;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class CpuUtils {
    static {
        try {
            System.loadLibrary("cpu_v1.1");
        } catch (UnsatisfiedLinkError e16) {
            QLog.e("CpuUtils", 1, "loadLibrary error.", e16);
        }
    }

    private static native long getCpuFeatures();

    public static long getCpuProperty() {
        try {
            return getCpuFeatures();
        } catch (UnsatisfiedLinkError e16) {
            QLog.e("CpuUtils", 1, "getCpuFeatures error. ", e16);
            return 0L;
        }
    }
}
