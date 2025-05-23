package com.tencent.luggage.wxa.ni;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.luggage.wxa.hd.a;
import com.tencent.luggage.wxa.kj.s;
import com.tencent.luggage.wxa.mc.k0;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends com.tencent.luggage.wxa.k1.a implements com.tencent.luggage.wxa.hd.b {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f135845a;

    public g(com.tencent.luggage.wxa.ic.g gVar) {
        this.f135845a = gVar;
    }

    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public boolean a(String str) {
        return str != null && str.startsWith("wxapkg://");
    }

    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public String b() {
        return "WxaPkgImageReader";
    }

    @Override // com.tencent.luggage.wxa.hd.b
    public String c(com.tencent.luggage.wxa.xd.d dVar, String str) {
        if (!a(dVar, str)) {
            return str;
        }
        return "wxapkg://icon?appId=" + dVar.getAppId() + ContainerUtils.FIELD_DELIMITER + "path=" + Uri.encode(str);
    }

    public final Pair d(String str) {
        Uri parse = Uri.parse(str);
        return Pair.create(parse.getQueryParameter("appId"), parse.getQueryParameter("path"));
    }

    @Override // com.tencent.luggage.wxa.k1.a
    public void a(String str, a.c cVar) {
        if (cVar == null) {
            return;
        }
        String str2 = (String) d(str).second;
        if (TextUtils.isEmpty(str2)) {
            cVar.a(null);
        } else {
            cVar.a(k0.d(this.f135845a, str2));
        }
    }

    @Override // com.tencent.luggage.wxa.hd.a.InterfaceC6261a
    public Bitmap a(String str, Rect rect, a.b bVar) {
        if (!a(str)) {
            return null;
        }
        String str2 = (String) d(str).second;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        Bitmap a16 = s.a(this.f135845a, Uri.decode(str2));
        return rect != null ? new com.tencent.luggage.wxa.mi.b(rect.left, rect.top, rect.width(), rect.height()).b(a16) : a16;
    }

    @Override // com.tencent.luggage.wxa.hd.b
    public boolean a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        return (dVar == null || str == null || str.length() == 0 || str.startsWith("wxapkg://") || str.startsWith("http://") || str.startsWith("https://") || str.startsWith("wxfile://") || str.contains(QzoneWebViewOfflinePlugin.STR_DEVIDER)) ? false : true;
    }
}
