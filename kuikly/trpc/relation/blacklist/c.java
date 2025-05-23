package kuikly.trpc.relation.blacklist;

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
public final class c implements c45.d {

    /* renamed from: h, reason: collision with root package name */
    public static final a f413275h = new a();

    /* renamed from: d, reason: collision with root package name */
    public final long f413276d;

    /* renamed from: e, reason: collision with root package name */
    public final String f413277e;

    /* renamed from: f, reason: collision with root package name */
    public final long f413278f;

    public c() {
        this(0L, null, 0L, null, 15, null);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413275h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, Long.valueOf(this.f413276d)) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413277e) + a17;
        c45.b a26 = aVar.a(10);
        Intrinsics.checkNotNull(a26);
        return iVar.a(10, a26, Long.valueOf(this.f413278f)) + a19;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413275h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, Long.valueOf(this.f413276d));
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413277e);
        c45.b a18 = aVar.a(10);
        Intrinsics.checkNotNull(a18);
        eVar.b(10, a18, Long.valueOf(this.f413278f));
    }

    public c(long j3, String str, long j16) {
        this.f413276d = j3;
        this.f413277e = str;
        this.f413278f = j16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(long j3, String str, long j16, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", 0L);
        MapsKt__MapsKt.emptyMap();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<c> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final c b(c45.f fVar) {
            final Ref.LongRef longRef = new Ref.LongRef();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.LongRef longRef2 = new Ref.LongRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.trpc.relation.blacklist.BlockRsp$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.String] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.LongRef longRef3 = Ref.LongRef.this;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                        longRef3.element = ((Long) obj).longValue();
                    } else if (intValue == 2) {
                        Ref.ObjectRef<String> objectRef2 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef2.element = (String) obj;
                    } else if (intValue == 10) {
                        Ref.LongRef longRef4 = longRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                        longRef4.element = ((Long) obj).longValue();
                    }
                    return Unit.INSTANCE;
                }
            });
            return new c(longRef.element, (String) objectRef.element, longRef2.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.i(false);
            }
            if (i3 == 2) {
                return new b.e.g(false);
            }
            if (i3 != 10) {
                return null;
            }
            return new b.e.i(false);
        }
    }
}
