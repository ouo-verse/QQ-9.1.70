package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.jz;
import com.tencent.mapsdk.internal.ka;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class kf<D extends ka> extends jy<D> {

    /* renamed from: a, reason: collision with root package name */
    private static b f148963a = new b() { // from class: com.tencent.mapsdk.internal.kf.1
        @Override // com.tencent.mapsdk.internal.kf.b
        public final String a(String str) {
            return kd.a(str);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private c f148964b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum a {
        DISK,
        DB
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        String a(String str);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class c implements jz.a {

        /* renamed from: j, reason: collision with root package name */
        a f148968j;

        /* renamed from: k, reason: collision with root package name */
        public int f148969k = 104857600;

        /* renamed from: l, reason: collision with root package name */
        public b f148970l = kf.f148963a;

        public c(a aVar) {
            this.f148968j = aVar;
        }

        private c a(b bVar) {
            this.f148970l = bVar;
            return this;
        }

        private c c() {
            this.f148969k = -1;
            return this;
        }

        private a d() {
            return this.f148968j;
        }

        private b e() {
            return this.f148970l;
        }

        @Override // com.tencent.mapsdk.internal.jz.a
        public final boolean b() {
            return false;
        }

        public String toString() {
            return "Options{mType=" + this.f148968j + ", mCacheSize=" + this.f148969k + ", keyGenerator=" + this.f148970l + '}';
        }

        @Override // com.tencent.mapsdk.internal.jz.a
        public final int a() {
            return this.f148969k;
        }
    }

    public kf(c cVar) {
        this.f148964b = cVar;
    }

    public c g() {
        return this.f148964b;
    }
}
