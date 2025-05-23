package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 32;
    private static final int MIN_TEXT_SPACING = 64;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 32;
    private static final String TAG = "PagerTabStrip";
    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final Paint mTabPaint;
    private final Rect mTempRect;
    private int mTouchSlop;

    public PagerTabStrip(@NonNull Context context) {
        this(context, null);
    }

    public boolean getDrawFullUnderline() {
        return this.mDrawFullUnderline;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.mMinStripHeight);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.mIndicatorColor;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.mCurrText.getLeft() - this.mTabPadding;
        int right = this.mCurrText.getRight() + this.mTabPadding;
        int i3 = height - this.mIndicatorHeight;
        this.mTabPaint.setColor((this.mTabAlpha << 24) | (this.mIndicatorColor & 16777215));
        float f16 = height;
        canvas.drawRect(left, i3, right, f16, this.mTabPaint);
        if (this.mDrawFullUnderline) {
            this.mTabPaint.setColor((this.mIndicatorColor & 16777215) | (-16777216));
            canvas.drawRect(getPaddingLeft(), height - this.mFullUnderlineHeight, getWidth() - getPaddingRight(), f16, this.mTabPaint);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.mIgnoreTap) {
            return false;
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && (Math.abs(x16 - this.mInitialMotionX) > this.mTouchSlop || Math.abs(y16 - this.mInitialMotionY) > this.mTouchSlop)) {
                    this.mIgnoreTap = true;
                }
            } else if (x16 < this.mCurrText.getLeft() - this.mTabPadding) {
                ViewPager viewPager = this.mPager;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            } else if (x16 > this.mCurrText.getRight() + this.mTabPadding) {
                ViewPager viewPager2 = this.mPager;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        } else {
            this.mInitialMotionX = x16;
            this.mInitialMotionY = y16;
            this.mIgnoreTap = false;
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i3) {
        boolean z16;
        super.setBackgroundColor(i3);
        if (!this.mDrawFullUnderlineSet) {
            if ((i3 & (-16777216)) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mDrawFullUnderline = z16;
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        boolean z16;
        super.setBackgroundDrawable(drawable);
        if (!this.mDrawFullUnderlineSet) {
            if (drawable == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mDrawFullUnderline = z16;
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i3) {
        boolean z16;
        super.setBackgroundResource(i3);
        if (!this.mDrawFullUnderlineSet) {
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mDrawFullUnderline = z16;
        }
    }

    public void setDrawFullUnderline(boolean z16) {
        this.mDrawFullUnderline = z16;
        this.mDrawFullUnderlineSet = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
        int i19 = this.mMinPaddingBottom;
        if (i18 < i19) {
            i18 = i19;
        }
        super.setPadding(i3, i16, i17, i18);
    }

    public void setTabIndicatorColor(@ColorInt int i3) {
        this.mIndicatorColor = i3;
        this.mTabPaint.setColor(i3);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i3) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i3));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i3) {
        int i16 = this.mMinTextSpacing;
        if (i3 < i16) {
            i3 = i16;
        }
        super.setTextSpacing(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void updateTextPositions(int i3, float f16, boolean z16) {
        Rect rect = this.mTempRect;
        int height = getHeight();
        int left = this.mCurrText.getLeft() - this.mTabPadding;
        int right = this.mCurrText.getRight() + this.mTabPadding;
        int i16 = height - this.mIndicatorHeight;
        rect.set(left, i16, right, height);
        super.updateTextPositions(i3, f16, z16);
        this.mTabAlpha = (int) (Math.abs(f16 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.mCurrText.getLeft() - this.mTabPadding, i16, this.mCurrText.getRight() + this.mTabPadding, height);
        invalidate(rect);
    }

    public PagerTabStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.mTabPaint = paint;
        this.mTempRect = new Rect();
        this.mTabAlpha = 255;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        int i3 = this.mTextColor;
        this.mIndicatorColor = i3;
        paint.setColor(i3);
        float f16 = context.getResources().getDisplayMetrics().density;
        this.mIndicatorHeight = (int) ((3.0f * f16) + 0.5f);
        this.mMinPaddingBottom = (int) ((6.0f * f16) + 0.5f);
        this.mMinTextSpacing = (int) (64.0f * f16);
        this.mTabPadding = (int) ((16.0f * f16) + 0.5f);
        this.mFullUnderlineHeight = (int) ((1.0f * f16) + 0.5f);
        this.mMinStripHeight = (int) ((f16 * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.mPrevText.setFocusable(true);
        this.mPrevText.setOnClickListener(new View.OnClickListener() { // from class: androidx.viewpager.widget.PagerTabStrip.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                PagerTabStrip.this.mPager.setCurrentItem(r0.getCurrentItem() - 1);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.mNextText.setFocusable(true);
        this.mNextText.setOnClickListener(new View.OnClickListener() { // from class: androidx.viewpager.widget.PagerTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                ViewPager viewPager = PagerTabStrip.this.mPager;
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        if (getBackground() == null) {
            this.mDrawFullUnderline = true;
        }
    }
}
