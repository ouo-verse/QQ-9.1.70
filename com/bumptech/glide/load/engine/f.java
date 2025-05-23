package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class f<DataType, ResourceType, Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<DataType> f31687a;

    /* renamed from: b, reason: collision with root package name */
    private final List<? extends com.bumptech.glide.load.f<DataType, ResourceType>> f31688b;

    /* renamed from: c, reason: collision with root package name */
    private final a0.e<ResourceType, Transcode> f31689c;

    /* renamed from: d, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f31690d;

    /* renamed from: e, reason: collision with root package name */
    private final String f31691e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface a<ResourceType> {
        @NonNull
        q<ResourceType> a(@NonNull q<ResourceType> qVar);
    }

    public f(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.bumptech.glide.load.f<DataType, ResourceType>> list, a0.e<ResourceType, Transcode> eVar, Pools.Pool<List<Throwable>> pool) {
        this.f31687a = cls;
        this.f31688b = list;
        this.f31689c = eVar;
        this.f31690d = pool;
        this.f31691e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    @NonNull
    private q<ResourceType> b(com.bumptech.glide.load.data.e<DataType> eVar, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar2) throws GlideException {
        List<Throwable> list = (List) h0.j.d(this.f31690d.acquire());
        try {
            return c(eVar, i3, i16, eVar2, list);
        } finally {
            this.f31690d.release(list);
        }
    }

    @NonNull
    private q<ResourceType> c(com.bumptech.glide.load.data.e<DataType> eVar, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar2, List<Throwable> list) throws GlideException {
        int size = this.f31688b.size();
        q<ResourceType> qVar = null;
        for (int i17 = 0; i17 < size; i17++) {
            com.bumptech.glide.load.f<DataType, ResourceType> fVar = this.f31688b.get(i17);
            try {
                if (fVar.a(eVar.a(), eVar2)) {
                    qVar = fVar.b(eVar.a(), i3, i16, eVar2);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e16) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + fVar, e16);
                }
                list.add(e16);
            }
            if (qVar != null) {
                break;
            }
        }
        if (qVar != null) {
            return qVar;
        }
        throw new GlideException(this.f31691e, new ArrayList(list));
    }

    public q<Transcode> a(com.bumptech.glide.load.data.e<DataType> eVar, int i3, int i16, @NonNull com.bumptech.glide.load.e eVar2, a<ResourceType> aVar) throws GlideException {
        return this.f31689c.a(aVar.a(b(eVar, i3, i16, eVar2)), eVar2);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f31687a + ", decoders=" + this.f31688b + ", transcoder=" + this.f31689c + '}';
    }
}
