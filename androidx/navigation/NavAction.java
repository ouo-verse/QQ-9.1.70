package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NavAction {
    private Bundle mDefaultArguments;

    @IdRes
    private final int mDestinationId;
    private NavOptions mNavOptions;

    public NavAction(@IdRes int i3) {
        this(i3, null);
    }

    @Nullable
    public Bundle getDefaultArguments() {
        return this.mDefaultArguments;
    }

    public int getDestinationId() {
        return this.mDestinationId;
    }

    @Nullable
    public NavOptions getNavOptions() {
        return this.mNavOptions;
    }

    public void setDefaultArguments(@Nullable Bundle bundle) {
        this.mDefaultArguments = bundle;
    }

    public void setNavOptions(@Nullable NavOptions navOptions) {
        this.mNavOptions = navOptions;
    }

    public NavAction(@IdRes int i3, @Nullable NavOptions navOptions) {
        this(i3, navOptions, null);
    }

    public NavAction(@IdRes int i3, @Nullable NavOptions navOptions, @Nullable Bundle bundle) {
        this.mDestinationId = i3;
        this.mNavOptions = navOptions;
        this.mDefaultArguments = bundle;
    }
}
