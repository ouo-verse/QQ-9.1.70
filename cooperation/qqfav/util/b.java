package cooperation.qqfav.util;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static int f390669d;

    /* renamed from: b, reason: collision with root package name */
    private String f390671b;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f390670a = true;

    /* renamed from: c, reason: collision with root package name */
    private int f390672c = 3;

    static {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i3 = 0; i3 < stackTrace.length; i3++) {
            if (b.class.getName().equals(stackTrace[i3].getClassName())) {
                f390669d = i3;
                return;
            }
        }
    }

    private StringBuilder c(int i3) {
        return new StringBuilder();
    }

    private synchronized void e(String str, int i3, int i16, String str2, int i17) {
        if (i3 != 2) {
            if (i3 == 4 && !QLog.isDevelopLevel()) {
                return;
            }
        } else if (!QLog.isColorLevel()) {
            return;
        }
        StringBuilder c16 = c(i17);
        if (str2 != null) {
            c16.append(str2);
        }
        if (str == null) {
            str = this.f390671b;
        }
        if (i16 != 3) {
            if (i16 != 4) {
                if (i16 != 5) {
                    if (i16 == 6) {
                        QLog.e(str, i3, c16.toString());
                    }
                } else {
                    QLog.w(str, i3, c16.toString());
                }
            } else {
                QLog.i(str, i3, c16.toString());
            }
        } else {
            QLog.d(str, i3, c16.toString());
        }
    }

    public b a(String str, int i3, String str2) {
        e(str, i3, 3, str2, this.f390672c);
        return this;
    }

    public b b(String str, int i3, String str2) {
        e(str, i3, 6, str2, this.f390672c);
        return this;
    }

    public b d(String str, int i3, String str2) {
        e(str, i3, 4, str2, this.f390672c);
        return this;
    }

    public b f(String str) {
        this.f390671b = str;
        return this;
    }

    public final void g(int i3) {
        this.f390672c = i3;
    }
}
