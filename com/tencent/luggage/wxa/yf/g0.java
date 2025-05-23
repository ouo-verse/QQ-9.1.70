package com.tencent.luggage.wxa.yf;

import com.tencent.luggage.wxa.fd.b;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 417;
    public static final String NAME = "setTabBarStyle";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.l f145684a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145685b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f145686c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f145687d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f145688e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f145689f;

        public a(com.tencent.luggage.wxa.ic.l lVar, int i3, String str, String str2, String str3, String str4) {
            this.f145684a = lVar;
            this.f145685b = i3;
            this.f145686c = str;
            this.f145687d = str2;
            this.f145688e = str3;
            this.f145689f = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.kj.n currentPage = this.f145684a.getRuntime().Y().getCurrentPage();
            if (!(currentPage instanceof com.tencent.luggage.wxa.kj.g)) {
                this.f145684a.a(this.f145685b, g0.this.makeReturnJson("fail:not TabBar page"));
            } else {
                ((com.tencent.luggage.wxa.kj.g) currentPage).getTabBar().a(this.f145686c, this.f145687d, this.f145688e, this.f145689f);
                this.f145684a.a(this.f145685b, g0.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject, int i3) {
        b.k i16 = lVar.getRuntime().E().i();
        a aVar = new a(lVar, i3, jSONObject.optString("color", i16.f125669b), jSONObject.optString("selectedColor", i16.f125670c), jSONObject.optString("backgroundColor", i16.f125671d), jSONObject.optString(NodeProps.BORDER_STYLES, i16.f125672e));
        if (!lVar.getRuntime().m1()) {
            aVar.run();
        } else {
            lVar.getRuntime().c(aVar);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }
}
