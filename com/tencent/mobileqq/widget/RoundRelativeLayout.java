package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RoundRelativeLayout extends RelativeLayout {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f316193m = {1, 2, 4, 8};

    /* renamed from: d, reason: collision with root package name */
    public Path f316194d;

    /* renamed from: e, reason: collision with root package name */
    public int f316195e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f316196f;

    /* renamed from: h, reason: collision with root package name */
    public int f316197h;

    /* renamed from: i, reason: collision with root package name */
    private float[] f316198i;

    public RoundRelativeLayout(Context context) {
        super(context);
        this.f316197h = 15;
        this.f316198i = new float[8];
        e();
    }

    private void d(Canvas canvas) {
        int i3 = 0;
        while (true) {
            float[] fArr = this.f316198i;
            if (i3 < fArr.length) {
                if ((f316193m[i3 / 2] & this.f316197h) != 0) {
                    fArr[i3] = this.f316195e;
                } else {
                    fArr[i3] = 0.0f;
                }
                i3++;
            } else {
                this.f316194d.reset();
                this.f316194d.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.f316198i, Path.Direction.CW);
                canvas.drawPath(this.f316194d, this.f316196f);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f316195e != 0 && this.f316197h != 0) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
            super.dispatchDraw(canvas);
            try {
                try {
                    d(canvas);
                } catch (Exception e16) {
                    QLog.i(com.tencent.state.view.RoundRelativeLayout.TAG, 1, "checkPathChanged", e16);
                }
                return;
            } finally {
                canvas.restoreToCount(saveLayer);
            }
        }
        super.dispatchDraw(canvas);
    }

    public void e() {
        Path path = new Path();
        this.f316194d = path;
        path.setFillType(Path.FillType.INVERSE_WINDING);
        Paint paint = new Paint(1);
        this.f316196f = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f316196f.setColor(0);
        this.f316196f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f316197h = 15;
        this.f316198i = new float[8];
        e();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316197h = 15;
        this.f316198i = new float[8];
        e();
    }
}
