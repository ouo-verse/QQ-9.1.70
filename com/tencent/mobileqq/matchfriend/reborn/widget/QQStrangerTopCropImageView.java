package com.tencent.mobileqq.matchfriend.reborn.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.matchfriend.widget.RoundCornerImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0014\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/widget/QQStrangerTopCropImageView;", "Lcom/tencent/mobileqq/matchfriend/widget/RoundCornerImageView;", "", "c", "", "l", "t", "r", "b", "setFrame", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerTopCropImageView extends RoundCornerImageView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQStrangerTopCropImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean c() {
        Drawable drawable = getDrawable();
        int intrinsicWidth = drawable != null ? drawable.getIntrinsicWidth() : 0;
        Drawable drawable2 = getDrawable();
        int intrinsicHeight = drawable2 != null ? drawable2.getIntrinsicHeight() : 0;
        if (intrinsicWidth == 0 || intrinsicHeight == 0) {
            return true;
        }
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        float f16 = intrinsicWidth * height > intrinsicHeight * width ? height / intrinsicHeight : width / intrinsicWidth;
        Matrix imageMatrix = getImageMatrix();
        if (imageMatrix != null) {
            imageMatrix.setScale(f16, f16);
            setImageMatrix(imageMatrix);
        }
        return false;
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int l3, int t16, int r16, int b16) {
        c();
        return super.setFrame(l3, t16, r16, b16);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQStrangerTopCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QQStrangerTopCropImageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerTopCropImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
