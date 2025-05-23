package kuikly.com.tencent.trpcprotocol.search.unifysearch;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d implements c45.d {

    /* renamed from: f, reason: collision with root package name */
    public static final a f413185f = new a();

    /* renamed from: d, reason: collision with root package name */
    public final String f413186d;

    /* renamed from: e, reason: collision with root package name */
    public final int f413187e;

    public d() {
        this(null, 0, null, 7, null);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413185f;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413186d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        return iVar.a(2, a18, Integer.valueOf(this.f413187e)) + a17;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413185f;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413186d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, Integer.valueOf(this.f413187e));
    }

    public d(String str, int i3) {
        this.f413186d = str;
        this.f413187e = i3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(String str, int i3, Map map, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0);
        MapsKt__MapsKt.emptyMap();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<d> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final d b(c45.f fVar) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.IntRef intRef = new Ref.IntRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.District$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<String> objectRef2 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef2.element = (String) obj;
                    } else if (intValue == 2) {
                        Ref.IntRef intRef2 = intRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                        intRef2.element = ((Integer) obj).intValue();
                    }
                    return Unit.INSTANCE;
                }
            });
            return new d((String) objectRef.element, intRef.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.g(false);
            }
            if (i3 != 2) {
                return null;
            }
            return new b.e.h(false);
        }
    }
}
