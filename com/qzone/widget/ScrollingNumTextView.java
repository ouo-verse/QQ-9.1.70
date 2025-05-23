package com.qzone.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ScrollingNumTextView extends TextView {
    private int C;
    private long D;
    private int E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private Paint f60673d;

    /* renamed from: e, reason: collision with root package name */
    private float f60674e;

    /* renamed from: f, reason: collision with root package name */
    private int f60675f;

    /* renamed from: h, reason: collision with root package name */
    private char[] f60676h;

    /* renamed from: i, reason: collision with root package name */
    private float f60677i;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f60678m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ScrollingNumTextView.this.f60674e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ScrollingNumTextView.this.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ScrollingNumTextView.this.f60675f++;
            if (ScrollingNumTextView.this.f60675f < ScrollingNumTextView.this.f60676h.length) {
                float f16 = ScrollingNumTextView.this.E;
                float f17 = ScrollingNumTextView.this.E;
                ScrollingNumTextView scrollingNumTextView = ScrollingNumTextView.this;
                float p16 = f17 - scrollingNumTextView.p(scrollingNumTextView.f60675f);
                ScrollingNumTextView scrollingNumTextView2 = ScrollingNumTextView.this;
                int o16 = scrollingNumTextView2.o(scrollingNumTextView2.f60675f);
                if (o16 < 0 || o16 > 9) {
                    f16 = ScrollingNumTextView.this.getBottom();
                }
                ScrollingNumTextView.this.n(f16, p16).start();
                return;
            }
            ScrollingNumTextView.this.f60678m = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    public ScrollingNumTextView(Context context) {
        super(context);
        this.f60675f = 0;
        this.f60678m = false;
        this.D = 200L;
        this.E = 0;
        t();
    }

    private float k(int i3) {
        return getPaddingLeft() + getLayout().getPrimaryHorizontal(i3);
    }

    private float l(int i3) {
        return getPaddingTop() + this.f60674e;
    }

    private long m(int i3) {
        int o16 = o(i3);
        if (o16 < 10 && o16 > 0) {
            return this.D * (o16 + 1);
        }
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o(int i3) {
        Object valueOf;
        char[] cArr = this.f60676h;
        if (cArr != null && i3 < cArr.length) {
            return cArr[i3] - '0';
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mValues length:");
        char[] cArr2 = this.f60676h;
        if (cArr2 == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(cArr2.length);
        }
        sb5.append(valueOf);
        sb5.append(",index:");
        sb5.append(i3);
        QZLog.w("ScrollingNumTextView", sb5.toString());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p(int i3) {
        int o16 = o(i3);
        if (o16 >= 10 || o16 <= 0) {
            return 0.0f;
        }
        return this.C * o16;
    }

    private void t() {
        Paint paint = new Paint(getPaint());
        this.f60673d = paint;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int currentTextColor = getCurrentTextColor();
        this.F = currentTextColor;
        this.f60673d.setColor(currentTextColor);
        super.setTextColor(0);
        this.C = (int) (Math.ceil(fontMetrics.descent - fontMetrics.ascent) + 1.0d);
        this.E = (int) (fontMetrics.bottom - fontMetrics.ascent);
        this.f60677i = this.f60673d.measureText("0");
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        char[] cArr;
        super.onDraw(canvas);
        int i3 = 0;
        if (getLayout() == null) {
            QZLog.w("ScrollingNumTextView", 2, "onDraw:getLayout()=null");
            return;
        }
        int baseline = this.E - getBaseline();
        if (getVisibility() != 0 || (cArr = this.f60676h) == null) {
            return;
        }
        int i16 = this.f60675f;
        if (i16 > 0) {
            if (i16 > cArr.length) {
                i16 = cArr.length;
            }
            canvas.drawText(cArr, 0, i16, k(0), this.E - baseline, this.f60673d);
        }
        if (this.f60678m) {
            int i17 = this.f60675f;
            if (i17 < this.f60676h.length) {
                int o16 = o(i17);
                if (o16 >= 0 && o16 <= 9) {
                    float l3 = l(this.f60675f);
                    while (i3 <= o16) {
                        if (this.C + l3 > getTop() && l3 < getBottom()) {
                            canvas.drawText("0123456789", i3, i3 + 1, k(this.f60675f), l3 - baseline, this.f60673d);
                        }
                        l3 += this.C;
                        i3++;
                    }
                } else {
                    canvas.drawText(String.valueOf(this.f60676h[this.f60675f]), k(this.f60675f), l(this.f60675f) - baseline, this.f60673d);
                }
            }
            int i18 = this.f60675f;
            if (i18 + 1 < this.f60676h.length) {
                for (int i19 = i18 + 1; i19 < this.f60676h.length; i19++) {
                    int o17 = o(i19);
                    if (o17 >= 0 && o17 <= 9) {
                        canvas.drawText("0", k(i19), this.E - baseline, this.f60673d);
                    }
                }
                return;
            }
            return;
        }
        if (this.f60675f == 0) {
            while (i3 < this.f60676h.length) {
                int o18 = o(i3);
                if (o18 >= 0 && o18 <= 9) {
                    canvas.drawText("0", k(i3), this.E - baseline, this.f60673d);
                }
                i3++;
            }
        }
    }

    public boolean q() {
        return this.f60678m;
    }

    public void s(boolean z16) {
        if (this.f60678m) {
            QZLog.i("ScrollingNumTextView", 1, "show --mIsAnimating:" + this.f60678m);
            return;
        }
        setTextString(String.valueOf(getText()));
        if (this.f60676h == null) {
            QZLog.w("ScrollingNumTextView", "values = null.");
            return;
        }
        this.f60675f = 0;
        setVisibility(0);
        if (z16) {
            postDelayed(new Runnable() { // from class: com.qzone.widget.ScrollingNumTextView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ScrollingNumTextView.this.f60678m) {
                        return;
                    }
                    ScrollingNumTextView.this.f60678m = true;
                    float f16 = ScrollingNumTextView.this.E;
                    float f17 = ScrollingNumTextView.this.E;
                    ScrollingNumTextView scrollingNumTextView = ScrollingNumTextView.this;
                    float p16 = f17 - scrollingNumTextView.p(scrollingNumTextView.f60675f);
                    ScrollingNumTextView scrollingNumTextView2 = ScrollingNumTextView.this;
                    int o16 = scrollingNumTextView2.o(scrollingNumTextView2.f60675f);
                    if (o16 < 0 || o16 > 9) {
                        f16 = ScrollingNumTextView.this.getBottom();
                    }
                    ScrollingNumTextView.this.n(f16, p16).start();
                }
            }, 500L);
        }
    }

    public void setSingleNumDuration(long j3) {
        this.D = j3;
    }

    @Override // android.widget.TextView
    public void setTextColor(int i3) {
        this.F = i3;
        this.f60673d.setColor(i3);
        super.setTextColor(0);
    }

    @Override // android.widget.TextView
    public void setTextSize(float f16) {
        super.setTextSize(f16);
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ValueAnimator n(float f16, float f17) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f16, f17);
        ofFloat.setDuration(m(this.f60675f));
        ofFloat.addUpdateListener(new a());
        ofFloat.addListener(new b());
        return ofFloat;
    }

    public void r() {
        this.f60675f = 0;
        this.f60678m = false;
    }

    public void setTextString(String str) {
        if (str != null) {
            this.f60676h = str.toCharArray();
        }
        setText(str);
    }

    public ScrollingNumTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60675f = 0;
        this.f60678m = false;
        this.D = 200L;
        this.E = 0;
        t();
    }
}
