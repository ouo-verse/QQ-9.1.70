package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface DividerMode {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, null);
    }

    private void forceUniformHeight(int i3, int i16) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i17 = 0; i17 < i3; i17++) {
            View virtualChildAt = getVirtualChildAt(i17);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                    int i18 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i16, 0, makeMeasureSpec, 0);
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = i18;
                }
            }
        }
    }

    private void forceUniformWidth(int i3, int i16) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i17 = 0; i17 < i3; i17++) {
            View virtualChildAt = getVirtualChildAt(i17);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                    int i18 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i16, 0);
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = i18;
                }
            }
        }
    }

    private void setChildFrame(View view, int i3, int i16, int i17, int i18) {
        view.layout(i3, i16, i17 + i3, i18 + i16);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int i3;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i16 = 0; i16 < virtualChildCount; i16++) {
            View virtualChildAt = getVirtualChildAt(i16);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i16)) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (isLayoutRtl) {
                    left2 = virtualChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                } else {
                    left2 = (virtualChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, left2);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                if (isLayoutRtl) {
                    right = getPaddingLeft();
                } else {
                    left = getWidth() - getPaddingRight();
                    i3 = this.mDividerWidth;
                    right = left - i3;
                }
            } else {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (isLayoutRtl) {
                    left = virtualChildAt2.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                    i3 = this.mDividerWidth;
                    right = left - i3;
                } else {
                    right = virtualChildAt2.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                }
            }
            drawVerticalDivider(canvas, right);
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i3 = 0; i3 < virtualChildCount; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i3)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((ViewGroup.MarginLayoutParams) ((LayoutParams) virtualChildAt.getLayoutParams())).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                bottom = virtualChildAt2.getBottom() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) virtualChildAt2.getLayoutParams())).bottomMargin;
            }
            drawHorizontalDivider(canvas, bottom);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i3) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i3, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i3);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i3) {
        this.mDivider.setBounds(i3, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i3, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i3;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i16 = this.mBaselineAlignedChildIndex;
        if (childCount > i16) {
            View childAt = getChildAt(i16);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.mBaselineAlignedChildIndex == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i17 = this.mBaselineChildTop;
            if (this.mOrientation == 1 && (i3 = this.mGravity & 112) != 48) {
                if (i3 != 16) {
                    if (i3 == 80) {
                        i17 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                    }
                } else {
                    i17 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                }
            }
            return i17 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    int getChildrenSkipCount(View view, int i3) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    View getVirtualChildAt(int i3) {
        return getChildAt(i3);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int i3) {
        if (i3 == 0) {
            if ((this.mShowDividers & 1) == 0) {
                return false;
            }
            return true;
        }
        if (i3 == getChildCount()) {
            if ((this.mShowDividers & 4) == 0) {
                return false;
            }
            return true;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int i16 = i3 - 1; i16 >= 0; i16--) {
            if (getChildAt(i16).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutHorizontal(int i3, int i16, int i17, int i18) {
        int paddingLeft;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        boolean z16;
        int i36;
        int i37;
        int i38;
        int i39;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i46 = i18 - i16;
        int paddingBottom = i46 - getPaddingBottom();
        int paddingBottom2 = (i46 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i47 = this.mGravity;
        int i48 = i47 & 112;
        boolean z17 = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i47, ViewCompat.getLayoutDirection(this));
        boolean z18 = true;
        if (absoluteGravity != 1) {
            if (absoluteGravity != 5) {
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = ((getPaddingLeft() + i17) - i3) - this.mTotalLength;
            }
        } else {
            paddingLeft = getPaddingLeft() + (((i17 - i3) - this.mTotalLength) / 2);
        }
        if (isLayoutRtl) {
            i19 = virtualChildCount - 1;
            i26 = -1;
        } else {
            i19 = 0;
            i26 = 1;
        }
        int i49 = 0;
        while (i49 < virtualChildCount) {
            int i56 = i19 + (i26 * i49);
            View virtualChildAt = getVirtualChildAt(i56);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i56);
                z16 = z18;
                i27 = paddingTop;
                i28 = virtualChildCount;
                i29 = i48;
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i57 = i49;
                if (z17) {
                    i28 = virtualChildCount;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                        i36 = virtualChildAt.getBaseline();
                        i37 = layoutParams.gravity;
                        if (i37 < 0) {
                            i37 = i48;
                        }
                        i38 = i37 & 112;
                        i29 = i48;
                        if (i38 == 16) {
                            if (i38 != 48) {
                                if (i38 != 80) {
                                    i39 = paddingTop;
                                } else {
                                    i39 = (paddingBottom - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                                    if (i36 != -1) {
                                        i39 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i36);
                                    }
                                }
                            } else {
                                i39 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                                if (i36 != -1) {
                                    z16 = true;
                                    i39 += iArr[1] - i36;
                                }
                            }
                            z16 = true;
                        } else {
                            z16 = true;
                            i39 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        }
                        if (hasDividerBeforeChildAt(i56)) {
                            paddingLeft += this.mDividerWidth;
                        }
                        int i58 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                        i27 = paddingTop;
                        setChildFrame(virtualChildAt, i58 + getLocationOffset(virtualChildAt), i39, measuredWidth, measuredHeight);
                        int nextLocationOffset = i58 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(virtualChildAt);
                        i49 = i57 + getChildrenSkipCount(virtualChildAt, i56);
                        paddingLeft = nextLocationOffset;
                        i49++;
                        virtualChildCount = i28;
                        i48 = i29;
                        z18 = z16;
                        paddingTop = i27;
                    }
                } else {
                    i28 = virtualChildCount;
                }
                i36 = -1;
                i37 = layoutParams.gravity;
                if (i37 < 0) {
                }
                i38 = i37 & 112;
                i29 = i48;
                if (i38 == 16) {
                }
                if (hasDividerBeforeChildAt(i56)) {
                }
                int i582 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                i27 = paddingTop;
                setChildFrame(virtualChildAt, i582 + getLocationOffset(virtualChildAt), i39, measuredWidth, measuredHeight);
                int nextLocationOffset2 = i582 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(virtualChildAt);
                i49 = i57 + getChildrenSkipCount(virtualChildAt, i56);
                paddingLeft = nextLocationOffset2;
                i49++;
                virtualChildCount = i28;
                i48 = i29;
                z18 = z16;
                paddingTop = i27;
            } else {
                i27 = paddingTop;
                i28 = virtualChildCount;
                i29 = i48;
                z16 = true;
            }
            i49++;
            virtualChildCount = i28;
            i48 = i29;
            z18 = z16;
            paddingTop = i27;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutVertical(int i3, int i16, int i17, int i18) {
        int paddingTop;
        int i19;
        int i26;
        int i27;
        int i28;
        int paddingLeft = getPaddingLeft();
        int i29 = i17 - i3;
        int paddingRight = i29 - getPaddingRight();
        int paddingRight2 = (i29 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i36 = this.mGravity;
        int i37 = i36 & 112;
        int i38 = i36 & 8388615;
        if (i37 != 16) {
            if (i37 != 80) {
                paddingTop = getPaddingTop();
            } else {
                paddingTop = ((getPaddingTop() + i18) - i16) - this.mTotalLength;
            }
        } else {
            paddingTop = getPaddingTop() + (((i18 - i16) - this.mTotalLength) / 2);
        }
        int i39 = 0;
        while (i39 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i39);
            if (virtualChildAt == null) {
                paddingTop += measureNullChild(i39);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i46 = layoutParams.gravity;
                if (i46 < 0) {
                    i46 = i38;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i46, ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity != 1) {
                    if (absoluteGravity != 5) {
                        i27 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                        int i47 = i27;
                        if (hasDividerBeforeChildAt(i39)) {
                            paddingTop += this.mDividerHeight;
                        }
                        int i48 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        setChildFrame(virtualChildAt, i47, i48 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                        int nextLocationOffset = i48 + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt);
                        i39 += getChildrenSkipCount(virtualChildAt, i39);
                        paddingTop = nextLocationOffset;
                        i28 = 1;
                        i39 += i28;
                    } else {
                        i19 = paddingRight - measuredWidth;
                        i26 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    }
                } else {
                    i19 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    i26 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                i27 = i19 - i26;
                int i472 = i27;
                if (hasDividerBeforeChildAt(i39)) {
                }
                int i482 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                setChildFrame(virtualChildAt, i472, i482 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                int nextLocationOffset2 = i482 + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt);
                i39 += getChildrenSkipCount(virtualChildAt, i39);
                paddingTop = nextLocationOffset2;
                i28 = 1;
                i39 += i28;
            }
            i28 = 1;
            i39 += i28;
        }
    }

    void measureChildBeforeLayout(View view, int i3, int i16, int i17, int i18, int i19) {
        measureChildWithMargins(view, i16, i17, i18, i19);
    }

    /* JADX WARN: Removed duplicated region for block: B:195:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void measureHorizontal(int i3, int i16) {
        boolean z16;
        int[] iArr;
        int i17;
        int max;
        int i18;
        int i19;
        int max2;
        int i26;
        int i27;
        int i28;
        int i29;
        float f16;
        boolean z17;
        int i36;
        boolean z18;
        int baseline;
        int i37;
        int i38;
        int i39;
        char c16;
        int i46;
        int i47;
        int i48;
        boolean z19;
        boolean z26;
        View view;
        int i49;
        boolean z27;
        int measuredHeight;
        int childrenSkipCount;
        int baseline2;
        int i56;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr2 = this.mMaxAscent;
        int[] iArr3 = this.mMaxDescent;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z28 = this.mBaselineAligned;
        boolean z29 = this.mUseLargestChild;
        int i57 = 1073741824;
        if (mode == 1073741824) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i58 = 0;
        int i59 = 0;
        int i65 = 0;
        int i66 = 0;
        int i67 = 0;
        boolean z36 = false;
        int i68 = 0;
        boolean z37 = false;
        boolean z38 = true;
        float f17 = 0.0f;
        while (true) {
            iArr = iArr3;
            if (i58 >= virtualChildCount) {
                break;
            }
            View virtualChildAt = getVirtualChildAt(i58);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i58);
            } else if (virtualChildAt.getVisibility() == 8) {
                i58 += getChildrenSkipCount(virtualChildAt, i58);
            } else {
                if (hasDividerBeforeChildAt(i58)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                float f18 = layoutParams.weight;
                float f19 = f17 + f18;
                if (mode == i57 && ((ViewGroup.MarginLayoutParams) layoutParams).width == 0 && f18 > 0.0f) {
                    if (z16) {
                        this.mTotalLength += ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    } else {
                        int i69 = this.mTotalLength;
                        this.mTotalLength = Math.max(i69, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + i69 + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    }
                    if (z28) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                        i48 = i58;
                        z19 = z29;
                        z26 = z28;
                        view = virtualChildAt;
                    } else {
                        i48 = i58;
                        z19 = z29;
                        z26 = z28;
                        view = virtualChildAt;
                        z36 = true;
                        i49 = 1073741824;
                        if (mode2 == i49 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                            z27 = true;
                            z37 = true;
                        } else {
                            z27 = false;
                        }
                        int i75 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i75;
                        i68 = View.combineMeasuredStates(i68, view.getMeasuredState());
                        if (z26 && (baseline2 = view.getBaseline()) != -1) {
                            i56 = layoutParams.gravity;
                            if (i56 < 0) {
                                i56 = this.mGravity;
                            }
                            int i76 = (((i56 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i76] = Math.max(iArr2[i76], baseline2);
                            iArr[i76] = Math.max(iArr[i76], measuredHeight - baseline2);
                        }
                        i65 = Math.max(i65, measuredHeight);
                        if (!z38 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                            z38 = true;
                        } else {
                            z38 = false;
                        }
                        if (layoutParams.weight <= 0.0f) {
                            if (!z27) {
                                i75 = measuredHeight;
                            }
                            i67 = Math.max(i67, i75);
                        } else {
                            int i77 = i67;
                            if (!z27) {
                                i75 = measuredHeight;
                            }
                            i66 = Math.max(i66, i75);
                            i67 = i77;
                        }
                        int i78 = i48;
                        childrenSkipCount = getChildrenSkipCount(view, i78) + i78;
                        f17 = f19;
                        int i79 = childrenSkipCount + 1;
                        iArr3 = iArr;
                        z29 = z19;
                        z28 = z26;
                        i57 = i49;
                        i58 = i79;
                    }
                } else {
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width == 0 && f18 > 0.0f) {
                        c16 = '\ufffe';
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
                        i46 = 0;
                    } else {
                        c16 = '\ufffe';
                        i46 = Integer.MIN_VALUE;
                    }
                    if (f19 == 0.0f) {
                        i47 = this.mTotalLength;
                    } else {
                        i47 = 0;
                    }
                    i48 = i58;
                    int i85 = i46;
                    z19 = z29;
                    z26 = z28;
                    measureChildBeforeLayout(virtualChildAt, i48, i3, i47, i16, 0);
                    if (i85 != Integer.MIN_VALUE) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = i85;
                    }
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    if (z16) {
                        view = virtualChildAt;
                        this.mTotalLength += ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(view);
                    } else {
                        view = virtualChildAt;
                        int i86 = this.mTotalLength;
                        this.mTotalLength = Math.max(i86, i86 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(view));
                    }
                    if (z19) {
                        i59 = Math.max(measuredWidth, i59);
                    }
                }
                i49 = 1073741824;
                if (mode2 == i49) {
                }
                z27 = false;
                int i752 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i752;
                i68 = View.combineMeasuredStates(i68, view.getMeasuredState());
                if (z26) {
                    i56 = layoutParams.gravity;
                    if (i56 < 0) {
                    }
                    int i762 = (((i56 & 112) >> 4) & (-2)) >> 1;
                    iArr2[i762] = Math.max(iArr2[i762], baseline2);
                    iArr[i762] = Math.max(iArr[i762], measuredHeight - baseline2);
                }
                i65 = Math.max(i65, measuredHeight);
                if (!z38) {
                }
                z38 = false;
                if (layoutParams.weight <= 0.0f) {
                }
                int i782 = i48;
                childrenSkipCount = getChildrenSkipCount(view, i782) + i782;
                f17 = f19;
                int i792 = childrenSkipCount + 1;
                iArr3 = iArr;
                z29 = z19;
                z28 = z26;
                i57 = i49;
                i58 = i792;
            }
            z19 = z29;
            z26 = z28;
            int i87 = i57;
            childrenSkipCount = i58;
            i49 = i87;
            int i7922 = childrenSkipCount + 1;
            iArr3 = iArr;
            z29 = z19;
            z28 = z26;
            i57 = i49;
            i58 = i7922;
        }
        boolean z39 = z29;
        boolean z46 = z28;
        int i88 = i65;
        int i89 = i66;
        int i95 = i67;
        int i96 = i68;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        int i97 = iArr2[1];
        if (i97 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            max = i88;
            i17 = i96;
        } else {
            i17 = i96;
            max = Math.max(i88, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i97, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z39 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int i98 = 0;
            while (i98 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i98);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i98);
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i98 += getChildrenSkipCount(virtualChildAt2, i98);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (z16) {
                        this.mTotalLength += ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + i59 + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + getNextLocationOffset(virtualChildAt2);
                    } else {
                        int i99 = this.mTotalLength;
                        i39 = max;
                        this.mTotalLength = Math.max(i99, i99 + i59 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + getNextLocationOffset(virtualChildAt2));
                        i98++;
                        max = i39;
                    }
                }
                i39 = max;
                i98++;
                max = i39;
            }
        }
        int i100 = max;
        int paddingLeft = this.mTotalLength + getPaddingLeft() + getPaddingRight();
        this.mTotalLength = paddingLeft;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i3, 0);
        int i101 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (!z36 && (i101 == 0 || f17 <= 0.0f)) {
            i27 = Math.max(i89, i95);
            if (z39 && mode != 1073741824) {
                for (int i102 = 0; i102 < virtualChildCount; i102++) {
                    View virtualChildAt3 = getVirtualChildAt(i102);
                    if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LayoutParams) virtualChildAt3.getLayoutParams()).weight > 0.0f) {
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i59, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i18 = i16;
            i19 = virtualChildCount;
            i26 = i100;
        } else {
            float f26 = this.mWeightSum;
            if (f26 > 0.0f) {
                f17 = f26;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.mTotalLength = 0;
            int i103 = i89;
            int i104 = -1;
            int i105 = i17;
            int i106 = 0;
            while (i106 < virtualChildCount) {
                View virtualChildAt4 = getVirtualChildAt(i106);
                if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8) {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt4.getLayoutParams();
                    float f27 = layoutParams3.weight;
                    if (f27 > 0.0f) {
                        int i107 = (int) ((i101 * f27) / f17);
                        float f28 = f17 - f27;
                        int i108 = i101 - i107;
                        i29 = virtualChildCount;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i16, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams3).height);
                        if (((ViewGroup.MarginLayoutParams) layoutParams3).width == 0) {
                            i38 = 1073741824;
                            if (mode == 1073741824) {
                                if (i107 <= 0) {
                                    i107 = 0;
                                }
                                virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i107, 1073741824), childMeasureSpec);
                                i105 = View.combineMeasuredStates(i105, virtualChildAt4.getMeasuredState() & (-16777216));
                                f17 = f28;
                                i28 = i108;
                            }
                        } else {
                            i38 = 1073741824;
                        }
                        int measuredWidth2 = virtualChildAt4.getMeasuredWidth() + i107;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i38), childMeasureSpec);
                        i105 = View.combineMeasuredStates(i105, virtualChildAt4.getMeasuredState() & (-16777216));
                        f17 = f28;
                        i28 = i108;
                    } else {
                        i28 = i101;
                        i29 = virtualChildCount;
                    }
                    if (z16) {
                        this.mTotalLength += virtualChildAt4.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin + getNextLocationOffset(virtualChildAt4);
                        f16 = f17;
                    } else {
                        int i109 = this.mTotalLength;
                        f16 = f17;
                        this.mTotalLength = Math.max(i109, virtualChildAt4.getMeasuredWidth() + i109 + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin + getNextLocationOffset(virtualChildAt4));
                    }
                    if (mode2 != 1073741824 && ((ViewGroup.MarginLayoutParams) layoutParams3).height == -1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    int i110 = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
                    int measuredHeight2 = virtualChildAt4.getMeasuredHeight() + i110;
                    i104 = Math.max(i104, measuredHeight2);
                    if (!z17) {
                        i110 = measuredHeight2;
                    }
                    int max3 = Math.max(i103, i110);
                    if (z38) {
                        i36 = -1;
                        if (((ViewGroup.MarginLayoutParams) layoutParams3).height == -1) {
                            z18 = true;
                            if (z46 && (baseline = virtualChildAt4.getBaseline()) != i36) {
                                i37 = layoutParams3.gravity;
                                if (i37 < 0) {
                                    i37 = this.mGravity;
                                }
                                int i111 = (((i37 & 112) >> 4) & (-2)) >> 1;
                                iArr2[i111] = Math.max(iArr2[i111], baseline);
                                iArr[i111] = Math.max(iArr[i111], measuredHeight2 - baseline);
                            }
                            z38 = z18;
                            i103 = max3;
                            f17 = f16;
                        }
                    } else {
                        i36 = -1;
                    }
                    z18 = false;
                    if (z46) {
                        i37 = layoutParams3.gravity;
                        if (i37 < 0) {
                        }
                        int i1112 = (((i37 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i1112] = Math.max(iArr2[i1112], baseline);
                        iArr[i1112] = Math.max(iArr[i1112], measuredHeight2 - baseline);
                    }
                    z38 = z18;
                    i103 = max3;
                    f17 = f16;
                } else {
                    i28 = i101;
                    i29 = virtualChildCount;
                }
                i106++;
                i101 = i28;
                virtualChildCount = i29;
            }
            i18 = i16;
            i19 = virtualChildCount;
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            int i112 = iArr2[1];
            if (i112 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
                max2 = i104;
            } else {
                max2 = Math.max(i104, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i112, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            }
            i26 = max2;
            i27 = i103;
            i17 = i105;
        }
        if (z38 || mode2 == 1073741824) {
            i27 = i26;
        }
        setMeasuredDimension(resolveSizeAndState | (i17 & (-16777216)), View.resolveSizeAndState(Math.max(i27 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i18, i17 << 16));
        if (z37) {
            forceUniformHeight(i19, i3);
        }
    }

    int measureNullChild(int i3) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x0326  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void measureVertical(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        boolean z16;
        boolean z17;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        int i48;
        int i49;
        int i56;
        int i57;
        View view;
        int i58;
        boolean z18;
        int max;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int i59 = this.mBaselineAlignedChildIndex;
        boolean z19 = this.mUseLargestChild;
        int i65 = 0;
        int i66 = 0;
        int i67 = 0;
        int i68 = 0;
        int i69 = 0;
        int i75 = 0;
        boolean z26 = false;
        boolean z27 = false;
        boolean z28 = true;
        float f16 = 0.0f;
        while (true) {
            int i76 = 8;
            int i77 = i68;
            if (i75 < virtualChildCount) {
                View virtualChildAt = getVirtualChildAt(i75);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(i75);
                    i47 = virtualChildCount;
                    i48 = mode2;
                    i68 = i77;
                } else {
                    int i78 = i65;
                    if (virtualChildAt.getVisibility() == 8) {
                        i75 += getChildrenSkipCount(virtualChildAt, i75);
                        i47 = virtualChildCount;
                        i68 = i77;
                        i65 = i78;
                        i48 = mode2;
                    } else {
                        if (hasDividerBeforeChildAt(i75)) {
                            this.mTotalLength += this.mDividerHeight;
                        }
                        LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                        float f17 = layoutParams.weight;
                        float f18 = f16 + f17;
                        if (mode2 == 1073741824 && ((ViewGroup.MarginLayoutParams) layoutParams).height == 0 && f17 > 0.0f) {
                            int i79 = this.mTotalLength;
                            this.mTotalLength = Math.max(i79, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + i79 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                            i58 = i67;
                            view = virtualChildAt;
                            i56 = i69;
                            z26 = true;
                            i39 = i78;
                            i46 = i66;
                            i47 = virtualChildCount;
                            i48 = mode2;
                            i49 = i77;
                            i57 = i75;
                        } else {
                            int i85 = i66;
                            if (((ViewGroup.MarginLayoutParams) layoutParams).height == 0 && f17 > 0.0f) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
                                i37 = 0;
                            } else {
                                i37 = Integer.MIN_VALUE;
                            }
                            if (f18 == 0.0f) {
                                i38 = this.mTotalLength;
                            } else {
                                i38 = 0;
                            }
                            i39 = i78;
                            int i86 = i37;
                            i46 = i85;
                            int i87 = i67;
                            i47 = virtualChildCount;
                            i48 = mode2;
                            i49 = i77;
                            i56 = i69;
                            i57 = i75;
                            measureChildBeforeLayout(virtualChildAt, i75, i3, 0, i16, i38);
                            if (i86 != Integer.MIN_VALUE) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).height = i86;
                            }
                            int measuredHeight = virtualChildAt.getMeasuredHeight();
                            int i88 = this.mTotalLength;
                            view = virtualChildAt;
                            this.mTotalLength = Math.max(i88, i88 + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + getNextLocationOffset(view));
                            if (z19) {
                                i58 = Math.max(measuredHeight, i87);
                            } else {
                                i58 = i87;
                            }
                        }
                        if (i59 >= 0 && i59 == i57 + 1) {
                            this.mBaselineChildTop = this.mTotalLength;
                        }
                        if (i57 < i59 && layoutParams.weight > 0.0f) {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                        if (mode != 1073741824 && ((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                            z18 = true;
                            z27 = true;
                        } else {
                            z18 = false;
                        }
                        int i89 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        int measuredWidth = view.getMeasuredWidth() + i89;
                        int max2 = Math.max(i46, measuredWidth);
                        int combineMeasuredStates = View.combineMeasuredStates(i39, view.getMeasuredState());
                        if (z28 && ((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                            z28 = true;
                        } else {
                            z28 = false;
                        }
                        if (layoutParams.weight > 0.0f) {
                            if (!z18) {
                                i89 = measuredWidth;
                            }
                            i68 = Math.max(i49, i89);
                            max = i56;
                        } else {
                            if (!z18) {
                                i89 = measuredWidth;
                            }
                            max = Math.max(i56, i89);
                            i68 = i49;
                        }
                        int childrenSkipCount = getChildrenSkipCount(view, i57) + i57;
                        i67 = i58;
                        f16 = f18;
                        i69 = max;
                        i65 = combineMeasuredStates;
                        i75 = childrenSkipCount;
                        i66 = max2;
                    }
                }
                i75++;
                mode2 = i48;
                virtualChildCount = i47;
            } else {
                int i95 = i65;
                int i96 = i67;
                int i97 = i69;
                int i98 = virtualChildCount;
                int i99 = mode2;
                int i100 = i66;
                if (this.mTotalLength > 0) {
                    i17 = i98;
                    if (hasDividerBeforeChildAt(i17)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i17 = i98;
                }
                if (z19 && (i99 == Integer.MIN_VALUE || i99 == 0)) {
                    this.mTotalLength = 0;
                    int i101 = 0;
                    while (i101 < i17) {
                        View virtualChildAt2 = getVirtualChildAt(i101);
                        if (virtualChildAt2 == null) {
                            this.mTotalLength += measureNullChild(i101);
                        } else if (virtualChildAt2.getVisibility() == i76) {
                            i101 += getChildrenSkipCount(virtualChildAt2, i101);
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                            int i102 = this.mTotalLength;
                            this.mTotalLength = Math.max(i102, i102 + i96 + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + getNextLocationOffset(virtualChildAt2));
                        }
                        i101++;
                        i76 = 8;
                    }
                }
                int paddingTop = this.mTotalLength + getPaddingTop() + getPaddingBottom();
                this.mTotalLength = paddingTop;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i16, 0);
                int i103 = (16777215 & resolveSizeAndState) - this.mTotalLength;
                if (!z26 && (i103 == 0 || f16 <= 0.0f)) {
                    i26 = Math.max(i97, i77);
                    if (z19 && i99 != 1073741824) {
                        for (int i104 = 0; i104 < i17; i104++) {
                            View virtualChildAt3 = getVirtualChildAt(i104);
                            if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LayoutParams) virtualChildAt3.getLayoutParams()).weight > 0.0f) {
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i96, 1073741824));
                            }
                        }
                    }
                    i19 = i3;
                    i18 = i95;
                } else {
                    float f19 = this.mWeightSum;
                    if (f19 > 0.0f) {
                        f16 = f19;
                    }
                    this.mTotalLength = 0;
                    int i105 = i103;
                    int i106 = i97;
                    i18 = i95;
                    int i107 = 0;
                    while (i107 < i17) {
                        View virtualChildAt4 = getVirtualChildAt(i107);
                        if (virtualChildAt4.getVisibility() == 8) {
                            i27 = i105;
                        } else {
                            LayoutParams layoutParams3 = (LayoutParams) virtualChildAt4.getLayoutParams();
                            float f26 = layoutParams3.weight;
                            if (f26 > 0.0f) {
                                int i108 = (int) ((i105 * f26) / f16);
                                float f27 = f16 - f26;
                                i27 = i105 - i108;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams3).width);
                                if (((ViewGroup.MarginLayoutParams) layoutParams3).height == 0) {
                                    i36 = 1073741824;
                                    if (i99 == 1073741824) {
                                        if (i108 <= 0) {
                                            i108 = 0;
                                        }
                                        virtualChildAt4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i108, 1073741824));
                                        i18 = View.combineMeasuredStates(i18, virtualChildAt4.getMeasuredState() & (-256));
                                        f16 = f27;
                                    }
                                } else {
                                    i36 = 1073741824;
                                }
                                int measuredHeight2 = virtualChildAt4.getMeasuredHeight() + i108;
                                if (measuredHeight2 < 0) {
                                    measuredHeight2 = 0;
                                }
                                virtualChildAt4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i36));
                                i18 = View.combineMeasuredStates(i18, virtualChildAt4.getMeasuredState() & (-256));
                                f16 = f27;
                            } else {
                                i27 = i105;
                            }
                            int i109 = ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin;
                            int measuredWidth2 = virtualChildAt4.getMeasuredWidth() + i109;
                            i100 = Math.max(i100, measuredWidth2);
                            float f28 = f16;
                            if (mode != 1073741824) {
                                i28 = i18;
                                i29 = -1;
                                if (((ViewGroup.MarginLayoutParams) layoutParams3).width == -1) {
                                    z16 = true;
                                    if (!z16) {
                                        i109 = measuredWidth2;
                                    }
                                    int max3 = Math.max(i106, i109);
                                    if (!z28 && ((ViewGroup.MarginLayoutParams) layoutParams3).width == i29) {
                                        z17 = true;
                                    } else {
                                        z17 = false;
                                    }
                                    int i110 = this.mTotalLength;
                                    this.mTotalLength = Math.max(i110, virtualChildAt4.getMeasuredHeight() + i110 + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + getNextLocationOffset(virtualChildAt4));
                                    z28 = z17;
                                    i18 = i28;
                                    i106 = max3;
                                    f16 = f28;
                                }
                            } else {
                                i28 = i18;
                                i29 = -1;
                            }
                            z16 = false;
                            if (!z16) {
                            }
                            int max32 = Math.max(i106, i109);
                            if (!z28) {
                            }
                            z17 = false;
                            int i1102 = this.mTotalLength;
                            this.mTotalLength = Math.max(i1102, virtualChildAt4.getMeasuredHeight() + i1102 + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + getNextLocationOffset(virtualChildAt4));
                            z28 = z17;
                            i18 = i28;
                            i106 = max32;
                            f16 = f28;
                        }
                        i107++;
                        i105 = i27;
                    }
                    i19 = i3;
                    this.mTotalLength += getPaddingTop() + getPaddingBottom();
                    i26 = i106;
                }
                if (z28 || mode == 1073741824) {
                    i26 = i100;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i26 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i19, i18), resolveSizeAndState);
                if (z27) {
                    forceUniformWidth(i17, i16);
                    return;
                }
                return;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (this.mOrientation == 1) {
            layoutVertical(i3, i16, i17, i18);
        } else {
            layoutHorizontal(i3, i16, i17, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        if (this.mOrientation == 1) {
            measureVertical(i3, i16);
        } else {
            measureHorizontal(i3, i16);
        }
    }

    public void setBaselineAligned(boolean z16) {
        this.mBaselineAligned = z16;
    }

    public void setBaselineAlignedChildIndex(int i3) {
        if (i3 >= 0 && i3 < getChildCount()) {
            this.mBaselineAlignedChildIndex = i3;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        boolean z16 = false;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        if (drawable == null) {
            z16 = true;
        }
        setWillNotDraw(z16);
        requestLayout();
    }

    public void setDividerPadding(int i3) {
        this.mDividerPadding = i3;
    }

    public void setGravity(int i3) {
        if (this.mGravity != i3) {
            if ((8388615 & i3) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            this.mGravity = i3;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i3) {
        int i16 = i3 & 8388615;
        int i17 = this.mGravity;
        if ((8388615 & i17) != i16) {
            this.mGravity = i16 | ((-8388616) & i17);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z16) {
        this.mUseLargestChild = z16;
    }

    public void setOrientation(int i3) {
        if (this.mOrientation != i3) {
            this.mOrientation = i3;
            requestLayout();
        }
    }

    public void setShowDividers(int i3) {
        if (i3 != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i3;
    }

    public void setVerticalGravity(int i3) {
        int i16 = i3 & 112;
        int i17 = this.mGravity;
        if ((i17 & 112) != i16) {
            this.mGravity = i16 | (i17 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f16) {
        this.mWeightSum = Math.max(0.0f, f16);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i3 = this.mOrientation;
        if (i3 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i3 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        int[] iArr = R.styleable.LinearLayoutCompat;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i3, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i3, 0);
        int i16 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i16 >= 0) {
            setOrientation(i16);
        }
        int i17 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i17 >= 0) {
            setGravity(i17);
        }
        boolean z16 = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z16) {
            setBaselineAligned(z16);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int i3, int i16, float f16) {
            super(i3, i16);
            this.gravity = -1;
            this.weight = f16;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }
    }
}
