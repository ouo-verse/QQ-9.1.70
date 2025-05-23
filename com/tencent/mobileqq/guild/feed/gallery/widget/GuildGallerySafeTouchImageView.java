package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.component.multitouchimg.MultiTouchImageView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J.\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildGallerySafeTouchImageView;", "Lcom/tencent/mobileqq/guild/component/multitouchimg/MultiTouchImageView;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "Landroid/graphics/drawable/Drawable;", "drawable", "", "drawableWidth", "drawableHeight", "left", "top", "setDrawableSizeAndPosition", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildGallerySafeTouchImageView extends MultiTouchImageView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildGallerySafeTouchImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("GuildGallerySafeTouchImageView", 4, "onDraw() Canvas: trying to use a recycled bitmap");
            }
        }
    }

    public final void setDrawableSizeAndPosition(@NotNull Drawable drawable, int drawableWidth, int drawableHeight, int left, int top) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        float intrinsicWidth = drawableWidth / drawable.getIntrinsicWidth();
        float intrinsicHeight = drawableHeight / drawable.getIntrinsicHeight();
        QLog.i("GuildGallerySafeTouchImageView", 1, "setDrawableSizeAndPosition displayWidth=" + drawableWidth + " displayHeight=" + drawableHeight + " drawableWidth=" + drawable.getIntrinsicWidth() + " drawableHeight=" + drawable.getIntrinsicHeight() + " left=" + left + " top=" + top + " scaleX=" + intrinsicWidth + " scaleY=" + intrinsicHeight);
        com.tencent.mobileqq.guild.component.multitouchimg.c cVar = new com.tencent.mobileqq.guild.component.multitouchimg.c();
        cVar.f216009a = intrinsicWidth;
        cVar.f216010b = intrinsicHeight;
        cVar.f216011c = left;
        cVar.f216012d = top;
        l().U(cVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildGallerySafeTouchImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildGallerySafeTouchImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildGallerySafeTouchImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
