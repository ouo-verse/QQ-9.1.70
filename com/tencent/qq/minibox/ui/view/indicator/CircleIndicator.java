package com.tencent.qq.minibox.ui.view.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014B\u001b\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0013\u0010\u0017B#\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0019J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qq/minibox/ui/view/indicator/CircleIndicator;", "Lcom/tencent/qq/minibox/ui/view/indicator/BaseIndicator;", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "i", "I", "mNormalRadius", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mSelectedRadius", BdhLogUtil.LogTag.Tag_Conn, "maxRadius", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class CircleIndicator extends BaseIndicator {

    /* renamed from: C, reason: from kotlin metadata */
    private int maxRadius;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mNormalRadius;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mSelectedRadius;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleIndicator(@NotNull Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        int normalColor;
        int normalWidth;
        int i3;
        super.onDraw(canvas);
        int indicatorSize = getHelper().getIndicatorSize();
        if (indicatorSize <= 1) {
            return;
        }
        float f16 = 0.0f;
        for (int i16 = 0; i16 < indicatorSize; i16++) {
            if (getHelper().getCurrentPosition() == i16) {
                normalColor = getHelper().getSelectedColor();
            } else {
                normalColor = getHelper().getNormalColor();
            }
            getMPaint().setColor(normalColor);
            if (getHelper().getCurrentPosition() == i16) {
                normalWidth = getHelper().getSelectedWidth();
            } else {
                normalWidth = getHelper().getNormalWidth();
            }
            if (getHelper().getCurrentPosition() == i16) {
                i3 = this.mSelectedRadius;
            } else {
                i3 = this.mNormalRadius;
            }
            if (canvas != null) {
                float f17 = i3;
                canvas.drawCircle(f16 + f17, this.maxRadius, f17, getMPaint());
            }
            f16 += normalWidth + getHelper().getIndicatorSpace();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int indicatorSize = getHelper().getIndicatorSize();
        if (indicatorSize <= 1) {
            return;
        }
        this.mNormalRadius = getHelper().getNormalWidth() / 2;
        int selectedWidth = getHelper().getSelectedWidth() / 2;
        this.mSelectedRadius = selectedWidth;
        this.maxRadius = Math.max(selectedWidth, this.mNormalRadius);
        int i3 = indicatorSize - 1;
        setMeasuredDimension((getHelper().getIndicatorSpace() * i3) + getHelper().getSelectedWidth() + (getHelper().getNormalWidth() * i3), Math.max(getHelper().getNormalWidth(), getHelper().getSelectedWidth()));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mNormalRadius = getHelper().getNormalWidth() / 2;
        this.mSelectedRadius = getHelper().getSelectedWidth() / 2;
    }
}
