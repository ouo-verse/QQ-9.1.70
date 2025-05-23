package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class MutliSeletedBottomLine extends View {
    private boolean C;
    private int D;
    private Paint E;

    /* renamed from: d, reason: collision with root package name */
    private final float f315854d;

    /* renamed from: e, reason: collision with root package name */
    private final float f315855e;

    /* renamed from: f, reason: collision with root package name */
    private final float f315856f;

    /* renamed from: h, reason: collision with root package name */
    private final float f315857h;

    /* renamed from: i, reason: collision with root package name */
    private float f315858i;

    /* renamed from: m, reason: collision with root package name */
    private float f315859m;

    public MutliSeletedBottomLine(Context context, int i3, boolean z16) {
        this(context, i3, com.tencent.mobileqq.util.x.c(context, 29.0f), z16);
    }

    @Override // android.view.View
    @SuppressLint({"ResourceAsColor"})
    protected void onDraw(Canvas canvas) {
        float f16;
        double d16;
        super.onDraw(canvas);
        this.E.setColor(getResources().getColor(R.color.alu));
        this.E.setAntiAlias(true);
        if (!this.C) {
            f16 = 0.2f;
        } else {
            f16 = 1.0f;
        }
        int i3 = 0;
        while (true) {
            if (i3 < this.D) {
                if (!this.C) {
                    d16 = f16 + ((i3 / r2) * 0.8d);
                } else {
                    d16 = f16 - ((i3 / r2) * 0.8d);
                }
                this.E.setAlpha((int) (((float) d16) * 255.0f));
                canvas.drawCircle((i3 * 8.0f) + 2.0f, this.f315859m / 2.0f, 2.0f, this.E);
                i3++;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        setMeasuredDimension((int) this.f315858i, getMeasuredHeight());
    }

    public MutliSeletedBottomLine(Context context, int i3, int i16, boolean z16) {
        super(context);
        this.f315854d = 0.2f;
        this.f315855e = 1.0f;
        this.f315856f = 2.0f;
        this.f315857h = 6.0f;
        this.f315858i = 0.0f;
        this.f315859m = 29.0f;
        this.C = false;
        this.E = new Paint();
        float f16 = i3;
        this.f315858i = f16;
        this.f315859m = i16;
        this.C = z16;
        this.D = (int) (f16 / 8.0f);
    }
}
