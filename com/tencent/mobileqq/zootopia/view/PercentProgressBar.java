package com.tencent.mobileqq.zootopia.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;

/* loaded from: classes35.dex */
public class PercentProgressBar extends ProgressBar {
    private final int C;
    private final int D;
    public LinearGradient E;

    /* renamed from: d, reason: collision with root package name */
    private String f329573d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f329574e;

    /* renamed from: f, reason: collision with root package name */
    private float f329575f;

    /* renamed from: h, reason: collision with root package name */
    private Rect f329576h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f329577i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f329578m;

    public PercentProgressBar(Context context) {
        this(context, null);
    }

    private float b() {
        float progress = (float) ((getProgress() * 1.0d) / 100.0d);
        if (progress < 0.01d) {
            progress = 0.01f;
        }
        return progress * getWidth();
    }

    private void c() {
        Paint paint = new Paint();
        this.f329574e = paint;
        paint.setColor(-1);
        this.f329574e.setTextSize(ViewUtils.dpToPx(this.f329575f));
    }

    private void d(int i3) {
        this.f329573d = i3 + "%";
    }

    public String a() {
        return this.f329573d;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f329577i) {
            this.f329576h.setEmpty();
            Paint paint = this.f329574e;
            String str = this.f329573d;
            paint.getTextBounds(str, 0, str.length(), this.f329576h);
            int width = (getWidth() / 2) - this.f329576h.centerX();
            int height = (getHeight() / 2) - this.f329576h.centerY();
            if (this.f329578m) {
                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, b(), 0.0f, new int[]{this.D, this.C}, new float[]{0.99f, 1.0f}, Shader.TileMode.CLAMP);
                this.E = linearGradient;
                this.f329574e.setShader(linearGradient);
            } else {
                this.f329574e.setShader(null);
            }
            canvas.drawText(this.f329573d, width, height, this.f329574e);
        }
    }

    public void setNeedMultiColor(boolean z16) {
        this.f329578m = z16;
        invalidate();
    }

    public void setPaintColor(int i3) {
        this.f329574e.setColor(i3);
        invalidate();
    }

    public void setPaintSize(float f16) {
        this.f329575f = f16;
        invalidate();
    }

    public void setPercentText(String str) {
        this.f329573d = str;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i3) {
        d(i3);
        super.setProgress(i3);
    }

    @Override // android.widget.ProgressBar
    public void setSecondaryProgress(int i3) {
        d(i3);
        super.setSecondaryProgress(i3);
    }

    public void setTextVisible(boolean z16) {
        this.f329577i = z16;
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        this.f329574e.setTypeface(typeface);
        invalidate();
    }

    public PercentProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PercentProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f329573d = "0%";
        this.f329575f = 14.0f;
        this.f329576h = new Rect();
        this.f329577i = true;
        this.f329578m = false;
        this.C = Color.parseColor("#0179FF");
        this.D = Color.parseColor(TipsElementData.DEFAULT_COLOR);
        c();
    }
}
