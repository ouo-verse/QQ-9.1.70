package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes10.dex */
public class LoadingAvatarProgressView extends View {
    static IPatchRedirector $redirector_;
    private Paint C;
    private int D;
    private float E;
    private int F;
    private RectF G;
    private int H;
    private int I;
    private int J;
    private RectF K;
    private PathMeasure L;
    private float M;
    private Path N;
    private float P;
    private int Q;
    private RectF R;
    private Paint S;

    /* renamed from: d, reason: collision with root package name */
    private int f181056d;

    /* renamed from: e, reason: collision with root package name */
    private int f181057e;

    /* renamed from: f, reason: collision with root package name */
    private int f181058f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f181059h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f181060i;

    /* renamed from: m, reason: collision with root package name */
    private Path f181061m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoadingAvatarProgressView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            LoadingAvatarProgressView.this.M = ((Float) valueAnimator.getAnimatedValue()).floatValue() * LoadingAvatarProgressView.this.P;
            LoadingAvatarProgressView.this.invalidate();
        }
    }

    /* loaded from: classes10.dex */
    interface b {
    }

    public LoadingAvatarProgressView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void c(Canvas canvas) {
        if (this.H < 100) {
            canvas.drawArc(this.G, -90.0f, (r0 * 360) / 100, false, this.C);
            this.H += 2;
            postInvalidateDelayed(this.J);
        } else if (this.f181059h) {
            this.C.setStyle(Paint.Style.FILL);
            canvas.drawCircle(this.f181056d, this.f181057e, Math.min(r0, r2), this.C);
            canvas.drawPath(this.f181061m, this.f181060i);
        }
    }

    private void d(Canvas canvas) {
        if (this.I < 100) {
            this.S.setStyle(Paint.Style.STROKE);
            this.S.setColor(Color.parseColor("#8E8E93"));
            canvas.drawArc(this.R, -90.0f, (this.I * 360) / 100, false, this.S);
            this.I += 2;
            postInvalidateDelayed(this.J);
            return;
        }
        this.I = 0;
        postInvalidateDelayed(this.J);
    }

    private void e(Canvas canvas) {
        if (this.M < this.P) {
            this.N.reset();
            this.N.lineTo(0.0f, 0.0f);
            this.L.getSegment(0.0f, this.M, this.N, false);
            canvas.drawPath(this.N, this.C);
            return;
        }
        if (this.f181059h) {
            this.C.setStyle(Paint.Style.FILL);
            RectF rectF = this.K;
            int i3 = this.Q;
            canvas.drawRoundRect(rectF, i3, i3, this.C);
            canvas.drawPath(this.f181061m, this.f181060i);
        }
    }

    private void f(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleLoadingView);
        this.E = obtainStyledAttributes.getInteger(R.styleable.CircleLoadingView_loading_width, 5);
        this.E = BaseAIOUtils.f(r4, getResources());
        int integer = obtainStyledAttributes.getInteger(R.styleable.CircleLoadingView_loading_roundSize, 5);
        this.Q = integer;
        this.Q = BaseAIOUtils.f(integer, getResources());
        this.D = obtainStyledAttributes.getInteger(R.styleable.CircleLoadingView_loading_color, -16776961);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.C = paint;
        paint.setAntiAlias(true);
        this.C.setStyle(Paint.Style.STROKE);
        this.C.setStrokeWidth(this.E);
        this.C.setColor(this.D);
        Paint paint2 = new Paint();
        this.S = paint2;
        paint2.setAntiAlias(true);
        this.S.setStyle(Paint.Style.FILL);
        this.S.setStrokeWidth(this.E);
        this.S.setColor(this.D);
        Paint paint3 = new Paint();
        this.f181060i = paint3;
        paint3.setAntiAlias(true);
        this.f181060i.setStyle(Paint.Style.STROKE);
        this.f181060i.setStrokeWidth(this.E);
        this.f181060i.setColor(this.D);
    }

    private void g() {
        this.N = new Path();
        float f16 = this.f181056d * 2;
        float f17 = this.f181057e * 2;
        this.K = new RectF(0.0f, 0.0f, f16, f17);
        Path path = new Path();
        path.moveTo(this.f181056d, 0.0f);
        path.lineTo(f16, 0.0f);
        path.lineTo(f16, f17);
        path.lineTo(0.0f, f17);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.f181056d, 0.0f);
        path.close();
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.L = pathMeasure;
        this.P = pathMeasure.getLength();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(this.F);
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
    }

    private void h() {
        int f16 = BaseAIOUtils.f(12.0f, getResources());
        int f17 = BaseAIOUtils.f(4.0f, getResources());
        int i3 = this.f181056d;
        int i16 = this.f181057e;
        int i17 = f16 / 2;
        int i18 = (f16 * 2) / 4;
        Path path = new Path();
        this.f181061m = path;
        path.reset();
        this.f181061m.moveTo((i3 - f16) + f17, i16);
        this.f181061m.lineTo((i3 - i17) + f17, i17 + i16);
        this.f181061m.lineTo(i3 + i18 + f17, i16 - i18);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        int i3 = this.f181058f;
        if (i3 == 0) {
            c(canvas);
        } else if (i3 == 1) {
            e(canvas);
        } else if (i3 == 2) {
            d(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onSizeChanged(i3, i16, i17, i18);
        int width = getWidth();
        int height = getHeight();
        this.f181056d = width / 2;
        this.f181057e = height / 2;
        float f16 = this.E;
        float f17 = width;
        float f18 = height;
        this.G = new RectF(f16 / 2.0f, f16 / 2.0f, f17 - (f16 / 2.0f), f18 - (f16 / 2.0f));
        float f19 = this.E;
        this.R = new RectF(f19 / 2.0f, f19 / 2.0f, f17 - (f19 / 2.0f), f18 - (f19 / 2.0f));
        g();
        if (this.f181059h) {
            h();
        }
    }

    public void setAnimDuration(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.F = i3;
            this.J = i3 / 50;
        }
    }

    public void setLoadType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.H = 0;
            this.f181058f = i3;
        }
    }

    public void setNeedCover(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.f181059h = z16;
        }
    }

    public void setProgressListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
        }
    }

    public void setRoundSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.Q = i3;
        }
    }

    public LoadingAvatarProgressView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public LoadingAvatarProgressView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f181059h = false;
        this.D = 0;
        this.F = 1500;
        this.H = 0;
        this.I = 0;
        this.J = 30;
        f(context, attributeSet);
    }
}
