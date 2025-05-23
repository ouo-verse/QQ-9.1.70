package com.tencent.biz.qui.quipagetabbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
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
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes5.dex */
public class QUIPageTabBar extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 200;
    protected static final int CORNER_RADIUS_SIZE = com.tencent.biz.qui.quicommon.e.a(2.0f);
    private static final int MIN_MARGIN_HORIZONTAL = 21;
    protected static final float NEW_STYLE_TAB_SPLIT_LINE_HEIGHT = 0.5f;
    protected static final int NEW_STYLE_TAB_TEXT_SIZE = 15;
    protected static final int TAB_TEXT_SIZE = 17;
    private static final String TAG = "QUIPageTabBar";
    protected static final int UNDERLINE_HEIGHT = 2;
    protected static final int UNDERLINE_MARGIN_TOP = 5;
    protected static final int UNDERLINE_NEW_HEIGHT = 3;
    protected int mAnimationStartX;
    protected ColorStateList mCheckedTextColor;
    private int mCurrentPosition;
    protected boolean mHasInit;
    private g mInterceptListener;
    protected boolean mIsAnim;
    private boolean mIsNewStyle;
    private boolean mIsShowLine;
    private boolean mIsUserClick;
    protected int mMinTabMargin;
    protected boolean mNeedUpdateUIWhenWidthChange;
    private h mOnCurrentTabClickListener;
    private ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    protected i mOnTabChangeListener;
    protected Paint mPaint;
    private int mPrePosition;
    protected RectF mRect;
    protected LinearLayout mTabContainer;
    protected int mTabCount;
    protected float mTabTextSize;
    protected String[] mTabTexts;
    protected Typeface mTabTypeface;
    private int mThemeId;
    protected ColorStateList mUncheckedTextColor;
    protected ColorStateList mUnderlineColor;
    protected ViewPager mViewPager;
    protected ViewPager2 mViewPager2;
    private ViewTreeObserver.OnGlobalLayoutListener mViewTreeObserver;
    protected int mWidth;

    /* loaded from: classes5.dex */
    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            QUIPageTabBar qUIPageTabBar = QUIPageTabBar.this;
            qUIPageTabBar.setCurrentPosition(i3, true, qUIPageTabBar.mIsUserClick);
            QUIPageTabBar.this.mIsUserClick = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f95166d;

        b(int i3) {
            this.f95166d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QUIPageTabBar.this.mCurrentPosition == this.f95166d && QUIPageTabBar.this.mCurrentPosition >= 0 && QUIPageTabBar.this.mOnCurrentTabClickListener != null) {
                QUIPageTabBar.this.mOnCurrentTabClickListener.k1(this.f95166d);
            }
            QUIPageTabBar.this.mIsUserClick = true;
            QUIPageTabBar qUIPageTabBar = QUIPageTabBar.this;
            ViewPager viewPager = qUIPageTabBar.mViewPager;
            if (viewPager != null) {
                viewPager.setCurrentItem(this.f95166d, false);
            } else {
                ViewPager2 viewPager2 = qUIPageTabBar.mViewPager2;
                if (viewPager2 != null) {
                    viewPager2.setCurrentItem(this.f95166d, false);
                } else {
                    qUIPageTabBar.setCurrentPosition(this.f95166d, true, true);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c extends AccessibilityDelegateCompat {
        c() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            boolean z16;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (view != null && (view.getTag() instanceof Integer) && accessibilityNodeInfoCompat != null) {
                if (((Integer) view.getTag()).intValue() == QUIPageTabBar.this.mCurrentPosition) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                accessibilityNodeInfoCompat.setSelected(z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f95169d;

        d(int i3) {
            this.f95169d = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            QUIPageTabBar.this.mAnimationStartX = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            QUIPageTabBar qUIPageTabBar = QUIPageTabBar.this;
            if (qUIPageTabBar.mAnimationStartX == this.f95169d) {
                qUIPageTabBar.mIsAnim = false;
            }
            qUIPageTabBar.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f95171d;

        e(View view) {
            this.f95171d = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            QUIPageTabBar.this.scrollToChildInternal(this.f95171d);
            QUIPageTabBar.this.getViewTreeObserver().removeOnGlobalLayoutListener(QUIPageTabBar.this.mViewTreeObserver);
            QUIPageTabBar.this.mViewTreeObserver = null;
        }
    }

    /* loaded from: classes5.dex */
    class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            View childAt;
            int i3;
            QUIPageTabBar qUIPageTabBar = QUIPageTabBar.this;
            String[] strArr = qUIPageTabBar.mTabTexts;
            if (strArr != null && strArr.length != 0) {
                if (qUIPageTabBar.mNeedUpdateUIWhenWidthChange && ((i3 = qUIPageTabBar.mWidth) == 0 || i3 != qUIPageTabBar.getWidth())) {
                    QUIPageTabBar qUIPageTabBar2 = QUIPageTabBar.this;
                    qUIPageTabBar2.mWidth = qUIPageTabBar2.getWidth();
                    QUIPageTabBar.this.notifyDataSetChanged();
                    return true;
                }
                QUIPageTabBar qUIPageTabBar3 = QUIPageTabBar.this;
                if (!qUIPageTabBar3.mHasInit && (childAt = qUIPageTabBar3.mTabContainer.getChildAt(qUIPageTabBar3.mCurrentPosition)) != null && childAt.getWidth() != 0) {
                    QUIPageTabBar qUIPageTabBar4 = QUIPageTabBar.this;
                    qUIPageTabBar4.mAnimationStartX = qUIPageTabBar4.getAniStartX();
                    QUIPageTabBar qUIPageTabBar5 = QUIPageTabBar.this;
                    qUIPageTabBar5.mHasInit = true;
                    qUIPageTabBar5.invalidate();
                }
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a(boolean z16);
    }

    /* loaded from: classes5.dex */
    public interface h {
        void k1(int i3);
    }

    /* loaded from: classes5.dex */
    public interface i {
        void I0(int i3, boolean z16);
    }

    /* loaded from: classes5.dex */
    private class j implements ViewPager.OnPageChangeListener {
        j() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            QUIPageTabBar qUIPageTabBar = QUIPageTabBar.this;
            qUIPageTabBar.setCurrentPosition(i3, true, qUIPageTabBar.mIsUserClick);
            QUIPageTabBar.this.mIsUserClick = false;
        }

        /* synthetic */ j(QUIPageTabBar qUIPageTabBar, a aVar) {
            this();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }

    public QUIPageTabBar(Context context) {
        this(context, null);
    }

    private void animateUnderline() {
        if (!this.mHasInit) {
            return;
        }
        int i3 = this.mPrePosition;
        int i16 = this.mCurrentPosition;
        if (i3 != i16) {
            int i17 = getUnderLineRect(i3)[0];
            int i18 = getUnderLineRect(this.mCurrentPosition)[0];
            ValueAnimator ofInt = ValueAnimator.ofInt(i17, i18);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new d(i18));
            ofInt.start();
            this.mIsAnim = true;
            return;
        }
        this.mAnimationStartX = getUnderLineRect(i16)[0];
        invalidate();
    }

    private void drawSplitLine(Canvas canvas) {
        this.mPaint.setColor(getContext().getColor(R.color.qui_common_border_standard));
        int height = getHeight();
        int left = this.mTabContainer.getLeft();
        int right = this.mTabContainer.getRight();
        int d16 = height - com.tencent.biz.qui.quicommon.e.d(getContext(), 0.5f);
        int d17 = com.tencent.biz.qui.quicommon.e.d(getContext(), 0.5f) + d16;
        Rect rect = new Rect();
        rect.set(left, d16, right, d17);
        canvas.drawRect(rect, this.mPaint);
    }

    private void drawUnderline(Canvas canvas) {
        if (!this.mIsShowLine) {
            return;
        }
        int[] underLineRect = getUnderLineRect(this.mCurrentPosition);
        int i3 = underLineRect[2];
        int i16 = underLineRect[0];
        int i17 = i3 - i16;
        int i18 = this.mAnimationStartX;
        if (i18 > 0) {
            i16 = i18;
        }
        this.mRect.set(i16, underLineRect[1], i17 + i16, underLineRect[3]);
        if (this.mIsNewStyle) {
            RectF rectF = this.mRect;
            int i19 = CORNER_RADIUS_SIZE;
            canvas.drawRoundRect(rectF, i19, i19, this.mPaint);
            return;
        }
        canvas.drawRect(this.mRect, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAniStartX() {
        return getUnderLineRect(this.mCurrentPosition)[0];
    }

    private void initBaseView(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.mTabContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.mTabContainer.setBackgroundColor(0);
        addView(this.mTabContainer, new LinearLayout.LayoutParams(-1, -1));
    }

    private void initFromAttributes(Context context, AttributeSet attributeSet, int i3, int i16) {
        float f16;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.biz.qui.quipagetabbar.a.G, i3, i16);
        this.mIsNewStyle = obtainStyledAttributes.getBoolean(com.tencent.biz.qui.quipagetabbar.a.H, false);
        ud0.d.g(TAG, ud0.d.f438811e, "mIsNewStyle is = " + this.mIsNewStyle);
        if (this.mIsNewStyle) {
            f16 = 15.0f;
        } else {
            f16 = 17.0f;
        }
        this.mTabTextSize = f16;
        obtainStyledAttributes.recycle();
    }

    private void initPaint() {
        if (this.mPaint == null) {
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setTextSize(com.tencent.biz.qui.quicommon.e.b(getContext(), this.mTabTextSize));
        }
        if (this.mRect == null) {
            this.mRect = new RectF();
        }
    }

    private void initParams() {
        int i3;
        ie0.a f16 = ie0.a.f();
        Context context = getContext();
        boolean z16 = this.mIsNewStyle;
        int i16 = R.color.qui_common_text_primary;
        if (z16) {
            i3 = R.color.qui_common_text_primary;
        } else {
            i3 = R.color.qui_common_brand_standard;
        }
        this.mCheckedTextColor = f16.h(context, i3, this.mThemeId);
        ie0.a f17 = ie0.a.f();
        Context context2 = getContext();
        if (this.mIsNewStyle) {
            i16 = R.color.qui_common_icon_primary;
        }
        this.mUncheckedTextColor = f17.h(context2, i16, this.mThemeId);
        this.mUnderlineColor = ie0.a.f().h(getContext(), R.color.qui_common_brand_standard, this.mThemeId);
        this.mMinTabMargin = com.tencent.biz.qui.quicommon.e.b(getContext(), 21.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChildInternal(View view) {
        int scrollX = getScrollX();
        int tabMargin = getTabMargin() + (view.getWidth() / 2);
        int right = ((view.getRight() - scrollX) + tabMargin) - getWidth();
        if (right > 0) {
            smoothScrollBy(right, 0);
            return;
        }
        int left = (view.getLeft() - scrollX) - tabMargin;
        if (left < 0) {
            smoothScrollBy(left, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addTab(int i3, String str) {
        ColorStateList colorStateList;
        Typeface typeface;
        TextView textView = new TextView(getContext());
        textView.setFocusable(true);
        textView.setText(str);
        textView.setTextSize(this.mTabTextSize);
        if (i3 == this.mCurrentPosition) {
            colorStateList = this.mCheckedTextColor;
        } else {
            colorStateList = this.mUncheckedTextColor;
        }
        textView.setTextColor(colorStateList);
        if (this.mIsNewStyle) {
            if (i3 == this.mCurrentPosition) {
                typeface = Typeface.DEFAULT_BOLD;
            } else {
                typeface = Typeface.DEFAULT;
            }
            textView.setTypeface(typeface);
        }
        Typeface typeface2 = this.mTabTypeface;
        if (typeface2 != null) {
            textView.setTypeface(typeface2);
        }
        textView.setGravity(17);
        textView.setPadding(0, 0, 0, 0);
        textView.setSingleLine();
        textView.setTag(Integer.valueOf(i3));
        setAccessibilityDelegate(textView);
        setTabClickListener(i3, textView);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        if (i3 == 0) {
            layoutParams.leftMargin = getTabMargin();
        }
        layoutParams.rightMargin = getTabMargin();
        this.mTabContainer.addView(textView, i3, layoutParams);
    }

    public void bindViewPager2(ViewPager2 viewPager2) {
        if (viewPager2 == null) {
            return;
        }
        if (viewPager2.getAdapter() != null) {
            this.mViewPager2 = viewPager2;
            viewPager2.registerOnPageChangeCallback(new a());
            notifyDataSetChanged();
            String[] strArr = this.mTabTexts;
            if (strArr != null && strArr.length > 0) {
                setCurrentPosition(viewPager2.getCurrentItem());
                return;
            }
            return;
        }
        ud0.d.b(TAG, ud0.d.f438811e, "ViewPager2 does not have adapter instance.");
        throw new IllegalStateException("ViewPager2 does not have adapter instance.");
    }

    public ColorStateList getCheckedTextColor() {
        return this.mCheckedTextColor;
    }

    public int getCurrentPosition() {
        return this.mCurrentPosition;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getTabMargin() {
        if (this.mTabTexts == null) {
            return this.mMinTabMargin;
        }
        int i3 = this.mWidth;
        if (i3 == 0) {
            i3 = com.tencent.biz.qui.quicommon.e.i();
        }
        int i16 = 0;
        for (String str : this.mTabTexts) {
            i16 = (int) (i16 + this.mPaint.measureText(str));
        }
        return Math.max(this.mMinTabMargin, (i3 - i16) / (this.mTabTexts.length + 1));
    }

    public ColorStateList getUncheckedTextColor() {
        return this.mUncheckedTextColor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] getUnderLineRect(int i3) {
        float f16;
        View childAt = this.mTabContainer.getChildAt(i3);
        if (childAt == null) {
            ud0.d.b(TAG, ud0.d.f438811e, "getUnderLineRect, currentTab is null!");
            return new int[]{0, 0, 0, 0};
        }
        int width = childAt.getWidth();
        int height = getHeight();
        int measureText = ((int) (width - this.mPaint.measureText(this.mTabTexts[i3]))) / 2;
        int left = childAt.getLeft() + measureText;
        int right = childAt.getRight() - measureText;
        int b16 = (height / 2) + (com.tencent.biz.qui.quicommon.e.b(getContext(), this.mTabTextSize) / 2) + com.tencent.biz.qui.quicommon.e.d(getContext(), 5.0f);
        int d16 = height - com.tencent.biz.qui.quicommon.e.d(getContext(), 3.5f);
        if (this.mIsNewStyle) {
            b16 = d16;
        }
        Context context = getContext();
        if (this.mIsNewStyle) {
            f16 = 3.0f;
        } else {
            f16 = 2.0f;
        }
        return new int[]{left, b16, right, com.tencent.biz.qui.quicommon.e.d(context, f16) + b16};
    }

    public ColorStateList getUnderlineColor() {
        return this.mUnderlineColor;
    }

    public void notifyDataSetChanged() {
        String[] strArr = this.mTabTexts;
        if (strArr != null && strArr.length != 0) {
            ViewPager viewPager = this.mViewPager;
            if (viewPager != null && (viewPager.getAdapter() == null || this.mViewPager.getAdapter().getCount() != this.mTabTexts.length)) {
                if (ud0.d.i()) {
                    ud0.d.b(TAG, ud0.d.f438811e, "tabTexts size not match viewPager's size");
                    return;
                }
                return;
            }
            ViewPager2 viewPager2 = this.mViewPager2;
            if (viewPager2 != null && (viewPager2.getAdapter() == null || this.mViewPager2.getAdapter().getItemCount() != this.mTabTexts.length)) {
                if (ud0.d.i()) {
                    ud0.d.b(TAG, ud0.d.f438811e, "tabTexts size not match viewPager2's size");
                    return;
                }
                return;
            }
            this.mTabContainer.removeAllViews();
            this.mTabCount = this.mTabTexts.length;
            for (int i3 = 0; i3 < this.mTabCount; i3++) {
                addTab(i3, this.mTabTexts[i3]);
            }
            this.mAnimationStartX = 0;
            return;
        }
        if (ud0.d.i()) {
            ud0.d.b(TAG, ud0.d.f438811e, "tabTexts is empty!");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mOnPreDrawListener == null) {
            this.mOnPreDrawListener = new f();
        }
        getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mHasInit = false;
        this.mWidth = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mViewTreeObserver != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.mViewTreeObserver);
            this.mViewTreeObserver = null;
        }
        if (this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
            this.mOnPreDrawListener = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.mTabCount != 0) {
            if (this.mTabContainer.getChildAt(this.mCurrentPosition) != null) {
                this.mPaint.setColor(this.mUnderlineColor.getDefaultColor());
                drawUnderline(canvas);
            }
            if (this.mIsNewStyle) {
                drawSplitLine(canvas);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        g gVar;
        int action = motionEvent.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3) && (gVar = this.mInterceptListener) != null) {
                gVar.a(false);
            }
        } else {
            g gVar2 = this.mInterceptListener;
            if (gVar2 != null) {
                gVar2.a(true);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        g gVar;
        int action = motionEvent.getAction();
        if ((action == 1 || action == 3) && (gVar = this.mInterceptListener) != null) {
            gVar.a(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void scrollToChild(int i3) {
        View childAt;
        if (this.mTabCount != 0 && (childAt = this.mTabContainer.getChildAt(i3)) != null) {
            if (childAt.getWidth() == 0) {
                if (this.mViewTreeObserver == null) {
                    this.mViewTreeObserver = new e(childAt);
                }
                getViewTreeObserver().removeOnGlobalLayoutListener(this.mViewTreeObserver);
                getViewTreeObserver().addOnGlobalLayoutListener(this.mViewTreeObserver);
                return;
            }
            scrollToChildInternal(childAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAccessibilityDelegate(View view) {
        ViewCompat.setAccessibilityDelegate(view, new c());
    }

    public void setCheckedColor(ColorStateList colorStateList) {
        this.mCheckedTextColor = colorStateList;
    }

    public void setCurrentPosition(int i3) {
        setCurrentPosition(i3, false);
    }

    public void setInterceptListener(g gVar) {
        this.mInterceptListener = gVar;
    }

    public void setIsShowLine(boolean z16) {
        this.mIsShowLine = z16;
    }

    public void setOnCurrentTabClickListener(h hVar) {
        this.mOnCurrentTabClickListener = hVar;
    }

    public void setTabChangeListener(i iVar) {
        this.mOnTabChangeListener = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTabClickListener(int i3, View view) {
        view.setOnClickListener(new b(i3));
    }

    public void setTabData(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            this.mTabTexts = (String[]) strArr.clone();
            notifyDataSetChanged();
        }
    }

    public void setTabTextSize(float f16) {
        this.mTabTextSize = f16;
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setTextSize(com.tencent.biz.qui.quicommon.e.b(getContext(), this.mTabTextSize));
        }
    }

    public void setTabTypeface(Typeface typeface) {
        this.mTabTypeface = typeface;
    }

    public void setThemeId(int i3) {
        this.mThemeId = i3;
        initParams();
    }

    public void setUncheckedColor(ColorStateList colorStateList) {
        this.mUncheckedTextColor = colorStateList;
    }

    public void setUnderlineColor(ColorStateList colorStateList) {
        this.mUnderlineColor = colorStateList;
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager == null) {
            return;
        }
        if (viewPager.getAdapter() != null) {
            this.mViewPager = viewPager;
            viewPager.addOnPageChangeListener(new j(this, null));
            notifyDataSetChanged();
            String[] strArr = this.mTabTexts;
            if (strArr != null && strArr.length > 0) {
                setCurrentPosition(viewPager.getCurrentItem());
                return;
            }
            return;
        }
        ud0.d.b(TAG, ud0.d.f438811e, "ViewPager does not have adapter instance.");
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public void updateTabText(int i3, String str) {
        String[] strArr = this.mTabTexts;
        if (strArr != null && i3 >= 0 && i3 < strArr.length && !TextUtils.isEmpty(str)) {
            this.mTabTexts[i3] = str;
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateTextColor(int i3) {
        int childCount = this.mTabContainer.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            TextView textView = (TextView) this.mTabContainer.getChildAt(i16);
            if (textView == null) {
                ud0.d.b(TAG, ud0.d.f438811e, "updateTextColor, but textview is null.");
                return;
            }
            if (i16 == i3) {
                textView.setTextColor(this.mCheckedTextColor);
                if (this.mIsNewStyle) {
                    textView.setTypeface(Typeface.DEFAULT_BOLD);
                }
            } else {
                textView.setTextColor(this.mUncheckedTextColor);
                if (this.mIsNewStyle) {
                    textView.setTypeface(Typeface.DEFAULT);
                }
            }
        }
    }

    public QUIPageTabBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setCurrentPosition(int i3, boolean z16) {
        setCurrentPosition(i3, z16, false);
    }

    public QUIPageTabBar(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCurrentPosition(int i3, boolean z16, boolean z17) {
        if (i3 < 0 || i3 >= this.mTabCount) {
            String format = String.format(" illegal position, please check! position = %d, tabCount = %d", Integer.valueOf(i3), Integer.valueOf(this.mTabCount));
            ud0.d.b(TAG, ud0.d.f438811e, format);
            if (ud0.b.d()) {
                throw new IllegalArgumentException(format);
            }
            i3 = 0;
        }
        int i16 = this.mCurrentPosition;
        if (i16 == i3 || i16 < 0) {
            return;
        }
        this.mPrePosition = i16;
        this.mCurrentPosition = i3;
        updateTextColor(i3);
        scrollToChild(this.mCurrentPosition);
        if (z16) {
            animateUnderline();
        } else {
            if (this.mTabContainer.getChildAt(this.mCurrentPosition) != null) {
                this.mAnimationStartX = getAniStartX();
            }
            invalidate();
        }
        i iVar = this.mOnTabChangeListener;
        if (iVar != null) {
            iVar.I0(i3, z17);
        }
    }

    public QUIPageTabBar(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mCurrentPosition = 0;
        this.mPrePosition = 0;
        this.mTabTextSize = 17.0f;
        this.mTabTypeface = null;
        this.mIsAnim = false;
        this.mHasInit = false;
        this.mThemeId = 1000;
        this.mIsShowLine = true;
        this.mNeedUpdateUIWhenWidthChange = true;
        this.mIsUserClick = false;
        this.mIsNewStyle = false;
        initFromAttributes(context, attributeSet, i3, i16);
        initParams();
        initBaseView(context);
        initPaint();
    }
}
