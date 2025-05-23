package e05;

import com.xingin.xhssharesdk.a.c0;
import com.xingin.xhssharesdk.a.g;
import com.xingin.xhssharesdk.a.j;
import com.xingin.xhssharesdk.a.k;
import com.xingin.xhssharesdk.a.m;
import com.xingin.xhssharesdk.a.q;
import java.io.IOException;
import java.util.Map;
import nz4.e;
import nz4.f;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class d extends k<d, b> implements f {
    public static final d K;
    public static volatile k.b L;
    public int D;
    public int F;
    public long G;

    /* renamed from: h, reason: collision with root package name */
    public int f395331h;
    public q<String, String> J = q.a();

    /* renamed from: i, reason: collision with root package name */
    public String f395332i = "";

    /* renamed from: m, reason: collision with root package name */
    public String f395333m = "";
    public String C = "";
    public String E = "";
    public String H = "";
    public String I = "";

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final j<String, String> f395334a;

        static {
            c0.a.C10093a c10093a = c0.a.f389885c;
            f395334a = new j<>(c10093a, c10093a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class b extends k.a<d, b> implements f {
        public b() {
            super(d.K);
        }
    }

    static {
        d dVar = new d();
        K = dVar;
        dVar.g();
    }

    @Override // com.xingin.xhssharesdk.a.l
    public final void a(g gVar) {
        int i3 = this.f395331h;
        if (i3 != 0) {
            gVar.j(1, i3);
        }
        if (!this.f395332i.isEmpty()) {
            gVar.p(2, this.f395332i);
        }
        if (!this.f395333m.isEmpty()) {
            gVar.p(3, this.f395333m);
        }
        if (!this.C.isEmpty()) {
            gVar.p(4, this.C);
        }
        int i16 = this.D;
        if (i16 != 0) {
            gVar.j(5, i16);
        }
        if (!this.E.isEmpty()) {
            gVar.p(6, this.E);
        }
        int i17 = this.F;
        if (i17 != 0) {
            gVar.j(7, i17);
        }
        long j3 = this.G;
        if (j3 != 0) {
            gVar.w(j3);
        }
        if (!this.H.isEmpty()) {
            gVar.p(9, this.H);
        }
        if (!this.I.isEmpty()) {
            gVar.p(10, this.I);
        }
        for (Map.Entry<String, String> entry : this.J.entrySet()) {
            j<String, String> jVar = a.f395334a;
            String key = entry.getKey();
            String value = entry.getValue();
            jVar.getClass();
            gVar.o(11, 2);
            j.a<String, String> aVar = jVar.f389927a;
            gVar.A(com.xingin.xhssharesdk.a.d.a(aVar.f389932c, 2, value) + com.xingin.xhssharesdk.a.d.a(aVar.f389930a, 1, key));
            j.a<String, String> aVar2 = jVar.f389927a;
            com.xingin.xhssharesdk.a.d.e(gVar, aVar2.f389930a, 1, key);
            com.xingin.xhssharesdk.a.d.e(gVar, aVar2.f389932c, 2, value);
        }
    }

    @Override // com.xingin.xhssharesdk.a.l
    public final int b() {
        int i3 = this.f389935f;
        if (i3 != -1) {
            return i3;
        }
        int i16 = this.f395331h;
        int i17 = 0;
        if (i16 != 0) {
            i17 = 0 + g.b(i16) + g.n(1);
        }
        if (!this.f395332i.isEmpty()) {
            i17 += g.c(2, this.f395332i);
        }
        if (!this.f395333m.isEmpty()) {
            i17 += g.c(3, this.f395333m);
        }
        if (!this.C.isEmpty()) {
            i17 += g.c(4, this.C);
        }
        int i18 = this.D;
        if (i18 != 0) {
            i17 += g.b(i18) + g.n(5);
        }
        if (!this.E.isEmpty()) {
            i17 += g.c(6, this.E);
        }
        int i19 = this.F;
        if (i19 != 0) {
            i17 += g.b(i19) + g.n(7);
        }
        long j3 = this.G;
        if (j3 != 0) {
            i17 += g.d(j3) + g.n(8);
        }
        if (!this.H.isEmpty()) {
            i17 += g.c(9, this.H);
        }
        if (!this.I.isEmpty()) {
            i17 += g.c(10, this.I);
        }
        for (Map.Entry<String, String> entry : this.J.entrySet()) {
            j<String, String> jVar = a.f395334a;
            String key = entry.getKey();
            String value = entry.getValue();
            jVar.getClass();
            int n3 = g.n(11);
            j.a<String, String> aVar = jVar.f389927a;
            int a16 = com.xingin.xhssharesdk.a.d.a(aVar.f389932c, 2, value) + com.xingin.xhssharesdk.a.d.a(aVar.f389930a, 1, key);
            i17 += g.v(a16) + a16 + n3;
        }
        this.f389935f = i17;
        return i17;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0047. Please report as an issue. */
    @Override // com.xingin.xhssharesdk.a.k
    public final Object c(k.h hVar, Object obj, Object obj2) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        q<String, String> qVar;
        boolean z36 = false;
        switch (hVar) {
            case f389945a:
                return K;
            case f389946b:
                k.i iVar = (k.i) obj;
                d dVar = (d) obj2;
                int i3 = this.f395331h;
                if (i3 != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                int i16 = dVar.f395331h;
                if (i16 != 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                this.f395331h = iVar.d(z16, i3, z17, i16);
                this.f395332i = iVar.e(!this.f395332i.isEmpty(), this.f395332i, !dVar.f395332i.isEmpty(), dVar.f395332i);
                this.f395333m = iVar.e(!this.f395333m.isEmpty(), this.f395333m, !dVar.f395333m.isEmpty(), dVar.f395333m);
                this.C = iVar.e(!this.C.isEmpty(), this.C, !dVar.C.isEmpty(), dVar.C);
                int i17 = this.D;
                if (i17 != 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                int i18 = dVar.D;
                if (i18 != 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                this.D = iVar.d(z18, i17, z19, i18);
                this.E = iVar.e(!this.E.isEmpty(), this.E, !dVar.E.isEmpty(), dVar.E);
                int i19 = this.F;
                if (i19 != 0) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                int i26 = dVar.F;
                if (i26 != 0) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                this.F = iVar.d(z26, i19, z27, i26);
                long j3 = this.G;
                if (j3 != 0) {
                    z28 = true;
                } else {
                    z28 = false;
                }
                long j16 = dVar.G;
                if (j16 != 0) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                this.G = iVar.g(z28, j3, z29, j16);
                this.H = iVar.e(!this.H.isEmpty(), this.H, !dVar.H.isEmpty(), dVar.H);
                this.I = iVar.e(!this.I.isEmpty(), this.I, true ^ dVar.I.isEmpty(), dVar.I);
                this.J = iVar.f(this.J, dVar.J);
                return this;
            case f389947c:
                com.xingin.xhssharesdk.a.c cVar = (com.xingin.xhssharesdk.a.c) obj;
                e eVar = (e) obj2;
                while (!z36) {
                    try {
                        try {
                            int k3 = cVar.k();
                            switch (k3) {
                                case 0:
                                    z36 = true;
                                case 8:
                                    this.f395331h = cVar.e();
                                case 18:
                                    this.f395332i = cVar.i();
                                case 26:
                                    this.f395333m = cVar.i();
                                case 34:
                                    this.C = cVar.i();
                                case 40:
                                    this.D = cVar.e();
                                case 50:
                                    this.E = cVar.i();
                                case 56:
                                    this.F = cVar.e();
                                case 64:
                                    this.G = cVar.g();
                                case 74:
                                    this.H = cVar.i();
                                case 82:
                                    this.I = cVar.i();
                                case 90:
                                    q<String, String> qVar2 = this.J;
                                    if (!qVar2.f389971a) {
                                        if (qVar2.isEmpty()) {
                                            qVar = new q<>();
                                        } else {
                                            qVar = new q<>(qVar2);
                                        }
                                        this.J = qVar;
                                    }
                                    a.f395334a.b(this.J, cVar, eVar);
                                default:
                                    if (!cVar.h(k3)) {
                                        z36 = true;
                                    }
                            }
                        } catch (m e16) {
                            throw new RuntimeException(e16);
                        }
                    } catch (IOException e17) {
                        throw new RuntimeException(new m(e17.getMessage()));
                    }
                }
                break;
            case f389948d:
                this.J.f389971a = false;
                return null;
            case f389949e:
                return new d();
            case f389950f:
                return new b();
            case f389951g:
                break;
            case f389952h:
                if (L == null) {
                    synchronized (d.class) {
                        if (L == null) {
                            L = new k.b(K);
                        }
                    }
                }
                return L;
            default:
                throw new UnsupportedOperationException();
        }
        return K;
    }
}
