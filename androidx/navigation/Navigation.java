package androidx.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Navigation {
    Navigation() {
    }

    @NonNull
    public static View.OnClickListener createNavigateOnClickListener(@IdRes int i3) {
        return createNavigateOnClickListener(i3, null);
    }

    @NonNull
    public static NavController findNavController(@NonNull Activity activity, @IdRes int i3) {
        NavController findViewNavController = findViewNavController(ActivityCompat.requireViewById(activity, i3));
        if (findViewNavController != null) {
            return findViewNavController;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i3);
    }

    @Nullable
    private static NavController findViewNavController(@NonNull View view) {
        while (view != null) {
            NavController viewNavController = getViewNavController(view);
            if (viewNavController != null) {
                return viewNavController;
            }
            Object parent = view.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
        }
        return null;
    }

    @Nullable
    private static NavController getViewNavController(@NonNull View view) {
        Object tag = view.getTag(com.tencent.mobileqq.R.id.zm_);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }

    public static void setViewNavController(@NonNull View view, @Nullable NavController navController) {
        view.setTag(com.tencent.mobileqq.R.id.zm_, navController);
    }

    @NonNull
    public static View.OnClickListener createNavigateOnClickListener(@IdRes final int i3, @Nullable final Bundle bundle) {
        return new View.OnClickListener() { // from class: androidx.navigation.Navigation.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                Navigation.findNavController(view).navigate(i3, bundle);
                EventCollector.getInstance().onViewClicked(view);
            }
        };
    }

    @NonNull
    public static View.OnClickListener createNavigateOnClickListener(@NonNull final NavDirections navDirections) {
        return new View.OnClickListener() { // from class: androidx.navigation.Navigation.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                Navigation.findNavController(view).navigate(NavDirections.this);
                EventCollector.getInstance().onViewClicked(view);
            }
        };
    }

    @NonNull
    public static NavController findNavController(@NonNull View view) {
        NavController findViewNavController = findViewNavController(view);
        if (findViewNavController != null) {
            return findViewNavController;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }
}
