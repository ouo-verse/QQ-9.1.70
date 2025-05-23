package com.tencent.mm.ui.widget.loading;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R;

/* loaded from: classes9.dex */
public class MMProgressLoading extends View {

    /* renamed from: a, reason: collision with root package name */
    public Paint f153432a;

    /* renamed from: b, reason: collision with root package name */
    public int f153433b;

    /* renamed from: c, reason: collision with root package name */
    public int f153434c;

    /* renamed from: d, reason: collision with root package name */
    public int f153435d;

    /* renamed from: e, reason: collision with root package name */
    public int f153436e;

    public MMProgressLoading(Context context) {
        super(context);
        a(context, null, 0);
    }

    public final void a(Context context, AttributeSet attributeSet, int i3) {
        this.f153432a = new Paint();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressLoading, i3, 0);
            this.f153433b = obtainStyledAttributes.getColor(R.styleable.ProgressLoading_loadProgressColor, getResources().getColor(com.tencent.mobileqq.R.color.f156699b25));
            this.f153434c = obtainStyledAttributes.getInt(R.styleable.ProgressLoading_loadMax, 100);
            this.f153436e = obtainStyledAttributes.getInt(R.styleable.ProgressLoading_loadprogress, 0);
            this.f153435d = obtainStyledAttributes.getInt(R.styleable.ProgressLoading_loadStartAngle, -90);
            obtainStyledAttributes.recycle();
        }
    }

    public int getProgress() {
        return this.f153436e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int width2 = (int) ((getWidth() / 2) * 0.175d);
        int i3 = (width - (width2 / 2)) - 1;
        int color = getResources().getColor(com.tencent.mobileqq.R.color.b1e);
        float f16 = width2;
        this.f153432a.setStrokeWidth(f16);
        this.f153432a.setColor(color);
        this.f153432a.setAlpha(127);
        this.f153432a.setAntiAlias(true);
        this.f153432a.setStyle(Paint.Style.STROKE);
        float f17 = width;
        float f18 = i3;
        canvas.drawCircle(f17, f17, f18, this.f153432a);
        this.f153432a.setStrokeWidth(f16);
        this.f153432a.setColor(this.f153433b);
        this.f153432a.setAlpha(51);
        this.f153432a.setAntiAlias(true);
        this.f153432a.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(f17, f17, f18, this.f153432a);
        this.f153432a.setStrokeWidth(f16);
        this.f153432a.setStrokeCap(Paint.Cap.ROUND);
        this.f153432a.setColor(this.f153433b);
        float f19 = width - i3;
        float f26 = width + i3;
        canvas.drawArc(new RectF(f19, f19, f26, f26), this.f153435d, (this.f153436e * 360) / this.f153434c, false, this.f153432a);
    }

    public void resetConfig(int i3, int i16, int i17, int i18) {
        this.f153436e = i3;
        this.f153433b = i16;
        this.f153434c = i17;
        this.f153435d = i18;
        invalidate();
    }

    public void setProgress(int i3) {
        this.f153436e = Math.max(0, i3);
        this.f153436e = Math.min(i3, this.f153434c);
        invalidate();
    }

    public MMProgressLoading(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public MMProgressLoading(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context, attributeSet, i3);
    }
}
