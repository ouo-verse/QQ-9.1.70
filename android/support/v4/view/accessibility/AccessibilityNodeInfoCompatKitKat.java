package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: P */
/* loaded from: classes.dex */
class AccessibilityNodeInfoCompatKitKat {

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class CollectionInfo {
        CollectionInfo() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getColumnCount(Object obj) {
            return ((AccessibilityNodeInfo.CollectionInfo) obj).getColumnCount();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getRowCount(Object obj) {
            return ((AccessibilityNodeInfo.CollectionInfo) obj).getRowCount();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean isHierarchical(Object obj) {
            return ((AccessibilityNodeInfo.CollectionInfo) obj).isHierarchical();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class CollectionItemInfo {
        CollectionItemInfo() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getColumnIndex(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnIndex();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getColumnSpan(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnSpan();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getRowIndex(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowIndex();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getRowSpan(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowSpan();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean isHeading(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).isHeading();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class RangeInfo {
        RangeInfo() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static float getCurrent(Object obj) {
            return ((AccessibilityNodeInfo.RangeInfo) obj).getCurrent();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static float getMax(Object obj) {
            return ((AccessibilityNodeInfo.RangeInfo) obj).getMax();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static float getMin(Object obj) {
            return ((AccessibilityNodeInfo.RangeInfo) obj).getMin();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int getType(Object obj) {
            return ((AccessibilityNodeInfo.RangeInfo) obj).getType();
        }
    }

    AccessibilityNodeInfoCompatKitKat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object getCollectionInfo(Object obj) {
        return ((AccessibilityNodeInfo) obj).getCollectionInfo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object getCollectionItemInfo(Object obj) {
        return ((AccessibilityNodeInfo) obj).getCollectionItemInfo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getLiveRegion(Object obj) {
        return ((AccessibilityNodeInfo) obj).getLiveRegion();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object getRangeInfo(Object obj) {
        return ((AccessibilityNodeInfo) obj).getRangeInfo();
    }

    public static Object obtainCollectionInfo(int i3, int i16, boolean z16, int i17) {
        return AccessibilityNodeInfo.CollectionInfo.obtain(i3, i16, z16);
    }

    public static Object obtainCollectionItemInfo(int i3, int i16, int i17, int i18, boolean z16) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain(i3, i16, i17, i18, z16);
    }

    public static void setCollectionInfo(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) obj2);
    }

    public static void setCollectionItemInfo(Object obj, Object obj2) {
        ((AccessibilityNodeInfo) obj).setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLiveRegion(Object obj, int i3) {
        ((AccessibilityNodeInfo) obj).setLiveRegion(i3);
    }
}
