package androidx.core.view;

import android.R;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;

/* compiled from: P */
/* loaded from: classes.dex */
public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final Impl mImpl;

    /* compiled from: P */
    @RequiresApi(23)
    /* loaded from: classes.dex */
    private static class Impl23 extends Impl20 {
        Impl23(@NonNull Window window, @Nullable View view) {
            super(window, view);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            if ((this.mWindow.getDecorView().getSystemUiVisibility() & 8192) != 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean z16) {
            if (z16) {
                unsetWindowFlag(67108864);
                setWindowFlag(Integer.MIN_VALUE);
                setSystemUiFlag(8192);
                return;
            }
            unsetSystemUiFlag(8192);
        }
    }

    /* compiled from: P */
    @RequiresApi(26)
    /* loaded from: classes.dex */
    private static class Impl26 extends Impl23 {
        Impl26(@NonNull Window window, @Nullable View view) {
            super(window, view);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            if ((this.mWindow.getDecorView().getSystemUiVisibility() & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean z16) {
            if (z16) {
                unsetWindowFlag(134217728);
                setWindowFlag(Integer.MIN_VALUE);
                setSystemUiFlag(16);
                return;
            }
            unsetSystemUiFlag(16);
        }
    }

    /* compiled from: P */
    @RequiresApi(30)
    /* loaded from: classes.dex */
    private static class Impl30 extends Impl {
        final WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> mListeners;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        Impl30(@NonNull Window window, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this(r1, windowInsetsControllerCompat);
            WindowInsetsController insetsController;
            insetsController = window.getInsetsController();
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(@NonNull final OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            if (this.mListeners.containsKey(onControllableInsetsChangedListener)) {
                return;
            }
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener2 = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.WindowInsetsControllerCompat.Impl30.2
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public void onControllableInsetsChanged(@NonNull WindowInsetsController windowInsetsController, int i3) {
                    Impl30 impl30 = Impl30.this;
                    if (impl30.mInsetsController == windowInsetsController) {
                        onControllableInsetsChangedListener.onControllableInsetsChanged(impl30.mCompatController, i3);
                    }
                }
            };
            this.mListeners.put(onControllableInsetsChangedListener, onControllableInsetsChangedListener2);
            this.mInsetsController.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener2);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int i3, long j3, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull final WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
            this.mInsetsController.controlWindowInsetsAnimation(i3, j3, interpolator, cancellationSignal, new WindowInsetsAnimationControlListener() { // from class: androidx.core.view.WindowInsetsControllerCompat.Impl30.1
                private WindowInsetsAnimationControllerCompat mCompatAnimController = null;

                @Override // android.view.WindowInsetsAnimationControlListener
                public void onCancelled(@Nullable WindowInsetsAnimationController windowInsetsAnimationController) {
                    WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat;
                    WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat2 = windowInsetsAnimationControlListenerCompat;
                    if (windowInsetsAnimationController == null) {
                        windowInsetsAnimationControllerCompat = null;
                    } else {
                        windowInsetsAnimationControllerCompat = this.mCompatAnimController;
                    }
                    windowInsetsAnimationControlListenerCompat2.onCancelled(windowInsetsAnimationControllerCompat);
                }

                @Override // android.view.WindowInsetsAnimationControlListener
                public void onFinished(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
                    windowInsetsAnimationControlListenerCompat.onFinished(this.mCompatAnimController);
                }

                @Override // android.view.WindowInsetsAnimationControlListener
                public void onReady(@NonNull WindowInsetsAnimationController windowInsetsAnimationController, int i16) {
                    WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                    this.mCompatAnimController = windowInsetsAnimationControllerCompat;
                    windowInsetsAnimationControlListenerCompat.onReady(windowInsetsAnimationControllerCompat, i16);
                }
            });
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        int getSystemBarsBehavior() {
            int systemBarsBehavior;
            systemBarsBehavior = this.mInsetsController.getSystemBarsBehavior();
            return systemBarsBehavior;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void hide(int i3) {
            this.mInsetsController.hide(i3);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            int systemBarsAppearance;
            systemBarsAppearance = this.mInsetsController.getSystemBarsAppearance();
            if ((systemBarsAppearance & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            int systemBarsAppearance;
            systemBarsAppearance = this.mInsetsController.getSystemBarsAppearance();
            if ((systemBarsAppearance & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            WindowInsetsController.OnControllableInsetsChangedListener remove = this.mListeners.remove(onControllableInsetsChangedListener);
            if (remove != null) {
                this.mInsetsController.removeOnControllableInsetsChangedListener(remove);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean z16) {
            if (z16) {
                this.mInsetsController.setSystemBarsAppearance(16, 16);
            } else {
                this.mInsetsController.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean z16) {
            if (z16) {
                this.mInsetsController.setSystemBarsAppearance(8, 8);
            } else {
                this.mInsetsController.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void setSystemBarsBehavior(int i3) {
            this.mInsetsController.setSystemBarsBehavior(i3);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void show(int i3) {
            this.mInsetsController.show(i3);
        }

        Impl30(@NonNull WindowInsetsController windowInsetsController, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat) {
            this.mListeners = new SimpleArrayMap<>();
            this.mInsetsController = windowInsetsController;
            this.mCompatController = windowInsetsControllerCompat;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(@NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, int i3);
    }

    @RequiresApi(30)
    WindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(windowInsetsController, this);
        } else {
            this.mImpl = new Impl();
        }
    }

    @NonNull
    @RequiresApi(30)
    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public void addOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    public void controlWindowInsetsAnimation(int i3, long j3, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.mImpl.controlWindowInsetsAnimation(i3, j3, interpolator, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void hide(int i3) {
        this.mImpl.hide(i3);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    public void setAppearanceLightNavigationBars(boolean z16) {
        this.mImpl.setAppearanceLightNavigationBars(z16);
    }

    public void setAppearanceLightStatusBars(boolean z16) {
        this.mImpl.setAppearanceLightStatusBars(z16);
    }

    public void setSystemBarsBehavior(int i3) {
        this.mImpl.setSystemBarsBehavior(i3);
    }

    public void show(int i3) {
        this.mImpl.show(i3);
    }

    public WindowInsetsControllerCompat(@NonNull Window window, @NonNull View view) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            this.mImpl = new Impl30(window, this);
        } else if (i3 >= 26) {
            this.mImpl = new Impl26(window, view);
        } else {
            this.mImpl = new Impl23(window, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Impl {
        Impl() {
        }

        int getSystemBarsBehavior() {
            return 0;
        }

        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        void hide(int i3) {
        }

        void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        public void setAppearanceLightNavigationBars(boolean z16) {
        }

        public void setAppearanceLightStatusBars(boolean z16) {
        }

        void setSystemBarsBehavior(int i3) {
        }

        void show(int i3) {
        }

        void controlWindowInsetsAnimation(int i3, long j3, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }
    }

    /* compiled from: P */
    @RequiresApi(20)
    /* loaded from: classes.dex */
    private static class Impl20 extends Impl {

        @Nullable
        private final View mView;

        @NonNull
        protected final Window mWindow;

        Impl20(@NonNull Window window, @Nullable View view) {
            this.mWindow = window;
            this.mView = view;
        }

        private void hideForType(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        ((InputMethodManager) this.mWindow.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.mWindow.getDecorView().getWindowToken(), 0);
                        return;
                    }
                    return;
                }
                setSystemUiFlag(2);
                return;
            }
            setSystemUiFlag(4);
        }

        private void showForType(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        final View view = this.mView;
                        if (view != null && (view.isInEditMode() || view.onCheckIsTextEditor())) {
                            view.requestFocus();
                        } else {
                            view = this.mWindow.getCurrentFocus();
                        }
                        if (view == null) {
                            view = this.mWindow.findViewById(R.id.content);
                        }
                        if (view != null && view.hasWindowFocus()) {
                            view.post(new Runnable() { // from class: androidx.core.view.WindowInsetsControllerCompat.Impl20.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(view, 0);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                }
                unsetSystemUiFlag(2);
                return;
            }
            unsetSystemUiFlag(4);
            unsetWindowFlag(1024);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        int getSystemBarsBehavior() {
            return 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void hide(int i3) {
            for (int i16 = 1; i16 <= 256; i16 <<= 1) {
                if ((i3 & i16) != 0) {
                    hideForType(i16);
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void setSystemBarsBehavior(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        unsetSystemUiFlag(2048);
                        setSystemUiFlag(4096);
                        return;
                    }
                    return;
                }
                unsetSystemUiFlag(4096);
                setSystemUiFlag(2048);
                return;
            }
            unsetSystemUiFlag(6144);
        }

        protected void setSystemUiFlag(int i3) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(i3 | decorView.getSystemUiVisibility());
        }

        protected void setWindowFlag(int i3) {
            this.mWindow.addFlags(i3);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void show(int i3) {
            for (int i16 = 1; i16 <= 256; i16 <<= 1) {
                if ((i3 & i16) != 0) {
                    showForType(i16);
                }
            }
        }

        protected void unsetSystemUiFlag(int i3) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility((~i3) & decorView.getSystemUiVisibility());
        }

        protected void unsetWindowFlag(int i3) {
            this.mWindow.clearFlags(i3);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int i3, long j3, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }
    }
}
