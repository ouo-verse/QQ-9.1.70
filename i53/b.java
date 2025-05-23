package i53;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b<T> extends a<T> {
    @Override // i53.a, androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(T t16) {
        T value = getValue();
        if (t16 != value) {
            if (t16 == null || !t16.equals(value)) {
                super.postValue(t16);
            }
        }
    }

    @Override // i53.a, androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T t16) {
        T value = getValue();
        if (t16 != value) {
            if (t16 == null || !t16.equals(value)) {
                super.setValue(t16);
            }
        }
    }
}
