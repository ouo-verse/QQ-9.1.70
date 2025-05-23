package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private Object mInfo;

    AccessibilityWindowInfoCompat(Object obj) {
        this.mInfo = obj;
    }

    public static AccessibilityWindowInfoCompat obtain() {
        return wrapNonNullInstance(AccessibilityWindowInfo.obtain());
    }

    private static String typeToString(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return "<UNKNOWN>";
                    }
                    return "TYPE_ACCESSIBILITY_OVERLAY";
                }
                return "TYPE_SYSTEM";
            }
            return "TYPE_INPUT_METHOD";
        }
        return "TYPE_APPLICATION";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AccessibilityWindowInfoCompat wrapNonNullInstance(Object obj) {
        if (obj != null) {
            return new AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityWindowInfoCompat)) {
            return false;
        }
        AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat) obj;
        Object obj2 = this.mInfo;
        if (obj2 == null) {
            if (accessibilityWindowInfoCompat.mInfo != null) {
                return false;
            }
        } else if (!obj2.equals(accessibilityWindowInfoCompat.mInfo)) {
            return false;
        }
        return true;
    }

    public AccessibilityNodeInfoCompat getAnchor() {
        AccessibilityNodeInfo anchor;
        if (Build.VERSION.SDK_INT >= 24) {
            anchor = ((AccessibilityWindowInfo) this.mInfo).getAnchor();
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(anchor);
        }
        return null;
    }

    public void getBoundsInScreen(Rect rect) {
        ((AccessibilityWindowInfo) this.mInfo).getBoundsInScreen(rect);
    }

    public AccessibilityWindowInfoCompat getChild(int i3) {
        return wrapNonNullInstance(((AccessibilityWindowInfo) this.mInfo).getChild(i3));
    }

    public int getChildCount() {
        return ((AccessibilityWindowInfo) this.mInfo).getChildCount();
    }

    public int getId() {
        return ((AccessibilityWindowInfo) this.mInfo).getId();
    }

    public int getLayer() {
        return ((AccessibilityWindowInfo) this.mInfo).getLayer();
    }

    public AccessibilityWindowInfoCompat getParent() {
        return wrapNonNullInstance(((AccessibilityWindowInfo) this.mInfo).getParent());
    }

    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo) this.mInfo).getRoot());
    }

    public CharSequence getTitle() {
        CharSequence title;
        if (Build.VERSION.SDK_INT >= 24) {
            title = ((AccessibilityWindowInfo) this.mInfo).getTitle();
            return title;
        }
        return null;
    }

    public int getType() {
        return ((AccessibilityWindowInfo) this.mInfo).getType();
    }

    public int hashCode() {
        Object obj = this.mInfo;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return ((AccessibilityWindowInfo) this.mInfo).isAccessibilityFocused();
    }

    public boolean isActive() {
        return ((AccessibilityWindowInfo) this.mInfo).isActive();
    }

    public boolean isFocused() {
        return ((AccessibilityWindowInfo) this.mInfo).isFocused();
    }

    public void recycle() {
        ((AccessibilityWindowInfo) this.mInfo).recycle();
    }

    @NonNull
    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        Rect rect = new Rect();
        getBoundsInScreen(rect);
        sb5.append("AccessibilityWindowInfo[");
        sb5.append("id=");
        sb5.append(getId());
        sb5.append(", type=");
        sb5.append(typeToString(getType()));
        sb5.append(", layer=");
        sb5.append(getLayer());
        sb5.append(", bounds=");
        sb5.append(rect);
        sb5.append(", focused=");
        sb5.append(isFocused());
        sb5.append(", active=");
        sb5.append(isActive());
        sb5.append(", hasParent=");
        boolean z17 = true;
        if (getParent() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(", hasChildren=");
        if (getChildCount() <= 0) {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append(']');
        return sb5.toString();
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        if (accessibilityWindowInfoCompat == null) {
            return null;
        }
        return wrapNonNullInstance(AccessibilityWindowInfo.obtain((AccessibilityWindowInfo) accessibilityWindowInfoCompat.mInfo));
    }
}
