package com.tencent.luggage.wxa.ni;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.hd.a;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.k1.a implements com.tencent.luggage.wxa.hd.b {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f135838a;

    public a(com.tencent.luggage.wxa.ic.g gVar) {
        this.f135838a = gVar;
    }

    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public boolean a(String str) {
        return str != null && str.startsWith("wxblob://");
    }

    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public String b() {
        return "WxBlobImageReader";
    }

    @Override // com.tencent.luggage.wxa.hd.b
    public String c(com.tencent.luggage.wxa.xd.d dVar, String str) {
        if (!a(dVar, str)) {
            return str;
        }
        return w0.d((String) d(str).second);
    }

    public final Pair d(String str) {
        if (w0.c(str)) {
            return Pair.create(null, null);
        }
        int lastIndexOf = str.lastIndexOf("wxblob://");
        if (lastIndexOf < 0) {
            return Pair.create(null, null);
        }
        return Pair.create(str.substring(0, lastIndexOf), str.substring(lastIndexOf));
    }

    @Override // com.tencent.luggage.wxa.k1.a
    public void a(String str, a.c cVar) {
        if (cVar == null) {
            return;
        }
        r P = this.f135838a.P();
        if (P == null) {
            cVar.a(null);
        } else {
            cVar.a(P.readStream((String) d(str).second));
        }
    }

    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public Bitmap a(String str, Rect rect, a.b bVar) {
        r P;
        v privateAbsoluteFile;
        if (!a(str) || (P = this.f135838a.P()) == null || (privateAbsoluteFile = P.getPrivateAbsoluteFile((String) d(str).second)) == null || !privateAbsoluteFile.e()) {
            return null;
        }
        String g16 = privateAbsoluteFile.g();
        if (!g16.startsWith("file://")) {
            g16 = "file://" + g16;
        }
        return AppBrandSimpleImageLoader.instance().findCachedLocal(g16, rect != null ? new com.tencent.luggage.wxa.mi.a(rect.left, rect.top, rect.width(), rect.height()) : null);
    }

    @Override // com.tencent.luggage.wxa.hd.b
    public boolean a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        if (dVar == null || str == null || str.length() == 0) {
            return false;
        }
        return str.startsWith("wxblob://") || w0.d((String) d(str).second).startsWith("wxblob://");
    }
}
