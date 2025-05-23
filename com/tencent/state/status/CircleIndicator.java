package com.tencent.state.status;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.state.square.common.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/status/CircleIndicator;", "Landroid/view/View;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "curPosition", "", WidgetCacheConstellationData.INTERVAL, "", "mCirclePaint", "Landroid/graphics/Paint;", "maxCount", "radius", "onDraw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "setMaxCount", "setSelectItemPosition", "value", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CircleIndicator extends View {
    private static final float INTERVAL = 7.0f;
    private static final float RADIUS = 3.0f;
    private int curPosition;
    private final float interval;
    private final Paint mCirclePaint;
    private int maxCount;
    private final float radius;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.interval = ViewExtensionsKt.dip(context, INTERVAL);
        this.radius = ViewExtensionsKt.dip(context, 3.0f);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        Unit unit = Unit.INSTANCE;
        this.mCirclePaint = paint;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas == null) {
            return;
        }
        float width = getWidth();
        int i3 = this.maxCount;
        float f16 = 2;
        float f17 = ((width - ((i3 - 1) * this.interval)) - ((this.radius * i3) * f16)) / f16;
        for (int i16 = 0; i16 < i3; i16++) {
            float f18 = (i16 * (this.interval + (this.radius * f16))) + f17;
            if (i16 == this.curPosition) {
                this.mCirclePaint.setColor(Color.parseColor("#000000"));
            } else {
                this.mCirclePaint.setColor(Color.parseColor(GameCenterVideoViewController.GRAY_MASK));
            }
            canvas.drawCircle(f18, getHeight() / 2.0f, this.radius, this.mCirclePaint);
        }
    }

    public final void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
        invalidate();
    }

    public final void setSelectItemPosition(int value) {
        this.curPosition = value;
        invalidate();
    }

    public /* synthetic */ CircleIndicator(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
