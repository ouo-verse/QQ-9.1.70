package com.tencent.luggage.wxa.yf;

import com.tencent.luggage.wxa.xd.o1;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h extends com.tencent.luggage.wxa.xd.v {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "initReady";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f145691a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f145692b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f145693c;

        public a(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, String str) {
            this.f145691a = dVar;
            this.f145692b = jSONObject;
            this.f145693c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            boolean z16;
            String str;
            com.tencent.luggage.wxa.kj.v a16 = o1.a(this.f145691a);
            boolean optBoolean = this.f145692b.optBoolean("ignoreWebviewPreload", false);
            if (a16 != null) {
                i3 = a16.getComponentId();
            } else {
                i3 = 0;
            }
            if (a16 != null && a16.isRunning()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (a16 != null) {
                str = a16.A0();
            } else {
                str = "";
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiInitReady", "invoke, appId:%s, webviewId:%s, isRunning:%b, ignoreWebviewPreload:%b, url:%s", this.f145693c, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(optBoolean), str);
            if (!z16) {
                return;
            }
            if (!optBoolean) {
                a16.getRuntime().Y().c(a16);
            }
            a16.e(h.NAME);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject) {
        dVar.getRuntime().a((Runnable) new a(dVar, jSONObject, dVar.getAppId()), true);
        return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
    }
}
