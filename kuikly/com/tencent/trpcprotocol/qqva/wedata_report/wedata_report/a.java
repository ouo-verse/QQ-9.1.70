package kuikly.com.tencent.trpcprotocol.qqva.wedata_report.wedata_report;

import c45.b;
import c45.d;
import c45.f;
import c45.g;
import e45.e;
import e45.i;
import java.util.Collection;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import pbandk.a;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a implements d {

    /* renamed from: e, reason: collision with root package name */
    public static final C10684a f413166e = new C10684a();

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, String> f413167d;

    public a(Map map) {
        this.f413167d = map;
    }

    @Override // c45.e
    public final int getProtoSize() {
        i iVar = i.f395705a;
        c45.b a16 = f413166e.a(1);
        Intrinsics.checkNotNull(a16);
        return iVar.a(1, a16, this.f413167d) + 0;
    }

    @Override // c45.d
    public final void writeMessage(g gVar) {
        e eVar = gVar instanceof e ? (e) gVar : null;
        if (eVar == null) {
            return;
        }
        c45.b a16 = f413166e.a(1);
        Intrinsics.checkNotNull(a16);
        eVar.b(1, a16, this.f413167d);
    }

    /* compiled from: P */
    /* renamed from: kuikly.com.tencent.trpcprotocol.qqva.wedata_report.wedata_report.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10684a implements d.a<a> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c45.d.a
        public final a b(f fVar) {
            pbandk.a aVar;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ((e45.c) fVar).b(this, new Function2<Integer, Object, Unit>() { // from class: kuikly.com.tencent.trpcprotocol.qqva.wedata_report.wedata_report.Item$Companion$decodeWith$unknownFields$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Type inference failed for: r0v3, types: [pbandk.a$a, T] */
                /* JADX WARN: Type inference failed for: r0v5 */
                /* JADX WARN: Type inference failed for: r0v6 */
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Integer num, Object obj) {
                    if (num.intValue() == 1) {
                        Ref.ObjectRef<a.C10999a<String, String>> objectRef2 = objectRef;
                        a.C10999a<String, String> c10999a = objectRef2.element;
                        ?? r06 = c10999a;
                        if (c10999a == null) {
                            r06 = new a.C10999a();
                        }
                        Collection collection = r06.f425872a;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.MessageMap.Entry<kotlin.String, kotlin.String>");
                        collection.add((a.c) obj);
                        objectRef2.element = r06;
                    }
                    return Unit.INSTANCE;
                }
            });
            a.C10999a c10999a = (a.C10999a) objectRef.element;
            if (c10999a != null) {
                aVar = new pbandk.a(c10999a.f425872a);
            } else {
                aVar = pbandk.a.f425870f;
                Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type pbandk.MessageMap<K of pbandk.MessageMap.Builder.Companion.fixed, V of pbandk.MessageMap.Builder.Companion.fixed>");
            }
            return new a(aVar);
        }

        @Override // c45.d.a
        public final c45.b a(int i3) {
            if (i3 == 1) {
                return new b.C0166b(new b.e.g(false), new b.e.g(false));
            }
            return null;
        }
    }
}
