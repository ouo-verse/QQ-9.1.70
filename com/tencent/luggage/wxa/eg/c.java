package com.tencent.luggage.wxa.eg;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 64;

    @NotNull
    private static final String NAME = "reportIDKey";

    /* renamed from: a, reason: collision with root package name */
    public static final a f124760a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        int i16;
        if (dVar != null && jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
            if (optJSONArray == null) {
                dVar.a(i3, makeReturnJson("fail"));
                return;
            }
            com.tencent.luggage.wxa.zj.b bVar = (com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class);
            if (bVar == null) {
                dVar.a(i3, makeReturnJson("fail:not supported"));
                return;
            }
            int length = optJSONArray.length();
            int i17 = 0;
            while (i17 < length) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i17);
                    i16 = i17;
                    try {
                        bVar.a(jSONObject2.optInt("id"), jSONObject2.optInt("key"), jSONObject2.optInt("value"), false);
                    } catch (Exception e16) {
                        e = e16;
                        w.b("MicroMsg.JsApiReportIDKey", "parse json failed : %s", e.getMessage());
                        i17 = i16 + 1;
                    }
                } catch (Exception e17) {
                    e = e17;
                    i16 = i17;
                }
                i17 = i16 + 1;
            }
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }
}
