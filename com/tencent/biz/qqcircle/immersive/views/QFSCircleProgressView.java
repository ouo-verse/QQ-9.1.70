package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.winkpublish.publishconst.WinkHostConstants;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes4.dex */
public class QFSCircleProgressView extends AppCompatImageView {

    /* renamed from: k0, reason: collision with root package name */
    private static final boolean f90310k0 = WinkHostConstants.AppSetting.isDebugVersion();
    private int C;
    private Paint D;
    private Path E;
    private RectF F;
    private int G;
    private Rect H;
    private RectF I;
    private String J;
    private float K;
    private float L;
    private float M;
    private int N;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private float W;

    /* renamed from: a0, reason: collision with root package name */
    private int f90311a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f90312b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f90313c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f90314d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f90315e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f90316f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f90317g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f90318h0;

    /* renamed from: i0, reason: collision with root package name */
    private int[] f90319i0;

    /* renamed from: j0, reason: collision with root package name */
    private float[] f90320j0;

    /* renamed from: m, reason: collision with root package name */
    private int f90321m;

    public QFSCircleProgressView(Context context) {
        this(context, null);
    }

    private void l(float f16) {
        if (f16 < 0.0f || f16 > 100.0f) {
            QLog.e("QFSCircleProgressView", 1, "The progress should be between 0 and 100, progress: " + f16);
            if (!f90310k0) {
                return;
            }
            throw new RuntimeException("The progress should be between 0 and 100, progress: " + f16);
        }
    }

    private void m(int i3, int i16) {
        l(i3);
        l(i16);
        if (i3 > i16) {
            QLog.e("QFSCircleProgressView", 1, "The startProgress should be less than endProgress, startProgress: " + i3 + ", endProgress: " + i16);
            if (f90310k0) {
                throw new RuntimeException("The startProgress should be less than endProgress.");
            }
        }
    }

    private void o(Canvas canvas) {
        float p16 = p(canvas);
        this.D.setStyle(Paint.Style.STROKE);
        this.D.setStrokeWidth(this.S);
        this.D.setAntiAlias(true);
        this.D.setStrokeCap(Paint.Cap.ROUND);
        if (this.f90316f0) {
            this.D.setColor(this.T);
            canvas.drawCircle(this.N, this.P - p16, this.W, this.D);
        }
        if (this.f90318h0) {
            this.D.setShader(new SweepGradient(this.N, this.P, this.f90319i0, this.f90320j0));
        } else {
            this.D.setColor(this.U);
        }
        RectF rectF = this.I;
        int i3 = this.N;
        float f16 = this.W;
        int i16 = this.P;
        rectF.set(i3 - f16, (i16 - f16) - p16, i3 + f16, (i16 + f16) - p16);
        canvas.drawArc(this.I, this.K, this.M, false, this.D);
        if (this.f90317g0 && this.f90315e0) {
            this.D.setColor(this.R);
            this.D.setStyle(Paint.Style.FILL_AND_STROKE);
            this.D.setStrokeWidth(0.0f);
            this.D.setTextSize(this.Q);
            Paint paint = this.D;
            String str = this.J;
            paint.getTextBounds(str, 0, str.length(), this.H);
            RFWTypefaceUtil.setNumberTypeface(this.D, false);
            canvas.drawText(this.J, this.N - (this.H.width() / 2.0f), (this.P + (this.H.height() / 2.0f)) - p16, this.D);
        }
    }

    private float p(Canvas canvas) {
        if (TextUtils.isEmpty(this.f90313c0)) {
            return 0.0f;
        }
        this.D.setColor(this.R);
        this.D.setStyle(Paint.Style.FILL_AND_STROKE);
        this.D.setStrokeWidth(0.0f);
        this.D.setTextSize(this.f90314d0);
        Rect rect = new Rect();
        Paint paint = this.D;
        String str = this.f90313c0;
        paint.getTextBounds(str, 0, str.length(), rect);
        float height = (((((this.S + this.W) * 2.75f) + rect.height()) / 2.0f) - this.S) - this.W;
        canvas.drawText(this.f90313c0, this.N - (rect.width() / 2.0f), (this.P - height) + ((this.S + this.W) * 1.75f) + (rect.height() / 2.0f), this.D);
        return height;
    }

