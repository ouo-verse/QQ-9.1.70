package com.tencent.luggage.wxa.q7;

import android.app.Activity;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxaapi.WxaExtendApiJSBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements WxaExtendApiJSBridge.b, WxaExtendApiJSBridge.c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f137950a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/luggage/wxa/q7/f;", "callbackData", "Lcom/tencent/luggage/wxa/va/e;", "a", "(Lcom/tencent/luggage/wxa/q7/f;)Lcom/tencent/luggage/wxa/va/e;"}, k = 3, mv = {1, 7, 1})
        /* renamed from: com.tencent.luggage.wxa.q7.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6626a<InputType, ResultType> implements com.tencent.luggage.wxa.ka.r {

            /* renamed from: a, reason: collision with root package name */
            public static final C6626a f137951a = new C6626a();

            @Override // com.tencent.luggage.wxa.ka.r
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.tencent.luggage.wxa.va.e invoke(f fVar) {
                boolean z16;
                WxaExtendApiJSBridge.a aVar;
                JSONObject jSONObject;
                a unused = e.f137950a;
                if (fVar != null) {
                    WxaExtendApiJSBridge.ErrMsg a16 = fVar.a();
                    String b16 = fVar.b();
                    String c16 = fVar.c();
                    String d16 = fVar.d();
                    if (a16 != null) {
                        if (d16 != null && d16.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16 && (aVar = (WxaExtendApiJSBridge.a) i.f137989a.a().remove(d16)) != null) {
                            if (c16 != null) {
                                jSONObject = new JSONObject(c16);
                            } else {
                                jSONObject = null;
                            }
                            aVar.callback(a16, b16, jSONObject);
                        }
                    }
                }
                return com.tencent.luggage.wxa.va.e.f143316a;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(String str, String hostProcess, WxaExtendApiJSBridge.ErrMsg errMsg, String str2, JSONObject jSONObject) {
            boolean z16;
            String str3;
            Intrinsics.checkNotNullParameter(hostProcess, "hostProcess");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            if (com.tencent.luggage.wxa.tn.z.m()) {
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    return;
                }
                if (jSONObject != null) {
                    str3 = jSONObject.toString();
                } else {
                    str3 = null;
                }
                com.tencent.luggage.wxa.ka.b.a(hostProcess, new f(errMsg, str2, str3, str), C6626a.f137951a);
                return;
            }
            throw new IllegalStateException("Can't be called in non-main process".toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/luggage/wxa/q7/g;", "invokeData", "Lcom/tencent/luggage/wxa/va/e;", "a", "(Lcom/tencent/luggage/wxa/q7/g;)Lcom/tencent/luggage/wxa/va/e;"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class b<InputType, ResultType> implements com.tencent.luggage.wxa.ka.r {

        /* renamed from: a, reason: collision with root package name */
        public static final b f137952a = new b();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements WxaExtendApiJSBridge.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f137953a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f137954b;

            public a(String str, String str2) {
                this.f137953a = str;
                this.f137954b = str2;
            }

            @Override // com.tencent.luggage.wxaapi.WxaExtendApiJSBridge.a
            public final void callback(WxaExtendApiJSBridge.ErrMsg errMsg, String str, JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                e.f137950a.a(this.f137953a, this.f137954b, errMsg, str, jSONObject);
            }
        }

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.va.e invoke(g gVar) {
            boolean z16;
            boolean z17;
            JSONObject jSONObject;
            if (gVar == null) {
                return com.tencent.luggage.wxa.va.e.f143316a;
            }
            String a16 = gVar.a();
            String b16 = gVar.b();
            String c16 = gVar.c();
            String d16 = gVar.d();
            String e16 = gVar.e();
            boolean z18 = false;
            if (a16 != null && a16.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (b16 != null && b16.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    if (e16 == null || e16.length() == 0) {
                        z18 = true;
                    }
                    if (!z18) {
                        WxaExtendApiJSBridge.b a17 = j.f138007a.a();
                        if (a17 == null) {
                            e.f137950a.a(d16, e16, WxaExtendApiJSBridge.ErrMsg.FAIL, "not supported", null);
                            return com.tencent.luggage.wxa.va.e.f143316a;
                        }
                        if (c16 != null) {
                            try {
                                jSONObject = new JSONObject(c16);
                            } catch (Throwable th5) {
                                k.f138011a.a("InvokeHandlerMainProcessProxy", "invoke for wxaAppID:" + a16 + " apiName:" + b16 + ", get exception:" + th5);
                                com.tencent.luggage.wxa.tn.w.b("InvokeHandlerMainProcessProxy", "invoke for wxaAppID:" + a16 + " apiName:" + b16 + ", get exception:" + th5);
                            }
                        } else {
                            jSONObject = null;
                        }
                        a17.invoke(a16, b16, jSONObject, new a(d16, e16));
                        return com.tencent.luggage.wxa.va.e.f143316a;
                    }
                }
            }
            return com.tencent.luggage.wxa.va.e.f143316a;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002*\u0010\u0005\u001a&\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0012\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/luggage/wxa/va/d;", "kotlin.jvm.PlatformType", "invokeData", "Lcom/tencent/luggage/wxa/ka/i;", "Lcom/tencent/luggage/wxa/va/e;", "callback", "", "a", "(Lcom/tencent/luggage/wxa/va/d;Lcom/tencent/luggage/wxa/ka/i;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class c<InputType, ResultType> implements com.tencent.luggage.wxa.ka.e {

        /* renamed from: a, reason: collision with root package name */
        public static final c f137955a = new c();

        @Override // com.tencent.luggage.wxa.ka.f
        public final void a(com.tencent.luggage.wxa.va.d dVar, com.tencent.luggage.wxa.ka.i iVar) {
            if (dVar == null) {
                if (iVar != null) {
                    return;
                } else {
                    return;
                }
            }
            try {
                String str = dVar.f143315a;
                if (str == null) {
                    str = "";
                }
                WxaExtendApiJSBridge.c b16 = j.f138007a.b();
                if (b16 == null) {
                    com.tencent.luggage.wxa.tn.w.d("InvokeHandlerMainProcessProxy", "missing handler for openUrl " + str);
                    k.f138011a.b("WxaExtendApiJSBridge", "missing handler for openUrl " + str);
                    if (iVar != null) {
                        iVar.a(com.tencent.luggage.wxa.va.e.f143316a);
                        return;
                    }
                    return;
                }
                com.tencent.luggage.wxa.tn.w.d("InvokeHandlerMainProcessProxy", "openUrl " + str + " handle by hash(" + b16.hashCode() + ')');
                b16.openUrl(null, str);
                if (iVar != null) {
                    iVar.a(com.tencent.luggage.wxa.va.e.f143316a);
                }
            } finally {
                if (iVar != null) {
                    iVar.a(com.tencent.luggage.wxa.va.e.f143316a);
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxaapi.WxaExtendApiJSBridge.b
    public void invoke(String wxaAppID, String apiName, JSONObject jSONObject, WxaExtendApiJSBridge.a aVar) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(wxaAppID, "wxaAppID");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        if (!com.tencent.luggage.wxa.tn.z.m()) {
            if (aVar != null) {
                str = wxaAppID + '#' + apiName + '#' + w0.a();
                i.f137989a.a().put(str, aVar);
            } else {
                str = "";
            }
            String str3 = str;
            try {
                String g16 = com.tencent.luggage.wxa.tn.z.g();
                Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
                if (jSONObject != null) {
                    str2 = jSONObject.toString();
                } else {
                    str2 = null;
                }
                com.tencent.luggage.wxa.ka.b.a(g16, new g(wxaAppID, apiName, str2, str3, com.tencent.luggage.wxa.tn.z.i()), b.f137952a);
                return;
            } catch (Exception e16) {
                k.f138011a.a("InvokeHandlerMainProcessProxy", "invoke for wxaAppID:" + wxaAppID + " apiName:" + apiName + ", get exception:" + e16);
                com.tencent.luggage.wxa.tn.w.b("InvokeHandlerMainProcessProxy", "invoke for wxaAppID:" + wxaAppID + " apiName:" + apiName + ", get exception:" + e16);
                return;
            }
        }
        throw new IllegalStateException("Can't be called in main process".toString());
    }

    @Override // com.tencent.luggage.wxaapi.WxaExtendApiJSBridge.c
    public void openUrl(Activity activity, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!com.tencent.luggage.wxa.tn.z.m()) {
            String g16 = com.tencent.luggage.wxa.tn.z.g();
            Intrinsics.checkNotNullExpressionValue(g16, "getMainProcessName()");
            com.tencent.luggage.wxa.ka.b.a(g16, new com.tencent.luggage.wxa.va.d(url), c.f137955a, null);
            return;
        }
        throw new IllegalStateException("Can't be called in main process".toString());
    }
}
