package com.tencent.luggage.wxa.ig;

import android.text.TextUtils;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class o extends com.tencent.luggage.wxa.xd.v {
    public static final int CTRL_INDEX = 113;
    public static final String NAME = "getStorageInfoSync";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        ArrayList arrayList;
        int i3;
        int i16;
        int i17;
        int i18 = 0;
        int optInt = jSONObject.optInt("storageId", 0);
        if (com.tencent.luggage.wxa.rc.v.a(optInt)) {
            return makeReturnJson(com.tencent.luggage.wxa.af.k.f121386b);
        }
        if (dVar.isRunning() && !TextUtils.isEmpty(dVar.getAppId())) {
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class);
            int i19 = qVar.f125967m;
            String str = qVar.D;
            if (i19 != 1) {
                Object[] a16 = ((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).a(dVar.getAppId(), i19, str).a(optInt, dVar.getAppId());
                arrayList = (ArrayList) a16[0];
                i16 = (int) Math.ceil(((Integer) a16[1]).doubleValue() / 1000.0d);
                i17 = (int) Math.ceil(((Integer) a16[2]).doubleValue() / 1000.0d);
                i3 = 2;
            } else {
                p pVar = new p();
                pVar.f130304c = dVar.getAppId();
                pVar.f130305d = optInt;
                pVar.c();
                arrayList = pVar.f130306e;
                i3 = 1;
                i16 = pVar.f130307f;
                i17 = pVar.f130308g;
            }
            int i26 = i16 * 1000;
            if (arrayList != null) {
                i18 = arrayList.size();
            }
            com.tencent.luggage.wxa.rc.u.a(i3, 3, i26, i18, System.currentTimeMillis() - currentTimeMillis, qVar);
            hashMap.put("keys", arrayList);
            hashMap.put("currentSize", Integer.valueOf(i16));
            hashMap.put("limitSize", Integer.valueOf(i17));
            return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
        }
        com.tencent.luggage.wxa.tn.w.b("Luggage.FULL.JsApiGetStorageInfoSync", "invoke with storageId(%s) but service destroyed", Integer.valueOf(optInt));
        return "fail:internal error";
    }
}
