package androidx.savedstate;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ViewTreeSavedStateRegistryOwner {
    ViewTreeSavedStateRegistryOwner() {
    }

    @Nullable
    public static SavedStateRegistryOwner get(@NonNull View view) {
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) view.getTag(com.tencent.mobileqq.R.id.f11957778);
        if (savedStateRegistryOwner != null) {
            return savedStateRegistryOwner;
        }
        Object parent = view.getParent();
        while (savedStateRegistryOwner == null && (parent instanceof View)) {
            View view2 = (View) parent;
            savedStateRegistryOwner = (SavedStateRegistryOwner) view2.getTag(com.tencent.mobileqq.R.id.f11957778);
            parent = view2.getParent();
        }
        return savedStateRegistryOwner;
    }

    public static void set(@NonNull View view, @Nullable SavedStateRegistryOwner savedStateRegistryOwner) {
        view.setTag(com.tencent.mobileqq.R.id.f11957778, savedStateRegistryOwner);
    }
}
