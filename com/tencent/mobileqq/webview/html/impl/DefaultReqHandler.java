package com.tencent.mobileqq.webview.html.impl;

import android.net.TrafficStats;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.webview.html.SessionData;
import com.tencent.mobileqq.webview.html.c;
import com.tencent.mobileqq.webview.html.k;
import com.tencent.mobileqq.webview.html.m;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.upload.report.UploadQualityReportBuilder;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Call;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 \u000b2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u001a\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00190\u0018H\u0016J$\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001bj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u001cH\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0013H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\u0002H\u0016R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010&R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010)R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u00100R\u0018\u00103\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/webview/html/impl/DefaultReqHandler;", "Lcom/tencent/mobileqq/webview/html/k;", "", "j", "Lokhttp3/Response;", "response", "", "save2Ins", "", "i", "headerValue", h.F, "Ljava/io/BufferedInputStream;", "bis", HttpMsg.CHARSET, "k", "reqUrl", "Lcom/tencent/mobileqq/webview/html/m;", "sessionConfig", "Lcom/tencent/mobileqq/webview/html/SessionData;", "sessionData", "b", "", UploadQualityReportBuilder.STATE_CONNECT, "", "", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "key", "g", "f", "e", "Ljava/io/InputStream;", "getInputStream", "d", "disconnect", "Lcom/tencent/mobileqq/webview/html/m;", "Lcom/tencent/mobileqq/webview/html/SessionData;", "Lokhttp3/Call;", "Lokhttp3/Call;", "call", "Lokhttp3/Response;", "Lokhttp3/Headers;", "Lokhttp3/Headers;", "respHeaders", "Ljava/io/ByteArrayInputStream;", "Ljava/io/ByteArrayInputStream;", "savedIns", "Ljava/lang/String;", "url", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class DefaultReqHandler implements k {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private m sessionConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SessionData sessionData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Call call;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Response response;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Headers respHeaders;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ByteArrayInputStream savedIns;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String url;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/webview/html/impl/DefaultReqHandler$a;", "", "", "TAG", "Ljava/lang/String;", "", "THREAD_ID", "I", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.webview.html.impl.DefaultReqHandler$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40828);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DefaultReqHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String h(String headerValue) {
        int indexOf$default;
        String replace$default;
        int indexOf$default2;
        com.tencent.mobileqq.webview.html.a aVar = com.tencent.mobileqq.webview.html.a.f313876a;
        String b16 = aVar.b();
        if (!TextUtils.isEmpty(headerValue)) {
            Intrinsics.checkNotNull(headerValue);
            String lowerCase = headerValue.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) lowerCase, HttpMsg.CHARSET, 0, false, 6, (Object) null);
            if (indexOf$default != -1) {
                String substring = lowerCase.substring(indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                replace$default = StringsKt__StringsJVMKt.replace$default(substring, " ", "", false, 4, (Object) null);
                indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) replace$default, ";", 0, false, 6, (Object) null);
                if (indexOf$default2 == -1) {
                    indexOf$default2 = replace$default.length();
                }
                String substring2 = replace$default.substring(8, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                if (TextUtils.isEmpty(substring2)) {
                    return aVar.b();
                }
                return substring2;
            }
            return b16;
        }
        return b16;
    }

    private final String i(Response response, boolean save2Ins) {
        InputStream inputStream;
        String str;
        boolean equals;
        BufferedInputStream bufferedInputStream;
        ResponseBody body = response.body();
        Integer num = null;
        if (body != null) {
            inputStream = body.byteStream();
        } else {
            inputStream = null;
        }
        if (inputStream != null) {
            equals = StringsKt__StringsJVMKt.equals("gzip", g("Content-Encoding"), true);
            if (equals) {
                bufferedInputStream = new BufferedInputStream(new GZIPInputStream(inputStream));
            } else {
                bufferedInputStream = new BufferedInputStream(inputStream);
            }
            str = k(bufferedInputStream, d(), save2Ins);
            try {
                bufferedInputStream.close();
            } catch (Throwable th5) {
                c.f313882a.f("htmlAgent_DefaultReqHandler", 5, "parseHtml() exception", th5);
            }
        } else {
            str = null;
        }
        c cVar = c.f313882a;
        if (str != null) {
            num = Integer.valueOf(str.length());
        }
        c.g(cVar, "htmlAgent_DefaultReqHandler", 4, "parseFromResponse() done bs=" + inputStream + " html.size=" + num, null, 8, null);
        return str;
    }

    private final void j() {
        List<ConnectionSpec> listOf;
        OkHttpClient.Builder followRedirects = new OkHttpClient.Builder().followRedirects(false);
        m mVar = this.sessionConfig;
        m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfig");
            mVar = null;
        }
        OkHttpClient.Builder followSslRedirects = followRedirects.followSslRedirects(mVar.v());
        m mVar3 = this.sessionConfig;
        if (mVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfig");
            mVar3 = null;
        }
        OkHttpClient.Builder connectTimeout = followSslRedirects.connectTimeout(mVar3.b(), TimeUnit.SECONDS);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT});
        OkHttpClient build = connectTimeout.connectionSpecs(listOf).build();
        Headers.Builder builder = new Headers.Builder();
        m mVar4 = this.sessionConfig;
        if (mVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfig");
            mVar4 = null;
        }
        builder.add("Host", mVar4.e());
        builder.add("Accept", "text/html");
        builder.add("Accept-Encoding", "gzip");
        builder.add("Accept-Language", "zh-CN,zh;");
        builder.add("Upgrade-Insecure-Requests", "1");
        SessionData sessionData = this.sessionData;
        if (sessionData != null) {
            String str = sessionData.lastModified;
            if (str != null) {
                builder.add("If-Modified-Since", str);
            }
            String str2 = sessionData.eTag;
            if (str2 != null) {
                builder.add("If-None-Match", str2);
            }
        }
        String str3 = this.url;
        if (str3 != null) {
            m mVar5 = this.sessionConfig;
            if (mVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionConfig");
                mVar5 = null;
            }
            String d16 = mVar5.d(str3);
            if (d16 != null) {
                builder.add("Cookie", d16);
            }
        }
        m mVar6 = this.sessionConfig;
        if (mVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionConfig");
        } else {
            mVar2 = mVar6;
        }
        builder.add("User-Agent", mVar2.l());
        Headers build2 = builder.build();
        if (((Boolean) t.INSTANCE.a().b("debug_enable_verbose_log", Boolean.FALSE)).booleanValue()) {
            c.g(c.f313882a, "htmlAgent_DefaultReqHandler", 3, "reqHeaders=" + build2, null, 8, null);
        }
        Request.Builder builder2 = new Request.Builder().get();
        String str4 = this.url;
        Intrinsics.checkNotNull(str4);
        this.call = build.newCall(builder2.url(str4).headers(build2).build());
        TrafficStats.setThreadStatsTag(10000);
    }

    private final String k(BufferedInputStream bis, String charset, boolean save2Ins) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                byte[] bArr = new byte[10240];
                Ref.IntRef intRef = new Ref.IntRef();
                while (true) {
                    int read = bis.read(bArr);
                    intRef.element = read;
                    Unit unit = Unit.INSTANCE;
                    if (-1 == read) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (save2Ins) {
                    this.savedIns = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                }
                String byteArrayOutputStream2 = byteArrayOutputStream.toString(charset);
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    c.f313882a.f("htmlAgent_DefaultReqHandler", 5, "read() close exception", th5);
                }
                return byteArrayOutputStream2;
            } catch (Exception e16) {
                c.f313882a.f("htmlAgent_DefaultReqHandler", 5, "read() exception", e16);
                try {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th6) {
                    c.f313882a.f("htmlAgent_DefaultReqHandler", 5, "read() close exception", th6);
                    return null;
                }
            }
        } catch (Throwable th7) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th8) {
                c.f313882a.f("htmlAgent_DefaultReqHandler", 5, "read() close exception", th8);
            }
            throw th7;
        }
    }

    @Override // com.tencent.mobileqq.webview.html.k
    @NotNull
    public HashMap<String, String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HashMap) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : c().entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().get(0));
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.webview.html.k
    public void b(@NotNull String reqUrl, @NotNull m sessionConfig, @Nullable SessionData sessionData) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, reqUrl, sessionConfig, sessionData);
            return;
        }
        Intrinsics.checkNotNullParameter(reqUrl, "reqUrl");
        Intrinsics.checkNotNullParameter(sessionConfig, "sessionConfig");
        c.g(c.f313882a, "htmlAgent_DefaultReqHandler", 3, "init()", null, 8, null);
        this.url = reqUrl;
        this.sessionConfig = sessionConfig;
        this.sessionData = sessionData;
        j();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        r0 = kotlin.collections.MapsKt__MapsKt.toMap(r0);
     */
    @Override // com.tencent.mobileqq.webview.html.k
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, List<String>> c() {
        Map<String, List<String>> emptyMap;
        Map map;
        int mapCapacity;
        List list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Headers headers = this.respHeaders;
        if (headers == null || (r0 = headers.toMultimap()) == null || map == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(map.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            list = CollectionsKt___CollectionsKt.toList((Iterable) entry.getValue());
            linkedHashMap.put(key, list);
        }
        return linkedHashMap;
    }

    @Override // com.tencent.mobileqq.webview.html.k
    public int connect() throws IOException {
        Integer num;
        Headers headers;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        Call call = this.call;
        if (call != null) {
            Response execute = call.execute();
            this.response = execute;
            c cVar = c.f313882a;
            m mVar = null;
            if (execute != null) {
                num = Integer.valueOf(execute.code());
            } else {
                num = null;
            }
            c.g(cVar, "htmlAgent_DefaultReqHandler", 5, "connect() response.code=" + num, null, 8, null);
            Response response = this.response;
            if (response != null) {
                headers = response.headers();
            } else {
                headers = null;
            }
            this.respHeaders = headers;
            Response response2 = this.response;
            if (response2 != null) {
                if (response2.isSuccessful()) {
                    return 0;
                }
                if (response2.isRedirect()) {
                    m mVar2 = this.sessionConfig;
                    if (mVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sessionConfig");
                    } else {
                        mVar = mVar2;
                    }
                    if (mVar.u()) {
                        return 1;
                    }
                    return -1001;
                }
                if (response2.code() == 304) {
                    return 2;
                }
            }
        }
        return -1000;
    }

    @Override // com.tencent.mobileqq.webview.html.k
    @NotNull
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        String g16 = g("Content-Type");
        if (g16 != null) {
            return h(g16);
        }
        return com.tencent.mobileqq.webview.html.a.f313876a.b();
    }

    @Override // com.tencent.mobileqq.webview.html.k
    public void disconnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Response response = this.response;
        if (response != null) {
            c.g(c.f313882a, "htmlAgent_DefaultReqHandler", 4, "disconnect()", null, 8, null);
            try {
                response.close();
                this.response = null;
            } catch (Throwable th5) {
                c.f313882a.f("htmlAgent_DefaultReqHandler", 5, "disconnect() exception", th5);
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.html.k
    @Nullable
    public SessionData e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SessionData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.sessionData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.webview.html.k
    @Nullable
    public String f(boolean save2Ins) throws IOException {
        T t16;
        Integer num;
        String html;
        SessionData sessionData;
        String html2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, save2Ins);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Response response = this.response;
        if (response != null) {
            if (response.code() == 304) {
                if (save2Ins && (sessionData = this.sessionData) != null && (html2 = sessionData.getHtml()) != null) {
                    Charset defaultCharset = Charset.defaultCharset();
                    Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset()");
                    byte[] bytes = html2.getBytes(defaultCharset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    this.savedIns = new ByteArrayInputStream(bytes);
                }
                c cVar = c.f313882a;
                SessionData sessionData2 = this.sessionData;
                t16 = 0;
                if (sessionData2 != null && (html = sessionData2.getHtml()) != null) {
                    num = Integer.valueOf(html.length());
                } else {
                    num = null;
                }
                c.g(cVar, "htmlAgent_DefaultReqHandler", 4, "parse() from cache html.size=" + num, null, 8, null);
                SessionData sessionData3 = this.sessionData;
                if (sessionData3 != null) {
                    t16 = sessionData3.getHtml();
                }
            } else {
                t16 = i(response, save2Ins);
            }
            objectRef.element = t16;
        }
        return (String) objectRef.element;
    }

    @Override // com.tencent.mobileqq.webview.html.k
    @Nullable
    public String g(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) key);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, List<String>> c16 = c();
        String lowerCase = key.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        List<String> list = c16.get(lowerCase);
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.html.k
    @Nullable
    public InputStream getInputStream() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (InputStream) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.savedIns;
    }
}
