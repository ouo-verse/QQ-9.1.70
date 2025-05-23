package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class o<Data, ResourceType, Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<Data> f31740a;

    /* renamed from: b, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f31741b;

    /* renamed from: c, reason: collision with root package name */
    private final List<? extends f<Data, ResourceType, Transcode>> f31742c;

    /* renamed from: d, reason: collision with root package name */
    private final String f31743d;

    public o(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<f<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f31740a = cls;
        this.f31741b = pool;
        this.f31742c = (List) h0.j.c(list);
        this.f31743d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private q<Transcode> b(com.bumptech.glide.load.data.e<Data> eVar, @NonNull com.bumptech.glide.load.e eVar2, int i3, int i16, f.a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        int size = this.f31742c.size();
        q<Transcode> qVar = null;
        for (int i17 = 0; i17 < size; i17++) {
            try {
                qVar = this.f31742c.get(i17).a(eVar, i3, i16, eVar2, aVar);
            } catch (GlideException e16) {
                list.add(e16);
            }
            if (qVar != null) {
                break;
            }
        }
        if (qVar != null) {
            return qVar;
        }
        throw new GlideException(this.f31743d, new ArrayList(list));
    }

    public q<Transcode> a(com.bumptech.glide.load.data.e<Data> eVar, @NonNull com.bumptech.glide.load.e eVar2, int i3, int i16, f.a<ResourceType> aVar) throws GlideException {
        List<Throwable> list = (List) h0.j.d(this.f31741b.acquire());
        try {
            return b(eVar, eVar2, i3, i16, aVar, list);
        } finally {
            this.f31741b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f31742c.toArray()) + '}';
    }
}
