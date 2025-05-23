package com.tencent.biz.pubaccount.weishi.ui.videotransition;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J(\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J&\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/a;", "", "Landroid/widget/ImageView;", "coverView", "", "showAreaWidth", "", "areaRatio", "topMargin", "", "b", "c", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f81662a = new a();

    a() {
    }

    private final void b(ImageView coverView, int showAreaWidth, float areaRatio, int topMargin) {
        Drawable drawable = coverView.getDrawable();
        if (drawable == null) {
            return;
        }
        Matrix imageMatrix = coverView.getImageMatrix();
        imageMatrix.reset();
        float f16 = showAreaWidth;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float f17 = (int) (f16 / areaRatio);
        float intrinsicHeight = drawable.getIntrinsicHeight();
        float max = Math.max(f16 / intrinsicWidth, f17 / intrinsicHeight);
        imageMatrix.postScale(max, max, 0.0f, 0.0f);
        float f18 = f16 - (intrinsicWidth * max);
        float f19 = 2;
        imageMatrix.postTranslate(f18 / f19, ((f17 - (intrinsicHeight * max)) / f19) + topMargin);
        coverView.setScaleType(ImageView.ScaleType.MATRIX);
        coverView.setImageMatrix(imageMatrix);
        coverView.invalidate();
    }

    private final void c(ImageView coverView, int showAreaWidth, float areaRatio, int topMargin) {
        coverView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ViewGroup.LayoutParams layoutParams = coverView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.width = showAreaWidth;
        marginLayoutParams.height = (int) (showAreaWidth / areaRatio);
        marginLayoutParams.topMargin = topMargin;
        coverView.setLayoutParams(marginLayoutParams);
    }

    public final void a(ImageView coverView, int showAreaWidth, float areaRatio, int topMargin) {
        Intrinsics.checkNotNullParameter(coverView, "coverView");
        if (com.tencent.biz.pubaccount.weishi.config.experiment.b.h().L()) {
            b(coverView, showAreaWidth, areaRatio, topMargin);
        } else {
            c(coverView, showAreaWidth, areaRatio, topMargin);
        }
    }
}
