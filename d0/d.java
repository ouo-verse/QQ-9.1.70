package d0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import h0.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<i> f392580a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayMap<i, List<Class<?>>> f392581b = new ArrayMap<>();

    @Nullable
    public List<Class<?>> a(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        i andSet = this.f392580a.getAndSet(null);
        if (andSet == null) {
            andSet = new i(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f392581b) {
            list = this.f392581b.get(andSet);
        }
        this.f392580a.set(andSet);
        return list;
    }

    public void b(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.f392581b) {
            this.f392581b.put(new i(cls, cls2, cls3), list);
        }
    }
}
