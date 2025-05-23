package dc0;

import com.tencent.tedger.outapi.delegate.e;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<b> f393532a;

    public c(b bVar) {
        this.f393532a = new WeakReference<>(bVar);
    }

    private e c() {
        return this.f393532a.get().d();
    }

    private String d() {
        return "TEDGEQFS_";
    }

    public void a(String str, String str2) {
        c().d(d() + str, c().a(), str2);
    }

    public void b(String str, int i3, String str2) {
        c().e(d() + str, c().a(), str2 + "(" + i3 + ")");
    }

    public void e(String str, String str2) {
        c().i(d() + str, c().a(), str2);
    }

    public void f(String str, int i3, String str2) {
        b(str, i3, str2);
    }
}
