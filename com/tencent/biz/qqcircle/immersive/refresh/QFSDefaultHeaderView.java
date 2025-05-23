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
public class QFSDefaultHeaderView extends View implements b {
    private float C;
    private boolean D;
    private Paint E;
    private Paint.FontMetrics F;
    private float G;
    private float H;
    private String I;
    private boolean J;
    private boolean K;
    private int L;
    private boolean M;
    private boolean N;
    private Paint P;
    private Path Q;
    private int R;
    private int S;
    private String T;
    private String U;
    private String V;
    private String W;

    /* renamed from: d, reason: collision with root package name */
    private RectF f89624d;

    /* renamed from: e, reason: collision with root package name */
    private int f89625e;

    /* renamed from: f, reason: collision with root package name */
    private int f89626f;

    /* renamed from: h, reason: collision with root package name */
    private float f89627h;

    /* renamed from: i, reason: collision with root package name */
    private int f89628i;

    /* renamed from: m, reason: collision with root package name */
    private int f89629m;

    public QFSDefaultHeaderView(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        if (!this.J) {
            return;
        }
        canvas.save();
        canvas.rotate(this.L, this.f89624d.centerX(), this.f89624d.centerY());
        b(canvas, this.f89628i + (this.f89625e / 2), this.f89629m + cx.a(4.0f), this.f89628i + (this.f89625e / 2), (this.f89629m + this.f89626f) - cx.a(4.0f), 40, 30.0f);
        if (this.M) {
            if (this.K) {
                int i3 = this.L - 15;
                this.L = i3;
                if (i3 <= -180) {
                    this.L = -180;
                    this.M = false;
                }
            } else {
                int i16 = this.L + 15;
                this.L = i16;
                if (i16 >= 0) {
                    this.L = 0;
                    this.M = false;
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
        canvas.drawPath(path, this.P);
    }

    private void c(Canvas canvas) {
        if (!this.N) {
            return;
        }
        canvas.save();
        this.Q.reset();
        this.Q.moveTo((this.f89624d.centerX() - (this.f89625e / 2)) + cx.a(4.0f), this.f89624d.centerY());
        this.Q.lineTo(this.f89624d.centerX() - cx.a(2.0f), (this.f89624d.centerY() + (this.f89625e / 2)) - cx.a(8.0f));
        this.Q.lineTo((this.f89624d.centerX() + (this.f89625e / 2)) - cx.a(6.0f), this.f89624d.centerY() - cx.a(6.0f));
        canvas.drawPath(this.Q, this.P);
        canvas.restore();
    }

    private void d(Canvas canvas) {
        canvas.save();
        canvas.rotate(this.C, this.f89624d.centerX(), this.f89624d.centerY());
        this.Q.reset();
        this.Q.arcTo(this.f89624d, 280.0f, this.f89627h, true);
        canvas.drawPath(this.Q, this.P);
        canvas.restore();
        if (this.D) {
            if (this.C >= 360.0f) {
                this.C = 0.0f;
            }
            this.C += 10.0f;
            invalidate();
        }
    }

    private void e(Canvas canvas) {
        canvas.save();
        canvas.drawText(this.I, this.G, this.H, this.E);
        canvas.restore();
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public /* synthetic */ int B() {
        return a.a(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void C(QFSPullRefreshLayout qFSPullRefreshLayout, boolean z16) {
        this.D = false;
        this.C = 0.0f;
        this.J = false;
        this.N = true;
        this.I = this.W;
        invalidate();
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void D(QFSPullRefreshLayout qFSPullRefreshLayout, float f16) {
        this.f89627h = 340.0f * f16;
        if (f16 >= 1.0f) {
            this.I = this.U;
            if (!this.K) {
                this.K = true;
                this.M = true;
            }
        } else {
            this.I = this.T;
            if (this.K) {
                this.K = false;
                this.M = true;
            }
        }
        invalidate();
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void U(QFSPullRefreshLayout qFSPullRefreshLayout) {
        this.C = 0.0f;
        this.f89627h = 0.0f;
        this.J = true;
        this.L = 0;
        this.N = false;
        this.M = false;
        this.K = false;
        this.I = this.T;
        this.D = false;
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
        a(canvas);
        e(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int resolveSize = View.resolveSize(this.S, i16);
        int i17 = this.S;
        if (resolveSize < i17) {
            resolveSize = i17;
        }
        setMeasuredDimension(this.R, resolveSize);
        this.f89629m = (getMeasuredHeight() - this.f89626f) / 2;
        this.f89628i = cx.a(20.0f);
        this.f89624d = new RectF(this.f89628i, this.f89629m, r6 + this.f89625e, r1 + this.f89626f);
        this.G = ((getMeasuredWidth() - cx.a(50.0f)) / 2) + cx.a(50.0f);
        Paint.FontMetrics fontMetrics = this.F;
        this.H = ((getMeasuredHeight() - (fontMetrics.bottom - fontMetrics.top)) / 2.0f) - this.F.top;
    }

    @Override // com.tencent.biz.qqcircle.immersive.refresh.b
    public void s(QFSPullRefreshLayout qFSPullRefreshLayout) {
        this.D = true;
        this.J = false;
        this.N = false;
        this.I = this.V;
        invalidate();
    }

    public QFSDefaultHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = h.a(R.string.hqh);
        this.J = true;
        this.K = false;
        this.M = false;
        this.N = false;
        this.T = h.a(R.string.hqh);
        this.U = h.a(R.string.hqj);
        this.V = h.a(R.string.hqg);
        this.W = h.a(R.string.hqk);
        Paint paint = new Paint(1);
        this.P = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.P.setStrokeWidth(cx.a(1.5f));
        this.P.setStrokeCap(Paint.Cap.ROUND);
        this.P.setColor(-12303292);
        Paint paint2 = new Paint(1);
        this.E = paint2;
        paint2.setTextSize(cx.a(16.0f));
        this.E.setColor(-12303292);
        this.E.setTextAlign(Paint.Align.CENTER);
        this.F = this.E.getFontMetrics();
        this.Q = new Path();
        int a16 = cx.a(28.0f);
        this.f89625e = a16;
        this.f89626f = a16;
        this.R = cx.a(170.0f);
        this.S = cx.a(50.0f);
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
