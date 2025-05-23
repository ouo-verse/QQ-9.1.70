package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.util.x;
import hd0.c;

/* loaded from: classes5.dex */
public class ProgressPointer extends View implements Handler.Callback {
    private int C;
    private int D;
    private Handler E;
    private int F;
    private int G;
    private long H;

    /* renamed from: d, reason: collision with root package name */
    private float f94417d;

    /* renamed from: e, reason: collision with root package name */
    private int f94418e;

    /* renamed from: f, reason: collision with root package name */
    private int f94419f;

    /* renamed from: h, reason: collision with root package name */
    private int f94420h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f94421i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f94422m;

    public ProgressPointer(Context context) {
        super(context);
        this.f94417d = -1.0f;
        this.f94421i = false;
        this.E = new Handler(Looper.getMainLooper(), this);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f94422m = paint;
        paint.setColor(-1);
        this.f94422m.setStyle(Paint.Style.FILL);
        this.C = x.c(getContext(), ScrollFrameSelectBar.T);
    }

    public void b() {
        this.H = System.currentTimeMillis();
        this.f94417d = 0.0f;
        this.E.removeMessages(1);
        this.E.sendEmptyMessage(1);
    }

    public void c() {
        this.H = System.currentTimeMillis();
        this.f94417d = 100.0f;
        this.E.removeMessages(1);
        this.E.sendEmptyMessage(1);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = currentTimeMillis - this.H;
            this.H = currentTimeMillis;
            float f16 = this.f94417d + ((((float) j3) * 100.0f) / this.f94420h);
            this.f94417d = f16;
            if (f16 > 100.0f) {
                this.f94417d = 100.0f;
            }
            invalidate();
            this.E.sendEmptyMessageDelayed(1, 50L);
            return false;
        }
        return false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.E.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f16 = this.f94417d;
        if (f16 >= 0.0f) {
            int i3 = this.f94419f;
            float f17 = (((i3 - r2) * f16) / 100.0f) + this.f94418e;
            canvas.drawRect(f17 - 2.0f, 0.0f, f17 + 2.0f, this.F, this.f94422m);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        this.D = View.MeasureSpec.getSize(i16);
        super.onMeasure(i3, i16);
    }

    public void setFrameSize(int i3, int i16) {
        this.F = i3;
        this.G = i16;
    }

    public void setRange(int i3, int i16, int i17) {
        c.e("Q.qqstory.frameWidget.ProgressPointer", "++++++++setRange++++++start=%s,end=%s,duration=%s,mProgress=%s", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Float.valueOf(this.f94417d));
        this.f94418e = i3;
        this.f94419f = i16;
        this.f94420h = i17;
    }

    public ProgressPointer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f94417d = -1.0f;
        this.f94421i = false;
        this.E = new Handler(Looper.getMainLooper(), this);
        a();
    }

    public ProgressPointer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f94417d = -1.0f;
        this.f94421i = false;
        this.E = new Handler(Looper.getMainLooper(), this);
        a();
    }
}
