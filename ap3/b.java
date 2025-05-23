package ap3;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.pager.Pager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import yo3.Offset;
import yo3.Size;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e0\r\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\tH\u0016R%\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0015\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018R\u0014\u0010#\u001a\u00020 8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010&\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010(\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010%\u00a8\u0006+"}, d2 = {"Lap3/b;", "Lap3/a;", "Lyo3/a;", "relativeToLocal", "e", "b", "sourceCoordinates", "relativeToSource", "a", "", "clipBounds", "Lyo3/b;", "d", "Lcom/tencent/kuikly/core/base/aa;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/kuikly/core/base/aa;", h.F, "()Lcom/tencent/kuikly/core/base/aa;", "ref", "g", "()Lyo3/a;", "position", "", "getX", "()F", HippyTKDListViewAdapter.X, "getY", "y", "getHeight", "height", "getWidth", "width", "Lyo3/d;", "getSize", "()Lyo3/d;", "size", "c", "()Lap3/a;", "parentLayoutCoordinates", "f", "parentCoordinates", "<init>", "(Lcom/tencent/kuikly/core/base/aa;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final aa<DeclarativeBaseView<?, ?>> ref;

    public b(aa<DeclarativeBaseView<?, ?>> ref) {
        Intrinsics.checkNotNullParameter(ref, "ref");
        this.ref = ref;
    }

    @Override // ap3.a
    public Offset a(a sourceCoordinates, Offset relativeToSource) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(relativeToSource, "relativeToSource");
        sourceCoordinates.c();
        float x16 = relativeToSource.getX() + c.c(sourceCoordinates).getX();
        float y16 = relativeToSource.getY() + c.c(sourceCoordinates).getY();
        DeclarativeBaseView<?, ?> d16 = c.d(sourceCoordinates);
        com.tencent.kuikly.core.layout.d dVar = null;
        if (d16 != null) {
            com.tencent.kuikly.core.layout.d dVar2 = new com.tencent.kuikly.core.layout.d(x16, y16, 0.0f, 0.0f);
            DeclarativeBaseView<?, ?> d17 = c.d(this);
            dVar = d16.convertFrame(dVar2, d17 instanceof ViewContainer ? (ViewContainer) d17 : null);
        }
        return new Offset(dVar != null ? dVar.getX() : 0.0f, dVar != null ? dVar.getY() : 0.0f);
    }

    @Override // ap3.a
    public Offset b(Offset relativeToLocal) {
        a b16;
        Offset a16;
        Intrinsics.checkNotNullParameter(relativeToLocal, "relativeToLocal");
        DeclarativeBaseView<?, ?> d16 = c.d(this);
        Object pager = d16 != null ? d16.getPager() : null;
        Pager pager2 = pager instanceof Pager ? (Pager) pager : null;
        return (pager2 == null || (b16 = c.b(pager2)) == null || (a16 = b16.a(this, relativeToLocal)) == null) ? Offset.INSTANCE.a() : a16;
    }

    @Override // ap3.a
    public a c() {
        DeclarativeBaseView<?, ?> b16;
        ViewContainer<?, ?> domParent;
        DeclarativeBaseView<?, ?> b17 = this.ref.b();
        if (Intrinsics.areEqual(b17 != null ? b17.getPager() : null, this.ref.b()) || (b16 = this.ref.b()) == null || (domParent = b16.getDomParent()) == null) {
            return null;
        }
        return c.b(domParent);
    }

    @Override // ap3.a
    public yo3.b d(a sourceCoordinates, boolean clipBounds) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        return yo3.c.a(a(sourceCoordinates, Offset.INSTANCE.a()), sourceCoordinates.getSize());
    }

    @Override // ap3.a
    public Offset e(Offset relativeToLocal) {
        Intrinsics.checkNotNullParameter(relativeToLocal, "relativeToLocal");
        return b(relativeToLocal);
    }

    @Override // ap3.a
    public a f() {
        return c();
    }

    public final Offset g() {
        FlexNode flexNode;
        com.tencent.kuikly.core.layout.d layoutFrame;
        FlexNode flexNode2;
        com.tencent.kuikly.core.layout.d layoutFrame2;
        DeclarativeBaseView<?, ?> b16 = this.ref.b();
        float f16 = 0.0f;
        float x16 = (b16 == null || (flexNode2 = b16.getFlexNode()) == null || (layoutFrame2 = flexNode2.getLayoutFrame()) == null) ? 0.0f : layoutFrame2.getX();
        DeclarativeBaseView<?, ?> b17 = this.ref.b();
        if (b17 != null && (flexNode = b17.getFlexNode()) != null && (layoutFrame = flexNode.getLayoutFrame()) != null) {
            f16 = layoutFrame.getY();
        }
        return new Offset(x16, f16);
    }

    @Override // ap3.a
    public float getHeight() {
        return getSize().getHeight();
    }

    @Override // ap3.a
    public Size getSize() {
        FlexNode flexNode;
        com.tencent.kuikly.core.layout.d layoutFrame;
        Size a16 = Size.INSTANCE.a();
        DeclarativeBaseView<?, ?> b16 = this.ref.b();
        return (b16 == null || (flexNode = b16.getFlexNode()) == null || (layoutFrame = flexNode.getLayoutFrame()) == null) ? a16 : new Size(layoutFrame.getWidth(), layoutFrame.getHeight());
    }

    @Override // ap3.a
    public float getWidth() {
        return getSize().getWidth();
    }

    @Override // ap3.a
    public float getX() {
        return g().getX();
    }

    @Override // ap3.a
    public float getY() {
        return g().getY();
    }

    public final aa<DeclarativeBaseView<?, ?>> h() {
        return this.ref;
    }
}
