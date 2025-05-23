package kuikly.com.tencent.trpcprotocol.search.unifysearch;

import c45.b;
import c45.d;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class u implements c45.d {

    /* renamed from: f, reason: collision with root package name */
    public static final a f413259f = new a();

    /* renamed from: d, reason: collision with root package name */
    public final String f413260d;

    /* renamed from: e, reason: collision with root package name */
    public final long f413261e;

    public u() {
        this(null, 0L, 7);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413259f;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413260d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        return iVar.a(2, a18, Long.valueOf(this.f413261e)) + a17;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413259f;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413260d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, Long.valueOf(this.f413261e));
    }

    public u(String str, long j3) {
        this.f413260d = str;
        this.f413261e = j3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ u(String str, long j3, int i3) {
        this(str, j3);
        str = (i3 & 1) != 0 ? "" : str;
        j3 = (i3 & 2) != 0 ? 0L : j3;
        if ((i3 & 4) != 0) {
            MapsKt__MapsKt.emptyMap();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<u> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final u b(c45.f fVar) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.LongRef longRef = new Ref.LongRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.TabInfo$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.String] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<String> objectRef2 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef2.element = (String) obj;
                    } else if (intValue == 2) {
                        Ref.LongRef longRef2 = longRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                        longRef2.element = ((Long) obj).longValue();
                    }
                    return Unit.INSTANCE;
                }
            });
            return new u((String) objectRef.element, longRef.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.g(false);
            }
            if (i3 != 2) {
                return null;
            }
            return new b.e.i(false);
        }
    }
}
