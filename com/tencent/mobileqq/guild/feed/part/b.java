package com.tencent.mobileqq.guild.feed.part;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.richframework.animation.transition.TransitionAnimUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/part/b;", "", "", "imageViewWidth", "imageViewHeight", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/RectF;", "b", "Landroid/widget/ImageView;", "targetView", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f222545a = new b();

    b() {
    }

    @NotNull
    public final RectF a(@NotNull ImageView targetView) {
        int i3;
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        int measuredWidth = targetView.getMeasuredWidth();
        int measuredHeight = targetView.getMeasuredHeight();
        int i16 = ScreenUtil.SCREEN_WIDTH;
        int i17 = ScreenUtil.SCREEN_HIGHT;
        int b16 = com.tencent.guild.aio.util.c.b(70);
        ViewGroup.LayoutParams layoutParams = targetView.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            i3 = marginLayoutParams.bottomMargin;
        } else {
            i3 = 0;
        }
        QLog.i("FeedImageCalculateUtils", 1, "calDrawableRectF imageViewWidth=" + measuredWidth + " imageViewHeight=" + measuredHeight + " screenWidth=" + i16 + " screenHeight=" + i17 + " 70dp=" + b16 + " targetView.marginBottom=" + i3);
        Drawable drawable = targetView.getDrawable();
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, (float) targetView.getMeasuredWidth(), (float) targetView.getMeasuredHeight());
        if (drawable != null) {
            int measuredWidth2 = targetView.getMeasuredWidth();
            int measuredHeight2 = targetView.getMeasuredHeight();
            if (drawable.getIntrinsicHeight() <= 0 || drawable.getIntrinsicWidth() <= 0) {
                QLog.i("FeedImageCalculateUtils", 1, "calDrawableRectF imageViewDrawable invalid");
                drawable = TransitionAnimUtil.getCoverDrawable();
            }
            RectF b17 = f222545a.b(measuredWidth2, measuredHeight2, drawable);
            QLog.i("FeedImageCalculateUtils", 1, "calDrawableRectF FixCenter drawableRectF=" + b17 + " width=" + b17.width() + " height=" + b17.height());
            return b17;
        }
        return rectF;
    }

    @NotNull
    public final RectF b(float imageViewWidth, float imageViewHeight, @Nullable Drawable drawable) {
        int i3;
        int i16;
        if (drawable != null) {
            i3 = drawable.getIntrinsicWidth();
        } else {
            i3 = (int) imageViewWidth;
        }
        if (drawable != null) {
            i16 = drawable.getIntrinsicHeight();
        } else {
            i16 = ((int) imageViewHeight) / 3;
        }
        QLog.i("FeedImageCalculateUtils", 1, "getFixCenterDrawableRectF  imageViewWidth=" + imageViewWidth + " imageViewHeight=" + imageViewHeight + " drawableWidth=" + i3 + " drawableHeight=" + i16);
        float f16 = (float) i3;
        float f17 = (float) i16;
        float min = Math.min(imageViewWidth / f16, imageViewHeight / f17);
        float min2 = Math.min(f16 * min, imageViewWidth);
        float min3 = Math.min(f17 * min, imageViewHeight);
        float f18 = (imageViewWidth - min2) / 2.0f;
        float f19 = (imageViewHeight - min3) / 2.0f;
        QLog.i("FeedImageCalculateUtils", 1, "getFixCenterDrawableRectF  posX=" + f18 + " posY=" + f19 + " displayWidth=" + min2 + " displayHeight=" + min3 + " scale=" + min);
        return new RectF(f18, f19, min2 + f18, min3 + f19);
    }
}
