package com.tencent.mobileqq.richmedialist.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import jj2.b;

/* compiled from: P */
/* loaded from: classes18.dex */
public class CircleFileStateView extends View {
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private Paint I;
    private float J;
    private int K;
    private boolean L;
    private int M;
    private int N;
    private Bitmap P;
    private Bitmap Q;
    private boolean R;

    /* renamed from: d, reason: collision with root package name */
    private float f282086d;

    /* renamed from: e, reason: collision with root package name */
    private int f282087e;

    /* renamed from: f, reason: collision with root package name */
    private int f282088f;

    /* renamed from: h, reason: collision with root package name */
    private int f282089h;

    /* renamed from: i, reason: collision with root package name */
    private int f282090i;

    /* renamed from: m, reason: collision with root package name */
    private int f282091m;

    public CircleFileStateView(Context context) {
        this(context, null);
    }

    private Bitmap a(Drawable drawable) {
        Bitmap.Config config;
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (drawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        this.I.setColor(this.N);
        this.I.setAntiAlias(true);
        this.I.setAlpha(255);
        this.I.setStyle(Paint.Style.FILL);
        int i3 = this.G;
        canvas.drawCircle(i3 / 2, i3 / 2, (i3 / 2) - this.H, this.I);
        int i16 = this.K;
        if (i16 != 1) {
            if (i16 != 2 && i16 != 3) {
                bitmap = null;
            } else {
                bitmap = this.P;
            }
        } else {
            bitmap = this.Q;
        }
        if (this.L) {
            this.I.setColor(this.f282087e);
            this.I.setShadowLayer(9.0f, 0.0f, 0.0f, this.f282088f);
            this.I.setStyle(Paint.Style.STROKE);
            this.I.setStrokeWidth(this.H);
            int i17 = this.H;
            int i18 = this.G;
            canvas.drawArc(new RectF(i17 / 2, i17 / 2, i18 - (i17 / 2), i18 - (i17 / 2)), -90.0f, 360.0f, false, this.I);
            this.I.setColor(this.M);
            this.I.setShadowLayer(9.0f, 0.0f, 0.0f, this.f282088f);
            this.I.setStyle(Paint.Style.STROKE);
            this.I.setStrokeWidth(this.H);
            int i19 = this.H;
            int i26 = this.G;
            canvas.drawArc(new RectF(i19 / 2, i19 / 2, i26 - (i19 / 2), i26 - (i19 / 2)), -90.0f, (float) (this.J * 3.6d), false, this.I);
        }
        if (bitmap != null) {
            this.I.setAntiAlias(true);
            float width = (this.G - (this.H * 2.0f)) / bitmap.getWidth();
            Matrix matrix = new Matrix();
            matrix.setScale(width, width);
            int i27 = this.H;
            matrix.postTranslate(i27, i27);
            if (this.K == 2) {
                int i28 = this.G;
                matrix.postRotate(180.0f, i28 / 2, i28 / 2);
            }
            canvas.drawBitmap(bitmap, matrix, this.I);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int min = Math.min(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i3));
        this.G = min;
        setMeasuredDimension(min, min);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && action != 2) {
            this.M = this.f282090i;
            if (this.K != 1) {
                this.M = this.C;
            }
            this.N = this.E;
            invalidate();
        } else {
            this.M = this.f282091m;
            this.N = this.F;
            invalidate();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackGroundColor(int i3, int i16) {
        this.f282087e = i16;
        this.f282089h = i3;
    }

    public void setCenterBgColor(int i3) {
        this.E = i3;
        this.N = i3;
        invalidate();
    }

    public void setProgress(int i3) {
        float f16;
        float f17;
        if (i3 > 100) {
            f16 = 100.0f;
        } else {
            f16 = i3;
        }
        this.J = f16;
        if (i3 < 0) {
            f17 = 0.0f;
        } else {
            f17 = i3;
        }
        this.J = f17;
        invalidate();
    }

    public void setProgressColor(int i3, int i16) {
        this.f282090i = i3;
        this.D = i16;
        invalidate();
    }

    public void setProgressRingWidth(float f16) {
        int i3 = (int) ((f16 * this.f282086d) + 0.5d);
        this.H = i3;
        this.I.setStrokeWidth(i3);
        invalidate();
    }

    public void setState(int i3) {
        this.K = i3;
        this.M = this.f282090i;
        if (i3 != 1) {
            this.M = this.C;
        }
        invalidate();
    }

    public CircleFileStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleFileStateView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f282087e = -1;
        this.f282090i = -16776961;
        this.f282091m = -16776961;
        this.C = -7829368;
        this.E = -7829368;
        this.F = -3355444;
        this.H = 3;
        this.J = 0.0f;
        this.K = 0;
        this.L = false;
        this.R = false;
        this.f282086d = getResources().getDisplayMetrics().density;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f409995b0);
            this.f282090i = obtainStyledAttributes.getColor(b.f410123m0, -16776961);
            this.f282087e = obtainStyledAttributes.getColor(b.f410090j0, -1);
            this.E = obtainStyledAttributes.getColor(b.f410007c0, -7829368);
            this.f282091m = obtainStyledAttributes.getColor(b.f410134n0, -16776961);
            this.C = obtainStyledAttributes.getColor(b.f410101k0, -7829368);
            this.F = obtainStyledAttributes.getColor(b.f410019d0, -3355444);
            this.D = obtainStyledAttributes.getInteger(b.f410112l0, 255);
            this.f282089h = obtainStyledAttributes.getInteger(b.f410079i0, 51);
            this.H = obtainStyledAttributes.getDimensionPixelOffset(b.f410145o0, 3);
            this.J = obtainStyledAttributes.getInteger(b.f410031e0, 50);
            this.K = obtainStyledAttributes.getInteger(b.f410043f0, 0);
            this.P = a(obtainStyledAttributes.getDrawable(b.f410055g0));
            this.Q = a(obtainStyledAttributes.getDrawable(b.f410067h0));
            obtainStyledAttributes.recycle();
        } else {
            this.P = BitmapFactory.decodeResource(context.getResources(), R.drawable.qfile_file_circle_state_download);
            this.Q = BitmapFactory.decodeResource(context.getResources(), R.drawable.qfile_file_circle_state_stop);
        }
        this.L = true;
        this.M = this.f282090i;
        this.N = this.E;
        Paint paint = new Paint();
        this.I = paint;
        paint.setAntiAlias(true);
        this.I.setStyle(Paint.Style.STROKE);
        setClickable(true);
    }
}
