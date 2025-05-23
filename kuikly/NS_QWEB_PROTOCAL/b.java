package kuikly.NS_QWEB_PROTOCAL;

import c45.b;
import c45.d;
import c45.f;
import c45.g;
import e45.e;
import e45.i;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b implements c45.d {

    /* renamed from: f, reason: collision with root package name */
    public static final a f413144f = new a();

    /* renamed from: d, reason: collision with root package name */
    public final Integer f413145d;

    /* renamed from: e, reason: collision with root package name */
    public final String f413146e;

    public b() {
        this(null, null, null, 7, null);
    }

    @Override // c45.e
    public final int getProtoSize() {
        i iVar = i.f395705a;
        a aVar = f413144f;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413145d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        return iVar.a(2, a18, this.f413146e) + a17;
    }

    @Override // c45.d
    public final void writeMessage(g gVar) {
        e eVar = gVar instanceof e ? (e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413144f;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413145d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413146e);
    }

    public b(Integer num, String str) {
        this.f413145d = num;
        this.f413146e = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Integer num, String str, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
        MapsKt__MapsKt.emptyMap();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<b> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final b b(f fVar) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.NS_QWEB_PROTOCAL.StEncryption$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Integer] */
                /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.String] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<Integer> objectRef3 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                        objectRef3.element = (Integer) obj;
                    } else if (intValue == 2) {
                        Ref.ObjectRef<String> objectRef4 = objectRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef4.element = (String) obj;
                    }
                    return Unit.INSTANCE;
                }
            });
            return new b((Integer) objectRef.element, (String) objectRef2.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.h(true);
            }
            if (i3 != 2) {
                return null;
            }
            return new b.e.g(true);
        }
    }
}
