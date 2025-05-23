package android.arch.lifecycle;

import android.app.Application;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ViewModelProvider {
    private static final String DEFAULT_KEY = "android.arch.lifecycle.ViewModelProvider.DefaultKey";
    private final Factory mFactory;
    private final ViewModelStore mViewModelStore;

    /* loaded from: classes.dex */
    public static class AndroidViewModelFactory extends NewInstanceFactory {
        private static AndroidViewModelFactory sInstance;
        private Application mApplication;

        public AndroidViewModelFactory(@NonNull Application application) {
            this.mApplication = application;
        }

        @NonNull
        public static AndroidViewModelFactory getInstance(@NonNull Application application) {
            if (sInstance == null) {
                sInstance = new AndroidViewModelFactory(application);
            }
            return sInstance;
        }

        @Override // android.arch.lifecycle.ViewModelProvider.NewInstanceFactory, android.arch.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            if (AndroidViewModel.class.isAssignableFrom(cls)) {
                try {
                    return cls.getConstructor(Application.class).newInstance(this.mApplication);
                } catch (IllegalAccessException e16) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e16);
                } catch (InstantiationException e17) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e17);
                } catch (NoSuchMethodException e18) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e18);
                } catch (InvocationTargetException e19) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e19);
                }
            }
            return (T) super.create(cls);
        }
    }

    /* loaded from: classes.dex */
    public interface Factory {
        @NonNull
        <T extends ViewModel> T create(@NonNull Class<T> cls);
    }

    /* loaded from: classes.dex */
    public static class NewInstanceFactory implements Factory {
        @Override // android.arch.lifecycle.ViewModelProvider.Factory
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e16) {
                throw new RuntimeException("Cannot create an instance of " + cls, e16);
            } catch (InstantiationException e17) {
                throw new RuntimeException("Cannot create an instance of " + cls, e17);
            }
        }
    }

    public ViewModelProvider(@NonNull ViewModelStore viewModelStore, @NonNull Factory factory) {
        this.mFactory = factory;
        this.mViewModelStore = viewModelStore;
    }

    @NonNull
    @MainThread
    public <T extends ViewModel> T get(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) get("android.arch.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public ViewModelProvider(@NonNull ViewModelStoreOwner viewModelStoreOwner, @NonNull Factory factory) {
        this(viewModelStoreOwner.getViewModelStore(), factory);
    }

    @NonNull
    @MainThread
    public <T extends ViewModel> T get(@NonNull String str, @NonNull Class<T> cls) {
        T t16 = (T) this.mViewModelStore.get(str);
        if (cls.isInstance(t16)) {
            return t16;
        }
        T t17 = (T) this.mFactory.create(cls);
        this.mViewModelStore.put(str, t17);
        return t17;
    }
}
