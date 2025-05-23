package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.guild.widget.x;

/* compiled from: P */
@RequiresApi(api = 21)
/* loaded from: classes14.dex */
public class RadiusFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private final x f236123d;

    /* renamed from: e, reason: collision with root package name */
    private float f236124e;

    /* renamed from: f, reason: collision with root package name */
    private float f236125f;

    /* renamed from: h, reason: collision with root package name */
    private float f236126h;

    /* renamed from: i, reason: collision with root package name */
    private float f236127i;

    /* renamed from: m, reason: collision with root package name */
    private float f236128m;

    public RadiusFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private x.b a(TypedArray typedArray) {
        float dimension = typedArray.getDimension(com.tencent.mobileqq.guild.api.j.G3, 0.0f);
        this.f236125f = typedArray.getDimension(com.tencent.mobileqq.guild.api.j.H3, dimension);
        this.f236126h = typedArray.getDimension(com.tencent.mobileqq.guild.api.j.I3, dimension);
        this.f236127i = typedArray.getDimension(com.tencent.mobileqq.guild.api.j.E3, dimension);
        float dimension2 = typedArray.getDimension(com.tencent.mobileqq.guild.api.j.F3, dimension);
        this.f236128m = dimension2;
        return x.b.b(this.f236125f, this.f236126h, dimension2, this.f236127i);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.guild.api.j.D3, 0, 0);
        this.f236123d.b(a(obtainStyledAttributes));
        this.f236124e = obtainStyledAttributes.getFloat(com.tencent.mobileqq.guild.api.j.J3, this.f236124e);
        obtainStyledAttributes.recycle();
    }

    private void c() {
        this.f236123d.e(this.f236125f, this.f236126h, this.f236128m, this.f236127i);
        invalidate();
    }

    public void d(float f16) {
        this.f236123d.d(f16);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int save = canvas.save();
        this.f236123d.a(canvas);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int save = canvas.save();
        this.f236123d.a(canvas);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    public void e(float f16, float f17, float f18, float f19) {
        this.f236123d.e(f16, f17, f18, f19);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (this.f236124e > 0.0f) {
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i3) / this.f236124e), 1073741824));
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f236123d.c(i3, i16, i17, i18);
    }

    public void setBottomLeftCornerRadius(int i3) {
        this.f236127i = i3;
        c();
    }

    public void setBottomRightCornerRadius(int i3) {
        this.f236128m = i3;
        c();
    }

    public void setCornerRadius(int i3) {
        this.f236123d.d(i3);
        invalidate();
    }

    public void setTopLeftCornerRadius(int i3) {
        this.f236125f = i3;
        c();
    }

    public void setTopRightCornerRadius(int i3) {
        this.f236126h = i3;
        c();
    }

    public RadiusFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public RadiusFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f236124e = -1.0f;
        this.f236125f = 0.0f;
        this.f236126h = 0.0f;
        this.f236127i = 0.0f;
        this.f236128m = 0.0f;
        this.f236123d = new x(this);
        b(context, attributeSet);
    }

    public void setCornerRadius(float[] fArr) {
        if (fArr.length < 4) {
            return;
        }
        this.f236125f = fArr[0];
        this.f236126h = fArr[1];
        this.f236128m = fArr[2];
        this.f236127i = fArr[3];
        c();
    }
}
