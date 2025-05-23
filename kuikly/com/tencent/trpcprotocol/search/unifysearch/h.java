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
public final class h implements c45.d {

    /* renamed from: f, reason: collision with root package name */
    public static final a f413202f = new a();

    /* renamed from: d, reason: collision with root package name */
    public final int f413203d;

    /* renamed from: e, reason: collision with root package name */
    public final String f413204e;

    public h() {
        this(0, null, null, 7, null);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413202f;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, Integer.valueOf(this.f413203d)) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        return iVar.a(2, a18, this.f413204e) + a17;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413202f;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, Integer.valueOf(this.f413203d));
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413204e);
    }

    public h(int i3, String str) {
        this.f413203d = i3;
        this.f413204e = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ h(int i3, String str, Map map, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, "");
        int value = d.c.f30317b.b().getValue();
        MapsKt__MapsKt.emptyMap();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<h> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final h b(c45.f fVar) {
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.GroupContentRankType$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.String] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.IntRef intRef2 = Ref.IntRef.this;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.search.unifysearch.UnifysearchKt.GROUPRANKTYPE }");
                        intRef2.element = ((Integer) obj).intValue();
                    } else if (intValue == 2) {
                        Ref.ObjectRef<String> objectRef2 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef2.element = (String) obj;
                    }
                    return Unit.INSTANCE;
                }
            });
            return new h(intRef.element, (String) objectRef.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.a(false);
            }
            if (i3 != 2) {
                return null;
            }
            return new b.e.g(false);
        }
    }
}
