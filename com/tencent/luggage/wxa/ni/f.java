package com.tencent.luggage.wxa.ni;

import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.hd.a;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import java.io.InputStream;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.k1.c {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Function {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.c f135843a;

        public b(a.c cVar) {
            this.f135843a = cVar;
        }

        @Override // androidx.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void apply(InputStream inputStream) {
            a.c cVar = this.f135843a;
            if (cVar != null) {
                cVar.a(inputStream);
                return null;
            }
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.k1.c, com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.startsWith("http://") || lowerCase.startsWith("https://");
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements AppBrandSimpleImageLoader.m {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.b f135841a;

        public a(a.b bVar) {
            this.f135841a = bVar;
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a(Bitmap bitmap) {
            if (this.f135841a == null) {
                return;
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f135841a.a(bitmap);
            } else {
                this.f135841a.a(null);
            }
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m, com.tencent.luggage.wxa.pb.a
        public String b() {
            return "WxaIcon" + hashCode();
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void a() {
            a.b bVar = this.f135841a;
            if (bVar == null) {
                return;
            }
            bVar.a(null);
        }

        @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
        public void c() {
        }
    }

    @Override // com.tencent.luggage.wxa.k1.c, com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public Bitmap a(String str, Rect rect, a.b bVar) {
        if (!a(str)) {
            return null;
        }
        com.tencent.luggage.wxa.mi.a aVar = rect != null ? new com.tencent.luggage.wxa.mi.a(rect.left, rect.top, rect.width(), rect.height()) : null;
        Bitmap findCachedLocal = AppBrandSimpleImageLoader.instance().findCachedLocal(str, aVar);
        if (findCachedLocal == null) {
            AppBrandSimpleImageLoader.instance().load(new a(bVar), str, null, aVar);
        }
        return findCachedLocal;
    }

    @Override // com.tencent.luggage.wxa.k1.a, com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public void a(String str, Map map, a.c cVar) {
        AppBrandSimpleImageLoader.instance().loadIntoDiskCache(str, map, new b(cVar));
    }
}
