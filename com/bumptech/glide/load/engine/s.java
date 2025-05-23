package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes.dex */
final class s implements com.bumptech.glide.load.c {

    /* renamed from: j, reason: collision with root package name */
    private static final h0.g<Class<?>, byte[]> f31760j = new h0.g<>(50);

    /* renamed from: b, reason: collision with root package name */
    private final r.b f31761b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.c f31762c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.c f31763d;

    /* renamed from: e, reason: collision with root package name */
    private final int f31764e;

    /* renamed from: f, reason: collision with root package name */
    private final int f31765f;

    /* renamed from: g, reason: collision with root package name */
    private final Class<?> f31766g;

    /* renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.load.e f31767h;

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.h<?> f31768i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r.b bVar, com.bumptech.glide.load.c cVar, com.bumptech.glide.load.c cVar2, int i3, int i16, com.bumptech.glide.load.h<?> hVar, Class<?> cls, com.bumptech.glide.load.e eVar) {
        this.f31761b = bVar;
        this.f31762c = cVar;
        this.f31763d = cVar2;
        this.f31764e = i3;
        this.f31765f = i16;
        this.f31768i = hVar;
        this.f31766g = cls;
        this.f31767h = eVar;
    }

    private byte[] c() {
        h0.g<Class<?>, byte[]> gVar = f31760j;
        byte[] f16 = gVar.f(this.f31766g);
        if (f16 == null) {
            byte[] bytes = this.f31766g.getName().getBytes(com.bumptech.glide.load.c.f31560a);
            gVar.j(this.f31766g, bytes);
            return bytes;
        }
        return f16;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f31761b.c(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f31764e).putInt(this.f31765f).array();
        this.f31763d.b(messageDigest);
        this.f31762c.b(messageDigest);
        messageDigest.update(bArr);
        com.bumptech.glide.load.h<?> hVar = this.f31768i;
        if (hVar != null) {
            hVar.b(messageDigest);
        }
        this.f31767h.b(messageDigest);
        messageDigest.update(c());
        this.f31761b.put(bArr);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        if (this.f31765f != sVar.f31765f || this.f31764e != sVar.f31764e || !h0.k.c(this.f31768i, sVar.f31768i) || !this.f31766g.equals(sVar.f31766g) || !this.f31762c.equals(sVar.f31762c) || !this.f31763d.equals(sVar.f31763d) || !this.f31767h.equals(sVar.f31767h)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        int hashCode = (((((this.f31762c.hashCode() * 31) + this.f31763d.hashCode()) * 31) + this.f31764e) * 31) + this.f31765f;
        com.bumptech.glide.load.h<?> hVar = this.f31768i;
        if (hVar != null) {
            hashCode = (hashCode * 31) + hVar.hashCode();
        }
        return (((hashCode * 31) + this.f31766g.hashCode()) * 31) + this.f31767h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f31762c + ", signature=" + this.f31763d + ", width=" + this.f31764e + ", height=" + this.f31765f + ", decodedResourceClass=" + this.f31766g + ", transformation='" + this.f31768i + "', options=" + this.f31767h + '}';
    }
}
