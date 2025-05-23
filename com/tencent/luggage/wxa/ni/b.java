package com.tencent.luggage.wxa.ni;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.hd.a;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.k1.a implements com.tencent.luggage.wxa.hd.b {
    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public boolean a(String str) {
        return str != null && str.startsWith("wxfile://ad");
    }

    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public String b() {
        return "WxFileAdImageReader";
    }

    @Override // com.tencent.luggage.wxa.hd.b
    public String c(com.tencent.luggage.wxa.xd.d dVar, String str) {
        a(dVar, str);
        return str;
    }

    @Override // com.tencent.luggage.wxa.k1.a
    public void a(String str, a.c cVar) {
        if (!a(str)) {
            w.h("MicroMsg.WxFileAdImageReader", "openRead, not match, url:%s", str);
            return;
        }
        if (cVar == null) {
            return;
        }
        com.tencent.luggage.wxa.jc.e eVar = (com.tencent.luggage.wxa.jc.e) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.jc.e.class);
        if (eVar == null) {
            w.d("MicroMsg.WxFileAdImageReader", "openRead, no ad service");
            return;
        }
        r mDefaultFileSystem = eVar.getMDefaultFileSystem();
        if (mDefaultFileSystem == null) {
            w.d("MicroMsg.WxFileAdImageReader", "openRead, no ad file system");
        } else {
            cVar.a(mDefaultFileSystem.readStream(str));
        }
    }

    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public Bitmap a(String str, Rect rect, a.b bVar) {
        if (!a(str)) {
            w.h("MicroMsg.WxFileAdImageReader", "read, not match, url:%s", str);
            return null;
        }
        com.tencent.luggage.wxa.jc.e eVar = (com.tencent.luggage.wxa.jc.e) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.jc.e.class);
        if (eVar == null) {
            w.d("MicroMsg.WxFileAdImageReader", "read, no ad service");
            return null;
        }
        r mDefaultFileSystem = eVar.getMDefaultFileSystem();
        if (mDefaultFileSystem == null) {
            w.d("MicroMsg.WxFileAdImageReader", "read, no ad file system");
            return null;
        }
        v absoluteFile = mDefaultFileSystem.getAbsoluteFile(str);
        if (absoluteFile != null && absoluteFile.e()) {
            String g16 = absoluteFile.g();
            if (!g16.startsWith("file://")) {
                g16 = "file://" + g16;
            }
            w.h("MicroMsg.WxFileAdImageReader", "read, url:%s, path:%s", str, g16);
            return AppBrandSimpleImageLoader.instance().findCachedLocal(g16, rect != null ? new com.tencent.luggage.wxa.mi.a(rect.left, rect.top, rect.width(), rect.height()) : null);
        }
        w.h("MicroMsg.WxFileAdImageReader", "read, file not exist, url:%s", str);
        return null;
    }

    @Override // com.tencent.luggage.wxa.hd.b
    public boolean a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        if (dVar == null || str == null || str.length() == 0) {
            return false;
        }
        return str.startsWith("wxfile://ad");
    }
}
