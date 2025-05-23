package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* loaded from: classes.dex */
class AccessibilityNodeProviderCompatJellyBean {

    /* loaded from: classes.dex */
    interface AccessibilityNodeInfoBridge {
        Object createAccessibilityNodeInfo(int i3);

        List<Object> findAccessibilityNodeInfosByText(String str, int i3);

        boolean performAction(int i3, int i16, Bundle bundle);
    }

    AccessibilityNodeProviderCompatJellyBean() {
    }

    public static Object newAccessibilityNodeProviderBridge(final AccessibilityNodeInfoBridge accessibilityNodeInfoBridge) {
        return new AccessibilityNodeProvider() { // from class: android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.1
            @Override // android.view.accessibility.AccessibilityNodeProvider
            public AccessibilityNodeInfo createAccessibilityNodeInfo(int i3) {
                return (AccessibilityNodeInfo) AccessibilityNodeInfoBridge.this.createAccessibilityNodeInfo(i3);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i3) {
                return AccessibilityNodeInfoBridge.this.findAccessibilityNodeInfosByText(str, i3);
            }

            @Override // android.view.accessibility.AccessibilityNodeProvider
            public boolean performAction(int i3, int i16, Bundle bundle) {
                return AccessibilityNodeInfoBridge.this.performAction(i3, i16, bundle);
            }
        };
    }
}
