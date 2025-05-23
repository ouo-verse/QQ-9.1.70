package com.tencent.luggage.wxa.yf;

import android.util.Pair;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 418;
    public static final String NAME = "setTabBarItem";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.l f145669a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145670b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f145671c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f145672d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f145673e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f145674f;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.yf.f0$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C6954a extends com.tencent.luggage.wxa.dm.d {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.dm.a f145676a;

            public C6954a(com.tencent.luggage.wxa.dm.a aVar) {
                this.f145676a = aVar;
            }

            @Override // com.tencent.luggage.wxa.dm.d
            public void a(String str, com.tencent.luggage.wxa.dm.e eVar) {
                super.a(str, eVar);
                com.tencent.luggage.wxa.dm.a aVar = this.f145676a;
                a aVar2 = a.this;
                int i3 = aVar2.f145672d;
                aVar.b(i3, aVar2.f145673e, (com.tencent.luggage.wxa.dm.e) ((Pair) aVar.f124333g.get(i3)).first, null);
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class b extends com.tencent.luggage.wxa.dm.d {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.dm.a f145678a;

            public b(com.tencent.luggage.wxa.dm.a aVar) {
                this.f145678a = aVar;
            }

            @Override // com.tencent.luggage.wxa.dm.d
            public void a(String str, com.tencent.luggage.wxa.dm.e eVar) {
                super.a(str, eVar);
                com.tencent.luggage.wxa.dm.a aVar = this.f145678a;
                a aVar2 = a.this;
                int i3 = aVar2.f145672d;
                aVar.b(i3, aVar2.f145673e, null, (com.tencent.luggage.wxa.dm.e) ((Pair) aVar.f124333g.get(i3)).second);
            }
        }

        public a(com.tencent.luggage.wxa.ic.l lVar, int i3, String str, int i16, String str2, String str3) {
            this.f145669a = lVar;
            this.f145670b = i3;
            this.f145671c = str;
            this.f145672d = i16;
            this.f145673e = str2;
            this.f145674f = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.kj.n currentPage = this.f145669a.getRuntime().Y().getCurrentPage();
            if (!(currentPage instanceof com.tencent.luggage.wxa.kj.g)) {
                this.f145669a.a(this.f145670b, f0.this.makeReturnJson("fail:not TabBar page"));
                return;
            }
            com.tencent.luggage.wxa.dm.a tabBar = ((com.tencent.luggage.wxa.kj.g) currentPage).getTabBar();
            tabBar.a(this.f145672d, this.f145673e, tabBar.f124327a.a(this.f145671c, new C6954a(tabBar), this.f145669a, this.f145672d), tabBar.f124327a.a(this.f145674f, new b(tabBar), this.f145669a, this.f145672d));
            this.f145669a.a(this.f145670b, f0.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject, int i3) {
        try {
            int i16 = jSONObject.getInt("index");
            a aVar = new a(lVar, i3, jSONObject.optString("iconPath", ""), i16, jSONObject.optString("text", null), jSONObject.optString("selectedIconPath", ""));
            if (!lVar.getRuntime().m1()) {
                aVar.run();
            } else {
                lVar.getRuntime().c(aVar);
            }
        } catch (Exception unused) {
            lVar.a(i3, makeReturnJson("fail:invalid data"));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }
}
