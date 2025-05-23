package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class ViewModel {

    @Nullable
    private final Map<String, Object> mBagOfTags = new HashMap();
    private volatile boolean mCleared = false;

    private static void closeWithRuntimeException(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e16) {
                throw new RuntimeException(e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @MainThread
    public final void clear() {
        this.mCleared = true;
        Map<String, Object> map = this.mBagOfTags;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.mBagOfTags.values().iterator();
                while (it.hasNext()) {
                    closeWithRuntimeException(it.next());
                }
            }
        }
        onCleared();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> T getTag(String str) {
        T t16;
        Map<String, Object> map = this.mBagOfTags;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t16 = (T) this.mBagOfTags.get(str);
        }
        return t16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T setTagIfAbsent(String str, T t16) {
        Object obj;
        synchronized (this.mBagOfTags) {
            obj = this.mBagOfTags.get(str);
            if (obj == 0) {
                this.mBagOfTags.put(str, t16);
            }
        }
        if (obj != 0) {
            t16 = obj;
        }
        if (this.mCleared) {
            closeWithRuntimeException(t16);
        }
        return t16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCleared() {
    }
}
