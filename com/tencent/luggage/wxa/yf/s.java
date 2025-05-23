package com.tencent.luggage.wxa.yf;

import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.math.BigDecimal;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class s extends com.tencent.luggage.wxa.xd.v {
    private static final int CTRL_INDEX = 413;
    public static final String NAME = "scrollWebviewTo";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.v f145750a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145751b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f145752c;

        public a(com.tencent.luggage.wxa.kj.v vVar, int i3, long j3) {
            this.f145750a = vVar;
            this.f145751b = i3;
            this.f145752c = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f145750a.D0() == null) {
                return;
            }
            this.f145750a.D0().a(this.f145751b, this.f145752c);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject) {
        com.tencent.luggage.wxa.kj.v J;
        if (dVar instanceof com.tencent.luggage.wxa.kj.v) {
            J = (com.tencent.luggage.wxa.kj.v) dVar;
        } else {
            J = dVar instanceof com.tencent.luggage.wxa.ic.l ? ((com.tencent.luggage.wxa.ic.l) dVar).J() : null;
        }
        if (J == null) {
            return makeReturnJson("fail:page don't exist");
        }
        long optLong = jSONObject.optLong("duration", 300L);
        if (!jSONObject.has("scrollTop")) {
            return makeReturnJson("fail:invalid data");
        }
        try {
            J.a(new a(J, Math.round(com.tencent.luggage.wxa.tk.g.a(new BigDecimal(jSONObject.getString("scrollTop")).floatValue())), optLong));
            return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.Jsapi_scrollWebviewTo", "opt scrollTop, e = %s", e16);
            return makeReturnJson("fail:invalid data " + w0.d(e16.getMessage()));
        }
    }
}
