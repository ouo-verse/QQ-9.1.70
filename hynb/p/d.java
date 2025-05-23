package hynb.p;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public c f406797a;

    public void a(c cVar) {
        this.f406797a = cVar;
    }

    @Override // hynb.p.c
    public boolean a() {
        c cVar = this.f406797a;
        if (cVar != null) {
            return cVar.a();
        }
        throw new IllegalArgumentException("Invoke isForeground failed, please invoke MTPApi.setLifecycle first.");
    }
}
