package ko4;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c<T> extends a<T> {
    public c(T t16) {
        super(t16);
    }

    @Override // ko4.a, androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(T t16) {
        T value = getValue();
        if (t16 != value) {
            if (t16 == null || !t16.equals(value)) {
                super.postValue(t16);
            }
        }
    }

    @Override // ko4.a, androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T t16) {
        T value = getValue();
        if (t16 != value) {
            if (t16 == null || !t16.equals(value)) {
                super.setValue(t16);
            }
        }
    }
}
