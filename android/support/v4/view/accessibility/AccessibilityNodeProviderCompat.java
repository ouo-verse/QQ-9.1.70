package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AccessibilityNodeProviderCompat {
    private static final AccessibilityNodeProviderImpl IMPL = new AccessibilityNodeProviderJellyBeanImpl();
    private final Object mProvider;

    /* loaded from: classes.dex */
    interface AccessibilityNodeProviderImpl {
        Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat);
    }

    /* loaded from: classes.dex */
    static class AccessibilityNodeProviderJellyBeanImpl extends AccessibilityNodeProviderStubImpl {
        AccessibilityNodeProviderJellyBeanImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderStubImpl, android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl
        public Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return AccessibilityNodeProviderCompatJellyBean.newAccessibilityNodeProviderBridge(new AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge() { // from class: android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderJellyBeanImpl.1
                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge
                public Object createAccessibilityNodeInfo(int i3) {
                    AccessibilityNodeInfoCompat createAccessibilityNodeInfo = accessibilityNodeProviderCompat.createAccessibilityNodeInfo(i3);
                    if (createAccessibilityNodeInfo == null) {
                        return null;
                    }
                    return createAccessibilityNodeInfo.getInfo();
                }

                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge
                public List<Object> findAccessibilityNodeInfosByText(String str, int i3) {
                    int size;
                    List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText = accessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(str, i3);
                    if (findAccessibilityNodeInfosByText != null && (size = findAccessibilityNodeInfosByText.size()) > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i16 = 0; i16 < size; i16++) {
                            arrayList.add(findAccessibilityNodeInfosByText.get(i16).getInfo());
                        }
                        return arrayList;
                    }
                    return null;
                }

                @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean.AccessibilityNodeInfoBridge
                public boolean performAction(int i3, int i16, Bundle bundle) {
                    return accessibilityNodeProviderCompat.performAction(i3, i16, bundle);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    static class AccessibilityNodeProviderStubImpl implements AccessibilityNodeProviderImpl {
        AccessibilityNodeProviderStubImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityNodeProviderCompat.AccessibilityNodeProviderImpl
        public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            return null;
        }
    }

    public AccessibilityNodeProviderCompat() {
        this.mProvider = IMPL.newAccessibilityNodeProviderBridge(this);
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i3) {
        return null;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str, int i3) {
        return null;
    }

    public Object getProvider() {
        return this.mProvider;
    }

    public boolean performAction(int i3, int i16, Bundle bundle) {
        return false;
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.mProvider = obj;
    }
}
