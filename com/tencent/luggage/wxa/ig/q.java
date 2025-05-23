package com.tencent.luggage.wxa.ig;

import android.os.Process;
import com.tencent.luggage.wxa.rc.p;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q extends com.tencent.luggage.wxa.xd.v {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorageSync";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        String str;
        String str2;
        int i3;
        String optString = jSONObject.optString("key");
        int optInt = jSONObject.optInt("storageId", 0);
        if (w0.c(optString)) {
            return makeReturnJson(com.tencent.luggage.wxa.af.k.f121388d);
        }
        if (com.tencent.luggage.wxa.rc.v.a(optInt)) {
            return makeReturnJson(com.tencent.luggage.wxa.af.k.f121386b);
        }
        String appId = dVar.getAppId();
        if (w0.c(appId)) {
            return makeReturnJson("fail:appID is empty");
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class);
        int i16 = qVar.f125967m;
        String str3 = qVar.D;
        if (i16 != 1) {
            Object[] a16 = ((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).a(dVar.getAppId(), i16, str3).a(optInt, appId, optString);
            if (((p.a) a16[0]) == p.a.NONE) {
                str = (String) a16[1];
                str2 = (String) a16[2];
            } else {
                str = null;
                str2 = null;
            }
            i3 = 2;
        } else {
            r rVar = new r();
            rVar.f130310c = appId;
            rVar.f130311d = optInt;
            rVar.f130317j = optString;
            rVar.f130320m = "" + Process.myPid() + "" + super.hashCode();
            rVar.c();
            str = rVar.f130318k;
            str2 = rVar.f130319l;
            i3 = 1;
        }
        a(i3, com.tencent.luggage.wxa.rc.v.a(optString, str), currentTimeMillis, qVar);
        String str4 = str == null ? "fail:data not found" : FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        hashMap.put("data", str);
        hashMap.put("dataType", str2 != null ? str2 : "");
        return makeReturnJson(str4, hashMap);
    }

    public final void a(int i3, int i16, long j3, com.tencent.luggage.wxa.fd.q qVar) {
        com.tencent.luggage.wxa.rc.u.a(i3, 2, i16, 1, System.currentTimeMillis() - j3, qVar);
    }
}
