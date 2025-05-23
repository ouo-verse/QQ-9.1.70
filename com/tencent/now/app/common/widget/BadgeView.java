package com.tencent.now.app.common.widget;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TabWidget;
import android.widget.TextView;
import com.tencent.component.appx.utils.AppUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BadgeView extends TextView {
    private static final int H = Color.parseColor("#ffff554c");
    private static Animation I;
    private static Animation J;
    private int C;
    private int D;
    private boolean E;
    private ShapeDrawable F;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    private Context f337896d;

    /* renamed from: e, reason: collision with root package name */
    private View f337897e;

    /* renamed from: f, reason: collision with root package name */
    private int f337898f;

    /* renamed from: h, reason: collision with root package name */
    private int f337899h;

    /* renamed from: i, reason: collision with root package name */
    private int f337900i;

    /* renamed from: m, reason: collision with root package name */
    private int f337901m;

    public BadgeView(Context context) {
        this(context, null, R.attr.textViewStyle);
    }

    private void a() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.C, this.D);
        int i3 = this.f337898f;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            layoutParams.gravity = 17;
                            layoutParams.setMargins(0, 0, 0, 0);
                        }
                    } else {
                        layoutParams.gravity = 85;
                        layoutParams.setMargins(0, 0, this.f337899h, this.f337900i);
                    }
                } else {
                    layoutParams.gravity = 83;
                    layoutParams.setMargins(this.f337899h, 0, 0, this.f337900i);
                }
            } else {
                layoutParams.gravity = 53;
                layoutParams.setMargins(0, this.f337900i, this.f337899h, 0);
            }
        } else {
            layoutParams.gravity = 51;
            layoutParams.setMargins(this.f337899h, this.f337900i, 0, 0);
        }
        setLayoutParams(layoutParams);
    }

    private void b(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewParent parent = view.getParent();
        FrameLayout frameLayout = new FrameLayout(this.f337896d);
        if (view instanceof TabWidget) {
            View childTabViewAt = ((TabWidget) view).getChildTabViewAt(this.G);
            this.f337897e = childTabViewAt;
            ((ViewGroup) childTabViewAt).addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            setVisibility(8);
            frameLayout.addView(this);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int indexOfChild = viewGroup.indexOfChild(view);
        viewGroup.removeView(view);
        viewGroup.addView(frameLayout, indexOfChild, layoutParams);
        frameLayout.addView(view);
        setVisibility(8);
        frameLayout.addView(this);
        viewGroup.invalidate();
    }

    private ShapeDrawable c() {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(this.f337901m);
        return shapeDrawable;
    }

    private void d(Context context, View view, int i3) {
        this.f337896d = context;
        this.f337897e = view;
        this.G = i3;
        int dip2px = AppUtils.UI.dip2px(8.0f);
        this.C = dip2px;
        this.D = dip2px;
        this.f337898f = 2;
        int dip2px2 = AppUtils.UI.dip2px(5.0f);
        this.f337899h = dip2px2;
        this.f337900i = dip2px2;
        this.f337901m = H;
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        I = alphaAnimation;
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        I.setDuration(200L);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        J = alphaAnimation2;
        alphaAnimation2.setInterpolator(new AccelerateInterpolator());
        J.setDuration(200L);
        this.E = false;
        View view2 = this.f337897e;
        if (view2 != null) {
            b(view2);
        } else {
            e();
        }
    }

    private void f(boolean z16, Animation animation) {
        if (getBackground() == null) {
            if (this.F == null) {
                this.F = c();
            }
            setBackground(this.F);
        }
        a();
        if (z16) {
            startAnimation(animation);
        }
        setVisibility(0);
        this.E = true;
    }

    public void e() {
        f(false, null);
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.E;
    }

    public void setBadgeBackgroundColor(int i3) {
        this.f337901m = i3;
        this.F = c();
    }

    public void setBadgeMargin(int i3) {
        this.f337899h = i3;
        this.f337900i = i3;
    }

    public void setBadgePosition(int i3) {
        this.f337898f = i3;
    }

    public BadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, null, 0);
    }

    public void setBadgeMargin(int i3, int i16) {
        this.f337899h = i3;
        this.f337900i = i16;
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i3, View view, int i16) {
        super(context, attributeSet, i3);
        d(context, view, i16);
    }
}
