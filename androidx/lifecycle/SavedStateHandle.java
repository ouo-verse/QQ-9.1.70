package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SavedStateHandle {
    private static final Class[] ACCEPTABLE_CLASSES = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    private static final String KEYS = "keys";
    private static final String VALUES = "values";
    private final Map<String, SavingStateLiveData<?>> mLiveDatas;
    final Map<String, Object> mRegular;
    private final SavedStateRegistry.SavedStateProvider mSavedStateProvider;
    final Map<String, SavedStateRegistry.SavedStateProvider> mSavedStateProviders;

    public SavedStateHandle(@NonNull Map<String, Object> map) {
        this.mSavedStateProviders = new HashMap();
        this.mLiveDatas = new HashMap();
        this.mSavedStateProvider = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.SavedStateHandle.1
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            @NonNull
            public Bundle saveState() {
                for (Map.Entry entry : new HashMap(SavedStateHandle.this.mSavedStateProviders).entrySet()) {
                    SavedStateHandle.this.set((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
                }
                Set<String> keySet = SavedStateHandle.this.mRegular.keySet();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
                for (String str : keySet) {
                    arrayList.add(str);
                    arrayList2.add(SavedStateHandle.this.mRegular.get(str));
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(SavedStateHandle.KEYS, arrayList);
                bundle.putParcelableArrayList(SavedStateHandle.VALUES, arrayList2);
                return bundle;
            }
        };
        this.mRegular = new HashMap(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SavedStateHandle createHandle(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new SavedStateHandle();
        }
        HashMap hashMap = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new SavedStateHandle(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEYS);
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(VALUES);
        if (parcelableArrayList != null && parcelableArrayList2 != null && parcelableArrayList.size() == parcelableArrayList2.size()) {
            for (int i3 = 0; i3 < parcelableArrayList.size(); i3++) {
                hashMap.put((String) parcelableArrayList.get(i3), parcelableArrayList2.get(i3));
            }
            return new SavedStateHandle(hashMap);
        }
        throw new IllegalStateException("Invalid bundle passed as restored state");
    }

    @NonNull
    private <T> MutableLiveData<T> getLiveDataInternal(@NonNull String str, boolean z16, @Nullable T t16) {
        SavingStateLiveData<?> savingStateLiveData;
        SavingStateLiveData<?> savingStateLiveData2 = this.mLiveDatas.get(str);
        if (savingStateLiveData2 != null) {
            return savingStateLiveData2;
        }
        if (this.mRegular.containsKey(str)) {
            savingStateLiveData = new SavingStateLiveData<>(this, str, this.mRegular.get(str));
        } else if (z16) {
            savingStateLiveData = new SavingStateLiveData<>(this, str, t16);
        } else {
            savingStateLiveData = new SavingStateLiveData<>(this, str);
        }
        this.mLiveDatas.put(str, savingStateLiveData);
        return savingStateLiveData;
    }

    private static void validateValue(Object obj) {
        if (obj == null) {
            return;
        }
        for (Class cls : ACCEPTABLE_CLASSES) {
            if (cls.isInstance(obj)) {
                return;
            }
        }
        throw new IllegalArgumentException("Can't put value with type " + obj.getClass() + " into saved state");
    }

    @MainThread
    public void clearSavedStateProvider(@NonNull String str) {
        this.mSavedStateProviders.remove(str);
    }

    @MainThread
    public boolean contains(@NonNull String str) {
        return this.mRegular.containsKey(str);
    }

    @Nullable
    @MainThread
    public <T> T get(@NonNull String str) {
        return (T) this.mRegular.get(str);
    }

    @NonNull
    @MainThread
    public <T> MutableLiveData<T> getLiveData(@NonNull String str) {
        return getLiveDataInternal(str, false, null);
    }

    @NonNull
    @MainThread
    public Set<String> keys() {
        HashSet hashSet = new HashSet(this.mRegular.keySet());
        hashSet.addAll(this.mSavedStateProviders.keySet());
        hashSet.addAll(this.mLiveDatas.keySet());
        return hashSet;
    }

    @Nullable
    @MainThread
    public <T> T remove(@NonNull String str) {
        T t16 = (T) this.mRegular.remove(str);
        SavingStateLiveData<?> remove = this.mLiveDatas.remove(str);
        if (remove != null) {
            remove.detach();
        }
        return t16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.mSavedStateProvider;
    }

    @MainThread
    public <T> void set(@NonNull String str, @Nullable T t16) {
        validateValue(t16);
        SavingStateLiveData<?> savingStateLiveData = this.mLiveDatas.get(str);
        if (savingStateLiveData != null) {
            savingStateLiveData.setValue(t16);
        } else {
            this.mRegular.put(str, t16);
        }
    }

    @MainThread
    public void setSavedStateProvider(@NonNull String str, @NonNull SavedStateRegistry.SavedStateProvider savedStateProvider) {
        this.mSavedStateProviders.put(str, savedStateProvider);
    }

    @NonNull
    @MainThread
    public <T> MutableLiveData<T> getLiveData(@NonNull String str, @SuppressLint({"UnknownNullness"}) T t16) {
        return getLiveDataInternal(str, true, t16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SavingStateLiveData<T> extends MutableLiveData<T> {
        private SavedStateHandle mHandle;
        private String mKey;

        SavingStateLiveData(SavedStateHandle savedStateHandle, String str, T t16) {
            super(t16);
            this.mKey = str;
            this.mHandle = savedStateHandle;
        }

        void detach() {
            this.mHandle = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T t16) {
            SavedStateHandle savedStateHandle = this.mHandle;
            if (savedStateHandle != null) {
                savedStateHandle.mRegular.put(this.mKey, t16);
            }
            super.setValue(t16);
        }

        SavingStateLiveData(SavedStateHandle savedStateHandle, String str) {
            this.mKey = str;
            this.mHandle = savedStateHandle;
        }
    }

    public SavedStateHandle() {
        this.mSavedStateProviders = new HashMap();
        this.mLiveDatas = new HashMap();
        this.mSavedStateProvider = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.SavedStateHandle.1
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            @NonNull
            public Bundle saveState() {
                for (Map.Entry entry : new HashMap(SavedStateHandle.this.mSavedStateProviders).entrySet()) {
                    SavedStateHandle.this.set((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
                }
                Set<String> keySet = SavedStateHandle.this.mRegular.keySet();
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
                for (String str : keySet) {
                    arrayList.add(str);
                    arrayList2.add(SavedStateHandle.this.mRegular.get(str));
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(SavedStateHandle.KEYS, arrayList);
                bundle.putParcelableArrayList(SavedStateHandle.VALUES, arrayList2);
                return bundle;
            }
        };
        this.mRegular = new HashMap();
    }
}
