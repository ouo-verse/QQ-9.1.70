package com.tencent.luggage.wxa.dm;

import android.graphics.Bitmap;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends e {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements AppBrandSimpleImageLoader.m {
        public a() {
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a(Bitmap bitmap) {
            h.this.a(bitmap);
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m, com.tencent.luggage.wxa.pb.a
        public String b() {
            return h.this.f124383a;
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a() {
            h hVar = h.this;
            hVar.f124385c.a("Failed to load icon via network", hVar);
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void c() {
        }
    }

    public h(String str, d dVar, l lVar) {
        super(str, dVar, lVar);
    }

    @Override // com.tencent.luggage.wxa.dm.e
    public void e() {
        if (this.f124383a != null) {
            AppBrandSimpleImageLoader.instance().load(new a(), this.f124383a, (AppBrandSimpleImageLoader.j) null);
        }
    }
}
