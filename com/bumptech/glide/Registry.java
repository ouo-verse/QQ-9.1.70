package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.engine.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import t.n;
import t.o;
import t.p;

/* compiled from: P */
/* loaded from: classes.dex */
public class Registry {

    /* renamed from: a, reason: collision with root package name */
    private final p f31433a;

    /* renamed from: b, reason: collision with root package name */
    private final d0.a f31434b;

    /* renamed from: c, reason: collision with root package name */
    private final d0.e f31435c;

    /* renamed from: d, reason: collision with root package name */
    private final d0.f f31436d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.data.f f31437e;

    /* renamed from: f, reason: collision with root package name */
    private final a0.f f31438f;

    /* renamed from: g, reason: collision with root package name */
    private final d0.b f31439g;

    /* renamed from: h, reason: collision with root package name */
    private final d0.d f31440h = new d0.d();

    /* renamed from: i, reason: collision with root package name */
    private final d0.c f31441i = new d0.c();

    /* renamed from: j, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f31442j;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(@NonNull M m3, @NonNull List<n<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m3);
        }

        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        Pools.Pool<List<Throwable>> e16 = i0.a.e();
        this.f31442j = e16;
        this.f31433a = new p(e16);
        this.f31434b = new d0.a();
        this.f31435c = new d0.e();
        this.f31436d = new d0.f();
        this.f31437e = new com.bumptech.glide.load.data.f();
        this.f31438f = new a0.f();
        this.f31439g = new d0.b();
        r(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    @NonNull
    private <Data, TResource, Transcode> List<com.bumptech.glide.load.engine.f<Data, TResource, Transcode>> f(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f31435c.d(cls, cls2)) {
            for (Class cls5 : this.f31438f.b(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.load.engine.f(cls, cls4, cls5, this.f31435c.b(cls, cls4), this.f31438f.a(cls4, cls5), this.f31442j));
            }
        }
        return arrayList;
    }

    @NonNull
    public <Data> Registry a(@NonNull Class<Data> cls, @NonNull com.bumptech.glide.load.a<Data> aVar) {
        this.f31434b.a(cls, aVar);
        return this;
    }

    @NonNull
    public <TResource> Registry b(@NonNull Class<TResource> cls, @NonNull com.bumptech.glide.load.g<TResource> gVar) {
        this.f31436d.a(cls, gVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.f<Data, TResource> fVar) {
        e("legacy_append", cls, cls2, fVar);
        return this;
    }

    @NonNull
    public <Model, Data> Registry d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.f31433a.a(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public <Data, TResource> Registry e(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.bumptech.glide.load.f<Data, TResource> fVar) {
        this.f31435c.a(str, fVar, cls, cls2);
        return this;
    }

    @NonNull
    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> b16 = this.f31439g.b();
        if (!b16.isEmpty()) {
            return b16;
        }
        throw new NoImageHeaderParserException();
    }

    @Nullable
    public <Data, TResource, Transcode> com.bumptech.glide.load.engine.o<Data, TResource, Transcode> h(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        com.bumptech.glide.load.engine.o<Data, TResource, Transcode> a16 = this.f31441i.a(cls, cls2, cls3);
        if (this.f31441i.c(a16)) {
            return null;
        }
        if (a16 == null) {
            List<com.bumptech.glide.load.engine.f<Data, TResource, Transcode>> f16 = f(cls, cls2, cls3);
            if (f16.isEmpty()) {
                a16 = null;
            } else {
                a16 = new com.bumptech.glide.load.engine.o<>(cls, cls2, cls3, f16, this.f31442j);
            }
            this.f31441i.d(cls, cls2, cls3, a16);
        }
        return a16;
    }

    @NonNull
    public <Model> List<n<Model, ?>> i(@NonNull Model model) {
        return this.f31433a.d(model);
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> j(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> a16 = this.f31440h.a(cls, cls2, cls3);
        if (a16 == null) {
            a16 = new ArrayList<>();
            Iterator<Class<?>> it = this.f31433a.c(cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.f31435c.d(it.next(), cls2)) {
                    if (!this.f31438f.b(cls4, cls3).isEmpty() && !a16.contains(cls4)) {
                        a16.add(cls4);
                    }
                }
            }
            this.f31440h.b(cls, cls2, cls3, Collections.unmodifiableList(a16));
        }
        return a16;
    }

    @NonNull
    public <X> com.bumptech.glide.load.g<X> k(@NonNull q<X> qVar) throws NoResultEncoderAvailableException {
        com.bumptech.glide.load.g<X> b16 = this.f31436d.b(qVar.getResourceClass());
        if (b16 != null) {
            return b16;
        }
        throw new NoResultEncoderAvailableException(qVar.getResourceClass());
    }

    @NonNull
    public <X> com.bumptech.glide.load.data.e<X> l(@NonNull X x16) {
        return this.f31437e.a(x16);
    }

    @NonNull
    public <X> com.bumptech.glide.load.a<X> m(@NonNull X x16) throws NoSourceEncoderAvailableException {
        com.bumptech.glide.load.a<X> b16 = this.f31434b.b(x16.getClass());
        if (b16 != null) {
            return b16;
        }
        throw new NoSourceEncoderAvailableException(x16.getClass());
    }

    public boolean n(@NonNull q<?> qVar) {
        if (this.f31436d.b(qVar.getResourceClass()) != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public Registry o(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f31439g.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public Registry p(@NonNull e.a<?> aVar) {
        this.f31437e.b(aVar);
        return this;
    }

    @NonNull
    public <TResource, Transcode> Registry q(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull a0.e<TResource, Transcode> eVar) {
        this.f31438f.c(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public final Registry r(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add("legacy_append");
        this.f31435c.e(arrayList);
        return this;
    }
}
