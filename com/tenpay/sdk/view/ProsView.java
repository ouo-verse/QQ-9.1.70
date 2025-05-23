package com.tenpay.sdk.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tenpay.QwLog;
import com.tenpay.util.Utils;

/* loaded from: classes27.dex */
public class ProsView extends View {
    private Paint bgPaint;
    private Paint fPaint;

    /* renamed from: h, reason: collision with root package name */
    private int f386948h;
    private int offTop;
    private int padding;
    private Rect rect;
    private String totalTime;
    private int txtMarginTop;
    private Paint txtPaint;
    private int txtW;
    private String upTime;
    private int uprate;

    /* renamed from: w, reason: collision with root package name */
    private int f386949w;

    public ProsView(Context context) {
        this(context, null, 0);
    }

    private void initPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(dp(3.0f));
        int rgb = Color.rgb(112, 128, 144);
        int rgb2 = Color.rgb(254, 243, 177);
        Paint paint2 = new Paint(paint);
        this.bgPaint = paint2;
        paint2.setColor(rgb);
        Paint paint3 = new Paint(paint);
        this.fPaint = paint3;
        paint3.setColor(rgb2);
        Paint paint4 = new Paint(paint);
        this.txtPaint = paint4;
        paint4.setColor(-7829368);
        this.txtPaint.setTextSize(dp(15.0f));
    }

    private void initView(Context context, AttributeSet attributeSet, int i3) {
        initPaint();
        int dp5 = dp(10.0f);
        this.padding = dp5;
        this.uprate = dp5 + 1;
        this.txtMarginTop = dp(20.0f);
    }

    protected final int dp(float f16) {
        return Utils.dp2Px(getContext(), f16);
    }

    public void initProsView(int i3) {
        this.totalTime = "05:02";
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3 = this.padding;
        int i16 = this.offTop;
        canvas.drawLine(i3, i16, this.f386949w - i3, i16, this.bgPaint);
        float f16 = this.padding;
        int i17 = this.offTop;
        canvas.drawLine(f16, i17, this.uprate, i17, this.fPaint);
        if (!TextUtils.isEmpty(this.upTime)) {
            canvas.drawText(this.upTime, this.padding, this.offTop + this.txtMarginTop, this.txtPaint);
        }
        if (!TextUtils.isEmpty(this.totalTime)) {
            canvas.drawText(this.totalTime, (this.f386949w - this.padding) - this.txtW, this.offTop + this.txtMarginTop, this.txtPaint);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.f386949w = getWidth();
        int height = getHeight();
        this.f386948h = height;
        this.offTop = height / 3;
        QwLog.i("w = " + this.f386949w + " h = " + this.f386948h);
        if (this.f386949w > 0 || this.f386948h > 0) {
            this.txtPaint.getTextBounds("05:02", 0, 5, this.rect);
            this.txtW = this.rect.width();
            postInvalidate();
        }
    }

    public void update(int i3) {
        if (this.f386949w <= 0) {
            return;
        }
        this.upTime = "05:0" + i3;
        this.uprate = (int) (((float) (this.f386949w - (this.padding * 2))) * 0.3f);
        postInvalidate();
    }

    public ProsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"NewApi"})
    public ProsView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.bgPaint = new Paint();
        this.txtPaint = new Paint();
        this.fPaint = new Paint();
        this.rect = new Rect();
        initView(context, attributeSet, i3);
    }
}
