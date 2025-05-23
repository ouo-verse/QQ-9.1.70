package com.tencent.icgame.game.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import d52.a;

/* loaded from: classes7.dex */
public class RoundProgressBar extends View {
    private int C;
    private int D;
    private int E;
    private int F;
    private RectF G;

    /* renamed from: d, reason: collision with root package name */
    private Paint f116109d;

    /* renamed from: e, reason: collision with root package name */
    private int f116110e;

    /* renamed from: f, reason: collision with root package name */
    private int f116111f;

    /* renamed from: h, reason: collision with root package name */
    private float f116112h;

    /* renamed from: i, reason: collision with root package name */
    private int f116113i;

    /* renamed from: m, reason: collision with root package name */
    private int f116114m;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        int i16;
        int i17;
        super.onDraw(canvas);
        if (this.C == 2) {
            this.f116109d.setAntiAlias(true);
            this.f116109d.setStrokeWidth(this.f116112h);
            this.f116109d.setColor(this.f116110e);
            this.f116109d.setStyle(Paint.Style.FILL_AND_STROKE);
            if (this.f116114m != 0 && (i17 = this.f116113i) > 0) {
                canvas.drawArc(this.G, this.F + ((r0 * 360) / i17), 360.0f - ((r0 * 360) / i17), true, this.f116109d);
                return;
            }
            return;
        }
        this.f116109d.setColor(this.f116110e);
        this.f116109d.setStyle(Paint.Style.STROKE);
        this.f116109d.setStrokeWidth(this.f116112h);
        this.f116109d.setAntiAlias(true);
        int i18 = this.D;
        canvas.drawCircle(i18, i18, this.E, this.f116109d);
        this.f116109d.setStrokeWidth(this.f116112h);
        this.f116109d.setColor(this.f116111f);
        int i19 = this.C;
        if (i19 != 0) {
            if (i19 == 1) {
                this.f116109d.setStyle(Paint.Style.FILL_AND_STROKE);
                if (this.f116114m != 0 && (i16 = this.f116113i) > 0) {
                    canvas.drawArc(this.G, this.F, 360 / i16, true, this.f116109d);
                    return;
                }
                return;
            }
            return;
        }
        this.f116109d.setStyle(Paint.Style.STROKE);
        if (this.f116114m != 0 && (i3 = this.f116113i) > 0) {
            canvas.drawArc(this.G, this.F, (r0 * 360) / i3, false, this.f116109d);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int width = getWidth() / 2;
        this.D = width;
        this.E = (int) (width - (this.f116112h / 2.0f));
        RectF rectF = this.G;
        rectF.left = width - r2;
        rectF.top = width - r2;
        rectF.right = width + r2;
        rectF.bottom = width + r2;
    }

    public void setCircleColor(int i3) {
        this.f116110e = i3;
    }

    public void setCircleProgressColor(int i3) {
        this.f116111f = i3;
    }

    public void setMax(int i3) {
        if (i3 < 0) {
            i3 = 1;
        }
        this.f116113i = i3;
    }

    public void setProgress(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        int i16 = this.f116113i;
        if (i3 > i16) {
            i3 = i16;
        }
        this.f116114m = i3;
        invalidate();
    }

    public void setRoundWidth(float f16) {
        this.f116112h = f16;
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f116109d = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f392966s5);
        this.f116110e = obtainStyledAttributes.getColor(a.f392992v5, SupportMenu.CATEGORY_MASK);
        this.f116111f = obtainStyledAttributes.getColor(a.f393000w5, -16711936);
        this.f116112h = obtainStyledAttributes.getDimension(a.f393009x5, 3.0f);
        this.f116113i = obtainStyledAttributes.getInteger(a.f392975t5, 100);
        this.f116114m = obtainStyledAttributes.getInteger(a.f392984u5, 0);
        this.C = obtainStyledAttributes.getInt(a.f393027z5, 0);
        this.F = obtainStyledAttributes.getInteger(a.f393018y5, 0);
        obtainStyledAttributes.recycle();
        this.G = new RectF();
    }
}
