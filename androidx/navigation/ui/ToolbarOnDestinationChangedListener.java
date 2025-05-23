package androidx.navigation.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.transition.TransitionManager;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ToolbarOnDestinationChangedListener extends AbstractAppBarOnDestinationChangedListener {
    private final WeakReference<Toolbar> mToolbarWeakReference;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ToolbarOnDestinationChangedListener(@NonNull Toolbar toolbar, @NonNull AppBarConfiguration appBarConfiguration) {
        super(toolbar.getContext(), appBarConfiguration);
        this.mToolbarWeakReference = new WeakReference<>(toolbar);
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener, androidx.navigation.NavController.OnDestinationChangedListener
    public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
        if (this.mToolbarWeakReference.get() == null) {
            navController.removeOnDestinationChangedListener(this);
        } else {
            super.onDestinationChanged(navController, navDestination, bundle);
        }
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    protected void setNavigationIcon(Drawable drawable, @StringRes int i3) {
        boolean z16;
        Toolbar toolbar = this.mToolbarWeakReference.get();
        if (toolbar != null) {
            if (drawable == null && toolbar.getNavigationIcon() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            toolbar.setNavigationIcon(drawable);
            toolbar.setNavigationContentDescription(i3);
            if (z16) {
                TransitionManager.beginDelayedTransition(toolbar);
            }
        }
    }

    @Override // androidx.navigation.ui.AbstractAppBarOnDestinationChangedListener
    protected void setTitle(CharSequence charSequence) {
        this.mToolbarWeakReference.get().setTitle(charSequence);
    }
}
