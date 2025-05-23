package com.tencent.luggage.wxa.xd;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public static final h0 f144811a = new h0();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f144812a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f144813b;

        public a(com.tencent.luggage.wxa.ic.d dVar, String str) {
            this.f144812a = dVar;
            this.f144813b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BufferedWriter bufferedWriter;
            try {
                URLConnection openConnection = new URL("https://weapp.tencent.com/weapplib_coverage/saveCoverageData").openConnection();
                Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.addRequestProperty("Content-Type", "application/json");
                OutputStream outputStream = httpURLConnection.getOutputStream();
                Intrinsics.checkNotNullExpressionValue(outputStream, "connection.outputStream");
                Writer outputStreamWriter = new OutputStreamWriter(outputStream, Charsets.UTF_8);
                if (outputStreamWriter instanceof BufferedWriter) {
                    bufferedWriter = (BufferedWriter) outputStreamWriter;
                } else {
                    bufferedWriter = new BufferedWriter(outputStreamWriter, 8192);
                }
                bufferedWriter.write(this.f144813b);
                bufferedWriter.flush();
                bufferedWriter.close();
                httpURLConnection.getOutputStream().close();
                com.tencent.luggage.wxa.tn.w.d("Luggage.JSCoverageUtils", "reportCoverage for appId:" + this.f144812a.getAppId() + ", responseCode:" + httpURLConnection.getResponseCode() + ", data:" + this.f144813b);
            } catch (IOException e16) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.JSCoverageUtils", "reportCoverage for appId:" + this.f144812a.getAppId() + ", get exception:" + e16 + ", data:" + this.f144813b);
            }
        }
    }

    public final String a(Object obj) {
        if (obj instanceof com.tencent.luggage.wxa.b9.t) {
            return "Worker";
        }
        if (obj instanceof com.tencent.luggage.wxa.ei.h) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Context(");
            com.tencent.luggage.wxa.ei.h hVar = (com.tencent.luggage.wxa.ei.h) obj;
            sb5.append(hVar.n() ? "Main" : String.valueOf(hVar.q()));
            sb5.append(')');
            return sb5.toString();
        }
        if (!(obj instanceof com.tencent.luggage.wxa.kj.c1)) {
            throw new IllegalStateException("Invalid jsRuntime".toString());
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("Page(");
        com.tencent.luggage.wxa.kj.v pageView = ((com.tencent.luggage.wxa.kj.c1) obj).getPageView();
        sb6.append(pageView != null ? pageView.A0() : null);
        sb6.append(')');
        return sb6.toString();
    }

    public static final void a(com.tencent.luggage.wxa.ic.d component, Object jsRuntime, String str) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(jsRuntime, "jsRuntime");
        com.tencent.luggage.wxa.tn.w.d("Luggage.JSCoverageUtils", "reportCoverage(appId:" + component.getAppId() + ", " + f144811a.a(jsRuntime) + ", data:" + str + ')');
        if ((str == null || str.length() == 0) || Intrinsics.areEqual("null", str) || Intrinsics.areEqual("undefined", str)) {
            return;
        }
        com.tencent.luggage.wxa.rc.q i3 = component.i();
        Intrinsics.checkNotNull(i3);
        JSONObject jSONObject = new JSONObject();
        com.tencent.luggage.wxa.fd.i S = component.getRuntime().S();
        Intrinsics.checkNotNull(S, "null cannot be cast to non-null type com.tencent.luggage.sdk.config.AppBrandInitConfigLU");
        jSONObject.put("userUin", com.tencent.luggage.wxa.y8.h.a(((com.tencent.luggage.wxa.j4.d) S).f130798j0));
        jSONObject.put("platform", "android");
        jSONObject.put("CoverageData", str);
        jSONObject.put("weapplibVersion", i3.r());
        jSONObject.put("weapplibTime", i3.D());
        String appId = component.getAppId();
        if (appId == null) {
            appId = "";
        }
        jSONObject.put("appId", appId);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026y())\n        }.toString()");
        com.tencent.luggage.wxa.zp.h.f146825d.d(new a(component, jSONObject2));
    }
}
