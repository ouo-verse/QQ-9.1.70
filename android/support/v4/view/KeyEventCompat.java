package android.support.v4.view;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes.dex */
public final class KeyEventCompat {
    static final KeyEventVersionImpl IMPL = new HoneycombKeyEventVersionImpl();

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class EclairKeyEventVersionImpl extends BaseKeyEventVersionImpl {
        EclairKeyEventVersionImpl() {
        }

        @Override // android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl, android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean dispatch(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2) {
            return KeyEventCompatEclair.dispatch(keyEvent, callback, obj, obj2);
        }

        @Override // android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl, android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public Object getKeyDispatcherState(View view) {
            return KeyEventCompatEclair.getKeyDispatcherState(view);
        }

        @Override // android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl, android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean isTracking(KeyEvent keyEvent) {
            return KeyEventCompatEclair.isTracking(keyEvent);
        }

        @Override // android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl, android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public void startTracking(KeyEvent keyEvent) {
            KeyEventCompatEclair.startTracking(keyEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class HoneycombKeyEventVersionImpl extends EclairKeyEventVersionImpl {
        HoneycombKeyEventVersionImpl() {
        }

        @Override // android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl, android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasModifiers(int i3, int i16) {
            return KeyEventCompatHoneycomb.metaStateHasModifiers(i3, i16);
        }

        @Override // android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl, android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasNoModifiers(int i3) {
            return KeyEventCompatHoneycomb.metaStateHasNoModifiers(i3);
        }

        @Override // android.support.v4.view.KeyEventCompat.BaseKeyEventVersionImpl, android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public int normalizeMetaState(int i3) {
            return KeyEventCompatHoneycomb.normalizeMetaState(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    interface KeyEventVersionImpl {
        boolean dispatch(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2);

        Object getKeyDispatcherState(View view);

        boolean isTracking(KeyEvent keyEvent);

        boolean metaStateHasModifiers(int i3, int i16);

        boolean metaStateHasNoModifiers(int i3);

        int normalizeMetaState(int i3);

        void startTracking(KeyEvent keyEvent);
    }

    KeyEventCompat() {
    }

    public static boolean dispatch(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2) {
        return IMPL.dispatch(keyEvent, callback, obj, obj2);
    }

    public static Object getKeyDispatcherState(View view) {
        return IMPL.getKeyDispatcherState(view);
    }

    public static boolean hasModifiers(KeyEvent keyEvent, int i3) {
        return IMPL.metaStateHasModifiers(keyEvent.getMetaState(), i3);
    }

    public static boolean hasNoModifiers(KeyEvent keyEvent) {
        return IMPL.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public static boolean isTracking(KeyEvent keyEvent) {
        return IMPL.isTracking(keyEvent);
    }

    public static boolean metaStateHasModifiers(int i3, int i16) {
        return IMPL.metaStateHasModifiers(i3, i16);
    }

    public static boolean metaStateHasNoModifiers(int i3) {
        return IMPL.metaStateHasNoModifiers(i3);
    }

    public static int normalizeMetaState(int i3) {
        return IMPL.normalizeMetaState(i3);
    }

    public static void startTracking(KeyEvent keyEvent) {
        IMPL.startTracking(keyEvent);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class BaseKeyEventVersionImpl implements KeyEventVersionImpl {
        private static final int META_ALL_MASK = 247;
        private static final int META_MODIFIER_MASK = 247;

        BaseKeyEventVersionImpl() {
        }

        private static int metaStateFilterDirectionalModifiers(int i3, int i16, int i17, int i18, int i19) {
            boolean z16;
            int i26;
            boolean z17 = true;
            if ((i16 & i17) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i27 = i18 | i19;
            if ((i16 & i27) == 0) {
                z17 = false;
            }
            if (z16) {
                if (!z17) {
                    i26 = ~i27;
                } else {
                    throw new IllegalArgumentException("bad arguments");
                }
            } else if (z17) {
                i26 = ~i17;
            } else {
                return i3;
            }
            return i3 & i26;
        }

        @Override // android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean dispatch(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2) {
            return keyEvent.dispatch(callback);
        }

        @Override // android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public Object getKeyDispatcherState(View view) {
            return null;
        }

        @Override // android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean isTracking(KeyEvent keyEvent) {
            return false;
        }

        @Override // android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasModifiers(int i3, int i16) {
            if (metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(normalizeMetaState(i3) & 247, i16, 1, 64, 128), i16, 2, 16, 32) == i16) {
                return true;
            }
            return false;
        }

        @Override // android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public boolean metaStateHasNoModifiers(int i3) {
            if ((normalizeMetaState(i3) & 247) == 0) {
                return true;
            }
            return false;
        }

        @Override // android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public int normalizeMetaState(int i3) {
            if ((i3 & 192) != 0) {
                i3 |= 1;
            }
            if ((i3 & 48) != 0) {
                i3 |= 2;
            }
            return i3 & 247;
        }

        @Override // android.support.v4.view.KeyEventCompat.KeyEventVersionImpl
        public void startTracking(KeyEvent keyEvent) {
        }
    }
}
