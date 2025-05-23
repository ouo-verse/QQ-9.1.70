package kuikly.trpc.relation.blacklist;

import c45.b;
import c45.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d implements c45.d {

    /* renamed from: i, reason: collision with root package name */
    public static final a f413279i = new a();

    /* renamed from: d, reason: collision with root package name */
    public final kuikly.trpc.relation.blacklist.a f413280d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f413281e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f413282f;

    /* renamed from: h, reason: collision with root package name */
    public final f f413283h;

    public d(kuikly.trpc.relation.blacklist.a aVar, boolean z16, boolean z17, f fVar) {
        this.f413280d = aVar;
        this.f413281e = z16;
        this.f413282f = z17;
        this.f413283h = fVar;
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413279i;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413280d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, Boolean.valueOf(this.f413281e)) + a17;
        c45.b a26 = aVar.a(3);
        Intrinsics.checkNotNull(a26);
        int a27 = iVar.a(3, a26, Boolean.valueOf(this.f413282f)) + a19;
        c45.b a28 = aVar.a(4);
        Intrinsics.checkNotNull(a28);
        return iVar.a(4, a28, this.f413283h) + a27;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413279i;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413280d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, Boolean.valueOf(this.f413281e));
        c45.b a18 = aVar.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, Boolean.valueOf(this.f413282f));
        c45.b a19 = aVar.a(4);
        Intrinsics.checkNotNull(a19);
        eVar.b(4, a19, this.f413283h);
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<d> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final d b(c45.f fVar) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.trpc.relation.blacklist.CheckReq$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r4v1, types: [kuikly.trpc.relation.blacklist.a, T] */
                /* JADX WARN: Type inference failed for: r4v6, types: [T, kuikly.trpc.relation.blacklist.f] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<a> objectRef3 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.trpc.relation.blacklist.Account");
                        objectRef3.element = (a) obj;
                    } else if (intValue == 2) {
                        Ref.BooleanRef booleanRef3 = booleanRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                        booleanRef3.element = ((Boolean) obj).booleanValue();
                    } else if (intValue == 3) {
                        Ref.BooleanRef booleanRef4 = booleanRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                        booleanRef4.element = ((Boolean) obj).booleanValue();
                    } else if (intValue == 4) {
                        Ref.ObjectRef<f> objectRef4 = objectRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.trpc.relation.blacklist.Scene");
                        objectRef4.element = (f) obj;
                    }
                    return Unit.INSTANCE;
                }
            });
            return new d((kuikly.trpc.relation.blacklist.a) objectRef.element, booleanRef.element, booleanRef2.element, (f) objectRef2.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.c(kuikly.trpc.relation.blacklist.a.C);
            }
            if (i3 == 2) {
                return new b.e.a(false);
            }
            if (i3 == 3) {
                return new b.e.a(false);
            }
            if (i3 != 4) {
                return null;
            }
            return new b.c(f.f413288f);
        }
    }
}
