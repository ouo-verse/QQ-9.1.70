package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.QAdBasicInterface;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.b;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdRouteJsApi extends a {
    public QAdRouteJsApi(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.a aVar, b bVar) {
        super(aVar, bVar);
    }

    @QAdBasicInterface
    public void hasApp(String str, String str2) {
        String str3;
        if (pw2.b.b(pw2.b.f427748a, str)) {
            str3 = "true";
        } else {
            str3 = "false";
        }
        getJsBridge().a(str2 + "(" + str3 + ")");
    }

    @QAdBasicInterface
    public void openApp(String str) {
        pw2.b.g(qv2.b.a(), str);
    }
}
