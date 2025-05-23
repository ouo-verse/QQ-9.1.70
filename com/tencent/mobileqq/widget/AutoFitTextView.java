package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AutoFitTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private Paint f315440d;

    /* renamed from: e, reason: collision with root package name */
    private float f315441e;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
    }

    public AutoFitTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f315440d = paint;
        paint.set(getPaint());
    }

    private void a(String str, int i3) {
        if (str != null && i3 > 0) {
            if (this.f315441e == 0.0f) {
                this.f315441e = getTextSize();
            }
            int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - getCompoundDrawablePadding();
            Rect rect = new Rect();
            this.f315440d.setTextSize(this.f315441e);
            this.f315440d.getTextBounds(str, 0, str.length(), rect);
            float width2 = rect.width();
            float f16 = this.f315441e;
            while (width2 > width) {
                f16 -= 1.0f;
                this.f315440d.setTextSize(f16);
                width2 = this.f315440d.measureText(str);
            }
            setTextSize(0, f16);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(getText().toString(), getWidth());
    }

    public void setOnGetMaxWidthCallback(a aVar) {
    }
}
