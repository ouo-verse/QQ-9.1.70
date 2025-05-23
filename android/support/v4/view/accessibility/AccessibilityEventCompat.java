package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AccessibilityEventCompat {
    public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4;
    public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1;
    public static final int CONTENT_CHANGE_TYPE_TEXT = 2;
    public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0;
    private static final AccessibilityEventVersionImpl IMPL = new AccessibilityEventKitKatImpl();
    public static final int TYPES_ALL_MASK = -1;
    public static final int TYPE_ANNOUNCEMENT = 16384;
    public static final int TYPE_GESTURE_DETECTION_END = 524288;
    public static final int TYPE_GESTURE_DETECTION_START = 262144;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
    public static final int TYPE_TOUCH_INTERACTION_END = 2097152;
    public static final int TYPE_TOUCH_INTERACTION_START = 1048576;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
    public static final int TYPE_VIEW_HOVER_ENTER = 128;
    public static final int TYPE_VIEW_HOVER_EXIT = 256;
    public static final int TYPE_VIEW_SCROLLED = 4096;
    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
    public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class AccessibilityEventIcsImpl extends AccessibilityEventStubImpl {
        AccessibilityEventIcsImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventStubImpl, android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventVersionImpl
        public void appendRecord(AccessibilityEvent accessibilityEvent, Object obj) {
            AccessibilityEventCompatIcs.appendRecord(accessibilityEvent, obj);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventStubImpl, android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventVersionImpl
        public Object getRecord(AccessibilityEvent accessibilityEvent, int i3) {
            return AccessibilityEventCompatIcs.getRecord(accessibilityEvent, i3);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventStubImpl, android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventVersionImpl
        public int getRecordCount(AccessibilityEvent accessibilityEvent) {
            return AccessibilityEventCompatIcs.getRecordCount(accessibilityEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class AccessibilityEventKitKatImpl extends AccessibilityEventIcsImpl {
        AccessibilityEventKitKatImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventStubImpl, android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventVersionImpl
        public int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
            return AccessibilityEventCompatKitKat.getContentChangeTypes(accessibilityEvent);
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventStubImpl, android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventVersionImpl
        public void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i3) {
            AccessibilityEventCompatKitKat.setContentChangeTypes(accessibilityEvent, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface AccessibilityEventVersionImpl {
        void appendRecord(AccessibilityEvent accessibilityEvent, Object obj);

        int getContentChangeTypes(AccessibilityEvent accessibilityEvent);

        Object getRecord(AccessibilityEvent accessibilityEvent, int i3);

        int getRecordCount(AccessibilityEvent accessibilityEvent);

        void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i3);
    }

    AccessibilityEventCompat() {
    }

    public static void appendRecord(AccessibilityEvent accessibilityEvent, AccessibilityRecordCompat accessibilityRecordCompat) {
        IMPL.appendRecord(accessibilityEvent, accessibilityRecordCompat.getImpl());
    }

    public static AccessibilityRecordCompat asRecord(AccessibilityEvent accessibilityEvent) {
        return new AccessibilityRecordCompat(accessibilityEvent);
    }

    public static int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
        return IMPL.getContentChangeTypes(accessibilityEvent);
    }

    public static AccessibilityRecordCompat getRecord(AccessibilityEvent accessibilityEvent, int i3) {
        return new AccessibilityRecordCompat(IMPL.getRecord(accessibilityEvent, i3));
    }

    public static int getRecordCount(AccessibilityEvent accessibilityEvent) {
        return IMPL.getRecordCount(accessibilityEvent);
    }

    public static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i3) {
        IMPL.setContentChangeTypes(accessibilityEvent, i3);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class AccessibilityEventStubImpl implements AccessibilityEventVersionImpl {
        AccessibilityEventStubImpl() {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventVersionImpl
        public int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventVersionImpl
        public Object getRecord(AccessibilityEvent accessibilityEvent, int i3) {
            return null;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventVersionImpl
        public int getRecordCount(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventVersionImpl
        public void appendRecord(AccessibilityEvent accessibilityEvent, Object obj) {
        }

        @Override // android.support.v4.view.accessibility.AccessibilityEventCompat.AccessibilityEventVersionImpl
        public void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i3) {
        }
    }
}
