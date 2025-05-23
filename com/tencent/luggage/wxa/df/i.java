package com.tencent.luggage.wxa.df;

import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ol.g1;
import com.tencent.luggage.wxa.ol.l;
import com.tencent.luggage.wxa.ol.m;
import com.tencent.luggage.wxa.ol.m0;
import com.tencent.luggage.wxa.ol.p0;
import com.tencent.luggage.wxa.ol.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends com.tencent.luggage.wxa.df.a {
    private static final int CTRL_INDEX = 112;
    private static final String NAME = "updateInput";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f124241a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f124242b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.vl.i f124243c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f124244d;

        public a(v vVar, int i3, com.tencent.luggage.wxa.vl.i iVar, int i16) {
            this.f124241a = vVar;
            this.f124242b = i3;
            this.f124243c = iVar;
            this.f124244d = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.a().a(this.f124241a, this.f124242b, this.f124243c)) {
                this.f124241a.a(this.f124244d, i.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                return;
            }
            p0 a16 = r.a(this.f124241a, this.f124242b);
            if (a16 instanceof l) {
                ((l) a16).a(this.f124243c);
                this.f124241a.a(this.f124244d, i.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            } else {
                Locale locale = Locale.US;
                w.b("MicroMsg.AppBrand.JsApiUpdateInput", String.format(locale, "AppBrandInputInvokeHandler with inputID(%d) 404", Integer.valueOf(this.f124242b)));
                this.f124241a.a(this.f124244d, i.this.makeReturnJson(String.format(locale, "fail found no input with %d", Integer.valueOf(this.f124242b))));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(v vVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.vl.i iVar = new com.tencent.luggage.wxa.vl.i();
        if (!a(iVar, jSONObject, vVar, i3)) {
            return;
        }
        try {
            int i16 = jSONObject.getInt("inputId");
            Integer num = iVar.f143664b;
            if (num != null && num.intValue() < 0) {
                iVar.f143664b = 0;
            }
            Integer num2 = iVar.f143665c;
            if (num2 != null && num2.intValue() < 0) {
                iVar.f143665c = 0;
            }
            Object opt = jSONObject.opt("data");
            if (opt != null && JSONObject.NULL != opt) {
                a(i16, opt.toString());
            }
            g1.a(jSONObject, iVar);
            m0.a(jSONObject, iVar);
            com.tencent.luggage.wxa.tk.l.a(new a(vVar, i16, iVar, i3));
        } catch (JSONException unused) {
            vVar.a(i3, makeReturnJson("fail:invalid data"));
        }
    }

    @Override // com.tencent.luggage.wxa.df.a
    public boolean e() {
        return true;
    }
}
