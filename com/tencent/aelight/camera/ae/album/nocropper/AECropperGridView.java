package com.tencent.aelight.camera.ae.album.nocropper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AECropperGridView extends View {
    private boolean C;
    private Handler D;
    private Path E;
    private Runnable F;

    /* renamed from: d, reason: collision with root package name */
    private long f62146d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f62147e;

    /* renamed from: f, reason: collision with root package name */
    private int f62148f;

    /* renamed from: h, reason: collision with root package name */
    private int f62149h;

    /* renamed from: i, reason: collision with root package name */
    private float f62150i;

    /* renamed from: m, reason: collision with root package name */
    private int f62151m;

    public AECropperGridView(Context context) {
        super(context);
        this.f62146d = 200L;
        this.f62148f = 268435455;
        this.f62149h = 200;
        this.f62150i = 0.8f;
        this.f62151m = 3;
        this.C = false;
        this.F = new Runnable() { // from class: com.tencent.aelight.camera.ae.album.nocropper.AECropperGridView.1
            @Override // java.lang.Runnable
            public void run() {
                AECropperGridView.this.animate().setDuration(200L).alpha(0.0f).start();
            }
        };
        a(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.C) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.E.reset();
            float f16 = width / 3;
            this.E.moveTo(f16, 0.0f);
            float f17 = height;
            this.E.lineTo(f16, f17);
            float f18 = (width * 2) / 3;
            this.E.moveTo(f18, 0.0f);
            this.E.lineTo(f18, f17);
            float f19 = height / 3;
            this.E.moveTo(0.0f, f19);
            float f26 = width;
            this.E.lineTo(f26, f19);
            float f27 = (height * 2) / 3;
            this.E.moveTo(0.0f, f27);
            this.E.lineTo(f26, f27);
            canvas.drawPath(this.E, this.f62147e);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int i17 = getContext().getResources().getConfiguration().orientation;
        if (i17 != 1 && i17 != 0) {
            int size = View.MeasureSpec.getSize(i16);
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, 1073741824), size);
        } else {
            int size2 = View.MeasureSpec.getSize(i3);
            setMeasuredDimension(size2, View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }
    }

    public void setShowGrid(boolean z16) {
        if (this.C != z16) {
            this.C = z16;
            if (z16) {
                this.D.removeCallbacks(this.F);
                setAlpha(this.f62150i);
                invalidate();
                return;
            }
            this.D.postDelayed(this.F, this.f62146d);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ls.a.f415479c);
            this.f62148f = obtainStyledAttributes.getColor(0, this.f62148f);
            float f16 = obtainStyledAttributes.getFloat(1, 1.0f);
            this.f62150i = f16;
            float f17 = 255.0f;
            float f18 = f16 * 255.0f;
            if (f18 < 0.0f) {
                f17 = 0.0f;
            } else if (f18 <= 255.0f) {
                f17 = f18;
            }
            this.f62149h = (int) f17;
            this.f62151m = obtainStyledAttributes.getDimensionPixelOffset(2, this.f62151m);
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint();
        this.f62147e = paint;
        paint.setColor(this.f62148f);
        this.f62147e.setAntiAlias(true);
        this.f62147e.setStyle(Paint.Style.STROKE);
        this.f62147e.setStrokeCap(Paint.Cap.ROUND);
        this.f62147e.setStrokeWidth(this.f62151m);
        this.f62147e.setAlpha(this.f62149h);
        this.E = new Path();
        this.D = new Handler();
        if (isInEditMode()) {
            this.C = true;
        }
    }

    public AECropperGridView(Context context, AttributeSet attributeSet) {
        super(context);
        this.f62146d = 200L;
        this.f62148f = 268435455;
        this.f62149h = 200;
        this.f62150i = 0.8f;
        this.f62151m = 3;
        this.C = false;
        this.F = new Runnable() { // from class: com.tencent.aelight.camera.ae.album.nocropper.AECropperGridView.1
            @Override // java.lang.Runnable
            public void run() {
                AECropperGridView.this.animate().setDuration(200L).alpha(0.0f).start();
            }
        };
        a(context, attributeSet);
    }

    public AECropperGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context);
        this.f62146d = 200L;
        this.f62148f = 268435455;
        this.f62149h = 200;
        this.f62150i = 0.8f;
        this.f62151m = 3;
        this.C = false;
        this.F = new Runnable() { // from class: com.tencent.aelight.camera.ae.album.nocropper.AECropperGridView.1
            @Override // java.lang.Runnable
            public void run() {
                AECropperGridView.this.animate().setDuration(200L).alpha(0.0f).start();
            }
        };
        a(context, attributeSet);
    }
}
