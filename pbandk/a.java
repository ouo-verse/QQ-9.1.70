package pbandk;

import c45.d;
import c45.f;
import c45.g;
import e45.e;
import e45.i;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.AbstractMap;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: P */
/* loaded from: classes34.dex */
public final class a<K, V> extends AbstractMap<K, V> {

    /* renamed from: e, reason: collision with root package name */
    public static final b f425869e = new b();

    /* renamed from: f, reason: collision with root package name */
    public static final a f425870f;

    /* renamed from: d, reason: collision with root package name */
    public final Set<c<K, V>> f425871d;

    /* compiled from: P */
    /* renamed from: pbandk.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C10999a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Set<c<K, V>> f425872a = new LinkedHashSet();
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static final class b {
    }

    static {
        Set emptySet;
        emptySet = SetsKt__SetsKt.emptySet();
        f425870f = new a(emptySet);
    }

    public a(Set<c<K, V>> set) {
        this.f425871d = set;
    }

    @Override // kotlin.collections.AbstractMap, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    public final Set<c<K, V>> getEntries() {
        return this.f425871d;
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static final class c<K, V> implements Map.Entry<K, V>, d, KMappedMarker {

        /* renamed from: d, reason: collision with root package name */
        public final K f425873d;

        /* renamed from: e, reason: collision with root package name */
        public final V f425874e;

        /* renamed from: f, reason: collision with root package name */
        public final C11000a<K, V> f425875f;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Object obj, Object obj2, C11000a c11000a) {
            this.f425873d = obj;
            this.f425874e = obj2;
            this.f425875f = c11000a;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f425873d;
        }

        @Override // c45.e
        public final int getProtoSize() {
            i iVar = i.f395705a;
            return iVar.a(2, this.f425875f.f425877b, this.f425874e) + iVar.a(1, this.f425875f.f425876a, this.f425873d) + 0;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f425874e;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v3) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // c45.d
        public final void writeMessage(g gVar) {
            e eVar = gVar instanceof e ? (e) gVar : null;
            if (eVar == null) {
                return;
            }
            eVar.b(1, this.f425875f.f425876a, this.f425873d);
            eVar.b(2, this.f425875f.f425877b, this.f425874e);
        }

        /* compiled from: P */
        /* renamed from: pbandk.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C11000a<K, V> implements d.a<c<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            public final c45.b f425876a;

            /* renamed from: b, reason: collision with root package name */
            public final c45.b f425877b;

            public C11000a(c45.b bVar, c45.b bVar2) {
                this.f425876a = bVar;
                this.f425877b = bVar2;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
            @Override // c45.d.a
            public final d b(f fVar) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = this.f425876a.a();
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = this.f425877b.a();
                ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: pbandk.MessageMap$Entry$Companion$decodeWith$unknownFields$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function2
                    public final Unit invoke(Integer num, Object obj) {
                        int intValue = num.intValue();
                        if (intValue == 1) {
                            objectRef.element = obj;
                        } else if (intValue == 2) {
                            objectRef2.element = obj;
                        }
                        return Unit.INSTANCE;
                    }
                });
                return new c(objectRef.element, objectRef2.element, this);
            }

            @Override // c45.d.a
            public final c45.b a(int i3) {
                if (i3 == 1) {
                    return this.f425876a;
                }
                if (i3 != 2) {
                    return null;
                }
                return this.f425877b;
            }
        }
    }
}
