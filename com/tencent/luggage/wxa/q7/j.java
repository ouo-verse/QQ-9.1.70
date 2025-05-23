package com.tencent.luggage.wxa.q7;

import com.tencent.luggage.wxaapi.WxaExtendApiJSBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j implements WxaExtendApiJSBridge {

    /* renamed from: a, reason: collision with root package name */
    public static final j f138007a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static WxaExtendApiJSBridge.b f138008b;

    /* renamed from: c, reason: collision with root package name */
    public static WxaExtendApiJSBridge.c f138009c;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/luggage/wxa/q7/h;", "event", "Lcom/tencent/luggage/wxa/va/e;", "a", "(Lcom/tencent/luggage/wxa/q7/h;)Lcom/tencent/luggage/wxa/va/e;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class a<InputType, ResultType> implements com.tencent.luggage.wxa.ka.r {

        /* renamed from: a, reason: collision with root package name */
        public static final a f138010a = new a();

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.va.e invoke(h hVar) {
            boolean z16;
            if (hVar == null) {
                return com.tencent.luggage.wxa.va.e.f143316a;
            }
            String a16 = hVar.a();
            String b16 = hVar.b();
            String c16 = hVar.c();
            boolean z17 = false;
            if (a16 != null && a16.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (b16 == null || b16.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    i.f137989a.a(a16, b16, c16);
                    return com.tencent.luggage.wxa.va.e.f143316a;
                }
            }
            k.f138011a.a("WxaExtendApiJSBridge", "sendJSEvent with invalid appID:" + a16 + ", event:" + b16);
            return com.tencent.luggage.wxa.va.e.f143316a;
        }
    }

    public final WxaExtendApiJSBridge.b a() {
        return f138008b;
    }

    public final WxaExtendApiJSBridge.c b() {
        return f138009c;
    }

    public void sendJSEvent(String wxaAppID, String eventName, JSONObject jSONObject) {
        String e16;
        String str;
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        try {
            com.tencent.luggage.wxa.z4.e a16 = com.tencent.luggage.wxa.z4.f.f146283b.a().a(wxaAppID);
            if (a16 != null && (e16 = a16.e()) != null) {
                if (jSONObject != null) {
                    str = jSONObject.toString();
                } else {
                    str = null;
                }
                com.tencent.luggage.wxa.ka.b.a(e16, new h(wxaAppID, eventName, str), a.f138010a);
                return;
            }
            k.f138011a.a("WxaExtendApiJSBridge", "try call sendJSEvent(wxaAppID:" + wxaAppID + ", eventName:" + eventName + ") but MiniProgram not running");
            com.tencent.luggage.wxa.tn.w.b("ExtendApiJSBridgeMainProcessImpl", "try call sendJSEvent(wxaAppID:" + wxaAppID + ", eventName:" + eventName + ") but MiniProgram not running");
        } catch (Exception unused) {
            k.f138011a.a("WxaExtendApiJSBridge", "try call sendJSEvent(wxaAppID:" + wxaAppID + ", eventName:" + eventName + ") but ProcessManager not ready");
            com.tencent.luggage.wxa.tn.w.b("ExtendApiJSBridgeMainProcessImpl", "try call sendJSEvent(wxaAppID:" + wxaAppID + ", eventName:" + eventName + ") but ProcessManager not ready");
        }
    }

    @Override // com.tencent.luggage.wxaapi.WxaExtendApiJSBridge
    public void setInvokeHandler(WxaExtendApiJSBridge.b bVar) {
        String str;
        f138008b = bVar;
        if (bVar == null) {
            str = "null";
        } else {
            str = "hash(" + bVar.hashCode() + ')';
        }
        k.f138011a.b("WxaExtendApiJSBridge", "setInvokeHandler " + str);
        com.tencent.luggage.wxa.tn.w.d("ExtendApiJSBridgeMainProcessImpl", "setInvokeHandler " + str);
    }

    @Override // com.tencent.luggage.wxaapi.WxaExtendApiJSBridge
    public void setOpenUrlHandler(WxaExtendApiJSBridge.c cVar) {
        String str;
        f138009c = cVar;
        if (cVar == null) {
            str = "null";
        } else {
            str = "hash(" + cVar.hashCode() + ')';
        }
        k.f138011a.b("WxaExtendApiJSBridge", "setOpenUrlHandler " + str);
        com.tencent.luggage.wxa.tn.w.d("ExtendApiJSBridgeMainProcessImpl", "setInvokeHandler " + str);
    }
}
