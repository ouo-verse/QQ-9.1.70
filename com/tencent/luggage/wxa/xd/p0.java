package com.tencent.luggage.wxa.xd;

import android.os.Build;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class p0 extends v {
    private static final int CTRL_INDEX = 97;
    private static final String NAME = "getPublicLibVersion";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject) {
        if (!dVar.isRunning()) {
            return makeReturnJson("fail js context not running");
        }
        return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, (Map<String, ? extends Object>) a(dVar));
    }

    public Map a(com.tencent.luggage.wxa.ic.d dVar) {
        HashMap hashMap = new HashMap();
        com.tencent.luggage.wxa.j4.g gVar = (com.tencent.luggage.wxa.j4.g) dVar.a(com.tencent.luggage.wxa.j4.g.class);
        hashMap.put("appDebug", Boolean.valueOf(gVar.f125966l.f151861a != 0));
        hashMap.put("appMd5", com.tencent.luggage.wxa.tn.w0.d(gVar.f125966l.md5));
        hashMap.put("appVersion", Integer.valueOf(gVar.f125966l.pkgVersion));
        com.tencent.luggage.wxa.rc.q i3 = dVar.i();
        if (i3 != null) {
            com.tencent.mm.plugin.appbrand.appcache.a aVar = (com.tencent.mm.plugin.appbrand.appcache.a) i3.e();
            hashMap.put("libDebug", Boolean.valueOf(aVar.f151861a != 0));
            hashMap.put("libMd5", com.tencent.luggage.wxa.tn.w0.d(aVar.md5));
            hashMap.put("libVersion", Integer.valueOf(aVar.pkgVersion));
        }
        hashMap.put(TVKPlayerMsg.PLAYER_CHOICE_SYSTEM, "android");
        hashMap.put("systemVersion", Integer.valueOf(Build.VERSION.SDK_INT));
        return hashMap;
    }
}
