package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SavedStateViewModelFactory extends ViewModelProvider.KeyedFactory {
    private static final Class<?>[] ANDROID_VIEWMODEL_SIGNATURE = {Application.class, SavedStateHandle.class};
    private static final Class<?>[] VIEWMODEL_SIGNATURE = {SavedStateHandle.class};
    private final Application mApplication;
    private final Bundle mDefaultArgs;
    private final ViewModelProvider.Factory mFactory;
    private final Lifecycle mLifecycle;
    private final SavedStateRegistry mSavedStateRegistry;

    public SavedStateViewModelFactory(@Nullable Application application, @NonNull SavedStateRegistryOwner savedStateRegistryOwner) {
        this(application, savedStateRegistryOwner, null);
    }

    private static <T> Constructor<T> findMatchingConstructor(Class<T> cls, Class<?>[] clsArr) {
        for (Object obj : cls.getConstructors()) {
            Constructor<T> constructor = (Constructor<T>) obj;
            if (Arrays.equals(clsArr, constructor.getParameterTypes())) {
                return constructor;
            }
        }
        return null;
    }

    @Override // androidx.lifecycle.ViewModelProvider.KeyedFactory
    @NonNull
    public <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls) {
        Constructor findMatchingConstructor;
        T t16;
        boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
        if (isAssignableFrom && this.mApplication != null) {
            findMatchingConstructor = findMatchingConstructor(cls, ANDROID_VIEWMODEL_SIGNATURE);
        } else {
            findMatchingConstructor = findMatchingConstructor(cls, VIEWMODEL_SIGNATURE);
        }
        if (findMatchingConstructor == null) {
            return (T) this.mFactory.create(cls);
        }
        SavedStateHandleController create = SavedStateHandleController.create(this.mSavedStateRegistry, this.mLifecycle, str, this.mDefaultArgs);
        if (isAssignableFrom) {
            try {
                Application application = this.mApplication;
                if (application != null) {
                    t16 = (T) findMatchingConstructor.newInstance(application, create.getHandle());
                    t16.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", create);
                    return t16;
                }
            } catch (IllegalAccessException e16) {
                throw new RuntimeException("Failed to access " + cls, e16);
            } catch (InstantiationException e17) {
                throw new RuntimeException("A " + cls + " cannot be instantiated.", e17);
            } catch (InvocationTargetException e18) {
                throw new RuntimeException("An exception happened in constructor of " + cls, e18.getCause());
            }
        }
        t16 = (T) findMatchingConstructor.newInstance(create.getHandle());
        t16.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", create);
        return t16;
    }

    @Override // androidx.lifecycle.ViewModelProvider.OnRequeryFactory
    void onRequery(@NonNull ViewModel viewModel) {
        SavedStateHandleController.attachHandleIfNeeded(viewModel, this.mSavedStateRegistry, this.mLifecycle);
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(@Nullable Application application, @NonNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
        ViewModelProvider.Factory newInstanceFactory;
        this.mSavedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.mLifecycle = savedStateRegistryOwner.getLifecycle();
        this.mDefaultArgs = bundle;
        this.mApplication = application;
        if (application != null) {
            newInstanceFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application);
        } else {
            newInstanceFactory = ViewModelProvider.NewInstanceFactory.getInstance();
        }
        this.mFactory = newInstanceFactory;
    }

    @Override // androidx.lifecycle.ViewModelProvider.KeyedFactory, androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) create(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
