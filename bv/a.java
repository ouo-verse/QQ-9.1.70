package bv;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends av.a {

    /* renamed from: h, reason: collision with root package name */
    private cv.a f29239h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f29240i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f29241m;

    /* compiled from: P */
    /* renamed from: bv.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0153a implements cv.a {
        C0153a() {
        }

        @Override // cv.a
        public void a(boolean z16) {
            a.this.f29241m = z16;
            a aVar = a.this;
            aVar.k(aVar.f29241m);
            cv.b.b().g(a.this.f29239h);
            QLog.d("MagicAuthPolicy", 1, "onAuthResult " + a.this.f29241m);
        }
    }

    public a() {
        super("MagicAuthPolicy");
    }

    @Override // av.a
    public long c() {
        return 1800000L;
    }

    @Override // av.a
    public void j() {
        this.f29239h = new C0153a();
        cv.b.b().f(this.f29239h);
        boolean z16 = o() == 0;
        this.f29240i = z16;
        if (z16) {
            return;
        }
        k(false);
        cv.b.b().g(this.f29239h);
        QLog.d("MagicAuthPolicy", 1, "registerLinkTurbo fail");
    }

    private int o() {
        return cv.b.b().e(32, 4, 32768);
    }
}
