package d0;

import a0.g;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.o;
import h0.i;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static final o<?, ?, ?> f392577c = new o<>(Object.class, Object.class, Object.class, Collections.singletonList(new com.bumptech.glide.load.engine.f(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);

    /* renamed from: a, reason: collision with root package name */
    private final ArrayMap<i, o<?, ?, ?>> f392578a = new ArrayMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<i> f392579b = new AtomicReference<>();

    private i b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        i andSet = this.f392579b.getAndSet(null);
        if (andSet == null) {
            andSet = new i();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    @Nullable
    public <Data, TResource, Transcode> o<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        o<Data, TResource, Transcode> oVar;
        i b16 = b(cls, cls2, cls3);
        synchronized (this.f392578a) {
            oVar = (o) this.f392578a.get(b16);
        }
        this.f392579b.set(b16);
        return oVar;
    }

    public boolean c(@Nullable o<?, ?, ?> oVar) {
        return f392577c.equals(oVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable o<?, ?, ?> oVar) {
        synchronized (this.f392578a) {
            ArrayMap<i, o<?, ?, ?>> arrayMap = this.f392578a;
            i iVar = new i(cls, cls2, cls3);
            if (oVar == null) {
                oVar = f392577c;
            }
            arrayMap.put(iVar, oVar);
        }
    }
}
