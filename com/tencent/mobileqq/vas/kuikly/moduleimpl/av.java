package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.webview.webso.c;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u0013\u0017B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ?\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J?\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0016J=\u0010\u0010\u001a\u00020\b2+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\b\u0010\u0011\u001a\u00020\bH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/av;", "", "Lcom/tencent/mobileqq/webview/webso/c$b;", "state", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "g", "", "params", "f", "args", "d", "e", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "cgiRequestHandler", "", "b", "Z", "isDestroy", "<init>", "()V", "c", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class av {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Handler cgiRequestHandler;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isDestroy;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJS\u0010\u000e\u001a\u00020\u0006*'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\u0004\u0018\u0001`\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u000fR\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/av$a;", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "", "host", "", "status", "code", "message", "b", "Lorg/json/JSONObject;", "jsonObj", "c", "CGI_CODE_ERROR", "I", "CGI_CODE_SUCCESS", "CGI_STATUS_ERROR", "CGI_STATUS_OPEN", "CGI_STATUS_SEND", "CGI_STATUS_SUCCESS", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.kuikly.moduleimpl.av$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(Function1<Object, Unit> function1, String str, int i3, int i16, String str2) {
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("host", str);
                jSONObject.put("status", i3);
                jSONObject.put("code", i16);
                jSONObject.put("message", str2);
                function1.invoke(jSONObject.toString());
            }
        }

        @Nullable
        public final String c(@NotNull JSONObject jsonObj) {
            boolean z16;
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            StringBuilder sb5 = new StringBuilder();
            try {
                Iterator keys = jsonObj.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    String string = jsonObj.getString(str);
                    sb5.append(URLEncoder.encode(str, "UTF-8"));
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(URLEncoder.encode(string, "UTF-8"));
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                }
                if (sb5.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    sb5.deleteCharAt(sb5.length() - 1);
                }
                return sb5.toString();
            } catch (Exception unused) {
                return null;
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011RG\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/av$b;", "Lcom/tencent/mobileqq/webview/webso/c$a;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "j", "Lkotlin/jvm/functions/Function1;", "a", "()Lkotlin/jvm/functions/Function1;", "b", "(Lkotlin/jvm/functions/Function1;)V", "kuiklyCallback", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends c.a {

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Function1<Object, Unit> kuiklyCallback;

        @Nullable
        public final Function1<Object, Unit> a() {
            return this.kuiklyCallback;
        }

        public final void b(@Nullable Function1<Object, Unit> function1) {
            this.kuiklyCallback = function1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/kuikly/moduleimpl/av$c", "Lcom/tencent/mobileqq/vas/api/VasSkey$c;", "", "", "domainToPskeyMap", "", "onSuccess", "errMsg", "onFail", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements VasSkey.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f309817a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f309818b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f309819c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f309820d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f309821e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ av f309822f;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/kuikly/moduleimpl/av$c$a", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class a extends Handler {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ av f309823a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f309824b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(av avVar, b bVar, Looper looper) {
                super(looper);
                this.f309823a = avVar;
                this.f309824b = bVar;
            }

            @Override // android.os.Handler
            public void handleMessage(@NotNull Message msg2) {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                Object obj = msg2.obj;
                if ((obj instanceof c.b) && msg2.what == 204) {
                    av avVar = this.f309823a;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.webview.webso.WebSoCgiService.WebSoCgiState");
                    avVar.g((c.b) obj, this.f309824b.a());
                }
            }
        }

        c(String str, Function1<Object, Unit> function1, b bVar, JSONObject jSONObject, String str2, av avVar) {
            this.f309817a = str;
            this.f309818b = function1;
            this.f309819c = bVar;
            this.f309820d = jSONObject;
            this.f309821e = str2;
            this.f309822f = avVar;
        }

        @Override // com.tencent.mobileqq.vas.api.VasSkey.c
        public void onFail(@NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("VasWnsCgi", 1, this.f309817a + " getPsKey Failed errMsg:" + errMsg);
            av.INSTANCE.b(this.f309818b, this.f309817a, 1, -1, "\u672a\u83b7\u53d6pskey");
        }

        @Override // com.tencent.mobileqq.vas.api.VasSkey.c
        public void onSuccess(@NotNull Map<String, String> domainToPskeyMap) {
            boolean equals;
            JSONObject jSONObject;
            boolean equals2;
            Intrinsics.checkNotNullParameter(domainToPskeyMap, "domainToPskeyMap");
            String str = domainToPskeyMap.get(this.f309817a);
            if (TextUtils.isEmpty(str)) {
                QLog.e("VasWnsCgi", 1, this.f309817a + " getPsKey empty");
                av.INSTANCE.b(this.f309818b, this.f309817a, 1, -1, "\u672a\u83b7\u53d6pskey");
                return;
            }
            String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
            String str2 = "uin=o" + currentUin + ";p_uin=o" + currentUin + ";p_skey=" + str;
            try {
                if (!TextUtils.isEmpty(this.f309819c.f315003a)) {
                    this.f309819c.f315004b = this.f309820d.optString("method");
                    equals = StringsKt__StringsJVMKt.equals("GET", this.f309819c.f315004b, true);
                    if (!equals) {
                        equals2 = StringsKt__StringsJVMKt.equals("POST", this.f309819c.f315004b, true);
                        if (!equals2) {
                            throw new Exception("no such method support!!!");
                        }
                    }
                    Object opt = this.f309820d.opt("body");
                    String str3 = null;
                    if (opt instanceof JSONObject) {
                        b bVar = this.f309819c;
                        bVar.f315007e = "application/x-www-form-urlencoded";
                        bVar.f315006d = av.INSTANCE.c((JSONObject) opt);
                    } else {
                        b bVar2 = this.f309819c;
                        bVar2.f315007e = null;
                        bVar2.f315006d = opt.toString();
                    }
                    Object opt2 = this.f309820d.opt("header");
                    if (opt2 != null && !(opt2 instanceof JSONObject)) {
                        throw new Exception("header format error!!!");
                    }
                    if (opt2 instanceof JSONObject) {
                        jSONObject = (JSONObject) opt2;
                    } else {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        jSONObject.put("Cookie", str2);
                    }
                    b bVar3 = this.f309819c;
                    if (opt2 != null) {
                        str3 = opt2.toString();
                    }
                    bVar3.f315005c = str3;
                    this.f309819c.f315009g = this.f309820d.optBoolean("dataNeedBase64", false);
                    this.f309819c.f315010h = (int) (this.f309820d.optDouble("timeout", 0.0d) * 1000);
                    this.f309819c.f315011i = this.f309820d.opt("userinfo");
                    if (this.f309822f.cgiRequestHandler == null) {
                        this.f309822f.cgiRequestHandler = new a(this.f309822f, this.f309819c, Looper.getMainLooper());
                    }
                    if (!com.tencent.mobileqq.webview.webso.c.c().h(this.f309819c, this.f309822f.cgiRequestHandler)) {
                        c.b bVar4 = new c.b();
                        b bVar5 = this.f309819c;
                        bVar4.f315013b = bVar5.f315003a;
                        bVar4.f315016e = 1;
                        bVar4.f315020i = 101;
                        bVar4.f315021j = "send req fail!";
                        this.f309822f.g(bVar4, bVar5.a());
                        return;
                    }
                    return;
                }
                throw new Exception("url is empty!!!");
            } catch (Exception e16) {
                QLog.w("VasWnsCgi", 1, "wnscgi error,args is " + this.f309821e, e16);
                c.b bVar6 = new c.b();
                bVar6.f315013b = this.f309819c.f315003a;
                bVar6.f315016e = 3;
                bVar6.f315020i = 101;
                bVar6.f315021j = e16.getMessage();
                b bVar7 = this.f309819c;
                bVar6.f315019h = bVar7.f315008f;
                this.f309822f.g(bVar6, bVar7.a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(c.b state, Function1<Object, Unit> callback) {
        String str;
        String str2;
        if (callback == null || state == null) {
            return;
        }
        QLog.i("VasWnsCgi", 1, "state is " + state);
        try {
            JSONObject jSONObject = new JSONObject();
            int i3 = state.f315016e;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            jSONObject.put("status", 100);
                        }
                    } else {
                        jSONObject.put("status", 1);
                    }
                } else {
                    jSONObject.put("status", 4);
                }
            } else {
                jSONObject.put("status", 2);
            }
            if (!TextUtils.isEmpty(state.f315013b)) {
                jSONObject.put("url", state.f315013b);
            }
            jSONObject.put("code", state.f315020i);
            if (!TextUtils.isEmpty(state.f315021j)) {
                jSONObject.put("msg", state.f315021j);
            }
            jSONObject.put("dataIsBase64", state.f315018g);
            if (!TextUtils.isEmpty(state.f315015d)) {
                if (state.f315018g) {
                    String str3 = state.f315015d;
                    Intrinsics.checkNotNullExpressionValue(str3, "state.htmlBody");
                    byte[] bytes = str3.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    str2 = PluginBaseInfoHelper.Base64Helper.encodeToString(bytes, 0);
                } else {
                    str2 = state.f315015d;
                }
                jSONObject.put("data", str2);
            } else {
                jSONObject.put("data", "");
            }
            int i16 = state.f315017f;
            if (i16 > 0) {
                jSONObject.put("httpStatusCode", i16);
            }
            if (!TextUtils.isEmpty(state.f315014c)) {
                jSONObject.put("header", new JSONObject(state.f315014c));
            }
            Object obj = state.f315022k;
            if (obj != null) {
                jSONObject.put("userinfo", obj);
            }
            d(callback, jSONObject.toString());
            long currentTimeMillis = System.currentTimeMillis() - state.f315025n;
            QLog.i("VasWnsCgi", 1, "wnscgi@ status=" + state.f315016e + ",total cost " + currentTimeMillis + " ms");
        } catch (Exception e16) {
            e16.printStackTrace();
            Companion companion = INSTANCE;
            String message = e16.getMessage();
            if (message == null) {
                str = "";
            } else {
                str = message;
            }
            companion.b(callback, "", 1, -1, str);
        }
    }

    public final void d(@Nullable Function1<Object, Unit> callback, @Nullable String args) {
        if (!this.isDestroy && callback != null) {
            callback.invoke(args);
        }
    }

    public void e() {
        this.isDestroy = true;
    }

    public void f(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        if (TextUtils.isEmpty(params)) {
            QLog.d("VasWnsCgi", 1, "VasWnsCgi.handleWnsCgi args is empty");
            return;
        }
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(params);
            bVar.b(callback);
            bVar.f315003a = jSONObject.optString("url");
            String optString = jSONObject.optString("domain");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"domain\")");
            if (TextUtils.isEmpty(optString)) {
                INSTANCE.b(callback, optString, 1, -1, "\u6ca1\u6709domain");
            } else {
                VasSkey.getPSkey(MobileQQ.sMobileQQ.peekAppRuntime(), optString, new c(optString, callback, bVar, jSONObject, params, this));
            }
        } catch (Exception e16) {
            Companion companion = INSTANCE;
            String message = e16.getMessage();
            if (message == null) {
                message = "";
            }
            companion.b(callback, "", 1, -1, message);
        }
    }
}
