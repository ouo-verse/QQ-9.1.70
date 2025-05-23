package com.tencent.mobileqq.guild.widget.circleindicator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes14.dex */
class GuildBaseCircleIndicator extends LinearLayout {
    protected ColorStateList C;
    protected Animator D;
    protected Animator E;
    protected Animator F;
    protected Animator G;
    protected int H;

    /* renamed from: d, reason: collision with root package name */
    protected int f236320d;

    /* renamed from: e, reason: collision with root package name */
    protected int f236321e;

    /* renamed from: f, reason: collision with root package name */
    protected int f236322f;

    /* renamed from: h, reason: collision with root package name */
    protected int f236323h;

    /* renamed from: i, reason: collision with root package name */
    protected int f236324i;

    /* renamed from: m, reason: collision with root package name */
    protected ColorStateList f236325m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class b implements Interpolator {
        protected b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            return Math.abs(1.0f - f16);
        }
    }

    public GuildBaseCircleIndicator(Context context) {
        super(context);
        this.f236320d = -1;
        this.f236321e = -1;
        this.f236322f = -1;
        this.H = -1;
        h(context, null);
    }

    private void c(View view, @DrawableRes int i3, @Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            Drawable wrap = DrawableCompat.wrap(ContextCompat.getDrawable(getContext(), i3).mutate());
            DrawableCompat.setTintList(wrap, colorStateList);
            ViewCompat.setBackground(view, wrap);
            return;
        }
        view.setBackgroundResource(i3);
    }

    private com.tencent.mobileqq.guild.widget.circleindicator.a g(Context context, AttributeSet attributeSet) {
        com.tencent.mobileqq.guild.widget.circleindicator.a aVar = new com.tencent.mobileqq.guild.widget.circleindicator.a();
        if (attributeSet == null) {
            return aVar;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.f439731y2);
        aVar.f236328a = obtainStyledAttributes.getDimensionPixelSize(up1.a.H2, -1);
        aVar.f236329b = obtainStyledAttributes.getDimensionPixelSize(up1.a.E2, -1);
        aVar.f236330c = obtainStyledAttributes.getDimensionPixelSize(up1.a.F2, -1);
        aVar.f236331d = obtainStyledAttributes.getResourceId(up1.a.f439744z2, R.anim.f154599o7);
        aVar.f236332e = obtainStyledAttributes.getResourceId(up1.a.A2, 0);
        int resourceId = obtainStyledAttributes.getResourceId(up1.a.B2, R.drawable.guild_indicator_white_radius);
        aVar.f236333f = resourceId;
        aVar.f236334g = obtainStyledAttributes.getResourceId(up1.a.C2, resourceId);
        aVar.f236335h = obtainStyledAttributes.getInt(up1.a.G2, -1);
        aVar.f236336i = obtainStyledAttributes.getInt(up1.a.D2, -1);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private void h(Context context, AttributeSet attributeSet) {
        i(g(context, attributeSet));
        if (isInEditMode()) {
            f(3, 1);
        }
    }

    protected void a(int i3) {
        View view = new View(getContext());
        LinearLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.width = this.f236321e;
        generateDefaultLayoutParams.height = this.f236322f;
        if (i3 == 0) {
            int i16 = this.f236320d;
            generateDefaultLayoutParams.leftMargin = i16;
            generateDefaultLayoutParams.rightMargin = i16;
        } else {
            int i17 = this.f236320d;
            generateDefaultLayoutParams.topMargin = i17;
            generateDefaultLayoutParams.bottomMargin = i17;
        }
        addView(view, generateDefaultLayoutParams);
    }

    public void b(int i3) {
        View childAt;
        if (this.H == i3) {
            return;
        }
        if (this.E.isRunning()) {
            this.E.end();
            this.E.cancel();
        }
        if (this.D.isRunning()) {
            this.D.end();
            this.D.cancel();
        }
        int i16 = this.H;
        if (i16 >= 0 && (childAt = getChildAt(i16)) != null) {
            c(childAt, this.f236324i, this.C);
            this.E.setTarget(childAt);
            this.E.start();
        }
        View childAt2 = getChildAt(i3);
        if (childAt2 != null) {
            c(childAt2, this.f236323h, this.f236325m);
            this.D.setTarget(childAt2);
            this.D.start();
        }
        this.H = i3;
    }

    protected Animator d(com.tencent.mobileqq.guild.widget.circleindicator.a aVar) {
        if (aVar.f236332e == 0) {
            Animator loadAnimator = AnimatorInflater.loadAnimator(getContext(), aVar.f236331d);
            loadAnimator.setInterpolator(new b());
            return loadAnimator;
        }
        return AnimatorInflater.loadAnimator(getContext(), aVar.f236332e);
    }

    protected Animator e(com.tencent.mobileqq.guild.widget.circleindicator.a aVar) {
        return AnimatorInflater.loadAnimator(getContext(), aVar.f236331d);
    }

    public void f(int i3, int i16) {
        if (this.F.isRunning()) {
            this.F.end();
            this.F.cancel();
        }
        if (this.G.isRunning()) {
            this.G.end();
            this.G.cancel();
        }
        int childCount = getChildCount();
        if (i3 < childCount) {
            removeViews(i3, childCount - i3);
        } else if (i3 > childCount) {
            int i17 = i3 - childCount;
            int orientation = getOrientation();
            for (int i18 = 0; i18 < i17; i18++) {
                a(orientation);
            }
        }
        for (int i19 = 0; i19 < i3; i19++) {
            View childAt = getChildAt(i19);
            if (i16 == i19) {
                c(childAt, this.f236323h, this.f236325m);
                this.F.setTarget(childAt);
                this.F.start();
                this.F.end();
            } else {
                c(childAt, this.f236324i, this.C);
                this.G.setTarget(childAt);
                this.G.start();
                this.G.end();
            }
        }
        this.H = i16;
    }

    public void i(com.tencent.mobileqq.guild.widget.circleindicator.a aVar) {
        int i3;
        int i16 = 1;
        int applyDimension = (int) (TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics()) + 0.5f);
        int i17 = aVar.f236328a;
        if (i17 < 0) {
            i17 = applyDimension;
        }
        this.f236321e = i17;
        int i18 = aVar.f236329b;
        if (i18 < 0) {
            i18 = applyDimension;
        }
        this.f236322f = i18;
        int i19 = aVar.f236330c;
        if (i19 >= 0) {
            applyDimension = i19;
        }
        this.f236320d = applyDimension;
        this.D = e(aVar);
        Animator e16 = e(aVar);
        this.F = e16;
        e16.setDuration(0L);
        this.E = d(aVar);
        Animator d16 = d(aVar);
        this.G = d16;
        d16.setDuration(0L);
        int i26 = aVar.f236333f;
        if (i26 == 0) {
            i3 = R.drawable.guild_indicator_white_radius;
        } else {
            i3 = i26;
        }
        this.f236323h = i3;
        int i27 = aVar.f236334g;
        if (i27 != 0) {
            i26 = i27;
        }
        this.f236324i = i26;
        if (aVar.f236335h != 1) {
            i16 = 0;
        }
        setOrientation(i16);
        int i28 = aVar.f236336i;
        if (i28 < 0) {
            i28 = 17;
        }
        setGravity(i28);
    }

    public GuildBaseCircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f236320d = -1;
        this.f236321e = -1;
        this.f236322f = -1;
        this.H = -1;
        h(context, attributeSet);
    }

    public GuildBaseCircleIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f236320d = -1;
        this.f236321e = -1;
        this.f236322f = -1;
        this.H = -1;
        h(context, attributeSet);
    }

    public void setIndicatorCreatedListener(@Nullable a aVar) {
    }
}
