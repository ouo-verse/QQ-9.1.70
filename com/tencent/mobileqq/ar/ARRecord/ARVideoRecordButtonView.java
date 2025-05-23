package com.tencent.mobileqq.ar.ARRecord;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARVideoRecordButtonView extends View {
    private float C;
    private Bitmap D;
    private Bitmap E;
    private Bitmap F;

    /* renamed from: d, reason: collision with root package name */
    private Paint f196976d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f196977e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f196978f;

    /* renamed from: h, reason: collision with root package name */
    private Rect f196979h;

    /* renamed from: i, reason: collision with root package name */
    private int f196980i;

    /* renamed from: m, reason: collision with root package name */
    private float f196981m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Float f16 = (Float) valueAnimator.getAnimatedValue();
            ARVideoRecordButtonView.this.f196981m = f16.floatValue();
            ARVideoRecordButtonView.this.h();
        }
    }

    public ARVideoRecordButtonView(Context context) {
        super(context);
        this.f196976d = null;
        this.f196977e = null;
        this.f196978f = null;
        this.f196979h = null;
        this.f196980i = 2;
        this.f196981m = 0.0f;
        this.C = 0.0f;
        this.D = null;
        this.E = null;
        this.F = null;
        g();
    }

    private Bitmap f(int i3) {
        try {
            return BitmapFactory.decodeResource(getResources(), i3);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return null;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    private void g() {
        Paint paint = new Paint();
        this.f196976d = paint;
        paint.setAntiAlias(true);
        this.f196976d.setStyle(Paint.Style.STROKE);
        this.f196976d.setColor(-48606);
        Paint paint2 = new Paint();
        this.f196977e = paint2;
        paint2.setAntiAlias(true);
        this.f196977e.setStyle(Paint.Style.STROKE);
        this.f196977e.setColor(-1);
        this.f196978f = new RectF();
        this.f196979h = new Rect();
        this.E = f(R.drawable.f160316fj);
        this.F = f(R.drawable.mrh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(float f16, float f17) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f16, f17);
        ofFloat.setDuration(1000L);
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i3 = this.f196980i;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    Bitmap bitmap = this.F;
                    if (bitmap != null) {
                        this.f196979h.set(0, 0, bitmap.getWidth(), this.F.getHeight());
                        this.f196978f.set(0.0f, 0.0f, width, height);
                        canvas.drawBitmap(this.F, this.f196979h, this.f196978f, this.f196976d);
                    }
                    float f16 = width;
                    float f17 = 0.08571429f * f16;
                    float min = ((Math.min(width, height) / 2) - f17) - (f16 * 0.0028571428f);
                    float f18 = width / 2;
                    float f19 = height / 2;
                    this.f196978f.set(f18 - min, f19 - min, f18 + min, f19 + min);
                    this.f196977e.setStrokeWidth(f17);
                    this.f196976d.setStrokeWidth(f17);
                    canvas.drawArc(this.f196978f, -90.0f, 360.0f, false, this.f196977e);
                    canvas.drawArc(this.f196978f, -90.0f, 360.0f - ((1.0f - this.f196981m) * 360.0f), false, this.f196976d);
                    return;
                }
                return;
            }
            Bitmap bitmap2 = this.E;
            if (bitmap2 != null) {
                this.f196979h.set(0, 0, bitmap2.getWidth(), this.E.getHeight());
                this.f196978f.set(0.0f, 0.0f, width, height);
                canvas.drawBitmap(this.E, this.f196979h, this.f196978f, this.f196976d);
                return;
            }
            return;
        }
        Bitmap bitmap3 = this.D;
        if (bitmap3 != null) {
            this.f196979h.set(0, 0, bitmap3.getWidth(), this.D.getHeight());
            this.f196978f.set(0.0f, 0.0f, width, height);
            canvas.drawBitmap(this.D, this.f196979h, this.f196978f, this.f196976d);
        }
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public void setProgress(long j3, long j16) {
        final float min = Math.min(1.0f, Math.max((((float) j3) * 1.0f) / ((float) j16), 0.0f));
        if (this.f196980i == 3) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView.1
                @Override // java.lang.Runnable
                public void run() {
                    ARVideoRecordButtonView.this.clearAnimation();
                    ARVideoRecordButtonView aRVideoRecordButtonView = ARVideoRecordButtonView.this;
                    aRVideoRecordButtonView.i(aRVideoRecordButtonView.C, min);
                    ARVideoRecordButtonView.this.C = min;
                }
            });
        }
    }

    public void setShowState(int i3) {
        this.f196980i = i3;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.f196981m = 0.0f;
                }
            } else {
                this.C = 0.0f;
                this.f196981m = 0.0f;
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ARVideoRecordButtonView.this.clearAnimation();
                    }
                });
            }
        } else {
            super.setAlpha(1.0f);
        }
        h();
    }

    public ARVideoRecordButtonView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f196976d = null;
        this.f196977e = null;
        this.f196978f = null;
        this.f196979h = null;
        this.f196980i = 2;
        this.f196981m = 0.0f;
        this.C = 0.0f;
        this.D = null;
        this.E = null;
        this.F = null;
        g();
    }

    public ARVideoRecordButtonView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f196976d = null;
        this.f196977e = null;
        this.f196978f = null;
        this.f196979h = null;
        this.f196980i = 2;
        this.f196981m = 0.0f;
        this.C = 0.0f;
        this.D = null;
        this.E = null;
        this.F = null;
        g();
    }
}
