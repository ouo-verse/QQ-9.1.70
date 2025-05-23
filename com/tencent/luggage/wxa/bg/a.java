package com.tencent.luggage.wxa.bg;

import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 106;
    private static final String NAME = "hideToast";

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bg.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6056a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f122601a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f122602b;

        public RunnableC6056a(l lVar, int i3) {
            this.f122601a = lVar;
            this.f122602b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.f122601a, this.f122602b);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        lVar.a(new RunnableC6056a(lVar, i3));
    }

    public final void a(l lVar, int i3) {
        p pVar;
        try {
            pVar = lVar.getRuntime().Y();
        } catch (Throwable unused) {
            pVar = null;
        }
        if (pVar == null) {
            w.b("MicroMsg.JsApiHideToast", "hideToast uiThread NULL page");
            lVar.a(i3, makeReturnJson("fail:page don't exist"));
            return;
        }
        try {
            if (com.tencent.luggage.wxa.am.a.a(lVar.getRuntime())) {
                lVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            } else {
                lVar.a(i3, makeReturnJson("fail:toast can't be found"));
            }
        } catch (Throwable unused2) {
            lVar.a(i3, makeReturnJson("fail:internal error"));
        }
    }
}
