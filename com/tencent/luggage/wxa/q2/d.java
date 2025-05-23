package com.tencent.luggage.wxa.q2;

import com.tencent.luggage.wxa.t9.l;
import com.tencent.luggage.wxa.t9.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 867;

    @NotNull
    public static final String NAME = "getDeviceInfo";

    /* renamed from: a, reason: collision with root package name */
    public static final a f137815a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        String str;
        String str2;
        Map<String, ? extends Object> mutableMapOf;
        com.tencent.luggage.wxa.yi.a aVar;
        String h16 = l.h();
        try {
            str = l.a(false);
        } catch (Exception e16) {
            w.f("Luggage.JsApiGetDeviceInfo", "getIMEI fail: " + e16);
            str = "";
        }
        String a16 = com.tencent.luggage.wxa.q2.a.a();
        if (dVar != null && (aVar = (com.tencent.luggage.wxa.yi.a) dVar.a(com.tencent.luggage.wxa.yi.a.class)) != null) {
            str2 = aVar.K;
        } else {
            str2 = null;
        }
        w.d("Luggage.JsApiGetDeviceInfo", "getDeviceInfo, oaid:" + h16 + ", imei:" + str + ", waid:, ua:" + str2 + ", devIdInfo:" + a16);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("oaid", h16), TuplesKt.to("imei", str), TuplesKt.to("waid", ""), TuplesKt.to("devIdInfo", a16), TuplesKt.to("ua", str2));
        mutableMapOf.put("aidTicket", v.a());
        if (dVar != null) {
            dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, mutableMapOf));
        }
    }
}
