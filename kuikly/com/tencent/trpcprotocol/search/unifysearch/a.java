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
public final class a implements c45.d {

    /* renamed from: f, reason: collision with root package name */
    public static final C10685a f413172f = new C10685a();

    /* renamed from: d, reason: collision with root package name */
    public final int f413173d;

    /* renamed from: e, reason: collision with root package name */
    public final int f413174e;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a() {
        this(r0, r0, 7);
        int i3 = 0;
    }

    @Override // c45.e
    public final int getProtoSize() {
        e45.i iVar = e45.i.f395705a;
        C10685a c10685a = f413172f;
        c45.b a16 = c10685a.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, Integer.valueOf(this.f413173d)) + 0;
        c45.b a18 = c10685a.a(2);
        Intrinsics.checkNotNull(a18);
        return iVar.a(2, a18, Integer.valueOf(this.f413174e)) + a17;
    }

    @Override // c45.d
    public final void writeMessage(c45.g gVar) {
        e45.e eVar = gVar instanceof e45.e ? (e45.e) gVar : null;
        if (eVar == null) {
            return;
        }
        C10685a c10685a = f413172f;
        c45.b a16 = c10685a.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, Integer.valueOf(this.f413173d));
        c45.b a17 = c10685a.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, Integer.valueOf(this.f413174e));
    }

    public a(int i3, int i16) {
        this.f413173d = i3;
        this.f413174e = i16;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ a(int i3, int i16, int i17) {
        this(i3, i16);
        i3 = (i17 & 1) != 0 ? d.c.f30317b.b().getValue() : i3;
        i16 = (i17 & 2) != 0 ? d.c.f30317b.b().getValue() : i16;
        if ((i17 & 4) != 0) {
            MapsKt__MapsKt.emptyMap();
        }
    }

    /* compiled from: P */
    /* renamed from: kuikly.com.tencent.trpcprotocol.search.unifysearch.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10685a implements d.a<a> {
        @Override // c45.d.a
        public final a b(c45.f fVar) {
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            final Ref.IntRef intRef2 = new Ref.IntRef();
            intRef2.element = 0;
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.search.unifysearch.ChannelConditonFilter$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.IntRef intRef3 = Ref.IntRef.this;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.search.unifysearch.UnifysearchKt.CHANNELRANKTYPE }");
                        intRef3.element = ((Integer) obj).intValue();
                    } else if (intValue == 2) {
                        Ref.IntRef intRef4 = intRef2;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.search.unifysearch.UnifysearchKt.CHANNELCONTENTTYPE }");
                        intRef4.element = ((Integer) obj).intValue();
                    }
                    return Unit.INSTANCE;
                }
            });
            return new a(intRef.element, intRef2.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.a(false);
            }
            if (i3 != 2) {
                return null;
            }
            return new b.a(false);
        }
    }
}
