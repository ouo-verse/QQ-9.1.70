package com.tencent.luggage.wxa.il;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatButton;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends AppCompatButton {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f130708a;

    /* renamed from: b, reason: collision with root package name */
    public RectF f130709b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f130710c;

    /* renamed from: d, reason: collision with root package name */
    public float f130711d;

    /* renamed from: e, reason: collision with root package name */
    public float f130712e;

    public j(Context context, boolean z16) {
        super(context);
        this.f130708a = z16;
        a();
    }

    public final void a() {
        setGravity(17);
        setText("vConsole");
        setTextColor(-1);
        float f16 = getContext().getResources().getDisplayMetrics().density;
        int i3 = (int) (13.0f * f16);
        setPadding(i3, (int) (4.0f * f16), i3, (int) (f16 * 6.0f));
        setBackgroundDrawable(new b());
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getBackground() == null) {
            setBackground(new b());
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelPendingInputEvents();
        this.f130710c = false;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && (this.f130710c || !a(motionEvent.getRawX(), motionEvent.getRawY()))) {
                    setX(getX() + (motionEvent.getRawX() - this.f130711d));
                    setY(getY() + (motionEvent.getRawY() - this.f130712e));
                    requestLayout();
                    this.f130710c = true;
                }
            } else if (!this.f130710c && a(motionEvent.getRawX(), motionEvent.getRawY())) {
                performClick();
            }
        } else {
            if (this.f130708a) {
                this.f130709b = new RectF(getX(), getY(), getX() + getWidth(), getY() + getHeight());
            } else {
                int[] iArr = new int[2];
                getLocationInWindow(iArr);
                this.f130709b = new RectF(iArr[0], iArr[1], r4 + getWidth(), iArr[1] + getHeight());
            }
            this.f130710c = false;
        }
        this.f130711d = motionEvent.getRawX();
        this.f130712e = motionEvent.getRawY();
        return true;
    }

    public j(Context context) {
        this(context, true);
    }

    public final boolean a(float f16, float f17) {
        RectF rectF = this.f130709b;
        if (rectF == null) {
            return false;
        }
        return rectF.contains(f16, f17);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends Drawable {

        /* renamed from: a, reason: collision with root package name */
        public Paint f130713a;

        /* renamed from: b, reason: collision with root package name */
        public RectF f130714b;

        /* renamed from: c, reason: collision with root package name */
        public Rect f130715c;

        public b() {
            this.f130713a = new Paint(1);
            this.f130714b = new RectF();
            this.f130715c = new Rect();
            this.f130713a.setColor(-12748166);
            this.f130713a.setStyle(Paint.Style.FILL);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            int width;
            int height;
            if (this.f130715c.width() > 0 && this.f130715c.height() > 0) {
                width = this.f130715c.width();
                height = this.f130715c.height();
            } else {
                width = canvas.getWidth();
                height = canvas.getHeight();
            }
            float f16 = height;
            float f17 = f16 / 2.0f;
            RectF rectF = this.f130714b;
            rectF.top = 0.0f;
            rectF.left = 0.0f;
            float f18 = 2.0f * f17;
            rectF.bottom = f18;
            rectF.right = f18;
            canvas.drawArc(rectF, 90.0f, 180.0f, false, this.f130713a);
            RectF rectF2 = this.f130714b;
            float f19 = width;
            rectF2.left = f19 - f18;
            rectF2.top = 0.0f;
            rectF2.right = f19;
            rectF2.bottom = f16;
            canvas.drawArc(rectF2, -90.0f, 180.0f, false, this.f130713a);
            canvas.drawRect(f17 - 1.0f, 0.0f, (f19 - f17) + 1.0f, f16, this.f130713a);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            Rect rect2 = this.f130715c;
            rect2.left = rect.left;
            rect2.right = rect.right;
            rect2.top = rect.top;
            rect2.bottom = rect.bottom;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i3) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }
}
