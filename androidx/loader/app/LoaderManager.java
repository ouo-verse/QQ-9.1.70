package androidx.loader.app;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class LoaderManager {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface LoaderCallbacks<D> {
        @NonNull
        @MainThread
        Loader<D> onCreateLoader(int i3, @Nullable Bundle bundle);

        @MainThread
        void onLoadFinished(@NonNull Loader<D> loader, D d16);

        @MainThread
        void onLoaderReset(@NonNull Loader<D> loader);
    }

    public static void enableDebugLogging(boolean z16) {
        LoaderManagerImpl.DEBUG = z16;
    }

    @NonNull
    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager getInstance(@NonNull T t16) {
        return new LoaderManagerImpl(t16, t16.get_viewModelStore());
    }

    @MainThread
    public abstract void destroyLoader(int i3);

    @Deprecated
    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @Nullable
    public abstract <D> Loader<D> getLoader(int i3);

    public boolean hasRunningLoaders() {
        return false;
    }

    @NonNull
    @MainThread
    public abstract <D> Loader<D> initLoader(int i3, @Nullable Bundle bundle, @NonNull LoaderCallbacks<D> loaderCallbacks);

    public abstract void markForRedelivery();

    @NonNull
    @MainThread
    public abstract <D> Loader<D> restartLoader(int i3, @Nullable Bundle bundle, @NonNull LoaderCallbacks<D> loaderCallbacks);
}
