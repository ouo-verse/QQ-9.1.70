package com.tencent.luggage.wxa.uj;

import com.tencent.luggage.wxa.be.c;
import com.tencent.luggage.wxa.hn.c5;
import com.tencent.luggage.wxa.hn.m9;
import com.tencent.luggage.wxa.hn.w5;
import com.tencent.luggage.wxa.hn.x5;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uj.k;
import com.tencent.luggage.wxa.xo.e;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f142456a;

    /* renamed from: b, reason: collision with root package name */
    public final String f142457b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f142458c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function4 f142459b;

        public a(Function4 function4) {
            this.f142459b = function4;
        }

        public final void a(x5 x5Var) {
            w.d("Luggage.FULL.CgiPhoneNumber", "getPhoneNumber success");
            c5 c5Var = x5Var.f129007e;
            int i3 = c5Var.f127384d;
            String str = c5Var.f127385e;
            if (i3 != g.f142469a.a()) {
                w.b("Luggage.FULL.CgiPhoneNumber", "jsErrcode:" + i3 + ", jsErrmsg:" + str);
                Function4 function4 = this.f142459b;
                if (function4 != null) {
                    Boolean bool = Boolean.FALSE;
                    if (str == null) {
                        str = "";
                    }
                    function4.invoke(bool, str, null, null);
                    return;
                }
                return;
            }
            JSONObject jSONObject = new JSONObject(x5Var.f129008f.d());
            ArrayList arrayList = new ArrayList();
            k.a aVar = k.f142498k;
            String optString = jSONObject.optString("wx_phone");
            Intrinsics.checkNotNullExpressionValue(optString, "phoneItemsJsonObj.optString(\"wx_phone\")");
            k a16 = aVar.a(optString);
            if (a16 != null) {
                a16.b(true);
                arrayList.add(a16);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("custom_phone_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                for (int i16 = 0; i16 < length; i16++) {
                    k.a aVar2 = k.f142498k;
                    String string = optJSONArray.getString(i16);
                    Intrinsics.checkNotNullExpressionValue(string, "customPhoneItemsObjArray.getString(i)");
                    k a17 = aVar2.a(string);
                    if (a17 != null) {
                        arrayList.add(a17);
                    }
                }
            }
            Function4 function42 = this.f142459b;
            if (function42 != null) {
                Boolean bool2 = Boolean.TRUE;
                m9 m9Var = x5Var.f129009g;
                com.tencent.luggage.wxa.hn.i iVar = x5Var.f129018p;
                String str2 = x5Var.f129016n;
                if (str2 == null) {
                    str2 = "";
                }
                function42.invoke(bool2, "", arrayList, new c.b(m9Var, iVar, str2, x5Var.f129019q));
            }
        }

        @Override // com.tencent.luggage.wxa.uo.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            a((x5) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function4 f142460a;

        public b(Function4 function4) {
            this.f142460a = function4;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            w.b("Luggage.FULL.CgiPhoneNumber", "getPhoneNumber fail");
            if (obj instanceof Exception) {
                w.b("Luggage.FULL.CgiPhoneNumber", "CgiGetAllPhone " + ((Exception) obj).getMessage());
            }
            Function4 function4 = this.f142460a;
            if (function4 != null) {
                function4.invoke(Boolean.FALSE, "cgi fail", null, null);
            }
        }
    }

    public d(String appId, String apiName, boolean z16) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        this.f142456a = appId;
        this.f142457b = apiName;
        this.f142458c = z16;
    }

    public final String a(String str, boolean z16) {
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.object();
            jSONStringer.key("api_name");
            jSONStringer.value(str);
            jSONStringer.key("with_credentials");
            jSONStringer.value(z16);
            jSONStringer.endObject();
        } catch (JSONException e16) {
            w.a("MicroMsg.JsApiGetPhoneNumberNew", e16, "", new Object[0]);
        }
        String jSONStringer2 = jSONStringer.toString();
        Intrinsics.checkNotNullExpressionValue(jSONStringer2, "jsonStringer.toString()");
        return jSONStringer2;
    }

    public final void a(Function4 function4) {
        String a16 = a(this.f142457b, this.f142458c);
        w5 w5Var = new w5();
        w5Var.f128942e = this.f142456a;
        byte[] bytes = a16.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        w5Var.f128943f = new com.tencent.luggage.wxa.fn.c(bytes);
        ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).b("/cgi-bin/mmbiz-bin/wxaapp/customphone/getallphone", this.f142456a, w5Var, x5.class).b(new a(function4)).a(new b(function4));
    }
}
