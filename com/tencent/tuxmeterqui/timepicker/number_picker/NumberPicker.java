package com.tencent.tuxmeterqui.timepicker.number_picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmeterqui.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: classes27.dex */
public class NumberPicker extends LinearLayout {
    static IPatchRedirector $redirector_ = null;
    public static final int ASCENDING = 0;
    public static final int CENTER = 1;
    private static final int DEFAULT_DIVIDER_COLOR = -16777216;
    private static final float DEFAULT_FADING_EDGE_STRENGTH = 0.9f;
    private static final float DEFAULT_LINE_SPACING_MULTIPLIER = 1.0f;
    private static final long DEFAULT_LONG_PRESS_UPDATE_INTERVAL = 300;
    private static final int DEFAULT_MAX_FLING_VELOCITY_COEFFICIENT = 8;
    private static final int DEFAULT_MAX_HEIGHT = 210;
    private static final int DEFAULT_MAX_VALUE = 100;
    private static final int DEFAULT_MIN_VALUE = 1;
    private static final int DEFAULT_MIN_WIDTH = 62;
    private static final int DEFAULT_SMALL_WHEEL_ITEM_COUNT = 3;
    private static final int DEFAULT_TEXT_ALIGN = 1;
    private static final int DEFAULT_TEXT_COLOR = -16777216;
    private static final float DEFAULT_TEXT_SIZE = 13.0f;
    private static final int DEFAULT_WHEEL_ITEM_COUNT = 5;
    public static final int DESCENDING = 1;
    public static final int HORIZONTAL = 0;
    public static final int LEFT = 2;
    public static final int RIGHT = 0;
    private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 800;
    public static final int SIDE_LINES = 0;
    private static final int SIZE_UNSPECIFIED = -1;
    private static final int SNAP_SCROLL_DURATION = 300;
    public static final int UNDERLINE = 1;
    private static final int UNSCALED_DEFAULT_DIVIDER_DISTANCE = 48;
    private static final int UNSCALED_DEFAULT_DIVIDER_THICKNESS = 1;
    public static final int VERTICAL = 1;
    private int defaultMinWidth;
    private String label;
    private boolean mAccessibilityDescriptionEnabled;
    private final Scroller mAdjustScroller;
    private int mBottomDividerBottom;
    private ChangeCurrentByOneFromLongPressCommand mChangeCurrentByOneFromLongPressCommand;
    private final boolean mComputeMaxWidth;
    private Context mContext;
    private int mCurrentScrollOffset;
    private String[] mDisplayedValues;
    private int mDividerColor;
    private int mDividerDistance;
    private Drawable mDividerDrawable;
    private int mDividerLength;
    private int mDividerThickness;
    private int mDividerType;
    private boolean mFadingEdgeEnabled;
    private float mFadingEdgeStrength;
    private final Scroller mFlingScroller;
    private Formatter mFormatter;
    private boolean mHideWheelUntilFocused;
    private int mInitialScrollOffset;
    private int mItemSpacing;
    private float mLastDownEventX;
    private float mLastDownEventY;
    private float mLastDownOrMoveEventX;
    private float mLastDownOrMoveEventY;
    private int mLastHandledDownDpadKeyCode;
    private int mLeftDividerLeft;
    private float mLineSpacingMultiplier;
    private long mLongPressUpdateInterval;
    private int mMaxFlingVelocityCoefficient;
    private int mMaxHeight;
    private int mMaxValue;
    private int mMaxWidth;
    private int mMaximumFlingVelocity;
    private int mMinHeight;
    private int mMinValue;
    private int mMinWidth;
    private int mMinimumFlingVelocity;
    private NumberFormat mNumberFormatter;
    private View.OnClickListener mOnClickListener;
    private OnScrollListener mOnScrollListener;
    private OnValueChangeListener mOnValueChangeListener;
    private int mOrder;
    private int mOrientation;
    private int mPreviousScrollerX;
    private int mPreviousScrollerY;
    private int mRealWheelItemCount;
    private int mRightDividerRight;
    private int mScrollState;
    private boolean mScrollerEnabled;
    private final EditText mSelectedText;
    private int mSelectedTextAlign;
    private float mSelectedTextCenterX;
    private float mSelectedTextCenterY;
    private int mSelectedTextColor;
    private float mSelectedTextSize;
    private boolean mSelectedTextStrikeThru;
    private boolean mSelectedTextUnderline;
    private Typeface mSelectedTypeface;
    private int mSelectorElementSize;
    private final SparseArray<String> mSelectorIndexToStringCache;
    private int[] mSelectorIndices;
    private int mSelectorTextGapHeight;
    private int mSelectorTextGapWidth;
    private final Paint mSelectorWheelPaint;
    private int mTextAlign;
    private int mTextColor;
    private int mTextHideColor;
    private float mTextSize;
    private boolean mTextStrikeThru;
    private boolean mTextUnderline;
    private int mTopDividerTop;
    private int mTouchSlop;
    private Typeface mTypeface;
    private int mValue;
    private VelocityTracker mVelocityTracker;
    private ViewConfiguration mViewConfiguration;
    private int mWheelItemCount;
    private int mWheelMiddleItemIndex;
    private boolean mWrapSelectorWheel;
    private boolean mWrapSelectorWheelPreferred;
    private boolean selectedTextBold;
    private boolean textBold;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes27.dex */
    public @interface Align {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public class ChangeCurrentByOneFromLongPressCommand implements Runnable {
        static IPatchRedirector $redirector_;
        private boolean mIncrement;

        ChangeCurrentByOneFromLongPressCommand() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NumberPicker.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStep(boolean z16) {
            this.mIncrement = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                NumberPicker.this.changeValueByOne(this.mIncrement);
                NumberPicker numberPicker = NumberPicker.this;
                numberPicker.postDelayed(this, numberPicker.mLongPressUpdateInterval);
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes27.dex */
    public @interface DividerType {
    }

    /* loaded from: classes27.dex */
    public interface Formatter {
        String format(int i3);
    }

    /* loaded from: classes27.dex */
    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes27.dex */
        public @interface ScrollState {
        }

        void onScrollStateChange(NumberPicker numberPicker, int i3);
    }

    /* loaded from: classes27.dex */
    public interface OnValueChangeListener {
        void onValueChange(NumberPicker numberPicker, int i3, int i16);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes27.dex */
    public @interface Order {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes27.dex */
    public @interface Orientation {
    }

