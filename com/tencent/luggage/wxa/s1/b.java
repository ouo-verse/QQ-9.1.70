package com.tencent.luggage.wxa.s1;

import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.wxa.ei.l;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.t1.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.magicbrush.MBRuntime;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f139992e = new b();

    /* renamed from: c, reason: collision with root package name */
    public boolean f139995c;

    /* renamed from: a, reason: collision with root package name */
    public final int f139993a = 8192;

    /* renamed from: b, reason: collision with root package name */
    public final int f139994b = 8192;

    /* renamed from: d, reason: collision with root package name */
    public WeakReference f139996d = null;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.s1.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6699b implements d.b, d.c, d.InterfaceC6731d {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f139997a;

        @Override // com.tencent.luggage.wxa.t1.d.c
        public int a() {
            return e();
        }

        @Override // com.tencent.luggage.wxa.t1.d.a
        public String b() {
            if (this.f139997a.get() != null) {
                return ((g) this.f139997a.get()).getAppId();
            }
            return "";
        }

        @Override // com.tencent.luggage.wxa.t1.d.InterfaceC6731d
        public l c() {
            if (this.f139997a.get() != null) {
                return (l) ((g) this.f139997a.get()).h0().getJsRuntime().a(l.class);
            }
            return null;
        }

        @Override // com.tencent.luggage.wxa.t1.d.c
        public int d() {
            return e();
        }

        public final int e() {
            com.tencent.luggage.wxa.yi.a aVar;
            g gVar = (g) this.f139997a.get();
            if (gVar == null || (aVar = (com.tencent.luggage.wxa.yi.a) gVar.a(com.tencent.luggage.wxa.yi.a.class)) == null) {
                return 0;
            }
            return aVar.f145796f;
        }

        @Override // com.tencent.luggage.wxa.t1.d.b
        public r getFileSystem() {
            if (this.f139997a.get() != null) {
                return ((g) this.f139997a.get()).P();
            }
            return null;
        }

        @Override // com.tencent.luggage.wxa.t1.d.c
        public String getUserAgentString() {
            com.tencent.luggage.wxa.yi.a aVar;
            g gVar = (g) this.f139997a.get();
            if (gVar == null || (aVar = (com.tencent.luggage.wxa.yi.a) gVar.a(com.tencent.luggage.wxa.yi.a.class)) == null) {
                return "";
            }
            return aVar.K;
        }

        public C6699b(g gVar) {
            this.f139997a = new WeakReference(gVar);
        }

        @Override // com.tencent.luggage.wxa.t1.d.c
        public String a(ImageDecodeConfig.ReferrerPolicy referrerPolicy) {
            g gVar = (g) this.f139997a.get();
            if (gVar != null) {
                com.tencent.luggage.wxa.cg.a aVar = (com.tencent.luggage.wxa.cg.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.cg.a.class);
                if (aVar != null) {
                    ImageDecodeConfig.ReferrerPolicy referrerPolicy2 = ImageDecodeConfig.ReferrerPolicy.NOT_SET;
                    if (referrerPolicy == referrerPolicy2) {
                        referrerPolicy = a(aVar.b(gVar.h0()));
                    }
                    if (referrerPolicy == referrerPolicy2) {
                        referrerPolicy = a(aVar.s());
                    }
                    if (referrerPolicy == ImageDecodeConfig.ReferrerPolicy.ORIGIN) {
                        return aVar.c(gVar.h0());
                    }
                } else {
                    w.f("MicroMsg.ImageFetcherConfigImp", "referrer helper is null");
                }
            }
            return null;
        }

        public final ImageDecodeConfig.ReferrerPolicy a(com.tencent.luggage.wxa.cg.c cVar) {
            if (cVar == null) {
                return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
            }
            if (cVar == com.tencent.luggage.wxa.cg.c.NO_REFERRER) {
                return ImageDecodeConfig.ReferrerPolicy.NO_REFERRER;
            }
            if (cVar == com.tencent.luggage.wxa.cg.c.ORIGIN) {
                return ImageDecodeConfig.ReferrerPolicy.ORIGIN;
            }
            return ImageDecodeConfig.ReferrerPolicy.NOT_SET;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements com.tencent.luggage.wxa.h.d {

        /* renamed from: a, reason: collision with root package name */
        public int f139998a;

        public c(int i3) {
            this.f139998a = i3;
        }

        public void a(Object... objArr) {
            if (this.f139998a != -1) {
                ((com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class)).a(this.f139998a, objArr);
            }
        }
    }

    public void a(MBRuntime mBRuntime, g gVar, boolean z16) {
        com.tencent.luggage.wxa.w1.b bVar;
        this.f139995c = z16;
        w.d("MicroMsg.MBImageHandlerRegistry", "dl: MBImageHandlerRegistry register ");
        if (z16 && gVar != null && (gVar.h0() instanceof com.tencent.luggage.wxa.r4.d)) {
            bVar = (com.tencent.luggage.wxa.w1.b) ((com.tencent.luggage.wxa.r4.d) gVar.h0()).h(com.tencent.luggage.wxa.w1.b.class);
        } else {
            bVar = null;
        }
        this.f139996d = new WeakReference(bVar);
        BaseImageDecodeService f16 = mBRuntime.f();
        C6699b c6699b = new C6699b(gVar);
        f16.addImageStreamFetcher(new com.tencent.luggage.wxa.t1.a(c6699b), true);
        f16.addImageStreamFetcher(new com.tencent.luggage.wxa.t1.b(c6699b), false);
        f16.addImageStreamFetcher(new com.tencent.luggage.wxa.t1.c(c6699b), false);
        f16.setKvReportDelegate(new c(14883));
        com.tencent.luggage.wxa.t8.a aVar = new com.tencent.luggage.wxa.t8.a();
        aVar.a(8192, 8192);
        f16.setBitmapDecodeSlave(aVar);
    }
}
