package kuikly.trpc.relation.blacklist;

import c45.b;
import c45.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b implements c45.d {

    /* renamed from: h, reason: collision with root package name */
    public static final a f413271h = new a();

    /* renamed from: d, reason: collision with root package name */
    public final kuikly.trpc.relation.blacklist.a f413272d;

    /* renamed from: e, reason: collision with root package name */
    public final long f413273e;

    /* renamed from: f, reason: collision with root package name */
    public final f f413274f;

    public b(kuikly.trpc.relation.blacklist.a aVar, long j3, f fVar) {
        this.f413272d = aVar;
        this.f413273e = j3;
        this.f413274f = fVar;
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413271h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413272d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, Long.valueOf(this.f413273e)) + a17;
        c45.b a26 = aVar.a(3);
        Intrinsics.checkNotNull(a26);
        return iVar.a(3, a26, this.f413274f) + a19;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413271h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413272d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, Long.valueOf(this.f413273e));
        c45.b a18 = aVar.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, this.f413274f);
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<b> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final b b(c45.f fVar) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.LongRef longRef = new Ref.LongRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.trpc.relation.blacklist.BlockReq$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r4v1, types: [kuikly.trpc.relation.blacklist.a, T] */
                /* JADX WARN: Type inference failed for: r4v3, types: [T, kuikly.trpc.relation.blacklist.f] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<a> objectRef3 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.trpc.relation.blacklist.Account");
                        objectRef3.element = (a) obj;
                    } else if (intValue == 2) {
                        Ref.LongRef longRef2 = longRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                        longRef2.element = ((Long) obj).longValue();
                    } else if (intValue == 3) {
                        Ref.ObjectRef<f> objectRef4 = objectRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.trpc.relation.blacklist.Scene");
                        objectRef4.element = (f) obj;
                    }
                    return Unit.INSTANCE;
                }
            });
            return new b((kuikly.trpc.relation.blacklist.a) objectRef.element, longRef.element, (f) objectRef2.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.c(kuikly.trpc.relation.blacklist.a.C);
            }
            if (i3 == 2) {
                return new b.e.i(false);
            }
            if (i3 != 3) {
                return null;
            }
            return new b.c(f.f413288f);
        }
    }
}
