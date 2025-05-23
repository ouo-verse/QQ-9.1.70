package com.tencent.luggage.wxa.m6;

import android.content.DialogInterface;
import android.os.Build;
import android.util.SparseIntArray;
import com.tencent.luggage.wxa.hn.a5;
import com.tencent.luggage.wxa.hn.a6;
import com.tencent.luggage.wxa.hn.b5;
import com.tencent.luggage.wxa.hn.c5;
import com.tencent.luggage.wxa.hn.g5;
import com.tencent.luggage.wxa.hn.h0;
import com.tencent.luggage.wxa.hn.h5;
import com.tencent.luggage.wxa.hn.i5;
import com.tencent.luggage.wxa.hn.j5;
import com.tencent.luggage.wxa.hn.k5;
import com.tencent.luggage.wxa.hn.l5;
import com.tencent.luggage.wxa.hn.n2;
import com.tencent.luggage.wxa.hn.qb;
import com.tencent.luggage.wxa.hn.y4;
import com.tencent.luggage.wxa.ml.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.luggage.wxa.xd.v;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: f, reason: collision with root package name */
    public static final b f134107f = new b(null);

    /* renamed from: g, reason: collision with root package name */
    public static final HashMap f134108g;

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f134109h;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.m6.d f134110a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.k6.b f134111b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f134112c;

    /* renamed from: d, reason: collision with root package name */
    public final e f134113d;

    /* renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap f134114e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function2 {
        public a() {
            super(2);
        }

        public final void a(String url, n2 resp) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(resp, "resp");
            e eVar = c.this.f134113d;
            byte[] f16 = resp.f128246t.f();
            Intrinsics.checkNotNullExpressionValue(f16, "resp.JSAPIControlBytes.bufferToBytes");
            eVar.a(url, f16);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((String) obj, (n2) obj2);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LinkedList a(JSONObject jSONObject, String str) {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                linkedList.add(optJSONArray.optString(i3));
            }
            return linkedList;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.m6.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6460c {

        /* renamed from: k, reason: collision with root package name */
        public static final a f134116k = new a(null);

        /* renamed from: a, reason: collision with root package name */
        public final String f134117a;

        /* renamed from: b, reason: collision with root package name */
        public final int f134118b;

        /* renamed from: c, reason: collision with root package name */
        public final String f134119c;

        /* renamed from: d, reason: collision with root package name */
        public final String f134120d;

        /* renamed from: e, reason: collision with root package name */
        public final String f134121e;

        /* renamed from: f, reason: collision with root package name */
        public final String f134122f;

        /* renamed from: g, reason: collision with root package name */
        public final String f134123g;

        /* renamed from: h, reason: collision with root package name */
        public final String f134124h;

        /* renamed from: i, reason: collision with root package name */
        public final byte[] f134125i;

        /* renamed from: j, reason: collision with root package name */
        public final String f134126j;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.m6.c$c$a */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final C6460c a(String str, o api, JSONObject dataJson) {
                String str2;
                String str3;
                String str4;
                String str5;
                int i3;
                String str6;
                Intrinsics.checkNotNullParameter(api, "api");
                Intrinsics.checkNotNullParameter(dataJson, "dataJson");
                String jSONObject = dataJson.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "dataJson.toString()");
                byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                if (dataJson.has("addrSign") && !dataJson.has("verifySignature")) {
                    String optString = dataJson.optString("appId");
                    Intrinsics.checkNotNullExpressionValue(optString, "dataJson.optString(KEY_JSOAUTH_APPID)");
                    String optString2 = dataJson.optString("addrSign");
                    Intrinsics.checkNotNullExpressionValue(optString2, "dataJson.optString(KEY_JSOAUTH_ADDR_SIGN)");
                    String optString3 = dataJson.optString(PayProxy.Source.PAY_REQUEST_SIGN_TYPE_KEY);
                    Intrinsics.checkNotNullExpressionValue(optString3, "dataJson.optString(KEY_JSOAUTH_SIGN_TYPE)");
                    String optString4 = dataJson.optString(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY);
                    Intrinsics.checkNotNullExpressionValue(optString4, "dataJson.optString(KEY_JSOAUTH_TIMESTAMP)");
                    String optString5 = dataJson.optString(PayProxy.Source.PAY_REQUEST_NONCE_STR_KEY);
                    Intrinsics.checkNotNullExpressionValue(optString5, "dataJson.optString(KEY_JSOAUTH_NONCESTR)");
                    str2 = optString2;
                    str3 = optString3;
                    str4 = optString4;
                    str5 = optString5;
                    i3 = 1;
                    str6 = optString;
                } else {
                    String optString6 = dataJson.optString("verifyAppId");
                    Intrinsics.checkNotNullExpressionValue(optString6, "dataJson.optString(KEY_JSVERIFY_APPID)");
                    String optString7 = dataJson.optString("verifySignature");
                    Intrinsics.checkNotNullExpressionValue(optString7, "dataJson.optString(KEY_JSVERIFY_SIGNATURE)");
                    String optString8 = dataJson.optString("verifySignType");
                    Intrinsics.checkNotNullExpressionValue(optString8, "dataJson.optString(KEY_JSVERIFY_SIGN_TYPE)");
                    String optString9 = dataJson.optString("verifyTimestamp");
                    Intrinsics.checkNotNullExpressionValue(optString9, "dataJson.optString(KEY_JSVERIFY_TIMESTAMP)");
                    String optString10 = dataJson.optString("verifyNonceStr");
                    Intrinsics.checkNotNullExpressionValue(optString10, "dataJson.optString(KEY_JSVERIFY_NONCE_STR)");
                    str2 = optString7;
                    str3 = optString8;
                    str4 = optString9;
                    str5 = optString10;
                    i3 = 2;
                    str6 = optString6;
                }
                return new C6460c(str, i3, str6, str2, str3, str4, str5, api.getName(), bytes, dataJson.optString("scope"));
            }
        }

        public C6460c(String str, int i3, String str2, String str3, String str4, String str5, String str6, String str7, byte[] bArr, String str8) {
            this.f134117a = str;
            this.f134118b = i3;
            this.f134119c = str2;
            this.f134120d = str3;
            this.f134121e = str4;
            this.f134122f = str5;
            this.f134123g = str6;
            this.f134124h = str7;
            this.f134125i = bArr;
            this.f134126j = str8;
        }

        public final a5 a() {
            a5 a5Var = new a5();
            a5Var.f127268e = this.f134117a;
            a5Var.f127269f = this.f134119c;
            a5Var.f127270g = this.f134124h;
            a5Var.f127271h = this.f134122f;
            a5Var.f127272i = this.f134123g;
            a5Var.f127273j = this.f134120d;
            a5Var.f127274k = this.f134121e;
            a5Var.f127275l = com.tencent.luggage.wxa.fn.c.a(this.f134125i);
            a5Var.f127276m = this.f134118b;
            a5Var.f127277n = this.f134126j;
            return a5Var;
        }

        public final i5 b() {
            i5 i5Var = new i5();
            i5Var.f127850e = this.f134117a;
            i5Var.f127851f = this.f134119c;
            i5Var.f127852g = this.f134124h;
            i5Var.f127853h = this.f134122f;
            i5Var.f127854i = this.f134123g;
            i5Var.f127855j = this.f134120d;
            i5Var.f127856k = this.f134121e;
            i5Var.f127857l = com.tencent.luggage.wxa.fn.c.a(this.f134125i);
            return i5Var;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C6460c)) {
                return false;
            }
            C6460c c6460c = (C6460c) obj;
            if (Intrinsics.areEqual(this.f134117a, c6460c.f134117a) && this.f134118b == c6460c.f134118b && Intrinsics.areEqual(this.f134119c, c6460c.f134119c) && Intrinsics.areEqual(this.f134120d, c6460c.f134120d) && Intrinsics.areEqual(this.f134121e, c6460c.f134121e) && Intrinsics.areEqual(this.f134122f, c6460c.f134122f) && Intrinsics.areEqual(this.f134123g, c6460c.f134123g) && Intrinsics.areEqual(this.f134124h, c6460c.f134124h) && Intrinsics.areEqual(this.f134125i, c6460c.f134125i) && Intrinsics.areEqual(this.f134126j, c6460c.f134126j)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            int hashCode7;
            int hashCode8;
            String str = this.f134117a;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = ((hashCode * 31) + this.f134118b) * 31;
            String str2 = this.f134119c;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.f134120d;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.f134121e;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            String str5 = this.f134122f;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            String str6 = this.f134123g;
            if (str6 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = str6.hashCode();
            }
            int i27 = (i26 + hashCode6) * 31;
            String str7 = this.f134124h;
            if (str7 == null) {
                hashCode7 = 0;
            } else {
                hashCode7 = str7.hashCode();
            }
            int i28 = (i27 + hashCode7) * 31;
            byte[] bArr = this.f134125i;
            if (bArr == null) {
                hashCode8 = 0;
            } else {
                hashCode8 = Arrays.hashCode(bArr);
            }
            int i29 = (i28 + hashCode8) * 31;
            String str8 = this.f134126j;
            if (str8 != null) {
                i3 = str8.hashCode();
            }
            return i29 + i3;
        }

        public String toString() {
            return "JSVerifyRequestProxy(url=" + this.f134117a + ", signFlag=" + this.f134118b + ", appId=" + this.f134119c + ", signature=" + this.f134120d + ", signType=" + this.f134121e + ", timestamp=" + this.f134122f + ", nonce=" + this.f134123g + ", JSAPIName=" + this.f134124h + ", JSAPIArgsJsonBytes=" + Arrays.toString(this.f134125i) + ", scope=" + this.f134126j + ')';
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f134132a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f134133b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f134134c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f134135d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0 f134136e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a5 f134137f;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ y4 f134138a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function0 f134139b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f134140c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a5 f134141d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ b5 f134142e;

            public a(y4 y4Var, Function0 function0, c cVar, a5 a5Var, b5 b5Var) {
                this.f134138a = y4Var;
                this.f134139b = function0;
                this.f134140c = cVar;
                this.f134141d = a5Var;
                this.f134142e = b5Var;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f134138a.f129067e = 1;
                this.f134139b.invoke();
                this.f134140c.a(this.f134141d, this.f134142e);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function0 f134143a;

            public b(Function0 function0) {
                this.f134143a = function0;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f134143a.invoke();
            }
        }

        public f(o oVar, String str, Function0 function0, c cVar, Function0 function02, a5 a5Var) {
            this.f134132a = oVar;
            this.f134133b = str;
            this.f134134c = function0;
            this.f134135d = cVar;
            this.f134136e = function02;
            this.f134137f = a5Var;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(b5 b5Var) {
            if ((b5Var != null ? b5Var.f127341f : null) == null) {
                w.b("Luggage.STANDALONE.HTMLWebViewJsApiPermissionController", "doJSAuthVerify get NULL resp.auth_info with api:" + this.f134132a.getName() + ", url:" + this.f134133b);
                this.f134134c.invoke();
                return;
            }
            LinkedList<y4> linkedList = b5Var.f127341f;
            Intrinsics.checkNotNullExpressionValue(linkedList, "verifyResponse.auth_info");
            c cVar = this.f134135d;
            String str = this.f134133b;
            for (y4 authInfo : linkedList) {
                ConcurrentHashMap concurrentHashMap = cVar.f134114e;
                String str2 = str + util.base64_pad_url + authInfo.f129066d;
                Intrinsics.checkNotNullExpressionValue(authInfo, "authInfo");
                concurrentHashMap.put(str2, authInfo);
            }
            y4 y4Var = (y4) this.f134135d.f134114e.get(this.f134135d.a(this.f134133b, this.f134132a.getName()));
            if (y4Var == null) {
                this.f134134c.invoke();
                return;
            }
            if (y4Var.f129067e == 1) {
                this.f134136e.invoke();
                return;
            }
            com.tencent.luggage.wxa.ml.b bVar = new com.tencent.luggage.wxa.ml.b(this.f134135d.f134111b.getContext());
            bVar.setMessage(y4Var.f129068f);
            bVar.setPositiveButton(this.f134135d.f134111b.getContext().getString(R.string.f159221rq), true, new a(y4Var, this.f134136e, this.f134135d, this.f134137f, b5Var));
            bVar.setNegativeButton(this.f134135d.f134111b.getContext().getString(R.string.f159211rp), true, new b(this.f134134c));
            r dialogContainer = this.f134135d.f134111b.getDialogContainer();
            Intrinsics.checkNotNull(dialogContainer);
            dialogContainer.a(bVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f134144a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f134145b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f134146c;

        public g(o oVar, String str, Function0 function0) {
            this.f134144a = oVar;
            this.f134145b = str;
            this.f134146c = function0;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doJSAuthVerify get exception:");
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            sb5.append(str);
            sb5.append(" with api:");
            sb5.append(this.f134144a.getName());
            sb5.append(", url:");
            sb5.append(this.f134145b);
            w.b("Luggage.STANDALONE.HTMLWebViewJsApiPermissionController", sb5.toString());
            this.f134146c.invoke();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f134147a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f134148b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f134149c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g5 f134150d;

        public h(Function0 function0, Function1 function1, c cVar, g5 g5Var) {
            this.f134147a = function0;
            this.f134148b = function1;
            this.f134149c = cVar;
            this.f134150d = g5Var;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(h5 h5Var) {
            c5 c5Var;
            c5 c5Var2;
            if ((h5Var == null || (c5Var2 = h5Var.f127756e) == null || c5Var2.f127384d != 0) ? false : true) {
                LinkedList linkedList = h5Var.f127757f;
                if (linkedList != null) {
                    this.f134149c.f134113d.a(this.f134150d.f127667e, linkedList);
                }
                this.f134147a.invoke();
                return;
            }
            this.f134148b.invoke((h5Var == null || (c5Var = h5Var.f127756e) == null) ? null : c5Var.f127385e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f134151a;

        public i(Function1 function1) {
            this.f134151a = function1;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            Function1 function1 = this.f134151a;
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            function1.invoke(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f134152a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f134153b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f134154c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ o f134155d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f134156e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Function0 f134157f;

        public j(int i3, Function0 function0, c cVar, o oVar, String str, Function0 function02) {
            this.f134152a = i3;
            this.f134153b = function0;
            this.f134154c = cVar;
            this.f134155d = oVar;
            this.f134156e = str;
            this.f134157f = function02;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(j5 j5Var) {
            qb qbVar;
            qb qbVar2;
            if ((j5Var == null || (qbVar2 = j5Var.f127942f) == null || this.f134152a != qbVar2.f128521f) ? false : true) {
                this.f134153b.invoke();
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doRealtimeVerify get VerifyInfo:");
            sb5.append((j5Var == null || (qbVar = j5Var.f127942f) == null) ? null : this.f134154c.a(qbVar));
            sb5.append(" with api:");
            sb5.append(this.f134155d.getName());
            sb5.append(", url:");
            sb5.append(this.f134156e);
            w.b("Luggage.STANDALONE.HTMLWebViewJsApiPermissionController", sb5.toString());
            this.f134157f.invoke();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f134158a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f134159b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f134160c;

        public k(o oVar, String str, Function0 function0) {
            this.f134158a = oVar;
            this.f134159b = str;
            this.f134160c = function0;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doRealtimeVerify get exception:");
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            sb5.append(str);
            sb5.append(" with api:");
            sb5.append(this.f134158a.getName());
            sb5.append(", url:");
            sb5.append(this.f134159b);
            w.b("Luggage.STANDALONE.HTMLWebViewJsApiPermissionController", sb5.toString());
            this.f134160c.invoke();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a5 f134161a;

        public l(a5 a5Var) {
            this.f134161a = a5Var;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(l5 l5Var) {
            h0 e16;
            h0 e17;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doSetJSAuth result:(");
            sb5.append((l5Var == null || (e17 = l5Var.e()) == null) ? -1 : e17.f127731d);
            sb5.append(", ");
            sb5.append((l5Var == null || (e16 = l5Var.e()) == null) ? null : e16.f127732e);
            sb5.append(") with api:");
            sb5.append(this.f134161a.f127270g);
            sb5.append(", url:");
            sb5.append(this.f134161a.f127268e);
            w.d("Luggage.STANDALONE.HTMLWebViewJsApiPermissionController", sb5.toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a5 f134162a;

        public m(a5 a5Var) {
            this.f134162a = a5Var;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("doSetJSAuth get exception:");
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            sb5.append(str);
            sb5.append(" with api:");
            sb5.append(this.f134162a.f127270g);
            sb5.append(", url:");
            sb5.append(this.f134162a.f127268e);
            w.b("Luggage.STANDALONE.HTMLWebViewJsApiPermissionController", sb5.toString());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("log", 0);
        hashMap.put("checkJsApi", 84);
        hashMap.put("chooseImage", 104);
        hashMap.put(com.tencent.luggage.wxa.l6.d.NAME, 57);
        hashMap.put("getNetworkType", 16);
        hashMap.put(com.tencent.luggage.wxa.l6.i.NAME, 295);
        f134108g = hashMap;
        f134109h = new String[]{com.tencent.luggage.wxa.l6.i.NAME, com.tencent.luggage.wxa.l6.l.NAME, "log"};
    }

    public c(com.tencent.luggage.wxa.m6.d urlCheckLogic, com.tencent.luggage.wxa.k6.b viewController) {
        Intrinsics.checkNotNullParameter(urlCheckLogic, "urlCheckLogic");
        Intrinsics.checkNotNullParameter(viewController, "viewController");
        this.f134110a = urlCheckLogic;
        this.f134111b = viewController;
        this.f134112c = com.tencent.luggage.wxa.l6.k.f133084a.a();
        this.f134113d = new e();
        urlCheckLogic.a(new a());
        this.f134114e = new ConcurrentHashMap();
    }

    public final void b(o oVar, JSONObject jSONObject, Function0 function0, Function0 function02) {
        String h16 = this.f134111b.h();
        y4 y4Var = (y4) this.f134114e.get(a(h16, oVar.getName()));
        int i3 = y4Var != null ? y4Var.f129067e : 0;
        if (i3 == 0) {
            a5 a16 = C6460c.f134116k.a(h16, oVar, jSONObject).a();
            this.f134111b.a("/cgi-bin/mmbiz-bin/jsapi-auth", a16, b5.class).a(com.tencent.luggage.wxa.yo.d.f146044a, new f(oVar, h16, function02, this, function0, a16)).a(new g(oVar, h16, function02));
        } else if (i3 != 1) {
            function02.invoke();
        } else {
            function0.invoke();
        }
    }

    public final void c(o oVar, JSONObject jSONObject, Function0 function0, Function0 function02) {
        String h16 = this.f134111b.h();
        this.f134111b.a("/cgi-bin/mmbiz-bin/jsapi-realtimeverify", C6460c.f134116k.a(h16, oVar, jSONObject).b(), j5.class).a(new j(1, function0, this, oVar, h16, function02)).a(new k(oVar, h16, function02));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        public final SparseIntArray f134127a = new SparseIntArray();

        public d() {
            b();
        }

        public final int a(String str) {
            o oVar;
            int i3;
            if ((str == null || str.length() == 0) || (oVar = (o) c.this.f134112c.get(str)) == null) {
                return 0;
            }
            synchronized (this.f134127a) {
                i3 = this.f134127a.get(oVar.getCtrlIndex(), 0);
            }
            return i3;
        }

        public final void b() {
            synchronized (this.f134127a) {
                a();
                for (String str : c.f134109h) {
                    a(str, 1);
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void a(String str, int i3) {
            o oVar;
            if ((str == null || str.length() == 0) || (oVar = (o) c.this.f134112c.get(str)) == null) {
                return;
            }
            synchronized (this.f134127a) {
                this.f134127a.put(oVar.getCtrlIndex(), i3);
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void a() {
            synchronized (this.f134127a) {
                this.f134127a.clear();
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void a(List list) {
            Intrinsics.checkNotNullParameter(list, "list");
            synchronized (this.f134127a) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    qb qbVar = (qb) it.next();
                    a(qbVar.f128519d, qbVar.f128520e);
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void a(byte[] controlBytes) {
            Intrinsics.checkNotNullParameter(controlBytes, "controlBytes");
            synchronized (this.f134127a) {
                int length = controlBytes.length;
                for (int i3 = 0; i3 < length; i3++) {
                    this.f134127a.put(i3, controlBytes[i3]);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void a(JSONObject data, Function0 onSuccess, Function1 onError) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        g5 g5Var = new g5();
        String g16 = this.f134111b.g();
        if (g16 == null || g16.length() == 0) {
            g16 = this.f134111b.h();
        }
        g5Var.f127667e = g16;
        g5Var.f127668f = data.optString("verifyAppId");
        LinkedList linkedList = g5Var.f127669g;
        List a16 = f134107f.a(data, "verifyJsApiList");
        if (a16 == null) {
            a16 = CollectionsKt__CollectionsKt.emptyList();
        }
        linkedList.addAll(a16);
        g5Var.f127670h = data.optString("verifyTimestamp");
        g5Var.f127671i = data.optString("verifyNonceStr");
        g5Var.f127672j = data.optString("verifySignature");
        g5Var.f127673k = data.optString("verifySignType");
        g5Var.f127674l = 0;
        g5Var.f127675m = this.f134111b.getAppId();
        if (com.tencent.luggage.wxa.k6.a.f131628a.a() && !g5Var.f127669g.contains(com.tencent.luggage.wxa.l6.d.NAME)) {
            g5Var.f127669g.add(com.tencent.luggage.wxa.l6.d.NAME);
        }
        this.f134111b.a("/cgi-bin/mmbiz-bin/jsapi-preverify", g5Var, h5.class).a(new h(onSuccess, onError, this, g5Var)).a(new i(onError));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class e {

        /* renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap f134129a = new ConcurrentHashMap();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Function {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f134131a;

            public a(c cVar) {
                this.f134131a = cVar;
            }

            @Override // java.util.function.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final d apply(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new d();
            }
        }

        public e() {
        }

        public final void a(String str, List list) {
            d dVar;
            Object putIfAbsent;
            Object batchUpdate;
            Intrinsics.checkNotNullParameter(list, "list");
            if (str == null || str.length() == 0) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                batchUpdate = this.f134129a.computeIfAbsent(com.tencent.luggage.wxa.m6.d.f134163j.b(str), new a(c.this));
                Intrinsics.checkNotNullExpressionValue(batchUpdate, "batchUpdate");
                dVar = (d) batchUpdate;
            } else {
                ConcurrentHashMap concurrentHashMap = this.f134129a;
                String b16 = com.tencent.luggage.wxa.m6.d.f134163j.b(str);
                c cVar = c.this;
                Object obj = concurrentHashMap.get(b16);
                if (obj == null && (putIfAbsent = concurrentHashMap.putIfAbsent(b16, (obj = new d()))) != null) {
                    obj = putIfAbsent;
                }
                Intrinsics.checkNotNullExpressionValue(obj, "{\n                map.ge\u2026          }\n            }");
                dVar = (d) obj;
            }
            dVar.a(list);
        }

        public final void a(String url, byte[] controlBytes) {
            Object putIfAbsent;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(controlBytes, "controlBytes");
            if (url.length() == 0) {
                return;
            }
            ConcurrentHashMap concurrentHashMap = this.f134129a;
            String b16 = com.tencent.luggage.wxa.m6.d.f134163j.b(url);
            c cVar = c.this;
            Object obj = concurrentHashMap.get(b16);
            if (obj == null && (putIfAbsent = concurrentHashMap.putIfAbsent(b16, (obj = new d()))) != null) {
                obj = putIfAbsent;
            }
            ((d) obj).a(controlBytes);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int a(String str, String str2, String str3) {
            boolean contains;
            d dVar;
            boolean z16 = true;
            if ((str3 == null || str3.length() == 0) == true) {
                return 0;
            }
            contains = ArraysKt___ArraysKt.contains(c.f134109h, str3);
            if ((str2 == null || str2.length() == 0) == false) {
                dVar = (d) this.f134129a.get(com.tencent.luggage.wxa.m6.d.f134163j.b(str2));
            } else {
                if (str != null && str.length() != 0) {
                    z16 = false;
                }
                if (z16) {
                    return contains ? 1 : 0;
                }
                dVar = (d) this.f134129a.get(com.tencent.luggage.wxa.m6.d.f134163j.b(str));
            }
            if (dVar == null) {
                return contains ? 1 : 0;
            }
            return dVar.a(str3);
        }
    }

    public final void a(o api, JSONObject dataJson, Function0 onAccept, Function0 onReject) {
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        Intrinsics.checkNotNullParameter(onAccept, "onAccept");
        Intrinsics.checkNotNullParameter(onReject, "onReject");
        if (api instanceof com.tencent.luggage.wxa.l6.l) {
            onAccept.invoke();
            return;
        }
        String h16 = this.f134111b.h();
        String g16 = this.f134111b.g();
        int a16 = this.f134113d.a(h16, g16, api.getName());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("checkApiPermission(");
        sb5.append(api.getName());
        sb5.append(", currentUrl:");
        sb5.append(h16 == null ? "" : h16);
        sb5.append(", commitUrl:");
        if (g16 == null) {
            g16 = "";
        }
        sb5.append(g16);
        sb5.append("), get value:");
        sb5.append(a16);
        w.d("Luggage.STANDALONE.HTMLWebViewJsApiPermissionController", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("checkApiPermission(");
        sb6.append(api.getName());
        sb6.append(", currentUrl:");
        if (h16 == null) {
            h16 = "";
        }
        sb6.append(h16);
        sb6.append("), get value:");
        sb6.append(a16);
        w.d("Luggage.STANDALONE.HTMLWebViewJsApiPermissionController", sb6.toString());
        if (a16 == 1) {
            onAccept.invoke();
            return;
        }
        if (api instanceof v) {
            onReject.invoke();
            return;
        }
        if (a16 == 2) {
            if (api instanceof com.tencent.luggage.wxa.l6.l) {
                onAccept.invoke();
                return;
            } else {
                onReject.invoke();
                return;
            }
        }
        if (a16 == 3) {
            c(api, dataJson, onAccept, onReject);
        } else if (a16 != 4) {
            onReject.invoke();
        } else {
            b(api, dataJson, onAccept, onReject);
        }
    }

    public final String a(String str, String str2) {
        return str + util.base64_pad_url + str2;
    }

    public final void a(a5 a5Var, b5 b5Var) {
        LinkedList linkedList = b5Var.f127343h;
        Intrinsics.checkNotNullExpressionValue(linkedList, "verifyResponse.scope_auth_info");
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((a6) it.next()).f127279e = 1;
        }
        k5 k5Var = new k5();
        k5Var.f127999e = a5Var.f127268e;
        k5Var.f128000f = a5Var.f127269f;
        k5Var.f128001g = a5Var.f127270g;
        k5Var.f128002h = a5Var.f127271h;
        k5Var.f128003i = a5Var.f127272i;
        k5Var.f128004j = a5Var.f127273j;
        k5Var.f128005k = a5Var.f127274k;
        k5Var.f128006l = a5Var.f127275l;
        k5Var.f128007m = a5Var.f127276m;
        k5Var.f128008n.addAll(b5Var.f127343h);
        this.f134111b.a("/cgi-bin/mmbiz-bin/jsapi-setauth", k5Var, l5.class).a(new l(a5Var)).a(new m(a5Var));
    }

    public final String a(qb qbVar) {
        return "VerifyInfo:{jsapi_name=" + qbVar.f128519d + ", state=" + qbVar.f128520e + ", verify_ok=" + qbVar.f128521f + '}';
    }
}