    public NumberPicker(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeValueByOne(boolean z16) {
        if (!moveToFinalScrollerPosition(this.mFlingScroller)) {
            moveToFinalScrollerPosition(this.mAdjustScroller);
        }
        smoothScroll(z16, 1);
    }

    private int computeScrollExtent(boolean z16) {
        if (z16) {
            return getWidth();
        }
        return getHeight();
    }

    private int computeScrollOffset(boolean z16) {
        if (z16) {
            return this.mCurrentScrollOffset;
        }
        return 0;
    }

    private int computeScrollRange(boolean z16) {
        if (z16) {
            return ((this.mMaxValue - this.mMinValue) + 1) * this.mSelectorElementSize;
        }
        return 0;
    }

    private void decrementSelectorIndices(int[] iArr) {
        for (int length = iArr.length - 1; length > 0; length--) {
            iArr[length] = iArr[length - 1];
        }
        int i3 = iArr[1] - 1;
        if (this.mWrapSelectorWheel && i3 < this.mMinValue) {
            i3 = this.mMaxValue;
        }
        iArr[0] = i3;
        ensureCachedScrollSelectorValue(i3);
    }

    private float dpToPx(float f16) {
        return f16 * getResources().getDisplayMetrics().density;
    }

    private void drawHorizontalDividers(Canvas canvas) {
        int bottom;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26 = this.mDividerType;
        if (i26 != 0) {
            if (i26 == 1) {
                int i27 = this.mDividerLength;
                if (i27 > 0 && i27 <= (i19 = this.mMaxWidth)) {
                    i17 = (i19 - i27) / 2;
                    i18 = i27 + i17;
                } else {
                    i17 = this.mLeftDividerLeft;
                    i18 = this.mRightDividerRight;
                }
                int i28 = this.mBottomDividerBottom;
                this.mDividerDrawable.setBounds(i17, i28 - this.mDividerThickness, i18, i28);
                this.mDividerDrawable.draw(canvas);
                return;
            }
            return;
        }
        int i29 = this.mDividerLength;
        if (i29 > 0 && i29 <= (i16 = this.mMaxHeight)) {
            i3 = (i16 - i29) / 2;
            bottom = i29 + i3;
        } else {
            bottom = getBottom();
            i3 = 0;
        }
        int i36 = this.mLeftDividerLeft;
        this.mDividerDrawable.setBounds(i36, i3, this.mDividerThickness + i36, bottom);
        this.mDividerDrawable.draw(canvas);
        int i37 = this.mRightDividerRight;
        this.mDividerDrawable.setBounds(i37 - this.mDividerThickness, i3, i37, bottom);
        this.mDividerDrawable.draw(canvas);
    }

    private void drawText(String str, float f16, float f17, Paint paint, Canvas canvas) {
        if (str.contains("\n")) {
            String[] split = str.split("\n");
            float abs = Math.abs(paint.descent() + paint.ascent()) * this.mLineSpacingMultiplier;
            float length = f17 - (((split.length - 1) * abs) / 2.0f);
            for (String str2 : split) {
                canvas.drawText(str2, f16, length, paint);
                length += abs;
            }
            return;
        }
        canvas.drawText(str, f16, f17, paint);
    }

    private void drawVerticalDividers(Canvas canvas) {
        int right;
        int i3;
        int i16;
        int i17 = this.mDividerLength;
        if (i17 > 0 && i17 <= (i16 = this.mMaxWidth)) {
            i3 = (i16 - i17) / 2;
            right = i17 + i3;
        } else {
            right = getRight();
            i3 = 0;
        }
        int i18 = this.mDividerType;
        if (i18 != 0) {
            if (i18 == 1) {
                int i19 = this.mBottomDividerBottom;
                this.mDividerDrawable.setBounds(i3, i19 - this.mDividerThickness, right, i19);
                this.mDividerDrawable.draw(canvas);
                return;
            }
            return;
        }
        int i26 = this.mTopDividerTop;
        this.mDividerDrawable.setBounds(i3, i26, right, this.mDividerThickness + i26);
        this.mDividerDrawable.draw(canvas);
        int i27 = this.mBottomDividerBottom;
        this.mDividerDrawable.setBounds(i3, i27 - this.mDividerThickness, right, i27);
        this.mDividerDrawable.draw(canvas);
    }

    private void ensureCachedScrollSelectorValue(int i3) {
        String str;
        SparseArray<String> sparseArray = this.mSelectorIndexToStringCache;
        if (sparseArray.get(i3) != null) {
            return;
        }
        int i16 = this.mMinValue;
        if (i3 >= i16 && i3 <= this.mMaxValue) {
            String[] strArr = this.mDisplayedValues;
            if (strArr != null) {
                int i17 = i3 - i16;
                if (i17 >= strArr.length) {
                    sparseArray.remove(i3);
                    return;
                }
                str = strArr[i17];
            } else {
                str = formatNumber(i3);
            }
        } else {
            str = "";
        }
        sparseArray.put(i3, str);
    }

    private void ensureScrollWheelAdjusted() {
        int i3 = this.mInitialScrollOffset - this.mCurrentScrollOffset;
        if (i3 == 0) {
            return;
        }
        int abs = Math.abs(i3);
        int i16 = this.mSelectorElementSize;
        if (abs > i16 / 2) {
            if (i3 > 0) {
                i16 = -i16;
            }
            i3 += i16;
        }
        int i17 = i3;
        if (isHorizontalMode()) {
            this.mPreviousScrollerX = 0;
            this.mAdjustScroller.startScroll(0, 0, i17, 0, 800);
        } else {
            this.mPreviousScrollerY = 0;
            this.mAdjustScroller.startScroll(0, 0, 0, i17, 800);
        }
        invalidate();
    }

    private void fling(int i3) {
        if (isHorizontalMode()) {
            this.mPreviousScrollerX = 0;
            if (i3 > 0) {
                this.mFlingScroller.fling(0, 0, i3, 0, 0, Integer.MAX_VALUE, 0, 0);
            } else {
                this.mFlingScroller.fling(Integer.MAX_VALUE, 0, i3, 0, 0, Integer.MAX_VALUE, 0, 0);
            }
        } else {
            this.mPreviousScrollerY = 0;
            if (i3 > 0) {
                this.mFlingScroller.fling(0, 0, 0, i3, 0, 0, 0, Integer.MAX_VALUE);
            } else {
                this.mFlingScroller.fling(0, Integer.MAX_VALUE, 0, i3, 0, 0, 0, Integer.MAX_VALUE);
            }
        }
        invalidate();
    }

    private String formatNumber(int i3) {
        Formatter formatter = this.mFormatter;
        if (formatter != null) {
            return formatter.format(i3);
        }
        return formatNumberWithLocale(i3);
    }

    private String formatNumberWithLocale(int i3) {
        return i3 + "";
    }

    private float getFadingEdgeStrength(boolean z16) {
        if (z16 && this.mFadingEdgeEnabled) {
            return this.mFadingEdgeStrength;
        }
        return 0.0f;
    }

    private float getMaxTextSize() {
        return Math.max(this.mTextSize, this.mSelectedTextSize);
    }

    private float getPaintCenterY(Paint.FontMetrics fontMetrics) {
        if (fontMetrics == null) {
            return 0.0f;
        }
        return Math.abs(fontMetrics.top + fontMetrics.bottom) / 2.0f;
    }

    private int[] getSelectorIndices() {
        return this.mSelectorIndices;
    }

    private int getWrappedSelectorIndex(int i3) {
        int i16 = this.mMaxValue;
        if (i3 > i16) {
            int i17 = this.mMinValue;
            return (i17 + ((i3 - i16) % (i16 - i17))) - 1;
        }
        int i18 = this.mMinValue;
        if (i3 < i18) {
            return (i16 - ((i18 - i3) % (i16 - i18))) + 1;
        }
        return i3;
    }

    private void incrementSelectorIndices(int[] iArr) {
        int i3 = 0;
        while (i3 < iArr.length - 1) {
            int i16 = i3 + 1;
            iArr[i3] = iArr[i16];
            i3 = i16;
        }
        int i17 = iArr[iArr.length - 2] + 1;
        if (this.mWrapSelectorWheel && i17 > this.mMaxValue) {
            i17 = this.mMinValue;
        }
        iArr[iArr.length - 1] = i17;
        ensureCachedScrollSelectorValue(i17);
    }

    private void initializeFadingEdges() {
        if (isHorizontalMode()) {
            setHorizontalFadingEdgeEnabled(true);
            setVerticalFadingEdgeEnabled(false);
            setFadingEdgeLength(((getRight() - getLeft()) - ((int) this.mTextSize)) / 2);
        } else {
            setHorizontalFadingEdgeEnabled(false);
            setVerticalFadingEdgeEnabled(true);
            setFadingEdgeLength(((getBottom() - getTop()) - ((int) this.mTextSize)) / 2);
        }
    }

    private void initializeSelectorWheel() {
        initializeSelectorWheelIndices();
        int[] selectorIndices = getSelectorIndices();
        int length = (int) (((selectorIndices.length - 1) * this.mTextSize) + this.mSelectedTextSize);
        float length2 = selectorIndices.length;
        if (isHorizontalMode()) {
            this.mSelectorTextGapWidth = (int) (((getRight() - getLeft()) - length) / length2);
            this.mSelectorElementSize = ((int) getMaxTextSize()) + this.mSelectorTextGapWidth;
            this.mInitialScrollOffset = (int) (this.mSelectedTextCenterX - (r0 * this.mWheelMiddleItemIndex));
        } else {
            this.mSelectorTextGapHeight = (int) (((getBottom() - getTop()) - length) / length2);
            this.mSelectorElementSize = ((int) getMaxTextSize()) + this.mSelectorTextGapHeight;
            this.mInitialScrollOffset = (int) (this.mSelectedTextCenterY - (r0 * this.mWheelMiddleItemIndex));
        }
        this.mCurrentScrollOffset = this.mInitialScrollOffset;
        updateInputTextView();
    }

    private void initializeSelectorWheelIndices() {
        this.mSelectorIndexToStringCache.clear();
        int[] selectorIndices = getSelectorIndices();
        int value = getValue();
        for (int i3 = 0; i3 < selectorIndices.length; i3++) {
            int i16 = (i3 - this.mWheelMiddleItemIndex) + value;
            if (this.mWrapSelectorWheel) {
                i16 = getWrappedSelectorIndex(i16);
            }
            selectorIndices[i3] = i16;
            ensureCachedScrollSelectorValue(i16);
        }
    }

    private boolean isWrappingAllowed() {
        if (this.mMaxValue - this.mMinValue >= this.mSelectorIndices.length - 1) {
            return true;
        }
        return false;
    }

    private int makeMeasureSpec(int i3, int i16) {
        if (i16 == -1) {
            return i3;
        }
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    return i3;
                }
                throw new IllegalArgumentException("Unknown measure mode: " + mode);
            }
            return View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i16), 1073741824);
    }

