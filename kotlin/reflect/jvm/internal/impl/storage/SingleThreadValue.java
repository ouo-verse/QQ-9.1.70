package kotlin.reflect.jvm.internal.impl.storage;

/* compiled from: P */
/* loaded from: classes28.dex */
class SingleThreadValue<T> {
    private final Thread thread = Thread.currentThread();
    private final T value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleThreadValue(T t16) {
        this.value = t16;
    }

    public T getValue() {
        if (hasValue()) {
            return this.value;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean hasValue() {
        if (this.thread == Thread.currentThread()) {
            return true;
        }
        return false;
    }
}
