package com.tencent.qqnt.widget.badgeview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QBadgeView extends View implements com.tencent.qqnt.widget.badgeview.a {
    static IPatchRedirector $redirector_;
    protected float C;
    protected float D;
    protected float E;
    protected int F;
    protected String G;
    protected int H;
    protected int I;
    protected boolean J;
    protected boolean K;
    protected boolean L;
    protected boolean M;
    protected boolean N;
    protected int P;
    protected float Q;
    protected float R;
    protected float S;
    protected float T;
    protected int U;
    protected boolean V;
    protected RectF W;

    /* renamed from: a0, reason: collision with root package name */
    protected RectF f363023a0;

    /* renamed from: b0, reason: collision with root package name */
    protected Path f363024b0;

    /* renamed from: c0, reason: collision with root package name */
    protected Paint.FontMetrics f363025c0;

    /* renamed from: d, reason: collision with root package name */
    protected int f363026d;

    /* renamed from: d0, reason: collision with root package name */
    protected PointF f363027d0;

    /* renamed from: e, reason: collision with root package name */
    protected int f363028e;

    /* renamed from: e0, reason: collision with root package name */
    protected PointF f363029e0;

    /* renamed from: f, reason: collision with root package name */
    protected int f363030f;

    /* renamed from: f0, reason: collision with root package name */
    protected PointF f363031f0;

    /* renamed from: g0, reason: collision with root package name */
    protected PointF f363032g0;

    /* renamed from: h, reason: collision with root package name */
    protected Drawable f363033h;

    /* renamed from: h0, reason: collision with root package name */
    protected List<PointF> f363034h0;

    /* renamed from: i, reason: collision with root package name */
    protected Bitmap f363035i;

    /* renamed from: i0, reason: collision with root package name */
    protected View f363036i0;

    /* renamed from: j0, reason: collision with root package name */
    protected int f363037j0;

    /* renamed from: k0, reason: collision with root package name */
    protected int f363038k0;

    /* renamed from: l0, reason: collision with root package name */
    protected TextPaint f363039l0;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f363040m;

    /* renamed from: m0, reason: collision with root package name */
    protected Paint f363041m0;

    /* renamed from: n0, reason: collision with root package name */
    protected Paint f363042n0;

    /* renamed from: o0, reason: collision with root package name */
    protected com.tencent.qqnt.widget.badgeview.b f363043o0;

    /* renamed from: p0, reason: collision with root package name */
    protected ViewGroup f363044p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f363045q0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PointF f363046d;

        a(PointF pointF) {
            this.f363046d = pointF;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QBadgeView.this, (Object) pointF);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            QBadgeView.this.L = true;
            PointF c16 = d.c(this.f363046d, QBadgeView.this.f363031f0, valueAnimator.getAnimatedFraction());
            QBadgeView qBadgeView = QBadgeView.this;
            PointF pointF = qBadgeView.f363029e0;
            pointF.x = c16.x;
            pointF.y = c16.y;
            qBadgeView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QBadgeView.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            QBadgeView qBadgeView = QBadgeView.this;
            qBadgeView.L = false;
            qBadgeView.r();
            QBadgeView.this.w(4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            QBadgeView qBadgeView = QBadgeView.this;
            qBadgeView.L = false;
            qBadgeView.r();
            QBadgeView.this.w(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class c extends ViewGroup {
        static IPatchRedirector $redirector_;

        public c(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) QBadgeView.this, (Object) context);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sparseArray);
            } else if (!(getParent() instanceof RelativeLayout)) {
                super.dispatchRestoreInstanceState(sparseArray);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            for (int i19 = 0; i19 < getChildCount(); i19++) {
                View childAt = getChildAt(i19);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            View view = null;
            View view2 = null;
            for (int i17 = 0; i17 < getChildCount(); i17++) {
                View childAt = getChildAt(i17);
                if (!(childAt instanceof QBadgeView)) {
                    view = childAt;
                } else {
                    view2 = childAt;
                }
            }
            if (view == null) {
                super.onMeasure(i3, i16);
                return;
            }
            view.measure(i3, i16);
            if (view2 != null) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
            }
            setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public QBadgeView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void e() {
        if (this.G == null || !this.f363040m) {
            return;
        }
        Bitmap bitmap = this.f363035i;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f363035i.recycle();
        }
        float l3 = l();
        if (!this.G.isEmpty() && this.G.length() != 1) {
            this.f363035i = Bitmap.createBitmap((int) (this.W.width() + (this.E * 2.0f)), (int) (this.W.height() + this.E), Bitmap.Config.ARGB_4444);
            new Canvas(this.f363035i).drawRoundRect(0.0f, 0.0f, r3.getWidth(), r3.getHeight(), r3.getHeight() / 2.0f, r3.getHeight() / 2.0f, this.f363041m0);
        } else {
            int i3 = ((int) l3) * 2;
            this.f363035i = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_4444);
            new Canvas(this.f363035i).drawCircle(r0.getWidth() / 2.0f, r0.getHeight() / 2.0f, r0.getWidth() / 2.0f, this.f363041m0);
        }
    }

    private void f(Canvas canvas, PointF pointF, float f16) {
        if (pointF.x == -1000.0f && pointF.y == -1000.0f) {
            return;
        }
        if (!this.G.isEmpty() && this.G.length() != 1) {
            this.f363023a0.left = pointF.x - ((this.W.width() / 2.0f) + this.E);
            this.f363023a0.top = pointF.y - ((this.W.height() / 2.0f) + (this.E * 0.5f));
            this.f363023a0.right = pointF.x + (this.W.width() / 2.0f) + this.E;
            this.f363023a0.bottom = pointF.y + (this.W.height() / 2.0f) + (this.E * 0.5f);
            float height = this.f363023a0.height() / 2.0f;
            if (this.f363033h != null) {
                g(canvas);
            } else {
                canvas.drawRoundRect(this.f363023a0, height, height, this.f363041m0);
                if (this.f363028e != 0 && this.C > 0.0f) {
                    canvas.drawRoundRect(this.f363023a0, height, height, this.f363042n0);
                }
            }
        } else {
            RectF rectF = this.f363023a0;
            float f17 = pointF.x;
            float f18 = (int) f16;
            rectF.left = f17 - f18;
            float f19 = pointF.y;
            rectF.top = f19 - f18;
            rectF.right = f17 + f18;
            rectF.bottom = f18 + f19;
            if (this.f363033h != null) {
                g(canvas);
            } else {
                canvas.drawCircle(f17, f19, f16, this.f363041m0);
                if (this.f363028e != 0 && this.C > 0.0f) {
                    canvas.drawCircle(pointF.x, pointF.y, f16, this.f363042n0);
                }
            }
        }
        if (!this.G.isEmpty()) {
            String str = this.G;
            float f26 = pointF.x + this.H;
            RectF rectF2 = this.f363023a0;
            float f27 = rectF2.bottom + rectF2.top;
            Paint.FontMetrics fontMetrics = this.f363025c0;
            canvas.drawText(str, f26, (((f27 - fontMetrics.bottom) - fontMetrics.top) / 2.0f) + this.I, this.f363039l0);
        }
    }

    private void g(Canvas canvas) {
        this.f363041m0.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        RectF rectF = this.f363023a0;
        int i3 = (int) rectF.left;
        int i16 = (int) rectF.top;
        int i17 = (int) rectF.right;
        int i18 = (int) rectF.bottom;
        if (this.f363040m) {
            i17 = i3 + this.f363035i.getWidth();
            i18 = this.f363035i.getHeight() + i16;
            canvas.saveLayer(i3, i16, i17, i18, null, 31);
        }
        this.f363033h.setBounds(i3, i16, i17, i18);
        this.f363033h.draw(canvas);
        if (this.f363040m) {
            this.f363041m0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawBitmap(this.f363035i, i3, i16, this.f363041m0);
            canvas.restore();
            this.f363041m0.setXfermode(null);
            if (!this.G.isEmpty() && this.G.length() != 1) {
                RectF rectF2 = this.f363023a0;
                canvas.drawRoundRect(rectF2, rectF2.height() / 2.0f, this.f363023a0.height() / 2.0f, this.f363042n0);
                return;
            } else {
                canvas.drawCircle(this.f363023a0.centerX(), this.f363023a0.centerY(), this.f363023a0.width() / 2.0f, this.f363042n0);
                return;
            }
        }
        canvas.drawRect(this.f363023a0, this.f363042n0);
    }

    private void h(Canvas canvas, float f16, float f17) {
        Path.Direction direction;
        float f18;
        float f19;
        float f26;
        int i3;
        PointF pointF = this.f363029e0;
        float f27 = pointF.y;
        PointF pointF2 = this.f363031f0;
        float f28 = f27 - pointF2.y;
        float f29 = pointF.x - pointF2.x;
        this.f363034h0.clear();
        if (f29 != 0.0f) {
            double d16 = (-1.0d) / (f28 / f29);
            d.b(this.f363029e0, f17, Double.valueOf(d16), this.f363034h0);
            d.b(this.f363031f0, f16, Double.valueOf(d16), this.f363034h0);
        } else {
            d.b(this.f363029e0, f17, Double.valueOf(0.0d), this.f363034h0);
            d.b(this.f363031f0, f16, Double.valueOf(0.0d), this.f363034h0);
        }
        this.f363024b0.reset();
        Path path = this.f363024b0;
        PointF pointF3 = this.f363031f0;
        float f36 = pointF3.x;
        float f37 = pointF3.y;
        int i16 = this.U;
        if (i16 != 1 && i16 != 2) {
            direction = Path.Direction.CW;
        } else {
            direction = Path.Direction.CCW;
        }
        path.addCircle(f36, f37, f16, direction);
        PointF pointF4 = this.f363032g0;
        PointF pointF5 = this.f363031f0;
        float f38 = pointF5.x;
        PointF pointF6 = this.f363029e0;
        pointF4.x = (f38 + pointF6.x) / 2.0f;
        pointF4.y = (pointF5.y + pointF6.y) / 2.0f;
        this.f363024b0.moveTo(this.f363034h0.get(2).x, this.f363034h0.get(2).y);
        Path path2 = this.f363024b0;
        PointF pointF7 = this.f363032g0;
        path2.quadTo(pointF7.x, pointF7.y, this.f363034h0.get(0).x, this.f363034h0.get(0).y);
        this.f363024b0.lineTo(this.f363034h0.get(1).x, this.f363034h0.get(1).y);
        Path path3 = this.f363024b0;
        PointF pointF8 = this.f363032g0;
        path3.quadTo(pointF8.x, pointF8.y, this.f363034h0.get(3).x, this.f363034h0.get(3).y);
        this.f363024b0.lineTo(this.f363034h0.get(2).x, this.f363034h0.get(2).y);
        this.f363024b0.close();
        canvas.drawPath(this.f363024b0, this.f363041m0);
        if (this.f363028e != 0 && this.C > 0.0f) {
            this.f363024b0.reset();
            this.f363024b0.moveTo(this.f363034h0.get(2).x, this.f363034h0.get(2).y);
            Path path4 = this.f363024b0;
            PointF pointF9 = this.f363032g0;
            path4.quadTo(pointF9.x, pointF9.y, this.f363034h0.get(0).x, this.f363034h0.get(0).y);
            this.f363024b0.moveTo(this.f363034h0.get(1).x, this.f363034h0.get(1).y);
            Path path5 = this.f363024b0;
            PointF pointF10 = this.f363032g0;
            path5.quadTo(pointF10.x, pointF10.y, this.f363034h0.get(3).x, this.f363034h0.get(3).y);
            int i17 = this.U;
            if (i17 != 1 && i17 != 2) {
                float f39 = this.f363034h0.get(3).x;
                PointF pointF11 = this.f363031f0;
                f18 = f39 - pointF11.x;
                f19 = pointF11.y;
                f26 = this.f363034h0.get(3).y;
            } else {
                float f46 = this.f363034h0.get(2).x;
                PointF pointF12 = this.f363031f0;
                f18 = f46 - pointF12.x;
                f19 = pointF12.y;
                f26 = this.f363034h0.get(2).y;
            }
            double atan = Math.atan((f19 - f26) / f18);
            int i18 = this.U;
            if (i18 - 1 == 0) {
                i3 = 4;
            } else {
                i3 = i18 - 1;
            }
            float g16 = 360.0f - ((float) d.g(d.f(atan, i3)));
            Path path6 = this.f363024b0;
            PointF pointF13 = this.f363031f0;
            float f47 = pointF13.x;
            float f48 = pointF13.y;
            path6.addArc(f47 - f16, f48 - f16, f47 + f16, f48 + f16, g16, 180.0f);
            canvas.drawPath(this.f363024b0, this.f363042n0);
        }
    }

    private void i(View view) {
        if (view.getParent() != null && (view.getParent() instanceof View)) {
            i((View) view.getParent());
        } else if (view instanceof ViewGroup) {
            this.f363044p0 = (ViewGroup) view;
        }
    }

    private void j() {
        float width;
        if (this.W.height() > this.W.width()) {
            width = this.W.height();
        } else {
            width = this.W.width();
        }
        switch (this.P) {
            case 17:
                PointF pointF = this.f363027d0;
                pointF.x = (this.f363037j0 / 2.0f) + this.Q;
                pointF.y = (this.f363038k0 / 2.0f) + this.R;
                break;
            case 49:
                PointF pointF2 = this.f363027d0;
                pointF2.x = this.f363037j0 / 2.0f;
                pointF2.y = this.R + this.E + (this.W.height() / 2.0f);
                break;
            case 81:
                PointF pointF3 = this.f363027d0;
                pointF3.x = this.f363037j0 / 2.0f;
                pointF3.y = this.f363038k0 - ((this.R + this.E) + (this.W.height() / 2.0f));
                break;
            case 8388627:
                PointF pointF4 = this.f363027d0;
                pointF4.x = this.Q + this.E + (width / 2.0f);
                pointF4.y = this.f363038k0 / 2.0f;
                break;
            case 8388629:
                PointF pointF5 = this.f363027d0;
                pointF5.x = this.f363037j0 - ((this.Q + this.E) + (width / 2.0f));
                pointF5.y = this.f363038k0 / 2.0f;
                break;
            case 8388659:
                PointF pointF6 = this.f363027d0;
                float f16 = this.Q;
                float f17 = this.E;
                pointF6.x = f16 + f17 + (width / 2.0f);
                pointF6.y = this.R + f17 + (this.W.height() / 2.0f);
                break;
            case 8388661:
                PointF pointF7 = this.f363027d0;
                float f18 = this.f363037j0;
                float f19 = this.Q;
                float f26 = this.E;
                pointF7.x = f18 - ((f19 + f26) + (width / 2.0f));
                pointF7.y = this.R + f26 + (this.W.height() / 2.0f);
                break;
            case 8388691:
                PointF pointF8 = this.f363027d0;
                float f27 = this.Q;
                float f28 = this.E;
                pointF8.x = f27 + f28 + (width / 2.0f);
                pointF8.y = this.f363038k0 - ((this.R + f28) + (this.W.height() / 2.0f));
                break;
            case 8388693:
                PointF pointF9 = this.f363027d0;
                float f29 = this.f363037j0;
                float f36 = this.Q;
                float f37 = this.E;
                pointF9.x = f29 - ((f36 + f37) + (width / 2.0f));
                pointF9.y = this.f363038k0 - ((this.R + f37) + (this.W.height() / 2.0f));
                break;
        }
        o();
    }

    private void k(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getRootView();
        this.f363044p0 = viewGroup;
        if (viewGroup == null) {
            i(view);
        }
    }

    private float l() {
        float width;
        float f16;
        if (this.G.isEmpty()) {
            return this.E;
        }
        if (this.G.length() == 1) {
            if (this.W.height() > this.W.width()) {
                width = this.W.height() / 2.0f;
                f16 = this.E;
            } else {
                width = this.W.width() / 2.0f;
                f16 = this.E;
            }
            return width + (f16 * 0.5f);
        }
        return this.f363023a0.height() / 2.0f;
    }

    private void m() {
        setLayerType(1, null);
        this.W = new RectF();
        this.f363023a0 = new RectF();
        this.f363024b0 = new Path();
        this.f363027d0 = new PointF();
        this.f363029e0 = new PointF();
        this.f363031f0 = new PointF();
        this.f363032g0 = new PointF();
        this.f363034h0 = new ArrayList();
        TextPaint textPaint = new TextPaint();
        this.f363039l0 = textPaint;
        textPaint.setAntiAlias(true);
        this.f363039l0.setSubpixelText(true);
        this.f363039l0.setFakeBoldText(true);
        this.f363039l0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Paint paint = new Paint();
        this.f363041m0 = paint;
        paint.setAntiAlias(true);
        this.f363041m0.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f363042n0 = paint2;
        paint2.setAntiAlias(true);
        this.f363042n0.setStyle(Paint.Style.STROKE);
        this.f363026d = -1552832;
        this.f363030f = -1;
        this.D = com.tencent.qqnt.widget.badgeview.c.a(getContext(), 11.0f);
        this.E = com.tencent.qqnt.widget.badgeview.c.a(getContext(), 5.0f);
        this.F = 0;
        this.P = 8388661;
        this.Q = com.tencent.qqnt.widget.badgeview.c.a(getContext(), 1.0f);
        this.R = com.tencent.qqnt.widget.badgeview.c.a(getContext(), 1.0f);
        this.T = com.tencent.qqnt.widget.badgeview.c.a(getContext(), 90.0f);
        this.N = true;
        this.f363045q0 = true;
        this.f363040m = false;
        this.H = 0;
        this.I = 0;
        setTranslationZ(1000.0f);
    }

    private void n() {
        u(this.N);
        this.f363041m0.setColor(this.f363026d);
        this.f363042n0.setColor(this.f363028e);
        this.f363042n0.setStrokeWidth(this.C);
        this.f363039l0.setColor(this.f363030f);
        this.f363039l0.setTextAlign(Paint.Align.CENTER);
    }

    private void o() {
        getLocationOnScreen(new int[2]);
        PointF pointF = this.f363031f0;
        PointF pointF2 = this.f363027d0;
        pointF.x = pointF2.x + r0[0];
        pointF.y = pointF2.y + r0[1];
    }

    private void p() {
        RectF rectF = this.W;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        if (TextUtils.isEmpty(this.G)) {
            RectF rectF2 = this.W;
            rectF2.right = 0.0f;
            rectF2.bottom = 0.0f;
        } else {
            this.f363039l0.setTextSize(this.D);
            this.W.right = this.f363039l0.measureText(this.G);
            Paint.FontMetrics fontMetrics = this.f363039l0.getFontMetrics();
            this.f363025c0 = fontMetrics;
            this.W.bottom = fontMetrics.descent - fontMetrics.ascent;
        }
        e();
    }

    private void q() {
        if (this.V) {
            b(this.f363029e0);
            w(5);
        } else {
            try {
                v();
            } catch (Exception unused) {
                r();
                w(4);
            }
        }
    }

    private void u(boolean z16) {
        float f16;
        int a16 = com.tencent.qqnt.widget.badgeview.c.a(getContext(), 1.0f);
        int a17 = com.tencent.qqnt.widget.badgeview.c.a(getContext(), 1.5f);
        int i3 = this.U;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        a16 = com.tencent.qqnt.widget.badgeview.c.a(getContext(), 1.0f);
                        a17 = com.tencent.qqnt.widget.badgeview.c.a(getContext(), 1.5f);
                    }
                } else {
                    a16 = com.tencent.qqnt.widget.badgeview.c.a(getContext(), -1.0f);
                    a17 = com.tencent.qqnt.widget.badgeview.c.a(getContext(), 1.5f);
                }
            } else {
                a16 = com.tencent.qqnt.widget.badgeview.c.a(getContext(), -1.0f);
                a17 = com.tencent.qqnt.widget.badgeview.c.a(getContext(), -1.5f);
            }
        } else {
            a16 = com.tencent.qqnt.widget.badgeview.c.a(getContext(), 1.0f);
            a17 = com.tencent.qqnt.widget.badgeview.c.a(getContext(), -1.5f);
        }
        Paint paint = this.f363041m0;
        if (z16) {
            f16 = com.tencent.qqnt.widget.badgeview.c.a(getContext(), 2.0f);
        } else {
            f16 = 0.0f;
        }
        paint.setShadowLayer(f16, a16, a17, 855638016);
    }

    private void v() {
        PointF pointF = this.f363029e0;
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        ofFloat.addUpdateListener(new a(pointF2));
        ofFloat.addListener(new b());
        ofFloat.setInterpolator(new OvershootInterpolator(4.0f));
        ofFloat.setRepeatCount(1);
        ofFloat.setRepeatMode(-1);
        ofFloat.setDuration(150L);
        ofFloat.start();
    }

    protected void b(PointF pointF) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) pointF);
            return;
        }
        if (this.G == null) {
            return;
        }
        com.tencent.qqnt.widget.badgeview.b bVar = this.f363043o0;
        if (bVar == null || !bVar.isRunning()) {
            s(true);
            com.tencent.qqnt.widget.badgeview.b bVar2 = new com.tencent.qqnt.widget.badgeview.b(d(), pointF, this);
            this.f363043o0 = bVar2;
            bVar2.start();
            t(0);
        }
    }

    public com.tencent.qqnt.widget.badgeview.a c(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.widget.badgeview.a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        }
        if (view != null) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                this.f363036i0 = view;
                if (parent instanceof c) {
                    ((c) parent).addView(this);
                } else {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    viewGroup.removeView(view);
                    c cVar = new c(getContext());
                    if (viewGroup instanceof RelativeLayout) {
                        cVar.setId(view.getId());
                    }
                    viewGroup.addView(cVar, indexOfChild, layoutParams);
                    cVar.addView(view);
                    cVar.addView(this);
                }
                return this;
            }
            throw new IllegalStateException("targetView must have a parent");
        }
        throw new IllegalStateException("targetView can not be null");
    }

    protected Bitmap d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bitmap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        Bitmap createBitmap = Bitmap.createBitmap(((int) this.f363023a0.width()) + com.tencent.qqnt.widget.badgeview.c.a(getContext(), 3.0f), ((int) this.f363023a0.height()) + com.tencent.qqnt.widget.badgeview.c.a(getContext(), 3.0f), Bitmap.Config.ARGB_8888);
        f(new Canvas(createBitmap), new PointF(r1.getWidth() / 2.0f, r1.getHeight() / 2.0f), l());
        return createBitmap;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        if (this.f363044p0 == null) {
            k(this.f363036i0);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) canvas);
            return;
        }
        com.tencent.qqnt.widget.badgeview.b bVar = this.f363043o0;
        if (bVar != null && bVar.isRunning()) {
            this.f363043o0.b(canvas);
            return;
        }
        if (this.G != null) {
            n();
            float l3 = l();
            float d16 = this.S * (1.0f - (d.d(this.f363031f0, this.f363029e0) / this.T));
            boolean z17 = this.J;
            if (z17 && this.K) {
                this.U = d.e(this.f363029e0, this.f363031f0);
                u(this.N);
                if (d16 < com.tencent.qqnt.widget.badgeview.c.a(getContext(), 1.5f)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.V = z16;
                if (z16) {
                    w(3);
                    f(canvas, this.f363029e0, l3);
                    return;
                } else {
                    w(2);
                    h(canvas, d16, l3);
                    f(canvas, this.f363029e0, l3);
                    return;
                }
            }
            if (z17 && this.L) {
                w(6);
                f(canvas, this.f363029e0, l3);
            } else {
                j();
                f(canvas, this.f363027d0, l3);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        this.f363037j0 = i3;
        this.f363038k0 = i16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        if (r0 != 6) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cc  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.f363045q0) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                        }
                    }
                } else if (this.K) {
                    this.f363029e0.x = motionEvent.getRawX();
                    this.f363029e0.y = motionEvent.getRawY();
                    invalidate();
                }
                if (this.K && !super.onTouchEvent(motionEvent)) {
                    return false;
                }
                return true;
            }
            if (motionEvent.getPointerId(motionEvent.getActionIndex()) == 0 && this.K) {
                this.K = false;
                q();
            }
            if (this.K) {
            }
            return true;
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (this.J && motionEvent.getPointerId(motionEvent.getActionIndex()) == 0) {
            RectF rectF = this.f363023a0;
            if (x16 > rectF.left && x16 < rectF.right && y16 > rectF.top && y16 < rectF.bottom && this.G != null) {
                o();
                this.K = true;
                w(1);
                this.S = com.tencent.qqnt.widget.badgeview.c.a(getContext(), 7.0f);
                getParent().requestDisallowInterceptTouchEvent(true);
                s(true);
                this.f363029e0.x = motionEvent.getRawX();
                this.f363029e0.y = motionEvent.getRawY();
            }
        }
        if (this.K) {
        }
        return true;
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        PointF pointF = this.f363029e0;
        pointF.x = -1000.0f;
        pointF.y = -1000.0f;
        this.U = 4;
        s(false);
        getParent().requestDisallowInterceptTouchEvent(false);
        invalidate();
    }

    protected void s(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (z16) {
            this.f363044p0.addView(this, new FrameLayout.LayoutParams(-1, -1));
        } else {
            c(this.f363036i0);
        }
    }

    public void setBadgeTextXOffset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, i3);
        } else {
            this.H = i3;
        }
    }

    public void setBadgeTextYOffset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, i3);
        } else {
            this.I = i3;
        }
    }

    public void setEnableDrag(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f363045q0 = z16;
        }
    }

    public com.tencent.qqnt.widget.badgeview.a t(int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.qqnt.widget.badgeview.a) iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
        this.F = i3;
        if (i3 < 0) {
            this.G = "";
        } else if (i3 > 99) {
            if (this.M) {
                str = String.valueOf(i3);
            } else {
                str = "99+";
            }
            this.G = str;
        } else if (i3 > 0 && i3 <= 99) {
            this.G = String.valueOf(i3);
        } else if (i3 == 0) {
            this.G = null;
        }
        p();
        invalidate();
        return this;
    }

    QBadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    QBadgeView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            m();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i3) {
    }
}
