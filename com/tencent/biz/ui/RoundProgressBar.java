package com.tencent.biz.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;

/* loaded from: classes5.dex */
public class RoundProgressBar extends View {
    private float C;
    private int D;
    private int E;
    private int F;
    private RectF G;
    private boolean H;
    Runnable I;

    /* renamed from: d, reason: collision with root package name */
    private Paint f97007d;

    /* renamed from: e, reason: collision with root package name */
    private int f97008e;

    /* renamed from: f, reason: collision with root package name */
    private int f97009f;

    /* renamed from: h, reason: collision with root package name */
    private int f97010h;

    /* renamed from: i, reason: collision with root package name */
    private float f97011i;

    /* renamed from: m, reason: collision with root package name */
    private float f97012m;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    private void d(int i3) {
        this.F = i3;
        ThreadManager.getUIHandler().postDelayed(this.I, 30L);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f16 = width;
        int i3 = (int) (f16 - (this.C / 2.0f));
        this.f97007d.setColor(this.f97008e);
        this.f97007d.setStyle(Paint.Style.STROKE);
        this.f97007d.setStrokeWidth(this.C);
        this.f97007d.setAntiAlias(true);
        canvas.drawCircle(f16, f16, i3, this.f97007d);
        this.f97007d.setStrokeWidth(this.C);
        this.f97007d.setColor(this.f97009f);
        float f17 = width - i3;
        float f18 = width + i3;
        this.G.set(f17, f17, f18, f18);
        this.f97007d.setStyle(Paint.Style.STROKE);
        canvas.drawArc(this.G, -90.0f, (this.E * 360) / this.D, false, this.f97007d);
        this.f97007d.setStrokeWidth(0.0f);
        this.f97007d.setColor(this.f97010h);
        this.f97007d.setTextSize(this.f97011i);
        this.f97007d.setStyle(Paint.Style.FILL);
        this.f97007d.setTypeface(Typeface.DEFAULT_BOLD);
        int i16 = (this.E * 100) / this.D;
        float measureText = this.f97007d.measureText(i16 + "");
        this.f97007d.setTextSize(this.f97012m);
        float measureText2 = this.f97007d.measureText("%");
        if (i16 != 0 && this.H) {
            this.f97007d.setTextSize(this.f97011i);
            float f19 = f16 - ((measureText2 + measureText) / 2.0f);
            canvas.drawText(i16 + "", f19, (this.f97011i / 2.0f) + f16, this.f97007d);
            this.f97007d.setTextSize(this.f97012m);
            canvas.drawText("%", f19 + measureText, f16 + (this.f97011i / 2.0f), this.f97007d);
        }
    }

    public void setCircleColor(int i3) {
        this.f97008e = i3;
    }

    public void setCircleProgressColor(int i3) {
        this.f97009f = i3;
    }

    public synchronized void setMax(int i3) {
        if (i3 >= 0) {
            this.D = i3;
        } else {
            throw new IllegalArgumentException("max not less than 0");
        }
    }

    public void setNeedShowProgreeText(boolean z16) {
        this.H = z16;
    }

    public void setPercentMarkTextSize(float f16) {
        this.f97012m = f16;
    }

    public synchronized void setProgress(int i3) {
        if (i3 >= 0) {
            int i16 = this.D;
            if (i3 > i16) {
                i3 = i16;
            }
            if (i3 <= i16 && this.E != i3) {
                d(i3);
            }
        } else {
            throw new IllegalArgumentException("progress not less than 0");
        }
    }

    public void setRoundWidth(float f16) {
        this.C = f16;
    }

    public void setTextColor(int i3) {
        this.f97010h = i3;
    }

    public void setTextSize(float f16) {
        this.f97011i = f16;
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.H = true;
        this.I = new Runnable() { // from class: com.tencent.biz.ui.RoundProgressBar.1
            @Override // java.lang.Runnable
            public void run() {
                if (RoundProgressBar.this.E < RoundProgressBar.this.F) {
                    RoundProgressBar.this.E++;
                    RoundProgressBar.this.invalidate();
                    ThreadManager.getUIHandler().postDelayed(this, 30L);
                    return;
                }
                if (RoundProgressBar.this.E > RoundProgressBar.this.F) {
                    RoundProgressBar roundProgressBar = RoundProgressBar.this;
                    roundProgressBar.E--;
                    RoundProgressBar.this.invalidate();
                    ThreadManager.getUIHandler().postDelayed(this, 30L);
                }
            }
        };
        this.f97007d = new Paint();
        this.f97008e = -252645121;
        this.f97009f = -1529614848;
        this.f97010h = -16777216;
        this.f97011i = 20.0f;
        this.f97012m = 18.0f;
        this.C = 5.0f;
        this.D = 100;
        this.E = 0;
        this.G = new RectF();
    }
}
