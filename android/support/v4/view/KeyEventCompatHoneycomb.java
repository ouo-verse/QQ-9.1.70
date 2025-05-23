package android.support.v4.view;

import android.view.KeyEvent;

/* compiled from: P */
/* loaded from: classes.dex */
class KeyEventCompatHoneycomb {
    KeyEventCompatHoneycomb() {
    }

    public static boolean metaStateHasModifiers(int i3, int i16) {
        return KeyEvent.metaStateHasModifiers(i3, i16);
    }

    public static boolean metaStateHasNoModifiers(int i3) {
        return KeyEvent.metaStateHasNoModifiers(i3);
    }

    public static int normalizeMetaState(int i3) {
        return KeyEvent.normalizeMetaState(i3);
    }
}
