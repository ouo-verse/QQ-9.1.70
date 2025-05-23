package com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes18.dex */
public class PlayerProgressBar extends View {
    private int C;
    private Rect D;
    private Paint E;

    /* renamed from: d, reason: collision with root package name */
    public int f288282d;

    /* renamed from: e, reason: collision with root package name */
    public int f288283e;

    /* renamed from: f, reason: collision with root package name */
    public int f288284f;

    /* renamed from: h, reason: collision with root package name */
    private int f288285h;

    /* renamed from: i, reason: collision with root package name */
    private int f288286i;

    /* renamed from: m, reason: collision with root package name */
    private int f288287m;

    public PlayerProgressBar(Context context) {
        super(context);
        this.f288282d = 1;
        this.f288283e = 1;
        this.f288284f = 1;
        this.f288285h = -14342358;
        this.f288286i = -15550475;
        this.f288287m = -10066330;
        this.D = new Rect();
        this.E = new Paint();
    }

    private int a(int i3) {
        int i16 = this.C;
        int i17 = this.f288284f;
        if (i16 == i17) {
            return i3;
        }
        int i18 = (i3 * i16) / i17;
        if (i18 <= 0) {
            return 1;
        }
        return i18;
    }

    private int b(int i3, int i16) {
        int i17 = this.f288282d;
        if (i3 == i17) {
            return i16;
        }
        int i18 = (i16 * i3) / i17;
        if (i18 <= 0) {
            return 1;
        }
        return i18;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (super.isInEditMode()) {
            return;
        }
        int i3 = this.f288283e;
        int i16 = this.f288282d;
        if (i3 > i16) {
            this.f288283e = i16;
        }
        int width = super.getWidth();
        int height = super.getHeight();
        int b16 = b(this.f288283e, width);
        Rect rect = this.D;
        rect.top = 0;
        rect.bottom = height;
        rect.left = b16;
        rect.right = width;
        this.E.setColor(this.f288285h);
        canvas.drawRect(this.D, this.E);
        int a16 = a(b16);
        Rect rect2 = this.D;
        rect2.left = 0;
        rect2.right = a16;
        this.E.setColor(this.f288286i);
        canvas.drawRect(this.D, this.E);
        if (a16 < b16) {
            Rect rect3 = this.D;
            rect3.left = a16;
            rect3.right = b16;
            this.E.setColor(this.f288287m);
            canvas.drawRect(this.D, this.E);
        }
    }

    public void setCurrentProgress(int i3, boolean z16) {
        if (z16) {
            this.C = this.f288284f;
        } else {
            this.C = i3;
        }
        super.postInvalidate();
    }

    public PlayerProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f288282d = 1;
        this.f288283e = 1;
        this.f288284f = 1;
        this.f288285h = -14342358;
        this.f288286i = -15550475;
        this.f288287m = -10066330;
        this.D = new Rect();
        this.E = new Paint();
    }
}
