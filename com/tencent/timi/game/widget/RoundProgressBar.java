package com.tencent.timi.game.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import mr2.a;

/* loaded from: classes26.dex */
public class RoundProgressBar extends View {
    private int C;
    private int D;
    private int E;
    private int F;
    private RectF G;

    /* renamed from: d, reason: collision with root package name */
    private Paint f380352d;

    /* renamed from: e, reason: collision with root package name */
    private int f380353e;

    /* renamed from: f, reason: collision with root package name */
    private int f380354f;

    /* renamed from: h, reason: collision with root package name */
    private float f380355h;

    /* renamed from: i, reason: collision with root package name */
    private int f380356i;

    /* renamed from: m, reason: collision with root package name */
    private int f380357m;

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
            this.f380352d.setAntiAlias(true);
            this.f380352d.setStrokeWidth(this.f380355h);
            this.f380352d.setColor(this.f380353e);
            this.f380352d.setStyle(Paint.Style.FILL_AND_STROKE);
            if (this.f380357m != 0 && (i17 = this.f380356i) > 0) {
                canvas.drawArc(this.G, this.F + ((r0 * 360) / i17), 360.0f - ((r0 * 360) / i17), true, this.f380352d);
                return;
            }
            return;
        }
        this.f380352d.setColor(this.f380353e);
        this.f380352d.setStyle(Paint.Style.STROKE);
        this.f380352d.setStrokeWidth(this.f380355h);
        this.f380352d.setAntiAlias(true);
        int i18 = this.D;
        canvas.drawCircle(i18, i18, this.E, this.f380352d);
        this.f380352d.setStrokeWidth(this.f380355h);
        this.f380352d.setColor(this.f380354f);
        int i19 = this.C;
        if (i19 != 0) {
            if (i19 == 1) {
                this.f380352d.setStyle(Paint.Style.FILL_AND_STROKE);
                if (this.f380357m != 0 && (i16 = this.f380356i) > 0) {
                    canvas.drawArc(this.G, this.F, 360 / i16, true, this.f380352d);
                    return;
                }
                return;
            }
            return;
        }
        this.f380352d.setStyle(Paint.Style.STROKE);
        if (this.f380357m != 0 && (i3 = this.f380356i) > 0) {
            canvas.drawArc(this.G, this.F, (r0 * 360) / i3, false, this.f380352d);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int width = getWidth() / 2;
        this.D = width;
        this.E = (int) (width - (this.f380355h / 2.0f));
        RectF rectF = this.G;
        rectF.left = width - r2;
        rectF.top = width - r2;
        rectF.right = width + r2;
        rectF.bottom = width + r2;
    }

    public void setCircleColor(int i3) {
        this.f380353e = i3;
    }

    public void setCircleProgressColor(int i3) {
        this.f380354f = i3;
    }

    public void setMax(int i3) {
        if (i3 < 0) {
            i3 = 1;
        }
        this.f380356i = i3;
    }

    public void setProgress(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        int i16 = this.f380356i;
        if (i3 > i16) {
            i3 = i16;
        }
        this.f380357m = i3;
        invalidate();
    }

    public void setRoundWidth(float f16) {
        this.f380355h = f16;
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f380352d = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f417380r5);
        this.f380353e = obtainStyledAttributes.getColor(a.f417407u5, SupportMenu.CATEGORY_MASK);
        this.f380354f = obtainStyledAttributes.getColor(a.f417415v5, -16711936);
        this.f380355h = obtainStyledAttributes.getDimension(a.f417423w5, 3.0f);
        this.f380356i = obtainStyledAttributes.getInteger(a.f417389s5, 100);
        this.f380357m = obtainStyledAttributes.getInteger(a.f417398t5, 0);
        this.C = obtainStyledAttributes.getInt(a.f417441y5, 0);
        this.F = obtainStyledAttributes.getInteger(a.f417432x5, 0);
        obtainStyledAttributes.recycle();
        this.G = new RectF();
    }
}
