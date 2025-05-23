package com.tencent.mobileqq.guild.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes14.dex */
public class LivingAnimationView extends View {
    private float C;
    private int D;
    private int E;
    private float F;
    private ValueAnimator G;

    /* renamed from: d, reason: collision with root package name */
    private final Random f236034d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f236035e;

    /* renamed from: f, reason: collision with root package name */
    private final List<Float> f236036f;

    /* renamed from: h, reason: collision with root package name */
    private int f236037h;

    /* renamed from: i, reason: collision with root package name */
    private float f236038i;

    /* renamed from: m, reason: collision with root package name */
    private float f236039m;

    public LivingAnimationView(Context context) {
        super(context);
        this.f236034d = new Random();
        this.f236036f = new ArrayList();
        this.D = SupportMenu.CATEGORY_MASK;
        this.F = 0.0f;
        b();
    }

    private void b() {
        Paint paint = new Paint();
        this.f236035e = paint;
        paint.setAntiAlias(true);
        this.f236035e.setColor(this.D);
    }

    private void c() {
        this.f236036f.clear();
        for (int i3 = 0; i3 < this.f236037h; i3++) {
            this.f236036f.add(Float.valueOf((float) ((this.f236034d.nextInt(10) + 1) * 0.1d * ((getHeight() - getPaddingBottom()) - getPaddingTop()))));
        }
    }

    private boolean d() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(ValueAnimator valueAnimator) {
        for (int i3 = 0; i3 < this.f236036f.size(); i3++) {
            this.f236036f.set(i3, Float.valueOf((this.f236038i - getPaddingTop()) * ((float) Math.abs(Math.sin(this.F + i3)))));
        }
        invalidate();
        this.F = ((Float) valueAnimator.getAnimatedValue()).floatValue();
    }

    public void f() {
        g();
        if (!d()) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 6.2831855f);
        this.G = ofFloat;
        ofFloat.setDuration(this.E);
        this.G.setInterpolator(new LinearInterpolator());
        this.G.setRepeatMode(1);
        this.G.setRepeatCount(-1);
        this.G.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.widget.v
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LivingAnimationView.this.e(valueAnimator);
            }
        });
        this.G.start();
    }

    public void g() {
        ValueAnimator valueAnimator = this.G;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.G = null;
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!d()) {
            return;
        }
        super.onDraw(canvas);
        float paddingLeft = getPaddingLeft() + 0.0f;
        for (int i3 = 0; i3 < this.f236036f.size(); i3++) {
            canvas.drawRect(paddingLeft, this.f236038i - this.f236036f.get(i3).floatValue(), paddingLeft + this.C, this.f236038i, this.f236035e);
            paddingLeft += this.f236039m + this.C;
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f236038i = getHeight() - getPaddingBottom();
        c();
        this.f236039m = (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.C * this.f236037h)) / (r3 - 1);
    }

    public void setPointerColor(int i3) {
        this.D = i3;
        this.f236035e.setColor(i3);
    }

    public void setPointerNum(int i3) {
        this.f236037h = i3;
    }

    public void setPointerSpeed(int i3) {
        this.E = i3;
    }

    public void setPointerWidth(float f16) {
        this.C = f16;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        if (d()) {
            f();
        } else {
            g();
        }
    }

    public LivingAnimationView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f236034d = new Random();
        this.f236036f = new ArrayList();
        this.D = SupportMenu.CATEGORY_MASK;
        this.F = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.f439664sb);
        this.D = obtainStyledAttributes.getColor(up1.a.f439677tb, SupportMenu.CATEGORY_MASK);
        this.f236037h = obtainStyledAttributes.getInt(up1.a.f439690ub, 4);
        this.C = ViewUtils.dip2px(obtainStyledAttributes.getFloat(up1.a.f439714wb, 5.0f));
        this.E = obtainStyledAttributes.getInt(up1.a.f439702vb, 100);
        obtainStyledAttributes.recycle();
        b();
    }

    public LivingAnimationView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f236034d = new Random();
        this.f236036f = new ArrayList();
        this.D = SupportMenu.CATEGORY_MASK;
        this.F = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.f439664sb);
        this.D = obtainStyledAttributes.getColor(up1.a.f439677tb, SupportMenu.CATEGORY_MASK);
        this.f236037h = obtainStyledAttributes.getInt(up1.a.f439690ub, 4);
        this.C = ViewUtils.dip2px(obtainStyledAttributes.getFloat(up1.a.f439714wb, 5.0f));
        this.E = obtainStyledAttributes.getInt(up1.a.f439702vb, 100);
        obtainStyledAttributes.recycle();
        b();
    }
}
