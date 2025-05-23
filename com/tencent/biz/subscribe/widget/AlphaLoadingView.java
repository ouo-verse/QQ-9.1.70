package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AlphaLoadingView extends View {
    private Paint C;
    private String D;
    private Handler E;
    private int F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private int f96375d;

    /* renamed from: e, reason: collision with root package name */
    private int f96376e;

    /* renamed from: f, reason: collision with root package name */
    private int f96377f;

    /* renamed from: h, reason: collision with root package name */
    private int f96378h;

    /* renamed from: i, reason: collision with root package name */
    private int f96379i;

    /* renamed from: m, reason: collision with root package name */
    private int f96380m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (!AlphaLoadingView.this.G) {
                AlphaLoadingView.this.invalidate();
                sendEmptyMessageDelayed(1, AlphaLoadingView.this.F);
            }
        }
    }

    public AlphaLoadingView(Context context) {
        this(context, null);
    }

    private int c(int i3, boolean z16) {
        int i16;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode != 1073741824) {
                    if (z16) {
                        return this.f96377f;
                    }
                    return this.f96378h;
                }
                return size;
            }
            if (z16) {
                return this.f96377f;
            }
            return this.f96378h;
        }
        if (z16) {
            i16 = this.f96377f;
        } else {
            i16 = this.f96378h;
        }
        return Math.min(i16, size);
    }

    public void d() {
        Handler handler = this.E;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.G = true;
            setVisibility(8);
        }
    }

    public void e() {
        Handler handler = this.E;
        if (handler != null) {
            this.G = false;
            handler.sendEmptyMessage(1);
            setVisibility(0);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
        Handler handler = this.E;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i3 = this.f96379i;
        int i16 = this.f96375d;
        int i17 = 30;
        if (i3 < i16) {
            this.f96379i = i3 + 30;
        } else {
            this.f96379i = this.f96380m;
        }
        int i18 = 255;
        int i19 = 255 - ((this.f96379i * 255) / i16);
        if (i19 <= 255) {
            i18 = i19;
        }
        if (i18 >= 30) {
            i17 = i18;
        }
        String hexString = Integer.toHexString(i17);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("#");
        sb5.append(hexString);
        String str = this.D;
        sb5.append(str.substring(1, str.length()));
        this.C.setColor(Color.parseColor(sb5.toString()));
        int i26 = this.f96375d;
        int i27 = this.f96379i;
        int i28 = this.f96378h;
        canvas.drawLine((i26 / 2) - (i27 / 2), i28 / 2, (i26 / 2) + (i27 / 2), i28 / 2, this.C);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        setMeasuredDimension(c(i3, true), c(i16, false));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f96375d = i3;
        this.f96376e = i16;
        int i19 = this.f96379i;
        if (i3 < i19) {
            this.f96375d = i19;
        }
        this.C.setStrokeWidth(i16);
    }

    public void setTimePeriod(int i3) {
        if (this.F > 0) {
            this.F = i3;
        }
    }

    public AlphaLoadingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlphaLoadingView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.F = 16;
        this.f96377f = -1;
        this.f96378h = 5;
        this.f96380m = 100;
        this.f96379i = 100;
        this.D = "#00CAFC";
        Paint paint = new Paint();
        this.C = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.C.setAntiAlias(true);
        this.E = new a();
    }
}
