package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* compiled from: P */
@Deprecated
/* loaded from: classes.dex */
public class ViewModelStores {
    ViewModelStores() {
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelStore of(@NonNull FragmentActivity fragmentActivity) {
        return fragmentActivity.get_viewModelStore();
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelStore of(@NonNull Fragment fragment) {
        return fragment.get_viewModelStore();
    }
}
