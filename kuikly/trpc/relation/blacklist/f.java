package kuikly.trpc.relation.blacklist;

import c45.b;
import c45.d;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f implements c45.d {

    /* renamed from: f, reason: collision with root package name */
    public static final a f413288f = new a();

    /* renamed from: d, reason: collision with root package name */
    public final String f413289d;

    /* renamed from: e, reason: collision with root package name */
    public final String f413290e;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f() {
        this(r0, r0, 7);
        String str = null;
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413288f;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413289d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        return iVar.a(2, a18, this.f413290e) + a17;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413288f;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413289d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413290e);
    }

    public f(String str, String str2) {
        this.f413289d = str;
        this.f413290e = str2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ f(String str, String str2, int i3) {
        this(str, str2);
        str = (i3 & 1) != 0 ? null : str;
        str2 = (i3 & 2) != 0 ? null : str2;
        if ((i3 & 4) != 0) {
            MapsKt__MapsKt.emptyMap();
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<f> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final f b(c45.f fVar) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.trpc.relation.blacklist.Scene$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.String] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<String> objectRef3 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef3.element = (String) obj;
                    } else if (intValue == 2) {
                        Ref.ObjectRef<String> objectRef4 = objectRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef4.element = (String) obj;
                    }
                    return Unit.INSTANCE;
                }
            });
            return new f((String) objectRef.element, (String) objectRef2.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.g(true);
            }
            if (i3 != 2) {
                return null;
            }
            return new b.e.g(true);
        }
    }
}
