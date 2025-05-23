package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FilterRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private Paint f315633d;

    public FilterRelativeLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Paint paint = this.f315633d;
        if (paint != null) {
            canvas.saveLayer(null, paint, 31);
        }
        super.dispatchDraw(canvas);
        if (this.f315633d != null) {
            canvas.restore();
        }
    }

    public void setFilter(int i3) {
        if (this.f315633d == null) {
            this.f315633d = new Paint();
        }
        this.f315633d.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_ATOP));
    }

    public FilterRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FilterRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
