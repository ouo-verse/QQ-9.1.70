package com.tencent.luggage.wxa.yf;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.wxa.kl.i;
import com.tencent.luggage.wxa.xd.o1;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a0 extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 238;
    private static final String NAME = "setNavigationBarRightButton";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends com.tencent.luggage.wxa.dm.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.i f145630a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145631b;

        public a(com.tencent.luggage.wxa.xd.i iVar, int i3) {
            this.f145630a = iVar;
            this.f145631b = i3;
        }

        @Override // com.tencent.luggage.wxa.dm.d
        public void a(String str, com.tencent.luggage.wxa.dm.e eVar) {
            super.a(str, eVar);
            this.f145630a.a(this.f145631b, a0.this.makeReturnJson("fail iconPath not found"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends com.tencent.luggage.wxa.dm.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kj.v f145633a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.i f145634b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f145635c;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.tencent.luggage.wxa.oj.d.a(b.this.f145633a);
            }
        }

        public b(com.tencent.luggage.wxa.kj.v vVar, com.tencent.luggage.wxa.xd.i iVar, int i3) {
            this.f145633a = vVar;
            this.f145634b = iVar;
            this.f145635c = i3;
        }

        @Override // com.tencent.luggage.wxa.dm.f
        public void a(Bitmap bitmap, com.tencent.luggage.wxa.dm.e eVar) {
            super.a(bitmap, eVar);
            if (this.f145633a.isRunning()) {
                this.f145633a.W().a(bitmap, new a());
            }
            this.f145634b.a(this.f145635c, a0.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    public a0() {
        com.tencent.luggage.wxa.rj.a.a(NAME);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.xd.i iVar, JSONObject jSONObject, int i3) {
        com.tencent.luggage.wxa.kj.v b16 = b(iVar);
        com.tencent.luggage.wxa.ic.l b17 = o1.b(iVar);
        boolean optBoolean = jSONObject.optBoolean("hide", false);
        if (b16 == null) {
            iVar.a(i3, makeReturnJson("fail:page don't exist"));
            com.tencent.luggage.wxa.tn.w.f("JsApiSetNavigationBarRightButton", "onInvoke: page not exist");
            return;
        }
        if (b17 == null) {
            iVar.a(i3, makeReturnJson("fail:internal error invalid js component"));
            com.tencent.luggage.wxa.tn.w.f("JsApiSetNavigationBarRightButton", "onInvoke: service not AppBrandService");
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("JsApiSetNavigationBarRightButton", "onInvoke: hide=" + optBoolean + ", appId=" + b16.getAppId());
        b16.b(optBoolean ^ true, i.a.EnumC6399a.JsApi);
        if (!optBoolean && e()) {
            String optString = jSONObject.optString("iconPath");
            if (!TextUtils.isEmpty(optString)) {
                com.tencent.luggage.wxa.dm.i iVar2 = new com.tencent.luggage.wxa.dm.i(optString, new a(iVar, i3), b17);
                iVar2.a(new b(b16, iVar, i3));
                iVar2.e();
                return;
            }
            iVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            return;
        }
        iVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }

    public com.tencent.luggage.wxa.kj.v b(com.tencent.luggage.wxa.xd.d dVar) {
        if (dVar instanceof com.tencent.luggage.wxa.kj.v) {
            return (com.tencent.luggage.wxa.kj.v) dVar;
        }
        return ((com.tencent.luggage.wxa.ic.l) dVar).J();
    }

    public boolean e() {
        return true;
    }
}
