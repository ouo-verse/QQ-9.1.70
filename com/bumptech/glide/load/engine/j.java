package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
class j implements com.bumptech.glide.load.c {

    /* renamed from: b, reason: collision with root package name */
    private final Object f31723b;

    /* renamed from: c, reason: collision with root package name */
    private final int f31724c;

    /* renamed from: d, reason: collision with root package name */
    private final int f31725d;

    /* renamed from: e, reason: collision with root package name */
    private final Class<?> f31726e;

    /* renamed from: f, reason: collision with root package name */
    private final Class<?> f31727f;

    /* renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.load.c f31728g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.h<?>> f31729h;

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.e f31730i;

    /* renamed from: j, reason: collision with root package name */
    private int f31731j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Object obj, com.bumptech.glide.load.c cVar, int i3, int i16, Map<Class<?>, com.bumptech.glide.load.h<?>> map, Class<?> cls, Class<?> cls2, com.bumptech.glide.load.e eVar) {
        this.f31723b = h0.j.d(obj);
        this.f31728g = (com.bumptech.glide.load.c) h0.j.e(cVar, "Signature must not be null");
        this.f31724c = i3;
        this.f31725d = i16;
        this.f31729h = (Map) h0.j.d(map);
        this.f31726e = (Class) h0.j.e(cls, "Resource class must not be null");
        this.f31727f = (Class) h0.j.e(cls2, "Transcode class must not be null");
        this.f31730i = (com.bumptech.glide.load.e) h0.j.d(eVar);
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (!this.f31723b.equals(jVar.f31723b) || !this.f31728g.equals(jVar.f31728g) || this.f31725d != jVar.f31725d || this.f31724c != jVar.f31724c || !this.f31729h.equals(jVar.f31729h) || !this.f31726e.equals(jVar.f31726e) || !this.f31727f.equals(jVar.f31727f) || !this.f31730i.equals(jVar.f31730i)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        if (this.f31731j == 0) {
            int hashCode = this.f31723b.hashCode();
            this.f31731j = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.f31728g.hashCode()) * 31) + this.f31724c) * 31) + this.f31725d;
            this.f31731j = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.f31729h.hashCode();
            this.f31731j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f31726e.hashCode();
            this.f31731j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f31727f.hashCode();
            this.f31731j = hashCode5;
            this.f31731j = (hashCode5 * 31) + this.f31730i.hashCode();
        }
        return this.f31731j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f31723b + ", width=" + this.f31724c + ", height=" + this.f31725d + ", resourceClass=" + this.f31726e + ", transcodeClass=" + this.f31727f + ", signature=" + this.f31728g + ", hashCode=" + this.f31731j + ", transformations=" + this.f31729h + ", options=" + this.f31730i + '}';
    }
}
