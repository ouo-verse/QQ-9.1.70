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
public final class e implements c45.d {

    /* renamed from: h, reason: collision with root package name */
    public static final a f413284h = new a();

    /* renamed from: d, reason: collision with root package name */
    public final boolean f413285d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f413286e;

    /* renamed from: f, reason: collision with root package name */
    public final long f413287f;

    public e() {
        this(false, false, 0L, null, 15, null);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413284h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, Boolean.valueOf(this.f413285d)) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, Boolean.valueOf(this.f413286e)) + a17;
        c45.b a26 = aVar.a(10);
        Intrinsics.checkNotNull(a26);
        return iVar.a(10, a26, Long.valueOf(this.f413287f)) + a19;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413284h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, Boolean.valueOf(this.f413285d));
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, Boolean.valueOf(this.f413286e));
        c45.b a18 = aVar.a(10);
        Intrinsics.checkNotNull(a18);
        eVar.b(10, a18, Long.valueOf(this.f413287f));
    }

    public e(boolean z16, boolean z17, long j3) {
        this.f413285d = z16;
        this.f413286e = z17;
        this.f413287f = j3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(boolean z16, boolean z17, long j3, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(false, false, 0L);
        MapsKt__MapsKt.emptyMap();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<e> {
        @Override // c45.d.a
        public final e b(c45.f fVar) {
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            final Ref.LongRef longRef = new Ref.LongRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.trpc.relation.blacklist.CheckRsp$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.BooleanRef booleanRef3 = Ref.BooleanRef.this;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                        booleanRef3.element = ((Boolean) obj).booleanValue();
                    } else if (intValue == 2) {
                        Ref.BooleanRef booleanRef4 = booleanRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                        booleanRef4.element = ((Boolean) obj).booleanValue();
                    } else if (intValue == 10) {
                        Ref.LongRef longRef2 = longRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                        longRef2.element = ((Long) obj).longValue();
                    }
                    return Unit.INSTANCE;
                }
            });
            return new e(booleanRef.element, booleanRef2.element, longRef.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.a(false);
            }
            if (i3 == 2) {
                return new b.e.a(false);
            }
            if (i3 != 10) {
                return null;
            }
            return new b.e.i(false);
        }
    }
}
