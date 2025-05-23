package com.tencent.mapsdk.core.utils.cache;

import android.support.annotation.Keep;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.jz;
import com.tencent.mapsdk.internal.ka;
import com.tencent.mapsdk.internal.kb;
import com.tencent.mapsdk.internal.kh;
import com.tencent.mapsdk.internal.ky;
import com.tencent.mapsdk.internal.lc;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class MemoryCache<D extends ka> extends kh<D> {

    /* renamed from: a, reason: collision with root package name */
    private static final float f147650a = 0.9f;

    /* renamed from: b, reason: collision with root package name */
    private static final float f147651b = 0.15f;

    /* renamed from: e, reason: collision with root package name */
    private static int f147652e = 104857600;

    /* renamed from: f, reason: collision with root package name */
    private static final float f147653f = 0.8f;

    /* renamed from: c, reason: collision with root package name */
    private final a f147654c;

    /* renamed from: d, reason: collision with root package name */
    private final kb.a<D> f147655d;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a implements jz.a {

        /* renamed from: b, reason: collision with root package name */
        public int f147656b;

        /* renamed from: c, reason: collision with root package name */
        public jz.b f147657c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f147658d;

        /* renamed from: e, reason: collision with root package name */
        int f147659e;

        public a(int i3) {
            this.f147659e = i3;
        }

        private <D> jz.b<D> c() {
            return this.f147657c;
        }

        @Override // com.tencent.mapsdk.internal.jz.a
        public final boolean b() {
            return this.f147658d;
        }

        public final String toString() {
            return "Options{mMaxCacheSize=" + this.f147656b + '}';
        }

        private a a(boolean z16) {
            this.f147658d = z16;
            return this;
        }

        private a a(int i3) {
            this.f147656b = i3;
            return this;
        }

        private <D> a a(jz.b<D> bVar) {
            this.f147657c = bVar;
            return this;
        }

        @Override // com.tencent.mapsdk.internal.jz.a
        public final int a() {
            return this.f147656b;
        }
    }

    @Keep
    public MemoryCache(a aVar) {
        this.f147654c = aVar;
        this.f147655d = new kb.a<>(a(), aVar.f147657c);
        if (!aVar.f147658d) {
            f147652e = Math.min(f147652e, a());
        }
    }

    private int a() {
        int i3 = (int) (((float) Runtime.getRuntime().totalMemory()) * 0.9f);
        int freeMemory = (int) (((float) Runtime.getRuntime().freeMemory()) * f147651b);
        a aVar = this.f147654c;
        return aVar != null ? Math.min(Math.max(aVar.f147656b, freeMemory), i3) : i3;
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final void b() {
        this.f147655d.a();
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final long c() {
        return this.f147655d.d().size();
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final long d() {
        return this.f147655d.b();
    }

    @Override // com.tencent.mapsdk.internal.jz, com.tencent.mapsdk.internal.kg
    public final long e() {
        return this.f147655d.c();
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final void a(String str, D d16) {
        lc.b(ky.f149112r, str, this.f147654c.f147659e);
        if (this.f147654c.f147658d && this.f147655d.b() >= this.f147655d.c() * 0.8f && this.f147655d.b() < f147652e) {
            this.f147655d.a((int) Math.min(r0.c() * 1.8f, f147652e));
            LogUtil.b(ky.f149112r, "MemoryCache expanding mDataSize:[" + this.f147655d.b() + "] maxDataSize:[" + this.f147655d.c() + "]");
        }
        this.f147655d.a((kb.a<D>) str, (String) d16);
        lc.a(ky.f149112r, str, (Object) "put data length", d16.a());
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final D a(String str, Class<D> cls) {
        D d16 = (D) this.f147655d.b((kb.a<D>) str);
        if (this.f147654c.f147658d && this.f147655d.b() <= this.f147655d.c() / 1.8f && this.f147655d.b() > a()) {
            this.f147655d.a((int) (r0.c() / 1.8f));
            LogUtil.b(ky.f149112r, "MemoryCache shrinking mDataSize:[" + this.f147655d.b() + "] maxDataSize:[" + this.f147655d.c() + "]");
        }
        lc.a(ky.f149112r, str, (Object) "get data length", d16 == null ? 0 : d16.a());
        lc.f(ky.f149112r, str, this.f147654c.f147659e);
        return d16;
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final boolean a(String str) {
        return this.f147655d.c(str) != 0;
    }
}
