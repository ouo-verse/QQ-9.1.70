package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\n\u001a3\u0010\b\u001a\u00020\t*\u00020\u00012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000bH\u0086\b\u00f8\u0001\u0000\u001a\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010*\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0017"}, d2 = {"and", "Landroid/graphics/Region;", "r", "Landroid/graphics/Rect;", "contains", "", "p", "Landroid/graphics/Point;", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", CanvasView.ACTION_RECT, "iterator", "", "minus", "not", "or", QCircleDaTongConstant.ElementParamValue.PLUS, "unaryMinus", "xor", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class RegionKt {
    @NotNull
    public static final Region and(@NotNull Region and, @NotNull Rect r16) {
        Intrinsics.checkNotNullParameter(and, "$this$and");
        Intrinsics.checkNotNullParameter(r16, "r");
        Region region = new Region(and);
        region.op(r16, Region.Op.INTERSECT);
        return region;
    }

    public static final boolean contains(@NotNull Region contains, @NotNull Point p16) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        Intrinsics.checkNotNullParameter(p16, "p");
        return contains.contains(p16.x, p16.y);
    }

    public static final void forEach(@NotNull Region forEach, @NotNull Function1<? super Rect, Unit> action) {
        Intrinsics.checkNotNullParameter(forEach, "$this$forEach");
        Intrinsics.checkNotNullParameter(action, "action");
        RegionIterator regionIterator = new RegionIterator(forEach);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            } else {
                action.invoke(rect);
            }
        }
    }

    @NotNull
    public static final Iterator<Rect> iterator(@NotNull Region iterator) {
        Intrinsics.checkNotNullParameter(iterator, "$this$iterator");
        return new RegionKt$iterator$1(iterator);
    }

    @NotNull
    public static final Region minus(@NotNull Region minus, @NotNull Rect r16) {
        Intrinsics.checkNotNullParameter(minus, "$this$minus");
        Intrinsics.checkNotNullParameter(r16, "r");
        Region region = new Region(minus);
        region.op(r16, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final Region not(@NotNull Region not) {
        Intrinsics.checkNotNullParameter(not, "$this$not");
        Region region = new Region(not.getBounds());
        region.op(not, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final Region or(@NotNull Region or5, @NotNull Rect r16) {
        Intrinsics.checkNotNullParameter(or5, "$this$or");
        Intrinsics.checkNotNullParameter(r16, "r");
        Region region = new Region(or5);
        region.union(r16);
        return region;
    }

    @NotNull
    public static final Region plus(@NotNull Region plus, @NotNull Rect r16) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(r16, "r");
        Region region = new Region(plus);
        region.union(r16);
        return region;
    }

    @NotNull
    public static final Region unaryMinus(@NotNull Region unaryMinus) {
        Intrinsics.checkNotNullParameter(unaryMinus, "$this$unaryMinus");
        Region region = new Region(unaryMinus.getBounds());
        region.op(unaryMinus, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final Region xor(@NotNull Region xor, @NotNull Rect r16) {
        Intrinsics.checkNotNullParameter(xor, "$this$xor");
        Intrinsics.checkNotNullParameter(r16, "r");
        Region region = new Region(xor);
        region.op(r16, Region.Op.XOR);
        return region;
    }

    @NotNull
    public static final Region and(@NotNull Region and, @NotNull Region r16) {
        Intrinsics.checkNotNullParameter(and, "$this$and");
        Intrinsics.checkNotNullParameter(r16, "r");
        Region region = new Region(and);
        region.op(r16, Region.Op.INTERSECT);
        return region;
    }

    @NotNull
    public static final Region minus(@NotNull Region minus, @NotNull Region r16) {
        Intrinsics.checkNotNullParameter(minus, "$this$minus");
        Intrinsics.checkNotNullParameter(r16, "r");
        Region region = new Region(minus);
        region.op(r16, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final Region or(@NotNull Region or5, @NotNull Region r16) {
        Intrinsics.checkNotNullParameter(or5, "$this$or");
        Intrinsics.checkNotNullParameter(r16, "r");
        Region region = new Region(or5);
        region.op(r16, Region.Op.UNION);
        return region;
    }

    @NotNull
    public static final Region plus(@NotNull Region plus, @NotNull Region r16) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(r16, "r");
        Region region = new Region(plus);
        region.op(r16, Region.Op.UNION);
        return region;
    }

    @NotNull
    public static final Region xor(@NotNull Region xor, @NotNull Region r16) {
        Intrinsics.checkNotNullParameter(xor, "$this$xor");
        Intrinsics.checkNotNullParameter(r16, "r");
        Region region = new Region(xor);
        region.op(r16, Region.Op.XOR);
        return region;
    }
}
