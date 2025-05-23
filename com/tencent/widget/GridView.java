package com.tencent.widget;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.GridLayoutAnimationController;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.AbsListView;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GridView extends AbsListView {
    static IPatchRedirector $redirector_ = null;
    public static final int AUTO_FIT = -1;
    public static final int NO_STRETCH = 0;
    public static final int STRETCH_COLUMN_WIDTH = 2;
    public static final int STRETCH_SPACING = 1;
    public static final int STRETCH_SPACING_UNIFORM = 3;
    private int mColumnWidth;
    private int mGravity;
    private int mHorizontalSpacing;
    public boolean mIsOnMeasure;
    private int mNumColumns;
    private View mReferenceView;
    private View mReferenceViewInSelectedRow;
    private int mRequestedColumnWidth;
    private int mRequestedHorizontalSpacing;
    private int mRequestedNumColumns;
    private int mStretchMode;
    private final Rect mTempRect;
    private int mVerticalSpacing;

    public GridView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void adjustForBottomFadingEdge(View view, int i3, int i16) {
        if (view.getBottom() > i16) {
            offsetChildrenTopAndBottomWrap(-Math.min(view.getTop() - i3, view.getBottom() - i16));
        }
    }

    private void adjustForTopFadingEdge(View view, int i3, int i16) {
        if (view.getTop() < i3) {
            offsetChildrenTopAndBottomWrap(Math.min(i3 - view.getTop(), i16 - view.getBottom()));
        }
    }

    private void adjustViewsUpOrDown() {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i3 = 0;
            if (!this.mStackFromBottom) {
                int top = getChildAt(0).getTop() - this.mListPadding.top;
                if (this.mFirstPosition != 0) {
                    top -= this.mVerticalSpacing;
                }
                if (top >= 0) {
                    i3 = top;
                }
            } else {
                int bottom = getChildAt(childCount - 1).getBottom() - (getHeight() - this.mListPadding.bottom);
                if (this.mFirstPosition + childCount < this.mItemCount) {
                    bottom += this.mVerticalSpacing;
                }
                if (bottom <= 0) {
                    i3 = bottom;
                }
            }
            if (i3 != 0) {
                offsetChildrenTopAndBottomWrap(-i3);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0149, code lost:
    
        if (r4.isShowing() != false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
    
        if (arrowScroll(66) != false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x005c, code lost:
    
        if (arrowScroll(17) != false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00c0, code lost:
    
        if (fullScroll(130) != false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00d4, code lost:
    
        if (fullScroll(33) != false) goto L117;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x018d  */
    @TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean commonKey(int i3, int i16, KeyEvent keyEvent) {
        boolean z16;
        if (this.mAdapter == null) {
            return false;
        }
        if (this.mDataChanged) {
            layoutChildren();
        }
        int action = keyEvent.getAction();
        if (action != 1) {
            if (i3 != 62) {
                if (i3 != 66) {
                    if (i3 != 92) {
                        if (i3 != 93) {
                            if (i3 != 122) {
                                if (i3 != 123) {
                                    switch (i3) {
                                        case 19:
                                            if (!keyEvent.hasNoModifiers()) {
                                                break;
                                            } else {
                                                break;
                                            }
                                        case 20:
                                            if (!keyEvent.hasNoModifiers()) {
                                                break;
                                            } else {
                                                break;
                                            }
                                        case 21:
                                            if (keyEvent.hasNoModifiers()) {
                                                if (!resurrectSelectionIfNeeded()) {
                                                    break;
                                                }
                                                z16 = true;
                                                break;
                                            }
                                            break;
                                        case 22:
                                            if (keyEvent.hasNoModifiers()) {
                                                if (!resurrectSelectionIfNeeded()) {
                                                    break;
                                                }
                                                z16 = true;
                                                break;
                                            }
                                            break;
                                    }
                                } else if (keyEvent.hasNoModifiers()) {
                                    if (!resurrectSelectionIfNeeded()) {
                                    }
                                    z16 = true;
                                }
                            } else if (keyEvent.hasNoModifiers()) {
                                if (!resurrectSelectionIfNeeded()) {
                                }
                                z16 = true;
                            }
                        } else if (!keyEvent.hasNoModifiers()) {
                        }
                    } else if (!keyEvent.hasNoModifiers()) {
                    }
                }
                if (keyEvent.hasNoModifiers()) {
                    z16 = resurrectSelectionIfNeeded();
                    if (!z16 && keyEvent.getRepeatCount() == 0 && getChildCount() > 0) {
                        keyPressed();
                        z16 = true;
                    }
                }
            } else {
                PopupWindow popupWindow = this.mPopup;
                if (popupWindow != null) {
                }
                if (keyEvent.hasNoModifiers()) {
                }
            }
            if (!z16 || sendToTextFilter(i3, i16, keyEvent)) {
                return true;
            }
            if (action == 0) {
                if (action != 1) {
                    if (action != 2) {
                        return false;
                    }
                    return super.onKeyMultiple(i3, i16, keyEvent);
                }
                return super.onKeyUp(i3, keyEvent);
            }
            return super.onKeyDown(i3, keyEvent);
        }
        z16 = false;
        if (!z16) {
            return true;
        }
        if (action == 0) {
        }
    }

    private void correctTooHigh(int i3, int i16, int i17) {
        if ((this.mFirstPosition + i17) - 1 == this.mItemCount - 1 && i17 > 0) {
            int bottom = ((getBottom() - getTop()) - this.mListPadding.bottom) - getChildAt(i17 - 1).getBottom();
            View childAt = getChildAt(0);
            int top = childAt.getTop();
            if (bottom > 0) {
                int i18 = this.mFirstPosition;
                if (i18 > 0 || top < this.mListPadding.top) {
                    if (i18 == 0) {
                        bottom = Math.min(bottom, this.mListPadding.top - top);
                    }
                    offsetChildrenTopAndBottomWrap(bottom);
                    int i19 = this.mFirstPosition;
                    if (i19 > 0) {
                        if (this.mStackFromBottom) {
                            i3 = 1;
                        }
                        fillUp(i19 - i3, childAt.getTop() - i16);
                        adjustViewsUpOrDown();
                    }
                }
            }
        }
    }

    private void correctTooLow(int i3, int i16, int i17) {
        if (this.mFirstPosition == 0 && i17 > 0) {
            int top = getChildAt(0).getTop();
            int i18 = this.mListPadding.top;
            int bottom = (getBottom() - getTop()) - this.mListPadding.bottom;
            int i19 = top - i18;
            View childAt = getChildAt(i17 - 1);
            int bottom2 = childAt.getBottom();
            int i26 = (this.mFirstPosition + i17) - 1;
            if (i19 > 0) {
                int i27 = this.mItemCount;
                if (i26 < i27 - 1 || bottom2 > bottom) {
                    if (i26 == i27 - 1) {
                        i19 = Math.min(i19, bottom2 - bottom);
                    }
                    offsetChildrenTopAndBottomWrap(-i19);
                    if (i26 < this.mItemCount - 1) {
                        if (!this.mStackFromBottom) {
                            i3 = 1;
                        }
                        fillDown(i26 + i3, childAt.getBottom() + i16);
                        adjustViewsUpOrDown();
                    }
                }
            }
        }
    }

    private boolean determineColumns(int i3) {
        int i16 = this.mRequestedHorizontalSpacing;
        int i17 = this.mStretchMode;
        int i18 = this.mRequestedColumnWidth;
        int i19 = this.mRequestedNumColumns;
        if (i19 == -1) {
            if (i18 > 0) {
                this.mNumColumns = (i3 + i16) / (i18 + i16);
            } else {
                this.mNumColumns = 2;
            }
        } else {
            this.mNumColumns = i19;
        }
        if (this.mNumColumns <= 0) {
            this.mNumColumns = 1;
        }
        boolean z16 = false;
        if (i17 != 0) {
            int i26 = this.mNumColumns;
            int i27 = (i3 - (i26 * i18)) - ((i26 - 1) * i16);
            if (i27 < 0) {
                z16 = true;
            }
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 == 3) {
                        this.mColumnWidth = i18;
                        if (i26 > 1) {
                            this.mHorizontalSpacing = i16 + (i27 / (i26 + 1));
                        } else {
                            this.mHorizontalSpacing = i16 + i27;
                        }
                    }
                } else {
                    this.mColumnWidth = i18 + (i27 / i26);
                    this.mHorizontalSpacing = i16;
                }
            } else {
                this.mColumnWidth = i18;
                if (i26 > 1) {
                    this.mHorizontalSpacing = i16 + (i27 / (i26 - 1));
                } else {
                    this.mHorizontalSpacing = i16 + i27;
                }
            }
        } else {
            this.mColumnWidth = i18;
            this.mHorizontalSpacing = i16;
        }
        return z16;
    }

    private View fillDown(int i3, int i16) {
        int bottom = getBottom() - getTop();
        View view = null;
        if (hasBooleanFlag(34)) {
            bottom -= this.mListPadding.bottom;
        }
        while (i16 < bottom && i3 < this.mItemCount) {
            View makeRow = makeRow(i3, i16, true);
            if (makeRow != null) {
                view = makeRow;
            }
            i16 = this.mReferenceView.getBottom() + this.mVerticalSpacing;
            i3 += this.mNumColumns;
        }
        return view;
    }

    private View fillFromBottom(int i3, int i16) {
        int min = Math.min(Math.max(i3, this.mSelectedPosition), this.mItemCount - 1);
        int i17 = this.mItemCount;
        int i18 = (i17 - 1) - min;
        return fillUp((i17 - 1) - (i18 - (i18 % this.mNumColumns)), i16);
    }

    private View fillFromSelection(int i3, int i16, int i17) {
        int i18;
        int max;
        int i19;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int i26 = this.mSelectedPosition;
        int i27 = this.mNumColumns;
        int i28 = this.mVerticalSpacing;
        if (!this.mStackFromBottom) {
            max = i26 - (i26 % i27);
            i18 = -1;
        } else {
            int i29 = this.mItemCount;
            int i36 = (i29 - 1) - i26;
            i18 = (i29 - 1) - (i36 - (i36 % i27));
            max = Math.max(0, (i18 - i27) + 1);
        }
        int topSelectionPixel = getTopSelectionPixel(i16, verticalFadingEdgeLength, max);
        int bottomSelectionPixel = getBottomSelectionPixel(i17, verticalFadingEdgeLength, i27, max);
        if (this.mStackFromBottom) {
            i19 = i18;
        } else {
            i19 = max;
        }
        View makeRow = makeRow(i19, i3, true);
        this.mFirstPosition = max;
        View view = this.mReferenceView;
        adjustForTopFadingEdge(view, topSelectionPixel, bottomSelectionPixel);
        adjustForBottomFadingEdge(view, topSelectionPixel, bottomSelectionPixel);
        if (!this.mStackFromBottom) {
            fillUp(max - i27, view.getTop() - i28);
            adjustViewsUpOrDown();
            fillDown(max + i27, view.getBottom() + i28);
        } else {
            fillDown(i18 + i27, view.getBottom() + i28);
            adjustViewsUpOrDown();
            fillUp(max - 1, view.getTop() - i28);
        }
        return makeRow;
    }

    private View fillFromTop(int i3) {
        int min = Math.min(this.mFirstPosition, this.mSelectedPosition);
        this.mFirstPosition = min;
        int min2 = Math.min(min, this.mItemCount - 1);
        this.mFirstPosition = min2;
        if (min2 < 0) {
            this.mFirstPosition = 0;
        }
        int i16 = this.mFirstPosition;
        int i17 = i16 - (i16 % this.mNumColumns);
        this.mFirstPosition = i17;
        return fillDown(i17, i3);
    }

    private View fillSelection(int i3, int i16) {
        int i17;
        int max;
        int i18;
        int reconcileSelectedPosition = reconcileSelectedPosition();
        int i19 = this.mNumColumns;
        int i26 = this.mVerticalSpacing;
        if (!this.mStackFromBottom) {
            max = reconcileSelectedPosition - (reconcileSelectedPosition % i19);
            i17 = -1;
        } else {
            int i27 = this.mItemCount;
            int i28 = (i27 - 1) - reconcileSelectedPosition;
            i17 = (i27 - 1) - (i28 - (i28 % i19));
            max = Math.max(0, (i17 - i19) + 1);
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int topSelectionPixel = getTopSelectionPixel(i3, verticalFadingEdgeLength, max);
        if (this.mStackFromBottom) {
            i18 = i17;
        } else {
            i18 = max;
        }
        View makeRow = makeRow(i18, topSelectionPixel, true);
        this.mFirstPosition = max;
        View view = this.mReferenceView;
        if (!this.mStackFromBottom) {
            fillDown(max + i19, view.getBottom() + i26);
            pinToBottom(i16);
            fillUp(max - i19, view.getTop() - i26);
            adjustViewsUpOrDown();
        } else {
            offsetChildrenTopAndBottomWrap(getBottomSelectionPixel(i16, verticalFadingEdgeLength, i19, max) - view.getBottom());
            fillUp(max - 1, view.getTop() - i26);
            pinToTop(i3);
            fillDown(i17 + i19, view.getBottom() + i26);
            adjustViewsUpOrDown();
        }
        return makeRow;
    }

    private View fillSpecific(int i3, int i16) {
        int i17;
        int max;
        int i18;
        View view;
        View view2;
        int i19 = this.mNumColumns;
        if (!this.mStackFromBottom) {
            max = i3 - (i3 % i19);
            i17 = -1;
        } else {
            int i26 = this.mItemCount;
            int i27 = (i26 - 1) - i3;
            i17 = (i26 - 1) - (i27 - (i27 % i19));
            max = Math.max(0, (i17 - i19) + 1);
        }
        if (this.mStackFromBottom) {
            i18 = i17;
        } else {
            i18 = max;
        }
        View makeRow = makeRow(i18, i16, true);
        this.mFirstPosition = max;
        View view3 = this.mReferenceView;
        if (view3 == null) {
            return null;
        }
        int i28 = this.mVerticalSpacing;
        if (!this.mStackFromBottom) {
            view = fillUp(max - i19, view3.getTop() - i28);
            adjustViewsUpOrDown();
            view2 = fillDown(max + i19, view3.getBottom() + i28);
            int childCount = getChildCount();
            if (childCount > 0) {
                correctTooHigh(i19, i28, childCount);
            }
        } else {
            View fillDown = fillDown(i17 + i19, view3.getBottom() + i28);
            adjustViewsUpOrDown();
            View fillUp = fillUp(max - 1, view3.getTop() - i28);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                correctTooLow(i19, i28, childCount2);
            }
            view = fillUp;
            view2 = fillDown;
        }
        if (makeRow != null) {
            return makeRow;
        }
        if (view != null) {
            return view;
        }
        return view2;
    }

    private View fillUp(int i3, int i16) {
        int i17;
        View view = null;
        if (hasBooleanFlag(34)) {
            i17 = this.mListPadding.top;
        } else {
            i17 = 0;
        }
        while (i16 > i17 && i3 >= 0) {
            View makeRow = makeRow(i3, i16, false);
            if (makeRow != null) {
                view = makeRow;
            }
            i16 = this.mReferenceView.getTop() - this.mVerticalSpacing;
            this.mFirstPosition = i3;
            i3 -= this.mNumColumns;
        }
        if (this.mStackFromBottom) {
            this.mFirstPosition = Math.max(0, i3 + 1);
        }
        return view;
    }

    private int getBottomSelectionPixel(int i3, int i16, int i17, int i18) {
        if ((i18 + i17) - 1 < this.mItemCount - 1) {
            return i3 - i16;
        }
        return i3;
    }

    private int getTopSelectionPixel(int i3, int i16, int i17) {
        if (i17 > 0) {
            return i3 + i16;
        }
        return i3;
    }

    private boolean isCandidateSelection(int i3, int i16) {
        int max;
        int i17;
        int childCount = getChildCount();
        int i18 = childCount - 1;
        int i19 = i18 - i3;
        if (!this.mStackFromBottom) {
            int i26 = this.mNumColumns;
            max = i3 - (i3 % i26);
            i17 = Math.max((i26 + max) - 1, childCount);
        } else {
            int i27 = this.mNumColumns;
            int i28 = i18 - (i19 - (i19 % i27));
            max = Math.max(0, (i28 - i27) + 1);
            i17 = i28;
        }
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 17) {
                    if (i16 != 33) {
                        if (i16 != 66) {
                            if (i16 == 130) {
                                if (max != 0) {
                                    return false;
                                }
                                return true;
                            }
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
                        }
                        if (i3 != max) {
                            return false;
                        }
                        return true;
                    }
                    if (i17 != i18) {
                        return false;
                    }
                    return true;
                }
                if (i3 != i17) {
                    return false;
                }
                return true;
            }
            if (i3 != max || max != 0) {
                return false;
            }
            return true;
        }
        if (i3 != i17 || i17 != i18) {
            return false;
        }
        return true;
    }

    private View makeAndAddView(int i3, int i16, boolean z16, int i17, boolean z17, int i18) {
        View activeView;
        if (!this.mDataChanged && (activeView = this.mRecycler.getActiveView(i3)) != null) {
            setupChild(activeView, i3, i16, z16, i17, z17, true, i18);
            return activeView;
        }
        View obtainView = obtainView(i3, this.mIsScrap);
        setupChild(obtainView, i3, i16, z16, i17, z17, this.mIsScrap[0], i18);
        return obtainView;
    }

    private View makeRow(int i3, int i16, boolean z16) {
        int i17;
        int i18;
        int i19;
        boolean z17;
        int i26;
        int i27 = this.mColumnWidth;
        int i28 = this.mHorizontalSpacing;
        int i29 = this.mListPadding.left;
        boolean z18 = false;
        if (this.mStretchMode == 3) {
            i17 = i28;
        } else {
            i17 = 0;
        }
        int i36 = i29 + i17;
        if (!this.mStackFromBottom) {
            i19 = i3;
            i18 = Math.min(i3 + this.mNumColumns, this.mItemCount);
        } else {
            int i37 = i3 + 1;
            int max = Math.max(0, (i3 - this.mNumColumns) + 1);
            int i38 = i37 - max;
            int i39 = this.mNumColumns;
            if (i38 < i39) {
                i36 += (i39 - i38) * (i27 + i28);
            }
            i18 = i37;
            i19 = max;
        }
        boolean shouldShowSelector = shouldShowSelector();
        boolean z19 = touchModeDrawsInPressedState();
        int i46 = this.mSelectedPosition;
        View view = null;
        int i47 = i36;
        View view2 = null;
        int i48 = i19;
        while (i48 < i18) {
            if (i48 == i46) {
                z17 = true;
            } else {
                z17 = z18;
            }
            if (z16) {
                i26 = -1;
            } else {
                i26 = i48 - i19;
            }
            int i49 = i48;
            int i56 = i46;
            view = makeAndAddView(i48, i16, z16, i47, z17, i26);
            i47 += i27;
            if (i49 < i18 - 1) {
                i47 += i28;
            }
            if (z17 && (shouldShowSelector || z19)) {
                view2 = view;
            }
            i48 = i49 + 1;
            i46 = i56;
            z18 = false;
        }
        this.mReferenceView = view;
        if (view2 != null) {
            this.mReferenceViewInSelectedRow = view;
        }
        return view2;
    }

    private View moveSelection(int i3, int i16, int i17) {
        int i18;
        int max;
        int i19;
        int i26;
        View makeRow;
        View view;
        int top;
        int i27;
        int i28;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int i29 = this.mSelectedPosition;
        int i36 = this.mNumColumns;
        int i37 = this.mVerticalSpacing;
        int i38 = 0;
        if (!this.mStackFromBottom) {
            int i39 = i29 - i3;
            max = i39 - (i39 % i36);
            i19 = i29 - (i29 % i36);
            i18 = -1;
        } else {
            int i46 = this.mItemCount;
            int i47 = (i46 - 1) - i29;
            i18 = (i46 - 1) - (i47 - (i47 % i36));
            int max2 = Math.max(0, (i18 - i36) + 1);
            int i48 = this.mItemCount;
            int i49 = (i48 - 1) - (i29 - i3);
            max = Math.max(0, (((i48 - 1) - (i49 - (i49 % i36))) - i36) + 1);
            i19 = max2;
        }
        int i56 = i19 - max;
        int topSelectionPixel = getTopSelectionPixel(i16, verticalFadingEdgeLength, i19);
        int bottomSelectionPixel = getBottomSelectionPixel(i17, verticalFadingEdgeLength, i36, i19);
        this.mFirstPosition = i19;
        if (i56 > 0) {
            View view2 = this.mReferenceViewInSelectedRow;
            if (view2 != null) {
                i38 = view2.getBottom();
            }
            if (this.mStackFromBottom) {
                i28 = i18;
            } else {
                i28 = i19;
            }
            makeRow = makeRow(i28, i38 + i37, true);
            view = this.mReferenceView;
            adjustForBottomFadingEdge(view, topSelectionPixel, bottomSelectionPixel);
        } else if (i56 < 0) {
            View view3 = this.mReferenceViewInSelectedRow;
            if (view3 == null) {
                top = 0;
            } else {
                top = view3.getTop();
            }
            if (this.mStackFromBottom) {
                i27 = i18;
            } else {
                i27 = i19;
            }
            makeRow = makeRow(i27, top - i37, false);
            view = this.mReferenceView;
            adjustForTopFadingEdge(view, topSelectionPixel, bottomSelectionPixel);
        } else {
            View view4 = this.mReferenceViewInSelectedRow;
            if (view4 != null) {
                i38 = view4.getTop();
            }
            if (this.mStackFromBottom) {
                i26 = i18;
            } else {
                i26 = i19;
            }
            makeRow = makeRow(i26, i38, true);
            view = this.mReferenceView;
        }
        if (!this.mStackFromBottom) {
            fillUp(i19 - i36, view.getTop() - i37);
            adjustViewsUpOrDown();
            fillDown(i19 + i36, view.getBottom() + i37);
        } else {
            fillDown(i18 + i36, view.getBottom() + i37);
            adjustViewsUpOrDown();
            fillUp(i19 - 1, view.getTop() - i37);
        }
        return makeRow;
    }

    private void pinToBottom(int i3) {
        int bottom;
        int childCount = getChildCount();
        if (this.mFirstPosition + childCount == this.mItemCount && (bottom = i3 - getChildAt(childCount - 1).getBottom()) > 0) {
            offsetChildrenTopAndBottomWrap(bottom);
        }
    }

    private void pinToTop(int i3) {
        int top;
        if (this.mFirstPosition == 0 && (top = i3 - getChildAt(0).getTop()) < 0) {
            offsetChildrenTopAndBottomWrap(top);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetApi(11)
    private void setupChild(View view, int i3, int i16, boolean z16, int i17, boolean z17, boolean z18, int i18) {
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        int i19;
        int i26;
        SparseBooleanArray sparseBooleanArray;
        if (z17 && shouldShowSelector()) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19 != view.isSelected()) {
            z26 = true;
        } else {
            z26 = false;
        }
        int i27 = this.mTouchMode;
        if (i27 > 0 && i27 < 3 && this.mMotionPosition == i3) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z27 != view.isPressed()) {
            z28 = true;
        } else {
            z28 = false;
        }
        if (z18 && !z26 && !view.isLayoutRequested()) {
            z29 = false;
        } else {
            z29 = true;
        }
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (AbsListView.LayoutParams) generateDefaultLayoutParams();
        }
        layoutParams.viewType = this.mAdapter.getItemViewType(i3);
        if (z18 && !layoutParams.forceAdd) {
            attachViewToParent(view, i18, layoutParams);
        } else {
            layoutParams.forceAdd = false;
            addViewInLayout(view, i18, layoutParams, true);
        }
        if (z26) {
            view.setSelected(z19);
            if (z19) {
                requestFocus();
            }
        }
        if (z28) {
            view.setPressed(z27);
        }
        if (this.mChoiceMode != 0 && (sparseBooleanArray = this.mCheckStates) != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(sparseBooleanArray.get(i3));
            } else if (getContext().getApplicationInfo().targetSdkVersion >= 11) {
                view.setActivated(this.mCheckStates.get(i3));
            }
        }
        if (z29) {
            view.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(this.mColumnWidth, 1073741824), 0, ((ViewGroup.LayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, ((ViewGroup.LayoutParams) layoutParams).height));
        } else {
            cleanupLayoutState(view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (z16) {
            i19 = i16;
        } else {
            i19 = i16 - measuredHeight;
        }
        int i28 = this.mGravity & 7;
        if (i28 != 1) {
            if (i28 != 5) {
                i26 = i17;
            } else {
                i26 = (i17 + this.mColumnWidth) - measuredWidth;
            }
        } else {
            i26 = i17 + ((this.mColumnWidth - measuredWidth) / 2);
        }
        if (z29) {
            view.layout(i26, i19, measuredWidth + i26, measuredHeight + i19);
        } else {
            view.offsetLeftAndRight(i26 - view.getLeft());
            view.offsetTopAndBottom(i19 - view.getTop());
        }
        if (this.mCachingStarted) {
            view.setDrawingCacheEnabled(true);
        }
        if (z18 && ((AbsListView.LayoutParams) view.getLayoutParams()).scrappedFromPosition != i3) {
            view.jumpDrawablesToCurrentState();
        }
    }

    boolean arrowScroll(int i3) {
        int i16;
        int max;
        int i17 = this.mSelectedPosition;
        int i18 = this.mNumColumns;
        boolean z16 = true;
        if (!this.mStackFromBottom) {
            max = (i17 / i18) * i18;
            i16 = Math.min((max + i18) - 1, this.mItemCount - 1);
        } else {
            int i19 = this.mItemCount;
            i16 = (i19 - 1) - ((((i19 - 1) - i17) / i18) * i18);
            max = Math.max(0, (i16 - i18) + 1);
        }
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        int i26 = this.mItemCount;
                        if (i16 < i26 - 1) {
                            this.mLayoutMode = 6;
                            setSelectionInt(Math.min(i17 + i18, i26 - 1));
                        }
                    }
                    z16 = false;
                } else {
                    if (i17 < i16) {
                        this.mLayoutMode = 6;
                        setSelectionInt(Math.min(i17 + 1, this.mItemCount - 1));
                    }
                    z16 = false;
                }
            } else {
                if (max > 0) {
                    this.mLayoutMode = 6;
                    setSelectionInt(Math.max(0, i17 - i18));
                }
                z16 = false;
            }
        } else {
            if (i17 > max) {
                this.mLayoutMode = 6;
                setSelectionInt(Math.max(0, i17 - 1));
            }
            z16 = false;
        }
        if (z16) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i3));
            invokeOnItemScrollListener();
        }
        if (z16) {
            awakenScrollBars();
        }
        return z16;
    }

    @Override // android.view.ViewGroup
    protected void attachLayoutAnimationParameters(View view, ViewGroup.LayoutParams layoutParams, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, view, layoutParams, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        GridLayoutAnimationController.AnimationParameters animationParameters = (GridLayoutAnimationController.AnimationParameters) layoutParams.layoutAnimationParameters;
        if (animationParameters == null) {
            animationParameters = new GridLayoutAnimationController.AnimationParameters();
            layoutParams.layoutAnimationParameters = animationParameters;
        }
        animationParameters.count = i16;
        animationParameters.index = i3;
        int i17 = this.mNumColumns;
        animationParameters.columnsCount = i17;
        int i18 = i16 / i17;
        animationParameters.rowsCount = i18;
        if (!this.mStackFromBottom) {
            animationParameters.column = i3 % i17;
            animationParameters.row = i3 / i17;
        } else {
            int i19 = (i16 - 1) - i3;
            animationParameters.column = (i17 - 1) - (i19 % i17);
            animationParameters.row = (i18 - 1) - (i19 / i17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, android.view.View
    public int computeVerticalScrollExtent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        int childCount = getChildCount();
        if (childCount <= 0) {
            return 0;
        }
        int i3 = (((childCount + r2) - 1) / this.mNumColumns) * 100;
        View childAt = getChildAt(0);
        int top = childAt.getTop();
        int height = childAt.getHeight();
        if (height > 0) {
            i3 += (top * 100) / height;
        }
        View childAt2 = getChildAt(childCount - 1);
        int bottom = childAt2.getBottom();
        int height2 = childAt2.getHeight();
        if (height2 > 0) {
            return i3 - (((bottom - getHeight()) * 100) / height2);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, android.view.View
    public int computeVerticalScrollOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        if (this.mFirstPosition >= 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int top = childAt.getTop();
            int height = childAt.getHeight();
            if (height > 0) {
                return Math.max((((this.mFirstPosition / this.mNumColumns) * 100) - ((top * 100) / height)) + ((int) ((getScrollY() / getHeight()) * (((this.mItemCount + r3) - 1) / r3) * 100.0f)), 0);
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, android.view.View
    public int computeVerticalScrollRange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        int i3 = ((this.mItemCount + r0) - 1) / this.mNumColumns;
        int max = Math.max(i3 * 100, 0);
        if (getScrollY() != 0) {
            return max + Math.abs((int) ((getScrollY() / getHeight()) * i3 * 100.0f));
        }
        return max;
    }

    @Override // com.tencent.widget.AbsListView
    void fillGap(boolean z16) {
        int i3;
        int height;
        int i16;
        int i17 = this.mNumColumns;
        int i18 = this.mVerticalSpacing;
        int childCount = getChildCount();
        int i19 = 0;
        if (z16) {
            if (hasBooleanFlag(34)) {
                i19 = getListPaddingTop();
            }
            if (childCount > 0) {
                i19 = getChildAt(childCount - 1).getBottom() + i18;
            }
            int i26 = this.mFirstPosition + childCount;
            if (this.mStackFromBottom) {
                i26 += i17 - 1;
            }
            fillDown(i26, i19);
            correctTooHigh(i17, i18, getChildCount());
            return;
        }
        if (hasBooleanFlag(34)) {
            i3 = getListPaddingBottom();
        } else {
            i3 = 0;
        }
        if (childCount > 0) {
            height = getChildAt(0).getTop() - i18;
        } else {
            height = getHeight() - i3;
        }
        int i27 = this.mFirstPosition;
        if (!this.mStackFromBottom) {
            i16 = i27 - i17;
        } else {
            i16 = i27 - 1;
        }
        fillUp(i16, height);
        correctTooLow(i17, i18, getChildCount());
    }

    @Override // com.tencent.widget.AbsListView
    int findMotionRow(int i3) {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i16 = this.mNumColumns;
            if (!this.mStackFromBottom) {
                for (int i17 = 0; i17 < childCount; i17 += i16) {
                    if (i3 <= getChildAt(i17).getBottom()) {
                        return this.mFirstPosition + i17;
                    }
                }
                return -1;
            }
            for (int i18 = childCount - 1; i18 >= 0; i18 -= i16) {
                if (i3 >= getChildAt(i18).getTop()) {
                    return this.mFirstPosition + i18;
                }
            }
            return -1;
        }
        return -1;
    }

    boolean fullScroll(int i3) {
        boolean z16 = true;
        if (i3 == 33) {
            this.mLayoutMode = 2;
            setSelectionInt(0);
            invokeOnItemScrollListener();
        } else if (i3 == 130) {
            this.mLayoutMode = 2;
            setSelectionInt(this.mItemCount - 1);
            invokeOnItemScrollListener();
        } else {
            z16 = false;
        }
        if (z16) {
            awakenScrollBars();
        }
        return z16;
    }

    public int getColumnWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return this.mColumnWidth;
    }

    public int getGravity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.mGravity;
    }

    public int getHorizontalSpacing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.mHorizontalSpacing;
    }

    @ViewDebug.ExportedProperty
    public int getNumColumns() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        return this.mNumColumns;
    }

    public int getRequestedColumnWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        return this.mRequestedColumnWidth;
    }

    public int getRequestedHorizontalSpacing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.mRequestedHorizontalSpacing;
    }

    public int getStretchMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.mStretchMode;
    }

    public int getVerticalSpacing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return this.mVerticalSpacing;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0046. Please report as an issue. */
    @Override // com.tencent.widget.AbsListView
    public void layoutChildren() {
        int i3;
        View view;
        View view2;
        View fillFromTop;
        int i16;
        int i17;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        boolean z16 = this.mBlockLayoutRequests;
        if (!z16) {
            this.mBlockLayoutRequests = true;
        }
        try {
            super.layoutChildren();
            invalidate();
            if (this.mAdapter == null) {
                resetList();
                invokeOnItemScrollListener();
                if (!z16) {
                    return;
                } else {
                    return;
                }
            }
            int i18 = this.mListPadding.top;
            int bottom = (getBottom() - getTop()) - this.mListPadding.bottom;
            int childCount = getChildCount();
            View view4 = null;
            switch (this.mLayoutMode) {
                case 1:
                case 3:
                case 4:
                case 5:
                    i3 = 0;
                    view = null;
                    view2 = null;
                    break;
                case 2:
                    int i19 = this.mNextSelectedPosition - this.mFirstPosition;
                    if (i19 >= 0 && i19 < childCount) {
                        view = null;
                        view2 = null;
                        view4 = getChildAt(i19);
                        i3 = 0;
                        break;
                    }
                    i3 = 0;
                    view = null;
                    view2 = null;
                    break;
                case 6:
                    int i26 = this.mNextSelectedPosition;
                    if (i26 >= 0) {
                        i3 = i26 - this.mSelectedPosition;
                        view = null;
                        view2 = null;
                        break;
                    }
                    i3 = 0;
                    view = null;
                    view2 = null;
                default:
                    int i27 = this.mSelectedPosition - this.mFirstPosition;
                    if (i27 >= 0 && i27 < childCount) {
                        view3 = getChildAt(i27);
                    } else {
                        view3 = null;
                    }
                    view = getChildAt(0);
                    view2 = view3;
                    i3 = 0;
                    break;
            }
            boolean z17 = this.mDataChanged;
            if (z17) {
                handleDataChanged();
            }
            if (this.mItemCount == 0) {
                resetList();
                invokeOnItemScrollListener();
                if (!z16) {
                    this.mBlockLayoutRequests = false;
                    return;
                }
                return;
            }
            setSelectedPositionInt(this.mNextSelectedPosition);
            int i28 = this.mFirstPosition;
            AbsListView.RecycleBin recycleBin = this.mRecycler;
            if (z17) {
                for (int i29 = 0; i29 < childCount; i29++) {
                    recycleBin.addScrapView(getChildAt(i29), i28 + i29);
                }
            } else {
                recycleBin.fillActiveViews(childCount, i28);
            }
            detachAllViewsFromParent();
            switch (this.mLayoutMode) {
                case 1:
                    this.mFirstPosition = 0;
                    fillFromTop = fillFromTop(i18);
                    adjustViewsUpOrDown();
                    break;
                case 2:
                    if (view4 != null) {
                        fillFromTop = fillFromSelection(view4.getTop(), i18, bottom);
                        break;
                    } else {
                        fillFromTop = fillSelection(i18, bottom);
                        break;
                    }
                case 3:
                    fillFromTop = fillUp(this.mItemCount - 1, bottom);
                    adjustViewsUpOrDown();
                    break;
                case 4:
                    fillFromTop = fillSpecific(this.mSelectedPosition, this.mSpecificTop);
                    break;
                case 5:
                    fillFromTop = fillSpecific(this.mSyncPosition, this.mSpecificTop);
                    break;
                case 6:
                    fillFromTop = moveSelection(i3, i18, bottom);
                    break;
                default:
                    if (childCount == 0) {
                        if (!this.mStackFromBottom) {
                            if (this.mAdapter != null && !isInTouchMode()) {
                                i17 = 0;
                                setSelectedPositionInt(i17);
                                fillFromTop = fillFromTop(i18);
                                break;
                            }
                            i17 = -1;
                            setSelectedPositionInt(i17);
                            fillFromTop = fillFromTop(i18);
                        } else {
                            int i36 = this.mItemCount - 1;
                            if (this.mAdapter != null && !isInTouchMode()) {
                                i16 = i36;
                                setSelectedPositionInt(i16);
                                fillFromTop = fillFromBottom(i36, bottom);
                                break;
                            }
                            i16 = -1;
                            setSelectedPositionInt(i16);
                            fillFromTop = fillFromBottom(i36, bottom);
                        }
                    } else {
                        int i37 = this.mSelectedPosition;
                        if (i37 >= 0 && i37 < this.mItemCount) {
                            if (view2 != null) {
                                i18 = view2.getTop();
                            }
                            fillFromTop = fillSpecific(i37, i18);
                            break;
                        } else {
                            int i38 = this.mFirstPosition;
                            if (i38 < this.mItemCount) {
                                if (view != null) {
                                    i18 = view.getTop();
                                }
                                fillFromTop = fillSpecific(i38, i18);
                                break;
                            } else {
                                fillFromTop = fillSpecific(0, i18);
                                break;
                            }
                        }
                    }
                    break;
            }
            recycleBin.scrapActiveViews();
            if (fillFromTop != null) {
                positionSelector(-1, fillFromTop);
                this.mSelectedTop = fillFromTop.getTop();
            } else {
                int i39 = this.mTouchMode;
                if (i39 > 0 && i39 < 3) {
                    View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
                    if (childAt != null) {
                        positionSelector(this.mMotionPosition, childAt);
                    }
                } else {
                    this.mSelectedTop = 0;
                    this.mSelectorRect.setEmpty();
                }
            }
            this.mLayoutMode = 0;
            this.mDataChanged = false;
            this.mNeedSync = false;
            setNextSelectedPositionInt(this.mSelectedPosition);
            updateScrollIndicators();
            if (this.mItemCount > 0) {
                checkSelectionChanged();
            }
            invokeOnItemScrollListener();
            if (!z16) {
                this.mBlockLayoutRequests = false;
            }
        } finally {
            if (!z16) {
                this.mBlockLayoutRequests = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.widget.AdapterView
    public int lookForSelectablePosition(int i3, boolean z16) {
        if (this.mAdapter == null || isInTouchMode() || i3 < 0 || i3 >= this.mItemCount) {
            return -1;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z16, int i3, Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), Integer.valueOf(i3), rect);
            return;
        }
        super.onFocusChanged(z16, i3, rect);
        int i16 = -1;
        if (z16 && rect != null) {
            rect.offset(getScrollX(), getScrollY());
            Rect rect2 = this.mTempRect;
            int childCount = getChildCount();
            int i17 = Integer.MAX_VALUE;
            for (int i18 = 0; i18 < childCount; i18++) {
                if (isCandidateSelection(i18, i3)) {
                    View childAt = getChildAt(i18);
                    childAt.getDrawingRect(rect2);
                    offsetDescendantRectToMyCoords(childAt, rect2);
                    int distance = AbsListView.getDistance(rect, rect2, i3);
                    if (distance < i17) {
                        i16 = i18;
                        i17 = distance;
                    }
                }
            }
        }
        if (i16 >= 0) {
            setSelection(i16 + this.mFirstPosition);
        } else {
            requestLayout();
        }
    }

    @Override // com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) accessibilityEvent);
        } else {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(GridView.class.getName());
        }
    }

    @Override // com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) accessibilityNodeInfo);
        } else {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(GridView.class.getName());
        }
    }

    @Override // com.tencent.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return commonKey(i3, 1, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i3, int i16, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), keyEvent)).booleanValue();
        }
        return commonKey(i3, i16, keyEvent);
    }

    @Override // com.tencent.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return commonKey(i3, 1, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        int count;
        int i17;
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mIsOnMeasure = true;
        super.onMeasure(i3, i16);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode == 0) {
            int i26 = this.mColumnWidth;
            if (i26 > 0) {
                Rect rect = this.mListPadding;
                i19 = i26 + rect.left + rect.right;
            } else {
                Rect rect2 = this.mListPadding;
                i19 = rect2.right + rect2.left;
            }
            size = i19 + getVerticalScrollbarWidth();
        }
        Rect rect3 = this.mListPadding;
        boolean determineColumns = determineColumns((size - rect3.left) - rect3.right);
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            count = 0;
        } else {
            count = listAdapter.getCount();
        }
        this.mItemCount = count;
        if (count > 0) {
            View obtainView = obtainView(0, this.mIsScrap);
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) obtainView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = (AbsListView.LayoutParams) generateDefaultLayoutParams();
                obtainView.setLayoutParams(layoutParams);
            }
            layoutParams.viewType = this.mAdapter.getItemViewType(0);
            layoutParams.forceAdd = true;
            obtainView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(this.mColumnWidth, 1073741824), 0, ((ViewGroup.LayoutParams) layoutParams).width), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, ((ViewGroup.LayoutParams) layoutParams).height));
            i17 = obtainView.getMeasuredHeight();
            if (this.mRecycler.shouldRecycleViewType(layoutParams.viewType)) {
                this.mRecycler.addScrapView(obtainView, -1);
            }
        } else {
            i17 = 0;
        }
        if (mode2 == 0) {
            Rect rect4 = this.mListPadding;
            size2 = (getVerticalFadingEdgeLength() * 2) + rect4.top + rect4.bottom + i17;
        }
        if (mode2 == Integer.MIN_VALUE) {
            Rect rect5 = this.mListPadding;
            int i27 = rect5.top + rect5.bottom;
            int i28 = this.mNumColumns;
            int i29 = 0;
            while (true) {
                if (i29 < count) {
                    i27 += i17;
                    i29 += i28;
                    if (i29 < count) {
                        i27 += this.mVerticalSpacing;
                    }
                    if (i27 >= size2) {
                        break;
                    }
                } else {
                    size2 = i27;
                    break;
                }
            }
        }
        if (mode == Integer.MIN_VALUE && (i18 = this.mRequestedNumColumns) != -1) {
            int i36 = (this.mColumnWidth * i18) + ((i18 - 1) * this.mHorizontalSpacing);
            Rect rect6 = this.mListPadding;
            if (i36 + rect6.left + rect6.right > size || determineColumns) {
                size |= 16777216;
            }
        }
        setMeasuredDimension(size, size2);
        this.mWidthMeasureSpec = i3;
        this.mIsOnMeasure = false;
    }

    boolean pageScroll(int i3) {
        int i16;
        if (i3 == 33) {
            i16 = Math.max(0, this.mSelectedPosition - getChildCount());
        } else if (i3 == 130) {
            i16 = Math.min(this.mItemCount - 1, this.mSelectedPosition + getChildCount());
        } else {
            i16 = -1;
        }
        if (i16 < 0) {
            return false;
        }
        setSelectionInt(i16);
        invokeOnItemScrollListener();
        awakenScrollBars();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
    
        if (r0 == r1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0049, code lost:
    
        r0 = r4;
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        if (r0 == r3) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean sequenceScroll(int i3) {
        int max;
        int i16;
        boolean z16;
        int i17 = this.mSelectedPosition;
        int i18 = this.mNumColumns;
        int i19 = this.mItemCount;
        boolean z17 = false;
        if (!this.mStackFromBottom) {
            max = (i17 / i18) * i18;
            i16 = Math.min((i18 + max) - 1, i19 - 1);
        } else {
            int i26 = i19 - 1;
            int i27 = i26 - (((i26 - i17) / i18) * i18);
            max = Math.max(0, (i27 - i18) + 1);
            i16 = i27;
        }
        if (i3 != 1) {
            if (i3 == 2 && i17 < i19 - 1) {
                this.mLayoutMode = 6;
                setSelectionInt(i17 + 1);
            }
            z16 = false;
        } else {
            if (i17 > 0) {
                this.mLayoutMode = 6;
                setSelectionInt(i17 - 1);
            }
            z16 = false;
        }
        if (z17) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i3));
            invokeOnItemScrollListener();
        }
        if (z16) {
            awakenScrollBars();
        }
        return z17;
    }

    public void setColumnWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else if (i3 != this.mRequestedColumnWidth) {
            this.mRequestedColumnWidth = i3;
            requestLayoutIfNecessary();
        }
    }

    public void setGravity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else if (this.mGravity != i3) {
            this.mGravity = i3;
            requestLayoutIfNecessary();
        }
    }

    public void setHorizontalSpacing(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else if (i3 != this.mRequestedHorizontalSpacing) {
            this.mRequestedHorizontalSpacing = i3;
            requestLayoutIfNecessary();
        }
    }

    public void setNumColumns(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
        } else if (i3 != this.mRequestedNumColumns) {
            this.mRequestedNumColumns = i3;
            requestLayoutIfNecessary();
        }
    }

    @Override // com.tencent.widget.AdapterView
    public void setSelection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
            return;
        }
        if (!isInTouchMode()) {
            setNextSelectedPositionInt(i3);
        } else {
            this.mResurrectToPosition = i3;
        }
        this.mLayoutMode = 2;
        AbsListView.PositionScroller positionScroller = this.mPositionScroller;
        if (positionScroller != null) {
            positionScroller.stop();
        }
        requestLayout();
    }

    @Override // com.tencent.widget.AbsListView
    void setSelectionInt(int i3) {
        int i16;
        int i17 = this.mNextSelectedPosition;
        AbsListView.PositionScroller positionScroller = this.mPositionScroller;
        if (positionScroller != null) {
            positionScroller.stop();
        }
        setNextSelectedPositionInt(i3);
        layoutChildren();
        boolean z16 = this.mStackFromBottom;
        if (z16) {
            i16 = (this.mItemCount - 1) - this.mNextSelectedPosition;
        } else {
            i16 = this.mNextSelectedPosition;
        }
        if (z16) {
            i17 = (this.mItemCount - 1) - i17;
        }
        int i18 = this.mNumColumns;
        if (i16 / i18 != i17 / i18) {
            awakenScrollBars();
        }
    }

    public void setStretchMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else if (i3 != this.mStretchMode) {
            this.mStretchMode = i3;
            requestLayoutIfNecessary();
        }
    }

    public void setVerticalSpacing(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else if (i3 != this.mVerticalSpacing) {
            this.mVerticalSpacing = i3;
            requestLayoutIfNecessary();
        }
    }

    @Override // com.tencent.widget.AbsListView
    public void smoothScrollByOffset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            super.smoothScrollByOffset(i3);
        }
    }

    @Override // com.tencent.widget.AbsListView
    public void smoothScrollToPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            super.smoothScrollToPosition(i3);
        }
    }

    public GridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.gridViewStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    @Override // com.tencent.widget.AdapterView
    public ListAdapter getAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.mAdapter : (ListAdapter) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.widget.AbsListView, com.tencent.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        int lookForSelectablePosition;
        AbsListView.AdapterDataSetObserver adapterDataSetObserver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listAdapter);
            return;
        }
        ListAdapter listAdapter2 = this.mAdapter;
        if (listAdapter2 != null && (adapterDataSetObserver = this.mDataSetObserver) != null) {
            listAdapter2.unregisterDataSetObserver(adapterDataSetObserver);
        }
        resetList();
        this.mRecycler.clear();
        this.mAdapter = listAdapter;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        ListAdapter listAdapter3 = this.mAdapter;
        if (listAdapter3 != null) {
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = listAdapter3.getCount();
            this.mDataChanged = true;
            checkFocus();
            AbsListView.AdapterDataSetObserver adapterDataSetObserver2 = new AbsListView.AdapterDataSetObserver();
            this.mDataSetObserver = adapterDataSetObserver2;
            this.mAdapter.registerDataSetObserver(adapterDataSetObserver2);
            this.mRecycler.setViewTypeCount(this.mAdapter.getViewTypeCount());
            if (this.mStackFromBottom) {
                lookForSelectablePosition = lookForSelectablePosition(this.mItemCount - 1, false);
            } else {
                lookForSelectablePosition = lookForSelectablePosition(0, true);
            }
            setSelectedPositionInt(lookForSelectablePosition);
            setNextSelectedPositionInt(lookForSelectablePosition);
            checkSelectionChanged();
        } else {
            checkFocus();
            checkSelectionChanged();
        }
        requestLayout();
    }

    public GridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mNumColumns = -1;
        this.mHorizontalSpacing = 0;
        this.mVerticalSpacing = 0;
        this.mStretchMode = 2;
        this.mReferenceView = null;
        this.mReferenceViewInSelectedRow = null;
        this.mGravity = 3;
        this.mTempRect = new Rect();
        this.mIsOnMeasure = false;
        setEdgeEffectEnabled(false);
        this.mOverscrollDistance = Integer.MAX_VALUE;
    }
}
