package com.tencent.luggage.wxa.h7;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.wxa.e5.f;
import com.tencent.luggage.wxa.q7.i;
import com.tencent.luggage.wxa.q7.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.c0;
import com.tencent.luggage.wxa.xd.e;
import com.tencent.luggage.wxa.xd.l;
import com.tencent.luggage.wxa.xd.n;
import com.tencent.luggage.wxaapi.WxaExtendApiJSBridge;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends n {

    /* renamed from: c, reason: collision with root package name */
    public static final C6255a f126914c = new C6255a(null);

    /* renamed from: b, reason: collision with root package name */
    public final e f126915b;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.h7.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6255a {
        public C6255a() {
        }

        public /* synthetic */ C6255a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements WxaExtendApiJSBridge.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c0.a f126917b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f126918c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f126919d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f126920e;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.h7.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public /* synthetic */ class C6256a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f126921a;

            static {
                int[] iArr = new int[WxaExtendApiJSBridge.ErrMsg.values().length];
                iArr[WxaExtendApiJSBridge.ErrMsg.OK.ordinal()] = 1;
                iArr[WxaExtendApiJSBridge.ErrMsg.FAIL.ordinal()] = 2;
                iArr[WxaExtendApiJSBridge.ErrMsg.CANCEL.ordinal()] = 3;
                f126921a = iArr;
            }
        }

        public b(c0.a aVar, String str, int i3, String str2) {
            this.f126917b = aVar;
            this.f126918c = str;
            this.f126919d = i3;
            this.f126920e = str2;
        }

        @Override // com.tencent.luggage.wxaapi.WxaExtendApiJSBridge.a
        public void callback(WxaExtendApiJSBridge.ErrMsg errMsg, String str, JSONObject jSONObject) {
            String str2;
            Map hashMap;
            String str3;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            int i3 = C6256a.f126921a[errMsg.ordinal()];
            boolean z16 = true;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        str2 = "fail cancel";
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("fail");
                    if (str != null && str.length() != 0) {
                        z16 = false;
                    }
                    if (z16) {
                        str3 = "";
                    } else {
                        str3 = TokenParser.SP + str;
                    }
                    sb5.append(str3);
                    str2 = sb5.toString();
                }
            } else {
                str2 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            }
            if (jSONObject != null) {
                hashMap = f.b(jSONObject);
                c0.a(a.this.f126915b.getJsRuntime(), hashMap, this.f126917b);
            } else {
                hashMap = new HashMap();
            }
            hashMap.put("errMsg", this.f126918c + ':' + str2);
            com.tencent.luggage.wxa.h6.f.a(hashMap);
            String jSONObject2 = new JSONObject(hashMap).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "map.let {\n              \u2026tring()\n                }");
            a aVar = a.this;
            aVar.a(aVar.f126915b, this.f126919d, jSONObject2);
            k.f138011a.b("WxaAppJsInterface", "callback with appID:" + this.f126920e + ", api:" + this.f126918c + ", callback:hash(" + hashCode() + "), data:" + jSONObject2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e env) {
        super(env);
        Intrinsics.checkNotNullParameter(env, "env");
        this.f126915b = env;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
    @JavascriptInterface
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String invokeThirdHandler(@Nullable String str, @Nullable String str2, int i3) {
        String str3;
        String str4;
        boolean z16;
        JSONObject jSONObject;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("invokeThirdHandler api:");
        if (str == null) {
            str3 = "";
        } else {
            str3 = str;
        }
        sb5.append(str3);
        sb5.append(", data:");
        if (str2 == null) {
            str4 = "";
        } else {
            str4 = str2;
        }
        sb5.append(str4);
        sb5.append(", callbackId:");
        sb5.append(i3);
        w.d("WxaAppJsInterface", sb5.toString());
        if (str == null) {
            return "";
        }
        String appId = this.f126915b.getAppId();
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException e16) {
                String str5 = "appId:" + appId + ", api:" + str + ", data:" + str2 + ", parse json failed, exception:" + e16;
                k.f138011a.a("WxaAppJsInterface", str5);
                w.b("WxaAppJsInterface", str5);
            }
            l a16 = this.f126915b.a(c0.a.class);
            Intrinsics.checkNotNullExpressionValue(a16, "env.getConfig(NativeBuff\u2026BufferConfig::class.java)");
            c0.a aVar = (c0.a) a16;
            if (jSONObject != null) {
                c0.a(this.f126915b.getJsRuntime(), null, jSONObject, aVar);
            }
            b bVar = new b(aVar, str, i3, appId);
            i iVar = i.f137989a;
            Intrinsics.checkNotNullExpressionValue(appId, "appId");
            iVar.invoke(appId, str, jSONObject, bVar);
            return "";
        }
        jSONObject = null;
        l a162 = this.f126915b.a(c0.a.class);
        Intrinsics.checkNotNullExpressionValue(a162, "env.getConfig(NativeBuff\u2026BufferConfig::class.java)");
        c0.a aVar2 = (c0.a) a162;
        if (jSONObject != null) {
        }
        b bVar2 = new b(aVar2, str, i3, appId);
        i iVar2 = i.f137989a;
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        iVar2.invoke(appId, str, jSONObject, bVar2);
        return "";
    }

    public final void a(e eVar, int i3, String str) {
        String trimIndent;
        trimIndent = StringsKt__IndentKt.trimIndent("\n            WeixinJSBridge.invokeThirdCallbackHandler(" + i3 + ", " + str + ")\n        ");
        eVar.getJsRuntime().evaluateJavascript(trimIndent, null);
    }
}
