package com.tencent.luggage.wxa.xn;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public final e f145167a = new a();

    /* renamed from: b, reason: collision with root package name */
    public final e f145168b = new b();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends e {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.xn.e
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            com.tencent.luggage.wxa.k0.d.a(obj);
            a((c) null, (f) obj2);
        }

        public void a(c cVar, f fVar) {
            d.this.a(cVar, fVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends e {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.xn.e
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            com.tencent.luggage.wxa.k0.d.a(obj);
            a((InterfaceC6922d) null, (String) obj2);
        }

        public void a(InterfaceC6922d interfaceC6922d, String str) {
            d.this.a(interfaceC6922d, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void a(String str, f fVar);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xn.d$d, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC6922d {
        void a();
    }

    public void a(f fVar) {
    }

    public final void a(c cVar, f fVar) {
        cVar.a(fVar.f145175a, fVar);
    }

    public final void a(InterfaceC6922d interfaceC6922d, String str) {
        interfaceC6922d.a();
    }

    public void a(String str, int i3, Object obj) {
        f fVar = new f();
        fVar.f145175a = str;
        fVar.f145176b = i3;
        fVar.f145178d = obj;
        fVar.f145177c = this;
        this.f145167a.a(fVar);
        this.f145167a.b();
        a(fVar);
    }
}
