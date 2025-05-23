package com.tencent.luggage.wxa.ni;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.hd.a;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.k1.a implements com.tencent.luggage.wxa.hd.b {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f135839a;

    public c(com.tencent.luggage.wxa.ic.g gVar) {
        this.f135839a = gVar;
    }

    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public boolean a(String str) {
        return (str == null || !str.startsWith("wxfile://") || str.startsWith("wxfile://ad")) ? false : true;
    }

    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public String b() {
        return "WxFileImageReader";
    }

    @Override // com.tencent.luggage.wxa.hd.b
    public String c(com.tencent.luggage.wxa.xd.d dVar, String str) {
        if (!a(dVar, str)) {
            return str;
        }
        return str + "?appId=" + dVar.getAppId();
    }

    public final Pair d(String str) {
        int lastIndexOf = str.lastIndexOf("?appId=");
        return Pair.create(str.substring(lastIndexOf + 7), str.substring(0, lastIndexOf));
    }

    @Override // com.tencent.luggage.wxa.k1.a
    public void a(String str, a.c cVar) {
        if (cVar == null) {
            return;
        }
        r P = this.f135839a.P();
        if (P == null) {
            cVar.a(null);
        } else {
            cVar.a(P.readStream((String) d(str).second));
        }
    }

    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public Bitmap a(String str, Rect rect, a.b bVar) {
        r P;
        v absoluteFile;
        if (!a(str) || (P = this.f135839a.P()) == null || (absoluteFile = P.getAbsoluteFile((String) d(str).second)) == null || !absoluteFile.e()) {
            return null;
        }
        String g16 = absoluteFile.g();
        if (!g16.startsWith("file://")) {
            g16 = "file://" + g16;
        }
        return AppBrandSimpleImageLoader.instance().findCachedLocal(g16, rect != null ? new com.tencent.luggage.wxa.mi.a(rect.left, rect.top, rect.width(), rect.height()) : null);
    }

    @Override // com.tencent.luggage.wxa.hd.b
    public boolean a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        return (dVar == null || str == null || str.length() == 0 || !str.startsWith("wxfile://") || str.startsWith("wxfile://ad")) ? false : true;
    }
}
