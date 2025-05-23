package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.c;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.e;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
public class VideoFrameSelectBar extends View implements b, e.a, c.InterfaceC7205c {
    private static final int Q = ViewUtils.dip2px(13.0f);
    private boolean C;
    private boolean D;
    private float E;
    private float F;
    private int G;
    private float H;
    private float I;
    private float J;
    private Paint K;
    private String L;
    private boolean M;
    private a N;
    private float P;

    /* renamed from: d, reason: collision with root package name */
    private e f185937d;

    /* renamed from: e, reason: collision with root package name */
    private c f185938e;

    /* renamed from: f, reason: collision with root package name */
    private float f185939f;

    /* renamed from: h, reason: collision with root package name */
    private float f185940h;

    /* renamed from: i, reason: collision with root package name */
    private int f185941i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f185942m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        void P1(int i3, int i16);

        void o1(float f16);
    }

    public VideoFrameSelectBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = 3000;
        this.H = 0.0f;
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = new Paint();
        this.L = "";
        this.M = false;
        this.f185941i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private void c() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private float e(float f16) {
        return (f16 / this.F) * this.G;
    }

    private final void o(MotionEvent motionEvent) {
        if (this.f185942m) {
            this.f185937d.n(motionEvent);
        } else if (this.C) {
            this.f185938e.w(motionEvent);
        }
    }

    private void p() {
        String format = String.format("%.1f''", Float.valueOf(this.J / 1000.0f));
        this.L = format;
        this.P = this.K.measureText(format);
        a aVar = this.N;
        if (aVar != null) {
            aVar.o1(this.J);
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.e.a
    public void a(float f16, float f17) {
        this.I = e((int) (f16 - this.f185937d.j()));
        this.J = e(f17 - f16);
        p();
        this.f185938e.x((int) f16);
        this.f185938e.z((int) f17);
        invalidate();
        a aVar = this.N;
        if (aVar != null) {
            aVar.P1((int) f(), (int) g());
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.c.InterfaceC7205c
    public void b(float f16, float f17, float f18) {
        this.H = e(f16);
        p();
        e eVar = this.f185937d;
        if (eVar != null) {
            eVar.p(f17, f18);
        }
        a aVar = this.N;
        if (aVar != null) {
            aVar.P1((int) f(), (int) g());
        }
    }

    public void d() {
        e eVar = this.f185937d;
        if (eVar != null) {
            eVar.b();
        }
        c cVar = this.f185938e;
        if (cVar != null) {
            cVar.s();
        }
        this.M = false;
        this.H = 0.0f;
        this.I = 0.0f;
        this.J = 0.0f;
    }

    public float f() {
        return this.H + this.I;
    }

    public float g() {
        return this.H + this.I + this.J;
    }

    public boolean h() {
        c cVar = this.f185938e;
        if (cVar == null || this.f185937d == null) {
            return false;
        }
        if (!cVar.v() && !this.f185937d.k()) {
            return false;
        }
        return true;
    }

    public void i(int i3, String str) {
        int i16;
        if (i3 < 12000) {
            this.G = 2000;
            i16 = (int) Math.ceil((i3 * 1.0f) / 2000.0f);
        } else {
            this.G = i3 / 6;
            i16 = 6;
        }
        int i17 = getResources().getDisplayMetrics().widthPixels;
        float f16 = (i17 * 0.925f) / 6.0f;
        this.F = f16;
        this.E = f16;
        int i18 = i16;
        e eVar = new e(this, f16, f16, i18, this.G, i17, i3);
        this.f185937d = eVar;
        eVar.q(this);
        this.J = e(this.f185937d.i());
        p();
        c cVar = new c(this, str, i3, i18, this.F, this.E, i17, this.f185937d.j(), this.G);
        this.f185938e = cVar;
        cVar.y(this);
        this.K.setAntiAlias(true);
        this.M = true;
    }

    public boolean j() {
        return this.M;
    }

    boolean k() {
        return this.D;
    }

    void l() {
        this.D = true;
    }

    void m() {
        this.D = false;
    }

    public void n() {
        e eVar = this.f185937d;
        if (eVar != null) {
            eVar.o();
        }
        c cVar = this.f185938e;
        if (cVar != null) {
            cVar.s();
        }
        this.L = "";
        this.M = false;
        this.H = 0.0f;
        this.I = 0.0f;
        this.J = 0.0f;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f185937d != null && this.f185938e != null) {
            this.K.setTextSize(40.0f);
            this.K.setColor(-1);
            int i3 = Q;
            canvas.translate(0.0f, i3 + 50);
            c cVar = this.f185938e;
            if (cVar != null) {
                cVar.t(canvas);
            }
            e eVar = this.f185937d;
            if (eVar != null) {
                eVar.c(canvas);
            }
            canvas.translate(0.0f, (-i3) - 50);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.f185937d != null && this.f185938e != null) {
            setMeasuredDimension(View.MeasureSpec.getSize(i3), (int) (this.f185937d.h() + 50.0f + Q));
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || this.f185937d == null || this.f185938e == null) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        if (k()) {
                            m();
                            o(motionEvent);
                            setPressed(false);
                        }
                        invalidate();
                    }
                } else if (k()) {
                    o(motionEvent);
                } else if (Math.abs(motionEvent.getX() - this.f185939f) > this.f185941i) {
                    setPressed(true);
                    invalidate();
                    l();
                    o(motionEvent);
                    c();
                }
            } else {
                if (k()) {
                    o(motionEvent);
                    m();
                    setPressed(false);
                } else {
                    l();
                    o(motionEvent);
                    m();
                }
                invalidate();
            }
        } else {
            this.f185939f = motionEvent.getX();
            float y16 = motionEvent.getY();
            this.f185940h = y16;
            boolean m3 = this.f185937d.m(this.f185939f, y16 - 50.0f);
            this.f185942m = m3;
            this.C = false;
            if (!m3) {
                return super.onTouchEvent(motionEvent);
            }
            setPressed(true);
            invalidate();
            l();
            o(motionEvent);
            c();
        }
        if (!this.C && !this.f185942m) {
            return false;
        }
        return true;
    }

    @Override // android.view.View, com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.b
    public void postInvalidate() {
        super.postInvalidate();
    }

    public void setOnFramesClipChangeListener(a aVar) {
        this.N = aVar;
    }
}
