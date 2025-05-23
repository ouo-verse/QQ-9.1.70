package hj1;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public class b {
    public static void a(String str, String str2) {
        QLog.i(str, 1, str2);
    }

    public static void b(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.i(str, 2, str2);
        } else {
            QLog.d(str, 4, str2);
        }
    }
}
