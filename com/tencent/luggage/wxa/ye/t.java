package com.tencent.luggage.wxa.ye;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public class t extends FrameLayout implements r, s, com.tencent.luggage.wxa.gh.g {

    /* renamed from: a, reason: collision with root package name */
    public FrameLayout f145615a;

    /* renamed from: b, reason: collision with root package name */
    public ScrollView f145616b;

    /* renamed from: c, reason: collision with root package name */
    public q f145617c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f145618d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f145619e;

    /* renamed from: f, reason: collision with root package name */
    public float f145620f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f145621g;

    /* renamed from: h, reason: collision with root package name */
    public float f145622h;

    /* renamed from: i, reason: collision with root package name */
    public int f145623i;

    /* renamed from: j, reason: collision with root package name */
    public int f145624j;

    /* renamed from: k, reason: collision with root package name */
    public Paint f145625k;

    /* renamed from: l, reason: collision with root package name */
    public GradientDrawable f145626l;

    /* renamed from: m, reason: collision with root package name */
    public float[] f145627m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends ScrollView {
        public a(Context context) {
            super(context);
        }

        @Override // android.view.View
        public void onScrollChanged(int i3, int i16, int i17, int i18) {
            super.onScrollChanged(i3, i16, i17, i18);
            if (t.this.f145617c != null) {
                t.this.f145617c.a(t.this, i3, i16, i17, i18);
            }
        }

        @Override // android.widget.ScrollView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 2 && !t.this.f145618d) {
                w.b("MicroMsg.WxaScrollView", "can not move");
                return false;
            }
            return super.onTouchEvent(motionEvent);
        }
    }

    public t(Context context) {
        super(context);
        this.f145618d = true;
        this.f145619e = true;
        this.f145625k = new Paint();
        this.f145626l = new GradientDrawable();
        this.f145627m = new float[8];
        a();
    }

    private Drawable getShadowDrawable() {
        int i3;
        int i16 = this.f145624j;
        if (i16 != 0) {
            this.f145626l.setColor(i16);
        }
        float[] fArr = this.f145621g;
        if (fArr != null && fArr.length > 3) {
            float[] fArr2 = this.f145627m;
            fArr2[0] = fArr[0];
            fArr2[1] = fArr[0];
            float f16 = fArr[1];
            fArr2[2] = f16;
            fArr2[3] = f16;
            float f17 = fArr[3];
            fArr2[4] = f17;
            fArr2[5] = f17;
            float f18 = fArr[2];
            fArr2[6] = f18;
            fArr2[7] = f18;
            this.f145626l.setCornerRadii(fArr2);
        }
        float f19 = this.f145622h;
        if (f19 > 0.0f && (i3 = this.f145623i) != 0) {
            this.f145626l.setStroke((int) f19, i3);
        }
        return this.f145626l;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        this.f145615a.addView(view, i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0 && !a(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z16;
        float[] fArr = this.f145621g;
        if (fArr != null && fArr.length == 4) {
            super.draw(canvas);
            return;
        }
        float f16 = 0.0f;
        boolean z17 = true;
        if (this.f145620f > 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            canvas.save();
            Path path = new Path();
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            float f17 = this.f145620f;
            path.addRoundRect(rectF, f17, f17, Path.Direction.CW);
            canvas.clipPath(path);
        }
        int i3 = this.f145624j;
        if (i3 != 0) {
            canvas.drawColor(i3);
        }
        float f18 = this.f145622h;
        if (f18 > 0.0f) {
            float f19 = f18 / 2.0f;
            RectF rectF2 = new RectF(f19, f19, getWidth() - f19, getHeight() - f19);
            float f26 = this.f145620f;
            canvas.drawRoundRect(rectF2, f26, f26, this.f145625k);
            if (z16) {
                canvas.restore();
            }
            canvas.save();
            Path path2 = new Path();
            float f27 = this.f145620f;
            if (f27 > 0.0f) {
                float f28 = f27 - this.f145622h;
                if (f28 > 0.0f) {
                    f16 = f28;
                }
            }
            float f29 = this.f145622h;
            path2.addRoundRect(new RectF(f29, f29, getWidth() - this.f145622h, getHeight() - this.f145622h), f16, f16, Path.Direction.CW);
            canvas.clipPath(path2);
        } else {
            z17 = z16;
        }
        int save = canvas.save();
        super.draw(canvas);
        canvas.restoreToCount(save);
        if (z17) {
            canvas.restore();
        }
    }

    public ViewGroup getTargetView() {
        return this.f145615a;
    }

    @Override // com.tencent.luggage.wxa.ye.r
    public int getTargetViewChildCount() {
        return this.f145615a.getChildCount();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        this.f145615a.removeView(view);
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        this.f145616b.scrollTo(i3, i16);
        invalidate();
    }

    @Override // com.tencent.luggage.wxa.gh.g
    public void setBgColor(int i3) {
        this.f145624j = i3;
    }

    @Override // com.tencent.luggage.wxa.gh.g
    public void setBorderColor(int i3) {
        this.f145623i = i3;
        this.f145625k.setColor(i3);
    }

    @Override // com.tencent.luggage.wxa.gh.g
    public void setBorderRadius(float f16) {
        this.f145620f = f16;
    }

    @Override // com.tencent.luggage.wxa.gh.g
    public void setBorderWidth(float f16) {
        this.f145622h = f16;
        this.f145625k.setStrokeWidth(f16);
    }

    public void setOnScrollChangedListener(q qVar) {
        this.f145617c = qVar;
    }

    public void setScrollHorizontal(boolean z16) {
        this.f145619e = z16;
    }

    public void setScrollVertical(boolean z16) {
        this.f145618d = z16;
    }

    public final void a() {
        this.f145616b = new a(getContext());
        this.f145615a = new FrameLayout(getContext());
        super.addView(this.f145616b, 0, new ViewGroup.LayoutParams(-1, -1));
        this.f145616b.addView(this.f145615a, 0, new ViewGroup.LayoutParams(-1, -2));
        this.f145625k.setStyle(Paint.Style.STROKE);
        this.f145625k.setAntiAlias(true);
        setWillNotDraw(false);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        this.f145615a.addView(view, i3, layoutParams);
    }

    @Override // com.tencent.luggage.wxa.gh.g
    public void setBorderRadius(float[] fArr) {
        this.f145621g = fArr;
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        setBackground(getShadowDrawable());
    }

    public final boolean a(float f16, float f17) {
        float f18 = this.f145620f;
        if (f18 <= 0.0f) {
            return true;
        }
        double pow = Math.pow(f18, 2.0d);
        float width = getWidth();
        float height = getHeight();
        float f19 = this.f145620f;
        if (f16 < f19) {
            if (f17 < f19) {
                if (Math.pow(f19 - f16, 2.0d) + Math.pow(this.f145620f - f17, 2.0d) > pow) {
                    return false;
                }
            } else if (f17 > height - f19 && Math.pow(f19 - f16, 2.0d) + Math.pow((f17 + this.f145620f) - height, 2.0d) > pow) {
                return false;
            }
        } else if (f16 > width - f19) {
            if (f17 < f19) {
                if (Math.pow((f16 + f19) - width, 2.0d) + Math.pow(this.f145620f - f17, 2.0d) > pow) {
                    return false;
                }
            } else if (f17 > height - f19 && Math.pow((f16 + f19) - width, 2.0d) + Math.pow((f17 + this.f145620f) - height, 2.0d) > pow) {
                return false;
            }
        }
        return true;
    }
}
