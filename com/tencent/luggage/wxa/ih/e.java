package com.tencent.luggage.wxa.ih;

import com.tencent.luggage.wxa.ih.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 469;
    public static final String NAME = "getAvailableAudioSources";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        String str;
        Object[] objArr = new Object[1];
        if (jSONObject != null) {
            str = jSONObject.toString();
        } else {
            str = "";
        }
        objArr[0] = str;
        w.d("MicroMsg.JsApiGetAvailableAudioSources", "getAvailableAudioSources data:%s", objArr);
        ArrayList arrayList = new ArrayList();
        arrayList.add(d.a.AUTO.f130380b);
        arrayList.add(d.a.MIC.f130380b);
        arrayList.add(d.a.CAMCORDER.f130380b);
        arrayList.add(d.a.VOICE_RECOGNITION.f130380b);
        arrayList.add(d.a.VOICE_COMMUNICATION.f130380b);
        if (com.tencent.luggage.wxa.aa.a.c(24)) {
            arrayList.add(d.a.UNPROCESSED.f130380b);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put((String) it.next());
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("audioSources", jSONArray);
        w.d("MicroMsg.JsApiGetAvailableAudioSources", "getAvailableAudioSources ret:%s", hashMap.toString());
        dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
    }
}
