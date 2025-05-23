package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;

/* loaded from: classes16.dex */
public class ViewPagerTabLayout extends HorizontalScrollView implements ViewPager.OnPageChangeListener {
    private Rect C;
    private Rect D;
    private GradientDrawable E;
    private float F;
    private boolean G;
    private float H;
    private int I;
    private float J;
    private float K;
    private float L;
    private float M;
    private float N;
    private float P;
    private float Q;
    private float R;
    private int S;
    private int T;
    private int U;
    private int V;
    private boolean W;

    /* renamed from: d, reason: collision with root package name */
    private Context f277802d;

    /* renamed from: e, reason: collision with root package name */
    private ViewPager f277803e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f277804f;

    /* renamed from: h, reason: collision with root package name */
    private int f277805h;

    /* renamed from: i, reason: collision with root package name */
    private float f277806i;

    /* renamed from: m, reason: collision with root package name */
    private int f277807m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setSelected(view.isSelected());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int indexOfChild = ViewPagerTabLayout.this.f277804f.indexOfChild(view);
            if (indexOfChild != -1) {
                if (ViewPagerTabLayout.this.f277803e.getCurrentItem() != indexOfChild) {
                    if (!ViewPagerTabLayout.this.W) {
                        ViewPagerTabLayout.this.setCurrentTab(indexOfChild, false);
                    } else {
                        ViewPagerTabLayout.this.setCurrentTab(indexOfChild);
                    }
                    ViewPagerTabLayout.d(ViewPagerTabLayout.this);
                } else {
                    ViewPagerTabLayout.d(ViewPagerTabLayout.this);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes16.dex */
    public interface c {
    }

    public ViewPagerTabLayout(Context context) {
        this(context, null);
    }

    static /* synthetic */ c d(ViewPagerTabLayout viewPagerTabLayout) {
        viewPagerTabLayout.getClass();
        return null;
    }

    private void e(int i3, String str, View view) {
        LinearLayout.LayoutParams layoutParams;
        TextView textView = (TextView) view.getTag();
        if (textView != null && str != null) {
            textView.setText(str);
        }
        view.setOnClickListener(new b());
        if (this.G) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
        }
        if (this.H > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) this.H, -1);
        }
        this.f277804f.addView(view, i3, layoutParams);
    }

    private void f() {
        View childAt = this.f277804f.getChildAt(this.f277805h);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        int i3 = this.f277805h;
        if (i3 < this.f277807m - 1) {
            View childAt2 = this.f277804f.getChildAt(i3 + 1);
            float left2 = childAt2.getLeft();
            float right2 = childAt2.getRight();
            float f16 = this.f277806i;
            left += (left2 - left) * f16;
            right += f16 * (right2 - right);
        }
        Rect rect = this.C;
        float f17 = this.F;
        rect.left = (int) (left + f17);
        rect.right = (int) (right - f17);
        Rect rect2 = this.D;
        rect2.left = (int) left;
        rect2.right = (int) right;
        if (this.K >= 0.0f) {
            float left3 = childAt.getLeft() + ((childAt.getWidth() - this.K) / 2.0f);
            if (this.f277805h < this.f277807m - 1) {
                left3 += this.f277806i * ((childAt.getWidth() / 2) + (this.f277804f.getChildAt(r2 + 1).getWidth() / 2));
            }
            Rect rect3 = this.C;
            int i16 = (int) left3;
            rect3.left = i16;
            rect3.right = (int) (i16 + this.K);
        }
    }

    private void h(Context context, AttributeSet attributeSet) {
        this.f277802d = context;
        setFillViewport(true);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f277804f = linearLayout;
        addView(linearLayout);
        j(context, attributeSet);
    }

    private void j(Context context, AttributeSet attributeSet) {
        int g16;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, gj2.a.M4);
        this.I = obtainStyledAttributes.getColor(gj2.a.N4, Color.parseColor(TipsElementData.DEFAULT_COLOR));
        this.J = obtainStyledAttributes.getDimension(gj2.a.P4, -1.0f);
        this.K = obtainStyledAttributes.getDimension(gj2.a.Q4, -1.0f);
        this.L = obtainStyledAttributes.getDimension(gj2.a.O4, -1.0f);
        this.R = obtainStyledAttributes.getDimension(gj2.a.V4, l(16.0f));
        this.S = obtainStyledAttributes.getColor(gj2.a.T4, Color.parseColor("#FF2051"));
        this.T = obtainStyledAttributes.getColor(gj2.a.U4, Color.parseColor("#F5F6FA"));
        float dimension = obtainStyledAttributes.getDimension(gj2.a.S4, g(-1.0f));
        this.H = dimension;
        int i3 = gj2.a.R4;
        if (!this.G && dimension <= 0.0f) {
            g16 = g(10.0f);
        } else {
            g16 = g(0.0f);
        }
        this.F = obtainStyledAttributes.getDimension(i3, g16);
        obtainStyledAttributes.recycle();
    }

    private void k() {
        if (this.f277807m <= 0) {
            return;
        }
        int width = (int) (this.f277806i * this.f277804f.getChildAt(this.f277805h).getWidth());
        int left = this.f277804f.getChildAt(this.f277805h).getLeft() + width;
        if (this.f277805h > 0 || width > 0) {
            int width2 = left - ((getWidth() / 2) - getPaddingLeft());
            f();
            Rect rect = this.D;
            left = width2 + ((rect.right - rect.left) / 2);
        }
        if (left != this.V) {
            this.V = left;
            scrollTo(left, 0);
        }
    }

    private void n() {
        int i3;
        for (int i16 = 0; i16 < this.f277807m; i16++) {
            TextView textView = (TextView) this.f277804f.getChildAt(i16).getTag();
            if (textView != null) {
                if (i16 == this.f277805h) {
                    i3 = this.S;
                } else {
                    i3 = this.T;
                }
                textView.setTextColor(i3);
                textView.setTextSize(0, this.R);
                float f16 = this.F;
                textView.setPadding((int) f16, 0, (int) f16, 0);
                int i17 = this.U;
                if (i17 == 2) {
                    textView.getPaint().setFakeBoldText(true);
                } else if (i17 == 0) {
                    textView.getPaint().setFakeBoldText(false);
                }
            }
        }
    }

    protected int g(float f16) {
        return (int) ((f16 * this.f277802d.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void i() {
        this.f277804f.removeAllViews();
        this.f277807m = this.f277803e.getAdapter().getF373114d();
        for (int i3 = 0; i3 < this.f277807m; i3++) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            relativeLayout.setClipChildren(false);
            relativeLayout.setClipToPadding(false);
            TextView textView = new TextView(getContext());
            textView.setGravity(17);
            textView.setSingleLine();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            relativeLayout.addView(textView, layoutParams);
            CharSequence pageTitle = this.f277803e.getAdapter().getPageTitle(i3);
            ViewCompat.setAccessibilityDelegate(relativeLayout, new a());
            relativeLayout.setTag(textView);
            if (pageTitle != null) {
                e(i3, pageTitle.toString(), relativeLayout);
            }
        }
        n();
    }

    protected int l(float f16) {
        return (int) ((f16 * this.f277802d.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public void m(int i3) {
        boolean z16;
        int i16;
        for (int i17 = 0; i17 < this.f277807m; i17++) {
            View childAt = this.f277804f.getChildAt(i17);
            if (i17 == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            TextView textView = (TextView) childAt.getTag();
            if (textView != null) {
                if (z16) {
                    i16 = this.S;
                } else {
                    i16 = this.T;
                }
                textView.setTextColor(i16);
                childAt.setSelected(z16);
                childAt.setFocusable(true);
                if (this.U == 1) {
                    textView.getPaint().setFakeBoldText(z16);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.f277807m > 0) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            f();
            if (this.J < 0.0f) {
                this.J = (height - this.N) - this.Q;
            }
            float f16 = this.J;
            if (f16 > 0.0f) {
                float f17 = this.L;
                if (f17 < 0.0f || f17 > f16 / 2.0f) {
                    this.L = f16 / 2.0f;
                }
                this.E.setColor(this.I);
                this.E.setBounds(((int) this.M) + paddingLeft + this.C.left, (int) (height - this.J), (int) ((paddingLeft + r4.right) - this.P), height);
                this.E.setCornerRadius(this.L);
                this.E.draw(canvas);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        this.f277805h = i3;
        this.f277806i = f16;
        k();
        invalidate();
        if (QLog.isColorLevel()) {
            QLog.i("ViewPagerTabLayout", 2, "onPageScrolled:" + i3 + " positionOffset:" + f16);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        m(i3);
        if (QLog.isColorLevel()) {
            QLog.i("ViewPagerTabLayout", 2, "onPageSelected:" + i3);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f277805h = bundle.getInt("currentTab");
            parcelable = bundle.getParcelable("currentState");
            if (this.f277805h != 0 && this.f277804f.getChildCount() > 0) {
                m(this.f277805h);
                k();
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("currentState", super.onSaveInstanceState());
        bundle.putInt("currentTab", this.f277805h);
        return bundle;
    }

    public void setBoldStyle(int i3) {
        this.U = i3;
    }

    public void setCurrentTab(int i3) {
        this.f277805h = i3;
        this.f277803e.setCurrentItem(i3);
    }

    public void setIndicatorColor(int i3) {
        this.I = i3;
        invalidate();
    }

    public void setScrollOnTabClick(boolean z16) {
        this.W = z16;
    }

    public void setTextsize(float f16) {
        this.R = l(f16);
        n();
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager != null && viewPager.getAdapter() != null) {
            this.f277803e = viewPager;
            viewPager.setOnPageChangeListener(this);
            i();
            return;
        }
        throw new IllegalStateException("ViewPager or it's adapter can not be null");
    }

    public ViewPagerTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerTabLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = new Rect();
        this.D = new Rect();
        this.E = new GradientDrawable();
        this.G = false;
        this.U = 1;
        this.W = true;
        h(context, attributeSet);
    }

    public void setCurrentTab(int i3, boolean z16) {
        this.f277805h = i3;
        this.f277803e.setCurrentItem(i3, z16);
        if (z16) {
            return;
        }
        onPageScrolled(i3, 0.0f, 0);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    public void setOnTabSelectListener(c cVar) {
    }
}
