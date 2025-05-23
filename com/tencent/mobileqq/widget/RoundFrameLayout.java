package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RoundFrameLayout extends FrameLayout {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f316181m = {1, 2, 4, 8};

    /* renamed from: d, reason: collision with root package name */
    private Path f316182d;

    /* renamed from: e, reason: collision with root package name */
    private int f316183e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f316184f;

    /* renamed from: h, reason: collision with root package name */
    private int f316185h;

    /* renamed from: i, reason: collision with root package name */
    private float[] f316186i;

    public RoundFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        int i3 = 0;
        while (true) {
            float[] fArr = this.f316186i;
            if (i3 < fArr.length) {
                if ((f316181m[i3 / 2] & this.f316185h) != 0) {
                    fArr[i3] = this.f316183e;
                } else {
                    fArr[i3] = 0.0f;
                }
                i3++;
            } else {
                this.f316182d.reset();
                this.f316182d.addRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.f316186i, Path.Direction.CW);
                canvas.drawPath(this.f316182d, this.f316184f);
                return;
            }
        }
    }

    private void b() {
        Path path = new Path();
        this.f316182d = path;
        path.setFillType(Path.FillType.INVERSE_WINDING);
        Paint paint = new Paint(1);
        this.f316184f = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f316184f.setColor(0);
        this.f316184f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f316183e != 0 && this.f316185h != 0) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
            super.dispatchDraw(canvas);
            try {
                try {
                    a(canvas);
                } catch (Exception e16) {
                    QLog.i("RoundFrameLayout", 1, "checkPathChanged", e16);
                    this.f316183e = 0;
                }
                return;
            } finally {
                canvas.restoreToCount(saveLayer);
            }
        }
        super.dispatchDraw(canvas);
    }

    public void setCorners(int i3) {
        this.f316185h = i3;
    }

    public void setRadius(int i3) {
        this.f316183e = i3;
    }

    public RoundFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316183e = 0;
        this.f316185h = 15;
        this.f316186i = new float[8];
        b();
    }
}
