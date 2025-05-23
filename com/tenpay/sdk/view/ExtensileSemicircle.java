package com.tenpay.sdk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ExtensileSemicircle extends View implements Runnable {
    int cX;
    int cY;
    private boolean firstLayout;

    /* renamed from: h, reason: collision with root package name */
    int f386944h;
    private Handler handler;
    int mR;

    /* renamed from: p, reason: collision with root package name */
    private Paint f386945p;
    int plus;

    /* renamed from: r, reason: collision with root package name */
    int f386946r;

    /* renamed from: w, reason: collision with root package name */
    int f386947w;

    public ExtensileSemicircle(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.firstLayout = true;
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.f386945p = paint;
        paint.setColor(-1);
        this.f386945p.setAntiAlias(true);
        this.handler = new Handler();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mR < 0) {
            this.mR = 0;
        }
        float f16 = this.cX;
        int i3 = this.cY;
        int i16 = this.mR;
        canvas.drawCircle(f16, i3 + i16, this.f386946r + i16, this.f386945p);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.firstLayout) {
            int height = getHeight();
            this.f386944h = height;
            if (height <= 0) {
                return;
            }
            int width = getWidth();
            this.f386947w = width;
            int i19 = this.f386944h;
            int i26 = ((width * width) / (i19 * 4)) + (i19 / 4);
            this.f386946r = i26;
            this.cX = width / 2;
            this.cY = i26 + (i19 / 2);
            this.firstLayout = false;
            this.mR = 0;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i3 = this.mR;
        int i16 = this.plus;
        int i17 = i3 - i16;
        this.mR = i17;
        if (i17 > i16) {
            this.mR = i17 - i16;
        } else if (i17 > 0 && i17 < i16) {
            this.mR = 0;
        } else {
            return;
        }
        invalidate();
    }

    public void setR(int i3) {
        int i16 = this.mR;
        if (i16 - i3 > 1000 && i3 == 0) {
            this.plus = (i16 - i3) / 50;
            for (int i17 = 0; i17 < 50; i17++) {
                this.handler.postDelayed(this, i17 * 20);
            }
            return;
        }
        this.plus = 0;
        if (i16 != i3) {
            this.mR = i3;
            invalidate();
        }
    }

    public ExtensileSemicircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.firstLayout = true;
        init();
    }

    public ExtensileSemicircle(Context context) {
        super(context);
        this.firstLayout = true;
        init();
    }
}
