package com.qq.e.comm.plugin.tangramsplash.interactive.a;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.am;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    String f40121a;

    /* renamed from: b, reason: collision with root package name */
    String f40122b;

    /* renamed from: c, reason: collision with root package name */
    int f40123c;

    /* renamed from: d, reason: collision with root package name */
    a f40124d;

    /* renamed from: e, reason: collision with root package name */
    ValueAnimator f40125e;

    /* renamed from: f, reason: collision with root package name */
    private Context f40126f;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a extends View {

        /* renamed from: a, reason: collision with root package name */
        Paint f40130a;

        /* renamed from: b, reason: collision with root package name */
        RectF f40131b;

        /* renamed from: c, reason: collision with root package name */
        Path f40132c;

        /* renamed from: d, reason: collision with root package name */
        final float f40133d;

        /* renamed from: e, reason: collision with root package name */
        float f40134e;

        /* renamed from: f, reason: collision with root package name */
        float f40135f;

        /* renamed from: g, reason: collision with root package name */
        float f40136g;

        /* renamed from: h, reason: collision with root package name */
        float f40137h;

        /* renamed from: i, reason: collision with root package name */
        int f40138i;

        /* renamed from: j, reason: collision with root package name */
        boolean f40139j;

        /* renamed from: k, reason: collision with root package name */
        OrientationEventListener f40140k;

        /* renamed from: l, reason: collision with root package name */
        float f40141l;

        /* renamed from: m, reason: collision with root package name */
        private float f40142m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f40143n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f40144o;

        /* renamed from: p, reason: collision with root package name */
        private com.qq.e.comm.plugin.tangramsplash.interactive.a.a f40145p;

        /* renamed from: q, reason: collision with root package name */
        private int f40146q;

        /* renamed from: r, reason: collision with root package name */
        private PorterDuffXfermode f40147r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f40148s;

        /* renamed from: t, reason: collision with root package name */
        private final Object f40149t;

        public a(Context context) {
            this(context, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i3) {
            int i16 = this.f40146q;
            if (i16 == 1 && i3 >= 0 && i3 < 180) {
                GDTLogger.d("GDT-shakingView-- \u5de6\u626d\u6a21\u5f0f, \u5f80\u53f3\u626d\u4e86 ");
                float f16 = this.f40135f;
                this.f40136g = f16;
                this.f40137h = -f16;
                this.f40143n = false;
                invalidate();
                return;
            }
            if (i16 == 2 && i3 <= 360 && i3 >= 180) {
                GDTLogger.d("GDT-shakingView-- \u53f3\u626d\u6a21\u5f0f, \u5f80\u5de6\u626d\u4e86 ");
                float f17 = this.f40135f;
                this.f40136g = -f17;
                this.f40137h = -f17;
                this.f40143n = false;
                invalidate();
                return;
            }
            this.f40143n = true;
            if (i3 >= 180) {
                i3 = 360 - i3;
            }
            GDTLogger.d("GDT-shakingView-- limit[0~180] " + i3);
            float f18 = (float) i3;
            float f19 = this.f40141l;
            if (f19 < 1.0f) {
                f19 = 1.0f;
            }
            int i17 = (int) (f18 * f19);
            GDTLogger.d("GDT-shakingView--  caculated with shakeSensitiveness " + i17);
            if (i17 >= 90) {
                this.f40136g = this.f40146q == 1 ? -this.f40135f : this.f40135f;
                this.f40137h = -this.f40135f;
                this.f40142m = 90.0f;
                this.f40144o = true;
                invalidate();
                synchronized (this.f40149t) {
                    com.qq.e.comm.plugin.tangramsplash.interactive.a.a aVar = this.f40145p;
                    if (aVar != null) {
                        aVar.b();
                    }
                }
                GDTLogger.d("GDT-shakingView--  shake success!!! " + i17);
                this.f40140k.disable();
                return;
            }
            this.f40142m = i17;
            float f26 = this.f40146q == 1 ? i17 + 45 : 135 - i17;
            float radians = (float) Math.toRadians(f26);
            GDTLogger.d("GDT-shakingView--  actual angle " + f26);
            double d16 = (double) radians;
            this.f40136g = ((float) this.f40138i) * ((float) Math.cos(d16));
            this.f40137h = -(((float) this.f40138i) * ((float) Math.sin(d16)));
            invalidate();
            synchronized (this.f40149t) {
                if (!this.f40148s && this.f40145p != null && i17 > 5) {
                    this.f40148s = true;
                    GDTLogger.d("GDT-shakingView--  shake begin " + i17);
                    com.qq.e.comm.plugin.tangramsplash.interactive.a.a aVar2 = this.f40145p;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            }
        }

        @Override // android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            postDelayed(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.a.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f40140k.enable();
                }
            }, 300L);
        }

        @Override // android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.f40140k.disable();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (this.f40139j) {
                float right = (getRight() - getLeft()) / 2.0f;
                float bottom = (getBottom() - getTop()) / 2.0f;
                int i3 = this.f40138i;
                this.f40131b = new RectF(right - i3, bottom - i3, right + i3, bottom + i3);
            }
            RectF rectF = this.f40131b;
            int saveLayer = canvas.saveLayer(rectF.left, rectF.top - 20.0f, rectF.right, rectF.bottom + 18.0f, null, 31);
            this.f40130a.setStrokeWidth(18.0f);
            this.f40130a.setColor(-1711276033);
            this.f40130a.setStyle(Paint.Style.STROKE);
            this.f40130a.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawArc(this.f40131b, -135.0f, 90.0f, false, this.f40130a);
            if (!this.f40143n) {
                this.f40130a.setStrokeCap(Paint.Cap.ROUND);
                float centerX = this.f40131b.centerX() + this.f40136g;
                float centerY = this.f40131b.centerY() + this.f40137h;
                this.f40130a.setColor(-855638017);
                this.f40130a.setStrokeWidth(18.0f);
                canvas.drawPoint(centerX, centerY, this.f40130a);
            }
            if (!this.f40139j && this.f40143n) {
                this.f40130a.setStyle(Paint.Style.STROKE);
                this.f40130a.setStrokeCap(Paint.Cap.ROUND);
                this.f40130a.setColor(-855638017);
                this.f40130a.setStrokeWidth(18.0f);
                if (this.f40146q == 1) {
                    RectF rectF2 = this.f40131b;
                    float f16 = this.f40142m;
                    canvas.drawArc(rectF2, (-45.0f) - f16, f16, false, this.f40130a);
                } else {
                    canvas.drawArc(this.f40131b, -135.0f, this.f40142m, false, this.f40130a);
                }
            }
            if (this.f40144o) {
                this.f40130a.setColor(-855638017);
            } else {
                this.f40130a.setColor(-1711276033);
            }
            this.f40130a.setStrokeWidth(1.0f);
            this.f40130a.setStyle(Paint.Style.FILL);
            a(canvas);
            canvas.restoreToCount(saveLayer);
            this.f40139j = false;
        }

        @Override // android.view.View
        protected void onMeasure(int i3, int i16) {
            super.onMeasure(i3, i16);
            int size = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i16);
            int mode2 = View.MeasureSpec.getMode(i16);
            if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                setMeasuredDimension(ak.a(getContext(), 120), ak.a(getContext(), 120));
            } else if (mode == Integer.MIN_VALUE) {
                setMeasuredDimension(ak.a(getContext(), 120), size2);
            } else if (mode2 == Integer.MIN_VALUE) {
                setMeasuredDimension(size, ak.a(getContext(), 120));
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0);
        }

        private void a(Canvas canvas) {
            float centerX = this.f40131b.centerX() + (this.f40146q == 1 ? -this.f40135f : this.f40135f);
            float centerY = this.f40131b.centerY() - this.f40135f;
            this.f40130a.setXfermode(this.f40147r);
            this.f40132c.moveTo((this.f40146q == 1 ? -this.f40134e : this.f40134e) + centerX, centerY - this.f40134e);
            Path path = this.f40132c;
            float f16 = this.f40134e;
            path.lineTo(centerX - f16, f16 + centerY);
            Path path2 = this.f40132c;
            float f17 = this.f40134e;
            path2.lineTo(centerX + f17, centerY + f17);
            this.f40132c.close();
            canvas.drawPath(this.f40132c, this.f40130a);
            this.f40130a.setXfermode(null);
        }

        public a(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            float sqrt = ((float) Math.sqrt(2.0d)) / 2.0f;
            this.f40133d = sqrt;
            this.f40134e = 25.4f * sqrt;
            this.f40139j = true;
            this.f40142m = 0.0f;
            this.f40143n = false;
            this.f40144o = false;
            this.f40146q = 1;
            this.f40141l = 0.5f;
            this.f40148s = false;
            this.f40149t = new Object();
            setLayerType(1, null);
            Paint paint = new Paint();
            this.f40130a = paint;
            paint.setAntiAlias(true);
            this.f40138i = ak.a(context, 50);
            this.f40132c = new Path();
            this.f40147r = new PorterDuffXfermode(PorterDuff.Mode.SRC);
            this.f40135f = sqrt * this.f40138i;
            this.f40140k = new OrientationEventListener(getContext(), 3) { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.a.b.a.1

                /* renamed from: a, reason: collision with root package name */
                int f40150a = -1;

                /* renamed from: b, reason: collision with root package name */
                boolean f40151b = false;

                /* renamed from: c, reason: collision with root package name */
                int f40152c = 0;

                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int i16) {
                    if (i16 == -1) {
                        return;
                    }
                    if (!this.f40151b) {
                        this.f40150a = i16;
                        this.f40151b = true;
                        GDTLogger.d("GDT-shakingView------- lastValue " + this.f40150a);
                        return;
                    }
                    GDTLogger.d("GDT-shakingView-- orientation " + i16);
                    int i17 = this.f40150a;
                    if (i17 != -1 && i16 != 0 && Math.abs(i17 - i16) > 2) {
                        int i18 = this.f40150a;
                        if (i16 > i18 && i16 <= 360) {
                            this.f40152c = i16 - i18;
                        } else {
                            this.f40152c = (i16 + 360) - i18;
                        }
                        GDTLogger.d("GDT-shakingView-- offset ori " + this.f40152c);
                        a.this.b(this.f40152c);
                    }
                }
            };
        }

        public void a(int i3) {
            float f16 = this.f40135f;
            if (i3 != 1) {
                f16 = -f16;
            }
            this.f40136g = f16;
            this.f40137h = -this.f40135f;
            this.f40142m = i3 == 1 ? -45.0f : -135.0f;
            this.f40146q = i3;
        }

        public void a(com.qq.e.comm.plugin.tangramsplash.interactive.a.a aVar) {
            synchronized (this.f40149t) {
                this.f40145p = aVar;
            }
        }

        public void a(float f16) {
            GDTLogger.i("GDT-shakingView--  shakeSensitiveness " + f16);
            this.f40141l = f16;
        }

        public void a() {
            OrientationEventListener orientationEventListener = this.f40140k;
            if (orientationEventListener != null) {
                orientationEventListener.disable();
            }
        }

        public void b() {
            OrientationEventListener orientationEventListener = this.f40140k;
            if (orientationEventListener != null) {
                orientationEventListener.enable();
            }
        }
    }

    public b(Context context) {
        this(context, null);
    }

    public void a() {
        final ImageView imageView = new ImageView(this.f40126f);
        imageView.setImageBitmap(am.a("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"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ak.a(getContext(), 70), ak.a(getContext(), 70));
        layoutParams.gravity = 1;
        layoutParams.topMargin = ak.a(getContext(), 63);
        addView(imageView, layoutParams);
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f40123c == 1 ? new int[]{0, 0, -45, -45, 5, -5, 0} : new int[]{0, 0, 45, 45, -5, 5, 0});
        this.f40125e = ofInt;
        ofInt.setDuration(1400L);
        this.f40125e.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f40125e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.a.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getAnimatedValue() instanceof Integer) {
                    imageView.setRotation(((Integer) r2).intValue());
                }
            }
        });
        this.f40125e.setRepeatCount(-1);
        this.f40125e.start();
        TextView textView = new TextView(this.f40126f);
        textView.setText(this.f40121a);
        textView.setTextColor(-1);
        textView.setTextSize(17.0f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = ak.a(getContext(), 143);
        layoutParams2.gravity = 1;
        addView(textView, layoutParams2);
        TextView textView2 = new TextView(this.f40126f);
        textView2.setText(this.f40122b);
        textView2.setTextColor(-1275068417);
        textView2.setTextSize(14.0f);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = ak.a(getContext(), 172);
        layoutParams3.gravity = 1;
        addView(textView2, layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 1;
        layoutParams4.topMargin = ak.a(getContext(), 35);
        addView(this.f40124d, layoutParams4);
    }

    public void b(String str) {
        this.f40122b = str;
    }

    public void c() {
        this.f40124d.b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f40125e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f40125e = null;
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void b() {
        this.f40124d.a();
    }

    public b(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f40121a = "\u6643\u52a8\u624b\u673a";
        this.f40122b = "";
        this.f40123c = 1;
        this.f40126f = context;
        this.f40124d = new a(context);
    }

    public void a(String str) {
        this.f40121a = str;
    }

    public void a(float f16) {
        this.f40124d.a(f16);
    }

    public void a(com.qq.e.comm.plugin.tangramsplash.interactive.a.a aVar) {
        this.f40124d.a(aVar);
    }

    public void a(int i3) {
        this.f40123c = i3;
        this.f40124d.a(i3);
    }
}
