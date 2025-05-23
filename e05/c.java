package e05;

import com.xingin.xhssharesdk.a.g;
import com.xingin.xhssharesdk.a.k;
import com.xingin.xhssharesdk.a.m;
import e05.b;
import e05.d;
import java.io.IOException;
import nz4.e;
import nz4.f;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class c extends k<c, a> implements f {
    public static volatile k.b C;

    /* renamed from: m, reason: collision with root package name */
    public static final c f395328m;

    /* renamed from: h, reason: collision with root package name */
    public b f395329h;

    /* renamed from: i, reason: collision with root package name */
    public d f395330i;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends k.a<c, a> implements f {
        public a() {
            super(c.f395328m);
        }
    }

    static {
        c cVar = new c();
        f395328m = cVar;
        cVar.g();
    }

    @Override // com.xingin.xhssharesdk.a.l
    public final void a(g gVar) {
        b bVar = this.f395329h;
        if (bVar != null) {
            gVar.k(1, bVar);
        }
        d dVar = this.f395330i;
        if (dVar != null) {
            gVar.k(2, dVar);
        }
    }

    @Override // com.xingin.xhssharesdk.a.l
    public final int b() {
        int i3 = this.f389935f;
        if (i3 != -1) {
            return i3;
        }
        b bVar = this.f395329h;
        int i16 = 0;
        if (bVar != null) {
            int n3 = g.n(1);
            int b16 = bVar.b();
            i16 = 0 + g.v(b16) + b16 + n3;
        }
        d dVar = this.f395330i;
        if (dVar != null) {
            int n16 = g.n(2);
            int b17 = dVar.b();
            i16 += g.v(b17) + b17 + n16;
        }
        this.f389935f = i16;
        return i16;
    }

    @Override // com.xingin.xhssharesdk.a.k
    public final Object c(k.h hVar, Object obj, Object obj2) {
        d.b bVar;
        b.a aVar;
        switch (hVar) {
            case f389945a:
                return f395328m;
            case f389946b:
                k.i iVar = (k.i) obj;
                c cVar = (c) obj2;
                this.f395329h = (b) iVar.c(this.f395329h, cVar.f395329h);
                this.f395330i = (d) iVar.c(this.f395330i, cVar.f395330i);
                return this;
            case f389947c:
                com.xingin.xhssharesdk.a.c cVar2 = (com.xingin.xhssharesdk.a.c) obj;
                e eVar = (e) obj2;
                boolean z16 = false;
                while (!z16) {
                    try {
                        try {
                            int k3 = cVar2.k();
                            if (k3 != 0) {
                                if (k3 != 10) {
                                    if (k3 != 18) {
                                        if (!cVar2.h(k3)) {
                                        }
                                    } else {
                                        d dVar = this.f395330i;
                                        if (dVar != null) {
                                            bVar = dVar.d();
                                        } else {
                                            bVar = null;
                                        }
                                        nz4.g gVar = (nz4.g) d.K.b(k.h.f389952h);
                                        int e16 = cVar2.e();
                                        if (cVar2.f389884h < 100) {
                                            int c16 = cVar2.c(e16);
                                            cVar2.f389884h++;
                                            k a16 = gVar.a(cVar2, eVar);
                                            cVar2.b(0);
                                            cVar2.f389884h--;
                                            cVar2.f389883g = c16;
                                            cVar2.m();
                                            d dVar2 = (d) a16;
                                            this.f395330i = dVar2;
                                            if (bVar != null) {
                                                bVar.b(dVar2);
                                                if (!bVar.f389938f) {
                                                    bVar.f389937e.g();
                                                    bVar.f389938f = true;
                                                }
                                                this.f395330i = (d) bVar.f389937e;
                                            }
                                        } else {
                                            throw m.a();
                                        }
                                    }
                                } else {
                                    b bVar2 = this.f395329h;
                                    if (bVar2 != null) {
                                        aVar = bVar2.d();
                                    } else {
                                        aVar = null;
                                    }
                                    nz4.g gVar2 = (nz4.g) b.Z.b(k.h.f389952h);
                                    int e17 = cVar2.e();
                                    if (cVar2.f389884h < 100) {
                                        int c17 = cVar2.c(e17);
                                        cVar2.f389884h++;
                                        k a17 = gVar2.a(cVar2, eVar);
                                        cVar2.b(0);
                                        cVar2.f389884h--;
                                        cVar2.f389883g = c17;
                                        cVar2.m();
                                        b bVar3 = (b) a17;
                                        this.f395329h = bVar3;
                                        if (aVar != null) {
                                            aVar.b(bVar3);
                                            if (!aVar.f389938f) {
                                                aVar.f389937e.g();
                                                aVar.f389938f = true;
                                            }
                                            this.f395329h = (b) aVar.f389937e;
                                        }
                                    } else {
                                        throw m.a();
                                    }
                                }
                            }
                            z16 = true;
                        } catch (m e18) {
                            throw new RuntimeException(e18);
                        }
                    } catch (IOException e19) {
                        throw new RuntimeException(new m(e19.getMessage()));
                    }
                }
                break;
            case f389948d:
                return null;
            case f389949e:
                return new c();
            case f389950f:
                return new a();
            case f389951g:
                break;
            case f389952h:
                if (C == null) {
                    synchronized (c.class) {
                        if (C == null) {
                            C = new k.b(f395328m);
                        }
                    }
                }
                return C;
            default:
                throw new UnsupportedOperationException();
        }
        return f395328m;
    }
}
