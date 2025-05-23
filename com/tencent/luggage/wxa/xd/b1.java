package com.tencent.luggage.wxa.xd;

import android.util.SparseArray;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b1 extends a {
    public static final int CTRL_INDEX = 215;
    public static final String NAME = "updatePerfData";

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f144738a;

    static {
        SparseArray sparseArray = new SparseArray();
        f144738a = sparseArray;
        sparseArray.put(1378443347, 301);
        sparseArray.put(-380349418, 302);
        sparseArray.put(-869335772, 402);
        sparseArray.put(117036920, 403);
        sparseArray.put(-1654508303, 404);
        sparseArray.put(834843062, 405);
        sparseArray.put(-659273562, 406);
        sparseArray.put(-364572001, 407);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (com.tencent.luggage.wxa.qj.b.d((com.tencent.luggage.wxa.c5.e) dVar.getRuntime()) && optJSONArray != null) {
            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i16);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("key");
                    String optString2 = optJSONObject.optString("value");
                    if (!com.tencent.luggage.wxa.tn.w0.c(optString)) {
                        Integer num = (Integer) f144738a.get(optString.hashCode());
                        if (num != null) {
                            com.tencent.luggage.wxa.qj.b.a((com.tencent.luggage.wxa.c5.e) dVar.getRuntime(), num.intValue(), optString2);
                        } else {
                            com.tencent.luggage.wxa.qj.b.a((com.tencent.luggage.wxa.c5.e) dVar.getRuntime(), optString, optString2);
                        }
                    }
                }
            }
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            return;
        }
        dVar.a(i3, makeReturnJson("fail"));
    }
}
