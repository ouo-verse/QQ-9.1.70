package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RemoteViews;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.SkinnableView;
import com.tencent.util.ReflectionUtil;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XBaseAdapter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
@RemoteViews.RemoteView
@Deprecated
/* loaded from: classes27.dex */
public class ListView extends AbsListView implements SkinnableView {
    static IPatchRedirector $redirector_ = null;
    private static final int ANIMATION_DURATION = 350;
    private static final int ANIMATION_TAG = 2131230829;
    public static final int HEADERVIEW_LEVEL_BOTTOM = 2;
    public static final int HEADERVIEW_LEVEL_MIDDLE = 1;
    public static final int HEADERVIEW_LEVEL_TOP = 0;
    public static final int HEADERVIEW_MAX_LEVEL = 3;
    private static final int[] LISTVIEW_STYLEABLE;
    private static final float MAX_SCROLL_FACTOR = 0.33f;
    private static final int MIN_SCROLL_PREVIEW_PIXELS = 2;
    static final int NO_POSITION = -1;
    protected static final int OVERSCROLL_STATUS_COMPLETE_RELEASE = 3;
    protected static final int OVERSCROLL_STATUS_COMPLETE_VISABLE = 2;
    protected static final int OVERSCROLL_STATUS_IDLE = 0;
    private static final int OVERSCROLL_STATUS_VISABLE = 1;
    private boolean considerFooterWhenDrawOverScrollFooter;
    private long delAnimDuration;
    public boolean isTouchHolding;
    private int[] mAddingRows;
    private boolean mAnimation;
    private boolean mAreAllItemsSelectable;
    private final ArrowScrollFocusResult mArrowScrollFocusResult;
    private Drawable mContentBackgroundDrawable;
    Drawable mDivider;
    int mDividerHeight;
    private boolean mDividerIsOpaque;
    private Paint mDividerPaint;
    private FocusSelector mFocusSelector;
    private boolean mFooterDividersEnabled;
    private ArrayList<FixedViewInfo> mFooterViewInfos;
    private boolean mHeaderDividersEnabled;
    protected ArrayList<FixedViewInfo> mHeaderViewInfos;
    protected int[] mHeaderViewLevelIndex;
    private Animation mInsertAnimation;
    private boolean mIsCacheColorOpaque;
    private boolean mItemsCanFocus;
    private OnScrollChangeListener mOnScrollChangeListener;
    protected OnSpringBackListener mOnSpringBackListener;
    Drawable mOverScrollFooter;
    protected int mOverScrollFooterHeight;
    Drawable mOverScrollHeader;
    protected Drawable mOverScrollHeaderShadow;
    int mOverScrollHeaderTopOffset;
    protected int mOverScrollHeight;
    protected OverScrollViewListener mOverScrollViewListener;
    protected OverscrollViewContainer mOverscrollFooterView;
    protected int mOverscrollHeadState;
    public OverscrollViewContainer mOverscrollHeaderViewContainer;
    private final Rect mTempRect;
    private boolean mUseEfficientMode;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ArrowScrollFocusResult {
        static IPatchRedirector $redirector_;
        private int mAmountToScroll;
        private int mSelectedPosition;

        ArrowScrollFocusResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public int getAmountToScroll() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.mAmountToScroll;
        }

