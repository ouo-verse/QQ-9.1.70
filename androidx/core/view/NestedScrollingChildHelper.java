package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(@NonNull View view) {
        this.mView = view;
    }

    private boolean dispatchNestedScrollInternal(int i3, int i16, int i17, int i18, @Nullable int[] iArr, int i19, @Nullable int[] iArr2) {
        ViewParent nestedScrollingParentForType;
        int i26;
        int i27;
        int[] iArr3;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i19)) == null) {
            return false;
        }
        if (i3 == 0 && i16 == 0 && i17 == 0 && i18 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.mView.getLocationInWindow(iArr);
            i26 = iArr[0];
            i27 = iArr[1];
        } else {
            i26 = 0;
            i27 = 0;
        }
        if (iArr2 == null) {
            int[] tempNestedScrollConsumed = getTempNestedScrollConsumed();
            tempNestedScrollConsumed[0] = 0;
            tempNestedScrollConsumed[1] = 0;
            iArr3 = tempNestedScrollConsumed;
        } else {
            iArr3 = iArr2;
        }
        ViewParentCompat.onNestedScroll(nestedScrollingParentForType, this.mView, i3, i16, i17, i18, i19, iArr3);
        if (iArr != null) {
            this.mView.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i26;
            iArr[1] = iArr[1] - i27;
        }
        return true;
    }

    private ViewParent getNestedScrollingParentForType(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return null;
            }
            return this.mNestedScrollingParentNonTouch;
        }
        return this.mNestedScrollingParentTouch;
    }

    private int[] getTempNestedScrollConsumed() {
        if (this.mTempNestedScrollConsumed == null) {
            this.mTempNestedScrollConsumed = new int[2];
        }
        return this.mTempNestedScrollConsumed;
    }

    private void setNestedScrollingParentForType(int i3, ViewParent viewParent) {
        if (i3 != 0) {
            if (i3 == 1) {
                this.mNestedScrollingParentNonTouch = viewParent;
                return;
            }
            return;
        }
        this.mNestedScrollingParentTouch = viewParent;
    }

    public boolean dispatchNestedFling(float f16, float f17, boolean z16) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedFling(nestedScrollingParentForType, this.mView, f16, f17, z16);
    }

    public boolean dispatchNestedPreFling(float f16, float f17) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedPreFling(nestedScrollingParentForType, this.mView, f16, f17);
    }

    public boolean dispatchNestedPreScroll(int i3, int i16, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i3, i16, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, @Nullable int[] iArr) {
        return dispatchNestedScrollInternal(i3, i16, i17, i18, iArr, 0, null);
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(@NonNull View view) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean z16) {
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = z16;
    }

    public boolean startNestedScroll(int i3) {
        return startNestedScroll(i3, 0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public boolean dispatchNestedPreScroll(int i3, int i16, @Nullable int[] iArr, @Nullable int[] iArr2, int i17) {
        ViewParent nestedScrollingParentForType;
        int i18;
        int i19;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i17)) == null) {
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
            i18 = iArr2[0];
            i19 = iArr2[1];
        } else {
            i18 = 0;
            i19 = 0;
        }
        if (iArr == null) {
            iArr = getTempNestedScrollConsumed();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        ViewParentCompat.onNestedPreScroll(nestedScrollingParentForType, this.mView, i3, i16, iArr, i17);
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i18;
            iArr2[1] = iArr2[1] - i19;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, @Nullable int[] iArr, int i19) {
        return dispatchNestedScrollInternal(i3, i16, i17, i18, iArr, i19, null);
    }

    public boolean hasNestedScrollingParent(int i3) {
        return getNestedScrollingParentForType(i3) != null;
    }

    public boolean startNestedScroll(int i3, int i16) {
        if (hasNestedScrollingParent(i16)) {
            return true;
        }
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        View view = this.mView;
        for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
            if (ViewParentCompat.onStartNestedScroll(parent, view, this.mView, i3, i16)) {
                setNestedScrollingParentForType(i16, parent);
                ViewParentCompat.onNestedScrollAccepted(parent, view, this.mView, i3, i16);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void stopNestedScroll(int i3) {
        ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i3);
        if (nestedScrollingParentForType != null) {
            ViewParentCompat.onStopNestedScroll(nestedScrollingParentForType, this.mView, i3);
            setNestedScrollingParentForType(i3, null);
        }
    }

    public void dispatchNestedScroll(int i3, int i16, int i17, int i18, @Nullable int[] iArr, int i19, @Nullable int[] iArr2) {
        dispatchNestedScrollInternal(i3, i16, i17, i18, iArr, i19, iArr2);
    }
}
