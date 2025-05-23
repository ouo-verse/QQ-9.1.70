package com.tencent.luggage.wxa.l2;

import com.tencent.luggage.wxa.ei.p;
import com.tencent.luggage.wxa.fd.q;
import com.tencent.luggage.wxa.hn.gf;
import com.tencent.luggage.wxa.hn.y5;
import com.tencent.luggage.wxa.hn.z5;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.f1;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.luggage.wxa.yo.g;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.t2.a {
    private static final int CTRL_INDEX = 118;
    private static final String NAME = "refreshSession";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f132968a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f132969b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map f132970c;

        public a(l lVar, int i3, Map map) {
            this.f132968a = lVar;
            this.f132969b = i3;
            this.f132970c = map;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public void a(Object obj) {
            this.f132968a.a(this.f132969b, e.this.makeReturnJson("fail", this.f132970c));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f132972a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f132973b;

        public b(l lVar, int i3) {
            this.f132972a = lVar;
            this.f132973b = i3;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public void a(String str) {
            this.f132972a.a(this.f132973b, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f132975b;

        public c(Map map) {
            this.f132975b = map;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call(z5 z5Var) {
            String str = "fail";
            if (z5Var == null) {
                return e.this.makeReturnJson("fail", this.f132975b);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", "" + z5Var.f129127e.f127384d);
            hashMap.put("expireIn", "" + z5Var.f129128f);
            e eVar = e.this;
            if (z5Var.f129127e.f127384d == 0) {
                str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            }
            return eVar.makeReturnJson(str, hashMap);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void invoke(l lVar, JSONObject jSONObject, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.tencent.luggage.wxa.t2.a
    public boolean b(JSONObject jSONObject) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void invoke(l lVar, JSONObject jSONObject, int i3, p pVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.tencent.luggage.wxa.t2.a
    public void b(f1 f1Var) {
        l lVar = (l) f1Var.f();
        int d16 = f1Var.d();
        q qVar = (q) lVar.a(q.class);
        int i3 = qVar != null ? qVar.f125966l.f151861a : 0;
        HashMap hashMap = new HashMap();
        hashMap.put("errCode", "-1");
        com.tencent.luggage.wxa.xo.d b16 = a(lVar.getAppId(), i3, 0).b(new c(hashMap));
        g gVar = com.tencent.luggage.wxa.yo.d.f146045b;
        b16.a(gVar, new b(lVar, d16)).a(gVar, new a(lVar, d16, hashMap));
    }

    public final com.tencent.luggage.wxa.xo.d a(String str, int i3, int i16) {
        w.d("Luggage.JsApiRefreshSessionStandalone", "refreshSession appId %s, versionType, statScene %d", str, Integer.valueOf(i3), Integer.valueOf(i16));
        y5 y5Var = new y5();
        y5Var.f129069e = str;
        y5Var.f129070f = i3;
        if (i16 > 0) {
            gf gfVar = new gf();
            y5Var.f129071g = gfVar;
            gfVar.f127719e = i16;
        }
        return ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/js-refreshsession", str, y5Var, z5.class);
    }
}
