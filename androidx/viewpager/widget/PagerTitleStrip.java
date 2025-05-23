package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.DecorView
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup {
    private static final float SIDE_ALPHA = 0.6f;
    private static final int TEXT_SPACING = 16;
    TextView mCurrText;
    private int mGravity;
    private int mLastKnownCurrentPage;
    float mLastKnownPositionOffset;
    TextView mNextText;
    private int mNonPrimaryAlpha;
    private final PageListener mPageListener;
    ViewPager mPager;
    TextView mPrevText;
    private int mScaledTextSpacing;
    int mTextColor;
    private boolean mUpdatingPositions;
    private boolean mUpdatingText;
    private WeakReference<PagerAdapter> mWatchingAdapter;
    private static final int[] ATTRS = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};
    private static final int[] TEXT_ATTRS = {R.attr.textAllCaps};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
        private int mScrollState;

        PageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.updateAdapter(pagerAdapter, pagerAdapter2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f16 = pagerTitleStrip2.mLastKnownPositionOffset;
            if (f16 < 0.0f) {
                f16 = 0.0f;
            }
            pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f16, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            this.mScrollState = i3;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            if (f16 > 0.5f) {
                i3++;
            }
            PagerTitleStrip.this.updateTextPositions(i3, f16, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            if (this.mScrollState == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), PagerTitleStrip.this.mPager.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f16 = pagerTitleStrip2.mLastKnownPositionOffset;
                if (f16 < 0.0f) {
                    f16 = 0.0f;
                }
                pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f16, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
        private Locale mLocale;

        SingleLineAllCapsTransform(Context context) {
            this.mLocale = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.mLocale);
            }
            return null;
        }
    }

    public PagerTitleStrip(@NonNull Context context) {
        this(context, null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new SingleLineAllCapsTransform(textView.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.mScaledTextSpacing;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        PagerAdapter pagerAdapter;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            PagerAdapter adapter = viewPager.getAdapter();
            viewPager.setInternalPageChangeListener(this.mPageListener);
            viewPager.addOnAdapterChangeListener(this.mPageListener);
            this.mPager = viewPager;
            WeakReference<PagerAdapter> weakReference = this.mWatchingAdapter;
            if (weakReference != null) {
                pagerAdapter = weakReference.get();
            } else {
                pagerAdapter = null;
            }
            updateAdapter(pagerAdapter, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            updateAdapter(viewPager.getAdapter(), null);
            this.mPager.setInternalPageChangeListener(null);
            this.mPager.removeOnAdapterChangeListener(this.mPageListener);
            this.mPager = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (this.mPager != null) {
            float f16 = this.mLastKnownPositionOffset;
            if (f16 < 0.0f) {
                f16 = 0.0f;
            }
            updateTextPositions(this.mLastKnownCurrentPage, f16, true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int max;
        if (View.MeasureSpec.getMode(i3) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i16, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i3);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, (int) (size * 0.2f), -2);
            this.mPrevText.measure(childMeasureSpec2, childMeasureSpec);
            this.mCurrText.measure(childMeasureSpec2, childMeasureSpec);
            this.mNextText.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i16) == 1073741824) {
                max = View.MeasureSpec.getSize(i16);
            } else {
                max = Math.max(getMinHeight(), this.mCurrText.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(max, i16, this.mCurrText.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.mUpdatingText) {
            super.requestLayout();
        }
    }

    public void setGravity(int i3) {
        this.mGravity = i3;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        int i3 = ((int) (f16 * 255.0f)) & 255;
        this.mNonPrimaryAlpha = i3;
        int i16 = (i3 << 24) | (this.mTextColor & 16777215);
        this.mPrevText.setTextColor(i16);
        this.mNextText.setTextColor(i16);
    }

    public void setTextColor(@ColorInt int i3) {
        this.mTextColor = i3;
        this.mCurrText.setTextColor(i3);
        int i16 = (this.mNonPrimaryAlpha << 24) | (this.mTextColor & 16777215);
        this.mPrevText.setTextColor(i16);
        this.mNextText.setTextColor(i16);
    }

    public void setTextSize(int i3, float f16) {
        this.mPrevText.setTextSize(i3, f16);
        this.mCurrText.setTextSize(i3, f16);
        this.mNextText.setTextSize(i3, f16);
    }

    public void setTextSpacing(int i3) {
        this.mScaledTextSpacing = i3;
        requestLayout();
    }

    void updateAdapter(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.mPageListener);
            this.mWatchingAdapter = new WeakReference<>(pagerAdapter2);
        }
        ViewPager viewPager = this.mPager;
        if (viewPager != null) {
            this.mLastKnownCurrentPage = -1;
            this.mLastKnownPositionOffset = -1.0f;
            updateText(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    void updateText(int i3, PagerAdapter pagerAdapter) {
        int i16;
        CharSequence charSequence;
        CharSequence charSequence2;
        if (pagerAdapter != null) {
            i16 = pagerAdapter.getF373114d();
        } else {
            i16 = 0;
        }
        this.mUpdatingText = true;
        CharSequence charSequence3 = null;
        if (i3 >= 1 && pagerAdapter != null) {
            charSequence = pagerAdapter.getPageTitle(i3 - 1);
        } else {
            charSequence = null;
        }
        this.mPrevText.setText(charSequence);
        TextView textView = this.mCurrText;
        if (pagerAdapter != null && i3 < i16) {
            charSequence2 = pagerAdapter.getPageTitle(i3);
        } else {
            charSequence2 = null;
        }
        textView.setText(charSequence2);
        int i17 = i3 + 1;
        if (i17 < i16 && pagerAdapter != null) {
            charSequence3 = pagerAdapter.getPageTitle(i17);
        }
        this.mNextText.setText(charSequence3);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.mPrevText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mCurrText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mNextText.measure(makeMeasureSpec, makeMeasureSpec2);
        this.mLastKnownCurrentPage = i3;
        if (!this.mUpdatingPositions) {
            updateTextPositions(i3, this.mLastKnownPositionOffset, false);
        }
        this.mUpdatingText = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateTextPositions(int i3, float f16, boolean z16) {
        int i16;
        int i17;
        int i18;
        int i19;
        if (i3 != this.mLastKnownCurrentPage) {
            updateText(i3, this.mPager.getAdapter());
        } else if (!z16 && f16 == this.mLastKnownPositionOffset) {
            return;
        }
        this.mUpdatingPositions = true;
        int measuredWidth = this.mPrevText.getMeasuredWidth();
        int measuredWidth2 = this.mCurrText.getMeasuredWidth();
        int measuredWidth3 = this.mNextText.getMeasuredWidth();
        int i26 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i27 = paddingRight + i26;
        int i28 = (width - (paddingLeft + i26)) - i27;
        float f17 = 0.5f + f16;
        if (f17 > 1.0f) {
            f17 -= 1.0f;
        }
        int i29 = ((width - i27) - ((int) (i28 * f17))) - i26;
        int i36 = measuredWidth2 + i29;
        int baseline = this.mPrevText.getBaseline();
        int baseline2 = this.mCurrText.getBaseline();
        int baseline3 = this.mNextText.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i37 = max - baseline;
        int i38 = max - baseline2;
        int i39 = max - baseline3;
        int max2 = Math.max(Math.max(this.mPrevText.getMeasuredHeight() + i37, this.mCurrText.getMeasuredHeight() + i38), this.mNextText.getMeasuredHeight() + i39);
        int i46 = this.mGravity & 112;
        if (i46 != 16) {
            if (i46 != 80) {
                i17 = i37 + paddingTop;
                i18 = i38 + paddingTop;
                i19 = paddingTop + i39;
                TextView textView = this.mCurrText;
                textView.layout(i29, i18, i36, textView.getMeasuredHeight() + i18);
                int min = Math.min(paddingLeft, (i29 - this.mScaledTextSpacing) - measuredWidth);
                TextView textView2 = this.mPrevText;
                textView2.layout(min, i17, measuredWidth + min, textView2.getMeasuredHeight() + i17);
                int max3 = Math.max((width - paddingRight) - measuredWidth3, i36 + this.mScaledTextSpacing);
                TextView textView3 = this.mNextText;
                textView3.layout(max3, i19, max3 + measuredWidth3, textView3.getMeasuredHeight() + i19);
                this.mLastKnownPositionOffset = f16;
                this.mUpdatingPositions = false;
            }
            i16 = (height - paddingBottom) - max2;
        } else {
            i16 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        }
        i17 = i37 + i16;
        i18 = i38 + i16;
        i19 = i16 + i39;
        TextView textView4 = this.mCurrText;
        textView4.layout(i29, i18, i36, textView4.getMeasuredHeight() + i18);
        int min2 = Math.min(paddingLeft, (i29 - this.mScaledTextSpacing) - measuredWidth);
        TextView textView22 = this.mPrevText;
        textView22.layout(min2, i17, measuredWidth + min2, textView22.getMeasuredHeight() + i17);
        int max32 = Math.max((width - paddingRight) - measuredWidth3, i36 + this.mScaledTextSpacing);
        TextView textView32 = this.mNextText;
        textView32.layout(max32, i19, max32 + measuredWidth3, textView32.getMeasuredHeight() + i19);
        this.mLastKnownPositionOffset = f16;
        this.mUpdatingPositions = false;
    }

    public PagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastKnownCurrentPage = -1;
        this.mLastKnownPositionOffset = -1.0f;
        this.mPageListener = new PageListener();
        TextView textView = new TextView(context);
        this.mPrevText = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.mCurrText = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.mNextText = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        boolean z16 = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.setTextAppearance(this.mPrevText, resourceId);
            TextViewCompat.setTextAppearance(this.mCurrText, resourceId);
            TextViewCompat.setTextAppearance(this.mNextText, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.mPrevText.setTextColor(color);
            this.mCurrText.setTextColor(color);
            this.mNextText.setTextColor(color);
        }
        this.mGravity = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.mTextColor = this.mCurrText.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(SIDE_ALPHA);
        this.mPrevText.setEllipsize(TextUtils.TruncateAt.END);
        this.mCurrText.setEllipsize(TextUtils.TruncateAt.END);
        this.mNextText.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, TEXT_ATTRS);
            z16 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z16) {
            setSingleLineAllCaps(this.mPrevText);
            setSingleLineAllCaps(this.mCurrText);
            setSingleLineAllCaps(this.mNextText);
        } else {
            this.mPrevText.setSingleLine();
            this.mCurrText.setSingleLine();
            this.mNextText.setSingleLine();
        }
        this.mScaledTextSpacing = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
