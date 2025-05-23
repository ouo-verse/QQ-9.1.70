package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.1
        @Override // androidx.customview.widget.FocusStrategy.BoundsAdapter
        public void obtainBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.getBoundsInParent(rect);
        }
    };
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.2
        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i3) {
            return sparseArrayCompat.valueAt(i3);
        }

        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.size();
        }
    };
    private final View mHost;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();
    private final int[] mTempGlobalRect = new int[2];
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class MyNodeProvider extends AccessibilityNodeProviderCompat {
        MyNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i3) {
            return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(i3));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i3) {
            int i16;
            if (i3 == 2) {
                i16 = ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId;
            } else {
                i16 = ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
            }
            if (i16 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(i16);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i3, int i16, Bundle bundle) {
            return ExploreByTouchHelper.this.performAction(i3, i16, bundle);
        }
    }

    public ExploreByTouchHelper(@NonNull View view) {
        if (view != null) {
            this.mHost = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean clearAccessibilityFocus(int i3) {
        if (this.mAccessibilityFocusedVirtualViewId == i3) {
            this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
            this.mHost.invalidate();
            sendEventForVirtualView(i3, 65536);
            return true;
        }
        return false;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int i3 = this.mKeyboardFocusedVirtualViewId;
        if (i3 != Integer.MIN_VALUE && onPerformActionForVirtualView(i3, 16, null)) {
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
        AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i3);
        obtain.getText().add(obtainAccessibilityNodeInfo.getText());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.getContentDescription());
        obtain.setScrollable(obtainAccessibilityNodeInfo.isScrollable());
        obtain.setPassword(obtainAccessibilityNodeInfo.isPassword());
        obtain.setEnabled(obtainAccessibilityNodeInfo.isEnabled());
        obtain.setChecked(obtainAccessibilityNodeInfo.isChecked());
        onPopulateEventForVirtualView(i3, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(obtainAccessibilityNodeInfo.getClassName());
        AccessibilityRecordCompat.setSource(obtain, this.mHost, i3);
        obtain.setPackageName(this.mHost.getContext().getPackageName());
        return obtain;
    }

    private AccessibilityEvent createEventForHost(int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForChild(int i3) {
        boolean z16;
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        obtain.setClassName(DEFAULT_CLASS_NAME);
        Rect rect = INVALID_PARENT_BOUNDS;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        obtain.setParent(this.mHost);
        onPopulateNodeForVirtualView(i3, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.mTempParentRect);
        if (!this.mTempParentRect.equals(rect)) {
            int actions = obtain.getActions();
            if ((actions & 64) == 0) {
                if ((actions & 128) == 0) {
                    obtain.setPackageName(this.mHost.getContext().getPackageName());
                    obtain.setSource(this.mHost, i3);
                    if (this.mAccessibilityFocusedVirtualViewId == i3) {
                        obtain.setAccessibilityFocused(true);
                        obtain.addAction(128);
                    } else {
                        obtain.setAccessibilityFocused(false);
                        obtain.addAction(64);
                    }
                    if (this.mKeyboardFocusedVirtualViewId == i3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        obtain.addAction(2);
                    } else if (obtain.isFocusable()) {
                        obtain.addAction(1);
                    }
                    obtain.setFocused(z16);
                    this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                    obtain.getBoundsInScreen(this.mTempScreenRect);
                    if (this.mTempScreenRect.equals(rect)) {
                        obtain.getBoundsInParent(this.mTempScreenRect);
                        if (obtain.mParentVirtualDescendantId != -1) {
                            AccessibilityNodeInfoCompat obtain2 = AccessibilityNodeInfoCompat.obtain();
                            for (int i16 = obtain.mParentVirtualDescendantId; i16 != -1; i16 = obtain2.mParentVirtualDescendantId) {
                                obtain2.setParent(this.mHost, -1);
                                obtain2.setBoundsInParent(INVALID_PARENT_BOUNDS);
                                onPopulateNodeForVirtualView(i16, obtain2);
                                obtain2.getBoundsInParent(this.mTempParentRect);
                                Rect rect2 = this.mTempScreenRect;
                                Rect rect3 = this.mTempParentRect;
                                rect2.offset(rect3.left, rect3.top);
                            }
                            obtain2.recycle();
                        }
                        this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                    }
                    if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                        this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                        if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                            obtain.setBoundsInScreen(this.mTempScreenRect);
                            if (isVisibleToUser(this.mTempScreenRect)) {
                                obtain.setVisibleToUser(true);
                            }
                        }
                    }
                    return obtain;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, obtain);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            obtain.addChild(this.mHost, ((Integer) arrayList.get(i3)).intValue());
        }
        return obtain;
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            sparseArrayCompat.put(arrayList.get(i3).intValue(), createNodeForChild(arrayList.get(i3).intValue()));
        }
        return sparseArrayCompat;
    }

    private void getBoundsInParent(int i3, Rect rect) {
        obtainAccessibilityNodeInfo(i3).getBoundsInParent(rect);
    }

    private static Rect guessPreviouslyFocusedRect(@NonNull View view, int i3, @NonNull Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        rect.set(0, -1, width, -1);
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    rect.set(-1, 0, -1, height);
                }
            } else {
                rect.set(0, height, width, height);
            }
        } else {
            rect.set(width, 0, width, height);
        }
        return rect;
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent == null) {
            return false;
        }
        return true;
    }

    private static int keyToDirection(int i3) {
        if (i3 != 19) {
            if (i3 != 21) {
                if (i3 != 22) {
                    return 130;
                }
                return 66;
            }
            return 17;
        }
        return 33;
    }

    private boolean moveFocus(int i3, @Nullable Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        boolean z16;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
        SparseArrayCompat<AccessibilityNodeInfoCompat> allNodes = getAllNodes();
        int i16 = this.mKeyboardFocusedVirtualViewId;
        int i17 = Integer.MIN_VALUE;
        if (i16 == Integer.MIN_VALUE) {
            accessibilityNodeInfoCompat = null;
        } else {
            accessibilityNodeInfoCompat = allNodes.get(i16);
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = accessibilityNodeInfoCompat;
        if (i3 != 1 && i3 != 2) {
            if (i3 != 17 && i3 != 33 && i3 != 66 && i3 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i18 = this.mKeyboardFocusedVirtualViewId;
            if (i18 != Integer.MIN_VALUE) {
                getBoundsInParent(i18, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                guessPreviouslyFocusedRect(this.mHost, i3, rect2);
            }
            accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInAbsoluteDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat3, rect2, i3);
        } else {
            if (ViewCompat.getLayoutDirection(this.mHost) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInRelativeDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat3, i3, z16, false);
        }
        if (accessibilityNodeInfoCompat2 != null) {
            i17 = allNodes.keyAt(allNodes.indexOfValue(accessibilityNodeInfoCompat2));
        }
        return requestKeyboardFocusForVirtualView(i17);
    }

    private boolean performActionForChild(int i3, int i16, Bundle bundle) {
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 64) {
                    if (i16 != 128) {
                        return onPerformActionForVirtualView(i3, i16, bundle);
                    }
                    return clearAccessibilityFocus(i3);
                }
                return requestAccessibilityFocus(i3);
            }
            return clearKeyboardFocusForVirtualView(i3);
        }
        return requestKeyboardFocusForVirtualView(i3);
    }

    private boolean performActionForHost(int i3, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.mHost, i3, bundle);
    }

    private boolean requestAccessibilityFocus(int i3) {
        int i16;
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || (i16 = this.mAccessibilityFocusedVirtualViewId) == i3) {
            return false;
        }
        if (i16 != Integer.MIN_VALUE) {
            clearAccessibilityFocus(i16);
        }
        this.mAccessibilityFocusedVirtualViewId = i3;
        this.mHost.invalidate();
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

    public final boolean clearKeyboardFocusForVirtualView(int i3) {
        if (this.mKeyboardFocusedVirtualViewId != i3) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i3, false);
        sendEventForVirtualView(i3, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7 && action != 9) {
            if (action != 10 || this.mHoveredVirtualViewId == Integer.MIN_VALUE) {
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

    public final boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        int i3 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int keyToDirection = keyToDirection(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z16 = false;
                        while (i3 < repeatCount && moveFocus(keyToDirection, null)) {
                            i3++;
                            z16 = true;
                        }
                        return z16;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            clickKeyboardFocusedVirtualView();
            return true;
        }
        if (keyEvent.hasNoModifiers()) {
            return moveFocus(2, null);
        }
        if (!keyEvent.hasModifiers(1)) {
            return false;
        }
        return moveFocus(1, null);
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider();
        }
        return this.mNodeProvider;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    protected abstract int getVirtualViewAt(float f16, float f17);

    protected abstract void getVisibleVirtualViews(List<Integer> list);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i3) {
        invalidateVirtualView(i3, 0);
    }

    @NonNull
    AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i3) {
        if (i3 == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i3);
    }

    public final void onFocusChanged(boolean z16, int i3, @Nullable Rect rect) {
        int i16 = this.mKeyboardFocusedVirtualViewId;
        if (i16 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i16);
        }
        if (z16) {
            moveFocus(i3, rect);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    protected abstract boolean onPerformActionForVirtualView(int i3, int i16, @Nullable Bundle bundle);

    protected abstract void onPopulateNodeForVirtualView(int i3, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    boolean performAction(int i3, int i16, Bundle bundle) {
        if (i3 != -1) {
            return performActionForChild(i3, i16, bundle);
        }
        return performActionForHost(i16, bundle);
    }

    public final boolean requestKeyboardFocusForVirtualView(int i3) {
        int i16;
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || (i16 = this.mKeyboardFocusedVirtualViewId) == i3) {
            return false;
        }
        if (i16 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i16);
        }
        if (i3 == Integer.MIN_VALUE) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = i3;
        onVirtualViewKeyboardFocusChanged(i3, true);
        sendEventForVirtualView(i3, 8);
        return true;
    }

    public final boolean sendEventForVirtualView(int i3, int i16) {
        ViewParent parent;
        if (i3 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.mHost, createEvent(i3, i16));
    }

    public final void invalidateVirtualView(int i3, int i16) {
        ViewParent parent;
        if (i3 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return;
        }
        AccessibilityEvent createEvent = createEvent(i3, 2048);
        AccessibilityEventCompat.setContentChangeTypes(createEvent, i16);
        parent.requestSendAccessibilityEvent(this.mHost, createEvent);
    }

    protected void onPopulateEventForHost(@NonNull AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    protected void onPopulateEventForVirtualView(int i3, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    protected void onVirtualViewKeyboardFocusChanged(int i3, boolean z16) {
    }
}
