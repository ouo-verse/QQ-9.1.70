package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import i63.ScalePoint;
import i63.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/TimeBarLimitTipView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/TimeBarView;", "Landroid/graphics/Canvas;", PM.CANVAS, "Li63/b;", "scaleCalculator", "", "f", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TimeBarLimitTipView extends TimeBarView {

    @NotNull
    public Map<Integer, View> P;

    @JvmOverloads
    public TimeBarLimitTipView(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.TimeBarView
    protected void f(@NotNull Canvas canvas, @NotNull b scaleCalculator) {
        ScalePoint scalePoint;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(scaleCalculator, "scaleCalculator");
        int size = scaleCalculator.i().size();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                scalePoint = scaleCalculator.i().get(i3);
                if (scaleCalculator.j(scalePoint) == getMaxDurationLimit()) {
                    break;
                } else {
                    i3++;
                }
            } else {
                scalePoint = null;
                break;
            }
        }
        if (scalePoint != null) {
            if (getMaxDurationLimitTip().length() > 0) {
                z16 = true;
            }
            if (z16) {
                Paint.FontMetrics fontMetrics = getTipPaint().getFontMetrics();
                float height = getHeight() / 2;
                float f16 = fontMetrics.bottom;
                canvas.drawText(getMaxDurationLimitTip(), 0, getMaxDurationLimitTip().length(), (getMeasuredWidth() / 2) + (scaleCalculator.getPerSpace() * scalePoint.getPosition()), (height + ((f16 - fontMetrics.top) / 2)) - f16, getTipPaint());
            }
        }
    }

    @JvmOverloads
    public TimeBarLimitTipView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimeBarLimitTipView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.P = new LinkedHashMap();
    }

    public /* synthetic */ TimeBarLimitTipView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
