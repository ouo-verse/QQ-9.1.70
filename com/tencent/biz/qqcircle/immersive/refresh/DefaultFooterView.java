package com.tencent.biz.qqcircle.immersive.refresh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class DefaultFooterView extends View implements b {
    private float C;
    private float D;
    private Paint E;
    private Paint.FontMetrics F;
    private float G;
    private float H;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private boolean P;
    private boolean Q;
    private int R;
    private boolean S;
    private boolean T;
    private Paint U;
    private int V;
    private int W;

    /* renamed from: d, reason: collision with root package name */
    private boolean f89618d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f89619e;

    /* renamed from: f, reason: collision with root package name */
    private int f89620f;

    /* renamed from: h, reason: collision with root package name */
    private int f89621h;

    /* renamed from: i, reason: collision with root package name */
    private int f89622i;

    /* renamed from: m, reason: collision with root package name */
    private int f89623m;

    public DefaultFooterView(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        if (!this.P) {
            return;
        }
        canvas.save();
        canvas.rotate(this.R, this.f89619e.centerX(), this.f89619e.centerY());
        b(canvas, this.f89622i + (this.f89620f / 2), this.f89619e.bottom - cx.a(4.0f), this.f89622i + (this.f89620f / 2), this.f89623m + cx.a(4.0f), 40, 30.0f);
        if (this.S) {
            if (this.Q) {
                int i3 = this.R - 15;
                this.R = i3;
                if (i3 <= -180) {
                    this.R = -180;
                    this.S = false;
                }
            } else {
                int i16 = this.R + 15;
                this.R = i16;
                if (i16 >= 0) {
                    this.R = 0;
                    this.S = false;
                }
            }
            invalidate();
        }
        canvas.restore();
    }

    private void b(Canvas canvas, float f16, float f17, float f18, float f19, int i3, float f26) {
        double atan2 = (Math.atan2(f17 - f19, f16 - f18) * 180.0d) / 3.141592653589793d;
        double d16 = i3;
        double d17 = ((atan2 + d16) * 3.141592653589793d) / 180.0d;
        double d18 = ((atan2 - d16) * 3.141592653589793d) / 180.0d;
        double d19 = f26;
        double cos = Math.cos(d17) * d19;
        double sin = Math.sin(d17) * d19;
        Path path = new Path();
        path.moveTo((float) (f16 - cos), (float) (f17 - sin));
        path.moveTo(f16, f17);
        path.lineTo(f18, f19);
        double d26 = f18;
        double d27 = f19;
        path.moveTo((float) (cos + d26), (float) (sin + d27));
        path.lineTo(f18, f19);
        path.lineTo((float) (d26 + (Math.cos(d18) * d19)), (float) (d27 + (d19 * Math.sin(d18))));
        canvas.drawPath(path, this.U);
    }

    private void c(Canvas canvas) {
        float f16;
        if (!this.T) {
            return;
        }
        canvas.save();
        canvas.rotate(this.C, this.f89619e.centerX(), this.f89619e.centerY());
        float f17 = this.D + 1.0f;
        this.D = f17;
        if (f17 == 3.0f) {
            float f18 = this.C;
            if (f18 < 360.0f) {
                f16 = f18 + 30.0f;
            } else {
                f16 = 0.0f;
            }
            this.C = f16;
            this.D = 0.0f;
        }
        int i3 = 0;
        while (i3 < 12) {
            i3++;
            this.U.setAlpha((i3 * 255) / 11);
            canvas.drawLine(this.f89619e.centerX(), this.f89619e.centerY() - (this.f89621h / 3), this.f89619e.centerX(), this.f89619e.centerY() - (this.f89620f / 6), this.U);
            canvas.rotate(30.0f, this.f89619e.centerX(), this.f89619e.centerY());
        }
        canvas.restore();
        if (this.f89618d) {
            invalidate();
        }
    }

    private void d(Canvas canvas) {
        canvas.save();
        canvas.drawText(this.N, this.G, this.H, this.E);
        canvas.restore();
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public /* synthetic */ int B() {
        return a.a(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void C(QFSPullRefreshLayout qFSPullRefreshLayout, boolean z16) {
        if (z16) {
            this.f89618d = false;
            this.N = this.L;
        } else {
            this.P = false;
            this.T = false;
            this.N = this.M;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void D(QFSPullRefreshLayout qFSPullRefreshLayout, float f16) {
        if (f16 >= 1.0f) {
            this.N = this.J;
            if (!this.Q) {
                this.Q = true;
                this.S = true;
            }
        } else {
            this.N = this.I;
            if (this.Q) {
                this.Q = false;
                this.S = true;
            }
        }
        invalidate();
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void U(QFSPullRefreshLayout qFSPullRefreshLayout) {
        this.C = 0.0f;
        this.P = true;
        this.R = 0;
        this.T = false;
        this.S = false;
        this.Q = true;
        this.N = this.I;
        this.f89618d = false;
        this.U.setColor(-12303292);
        invalidate();
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public int b0() {
        return 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
        c(canvas);
        a(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int measureText = (int) this.E.measureText(this.N);
        int a16 = ((measureText / 2) + this.f89620f + cx.a(20.0f)) * 2;
        this.V = a16;
        int resolveSize = View.resolveSize(a16, i3);
        int i17 = this.V;
        if (resolveSize < i17) {
            resolveSize = i17;
        }
        int resolveSize2 = View.resolveSize(this.W, i16);
        int i18 = this.W;
        if (resolveSize2 < i18) {
            resolveSize2 = i18;
        }
        setMeasuredDimension(resolveSize, resolveSize2);
        this.f89623m = (getMeasuredHeight() - this.f89621h) / 2;
        this.f89622i = (((getMeasuredWidth() - measureText) / 2) - this.f89620f) - cx.a(20.0f);
        this.f89619e = new RectF(this.f89622i, this.f89623m, r6 + this.f89620f, r1 + this.f89621h);
        this.G = getMeasuredWidth() / 2;
        Paint.FontMetrics fontMetrics = this.F;
        this.H = ((getMeasuredHeight() - (fontMetrics.bottom - fontMetrics.top)) / 2.0f) - this.F.top;
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void s(QFSPullRefreshLayout qFSPullRefreshLayout) {
        this.f89618d = true;
        this.P = false;
        this.T = true;
        this.N = this.K;
        invalidate();
    }

    public void setCircleColor(int i3) {
        this.U.setColor(i3);
    }

    public void setFinishText(String str) {
        this.L = str;
    }

    public void setLoadingText(String str) {
        this.K = str;
    }

    public void setNoDataText(String str) {
        this.M = str;
    }

    public void setReleaseText(String str) {
        this.J = str;
    }

    public void setStartText(String str) {
        this.I = str;
    }

    public void setTextColor(int i3) {
        this.E.setColor(i3);
    }

    public DefaultFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = h.a(R.string.f1350200b);
        this.J = h.a(R.string.f1350300c);
        this.K = h.a(R.string.f1350000_);
        this.L = h.a(R.string.f13499009);
        this.M = h.a(R.string.f1350100a);
        this.N = this.I;
        this.P = true;
        this.Q = true;
        this.S = false;
        this.T = false;
        Paint paint = new Paint(1);
        this.U = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.U.setStrokeWidth(cx.a(1.5f));
        this.U.setStrokeCap(Paint.Cap.ROUND);
        this.U.setColor(-12303292);
        Paint paint2 = new Paint(1);
        this.E = paint2;
        paint2.setTextSize(cx.a(16.0f));
        this.E.setColor(-12303292);
        this.E.setTextAlign(Paint.Align.CENTER);
        this.F = this.E.getFontMetrics();
        int a16 = cx.a(30.0f);
        this.f89620f = a16;
        this.f89621h = a16;
        this.W = cx.a(50.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public View getRefreshView() {
        return this;
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void A(float f16, boolean z16) {
    }
}
