package cooperation.qzone.statistic;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class Singleton<T, P> {
    private volatile T mInstance;

    protected abstract T create(P p16);

    public final T get(P p16) {
        if (this.mInstance == null) {
            synchronized (this) {
                if (this.mInstance == null) {
                    this.mInstance = create(p16);
                }
            }
        }
        return this.mInstance;
    }

    public void release() {
        this.mInstance = null;
    }
}
