package com.tencent.mobileqq.wink.editor.sticker;

import android.graphics.Matrix;
import android.view.View;
import com.tencent.mobileqq.wink.editor.model.PointF;
import com.tencent.videocut.model.RectF;
import com.tencent.videocut.model.SizeF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a\u0016\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005\u001a\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\f\"\u0018\u0010\u0011\u001a\u00020\u000e*\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0018\u0010\u0013\u001a\u00020\u000e*\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010\"\u0018\u0010\u0017\u001a\u00020\u0014*\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "Landroid/view/View;", "frameView", "", "isCover", "Lcom/tencent/videocut/model/SizeF;", "a", "dst", "src", "Landroid/graphics/Matrix;", "f", "d", "Lcom/tencent/videocut/model/RectF;", "e", "", "g", "(Lcom/tencent/videocut/model/RectF;)F", "width", "c", "height", "Lcom/tencent/mobileqq/wink/editor/model/PointF;", "b", "(Lcom/tencent/videocut/model/RectF;)Lcom/tencent/mobileqq/wink/editor/model/PointF;", "center", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class n {
    @NotNull
    public static final SizeF a(@NotNull WinkStickerModel winkStickerModel, @NotNull View frameView, boolean z16) {
        Intrinsics.checkNotNullParameter(winkStickerModel, "<this>");
        Intrinsics.checkNotNullParameter(frameView, "frameView");
        PointF originPointInView = winkStickerModel.getOriginPointInView();
        float measuredWidth = frameView.getMeasuredWidth() * 1.0f;
        float measuredHeight = frameView.getMeasuredHeight() * 1.0f;
        float f16 = measuredWidth - (originPointInView.f320587x * 2.0f);
        float f17 = measuredHeight - (originPointInView.f320588y * 2.0f);
        if (z16) {
            return new SizeF(measuredWidth, measuredHeight, null, 4, null);
        }
        return new SizeF(f16, f17, null, 4, null);
    }

    private static final PointF b(RectF rectF) {
        float f16 = 2;
        return new PointF((rectF.right + rectF.left) / f16, (rectF.top + rectF.bottom) / f16);
    }

    private static final float c(RectF rectF) {
        return Math.abs(rectF.bottom - rectF.top);
    }

    @NotNull
    public static final Matrix d(@NotNull SizeF dst, @NotNull SizeF src) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        Intrinsics.checkNotNullParameter(src, "src");
        float f16 = dst.width / src.width;
        float f17 = dst.height / src.height;
        Matrix matrix = new Matrix();
        matrix.postScale(f16, f17);
        return matrix;
    }

    @NotNull
    public static final Matrix e(@NotNull RectF dst, @NotNull RectF src) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        Intrinsics.checkNotNullParameter(src, "src");
        Matrix matrix = new Matrix();
        float g16 = g(dst) / g(src);
        float c16 = c(dst) / c(src);
        matrix.postTranslate(-b(src).f320587x, -b(src).f320588y);
        matrix.postScale(g16, c16);
        matrix.postTranslate(b(dst).f320587x, b(dst).f320588y);
        return matrix;
    }

    @NotNull
    public static final Matrix f(@NotNull SizeF dst, @NotNull SizeF src) {
        Intrinsics.checkNotNullParameter(dst, "dst");
        Intrinsics.checkNotNullParameter(src, "src");
        RectF rectF = new RectF(0.0f, 0.0f, src.width, src.height, null, 16, null);
        PointF b16 = b(rectF);
        float f16 = b16.f320587x;
        float f17 = dst.width;
        float f18 = b16.f320588y;
        float f19 = dst.height;
        return e(new RectF(f16 - (f17 / 2.0f), f18 - (f19 / 2.0f), f16 + (f17 / 2.0f), (f19 / 2.0f) + f18, null, 16, null), rectF);
    }

    private static final float g(RectF rectF) {
        return Math.abs(rectF.right - rectF.left);
    }
}
