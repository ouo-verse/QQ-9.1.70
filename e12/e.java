package e12;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e<T> extends a<T> {
    public e() {
    }

    @Override // e12.a, androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(T t16) {
        T value = getValue();
        if (t16 != value) {
            if (t16 == null || !t16.equals(value)) {
                super.postValue(t16);
            }
        }
    }

    @Override // e12.a, androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T t16) {
        T value = getValue();
        if (t16 != value) {
            if (t16 == null || !t16.equals(value)) {
                super.setValue(t16);
            }
        }
    }

    public e(T t16) {
        super(t16);
    }
}
