package hd0;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements a {

    /* renamed from: d, reason: collision with root package name */
    public static final b f404742d = new b();

    /* renamed from: a, reason: collision with root package name */
    public String f404743a = null;

    /* renamed from: b, reason: collision with root package name */
    public int f404744b = 3;

    /* renamed from: c, reason: collision with root package name */
    private int f404745c = -1;

    b() {
    }

    public static b b() {
        return f404742d;
    }

    private void c(int i3, String str, String str2) {
        switch (i3) {
            case 2:
                QLog.d(str, 2, str2);
                return;
            case 3:
                QLog.d(str, 2, str2);
                return;
            case 4:
                QLog.i(str, 2, str2);
                return;
            case 5:
                QLog.e(str, 1, str2);
                return;
            case 6:
            case 7:
                QLog.e(str, 1, str2);
                return;
            default:
                return;
        }
    }

    private void f(int i3, String str, String str2, Throwable th5) {
        switch (i3) {
            case 2:
                QLog.d(str, 2, str2, th5);
                return;
            case 3:
                QLog.d(str, 2, str2, th5);
                return;
            case 4:
                QLog.i(str, 2, str2, th5);
                return;
            case 5:
                QLog.e(str, 1, str2, th5);
                return;
            case 6:
            case 7:
                QLog.e(str, 1, str2, th5);
                return;
            default:
                return;
        }
    }

    @Override // hd0.a
    public boolean a(int i3) {
        int i16 = this.f404745c;
        if ((i16 != -1 && i3 >= i16) || 5 <= i3) {
            return true;
        }
        if (QLog.isColorLevel() && this.f404744b <= i3) {
            return true;
        }
        return false;
    }

    @Override // hd0.a
    public void d(String str, String str2) {
        c(3, str, str2);
    }

    @Override // hd0.a
    public void e(String str, String str2) {
        c(6, str, str2);
    }

    @Override // hd0.a
    public void i(String str, String str2) {
        c(4, str, str2);
    }

    @Override // hd0.a
    public void v(String str, String str2) {
        c(2, str, str2);
    }

    @Override // hd0.a
    public void w(String str, String str2) {
        c(5, str, str2);
    }

    @Override // hd0.a
    public void e(String str, String str2, Throwable th5) {
        f(6, str, str2, th5);
    }

    @Override // hd0.a
    public void w(String str, String str2, Throwable th5) {
        f(5, str, str2, th5);
    }
}
