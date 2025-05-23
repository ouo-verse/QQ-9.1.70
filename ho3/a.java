package ho3;

import g55.q;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private q f405479a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.now.pkgame.pkgame.pklib.state.a f405480b;

    public boolean a() {
        q qVar = this.f405479a;
        if (qVar != null && qVar.f401379b != null) {
            return true;
        }
        return false;
    }

    public q b() {
        return this.f405479a;
    }

    public void c(com.tencent.now.pkgame.pkgame.pklib.state.a aVar) {
        this.f405480b = aVar;
    }

    public void d(q qVar) {
        this.f405479a = qVar;
    }
}
