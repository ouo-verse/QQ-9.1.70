package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* compiled from: P */
/* loaded from: classes.dex */
class AccessibilityDelegateCompatJellyBean {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface AccessibilityDelegateBridgeJellyBean {
        boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        Object getAccessibilityNodeProvider(View view);

        void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityNodeInfo(View view, Object obj);

        void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        boolean performAccessibilityAction(View view, int i3, Bundle bundle);

        void sendAccessibilityEvent(View view, int i3);

        void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent);
    }

    AccessibilityDelegateCompatJellyBean() {
    }

    public static Object getAccessibilityNodeProvider(Object obj, View view) {
        return ((View.AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static Object newAccessibilityDelegateBridge(final AccessibilityDelegateBridgeJellyBean accessibilityDelegateBridgeJellyBean) {
        return new View.AccessibilityDelegate() { // from class: android.support.v4.view.AccessibilityDelegateCompatJellyBean.1
            @Override // android.view.View.AccessibilityDelegate
            public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                return AccessibilityDelegateBridgeJellyBean.this.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                return (AccessibilityNodeProvider) AccessibilityDelegateBridgeJellyBean.this.getAccessibilityNodeProvider(view);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                AccessibilityDelegateBridgeJellyBean.this.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                AccessibilityDelegateBridgeJellyBean.this.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                AccessibilityDelegateBridgeJellyBean.this.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return AccessibilityDelegateBridgeJellyBean.this.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }

            @Override // android.view.View.AccessibilityDelegate
            public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
                return AccessibilityDelegateBridgeJellyBean.this.performAccessibilityAction(view, i3, bundle);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i3) {
                AccessibilityDelegateBridgeJellyBean.this.sendAccessibilityEvent(view, i3);
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                AccessibilityDelegateBridgeJellyBean.this.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        };
    }

    public static boolean performAccessibilityAction(Object obj, View view, int i3, Bundle bundle) {
        return ((View.AccessibilityDelegate) obj).performAccessibilityAction(view, i3, bundle);
    }
}
