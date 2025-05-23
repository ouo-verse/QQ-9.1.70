package com.tencent.luggage.wxa.zf;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class i extends com.tencent.luggage.wxa.zf.a {
    private static final int CTRL_INDEX = 258;
    private static final String NAME = "updateMultiPickerView";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends e {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.zf.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC6986a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f146598a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AppBrandMultiOptionsPickerV2.b f146599b;

            public RunnableC6986a(int i3, AppBrandMultiOptionsPickerV2.b bVar) {
                this.f146598a = i3;
                this.f146599b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                AppBrandMultiOptionsPickerV2 appBrandMultiOptionsPickerV2 = (AppBrandMultiOptionsPickerV2) a.this.a(AppBrandMultiOptionsPickerV2.class);
                if (appBrandMultiOptionsPickerV2 == null) {
                    a.this.a("fail picker not exists");
                } else {
                    appBrandMultiOptionsPickerV2.a(this.f146598a, this.f146599b);
                    a.this.a(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                }
            }
        }

        public a() {
        }

        @Override // com.tencent.luggage.wxa.zf.e
        public void b(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("column", -1);
            JSONArray optJSONArray = jSONObject.optJSONArray(HippyControllerProps.ARRAY);
            if (optInt >= 0 && optJSONArray != null && optJSONArray.length() >= 0) {
                try {
                    int length = optJSONArray.length();
                    String[] strArr = new String[length];
                    for (int i3 = 0; i3 < length; i3++) {
                        strArr[i3] = optJSONArray.getString(i3);
                    }
                    a(new RunnableC6986a(optInt, new AppBrandMultiOptionsPickerV2.b(strArr, jSONObject.optInt("current", 0))));
                    return;
                } catch (Exception e16) {
                    w.a("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", e16, "opt params", new Object[0]);
                    a("fail:invalid data");
                    return;
                }
            }
            a("fail:invalid data");
        }

        @Override // com.tencent.luggage.wxa.zf.e
        public void a(JSONObject jSONObject) {
            super.a(jSONObject);
        }
    }

    @Override // com.tencent.luggage.wxa.zf.a, com.tencent.luggage.wxa.xd.a
    /* renamed from: a */
    public void invoke(com.tencent.luggage.wxa.xd.f fVar, JSONObject jSONObject, int i3) {
        new a().a(this, fVar, jSONObject, i3, e());
    }
}
