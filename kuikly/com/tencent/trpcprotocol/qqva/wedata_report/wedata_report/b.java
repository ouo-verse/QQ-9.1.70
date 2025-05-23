package kuikly.com.tencent.trpcprotocol.qqva.wedata_report.wedata_report;

import c45.b;
import c45.c;
import c45.d;
import c45.f;
import c45.g;
import e45.e;
import e45.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b implements d {

    /* renamed from: f, reason: collision with root package name */
    public static final a f413168f = new a();

    /* renamed from: d, reason: collision with root package name */
    public final String f413169d;

    /* renamed from: e, reason: collision with root package name */
    public final List<kuikly.com.tencent.trpcprotocol.qqva.wedata_report.wedata_report.a> f413170e;

    public b(String str, List list) {
        this.f413169d = str;
        this.f413170e = list;
    }

    @Override // c45.e
    public final int getProtoSize() {
        i iVar = i.f395705a;
        a aVar = f413168f;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        int a17 = iVar.a(1, a16, this.f413169d) + 0;
        c45.b a18 = aVar.a(2);
        Intrinsics.checkNotNull(a18);
        return iVar.a(2, a18, this.f413170e) + a17;
    }

    @Override // c45.d
    public final void writeMessage(g gVar) {
        e eVar = gVar instanceof e ? (e) gVar : null;
        if (eVar == null) {
            return;
        }
        a aVar = f413168f;
        c45.b a16 = aVar.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413169d);
        c45.b a17 = aVar.a(2);
        Intrinsics.checkNotNull(a17);
        eVar.b(2, a17, this.f413170e);
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a implements d.a<b> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final b b(f fVar) {
            c45.c cVar;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.qqva.wedata_report.wedata_report.ReportReq$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r0v5, types: [T, java.util.Collection] */
                /* JADX WARN: Type inference failed for: r0v7 */
                /* JADX WARN: Type inference failed for: r0v8 */
                /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.String] */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    int intValue = num.intValue();
                    if (intValue == 1) {
                        Ref.ObjectRef<String> objectRef3 = objectRef;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        objectRef3.element = (String) obj;
                    } else if (intValue == 2) {
                        Ref.ObjectRef<c.a<a>> objectRef4 = objectRef2;
                        c.a<a> aVar = objectRef4.element;
                        ?? r06 = aVar;
                        if (aVar == null) {
                            r06 = new c.a();
                        }
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqva.wedata_report.wedata_report.Item>");
                        CollectionsKt__MutableCollectionsKt.addAll((Collection) r06, (Sequence) obj);
                        objectRef4.element = r06;
                    }
                    return Unit.INSTANCE;
                }
            });
            String str = (String) objectRef.element;
            c.a aVar = (c.a) objectRef2.element;
            if (aVar != null) {
                ArrayList<T> arrayList = aVar.f30316d;
                arrayList.trimToSize();
                cVar = new c45.c(arrayList, null);
            } else {
                cVar = c45.c.f30313h;
            }
            return new b(str, cVar);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.e.g(false);
            }
            if (i3 != 2) {
                return null;
            }
            return new b.f(new b.c(kuikly.com.tencent.trpcprotocol.qqva.wedata_report.wedata_report.a.f413166e), false);
        }
    }
}
