package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMSwitchBtn extends View implements View.OnClickListener {
    public float C;
    public int D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public Paint I;
    public RectF J;
    public RectF K;
    public int L;
    public int M;
    public int N;
    public String O;
    public String P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public Vibrator T;
    public Context U;
    public boolean V;
    public SlideAnimation W;

    /* renamed from: a, reason: collision with root package name */
    public float f152691a;

    /* renamed from: a0, reason: collision with root package name */
    public ISwitch f152692a0;

    /* renamed from: b, reason: collision with root package name */
    public float f152693b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f152694b0;

    /* renamed from: c, reason: collision with root package name */
    public long f152695c;

    /* renamed from: d, reason: collision with root package name */
    public int f152696d;

    /* renamed from: e, reason: collision with root package name */
    public int f152697e;

    /* renamed from: f, reason: collision with root package name */
    public int f152698f;

    /* renamed from: g, reason: collision with root package name */
    public int f152699g;

    /* renamed from: h, reason: collision with root package name */
    public int f152700h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f152701i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f152702j;

    /* renamed from: k, reason: collision with root package name */
    public int f152703k;

    /* renamed from: l, reason: collision with root package name */
    public int f152704l;

    /* renamed from: m, reason: collision with root package name */
    public float f152705m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface ISwitch {
        void onStatusChange(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class SlideAnimation extends Animation {

        /* renamed from: a, reason: collision with root package name */
        public int f152706a;

        /* renamed from: b, reason: collision with root package name */
        public float f152707b;

        /* renamed from: c, reason: collision with root package name */
        public long f152708c;

        @Override // android.view.animation.Animation
        public void applyTransformation(float f16, Transformation transformation) {
            if (this.f152706a == 0) {
                MMSwitchBtn.this.K.left = this.f152707b - (f16 * ((float) this.f152708c));
            } else {
                MMSwitchBtn.this.K.left = this.f152707b + (f16 * ((float) this.f152708c));
            }
            MMSwitchBtn.this.c(false);
            MMSwitchBtn.this.invalidate();
        }

        SlideAnimation() {
            this.f152706a = 0;
            this.f152707b = 0.0f;
            this.f152708c = 0L;
            setInterpolator(new AccelerateDecelerateInterpolator());
            setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mm.ui.widget.MMSwitchBtn.SlideAnimation.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    boolean z16;
                    boolean z17 = MMSwitchBtn.this.H;
                    SlideAnimation slideAnimation = SlideAnimation.this;
                    int i3 = slideAnimation.f152706a;
                    boolean z18 = true;
                    if (i3 == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z17 != z16) {
                        MMSwitchBtn mMSwitchBtn = MMSwitchBtn.this;
                        if (i3 != 1) {
                            z18 = false;
                        }
                        mMSwitchBtn.H = z18;
                        if (MMSwitchBtn.this.f152694b0) {
                            if (MMSwitchBtn.this.f152692a0 != null) {
                                MMSwitchBtn.this.f152692a0.onStatusChange(MMSwitchBtn.this.H);
                            }
                        } else {
                            MMSwitchBtn.this.post(new Runnable() { // from class: com.tencent.mm.ui.widget.MMSwitchBtn.SlideAnimation.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (MMSwitchBtn.this.f152692a0 != null) {
                                        MMSwitchBtn.this.f152692a0.onStatusChange(MMSwitchBtn.this.H);
                                    }
                                }
                            });
                        }
                    }
                    MMSwitchBtn.this.f152701i = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
        }
    }

    public MMSwitchBtn(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f152701i = false;
        this.f152702j = false;
        this.H = false;
        this.I = new Paint(1);
        this.J = new RectF();
        this.K = new RectF();
        this.Q = false;
        this.R = false;
        this.S = true;
        this.V = true;
        this.W = new SlideAnimation();
        this.f152694b0 = false;
        this.U = context;
        b();
        a(context, attributeSet);
    }

    public boolean isCheck() {
        return this.H;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.S;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b(!this.H);
        a(false);
        this.f152702j = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        int i16;
        if (!isEnabled()) {
            if (isCheck()) {
                i3 = this.M;
            } else {
                i3 = this.L;
            }
            this.I.setColor(i3);
            if (isCheck()) {
                i16 = 76;
            } else {
                i16 = 7;
            }
            this.I.setAlpha(i16);
            RectF rectF = this.J;
            float f16 = this.f152705m;
            canvas.drawRoundRect(rectF, f16, f16, this.I);
        } else {
            int i17 = this.L;
            this.I.setAlpha(255);
            this.I.setColor(i17);
            RectF rectF2 = this.J;
            float f17 = this.f152705m;
            canvas.drawRoundRect(rectF2, f17, f17, this.I);
            this.I.setColor(this.M);
            this.I.setAlpha(Math.min(255, (int) (((this.K.left - this.f152704l) / this.f152697e) * 255.0f)));
            RectF rectF3 = this.J;
            float f18 = this.f152705m;
            canvas.drawRoundRect(rectF3, f18, f18, this.I);
        }
        this.I.setColor(this.N);
        RectF rectF4 = this.K;
        float f19 = this.C;
        canvas.drawRoundRect(rectF4, f19, f19, this.I);
        if (this.O != null && this.P != null) {
            Paint paint = new Paint();
            paint.setTextSize(getResources().getDimension(R.dimen.bp9));
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(getResources().getColor(R.color.czm));
            paint.setAntiAlias(true);
            int min = Math.min(255, (int) (((this.K.left - this.f152704l) / this.f152697e) * 255.0f));
            Rect rect = new Rect();
            String str = this.O;
            paint.getTextBounds(str, 0, str.length(), rect);
            paint.setAlpha(min);
            RectF rectF5 = this.J;
            float a16 = (((rectF5.left + rectF5.right) / 2.0f) - this.C) + o.a(getContext(), 1);
            RectF rectF6 = this.J;
            float height = (((rectF6.top + rectF6.bottom) / 2.0f) + (rect.height() / 2.0f)) - o.a(getContext(), 1);
            canvas.drawText(this.O, a16, height, paint);
            RectF rectF7 = this.J;
            float a17 = (((rectF7.left + rectF7.right) / 2.0f) + this.C) - o.a(getContext(), 1);
            paint.setAlpha(255 - min);
            canvas.drawText(this.P, a17, height, paint);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int i19 = i17 - i3;
        this.f152698f = i19;
        this.f152699g = i18 - i16;
        int i26 = (i19 - ((int) (this.C * 2.0f))) - (this.f152704l * 2);
        this.f152697e = i26;
        this.f152696d = i26 / 2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.bpq);
        this.f152700h = dimensionPixelSize;
        int i27 = this.f152699g;
        if (dimensionPixelSize < i27) {
            RectF rectF = this.J;
            float f16 = (i27 - dimensionPixelSize) / 2;
            rectF.top = f16;
            rectF.bottom = f16 + dimensionPixelSize;
        } else {
            RectF rectF2 = this.J;
            rectF2.top = 0.0f;
            rectF2.bottom = i27;
        }
        RectF rectF3 = this.J;
        rectF3.left = 0.0f;
        rectF3.right = this.f152698f;
        c();
        this.I.setStyle(Paint.Style.FILL);
        this.I.setColor(this.E);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f152701i || !isEnabled()) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.Q = true;
                        a();
                        a(false);
                        this.f152702j = false;
                    }
                } else {
                    if (this.f152702j) {
                        a(true);
                        a(motionEvent.getX() - this.f152691a);
                    } else if (a(motionEvent.getX() - this.f152691a, motionEvent.getY() - this.f152693b)) {
                        this.f152702j = true;
                        a(true);
                    }
                    this.f152691a = motionEvent.getX();
                    this.f152693b = motionEvent.getY();
                }
            } else {
                if (SystemClock.elapsedRealtime() - this.f152695c < 300) {
                    this.Q = true;
                } else if (!this.H) {
                    this.Q = false;
                } else {
                    this.Q = true;
                }
                b(!this.H);
                a(false);
                this.f152702j = false;
            }
        } else {
            clearAnimation();
            this.f152691a = motionEvent.getX();
            this.f152693b = motionEvent.getY();
            this.f152695c = SystemClock.elapsedRealtime();
            this.f152702j = false;
            if (this.H) {
                this.K.left -= getResources().getDimensionPixelSize(R.dimen.bpx) - getResources().getDimensionPixelSize(R.dimen.bpw);
            } else {
                this.K.right += getResources().getDimensionPixelSize(R.dimen.bpx) - getResources().getDimensionPixelSize(R.dimen.bpw);
            }
            invalidate();
        }
        if (this.f152702j) {
            invalidate();
        }
        return true;
    }

    public void setCheck(boolean z16) {
        if (this.H != z16) {
            clearAnimation();
            this.H = z16;
            c();
            this.f152701i = false;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        super.setEnabled(z16);
        this.S = z16;
    }

    public void setOffColor(int i3) {
        this.L = i3;
    }

    public void setRemoveAnimateEndPost(boolean z16) {
        this.f152694b0 = z16;
    }

    public void setSlideAnimationEnabled(boolean z16) {
        if (this.V != z16) {
            this.V = z16;
            if (!z16) {
                if (this.f152701i) {
                    boolean z17 = true;
                    if (this.W.f152706a != 1) {
                        z17 = false;
                    }
                    this.H = z17;
                }
                clearAnimation();
                c();
                this.f152701i = false;
                invalidate();
            }
        }
    }

    public void setSwitchListener(ISwitch iSwitch) {
        this.f152692a0 = iSwitch;
    }

    public void updateDescription(boolean z16) {
        String string;
        if (z16) {
            string = getContext().getString(R.string.f230006xz);
        } else {
            string = getContext().getString(R.string.f230056y4);
        }
        setContentDescription(string);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.MMSwitchBtn);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.Component);
        this.M = obtainStyledAttributes.getColor(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.MMSwitchBtn_on_color, this.F);
        this.L = obtainStyledAttributes.getColor(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.MMSwitchBtn_off_color, this.E);
        this.N = obtainStyledAttributes.getColor(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.MMSwitchBtn_slide_color, this.D);
        this.O = obtainStyledAttributes.getString(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.MMSwitchBtn_on_text);
        this.P = obtainStyledAttributes.getString(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.MMSwitchBtn_off_text);
        this.R = obtainStyledAttributes2.getBoolean(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.Component_checked, false);
        this.S = obtainStyledAttributes2.getBoolean(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.Component_enabled, true);
        this.H = this.R;
        obtainStyledAttributes.recycle();
        obtainStyledAttributes2.recycle();
    }

    public final void b() {
        this.f152704l = getResources().getDimensionPixelSize(R.dimen.bpd);
        this.f152705m = getResources().getDimensionPixelSize(R.dimen.bpu) / 2.0f;
        this.C = getResources().getDimensionPixelSize(R.dimen.bpw) / 2.0f;
        this.D = getResources().getColor(R.color.az_);
        this.E = getResources().getColor(R.color.aza);
        this.F = getResources().getColor(R.color.azb);
        this.G = getResources().getColor(R.color.aza);
        this.M = this.F;
        this.L = this.E;
        this.N = this.D;
        this.f152703k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        setOnClickListener(this);
        this.T = (Vibrator) this.U.getSystemService("vibrator");
    }

    public final void c() {
        int i3 = this.f152700h;
        int i16 = this.f152699g;
        if (i3 < i16) {
            RectF rectF = this.K;
            float f16 = ((i16 - i3) / 2) + this.f152704l;
            rectF.top = f16;
            rectF.bottom = (f16 + i3) - (r3 * 2);
        } else {
            RectF rectF2 = this.K;
            rectF2.top = this.f152704l;
            rectF2.bottom = i16 - r2;
        }
        if (this.H) {
            RectF rectF3 = this.K;
            int i17 = this.f152697e;
            int i18 = this.f152704l;
            rectF3.left = i17 + i18;
            rectF3.right = this.f152698f - i18;
            return;
        }
        RectF rectF4 = this.K;
        rectF4.left = this.f152704l;
        rectF4.right = ((int) (this.C * 2.0f)) + r1;
    }

    public final void c(boolean z16) {
        RectF rectF = this.K;
        float f16 = rectF.left;
        int i3 = this.f152704l;
        float f17 = i3;
        if (f16 < f17) {
            rectF.left = f17;
        }
        float f18 = this.f152697e + i3;
        if (z16) {
            f18 -= getResources().getDimensionPixelSize(R.dimen.bpx) - getResources().getDimensionPixelSize(R.dimen.bpw);
        }
        RectF rectF2 = this.K;
        if (rectF2.left > f18) {
            rectF2.left = f18;
        }
        if (this.Q) {
            rectF2.right = rectF2.left + ((int) (this.C * 2.0f));
        } else {
            rectF2.right = rectF2.left + getResources().getDimensionPixelSize(R.dimen.bpx);
        }
        float dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f158119bq0) - this.f152704l;
        RectF rectF3 = this.K;
        if (rectF3.right > dimensionPixelSize) {
            rectF3.right = dimensionPixelSize;
        }
    }

    public final void a(float f16) {
        this.K.left += f16;
        this.Q = false;
        c(true);
    }

    public final void b(boolean z16) {
        Vibrator vibrator = this.T;
        if (vibrator != null) {
            vibrator.vibrate(10L);
        }
        if (!this.V) {
            this.H = z16;
            this.f152701i = false;
            this.W.reset();
            this.W.f152706a = z16 ? 1 : 0;
            c();
            invalidate();
            ISwitch iSwitch = this.f152692a0;
            if (iSwitch != null) {
                iSwitch.onStatusChange(this.H);
                return;
            }
            return;
        }
        this.f152701i = true;
        this.W.reset();
        if (z16) {
            SlideAnimation slideAnimation = this.W;
            slideAnimation.f152708c = (this.f152697e - this.K.left) + this.f152704l;
            slideAnimation.f152706a = 1;
        } else {
            SlideAnimation slideAnimation2 = this.W;
            slideAnimation2.f152708c = this.K.left;
            slideAnimation2.f152706a = 0;
        }
        SlideAnimation slideAnimation3 = this.W;
        slideAnimation3.f152707b = this.K.left;
        slideAnimation3.setDuration((slideAnimation3.f152708c * 150) / this.f152697e);
        startAnimation(this.W);
    }

    public MMSwitchBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f152701i = false;
        this.f152702j = false;
        this.H = false;
        this.I = new Paint(1);
        this.J = new RectF();
        this.K = new RectF();
        this.Q = false;
        this.R = false;
        this.S = true;
        this.V = true;
        this.W = new SlideAnimation();
        this.f152694b0 = false;
        this.U = context;
        b();
        a(context, attributeSet);
    }

    public final boolean a(float f16, float f17) {
        if (Math.abs(f16) < this.f152703k / 10.0f) {
            return false;
        }
        if (f17 == 0.0f) {
            f17 = 1.0f;
        }
        return Math.abs(f16 / f17) > 3.0f;
    }

    public final void a(boolean z16) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z16);
        }
    }

    public final void a() {
        if (this.K.left > this.f152696d) {
            b(true);
        } else {
            b(false);
        }
    }

    public MMSwitchBtn(Context context) {
        super(context);
        this.f152701i = false;
        this.f152702j = false;
        this.H = false;
        this.I = new Paint(1);
        this.J = new RectF();
        this.K = new RectF();
        this.Q = false;
        this.R = false;
        this.S = true;
        this.V = true;
        this.W = new SlideAnimation();
        this.f152694b0 = false;
        this.U = context;
        b();
    }
}
