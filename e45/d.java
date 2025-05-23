package e45;

import c45.b;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d {
    public static final boolean a(c45.b bVar, int i3) {
        return k.a(bVar.c(), i3) || ((bVar instanceof b.f) && ((b.f) bVar).f30309a.e() && k.a(i3, 2));
    }

    public static final Object b(c45.b bVar, g gVar) {
        if (bVar instanceof b.e.c) {
            return Double.valueOf(gVar.readDouble());
        }
        if (bVar instanceof b.e.d) {
            return Float.valueOf(gVar.readFloat());
        }
        if (bVar instanceof b.e.f) {
            return Long.valueOf(gVar.b());
        }
        if (bVar instanceof b.e.i) {
            return Long.valueOf(gVar.f());
        }
        if (bVar instanceof b.e.C0168e) {
            return Integer.valueOf(gVar.h());
        }
        if (bVar instanceof b.e.a) {
            return Boolean.valueOf(gVar.c());
        }
        if (bVar instanceof b.e.g) {
            return gVar.d();
        }
        if (bVar instanceof b.e.C0167b) {
            return gVar.e();
        }
        if (bVar instanceof b.e.h) {
            return Integer.valueOf(gVar.a());
        }
        if (bVar instanceof b.c) {
            return gVar.j(((b.c) bVar).f30297a);
        }
        if (bVar instanceof b.d) {
            return gVar.g(((b.d) bVar).f30298a);
        }
        if (bVar instanceof b.a) {
            return Integer.valueOf(gVar.k(((b.a) bVar).f30292a).getValue());
        }
        if (!(bVar instanceof b.f)) {
            if (bVar instanceof b.C0166b) {
                return gVar.j(((b.C0166b) bVar).f30295a);
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("Repeated values should've been handled by the caller of this method".toString());
    }
}
