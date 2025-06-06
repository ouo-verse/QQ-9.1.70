package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

@Deprecated
/* loaded from: classes.dex */
public class ViewModelProviders {

    @Deprecated
    /* loaded from: classes.dex */
    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        @Deprecated
        public DefaultFactory(@NonNull Application application) {
            super(application);
        }
    }

    @Deprecated
    public ViewModelProviders() {
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelProvider of(@NonNull Fragment fragment) {
        return new ViewModelProvider(fragment);
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelProvider of(@NonNull FragmentActivity fragmentActivity) {
        return new ViewModelProvider(fragmentActivity);
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelProvider of(@NonNull Fragment fragment, @Nullable ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = fragment.getDefaultViewModelProviderFactory();
        }
        return new ViewModelProvider(fragment.get_viewModelStore(), factory);
    }

    @NonNull
    @MainThread
    @Deprecated
    public static ViewModelProvider of(@NonNull FragmentActivity fragmentActivity, @Nullable ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = fragmentActivity.getDefaultViewModelProviderFactory();
        }
        return new ViewModelProvider(fragmentActivity.get_viewModelStore(), factory);
    }
}
