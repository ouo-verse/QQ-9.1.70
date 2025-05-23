package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
public final class ViewParentCompat {
    static final ViewParentCompatImpl IMPL = new ViewParentCompatLollipopImpl();

    /* loaded from: classes.dex */
    static class ViewParentCompatICSImpl extends ViewParentCompatStubImpl {
        ViewParentCompatICSImpl() {
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatStubImpl, android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
            return ViewParentCompatICS.requestSendAccessibilityEvent(viewParent, view, accessibilityEvent);
        }
    }

    /* loaded from: classes.dex */
    interface ViewParentCompatImpl {
        void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i3);

        boolean onNestedFling(ViewParent viewParent, View view, float f16, float f17, boolean z16);

        boolean onNestedPreFling(ViewParent viewParent, View view, float f16, float f17);

        void onNestedPreScroll(ViewParent viewParent, View view, int i3, int i16, int[] iArr);

        void onNestedScroll(ViewParent viewParent, View view, int i3, int i16, int i17, int i18);

        void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i3);

        boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i3);

        void onStopNestedScroll(ViewParent viewParent, View view);

        boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent);
    }

    /* loaded from: classes.dex */
    static class ViewParentCompatKitKatImpl extends ViewParentCompatICSImpl {
        ViewParentCompatKitKatImpl() {
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatStubImpl, android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i3) {
            ViewParentCompatKitKat.notifySubtreeAccessibilityStateChanged(viewParent, view, view2, i3);
        }
    }

    /* loaded from: classes.dex */
    static class ViewParentCompatLollipopImpl extends ViewParentCompatKitKatImpl {
        ViewParentCompatLollipopImpl() {
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatStubImpl, android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean onNestedFling(ViewParent viewParent, View view, float f16, float f17, boolean z16) {
            return ViewParentCompatLollipop.onNestedFling(viewParent, view, f16, f17, z16);
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatStubImpl, android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean onNestedPreFling(ViewParent viewParent, View view, float f16, float f17) {
            return ViewParentCompatLollipop.onNestedPreFling(viewParent, view, f16, f17);
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatStubImpl, android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onNestedPreScroll(ViewParent viewParent, View view, int i3, int i16, int[] iArr) {
            ViewParentCompatLollipop.onNestedPreScroll(viewParent, view, i3, i16, iArr);
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatStubImpl, android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onNestedScroll(ViewParent viewParent, View view, int i3, int i16, int i17, int i18) {
            ViewParentCompatLollipop.onNestedScroll(viewParent, view, i3, i16, i17, i18);
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatStubImpl, android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i3) {
            ViewParentCompatLollipop.onNestedScrollAccepted(viewParent, view, view2, i3);
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatStubImpl, android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i3) {
            return ViewParentCompatLollipop.onStartNestedScroll(viewParent, view, view2, i3);
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatStubImpl, android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onStopNestedScroll(ViewParent viewParent, View view) {
            ViewParentCompatLollipop.onStopNestedScroll(viewParent, view);
        }
    }

    ViewParentCompat() {
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i3) {
        IMPL.notifySubtreeAccessibilityStateChanged(viewParent, view, view2, i3);
    }

    public static boolean onNestedFling(ViewParent viewParent, View view, float f16, float f17, boolean z16) {
        return IMPL.onNestedFling(viewParent, view, f16, f17, z16);
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f16, float f17) {
        return IMPL.onNestedPreFling(viewParent, view, f16, f17);
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i3, int i16, int[] iArr) {
        IMPL.onNestedPreScroll(viewParent, view, i3, i16, iArr);
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i3, int i16, int i17, int i18) {
        IMPL.onNestedScroll(viewParent, view, i3, i16, i17, i18);
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i3) {
        IMPL.onNestedScrollAccepted(viewParent, view, view2, i3);
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i3) {
        return IMPL.onStartNestedScroll(viewParent, view, view2, i3);
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        IMPL.onStopNestedScroll(viewParent, view);
    }

    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return IMPL.requestSendAccessibilityEvent(viewParent, view, accessibilityEvent);
    }

    /* loaded from: classes.dex */
    static class ViewParentCompatStubImpl implements ViewParentCompatImpl {
        ViewParentCompatStubImpl() {
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean onNestedFling(ViewParent viewParent, View view, float f16, float f17, boolean z16) {
            if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onNestedFling(view, f16, f17, z16);
            }
            return false;
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean onNestedPreFling(ViewParent viewParent, View view, float f16, float f17) {
            if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onNestedPreFling(view, f16, f17);
            }
            return false;
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onNestedPreScroll(ViewParent viewParent, View view, int i3, int i16, int[] iArr) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedPreScroll(view, i3, i16, iArr);
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onNestedScroll(ViewParent viewParent, View view, int i3, int i16, int i17, int i18) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScroll(view, i3, i16, i17, i18);
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i3) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScrollAccepted(view, view2, i3);
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i3) {
            if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onStartNestedScroll(view, view2, i3);
            }
            return false;
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void onStopNestedScroll(ViewParent viewParent, View view) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onStopNestedScroll(view);
            }
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
            if (view == null) {
                return false;
            }
            ((AccessibilityManager) view.getContext().getSystemService("accessibility")).sendAccessibilityEvent(accessibilityEvent);
            return true;
        }

        @Override // android.support.v4.view.ViewParentCompat.ViewParentCompatImpl
        public void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i3) {
        }
    }
}
