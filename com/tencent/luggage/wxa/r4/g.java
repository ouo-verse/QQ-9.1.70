package com.tencent.luggage.wxa.r4;

import cooperation.qzone.QZoneHelper;
import org.chromium.base.PathUtils;
import org.chromium.net.CronetEngine;
import org.chromium.net.impl.CronetLibraryLoader;
import org.chromium.net.impl.NativeCronetEngineBuilderImpl;
import org.chromium.net.mm.CronetJsBinding;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public long f139206a = 0;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.yi.a f139207b = null;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.ic.g f139208c = null;

    /* renamed from: d, reason: collision with root package name */
    public final CronetJsBinding f139209d = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends CronetJsBinding {
        public a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends CronetEngine.Builder.LibraryLoader {
    }

    static {
        b();
    }

    public static void b() {
        NativeCronetEngineBuilderImpl nativeCronetEngineBuilderImpl = new NativeCronetEngineBuilderImpl(com.tencent.luggage.wxa.tn.z.c());
        nativeCronetEngineBuilderImpl.setLibraryLoader(new b());
        CronetLibraryLoader.ensureInitialized(com.tencent.luggage.wxa.tn.z.c(), nativeCronetEngineBuilderImpl);
        PathUtils.setPrivateDirectoryPath((String) null, (String) null, "WxaCronet", (String) null);
    }

    public void a(long j3, long j16, long j17) {
        com.tencent.luggage.wxa.er.a.a(0L, this.f139206a);
        this.f139206a = this.f139209d.initCronetJsBinding(j3, j16, j17);
    }

    public void c() {
        com.tencent.luggage.wxa.er.a.b((Object) 0, (Object) Long.valueOf(this.f139206a));
        this.f139209d.cancelAllRequests(this.f139206a);
    }

    public void a(com.tencent.luggage.wxa.ic.g gVar) {
        com.tencent.luggage.wxa.er.a.b((Object) 0, (Object) Long.valueOf(this.f139206a));
        com.tencent.luggage.wxa.yi.a aVar = (com.tencent.luggage.wxa.yi.a) gVar.a(com.tencent.luggage.wxa.yi.a.class);
        this.f139207b = aVar;
        this.f139208c = gVar;
        String str = aVar.K;
        String i3 = com.tencent.luggage.wxa.tn.z.i();
        this.f139209d.setupConfig(this.f139206a, str, com.tencent.luggage.wxa.cp.x.b("wcf://WxaCronetRequestCache/", true), QZoneHelper.Constants.SUPPORT_MIX_MUSIC_DEFAULT, com.tencent.luggage.wxa.yi.q.a(this.f139207b, 0), com.tencent.luggage.wxa.yi.q.a(this.f139207b, 3), com.tencent.luggage.wxa.yi.q.a(this.f139207b, 2), i3, this.f139207b.O);
    }

    public void a() {
        com.tencent.luggage.wxa.er.a.b((Object) 0, (Object) Long.valueOf(this.f139206a));
        this.f139209d.destroy(this.f139206a);
        this.f139206a = 0L;
    }
}
