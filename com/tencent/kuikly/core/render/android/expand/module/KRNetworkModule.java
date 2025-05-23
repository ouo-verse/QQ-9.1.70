package com.tencent.kuikly.core.render.android.expand.module;

import android.net.http.Headers;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.kuikly.core.render.android.expand.module.KRNetworkModule;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import d01.w;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.fileupload.FileUploadBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J?\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JE\u0010\u0012\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002JM\u0010\u0015\u001a\u00020\t2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\n2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002JI\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016JE\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00102#\u0010\u001d\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\t0\u0004R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/KRNetworkModule;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "l", "errorMsg", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "i", "resultData", "headers", "j", "method", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "url", "storePath", "timeoutS", "filePath", "resultCallback", "d", "", "Lcom/tencent/kuikly/core/render/android/expand/module/KRHttpEventStreamRequestSession;", "Ljava/util/Map;", "httpEventStreamSessionMap", "<init>", "()V", "e", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRNetworkModule extends i01.e {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Map<String, KRHttpEventStreamRequestSession> httpEventStreamSessionMap = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004J*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\"\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J \u0010\u0017\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0014\u0010 \u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0019R\u0014\u0010\"\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0014\u0010$\u001a\u00020#8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006("}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/KRNetworkModule$a;", "", "Lorg/json/JSONObject;", "param", "", "c", "header", "", "e", "url", "d", "Ljava/io/InputStream;", "inputStream", "g", "Ljava/net/HttpURLConnection;", Headers.CONN_DIRECTIVE, "method", "", tl.h.F, "Ljava/net/URLConnection;", "a", "cookie", "b", "f", "HTTP_METHOD_GET", "Ljava/lang/String;", "HTTP_METHOD_POST", "KEY_ERROR_MSG", "KEY_HEADERS", "KEY_STATUS_CODE", "KEY_SUCCESS", "METHOD_CANCEL_HTTP_EVENT_STREAM_REQUEST", "METHOD_HTTP_REQUEST", "METHOD_START_HTTP_EVENT_STREAM_REQUEST", "MODULE_NAME", "", "STATE_CODE_UNKNOWN", "I", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.module.KRNetworkModule$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        private final String c(JSONObject param) {
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

        private final String d(String url, JSONObject param) {
            boolean z16;
            String str;
            boolean contains$default;
            if (param == null) {
                return url;
            }
            Iterator keys = param.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "keys");
            StringBuilder sb5 = null;
            while (true) {
                boolean z17 = true;
                z16 = false;
                if (!keys.hasNext()) {
                    break;
                }
                String str2 = (String) keys.next();
                Object opt = param.opt(str2);
                if (opt != null) {
                    str = opt.toString();
                } else {
                    str = null;
                }
                String value = URLEncoder.encode(str);
                Intrinsics.checkNotNullExpressionValue(value, "value");
                if (value.length() <= 0) {
                    z17 = false;
                }
                if (z17) {
                    value = StringsKt__StringsJVMKt.replace$default(value, Marker.ANY_NON_NULL_MARKER, "%20", false, 4, (Object) null);
                }
                if (sb5 == null) {
                    sb5 = new StringBuilder();
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
                    if (!contains$default) {
                        sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                    } else {
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                    }
                } else {
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                }
                sb5.append(str2);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(value);
            }
            if (sb5 != null) {
                if (sb5.length() > 0) {
                    z16 = true;
                }
                if (z16) {
                    return url + sb5.toString();
                }
                return url;
            }
            return url;
        }

        private final boolean e(JSONObject header) {
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

        public final void a(@NotNull URLConnection connection, @NotNull String method, @Nullable JSONObject header, @Nullable JSONObject param) {
            String c16;
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(method, "method");
            if (param != null && Intrinsics.areEqual(method, "POST")) {
                connection.setDoOutput(true);
                if (e(header)) {
                    c16 = param.toString();
                } else {
                    c16 = c(param);
                }
                Intrinsics.checkNotNullExpressionValue(c16, "if (isContentTypeJson(he\u2026(param)\n                }");
                DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
                Charset charset = Charsets.UTF_8;
                if (c16 != null) {
                    byte[] bytes = c16.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    dataOutputStream.write(bytes);
                    dataOutputStream.close();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }

        public final void b(@NotNull URLConnection connection, @Nullable JSONObject header, @Nullable String cookie) {
            String str;
            Intrinsics.checkNotNullParameter(connection, "connection");
            if (cookie != null) {
                connection.addRequestProperty("Cookie", cookie);
            }
            if (header != null) {
                Iterator keys = header.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "keys");
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    Object opt = header.opt(str2);
                    if (opt == null || (str = opt.toString()) == null) {
                        str = "";
                    }
                    connection.addRequestProperty(str2, str);
                }
            }
        }

        @NotNull
        public final URLConnection f(@NotNull String url, @NotNull String method, @Nullable JSONObject param) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(method, "method");
            if (Intrinsics.areEqual(method, "GET")) {
                url = d(url, param);
            }
            URLConnection openConnection = new URL(url).openConnection();
            Intrinsics.checkNotNullExpressionValue(openConnection, "requestUrl.openConnection()");
            return openConnection;
        }

        @NotNull
        public final String g(@Nullable InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return "{}";
            }
            StringBuilder sb5 = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            char[] cArr = new char[2048];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    sb5.append(cArr, 0, read);
                } else {
                    bufferedReader.close();
                    String sb6 = sb5.toString();
                    Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
                    return sb6;
                }
            }
        }

        public final void h(@NotNull HttpURLConnection connection, @NotNull String method) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(method, "method");
            connection.setRequestMethod(method);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void c(String params) {
        KRHttpEventStreamRequestSession remove = this.httpEventStreamSessionMap.remove(KRCSSViewExtensionKt.k0(params).optString("eventStreamSessionId"));
        if (remove != null) {
            remove.g();
        }
    }

    public static /* synthetic */ void g(KRNetworkModule kRNetworkModule, String str, String str2, int i3, Function1 function1, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 30;
        }
        kRNetworkModule.d(str, str2, i3, function1);
    }

    private final void i(Function1<Object, Unit> callback, String errorMsg, int statusCode) {
        Map mapOf;
        if (callback != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("success", 0), TuplesKt.to("errorMsg", errorMsg), TuplesKt.to(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(statusCode)));
            callback.invoke(mapOf);
        }
    }

    private final void j(Function1<Object, Unit> callback, String resultData, String headers, int statusCode) {
        Map mapOf;
        if (callback != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("data", resultData), TuplesKt.to("success", 1), TuplesKt.to("errorMsg", ""), TuplesKt.to("headers", headers), TuplesKt.to(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(statusCode)));
            callback.invoke(mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0133 A[Catch: IOException -> 0x012f, TryCatch #9 {IOException -> 0x012f, blocks: (B:51:0x012b, B:41:0x0133, B:43:0x0138), top: B:50:0x012b }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0138 A[Catch: IOException -> 0x012f, TRY_LEAVE, TryCatch #9 {IOException -> 0x012f, blocks: (B:51:0x012b, B:41:0x0133, B:43:0x0138), top: B:50:0x012b }] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.tencent.kuikly.core.render.android.expand.module.KRNetworkModule$a] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(String params, Function1<Object, Unit> callback) {
        InputStream inputStream;
        w wVar;
        StringBuilder sb5;
        String str;
        String str2;
        ?? r06 = "";
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        ?? r36 = "url";
        String url = k06.optString("url");
        String method = k06.optString("method");
        JSONObject optJSONObject = k06.optJSONObject("param");
        JSONObject optJSONObject2 = k06.optJSONObject("headers");
        String optString = k06.optString("cookie");
        int optInt = k06.optInt("timeout");
        InputStream inputStream2 = null;
        try {
            try {
                ?? r112 = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(url, "url");
                Intrinsics.checkNotNullExpressionValue(method, "method");
                URLConnection f16 = r112.f(url, method, optJSONObject);
                if (f16 != null) {
                    r36 = (HttpURLConnection) f16;
                    int i3 = optInt * 1000;
                    try {
                        r36.setConnectTimeout(i3);
                        r36.setReadTimeout(i3);
                        r36.setUseCaches(false);
                        r36.setDoInput(true);
                        r112.b(r36, optJSONObject2, optString);
                        r112.a(r36, method, optJSONObject2, optJSONObject);
                        r112.h(r36, method);
                        int responseCode = r36.getResponseCode();
                        if (responseCode >= 200 && responseCode <= 299) {
                            InputStream inputStream3 = r36.getInputStream();
                            try {
                                if (r36.getHeaderFields() == null) {
                                    str2 = "";
                                } else {
                                    Map<String, List<String>> headerFields = r36.getHeaderFields();
                                    Intrinsics.checkNotNullExpressionValue(headerFields, "connection.headerFields");
                                    str2 = com.tencent.kuikly.core.render.android.css.ktx.b.E(headerFields).toString();
                                }
                                Intrinsics.checkNotNullExpressionValue(str2, "if (connection.headerFie\u2026ject().toString() else \"\"");
                                str = str2;
                            } catch (Throwable th5) {
                                try {
                                    w.f392617a.b("KRNetworkModule", "headerFields to json occur exception: " + th5);
                                    str = r06;
                                } catch (Exception e16) {
                                    e = e16;
                                    inputStream = null;
                                    inputStream2 = inputStream3;
                                    w.f392617a.b("KRNetworkModule", "Network module error: " + e);
                                    i(callback, "io exception", -1000);
                                    if (inputStream2 != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (r36 == 0) {
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    r06 = 0;
                                    inputStream2 = inputStream3;
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e17) {
                                            w.f392617a.b("KRNetworkModule", "Network module close error: " + e17);
                                            throw th;
                                        }
                                    }
                                    if (r06 != 0) {
                                        r06.close();
                                    }
                                    if (r36 != 0) {
                                        r36.disconnect();
                                    }
                                    throw th;
                                }
                            }
                            j(callback, INSTANCE.g(inputStream3), str, responseCode);
                            inputStream = null;
                            inputStream2 = inputStream3;
                        } else {
                            inputStream = r36.getErrorStream();
                            try {
                                i(callback, r112.g(inputStream), responseCode);
                            } catch (Exception e18) {
                                e = e18;
                                w.f392617a.b("KRNetworkModule", "Network module error: " + e);
                                i(callback, "io exception", -1000);
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e19) {
                                        e = e19;
                                        wVar = w.f392617a;
                                        sb5 = new StringBuilder();
                                        sb5.append("Network module close error: ");
                                        sb5.append(e);
                                        wVar.b("KRNetworkModule", sb5.toString());
                                        return;
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (r36 == 0) {
                                    r36.disconnect();
                                    return;
                                }
                                return;
                            }
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e26) {
                                e = e26;
                                wVar = w.f392617a;
                                sb5 = new StringBuilder();
                                sb5.append("Network module close error: ");
                                sb5.append(e);
                                wVar.b("KRNetworkModule", sb5.toString());
                                return;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        r36.disconnect();
                    } catch (Exception e27) {
                        e = e27;
                        inputStream = null;
                    } catch (Throwable th7) {
                        th = th7;
                        r06 = 0;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
                }
            } catch (Exception e28) {
                e = e28;
                inputStream = null;
                r36 = 0;
            } catch (Throwable th8) {
                th = th8;
                r06 = 0;
                r36 = 0;
            }
        } catch (Throwable th9) {
            th = th9;
        }
    }

    private final void m(String params, Function1<Object, Unit> callback) {
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        String url = k06.optString("url");
        String method = k06.optString("method");
        JSONObject optJSONObject = k06.optJSONObject("param");
        JSONObject optJSONObject2 = k06.optJSONObject("headers");
        String cookie = k06.optString("cookie");
        int optInt = k06.optInt("timeout");
        KRHttpEventStreamRequestSession kRHttpEventStreamRequestSession = new KRHttpEventStreamRequestSession(callback);
        this.httpEventStreamSessionMap.put(kRHttpEventStreamRequestSession.getSessionId(), kRHttpEventStreamRequestSession);
        Intrinsics.checkNotNullExpressionValue(method, "method");
        Intrinsics.checkNotNullExpressionValue(url, "url");
        Intrinsics.checkNotNullExpressionValue(cookie, "cookie");
        kRHttpEventStreamRequestSession.o(method, url, optJSONObject, optJSONObject2, optInt, cookie);
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable final String params, @Nullable final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -1593497545) {
            if (hashCode != -1472536545) {
                if (hashCode == 1950177511 && method.equals("httpRequest")) {
                    d01.n k3 = d01.u.f392615m.k();
                    if (k3 != null) {
                        k3.a(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRNetworkModule$call$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                KRNetworkModule.this.l(params, callback);
                            }
                        });
                        return Unit.INSTANCE;
                    }
                    return null;
                }
            } else if (method.equals("startHttpEventStreamRequest")) {
                m(params, callback);
                return Unit.INSTANCE;
            }
        } else if (method.equals("cancelHttpEventStreamRequest")) {
            c(params);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }

    public final void d(@NotNull final String url, @NotNull final String storePath, final int timeoutS, @NotNull final Function1<? super String, Unit> resultCallback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(storePath, "storePath");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        d01.n k3 = d01.u.f392615m.k();
        if (k3 != null) {
            k3.a(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.module.KRNetworkModule$downloadFile$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:46:0x0119 A[Catch: IOException -> 0x0115, TryCatch #1 {IOException -> 0x0115, blocks: (B:58:0x0111, B:46:0x0119, B:48:0x011e, B:50:0x0123), top: B:57:0x0111 }] */
                /* JADX WARN: Removed duplicated region for block: B:48:0x011e A[Catch: IOException -> 0x0115, TryCatch #1 {IOException -> 0x0115, blocks: (B:58:0x0111, B:46:0x0119, B:48:0x011e, B:50:0x0123), top: B:57:0x0111 }] */
                /* JADX WARN: Removed duplicated region for block: B:50:0x0123 A[Catch: IOException -> 0x0115, TRY_LEAVE, TryCatch #1 {IOException -> 0x0115, blocks: (B:58:0x0111, B:46:0x0119, B:48:0x011e, B:50:0x0123), top: B:57:0x0111 }] */
                /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:57:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:63:0x013b A[Catch: IOException -> 0x0137, TryCatch #0 {IOException -> 0x0137, blocks: (B:74:0x0133, B:63:0x013b, B:65:0x0140, B:67:0x0145), top: B:73:0x0133 }] */
                /* JADX WARN: Removed duplicated region for block: B:65:0x0140 A[Catch: IOException -> 0x0137, TryCatch #0 {IOException -> 0x0137, blocks: (B:74:0x0133, B:63:0x013b, B:65:0x0140, B:67:0x0145), top: B:73:0x0133 }] */
                /* JADX WARN: Removed duplicated region for block: B:67:0x0145 A[Catch: IOException -> 0x0137, TRY_LEAVE, TryCatch #0 {IOException -> 0x0137, blocks: (B:74:0x0133, B:63:0x013b, B:65:0x0140, B:67:0x0145), top: B:73:0x0133 }] */
                /* JADX WARN: Removed duplicated region for block: B:73:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2() {
                    InputStream inputStream;
                    FileOutputStream fileOutputStream;
                    HttpURLConnection httpURLConnection;
                    w wVar;
                    StringBuilder sb5;
                    BufferedInputStream bufferedInputStream = null;
                    try {
                        KRNetworkModule.Companion companion = KRNetworkModule.INSTANCE;
                        URLConnection f16 = companion.f(url, "GET", null);
                        if (f16 != null) {
                            httpURLConnection = (HttpURLConnection) f16;
                            try {
                                httpURLConnection.setConnectTimeout(timeoutS * 1000);
                                httpURLConnection.setReadTimeout(timeoutS * 1000);
                                httpURLConnection.setUseCaches(false);
                                httpURLConnection.setDoInput(true);
                                companion.h(httpURLConnection, "GET");
                                int responseCode = httpURLConnection.getResponseCode();
                                if (responseCode >= 200 && responseCode <= 299) {
                                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                                    try {
                                        fileOutputStream = new FileOutputStream(new File(storePath));
                                    } catch (Exception e16) {
                                        e = e16;
                                        fileOutputStream = null;
                                        bufferedInputStream = bufferedInputStream2;
                                        inputStream = null;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        fileOutputStream = null;
                                        bufferedInputStream = bufferedInputStream2;
                                        inputStream = null;
                                    }
                                    try {
                                        byte[] bArr = new byte[2048];
                                        while (true) {
                                            int read = bufferedInputStream2.read(bArr);
                                            if (read == -1) {
                                                break;
                                            } else {
                                                fileOutputStream.write(bArr, 0, read);
                                            }
                                        }
                                        fileOutputStream.flush();
                                        resultCallback.invoke(storePath);
                                        bufferedInputStream = bufferedInputStream2;
                                        inputStream = null;
                                    } catch (Exception e17) {
                                        e = e17;
                                        bufferedInputStream = bufferedInputStream2;
                                        inputStream = null;
                                        w.f392617a.b("KRNetworkModule", "Network module error: " + e);
                                        if (bufferedInputStream != null) {
                                            try {
                                                bufferedInputStream.close();
                                            } catch (IOException e18) {
                                                e = e18;
                                                wVar = w.f392617a;
                                                sb5 = new StringBuilder();
                                                sb5.append("Network module close error: ");
                                                sb5.append(e);
                                                wVar.b("KRNetworkModule", sb5.toString());
                                                return;
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection == null) {
                                            httpURLConnection.disconnect();
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        bufferedInputStream = bufferedInputStream2;
                                        inputStream = null;
                                        if (bufferedInputStream != null) {
                                        }
                                        if (fileOutputStream != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (httpURLConnection != null) {
                                        }
                                        throw th;
                                    }
                                } else {
                                    resultCallback.invoke(null);
                                    inputStream = httpURLConnection.getErrorStream();
                                    try {
                                        String g16 = companion.g(inputStream);
                                        w.f392617a.b("KRNetworkModule", "download file error: " + g16);
                                        fileOutputStream = null;
                                    } catch (Exception e19) {
                                        e = e19;
                                        fileOutputStream = null;
                                        try {
                                            w.f392617a.b("KRNetworkModule", "Network module error: " + e);
                                            if (bufferedInputStream != null) {
                                            }
                                            if (fileOutputStream != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            if (httpURLConnection == null) {
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            if (bufferedInputStream != null) {
                                                try {
                                                    bufferedInputStream.close();
                                                } catch (IOException e26) {
                                                    w.f392617a.b("KRNetworkModule", "Network module close error: " + e26);
                                                    throw th;
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        fileOutputStream = null;
                                        if (bufferedInputStream != null) {
                                        }
                                        if (fileOutputStream != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (httpURLConnection != null) {
                                        }
                                        throw th;
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e27) {
                                        e = e27;
                                        wVar = w.f392617a;
                                        sb5 = new StringBuilder();
                                        sb5.append("Network module close error: ");
                                        sb5.append(e);
                                        wVar.b("KRNetworkModule", sb5.toString());
                                        return;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                httpURLConnection.disconnect();
                            } catch (Exception e28) {
                                e = e28;
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (Throwable th9) {
                                th = th9;
                                inputStream = null;
                                fileOutputStream = null;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
                        }
                    } catch (Exception e29) {
                        e = e29;
                        inputStream = null;
                        fileOutputStream = null;
                        httpURLConnection = null;
                    } catch (Throwable th10) {
                        th = th10;
                        inputStream = null;
                        fileOutputStream = null;
                        httpURLConnection = null;
                    }
                }
            });
        }
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        if (!this.httpEventStreamSessionMap.isEmpty()) {
            Iterator<T> it = this.httpEventStreamSessionMap.values().iterator();
            while (it.hasNext()) {
                ((KRHttpEventStreamRequestSession) it.next()).h();
            }
            this.httpEventStreamSessionMap.clear();
        }
    }
}
