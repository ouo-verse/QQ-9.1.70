package com.tencent.luggage.wxa.yf;

import com.tencent.luggage.wxa.yf.i;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqmini.miniapp.core.EventListener;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class i extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 15;
    public static final String NAME = "navigateBack";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f145698a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145699b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f145700c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f145701d;

        public a(com.tencent.luggage.wxa.ic.d dVar, int i3, JSONObject jSONObject, JSONObject jSONObject2) {
            this.f145698a = dVar;
            this.f145699b = i3;
            this.f145700c = jSONObject;
            this.f145701d = jSONObject2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.kj.p Y = this.f145698a.getRuntime().Y();
            int renderPagesCount = Y.getRenderPagesCount();
            if (renderPagesCount <= 1) {
                this.f145698a.a(this.f145699b, i.this.makeReturnJson(com.tencent.luggage.wxa.af.j.f121382b));
                return;
            }
            int optInt = this.f145700c.optInt(EventListener.KEY_DELTA, 1);
            if (optInt >= renderPagesCount) {
                optInt = renderPagesCount - 1;
            }
            JSONObject jSONObject = this.f145701d;
            final com.tencent.luggage.wxa.ic.d dVar = this.f145698a;
            final int i3 = this.f145699b;
            Y.a(optInt, "scene_jsapi_navigate_back", jSONObject, new com.tencent.luggage.wxa.nj.f() { // from class: w41.a
                @Override // com.tencent.luggage.wxa.nj.f
                public final void a(boolean z16) {
                    i.a.this.a(dVar, i3, z16);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(com.tencent.luggage.wxa.ic.d dVar, int i3, boolean z16) {
            if (z16) {
                dVar.a(i3, i.this.makeReturnJson("fail:navigateBack intercepted"));
            } else {
                dVar.a(i3, i.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        dVar.a(new a(dVar, i3, jSONObject, jSONObject.optJSONObject("singlePageData")));
    }
}
