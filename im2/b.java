package im2;

import com.tencent.mobileqq.intervideo.huayang.IHuayangCrashReport;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f407998a = IHuayangCrashReport.class.getSimpleName();

    public static void a(Throwable th5) {
        Throwable th6 = new Throwable(th5);
        try {
            for (Field field : Class.forName("java.lang.Throwable").getDeclaredFields()) {
                if (field.getName().equals("detailMessage")) {
                    field.setAccessible(true);
                    if (th5.getCause() != null && th6.getCause() != null) {
                        field.set(th6.getCause(), "ShortVideoCatchedException:" + th5.getCause().getMessage());
                    } else {
                        field.set(th6, "ShortVideoCatchedException:" + th5.getMessage());
                    }
                }
            }
        } catch (Throwable th7) {
            QLog.e(f407998a, 2, "addStackTag failed", th7);
        }
        com.tencent.qqperf.monitor.crash.catchedexception.a.c(th6, "ShortVideo Fail");
    }
}
