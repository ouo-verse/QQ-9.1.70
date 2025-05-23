package androidx.core.view;

import android.os.Build;
import android.view.WindowInsetsAnimationController;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;
import com.tencent.mapsdk.internal.by;

/* compiled from: P */
/* loaded from: classes.dex */
public final class WindowInsetsAnimationControllerCompat {
    private final Impl mImpl;

    /* compiled from: P */
    @RequiresApi(30)
    /* loaded from: classes.dex */
    private static class Impl30 extends Impl {
        private final WindowInsetsAnimationController mController;

        Impl30(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
            this.mController = windowInsetsAnimationController;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        void finish(boolean z16) {
            this.mController.finish(z16);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public float getCurrentAlpha() {
            float currentAlpha;
            currentAlpha = this.mController.getCurrentAlpha();
            return currentAlpha;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public float getCurrentFraction() {
            float currentFraction;
            currentFraction = this.mController.getCurrentFraction();
            return currentFraction;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        @NonNull
        public Insets getCurrentInsets() {
            android.graphics.Insets currentInsets;
            currentInsets = this.mController.getCurrentInsets();
            return Insets.toCompatInsets(currentInsets);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        @NonNull
        public Insets getHiddenStateInsets() {
            android.graphics.Insets hiddenStateInsets;
            hiddenStateInsets = this.mController.getHiddenStateInsets();
            return Insets.toCompatInsets(hiddenStateInsets);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        @NonNull
        public Insets getShownStateInsets() {
            android.graphics.Insets shownStateInsets;
            shownStateInsets = this.mController.getShownStateInsets();
            return Insets.toCompatInsets(shownStateInsets);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public int getTypes() {
            int types;
            types = this.mController.getTypes();
            return types;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        boolean isCancelled() {
            boolean isCancelled;
            isCancelled = this.mController.isCancelled();
            return isCancelled;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        boolean isFinished() {
            boolean isFinished;
            isFinished = this.mController.isFinished();
            return isFinished;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public boolean isReady() {
            boolean isReady;
            isReady = this.mController.isReady();
            return isReady;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public void setInsetsAndAlpha(@Nullable Insets insets, float f16, float f17) {
            android.graphics.Insets platformInsets;
            WindowInsetsAnimationController windowInsetsAnimationController = this.mController;
            if (insets == null) {
                platformInsets = null;
            } else {
                platformInsets = insets.toPlatformInsets();
            }
            windowInsetsAnimationController.setInsetsAndAlpha(platformInsets, f16, f17);
        }
    }

    WindowInsetsAnimationControllerCompat() {
        if (Build.VERSION.SDK_INT < 30) {
            this.mImpl = new Impl();
            return;
        }
        throw new UnsupportedOperationException("On API 30+, the constructor taking a " + WindowInsetsAnimationController.class.getSimpleName() + " as parameter");
    }

    public void finish(boolean z16) {
        this.mImpl.finish(z16);
    }

    public float getCurrentAlpha() {
        return this.mImpl.getCurrentAlpha();
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float getCurrentFraction() {
        return this.mImpl.getCurrentFraction();
    }

    @NonNull
    public Insets getCurrentInsets() {
        return this.mImpl.getCurrentInsets();
    }

    @NonNull
    public Insets getHiddenStateInsets() {
        return this.mImpl.getHiddenStateInsets();
    }

    @NonNull
    public Insets getShownStateInsets() {
        return this.mImpl.getShownStateInsets();
    }

    public int getTypes() {
        return this.mImpl.getTypes();
    }

    public boolean isCancelled() {
        return this.mImpl.isCancelled();
    }

    public boolean isFinished() {
        return this.mImpl.isFinished();
    }

    public boolean isReady() {
        if (!isFinished() && !isCancelled()) {
            return true;
        }
        return false;
    }

    public void setInsetsAndAlpha(@Nullable Insets insets, @FloatRange(from = 0.0d, to = 1.0d) float f16, @FloatRange(from = 0.0d, to = 1.0d) float f17) {
        this.mImpl.setInsetsAndAlpha(insets, f16, f17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RequiresApi(30)
    public WindowInsetsAnimationControllerCompat(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mImpl = new Impl30(windowInsetsAnimationController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Impl {
        Impl() {
        }

        public float getCurrentAlpha() {
            return 0.0f;
        }

        @FloatRange(from = 0.0d, to = by.f147964a)
        public float getCurrentFraction() {
            return 0.0f;
        }

        @NonNull
        public Insets getCurrentInsets() {
            return Insets.NONE;
        }

        @NonNull
        public Insets getHiddenStateInsets() {
            return Insets.NONE;
        }

        @NonNull
        public Insets getShownStateInsets() {
            return Insets.NONE;
        }

        public int getTypes() {
            return 0;
        }

        boolean isCancelled() {
            return true;
        }

        boolean isFinished() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        void finish(boolean z16) {
        }

        public void setInsetsAndAlpha(@Nullable Insets insets, @FloatRange(from = 0.0d, to = 1.0d) float f16, @FloatRange(from = 0.0d, to = 1.0d) float f17) {
        }
    }
}
