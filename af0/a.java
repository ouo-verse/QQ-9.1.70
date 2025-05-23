package af0;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private volatile int f25953a = 0;

    /* renamed from: b, reason: collision with root package name */
    private bf0.b f25954b;

    public void a(bf0.b bVar) {
        this.f25954b = bVar;
        e(this.f25953a);
    }

    public boolean b() {
        if (this.f25953a == -1) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f25953a == 1) {
            return true;
        }
        return false;
    }

    public void d() {
        e(-1);
    }

    public void e(int i3) {
        this.f25953a = i3;
        bf0.b bVar = this.f25954b;
        if (bVar != null) {
            if (i3 != -1) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            bVar.e();
                            return;
                        }
                        return;
                    }
                    bVar.h();
                    return;
                }
                bVar.m();
                return;
            }
            bVar.b();
        }
    }
}
