package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class AccessibilityNodeProviderCompat {
    public static final int HOST_VIEW_ID = -1;
    private final Object mProvider;

    @RequiresApi(16)
    /* loaded from: classes.dex */
    static class AccessibilityNodeProviderApi16 extends AccessibilityNodeProvider {
        final AccessibilityNodeProviderCompat mCompat;

        AccessibilityNodeProviderApi16(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.mCompat = accessibilityNodeProviderCompat;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i3) {
            AccessibilityNodeInfoCompat createAccessibilityNodeInfo = this.mCompat.createAccessibilityNodeInfo(i3);
            if (createAccessibilityNodeInfo == null) {
                return null;
            }
            return createAccessibilityNodeInfo.unwrap();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i3) {
            List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText = this.mCompat.findAccessibilityNodeInfosByText(str, i3);
            if (findAccessibilityNodeInfosByText == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = findAccessibilityNodeInfosByText.size();
            for (int i16 = 0; i16 < size; i16++) {
                arrayList.add(findAccessibilityNodeInfosByText.get(i16).unwrap());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i3, int i16, Bundle bundle) {
            return this.mCompat.performAction(i3, i16, bundle);
        }
    }

    @RequiresApi(19)
    /* loaded from: classes.dex */
    static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProviderApi16 {
        AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i3) {
            AccessibilityNodeInfoCompat findFocus = this.mCompat.findFocus(i3);
            if (findFocus == null) {
                return null;
            }
            return findFocus.unwrap();
        }
    }

    @RequiresApi(26)
    /* loaded from: classes.dex */
    static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i3, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.mCompat.addExtraDataToAccessibilityNodeInfo(i3, AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo), str, bundle);
        }
    }

    public AccessibilityNodeProviderCompat() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mProvider = new AccessibilityNodeProviderApi26(this);
        } else {
            this.mProvider = new AccessibilityNodeProviderApi19(this);
        }
    }

    @Nullable
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i3) {
        return null;
    }

    @Nullable
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str, int i3) {
        return null;
    }

    @Nullable
    public AccessibilityNodeInfoCompat findFocus(int i3) {
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

    public void addExtraDataToAccessibilityNodeInfo(int i3, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @NonNull String str, @Nullable Bundle bundle) {
    }
}
