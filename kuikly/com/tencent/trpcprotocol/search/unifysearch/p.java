package kuikly.com.tencent.trpcprotocol.search.unifysearch;

import c45.b;
import c45.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class p implements c45.d {
    public static final a I = new a();
    public final g C;
    public final String D;
    public final kuikly.com.tencent.trpcprotocol.search.unifysearch.a E;
    public final c45.a F;
    public final boolean G;
    public final c45.a H;

    /* renamed from: d, reason: collision with root package name */
    public final String f413235d;

    /* renamed from: e, reason: collision with root package name */
    public final String f413236e;

    /* renamed from: f, reason: collision with root package name */
    public final u f413237f;

    /* renamed from: h, reason: collision with root package name */
    public final c45.a f413238h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f413239i;

    /* renamed from: m, reason: collision with root package name */
    public final c f413240m;

    public p(String str, String str2, u uVar, c45.a aVar, boolean z16, c cVar, g gVar, String str3, kuikly.com.tencent.trpcprotocol.search.unifysearch.a aVar2, c45.a aVar3, boolean z17, c45.a aVar4) {
        this.f413235d = str;
        this.f413236e = str2;
        this.f413237f = uVar;
        this.f413238h = aVar;
        this.f413239i = z16;
        this.f413240m = cVar;
        this.C = gVar;
        this.D = str3;
        this.E = aVar2;
        this.F = aVar3;
        this.G = z17;
        this.H = aVar4;
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = I;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413235d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413236e) + a17;
        c45.b a26 = aVar.a(3);
        Intrinsics.checkNotNull(a26);
        int a27 = iVar.a(3, a26, this.f413237f) + a19;
        c45.b a28 = aVar.a(4);
        Intrinsics.checkNotNull(a28);
        int a29 = iVar.a(4, a28, this.f413238h) + a27;
        c45.b a36 = aVar.a(5);
        Intrinsics.checkNotNull(a36);
        int a37 = iVar.a(5, a36, Boolean.valueOf(this.f413239i)) + a29;
        c45.b a38 = aVar.a(6);
        Intrinsics.checkNotNull(a38);
        int a39 = iVar.a(6, a38, this.f413240m) + a37;
        c45.b a46 = aVar.a(7);
        Intrinsics.checkNotNull(a46);
        int a47 = iVar.a(7, a46, this.C) + a39;
        c45.b a48 = aVar.a(8);
        Intrinsics.checkNotNull(a48);
        int a49 = iVar.a(8, a48, this.D) + a47;
        c45.b a56 = aVar.a(9);
        Intrinsics.checkNotNull(a56);
        int a57 = iVar.a(9, a56, this.E) + a49;
        c45.b a58 = aVar.a(10);
        Intrinsics.checkNotNull(a58);
        int a59 = iVar.a(10, a58, this.F) + a57;
        c45.b a65 = aVar.a(11);
        Intrinsics.checkNotNull(a65);
        int a66 = iVar.a(11, a65, Boolean.valueOf(this.G)) + a59;
        c45.b a67 = aVar.a(100);
        Intrinsics.checkNotNull(a67);
        return iVar.a(100, a67, this.H) + a66;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = I;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413235d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413236e);
        c45.b a18 = aVar.a(3);
        Intrinsics.checkNotNull(a18);
        eVar.b(3, a18, this.f413237f);
        c45.b a19 = aVar.a(4);
        Intrinsics.checkNotNull(a19);
        eVar.b(4, a19, this.f413238h);
        c45.b a26 = aVar.a(5);
        Intrinsics.checkNotNull(a26);
        eVar.b(5, a26, Boolean.valueOf(this.f413239i));
        c45.b a27 = aVar.a(6);
        Intrinsics.checkNotNull(a27);
        eVar.b(6, a27, this.f413240m);
        c45.b a28 = aVar.a(7);
        Intrinsics.checkNotNull(a28);
        eVar.b(7, a28, this.C);
        c45.b a29 = aVar.a(8);
        Intrinsics.checkNotNull(a29);
        eVar.b(8, a29, this.D);
        c45.b a36 = aVar.a(9);
        Intrinsics.checkNotNull(a36);
        eVar.b(9, a36, this.E);
        c45.b a37 = aVar.a(10);
        Intrinsics.checkNotNull(a37);
        eVar.b(10, a37, this.F);
        c45.b a38 = aVar.a(11);
        Intrinsics.checkNotNull(a38);
        eVar.b(11, a38, Boolean.valueOf(this.G));
        c45.b a39 = aVar.a(100);
        Intrinsics.checkNotNull(a39);
        eVar.b(100, a39, this.H);
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<p> {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [T, c45.a] */
        @Override // c45.d.a
        public final p b(c45.f fVar) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = "";
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            ?? r16 = c45.a.f30290b;
            objectRef4.element = r16;
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            final Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
            objectRef7.element = "";
            final Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
            objectRef9.element = r16;
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            final Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
            objectRef10.element = r16;
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.ReqBody$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r5v1, types: [T, c45.a] */
                /* JADX WARN: Type inference failed for: r5v10, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r5v11, types: [T, kuikly.com.tencent.trpcprotocol.search.unifysearch.a] */
                /* JADX WARN: Type inference failed for: r5v12, types: [T, c45.a] */
                /* JADX WARN: Type inference failed for: r5v2, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r5v3, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r5v4, types: [T, kuikly.com.tencent.trpcprotocol.search.unifysearch.u] */
                /* JADX WARN: Type inference failed for: r5v5, types: [T, c45.a] */
                /* JADX WARN: Type inference failed for: r5v8, types: [T, kuikly.com.tencent.trpcprotocol.search.unifysearch.c] */
                /* JADX WARN: Type inference failed for: r5v9, types: [T, kuikly.com.tencent.trpcprotocol.search.unifysearch.g] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue != 100) {
                        switch (intValue) {
                            case 1:
                                Ref.ObjectRef<String> objectRef11 = objectRef;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                                objectRef11.element = (String) obj;
                                break;
                            case 2:
                                Ref.ObjectRef<String> objectRef12 = objectRef2;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                                objectRef12.element = (String) obj;
                                break;
                            case 3:
                                Ref.ObjectRef<u> objectRef13 = objectRef3;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.search.unifysearch.TabInfo");
                                objectRef13.element = (u) obj;
                                break;
                            case 4:
                                Ref.ObjectRef<c45.a> objectRef14 = objectRef4;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                                objectRef14.element = (c45.a) obj;
                                break;
                            case 5:
                                Ref.BooleanRef booleanRef3 = booleanRef;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                                booleanRef3.element = ((Boolean) obj).booleanValue();
                                break;
                            case 6:
                                Ref.ObjectRef<c> objectRef15 = objectRef5;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.search.unifysearch.DeviceInfo");
                                objectRef15.element = (c) obj;
                                break;
                            case 7:
                                Ref.ObjectRef<g> objectRef16 = objectRef6;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.search.unifysearch.GroupConditonFilter");
                                objectRef16.element = (g) obj;
                                break;
                            case 8:
                                Ref.ObjectRef<String> objectRef17 = objectRef7;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                                objectRef17.element = (String) obj;
                                break;
                            case 9:
                                Ref.ObjectRef<a> objectRef18 = objectRef8;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.search.unifysearch.ChannelConditonFilter");
                                objectRef18.element = (a) obj;
                                break;
                            case 10:
                                Ref.ObjectRef<c45.a> objectRef19 = objectRef9;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                                objectRef19.element = (c45.a) obj;
                                break;
                            case 11:
                                Ref.BooleanRef booleanRef4 = booleanRef2;
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                                booleanRef4.element = ((Boolean) obj).booleanValue();
                                break;
                        }
                    } else {
                        Ref.ObjectRef<c45.a> objectRef20 = objectRef10;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                        objectRef20.element = (c45.a) obj;
                    }
                    return Unit.INSTANCE;
                }
            });
            return new p((String) objectRef.element, (String) objectRef2.element, (u) objectRef3.element, (c45.a) objectRef4.element, booleanRef.element, (c) objectRef5.element, (g) objectRef6.element, (String) objectRef7.element, (kuikly.com.tencent.trpcprotocol.search.unifysearch.a) objectRef8.element, (c45.a) objectRef9.element, booleanRef2.element, (c45.a) objectRef10.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 != 100) {
                switch (i3) {
                    case 1:
                        return new b.e.g(false);
                    case 2:
                        return new b.e.g(false);
                    case 3:
                        return new b.c(u.f413259f);
                    case 4:
                        return new b.e.C0167b(false);
                    case 5:
                        return new b.e.a(false);
                    case 6:
                        return new b.c(c.f413180i);
                    case 7:
                        return new b.c(g.f413198h);
                    case 8:
                        return new b.e.g(false);
                    case 9:
                        return new b.c(kuikly.com.tencent.trpcprotocol.search.unifysearch.a.f413172f);
                    case 10:
                        return new b.e.C0167b(false);
                    case 11:
                        return new b.e.a(false);
                    default:
                        return null;
                }
            }
            return new b.e.C0167b(false);
        }
    }
}
