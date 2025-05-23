package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* compiled from: P */
/* loaded from: classes.dex */
public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParent;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(View view) {
        this.mView = view;
    }

    public boolean dispatchNestedFling(float f16, float f17, boolean z16) {
        ViewParent viewParent;
        if (isNestedScrollingEnabled() && (viewParent = this.mNestedScrollingParent) != null) {
            return ViewParentCompat.onNestedFling(viewParent, this.mView, f16, f17, z16);
        }
        return false;
    }

    public boolean dispatchNestedPreFling(float f16, float f17) {
        ViewParent viewParent;
        if (isNestedScrollingEnabled() && (viewParent = this.mNestedScrollingParent) != null) {
            return ViewParentCompat.onNestedPreFling(viewParent, this.mView, f16, f17);
        }
        return false;
    }

    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2) {
        int i17;
        int i18;
        if (!isNestedScrollingEnabled() || this.mNestedScrollingParent == null) {
            return false;
        }
        if (i3 == 0 && i16 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            i17 = iArr2[0];
            i18 = iArr2[1];
        } else {
            i17 = 0;
            i18 = 0;
        }
        if (iArr == null) {
            if (this.mTempNestedScrollConsumed == null) {
                this.mTempNestedScrollConsumed = new int[2];
            }
            iArr = this.mTempNestedScrollConsumed;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        ViewParentCompat.onNestedPreScroll(this.mNestedScrollingParent, this.mView, i3, i16, iArr);
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i17;
            iArr2[1] = iArr2[1] - i18;
        }
        if (iArr[0] == 0 && iArr[1] == 0) {
            return false;
        }
        return true;
    }

    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr) {
        int i19;
        int i26;
        if (isNestedScrollingEnabled() && this.mNestedScrollingParent != null) {
            if (i3 == 0 && i16 == 0 && i17 == 0 && i18 == 0) {
                if (iArr != null) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                }
            } else {
                if (iArr != null) {
                    this.mView.getLocationInWindow(iArr);
                    i19 = iArr[0];
                    i26 = iArr[1];
                } else {
                    i19 = 0;
                    i26 = 0;
                }
                ViewParentCompat.onNestedScroll(this.mNestedScrollingParent, this.mView, i3, i16, i17, i18);
                if (iArr != null) {
                    this.mView.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i19;
                    iArr[1] = iArr[1] - i26;
                }
                return true;
            }
        }
        return false;
    }

    public boolean hasNestedScrollingParent() {
        if (this.mNestedScrollingParent != null) {
            return true;
        }
        return false;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(View view) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean z16) {
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = z16;
    }

    public boolean startNestedScroll(int i3) {
        if (hasNestedScrollingParent()) {
            return true;
        }
        if (isNestedScrollingEnabled()) {
            View view = this.mView;
            for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
                if (ViewParentCompat.onStartNestedScroll(parent, view, this.mView, i3)) {
                    this.mNestedScrollingParent = parent;
                    ViewParentCompat.onNestedScrollAccepted(parent, view, this.mView, i3);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
            return false;
        }
        return false;
    }

    public void stopNestedScroll() {
        ViewParent viewParent = this.mNestedScrollingParent;
        if (viewParent != null) {
            ViewParentCompat.onStopNestedScroll(viewParent, this.mView);
            this.mNestedScrollingParent = null;
        }
    }
}
