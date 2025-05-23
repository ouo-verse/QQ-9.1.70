package com.tencent.luggage.wxa.d3;

import com.tencent.luggage.wxa.bj.c;
import com.tencent.luggage.wxa.hn.ei;
import com.tencent.luggage.wxa.hn.m0;
import com.tencent.luggage.wxa.hn.n0;
import com.tencent.luggage.wxa.j4.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.y;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.luggage.wxa.y8.h;
import com.tencent.luggage.wxa.yo.d;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 66;
    public static final String NAME = "reportSubmitForm";

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.d3.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6127a implements e.c {
        public C6127a() {
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public void a(String str) {
            w.d("MicroMsg.JsApiReportSubmitForm", "reportSubmitForm result:%s", str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.uo.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call(n0 n0Var) {
            w.d("MicroMsg.JsApiReportSubmitForm", "resp errCode:%d", Integer.valueOf(n0Var.f128743d.f127731d));
            if (n0Var.f128743d.f127731d == 0) {
                return FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            }
            return "fail";
        }
    }

    public static String a(com.tencent.luggage.wxa.m4.b bVar) {
        return y.a(StringUtils.join((Object[]) new String[]{bVar.getAppId(), new h(bVar.getRuntime().S().f130798j0).toString(), "" + System.currentTimeMillis()}, '#'));
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.m4.b bVar, JSONObject jSONObject, int i3) {
        String a16 = a(bVar);
        String B0 = bVar.B0();
        g j06 = bVar.getRuntime().j0();
        String str = j06.f125956b;
        int a17 = j06.a();
        int i16 = j06.f125966l.pkgVersion;
        w.d("MicroMsg.JsApiReportSubmitForm", "reportSubmitForm formId:%s", a16);
        a(1, str, a16, B0, a17, i16).b(new b()).a(d.f146045b, new C6127a());
        HashMap hashMap = new HashMap();
        hashMap.put("formId", a16);
        bVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
    }

    public final com.tencent.luggage.wxa.xo.d a(int i3, String str, String str2, String str3, int i16, int i17) {
        m0 m0Var = new m0();
        m0Var.f128101e = new LinkedList();
        ei eiVar = new ei();
        eiVar.f127581d = i3;
        eiVar.f127582e = str;
        eiVar.f127583f = str2;
        eiVar.f127584g = str3;
        eiVar.f127585h = i16;
        eiVar.f127586i = i17;
        m0Var.f128101e.add(eiVar);
        return ((c) com.tencent.luggage.wxa.h1.e.a(c.class)).b("/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent", str, m0Var, n0.class);
    }
}
