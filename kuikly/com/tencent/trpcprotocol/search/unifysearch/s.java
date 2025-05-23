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
public final class s implements c45.d {
    public static final a D = new a();
    public final int C;

    /* renamed from: d, reason: collision with root package name */
    public final String f413249d;

    /* renamed from: e, reason: collision with root package name */
    public final String f413250e;

    /* renamed from: f, reason: collision with root package name */
    public final long f413251f;

    /* renamed from: h, reason: collision with root package name */
    public final int f413252h;

    /* renamed from: i, reason: collision with root package name */
    public final String f413253i;

    /* renamed from: m, reason: collision with root package name */
    public final c45.a f413254m;

    public s() {
        this(null, null, 0L, 0, null, null, 0, null, 255, null);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = D;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413249d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413250e) + a17;
        c45.b a26 = aVar.a(3);
        Intrinsics.checkNotNull(a26);
        int a27 = iVar.a(3, a26, Long.valueOf(this.f413251f)) + a19;
        c45.b a28 = aVar.a(4);
        Intrinsics.checkNotNull(a28);
        int a29 = iVar.a(4, a28, Integer.valueOf(this.f413252h)) + a27;
        c45.b a36 = aVar.a(5);
        Intrinsics.checkNotNull(a36);
        int a37 = iVar.a(5, a36, this.f413253i) + a29;
        c45.b a38 = aVar.a(6);
        Intrinsics.checkNotNull(a38);
        int a39 = iVar.a(6, a38, this.f413254m) + a37;
        c45.b a46 = aVar.a(7);
        Intrinsics.checkNotNull(a46);
        return iVar.a(7, a46, Integer.valueOf(this.C)) + a39;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = D;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413249d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413250e);
        c45.b a18 = aVar.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, Long.valueOf(this.f413251f));
        c45.b a19 = aVar.a(4);
        Intrinsics.checkNotNull(a19);
        eVar.b(4, a19, Integer.valueOf(this.f413252h));
        c45.b a26 = aVar.a(5);
        Intrinsics.checkNotNull(a26);
        eVar.b(5, a26, this.f413253i);
        c45.b a27 = aVar.a(6);
        Intrinsics.checkNotNull(a27);
        eVar.b(6, a27, this.f413254m);
        c45.b a28 = aVar.a(7);
        Intrinsics.checkNotNull(a28);
        eVar.b(7, a28, Integer.valueOf(this.C));
    }

    public s(String str, String str2, long j3, int i3, String str3, c45.a aVar, int i16) {
        this.f413249d = str;
        this.f413250e = str2;
        this.f413251f = j3;
        this.f413252h = i3;
        this.f413253i = str3;
        this.f413254m = aVar;
        this.C = i16;
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<s> {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [T, c45.a] */
        @Override // c45.d.a
        public final s b(c45.f fVar) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = "";
            final Ref.LongRef longRef = new Ref.LongRef();
            final Ref.IntRef intRef = new Ref.IntRef();
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.element = "";
            final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            objectRef4.element = c45.a.f30290b;
            final Ref.IntRef intRef2 = new Ref.IntRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.TabContent$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v6, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r4v7, types: [T, c45.a] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    switch (num.intValue()) {
                        case 1:
                            Ref.ObjectRef<String> objectRef5 = objectRef;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            objectRef5.element = (String) obj;
                            break;
                        case 2:
                            Ref.ObjectRef<String> objectRef6 = objectRef2;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            objectRef6.element = (String) obj;
                            break;
                        case 3:
                            Ref.LongRef longRef2 = longRef;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                            longRef2.element = ((Long) obj).longValue();
                            break;
                        case 4:
                            Ref.IntRef intRef3 = intRef;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                            intRef3.element = ((Integer) obj).intValue();
                            break;
                        case 5:
                            Ref.ObjectRef<String> objectRef7 = objectRef3;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                            objectRef7.element = (String) obj;
                            break;
                        case 6:
                            Ref.ObjectRef<c45.a> objectRef8 = objectRef4;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                            objectRef8.element = (c45.a) obj;
                            break;
                        case 7:
                            Ref.IntRef intRef4 = intRef2;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                            intRef4.element = ((Integer) obj).intValue();
                            break;
                    }
                    return Unit.INSTANCE;
                }
            });
            return new s((String) objectRef.element, (String) objectRef2.element, longRef.element, intRef.element, (String) objectRef3.element, (c45.a) objectRef4.element, intRef2.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            switch (i3) {
                case 1:
                    return new b.e.g(false);
                case 2:
                    return new b.e.g(false);
                case 3:
                    return new b.e.i(false);
                case 4:
                    return new b.e.h(false);
                case 5:
                    return new b.e.g(false);
                case 6:
                    return new b.e.C0167b(false);
                case 7:
                    return new b.e.h(false);
                default:
                    return null;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ s(String str, String str2, long j3, int i3, String str3, c45.a aVar, int i16, Map map, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", 0L, 0, "", r8, 0);
        c45.a aVar2 = c45.a.f30290b;
        MapsKt__MapsKt.emptyMap();
    }
}
