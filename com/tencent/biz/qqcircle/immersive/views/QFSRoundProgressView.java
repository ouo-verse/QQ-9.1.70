package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.winkpublish.publishconst.WinkHostConstants;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes4.dex */
public class QFSRoundProgressView extends AppCompatImageView {

    /* renamed from: i0, reason: collision with root package name */
    private static final boolean f90457i0 = WinkHostConstants.AppSetting.isDebugVersion();
    private int C;
    private Paint D;
    private Path E;
    private RectF F;
    private int G;
    private int H;
    private int I;
    private int J;
    private Rect K;
    private RectF L;
    private String M;
    private float N;
    private float P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f90458a0;

    /* renamed from: b0, reason: collision with root package name */
    private float f90459b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f90460c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f90461d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f90462e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f90463f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f90464g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f90465h0;

    /* renamed from: m, reason: collision with root package name */
    private int f90466m;

    public QFSRoundProgressView(Context context) {
        this(context, null);
    }

    private void l(int i3) {
        if (i3 < 0 || i3 > 100) {
            QLog.e("QFSRoundProgressView", 1, "The progress should be between 0 and 100, progress: " + i3);
            if (!f90457i0) {
                return;
            }
            throw new RuntimeException("The progress should be between 0 and 100, progress: " + i3);
        }
    }

    private void m(int i3, int i16) {
        l(i3);
        l(i16);
        if (i3 > i16) {
            QLog.e("QFSRoundProgressView", 1, "The startProgress should be less than endProgress, startProgress: " + i3 + ", endProgress: " + i16);
            if (f90457i0) {
                throw new RuntimeException("The startProgress should be less than endProgress.");
            }
        }
    }

    private void o(Canvas canvas) {
        float p16 = p(canvas);
        this.D.setColor(this.V);
        this.D.setStyle(Paint.Style.STROKE);
        this.D.setStrokeWidth(this.U);
        this.D.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawCircle(this.Q, this.R - p16, this.f90459b0, this.D);
        this.D.setColor(this.W);
        RectF rectF = this.L;
        int i3 = this.Q;
        float f16 = this.f90459b0;
        int i16 = this.R;
        rectF.set(i3 - f16, (i16 - f16) - p16, i3 + f16, (i16 + f16) - p16);
        canvas.drawArc(this.L, this.N, this.P, false, this.D);
        this.D.setColor(this.T);
        this.D.setStyle(Paint.Style.FILL_AND_STROKE);
        this.D.setStrokeWidth(0.0f);
        this.D.setTextSize(this.S);
        Paint paint = this.D;
        String str = this.M;
        paint.getTextBounds(str, 0, str.length(), this.K);
        canvas.drawText(this.M, this.Q - (this.K.width() / 2.0f), (this.R + (this.K.height() / 2.0f)) - p16, this.D);
    }

    private float p(Canvas canvas) {
        if (TextUtils.isEmpty(this.f90463f0)) {
            return 0.0f;
        }
        this.D.setColor(this.T);
        this.D.setStyle(Paint.Style.FILL_AND_STROKE);
        this.D.setStrokeWidth(0.0f);
        this.D.setTextSize(this.f90464g0);
        Rect rect = new Rect();
        Paint paint = this.D;
        String str = this.f90463f0;
        paint.getTextBounds(str, 0, str.length(), rect);
        float height = (((((this.U + this.f90459b0) * 2.75f) + rect.height()) / 2.0f) - this.U) - this.f90459b0;
        canvas.drawText(this.f90463f0, this.Q - (rect.width() / 2.0f), (this.R - height) + ((this.U + this.f90459b0) * 1.75f) + (rect.height() / 2.0f), this.D);
        return height;
    }

