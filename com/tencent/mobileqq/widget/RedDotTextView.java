package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RedDotTextView extends TextView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f316154d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f316155e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f316156f;

    /* renamed from: h, reason: collision with root package name */
    private float f316157h;

    /* renamed from: i, reason: collision with root package name */
    private int f316158i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f316159m;

    public RedDotTextView(Context context) {
        this(context, null);
    }

    public void a(Canvas canvas) {
        float f16;
        if (this.f316154d) {
            if (this.f316155e == null) {
                this.f316155e = getResources().getDrawable(R.drawable.skin_tips_dot);
            }
            String charSequence = getText().toString();
            TextPaint paint = getPaint();
            paint.getTextBounds(charSequence, 0, charSequence.length(), this.f316156f);
            float height = this.f316156f.height();
            float desiredWidth = Layout.getDesiredWidth(charSequence, paint);
            int width = getWidth();
            int height2 = getHeight();
            float f17 = (width / 2) + (desiredWidth / 2.0f);
            boolean z16 = this.f316159m;
            float f18 = 0.0f;
            if (z16) {
                f16 = this.f316157h * 2.0f;
            } else {
                f16 = 0.0f;
            }
            int i3 = (int) (f17 - f16);
            float f19 = (height2 / 2) - (height / 2.0f);
            int i16 = this.f316158i;
            float f26 = f19 - i16;
            if (z16) {
                f18 = this.f316157h * 2.0f;
            }
            int i17 = (int) (f26 + f18);
            this.f316155e.setBounds(i3, i17, i3 + i16, i16 + i17);
            this.f316155e.draw(canvas);
        }
    }

    public boolean b() {
        return this.f316154d;
    }

    public void c(boolean z16) {
        this.f316154d = z16;
        invalidate();
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        a(canvas);
        canvas.restore();
    }

    public void setRedDotDrawable(Drawable drawable) {
        this.f316155e = drawable;
    }

    public RedDotTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316159m = true;
        this.f316156f = new Rect();
        this.f316157h = getResources().getDisplayMetrics().density;
        this.f316158i = (int) ((r3 * 9.0f) + 0.5d);
    }
}
