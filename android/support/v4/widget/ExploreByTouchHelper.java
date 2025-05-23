package android.support.v4.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = View.class.getName();
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private final AccessibilityManager mManager;
    private ExploreByTouchNodeProvider mNodeProvider;
    private final View mView;
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();
    private final int[] mTempGlobalRect = new int[2];
    private int mFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class ExploreByTouchNodeProvider extends AccessibilityNodeProviderCompat {
        ExploreByTouchNodeProvider() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i3) {
            return ExploreByTouchHelper.this.createNode(i3);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i3, int i16, Bundle bundle) {
            return ExploreByTouchHelper.this.performAction(i3, i16, bundle);
        }
    }

    public ExploreByTouchHelper(View view) {
        if (view != null) {
            this.mView = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean clearAccessibilityFocus(int i3) {
        if (isAccessibilityFocused(i3)) {
            this.mFocusedVirtualViewId = Integer.MIN_VALUE;
            this.mView.invalidate();
            sendEventForVirtualView(i3, 65536);
            return true;
        }
        return false;
    }

    private AccessibilityEvent createEvent(int i3, int i16) {
        if (i3 != -1) {
            return createEventForChild(i3, i16);
        }
        return createEventForHost(i16);
    }

    private AccessibilityEvent createEventForChild(int i3, int i16) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i16);
        obtain.setEnabled(true);
        obtain.setClassName(DEFAULT_CLASS_NAME);
        onPopulateEventForVirtualView(i3, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setPackageName(this.mView.getContext().getPackageName());
        obtain.setSource(this.mView, i3);
        return obtain;
    }

    private AccessibilityEvent createEventForHost(int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        ViewCompat.onInitializeAccessibilityEvent(this.mView, obtain);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AccessibilityNodeInfoCompat createNode(int i3) {
        if (i3 != -1) {
            return createNodeForChild(i3);
        }
        return createNodeForHost();
    }

    private AccessibilityNodeInfoCompat createNodeForChild(int i3) {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setClassName(DEFAULT_CLASS_NAME);
        onPopulateNodeForVirtualView(i3, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.mTempParentRect);
        if (!this.mTempParentRect.isEmpty()) {
            int actions = obtain.getActions();
            if ((actions & 64) == 0) {
                if ((actions & 128) == 0) {
                    obtain.setPackageName(this.mView.getContext().getPackageName());
                    obtain.setSource(this.mView, i3);
                    obtain.setParent(this.mView);
                    if (this.mFocusedVirtualViewId == i3) {
                        obtain.setAccessibilityFocused(true);
                        obtain.addAction(128);
                    } else {
                        obtain.setAccessibilityFocused(false);
                        obtain.addAction(64);
                    }
                    if (intersectVisibleToUser(this.mTempParentRect)) {
                        obtain.setVisibleToUser(true);
                        obtain.setBoundsInParent(this.mTempParentRect);
                    }
                    this.mView.getLocationOnScreen(this.mTempGlobalRect);
                    int[] iArr = this.mTempGlobalRect;
                    int i16 = iArr[0];
                    int i17 = iArr[1];
                    this.mTempScreenRect.set(this.mTempParentRect);
                    this.mTempScreenRect.offset(i16, i17);
                    obtain.setBoundsInScreen(this.mTempScreenRect);
                    return obtain;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId(), Rect(" + this.mTempParentRect.left + "," + this.mTempParentRect.top + "," + this.mTempParentRect.right + "," + this.mTempParentRect.bottom + "), nodeText(" + ((Object) obtain.getContentDescription()) + ")");
    }

    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.mView);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mView, obtain);
        LinkedList linkedList = new LinkedList();
        getVisibleVirtualViews(linkedList);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            obtain.addChild(this.mView, ((Integer) it.next()).intValue());
        }
        return obtain;
    }

    private boolean intersectVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mView.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.mView.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent == null || !this.mView.getLocalVisibleRect(this.mTempVisibleRect)) {
            return false;
        }
        return rect.intersect(this.mTempVisibleRect);
    }

    private boolean isAccessibilityFocused(int i3) {
        if (this.mFocusedVirtualViewId == i3) {
            return true;
        }
        return false;
    }

    private boolean manageFocusForChild(int i3, int i16, Bundle bundle) {
        if (i16 != 64) {
            if (i16 != 128) {
                return false;
            }
            return clearAccessibilityFocus(i3);
        }
        return requestAccessibilityFocus(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean performAction(int i3, int i16, Bundle bundle) {
        if (i3 != -1) {
            return performActionForChild(i3, i16, bundle);
        }
        return performActionForHost(i16, bundle);
    }

    private boolean performActionForChild(int i3, int i16, Bundle bundle) {
        if (i16 != 64 && i16 != 128) {
            return onPerformActionForVirtualView(i3, i16, bundle);
        }
        return manageFocusForChild(i3, i16, bundle);
    }

    private boolean performActionForHost(int i3, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.mView, i3, bundle);
    }

    private boolean requestAccessibilityFocus(int i3) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || isAccessibilityFocused(i3)) {
            return false;
        }
        this.mFocusedVirtualViewId = i3;
        this.mView.invalidate();
        sendEventForVirtualView(i3, 32768);
        return true;
    }

    private void updateHoveredVirtualView(int i3) {
        int i16 = this.mHoveredVirtualViewId;
        if (i16 == i3) {
            return;
        }
        this.mHoveredVirtualViewId = i3;
        sendEventForVirtualView(i3, 128);
        sendEventForVirtualView(i16, 256);
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7 && action != 9) {
            if (action != 10 || this.mFocusedVirtualViewId == Integer.MIN_VALUE) {
                return false;
            }
            updateHoveredVirtualView(Integer.MIN_VALUE);
            return true;
        }
        int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
        updateHoveredVirtualView(virtualViewAt);
        if (virtualViewAt == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    @Override // android.support.v4.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new ExploreByTouchNodeProvider();
        }
        return this.mNodeProvider;
    }

    public int getFocusedVirtualView() {
        return this.mFocusedVirtualViewId;
    }

    protected abstract int getVirtualViewAt(float f16, float f17);

    protected abstract void getVisibleVirtualViews(List<Integer> list);

    public void invalidateRoot() {
        invalidateVirtualView(-1);
    }

    public void invalidateVirtualView(int i3) {
        sendEventForVirtualView(i3, 2048);
    }

    protected abstract boolean onPerformActionForVirtualView(int i3, int i16, Bundle bundle);

    protected abstract void onPopulateEventForVirtualView(int i3, AccessibilityEvent accessibilityEvent);

    protected abstract void onPopulateNodeForVirtualView(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public boolean sendEventForVirtualView(int i3, int i16) {
        ViewParent parent;
        if (i3 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mView.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.mView, createEvent(i3, i16));
    }
}
