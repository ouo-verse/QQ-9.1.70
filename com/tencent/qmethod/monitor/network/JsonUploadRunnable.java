package com.tencent.qmethod.monitor.network;

import android.net.http.Headers;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.auth.k;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qmethod.pandoraex.core.o;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0002#$B3\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020\n\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J,\u0010\u0010\u001a\u00020\u00052\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\rj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/qmethod/monitor/network/JsonUploadRunnable;", "Lcom/tencent/qmethod/monitor/network/f;", "Ljava/lang/Runnable;", "Ljava/net/HttpURLConnection;", Headers.CONN_DIRECTIVE, "", "i", "", h.F, "resp", "", AdMetricTag.RESPONSE_CODE, "g", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "headers", "f", TencentLocation.RUN_MODE, "Lorg/json/JSONObject;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lorg/json/JSONObject;", "params", "Lcom/tencent/qmethod/monitor/network/c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qmethod/monitor/network/c;", "callback", "D", "Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "Ljava/net/URL;", "url", "timeoutTime", "<init>", "(Ljava/net/URL;Lorg/json/JSONObject;Lcom/tencent/qmethod/monitor/network/c;Ljava/lang/String;I)V", "E", "a", "b", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class JsonUploadRunnable extends f implements Runnable {

    /* renamed from: C, reason: from kotlin metadata */
    private final c callback;

    /* renamed from: D, reason: from kotlin metadata */
    private final String requestId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final JSONObject params;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qmethod/monitor/network/JsonUploadRunnable$b;", "Ljava/io/DataOutputStream;", "", "b", "", DebugKt.DEBUG_PROPERTY_VALUE_OFF, com.tencent.luggage.wxa.c8.c.E, "", k.f247492f, "", "d", "J", "getLength", "()J", "setLength", "(J)V", "length", "Ljava/io/OutputStream;", "out", "<init>", "(Ljava/io/OutputStream;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class b extends DataOutputStream {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long length;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull OutputStream out) {
            super(out);
            Intrinsics.checkParameterIsNotNull(out, "out");
        }

        @Override // java.io.DataOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
        public void write(@Nullable byte[] b16, int off, int len) {
            super.write(b16, off, len);
            this.length += len;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonUploadRunnable(@NotNull URL url, @NotNull JSONObject params, @NotNull c callback, @NotNull String requestId, int i3) {
        super(url, i3);
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        Intrinsics.checkParameterIsNotNull(requestId, "requestId");
        this.params = params;
        this.callback = callback;
        this.requestId = requestId;
    }

    private final void f(HashMap<String, String> headers) {
        headers.put("Content-Encoding", "gzip");
        headers.put("Content-Type", "application/json; charset=utf-8;");
        headers.put("X-REQUEST-ID", this.requestId);
    }

    private final void g(String resp, int responseCode) {
        if (responseCode != 200) {
            this.callback.onFailure(responseCode, resp);
        } else {
            this.callback.onSuccess(resp);
        }
    }

    private final String h(HttpURLConnection connection) {
        InputStream inputStream;
        if (connection.getResponseCode() >= 400) {
            inputStream = connection.getErrorStream();
        } else {
            inputStream = connection.getInputStream();
        }
        String a16 = com.tencent.qmethod.monitor.base.util.c.a(new BufferedInputStream(inputStream), 8192);
        if (connection.getResponseCode() != 200) {
            o.c("JsonUpload", "responseCode:" + connection.getResponseCode() + " resp: " + a16);
        } else {
            com.tencent.qmethod.monitor.a.f343451h.g().r();
        }
        return a16;
    }

    private final void i(HttpURLConnection connection) {
        if (connection != null) {
            OutputStream outputStream = connection.getOutputStream();
            Intrinsics.checkExpressionValueIsNotNull(outputStream, "it.outputStream");
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new b(outputStream));
            try {
                String jSONObject = this.params.toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject, "params.toString()");
                Charset forName = Charset.forName("utf-8");
                Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(charsetName)");
                if (jSONObject != null) {
                    byte[] bytes = jSONObject.getBytes(forName);
                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.finish();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(gZIPOutputStream, null);
                    com.tencent.qmethod.monitor.a.f343451h.g().r();
                    g(h(connection), connection.getResponseCode());
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    CloseableKt.closeFinally(gZIPOutputStream, th5);
                    throw th6;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap<String, String> hashMap = new HashMap<>();
        f(hashMap);
        o.e("JsonUpload", "url: " + getUrl());
        HttpURLConnection b16 = b(hashMap);
        try {
            if (b16 != null) {
                try {
                    try {
                        try {
                            i(b16);
                        } catch (Exception e16) {
                            o.d("JsonUpload", e16 + ": param is " + this.params + " \n", e16);
                        }
                    } catch (OutOfMemoryError e17) {
                        try {
                            this.callback.onFailure(600, "OutOfMemoryError");
                            o.d("JsonUpload", e17 + ": param is " + this.params + " \n", e17);
                        } catch (Exception e18) {
                            o.d("JsonUpload", e18 + ": param is " + this.params + " \n", e18);
                        } catch (OutOfMemoryError e19) {
                            o.d("JsonUpload", e19 + ": param is " + this.params + " \n", e19);
                        }
                    }
                } finally {
                    b16.disconnect();
                    return;
                }
                b16.disconnect();
                return;
            }
            this.callback.onFailure(700, "connection null");
        } catch (Throwable th5) {
            b16.disconnect();
        }
    }
}
