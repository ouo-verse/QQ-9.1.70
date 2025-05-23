package com.tencent.mtt.hippy.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FocusFinder {
    private static final ThreadLocal<FocusFinder> tlFocusFinder = new ThreadLocal<FocusFinder>() { // from class: com.tencent.mtt.hippy.utils.FocusFinder.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public FocusFinder initialValue() {
            return new FocusFinder();
        }
    };
    final Rect mFocusedRect = new Rect();
    final Rect mOtherRect = new Rect();
    final Rect mBestCandidateRect = new Rect();
    private final FocusSorter mFocusSorter = new FocusSorter();
    private final ArrayList<View> mTempList = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class FocusSorter {
        private int mLastPoolRect;
        private int mRtlMult;
        private ArrayList<Rect> mRectPool = new ArrayList<>();
        private HashMap<View, Rect> mRectByView = null;
        private Comparator<View> mTopsComparator = new Comparator<View>() { // from class: com.tencent.mtt.hippy.utils.FocusFinder.FocusSorter.1
            @Override // java.util.Comparator
            public int compare(View view, View view2) {
                if (view == view2) {
                    return 0;
                }
                Rect rect = (Rect) FocusSorter.this.mRectByView.get(view);
                Rect rect2 = (Rect) FocusSorter.this.mRectByView.get(view2);
                int i3 = rect.top - rect2.top;
                return i3 == 0 ? rect.bottom - rect2.bottom : i3;
            }
        };
        private Comparator<View> mSidesComparator = new Comparator<View>() { // from class: com.tencent.mtt.hippy.utils.FocusFinder.FocusSorter.2
            @Override // java.util.Comparator
            public int compare(View view, View view2) {
                if (view == view2) {
                    return 0;
                }
                Rect rect = (Rect) FocusSorter.this.mRectByView.get(view);
                Rect rect2 = (Rect) FocusSorter.this.mRectByView.get(view2);
                int i3 = rect.left - rect2.left;
                return i3 == 0 ? rect.right - rect2.right : FocusSorter.this.mRtlMult * i3;
            }
        };

        FocusSorter() {
        }

        public void sort(View[] viewArr, int i3, int i16, ViewGroup viewGroup, boolean z16) {
            int i17;
            int i18 = i16 - i3;
            if (i18 < 2) {
                return;
            }
            if (this.mRectByView == null) {
                this.mRectByView = new HashMap<>();
            }
            if (z16) {
                i17 = -1;
            } else {
                i17 = 1;
            }
            this.mRtlMult = i17;
            for (int size = this.mRectPool.size(); size < i18; size++) {
                this.mRectPool.add(new Rect());
            }
            for (int i19 = i3; i19 < i16; i19++) {
                ArrayList<Rect> arrayList = this.mRectPool;
                int i26 = this.mLastPoolRect;
                this.mLastPoolRect = i26 + 1;
                Rect rect = arrayList.get(i26);
                viewArr[i19].getDrawingRect(rect);
                viewGroup.offsetDescendantRectToMyCoords(viewArr[i19], rect);
                this.mRectByView.put(viewArr[i19], rect);
            }
            Arrays.sort(viewArr, i3, i18, this.mTopsComparator);
            int i27 = this.mRectByView.get(viewArr[i3]).bottom;
            int i28 = i3 + 1;
            while (i28 < i16) {
                Rect rect2 = this.mRectByView.get(viewArr[i28]);
                if (rect2.top >= i27) {
                    if (i28 - i3 > 1) {
                        Arrays.sort(viewArr, i3, i28, this.mSidesComparator);
                    }
                    i27 = rect2.bottom;
                    i3 = i28;
                } else {
                    i27 = Math.max(i27, rect2.bottom);
                }
                i28++;
            }
            if (i28 - i3 > 1) {
                Arrays.sort(viewArr, i3, i28, this.mSidesComparator);
            }
            this.mLastPoolRect = 0;
            this.mRectByView.clear();
        }
    }

    private View findNextFocusInRelativeDirection(ArrayList<View> arrayList, ViewGroup viewGroup, View view, Rect rect, int i3) {
        int size = arrayList.size();
        if (i3 != 1) {
            if (i3 != 2) {
                return arrayList.get(size - 1);
            }
            return getNextFocusable(view, arrayList, size);
        }
        return getPreviousFocusable(view, arrayList, size);
    }

    private View findNextUserSpecifiedFocus(ViewGroup viewGroup, View view, int i3) {
        View findUserSetNextFocus = findUserSetNextFocus(viewGroup, view, i3);
        int i16 = 0;
        while (findUserSetNextFocus != null) {
            if (isVisible(findUserSetNextFocus)) {
                return findUserSetNextFocus;
            }
            if (findUserSetNextFocus == view) {
                return view;
            }
            if (i16 < 10) {
                findUserSetNextFocus = findUserSetNextFocus(viewGroup, findUserSetNextFocus, i3);
                i16++;
            } else {
                return null;
            }
        }
        return null;
    }

    private View findUserSetNextFocus(ViewGroup viewGroup, View view, int i3) {
        int i16;
        if (i3 != 2) {
            if (i3 != 17) {
                if (i3 != 33) {
                    if (i3 != 66) {
                        if (i3 != 130) {
                            i16 = -1;
                        }
                        i16 = view.getNextFocusDownId();
                    } else {
                        i16 = view.getNextFocusRightId();
                    }
                } else {
                    i16 = view.getNextFocusUpId();
                }
            } else {
                i16 = view.getNextFocusLeftId();
            }
        } else {
            int nextFocusForwardId = view.getNextFocusForwardId();
            if (nextFocusForwardId != -1 || (nextFocusForwardId = view.getNextFocusRightId()) != -1) {
                i16 = nextFocusForwardId;
            }
            i16 = view.getNextFocusDownId();
        }
        if (i16 != -1) {
            return viewGroup.findViewById(i16);
        }
        return null;
    }

    private static float getFocusScale(View view, int i3) {
        return 0.5f;
    }

    public static FocusFinder getInstance() {
        return tlFocusFinder.get();
    }

    private static View getNextFocusable(View view, ArrayList<View> arrayList, int i3) {
        int i16;
        int lastIndexOf;
        if (view == null || (lastIndexOf = arrayList.lastIndexOf(view)) < 0 || (i16 = lastIndexOf + 1) >= i3) {
            if (!arrayList.isEmpty()) {
                i16 = 0;
            } else {
                return null;
            }
        }
        return arrayList.get(i16);
    }

    private static View getNextKeyboardNavigationCluster(View view, View view2, List<View> list, int i3) {
        int i16;
        View view3;
        if (view2 == null) {
            view3 = list.get(0);
        } else {
            int lastIndexOf = list.lastIndexOf(view2);
            if (lastIndexOf >= 0 && (i16 = lastIndexOf + 1) < i3) {
                view3 = list.get(i16);
            } else {
                return view;
            }
        }
        return view3;
    }

    private static View getPreviousFocusable(View view, ArrayList<View> arrayList, int i3) {
        View view2;
        int indexOf;
        if (view != null && (indexOf = arrayList.indexOf(view)) > 0) {
            view2 = arrayList.get(indexOf - 1);
        } else if (!arrayList.isEmpty()) {
            view2 = arrayList.get(i3 - 1);
        } else {
            return null;
        }
        return view2;
    }

    private static View getPreviousKeyboardNavigationCluster(View view, View view2, List<View> list, int i3) {
        View view3;
        if (view2 == null) {
            view3 = list.get(i3 - 1);
        } else {
            int indexOf = list.indexOf(view2);
            if (indexOf > 0) {
                view3 = list.get(indexOf - 1);
            } else {
                return view;
            }
        }
        return view3;
    }

    private View getView(ViewGroup viewGroup, View view, Rect rect, int i3, ArrayList<View> arrayList) {
        if (isRelativeDirection(i3)) {
            return findNextFocusInRelativeDirection(arrayList, viewGroup, view, rect, i3);
        }
        if (isAbsoluteDirection(i3)) {
            return findNextFocusInAbsoluteDirection(arrayList, viewGroup, view, rect, i3);
        }
        throw new IllegalArgumentException("Unknown direction: " + i3);
    }

    private boolean isAbsoluteDirection(int i3) {
        if (i3 != 33 && i3 != 130 && i3 != 17 && i3 != 66) {
            return false;
        }
        return true;
    }

    private boolean isCandidateDown(Rect rect, Rect rect2) {
        int i3 = rect.top;
        int i16 = rect2.top;
        if ((i3 < i16 || rect.bottom <= i16) && rect.bottom < rect2.bottom) {
            return true;
        }
        return false;
    }

    private boolean isCandidateLeft(Rect rect, Rect rect2) {
        int i3 = rect.right;
        int i16 = rect2.right;
        if ((i3 > i16 || rect.left >= i16) && rect.left > rect2.left) {
            return true;
        }
        return false;
    }

    private boolean isCandidateRight(Rect rect, Rect rect2) {
        int i3 = rect.left;
        int i16 = rect2.left;
        if ((i3 < i16 || rect.right <= i16) && rect.right < rect2.right) {
            return true;
        }
        return false;
    }

    private boolean isCandidateUp(Rect rect, Rect rect2) {
        int i3 = rect.bottom;
        int i16 = rect2.bottom;
        if ((i3 > i16 || rect.top >= i16) && rect.top > rect2.top) {
            return true;
        }
        return false;
    }

    private boolean isRelativeDirection(int i3) {
        if (i3 == 2 || i3 == 1) {
            return true;
        }
        return false;
    }

    private boolean isTouchCandidate(int i3, int i16, Rect rect, int i17) {
        if (i17 == 17) {
            return isTouchCandidateLeft(i3, i16, rect);
        }
        if (i17 == 66) {
            return isTouchCandidateRight(i3, i16, rect);
        }
        if (i17 == 33) {
            return isTouchCandidateUp(i3, i16, rect);
        }
        if (i17 == 130) {
            return isTouchCandidateDown(i3, i16, rect);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private boolean isTouchCandidateDown(int i3, int i16, Rect rect) {
        if (rect.top >= i16 && rect.left <= i3 && i3 <= rect.right) {
            return true;
        }
        return false;
    }

    private boolean isTouchCandidateLeft(int i3, int i16, Rect rect) {
        if (rect.left <= i3 && rect.top <= i16 && i16 <= rect.bottom) {
            return true;
        }
        return false;
    }

    private boolean isTouchCandidateRight(int i3, int i16, Rect rect) {
        if (rect.left >= i3 && rect.top <= i16 && i16 <= rect.bottom) {
            return true;
        }
        return false;
    }

    private boolean isTouchCandidateUp(int i3, int i16, Rect rect) {
        if (rect.top <= i16 && rect.left <= i3 && i3 <= rect.right) {
            return true;
        }
        return false;
    }

    private static final boolean isValidId(int i3) {
        if (i3 != 0 && i3 != -1) {
            return true;
        }
        return false;
    }

    private boolean isVisible(View view) {
        View rootView = view.getRootView();
        while (view != null && view != rootView) {
            if (view.getVisibility() != 0) {
                return false;
            }
            Object parent = view.getParent();
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            view = (View) parent;
        }
        return true;
    }

    static int majorAxisDistance(int i3, Rect rect, Rect rect2) {
        return Math.max(0, majorAxisDistanceRaw(i3, rect, rect2));
    }

    static int majorAxisDistanceRaw(int i3, Rect rect, Rect rect2) {
        int i16;
        int i17;
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        i16 = rect2.top;
                        i17 = rect.bottom;
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    i16 = rect2.left;
                    i17 = rect.right;
                }
            } else {
                i16 = rect.top;
                i17 = rect2.bottom;
            }
        } else {
            i16 = rect.left;
            i17 = rect2.right;
        }
        return i16 - i17;
    }

    static int majorAxisDistanceToFarEdge(int i3, Rect rect, Rect rect2) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(i3, rect, rect2));
    }

    static int majorAxisDistanceToFarEdgeRaw(int i3, Rect rect, Rect rect2) {
        int i16;
        int i17;
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        i16 = rect2.bottom;
                        i17 = rect.bottom;
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    i16 = rect2.right;
                    i17 = rect.right;
                }
            } else {
                i16 = rect.top;
                i17 = rect2.top;
            }
        } else {
            i16 = rect.left;
            i17 = rect2.left;
        }
        return i16 - i17;
    }

    private void makeUpRectOfRoot(ViewGroup viewGroup, Rect rect, int i3) {
        if (i3 != 66 && i3 != 130) {
            if (i3 == 17 || i3 == 33) {
                setFocusBottomRight(viewGroup, rect);
                return;
            }
            return;
        }
        setFocusTopLeft(viewGroup, rect);
    }

    static int minorAxisDistance(float f16, int i3, Rect rect, Rect rect2) {
        int height;
        int i16;
        int height2;
        if (i3 != 17 && i3 != 66) {
            if (i3 != 33 && i3 != 130) {
                throw new IllegalArgumentException("direction must be one of  {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            height = rect.left + ((int) (rect.width() * f16));
            i16 = rect2.left;
            height2 = rect2.width();
        } else {
            height = rect.top + ((int) (rect.height() * f16));
            i16 = rect2.top;
            height2 = rect2.height();
        }
        return Math.abs(height - (i16 + (height2 / 2)));
    }

    private void setFocusBottomRight(ViewGroup viewGroup, Rect rect) {
        int scrollY = viewGroup.getScrollY() + viewGroup.getHeight();
        int scrollX = viewGroup.getScrollX() + viewGroup.getWidth();
        rect.set(scrollX, scrollY, scrollX, scrollY);
    }

    private void setFocusTopLeft(ViewGroup viewGroup, Rect rect) {
        int scrollY = viewGroup.getScrollY();
        int scrollX = viewGroup.getScrollX();
        rect.set(scrollX, scrollY, scrollX, scrollY);
    }

    public static void sort(View[] viewArr, int i3, int i16, ViewGroup viewGroup, boolean z16) {
        getInstance().mFocusSorter.sort(viewArr, i3, i16, viewGroup, z16);
    }

    boolean beamBeats(int i3, Rect rect, Rect rect2, Rect rect3) {
        boolean beamsOverlap = beamsOverlap(i3, rect, rect2);
        if (beamsOverlap(i3, rect, rect3) || !beamsOverlap) {
            return false;
        }
        if (isToDirectionOf(i3, rect, rect3) && i3 != 17 && i3 != 66 && majorAxisDistance(i3, rect, rect2) >= majorAxisDistanceToFarEdge(i3, rect, rect3)) {
            return false;
        }
        return true;
    }

    boolean beamsOverlap(int i3, Rect rect, Rect rect2) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right >= rect.left && rect2.left <= rect.right) {
                return true;
            }
            return false;
        }
        if (rect2.bottom >= rect.top && rect2.top <= rect.bottom) {
            return true;
        }
        return false;
    }

    public final View findNextFocus(ViewGroup viewGroup, View view, int i3) {
        return findNextFocus(viewGroup, view, null, i3);
    }

    public View findNextFocusFromRect(ViewGroup viewGroup, Rect rect, int i3) {
        this.mFocusedRect.set(rect);
        return findNextFocus(viewGroup, null, this.mFocusedRect, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    View findNextFocusInAbsoluteDirection(ArrayList<View> arrayList, ViewGroup viewGroup, View view, Rect rect, int i3) {
        Rect rect2;
        int i16;
        Rect rect3;
        int i17;
        int size;
        int i18;
        this.mBestCandidateRect.set(rect);
        if (i3 == 17) {
            rect3 = this.mBestCandidateRect;
            i17 = rect.width() + 1;
        } else if (i3 == 66) {
            rect3 = this.mBestCandidateRect;
            i17 = -(rect.width() + 1);
        } else {
            if (i3 == 33) {
                rect2 = this.mBestCandidateRect;
                i16 = rect.height() + 1;
            } else {
                if (i3 == 130) {
                    rect2 = this.mBestCandidateRect;
                    i16 = -(rect.height() + 1);
                }
                float focusScale = getFocusScale(view, i3);
                size = arrayList.size();
                View view2 = null;
                for (i18 = 0; i18 < size; i18++) {
                    View view3 = arrayList.get(i18);
                    if (view3 != view && view3 != viewGroup) {
                        view3.getFocusedRect(this.mOtherRect);
                        viewGroup.offsetDescendantRectToMyCoords(view3, this.mOtherRect);
                        if (isBetterCandidate(focusScale, i3, rect, this.mOtherRect, this.mBestCandidateRect)) {
                            this.mBestCandidateRect.set(this.mOtherRect);
                            view2 = view3;
                        }
                    }
                }
                return view2;
            }
            rect2.offset(0, i16);
            float focusScale2 = getFocusScale(view, i3);
            size = arrayList.size();
            View view22 = null;
            while (i18 < size) {
            }
            return view22;
        }
        rect3.offset(i17, 0);
        float focusScale22 = getFocusScale(view, i3);
        size = arrayList.size();
        View view222 = null;
        while (i18 < size) {
        }
        return view222;
    }

    int getWeightedDistanceFor(int i3, int i16) {
        return (i3 * 26 * i3) + (i16 * i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBetterCandidate(float f16, int i3, Rect rect, Rect rect2, Rect rect3) {
        if (!isCandidate(rect, rect2, i3)) {
            return false;
        }
        if (!isCandidate(rect, rect3, i3) || beamBeats(i3, rect, rect2, rect3)) {
            return true;
        }
        if (beamBeats(i3, rect, rect3, rect2)) {
            return false;
        }
        if (middle(i3, rect, rect3, rect2)) {
            return true;
        }
        if (middle(i3, rect, rect2, rect3) || getWeightedDistanceFor(majorAxisDistance(i3, rect, rect2), minorAxisDistance(f16, i3, rect, rect2)) >= getWeightedDistanceFor(majorAxisDistance(i3, rect, rect3), minorAxisDistance(f16, i3, rect, rect3))) {
            return false;
        }
        return true;
    }

    boolean isCandidate(Rect rect, Rect rect2, int i3) {
        if (i3 == 17) {
            return isCandidateLeft(rect, rect2);
        }
        if (i3 == 66) {
            return isCandidateRight(rect, rect2);
        }
        if (i3 == 33) {
            return isCandidateUp(rect, rect2);
        }
        if (i3 == 130) {
            return isCandidateDown(rect, rect2);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    boolean isToDirectionOf(int i3, Rect rect, Rect rect2) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        if (rect.bottom <= rect2.top) {
                            return true;
                        }
                        return false;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                if (rect.right <= rect2.left) {
                    return true;
                }
                return false;
            }
            if (rect.top >= rect2.bottom) {
                return true;
            }
            return false;
        }
        if (rect.left >= rect2.right) {
            return true;
        }
        return false;
    }

    boolean middle(int i3, Rect rect, Rect rect2, Rect rect3) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        if (rect3.top > rect.centerY() && rect2.centerY() > rect3.bottom) {
                            return true;
                        }
                        return false;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                if (rect3.left > rect.centerX() && rect2.centerX() > rect3.right) {
                    return true;
                }
                return false;
            }
            if (rect3.bottom < rect.centerY() && rect2.centerY() < rect3.top) {
                return true;
            }
            return false;
        }
        if (rect3.right < rect.centerX() && rect2.centerX() < rect3.left) {
            return true;
        }
        return false;
    }

    private View findNextFocus(ViewGroup viewGroup, View view, Rect rect, int i3) {
        View findNextUserSpecifiedFocus = view != null ? findNextUserSpecifiedFocus(viewGroup, view, i3) : null;
        if (findNextUserSpecifiedFocus != null) {
            return findNextUserSpecifiedFocus;
        }
        ArrayList<View> arrayList = this.mTempList;
        try {
            arrayList.clear();
            viewGroup.addFocusables(arrayList, i3);
            if (!arrayList.isEmpty()) {
                findNextUserSpecifiedFocus = findNextFocus(viewGroup, view, rect, i3, arrayList);
            }
            return findNextUserSpecifiedFocus;
        } finally {
            arrayList.clear();
        }
    }

    private View findNextFocus(ViewGroup viewGroup, View view, Rect rect, int i3, ArrayList<View> arrayList) {
        if (view != null) {
            if (rect == null) {
                rect = this.mFocusedRect;
            }
            view.getFocusedRect(rect);
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
        } else if (rect == null) {
            rect = this.mFocusedRect;
            makeUpRectOfRoot(viewGroup, rect, i3);
        }
        return getView(viewGroup, view, rect, i3, arrayList);
    }
}
