package e05;

import com.xingin.xhssharesdk.a.g;
import com.xingin.xhssharesdk.a.k;
import com.xingin.xhssharesdk.a.m;
import java.io.IOException;
import nz4.f;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class b extends k<b, a> implements f {
    public static final b Z;

    /* renamed from: a0, reason: collision with root package name */
    public static volatile k.b f395324a0;
    public int M;
    public int Y;

    /* renamed from: h, reason: collision with root package name */
    public int f395325h;

    /* renamed from: i, reason: collision with root package name */
    public String f395326i = "";

    /* renamed from: m, reason: collision with root package name */
    public String f395327m = "";
    public String C = "";
    public String D = "";
    public String E = "";
    public String F = "";
    public String G = "";
    public String H = "";
    public String I = "";
    public String J = "";
    public String K = "";
    public String L = "";
    public String N = "";
    public String P = "";
    public String Q = "";
    public String R = "";
    public String S = "";
    public String T = "";
    public String U = "";
    public String V = "";
    public String W = "";
    public String X = "";

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a extends k.a<b, a> implements f {
        public a() {
            super(b.Z);
        }
    }

    static {
        b bVar = new b();
        Z = bVar;
        bVar.g();
    }

    @Override // com.xingin.xhssharesdk.a.l
    public final void a(g gVar) {
        int i3 = this.f395325h;
        if (i3 != 0) {
            gVar.j(1, i3);
        }
        if (!this.f395326i.isEmpty()) {
            gVar.p(2, this.f395326i);
        }
        if (!this.f395327m.isEmpty()) {
            gVar.p(3, this.f395327m);
        }
        if (!this.C.isEmpty()) {
            gVar.p(4, this.C);
        }
        if (!this.D.isEmpty()) {
            gVar.p(5, this.D);
        }
        if (!this.E.isEmpty()) {
            gVar.p(6, this.E);
        }
        if (!this.F.isEmpty()) {
            gVar.p(7, this.F);
        }
        if (!this.G.isEmpty()) {
            gVar.p(8, this.G);
        }
        if (!this.H.isEmpty()) {
            gVar.p(9, this.H);
        }
        if (!this.I.isEmpty()) {
            gVar.p(10, this.I);
        }
        if (!this.J.isEmpty()) {
            gVar.p(11, this.J);
        }
        if (!this.K.isEmpty()) {
            gVar.p(12, this.K);
        }
        if (!this.L.isEmpty()) {
            gVar.p(13, this.L);
        }
        int i16 = this.M;
        if (i16 != 0) {
            gVar.j(14, i16);
        }
        if (!this.N.isEmpty()) {
            gVar.p(15, this.N);
        }
        if (!this.P.isEmpty()) {
            gVar.p(16, this.P);
        }
        if (!this.Q.isEmpty()) {
            gVar.p(17, this.Q);
        }
        if (!this.R.isEmpty()) {
            gVar.p(18, this.R);
        }
        if (!this.S.isEmpty()) {
            gVar.p(19, this.S);
        }
        if (!this.T.isEmpty()) {
            gVar.p(20, this.T);
        }
        if (!this.U.isEmpty()) {
            gVar.p(21, this.U);
        }
        if (!this.V.isEmpty()) {
            gVar.p(22, this.V);
        }
        if (!this.W.isEmpty()) {
            gVar.p(23, this.W);
        }
        if (!this.X.isEmpty()) {
            gVar.p(24, this.X);
        }
        int i17 = this.Y;
        if (i17 != 0) {
            gVar.j(25, i17);
        }
    }

    @Override // com.xingin.xhssharesdk.a.l
    public final int b() {
        int i3 = this.f389935f;
        if (i3 != -1) {
            return i3;
        }
        int i16 = this.f395325h;
        int i17 = 0;
        if (i16 != 0) {
            i17 = 0 + g.b(i16) + g.n(1);
        }
        if (!this.f395326i.isEmpty()) {
            i17 += g.c(2, this.f395326i);
        }
        if (!this.f395327m.isEmpty()) {
            i17 += g.c(3, this.f395327m);
        }
        if (!this.C.isEmpty()) {
            i17 += g.c(4, this.C);
        }
        if (!this.D.isEmpty()) {
            i17 += g.c(5, this.D);
        }
        if (!this.E.isEmpty()) {
            i17 += g.c(6, this.E);
        }
        if (!this.F.isEmpty()) {
            i17 += g.c(7, this.F);
        }
        if (!this.G.isEmpty()) {
            i17 += g.c(8, this.G);
        }
        if (!this.H.isEmpty()) {
            i17 += g.c(9, this.H);
        }
        if (!this.I.isEmpty()) {
            i17 += g.c(10, this.I);
        }
        if (!this.J.isEmpty()) {
            i17 += g.c(11, this.J);
        }
        if (!this.K.isEmpty()) {
            i17 += g.c(12, this.K);
        }
        if (!this.L.isEmpty()) {
            i17 += g.c(13, this.L);
        }
        int i18 = this.M;
        if (i18 != 0) {
            i17 += g.b(i18) + g.n(14);
        }
        if (!this.N.isEmpty()) {
            i17 += g.c(15, this.N);
        }
        if (!this.P.isEmpty()) {
            i17 += g.c(16, this.P);
        }
        if (!this.Q.isEmpty()) {
            i17 += g.c(17, this.Q);
        }
        if (!this.R.isEmpty()) {
            i17 += g.c(18, this.R);
        }
        if (!this.S.isEmpty()) {
            i17 += g.c(19, this.S);
        }
        if (!this.T.isEmpty()) {
            i17 += g.c(20, this.T);
        }
        if (!this.U.isEmpty()) {
            i17 += g.c(21, this.U);
        }
        if (!this.V.isEmpty()) {
            i17 += g.c(22, this.V);
        }
        if (!this.W.isEmpty()) {
            i17 += g.c(23, this.W);
        }
        if (!this.X.isEmpty()) {
            i17 += g.c(24, this.X);
        }
        int i19 = this.Y;
        if (i19 != 0) {
            i17 += g.b(i19) + g.n(25);
        }
        this.f389935f = i17;
        return i17;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x0043. Please report as an issue. */
    @Override // com.xingin.xhssharesdk.a.k
    public final Object c(k.h hVar, Object obj, Object obj2) {
        switch (hVar) {
            case f389945a:
                return Z;
            case f389946b:
                k.i iVar = (k.i) obj;
                b bVar = (b) obj2;
                int i3 = this.f395325h;
                boolean z16 = i3 != 0;
                int i16 = bVar.f395325h;
                this.f395325h = iVar.d(z16, i3, i16 != 0, i16);
                this.f395326i = iVar.e(!this.f395326i.isEmpty(), this.f395326i, !bVar.f395326i.isEmpty(), bVar.f395326i);
                this.f395327m = iVar.e(!this.f395327m.isEmpty(), this.f395327m, !bVar.f395327m.isEmpty(), bVar.f395327m);
                this.C = iVar.e(!this.C.isEmpty(), this.C, !bVar.C.isEmpty(), bVar.C);
                this.D = iVar.e(!this.D.isEmpty(), this.D, !bVar.D.isEmpty(), bVar.D);
                this.E = iVar.e(!this.E.isEmpty(), this.E, !bVar.E.isEmpty(), bVar.E);
                this.F = iVar.e(!this.F.isEmpty(), this.F, !bVar.F.isEmpty(), bVar.F);
                this.G = iVar.e(!this.G.isEmpty(), this.G, !bVar.G.isEmpty(), bVar.G);
                this.H = iVar.e(!this.H.isEmpty(), this.H, !bVar.H.isEmpty(), bVar.H);
                this.I = iVar.e(!this.I.isEmpty(), this.I, !bVar.I.isEmpty(), bVar.I);
                this.J = iVar.e(!this.J.isEmpty(), this.J, !bVar.J.isEmpty(), bVar.J);
                this.K = iVar.e(!this.K.isEmpty(), this.K, !bVar.K.isEmpty(), bVar.K);
                this.L = iVar.e(!this.L.isEmpty(), this.L, !bVar.L.isEmpty(), bVar.L);
                int i17 = this.M;
                boolean z17 = i17 != 0;
                int i18 = bVar.M;
                this.M = iVar.d(z17, i17, i18 != 0, i18);
                this.N = iVar.e(!this.N.isEmpty(), this.N, !bVar.N.isEmpty(), bVar.N);
                this.P = iVar.e(!this.P.isEmpty(), this.P, !bVar.P.isEmpty(), bVar.P);
                this.Q = iVar.e(!this.Q.isEmpty(), this.Q, !bVar.Q.isEmpty(), bVar.Q);
                this.R = iVar.e(!this.R.isEmpty(), this.R, !bVar.R.isEmpty(), bVar.R);
                this.S = iVar.e(!this.S.isEmpty(), this.S, !bVar.S.isEmpty(), bVar.S);
                this.T = iVar.e(!this.T.isEmpty(), this.T, !bVar.T.isEmpty(), bVar.T);
                this.U = iVar.e(!this.U.isEmpty(), this.U, !bVar.U.isEmpty(), bVar.U);
                this.V = iVar.e(!this.V.isEmpty(), this.V, !bVar.V.isEmpty(), bVar.V);
                this.W = iVar.e(!this.W.isEmpty(), this.W, !bVar.W.isEmpty(), bVar.W);
                this.X = iVar.e(!this.X.isEmpty(), this.X, !bVar.X.isEmpty(), bVar.X);
                int i19 = this.Y;
                boolean z18 = i19 != 0;
                int i26 = bVar.Y;
                this.Y = iVar.d(z18, i19, i26 != 0, i26);
                return this;
            case f389947c:
                com.xingin.xhssharesdk.a.c cVar = (com.xingin.xhssharesdk.a.c) obj;
                while (!r0) {
                    try {
                        int k3 = cVar.k();
                        switch (k3) {
                            case 0:
                                r0 = true;
                            case 8:
                                this.f395325h = cVar.e();
                            case 18:
                                this.f395326i = cVar.i();
                            case 26:
                                this.f395327m = cVar.i();
                            case 34:
                                this.C = cVar.i();
                            case 42:
                                this.D = cVar.i();
                            case 50:
                                this.E = cVar.i();
                            case 58:
                                this.F = cVar.i();
                            case 66:
                                this.G = cVar.i();
                            case 74:
                                this.H = cVar.i();
                            case 82:
                                this.I = cVar.i();
                            case 90:
                                this.J = cVar.i();
                            case 98:
                                this.K = cVar.i();
                            case 106:
                                this.L = cVar.i();
                            case 112:
                                this.M = cVar.e();
                            case 122:
                                this.N = cVar.i();
                            case 130:
                                this.P = cVar.i();
                            case 138:
                                this.Q = cVar.i();
                            case 146:
                                this.R = cVar.i();
                            case 154:
                                this.S = cVar.i();
                            case 162:
                                this.T = cVar.i();
                            case 170:
                                this.U = cVar.i();
                            case 178:
                                this.V = cVar.i();
                            case 186:
                                this.W = cVar.i();
                            case 194:
                                this.X = cVar.i();
                            case 200:
                                this.Y = cVar.e();
                            default:
                                if (!cVar.h(k3)) {
                                    r0 = true;
                                }
                        }
                    } catch (m e16) {
                        throw new RuntimeException(e16);
                    } catch (IOException e17) {
                        throw new RuntimeException(new m(e17.getMessage()));
                    }
                }
                break;
            case f389948d:
                return null;
            case f389949e:
                return new b();
            case f389950f:
                return new a();
            case f389951g:
                break;
            case f389952h:
                if (f395324a0 == null) {
                    synchronized (b.class) {
                        if (f395324a0 == null) {
                            f395324a0 = new k.b(Z);
                        }
                    }
                }
                return f395324a0;
            default:
                throw new UnsupportedOperationException();
        }
        return Z;
    }
}
