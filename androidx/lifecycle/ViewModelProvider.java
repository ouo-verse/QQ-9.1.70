package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class ViewModelProvider {
    private static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
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

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class KeyedFactory extends OnRequeryFactory implements Factory {
        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        @NonNull
        public abstract <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls);
    }

    /* loaded from: classes.dex */
    public static class NewInstanceFactory implements Factory {
        private static NewInstanceFactory sInstance;

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public static NewInstanceFactory getInstance() {
            if (sInstance == null) {
                sInstance = new NewInstanceFactory();
            }
            return sInstance;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
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

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ViewModelProvider(@NonNull ViewModelStoreOwner viewModelStoreOwner) {
        this(r0, r3);
        Factory newInstanceFactory;
        ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
        if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
            newInstanceFactory = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory();
        } else {
            newInstanceFactory = NewInstanceFactory.getInstance();
        }
    }

    @NonNull
    @MainThread
    public <T extends ViewModel> T get(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @NonNull
    @MainThread
    public <T extends ViewModel> T get(@NonNull String str, @NonNull Class<T> cls) {
        T t16;
        T t17 = (T) this.mViewModelStore.get(str);
        if (cls.isInstance(t17)) {
            Object obj = this.mFactory;
            if (obj instanceof OnRequeryFactory) {
                ((OnRequeryFactory) obj).onRequery(t17);
            }
            return t17;
        }
        Factory factory = this.mFactory;
        if (factory instanceof KeyedFactory) {
            t16 = (T) ((KeyedFactory) factory).create(str, cls);
        } else {
            t16 = (T) factory.create(cls);
        }
        this.mViewModelStore.put(str, t16);
        return t16;
    }

    public ViewModelProvider(@NonNull ViewModelStoreOwner viewModelStoreOwner, @NonNull Factory factory) {
        this(viewModelStoreOwner.getViewModelStore(), factory);
    }

    public ViewModelProvider(@NonNull ViewModelStore viewModelStore, @NonNull Factory factory) {
        this.mFactory = factory;
        this.mViewModelStore = viewModelStore;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class OnRequeryFactory {
        OnRequeryFactory() {
        }

        void onRequery(@NonNull ViewModel viewModel) {
        }
    }
}