    private void t(Context context, @Nullable AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, y91.a.U6, i3, 0);
        int i16 = y91.a.f449701j7;
        this.S = obtainStyledAttributes.getDimensionPixelSize(i16, (int) TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics()));
        this.G = obtainStyledAttributes.getDimensionPixelSize(y91.a.f449586a7, (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()));
        this.H = obtainStyledAttributes.getDimensionPixelSize(y91.a.V6, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.T = obtainStyledAttributes.getColor(y91.a.f449689i7, -16777216);
        this.V = obtainStyledAttributes.getColor(y91.a.W6, -16777216);
        this.I = obtainStyledAttributes.getColor(y91.a.f449638e7, Integer.MIN_VALUE);
        this.J = obtainStyledAttributes.getColor(y91.a.f449599b7, 872415231);
        this.U = obtainStyledAttributes.getDimensionPixelSize(y91.a.Z6, (int) TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics()));
        this.W = obtainStyledAttributes.getColor(y91.a.X6, -16777216);
        this.f90458a0 = obtainStyledAttributes.getInt(y91.a.f449625d7, 10);
        this.f90459b0 = obtainStyledAttributes.getDimensionPixelSize(y91.a.Y6, (int) TypedValue.applyDimension(1, 35.0f, getResources().getDisplayMetrics()));
        this.f90464g0 = obtainStyledAttributes.getDimensionPixelSize(i16, DisplayUtil.dip2px(context, 9.0f));
        obtainStyledAttributes.recycle();
    }

    private void u() {
        this.M = "0%";
        this.N = -90.0f;
        this.f90460c0 = 0;
        this.f90462e0 = 0;
        this.f90461d0 = 0;
    }

    private void v() {
        this.D = new Paint(1);
        this.E = new Path();
        this.F = new RectF();
        this.K = new Rect();
        this.L = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        this.E.reset();
        this.F.set(getPaddingLeft(), getPaddingTop(), this.f90466m - getPaddingRight(), this.C - getPaddingBottom());
        Path path = this.E;
        RectF rectF = this.F;
        int i3 = this.G;
        path.addRoundRect(rectF, i3, i3, Path.Direction.CW);
        this.E.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(this.E);
        super.onDraw(canvas);
        if (this.f90465h0) {
            this.D.setStyle(Paint.Style.FILL);
            this.D.setColor(this.I);
            RectF rectF2 = this.F;
            int i16 = this.G;
            canvas.drawRoundRect(rectF2, i16, i16, this.D);
            o(canvas);
        }
        this.D.setStrokeWidth(this.H);
        this.D.setStyle(Paint.Style.STROKE);
        this.D.setColor(this.J);
        RectF rectF3 = this.F;
        int i17 = this.G;
        canvas.drawRoundRect(rectF3, i17, i17, this.D);
        int i18 = this.f90461d0;
        if (i18 < this.f90462e0) {
            int i19 = i18 + 1;
            this.f90461d0 = i19;
            this.P = i19 * 3.6f;
            this.f90460c0 = i19;
            this.M = this.f90461d0 + "%";
            postInvalidateDelayed((long) this.f90458a0);
        }
        canvas.restore();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.f90466m = View.MeasureSpec.getSize(i3);
        int size = View.MeasureSpec.getSize(i16);
        this.C = size;
        this.Q = this.f90466m >> 1;
        this.R = size >> 1;
    }

    public int q() {
        return this.f90460c0;
    }

    public void r() {
        this.f90465h0 = false;
        postInvalidate();
    }

    public void setCorner(int i3) {
        this.G = i3;
    }

    public void setCover(Drawable drawable) {
        setImageDrawable(drawable);
    }

    public void setNeedProgress(boolean z16) {
        this.f90465h0 = z16;
    }

    public void setProgress(int i3) {
        l(i3);
        this.P = i3 * 3.6f;
        this.f90460c0 = i3;
        this.M = i3 + "%";
        postInvalidate();
    }

    public void setProgressRange(int i3, int i16) {
        m(i3, i16);
        this.f90461d0 = i3;
        this.f90462e0 = i16;
        postInvalidate();
    }

    public void setShowTips(String str) {
        this.f90463f0 = str;
    }

    public QFSRoundProgressView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSRoundProgressView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f90465h0 = true;
        t(context, attributeSet, i3);
        u();
        v();
    }
}