    private void q(Context context, @Nullable AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, y91.a.U6, i3, 0);
        this.Q = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449701j7, (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics()));
        this.G = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449586a7, (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()));
        this.R = obtainStyledAttributes.getColor(y91.a.f449689i7, -16777216);
        this.T = obtainStyledAttributes.getColor(y91.a.W6, -16777216);
        this.S = obtainStyledAttributes.getDimensionPixelSize(y91.a.Z6, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.U = obtainStyledAttributes.getColor(y91.a.X6, -16777216);
        this.V = obtainStyledAttributes.getInt(y91.a.f449625d7, 20);
        this.W = obtainStyledAttributes.getDimensionPixelSize(y91.a.Y6, (int) TypedValue.applyDimension(1, 35.0f, getResources().getDisplayMetrics()));
        this.K = obtainStyledAttributes.getFloat(y91.a.f449677h7, -270.0f);
        this.L = obtainStyledAttributes.getFloat(y91.a.f449612c7, 90.0f);
        this.f90315e0 = obtainStyledAttributes.getBoolean(y91.a.f449664g7, true);
        this.f90316f0 = obtainStyledAttributes.getBoolean(y91.a.f449651f7, true);
        this.f90314d0 = DisplayUtil.dip2px(context, 9.0f);
        obtainStyledAttributes.recycle();
    }

    private void r() {
        this.J = "0%";
        this.f90312b0 = 0;
        this.f90311a0 = 0;
    }

    private void t() {
        this.D = new Paint(1);
        this.E = new Path();
        this.F = new RectF();
        this.H = new Rect();
        this.I = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.E.reset();
        this.F.set(getPaddingLeft(), getPaddingTop(), this.f90321m - getPaddingRight(), this.C - getPaddingBottom());
        Path path = this.E;
        RectF rectF = this.F;
        int i3 = this.G;
        path.addRoundRect(rectF, i3, i3, Path.Direction.CW);
        this.E.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(this.E);
        super.onDraw(canvas);
        o(canvas);
        int i16 = this.f90311a0;
        if (i16 < this.f90312b0) {
            int i17 = i16 + 1;
            this.f90311a0 = i17;
            this.M = i17 * 3.6f;
            this.J = this.f90311a0 + "%";
            postInvalidateDelayed((long) this.V);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.f90321m = View.MeasureSpec.getSize(i3);
        int size = View.MeasureSpec.getSize(i16);
        this.C = size;
        this.N = this.f90321m >> 1;
        this.P = size >> 1;
    }

    public void setCorner(int i3) {
        this.G = i3;
    }

    public void setCover(Drawable drawable) {
        setImageDrawable(drawable);
    }

    public void setGradientColors(int[] iArr) {
        this.f90319i0 = iArr;
    }

    public void setGradientPotions(float[] fArr) {
        this.f90320j0 = fArr;
    }

    public void setIsShowProgressNum(boolean z16) {
        this.f90317g0 = z16;
    }

    public void setProgress(float f16) {
        l(f16);
        this.M = ((this.L - this.K) * f16) / 100.0f;
        this.J = f16 + "%";
        postInvalidate();
    }

    public void setProgressRange(int i3, int i16) {
        QLog.d("QFSCircleProgressView", 1, "start progress is " + this.f90311a0 + " end progress is " + this.f90312b0);
        m(i3, i16);
        this.f90311a0 = i3;
        this.f90312b0 = i16;
        postInvalidate();
    }

    public void setShowTips(String str) {
        this.f90313c0 = str;
    }

    public void setUseGradientFgColor(boolean z16) {
        this.f90318h0 = z16;
    }

    public QFSCircleProgressView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSCircleProgressView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f90317g0 = true;
        this.f90319i0 = new int[]{0, 0};
        this.f90320j0 = new float[]{0.0f, 0.0f};
        q(context, attributeSet, i3);
        r();
        t();
    }
}
