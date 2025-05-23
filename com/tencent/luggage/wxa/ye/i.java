package com.tencent.luggage.wxa.ye;

import android.content.res.Resources;
import android.text.StaticLayout;
import com.tencent.luggage.wxa.xd.v;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class i extends v {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "measureTextString";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends HashMap {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashMap f145609a;

        public a(HashMap hashMap) {
            this.f145609a = hashMap;
            put("size", hashMap);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        Resources resources;
        JSONObject optJSONObject = jSONObject.optJSONObject("size");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("label");
        if (optJSONObject != null && optJSONObject2 != null) {
            int i3 = Integer.MAX_VALUE;
            int a16 = com.tencent.luggage.wxa.tk.g.a(optJSONObject, "width", Integer.MAX_VALUE);
            if (a16 < 0) {
                a16 = Integer.MAX_VALUE;
            }
            int a17 = com.tencent.luggage.wxa.tk.g.a(optJSONObject, "height", Integer.MAX_VALUE);
            if (a17 >= 0) {
                i3 = a17;
            }
            if (dVar.getContext() == null) {
                resources = Resources.getSystem();
            } else {
                resources = dVar.getContext().getResources();
            }
            com.tencent.luggage.wxa.ye.a aVar = new com.tencent.luggage.wxa.ye.a(resources, a16);
            com.tencent.luggage.wxa.gh.c.a(aVar, optJSONObject2);
            StaticLayout a18 = aVar.a();
            float f16 = 0.0f;
            for (int i16 = 0; i16 < a18.getLineCount(); i16++) {
                f16 = Math.max(f16, a18.getLineWidth(i16));
            }
            float min = Math.min(a18.getHeight(), i3);
            HashMap hashMap = new HashMap(2);
            hashMap.put("width", Float.valueOf(com.tencent.luggage.wxa.tk.g.b((float) Math.ceil(f16))));
            hashMap.put("height", Float.valueOf(com.tencent.luggage.wxa.tk.g.b(min)));
            return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, new a(hashMap));
        }
        return makeReturnJson("fail:invalid data");
    }
}
