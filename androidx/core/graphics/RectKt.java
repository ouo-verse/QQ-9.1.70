package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\r\u0010\u0004\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0004\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0012\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u0003H\u0086\b\u001a\r\u0010\u0017\u001a\u00020\u0003*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\u0015\u0010\u0019\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u00a8\u0006\u001d"}, d2 = {"and", "Landroid/graphics/Rect;", "r", "Landroid/graphics/RectF;", "component1", "", "", "component2", "component3", "component4", "contains", "", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "minus", "xy", "Landroid/graphics/Region;", "or", QCircleDaTongConstant.ElementParamValue.PLUS, Element.ELEMENT_NAME_TIMES, "factor", "toRect", "toRectF", "toRegion", "transform", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Matrix;", "xor", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class RectKt {
    @SuppressLint({"CheckResult"})
    @NotNull
    public static final Rect and(@NotNull Rect and, @NotNull Rect r16) {
        Intrinsics.checkNotNullParameter(and, "$this$and");
        Intrinsics.checkNotNullParameter(r16, "r");
        Rect rect = new Rect(and);
        rect.intersect(r16);
        return rect;
    }

    public static final int component1(@NotNull Rect component1) {
        Intrinsics.checkNotNullParameter(component1, "$this$component1");
        return component1.left;
    }

    public static final int component2(@NotNull Rect component2) {
        Intrinsics.checkNotNullParameter(component2, "$this$component2");
        return component2.top;
    }

    public static final int component3(@NotNull Rect component3) {
        Intrinsics.checkNotNullParameter(component3, "$this$component3");
        return component3.right;
    }

    public static final int component4(@NotNull Rect component4) {
        Intrinsics.checkNotNullParameter(component4, "$this$component4");
        return component4.bottom;
    }

    public static final boolean contains(@NotNull Rect contains, @NotNull Point p16) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        Intrinsics.checkNotNullParameter(p16, "p");
        return contains.contains(p16.x, p16.y);
    }

    @NotNull
    public static final Region minus(@NotNull Rect minus, @NotNull Rect r16) {
        Intrinsics.checkNotNullParameter(minus, "$this$minus");
        Intrinsics.checkNotNullParameter(r16, "r");
        Region region = new Region(minus);
        region.op(r16, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final Rect or(@NotNull Rect or5, @NotNull Rect r16) {
        Intrinsics.checkNotNullParameter(or5, "$this$or");
        Intrinsics.checkNotNullParameter(r16, "r");
        Rect rect = new Rect(or5);
        rect.union(r16);
        return rect;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect plus, @NotNull Rect r16) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(r16, "r");
        Rect rect = new Rect(plus);
        rect.union(r16);
        return rect;
    }

    @NotNull
    public static final Rect times(@NotNull Rect times, int i3) {
        Intrinsics.checkNotNullParameter(times, "$this$times");
        Rect rect = new Rect(times);
        rect.top *= i3;
        rect.left *= i3;
        rect.right *= i3;
        rect.bottom *= i3;
        return rect;
    }

    @NotNull
    public static final Rect toRect(@NotNull RectF toRect) {
        Intrinsics.checkNotNullParameter(toRect, "$this$toRect");
        Rect rect = new Rect();
        toRect.roundOut(rect);
        return rect;
    }

    @NotNull
    public static final RectF toRectF(@NotNull Rect toRectF) {
        Intrinsics.checkNotNullParameter(toRectF, "$this$toRectF");
        return new RectF(toRectF);
    }

    @NotNull
    public static final Region toRegion(@NotNull Rect toRegion) {
        Intrinsics.checkNotNullParameter(toRegion, "$this$toRegion");
        return new Region(toRegion);
    }

    @NotNull
    public static final RectF transform(@NotNull RectF transform, @NotNull Matrix m3) {
        Intrinsics.checkNotNullParameter(transform, "$this$transform");
        Intrinsics.checkNotNullParameter(m3, "m");
        m3.mapRect(transform);
        return transform;
    }

    @NotNull
    public static final Region xor(@NotNull Rect xor, @NotNull Rect r16) {
        Intrinsics.checkNotNullParameter(xor, "$this$xor");
        Intrinsics.checkNotNullParameter(r16, "r");
        Region region = new Region(xor);
        region.op(r16, Region.Op.XOR);
        return region;
    }

    public static final float component1(@NotNull RectF component1) {
        Intrinsics.checkNotNullParameter(component1, "$this$component1");
        return component1.left;
    }

    public static final float component2(@NotNull RectF component2) {
        Intrinsics.checkNotNullParameter(component2, "$this$component2");
        return component2.top;
    }

    public static final float component3(@NotNull RectF component3) {
        Intrinsics.checkNotNullParameter(component3, "$this$component3");
        return component3.right;
    }

    public static final float component4(@NotNull RectF component4) {
        Intrinsics.checkNotNullParameter(component4, "$this$component4");
        return component4.bottom;
    }

    public static final boolean contains(@NotNull RectF contains, @NotNull PointF p16) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        Intrinsics.checkNotNullParameter(p16, "p");
        return contains.contains(p16.x, p16.y);
    }

    @NotNull
    public static final Region toRegion(@NotNull RectF toRegion) {
        Intrinsics.checkNotNullParameter(toRegion, "$this$toRegion");
        Rect rect = new Rect();
        toRegion.roundOut(rect);
        return new Region(rect);
    }

    @SuppressLint({"CheckResult"})
    @NotNull
    public static final RectF and(@NotNull RectF and, @NotNull RectF r16) {
        Intrinsics.checkNotNullParameter(and, "$this$and");
        Intrinsics.checkNotNullParameter(r16, "r");
        RectF rectF = new RectF(and);
        rectF.intersect(r16);
        return rectF;
    }

    @NotNull
    public static final Region minus(@NotNull RectF minus, @NotNull RectF r16) {
        Intrinsics.checkNotNullParameter(minus, "$this$minus");
        Intrinsics.checkNotNullParameter(r16, "r");
        Rect rect = new Rect();
        minus.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r16.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final RectF or(@NotNull RectF or5, @NotNull RectF r16) {
        Intrinsics.checkNotNullParameter(or5, "$this$or");
        Intrinsics.checkNotNullParameter(r16, "r");
        RectF rectF = new RectF(or5);
        rectF.union(r16);
        return rectF;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF plus, @NotNull RectF r16) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(r16, "r");
        RectF rectF = new RectF(plus);
        rectF.union(r16);
        return rectF;
    }

    @NotNull
    public static final Region xor(@NotNull RectF xor, @NotNull RectF r16) {
        Intrinsics.checkNotNullParameter(xor, "$this$xor");
        Intrinsics.checkNotNullParameter(r16, "r");
        Rect rect = new Rect();
        xor.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r16.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect plus, int i3) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Rect rect = new Rect(plus);
        rect.offset(i3, i3);
        return rect;
    }

    @NotNull
    public static final RectF times(@NotNull RectF times, float f16) {
        Intrinsics.checkNotNullParameter(times, "$this$times");
        RectF rectF = new RectF(times);
        rectF.top *= f16;
        rectF.left *= f16;
        rectF.right *= f16;
        rectF.bottom *= f16;
        return rectF;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF plus, float f16) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        RectF rectF = new RectF(plus);
        rectF.offset(f16, f16);
        return rectF;
    }

    @NotNull
    public static final Rect plus(@NotNull Rect plus, @NotNull Point xy5) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(xy5, "xy");
        Rect rect = new Rect(plus);
        rect.offset(xy5.x, xy5.y);
        return rect;
    }

    @NotNull
    public static final Rect minus(@NotNull Rect minus, int i3) {
        Intrinsics.checkNotNullParameter(minus, "$this$minus");
        Rect rect = new Rect(minus);
        int i16 = -i3;
        rect.offset(i16, i16);
        return rect;
    }

    @NotNull
    public static final RectF plus(@NotNull RectF plus, @NotNull PointF xy5) {
        Intrinsics.checkNotNullParameter(plus, "$this$plus");
        Intrinsics.checkNotNullParameter(xy5, "xy");
        RectF rectF = new RectF(plus);
        rectF.offset(xy5.x, xy5.y);
        return rectF;
    }

    @NotNull
    public static final RectF times(@NotNull RectF times, int i3) {
        Intrinsics.checkNotNullParameter(times, "$this$times");
        float f16 = i3;
        RectF rectF = new RectF(times);
        rectF.top *= f16;
        rectF.left *= f16;
        rectF.right *= f16;
        rectF.bottom *= f16;
        return rectF;
    }

    @NotNull
    public static final RectF minus(@NotNull RectF minus, float f16) {
        Intrinsics.checkNotNullParameter(minus, "$this$minus");
        RectF rectF = new RectF(minus);
        float f17 = -f16;
        rectF.offset(f17, f17);
        return rectF;
    }

    @NotNull
    public static final Rect minus(@NotNull Rect minus, @NotNull Point xy5) {
        Intrinsics.checkNotNullParameter(minus, "$this$minus");
        Intrinsics.checkNotNullParameter(xy5, "xy");
        Rect rect = new Rect(minus);
        rect.offset(-xy5.x, -xy5.y);
        return rect;
    }

    @NotNull
    public static final RectF minus(@NotNull RectF minus, @NotNull PointF xy5) {
        Intrinsics.checkNotNullParameter(minus, "$this$minus");
        Intrinsics.checkNotNullParameter(xy5, "xy");
        RectF rectF = new RectF(minus);
        rectF.offset(-xy5.x, -xy5.y);
        return rectF;
    }
}
