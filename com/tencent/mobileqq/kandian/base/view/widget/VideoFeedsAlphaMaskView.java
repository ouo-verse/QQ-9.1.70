package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes15.dex */
public class VideoFeedsAlphaMaskView extends View {

    /* renamed from: d, reason: collision with root package name */
    private Paint f239188d;

    /* renamed from: e, reason: collision with root package name */
    private float f239189e;

    public VideoFeedsAlphaMaskView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f239188d = paint;
        this.f239189e = 1.0f;
        paint.setColor(-635823590);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f239188d.setAlpha((int) (this.f239189e * 218.0f));
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.f239188d);
    }

    @Override // android.view.View
    public void setAlpha(float f16) {
        if (this.f239189e != f16) {
            this.f239189e = f16;
            invalidate();
        }
    }

    public VideoFeedsAlphaMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f239188d = paint;
        this.f239189e = 1.0f;
        paint.setColor(-635823590);
    }

    public VideoFeedsAlphaMaskView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Paint paint = new Paint();
        this.f239188d = paint;
        this.f239189e = 1.0f;
        paint.setColor(-635823590);
    }
}
