package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.widgets.multitouchimg.FeedMultiTouchImageView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/FeedSafeTouchImageView;", "Lcom/tencent/biz/qqcircle/widgets/multitouchimg/FeedMultiTouchImageView;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/RectF;", "drawableRectF", "setDrawableSizeAndPosition", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedSafeTouchImageView extends FeedMultiTouchImageView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FeedSafeTouchImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("FeedSafeTouchImageView", 4, "onDraw() Canvas: trying to use a recycled bitmap");
            }
        }
    }

    public final void setDrawableSizeAndPosition(@NotNull Drawable drawable, @NotNull RectF drawableRectF) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(drawableRectF, "drawableRectF");
        float width = drawableRectF.width();
        float height = drawableRectF.height();
        float f16 = drawableRectF.left;
        float f17 = drawableRectF.top;
        float intrinsicWidth = width / drawable.getIntrinsicWidth();
        float intrinsicHeight = height / drawable.getIntrinsicHeight();
        QLog.i("FeedSafeTouchImageView", 1, "setDrawableSizeAndPosition displayWidth=" + width + " displayHeight=" + height + " drawableWidth=" + drawable.getIntrinsicWidth() + " drawableHeight=" + drawable.getIntrinsicHeight() + " left=" + f16 + " top=" + f17 + " scaleX=" + intrinsicWidth + " scaleY=" + intrinsicHeight);
        com.tencent.biz.qqcircle.widgets.multitouchimg.c cVar = new com.tencent.biz.qqcircle.widgets.multitouchimg.c();
        cVar.f93680a = intrinsicWidth;
        cVar.f93681b = intrinsicHeight;
        cVar.f93682c = (int) f16;
        cVar.f93683d = (int) f17;
        l().Q(cVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FeedSafeTouchImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FeedSafeTouchImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FeedSafeTouchImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