    private boolean moveToFinalScrollerPosition(Scroller scroller) {
        scroller.forceFinished(true);
        if (isHorizontalMode()) {
            int finalX = scroller.getFinalX() - scroller.getCurrX();
            int i3 = this.mInitialScrollOffset - ((this.mCurrentScrollOffset + finalX) % this.mSelectorElementSize);
            if (i3 != 0) {
                int abs = Math.abs(i3);
                int i16 = this.mSelectorElementSize;
                if (abs > i16 / 2) {
                    if (i3 > 0) {
                        i3 -= i16;
                    } else {
                        i3 += i16;
                    }
                }
                scrollBy(finalX + i3, 0);
                return true;
            }
        } else {
            int finalY = scroller.getFinalY() - scroller.getCurrY();
            int i17 = this.mInitialScrollOffset - ((this.mCurrentScrollOffset + finalY) % this.mSelectorElementSize);
            if (i17 != 0) {
                int abs2 = Math.abs(i17);
                int i18 = this.mSelectorElementSize;
                if (abs2 > i18 / 2) {
                    if (i17 > 0) {
                        i17 -= i18;
                    } else {
                        i17 += i18;
                    }
                }
                scrollBy(0, finalY + i17);
                return true;
            }
        }
        return false;
    }

    private void notifyChange(int i3, int i16) {
        OnValueChangeListener onValueChangeListener = this.mOnValueChangeListener;
        if (onValueChangeListener != null) {
            onValueChangeListener.onValueChange(this, i3, i16);
        }
    }

    private void onScrollStateChange(int i3) {
        if (this.mScrollState == i3) {
            return;
        }
        this.mScrollState = i3;
        OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChange(this, i3);
        }
    }

    private void onScrollerFinished(Scroller scroller) {
        if (scroller == this.mFlingScroller) {
            ensureScrollWheelAdjusted();
            updateInputTextView();
            onScrollStateChange(0);
        } else if (this.mScrollState != 1) {
            updateInputTextView();
        }
    }

    private void postChangeCurrentByOneFromLongPress(boolean z16, long j3) {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand == null) {
            this.mChangeCurrentByOneFromLongPressCommand = new ChangeCurrentByOneFromLongPressCommand();
        } else {
            removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
        this.mChangeCurrentByOneFromLongPressCommand.setStep(z16);
        postDelayed(this.mChangeCurrentByOneFromLongPressCommand, j3);
    }

    private float pxToDp(float f16) {
        return f16 / getResources().getDisplayMetrics().density;
    }

    private float pxToSp(float f16) {
        return f16 / getResources().getDisplayMetrics().scaledDensity;
    }

    private void removeAllCallbacks() {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand != null) {
            removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
    }

    private void removeChangeCurrentByOneFromLongPress() {
        ChangeCurrentByOneFromLongPressCommand changeCurrentByOneFromLongPressCommand = this.mChangeCurrentByOneFromLongPressCommand;
        if (changeCurrentByOneFromLongPressCommand != null) {
            removeCallbacks(changeCurrentByOneFromLongPressCommand);
        }
    }

