package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes.dex */
final class b implements com.bumptech.glide.load.c {

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.c f31647b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.c f31648c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(com.bumptech.glide.load.c cVar, com.bumptech.glide.load.c cVar2) {
        this.f31647b = cVar;
        this.f31648c = cVar2;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        this.f31647b.b(messageDigest);
        this.f31648c.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!this.f31647b.equals(bVar.f31647b) || !this.f31648c.equals(bVar.f31648c)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return (this.f31647b.hashCode() * 31) + this.f31648c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f31647b + ", signature=" + this.f31648c + '}';
    }
}
