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
public final class r implements c45.d {
    public static final a F = new a();
    public final String C;
    public final String D;
    public final c45.a E;

    /* renamed from: d, reason: collision with root package name */
    public final int f413243d;

    /* renamed from: e, reason: collision with root package name */
    public final String f413244e;

    /* renamed from: f, reason: collision with root package name */
    public final t f413245f;

    /* renamed from: h, reason: collision with root package name */
    public final int f413246h;

    /* renamed from: i, reason: collision with root package name */
    public final c45.a f413247i;

    /* renamed from: m, reason: collision with root package name */
    public final c45.a f413248m;

    public r() {
        this(0, null, null, 0, null, null, null, null, null, null, 1023, null);
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = F;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, Integer.valueOf(this.f413243d)) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413244e) + a17;
        c45.b a26 = aVar.a(3);
        Intrinsics.checkNotNull(a26);
        int a27 = iVar.a(3, a26, this.f413245f) + a19;
        c45.b a28 = aVar.a(4);
        Intrinsics.checkNotNull(a28);
        int a29 = iVar.a(4, a28, Integer.valueOf(this.f413246h)) + a27;
        c45.b a36 = aVar.a(5);
        Intrinsics.checkNotNull(a36);
        int a37 = iVar.a(5, a36, this.f413247i) + a29;
        c45.b a38 = aVar.a(6);
        Intrinsics.checkNotNull(a38);
        int a39 = iVar.a(6, a38, this.f413248m) + a37;
        c45.b a46 = aVar.a(7);
        Intrinsics.checkNotNull(a46);
        int a47 = iVar.a(7, a46, this.C) + a39;
        c45.b a48 = aVar.a(11);
        Intrinsics.checkNotNull(a48);
        int a49 = iVar.a(11, a48, this.D) + a47;
        c45.b a56 = aVar.a(100);
        Intrinsics.checkNotNull(a56);
        return iVar.a(100, a56, this.E) + a49;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = F;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, Integer.valueOf(this.f413243d));
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413244e);
        c45.b a18 = aVar.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, this.f413245f);
        c45.b a19 = aVar.a(4);
        Intrinsics.checkNotNull(a19);
        eVar.b(4, a19, Integer.valueOf(this.f413246h));
        c45.b a26 = aVar.a(5);
        Intrinsics.checkNotNull(a26);
        eVar.b(5, a26, this.f413247i);
        c45.b a27 = aVar.a(6);
        Intrinsics.checkNotNull(a27);
        eVar.b(6, a27, this.f413248m);
        c45.b a28 = aVar.a(7);
        Intrinsics.checkNotNull(a28);
        eVar.b(7, a28, this.C);
        c45.b a29 = aVar.a(11);
        Intrinsics.checkNotNull(a29);
        eVar.b(11, a29, this.D);
        c45.b a36 = aVar.a(100);
        Intrinsics.checkNotNull(a36);
        eVar.b(100, a36, this.E);
    }

    public r(int i3, String str, t tVar, int i16, c45.a aVar, c45.a aVar2, String str2, String str3, c45.a aVar3) {
        this.f413243d = i3;
        this.f413244e = str;
        this.f413245f = tVar;
        this.f413246h = i16;
        this.f413247i = aVar;
        this.f413248m = aVar2;
        this.C = str2;
        this.D = str3;
        this.E = aVar3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ r(int i3, String str, t tVar, int i16, c45.a aVar, c45.a aVar2, String str2, String str3, c45.a aVar3, Map map, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", null, 0, r10, r10, "", "", r10);
        c45.a aVar4 = c45.a.f30290b;
        MapsKt__MapsKt.emptyMap();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<r> {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [T, c45.a] */
        @Override // c45.d.a
        public final r b(c45.f fVar) {
            final Ref.IntRef intRef = new Ref.IntRef();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            final Ref.IntRef intRef2 = new Ref.IntRef();
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            ?? r16 = c45.a.f30290b;
            objectRef3.element = r16;
            final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            objectRef4.element = r16;
            final Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
            objectRef5.element = "";
            final Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
            objectRef6.element = "";
            final Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
            objectRef7.element = r16;
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.RspBody$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r5v10, types: [T, c45.a] */
                /* JADX WARN: Type inference failed for: r5v11, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r5v2, types: [T, c45.a] */
                /* JADX WARN: Type inference failed for: r5v5, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r5v6, types: [T, kuikly.com.tencent.trpcprotocol.search.unifysearch.t] */
                /* JADX WARN: Type inference failed for: r5v9, types: [T, c45.a] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 11) {
                        Ref.ObjectRef<String> objectRef8 = objectRef6;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef8.element = (String) obj;
                    } else if (intValue != 100) {
                        switch (intValue) {
                            case 1:
                                Ref.IntRef intRef3 = Ref.IntRef.this;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                                intRef3.element = ((Integer) obj).intValue();
                                break;
                            case 2:
                                Ref.ObjectRef<String> objectRef9 = objectRef;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                                objectRef9.element = (String) obj;
                                break;
                            case 3:
                                Ref.ObjectRef<t> objectRef10 = objectRef2;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.search.unifysearch.TabContentResult");
                                objectRef10.element = (t) obj;
                                break;
                            case 4:
                                Ref.IntRef intRef4 = intRef2;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                                intRef4.element = ((Integer) obj).intValue();
                                break;
                            case 5:
                                Ref.ObjectRef<c45.a> objectRef11 = objectRef3;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                                objectRef11.element = (c45.a) obj;
                                break;
                            case 6:
                                Ref.ObjectRef<c45.a> objectRef12 = objectRef4;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                                objectRef12.element = (c45.a) obj;
                                break;
                            case 7:
                                Ref.ObjectRef<String> objectRef13 = objectRef5;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                                objectRef13.element = (String) obj;
                                break;
                        }
                    } else {
                        Ref.ObjectRef<c45.a> objectRef14 = objectRef7;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                        objectRef14.element = (c45.a) obj;
                    }
                    return Unit.INSTANCE;
                }
            });
            return new r(intRef.element, (String) objectRef.element, (t) objectRef2.element, intRef2.element, (c45.a) objectRef3.element, (c45.a) objectRef4.element, (String) objectRef5.element, (String) objectRef6.element, (c45.a) objectRef7.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 11) {
                return new b.e.g(false);
            }
            if (i3 != 100) {
                switch (i3) {
                    case 1:
                        return new b.e.h(false);
                    case 2:
                        return new b.e.g(false);
                    case 3:
                        return new b.c(t.f413255h);
                    case 4:
                        return new b.e.h(false);
                    case 5:
                        return new b.e.C0167b(false);
                    case 6:
                        return new b.e.C0167b(false);
                    case 7:
                        return new b.e.g(false);
                    default:
                        return null;
                }
            }
            return new b.e.C0167b(false);
        }
    }
}
