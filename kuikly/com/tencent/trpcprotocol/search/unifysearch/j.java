package kuikly.com.tencent.trpcprotocol.search.unifysearch;

import c45.b;
import c45.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j implements c45.d {

    /* renamed from: h, reason: collision with root package name */
    public static final a f413209h = new a();

    /* renamed from: d, reason: collision with root package name */
    public final String f413210d;

    /* renamed from: e, reason: collision with root package name */
    public final c f413211e;

    /* renamed from: f, reason: collision with root package name */
    public final c45.a f413212f;

    public j(String str, c cVar, c45.a aVar) {
        this.f413210d = str;
        this.f413211e = cVar;
        this.f413212f = aVar;
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        a aVar = f413209h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413210d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        int a19 = iVar.a(2, a18, this.f413211e) + a17;
        c45.b a26 = aVar.a(100);
        Intrinsics.checkNotNull(a26);
        return iVar.a(100, a26, this.f413212f) + a19;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413209h;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413210d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413211e);
        c45.b a18 = aVar.a(100);
        Intrinsics.checkNotNull(a18);
        eVar.b(100, a18, this.f413212f);
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<j> {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [T, c45.a] */
        @Override // c45.d.a
        public final j b(c45.f fVar) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            objectRef3.element = c45.a.f30290b;
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.NetResultTabsReq$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
                /* JADX WARN: Type inference failed for: r3v2, types: [T, kuikly.com.tencent.trpcprotocol.search.unifysearch.c] */
                /* JADX WARN: Type inference failed for: r3v3, types: [T, c45.a] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<String> objectRef4 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef4.element = (String) obj;
                    } else if (intValue == 2) {
                        Ref.ObjectRef<c> objectRef5 = objectRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.search.unifysearch.DeviceInfo");
                        objectRef5.element = (c) obj;
                    } else if (intValue == 100) {
                        Ref.ObjectRef<c45.a> objectRef6 = objectRef3;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                        objectRef6.element = (c45.a) obj;
                    }
                    return Unit.INSTANCE;
                }
            });
            return new j((String) objectRef.element, (c) objectRef2.element, (c45.a) objectRef3.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.g(false);
            }
            if (i3 == 2) {
                return new b.c(c.f413180i);
            }
            if (i3 != 100) {
                return null;
            }
            return new b.e.C0167b(false);
        }
    }
}
