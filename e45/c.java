package e45;

import c45.b;
import c45.d;
import c45.m;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import pbandk.InvalidProtocolBufferException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c implements c45.f {

    /* renamed from: b, reason: collision with root package name */
    public static final a f395702b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final g f395703a;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a {
        public final <T> Sequence<T> a(b.f<T> fVar, int i3, g gVar) {
            Sequence<T> sequenceOf;
            if (!k.a(i3, 2) || !fVar.f30309a.e()) {
                sequenceOf = SequencesKt__SequencesKt.sequenceOf(d.b(fVar.f30309a, gVar));
                Intrinsics.checkNotNull(sequenceOf, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of pbandk.internal.binary.BinaryMessageDecoder.Companion.readRepeatedField>");
                return sequenceOf;
            }
            return gVar.m(fVar.f30309a);
        }
    }

    public c(g gVar) {
        this.f395703a = gVar;
    }

    public static void a(c cVar, int i3, int i16) {
        m mVar;
        List listOf;
        List plus;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        m.a l3 = cVar.f395703a.l(i16);
        if (l3 == null) {
            return;
        }
        Integer valueOf = Integer.valueOf(i3);
        m mVar2 = (m) linkedHashMap.get(Integer.valueOf(i3));
        if (mVar2 == null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(l3);
            mVar = new m(i3, listOf);
        } else {
            plus = CollectionsKt___CollectionsKt.plus((Collection<? extends m.a>) ((Collection<? extends Object>) mVar2.f30323b), l3);
            mVar = new m(mVar2.f30322a, plus);
        }
        linkedHashMap.put(valueOf, mVar);
    }

    public final <T extends c45.d> Map<Integer, m> b(d.a<T> aVar, Function2<? super Integer, Object, Unit> function2) {
        Object b16;
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                int i3 = this.f395703a.i();
                if (j.b(i3, 0)) {
                    return linkedHashMap;
                }
                int i16 = i3 >>> 3;
                int i17 = i3 & 7;
                c45.b a16 = aVar.a(i16);
                if (a16 != null && d.a(a16, i17)) {
                    if (a16 instanceof b.f) {
                        b16 = f395702b.a((b.f) a16, i17, this.f395703a);
                    } else {
                        b16 = d.b(a16, this.f395703a);
                    }
                    function2.invoke(Integer.valueOf(i16), b16);
                }
                a(this, i16, i17);
            }
        } catch (InvalidProtocolBufferException e16) {
            throw e16;
        } catch (Exception e17) {
            throw new InvalidProtocolBufferException(e17);
        }
    }

    @Override // c45.f
    public final c45.j g(c45.j jVar) {
        Object b16;
        while (true) {
            try {
                int i3 = this.f395703a.i();
                if (j.b(i3, 0)) {
                    return jVar;
                }
                int i16 = i3 >>> 3;
                int i17 = i3 & 7;
                c45.h hVar = jVar.getIndexes().get(Integer.valueOf(i16));
                c45.b bVar = hVar != null ? hVar.f30321c : null;
                if (bVar != null && d.a(bVar, i17)) {
                    if (bVar instanceof b.f) {
                        b16 = f395702b.a((b.f) bVar, i17, this.f395703a);
                    } else {
                        b16 = d.b(bVar, this.f395703a);
                    }
                    jVar.setValue(i16, b16);
                }
                a(this, i16, i17);
            } catch (InvalidProtocolBufferException e16) {
                throw e16;
            } catch (Exception e17) {
                throw new InvalidProtocolBufferException(e17);
            }
        }
    }
}
