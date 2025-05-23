package com.tencent.luggage.wxa.q7;

import android.app.Activity;
import com.tencent.luggage.wxa.xd.h1;
import com.tencent.luggage.wxaapi.WxaExtendApiJSBridge;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i implements WxaExtendApiJSBridge, WxaExtendApiJSBridge.b, WxaExtendApiJSBridge.c {

    /* renamed from: c, reason: collision with root package name */
    public static WxaExtendApiJSBridge.b f137991c;

    /* renamed from: d, reason: collision with root package name */
    public static WxaExtendApiJSBridge.c f137992d;

    /* renamed from: a, reason: collision with root package name */
    public static final i f137989a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f137990b = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public static final e f137993e = new e();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.p5.f f137994a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f137995b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f137996c;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.q7.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6627a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ic.l f137997a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f137998b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f137999c;

            public RunnableC6627a(com.tencent.luggage.wxa.ic.l lVar, String str, String str2) {
                this.f137997a = lVar;
                this.f137998b = str;
                this.f137999c = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                i iVar = i.f137989a;
                com.tencent.luggage.wxa.ic.l service = this.f137997a;
                Intrinsics.checkNotNullExpressionValue(service, "service");
                String str = this.f137998b;
                String str2 = this.f137999c;
                if (str2 == null) {
                    str2 = "{}";
                }
                iVar.a(service, str, str2);
            }
        }

        public a(com.tencent.luggage.wxa.p5.f fVar, String str, String str2) {
            this.f137994a = fVar;
            this.f137995b = str;
            this.f137996c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.luggage.wxa.ic.l h06 = this.f137994a.h0();
            h06.c(new RunnableC6627a(h06, this.f137995b, this.f137996c));
        }
    }

    @Override // com.tencent.luggage.wxaapi.WxaExtendApiJSBridge.b
    public void invoke(String wxaAppID, String apiName, JSONObject jSONObject, WxaExtendApiJSBridge.a aVar) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        WxaExtendApiJSBridge.b bVar = f137991c;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            str = "hash(" + bVar.hashCode() + ')';
        } else {
            bVar = f137993e;
            str = "MainProcessProxy";
        }
        if (aVar == null) {
            str2 = "null";
        } else {
            str2 = "hash(" + aVar.hashCode() + ')';
        }
        com.tencent.luggage.wxa.tn.w.d("ExtendApiJSBridgeImpl", "invoke before, appId:" + wxaAppID + ", api:" + apiName + ", invokeHandler:" + str + ", callback:" + str2);
        k kVar = k.f138011a;
        kVar.b("WxaExtendApiJSBridge", "invoke before, appId:" + wxaAppID + ", api:" + apiName + ", invokeHandler:" + str + ", callback:" + str2);
        bVar.invoke(wxaAppID, apiName, jSONObject, aVar);
        com.tencent.luggage.wxa.tn.w.d("ExtendApiJSBridgeImpl", "invoke after, appId:" + wxaAppID + ", api:" + apiName + ", invokeHandler:" + str + ", callback:" + str2);
        kVar.b("WxaExtendApiJSBridge", "invoke after, appId:" + wxaAppID + ", api:" + apiName + ", invokeHandler:" + str + ", callback:" + str2);
    }

    @Override // com.tencent.luggage.wxaapi.WxaExtendApiJSBridge.c
    public void openUrl(Activity activity, String url) {
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        WxaExtendApiJSBridge.c cVar = f137992d;
        if (cVar != null) {
            Intrinsics.checkNotNull(cVar);
            str = "hash(" + cVar.hashCode() + ')';
        } else {
            cVar = f137993e;
            str = "MainProcessProxy";
        }
        com.tencent.luggage.wxa.tn.w.d("ExtendApiJSBridgeImpl", "openUrl before, url:" + url + ", handler:" + str);
        k kVar = k.f138011a;
        kVar.b("WxaExtendApiJSBridge", "openUrl before, url:" + url + ", handler:" + str);
        cVar.openUrl(activity, url);
        com.tencent.luggage.wxa.tn.w.d("ExtendApiJSBridgeImpl", "openUrl after, url:" + url + ", handler:" + str);
        kVar.b("WxaExtendApiJSBridge", "openUrl after, url:" + url + ", handler:" + str);
    }

    public void sendJSEvent(String wxaAppID, String eventName, JSONObject jSONObject) {
        String str;
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (jSONObject != null) {
            str = jSONObject.toString();
        } else {
            str = null;
        }
        a(wxaAppID, eventName, str);
    }

    @Override // com.tencent.luggage.wxaapi.WxaExtendApiJSBridge
    public void setInvokeHandler(WxaExtendApiJSBridge.b bVar) {
        String str;
        f137991c = bVar;
        if (bVar == null) {
            str = "null";
        } else {
            str = "hash(" + bVar.hashCode() + ')';
        }
        k.f138011a.b("WxaExtendApiJSBridge", "setInvokeHandler " + str);
        com.tencent.luggage.wxa.tn.w.d("ExtendApiJSBridgeImpl", "setInvokeHandler " + str);
    }

    @Override // com.tencent.luggage.wxaapi.WxaExtendApiJSBridge
    public void setOpenUrlHandler(WxaExtendApiJSBridge.c cVar) {
        String str;
        f137992d = cVar;
        if (cVar == null) {
            str = "null";
        } else {
            str = "hash(" + cVar.hashCode() + ')';
        }
        k.f138011a.b("WxaExtendApiJSBridge", "setOpenUrlHandler " + str);
        com.tencent.luggage.wxa.tn.w.d("ExtendApiJSBridgeImpl", "setInvokeHandler " + str);
    }

    public final ConcurrentHashMap a() {
        return f137990b;
    }

    public final void a(com.tencent.luggage.wxa.xd.e eVar, String str, String str2) {
        String trimIndent;
        trimIndent = StringsKt__IndentKt.trimIndent("\n            WeixinJSBridge.subscribeThirdHandler(\"" + com.tencent.luggage.wxa.uk.w.a(str) + "\", " + str2 + ", undefined, " + h1.a() + ")\n        ");
        eVar.getJsRuntime().evaluateJavascript(trimIndent, null);
    }

    public final void a(String wxaAppID, String eventName, String str) {
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        com.tencent.luggage.wxa.p5.f b16 = com.tencent.luggage.wxa.p6.h.b(wxaAppID);
        if (b16 == null) {
            k.f138011a.c("WxaExtendApiJSBridge", "sendJSEvent with not alive appID:" + wxaAppID);
            com.tencent.luggage.wxa.tn.w.f("ExtendApiJSBridgeImpl", "sendJSEvent with not alive appID:" + wxaAppID);
            return;
        }
        b16.c(new a(b16, eventName, str));
        com.tencent.luggage.wxa.tn.w.d("ExtendApiJSBridgeImpl", "sendJSEvent with appID:" + wxaAppID + ", event:" + eventName + ", emitted");
        k.f138011a.c("WxaExtendApiJSBridge", "sendJSEvent with appID:" + wxaAppID + ", event:" + eventName + ", emitted");
    }
}
