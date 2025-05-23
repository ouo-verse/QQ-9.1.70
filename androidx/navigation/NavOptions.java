package androidx.navigation;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NavOptions {

    @AnimRes
    @AnimatorRes
    private int mEnterAnim;

    @AnimRes
    @AnimatorRes
    private int mExitAnim;

    @AnimRes
    @AnimatorRes
    private int mPopEnterAnim;

    @AnimRes
    @AnimatorRes
    private int mPopExitAnim;

    @IdRes
    private int mPopUpTo;
    private boolean mPopUpToInclusive;
    private boolean mSingleTop;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class Builder {
        boolean mPopUpToInclusive;
        boolean mSingleTop;

        @IdRes
        int mPopUpTo = -1;

        @AnimRes
        @AnimatorRes
        int mEnterAnim = -1;

        @AnimRes
        @AnimatorRes
        int mExitAnim = -1;

        @AnimRes
        @AnimatorRes
        int mPopEnterAnim = -1;

        @AnimRes
        @AnimatorRes
        int mPopExitAnim = -1;

        @NonNull
        public NavOptions build() {
            return new NavOptions(this.mSingleTop, this.mPopUpTo, this.mPopUpToInclusive, this.mEnterAnim, this.mExitAnim, this.mPopEnterAnim, this.mPopExitAnim);
        }

        @NonNull
        public Builder setEnterAnim(@AnimRes @AnimatorRes int i3) {
            this.mEnterAnim = i3;
            return this;
        }

        @NonNull
        public Builder setExitAnim(@AnimRes @AnimatorRes int i3) {
            this.mExitAnim = i3;
            return this;
        }

        @NonNull
        public Builder setLaunchSingleTop(boolean z16) {
            this.mSingleTop = z16;
            return this;
        }

        @NonNull
        public Builder setPopEnterAnim(@AnimRes @AnimatorRes int i3) {
            this.mPopEnterAnim = i3;
            return this;
        }

        @NonNull
        public Builder setPopExitAnim(@AnimRes @AnimatorRes int i3) {
            this.mPopExitAnim = i3;
            return this;
        }

        @NonNull
        public Builder setPopUpTo(@IdRes int i3, boolean z16) {
            this.mPopUpTo = i3;
            this.mPopUpToInclusive = z16;
            return this;
        }
    }

    NavOptions(boolean z16, @IdRes int i3, boolean z17, @AnimRes @AnimatorRes int i16, @AnimRes @AnimatorRes int i17, @AnimRes @AnimatorRes int i18, @AnimRes @AnimatorRes int i19) {
        this.mSingleTop = z16;
        this.mPopUpTo = i3;
        this.mPopUpToInclusive = z17;
        this.mEnterAnim = i16;
        this.mExitAnim = i17;
        this.mPopEnterAnim = i18;
        this.mPopExitAnim = i19;
    }

    @AnimRes
    @AnimatorRes
    public int getEnterAnim() {
        return this.mEnterAnim;
    }

    @AnimRes
    @AnimatorRes
    public int getExitAnim() {
        return this.mExitAnim;
    }

    @AnimRes
    @AnimatorRes
    public int getPopEnterAnim() {
        return this.mPopEnterAnim;
    }

    @AnimRes
    @AnimatorRes
    public int getPopExitAnim() {
        return this.mPopExitAnim;
    }

    @IdRes
    public int getPopUpTo() {
        return this.mPopUpTo;
    }

    public boolean isPopUpToInclusive() {
        return this.mPopUpToInclusive;
    }

    public boolean shouldLaunchSingleTop() {
        return this.mSingleTop;
    }
}
