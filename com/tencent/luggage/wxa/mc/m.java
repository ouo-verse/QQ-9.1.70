package com.tencent.luggage.wxa.mc;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.mc.a0;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import java.io.InputStream;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface m {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f134335a;

        /* renamed from: b, reason: collision with root package name */
        public int f134336b;

        /* renamed from: c, reason: collision with root package name */
        public String f134337c;

        /* renamed from: d, reason: collision with root package name */
        public a0 f134338d;

        /* renamed from: e, reason: collision with root package name */
        public String f134339e;

        /* renamed from: f, reason: collision with root package name */
        public String f134340f;

        /* renamed from: g, reason: collision with root package name */
        public int f134341g;

        /* renamed from: h, reason: collision with root package name */
        public int f134342h;

        public a0.a a() {
            return new a0.a(this.f134339e, this.f134340f, this.f134341g, this.f134342h);
        }

        public void a(a aVar) {
            this.f134335a = aVar.f134335a;
            this.f134336b = aVar.f134336b;
            this.f134337c = aVar.f134337c;
            this.f134338d = aVar.f134338d;
            this.f134339e = aVar.f134339e;
            this.f134340f = aVar.f134340f;
            this.f134341g = aVar.f134341g;
            this.f134342h = aVar.f134342h;
        }
    }

    List<ModulePkgInfo> a();

    boolean a(String str, boolean z16);

    @Nullable
    InputStream b(String str);

    void b();

    List<String> c();

    void close();

    @Nullable
    List<a0.a> d();

    boolean d(String str);

    @Nullable
    a0 e(String str);

    @Nullable
    a openReadPartialInfo(String str);
}
