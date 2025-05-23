package om2;

import androidx.annotation.NonNull;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    static a f423129b = new a();

    /* renamed from: a, reason: collision with root package name */
    final HashMap<String, C10925a> f423130a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: om2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public final class C10925a extends e {

        /* renamed from: f, reason: collision with root package name */
        int f423131f = 0;

        C10925a() {
        }

        @Override // om2.e
        public void g() {
            a.this.e(this);
        }

        public void h() {
            this.f423131f++;
        }

        public int i() {
            int i3 = this.f423131f - 1;
            this.f423131f = i3;
            return i3;
        }

        public void j() {
            super.g();
        }
    }

    public static a b() {
        return f423129b;
    }

    @NonNull
    C10925a a(String str, @NonNull C10925a c10925a) {
        synchronized (this.f423130a) {
            C10925a c10925a2 = this.f423130a.get(str);
            if (c10925a2 != null) {
                c10925a2.h();
                c10925a.j();
                return c10925a2;
            }
            this.f423130a.put(str, c10925a);
            c10925a.h();
            return c10925a;
        }
    }

    public e c(String str) {
        C10925a d16 = d(str);
        if (d16 != null) {
            return d16;
        }
        C10925a c10925a = new C10925a();
        if (!c10925a.f(str)) {
            lm2.c.b("APNGDecoderManager", "load image fail, " + str);
            return null;
        }
        return a(str, c10925a);
    }

    C10925a d(String str) {
        synchronized (this.f423130a) {
            C10925a c10925a = this.f423130a.get(str);
            if (c10925a != null) {
                c10925a.h();
                return c10925a;
            }
            return null;
        }
    }

    void e(C10925a c10925a) {
        if (c10925a == null) {
            return;
        }
        synchronized (this.f423130a) {
            if (c10925a.i() == 0) {
                c10925a.j();
                this.f423130a.remove(c10925a.d());
            }
        }
    }
}
