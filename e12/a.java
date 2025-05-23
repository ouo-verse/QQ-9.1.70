package e12;

import android.os.Looper;
import androidx.lifecycle.MediatorLiveData;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a<T> extends MediatorLiveData<T> {
    public a() {
    }

    private void c(T t16) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            super.setValue(t16);
        } else {
            super.postValue(t16);
        }
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(T t16) {
        c(t16);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T t16) {
        c(t16);
    }

    public a(T t16) {
        setValue(t16);
    }
}
