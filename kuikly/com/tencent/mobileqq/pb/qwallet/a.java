package kuikly.com.tencent.mobileqq.pb.qwallet;

import c45.b;
import c45.d;
import c45.f;
import c45.g;
import e45.c;
import e45.e;
import e45.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a implements d {

    /* renamed from: e, reason: collision with root package name */
    public static final C10682a f413159e = new C10682a();

    /* renamed from: d, reason: collision with root package name */
    public final c45.a f413160d;

    public a(c45.a aVar) {
        this.f413160d = aVar;
    }

    @Override // c45.e
    public final int getProtoSize() {
        i iVar = i.f395705a;
        c45.b a16 = f413159e.a(1);
        Intrinsics.checkNotNull(a16);
        return iVar.a(1, a16, this.f413160d) + 0;
    }

    @Override // c45.d
    public final void writeMessage(g gVar) {
        e eVar = gVar instanceof e ? (e) gVar : null;
        if (eVar == null) {
            return;
        }
        c45.b a16 = f413159e.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413160d);
    }

    /* compiled from: P */
    /* renamed from: kuikly.com.tencent.mobileqq.pb.qwallet.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10682a implements d.a<a> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final a b(f fVar) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ((c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.mobileqq.pb.qwallet.OriginCgiReq$Companion$decodeWith$unknownFields$1
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
            return new a((c45.a) objectRef.element);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.C0167b(true);
            }
            return null;
        }
    }
}
