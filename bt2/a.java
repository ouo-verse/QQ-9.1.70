package bt2;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f29097b = new a();

    /* renamed from: a, reason: collision with root package name */
    String f29098a;

    /* compiled from: P */
    /* renamed from: bt2.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC0150a {
    }

    public static a a() {
        return f29097b;
    }

    public boolean b(String str) {
        return true;
    }

    public boolean c() {
        return !TextUtils.isEmpty(this.f29098a);
    }

    public boolean d(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f29098a)) {
            return str.equals(this.f29098a);
        }
        return false;
    }

    public void h() {
    }

    public void e(String str) {
    }

    public void f(String str, InterfaceC0150a interfaceC0150a) {
    }

    public void g(String str, String str2, String str3) {
    }
}