        public int getSelectedPosition() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.mSelectedPosition;
        }

        void populate(int i3, int i16) {
            this.mSelectedPosition = i3;
            this.mAmountToScroll = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class FixedViewInfo {
        static IPatchRedirector $redirector_;
        public Object data;
        public boolean isSelectable;
        public View view;

        public FixedViewInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ListView.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class FocusSelector implements Runnable {
        static IPatchRedirector $redirector_;
        private int mPosition;
        private int mPositionTop;

        FocusSelector() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ListView.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                ListView.this.setSelectionFromTop(this.mPosition, this.mPositionTop);
            }
        }

        public FocusSelector setup(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FocusSelector) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
            this.mPosition = i3;
            this.mPositionTop = i16;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class ListDataSetObserver extends AbsListView.AdapterDataSetObserver implements XBaseAdapter.ListDataSetListener {
        static IPatchRedirector $redirector_;

        ListDataSetObserver() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ListView.this);
            }
        }

        private void calcAnimation(int i3, int i16, int i17, int i18, boolean z16) {
            int i19 = 0;
            if (z16) {
                while (i19 < i3) {
                    View childAt = ListView.this.getChildAt(i19);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(ListView.this.getDelAnimationDuration());
                    childAt.setAnimation(alphaAnimation);
                    i19++;
                }
                return;
            }
            while (i19 <= i16) {
                View childAt2 = ListView.this.getChildAt(i19);
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, i17, 0.0f);
                translateAnimation.setDuration(ListView.this.getDelAnimationDuration());
                childAt2.setAnimation(translateAnimation);
                i19++;
            }
            while (true) {
                i16++;
                if (i16 < i3) {
                    View childAt3 = ListView.this.getChildAt(i16);
                    TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, i18, 0.0f);
                    translateAnimation2.setDuration(ListView.this.getDelAnimationDuration());
                    childAt3.setAnimation(translateAnimation2);
                } else {
                    return;
                }
            }
        }

        private int calcNewPosition(int i3, int i16, int i17, int i18, int i19) {
            if (i3 > i19 || i3 < i18) {
                return -1;
            }
            if (i3 >= i16) {
                if (i3 <= i17) {
                    return -1;
                }
                return i3 - ((i17 - i16) + 1);
            }
            return i3;
        }

        private int calcNewPositionAdd(int i3, int i16, int i17, int i18, int i19) {
            if (i3 <= i19 && i3 >= i18) {
                if (i3 >= i16) {
                    return i3 + (i17 - i16) + 1;
                }
                return i3;
            }
            return -1;
        }

        private void offsetBottom(int i3, int i16, int i17, int i18) {
            if (i18 > 0) {
                int i19 = -1;
                while (i17 < i3) {
                    View childAt = ListView.this.getChildAt(i17);
                    if (childAt.getTop() + i18 > i16) {
                        ListView listView = ListView.this;
                        listView.mRecycler.addScrapView(childAt, listView.mFirstPosition + i17);
                        if (i19 < 0) {
                            i19 = i17;
                        }
                    } else {
                        childAt.offsetTopAndBottom(i18);
                    }
                    i17++;
                }
                if (i19 >= 0) {
                    ListView.this.detachViewsFromParent(i19, i3 - i19);
                    return;
                }
                return;
            }
            if (i18 < 0) {
                while (i17 < i3) {
                    ListView.this.getChildAt(i17).offsetTopAndBottom(i18);
                    i17++;
                }
                ListView.this.fillGap(true);
            }
        }

        private void offsetTop(int i3, int i16, int i17) {
            if (i16 < 0) {
                return;
            }
            if (i17 > 0) {
                int i18 = -1;
                while (i16 >= 0) {
                    View childAt = ListView.this.getChildAt(i16);
                    if (childAt.getBottom() - i17 < i3) {
                        ListView listView = ListView.this;
                        listView.mRecycler.addScrapView(childAt, listView.mFirstPosition + i16);
                        if (i18 < 0) {
                            i18 = i16;
                        }
                    } else {
                        childAt.offsetTopAndBottom(-i17);
                    }
                    i16--;
                }
                if (i18 >= 0) {
                    int i19 = i18 + 1;
                    ListView.this.detachViewsFromParent(0, i19);
                    ListView.this.mFirstPosition += i19;
                    return;
                }
                return;
            }
            if (i17 < 0) {
                ListView.this.fillGap(false);
            }
        }

        private int updateAfter(int i3, int i16, int i17, int i18) {
            int i19 = i17;
            int i26 = 0;
            int i27 = Integer.MIN_VALUE;
            while (true) {
                if (i19 <= i18) {
                    if (i27 > i16) {
                        break;
                    }
                    View childAt = ListView.this.getChildAt(i19);
                    if (i27 == Integer.MIN_VALUE) {
                        i27 = childAt.getTop();
                    }
                    int i28 = i27;
                    int height = childAt.getHeight();
                    ListView listView = ListView.this;
                    int updateChild = listView.updateChild(childAt, listView.mFirstPosition + i19, i28, true, listView.mListPadding.left, i19);
                    i26 += updateChild;
                    i27 = i28 + height + updateChild + ListView.this.mDividerHeight;
                    i19++;
                } else {
                    i19 = -1;
                    break;
                }
            }
            if (i19 >= 0) {
                for (int i29 = i19; i29 < i3; i29++) {
                    ListView listView2 = ListView.this;
                    listView2.mRecycler.addScrapView(listView2.getChildAt(i29), ListView.this.mFirstPosition + i29);
                }
                ListView.this.detachViewsFromParent(i19, i3 - i19);
                return 0;
            }
            return i26;
        }

        private int updateBefore(int i3, int i16, int i17) {
            int i18 = 0;
            int i19 = Integer.MAX_VALUE;
            while (true) {
                if (i17 >= i16) {
                    if (i19 < i3) {
                        break;
                    }
                    View childAt = ListView.this.getChildAt(i17);
                    if (i19 == Integer.MAX_VALUE) {
                        i19 = childAt.getBottom();
                    }
                    int i26 = i19;
                    int height = childAt.getHeight();
                    ListView listView = ListView.this;
                    int updateChild = listView.updateChild(childAt, listView.mFirstPosition + i17, i26, false, listView.mListPadding.left, i17);
                    i18 += updateChild;
                    i19 = i26 - ((height + updateChild) + ListView.this.mDividerHeight);
                    i17--;
                } else {
                    i17 = -1;
                    break;
                }
            }
            if (i17 >= 0) {
                for (int i27 = 0; i27 <= i17; i27++) {
                    ListView listView2 = ListView.this;
                    listView2.mRecycler.addScrapView(listView2.getChildAt(i27), ListView.this.mFirstPosition + i27);
                }
                int i28 = i17 + 1;
                ListView.this.detachViewsFromParent(0, i28);
                ListView.this.mFirstPosition += i28;
                return 0;
            }
            return i18;
        }

        @Override // com.tencent.widget.XBaseAdapter.ListDataSetListener
        public void onRowDeleted(int... iArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                onChanged();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) iArr);
            }
        }

        @Override // com.tencent.widget.XBaseAdapter.ListDataSetListener
        public void onRowInserted(int i3, int i16) {
            boolean z16;
            int size;
            int bottom;
            boolean z17;
            int i17 = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            ListView listView = ListView.this;
            if (listView.mItemCount > 0) {
                System.nanoTime();
                if (i16 >= i17) {
                    if (i17 >= 0) {
                        ListView listView2 = ListView.this;
                        if (i17 <= (listView2.mItemCount - listView2.getHeaderViewsCount()) - ListView.this.getFooterViewsCount()) {
                            ListView listView3 = ListView.this;
                            if (!listView3.mNeedSync && !listView3.mDataChanged) {
                                if (listView3.mItemCount == 0) {
                                    return;
                                }
                                int headerViewsCount = i17 + listView3.getHeaderViewsCount();
                                int headerViewsCount2 = i16 + ListView.this.getHeaderViewsCount();
                                int i18 = (headerViewsCount2 - headerViewsCount) + 1;
                                int childCount = ListView.this.getChildCount();
                                ListView listView4 = ListView.this;
                                int i19 = listView4.mFirstPosition;
                                int i26 = (i19 + childCount) - 1;
                                int i27 = listView4.mItemCount;
                                if (headerViewsCount == i27) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                FastScroller fastScroller = listView4.mFastScroller;
                                if (fastScroller != null) {
                                    fastScroller.onItemCountChanged(i27, i27 - i18);
                                }
                                ListView listView5 = ListView.this;
                                listView5.mItemCount += i18;
                                int i28 = listView5.mSelectedPosition;
                                if (i28 >= 0) {
                                    int calcNewPositionAdd = calcNewPositionAdd(i28, headerViewsCount, headerViewsCount2, i19, i26);
                                    ListView.this.setSelectedPositionInt(calcNewPositionAdd);
                                    ListView.this.setNextSelectedPositionInt(calcNewPositionAdd);
                                } else {
                                    int i29 = listView5.mSelectorPosition;
                                    if (i29 >= 0) {
                                        listView5.mSelectedPosition = calcNewPositionAdd(i29, headerViewsCount, headerViewsCount2, i19, i26);
                                    }
                                }
                                ListView listView6 = ListView.this;
                                int i36 = listView6.mMotionPosition;
                                if (i36 >= 0) {
                                    listView6.mMotionPosition = calcNewPositionAdd(i36, headerViewsCount, headerViewsCount2, i19, i26);
                                }
                                SparseBooleanArray sparseBooleanArray = ListView.this.mCheckStates;
                                if (sparseBooleanArray == null) {
                                    size = 0;
                                } else {
                                    size = sparseBooleanArray.size();
                                }
                                if (size > 0) {
                                    for (int i37 = 0; i37 < size; i37++) {
                                        int keyAt = ListView.this.mCheckStates.keyAt(i37);
                                        boolean valueAt = ListView.this.mCheckStates.valueAt(i37);
                                        if (keyAt >= headerViewsCount) {
                                            ListView.this.mCheckStates.delete(keyAt);
                                            ListView.this.mCheckStates.put(keyAt + i18, valueAt);
                                        }
                                    }
                                }
                                if (ListView.this.mAddingRows != null) {
                                    for (int i38 = 0; i38 < ListView.this.mAddingRows.length; i38++) {
                                        int i39 = ListView.this.mAddingRows[i38];
                                        if (i39 >= headerViewsCount) {
                                            ListView.this.mAddingRows[i38] = i39 + i18;
                                        }
                                    }
                                }
                                int bottom2 = ListView.this.getBottom() - ListView.this.getTop();
                                ListView listView7 = ListView.this;
                                int i46 = bottom2 - listView7.mListPadding.bottom;
                                View childAt = listView7.getChildAt(childCount - 1);
                                if (childAt == null) {
                                    bottom = 0;
                                } else {
                                    bottom = childAt.getBottom();
                                }
                                if (ListView.this.getTranscriptMode() == 1 && z16 && bottom <= i46) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (headerViewsCount <= i19 && !z17 && bottom >= i46) {
                                    ListView.this.mFirstPosition += i18;
                                    return;
                                }
                                if (headerViewsCount > i26 && !z17 && bottom >= i46) {
                                    return;
                                }
                                ListView listView8 = ListView.this;
                                int i47 = listView8.mListPadding.top;
                                int i48 = listView8.mSelectedPosition;
                                int i49 = -1;
                                if (i48 < 0) {
                                    if (listView8.shouldShowSelector()) {
                                        i48 = ListView.this.mSelectorPosition;
                                    } else {
                                        i48 = -1;
                                    }
                                }
                                int i56 = headerViewsCount - i19;
                                if (z17) {
                                    int i57 = 0;
                                    while (true) {
                                        if (headerViewsCount2 < headerViewsCount) {
                                            break;
                                        }
                                        if (i46 < i47) {
                                            i49 = headerViewsCount2 + 1;
                                            break;
                                        }
                                        ListView listView9 = ListView.this;
                                        View obtainView = listView9.obtainView(headerViewsCount2, listView9.mIsScrap);
                                        ListView listView10 = ListView.this;
                                        listView10.setupChild(obtainView, headerViewsCount2, i46, false, listView10.mListPadding.left, false, listView10.mIsScrap[0], i56);
                                        int height = obtainView.getHeight() + ListView.this.mDividerHeight;
                                        i46 -= height;
                                        i57 += height;
                                        headerViewsCount2--;
                                    }
                                    if (i49 >= 0) {
                                        for (int i58 = 0; i58 <= i56 - 1; i58++) {
                                            ListView listView11 = ListView.this;
                                            listView11.mRecycler.addScrapView(listView11.getChildAt(i58), ListView.this.mFirstPosition + i58);
                                        }
                                        ListView.this.detachViewsFromParent(0, i56);
                                        ListView.this.mFirstPosition = i49;
                                    } else {
                                        offsetTop(i47, i56 - 1, i57);
                                    }
                                } else if ((i48 >= 0 && i48 < headerViewsCount) || (i48 < 0 && !ListView.this.mStackFromBottom)) {
                                    if (i56 > 0) {
                                        int bottom3 = ListView.this.getChildAt(i56 - 1).getBottom() + ListView.this.mDividerHeight;
                                        int i59 = 0;
                                        while (true) {
                                            if (headerViewsCount > headerViewsCount2) {
                                                break;
                                            }
                                            if (bottom3 > i46) {
                                                i49 = headerViewsCount - ListView.this.mFirstPosition;
                                                break;
                                            }
                                            ListView listView12 = ListView.this;
                                            View obtainView2 = listView12.obtainView(headerViewsCount, listView12.mIsScrap);
                                            ListView listView13 = ListView.this;
                                            listView13.setupChild(obtainView2, headerViewsCount, bottom3, true, listView13.mListPadding.left, false, listView13.mIsScrap[0], headerViewsCount - listView13.mFirstPosition);
                                            int height2 = obtainView2.getHeight() + ListView.this.mDividerHeight;
                                            bottom3 += height2;
                                            i59 += height2;
                                            headerViewsCount++;
                                        }
                                        int childCount2 = ListView.this.getChildCount();
                                        if (i49 >= 0) {
                                            for (int i65 = i49; i65 < childCount2; i65++) {
                                                ListView listView14 = ListView.this;
                                                listView14.mRecycler.addScrapView(listView14.getChildAt(i65), ListView.this.mFirstPosition + i65);
                                            }
                                            ListView.this.detachViewsFromParent(i49, childCount2 - i49);
                                        } else {
                                            offsetBottom(ListView.this.getChildCount(), i46, (headerViewsCount2 - ListView.this.mFirstPosition) + 1, i59);
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    if (i46 > bottom) {
                                        ListView.this.offsetChildrenTopAndBottomWrap(i46 - bottom);
                                    }
                                    int top = ListView.this.getChildAt(i56).getTop() - ListView.this.mDividerHeight;
                                    int i66 = 0;
                                    while (true) {
                                        if (headerViewsCount2 < headerViewsCount) {
                                            break;
                                        }
                                        if (top < i47) {
                                            i49 = headerViewsCount2 + 1;
                                            break;
                                        }
                                        ListView listView15 = ListView.this;
                                        View obtainView3 = listView15.obtainView(headerViewsCount2, listView15.mIsScrap);
                                        ListView listView16 = ListView.this;
                                        listView16.setupChild(obtainView3, headerViewsCount2, top, false, listView16.mListPadding.left, false, listView16.mIsScrap[0], i56);
                                        int height3 = obtainView3.getHeight() + ListView.this.mDividerHeight;
                                        top -= height3;
                                        i66 += height3;
                                        headerViewsCount2--;
                                    }
                                    if (i49 >= 0) {
                                        for (int i67 = 0; i67 <= i56 - 1; i67++) {
                                            ListView listView17 = ListView.this;
                                            listView17.mRecycler.addScrapView(listView17.getChildAt(i67), ListView.this.mFirstPosition + i67);
                                        }
                                        ListView.this.detachViewsFromParent(0, i56);
                                        ListView.this.mFirstPosition = i49;
                                    } else {
                                        offsetTop(i47, i56 - 1, i66);
                                    }
                                }
                                ListView.this.stayOnTheTop();
                                return;
                            }
                            onChanged();
                            return;
                        }
                    }
                    throw new IllegalArgumentException("row index out of bound");
                }
                throw new IllegalArgumentException("lastRow must more than firstRow!");
            }
            if (listView.mAddingRows == null) {
                int[] iArr = new int[(i16 - i17) + 1];
                int i68 = 0;
                while (i17 <= i16) {
                    iArr[i68] = i17;
                    i17++;
                    i68++;
                }
                ListView.this.mAddingRows = iArr;
            } else {
                HashSet hashSet = new HashSet();
                while (i17 <= i16) {
                    hashSet.add(Integer.valueOf(i17));
                    i17++;
                }
                for (int i69 : ListView.this.mAddingRows) {
                    hashSet.add(Integer.valueOf(i69));
                }
                int[] iArr2 = new int[hashSet.size()];
                Iterator it = hashSet.iterator();
                int i75 = 0;
                while (it.hasNext()) {
                    iArr2[i75] = ((Integer) it.next()).intValue();
                    i75++;
                }
                ListView.this.mAddingRows = iArr2;
            }
            onChanged();
        }

        @Override // com.tencent.widget.XBaseAdapter.ListDataSetListener
        public void onRowUpdated(int i3, int i16) {
            int i17;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i18 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i16 >= i3) {
                if (i3 >= ListView.this.getHeaderViewsCount()) {
                    ListView listView = ListView.this;
                    if (i16 < (listView.mItemCount - listView.getHeaderViewsCount()) - ListView.this.getFooterViewsCount()) {
                        ListView listView2 = ListView.this;
                        if (!listView2.mNeedSync && !listView2.mDataChanged) {
                            if (listView2.mItemCount == 0) {
                                return;
                            }
                            int headerViewsCount = i3 + listView2.getHeaderViewsCount();
                            int headerViewsCount2 = i16 + ListView.this.getHeaderViewsCount();
                            int childCount = ListView.this.getChildCount();
                            ListView listView3 = ListView.this;
                            int i19 = listView3.mFirstPosition;
                            int i26 = (i19 + childCount) - 1;
                            if (headerViewsCount2 >= i19 && headerViewsCount <= i26) {
                                int i27 = listView3.mListPadding.top;
                                int bottom = listView3.getBottom() - ListView.this.getTop();
                                ListView listView4 = ListView.this;
                                int i28 = bottom - listView4.mListPadding.bottom;
                                if (headerViewsCount >= i19) {
                                    i18 = headerViewsCount - i19;
                                }
                                if (headerViewsCount2 > i26) {
                                    i17 = childCount - 1;
                                } else {
                                    i17 = headerViewsCount2 - i19;
                                }
                                int i29 = listView4.mSelectedPosition;
                                if (i29 < 0) {
                                    if (listView4.shouldShowSelector()) {
                                        i29 = ListView.this.mSelectorPosition;
                                    } else {
                                        i29 = -1;
                                    }
                                }
                                if ((i29 >= 0 && i29 <= headerViewsCount) || (i29 < 0 && !ListView.this.mStackFromBottom)) {
                                    int updateAfter = updateAfter(childCount, i28, i18, i17);
                                    ListView listView5 = ListView.this;
                                    listView5.correctTooLow(listView5.getChildCount());
                                    offsetBottom(childCount, i28, i17 + 1, updateAfter);
                                } else if (i29 < headerViewsCount2 && (i29 >= 0 || !ListView.this.mStackFromBottom)) {
                                    int i36 = i29 - ListView.this.mFirstPosition;
                                    offsetBottom(childCount, i28, i17 + 1, updateAfter(childCount, i28, i36, i17));
                                    offsetTop(i27, i18 - 1, updateBefore(i27, i18, i36 - 1));
                                } else {
                                    int updateBefore = updateBefore(i27, i18, i17);
                                    ListView listView6 = ListView.this;
                                    listView6.correctTooHigh(listView6.getChildCount());
                                    offsetTop(i27, i18 - 1, updateBefore);
                                }
                                ListView.this.stayOnTheTop();
                                return;
                            }
                            return;
                        }
                        onChanged();
                        return;
                    }
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("row index out of bound. insert range: ");
                sb5.append(i3);
                sb5.append("~");
                sb5.append(i16);
                sb5.append(". valid range: ");
                sb5.append(ListView.this.getHeaderViewsCount());
                sb5.append("~");
                ListView listView7 = ListView.this;
                sb5.append((listView7.mItemCount - listView7.getHeaderViewsCount()) - ListView.this.getFooterViewsCount());
                throw new IllegalArgumentException(sb5.toString());
            }
            throw new IllegalArgumentException("lastRow must more than firstRow!");
        }

        @Override // com.tencent.widget.XBaseAdapter.ListDataSetListener
        public void onRowDeleted(int i3, int i16) {
            int top;
            int indexOfChild;
            int i17;
            boolean z16;
            int i18;
            int top2;
            int i19;
            int i26;
            int indexOfChild2;
            int i27;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            System.nanoTime();
            if (i16 >= i3) {
                if (i3 >= 0) {
                    ListView listView = ListView.this;
                    if (i16 < (listView.mItemCount - listView.getHeaderViewsCount()) - ListView.this.getFooterViewsCount()) {
                        ListView listView2 = ListView.this;
                        if (!listView2.mNeedSync && !listView2.mDataChanged) {
                            int headerViewsCount = i3 + listView2.getHeaderViewsCount();
                            int headerViewsCount2 = i16 + ListView.this.getHeaderViewsCount();
                            int i28 = (headerViewsCount2 - headerViewsCount) + 1;
                            int childCount = ListView.this.getChildCount();
                            ListView listView3 = ListView.this;
                            int i29 = listView3.mFirstPosition;
                            int i36 = (i29 + childCount) - 1;
                            FastScroller fastScroller = listView3.mFastScroller;
                            if (fastScroller != null) {
                                int i37 = listView3.mItemCount;
                                fastScroller.onItemCountChanged(i37, i37 - i28);
                            }
                            ListView listView4 = ListView.this;
                            listView4.mItemCount -= i28;
                            int i38 = listView4.mSelectedPosition;
                            if (i38 >= 0) {
                                int calcNewPosition = calcNewPosition(i38, headerViewsCount, headerViewsCount2, i29, i36);
                                ListView.this.setSelectedPositionInt(calcNewPosition);
                                ListView.this.setNextSelectedPositionInt(calcNewPosition);
                            } else {
                                int i39 = listView4.mSelectorPosition;
                                if (i39 >= 0) {
                                    listView4.mSelectedPosition = calcNewPosition(i39, headerViewsCount, headerViewsCount2, i29, i36);
                                }
                            }
                            ListView listView5 = ListView.this;
                            int i46 = listView5.mMotionPosition;
                            if (i46 >= 0) {
                                listView5.mMotionPosition = calcNewPosition(i46, headerViewsCount, headerViewsCount2, i29, i36);
                            }
                            SparseBooleanArray sparseBooleanArray = ListView.this.mCheckStates;
                            int size = sparseBooleanArray == null ? 0 : sparseBooleanArray.size();
                            if (size > 0) {
                                int i47 = 0;
                                while (i47 < size) {
                                    int keyAt = ListView.this.mCheckStates.keyAt(i47);
                                    boolean valueAt = ListView.this.mCheckStates.valueAt(i47);
                                    if (keyAt >= headerViewsCount) {
                                        ListView.this.mCheckStates.delete(keyAt);
                                        if (keyAt <= headerViewsCount2) {
                                            i47--;
                                            size--;
                                        }
                                        if (keyAt > headerViewsCount2) {
                                            ListView.this.mCheckStates.put(keyAt - i28, valueAt);
                                        }
                                    }
                                    i47++;
                                }
                            }
                            if (ListView.this.mAddingRows != null) {
                                for (int i48 = 0; i48 < ListView.this.mAddingRows.length; i48++) {
                                    int i49 = ListView.this.mAddingRows[i48];
                                    if (i49 >= headerViewsCount) {
                                        ListView.this.mAddingRows[i48] = i49 <= headerViewsCount2 ? -1 : i49 - i28;
                                    }
                                }
                            }
                            if (headerViewsCount2 < i29 || headerViewsCount > i36) {
                                return;
                            }
                            ListView listView6 = ListView.this;
                            int i56 = listView6.mListPadding.top;
                            int bottom = (listView6.getBottom() - ListView.this.getTop()) - ListView.this.mListPadding.bottom;
                            int i57 = headerViewsCount < i29 ? 0 : headerViewsCount - i29;
                            int i58 = headerViewsCount2 > i36 ? childCount - 1 : headerViewsCount2 - i29;
                            for (int i59 = 0; i59 < childCount; i59++) {
                                View childAt = ListView.this.getChildAt(i59);
                                if (i59 < i57 || i59 > i58) {
                                    if (ListView.this.mAnimation) {
                                        childAt.setTag(R.drawable.m_n, new Point(childAt.getTop(), childAt.getBottom()));
                                    }
                                } else {
                                    ListView.this.mRecycler.addScrapView(childAt, i59);
                                    childAt.setTag(R.drawable.m_n, null);
                                }
                            }
                            ListView.this.detachViewsFromParent(i57, (i58 - i57) + 1);
                            ListView listView7 = ListView.this;
                            if (listView7.mItemCount == 0) {
                                return;
                            }
                            int childCount2 = listView7.getChildCount();
                            boolean shouldShowSelector = ListView.this.shouldShowSelector();
                            ListView listView8 = ListView.this;
                            int i65 = listView8.mSelectedPosition;
                            if (i65 < 0) {
                                i65 = shouldShowSelector ? listView8.mSelectorPosition : -1;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(AdapterView.TAG, 2, "first is:" + headerViewsCount + ",last is:" + headerViewsCount2 + ",firstPosition is:" + i29 + ",lastPosition is:" + i36 + ",newSelectionPosition is:" + i65 + ",mStackFromBottom is:" + ListView.this.mStackFromBottom);
                            }
                            if (headerViewsCount > i29 || headerViewsCount2 < i36) {
                                if (headerViewsCount <= i29) {
                                    ListView listView9 = ListView.this;
                                    if (!listView9.mStackFromBottom && i65 < 0) {
                                        View childAt2 = listView9.getChildAt(0);
                                        int top3 = childAt2.getTop();
                                        ListView.this.offsetChildrenTopAndBottomWrap(i56 - childAt2.getTop());
                                        ListView listView10 = ListView.this;
                                        listView10.mFirstPosition = headerViewsCount;
                                        listView10.fillGap(true);
                                        ListView.this.stayOnTheTop();
                                        top2 = childAt2.getTop() - ListView.this.mDividerHeight > 0 ? (-childAt2.getTop()) + ListView.this.mDividerHeight : 0;
                                        i27 = top3 - childAt2.getTop();
                                        indexOfChild = ListView.this.indexOfChild(childAt2);
                                    } else {
                                        listView9.mFirstPosition = headerViewsCount;
                                        View childAt3 = listView9.getChildAt(i57);
                                        int top4 = childAt3.getTop();
                                        ListView.this.fillGap(false);
                                        ListView.this.stayOnTheTop();
                                        int top5 = childAt3.getTop();
                                        i27 = top4 - top5;
                                        ListView listView11 = ListView.this;
                                        int i66 = listView11.mDividerHeight;
                                        top2 = top5 - i66 > 0 ? (-top5) + i66 : 0;
                                        indexOfChild = listView11.indexOfChild(childAt3) - 1;
                                    }
                                    top = i27;
                                } else if (headerViewsCount2 >= i36) {
                                    ListView listView12 = ListView.this;
                                    if (listView12.mStackFromBottom && i65 < 0) {
                                        View childAt4 = listView12.getChildAt(childCount2 - 1);
                                        int top6 = childAt4.getTop();
                                        ListView.this.offsetChildrenTopAndBottomWrap(bottom - childAt4.getBottom());
                                        ListView.this.fillGap(false);
                                        ListView.this.stayOnTheTop();
                                        i26 = (bottom - childAt4.getBottom()) - ListView.this.mDividerHeight > 0 ? (bottom - childAt4.getBottom()) - ListView.this.mDividerHeight : 0;
                                        i19 = top6 - childAt4.getTop();
                                        indexOfChild2 = ListView.this.indexOfChild(childAt4);
                                    } else {
                                        View childAt5 = listView12.getChildAt(childCount2 - 1);
                                        int bottom2 = childAt5.getBottom();
                                        ListView.this.fillGap(true);
                                        ListView.this.stayOnTheTop();
                                        int bottom3 = childAt5.getBottom();
                                        i19 = bottom2 - bottom3;
                                        int i67 = bottom - bottom3;
                                        ListView listView13 = ListView.this;
                                        int i68 = listView13.mDividerHeight;
                                        i26 = i67 - i68 > 0 ? i67 - i68 : 0;
                                        indexOfChild2 = listView13.indexOfChild(childAt5);
                                    }
                                    top = i26;
                                    i17 = i19;
                                    z16 = false;
                                    i18 = indexOfChild2;
                                } else if ((i65 >= 0 && i65 < headerViewsCount) || (i65 < 0 && !ListView.this.mStackFromBottom)) {
                                    View childAt6 = ListView.this.getChildAt(i57 - 1);
                                    int top7 = childAt6.getTop();
                                    View childAt7 = ListView.this.getChildAt(i57);
                                    int top8 = childAt7.getTop();
                                    int top9 = childAt7.getTop() - childAt6.getBottom();
                                    for (int i69 = headerViewsCount - i29; i69 < childCount2; i69++) {
                                        ListView.this.getChildAt(i69).offsetTopAndBottom((-top9) + ListView.this.mDividerHeight);
                                    }
                                    ListView.this.fillGap(true);
                                    ListView.this.stayOnTheTop();
                                    top = top8 - childAt7.getTop();
                                    top2 = top7 - childAt6.getTop();
                                    indexOfChild = ListView.this.indexOfChild(childAt6);
                                } else if (i65 >= headerViewsCount || (i65 < 0 && ListView.this.mStackFromBottom)) {
                                    int i75 = i57 - 1;
                                    View childAt8 = ListView.this.getChildAt(i75);
                                    int top10 = childAt8.getTop();
                                    View childAt9 = ListView.this.getChildAt(i57);
                                    int top11 = childAt9.getTop();
                                    int top12 = childAt9.getTop() - ListView.this.getChildAt(i75).getBottom();
                                    for (int i76 = 0; i76 < headerViewsCount - i29; i76++) {
                                        ListView.this.getChildAt(i76).offsetTopAndBottom(top12 - ListView.this.mDividerHeight);
                                    }
                                    ListView.this.fillGap(false);
                                    ListView.this.stayOnTheTop();
                                    top = top11 - childAt9.getTop();
                                    int top13 = top10 - childAt8.getTop();
                                    indexOfChild = ListView.this.indexOfChild(childAt8);
                                    i17 = top13;
                                    z16 = false;
                                    i18 = indexOfChild;
                                } else {
                                    i18 = -1;
                                    i17 = 0;
                                    top = 0;
                                    z16 = false;
                                }
                                i17 = top2;
                                z16 = false;
                                i18 = indexOfChild;
                            } else {
                                ListView listView14 = ListView.this;
                                if (listView14.mStackFromBottom) {
                                    int i77 = headerViewsCount - 1;
                                    if (i77 < 0) {
                                        i77 = 0;
                                    }
                                    listView14.fillSpecificBottom(i77, bottom);
                                } else {
                                    int i78 = listView14.mItemCount;
                                    if (headerViewsCount > i78 - 1) {
                                        headerViewsCount = i78 - 1;
                                    }
                                    listView14.fillSpecific(headerViewsCount, i56);
                                }
                                i18 = -1;
                                i17 = 0;
                                top = 0;
                                z16 = true;
                            }
                            int childCount3 = ListView.this.getChildCount();
                            if (i65 >= 0 && i65 < childCount3 && shouldShowSelector) {
                                ListView listView15 = ListView.this;
                                listView15.positionSelector(i65, listView15.getChildAt(i65 - listView15.mFirstPosition));
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d(AdapterView.TAG, 2, "upItemsMaxIndex is:" + i18 + ",upItemsMoveDistance is:" + i17 + ",downItemsMoveDistance is:" + top);
                            }
                            if (ListView.this.mAnimation) {
                                calcAnimation(childCount3, i18, i17, top, z16);
                            }
                            ListView.this.invalidate();
                            return;
                        }
                        onChanged();
                        return;
                    }
                }
                throw new IllegalArgumentException("row index out of bound");
            }
            throw new IllegalArgumentException("lastRow must more than firstRow!");
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnScrollChangeListener {
        void onScrollChanged(int i3, int i16, int i17);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnSpringBackListener {
        void onSpringBack();
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class OverscrollViewContainer extends FrameLayout {
        static IPatchRedirector $redirector_;

        public OverscrollViewContainer(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setParent(ViewParent viewParent) {
            ReflectionUtil.invokeMethodWithArgs(this, "android.view.View", "assignParent", new Class[]{ViewParent.class}, viewParent);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41386);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 103)) {
            redirector.redirect((short) 103);
        } else {
            LISTVIEW_STYLEABLE = new int[]{android.R.attr.entries, android.R.attr.divider, android.R.attr.overScrollHeader, android.R.attr.overScrollFooter, android.R.attr.dividerHeight, android.R.attr.headerDividersEnabled, android.R.attr.footerDividersEnabled};
        }
    }

    public ListView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private View addViewAbove(View view, int i3) {
        int i16 = i3 - 1;
        View obtainView = obtainView(i16, this.mIsScrap);
        setupChild(obtainView, i16, view.getTop() - this.mDividerHeight, false, this.mListPadding.left, false, this.mIsScrap[0]);
        return obtainView;
    }

    private View addViewBelow(View view, int i3) {
        int i16 = i3 + 1;
        View obtainView = obtainView(i16, this.mIsScrap);
        setupChild(obtainView, i16, view.getBottom() + this.mDividerHeight, true, this.mListPadding.left, false, this.mIsScrap[0]);
        return obtainView;
    }

    private void adjustViewsUpOrDown() {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i3 = 0;
            if (!this.mStackFromBottom) {
                int top = getChildAt(0).getTop() - this.mListPadding.top;
                if (this.mFirstPosition != 0) {
                    top -= this.mDividerHeight;
                }
                if (top >= 0) {
                    i3 = top;
                }
            } else {
                int bottom = getChildAt(childCount - 1).getBottom() - (getHeight() - this.mListPadding.bottom);
                if (this.mFirstPosition + childCount < this.mItemCount) {
                    bottom += this.mDividerHeight;
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

    private int amountToScroll(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int i26;
        int height = getHeight();
        Rect rect = this.mListPadding;
        int i27 = height - rect.bottom;
        int i28 = rect.top;
        int childCount = getChildCount();
        if (i3 == 130) {
            int i29 = childCount - 1;
            if (i16 != -1) {
                i19 = i16 - this.mFirstPosition;
            } else {
                i19 = i29;
            }
            int i36 = this.mFirstPosition + i19;
            View childAt = getChildAt(i19);
            if (i36 < this.mItemCount - 1) {
                i26 = i27 - getArrowScrollPreviewLength();
            } else {
                i26 = i27;
            }
            if (childAt.getBottom() <= i26) {
                return 0;
            }
            if (i16 != -1 && i26 - childAt.getTop() >= getMaxScrollAmount()) {
                return 0;
            }
            int bottom = childAt.getBottom() - i26;
            if (this.mFirstPosition + childCount == this.mItemCount) {
                bottom = Math.min(bottom, getChildAt(i29).getBottom() - i27);
            }
            return Math.min(bottom, getMaxScrollAmount());
        }
        if (i16 != -1) {
            i17 = i16 - this.mFirstPosition;
        } else {
            i17 = 0;
        }
        int i37 = this.mFirstPosition + i17;
        View childAt2 = getChildAt(i17);
        if (i37 > 0) {
            i18 = getArrowScrollPreviewLength() + i28;
        } else {
            i18 = i28;
        }
        if (childAt2.getTop() >= i18) {
            return 0;
        }
        if (i16 != -1 && childAt2.getBottom() - i18 >= getMaxScrollAmount()) {
            return 0;
        }
        int top = i18 - childAt2.getTop();
        if (this.mFirstPosition == 0) {
            top = Math.min(top, i28 - getChildAt(0).getTop());
        }
        return Math.min(top, getMaxScrollAmount());
    }

    private int amountToScrollToNewFocus(int i3, View view, int i16) {
        int i17;
        int arrowScrollPreviewLength;
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        if (i3 == 33) {
            int i18 = this.mTempRect.top;
            int i19 = this.mListPadding.top;
            if (i18 < i19) {
                i17 = i19 - i18;
                if (i16 > 0) {
                    arrowScrollPreviewLength = getArrowScrollPreviewLength();
                    return i17 + arrowScrollPreviewLength;
                }
                return i17;
            }
            return 0;
        }
        int height = getHeight() - this.mListPadding.bottom;
        int i26 = this.mTempRect.bottom;
        if (i26 > height) {
            i17 = i26 - height;
            if (i16 < this.mItemCount - 1) {
                arrowScrollPreviewLength = getArrowScrollPreviewLength();
                return i17 + arrowScrollPreviewLength;
            }
            return i17;
        }
        return 0;
    }

    private ArrowScrollFocusResult arrowScrollFocused(int i3) {
        int i16;
        View findNextFocusFromRect;
        int i17;
        int lookForSelectablePositionOnScreen;
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.hasFocus()) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i3);
        } else {
            boolean z16 = true;
            if (i3 == 130) {
                if (this.mFirstPosition <= 0) {
                    z16 = false;
                }
                int i18 = this.mListPadding.top;
                if (z16) {
                    i17 = getArrowScrollPreviewLength();
                } else {
                    i17 = 0;
                }
                int i19 = i18 + i17;
                if (selectedView != null && selectedView.getTop() > i19) {
                    i19 = selectedView.getTop();
                }
                this.mTempRect.set(0, i19, 0, i19);
            } else {
                if ((this.mFirstPosition + getChildCount()) - 1 >= this.mItemCount) {
                    z16 = false;
                }
                int height = getHeight() - this.mListPadding.bottom;
                if (z16) {
                    i16 = getArrowScrollPreviewLength();
                } else {
                    i16 = 0;
                }
                int i26 = height - i16;
                if (selectedView != null && selectedView.getBottom() < i26) {
                    i26 = selectedView.getBottom();
                }
                this.mTempRect.set(0, i26, 0, i26);
            }
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.mTempRect, i3);
        }
        if (findNextFocusFromRect != null) {
            int positionOfNewFocus = positionOfNewFocus(findNextFocusFromRect);
            int i27 = this.mSelectedPosition;
            if (i27 != -1 && positionOfNewFocus != i27 && (lookForSelectablePositionOnScreen = lookForSelectablePositionOnScreen(i3)) != -1 && ((i3 == 130 && lookForSelectablePositionOnScreen < positionOfNewFocus) || (i3 == 33 && lookForSelectablePositionOnScreen > positionOfNewFocus))) {
                return null;
            }
            int amountToScrollToNewFocus = amountToScrollToNewFocus(i3, findNextFocusFromRect, positionOfNewFocus);
            int maxScrollAmount = getMaxScrollAmount();
            if (amountToScrollToNewFocus < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i3);
                this.mArrowScrollFocusResult.populate(positionOfNewFocus, amountToScrollToNewFocus);
                return this.mArrowScrollFocusResult;
            }
            if (distanceToView(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i3);
                this.mArrowScrollFocusResult.populate(positionOfNewFocus, maxScrollAmount);
                return this.mArrowScrollFocusResult;
            }
        }
        return null;
    }

    private boolean arrowScrollImpl(int i3) {
        ArrowScrollFocusResult arrowScrollFocusResult;
        boolean z16;
        View findFocus;
        boolean z17;
        View focusedChild;
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i16 = this.mSelectedPosition;
        int lookForSelectablePositionOnScreen = lookForSelectablePositionOnScreen(i3);
        int amountToScroll = amountToScroll(i3, lookForSelectablePositionOnScreen);
        View view = null;
        if (this.mItemsCanFocus) {
            arrowScrollFocusResult = arrowScrollFocused(i3);
        } else {
            arrowScrollFocusResult = null;
        }
        if (arrowScrollFocusResult != null) {
            lookForSelectablePositionOnScreen = arrowScrollFocusResult.getSelectedPosition();
            amountToScroll = arrowScrollFocusResult.getAmountToScroll();
        }
        if (arrowScrollFocusResult != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (lookForSelectablePositionOnScreen != -1) {
            if (arrowScrollFocusResult != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            handleNewSelectionChange(selectedView, i3, lookForSelectablePositionOnScreen, z17);
            setSelectedPositionInt(lookForSelectablePositionOnScreen);
            setNextSelectedPositionInt(lookForSelectablePositionOnScreen);
            selectedView = getSelectedView();
            if (this.mItemsCanFocus && arrowScrollFocusResult == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            checkSelectionChanged();
            i16 = lookForSelectablePositionOnScreen;
            z16 = true;
        }
        if (amountToScroll > 0) {
            if (i3 != 33) {
                amountToScroll = -amountToScroll;
            }
            scrollListItemsBy(amountToScroll);
            z16 = true;
        }
        if (this.mItemsCanFocus && arrowScrollFocusResult == null && selectedView != null && selectedView.hasFocus() && (findFocus = selectedView.findFocus()) != null && (!isViewAncestorOf(findFocus, this) || distanceToView(findFocus) > 0)) {
            findFocus.clearFocus();
        }
        if (lookForSelectablePositionOnScreen == -1 && selectedView != null && !isViewAncestorOf(selectedView, this)) {
            hideSelector();
            this.mResurrectToPosition = -1;
        } else {
            view = selectedView;
        }
        if (!z16) {
            return false;
        }
        if (view != null) {
            positionSelector(i16, view);
            this.mSelectedTop = view.getTop();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        invokeOnItemScrollListener();
        return true;
    }

    private void attachWindow(View view) {
        Method method;
        try {
            Field field = ReflectionUtil.getField("android.view.View", "mAttachInfo");
            field.setAccessible(true);
            Object obj = field.get(this);
            if (obj != null && (method = ReflectionUtil.getMethod("android.view.View", "dispatchAttachedToWindow", new Class[]{obj.getClass(), Integer.TYPE})) != null) {
                method.setAccessible(true);
                method.invoke(view, obj, Integer.valueOf(getVisibility()));
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(AdapterView.TAG, 2, e16.getMessage(), e16);
            }
        }
    }

    private void checkOverScrollHeaderIsVisable() {
        OverscrollViewContainer overscrollViewContainer;
        OverscrollViewContainer overscrollViewContainer2;
        int overScrollFooterHeight;
        int i3;
        if (this.mTouchMode == 5 && getScrollY() != 0) {
            int scrollY = getScrollY();
            if (scrollY < 0 && this.mOverscrollHeaderViewContainer != null && scrollY > (-getOverScrollHeight())) {
                int i16 = this.mOverscrollHeadState;
                if (i16 == 0 || i16 == 2) {
                    OverScrollViewListener overScrollViewListener = this.mOverScrollViewListener;
                    if (overScrollViewListener != null) {
                        overScrollViewListener.onNotCompleteVisable(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this);
                    }
                    this.mOverscrollHeadState = 1;
                }
                OverScrollViewListener overScrollViewListener2 = this.mOverScrollViewListener;
                if (overScrollViewListener2 != null && (overScrollViewListener2 instanceof ReadInJoyOverScrollViewListener)) {
                    ReadInJoyOverScrollViewListener readInJoyOverScrollViewListener = (ReadInJoyOverScrollViewListener) overScrollViewListener2;
                    View childAt = this.mOverscrollHeaderViewContainer.getChildAt(0);
                    if (getOverScrollHeight() > 0) {
                        i3 = ((-scrollY) * 100) / getOverScrollHeight();
                    } else {
                        i3 = 0;
                    }
                    readInJoyOverScrollViewListener.onNotCompleteVisable(0, childAt, this, i3);
                    ((ReadInJoyOverScrollViewListener) this.mOverScrollViewListener).onScrollView(this.mOverscrollHeaderViewContainer.getChildAt(0), this, -scrollY);
                    return;
                }
                return;
            }
            if (scrollY > 0 && this.mOverscrollFooterView != null && scrollY < getOverScrollFooterHeight()) {
                int i17 = this.mOverscrollHeadState;
                if (i17 == 0 || i17 == 2) {
                    OverScrollViewListener overScrollViewListener3 = this.mOverScrollViewListener;
                    if (overScrollViewListener3 != null) {
                        overScrollViewListener3.onNotCompleteVisable(1, this.mOverscrollFooterView.getChildAt(0), this);
                    }
                    this.mOverscrollHeadState = 1;
                }
                OverScrollViewListener overScrollViewListener4 = this.mOverScrollViewListener;
                if (overScrollViewListener4 != null && (overScrollViewListener4 instanceof ReadInJoyOverScrollViewListener)) {
                    ReadInJoyOverScrollViewListener readInJoyOverScrollViewListener2 = (ReadInJoyOverScrollViewListener) overScrollViewListener4;
                    View childAt2 = this.mOverscrollFooterView.getChildAt(0);
                    if (getOverScrollFooterHeight() == 0) {
                        overScrollFooterHeight = 0;
                    } else {
                        overScrollFooterHeight = (scrollY * 100) / getOverScrollFooterHeight();
                    }
                    readInJoyOverScrollViewListener2.onNotCompleteVisable(1, childAt2, this, overScrollFooterHeight);
                    ((ReadInJoyOverScrollViewListener) this.mOverScrollViewListener).onScrollView(this.mOverscrollFooterView.getChildAt(0), this, scrollY);
                    return;
                }
                return;
            }
            if (scrollY < 0 && (overscrollViewContainer2 = this.mOverscrollHeaderViewContainer) != null) {
                OverScrollViewListener overScrollViewListener5 = this.mOverScrollViewListener;
                if (overScrollViewListener5 != null && (overScrollViewListener5 instanceof ReadInJoyOverScrollViewListener)) {
                    ((ReadInJoyOverScrollViewListener) overScrollViewListener5).onScrollView(overscrollViewContainer2.getChildAt(0), this, -scrollY);
                    return;
                }
                return;
            }
            if (scrollY > 0 && (overscrollViewContainer = this.mOverscrollFooterView) != null) {
                OverScrollViewListener overScrollViewListener6 = this.mOverScrollViewListener;
                if (overScrollViewListener6 instanceof ReadInJoyOverScrollViewListener) {
                    ((ReadInJoyOverScrollViewListener) overScrollViewListener6).onScrollView(overscrollViewContainer.getChildAt(0), this, scrollY);
                }
            }
        }
    }

    private void checkOverscrollViewIsCompleteVisable(View view) {
        int scrollY = getScrollY();
        view.getHeight();
        if (view == this.mOverscrollHeaderViewContainer) {
            if (this.mOverscrollHeadState == 1 && scrollY <= (-getOverScrollHeight())) {
                this.mOverscrollHeadState = 2;
                OverScrollViewListener overScrollViewListener = this.mOverScrollViewListener;
                if (overScrollViewListener != null) {
                    overScrollViewListener.onViewCompleteVisable(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this);
                    return;
                }
                return;
            }
            return;
        }
        if (view == this.mOverscrollFooterView && this.mOverscrollHeadState == 1 && scrollY >= getOverScrollFooterHeight()) {
            this.mOverscrollHeadState = 2;
            OverScrollViewListener overScrollViewListener2 = this.mOverScrollViewListener;
            if (overScrollViewListener2 != null) {
                overScrollViewListener2.onViewCompleteVisable(1, this.mOverscrollFooterView.getChildAt(0), this);
            }
        }
    }

    private void clearRecycledState(ArrayList<FixedViewInfo> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) arrayList.get(i3).view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.recycledHeaderFooter = false;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x00ef, code lost:
    
        if (fullScroll(130) != false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0109, code lost:
    
        if (fullScroll(33) != false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0099, code lost:
    
        if (fullScroll(130) != false) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00d5, code lost:
    
        if (fullScroll(33) != false) goto L161;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01eb  */
    @TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean commonKey(int i3, int i16, KeyEvent keyEvent) {
        boolean z16;
        int i17;
        int i18;
        if (this.mAdapter == null || !this.mIsAttached) {
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
                                            if (VersionUtils.isHoneycomb() && keyEvent.hasNoModifiers()) {
                                                z16 = resurrectSelectionIfNeeded();
                                                if (!z16) {
                                                    while (true) {
                                                        i17 = i16 - 1;
                                                        if (i16 > 0 && arrowScroll(33)) {
                                                            z16 = true;
                                                            i16 = i17;
                                                        }
                                                    }
                                                    i16 = i17;
                                                    break;
                                                }
                                            } else if (VersionUtils.isHoneycomb()) {
                                                if (keyEvent.hasModifiers(2)) {
                                                    if (!resurrectSelectionIfNeeded()) {
                                                        break;
                                                    }
                                                    z16 = true;
                                                    break;
                                                }
                                            }
                                            break;
                                        case 20:
                                            if (VersionUtils.isHoneycomb() && keyEvent.hasNoModifiers()) {
                                                z16 = resurrectSelectionIfNeeded();
                                                if (!z16) {
                                                    while (true) {
                                                        i18 = i16 - 1;
                                                        if (i16 > 0 && arrowScroll(130)) {
                                                            z16 = true;
                                                            i16 = i18;
                                                        }
                                                    }
                                                    i16 = i18;
                                                    break;
                                                }
                                            } else if (VersionUtils.isHoneycomb()) {
                                                if (keyEvent.hasModifiers(2)) {
                                                    if (!resurrectSelectionIfNeeded()) {
                                                        break;
                                                    }
                                                    z16 = true;
                                                    break;
                                                }
                                            }
                                            break;
                                        case 21:
                                            if (VersionUtils.isHoneycomb() && keyEvent.hasNoModifiers()) {
                                                z16 = handleHorizontalFocusWithinListItem(17);
                                                break;
                                            }
                                            break;
                                        case 22:
                                            if (VersionUtils.isHoneycomb() && keyEvent.hasNoModifiers()) {
                                                z16 = handleHorizontalFocusWithinListItem(66);
                                                break;
                                            }
                                            break;
                                    }
                                } else if (VersionUtils.isHoneycomb()) {
                                    if (keyEvent.hasNoModifiers()) {
                                        if (!resurrectSelectionIfNeeded()) {
                                        }
                                        z16 = true;
                                    }
                                }
                            } else if (VersionUtils.isHoneycomb()) {
                                if (keyEvent.hasNoModifiers()) {
                                    if (!resurrectSelectionIfNeeded()) {
                                    }
                                    z16 = true;
                                }
                            }
                        } else if (VersionUtils.isHoneycomb()) {
                        }
                    } else if (VersionUtils.isHoneycomb()) {
                    }
                }
                if (VersionUtils.isHoneycomb() && keyEvent.hasNoModifiers()) {
                    z16 = resurrectSelectionIfNeeded();
                    if (!z16 && keyEvent.getRepeatCount() == 0 && getChildCount() > 0) {
                        keyPressed();
                        z16 = true;
                    }
                }
            } else {
                PopupWindow popupWindow = this.mPopup;
                if (popupWindow == null || !popupWindow.isShowing()) {
                    if (VersionUtils.isHoneycomb() && keyEvent.hasNoModifiers()) {
                        if (!resurrectSelectionIfNeeded()) {
                            pageScroll(130);
                        }
                    } else if (VersionUtils.isHoneycomb() && keyEvent.hasModifiers(1) && !resurrectSelectionIfNeeded()) {
                        pageScroll(33);
                    }
                    z16 = true;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void correctTooHigh(int i3) {
        if ((this.mFirstPosition + i3) - 1 == this.mItemCount - 1 && i3 > 0) {
            int bottom = ((getBottom() - getTop()) - this.mListPadding.bottom) - getChildAt(i3 - 1).getBottom();
            View childAt = getChildAt(0);
            int top = childAt.getTop();
            if (bottom > 0) {
                int i16 = this.mFirstPosition;
                if (i16 > 0 || top < this.mListPadding.top) {
                    if (i16 == 0) {
                        bottom = Math.min(bottom, this.mListPadding.top - top);
                    }
                    offsetChildrenTopAndBottomWrap(bottom);
                    int i17 = this.mFirstPosition;
                    if (i17 > 0) {
                        fillUp(i17 - 1, childAt.getTop() - this.mDividerHeight);
                        adjustViewsUpOrDown();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void correctTooLow(int i3) {
        if (this.mFirstPosition == 0 && i3 > 0) {
            int top = getChildAt(0).getTop();
            int i16 = this.mListPadding.top;
            int bottom = (getBottom() - getTop()) - this.mListPadding.bottom;
            int i17 = top - i16;
            View childAt = getChildAt(i3 - 1);
            int bottom2 = childAt.getBottom();
            int i18 = (this.mFirstPosition + i3) - 1;
            if (i17 > 0) {
                int i19 = this.mItemCount;
                if (i18 >= i19 - 1 && bottom2 <= bottom) {
                    if (i18 == i19 - 1) {
                        adjustViewsUpOrDown();
                        return;
                    }
                    return;
                }
                if (i18 == i19 - 1) {
                    i17 = Math.min(i17, bottom2 - bottom);
                }
                offsetChildrenTopAndBottomWrap(-i17);
                if (i18 < this.mItemCount - 1) {
                    fillDown(i18 + 1, childAt.getBottom() + this.mDividerHeight);
                    adjustViewsUpOrDown();
                }
            }
        }
    }

    private void detachedWindow(View view) {
        Method method;
        try {
            Field field = ReflectionUtil.getField("android.view.View", "mAttachInfo");
            field.setAccessible(true);
            if (field.get(view) != null && (method = ReflectionUtil.getMethod("android.view.View", "dispatchDetachedFromWindow", null)) != null) {
                method.setAccessible(true);
                method.invoke(view, new Object[0]);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(AdapterView.TAG, 2, e16.getMessage(), e16);
            }
        }
    }

    private int distanceToView(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int bottom = getBottom() - getTop();
        Rect rect = this.mListPadding;
        int i3 = bottom - rect.bottom;
        Rect rect2 = this.mTempRect;
        int i16 = rect2.bottom;
        int i17 = rect.top;
        if (i16 < i17) {
            return i17 - i16;
        }
        int i18 = rect2.top;
        if (i18 > i3) {
            return i18 - i3;
        }
        return 0;
    }

    private void fillAboveAndBelow(View view, int i3) {
        int i16 = this.mDividerHeight;
        if (!this.mStackFromBottom) {
            fillUp(i3 - 1, view.getTop() - i16);
            adjustViewsUpOrDown();
            fillDown(i3 + 1, view.getBottom() + i16);
        } else {
            fillDown(i3 + 1, view.getBottom() + i16);
            adjustViewsUpOrDown();
            fillUp(i3 - 1, view.getTop() - i16);
        }
    }

    private View fillDown(int i3, int i16) {
        boolean z16;
        int bottom = getBottom() - getTop();
        View view = null;
        if (hasBooleanFlag(34)) {
            bottom -= this.mListPadding.bottom;
        }
        while (i16 < bottom && i3 < this.mItemCount) {
            if (i3 == this.mSelectedPosition) {
                z16 = true;
            } else {
                z16 = false;
            }
            View makeAndAddView = makeAndAddView(i3, i16, true, this.mListPadding.left, z16);
            if (makeAndAddView != null) {
                i16 = makeAndAddView.getBottom() + this.mDividerHeight;
                if (z16) {
                    view = makeAndAddView;
                }
            }
            i3++;
        }
        return view;
    }

    private View fillFromMiddle(int i3, int i16) {
        int i17 = i16 - i3;
        int reconcileSelectedPosition = reconcileSelectedPosition();
        View makeAndAddView = makeAndAddView(reconcileSelectedPosition, i3, true, this.mListPadding.left, true);
        if (makeAndAddView == null) {
            return makeAndAddView;
        }
        this.mFirstPosition = reconcileSelectedPosition;
        int measuredHeight = makeAndAddView.getMeasuredHeight();
        if (measuredHeight <= i17) {
            makeAndAddView.offsetTopAndBottom((i17 - measuredHeight) / 2);
        }
        fillAboveAndBelow(makeAndAddView, reconcileSelectedPosition);
        if (!this.mStackFromBottom) {
            correctTooHigh(getChildCount());
        } else {
            correctTooLow(getChildCount());
        }
        return makeAndAddView;
    }

    private View fillFromSelection(int i3, int i16, int i17) {
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int i18 = this.mSelectedPosition;
        int topSelectionPixel = getTopSelectionPixel(i16, verticalFadingEdgeLength, i18);
        int bottomSelectionPixel = getBottomSelectionPixel(i17, verticalFadingEdgeLength, i18);
        View makeAndAddView = makeAndAddView(i18, i3, true, this.mListPadding.left, true);
        if (makeAndAddView == null) {
            return makeAndAddView;
        }
        if (makeAndAddView.getBottom() > bottomSelectionPixel) {
            makeAndAddView.offsetTopAndBottom(-Math.min(makeAndAddView.getTop() - topSelectionPixel, makeAndAddView.getBottom() - bottomSelectionPixel));
        } else if (makeAndAddView.getTop() < topSelectionPixel) {
            makeAndAddView.offsetTopAndBottom(Math.min(topSelectionPixel - makeAndAddView.getTop(), bottomSelectionPixel - makeAndAddView.getBottom()));
        }
        fillAboveAndBelow(makeAndAddView, i18);
        if (!this.mStackFromBottom) {
            correctTooHigh(getChildCount());
        } else {
            correctTooLow(getChildCount());
        }
        return makeAndAddView;
    }

    private View fillFromTop(int i3) {
        int min = Math.min(this.mFirstPosition, this.mSelectedPosition);
        this.mFirstPosition = min;
        int min2 = Math.min(min, this.mItemCount - 1);
        this.mFirstPosition = min2;
        if (min2 < 0) {
            this.mFirstPosition = 0;
        }
        return fillDown(this.mFirstPosition, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View fillSpecific(int i3, int i16) {
        boolean z16;
        View view;
        View view2;
        if (i3 == this.mSelectedPosition) {
            z16 = true;
        } else {
            z16 = false;
        }
        View makeAndAddView = makeAndAddView(i3, i16, true, this.mListPadding.left, z16);
        if (makeAndAddView == null) {
            return makeAndAddView;
        }
        this.mFirstPosition = i3;
        int i17 = this.mDividerHeight;
        if (!this.mStackFromBottom) {
            view = fillUp(i3 - 1, makeAndAddView.getTop() - i17);
            adjustViewsUpOrDown();
            view2 = fillDown(i3 + 1, makeAndAddView.getBottom() + i17);
            int childCount = getChildCount();
            if (childCount > 0) {
                correctTooHigh(childCount);
            }
        } else {
            View fillDown = fillDown(i3 + 1, makeAndAddView.getBottom() + i17);
            adjustViewsUpOrDown();
            View fillUp = fillUp(i3 - 1, makeAndAddView.getTop() - i17);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                correctTooLow(childCount2);
            }
            view = fillUp;
            view2 = fillDown;
        }
        if (z16) {
            return makeAndAddView;
        }
        if (view != null) {
            return view;
        }
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View fillSpecificBottom(int i3, int i16) {
        boolean z16;
        View view;
        View view2;
        if (i3 == this.mSelectedPosition) {
            z16 = true;
        } else {
            z16 = false;
        }
        View makeAndAddView = makeAndAddView(i3, i16, false, this.mListPadding.left, z16);
        if (makeAndAddView == null) {
            return makeAndAddView;
        }
        this.mFirstPosition = i3;
        int i17 = this.mDividerHeight;
        if (!this.mStackFromBottom) {
            view = fillUp(i3 - 1, makeAndAddView.getTop() - i17);
            adjustViewsUpOrDown();
            view2 = fillDown(i3 + 1, makeAndAddView.getBottom() + i17);
            int childCount = getChildCount();
            if (childCount > 0) {
                correctTooHigh(childCount);
            }
        } else {
            View fillDown = fillDown(i3 + 1, makeAndAddView.getBottom() + i17);
            adjustViewsUpOrDown();
            View fillUp = fillUp(i3 - 1, makeAndAddView.getTop() - i17);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                correctTooLow(childCount2);
            }
            view = fillUp;
            view2 = fillDown;
        }
        if (z16) {
            return makeAndAddView;
        }
        if (view != null) {
            return view;
        }
        return view2;
    }

    private View fillUp(int i3, int i16) {
        int i17;
        boolean z16;
        View view = null;
        if (hasBooleanFlag(34)) {
            i17 = this.mListPadding.top;
        } else {
            i17 = 0;
        }
        while (i16 > i17 && i3 >= 0) {
            if (i3 == this.mSelectedPosition) {
                z16 = true;
            } else {
                z16 = false;
            }
            View makeAndAddView = makeAndAddView(i3, i16, false, this.mListPadding.left, z16);
            if (makeAndAddView != null) {
                i16 = makeAndAddView.getTop() - this.mDividerHeight;
                if (z16) {
                    view = makeAndAddView;
                }
            } else {
                QLog.e(AdapterView.TAG, 1, "fillUp childis null");
            }
            i3--;
        }
        this.mFirstPosition = i3 + 1;
        return view;
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getVerticalFadingEdgeLength());
    }

    private int getBottomSelectionPixel(int i3, int i16, int i17) {
        if (i17 != this.mItemCount - 1) {
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

    private boolean handleHorizontalFocusWithinListItem(int i3) {
        View selectedView;
        if (i3 != 17 && i3 != 66) {
            throw new IllegalArgumentException("direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
        }
        int childCount = getChildCount();
        if (this.mItemsCanFocus && childCount > 0 && this.mSelectedPosition != -1 && (selectedView = getSelectedView()) != null && selectedView.hasFocus() && (selectedView instanceof ViewGroup)) {
            View findFocus = selectedView.findFocus();
            View findNextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup) selectedView, findFocus, i3);
            if (findNextFocus != null) {
                findFocus.getFocusedRect(this.mTempRect);
                offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
                offsetRectIntoDescendantCoords(findNextFocus, this.mTempRect);
                if (findNextFocus.requestFocus(i3, this.mTempRect)) {
                    return true;
                }
            }
            View findNextFocus2 = FocusFinder.getInstance().findNextFocus((ViewGroup) getRootView(), findFocus, i3);
            if (findNextFocus2 != null) {
                return isViewAncestorOf(findNextFocus2, this);
            }
            return false;
        }
        return false;
    }

    private void handleNewSelectionChange(View view, int i3, int i16, boolean z16) {
        View childAt;
        boolean z17;
        boolean z18;
        if (i16 != -1) {
            int i17 = this.mSelectedPosition;
            int i18 = this.mFirstPosition;
            int i19 = i17 - i18;
            int i26 = i16 - i18;
            boolean z19 = true;
            if (i3 == 33) {
                z17 = true;
                childAt = view;
                view = getChildAt(i26);
                i19 = i26;
                i26 = i19;
            } else {
                childAt = getChildAt(i26);
                z17 = false;
            }
            int childCount = getChildCount();
            if (view != null) {
                if (!z16 && z17) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                view.setSelected(z18);
                measureAndAdjustDown(view, i19, childCount);
            }
            if (childAt != null) {
                if (z16 || z17) {
                    z19 = false;
                }
                childAt.setSelected(z19);
                measureAndAdjustDown(childAt, i26, childCount);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("newSelectedPosition needs to be valid");
    }

    private void invalidateWithoutNotiyParent(Rect rect) {
        try {
            Field declaredField = View.class.getDeclaredField("mPrivateFlags");
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(declaredField.getInt(this) | Integer.MIN_VALUE));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(AdapterView.TAG, 2, e16.getMessage(), e16);
            }
            postInvalidate(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    private boolean isViewAncestorOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        if ((parent instanceof ViewGroup) && isViewAncestorOf((View) parent, view2)) {
            return true;
        }
        return false;
    }

    private int lookForSelectablePositionOnScreen(int i3) {
        int i16;
        int i17 = this.mFirstPosition;
        if (i3 == 130) {
            int i18 = this.mSelectedPosition;
            if (i18 != -1) {
                i16 = i18 + 1;
            } else {
                i16 = i17;
            }
            if (i16 >= this.mAdapter.getCount()) {
                return -1;
            }
            if (i16 < i17) {
                i16 = i17;
            }
            int lastVisiblePosition = getLastVisiblePosition();
            ListAdapter adapter = getAdapter();
            while (i16 <= lastVisiblePosition) {
                if (adapter.isEnabled(i16) && getChildAt(i16 - i17).getVisibility() == 0) {
                    return i16;
                }
                i16++;
            }
        } else {
            int childCount = (getChildCount() + i17) - 1;
            int i19 = this.mSelectedPosition;
            if (i19 == -1) {
                i19 = getChildCount() + i17;
            }
            int i26 = i19 - 1;
            if (i26 >= 0 && i26 < this.mAdapter.getCount()) {
                if (i26 <= childCount) {
                    childCount = i26;
                }
                ListAdapter adapter2 = getAdapter();
                while (childCount >= i17) {
                    if (adapter2.isEnabled(childCount) && getChildAt(childCount - i17).getVisibility() == 0) {
                        return childCount;
                    }
                    childCount--;
                }
            }
        }
        return -1;
    }

    private View makeAndAddView(int i3, int i16, boolean z16, int i17, boolean z17) {
        View activeView;
        AdapterView.traceBegin("ListView.makeAndAddView");
        try {
            if (!this.mDataChanged && (activeView = this.mRecycler.getActiveView(i3)) != null) {
                setupChild(activeView, i3, i16, z16, i17, z17, true);
                return activeView;
            }
            View obtainView = obtainView(i3, this.mIsScrap);
            setupChild(obtainView, i3, i16, z16, i17, z17, this.mIsScrap[0]);
            return obtainView;
        } finally {
            AdapterView.traceEnd();
        }
    }

    private void measureAndAdjustDown(View view, int i3, int i16) {
        int height = view.getHeight();
        measureItem(view);
        if (view.getMeasuredHeight() != height) {
            relayoutMeasuredItem(view);
            int measuredHeight = view.getMeasuredHeight() - height;
            while (true) {
                i3++;
                if (i3 < i16) {
                    getChildAt(i3).offsetTopAndBottom(measuredHeight);
                } else {
                    return;
                }
            }
        }
    }

    private void measureItem(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int i3 = this.mWidthMeasureSpec;
        Rect rect = this.mListPadding;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, rect.left + rect.right, layoutParams.width);
        int i16 = layoutParams.height;
        if (i16 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private View moveSelection(View view, View view2, int i3, int i16, int i17) {
        View makeAndAddView;
        View makeAndAddView2;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int i18 = this.mSelectedPosition;
        int topSelectionPixel = getTopSelectionPixel(i16, verticalFadingEdgeLength, i18);
        int bottomSelectionPixel = getBottomSelectionPixel(i16, verticalFadingEdgeLength, i18);
        if (i3 > 0) {
            View makeAndAddView3 = makeAndAddView(i18 - 1, view.getTop(), true, this.mListPadding.left, false);
            int i19 = this.mDividerHeight;
            makeAndAddView = makeAndAddView(i18, makeAndAddView3.getBottom() + i19, true, this.mListPadding.left, true);
            if (makeAndAddView.getBottom() > bottomSelectionPixel) {
                int i26 = -Math.min(Math.min(makeAndAddView.getTop() - topSelectionPixel, makeAndAddView.getBottom() - bottomSelectionPixel), (i17 - i16) / 2);
                makeAndAddView3.offsetTopAndBottom(i26);
                makeAndAddView.offsetTopAndBottom(i26);
            }
            if (!this.mStackFromBottom) {
                fillUp(this.mSelectedPosition - 2, makeAndAddView.getTop() - i19);
                adjustViewsUpOrDown();
                fillDown(this.mSelectedPosition + 1, makeAndAddView.getBottom() + i19);
            } else {
                fillDown(this.mSelectedPosition + 1, makeAndAddView.getBottom() + i19);
                adjustViewsUpOrDown();
                fillUp(this.mSelectedPosition - 2, makeAndAddView.getTop() - i19);
            }
        } else if (i3 < 0) {
            if (view2 != null) {
                makeAndAddView2 = makeAndAddView(i18, view2.getTop(), true, this.mListPadding.left, true);
            } else {
                makeAndAddView2 = makeAndAddView(i18, view.getTop(), false, this.mListPadding.left, true);
            }
            makeAndAddView = makeAndAddView2;
            if (makeAndAddView.getTop() < topSelectionPixel) {
                makeAndAddView.offsetTopAndBottom(Math.min(Math.min(topSelectionPixel - makeAndAddView.getTop(), bottomSelectionPixel - makeAndAddView.getBottom()), (i17 - i16) / 2));
            }
            fillAboveAndBelow(makeAndAddView, i18);
        } else {
            int top = view.getTop();
            makeAndAddView = makeAndAddView(i18, top, true, this.mListPadding.left, true);
            if (top < i16 && makeAndAddView.getBottom() < i16 + 20) {
                makeAndAddView.offsetTopAndBottom(i16 - makeAndAddView.getTop());
            }
            fillAboveAndBelow(makeAndAddView, i18);
        }
        return makeAndAddView;
    }

    private int positionOfNewFocus(View view) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (isViewAncestorOf(view, getChildAt(i3))) {
                return this.mFirstPosition + i3;
            }
        }
        throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    }

    private void relayoutMeasuredItem(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = this.mListPadding.left;
        int top = view.getTop();
        view.layout(i3, top, measuredWidth + i3, measuredHeight + top);
    }

    private void removeFixedViewInfo(View view, ArrayList<FixedViewInfo> arrayList) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (arrayList.get(i3).view == view) {
                arrayList.remove(i3);
                return;
            }
        }
    }

    private void scrollListItemsBy(int i3) {
        int i16;
        int i17;
        offsetChildrenTopAndBottomWrap(i3);
        int height = getHeight();
        Rect rect = this.mListPadding;
        int i18 = height - rect.bottom;
        int i19 = rect.top;
        AbsListView.RecycleBin recycleBin = this.mRecycler;
        if (i3 < 0) {
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            while (childAt.getBottom() < i18 && (this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
                childAt = addViewBelow(childAt, i17);
                childCount++;
            }
            if (childAt.getBottom() < i18) {
                offsetChildrenTopAndBottomWrap(i18 - childAt.getBottom());
            }
            View childAt2 = getChildAt(0);
            while (childAt2.getBottom() < i19) {
                if (recycleBin.shouldRecycleViewType(((AbsListView.LayoutParams) childAt2.getLayoutParams()).viewType)) {
                    detachViewFromParent(childAt2);
                    recycleBin.addScrapView(childAt2, this.mFirstPosition);
                } else {
                    removeViewInLayout(childAt2);
                }
                childAt2 = getChildAt(0);
                this.mFirstPosition++;
            }
            return;
        }
        View childAt3 = getChildAt(0);
        while (childAt3.getTop() > i19 && (i16 = this.mFirstPosition) > 0) {
            childAt3 = addViewAbove(childAt3, i16);
            this.mFirstPosition--;
        }
        if (childAt3.getTop() > i19) {
            offsetChildrenTopAndBottomWrap(i19 - childAt3.getTop());
        }
        int childCount2 = getChildCount() - 1;
        View childAt4 = getChildAt(childCount2);
        while (childAt4.getTop() > i18) {
            if (recycleBin.shouldRecycleViewType(((AbsListView.LayoutParams) childAt4.getLayoutParams()).viewType)) {
                detachViewFromParent(childAt4);
                recycleBin.addScrapView(childAt4, this.mFirstPosition + childCount2);
            } else {
                removeViewInLayout(childAt4);
            }
            childCount2--;
            childAt4 = getChildAt(childCount2);
        }
    }

    @TargetApi(11)
    private void setupChild(View view, int i3, int i16, boolean z16, int i17, boolean z17, boolean z18) {
        setupChild(view, i3, i16, z16, i17, z17, z18, z16 ? -1 : 0);
    }

    private boolean showingBottomFadingEdge() {
        int childCount = getChildCount();
        int bottom = getChildAt(childCount - 1).getBottom();
        int i3 = (this.mFirstPosition + childCount) - 1;
        int scrollY = (getScrollY() + getHeight()) - this.mListPadding.bottom;
        if (i3 < this.mItemCount - 1 || bottom < scrollY) {
            return true;
        }
        return false;
    }

    private boolean showingTopFadingEdge() {
        int scrollY = getScrollY() + this.mListPadding.top;
        if (this.mFirstPosition <= 0 && getChildAt(0).getTop() <= scrollY) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stayOnTheTop() {
        int top;
        if (this.mStackFromBottom && this.mFirstPosition == 0 && getChildCount() > 0 && (top = getChildAt(0).getTop() - this.mListPadding.top) > 0) {
            offsetChildrenTopAndBottomWrap(-top);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public int updateChild(View view, int i3, int i16, boolean z16, int i17, int i18) {
        View view2;
        int makeMeasureSpec;
        SparseBooleanArray sparseBooleanArray;
        int height = view.getHeight();
        int i19 = ((AbsListView.LayoutParams) view.getLayoutParams()).viewType;
        int itemViewType = this.mAdapter.getItemViewType(i3);
        if (i19 == itemViewType) {
            view2 = this.mAdapter.getView(i3, view, this);
        } else {
            view2 = this.mAdapter.getView(i3, this.mRecycler.getScrapView(i3), this);
        }
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2, 0);
        }
        layoutParams.viewType = itemViewType;
        if (view2 != view) {
            boolean isSelected = view.isSelected();
            boolean isPressed = view.isPressed();
            this.mRecycler.addScrapView(view, i3);
            int i26 = this.mCacheColorHint;
            if (i26 != 0) {
                view2.setDrawingCacheBackgroundColor(i26);
            }
            detachViewFromParent(i18);
            addViewInLayout(view2, i18, layoutParams, true);
            if (view2.isSelected() != isSelected) {
                view2.setSelected(isSelected);
            }
            if (view2.isPressed() != isPressed) {
                view2.setPressed(isPressed);
            }
            if (this.mChoiceMode != 0 && (sparseBooleanArray = this.mCheckStates) != null) {
                if (view2 instanceof Checkable) {
                    ((Checkable) view2).setChecked(sparseBooleanArray.get(i3));
                } else if (getContext().getApplicationInfo().targetSdkVersion >= 11 && VersionUtils.isHoneycomb()) {
                    view2.setActivated(this.mCheckStates.get(i3));
                }
            }
        }
        boolean isLayoutRequested = view2.isLayoutRequested();
        if (isLayoutRequested) {
            int i27 = this.mWidthMeasureSpec;
            Rect rect = this.mListPadding;
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i27, rect.left + rect.right, ((ViewGroup.LayoutParams) layoutParams).width);
            int i28 = ((ViewGroup.LayoutParams) layoutParams).height;
            if (i28 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i28, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view2.measure(childMeasureSpec, makeMeasureSpec);
        } else {
            cleanupLayoutState(view2);
        }
        int measuredWidth = view2.getMeasuredWidth();
        int measuredHeight = view2.getMeasuredHeight();
        if (!z16) {
            i16 -= measuredHeight;
        }
        if (isLayoutRequested) {
            view2.layout(i17, i16, measuredWidth + i17, measuredHeight + i16);
        } else {
            view2.offsetLeftAndRight(i17 - view2.getLeft());
            view2.offsetTopAndBottom(i16 - view2.getTop());
        }
        if (this.mCachingStarted && !view2.isDrawingCacheEnabled()) {
            view2.setDrawingCacheEnabled(true);
        }
        if (VersionUtils.isHoneycomb() && ((AbsListView.LayoutParams) view2.getLayoutParams()).scrappedFromPosition != i3) {
            view2.jumpDrawablesToCurrentState();
        }
        return view2.getHeight() - height;
    }

    public void addFooterView(View view, Object obj, boolean z16) {
        AbsListView.AdapterDataSetObserver adapterDataSetObserver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, view, obj, Boolean.valueOf(z16));
            return;
        }
        FixedViewInfo fixedViewInfo = new FixedViewInfo();
        fixedViewInfo.view = view;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z16;
        this.mFooterViewInfos.add(fixedViewInfo);
        if (this.mAdapter == null || (adapterDataSetObserver = this.mDataSetObserver) == null) {
            return;
        }
        adapterDataSetObserver.onChanged();
    }

    public void addHeaderView(View view, Object obj, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            addHeaderView(view, 1, obj, z16);
        } else {
            iPatchRedirector.redirect((short) 10, this, view, obj, Boolean.valueOf(z16));
        }
    }

    boolean arrowScroll(int i3) {
        try {
            this.mInLayout = true;
            boolean arrowScrollImpl = arrowScrollImpl(i3);
            if (arrowScrollImpl) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i3));
            }
            return arrowScrollImpl;
        } finally {
            this.mInLayout = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AdapterView, android.view.ViewGroup
    public boolean canAnimate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this)).booleanValue();
        }
        if (super.canAnimate() && this.mItemCount > 0) {
            return true;
        }
        return false;
    }

    public void clearDelAnim() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, (Object) this);
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getAnimation() != null) {
                childAt.clearAnimation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c7  */
    @Override // com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dispatchDraw(Canvas canvas) {
        boolean z16;
        boolean z17;
        boolean z18;
        OverscrollViewContainer overscrollViewContainer;
        int i3;
        boolean z19;
        int i16;
        Paint paint;
        int i17;
        int bottom;
        int i18;
        Paint paint2;
        int i19;
        ListAdapter listAdapter;
        int i26;
        int i27;
        int i28;
        ListAdapter listAdapter2;
        Paint paint3;
        int i29;
        View childAt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) canvas);
            return;
        }
        if (this.mCachingStarted) {
            this.mCachingActive = true;
        }
        int i36 = this.mDividerHeight;
        Drawable drawable = this.mOverScrollHeader;
        OverscrollViewContainer overscrollViewContainer2 = this.mOverscrollHeaderViewContainer;
        OverscrollViewContainer overscrollViewContainer3 = this.mOverscrollFooterView;
        Drawable drawable2 = this.mOverScrollFooter;
        Drawable drawable3 = this.mOverScrollHeaderShadow;
        if (drawable == null && overscrollViewContainer2 == null && drawable3 == null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (drawable2 == null && overscrollViewContainer3 == null) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (i36 > 0 && this.mDivider != null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (this.mContentBackgroundDrawable != null) {
            Rect rect = this.mTempRect;
            rect.top = 0;
            rect.bottom = getHeight();
            rect.left = 0;
            rect.right = getWidth();
            int save = canvas.save();
            if (getScrollY() > 0) {
                rect.top += getScrollY();
                rect.bottom += getScrollY();
            }
            if (this.mUseEfficientMode) {
                int childCount = getChildCount();
                if (childCount > 0 && (childAt = getChildAt(childCount - 1)) != null) {
                    overscrollViewContainer = overscrollViewContainer3;
                    if (getLastVisiblePosition() == getCount() - 1) {
                        i29 = childAt.getTop();
                    } else {
                        i29 = childAt.getBottom();
                    }
                } else {
                    overscrollViewContainer = overscrollViewContainer3;
                    i29 = 0;
                }
                if (i29 < 0) {
                    i29 = 0;
                } else {
                    int i37 = rect.bottom;
                    if (i29 > i37) {
                        i29 = i37;
                    }
                }
                canvas.clipRect(0, i29, rect.right, rect.bottom);
            } else {
                overscrollViewContainer = overscrollViewContainer3;
            }
            this.mContentBackgroundDrawable.setBounds(rect);
            this.mContentBackgroundDrawable.draw(canvas);
            canvas.restoreToCount(save);
        } else {
            overscrollViewContainer = overscrollViewContainer3;
        }
        if (z18 || z16 || z17) {
            Rect rect2 = this.mTempRect;
            rect2.left = getPaddingLeft();
            rect2.right = (getRight() - getLeft()) - getPaddingRight();
            int childCount2 = getChildCount();
            int size = this.mHeaderViewInfos.size();
            int i38 = this.mItemCount;
            ArrayList<FixedViewInfo> arrayList = this.mFooterViewInfos;
            if (arrayList != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            boolean z26 = true;
            int i39 = (i38 - i3) - 1;
            boolean z27 = this.mHeaderDividersEnabled;
            boolean z28 = this.mFooterDividersEnabled;
            boolean z29 = z17;
            int i46 = this.mFirstPosition;
            boolean z36 = this.mAreAllItemsSelectable;
            ListAdapter listAdapter3 = this.mAdapter;
            if (VersionUtils.isECLAIR_MR1()) {
                if (!isOpaque() || super.isOpaque()) {
                    z19 = false;
                    if (!z19 && this.mDividerPaint == null && this.mIsCacheColorOpaque) {
                        Paint paint4 = new Paint();
                        this.mDividerPaint = paint4;
                        i16 = i39;
                        paint4.setColor(getCacheColorHint());
                    } else {
                        i16 = i39;
                    }
                    paint = this.mDividerPaint;
                    if (!hasBooleanFlag(34)) {
                        i17 = this.mListPadding.bottom;
                    } else {
                        i17 = 0;
                    }
                    bottom = ((getBottom() - getTop()) - i17) + getScrollY();
                    int scrollY = getScrollY();
                    if (childCount2 <= 0 && scrollY < 0) {
                        if (z16) {
                            int i47 = this.mListPadding.top;
                            i18 = bottom;
                            int i48 = (i47 + 0) - this.mDividerHeight;
                            int i49 = this.mOverScrollHeaderTopOffset;
                            rect2.bottom = i48 + i49;
                            rect2.top = i47 + scrollY + i49;
                            int i56 = i16;
                            listAdapter = listAdapter3;
                            paint2 = paint;
                            i26 = i56;
                            drawOverscrollHeader(canvas, overscrollViewContainer2, drawable3, drawable, rect2);
                        } else {
                            i18 = bottom;
                            paint2 = paint;
                            int i57 = i16;
                            listAdapter = listAdapter3;
                            i26 = i57;
                        }
                        i19 = 0;
                        if (z18) {
                            rect2.bottom = 0;
                            rect2.top = -i36;
                            drawDivider(canvas, rect2, -1);
                        }
                    } else {
                        i18 = bottom;
                        paint2 = paint;
                        i19 = 0;
                        int i58 = i16;
                        listAdapter = listAdapter3;
                        i26 = i58;
                    }
                    if (z18) {
                        int i59 = i19;
                        while (i59 < childCount2) {
                            if ((!z27 && i46 + i59 < size) || (!z28 && i46 + i59 >= i26)) {
                                listAdapter2 = listAdapter;
                                i28 = i18;
                            } else {
                                int bottom2 = getChildAt(i59).getBottom();
                                i28 = i18;
                                if (bottom2 < i28 && (!z29 || i59 != childCount2 - 1)) {
                                    if (!z36) {
                                        int i65 = i46 + i59;
                                        listAdapter2 = listAdapter;
                                        if (!listAdapter2.isEnabled(i65) || (i59 != childCount2 - 1 && !listAdapter2.isEnabled(i65 + 1))) {
                                            if (z19) {
                                                rect2.top = bottom2;
                                                rect2.bottom = bottom2 + i36;
                                                paint3 = paint2;
                                                canvas.drawRect(rect2, paint3);
                                                i59++;
                                                i18 = i28;
                                                paint2 = paint3;
                                                listAdapter = listAdapter2;
                                            }
                                        }
                                    } else {
                                        listAdapter2 = listAdapter;
                                    }
                                    paint3 = paint2;
                                    rect2.top = bottom2;
                                    rect2.bottom = bottom2 + i36;
                                    drawDivider(canvas, rect2, i59);
                                    i59++;
                                    i18 = i28;
                                    paint2 = paint3;
                                    listAdapter = listAdapter2;
                                } else {
                                    listAdapter2 = listAdapter;
                                }
                            }
                            paint3 = paint2;
                            i59++;
                            i18 = i28;
                            paint2 = paint3;
                            listAdapter = listAdapter2;
                        }
                    }
                    int bottom3 = getBottom() + scrollY + this.mDividerHeight;
                    if (z29 && i46 + childCount2 == i38 && bottom3 > getBottom()) {
                        if (!this.considerFooterWhenDrawOverScrollFooter) {
                            ArrayList<FixedViewInfo> arrayList2 = this.mFooterViewInfos;
                            if (arrayList2 != null) {
                                Iterator<FixedViewInfo> it = arrayList2.iterator();
                                i27 = i19;
                                while (it.hasNext()) {
                                    i27 += it.next().view.getHeight();
                                }
                            } else {
                                i27 = i19;
                            }
                            int bottom4 = getBottom() + this.mDividerHeight;
                            int i66 = this.mListPadding.bottom;
                            rect2.top = (bottom4 - i66) - i27;
                            rect2.bottom = (bottom3 - i66) - i27;
                        } else {
                            rect2.top = getBottom() + this.mDividerHeight;
                            rect2.bottom = bottom3;
                        }
                        drawOverscrollFooter(canvas, overscrollViewContainer, drawable2, rect2);
                    }
                }
            } else {
                z26 = isOpaque();
            }
            z19 = z26;
            if (!z19) {
            }
            i16 = i39;
            paint = this.mDividerPaint;
            if (!hasBooleanFlag(34)) {
            }
            bottom = ((getBottom() - getTop()) - i17) + getScrollY();
            int scrollY2 = getScrollY();
            if (childCount2 <= 0) {
            }
            i18 = bottom;
            paint2 = paint;
            i19 = 0;
            int i582 = i16;
            listAdapter = listAdapter3;
            i26 = i582;
            if (z18) {
            }
            int bottom32 = getBottom() + scrollY2 + this.mDividerHeight;
            if (z29) {
                if (!this.considerFooterWhenDrawOverScrollFooter) {
                }
                drawOverscrollFooter(canvas, overscrollViewContainer, drawable2, rect2);
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this, (Object) keyEvent)).booleanValue();
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        if (!dispatchKeyEvent && getFocusedChild() != null && keyEvent.getAction() == 0) {
            return onKeyDown(keyEvent.getKeyCode(), keyEvent);
        }
        return dispatchKeyEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, this, canvas, view, Long.valueOf(j3))).booleanValue();
        }
        try {
            z16 = super.drawChild(canvas, view, j3);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(AdapterView.TAG, 2, e16, new Object[0]);
            }
            z16 = false;
        }
        if (this.mCachingActive) {
            this.mCachingActive = false;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawDivider(Canvas canvas, Rect rect, int i3) {
        Drawable drawable = this.mDivider;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    void drawOverscrollFooter(Canvas canvas, View view, Drawable drawable, Rect rect) {
        canvas.save();
        if (drawable != null) {
            int minimumHeight = drawable.getMinimumHeight();
            canvas.clipRect(rect);
            int i3 = rect.bottom;
            int i16 = rect.top;
            if (i3 - i16 < minimumHeight) {
                rect.bottom = i16 + minimumHeight;
            }
            drawable.setBounds(rect);
            drawable.draw(canvas);
        }
        if (view != null) {
            checkOverscrollViewIsCompleteVisable(view);
            view.offsetTopAndBottom(rect.top - view.getTop());
            drawChild(canvas, view, getDrawingTime());
        }
        canvas.restore();
    }

    protected void drawOverscrollHeader(Canvas canvas, View view, Drawable drawable, Drawable drawable2, Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, canvas, view, drawable, drawable2, rect);
            return;
        }
        int save = canvas.save();
        if (drawable != null) {
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight < rect.height()) {
                Rect rect2 = new Rect(rect);
                rect2.top = (rect2.top + rect.height()) - intrinsicHeight;
                drawable.setBounds(rect2);
            } else {
                drawable.setBounds(rect);
            }
            drawable.draw(canvas);
        }
        if (drawable2 != null) {
            int minimumHeight = drawable2.getMinimumHeight();
            int i3 = rect.bottom;
            if (i3 - rect.top < minimumHeight) {
                rect.top = i3 - minimumHeight;
            }
            drawable2.setBounds(rect);
            drawable2.draw(canvas);
        }
        if (view != null) {
            checkOverscrollViewIsCompleteVisable(view);
            view.offsetTopAndBottom(rect.bottom - view.getBottom());
            drawChild(canvas, view, getDrawingTime());
        }
        canvas.restoreToCount(save);
    }

    @Override // com.tencent.widget.AbsListView
    void fillGap(boolean z16) {
        int i3;
        int height;
        int childCount = getChildCount();
        int i16 = 0;
        if (z16) {
            if (hasBooleanFlag(34)) {
                i16 = getListPaddingTop();
            }
            if (childCount > 0) {
                i16 = getChildAt(childCount - 1).getBottom() + this.mDividerHeight;
            }
            fillDown(this.mFirstPosition + childCount, i16);
            correctTooHigh(getChildCount());
            return;
        }
        if (hasBooleanFlag(34)) {
            i3 = getListPaddingBottom();
        } else {
            i3 = 0;
        }
        if (childCount > 0) {
            height = getChildAt(0).getTop() - this.mDividerHeight;
        } else {
            height = getHeight() - i3;
        }
        fillUp(this.mFirstPosition - 1, height);
        correctTooLow(getChildCount());
    }

    public int findHeaderViewPosition(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) view)).intValue();
        }
        int size = this.mHeaderViewInfos.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.mHeaderViewInfos.get(i3).view == view) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.tencent.widget.AbsListView
    int findMotionRow(int i3) {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (!this.mStackFromBottom) {
                for (int i16 = 0; i16 < childCount; i16++) {
                    if (i3 <= getChildAt(i16).getBottom()) {
                        return this.mFirstPosition + i16;
                    }
                }
                return -1;
            }
            for (int i17 = childCount - 1; i17 >= 0; i17--) {
                if (i3 >= getChildAt(i17).getTop()) {
                    return this.mFirstPosition + i17;
                }
            }
            return -1;
        }
        return -1;
    }

    boolean fullScroll(int i3) {
        boolean z16 = true;
        if (i3 == 33) {
            if (this.mSelectedPosition != 0) {
                int lookForSelectablePosition = lookForSelectablePosition(0, true);
                if (lookForSelectablePosition >= 0) {
                    this.mLayoutMode = 1;
                    setSelectionInt(lookForSelectablePosition);
                    invokeOnItemScrollListener();
                }
            }
            z16 = false;
        } else {
            if (i3 == 130) {
                int i16 = this.mSelectedPosition;
                int i17 = this.mItemCount;
                if (i16 < i17 - 1) {
                    int lookForSelectablePosition2 = lookForSelectablePosition(i17 - 1, true);
                    if (lookForSelectablePosition2 >= 0) {
                        this.mLayoutMode = 3;
                        setSelectionInt(lookForSelectablePosition2);
                        invokeOnItemScrollListener();
                    }
                }
            }
            z16 = false;
        }
        if (z16 && !awakenScrollBars()) {
            awakenScrollBars();
            invalidate();
        }
        return z16;
    }

    @Deprecated
    public long[] getCheckItemIds() {
        SparseBooleanArray sparseBooleanArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (long[]) iPatchRedirector.redirect((short) 67, (Object) this);
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && listAdapter.hasStableIds()) {
            return getCheckedItemIds();
        }
        if (this.mChoiceMode != 0 && (sparseBooleanArray = this.mCheckStates) != null && this.mAdapter != null) {
            int size = sparseBooleanArray.size();
            long[] jArr = new long[size];
            ListAdapter listAdapter2 = this.mAdapter;
            int i3 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                if (sparseBooleanArray.valueAt(i16)) {
                    jArr[i3] = listAdapter2.getItemId(sparseBooleanArray.keyAt(i16));
                    i3++;
                }
            }
            if (i3 == size) {
                return jArr;
            }
            long[] jArr2 = new long[i3];
            System.arraycopy(jArr, 0, jArr2, 0, i3);
            return jArr2;
        }
        return new long[0];
    }

    public Drawable getContentBackgroundDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            return (Drawable) iPatchRedirector.redirect((short) 94, (Object) this);
        }
        return this.mContentBackgroundDrawable;
    }

    protected int getDefaultChildHeightSpec(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this, (Object) view, i3)).intValue();
        }
        return View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    public long getDelAnimationDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            return ((Long) iPatchRedirector.redirect((short) 88, (Object) this)).longValue();
        }
        long j3 = this.delAnimDuration;
        if (j3 > 0) {
            return j3;
        }
        return 350L;
    }

    public Drawable getDivider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (Drawable) iPatchRedirector.redirect((short) 54, (Object) this);
        }
        return this.mDivider;
    }

    public int getDividerHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Integer) iPatchRedirector.redirect((short) 56, (Object) this)).intValue();
        }
        return this.mDividerHeight;
    }

    @Override // com.tencent.widget.AbsListView
    public int getFooterViewsCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.mFooterViewInfos.size();
    }

    @Override // com.tencent.widget.AbsListView
    public int getHeaderViewsCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? this.mHeaderViewInfos.size() : ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
    }

    public boolean getItemsCanFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this)).booleanValue();
        }
        return this.mItemsCanFocus;
    }

    public int getListViewScrollY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            return ((Integer) iPatchRedirector.redirect((short) 101, (Object) this)).intValue();
        }
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null) {
            return getScrollY();
        }
        int firstVisiblePosition = getFirstVisiblePosition();
        if (firstVisiblePosition >= this.mHeaderViewInfos.size()) {
            Iterator<FixedViewInfo> it = this.mHeaderViewInfos.iterator();
            while (it.hasNext()) {
                i3 += it.next().view.getHeight();
            }
            return i3 + (-childAt.getTop()) + ((firstVisiblePosition - this.mHeaderViewInfos.size()) * childAt.getHeight());
        }
        int i16 = 0;
        while (i3 < firstVisiblePosition) {
            i16 += this.mHeaderViewInfos.get(i3).view.getHeight();
            i3++;
        }
        return (-childAt.getTop()) + i16;
    }

    public int getMaxScrollAmount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return (int) ((getBottom() - getTop()) * MAX_SCROLL_FACTOR);
    }

    public int getOverScrollFooterHeight() {
        OverscrollViewContainer overscrollViewContainer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        int i3 = this.mOverScrollFooterHeight;
        if (i3 == 0 && (overscrollViewContainer = this.mOverscrollFooterView) != null) {
            return overscrollViewContainer.getHeight();
        }
        return i3;
    }

    public View getOverScrollFooterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (View) iPatchRedirector.redirect((short) 71, (Object) this);
        }
        return this.mOverscrollFooterView;
    }

    public View getOverScrollHeaderView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (View) iPatchRedirector.redirect((short) 70, (Object) this);
        }
        return this.mOverscrollHeaderViewContainer;
    }

    public int getOverScrollHeight() {
        OverscrollViewContainer overscrollViewContainer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int i3 = this.mOverScrollHeight;
        if (i3 == 0 && (overscrollViewContainer = this.mOverscrollHeaderViewContainer) != null) {
            return overscrollViewContainer.getHeight();
        }
        return i3;
    }

    public Drawable getOverscrollFooter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (Drawable) iPatchRedirector.redirect((short) 64, (Object) this);
        }
        return this.mOverScrollFooter;
    }

    public Drawable getOverscrollHeader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (Drawable) iPatchRedirector.redirect((short) 62, (Object) this);
        }
        return this.mOverScrollHeader;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView
    public int getSpringbackOffset() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return ((Integer) iPatchRedirector.redirect((short) 73, (Object) this)).intValue();
        }
        int scrollY = getScrollY();
        if (this.mOverscrollHeaderViewContainer != null && scrollY < 0) {
            if (scrollY <= (-getOverScrollHeight())) {
                if (this.mOverscrollHeadState == 2) {
                    OverScrollViewListener overScrollViewListener = this.mOverScrollViewListener;
                    if (overScrollViewListener != null) {
                        z17 = overScrollViewListener.onViewCompleteVisableAndReleased(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this);
                    } else {
                        z17 = false;
                    }
                    this.mOverscrollHeadState = 3;
                } else {
                    z17 = false;
                }
                if (z17) {
                    if (this.mOverscrollHeaderViewContainer == null) {
                        return 0;
                    }
                    return -getOverScrollHeight();
                }
                this.mOverscrollHeadState = 0;
                return 0;
            }
            if (this.mOverscrollHeadState < 2) {
                OverScrollViewListener overScrollViewListener2 = this.mOverScrollViewListener;
                if (overScrollViewListener2 != null) {
                    overScrollViewListener2.onViewNotCompleteVisableAndReleased(0, this.mOverscrollHeaderViewContainer.getChildAt(0), this);
                }
                this.mOverscrollHeadState = 0;
            }
            return 0;
        }
        if (this.mOverscrollFooterView != null && scrollY > 0) {
            if (scrollY >= getOverScrollFooterHeight()) {
                if (this.mOverscrollHeadState == 2) {
                    OverScrollViewListener overScrollViewListener3 = this.mOverScrollViewListener;
                    if (overScrollViewListener3 != null) {
                        z16 = overScrollViewListener3.onViewCompleteVisableAndReleased(1, this.mOverscrollFooterView.getChildAt(0), this);
                    } else {
                        z16 = false;
                    }
                    this.mOverscrollHeadState = 3;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (this.mOverscrollFooterView == null) {
                        return 0;
                    }
                    return getOverScrollFooterHeight();
                }
                this.mOverscrollHeadState = 0;
                return 0;
            }
            if (this.mOverscrollHeadState < 2) {
                OverScrollViewListener overScrollViewListener4 = this.mOverScrollViewListener;
                if (overScrollViewListener4 != null) {
                    overScrollViewListener4.onViewNotCompleteVisableAndReleased(1, this.mOverscrollFooterView.getChildAt(0), this);
                }
                this.mOverscrollHeadState = 0;
            }
        }
        return 0;
    }

    public void hideOverScrollHeaderView() {
        int bottom;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this);
            return;
        }
        if (getScrollY() < 0) {
            abordFling();
            if (!this.mStackFromBottom) {
                setSelectionFromTop(this.mFirstPosition, this.mListPadding.top - getScrollY());
            } else {
                this.mLayoutMode = 100;
                View childAt = getChildAt(0);
                if (childAt == null) {
                    bottom = 0;
                } else {
                    bottom = (this.mLayoutHeight - childAt.getBottom()) - this.mListPadding.bottom;
                }
                setSelectionFromBottom(this.mFirstPosition, bottom + getScrollY());
            }
            onScrollChanged(0, 0, 0, getScrollY());
            setScrollY(0);
        }
        this.mOverscrollHeadState = 0;
    }

    public void hideOverScrollerFooterView() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this);
            return;
        }
        if (getScrollY() > 0) {
            abordFling();
            int childCount = getChildCount();
            if (childCount > 0 && this.mItemCount > 0 && (i3 = this.mFirstPosition) >= 0) {
                int i16 = (i3 + childCount) - 1;
                if (this.mStackFromBottom) {
                    this.mLayoutMode = 100;
                    ArrayList<FixedViewInfo> arrayList = this.mFooterViewInfos;
                    if (arrayList != null && arrayList.size() > 0) {
                        Iterator<FixedViewInfo> it = this.mFooterViewInfos.iterator();
                        int i17 = 0;
                        while (it.hasNext()) {
                            i17 += it.next().view.getHeight();
                        }
                        setSelectionFromBottom(i16 - this.mFooterViewInfos.size(), i17);
                    } else {
                        setSelectionFromBottom(i16, getScrollY());
                    }
                }
            }
            onScrollChanged(0, 0, 0, getScrollY());
            setScrollY(0);
        }
        this.mOverscrollHeadState = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initPaddingManual() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            return (ViewParent) iPatchRedirector.redirect((short) 84, (Object) this, (Object) iArr, (Object) rect);
        }
        ViewParent invalidateChildInParent = super.invalidateChildInParent(iArr, rect);
        if (rect.bottom > 0 && rect.top < getHeight()) {
            int scrollY = getScrollY();
            if (scrollY < 0 && rect.top + scrollY < 0) {
                invalidateWithoutNotiyParent(rect);
            } else if (scrollY > 0 && rect.bottom > getHeight() - scrollY) {
                invalidateWithoutNotiyParent(rect);
            }
        }
        return invalidateChildInParent;
    }

    public boolean isDirectChildHeaderOrFooter(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) view)).booleanValue();
        }
        ArrayList<FixedViewInfo> arrayList = this.mHeaderViewInfos;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (view == arrayList.get(i3).view) {
                return true;
            }
        }
        ArrayList<FixedViewInfo> arrayList2 = this.mFooterViewInfos;
        int size2 = arrayList2.size();
        for (int i16 = 0; i16 < size2; i16++) {
            if (view == arrayList2.get(i16).view) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Boolean) iPatchRedirector.redirect((short) 49, (Object) this)).booleanValue();
        }
        return false;
    }

    public boolean isOverscrollFooterVisiable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            return ((Boolean) iPatchRedirector.redirect((short) 98, (Object) this)).booleanValue();
        }
        if (getScrollY() > 0 && this.mOverscrollFooterView != null) {
            return true;
        }
        return false;
    }

    public boolean isOverscrollHeadVisiable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            return ((Boolean) iPatchRedirector.redirect((short) 97, (Object) this)).booleanValue();
        }
        if (getScrollY() < 0 && this.mOverscrollHeaderViewContainer != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a1 A[Catch: all -> 0x0358, Exception -> 0x035c, TryCatch #4 {Exception -> 0x035c, all -> 0x0358, blocks: (B:12:0x0020, B:14:0x002a, B:19:0x0038, B:28:0x0063, B:31:0x006a, B:32:0x0070, B:34:0x007e, B:35:0x0083, B:36:0x009d, B:38:0x00a1, B:39:0x00a4, B:41:0x00a8, B:46:0x00b6, B:48:0x00be, B:50:0x00ca, B:51:0x00d4, B:52:0x012e, B:53:0x012f, B:58:0x013d, B:201:0x0089, B:204:0x0090), top: B:11:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a8 A[Catch: all -> 0x0358, Exception -> 0x035c, TRY_LEAVE, TryCatch #4 {Exception -> 0x035c, all -> 0x0358, blocks: (B:12:0x0020, B:14:0x002a, B:19:0x0038, B:28:0x0063, B:31:0x006a, B:32:0x0070, B:34:0x007e, B:35:0x0083, B:36:0x009d, B:38:0x00a1, B:39:0x00a4, B:41:0x00a8, B:46:0x00b6, B:48:0x00be, B:50:0x00ca, B:51:0x00d4, B:52:0x012e, B:53:0x012f, B:58:0x013d, B:201:0x0089, B:204:0x0090), top: B:11:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b6 A[Catch: all -> 0x0358, Exception -> 0x035c, TRY_ENTER, TryCatch #4 {Exception -> 0x035c, all -> 0x0358, blocks: (B:12:0x0020, B:14:0x002a, B:19:0x0038, B:28:0x0063, B:31:0x006a, B:32:0x0070, B:34:0x007e, B:35:0x0083, B:36:0x009d, B:38:0x00a1, B:39:0x00a4, B:41:0x00a8, B:46:0x00b6, B:48:0x00be, B:50:0x00ca, B:51:0x00d4, B:52:0x012e, B:53:0x012f, B:58:0x013d, B:201:0x0089, B:204:0x0090), top: B:11:0x0020 }] */
    @Override // com.tencent.widget.AbsListView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutChildren() {
        boolean z16;
        int i3;
        View view;
        View view2;
        View view3;
        View view4;
        boolean z17;
        int i16;
        View view5;
        View fillSpecificBottom;
        int i17;
        boolean z18;
        int bottom;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        boolean z19 = this.mBlockLayoutRequests;
        if (!z19) {
            this.mBlockLayoutRequests = true;
            AdapterView.traceBegin("ListView.layoutChildren");
            try {
                try {
                    super.layoutChildren();
                    invalidate();
                } catch (Exception e16) {
                    e = e16;
                    z16 = z19;
                } catch (Throwable th5) {
                    th = th5;
                    if (!z19) {
                    }
                    AdapterView.traceEnd();
                    throw th;
                }
                if (this.mAdapter == null) {
                    resetList();
                    invokeOnItemScrollListener();
                    if (!z19) {
                        this.mBlockLayoutRequests = false;
                    }
                    AdapterView.traceEnd();
                    return;
                }
                int i18 = this.mListPadding.top;
                int bottom2 = (getBottom() - getTop()) - this.mListPadding.bottom;
                int childCount = getChildCount();
                int i19 = this.mFirstPosition;
                int i26 = (i19 + childCount) - 1;
                int i27 = this.mLayoutMode;
                if (i27 != 1) {
                    if (i27 != 2) {
                        if (i27 != 3 && i27 != 4 && i27 != 5) {
                            int i28 = this.mSelectedPosition - i19;
                            if (i28 >= 0 && i28 < childCount) {
                                view = getChildAt(i28);
                            } else {
                                view = null;
                            }
                            view3 = getChildAt(0);
                            view4 = getChildAt(childCount - 1);
                            int i29 = this.mNextSelectedPosition;
                            if (i29 >= 0) {
                                i3 = i29 - this.mSelectedPosition;
                            } else {
                                i3 = 0;
                            }
                            view2 = getChildAt(i28 + i3);
                            z17 = this.mDataChanged;
                            if (z17) {
                                handleDataChanged();
                            }
                            i16 = this.mItemCount;
                            if (i16 == 0) {
                                resetList();
                                invokeOnItemScrollListener();
                                if (!z19) {
                                    this.mBlockLayoutRequests = false;
                                }
                                AdapterView.traceEnd();
                                return;
                            }
                            if (i16 != this.mAdapter.getCount()) {
                                Class<?> cls = this.mAdapter.getClass();
                                ListAdapter listAdapter = this.mAdapter;
                                if (listAdapter instanceof HeaderViewListAdapter) {
                                    cls = ((HeaderViewListAdapter) listAdapter).getWrappedAdapter().getClass();
                                }
                                throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + cls + ")]mItemCount=" + this.mItemCount + "mAdapter.getCount()=" + this.mAdapter.getCount() + ",adapter.addr = " + this.mAdapter.toString());
                            }
                            setSelectedPositionInt(this.mNextSelectedPosition);
                            int i36 = this.mFirstPosition;
                            AbsListView.RecycleBin recycleBin = this.mRecycler;
                            try {
                                if (z17) {
                                    int i37 = 0;
                                    while (i37 < childCount) {
                                        boolean z26 = z19;
                                        recycleBin.addScrapView(getChildAt(i37), i36 + i37);
                                        i37++;
                                        z19 = z26;
                                    }
                                    z16 = z19;
                                } else {
                                    z16 = z19;
                                    recycleBin.fillActiveViews(childCount, i36);
                                }
                                View focusedChild = getFocusedChild();
                                if (focusedChild != null) {
                                    if (z17 && !isDirectChildHeaderOrFooter(focusedChild)) {
                                        focusedChild = null;
                                        view5 = null;
                                        requestFocus();
                                    }
                                    view5 = findFocus();
                                    if (view5 != null) {
                                        view5.onStartTemporaryDetach();
                                    }
                                    requestFocus();
                                } else {
                                    focusedChild = null;
                                    view5 = null;
                                }
                                detachAllViewsFromParent();
                                int i38 = this.mLayoutMode;
                                if (i38 != 100) {
                                    switch (i38) {
                                        case 1:
                                            this.mFirstPosition = 0;
                                            fillSpecificBottom = fillFromTop(i18);
                                            adjustViewsUpOrDown();
                                            break;
                                        case 2:
                                            if (view2 != null) {
                                                fillSpecificBottom = fillFromSelection(view2.getTop(), i18, bottom2);
                                                break;
                                            } else {
                                                fillSpecificBottom = fillFromMiddle(i18, bottom2);
                                                break;
                                            }
                                        case 3:
                                            fillSpecificBottom = fillUp(this.mItemCount - 1, bottom2);
                                            adjustViewsUpOrDown();
                                            break;
                                        case 4:
                                            fillSpecificBottom = fillSpecific(reconcileSelectedPosition(), this.mSpecificTop);
                                            break;
                                        case 5:
                                            if (!this.mStackFromBottom) {
                                                fillSpecificBottom = fillSpecific(this.mSyncPosition, this.mSpecificTop);
                                                break;
                                            } else {
                                                fillSpecificBottom = fillSpecificBottom(this.mSyncPosition, this.mLayoutHeight - this.mSpecificBottom);
                                                break;
                                            }
                                        case 6:
                                            fillSpecificBottom = moveSelection(view, view2, i3, i18, bottom2);
                                            break;
                                        default:
                                            if (childCount == 0) {
                                                if (!this.mStackFromBottom) {
                                                    setSelectedPositionInt(lookForSelectablePosition(0, true));
                                                    fillSpecificBottom = fillFromTop(i18);
                                                    break;
                                                } else {
                                                    setSelectedPositionInt(lookForSelectablePosition(this.mItemCount - 1, false));
                                                    fillSpecificBottom = fillUp(this.mItemCount - 1, bottom2);
                                                    break;
                                                }
                                            } else {
                                                int i39 = this.mSelectedPosition;
                                                if (i39 >= 0 && i39 < this.mItemCount) {
                                                    if (view != null) {
                                                        i18 = view.getTop();
                                                    }
                                                    fillSpecificBottom = fillSpecific(i39, i18);
                                                    break;
                                                } else if ((getScrollY() == 0 && !this.mStackFromBottom) || getScrollY() < 0) {
                                                    int i46 = this.mFirstPosition;
                                                    if (i46 < this.mItemCount) {
                                                        if (view3 != null) {
                                                            i18 = view3.getTop();
                                                        }
                                                        fillSpecificBottom = fillSpecific(i46, i18);
                                                        break;
                                                    } else {
                                                        fillSpecificBottom = fillSpecific(0, i18);
                                                        break;
                                                    }
                                                } else {
                                                    int i47 = this.mItemCount;
                                                    if (i26 < i47) {
                                                        if (view4 == null) {
                                                            bottom = bottom2;
                                                        } else {
                                                            bottom = view4.getBottom();
                                                        }
                                                        fillSpecificBottom = fillSpecificBottom(i26, bottom);
                                                        break;
                                                    } else {
                                                        fillSpecificBottom = fillSpecificBottom(i47 - 1, this.mLayoutHeight);
                                                        break;
                                                    }
                                                }
                                            }
                                            break;
                                    }
                                } else {
                                    fillSpecificBottom = fillSpecificBottom(reconcileSelectedPosition(), this.mLayoutHeight - this.mSpecificBottom);
                                }
                                stayOnTheTop();
                                recycleBin.scrapActiveViews();
                                if (fillSpecificBottom != null) {
                                    if (this.mItemsCanFocus && hasFocus() && !fillSpecificBottom.hasFocus()) {
                                        if ((fillSpecificBottom == focusedChild && view5 != null && view5.requestFocus()) || fillSpecificBottom.requestFocus()) {
                                            z18 = true;
                                        } else {
                                            z18 = false;
                                        }
                                        if (!z18) {
                                            View focusedChild2 = getFocusedChild();
                                            if (focusedChild2 != null) {
                                                focusedChild2.clearFocus();
                                            }
                                            positionSelector(-1, fillSpecificBottom);
                                        } else {
                                            fillSpecificBottom.setSelected(false);
                                            this.mSelectorRect.setEmpty();
                                        }
                                    } else {
                                        positionSelector(-1, fillSpecificBottom);
                                    }
                                    this.mSelectedTop = fillSpecificBottom.getTop();
                                } else {
                                    int i48 = this.mTouchMode;
                                    if (i48 > 0 && i48 < 3) {
                                        View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
                                        if (childAt != null) {
                                            positionSelector(this.mMotionPosition, childAt);
                                        }
                                    } else {
                                        this.mSelectedTop = 0;
                                        this.mSelectorRect.setEmpty();
                                    }
                                    if (hasFocus() && view5 != null) {
                                        view5.requestFocus();
                                    }
                                }
                                if (view5 != null && view5.getWindowToken() != null) {
                                    view5.onFinishTemporaryDetach();
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
                                int childCount2 = (this.mFirstPosition + getChildCount()) - 1;
                                if (this.mInsertAnimation != null && this.mAddingRows != null && z17 && (i17 = this.mItemCount) > 0 && childCount2 >= i17 - 1 && getChildAt(getChildCount() - 1).getBottom() < bottom2) {
                                    for (int i49 : this.mAddingRows) {
                                        int i56 = this.mFirstPosition;
                                        if (i49 >= i56 && i49 <= childCount2) {
                                            getChildAt(i49 - i56).startAnimation(this.mInsertAnimation);
                                        }
                                    }
                                }
                                this.mAddingRows = null;
                                if (!z16) {
                                    this.mBlockLayoutRequests = false;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                QLog.e(AdapterView.TAG, 1, e, new Object[0]);
                                if (!z16) {
                                    this.mBlockLayoutRequests = false;
                                }
                                AdapterView.traceEnd();
                                return;
                            }
                            AdapterView.traceEnd();
                            return;
                        }
                    } else {
                        int i57 = this.mNextSelectedPosition - i19;
                        if (i57 >= 0 && i57 < childCount) {
                            view2 = getChildAt(i57);
                            i3 = 0;
                            view = null;
                            view3 = null;
                            view4 = null;
                            z17 = this.mDataChanged;
                            if (z17) {
                            }
                            i16 = this.mItemCount;
                            if (i16 == 0) {
                            }
                        }
                    }
                }
                i3 = 0;
                view = null;
                view2 = null;
                view3 = null;
                view4 = null;
                z17 = this.mDataChanged;
                if (z17) {
                }
                i16 = this.mItemCount;
                if (i16 == 0) {
                }
            } catch (Throwable th6) {
                th = th6;
                if (!z19) {
                    this.mBlockLayoutRequests = false;
                }
                AdapterView.traceEnd();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.widget.AdapterView
    public int lookForSelectablePosition(int i3, boolean z16) {
        int min;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && !isInTouchMode()) {
            int count = listAdapter.getCount();
            if (!this.mAreAllItemsSelectable) {
                if (z16) {
                    min = Math.max(0, i3);
                    while (min < count && !listAdapter.isEnabled(min)) {
                        min++;
                    }
                } else {
                    min = Math.min(i3, count - 1);
                    while (min >= 0 && !listAdapter.isEnabled(min)) {
                        min--;
                    }
                }
                if (min < 0 || min >= count) {
                    return -1;
                }
                return min;
            }
            if (i3 >= 0 && i3 < count) {
                return i3;
            }
        }
        return -1;
    }

    final int measureHeightOfChildren(int i3, int i16, int i17, int i18, int i19) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            Rect rect = this.mListPadding;
            return rect.top + rect.bottom;
        }
        Rect rect2 = this.mListPadding;
        int i26 = rect2.top + rect2.bottom;
        int i27 = this.mDividerHeight;
        int i28 = 0;
        if (i27 <= 0 || this.mDivider == null) {
            i27 = 0;
        }
        if (i17 == -1) {
            i17 = listAdapter.getCount() - 1;
        }
        AbsListView.RecycleBin recycleBin = this.mRecycler;
        boolean recycleOnMeasure = recycleOnMeasure();
        boolean[] zArr = this.mIsScrap;
        while (i16 <= i17) {
            View obtainView = obtainView(i16, zArr);
            measureScrapChild(obtainView, i16, i3);
            if (i16 > 0) {
                i26 += i27;
            }
            if (recycleOnMeasure && recycleBin.shouldRecycleViewType(((AbsListView.LayoutParams) obtainView.getLayoutParams()).viewType)) {
                recycleBin.addScrapView(obtainView, -1);
            }
            i26 += obtainView.getMeasuredHeight();
            if (i26 >= i18) {
                if (i19 >= 0 && i16 > i19 && i28 > 0 && i26 != i18) {
                    return i28;
                }
                return i18;
            }
            if (i19 >= 0 && i16 >= i19) {
                i28 = i26;
            }
            i16++;
        }
        return i26;
    }

    protected void measureScrapChild(View view, int i3, int i16) {
        int makeMeasureSpec;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2, 0);
            view.setLayoutParams(layoutParams);
        }
        layoutParams.viewType = this.mAdapter.getItemViewType(i3);
        layoutParams.forceAdd = true;
        Rect rect = this.mListPadding;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i16, rect.left + rect.right, ((ViewGroup.LayoutParams) layoutParams).width);
        int i17 = ((ViewGroup.LayoutParams) layoutParams).height;
        if (i17 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    @Override // com.tencent.widget.AbsListView
    protected AbsListView.AdapterDataSetObserver newObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            return (AbsListView.AdapterDataSetObserver) iPatchRedirector.redirect((short) 86, (Object) this);
        }
        return new ListDataSetObserver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this);
            return;
        }
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                addHeaderView(getChildAt(i3));
            }
            removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z16, int i3, Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, this, Boolean.valueOf(z16), Integer.valueOf(i3), rect);
            return;
        }
        super.onFocusChanged(z16, i3, rect);
        ListAdapter listAdapter = this.mAdapter;
        int i17 = -1;
        if (listAdapter != null && z16 && rect != null) {
            rect.offset(getScrollX(), getScrollY());
            if (listAdapter.getCount() < getChildCount() + this.mFirstPosition) {
                this.mLayoutMode = 0;
                layoutChildren();
            }
            Rect rect2 = this.mTempRect;
            int childCount = getChildCount();
            int i18 = this.mFirstPosition;
            int i19 = Integer.MAX_VALUE;
            int i26 = -1;
            int i27 = 0;
            while (i16 < childCount) {
                if (listAdapter.isEnabled(i18 + i16)) {
                    View childAt = getChildAt(i16);
                    childAt.getDrawingRect(rect2);
                    offsetDescendantRectToMyCoords(childAt, rect2);
                    int distance = AbsListView.getDistance(rect, rect2, i3);
                    if (distance < i19) {
                        i27 = childAt.getTop();
                        i26 = i16;
                        i19 = distance;
                    }
                }
                i16++;
            }
            i16 = i27;
            i17 = i26;
        }
        if (i17 >= 0) {
            setSelectionFromTop(i17 + this.mFirstPosition, i16);
        } else {
            requestLayout();
        }
    }

    @Override // com.tencent.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            return ((Boolean) iPatchRedirector.redirect((short) 75, (Object) this, (Object) motionEvent)).booleanValue();
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        checkOverScrollHeaderIsVisable();
        return onInterceptTouchEvent;
    }

    @Override // com.tencent.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return commonKey(i3, 1, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i3, int i16, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, this, Integer.valueOf(i3), Integer.valueOf(i16), keyEvent)).booleanValue();
        }
        return commonKey(i3, i16, keyEvent);
    }

    @Override // com.tencent.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return commonKey(i3, 1, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, com.tencent.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        OverscrollViewContainer overscrollViewContainer = this.mOverscrollHeaderViewContainer;
        if (overscrollViewContainer != null) {
            Rect rect = this.mListPadding;
            int i19 = rect.top;
            int i26 = rect.left;
            overscrollViewContainer.layout(i26, i19, overscrollViewContainer.getMeasuredWidth() + i26, this.mOverscrollHeaderViewContainer.getMeasuredHeight() + i19);
            this.mTopOverflingDistance = this.mOverscrollHeaderViewContainer.getHeight();
        }
        OverscrollViewContainer overscrollViewContainer2 = this.mOverscrollFooterView;
        if (overscrollViewContainer2 != null) {
            int i27 = this.mListPadding.left;
            int measuredHeight = getMeasuredHeight() - this.mOverscrollFooterView.getMeasuredHeight();
            Rect rect2 = this.mListPadding;
            overscrollViewContainer2.layout(i27, measuredHeight - rect2.bottom, rect2.left + this.mOverscrollFooterView.getMeasuredWidth(), getMeasuredHeight() - this.mListPadding.bottom);
            this.mBottomOverflingDistance = this.mOverscrollFooterView.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, android.view.View
    @TargetApi(11)
    public void onMeasure(int i3, int i16) {
        int count;
        int i17;
        int i18;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            count = 0;
        } else {
            count = listAdapter.getCount();
        }
        this.mItemCount = count;
        if (count > 0 && (mode == 0 || mode2 == 0)) {
            View obtainView = obtainView(0, this.mIsScrap);
            measureScrapChild(obtainView, 0, i3);
            i17 = obtainView.getMeasuredWidth();
            i18 = obtainView.getMeasuredHeight();
            if (VersionUtils.isHoneycomb()) {
                i19 = View.combineMeasuredStates(0, obtainView.getMeasuredState());
            } else {
                i19 = 0;
            }
            if (recycleOnMeasure() && this.mRecycler.shouldRecycleViewType(((AbsListView.LayoutParams) obtainView.getLayoutParams()).viewType)) {
                this.mRecycler.addScrapView(obtainView, -1);
            }
        } else {
            i17 = 0;
            i18 = 0;
            i19 = 0;
        }
        if (mode == 0) {
            Rect rect = this.mListPadding;
            size = rect.left + rect.right + i17 + getVerticalScrollbarWidth();
        } else if (VersionUtils.isHoneycomb()) {
            size |= (-16777216) & i19;
        }
        if (mode2 == 0) {
            Rect rect2 = this.mListPadding;
            size2 = (getVerticalFadingEdgeLength() * 2) + rect2.top + rect2.bottom + i18;
        }
        int i26 = size2;
        if (mode2 == Integer.MIN_VALUE) {
            i26 = measureHeightOfChildren(i3, 0, -1, i26, -1);
        }
        setMeasuredDimension(size, i26);
        this.mWidthMeasureSpec = i3;
        if (this.mOverscrollHeaderViewContainer != null || this.mOverscrollFooterView != null) {
            Rect rect3 = this.mListPadding;
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, rect3.left + rect3.right, -1);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            OverscrollViewContainer overscrollViewContainer = this.mOverscrollHeaderViewContainer;
            if (overscrollViewContainer != null) {
                overscrollViewContainer.measure(childMeasureSpec, makeMeasureSpec);
            }
            OverscrollViewContainer overscrollViewContainer2 = this.mOverscrollFooterView;
            if (overscrollViewContainer2 != null) {
                overscrollViewContainer2.measure(childMeasureSpec, makeMeasureSpec);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        OverscrollViewContainer overscrollViewContainer;
        OverscrollViewContainer overscrollViewContainer2;
        OverscrollViewContainer overscrollViewContainer3;
        OverscrollViewContainer overscrollViewContainer4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (i16 < 0 && i18 == 0 && (overscrollViewContainer4 = this.mOverscrollHeaderViewContainer) != null) {
            attachWindow(overscrollViewContainer4);
        } else if (i16 == 0 && i18 < 0 && (overscrollViewContainer3 = this.mOverscrollHeaderViewContainer) != null) {
            detachedWindow(overscrollViewContainer3);
        } else if (i16 > 0 && i18 == 0 && (overscrollViewContainer2 = this.mOverscrollFooterView) != null) {
            attachWindow(overscrollViewContainer2);
        } else if (i16 == 0 && i18 > 0 && (overscrollViewContainer = this.mOverscrollFooterView) != null) {
            detachedWindow(overscrollViewContainer);
        }
        OnScrollChangeListener onScrollChangeListener = this.mOnScrollChangeListener;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChanged(this.mFirstPosition, getChildCount(), this.mItemCount);
        }
        super.onScrollChanged(i3, i16, i17, i18);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if (getChildCount() > 0) {
            View focusedChild = getFocusedChild();
            if (focusedChild != null) {
                int indexOfChild = this.mFirstPosition + indexOfChild(focusedChild);
                int top = focusedChild.getTop() - Math.max(0, focusedChild.getBottom() - (i16 - getPaddingTop()));
                if (this.mFocusSelector == null) {
                    this.mFocusSelector = new FocusSelector();
                }
                post(this.mFocusSelector.setup(indexOfChild, top));
            }
            clearDelAnim();
        }
        super.onSizeChanged(i3, i16, i17, i18);
    }

    public void onThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            iPatchRedirector.redirect((short) 99, (Object) this);
            return;
        }
        this.mRecycler.clear();
        Iterator<FixedViewInfo> it = this.mHeaderViewInfos.iterator();
        while (it.hasNext()) {
            SkinEngine.invalidateAll(it.next().view);
        }
        Iterator<FixedViewInfo> it5 = this.mFooterViewInfos.iterator();
        while (it5.hasNext()) {
            SkinEngine.invalidateAll(it5.next().view);
        }
    }

    @Override // com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            return ((Boolean) iPatchRedirector.redirect((short) 74, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.isTouchHolding = true;
        } else if (action == 1 || action == 3) {
            this.isTouchHolding = false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        checkOverScrollHeaderIsVisable();
        return onTouchEvent;
    }

    boolean pageScroll(int i3) {
        int i16;
        boolean z16;
        int lookForSelectablePosition;
        if (i3 == 33) {
            i16 = Math.max(0, (this.mSelectedPosition - getChildCount()) - 1);
        } else {
            if (i3 == 130) {
                i16 = Math.min(this.mItemCount - 1, (this.mSelectedPosition + getChildCount()) - 1);
                z16 = true;
                if (i16 >= 0 || (lookForSelectablePosition = lookForSelectablePosition(i16, z16)) < 0) {
                    return false;
                }
                this.mLayoutMode = 4;
                this.mSpecificTop = getPaddingTop() + getVerticalFadingEdgeLength();
                if (z16 && lookForSelectablePosition > this.mItemCount - getChildCount()) {
                    this.mLayoutMode = 3;
                }
                if (!z16 && lookForSelectablePosition < getChildCount()) {
                    this.mLayoutMode = 1;
                }
                setSelectionInt(lookForSelectablePosition);
                invokeOnItemScrollListener();
                if (!awakenScrollBars()) {
                    invalidate();
                }
                return true;
            }
            i16 = -1;
        }
        z16 = false;
        if (i16 >= 0) {
        }
        return false;
    }

    @ViewDebug.ExportedProperty(category = "list")
    protected boolean recycleOnMeasure() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return true;
    }

    public boolean removeFooterView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) view)).booleanValue();
        }
        boolean z16 = false;
        if (this.mFooterViewInfos.size() > 0) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && ((HeaderViewListAdapter) listAdapter).removeFooter(view)) {
                AbsListView.AdapterDataSetObserver adapterDataSetObserver = this.mDataSetObserver;
                if (adapterDataSetObserver != null) {
                    adapterDataSetObserver.onChanged();
                }
                z16 = true;
            }
            removeFixedViewInfo(view, this.mFooterViewInfos);
        }
        return z16;
    }

    public boolean removeHeaderView(View view) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) view)).booleanValue();
        }
        if (this.mHeaderViewInfos.size() <= 0 || view == null) {
            return false;
        }
        int size = this.mHeaderViewInfos.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                if (this.mHeaderViewInfos.get(i3).view == view) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && ((HeaderViewListAdapter) listAdapter).removeHeader(view)) {
            AbsListView.AdapterDataSetObserver adapterDataSetObserver = this.mDataSetObserver;
            if (adapterDataSetObserver != null) {
                adapterDataSetObserver.onChanged();
            }
            z16 = true;
        } else {
            z16 = false;
        }
        removeFixedViewInfo(view, this.mHeaderViewInfos);
        if (i3 != -1) {
            for (int i16 = 0; i16 < 3; i16++) {
                int[] iArr = this.mHeaderViewLevelIndex;
                int i17 = iArr[i16];
                if (i17 > i3) {
                    iArr[i16] = i17 - 1;
                }
            }
        }
        return z16;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z16) {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, this, view, rect, Boolean.valueOf(z16))).booleanValue();
        }
        int i18 = rect.top;
        rect.offset(view.getLeft(), view.getTop());
        rect.offset(-view.getScrollX(), -view.getScrollY());
        int height = getHeight();
        int scrollY = getScrollY();
        int i19 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (showingTopFadingEdge() && (this.mSelectedPosition > 0 || i18 > verticalFadingEdgeLength)) {
            scrollY += verticalFadingEdgeLength;
        }
        int bottom = getChildAt(getChildCount() - 1).getBottom();
        if (showingBottomFadingEdge() && (this.mSelectedPosition < this.mItemCount - 1 || rect.bottom < bottom - verticalFadingEdgeLength)) {
            i19 -= verticalFadingEdgeLength;
        }
        int i26 = rect.bottom;
        if (i26 > i19 && rect.top > scrollY) {
            if (rect.height() > height) {
                i17 = rect.top - scrollY;
            } else {
                i17 = rect.bottom - i19;
            }
            i3 = Math.min(i17 + 0, bottom - i19);
        } else if (rect.top < scrollY && i26 < i19) {
            if (rect.height() > height) {
                i16 = 0 - (i19 - rect.bottom);
            } else {
                i16 = 0 - (scrollY - rect.top);
            }
            i3 = Math.max(i16, getChildAt(0).getTop() - scrollY);
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            z17 = true;
        }
        if (z17) {
            scrollListItemsBy(-i3);
            positionSelector(-1, view);
            this.mSelectedTop = view.getTop();
            invalidate();
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.widget.AbsListView
    public void resetList() {
        clearRecycledState(this.mHeaderViewInfos);
        clearRecycledState(this.mFooterViewInfos);
        super.resetList();
        this.mLayoutMode = 0;
    }

    @Override // com.tencent.widget.AbsListView
    public void setCacheColorHint(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, i3);
            return;
        }
        if ((i3 >>> 24) == 255) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsCacheColorOpaque = z16;
        if (z16) {
            if (this.mDividerPaint == null) {
                this.mDividerPaint = new Paint();
            }
            this.mDividerPaint.setColor(i3);
        }
        super.setCacheColorHint(i3);
    }

    public void setConsiderFooterWhenDrawOverScrollFooter(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.considerFooterWhenDrawOverScrollFooter = z16;
        }
    }

    public void setContentBackground(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 90)) {
            setContentBackground(getContext().getResources().getDrawable(i3));
        } else {
            iPatchRedirector.redirect((short) 90, (Object) this, i3);
        }
    }

    public void setDelAnimationDuration(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, (Object) this, j3);
        } else if (j3 > 0) {
            this.delAnimDuration = j3;
        }
    }

    public void setDivider(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) drawable);
            return;
        }
        boolean z16 = false;
        if (drawable != null) {
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerHeight = 0;
        }
        int i3 = this.mDividerHeight;
        if (i3 < 0) {
            i3 = 0;
        }
        this.mDividerHeight = i3;
        this.mDivider = drawable;
        if (drawable == null || drawable.getOpacity() == -1) {
            z16 = true;
        }
        this.mDividerIsOpaque = z16;
        requestLayout();
        invalidate();
    }

    public void setDividerHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, i3);
            return;
        }
        this.mDividerHeight = i3;
        requestLayout();
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, z16);
        } else {
            this.mFooterDividersEnabled = z16;
            invalidate();
        }
    }

    public void setHeaderDividersEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, z16);
        } else {
            this.mHeaderDividersEnabled = z16;
            invalidate();
        }
    }

    public void setInsertAnimation(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) animation);
        } else {
            this.mInsertAnimation = animation;
        }
    }

    public void setItemsCanFocus(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, z16);
            return;
        }
        this.mItemsCanFocus = z16;
        if (!z16) {
            setDescendantFocusability(393216);
        }
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, (Object) this, (Object) onScrollChangeListener);
        } else {
            this.mOnScrollChangeListener = onScrollChangeListener;
        }
    }

    public void setOnSpringBackListener(OnSpringBackListener onSpringBackListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            iPatchRedirector.redirect((short) 102, (Object) this, (Object) onSpringBackListener);
        } else {
            this.mOnSpringBackListener = onSpringBackListener;
        }
    }

    public void setOverScrollFooter(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, (Object) view);
            return;
        }
        if (view == null) {
            OverscrollViewContainer overscrollViewContainer = this.mOverscrollFooterView;
            if (overscrollViewContainer != null) {
                overscrollViewContainer.removeAllViewsInLayout();
                this.mOverscrollFooterView.setParent(null);
                this.mOverscrollFooterView = null;
            }
        } else {
            if (this.mOverscrollFooterView == null) {
                OverscrollViewContainer overscrollViewContainer2 = new OverscrollViewContainer(getContext());
                this.mOverscrollFooterView = overscrollViewContainer2;
                overscrollViewContainer2.setParent(this);
            }
            this.mOverscrollFooterView.removeAllViewsInLayout();
            this.mOverscrollFooterView.addView(view);
        }
        this.mOverscrollHeadState = 0;
        setScrollY(0);
    }

    public void setOverScrollFooterHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mOverScrollFooterHeight = i3;
        }
    }

    public void setOverScrollHeader(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) view);
            return;
        }
        if (view == null) {
            OverscrollViewContainer overscrollViewContainer = this.mOverscrollHeaderViewContainer;
            if (overscrollViewContainer != null) {
                overscrollViewContainer.removeAllViewsInLayout();
                this.mOverscrollHeaderViewContainer.setParent(null);
                this.mOverscrollHeaderViewContainer = null;
            }
        } else {
            if (this.mOverscrollHeaderViewContainer == null) {
                OverscrollViewContainer overscrollViewContainer2 = new OverscrollViewContainer(getContext());
                this.mOverscrollHeaderViewContainer = overscrollViewContainer2;
                overscrollViewContainer2.setParent(this);
            }
            this.mOverscrollHeaderViewContainer.removeAllViewsInLayout();
            this.mOverscrollHeaderViewContainer.addView(view);
        }
        this.mOverscrollHeadState = 0;
        setScrollY(0);
    }

    public void setOverScrollHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mOverScrollHeight = i3;
        }
    }

    public void setOverScrollListener(OverScrollViewListener overScrollViewListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, (Object) overScrollViewListener);
        } else {
            this.mOverScrollViewListener = overScrollViewListener;
        }
    }

    public void setOverscrollFooter(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, (Object) drawable);
        } else {
            this.mOverScrollFooter = drawable;
            invalidate();
        }
    }

    public void setOverscrollHeader(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) drawable);
            return;
        }
        this.mOverScrollHeader = drawable;
        if (getScrollY() < 0) {
            invalidate();
        }
    }

    public void setOverscrollHeaderTop(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, (Object) this, i3);
        } else {
            this.mOverScrollHeaderTopOffset = i3;
        }
    }

    @Override // com.tencent.widget.AdapterView
    public void setSelection(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, i3);
        } else {
            setSelectionFromTop(i3, 0);
        }
    }

    public void setSelectionAfterHeaderView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        int size = this.mHeaderViewInfos.size();
        if (size > 0) {
            this.mNextSelectedPosition = 0;
        } else if (this.mAdapter != null) {
            setSelection(size);
        } else {
            this.mNextSelectedPosition = size;
            this.mLayoutMode = 2;
        }
    }

    public void setSelectionFromBottom(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mAdapter == null) {
            return;
        }
        if (!isInTouchMode()) {
            i3 = lookForSelectablePosition(i3, true);
            if (i3 >= 0) {
                setNextSelectedPositionInt(i3);
            }
        } else {
            this.mResurrectToPosition = i3;
        }
        if (i3 >= 0) {
            requestLayout();
            this.mLayoutMode = 100;
            if (this.mNeedSync) {
                this.mSyncPosition = i3;
                this.mSyncRowId = this.mAdapter.getItemId(i3);
            }
            this.mSpecificBottom = this.mListPadding.bottom + i16;
        }
    }

    public void setSelectionFromTop(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.mAdapter == null) {
            return;
        }
        if (!isInTouchMode()) {
            i3 = lookForSelectablePosition(i3, true);
            if (i3 >= 0) {
                setNextSelectedPositionInt(i3);
            }
        } else {
            this.mResurrectToPosition = i3;
        }
        if (i3 >= 0) {
            requestLayout();
            this.mLayoutMode = 4;
            if (this.mNeedSync) {
                this.mSyncPosition = i3;
                this.mSyncRowId = this.mAdapter.getItemId(i3);
            }
            initPaddingManual();
            this.mSpecificTop = this.mListPadding.top + i16;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
    
        if (r4 == (r0 + 1)) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    @Override // com.tencent.widget.AbsListView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void setSelectionInt(int i3) {
        boolean z16;
        setNextSelectedPositionInt(i3);
        int i16 = this.mSelectedPosition;
        if (i16 >= 0) {
            z16 = true;
            if (i3 != i16 - 1) {
            }
            layoutChildren();
            if (!z16) {
                awakenScrollBars();
                return;
            }
            return;
        }
        z16 = false;
        layoutChildren();
        if (!z16) {
        }
    }

    public void setStatisticCollector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
            return;
        }
        ListAdapter adapter = getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            ListAdapter wrappedAdapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            if (wrappedAdapter instanceof ExpandableListConnector) {
                ((ExpandableListConnector) wrappedAdapter).getAdapter().getClass();
                return;
            } else {
                wrappedAdapter.getClass();
                return;
            }
        }
        if (adapter instanceof ExpandableListConnector) {
            ((ExpandableListConnector) adapter).getAdapter().getClass();
        } else {
            adapter.getClass();
        }
    }

    public void showOverScrollFooter() {
        OverscrollViewContainer overscrollViewContainer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            iPatchRedirector.redirect((short) 96, (Object) this);
            return;
        }
        scrollTo(0, getOverScrollFooterHeight() + 1);
        OverScrollViewListener overScrollViewListener = this.mOverScrollViewListener;
        if (overScrollViewListener != null && (overscrollViewContainer = this.mOverscrollFooterView) != null) {
            if (!overScrollViewListener.onViewCompleteVisableAndReleased(1, overscrollViewContainer.getChildAt(0), this)) {
                springBackOverScrollView();
            } else {
                this.mOverscrollHeadState = 3;
            }
        }
    }

    public void showOverScrollHeader() {
        OverscrollViewContainer overscrollViewContainer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, (Object) this);
            return;
        }
        scrollTo(0, (-getOverScrollHeight()) - 1);
        OverScrollViewListener overScrollViewListener = this.mOverScrollViewListener;
        if (overScrollViewListener != null && (overscrollViewContainer = this.mOverscrollHeaderViewContainer) != null) {
            if (!overScrollViewListener.onViewCompleteVisableAndReleased(0, overscrollViewContainer.getChildAt(0), this)) {
                springBackOverScrollView();
            } else {
                this.mOverscrollHeadState = 3;
            }
        }
    }

    @Override // com.tencent.widget.AbsListView
    public void smoothScrollByOffset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
        } else {
            super.smoothScrollByOffset(i3);
        }
    }

    @Override // com.tencent.widget.AbsListView
    public void smoothScrollToPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else {
            super.smoothScrollToPosition(i3);
        }
    }

    public void springBackOverScrollFooterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 78)) {
            springBackOverScrollFooterView(0);
        } else {
            iPatchRedirector.redirect((short) 78, (Object) this);
        }
    }

    public void springBackOverScrollHeaderView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 76)) {
            springBackOverScrollHeaderView(0);
        } else {
            iPatchRedirector.redirect((short) 76, (Object) this);
        }
    }

    public void springBackOverScrollView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 80)) {
            springBackOverScrollView(0);
        } else {
            iPatchRedirector.redirect((short) 80, (Object) this);
        }
    }

    public ListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.listViewStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x008e A[Catch: NullPointerException -> 0x0177, TryCatch #2 {NullPointerException -> 0x0177, blocks: (B:110:0x002c, B:12:0x0035, B:15:0x003e, B:19:0x0045, B:22:0x004c, B:27:0x0059, B:31:0x0063, B:33:0x006c, B:34:0x0072, B:36:0x007c, B:38:0x0086, B:40:0x0098, B:42:0x009d, B:43:0x00a0, B:45:0x00a4, B:47:0x00a8, B:49:0x00ac, B:50:0x00b7, B:52:0x00c5, B:54:0x00cb, B:56:0x00d6, B:58:0x00e9, B:59:0x00f4, B:62:0x011b, B:63:0x0122, B:67:0x0133, B:68:0x0153, B:70:0x0157, B:72:0x015d, B:73:0x0161, B:76:0x0169, B:78:0x0173, B:82:0x0142, B:83:0x012f, B:91:0x0100, B:93:0x0106, B:86:0x010e, B:88:0x0115, B:95:0x00f0, B:96:0x011f, B:97:0x0080, B:100:0x008a, B:102:0x008e, B:103:0x0093, B:61:0x00fa), top: B:109:0x002c, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c A[Catch: NullPointerException -> 0x0177, TryCatch #2 {NullPointerException -> 0x0177, blocks: (B:110:0x002c, B:12:0x0035, B:15:0x003e, B:19:0x0045, B:22:0x004c, B:27:0x0059, B:31:0x0063, B:33:0x006c, B:34:0x0072, B:36:0x007c, B:38:0x0086, B:40:0x0098, B:42:0x009d, B:43:0x00a0, B:45:0x00a4, B:47:0x00a8, B:49:0x00ac, B:50:0x00b7, B:52:0x00c5, B:54:0x00cb, B:56:0x00d6, B:58:0x00e9, B:59:0x00f4, B:62:0x011b, B:63:0x0122, B:67:0x0133, B:68:0x0153, B:70:0x0157, B:72:0x015d, B:73:0x0161, B:76:0x0169, B:78:0x0173, B:82:0x0142, B:83:0x012f, B:91:0x0100, B:93:0x0106, B:86:0x010e, B:88:0x0115, B:95:0x00f0, B:96:0x011f, B:97:0x0080, B:100:0x008a, B:102:0x008e, B:103:0x0093, B:61:0x00fa), top: B:109:0x002c, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007c A[Catch: NullPointerException -> 0x0177, TryCatch #2 {NullPointerException -> 0x0177, blocks: (B:110:0x002c, B:12:0x0035, B:15:0x003e, B:19:0x0045, B:22:0x004c, B:27:0x0059, B:31:0x0063, B:33:0x006c, B:34:0x0072, B:36:0x007c, B:38:0x0086, B:40:0x0098, B:42:0x009d, B:43:0x00a0, B:45:0x00a4, B:47:0x00a8, B:49:0x00ac, B:50:0x00b7, B:52:0x00c5, B:54:0x00cb, B:56:0x00d6, B:58:0x00e9, B:59:0x00f4, B:62:0x011b, B:63:0x0122, B:67:0x0133, B:68:0x0153, B:70:0x0157, B:72:0x015d, B:73:0x0161, B:76:0x0169, B:78:0x0173, B:82:0x0142, B:83:0x012f, B:91:0x0100, B:93:0x0106, B:86:0x010e, B:88:0x0115, B:95:0x00f0, B:96:0x011f, B:97:0x0080, B:100:0x008a, B:102:0x008e, B:103:0x0093, B:61:0x00fa), top: B:109:0x002c, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0098 A[Catch: NullPointerException -> 0x0177, TryCatch #2 {NullPointerException -> 0x0177, blocks: (B:110:0x002c, B:12:0x0035, B:15:0x003e, B:19:0x0045, B:22:0x004c, B:27:0x0059, B:31:0x0063, B:33:0x006c, B:34:0x0072, B:36:0x007c, B:38:0x0086, B:40:0x0098, B:42:0x009d, B:43:0x00a0, B:45:0x00a4, B:47:0x00a8, B:49:0x00ac, B:50:0x00b7, B:52:0x00c5, B:54:0x00cb, B:56:0x00d6, B:58:0x00e9, B:59:0x00f4, B:62:0x011b, B:63:0x0122, B:67:0x0133, B:68:0x0153, B:70:0x0157, B:72:0x015d, B:73:0x0161, B:76:0x0169, B:78:0x0173, B:82:0x0142, B:83:0x012f, B:91:0x0100, B:93:0x0106, B:86:0x010e, B:88:0x0115, B:95:0x00f0, B:96:0x011f, B:97:0x0080, B:100:0x008a, B:102:0x008e, B:103:0x0093, B:61:0x00fa), top: B:109:0x002c, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009d A[Catch: NullPointerException -> 0x0177, TryCatch #2 {NullPointerException -> 0x0177, blocks: (B:110:0x002c, B:12:0x0035, B:15:0x003e, B:19:0x0045, B:22:0x004c, B:27:0x0059, B:31:0x0063, B:33:0x006c, B:34:0x0072, B:36:0x007c, B:38:0x0086, B:40:0x0098, B:42:0x009d, B:43:0x00a0, B:45:0x00a4, B:47:0x00a8, B:49:0x00ac, B:50:0x00b7, B:52:0x00c5, B:54:0x00cb, B:56:0x00d6, B:58:0x00e9, B:59:0x00f4, B:62:0x011b, B:63:0x0122, B:67:0x0133, B:68:0x0153, B:70:0x0157, B:72:0x015d, B:73:0x0161, B:76:0x0169, B:78:0x0173, B:82:0x0142, B:83:0x012f, B:91:0x0100, B:93:0x0106, B:86:0x010e, B:88:0x0115, B:95:0x00f0, B:96:0x011f, B:97:0x0080, B:100:0x008a, B:102:0x008e, B:103:0x0093, B:61:0x00fa), top: B:109:0x002c, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4 A[Catch: NullPointerException -> 0x0177, TryCatch #2 {NullPointerException -> 0x0177, blocks: (B:110:0x002c, B:12:0x0035, B:15:0x003e, B:19:0x0045, B:22:0x004c, B:27:0x0059, B:31:0x0063, B:33:0x006c, B:34:0x0072, B:36:0x007c, B:38:0x0086, B:40:0x0098, B:42:0x009d, B:43:0x00a0, B:45:0x00a4, B:47:0x00a8, B:49:0x00ac, B:50:0x00b7, B:52:0x00c5, B:54:0x00cb, B:56:0x00d6, B:58:0x00e9, B:59:0x00f4, B:62:0x011b, B:63:0x0122, B:67:0x0133, B:68:0x0153, B:70:0x0157, B:72:0x015d, B:73:0x0161, B:76:0x0169, B:78:0x0173, B:82:0x0142, B:83:0x012f, B:91:0x0100, B:93:0x0106, B:86:0x010e, B:88:0x0115, B:95:0x00f0, B:96:0x011f, B:97:0x0080, B:100:0x008a, B:102:0x008e, B:103:0x0093, B:61:0x00fa), top: B:109:0x002c, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ac A[Catch: NullPointerException -> 0x0177, TryCatch #2 {NullPointerException -> 0x0177, blocks: (B:110:0x002c, B:12:0x0035, B:15:0x003e, B:19:0x0045, B:22:0x004c, B:27:0x0059, B:31:0x0063, B:33:0x006c, B:34:0x0072, B:36:0x007c, B:38:0x0086, B:40:0x0098, B:42:0x009d, B:43:0x00a0, B:45:0x00a4, B:47:0x00a8, B:49:0x00ac, B:50:0x00b7, B:52:0x00c5, B:54:0x00cb, B:56:0x00d6, B:58:0x00e9, B:59:0x00f4, B:62:0x011b, B:63:0x0122, B:67:0x0133, B:68:0x0153, B:70:0x0157, B:72:0x015d, B:73:0x0161, B:76:0x0169, B:78:0x0173, B:82:0x0142, B:83:0x012f, B:91:0x0100, B:93:0x0106, B:86:0x010e, B:88:0x0115, B:95:0x00f0, B:96:0x011f, B:97:0x0080, B:100:0x008a, B:102:0x008e, B:103:0x0093, B:61:0x00fa), top: B:109:0x002c, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b7 A[Catch: NullPointerException -> 0x0177, TryCatch #2 {NullPointerException -> 0x0177, blocks: (B:110:0x002c, B:12:0x0035, B:15:0x003e, B:19:0x0045, B:22:0x004c, B:27:0x0059, B:31:0x0063, B:33:0x006c, B:34:0x0072, B:36:0x007c, B:38:0x0086, B:40:0x0098, B:42:0x009d, B:43:0x00a0, B:45:0x00a4, B:47:0x00a8, B:49:0x00ac, B:50:0x00b7, B:52:0x00c5, B:54:0x00cb, B:56:0x00d6, B:58:0x00e9, B:59:0x00f4, B:62:0x011b, B:63:0x0122, B:67:0x0133, B:68:0x0153, B:70:0x0157, B:72:0x015d, B:73:0x0161, B:76:0x0169, B:78:0x0173, B:82:0x0142, B:83:0x012f, B:91:0x0100, B:93:0x0106, B:86:0x010e, B:88:0x0115, B:95:0x00f0, B:96:0x011f, B:97:0x0080, B:100:0x008a, B:102:0x008e, B:103:0x0093, B:61:0x00fa), top: B:109:0x002c, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6 A[Catch: NullPointerException -> 0x0177, TryCatch #2 {NullPointerException -> 0x0177, blocks: (B:110:0x002c, B:12:0x0035, B:15:0x003e, B:19:0x0045, B:22:0x004c, B:27:0x0059, B:31:0x0063, B:33:0x006c, B:34:0x0072, B:36:0x007c, B:38:0x0086, B:40:0x0098, B:42:0x009d, B:43:0x00a0, B:45:0x00a4, B:47:0x00a8, B:49:0x00ac, B:50:0x00b7, B:52:0x00c5, B:54:0x00cb, B:56:0x00d6, B:58:0x00e9, B:59:0x00f4, B:62:0x011b, B:63:0x0122, B:67:0x0133, B:68:0x0153, B:70:0x0157, B:72:0x015d, B:73:0x0161, B:76:0x0169, B:78:0x0173, B:82:0x0142, B:83:0x012f, B:91:0x0100, B:93:0x0106, B:86:0x010e, B:88:0x0115, B:95:0x00f0, B:96:0x011f, B:97:0x0080, B:100:0x008a, B:102:0x008e, B:103:0x0093, B:61:0x00fa), top: B:109:0x002c, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0133 A[Catch: NullPointerException -> 0x0177, TryCatch #2 {NullPointerException -> 0x0177, blocks: (B:110:0x002c, B:12:0x0035, B:15:0x003e, B:19:0x0045, B:22:0x004c, B:27:0x0059, B:31:0x0063, B:33:0x006c, B:34:0x0072, B:36:0x007c, B:38:0x0086, B:40:0x0098, B:42:0x009d, B:43:0x00a0, B:45:0x00a4, B:47:0x00a8, B:49:0x00ac, B:50:0x00b7, B:52:0x00c5, B:54:0x00cb, B:56:0x00d6, B:58:0x00e9, B:59:0x00f4, B:62:0x011b, B:63:0x0122, B:67:0x0133, B:68:0x0153, B:70:0x0157, B:72:0x015d, B:73:0x0161, B:76:0x0169, B:78:0x0173, B:82:0x0142, B:83:0x012f, B:91:0x0100, B:93:0x0106, B:86:0x010e, B:88:0x0115, B:95:0x00f0, B:96:0x011f, B:97:0x0080, B:100:0x008a, B:102:0x008e, B:103:0x0093, B:61:0x00fa), top: B:109:0x002c, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0157 A[Catch: NullPointerException -> 0x0177, TryCatch #2 {NullPointerException -> 0x0177, blocks: (B:110:0x002c, B:12:0x0035, B:15:0x003e, B:19:0x0045, B:22:0x004c, B:27:0x0059, B:31:0x0063, B:33:0x006c, B:34:0x0072, B:36:0x007c, B:38:0x0086, B:40:0x0098, B:42:0x009d, B:43:0x00a0, B:45:0x00a4, B:47:0x00a8, B:49:0x00ac, B:50:0x00b7, B:52:0x00c5, B:54:0x00cb, B:56:0x00d6, B:58:0x00e9, B:59:0x00f4, B:62:0x011b, B:63:0x0122, B:67:0x0133, B:68:0x0153, B:70:0x0157, B:72:0x015d, B:73:0x0161, B:76:0x0169, B:78:0x0173, B:82:0x0142, B:83:0x012f, B:91:0x0100, B:93:0x0106, B:86:0x010e, B:88:0x0115, B:95:0x00f0, B:96:0x011f, B:97:0x0080, B:100:0x008a, B:102:0x008e, B:103:0x0093, B:61:0x00fa), top: B:109:0x002c, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0167 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0142 A[Catch: NullPointerException -> 0x0177, TryCatch #2 {NullPointerException -> 0x0177, blocks: (B:110:0x002c, B:12:0x0035, B:15:0x003e, B:19:0x0045, B:22:0x004c, B:27:0x0059, B:31:0x0063, B:33:0x006c, B:34:0x0072, B:36:0x007c, B:38:0x0086, B:40:0x0098, B:42:0x009d, B:43:0x00a0, B:45:0x00a4, B:47:0x00a8, B:49:0x00ac, B:50:0x00b7, B:52:0x00c5, B:54:0x00cb, B:56:0x00d6, B:58:0x00e9, B:59:0x00f4, B:62:0x011b, B:63:0x0122, B:67:0x0133, B:68:0x0153, B:70:0x0157, B:72:0x015d, B:73:0x0161, B:76:0x0169, B:78:0x0173, B:82:0x0142, B:83:0x012f, B:91:0x0100, B:93:0x0106, B:86:0x010e, B:88:0x0115, B:95:0x00f0, B:96:0x011f, B:97:0x0080, B:100:0x008a, B:102:0x008e, B:103:0x0093, B:61:0x00fa), top: B:109:0x002c, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x012f A[Catch: NullPointerException -> 0x0177, TryCatch #2 {NullPointerException -> 0x0177, blocks: (B:110:0x002c, B:12:0x0035, B:15:0x003e, B:19:0x0045, B:22:0x004c, B:27:0x0059, B:31:0x0063, B:33:0x006c, B:34:0x0072, B:36:0x007c, B:38:0x0086, B:40:0x0098, B:42:0x009d, B:43:0x00a0, B:45:0x00a4, B:47:0x00a8, B:49:0x00ac, B:50:0x00b7, B:52:0x00c5, B:54:0x00cb, B:56:0x00d6, B:58:0x00e9, B:59:0x00f4, B:62:0x011b, B:63:0x0122, B:67:0x0133, B:68:0x0153, B:70:0x0157, B:72:0x015d, B:73:0x0161, B:76:0x0169, B:78:0x0173, B:82:0x0142, B:83:0x012f, B:91:0x0100, B:93:0x0106, B:86:0x010e, B:88:0x0115, B:95:0x00f0, B:96:0x011f, B:97:0x0080, B:100:0x008a, B:102:0x008e, B:103:0x0093, B:61:0x00fa), top: B:109:0x002c, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011f A[Catch: NullPointerException -> 0x0177, TryCatch #2 {NullPointerException -> 0x0177, blocks: (B:110:0x002c, B:12:0x0035, B:15:0x003e, B:19:0x0045, B:22:0x004c, B:27:0x0059, B:31:0x0063, B:33:0x006c, B:34:0x0072, B:36:0x007c, B:38:0x0086, B:40:0x0098, B:42:0x009d, B:43:0x00a0, B:45:0x00a4, B:47:0x00a8, B:49:0x00ac, B:50:0x00b7, B:52:0x00c5, B:54:0x00cb, B:56:0x00d6, B:58:0x00e9, B:59:0x00f4, B:62:0x011b, B:63:0x0122, B:67:0x0133, B:68:0x0153, B:70:0x0157, B:72:0x015d, B:73:0x0161, B:76:0x0169, B:78:0x0173, B:82:0x0142, B:83:0x012f, B:91:0x0100, B:93:0x0106, B:86:0x010e, B:88:0x0115, B:95:0x00f0, B:96:0x011f, B:97:0x0080, B:100:0x008a, B:102:0x008e, B:103:0x0093, B:61:0x00fa), top: B:109:0x002c, inners: #3 }] */
    @TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setupChild(View view, int i3, int i16, boolean z16, int i17, boolean z17, boolean z18, int i18) {
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        AbsListView.LayoutParams layoutParams;
        int itemViewType;
        boolean z29;
        int defaultChildHeightSpec;
        SparseBooleanArray sparseBooleanArray;
        AdapterView.traceBegin("ListView.setupChild");
        if (view == 0) {
            if (QLog.isColorLevel()) {
                QLog.e(AdapterView.TAG, 2, "ListView setupChild view is null");
            }
            setStatisticCollector();
            AdapterView.traceEnd();
            return;
        }
        if (z17) {
            try {
            } catch (NullPointerException unused) {
                setStatisticCollector();
            }
            if (shouldShowSelector()) {
                z19 = true;
                z26 = z19 == view.isSelected();
                int i19 = this.mTouchMode;
                boolean z36 = i19 <= 0 && i19 < 3 && this.mMotionPosition == i3;
                z27 = z36 == view.isPressed();
                if (z18 && !z26 && !view.isLayoutRequested()) {
                    z28 = false;
                    layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new AbsListView.LayoutParams(-1, -2, 0);
                    }
                    itemViewType = this.mAdapter.getItemViewType(i3);
                    layoutParams.viewType = itemViewType;
                    if ((!z18 && !layoutParams.forceAdd) || (layoutParams.recycledHeaderFooter && itemViewType == -2)) {
                        attachViewToParent(view, i18, layoutParams);
                    } else {
                        layoutParams.forceAdd = false;
                        if (itemViewType != -2) {
                            z29 = true;
                            layoutParams.recycledHeaderFooter = true;
                        } else {
                            z29 = true;
                        }
                        addViewInLayout(view, i18, layoutParams, z29);
                    }
                    if (z26) {
                        view.setSelected(z19);
                    }
                    if (z27) {
                        view.setPressed(z36);
                    }
                    if (this.mChoiceMode != 0 && (sparseBooleanArray = this.mCheckStates) != null) {
                        if (!(view instanceof Checkable)) {
                            ((Checkable) view).setChecked(sparseBooleanArray.get(i3));
                        } else if (getContext().getApplicationInfo().targetSdkVersion >= 11 && VersionUtils.isHoneycomb()) {
                            view.setActivated(this.mCheckStates.get(i3));
                        }
                    }
                    if (!z28) {
                        int i26 = this.mWidthMeasureSpec;
                        Rect rect = this.mListPadding;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i26, rect.left + rect.right, ((ViewGroup.LayoutParams) layoutParams).width);
                        int i27 = ((ViewGroup.LayoutParams) layoutParams).height;
                        if (i27 > 0) {
                            defaultChildHeightSpec = View.MeasureSpec.makeMeasureSpec(i27, 1073741824);
                        } else {
                            defaultChildHeightSpec = getDefaultChildHeightSpec(view, i27);
                        }
                        AdapterView.traceBegin("ListView.childMeasure");
                        try {
                            view.measure(childMeasureSpec, defaultChildHeightSpec);
                        } catch (StringIndexOutOfBoundsException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e(AdapterView.TAG, 2, e16, new Object[0]);
                            }
                        } catch (Exception e17) {
                            if (QLog.isColorLevel()) {
                                QLog.e(AdapterView.TAG, 2, e17, new Object[0]);
                            }
                        }
                        AdapterView.traceEnd();
                    } else {
                        cleanupLayoutState(view);
                    }
                    int measuredWidth = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    int i28 = !z16 ? i16 : i16 - measuredHeight;
                    if (!z28) {
                        AdapterView.traceBegin("ListView.childLayout");
                        view.layout(i17, i28, measuredWidth + i17, measuredHeight + i28);
                        AdapterView.traceEnd();
                    } else {
                        view.offsetLeftAndRight(i17 - view.getLeft());
                        view.offsetTopAndBottom(i28 - view.getTop());
                    }
                    if (this.mCachingStarted && !view.isDrawingCacheEnabled()) {
                        view.setDrawingCacheEnabled(true);
                    }
                    if (VersionUtils.isHoneycomb() && z18 && ((AbsListView.LayoutParams) view.getLayoutParams()).scrappedFromPosition != i3) {
                        view.jumpDrawablesToCurrentState();
                    }
                    AdapterView.traceEnd();
                }
                z28 = true;
                layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
                if (layoutParams == null) {
                }
                itemViewType = this.mAdapter.getItemViewType(i3);
                layoutParams.viewType = itemViewType;
                if (!z18) {
                }
                layoutParams.forceAdd = false;
                if (itemViewType != -2) {
                }
                addViewInLayout(view, i18, layoutParams, z29);
                if (z26) {
                }
                if (z27) {
                }
                if (this.mChoiceMode != 0) {
                    if (!(view instanceof Checkable)) {
                    }
                }
                if (!z28) {
                }
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                if (!z16) {
                }
                if (!z28) {
                }
                if (this.mCachingStarted) {
                    view.setDrawingCacheEnabled(true);
                }
                if (VersionUtils.isHoneycomb()) {
                    view.jumpDrawablesToCurrentState();
                }
                AdapterView.traceEnd();
            }
        }
        z19 = false;
        if (z19 == view.isSelected()) {
        }
        int i192 = this.mTouchMode;
        if (i192 <= 0) {
        }
        if (z36 == view.isPressed()) {
        }
        if (z18) {
            z28 = false;
            layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
            }
            itemViewType = this.mAdapter.getItemViewType(i3);
            layoutParams.viewType = itemViewType;
            if (!z18) {
            }
            layoutParams.forceAdd = false;
            if (itemViewType != -2) {
            }
            addViewInLayout(view, i18, layoutParams, z29);
            if (z26) {
            }
            if (z27) {
            }
            if (this.mChoiceMode != 0) {
            }
            if (!z28) {
            }
            int measuredWidth22 = view.getMeasuredWidth();
            int measuredHeight22 = view.getMeasuredHeight();
            if (!z16) {
            }
            if (!z28) {
            }
            if (this.mCachingStarted) {
            }
            if (VersionUtils.isHoneycomb()) {
            }
            AdapterView.traceEnd();
        }
        z28 = true;
        layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
        }
        itemViewType = this.mAdapter.getItemViewType(i3);
        layoutParams.viewType = itemViewType;
        if (!z18) {
        }
        layoutParams.forceAdd = false;
        if (itemViewType != -2) {
        }
        addViewInLayout(view, i18, layoutParams, z29);
        if (z26) {
        }
        if (z27) {
        }
        if (this.mChoiceMode != 0) {
        }
        if (!z28) {
        }
        int measuredWidth222 = view.getMeasuredWidth();
        int measuredHeight222 = view.getMeasuredHeight();
        if (!z16) {
        }
        if (!z28) {
        }
        if (this.mCachingStarted) {
        }
        if (VersionUtils.isHoneycomb()) {
        }
        AdapterView.traceEnd();
    }

    public void addHeaderView(View view, int i3, Object obj, boolean z16) {
        AbsListView.AdapterDataSetObserver adapterDataSetObserver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, view, Integer.valueOf(i3), obj, Boolean.valueOf(z16));
            return;
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && !(listAdapter instanceof HeaderViewListAdapter)) {
            throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
        }
        if (view == null) {
            return;
        }
        if (view.getParent() != null && view.getParent() != this && Log.isLoggable(AdapterView.TAG, 5)) {
            Log.w(AdapterView.TAG, "The specified child already has a parent. You must call removeView() on the child's parent first.");
        }
        FixedViewInfo fixedViewInfo = new FixedViewInfo();
        fixedViewInfo.view = view;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z16;
        if (this.mHeaderViewLevelIndex[i3] > this.mHeaderViewInfos.size()) {
            for (int i16 = i3; i16 < 3; i16++) {
                this.mHeaderViewLevelIndex[i16] = this.mHeaderViewInfos.size();
            }
        }
        this.mHeaderViewInfos.add(this.mHeaderViewLevelIndex[i3], fixedViewInfo);
        while (i3 < 3) {
            int[] iArr = this.mHeaderViewLevelIndex;
            iArr[i3] = iArr[i3] + 1;
            i3++;
        }
        if (this.mAdapter == null || (adapterDataSetObserver = this.mDataSetObserver) == null) {
            return;
        }
        adapterDataSetObserver.onChanged();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.widget.AdapterView
    public ListAdapter getAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) ? this.mAdapter : (ListAdapter) iPatchRedirector.redirect((short) 22, (Object) this);
    }

    public int getHeaderViewsCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, i3)).intValue();
        }
        if (i3 == 0) {
            return this.mHeaderViewLevelIndex[0];
        }
        int[] iArr = this.mHeaderViewLevelIndex;
        return iArr[i3] - iArr[i3 - 1];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.widget.AbsListView, com.tencent.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        int lookForSelectablePosition;
        AbsListView.AdapterDataSetObserver adapterDataSetObserver;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) listAdapter);
            return;
        }
        ListAdapter listAdapter2 = this.mAdapter;
        if (listAdapter2 != null && (adapterDataSetObserver = this.mDataSetObserver) != null) {
            listAdapter2.unregisterDataSetObserver(adapterDataSetObserver);
        }
        resetList();
        this.mRecycler.clear();
        if (this.mHeaderViewInfos.size() <= 0 && this.mFooterViewInfos.size() <= 0) {
            this.mAdapter = listAdapter;
        } else {
            this.mAdapter = new HeaderViewListAdapter(this.mHeaderViewInfos, this.mFooterViewInfos, listAdapter);
        }
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        ListAdapter listAdapter3 = this.mAdapter;
        if (listAdapter3 != null) {
            this.mAreAllItemsSelectable = listAdapter3.areAllItemsEnabled();
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            checkFocus();
            ListDataSetObserver listDataSetObserver = new ListDataSetObserver();
            this.mDataSetObserver = listDataSetObserver;
            this.mAdapter.registerDataSetObserver(listDataSetObserver);
            this.mRecycler.setViewTypeCount(this.mAdapter.getViewTypeCount());
            if (this.mStackFromBottom) {
                lookForSelectablePosition = lookForSelectablePosition(this.mItemCount - 1, false);
            } else {
                lookForSelectablePosition = lookForSelectablePosition(0, true);
            }
            setSelectedPositionInt(lookForSelectablePosition);
            setNextSelectedPositionInt(lookForSelectablePosition);
            if (this.mItemCount == 0) {
                checkSelectionChanged();
            }
        } else {
            this.mAreAllItemsSelectable = true;
            checkFocus();
            checkSelectionChanged();
        }
        requestLayout();
    }

    public void setContentBackground(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 91)) {
            setContentBackground(drawable, true);
        } else {
            iPatchRedirector.redirect((short) 91, (Object) this, (Object) drawable);
        }
    }

    public void springBackOverScrollFooterView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 79)) {
            springBackOverScrollView(i3);
        } else {
            iPatchRedirector.redirect((short) 79, (Object) this, i3);
        }
    }

    public void springBackOverScrollHeaderView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, (Object) this, i3);
            return;
        }
        springBackOverScrollView(i3);
        OnSpringBackListener onSpringBackListener = this.mOnSpringBackListener;
        if (onSpringBackListener != null) {
            onSpringBackListener.onSpringBack();
        }
    }

    public void springBackOverScrollView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, (Object) this, i3);
            return;
        }
        if (getScrollY() != 0 && !this.isTouchHolding) {
            doSpringBack(i3);
        }
        this.mOverscrollHeadState = 0;
    }

    public ListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        this.mHeaderViewLevelIndex = new int[]{0, 0, 0};
        this.mOverScrollHeaderTopOffset = 0;
        this.mAreAllItemsSelectable = true;
        this.mItemsCanFocus = false;
        this.mTempRect = new Rect();
        this.mArrowScrollFocusResult = new ArrowScrollFocusResult();
        this.mOverscrollHeadState = 0;
        this.mAddingRows = null;
        this.considerFooterWhenDrawOverScrollFooter = false;
        this.mOverScrollHeight = 0;
        this.mOverScrollFooterHeight = 0;
        this.isTouchHolding = false;
        this.mAnimation = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LISTVIEW_STYLEABLE, i3, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(0);
        if (textArray != null) {
            setAdapter((ListAdapter) new ArrayAdapter(context, android.R.layout.simple_list_item_1, textArray));
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        if (drawable != null) {
            setDivider(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(2);
        if (drawable2 != null) {
            setOverscrollHeader(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(3);
        if (drawable3 != null) {
            setOverscrollFooter(drawable3);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        if (dimensionPixelSize != 0) {
            setDividerHeight(dimensionPixelSize);
        }
        this.mHeaderDividersEnabled = obtainStyledAttributes.getBoolean(5, true);
        this.mFooterDividersEnabled = obtainStyledAttributes.getBoolean(6, true);
        obtainStyledAttributes.recycle();
    }

    public void setContentBackground(Drawable drawable, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 92)) {
            setContentBackground(drawable, z16, false);
        } else {
            iPatchRedirector.redirect((short) 92, this, drawable, Boolean.valueOf(z16));
        }
    }

    public void setContentBackground(Drawable drawable, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            iPatchRedirector.redirect((short) 93, this, drawable, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (drawable == null) {
            this.mContentBackgroundDrawable = null;
            this.mOverScrollHeaderShadow = null;
        } else {
            this.mContentBackgroundDrawable = drawable;
            if (z16) {
                this.mOverScrollHeaderShadow = getResources().getDrawable(R.drawable.csv);
            }
        }
        this.mUseEfficientMode = z17;
    }

    public void addFooterView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            addFooterView(view, null, true);
        } else {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view);
        }
    }

    public void addHeaderView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            addHeaderView(view, 1, null, true);
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        }
    }

    public void addHeaderView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            addHeaderView(view, i3, null, true);
        } else {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view, i3);
        }
    }
}
