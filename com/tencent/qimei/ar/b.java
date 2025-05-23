package com.tencent.qimei.ar;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements com.tencent.qimei.y.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f343095a;

    public b(c cVar) {
        this.f343095a = cVar;
    }

    @Override // com.tencent.qimei.y.c
    public void c() {
        boolean z16;
        synchronized (this.f343095a) {
            c cVar = this.f343095a;
            cVar.getClass();
            synchronized (c.f343097e) {
                z16 = cVar.f343100c;
            }
            if (!z16 && !this.f343095a.f343099b.f343103b.get()) {
                this.f343095a.a();
            }
        }
    }

    @Override // com.tencent.qimei.y.c
    public void d() {
    }
}
