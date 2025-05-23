package ap3;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;
import yo3.Offset;
import yo3.Size;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0002H&J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\tH&R\u0014\u0010\u0010\u001a\u00020\r8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00118&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001c\u00a8\u0006 "}, d2 = {"Lap3/a;", "", "Lyo3/a;", "relativeToLocal", "e", "b", "sourceCoordinates", "relativeToSource", "a", "", "clipBounds", "Lyo3/b;", "d", "Lyo3/d;", "getSize", "()Lyo3/d;", "size", "", "getX", "()F", HippyTKDListViewAdapter.X, "getY", "y", "getWidth", "width", "getHeight", "height", "c", "()Lap3/a;", "parentLayoutCoordinates", "f", "parentCoordinates", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public interface a {
    Offset a(a sourceCoordinates, Offset relativeToSource);

    Offset b(Offset relativeToLocal);

    a c();

    yo3.b d(a sourceCoordinates, boolean clipBounds);

    Offset e(Offset relativeToLocal);

    a f();

    float getHeight();

    Size getSize();

    float getWidth();

    float getX();

    float getY();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: ap3.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static final class C0062a {
        public static /* synthetic */ yo3.b a(a aVar, a aVar2, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                return aVar.d(aVar2, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localBoundingBoxOf");
        }
    }
}
