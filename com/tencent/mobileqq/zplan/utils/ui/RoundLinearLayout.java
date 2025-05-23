package com.tencent.mobileqq.zplan.utils.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.view.RoundRelativeLayout;

/* compiled from: P */
/* loaded from: classes34.dex */
public class RoundLinearLayout extends LinearLayout {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f335842m = {1, 2, 4, 8};

    /* renamed from: d, reason: collision with root package name */
    public Path f335843d;

    /* renamed from: e, reason: collision with root package name */
    public int f335844e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f335845f;

    /* renamed from: h, reason: collision with root package name */
    public int f335846h;

    /* renamed from: i, reason: collision with root package name */
    private float[] f335847i;

    public RoundLinearLayout(Context context) {
        super(context);
        this.f335846h = 15;
        this.f335847i = new float[8];
        b();
    }

    public void b() {
        Path path = new Path();
        this.f335843d = path;
        path.setFillType(Path.FillType.INVERSE_WINDING);
        Paint paint = new Paint(1);
        this.f335845f = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f335845f.setColor(0);
        this.f335845f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f335844e != 0 && this.f335846h != 0) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
            super.dispatchDraw(canvas);
            try {
                try {
                    a(canvas);
                } catch (Exception e16) {
                    QLog.i(RoundRelativeLayout.TAG, 1, "checkPathChanged", e16);
                }
                return;
            } finally {
                canvas.restoreToCount(saveLayer);
            }
        }
        super.dispatchDraw(canvas);
    }

    private void a(Canvas canvas) {
        int i3 = 0;
        while (true) {
            float[] fArr = this.f335847i;
            if (i3 < fArr.length) {
                if ((f335842m[i3 / 2] & this.f335846h) != 0) {
                    fArr[i3] = this.f335844e;
                } else {
                    fArr[i3] = 0.0f;
                }
                i3++;
            } else {
                this.f335843d.reset();
                this.f335843d.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.f335847i, Path.Direction.CW);
                canvas.drawPath(this.f335843d, this.f335845f);
                return;
            }
        }
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f335846h = 15;
        this.f335847i = new float[8];
        b();
    }

    public RoundLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f335846h = 15;
        this.f335847i = new float[8];
        b();
    }
}
