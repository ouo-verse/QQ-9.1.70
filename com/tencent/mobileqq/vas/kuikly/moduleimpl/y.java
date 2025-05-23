package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.vas.http.VasHttpRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.util.AppSetting;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.fileupload.FileUploadBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b \u0010!J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\u000e\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002JS\u0010\u001c\u001a\u00020\f*'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012j\u0004\u0018\u0001`\u00162\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u0002H\u0002J?\u0010\u001f\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022+\u0010\u001e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012j\u0004\u0018\u0001`\u0016H\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/y;", "", "", "url", "Lorg/json/JSONObject;", "param", "Lokhttp3/HttpUrl;", "e", "Lokhttp3/Headers$Builder;", "builder", "header", "cookie", "", "d", "c", "", "i", "f", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "", "success", "code", "msg", "data", "g", "params", "callback", "j", "<init>", "()V", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class y {

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f309860b = AppSetting.isDebugVersion();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final MediaType f309861c;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/kuikly/moduleimpl/y$b", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f309862a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ y f309863b;

        b(Function1<Object, Unit> function1, y yVar) {
            this.f309862a = function1;
            this.f309863b = yVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException e16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e16, "e");
            QLog.i("KuiklyHttpRequest", 1, "error", e16);
            Function1<Object, Unit> function1 = this.f309862a;
            if (function1 != null) {
                y.h(this.f309863b, function1, 0, -1, "\u8bf7\u6c42\u5931\u8d25", null, 8, null);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            Function1<Object, Unit> function1;
            InputStream inputStream;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            try {
                try {
                    int code = response.code();
                    QLog.i("KuiklyHttpRequest", 1, "success, code: " + code);
                    try {
                        if (response.isSuccessful()) {
                            boolean z16 = false;
                            if (200 <= code && code < 300) {
                                z16 = true;
                            }
                            if (z16) {
                                ResponseBody body = response.body();
                                StringBuilder sb5 = new StringBuilder();
                                if (body != null) {
                                    inputStream = body.byteStream();
                                } else {
                                    inputStream = null;
                                }
                                if (inputStream != null) {
                                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                                    while (true) {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        } else {
                                            sb5.append(readLine);
                                        }
                                    }
                                }
                                if (y.f309860b) {
                                    QLog.i("KuiklyHttpRequest", 1, "result:" + ((Object) sb5));
                                }
                                Function1<Object, Unit> function12 = this.f309862a;
                                if (function12 != null) {
                                    y yVar = this.f309863b;
                                    String sb6 = sb5.toString();
                                    Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
                                    yVar.g(function12, 1, code, "", sb6);
                                }
                                response.close();
                                return;
                            }
                        }
                        response.close();
                        return;
                    } catch (Exception unused) {
                        function1 = this.f309862a;
                        if (function1 == null) {
                            return;
                        }
                        y.h(this.f309863b, function1, 0, -1, "IO\u5f02\u5e38", null, 8, null);
                    }
                    String message = response.message();
                    Function1<Object, Unit> function13 = this.f309862a;
                    if (function13 != null) {
                        y.h(this.f309863b, function13, 0, code, message, null, 8, null);
                    }
                } catch (Exception e16) {
                    if (e16 instanceof IOException) {
                        Function1<Object, Unit> function14 = this.f309862a;
                        if (function14 != null) {
                            y.h(this.f309863b, function14, 0, -1, "IO\u5f02\u5e38", null, 8, null);
                        }
                    } else {
                        Function1<Object, Unit> function15 = this.f309862a;
                        if (function15 != null) {
                            y.h(this.f309863b, function15, 0, -1, "\u89e3\u6790\u5f02\u5e38", null, 8, null);
                        }
                    }
                    try {
                        response.close();
                    } catch (Exception unused2) {
                        function1 = this.f309862a;
                        if (function1 == null) {
                            return;
                        }
                        y.h(this.f309863b, function1, 0, -1, "IO\u5f02\u5e38", null, 8, null);
                    }
                }
            } catch (Throwable th5) {
                try {
                    response.close();
                } catch (Exception unused3) {
                    Function1<Object, Unit> function16 = this.f309862a;
                    if (function16 != null) {
                        y.h(this.f309863b, function16, 0, -1, "IO\u5f02\u5e38", null, 8, null);
                    }
                }
                throw th5;
            }
        }
    }

    static {
        MediaType parse = MediaType.INSTANCE.parse("application/json");
        Intrinsics.checkNotNull(parse);
        f309861c = parse;
    }

    private final String c(JSONObject header, JSONObject param) {
        if (param == null) {
            return "";
        }
        if (i(header)) {
            String jSONObject = param.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "{\n            param.toString()\n        }");
            return jSONObject;
        }
        return f(param);
    }

    private final void d(Headers.Builder builder, JSONObject header, String cookie) {
        String str;
        if (cookie != null) {
            builder.add("Cookie", cookie);
        }
        if (header != null) {
            Iterator keys = header.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys");
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Object opt = header.opt(key);
                if (opt == null || (str = opt.toString()) == null) {
                    str = "";
                }
                builder.add(key, str);
            }
        }
    }

    private final HttpUrl e(String url, JSONObject param) {
        HttpUrl.Builder newBuilder = HttpUrl.INSTANCE.get(url).newBuilder();
        if (param != null) {
            Iterator keys = param.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys");
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Object obj = param.get(key);
                Intrinsics.checkNotNullExpressionValue(key, "key");
                StringBuilder sb5 = new StringBuilder();
                sb5.append(obj);
                newBuilder.addQueryParameter(key, sb5.toString());
            }
        }
        return newBuilder.build();
    }

    private final String f(JSONObject param) {
        String str;
        if (param == null) {
            return "";
        }
        Iterator keys = param.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys");
        StringBuilder sb5 = null;
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            Object opt = param.opt(str2);
            if (opt == null || (str = opt.toString()) == null) {
                str = "";
            }
            if (sb5 == null) {
                sb5 = new StringBuilder();
            } else {
                sb5.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb5.append(str2);
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(str);
        }
        return String.valueOf(sb5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(Function1<Object, Unit> function1, int i3, int i16, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", i3);
        jSONObject.put("errorMsg", str);
        jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, i16);
        jSONObject.put("data", str2);
        if (function1 != null) {
            function1.invoke(jSONObject.toString());
        }
    }

    static /* synthetic */ void h(y yVar, Function1 function1, int i3, int i16, String str, String str2, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            str2 = "";
        }
        yVar.g(function1, i3, i16, str, str2);
    }

    private final boolean i(JSONObject header) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        if (header == null) {
            return false;
        }
        String optString = header.optString("Content-Type");
        Intrinsics.checkNotNullExpressionValue(optString, "header.optString(\"Content-Type\")");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) optString, (CharSequence) "application/json", false, 2, (Object) null);
        if (!contains$default) {
            String optString2 = header.optString("content-Type");
            Intrinsics.checkNotNullExpressionValue(optString2, "header.optString(\"content-Type\")");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) optString2, (CharSequence) "application/json", false, 2, (Object) null);
            if (!contains$default2) {
                String optString3 = header.optString(FileUploadBase.CONTENT_TYPE);
                Intrinsics.checkNotNullExpressionValue(optString3, "header.optString(\"Content-type\")");
                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) optString3, (CharSequence) "application/json", false, 2, (Object) null);
                if (!contains$default3) {
                    String optString4 = header.optString("content-type");
                    Intrinsics.checkNotNullExpressionValue(optString4, "header.optString(\"content-type\")");
                    contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) optString4, (CharSequence) "application/json", false, 2, (Object) null);
                    if (!contains$default4) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void j(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Request build;
        if (params == null && callback != null) {
            g(callback, 0, -1, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR, "");
        }
        if (params == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String url = jSONObject.optString("url");
        String method = jSONObject.optString("method");
        JSONObject optJSONObject = jSONObject.optJSONObject("param");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("headers");
        String optString = jSONObject.optString("cookie");
        jSONObject.optInt("timeout");
        Headers.Builder builder = new Headers.Builder();
        d(builder, optJSONObject2, optString);
        Headers build2 = builder.build();
        if (Intrinsics.areEqual("GET", method)) {
            Intrinsics.checkNotNullExpressionValue(url, "url");
            build = new Request.Builder().headers(build2).url(e(url, optJSONObject)).build();
        } else if (Intrinsics.areEqual("POST", method)) {
            String c16 = c(optJSONObject2, optJSONObject);
            RequestBody create = RequestBody.INSTANCE.create(f309861c, c16);
            QLog.i("KuiklyHttpRequest", 1, "header: " + optJSONObject2 + " param: " + c16);
            Request.Builder headers = new Request.Builder().headers(build2);
            Intrinsics.checkNotNullExpressionValue(url, "url");
            Request.Builder url2 = headers.url(url);
            Intrinsics.checkNotNullExpressionValue(method, "method");
            build = url2.method(method, create).build();
        } else {
            throw new IllegalArgumentException("method is " + method + ", is not support now!");
        }
        VasHttpRequest.f309555a.c().newCall(build).enqueue(new b(callback, this));
    }
}
