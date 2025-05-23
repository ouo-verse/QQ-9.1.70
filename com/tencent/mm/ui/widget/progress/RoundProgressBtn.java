package com.tencent.mm.ui.widget.progress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.mobileqq.R;

/* loaded from: classes9.dex */
public class RoundProgressBtn extends View {
    public static final int FILL = 1;
    public static final int STROKE = 0;

    /* renamed from: a, reason: collision with root package name */
    public Paint f153680a;

    /* renamed from: b, reason: collision with root package name */
    public int f153681b;

    /* renamed from: c, reason: collision with root package name */
    public float f153682c;

    /* renamed from: d, reason: collision with root package name */
    public int f153683d;

    /* renamed from: e, reason: collision with root package name */
    public float f153684e;

    /* renamed from: f, reason: collision with root package name */
    public int f153685f;

    /* renamed from: g, reason: collision with root package name */
    public int f153686g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f153687h;

    /* renamed from: i, reason: collision with root package name */
    public int f153688i;

    /* renamed from: j, reason: collision with root package name */
    public int f153689j;

    /* renamed from: k, reason: collision with root package name */
    public int f153690k;

    /* renamed from: l, reason: collision with root package name */
    public int f153691l;

    public RoundProgressBtn(Context context) {
        super(context);
        this.f153689j = 0;
        this.f153690k = 0;
        this.f153691l = o.c(getContext(), R.dimen.bgc);
        a(context, null, 0);
    }

    public final void a(Context context, AttributeSet attributeSet, int i3) {
        this.f153680a = new Paint();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.RoundProgressBtn, i3, 0);
            this.f153681b = obtainStyledAttributes.getColor(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.RoundProgressBtn_roundColor, getContext().getResources().getColor(R.color.cov));
            this.f153682c = obtainStyledAttributes.getDimension(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.RoundProgressBtn_roundwidth, 0.0f);
            this.f153683d = obtainStyledAttributes.getColor(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.RoundProgressBtn_progressColor, getContext().getResources().getColor(R.color.cyl));
            this.f153684e = obtainStyledAttributes.getDimension(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.RoundProgressBtn_progressWidth, this.f153682c);
            this.f153685f = obtainStyledAttributes.getInt(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.RoundProgressBtn_max, 100);
            this.f153688i = obtainStyledAttributes.getInt(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.RoundProgressBtn_progress, 0);
            this.f153686g = obtainStyledAttributes.getInt(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.RoundProgressBtn_startAngle, -90);
            this.f153687h = obtainStyledAttributes.getBoolean(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.RoundProgressBtn_hasPause, true);
            obtainStyledAttributes.recycle();
        }
    }

    public int getProgress() {
        return this.f153688i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        if (this.f153682c == 0.0f) {
            this.f153682c = (int) ((getWidth() / 2) * 0.167d);
        }
        float f16 = this.f153682c;
        this.f153684e = f16;
        this.f153689j = (int) f16;
        float f17 = width;
        this.f153690k = (int) (0.667f * f17);
        int i3 = (int) (f17 - (f16 / 2.0f));
        this.f153680a.setStrokeWidth(f16);
        this.f153680a.setColor(this.f153681b);
        this.f153680a.setAntiAlias(true);
        this.f153680a.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(f17, f17, i3, this.f153680a);
        this.f153680a.setStrokeWidth(this.f153684e);
        this.f153680a.setStrokeCap(Paint.Cap.ROUND);
        this.f153680a.setColor(this.f153683d);
        float f18 = width - i3;
        float f19 = i3 + width;
        canvas.drawArc(new RectF(f18, f18, f19, f19), this.f153686g, (this.f153688i * 360) / this.f153685f, false, this.f153680a);
        this.f153680a.setStrokeWidth(0.0f);
        this.f153680a.setStyle(Paint.Style.FILL);
        if (this.f153687h) {
            float f26 = this.f153682c;
            int i16 = this.f153690k / 2;
            canvas.drawRect(f17 - (f26 * 1.5f), width - i16, f17 - (f26 * 0.5f), i16 + width, this.f153680a);
            float f27 = this.f153689j;
            int i17 = this.f153690k / 2;
            canvas.drawRect(f17 + (0.5f * f27), width - i17, f17 + (f27 * 1.5f), width + i17, this.f153680a);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setText(((this.f153688i * 100) / this.f153685f) + "%");
    }

    public void setHasPause(boolean z16) {
        this.f153687h = z16;
        invalidate();
    }

    public void setProgress(int i3) {
        this.f153688i = Math.max(0, i3);
        this.f153688i = Math.min(i3, this.f153685f);
        invalidate();
    }

    public void setProgressColor(int i3) {
        this.f153683d = i3;
    }

    public RoundProgressBtn(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f153689j = 0;
        this.f153690k = 0;
        this.f153691l = o.c(getContext(), R.dimen.bgc);
        a(context, attributeSet, 0);
    }

    public RoundProgressBtn(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f153689j = 0;
        this.f153690k = 0;
        this.f153691l = o.c(getContext(), R.dimen.bgc);
        a(context, attributeSet, i3);
    }
}
