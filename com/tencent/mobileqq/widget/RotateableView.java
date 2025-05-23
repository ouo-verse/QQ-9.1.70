package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RotateableView extends View {
    private Context C;
    Handler D;

    /* renamed from: d, reason: collision with root package name */
    private float f316174d;

    /* renamed from: e, reason: collision with root package name */
    private int f316175e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f316176f;

    /* renamed from: h, reason: collision with root package name */
    private int f316177h;

    /* renamed from: i, reason: collision with root package name */
    private int f316178i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f316179m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            RotateableView.this.f316174d += 8.0f;
            if (RotateableView.this.f316174d >= 360.0f) {
                RotateableView.this.f316174d -= 360.0f;
            }
            RotateableView.this.invalidate();
        }
    }

    public RotateableView(Context context) {
        super(context);
        this.f316179m = false;
        this.D = new a();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.rotate(this.f316174d, this.f316177h / 2.0f, this.f316178i / 2.0f);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap bitmap = this.f316176f;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        }
        if (this.f316179m) {
            float f16 = this.f316174d + 8.0f;
            this.f316174d = f16;
            if (f16 >= 360.0f) {
                this.f316174d = f16 - 360.0f;
            }
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        Bitmap bitmap = this.f316176f;
        if (bitmap != null) {
            this.f316178i = bitmap.getHeight();
            this.f316177h = this.f316176f.getWidth();
        }
        setMeasuredDimension(this.f316177h, this.f316178i);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        this.f316175e = i3;
        this.f316176f = BitmapFactory.decodeResource(this.C.getResources(), this.f316175e);
        invalidate();
    }

    public RotateableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316179m = false;
        this.D = new a();
        this.C = context;
    }
}