    public static int resolveSizeAndState(int i3, int i16, int i17) {
        int mode = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i16);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 1073741824) {
                i3 = size;
            }
        } else if (size < i3) {
            i3 = 16777216 | size;
        }
        return i3 | ((-16777216) & i17);
    }

    private int resolveSizeAndStateRespectingMinSize(int i3, int i16, int i17) {
        if (i3 != -1) {
            return resolveSizeAndState(Math.max(i3, i16), i17, 0);
        }
        return i16;
    }

    private void setValueInternal(int i3, boolean z16) {
        int min;
        if (this.mValue == i3) {
            return;
        }
        if (this.mWrapSelectorWheel) {
            min = getWrappedSelectorIndex(i3);
        } else {
            min = Math.min(Math.max(i3, this.mMinValue), this.mMaxValue);
        }
        int i16 = this.mValue;
        this.mValue = min;
        if (this.mScrollState != 2) {
            updateInputTextView();
        }
        if (z16) {
            notifyChange(i16, min);
        }
        initializeSelectorWheelIndices();
        updateAccessibilityDescription();
        invalidate();
    }

    private void setWidthAndHeight() {
        if (isHorizontalMode()) {
            this.mMinHeight = -1;
            this.mMaxHeight = (int) dpToPx(this.defaultMinWidth);
            this.mMinWidth = (int) dpToPx(210.0f);
            this.mMaxWidth = -1;
            return;
        }
        this.mMinHeight = -1;
        this.mMaxHeight = (int) dpToPx(210.0f);
        this.mMinWidth = (int) dpToPx(this.defaultMinWidth);
        this.mMaxWidth = -1;
    }

    private float spToPx(float f16) {
        return TypedValue.applyDimension(2, f16, getResources().getDisplayMetrics());
    }

    private Formatter stringToFormatter(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new Formatter(str) { // from class: com.tencent.tuxmeterqui.timepicker.number_picker.NumberPicker.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$formatter;

            {
                this.val$formatter = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NumberPicker.this, (Object) str);
                }
            }

            @Override // com.tencent.tuxmeterqui.timepicker.number_picker.NumberPicker.Formatter
            public String format(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3);
                }
                return String.format(Locale.getDefault(), this.val$formatter, Integer.valueOf(i3));
            }
        };
    }

    private void tryComputeMaxWidth() {
        int i3;
        if (!this.mComputeMaxWidth) {
            return;
        }
        this.mSelectorWheelPaint.setTextSize(getMaxTextSize());
        String[] strArr = this.mDisplayedValues;
        int i16 = 0;
        if (strArr == null) {
            float f16 = 0.0f;
            for (int i17 = 0; i17 <= 9; i17++) {
                float measureText = this.mSelectorWheelPaint.measureText(formatNumber(i17));
                if (measureText > f16) {
                    f16 = measureText;
                }
            }
            for (int i18 = this.mMaxValue; i18 > 0; i18 /= 10) {
                i16++;
            }
            i3 = (int) (i16 * f16);
        } else {
            int length = strArr.length;
            int i19 = 0;
            while (i16 < length) {
                float measureText2 = this.mSelectorWheelPaint.measureText(strArr[i16]);
                if (measureText2 > i19) {
                    i19 = (int) measureText2;
                }
                i16++;
            }
            i3 = i19;
        }
        int paddingLeft = i3 + this.mSelectedText.getPaddingLeft() + this.mSelectedText.getPaddingRight();
        if (this.mMaxWidth != paddingLeft) {
            this.mMaxWidth = Math.max(paddingLeft, this.mMinWidth);
            invalidate();
        }
    }

    private void updateAccessibilityDescription() {
        if (!this.mAccessibilityDescriptionEnabled) {
            return;
        }
        setContentDescription(String.valueOf(getValue()));
    }

    private void updateInputTextView() {
        String str;
        String[] strArr = this.mDisplayedValues;
        if (strArr == null) {
            str = formatNumber(this.mValue);
        } else {
            str = strArr[this.mValue - this.mMinValue];
        }
        if (TextUtils.isEmpty(str) || str.equals(this.mSelectedText.getText().toString())) {
            return;
        }
        this.mSelectedText.setText(str + this.label);
    }

    private void updateWrapSelectorWheel() {
        boolean z16;
        if (isWrappingAllowed() && this.mWrapSelectorWheelPreferred) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mWrapSelectorWheel = z16;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return computeScrollExtent(isHorizontalMode());
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return computeScrollOffset(isHorizontalMode());
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return computeScrollRange(isHorizontalMode());
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (!isScrollerEnabled()) {
            return;
        }
        Scroller scroller = this.mFlingScroller;
        if (scroller.isFinished()) {
            scroller = this.mAdjustScroller;
            if (scroller.isFinished()) {
                return;
            }
        }
        scroller.computeScrollOffset();
        if (isHorizontalMode()) {
            int currX = scroller.getCurrX();
            if (this.mPreviousScrollerX == 0) {
                this.mPreviousScrollerX = scroller.getStartX();
            }
            scrollBy(currX - this.mPreviousScrollerX, 0);
            this.mPreviousScrollerX = currX;
        } else {
            int currY = scroller.getCurrY();
            if (this.mPreviousScrollerY == 0) {
                this.mPreviousScrollerY = scroller.getStartY();
            }
            scrollBy(0, currY - this.mPreviousScrollerY);
            this.mPreviousScrollerY = currY;
        }
        if (scroller.isFinished()) {
            onScrollerFinished(scroller);
        } else {
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected int computeVerticalScrollExtent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return computeScrollExtent(isHorizontalMode());
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return computeScrollOffset(!isHorizontalMode());
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return computeScrollRange(!isHorizontalMode());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) keyEvent)).booleanValue();
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 19 && keyCode != 20) {
            if (keyCode == 23 || keyCode == 66) {
                removeAllCallbacks();
            }
        } else {
            int action = keyEvent.getAction();
            if (action != 0) {
                if (action == 1 && this.mLastHandledDownDpadKeyCode == keyCode) {
                    this.mLastHandledDownDpadKeyCode = -1;
                    return true;
                }
            } else {
                if (!this.mWrapSelectorWheel) {
                    if (keyCode == 20) {
                    }
                }
                requestFocus();
                this.mLastHandledDownDpadKeyCode = keyCode;
                removeAllCallbacks();
                if (this.mFlingScroller.isFinished()) {
                    if (keyCode == 20) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    changeValueByOne(z16);
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            removeAllCallbacks();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            removeAllCallbacks();
        }
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    @CallSuper
    protected void drawableStateChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        super.drawableStateChanged();
        Drawable drawable = this.mDividerDrawable;
        if (drawable != null && drawable.isStateful() && this.mDividerDrawable.setState(getDrawableState())) {
            invalidateDrawable(this.mDividerDrawable);
        }
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Float) iPatchRedirector.redirect((short) 37, (Object) this)).floatValue();
        }
        return getFadingEdgeStrength(!isHorizontalMode());
    }

    public String[] getDisplayedValues() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String[]) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.mDisplayedValues;
    }

    public int getDividerColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            return ((Integer) iPatchRedirector.redirect((short) 94, (Object) this)).intValue();
        }
        return this.mDividerColor;
    }

    public float getDividerDistance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            return ((Float) iPatchRedirector.redirect((short) 95, (Object) this)).floatValue();
        }
        return pxToDp(this.mDividerDistance);
    }

    public float getDividerThickness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            return ((Float) iPatchRedirector.redirect((short) 96, (Object) this)).floatValue();
        }
        return pxToDp(this.mDividerThickness);
    }

    public Formatter getFormatter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            return (Formatter) iPatchRedirector.redirect((short) 100, (Object) this);
        }
        return this.mFormatter;
    }

    public String getLabel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 118)) {
            return (String) iPatchRedirector.redirect((short) 118, (Object) this);
        }
        return this.label;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Float) iPatchRedirector.redirect((short) 38, (Object) this)).floatValue();
        }
        return getFadingEdgeStrength(isHorizontalMode());
    }

    public float getLineSpacingMultiplier() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            return ((Float) iPatchRedirector.redirect((short) 115, (Object) this)).floatValue();
        }
        return this.mLineSpacingMultiplier;
    }

    public int getMaxFlingVelocityCoefficient() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 116)) {
            return ((Integer) iPatchRedirector.redirect((short) 116, (Object) this)).intValue();
        }
        return this.mMaxFlingVelocityCoefficient;
    }

    public int getMaxValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return this.mMaxValue;
    }

    public int getMinValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        return this.mMinValue;
    }

    public int getOrder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            return ((Integer) iPatchRedirector.redirect((short) 97, (Object) this)).intValue();
        }
        return this.mOrder;
    }

    @Override // android.widget.LinearLayout
    public int getOrientation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            return ((Integer) iPatchRedirector.redirect((short) 98, (Object) this)).intValue();
        }
        return this.mOrientation;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Float) iPatchRedirector.redirect((short) 39, (Object) this)).floatValue();
        }
        return getFadingEdgeStrength(isHorizontalMode());
    }

    public int getSelectedTextAlign() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            return ((Integer) iPatchRedirector.redirect((short) 104, (Object) this)).intValue();
        }
        return this.mSelectedTextAlign;
    }

    public int getSelectedTextColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            return ((Integer) iPatchRedirector.redirect((short) 105, (Object) this)).intValue();
        }
        return this.mSelectedTextColor;
    }

    public float getSelectedTextSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            return ((Float) iPatchRedirector.redirect((short) 106, (Object) this)).floatValue();
        }
        return this.mSelectedTextSize;
    }

    public boolean getSelectedTextStrikeThru() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            return ((Boolean) iPatchRedirector.redirect((short) 107, (Object) this)).booleanValue();
        }
        return this.mSelectedTextStrikeThru;
    }

    public boolean getSelectedTextUnderline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            return ((Boolean) iPatchRedirector.redirect((short) 108, (Object) this)).booleanValue();
        }
        return this.mSelectedTextUnderline;
    }

    public int getTextAlign() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            return ((Integer) iPatchRedirector.redirect((short) 109, (Object) this)).intValue();
        }
        return this.mTextAlign;
    }

    public int getTextColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
            return ((Integer) iPatchRedirector.redirect((short) 110, (Object) this)).intValue();
        }
        return this.mTextColor;
    }

    public float getTextSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            return ((Float) iPatchRedirector.redirect((short) 111, (Object) this)).floatValue();
        }
        return spToPx(this.mTextSize);
    }

    public boolean getTextStrikeThru() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 112)) {
            return ((Boolean) iPatchRedirector.redirect((short) 112, (Object) this)).booleanValue();
        }
        return this.mTextStrikeThru;
    }

    public boolean getTextUnderline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
            return ((Boolean) iPatchRedirector.redirect((short) 113, (Object) this)).booleanValue();
        }
        return this.mTextUnderline;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Float) iPatchRedirector.redirect((short) 36, (Object) this)).floatValue();
        }
        return getFadingEdgeStrength(!isHorizontalMode());
    }

    public Typeface getTypeface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            return (Typeface) iPatchRedirector.redirect((short) 114, (Object) this);
        }
        return this.mTypeface;
    }

    public int getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return this.mValue;
    }

    public int getWheelItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            return ((Integer) iPatchRedirector.redirect((short) 99, (Object) this)).intValue();
        }
        return this.mWheelItemCount;
    }

    public boolean getWrapSelectorWheel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.mWrapSelectorWheel;
    }

    public boolean isAccessibilityDescriptionEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            return ((Boolean) iPatchRedirector.redirect((short) 93, (Object) this)).booleanValue();
        }
        return this.mAccessibilityDescriptionEnabled;
    }

    public boolean isAscendingOrder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            return ((Boolean) iPatchRedirector.redirect((short) 92, (Object) this)).booleanValue();
        }
        if (getOrder() == 0) {
            return true;
        }
        return false;
    }

    public boolean isFadingEdgeEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            return ((Boolean) iPatchRedirector.redirect((short) 101, (Object) this)).booleanValue();
        }
        return this.mFadingEdgeEnabled;
    }

    public boolean isHorizontalMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            return ((Boolean) iPatchRedirector.redirect((short) 91, (Object) this)).booleanValue();
        }
        if (getOrientation() == 0) {
            return true;
        }
        return false;
    }

    public boolean isScrollerEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            return ((Boolean) iPatchRedirector.redirect((short) 103, (Object) this)).booleanValue();
        }
        return this.mScrollerEnabled;
    }

    public boolean isSelectedTextBold() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 121)) {
            return ((Boolean) iPatchRedirector.redirect((short) 121, (Object) this)).booleanValue();
        }
        return this.selectedTextBold;
    }

    public boolean isTextBold() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 119)) {
            return ((Boolean) iPatchRedirector.redirect((short) 119, (Object) this)).booleanValue();
        }
        return this.textBold;
    }

    @Override // android.view.ViewGroup, android.view.View
    @CallSuper
    public void jumpDrawablesToCurrentState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mDividerDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            this.mNumberFormatter = NumberFormat.getInstance();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
        } else {
            super.onDetachedFromWindow();
            removeAllCallbacks();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z16;
        float right;
        float f16;
        int i3;
        String replace;
        int i16;
        float f17;
        int i17;
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) canvas);
            return;
        }
        canvas.save();
        if (this.mHideWheelUntilFocused && !hasFocus()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (isHorizontalMode()) {
            right = this.mCurrentScrollOffset;
            f16 = this.mSelectedText.getBaseline() + this.mSelectedText.getTop();
            if (this.mRealWheelItemCount < 5) {
                canvas.clipRect(this.mLeftDividerLeft, 0, this.mRightDividerRight, getBottom());
            }
        } else {
            right = (getRight() - getLeft()) / 2.0f;
            f16 = this.mCurrentScrollOffset;
            if (this.mRealWheelItemCount < 5) {
                canvas.clipRect(0, this.mTopDividerTop, getRight(), this.mBottomDividerBottom);
            }
        }
        int[] selectorIndices = getSelectorIndices();
        int length = selectorIndices.length;
        float f18 = right;
        float f19 = f16;
        for (int i26 = 0; i26 < length; i26++) {
            if (isAscendingOrder()) {
                i3 = i26;
            } else {
                i3 = (length - i26) - 1;
            }
            String str = this.mSelectorIndexToStringCache.get(selectorIndices[i3]);
            if (i26 == this.mWheelMiddleItemIndex) {
                this.mSelectorWheelPaint.setTextAlign(Paint.Align.values()[this.mSelectedTextAlign]);
                this.mSelectorWheelPaint.setTextSize(spToPx(DEFAULT_TEXT_SIZE));
                this.mSelectorWheelPaint.setColor(this.mSelectedTextColor);
                this.mSelectorWheelPaint.setFakeBoldText(this.selectedTextBold);
                this.mSelectorWheelPaint.setStrikeThruText(this.mSelectedTextStrikeThru);
                this.mSelectorWheelPaint.setUnderlineText(this.mSelectedTextUnderline);
                this.mSelectorWheelPaint.setTypeface(this.mSelectedTypeface);
                replace = str + this.label;
            } else {
                this.mSelectorWheelPaint.setTextAlign(Paint.Align.values()[this.mTextAlign]);
                this.mSelectorWheelPaint.setTextSize(spToPx(12.0f));
                int i27 = this.mTextColor;
                if (length > 3 && length % 2 == 1 && (i26 < (i16 = (length - 3) / 2) || i26 >= i16 + 3)) {
                    i27 = this.mTextHideColor;
                }
                this.mSelectorWheelPaint.setColor(i27);
                this.mSelectorWheelPaint.setFakeBoldText(this.textBold);
                this.mSelectorWheelPaint.setStrikeThruText(this.mTextStrikeThru);
                this.mSelectorWheelPaint.setUnderlineText(this.mTextUnderline);
                this.mSelectorWheelPaint.setTypeface(this.mTypeface);
                replace = str.replace(this.label, "");
            }
            String str2 = replace;
            if (str2 != null) {
                if ((z16 && i26 != this.mWheelMiddleItemIndex) || (i26 == this.mWheelMiddleItemIndex && this.mSelectedText.getVisibility() != 0)) {
                    if (!isHorizontalMode()) {
                        f17 = getPaintCenterY(this.mSelectorWheelPaint.getFontMetrics()) + f19;
                    } else {
                        f17 = f19;
                    }
                    if (i26 != this.mWheelMiddleItemIndex && this.mItemSpacing != 0) {
                        if (isHorizontalMode()) {
                            if (i26 > this.mWheelMiddleItemIndex) {
                                i17 = this.mItemSpacing;
                            } else {
                                i17 = -this.mItemSpacing;
                            }
                            i18 = 0;
                        } else {
                            if (i26 > this.mWheelMiddleItemIndex) {
                                i19 = this.mItemSpacing;
                            } else {
                                i19 = -this.mItemSpacing;
                            }
                            i18 = i19;
                            i17 = 0;
                        }
                    } else {
                        i17 = 0;
                        i18 = 0;
                    }
                    drawText(str2, i17 + f18, i18 + f17, this.mSelectorWheelPaint, canvas);
                }
                if (isHorizontalMode()) {
                    f18 += this.mSelectorElementSize;
                } else {
                    f19 += this.mSelectorElementSize;
                }
            }
        }
        canvas.restore();
        if (z16 && this.mDividerDrawable != null) {
            if (isHorizontalMode()) {
                drawHorizontalDividers(canvas);
            } else {
                drawVerticalDividers(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) accessibilityEvent);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(NumberPicker.class.getName());
        accessibilityEvent.setScrollable(isScrollerEnabled());
        int i3 = this.mMinValue;
        int i16 = this.mValue + i3;
        int i17 = this.mSelectorElementSize;
        int i18 = i16 * i17;
        int i19 = (this.mMaxValue - i3) * i17;
        if (isHorizontalMode()) {
            accessibilityEvent.setScrollX(i18);
            accessibilityEvent.setMaxScrollX(i19);
        } else {
            accessibilityEvent.setScrollY(i18);
            accessibilityEvent.setMaxScrollY(i19);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!isEnabled() || (motionEvent.getAction() & 255) != 0) {
            return false;
        }
        removeAllCallbacks();
        getParent().requestDisallowInterceptTouchEvent(true);
        if (isHorizontalMode()) {
            float x16 = motionEvent.getX();
            this.mLastDownEventX = x16;
            this.mLastDownOrMoveEventX = x16;
            if (!this.mFlingScroller.isFinished()) {
                this.mFlingScroller.forceFinished(true);
                this.mAdjustScroller.forceFinished(true);
                onScrollerFinished(this.mFlingScroller);
                onScrollStateChange(0);
            } else if (!this.mAdjustScroller.isFinished()) {
                this.mFlingScroller.forceFinished(true);
                this.mAdjustScroller.forceFinished(true);
                onScrollerFinished(this.mAdjustScroller);
            } else {
                float f16 = this.mLastDownEventX;
                int i3 = this.mLeftDividerLeft;
                if (f16 >= i3 && f16 <= this.mRightDividerRight) {
                    View.OnClickListener onClickListener = this.mOnClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(this);
                    }
                } else if (f16 < i3) {
                    postChangeCurrentByOneFromLongPress(false);
                } else if (f16 > this.mRightDividerRight) {
                    postChangeCurrentByOneFromLongPress(true);
                }
            }
        } else {
            float y16 = motionEvent.getY();
            this.mLastDownEventY = y16;
            this.mLastDownOrMoveEventY = y16;
            if (!this.mFlingScroller.isFinished()) {
                this.mFlingScroller.forceFinished(true);
                this.mAdjustScroller.forceFinished(true);
                onScrollStateChange(0);
            } else if (!this.mAdjustScroller.isFinished()) {
                this.mFlingScroller.forceFinished(true);
                this.mAdjustScroller.forceFinished(true);
            } else {
                float f17 = this.mLastDownEventY;
                int i16 = this.mTopDividerTop;
                if (f17 >= i16 && f17 <= this.mBottomDividerBottom) {
                    View.OnClickListener onClickListener2 = this.mOnClickListener;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(this);
                    }
                } else if (f17 < i16) {
                    postChangeCurrentByOneFromLongPress(false);
                } else if (f17 > this.mBottomDividerBottom) {
                    postChangeCurrentByOneFromLongPress(true);
                }
            }
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = this.mSelectedText.getMeasuredWidth();
        int measuredHeight2 = this.mSelectedText.getMeasuredHeight();
        int i19 = (measuredWidth - measuredWidth2) / 2;
        int i26 = (measuredHeight - measuredHeight2) / 2;
        this.mSelectedText.layout(i19, i26, measuredWidth2 + i19, measuredHeight2 + i26);
        this.mSelectedTextCenterX = (this.mSelectedText.getX() + (this.mSelectedText.getMeasuredWidth() / 2.0f)) - 2.0f;
        this.mSelectedTextCenterY = (this.mSelectedText.getY() + (this.mSelectedText.getMeasuredHeight() / 2.0f)) - 5.0f;
        if (z16) {
            initializeSelectorWheel();
            initializeFadingEdges();
            int i27 = (this.mDividerThickness * 2) + this.mDividerDistance;
            if (isHorizontalMode()) {
                int width = ((getWidth() - this.mDividerDistance) / 2) - this.mDividerThickness;
                this.mLeftDividerLeft = width;
                this.mRightDividerRight = width + i27;
                this.mBottomDividerBottom = getHeight();
                return;
            }
            int height = ((getHeight() - this.mDividerDistance) / 2) - this.mDividerThickness;
            this.mTopDividerTop = height;
            this.mBottomDividerBottom = height + i27;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(makeMeasureSpec(i3, this.mMaxWidth), makeMeasureSpec(i16, this.mMaxHeight));
            setMeasuredDimension(resolveSizeAndStateRespectingMinSize(this.mMinWidth, getMeasuredWidth(), i3), resolveSizeAndStateRespectingMinSize(this.mMinHeight, getMeasuredHeight(), i16));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!isEnabled() || !isScrollerEnabled()) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 1) {
            if (action == 2) {
                if (isHorizontalMode()) {
                    float x16 = motionEvent.getX();
                    if (this.mScrollState != 1) {
                        if (((int) Math.abs(x16 - this.mLastDownEventX)) > this.mTouchSlop) {
                            removeAllCallbacks();
                            onScrollStateChange(1);
                        }
                    } else {
                        scrollBy((int) (x16 - this.mLastDownOrMoveEventX), 0);
                        invalidate();
                    }
                    this.mLastDownOrMoveEventX = x16;
                } else {
                    float y16 = motionEvent.getY();
                    if (this.mScrollState != 1) {
                        if (((int) Math.abs(y16 - this.mLastDownEventY)) > this.mTouchSlop) {
                            removeAllCallbacks();
                            onScrollStateChange(1);
                        }
                    } else {
                        scrollBy(0, (int) (y16 - this.mLastDownOrMoveEventY));
                        invalidate();
                    }
                    this.mLastDownOrMoveEventY = y16;
                }
            }
        } else {
            removeChangeCurrentByOneFromLongPress();
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumFlingVelocity);
            if (isHorizontalMode()) {
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (Math.abs(xVelocity) > this.mMinimumFlingVelocity) {
                    fling(xVelocity);
                    onScrollStateChange(2);
                } else {
                    int x17 = (int) motionEvent.getX();
                    if (((int) Math.abs(x17 - this.mLastDownEventX)) <= this.mTouchSlop) {
                        int i3 = (x17 / this.mSelectorElementSize) - this.mWheelMiddleItemIndex;
                        if (i3 > 0) {
                            changeValueByOne(true);
                        } else if (i3 < 0) {
                            changeValueByOne(false);
                        } else {
                            ensureScrollWheelAdjusted();
                        }
                    } else {
                        ensureScrollWheelAdjusted();
                    }
                    onScrollStateChange(0);
                }
            } else {
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (Math.abs(yVelocity) > this.mMinimumFlingVelocity) {
                    fling(yVelocity);
                    onScrollStateChange(2);
                } else {
                    int y17 = (int) motionEvent.getY();
                    if (((int) Math.abs(y17 - this.mLastDownEventY)) <= this.mTouchSlop) {
                        int i16 = (y17 / this.mSelectorElementSize) - this.mWheelMiddleItemIndex;
                        if (i16 > 0) {
                            changeValueByOne(true);
                        } else if (i16 < 0) {
                            changeValueByOne(false);
                        } else {
                            ensureScrollWheelAdjusted();
                        }
                    } else {
                        ensureScrollWheelAdjusted();
                    }
                    onScrollStateChange(0);
                }
            }
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        return true;
    }

    @Override // android.view.View
    public void scrollBy(int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (!isScrollerEnabled()) {
            return;
        }
        int[] selectorIndices = getSelectorIndices();
        int i18 = this.mCurrentScrollOffset;
        int maxTextSize = (int) getMaxTextSize();
        if (isHorizontalMode()) {
            if (isAscendingOrder()) {
                boolean z16 = this.mWrapSelectorWheel;
                if (!z16 && i3 > 0 && selectorIndices[this.mWheelMiddleItemIndex] <= this.mMinValue) {
                    this.mCurrentScrollOffset = this.mInitialScrollOffset;
                    return;
                } else if (!z16 && i3 < 0 && selectorIndices[this.mWheelMiddleItemIndex] >= this.mMaxValue) {
                    this.mCurrentScrollOffset = this.mInitialScrollOffset;
                    return;
                }
            } else {
                boolean z17 = this.mWrapSelectorWheel;
                if (!z17 && i3 > 0 && selectorIndices[this.mWheelMiddleItemIndex] >= this.mMaxValue) {
                    this.mCurrentScrollOffset = this.mInitialScrollOffset;
                    return;
                } else if (!z17 && i3 < 0 && selectorIndices[this.mWheelMiddleItemIndex] <= this.mMinValue) {
                    this.mCurrentScrollOffset = this.mInitialScrollOffset;
                    return;
                }
            }
            this.mCurrentScrollOffset += i3;
        } else {
            if (isAscendingOrder()) {
                boolean z18 = this.mWrapSelectorWheel;
                if (!z18 && i16 > 0 && selectorIndices[this.mWheelMiddleItemIndex] <= this.mMinValue) {
                    this.mCurrentScrollOffset = this.mInitialScrollOffset;
                    return;
                } else if (!z18 && i16 < 0 && selectorIndices[this.mWheelMiddleItemIndex] >= this.mMaxValue) {
                    this.mCurrentScrollOffset = this.mInitialScrollOffset;
                    return;
                }
            } else {
                boolean z19 = this.mWrapSelectorWheel;
                if (!z19 && i16 > 0 && selectorIndices[this.mWheelMiddleItemIndex] >= this.mMaxValue) {
                    this.mCurrentScrollOffset = this.mInitialScrollOffset;
                    return;
                } else if (!z19 && i16 < 0 && selectorIndices[this.mWheelMiddleItemIndex] <= this.mMinValue) {
                    this.mCurrentScrollOffset = this.mInitialScrollOffset;
                    return;
                }
            }
            this.mCurrentScrollOffset += i16;
        }
        while (true) {
            int i19 = this.mCurrentScrollOffset;
            if (i19 - this.mInitialScrollOffset <= maxTextSize) {
                break;
            }
            this.mCurrentScrollOffset = i19 - this.mSelectorElementSize;
            if (isAscendingOrder()) {
                decrementSelectorIndices(selectorIndices);
            } else {
                incrementSelectorIndices(selectorIndices);
            }
            setValueInternal(selectorIndices[this.mWheelMiddleItemIndex], true);
            if (!this.mWrapSelectorWheel && selectorIndices[this.mWheelMiddleItemIndex] < this.mMinValue) {
                this.mCurrentScrollOffset = this.mInitialScrollOffset;
            }
        }
        while (true) {
            i17 = this.mCurrentScrollOffset;
            if (i17 - this.mInitialScrollOffset >= (-maxTextSize)) {
                break;
            }
            this.mCurrentScrollOffset = i17 + this.mSelectorElementSize;
            if (isAscendingOrder()) {
                incrementSelectorIndices(selectorIndices);
            } else {
                decrementSelectorIndices(selectorIndices);
            }
            setValueInternal(selectorIndices[this.mWheelMiddleItemIndex], true);
            if (!this.mWrapSelectorWheel && selectorIndices[this.mWheelMiddleItemIndex] > this.mMaxValue) {
                this.mCurrentScrollOffset = this.mInitialScrollOffset;
            }
        }
        if (i18 != i17) {
            if (isHorizontalMode()) {
                onScrollChanged(this.mCurrentScrollOffset, 0, i18, 0);
            } else {
                onScrollChanged(0, this.mCurrentScrollOffset, 0, i18);
            }
        }
    }

    public void setAccessibilityDescriptionEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, z16);
        } else {
            this.mAccessibilityDescriptionEnabled = z16;
        }
    }

    public void setDefaultMinWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, (Object) this, i3);
        } else {
            this.defaultMinWidth = i3;
            setWidthAndHeight();
        }
    }

    public void setDisplayedValues(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) strArr);
            return;
        }
        if (this.mDisplayedValues == strArr) {
            return;
        }
        this.mDisplayedValues = strArr;
        if (strArr != null) {
            this.mSelectedText.setRawInputType(655360);
        } else {
            this.mSelectedText.setRawInputType(655360);
        }
        updateInputTextView();
        initializeSelectorWheelIndices();
        tryComputeMaxWidth();
    }

    public void setDividerColor(@ColorInt int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, i3);
            return;
        }
        this.mDividerColor = i3;
        this.mDividerDrawable = new ColorDrawable(i3);
        invalidate();
    }

    public void setDividerColorResource(@ColorRes int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, i3);
        } else {
            setDividerColor(ContextCompat.getColor(this.mContext, i3));
        }
    }

    public void setDividerDistance(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, i3);
        } else {
            this.mDividerDistance = i3;
        }
    }

    public void setDividerDistanceResource(@DimenRes int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, i3);
        } else {
            setDividerDistance(getResources().getDimensionPixelSize(i3));
        }
    }

    public void setDividerThickness(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, i3);
        } else {
            this.mDividerThickness = i3;
        }
    }

    public void setDividerThicknessResource(@DimenRes int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, i3);
        } else {
            setDividerThickness(getResources().getDimensionPixelSize(i3));
        }
    }

    public void setDividerType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, i3);
        } else {
            this.mDividerType = i3;
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            super.setEnabled(z16);
            this.mSelectedText.setEnabled(z16);
        }
    }

    public void setFadingEdgeEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, z16);
        } else {
            this.mFadingEdgeEnabled = z16;
        }
    }

    public void setFadingEdgeStrength(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, Float.valueOf(f16));
        } else {
            this.mFadingEdgeStrength = f16;
        }
    }

    public void setFormatter(Formatter formatter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) formatter);
        } else {
            if (formatter == this.mFormatter) {
                return;
            }
            this.mFormatter = formatter;
            initializeSelectorWheelIndices();
            updateInputTextView();
        }
    }

    public void setItemSpacing(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, (Object) this, i3);
        } else {
            this.mItemSpacing = i3;
        }
    }

    public void setLabel(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 117)) {
            iPatchRedirector.redirect((short) 117, (Object) this, (Object) str);
        } else {
            this.label = str;
        }
    }

    public void setLineSpacingMultiplier(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, this, Float.valueOf(f16));
        } else {
            this.mLineSpacingMultiplier = f16;
        }
    }

    public void setMaxFlingVelocityCoefficient(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this, i3);
        } else {
            this.mMaxFlingVelocityCoefficient = i3;
            this.mMaximumFlingVelocity = this.mViewConfiguration.getScaledMaximumFlingVelocity() / this.mMaxFlingVelocityCoefficient;
        }
    }

    public void setMaxValue(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3);
            return;
        }
        if (i3 >= 0) {
            this.mMaxValue = i3;
            if (i3 < this.mValue) {
                this.mValue = i3;
            }
            updateWrapSelectorWheel();
            initializeSelectorWheelIndices();
            updateInputTextView();
            tryComputeMaxWidth();
            invalidate();
            return;
        }
        throw new IllegalArgumentException("maxValue must be >= 0");
    }

    public void setMinValue(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
            return;
        }
        this.mMinValue = i3;
        if (i3 > this.mValue) {
            this.mValue = i3;
        }
        updateWrapSelectorWheel();
        initializeSelectorWheelIndices();
        updateInputTextView();
        tryComputeMaxWidth();
        invalidate();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) onClickListener);
        } else {
            this.mOnClickListener = onClickListener;
        }
    }

    public void setOnLongPressUpdateInterval(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, j3);
        } else {
            this.mLongPressUpdateInterval = j3;
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) onScrollListener);
        } else {
            this.mOnScrollListener = onScrollListener;
        }
    }

    public void setOnValueChangedListener(OnValueChangeListener onValueChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) onValueChangeListener);
        } else {
            this.mOnValueChangeListener = onValueChangeListener;
        }
    }

    public void setOrder(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, i3);
        } else {
            this.mOrder = i3;
        }
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, i3);
            return;
        }
        this.mOrientation = i3;
        setWidthAndHeight();
        requestLayout();
    }

    public void setScrollerEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, z16);
        } else {
            this.mScrollerEnabled = z16;
        }
    }

    public void setSelectedTextAlign(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, i3);
        } else {
            this.mSelectedTextAlign = i3;
        }
    }

    public void setSelectedTextBold(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 122)) {
            iPatchRedirector.redirect((short) 122, (Object) this, z16);
        } else {
            this.selectedTextBold = z16;
        }
    }

    public void setSelectedTextColor(@ColorInt int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, i3);
            return;
        }
        this.mSelectedTextColor = i3;
        this.mSelectedText.setTextColor(i3);
        invalidate();
    }

    public void setSelectedTextColorResource(@ColorRes int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, i3);
        } else {
            setSelectedTextColor(ContextCompat.getColor(this.mContext, i3));
        }
    }

    public void setSelectedTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, this, Float.valueOf(f16));
            return;
        }
        this.mSelectedTextSize = f16;
        this.mSelectedText.setTextSize(pxToSp(f16));
        invalidate();
    }

    public void setSelectedTextStrikeThru(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, z16);
        } else {
            this.mSelectedTextStrikeThru = z16;
        }
    }

    public void setSelectedTextUnderline(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, z16);
        } else {
            this.mSelectedTextUnderline = z16;
        }
    }

    public void setSelectedTypeface(Typeface typeface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, (Object) typeface);
            return;
        }
        this.mSelectedTypeface = typeface;
        if (typeface != null) {
            this.mSelectorWheelPaint.setTypeface(typeface);
        } else {
            Typeface typeface2 = this.mTypeface;
            if (typeface2 != null) {
                this.mSelectorWheelPaint.setTypeface(typeface2);
            } else {
                this.mSelectorWheelPaint.setTypeface(Typeface.MONOSPACE);
            }
        }
        invalidate();
    }

    public void setTextAlign(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, i3);
        } else {
            this.mTextAlign = i3;
        }
    }

    public void setTextBold(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 120)) {
            iPatchRedirector.redirect((short) 120, (Object) this, z16);
        } else {
            this.textBold = z16;
        }
    }

    public void setTextColor(@ColorInt int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, i3);
            return;
        }
        this.mTextColor = i3;
        this.mSelectorWheelPaint.setColor(i3);
        invalidate();
    }

    public void setTextColorResource(@ColorRes int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this, i3);
        } else {
            setTextColor(ContextCompat.getColor(this.mContext, i3));
        }
    }

    public void setTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, this, Float.valueOf(f16));
            return;
        }
        this.mTextSize = f16;
        this.mSelectorWheelPaint.setTextSize(f16);
        invalidate();
    }

    public void setTextStrikeThru(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, z16);
        } else {
            this.mTextStrikeThru = z16;
        }
    }

    public void setTextUnderline(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, z16);
        } else {
            this.mTextUnderline = z16;
        }
    }

    public void setTypeface(Typeface typeface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) typeface);
            return;
        }
        this.mTypeface = typeface;
        if (typeface != null) {
            this.mSelectedText.setTypeface(typeface);
            setSelectedTypeface(this.mSelectedTypeface);
        } else {
            this.mSelectedText.setTypeface(Typeface.MONOSPACE);
        }
        invalidate();
    }

    public void setValue(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else {
            setValueInternal(i3, false);
        }
    }

    public void setWheelItemCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, i3);
            return;
        }
        if (i3 >= 1) {
            this.mRealWheelItemCount = i3;
            int max = Math.max(i3, 5);
            this.mWheelItemCount = max;
            this.mWheelMiddleItemIndex = max / 2;
            this.mSelectorIndices = new int[max];
            return;
        }
        throw new IllegalArgumentException("Wheel item count must be >= 1");
    }

    public void setWrapSelectorWheel(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.mWrapSelectorWheelPreferred = z16;
            updateWrapSelectorWheel();
        }
    }

    public void smoothScroll(boolean z16, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (z16) {
            i16 = -this.mSelectorElementSize;
        } else {
            i16 = this.mSelectorElementSize;
        }
        int i17 = i16 * i3;
        if (isHorizontalMode()) {
            this.mPreviousScrollerX = 0;
            this.mFlingScroller.startScroll(0, 0, i17, 0, 300);
        } else {
            this.mPreviousScrollerY = 0;
            this.mFlingScroller.startScroll(0, 0, 0, i17, 300);
        }
        invalidate();
    }

    public void smoothScrollToPosition(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
            return;
        }
        int i16 = getSelectorIndices()[this.mWheelMiddleItemIndex];
        if (i16 == i3) {
            return;
        }
        if (i3 > i16) {
            z16 = true;
        } else {
            z16 = false;
        }
        smoothScroll(z16, Math.abs(i3 - i16));
    }

    public NumberPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public float getFadingEdgeStrength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 102)) ? this.mFadingEdgeStrength : ((Float) iPatchRedirector.redirect((short) 102, (Object) this)).floatValue();
    }

    public NumberPicker(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.defaultMinWidth = 62;
        this.label = "";
        this.textBold = true;
        this.selectedTextBold = true;
        this.mSelectedTextAlign = 1;
        this.mSelectedTextColor = -16777216;
        this.mSelectedTextSize = DEFAULT_TEXT_SIZE;
        this.mTextAlign = 1;
        this.mTextColor = -16777216;
        this.mTextHideColor = -16777216;
        this.mTextSize = DEFAULT_TEXT_SIZE;
        this.mMinValue = 1;
        this.mMaxValue = 100;
        this.mLongPressUpdateInterval = 300L;
        this.mSelectorIndexToStringCache = new SparseArray<>();
        this.mWheelItemCount = 5;
        this.mRealWheelItemCount = 5;
        this.mWheelMiddleItemIndex = 5 / 2;
        this.mSelectorIndices = new int[5];
        this.mInitialScrollOffset = Integer.MIN_VALUE;
        this.mWrapSelectorWheelPreferred = true;
        this.mDividerColor = -16777216;
        this.mScrollState = 0;
        this.mLastHandledDownDpadKeyCode = -1;
        this.mFadingEdgeEnabled = true;
        this.mFadingEdgeStrength = 0.9f;
        this.mScrollerEnabled = true;
        this.mLineSpacingMultiplier = 1.0f;
        this.mMaxFlingVelocityCoefficient = 8;
        this.mAccessibilityDescriptionEnabled = true;
        this.mItemSpacing = 0;
        this.mContext = context;
        this.mNumberFormatter = NumberFormat.getInstance();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NumberPicker, i3, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.NumberPicker_tp_divider);
        if (drawable != null) {
            drawable.setCallback(this);
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
            this.mDividerDrawable = drawable;
        } else {
            int color = obtainStyledAttributes.getColor(R.styleable.NumberPicker_tp_dividerColor, this.mDividerColor);
            this.mDividerColor = color;
            setDividerColor(color);
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int applyDimension = (int) TypedValue.applyDimension(1, 48.0f, displayMetrics);
        int applyDimension2 = (int) TypedValue.applyDimension(1, 1.0f, displayMetrics);
        this.mDividerDistance = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_tp_dividerDistance, applyDimension);
        this.mDividerLength = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_tp_dividerLength, 0);
        this.mDividerThickness = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_tp_dividerThickness, applyDimension2);
        this.mDividerType = obtainStyledAttributes.getInt(R.styleable.NumberPicker_tp_dividerType, 0);
        this.mOrder = obtainStyledAttributes.getInt(R.styleable.NumberPicker_tp_order, 0);
        this.mOrientation = obtainStyledAttributes.getInt(R.styleable.NumberPicker_tp_orientation, 1);
        this.defaultMinWidth = obtainStyledAttributes.getInt(R.styleable.NumberPicker_tp_default_min_width, 62);
        float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_tp_width, -1);
        float dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_tp_height, -1);
        setWidthAndHeight();
        this.mComputeMaxWidth = true;
        this.mValue = obtainStyledAttributes.getInt(R.styleable.NumberPicker_tp_value, this.mValue);
        this.mMaxValue = obtainStyledAttributes.getInt(R.styleable.NumberPicker_tp_max, this.mMaxValue);
        this.mMinValue = obtainStyledAttributes.getInt(R.styleable.NumberPicker_tp_min, this.mMinValue);
        this.mSelectedTextAlign = obtainStyledAttributes.getInt(R.styleable.NumberPicker_tp_selectedTextAlign, this.mSelectedTextAlign);
        this.mSelectedTextColor = obtainStyledAttributes.getColor(R.styleable.NumberPicker_tp_selectedTextColor, this.mSelectedTextColor);
        this.mSelectedTextSize = obtainStyledAttributes.getDimension(R.styleable.NumberPicker_tp_selectedTextSize, spToPx(this.mSelectedTextSize));
        this.mSelectedTextStrikeThru = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_tp_selectedTextStrikeThru, this.mSelectedTextStrikeThru);
        this.mSelectedTextUnderline = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_tp_selectedTextUnderline, this.mSelectedTextUnderline);
        this.mSelectedTypeface = Typeface.create(obtainStyledAttributes.getString(R.styleable.NumberPicker_tp_selectedTypeface), 0);
        this.mTextAlign = obtainStyledAttributes.getInt(R.styleable.NumberPicker_tp_textAlign, this.mTextAlign);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.NumberPicker_tp_textColor, this.mTextColor);
        this.mTextHideColor = obtainStyledAttributes.getColor(R.styleable.NumberPicker_tp_textHideColor, this.mTextHideColor);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.NumberPicker_tp_textSize, spToPx(this.mTextSize));
        this.mTextStrikeThru = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_tp_textStrikeThru, this.mTextStrikeThru);
        this.mTextUnderline = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_tp_textUnderline, this.mTextUnderline);
        this.mTypeface = Typeface.create(obtainStyledAttributes.getString(R.styleable.NumberPicker_tp_typeface), 0);
        this.mFormatter = stringToFormatter(obtainStyledAttributes.getString(R.styleable.NumberPicker_tp_formatter));
        this.mFadingEdgeEnabled = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_tp_fadingEdgeEnabled, this.mFadingEdgeEnabled);
        this.mFadingEdgeStrength = obtainStyledAttributes.getFloat(R.styleable.NumberPicker_tp_fadingEdgeStrength, this.mFadingEdgeStrength);
        this.mScrollerEnabled = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_tp_scrollerEnabled, this.mScrollerEnabled);
        this.mWheelItemCount = obtainStyledAttributes.getInt(R.styleable.NumberPicker_tp_wheelItemCount, this.mWheelItemCount);
        this.mLineSpacingMultiplier = obtainStyledAttributes.getFloat(R.styleable.NumberPicker_tp_lineSpacingMultiplier, this.mLineSpacingMultiplier);
        this.mMaxFlingVelocityCoefficient = obtainStyledAttributes.getInt(R.styleable.NumberPicker_tp_maxFlingVelocityCoefficient, this.mMaxFlingVelocityCoefficient);
        this.mHideWheelUntilFocused = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_tp_hideWheelUntilFocused, false);
        this.mAccessibilityDescriptionEnabled = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_tp_accessibilityDescriptionEnabled, true);
        this.mItemSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.NumberPicker_tp_itemSpacing, 0);
        this.textBold = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_tp_textBold, this.textBold);
        this.selectedTextBold = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_tp_selectedTextBold, this.selectedTextBold);
        setWillNotDraw(false);
        EditText editText = new EditText(context);
        this.mSelectedText = editText;
        editText.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        editText.setGravity(17);
        editText.setSingleLine(true);
        editText.setImportantForAccessibility(2);
        editText.setEnabled(false);
        editText.setFocusable(false);
        editText.setVisibility(4);
        editText.setImeOptions(1);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        this.mSelectorWheelPaint = paint;
        setSelectedTextColor(this.mSelectedTextColor);
        setTextColor(this.mTextColor);
        setTextSize(this.mTextSize);
        setSelectedTextSize(this.mSelectedTextSize);
        setTypeface(this.mTypeface);
        setSelectedTypeface(this.mSelectedTypeface);
        setFormatter(this.mFormatter);
        updateInputTextView();
        setValue(this.mValue);
        setMaxValue(this.mMaxValue);
        setMinValue(this.mMinValue);
        setWheelItemCount(this.mWheelItemCount);
        boolean z16 = obtainStyledAttributes.getBoolean(R.styleable.NumberPicker_tp_wrapSelectorWheel, this.mWrapSelectorWheel);
        this.mWrapSelectorWheel = z16;
        setWrapSelectorWheel(z16);
        if (dimensionPixelSize != -1.0f && dimensionPixelSize2 != -1.0f) {
            setScaleX(dimensionPixelSize / this.mMinWidth);
            setScaleY(dimensionPixelSize2 / this.mMaxHeight);
        } else if (dimensionPixelSize != -1.0f) {
            float f16 = dimensionPixelSize / this.mMinWidth;
            setScaleX(f16);
            setScaleY(f16);
        } else if (dimensionPixelSize2 != -1.0f) {
            float f17 = dimensionPixelSize2 / this.mMaxHeight;
            setScaleX(f17);
            setScaleY(f17);
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mViewConfiguration = viewConfiguration;
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumFlingVelocity = this.mViewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumFlingVelocity = this.mViewConfiguration.getScaledMaximumFlingVelocity() / this.mMaxFlingVelocityCoefficient;
        this.mFlingScroller = new Scroller(context, null, true);
        this.mAdjustScroller = new Scroller(context, new DecelerateInterpolator(2.5f));
        int i16 = Build.VERSION.SDK_INT;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        if (i16 >= 26 && getFocusable() == 16) {
            setFocusable(1);
            setFocusableInTouchMode(true);
        }
        obtainStyledAttributes.recycle();
    }

    public void setSelectedTextSize(@DimenRes int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 67)) {
            setSelectedTextSize(getResources().getDimension(i3));
        } else {
            iPatchRedirector.redirect((short) 67, (Object) this, i3);
        }
    }

    public void setTextSize(@DimenRes int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 79)) {
            setTextSize(getResources().getDimension(i3));
        } else {
            iPatchRedirector.redirect((short) 79, (Object) this, i3);
        }
    }

    public void setFormatter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) str);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            setFormatter(stringToFormatter(str));
        }
    }

    private void postChangeCurrentByOneFromLongPress(boolean z16) {
        postChangeCurrentByOneFromLongPress(z16, ViewConfiguration.getLongPressTimeout());
    }

    public void setTypeface(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this, (Object) str, i3);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            setTypeface(Typeface.create(str, i3));
        }
    }

    public void setFormatter(@StringRes int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 59)) {
            setFormatter(getResources().getString(i3));
        } else {
            iPatchRedirector.redirect((short) 59, (Object) this, i3);
        }
    }

    public void setSelectedTypeface(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this, (Object) str, i3);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            setSelectedTypeface(Typeface.create(str, i3));
        }
    }

    public void setTypeface(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 84)) {
            setTypeface(str, 0);
        } else {
            iPatchRedirector.redirect((short) 84, (Object) this, (Object) str);
        }
    }

    public void setSelectedTypeface(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 72)) {
            setSelectedTypeface(str, 0);
        } else {
            iPatchRedirector.redirect((short) 72, (Object) this, (Object) str);
        }
    }

    public void setTypeface(@StringRes int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 85)) {
            setTypeface(getResources().getString(i3), i16);
        } else {
            iPatchRedirector.redirect((short) 85, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void setSelectedTypeface(@StringRes int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 73)) {
            setSelectedTypeface(getResources().getString(i3), i16);
        } else {
            iPatchRedirector.redirect((short) 73, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void setTypeface(@StringRes int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 86)) {
            setTypeface(i3, 0);
        } else {
            iPatchRedirector.redirect((short) 86, (Object) this, i3);
        }
    }

    public void setSelectedTypeface(@StringRes int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 74)) {
            setSelectedTypeface(i3, 0);
        } else {
            iPatchRedirector.redirect((short) 74, (Object) this, i3);
        }
    }
}
