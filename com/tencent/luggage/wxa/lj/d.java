package com.tencent.luggage.wxa.lj;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleHomeButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandTranslateLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends com.tencent.luggage.wxa.kl.f implements h, com.tencent.luggage.wxa.hp.a {
    public AppBrandTranslateLayout C;
    public boolean D;

    /* renamed from: f, reason: collision with root package name */
    public int f133444f;

    /* renamed from: g, reason: collision with root package name */
    public final AppBrandOptionButton f133445g;

    /* renamed from: h, reason: collision with root package name */
    public final AppBrandCapsuleHomeButton f133446h;

    /* renamed from: i, reason: collision with root package name */
    public final ConstraintLayout f133447i;

    /* renamed from: j, reason: collision with root package name */
    public final int f133448j;

    /* renamed from: k, reason: collision with root package name */
    public final View f133449k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f133450l;

    /* renamed from: m, reason: collision with root package name */
    public final ViewStub f133451m;

    public d(@NonNull Context context) {
        this(context, null);
    }

    private void setTranslateLayoutStyleColor(@ColorInt int i3) {
        AppBrandTranslateLayout appBrandTranslateLayout = this.C;
        if (appBrandTranslateLayout != null) {
            appBrandTranslateLayout.setStyleColor(i3);
        }
    }

    @Override // com.tencent.luggage.wxa.hp.a
    public boolean a(Canvas canvas) {
        draw(canvas);
        return true;
    }

    public void d() {
        this.D = false;
        if (this.f133444f == -1) {
            this.f133447i.setBackgroundResource(R.drawable.j_h);
        } else {
            this.f133447i.setBackgroundResource(R.drawable.j_i);
        }
    }

    public void destroy() {
        removeAllViews();
    }

    public void e() {
        this.D = true;
        if (this.f133444f == -1) {
            this.f133447i.setBackgroundResource(R.drawable.j_b);
        } else {
            this.f133447i.setBackgroundResource(R.drawable.j_c);
        }
    }

    public View getCapsuleContentAreaView() {
        return this.f133447i;
    }

    public AppBrandCapsuleHomeButton getCapsuleHomeButton() {
        return this.f133446h;
    }

    public AppBrandOptionButton getOptionBtn() {
        return this.f133445g;
    }

    public AppBrandTranslateLayout getTranslateLayout() {
        if (this.C == null) {
            AppBrandTranslateLayout appBrandTranslateLayout = (AppBrandTranslateLayout) this.f133451m.inflate().findViewById(R.id.s_h);
            this.C = appBrandTranslateLayout;
            appBrandTranslateLayout.setDivider(findViewById(R.id.s_e));
            this.C.setStyleColor(this.f133444f);
        }
        return this.C;
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i3, int i16, int i17, int i18) {
        if (view.getId() == R.id.s_9) {
            view.getLayoutParams().height = this.f133448j;
        }
        super.measureChildWithMargins(view, i3, i16, i17, i18);
    }

    public void setCapsuleContentAreaMarginEnd(int i3) {
        ViewGroup.LayoutParams layoutParams = getCapsuleContentAreaView().getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams.getMarginEnd() != i3 || marginLayoutParams.rightMargin != i3) {
                marginLayoutParams.rightMargin = i3;
                marginLayoutParams.setMarginEnd(i3);
                getCapsuleContentAreaView().setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void setHomeButtonOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f133446h.setOnClickListener(onClickListener);
    }

    public void setOptionButtonOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f133445g.setOnClickListener(onClickListener);
    }

    public void setStyleColor(@ColorInt int i3) {
        if (i3 == this.f133444f) {
            return;
        }
        if (i3 == -1) {
            this.f133444f = -1;
            this.f133449k.setBackgroundResource(R.color.b5h);
            this.f133450l.setTextColor(z.a(R.color.b5q));
            if (this.D) {
                this.f133447i.setBackgroundResource(R.drawable.j_b);
            } else {
                this.f133447i.setBackgroundResource(R.drawable.j_h);
            }
            this.f133445g.setColor(-1);
            this.f133446h.setColor(-1);
            setTranslateLayoutStyleColor(-1);
            return;
        }
        this.f133444f = -16777216;
        this.f133449k.setBackgroundResource(R.color.b5i);
        this.f133450l.setTextColor(z.a(R.color.b5r));
        if (this.D) {
            this.f133447i.setBackgroundResource(R.drawable.j_c);
        } else {
            this.f133447i.setBackgroundResource(R.drawable.j_i);
        }
        this.f133445g.setColor(-16777216);
        this.f133446h.setColor(-16777216);
        setTranslateLayoutStyleColor(-16777216);
    }

    public d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f133444f = 0;
        this.D = false;
        LayoutInflater.from(context).inflate(R.layout.dxq, (ViewGroup) this, true);
        AppBrandOptionButton appBrandOptionButton = (AppBrandOptionButton) findViewById(R.id.s_g);
        this.f133445g = appBrandOptionButton;
        AppBrandCapsuleHomeButton appBrandCapsuleHomeButton = (AppBrandCapsuleHomeButton) findViewById(R.id.s_f);
        this.f133446h = appBrandCapsuleHomeButton;
        this.f133447i = (ConstraintLayout) findViewById(R.id.s_9);
        this.f133449k = findViewById(R.id.s_d);
        this.f133450l = (TextView) findViewById(R.id.s_c);
        this.f133451m = (ViewStub) findViewById(R.id.s_h);
        appBrandOptionButton.setAccessibilityLabel(getContext().getString(R.string.ywi));
        appBrandCapsuleHomeButton.setAccessibilityLabel(getContext().getString(R.string.ywe));
        this.f133448j = context.getResources().getDimensionPixelSize(R.dimen.c1t);
    }
}
