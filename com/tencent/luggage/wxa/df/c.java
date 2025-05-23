package com.tencent.luggage.wxa.df;

import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ol.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 70;
    public static final String NAME = "hideKeyboard";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f124203a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Integer f124204b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f124205c;

        public a(com.tencent.luggage.wxa.xd.d dVar, Integer num, int i3) {
            this.f124203a = dVar;
            this.f124204b = num;
            this.f124205c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (!this.f124203a.isRunning()) {
                return;
            }
            if (r.a(c.this.b(this.f124203a), this.f124204b)) {
                str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            } else {
                str = "fail:input not exists";
            }
            this.f124203a.a(this.f124205c, c.this.makeReturnJson(str));
        }
    }

    public final v b(com.tencent.luggage.wxa.xd.d dVar) {
        if (dVar instanceof v) {
            return (v) dVar;
        }
        if (dVar instanceof l) {
            return ((l) dVar).getRuntime().Y().getCurrentPage().getCurrentPageView();
        }
        w.b("MicroMsg.JsApiHideKeyboard", "invalid component type while calling hide keyboard");
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        Integer num;
        try {
            num = Integer.valueOf(jSONObject.getInt("inputId"));
        } catch (JSONException unused) {
            num = null;
        }
        com.tencent.luggage.wxa.tk.l.a(new a(dVar, num, i3));
    }
}
