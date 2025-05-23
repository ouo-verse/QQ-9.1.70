package kuikly.com.tencent.mobileqq.pb.qwallet;

import c45.b;
import c45.d;
import c45.f;
import c45.g;
import e45.c;
import e45.e;
import e45.i;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b implements d {

    /* renamed from: e, reason: collision with root package name */
    public static final a f413161e = new a();

    /* renamed from: d, reason: collision with root package name */
    public final c45.a f413162d;

    public b() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.e
    public final int getProtoSize() {
        i iVar = i.f395705a;
        c45.b a16 = f413161e.a(1);
        Intrinsics.checkNotNull(a16);
        return iVar.a(1, a16, this.f413162d) + 0;
    }

    @Override // c45.d
    public final void writeMessage(g gVar) {
        e eVar = gVar instanceof e ? (e) gVar : null;
        if (eVar == null) {
            return;
        }
        c45.b a16 = f413161e.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413162d);
    }

    public b(c45.a aVar) {
        this.f413162d = aVar;
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<b> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final b b(f fVar) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ((c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.mobileqq.pb.qwallet.OriginCgiRsp$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r3v1, types: [T, c45.a] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    if (num.intValue() == 1) {
                        Ref.ObjectRef<c45.a> objectRef2 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                        objectRef2.element = (c45.a) obj;
                    }
                    return Unit.INSTANCE;
                }
            });
            return new b((c45.a) objectRef.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.C0167b(true);
            }
            return null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(c45.a aVar, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
        MapsKt__MapsKt.emptyMap();
    }
}
