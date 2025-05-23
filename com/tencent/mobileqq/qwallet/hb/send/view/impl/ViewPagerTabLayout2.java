package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQUIAppSetting;

/* loaded from: classes16.dex */
public class ViewPagerTabLayout2 extends HorizontalScrollView {
    protected int C;
    protected int D;
    protected int E;
    protected float F;
    protected Typeface G;
    protected int H;
    protected boolean I;
    protected boolean J;
    protected ViewPager K;
    protected int L;
    protected Paint M;
    protected RectF N;
    private ViewTreeObserver.OnGlobalLayoutListener P;
    private ViewTreeObserver.OnPreDrawListener Q;
    private boolean R;
    protected boolean S;
    private boolean T;

    /* renamed from: d, reason: collision with root package name */
    protected LinearLayout f277810d;

    /* renamed from: e, reason: collision with root package name */
    protected int f277811e;

    /* renamed from: f, reason: collision with root package name */
    private int f277812f;

    /* renamed from: h, reason: collision with root package name */
    private int f277813h;

    /* renamed from: i, reason: collision with root package name */
    protected String[] f277814i;

    /* renamed from: m, reason: collision with root package name */
    protected int f277815m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f277816d;

        a(int i3) {
            this.f277816d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ViewPagerTabLayout2.this.f277812f == this.f277816d && ViewPagerTabLayout2.this.f277812f >= 0) {
                ViewPagerTabLayout2.b(ViewPagerTabLayout2.this);
            }
            ViewPagerTabLayout2.this.T = true;
            ViewPagerTabLayout2 viewPagerTabLayout2 = ViewPagerTabLayout2.this;
            ViewPager viewPager = viewPagerTabLayout2.K;
            if (viewPager != null) {
                viewPager.setCurrentItem(this.f277816d, false);
            } else {
                viewPagerTabLayout2.w(this.f277816d, true, true);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b extends AccessibilityDelegateCompat {
        b() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            boolean z16;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (view != null && (view.getTag() instanceof Integer) && accessibilityNodeInfoCompat != null) {
                if (((Integer) view.getTag()).intValue() == ViewPagerTabLayout2.this.f277812f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                accessibilityNodeInfoCompat.setSelected(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f277819d;

        c(int i3) {
            this.f277819d = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            ViewPagerTabLayout2.this.H = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewPagerTabLayout2 viewPagerTabLayout2 = ViewPagerTabLayout2.this;
            if (viewPagerTabLayout2.H == this.f277819d) {
                viewPagerTabLayout2.I = false;
            }
            viewPagerTabLayout2.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f277821d;

        d(View view) {
            this.f277821d = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewPagerTabLayout2.this.u(this.f277821d);
            ViewPagerTabLayout2.this.getViewTreeObserver().removeOnGlobalLayoutListener(ViewPagerTabLayout2.this.P);
            ViewPagerTabLayout2.this.P = null;
        }
    }

    /* loaded from: classes16.dex */
    class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            View childAt;
            int i3;
            ViewPagerTabLayout2 viewPagerTabLayout2 = ViewPagerTabLayout2.this;
            String[] strArr = viewPagerTabLayout2.f277814i;
            if (strArr != null && strArr.length != 0) {
                if (viewPagerTabLayout2.S && ((i3 = viewPagerTabLayout2.L) == 0 || i3 != viewPagerTabLayout2.getWidth())) {
                    ViewPagerTabLayout2 viewPagerTabLayout22 = ViewPagerTabLayout2.this;
                    viewPagerTabLayout22.L = viewPagerTabLayout22.getWidth();
                    ViewPagerTabLayout2.this.s();
                    return true;
                }
                ViewPagerTabLayout2 viewPagerTabLayout23 = ViewPagerTabLayout2.this;
                if (!viewPagerTabLayout23.J && (childAt = viewPagerTabLayout23.f277810d.getChildAt(viewPagerTabLayout23.f277812f)) != null && childAt.getWidth() != 0) {
                    ViewPagerTabLayout2 viewPagerTabLayout24 = ViewPagerTabLayout2.this;
                    viewPagerTabLayout24.H = viewPagerTabLayout24.l();
                    ViewPagerTabLayout2 viewPagerTabLayout25 = ViewPagerTabLayout2.this;
                    viewPagerTabLayout25.J = true;
                    viewPagerTabLayout25.invalidate();
                }
            }
            return true;
        }
    }

    /* loaded from: classes16.dex */
    public interface f {
    }

    /* loaded from: classes16.dex */
    public interface g {
    }

    /* loaded from: classes16.dex */
    public interface h {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class i implements ViewPager.OnPageChangeListener {
        i() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            ViewPagerTabLayout2 viewPagerTabLayout2 = ViewPagerTabLayout2.this;
            viewPagerTabLayout2.w(i3, true, viewPagerTabLayout2.T);
            ViewPagerTabLayout2.this.T = false;
        }

        /* synthetic */ i(ViewPagerTabLayout2 viewPagerTabLayout2, a aVar) {
            this();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }

    public ViewPagerTabLayout2(Context context) {
        this(context, null);
    }

    static /* synthetic */ g b(ViewPagerTabLayout2 viewPagerTabLayout2) {
        viewPagerTabLayout2.getClass();
        return null;
    }

    private void j() {
        if (!this.J) {
            return;
        }
        int i3 = this.f277813h;
        int i16 = this.f277812f;
        if (i3 != i16) {
            int i17 = o(i3)[0];
            int i18 = o(this.f277812f)[0];
            ValueAnimator ofInt = ValueAnimator.ofInt(i17, i18);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new c(i18));
            ofInt.start();
            this.I = true;
            return;
        }
        this.H = o(i16)[0];
        invalidate();
    }

    private void k(Canvas canvas) {
        if (!this.R) {
            return;
        }
        int[] o16 = o(this.f277812f);
        int i3 = o16[2];
        int i16 = o16[0];
        int i17 = i3 - i16;
        int i18 = this.H;
        if (i18 > 0) {
            i16 = i18;
        }
        this.N.set(i16, o16[1], i17 + i16, o16[3]);
        canvas.drawRect(this.N, this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l() {
        return o(this.f277812f)[0];
    }

    private void p(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.f277810d = linearLayout;
        linearLayout.setOrientation(0);
        this.f277810d.setBackgroundColor(0);
        addView(this.f277810d, new LinearLayout.LayoutParams(-1, -1));
    }

    private void q() {
        if (this.M == null) {
            Paint paint = new Paint();
            this.M = paint;
            paint.setAntiAlias(true);
            this.M.setStyle(Paint.Style.FILL);
            this.M.setTextSize(ViewUtils.dip2px(this.F));
        }
        if (this.N == null) {
            this.N = new RectF();
        }
    }

    private void r() {
        this.f277815m = getContext().getColor(R.color.qui_common_text_primary);
        this.C = getContext().getColor(R.color.qui_common_text_secondary);
        this.D = Color.parseColor("#FF4D4D");
        this.E = ViewUtils.dip2px(21.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(View view) {
        int scrollX = getScrollX();
        int n3 = n() + (view.getWidth() / 2);
        int right = ((view.getRight() - scrollX) + n3) - getWidth();
        if (right > 0) {
            smoothScrollBy(right, 0);
            return;
        }
        int left = (view.getLeft() - scrollX) - n3;
        if (left < 0) {
            smoothScrollBy(left, 0);
        }
    }

    protected void i(int i3, String str) {
        int i16;
        TextView textView = new TextView(getContext());
        textView.setFocusable(true);
        textView.setText(str);
        textView.setTextSize(this.F);
        if (i3 == this.f277812f) {
            i16 = this.f277815m;
        } else {
            i16 = this.C;
        }
        textView.setTextColor(i16);
        Typeface typeface = this.G;
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
        textView.setGravity(17);
        textView.setPadding(0, 0, 0, 0);
        textView.setSingleLine();
        textView.setTag(Integer.valueOf(i3));
        v(textView);
        x(i3, textView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i3 == 0) {
            layoutParams.leftMargin = n();
        }
        layoutParams.rightMargin = n();
        this.f277810d.addView(textView, i3, layoutParams);
    }

    public int m() {
        return this.f277812f;
    }

    protected int n() {
        if (this.f277814i == null) {
            return this.E;
        }
        int i3 = this.L;
        if (i3 == 0) {
            i3 = ViewUtils.getScreenWidth();
        }
        int i16 = 0;
        for (String str : this.f277814i) {
            i16 = (int) (i16 + this.M.measureText(str));
        }
        return Math.max(this.E, (i3 - i16) / (this.f277814i.length + 1));
    }

    protected int[] o(int i3) {
        View childAt = this.f277810d.getChildAt(i3);
        if (childAt == null) {
            QLog.e("QUIPageTabBar", 1, "getUnderLineRect, currentTab is null!");
            return new int[]{0, 0, 0, 0};
        }
        int width = childAt.getWidth();
        int height = getHeight();
        int measureText = ((int) (width - this.M.measureText(this.f277814i[i3]))) / 2;
        int left = childAt.getLeft() + measureText;
        int right = childAt.getRight() - measureText;
        int dpToPx = height - ViewUtils.dpToPx(11.0f);
        return new int[]{left, dpToPx - ViewUtils.dpToPx(2.0f), right, dpToPx};
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.Q == null) {
            this.Q = new e();
        }
        getViewTreeObserver().addOnPreDrawListener(this.Q);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.J = false;
        this.L = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.P != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.P);
            this.P = null;
        }
        if (this.Q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.Q);
            this.Q = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.f277811e != 0 && this.f277810d.getChildAt(this.f277812f) != null) {
            this.M.setColor(this.D);
            k(canvas);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || action != 1) {
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
        }
        return super.onTouchEvent(motionEvent);
    }

    public void s() {
        String[] strArr = this.f277814i;
        if (strArr != null && strArr.length != 0) {
            ViewPager viewPager = this.K;
            if (viewPager != null && (viewPager.getAdapter() == null || this.K.getAdapter().getF373114d() != this.f277814i.length)) {
                return;
            }
            this.f277810d.removeAllViews();
            this.f277811e = this.f277814i.length;
            for (int i3 = 0; i3 < this.f277811e; i3++) {
                i(i3, this.f277814i[i3]);
            }
            this.H = 0;
        }
    }

    public void setCurrentPosition(int i3) {
        setCurrentPosition(i3, false);
    }

    public void setIsShowLine(boolean z16) {
        this.R = z16;
    }

    public void setTabData(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            this.f277814i = (String[]) strArr.clone();
            s();
        }
    }

    public void setTabTextSize(float f16) {
        this.F = f16;
        Paint paint = this.M;
        if (paint != null) {
            paint.setTextSize(ViewUtils.dip2px(f16));
        }
    }

    public void setTabTypeface(Typeface typeface) {
        this.G = typeface;
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager == null) {
            return;
        }
        if (viewPager.getAdapter() != null) {
            this.K = viewPager;
            viewPager.addOnPageChangeListener(new i(this, null));
            s();
            String[] strArr = this.f277814i;
            if (strArr != null && strArr.length > 0) {
                setCurrentPosition(viewPager.getCurrentItem());
                return;
            }
            return;
        }
        QLog.e("QUIPageTabBar", 1, "ViewPager does not have adapter instance.");
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public void t(int i3) {
        View childAt;
        if (this.f277811e != 0 && (childAt = this.f277810d.getChildAt(i3)) != null) {
            if (childAt.getWidth() == 0) {
                if (this.P == null) {
                    this.P = new d(childAt);
                }
                getViewTreeObserver().removeOnGlobalLayoutListener(this.P);
                getViewTreeObserver().addOnGlobalLayoutListener(this.P);
                return;
            }
            u(childAt);
        }
    }

    protected void v(View view) {
        ViewCompat.setAccessibilityDelegate(view, new b());
    }

    protected void w(int i3, boolean z16, boolean z17) {
        if (i3 < 0 || i3 >= this.f277811e) {
            String format = String.format(" illegal position, please check! position = %d, tabCount = %d", Integer.valueOf(i3), Integer.valueOf(this.f277811e));
            QLog.e("QUIPageTabBar", 1, format);
            if (!QQUIAppSetting.isDebugVersion()) {
                i3 = 0;
            } else {
                throw new IllegalArgumentException(format);
            }
        }
        int i16 = this.f277812f;
        if (i16 != i3 && i16 >= 0) {
            this.f277813h = i16;
            this.f277812f = i3;
            y(i3);
            t(this.f277812f);
            if (z16) {
                j();
                return;
            }
            if (this.f277810d.getChildAt(this.f277812f) != null) {
                this.H = l();
            }
            invalidate();
        }
    }

    protected void x(int i3, View view) {
        view.setOnClickListener(new a(i3));
    }

    protected void y(int i3) {
        int childCount = this.f277810d.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            TextView textView = (TextView) this.f277810d.getChildAt(i16);
            if (textView == null) {
                QLog.e("QUIPageTabBar", 1, "updateTextColor, but textview is null.");
                return;
            }
            if (i16 == i3) {
                textView.setTextColor(this.f277815m);
            } else {
                textView.setTextColor(this.C);
            }
        }
    }

    public ViewPagerTabLayout2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setCurrentPosition(int i3, boolean z16) {
        w(i3, z16, false);
    }

    public ViewPagerTabLayout2(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public ViewPagerTabLayout2(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f277812f = 0;
        this.f277813h = 0;
        this.F = 17.0f;
        this.G = null;
        this.I = false;
        this.J = false;
        this.R = true;
        this.S = true;
        this.T = false;
        r();
        p(context);
        q();
    }

    public void setInterceptListener(f fVar) {
    }

    public void setOnCurrentTabClickListener(g gVar) {
    }

    public void setTabChangeListener(h hVar) {
    }
}
