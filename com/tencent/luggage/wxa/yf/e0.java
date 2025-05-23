package com.tencent.luggage.wxa.yf;

import com.tencent.luggage.wxa.qo.a;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 389;
    public static final String NAME = "setTabBarBadge";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.l f145658a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145659b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f145660c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f145661d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f145662e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f145663f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f145664g;

        public b(com.tencent.luggage.wxa.ic.l lVar, int i3, int i16, String str, String str2, String str3, String str4) {
            this.f145658a = lVar;
            this.f145659b = i3;
            this.f145660c = i16;
            this.f145661d = str;
            this.f145662e = str2;
            this.f145663f = str3;
            this.f145664g = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.kj.n currentPage = this.f145658a.getRuntime().Y().getCurrentPage();
            if (!(currentPage instanceof com.tencent.luggage.wxa.kj.g)) {
                this.f145658a.a(this.f145659b, e0.this.makeReturnJson("fail:not TabBar page"));
            } else {
                ((com.tencent.luggage.wxa.kj.g) currentPage).getTabBar().a(this.f145660c, this.f145661d, this.f145662e, this.f145663f, this.f145664g);
                this.f145658a.a(this.f145659b, e0.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject, int i3) {
        String str;
        try {
            int i16 = jSONObject.getInt("index");
            String optString = jSONObject.optString("type", "none");
            String optString2 = jSONObject.optString("badgeValue", "");
            String optString3 = jSONObject.optString("badgeColor", "");
            String optString4 = jSONObject.optString("badgeTextColor", "");
            com.tencent.luggage.wxa.dn.a aVar = new com.tencent.luggage.wxa.dn.a();
            aVar.f124395a = false;
            com.tencent.luggage.wxa.ro.b.a(optString2).a(a.EnumC6654a.MODE_CHINESE_AS_2).b(4).a(true).a(new a(aVar));
            if (aVar.f124395a) {
                str = "\u2026";
            } else {
                str = optString2;
            }
            b bVar = new b(lVar, i3, i16, optString, str, optString3, optString4);
            if (!lVar.getRuntime().m1()) {
                bVar.run();
            } else {
                lVar.getRuntime().c(bVar);
            }
        } catch (Exception unused) {
            lVar.a(i3, makeReturnJson("fail"));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.dn.a f145656a;

        public a(com.tencent.luggage.wxa.dn.a aVar) {
            this.f145656a = aVar;
        }

        @Override // com.tencent.luggage.wxa.ro.b.a
        public void a(String str) {
            this.f145656a.f124395a = true;
        }

        @Override // com.tencent.luggage.wxa.ro.b.a
        public void b(String str) {
        }

        @Override // com.tencent.luggage.wxa.ro.b.a
        public void c(String str) {
        }
    }
}
