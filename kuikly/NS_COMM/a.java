package kuikly.NS_COMM;

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

    /* renamed from: f, reason: collision with root package name */
    public static final C10680a f413135f = new C10680a();

    /* renamed from: d, reason: collision with root package name */
    public final String f413136d;

    /* renamed from: e, reason: collision with root package name */
    public final String f413137e;

    public a(String str, String str2) {
        this.f413136d = str;
        this.f413137e = str2;
    }

    @Override // c45.e
    public final int getProtoSize() {
        i iVar = i.f395705a;
        C10680a c10680a = f413135f;
        b a16 = c10680a.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413136d) + 0;
        b a18 = c10680a.a(2);
        Intrinsics.checkNotNull(a18);
        return iVar.a(2, a18, this.f413137e) + a17;
    }

    @Override // c45.d
    public final void writeMessage(g gVar) {
        e eVar = gVar instanceof e ? (e) gVar : null;
        if (eVar == null) {
            return;
        }
        C10680a c10680a = f413135f;
        b a16 = c10680a.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413136d);
        b a17 = c10680a.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413137e);
    }

    /* compiled from: P */
    /* renamed from: kuikly.NS_COMM.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10680a implements d.a<a> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final a b(f fVar) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ((c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.NS_COMM.Entry$Companion$decodeWith$unknownFields$1
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
            return new a((String) objectRef.element, (String) objectRef2.element);
        }

        @Override // c45.d.a
        public final b a(int i3) {
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
