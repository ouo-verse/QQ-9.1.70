package com.tencent.mobileqq.search.util;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\f\u0010\u0010B#\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\f\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/search/util/TopCropImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "l", "", "t", "r", "b", "", "setFrame", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TopCropImageView extends AppCompatImageView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopCropImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void l() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int measuredWidth = getMeasuredWidth();
        getHeight();
        QLog.d("TopCropImageView", 1, "o:" + getWidth() + ",m:" + measuredWidth + " i" + intrinsicWidth + " " + drawable);
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            float f16 = measuredWidth / intrinsicWidth;
            Matrix matrix = new Matrix();
            matrix.setScale(f16, f16);
            matrix.postTranslate(0.0f, 0.0f);
            QLog.d("TopCropImageView", 1, "scale:" + getImageMatrix());
            setImageMatrix(matrix);
        }
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int l3, int t16, int r16, int b16) {
        l();
        return super.setFrame(l3, t16, r16, b16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopCropImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopCropImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
