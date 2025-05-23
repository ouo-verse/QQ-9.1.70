package com.tencent.mobileqq.wink.editor.hdr;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes21.dex */
public class HDRProgressView extends View {

    /* renamed from: d, reason: collision with root package name */
    private Paint f320430d;

    /* renamed from: e, reason: collision with root package name */
    private int f320431e;

    /* renamed from: f, reason: collision with root package name */
    private float f320432f;

    /* renamed from: h, reason: collision with root package name */
    private RectF f320433h;

    /* renamed from: i, reason: collision with root package name */
    private Rect f320434i;

    /* renamed from: m, reason: collision with root package name */
    private ObjectAnimator f320435m;

    @Keep
    private int progress;

    public HDRProgressView(Context context) {
        super(context, null);
        this.progress = 0;
        this.f320435m = null;
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f320430d = paint;
        paint.setAntiAlias(true);
        this.f320433h = new RectF();
        this.f320434i = new Rect();
    }

    public void b(int i3, boolean z16) {
        ObjectAnimator objectAnimator = this.f320435m;
        if (objectAnimator != null) {
            objectAnimator.end();
            this.f320435m = null;
        }
        if (!z16) {
            this.progress = i3;
            invalidate();
        } else {
            ObjectAnimator duration = ObjectAnimator.ofInt(this, "progress", this.progress, i3).setDuration(100L);
            this.f320435m = duration;
            duration.start();
        }
    }

    @Keep
    public int getProgress() {
        return this.progress;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f320435m;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f320435m = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f16 = this.f320431e / 2.0f;
        float f17 = f16 - this.f320432f;
        this.f320430d.setStyle(Paint.Style.STROKE);
        this.f320430d.setStrokeWidth(this.f320432f);
        this.f320430d.setColor(Color.parseColor("#33FFFFFF"));
        canvas.drawCircle(f16, f16, f17, this.f320430d);
        canvas.save();
        canvas.rotate(-90.0f, f16, f16);
        this.f320430d.setColor(Color.parseColor("#FF0099FF"));
        RectF rectF = this.f320433h;
        float f18 = this.f320432f;
        int i3 = this.f320431e;
        rectF.set(f18, f18, i3 - f18, i3 - f18);
        canvas.drawArc(this.f320433h, 0.0f, (this.progress * 360.0f) / 100.0f, false, this.f320430d);
        this.f320430d.setShader(null);
        canvas.rotate(90.0f, f16, f16);
        canvas.restore();
        String str = this.progress + "%";
        this.f320430d.setStrokeWidth(0.0f);
        this.f320430d.setTextSize(com.tencent.videocut.utils.e.f384236a.a(10.0f));
        this.f320430d.getTextBounds(str, 0, str.length(), this.f320434i);
        this.f320430d.setColor(Color.parseColor("#FFFFFFFF"));
        canvas.drawText(str, f16 - (this.f320434i.width() / 2.0f), f16 + (this.f320434i.height() / 2.0f), this.f320430d);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        float f16;
        super.onMeasure(i3, i16);
        int measuredWidth = getMeasuredWidth();
        this.f320431e = measuredWidth;
        if (measuredWidth > 20) {
            f16 = measuredWidth / 20.0f;
        } else {
            f16 = 1.0f;
        }
        this.f320432f = f16;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 != 0) {
            float f16 = i3;
            this.f320430d.setShader(new SweepGradient(f16, f16, new int[]{Color.parseColor("#FF0099FF"), Color.parseColor("#FF26E7FC")}, (float[]) null));
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i3) {
        ObjectAnimator objectAnimator;
        super.onVisibilityChanged(view, i3);
        if ((i3 == 8 || i3 == 4) && (objectAnimator = this.f320435m) != null) {
            objectAnimator.end();
            this.f320435m = null;
        }
    }

    public void setArcWidth(int i3) {
        this.f320432f = i3;
    }

    @Keep
    public void setProgress(int i3) {
        this.progress = i3;
        invalidate();
    }

    public HDRProgressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.progress = 0;
        this.f320435m = null;
        a();
    }
}
