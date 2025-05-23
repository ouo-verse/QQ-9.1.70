package ap3;

import ap3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yo3.Offset;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0000\u001a\f\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0000\u00a8\u0006\u0007"}, d2 = {"Lap3/a;", "Lyo3/a;", "c", "d", "Lyo3/b;", "a", "b", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class d {
    public static final yo3.b a(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return a.C0062a.a(b(aVar), aVar, false, 2, null);
    }

    public static final a b(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        a c16 = aVar.c();
        while (true) {
            a aVar2 = c16;
            a aVar3 = aVar;
            aVar = aVar2;
            if (aVar == null) {
                return aVar3;
            }
            c16 = aVar.c();
        }
    }

    public static final Offset c(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.b(Offset.INSTANCE.a());
    }

    public static final Offset d(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.e(Offset.INSTANCE.a());
    }
}
