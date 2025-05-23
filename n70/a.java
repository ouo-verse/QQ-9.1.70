package n70;

import com.tencent.qphone.base.util.QLog;
import tz3.j;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a implements j.a {
    @Override // tz3.j.a
    public void d(String str, Object... objArr) {
        if (QLog.isDebugVersion()) {
            QLog.d("QDM-" + str, 4, objArr);
        }
    }

    @Override // tz3.j.a
    public void e(String str, Object... objArr) {
        if (QLog.isColorLevel()) {
            QLog.e("QDM-" + str, 1, objArr);
        }
    }

    @Override // tz3.j.a
    public void i(String str, Object... objArr) {
        if (QLog.isDebugVersion()) {
            QLog.d("QDM-" + str, 4, objArr);
        }
    }

    @Override // tz3.j.a
    public void e(String str, String str2, Throwable th5) {
        if (QLog.isColorLevel()) {
            QLog.e("QDM-" + str, 1, str2, th5);
        }
    }

    @Override // tz3.j.a
    public void a(String str, Object... objArr) {
    }
}
