package com.tencent.zplan.http;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kx4.a;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J.\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J-\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J.\u0010\u0014\u001a\u00020\u000e\"\u0004\b\u0000\u0010\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0002\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/zplan/http/HttpRequestUtil;", "", "", "originalUrl", "", "headers", "Lorg/json/JSONObject;", "jsonObject", "Lokhttp3/Response;", "f", "T", "Lkx4/a;", "callback", "result", "", "e", "(Lkx4/a;Ljava/lang/Object;)V", "", "errCode", "errMsg", "d", "<init>", "()V", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class HttpRequestUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final HttpRequestUtil f385646a = new HttpRequestUtil();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/zplan/http/HttpRequestUtil$a", "Ljavax/net/ssl/HostnameVerifier;", "", "hostname", "Ljavax/net/ssl/SSLSession;", SessionDbHelper.SESSION_ID, "", "verify", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements HostnameVerifier {
        a() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(@Nullable String hostname, @Nullable SSLSession session) {
            return true;
        }
    }

    HttpRequestUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void d(final kx4.a<T> callback, final int errCode, final String errMsg) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.zplan.http.HttpRequestUtil$callbackFail$1
            @Override // java.lang.Runnable
            public final void run() {
                a aVar = a.this;
                if (aVar != null) {
                    aVar.onResultFailure(errCode, errMsg);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void e(final kx4.a<T> callback, final T result) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.zplan.http.HttpRequestUtil$callbackSuccess$1
            @Override // java.lang.Runnable
            public final void run() {
                a aVar = a.this;
                if (aVar != null) {
                    aVar.onResultSuccess(result);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Response f(String originalUrl, Map<String, String> headers, JSONObject jsonObject) {
        Request.Builder url = new Request.Builder().url(originalUrl);
        url.header("Content-Type", "application/json");
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            url.header(entry.getKey(), entry.getValue());
        }
        String jSONObject = jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.toString()");
        url.post(RequestBody.create(MediaType.parse("application/json"), jSONObject));
        try {
            Request build = url.build();
            QLog.i("HttpRequestUtil", 1, "sendHttpPostRequest headers= " + build.headers());
            return new OkHttpClient.Builder().hostnameVerifier(new a()).build().newCall(build).execute();
        } catch (Exception e16) {
            QLog.e("HttpRequestUtil", 1, "sendHttpPostRequest Exception", e16);
            return null;
        }
    }
}
