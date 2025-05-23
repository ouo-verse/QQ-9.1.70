package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes5.dex */
public class SplitedProgressBar extends View {
    public int C;
    public int D;
    public int E;
    public int F;
    public Paint G;

    /* renamed from: d, reason: collision with root package name */
    public int f94498d;

    /* renamed from: e, reason: collision with root package name */
    public int f94499e;

    /* renamed from: f, reason: collision with root package name */
    public int f94500f;

    /* renamed from: h, reason: collision with root package name */
    public int f94501h;

    /* renamed from: i, reason: collision with root package name */
    public int f94502i;

    /* renamed from: m, reason: collision with root package name */
    public int f94503m;

    public SplitedProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = new Paint();
        this.f94502i = 872415231;
        this.f94503m = Integer.MAX_VALUE;
        this.f94498d = 1;
        this.E = 0;
        this.F = 1;
        this.D = 4;
        this.C = 3;
        this.f94499e = 1;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = super.getWidth();
        if (this.f94499e == 0) {
            return;
        }
        this.G.setStrokeWidth(this.C);
        int i3 = this.F;
        int i16 = this.E;
        float f16 = (width - (((i3 - i16) - 1) * this.D)) / (i3 - i16);
        while (i16 < this.F) {
            int i17 = this.E;
            int i18 = this.D;
            int i19 = (int) ((i16 - i17) * (i18 + f16));
            int i26 = (int) (((i16 - i17) * (i18 + f16)) + f16);
            int i27 = this.f94500f;
            if (i16 < i27) {
                this.G.setStrokeWidth(this.C);
                this.G.setColor(this.f94503m);
                float f17 = i26 - 1;
                canvas.drawLine(i19 + 1, 1.0f, f17, 1.0f, this.G);
                this.G.setStrokeWidth(1.0f);
                canvas.drawPoint(i19, 1.0f, this.G);
                canvas.drawPoint(f17, 1.0f, this.G);
            } else if (i16 == i27) {
                this.G.setStrokeWidth(this.C);
                this.G.setColor(this.f94503m);
                float f18 = i19 + 1;
                float f19 = i19;
                canvas.drawLine(f18, 1.0f, f19 + ((this.f94501h * f16) / 100.0f), 1.0f, this.G);
                this.G.setStrokeWidth(1.0f);
                canvas.drawPoint(f19, 1.0f, this.G);
                this.G.setStrokeWidth(this.C);
                this.G.setColor(this.f94502i);
                float f26 = i26 - 1;
                canvas.drawLine(f19 + ((this.f94501h * f16) / 100.0f), 1.0f, f26, 1.0f, this.G);
                this.G.setStrokeWidth(1.0f);
                canvas.drawPoint(f26, 1.0f, this.G);
            } else {
                this.G.setStrokeWidth(this.C);
                this.G.setColor(this.f94502i);
                float f27 = i26 - 1;
                canvas.drawLine(i19 + 1, 1.0f, f27, 1.0f, this.G);
                this.G.setStrokeWidth(1.0f);
                canvas.drawPoint(i19, 1.0f, this.G);
                canvas.drawPoint(f27, 1.0f, this.G);
            }
            i16++;
        }
    }

    public void setProgress(int i3, int i16) {
        int i17;
        int i18;
        int i19 = this.f94499e;
        if (i19 <= 0) {
            return;
        }
        if (i3 >= 0 && i3 < i19) {
            if (i16 >= 0 && i16 <= 100) {
                this.f94500f = i3;
                this.f94501h = i16;
                int i26 = this.f94498d;
                if (i3 < i26) {
                    this.E = 0;
                    this.F = i26;
                } else {
                    this.E = i26;
                    while (true) {
                        i17 = this.E;
                        i18 = this.f94498d;
                        if (i17 + i18 > this.f94500f) {
                            break;
                        } else {
                            this.E = i17 + i18;
                        }
                    }
                    int i27 = this.f94499e;
                    if (i27 >= i17 + i18) {
                        i27 = i17 + i18;
                    }
                    this.F = i27;
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    super.invalidate();
                    return;
                } else {
                    super.postInvalidate();
                    return;
                }
            }
            throw new IllegalArgumentException("setProgress Exception, progress is < 0 or > 100, progress = " + i16);
        }
        throw new IllegalArgumentException("setProgress Exception, progressIndex is < 0 or > mTotalCount, progressIndex = " + i3 + ", mTotalCount = " + this.f94499e);
    }

    public void setShowMaxCount(int i3) {
        if (i3 >= 1) {
            if (i3 > 50) {
                i3 = 50;
            }
            this.f94498d = i3;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                super.invalidate();
                return;
            } else {
                super.postInvalidate();
                return;
            }
        }
        throw new IllegalArgumentException("setShowMaxCount Exception, count is < 1, count = " + i3);
    }

    public void setTotalCount(int i3) {
        if (i3 >= 0) {
            this.f94499e = i3;
            setShowMaxCount(i3);
            if (Looper.myLooper() == Looper.getMainLooper()) {
                super.invalidate();
                return;
            } else {
                super.postInvalidate();
                return;
            }
        }
        throw new IllegalArgumentException("setTotalCount Exception, count is < 0, count = " + i3);
    }

    public SplitedProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SplitedProgressBar(Context context) {
        this(context, null, 0);
    }
}
