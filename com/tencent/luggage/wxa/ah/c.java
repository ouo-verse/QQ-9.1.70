package com.tencent.luggage.wxa.ah;

import android.net.Uri;
import com.tencent.luggage.wxa.l0.g;
import com.tencent.luggage.wxa.l0.j;
import com.tencent.luggage.wxa.tn.w;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.m0.a f121408a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.m0.e f121409b;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f121410c;

    /* renamed from: d, reason: collision with root package name */
    public final g.a f121411d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements g.a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ah.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6006a implements g {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.m0.d f121413a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.m0.d f121414b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f121415c;

            public C6006a(com.tencent.luggage.wxa.m0.d dVar, c cVar) {
                this.f121414b = dVar;
                this.f121415c = cVar;
                this.f121413a = dVar;
            }

            @Override // com.tencent.luggage.wxa.l0.g
            public long a(j jVar) {
                String str;
                long a16 = this.f121414b.a(jVar);
                if (jVar == null) {
                    return a16;
                }
                Uri uri = jVar.f132782a;
                if (uri != null) {
                    str = uri.toString();
                } else {
                    str = null;
                }
                w.d("MicroMsg.AppBrand.CancellableCacheLogic", "open#DataSource, url: " + str);
                Future future = (Future) TypeIntrinsics.asMutableMap(this.f121415c.f121410c).remove(str);
                if (future != null) {
                    w.d("MicroMsg.AppBrand.CancellableCacheLogic", "open#DataSource, url: " + str + ", cancel cache, success: " + future.cancel(true));
                }
                return a16;
            }

            @Override // com.tencent.luggage.wxa.l0.g
            public void close() {
                this.f121413a.close();
            }

            @Override // com.tencent.luggage.wxa.l0.g
            public Uri getUri() {
                return this.f121413a.getUri();
            }

            @Override // com.tencent.luggage.wxa.l0.g
            public int read(byte[] bArr, int i3, int i16) {
                return this.f121413a.read(bArr, i3, i16);
            }
        }

        public a() {
        }

        @Override // com.tencent.luggage.wxa.l0.g.a
        public final g createDataSource() {
            return new C6006a(c.this.f121409b.createDataSource(), c.this);
        }
    }

    public c(com.tencent.luggage.wxa.m0.a cache, com.tencent.luggage.wxa.m0.e cacheDataSourceFactory) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(cacheDataSourceFactory, "cacheDataSourceFactory");
        this.f121408a = cache;
        this.f121409b = cacheDataSourceFactory;
        this.f121410c = new ConcurrentHashMap();
        this.f121411d = new a();
    }

    public final g.a a() {
        return this.f121411d;
    }
}
