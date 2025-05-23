package android.support.v4.view;

import android.view.ViewConfiguration;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ViewConfigurationCompat {
    static final ViewConfigurationVersionImpl IMPL = new IcsViewConfigurationVersionImpl();

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        BaseViewConfigurationVersionImpl() {
        }

        @Override // android.support.v4.view.ViewConfigurationCompat.ViewConfigurationVersionImpl
        public int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }

        @Override // android.support.v4.view.ViewConfigurationCompat.ViewConfigurationVersionImpl
        public boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class FroyoViewConfigurationVersionImpl extends BaseViewConfigurationVersionImpl {
        FroyoViewConfigurationVersionImpl() {
        }

        @Override // android.support.v4.view.ViewConfigurationCompat.BaseViewConfigurationVersionImpl, android.support.v4.view.ViewConfigurationCompat.ViewConfigurationVersionImpl
        public int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
            return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(viewConfiguration);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class HoneycombViewConfigurationVersionImpl extends FroyoViewConfigurationVersionImpl {
        HoneycombViewConfigurationVersionImpl() {
        }

        @Override // android.support.v4.view.ViewConfigurationCompat.BaseViewConfigurationVersionImpl, android.support.v4.view.ViewConfigurationCompat.ViewConfigurationVersionImpl
        public boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class IcsViewConfigurationVersionImpl extends HoneycombViewConfigurationVersionImpl {
        IcsViewConfigurationVersionImpl() {
        }

        @Override // android.support.v4.view.ViewConfigurationCompat.HoneycombViewConfigurationVersionImpl, android.support.v4.view.ViewConfigurationCompat.BaseViewConfigurationVersionImpl, android.support.v4.view.ViewConfigurationCompat.ViewConfigurationVersionImpl
        public boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
            return ViewConfigurationCompatICS.hasPermanentMenuKey(viewConfiguration);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    interface ViewConfigurationVersionImpl {
        int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration);

        boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration);
    }

    ViewConfigurationCompat() {
    }

    public static int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
        return IMPL.getScaledPagingTouchSlop(viewConfiguration);
    }

    public static boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
        return IMPL.hasPermanentMenuKey(viewConfiguration);
    }
}
