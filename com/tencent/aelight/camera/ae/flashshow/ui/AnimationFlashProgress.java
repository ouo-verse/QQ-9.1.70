package com.tencent.aelight.camera.ae.flashshow.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.QIMCircleProgress;

/* loaded from: classes32.dex */
public class AnimationFlashProgress extends QIMCircleProgress {
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private int f64627d;

    /* renamed from: e, reason: collision with root package name */
    private int f64628e;

    /* renamed from: f, reason: collision with root package name */
    Paint f64629f;

    /* renamed from: h, reason: collision with root package name */
    private RectF f64630h;

    /* renamed from: i, reason: collision with root package name */
    private int f64631i;

    /* renamed from: m, reason: collision with root package name */
    private int f64632m;

    public AnimationFlashProgress(Context context) {
        super(context);
        this.C = true;
    }

    protected void a(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f64628e * this.mCenterScale, this.mPaintWhite);
    }

    protected void b(Canvas canvas) {
        this.f64630h.set((getWidth() - this.f64631i) / 2, (getHeight() - this.f64631i) / 2, r0 + r2, r1 + r2);
        RectF rectF = this.f64630h;
        int i3 = this.f64632m;
        canvas.drawRoundRect(rectF, i3, i3, this.mPaintWhite);
    }

    @Override // com.tencent.widget.QIMCircleProgress
    protected void drawCenterCircle(Canvas canvas) {
        if (this.C) {
            if (this.mMode == 3) {
                b(canvas);
            } else {
                a(canvas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.QIMCircleProgress
    public void init() {
        super.init();
        Paint paint = new Paint();
        this.f64629f = paint;
        paint.setAntiAlias(true);
        this.mPaintWhite.setStyle(Paint.Style.FILL);
        setBackgroundResource(R.drawable.iyn);
        this.f64631i = ViewUtils.dip2px(30.0f);
        this.f64632m = ViewUtils.dip2px(6.0f);
        this.f64630h = new RectF();
    }

    @Override // com.tencent.widget.QIMCircleProgress
    public void setCenterView() {
        super.setCenterView();
        this.f64627d = ViewUtils.dip2px(3.0f);
        this.f64628e = ViewUtils.dip2px(14.0f);
    }

    public AnimationFlashProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = true;
    }

    @Override // com.tencent.widget.QIMCircleProgress
    public void changeMode(int i3) {
        setBackgroundResource(R.drawable.iyn);
        super.changeMode(i3);
    }
}
