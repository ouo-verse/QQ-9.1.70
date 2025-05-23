package ap3;

import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.aa;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yo3.Offset;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u001f\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\t*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u001d\u0010\u000f\u001a\u00020\u0000*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lap3/a;", "Lyo3/a;", "c", "(Lap3/a;)Lyo3/a;", "position", "Lcom/tencent/kuikly/core/layout/d;", "a", "(Lap3/a;)Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "d", "(Lap3/a;)Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "view", "b", "(Lcom/tencent/kuikly/core/base/DeclarativeBaseView;)Lap3/a;", "layoutCoordinates", "ntcompose_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c {
    public static final com.tencent.kuikly.core.layout.d a(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return new com.tencent.kuikly.core.layout.d(c(aVar).getX(), c(aVar).getY(), aVar.getSize().getWidth(), aVar.getSize().getHeight());
    }

    public static final a b(DeclarativeBaseView<?, ?> declarativeBaseView) {
        Intrinsics.checkNotNullParameter(declarativeBaseView, "<this>");
        Object obj = declarativeBaseView.getExtProps().get("LayoutCoordinatesKey");
        if (obj == null) {
            obj = new b(new aa(declarativeBaseView.getPagerId(), declarativeBaseView.getNativeRef()));
            declarativeBaseView.getExtProps().put("LayoutCoordinatesKey", obj);
        }
        return (a) obj;
    }

    public static final Offset c(a aVar) {
        Offset g16;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        b bVar = aVar instanceof b ? (b) aVar : null;
        return (bVar == null || (g16 = bVar.g()) == null) ? Offset.INSTANCE.a() : g16;
    }

    public static final DeclarativeBaseView<?, ?> d(a aVar) {
        aa<DeclarativeBaseView<?, ?>> h16;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        b bVar = aVar instanceof b ? (b) aVar : null;
        if (bVar == null || (h16 = bVar.h()) == null) {
            return null;
        }
        return h16.b();
    }
}
