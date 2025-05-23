package com.tencent.luggage.wxa.kj;

import android.net.Uri;
import android.net.http.SslCertificate;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.wxa.kj.b0;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.cert.X509Certificate;
import java.util.Locale;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b0 {

    /* renamed from: a, reason: collision with root package name */
    public v f132078a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.yi.t f132079b;

    /* renamed from: c, reason: collision with root package name */
    public volatile String f132080c;

    /* renamed from: d, reason: collision with root package name */
    public final a f132081d = new a() { // from class: b31.c
        @Override // com.tencent.luggage.wxa.kj.b0.a
        public final WebResourceResponse a(com.tencent.luggage.wxa.kj.v vVar, String str) {
            return b0.a(vVar, str);
        }
    };

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        WebResourceResponse a(v vVar, String str);
    }

    public b0(v vVar) {
        this.f132078a = vVar;
    }

    public void a(int i3, int i16, int i17, int i18, View view) {
    }

    public void d(String str) {
        this.f132080c = str;
    }

    public static /* synthetic */ WebResourceResponse a(v vVar, String str) {
        InputStream a16;
        if ((!StringUtils.startsWith(str, "/WA") && !StringUtils.startsWith(str, "WA")) || vVar.i() == null || (a16 = vVar.i().a(str)) == null) {
            return null;
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse(com.tencent.luggage.wxa.bo.e.d(str), "UTF-8", a16);
        webResourceResponse.setStatusCodeAndReasonPhrase(200, "OK");
        return webResourceResponse;
    }

    public void a(v vVar) {
        this.f132078a = vVar;
    }

    public void a(ConsoleMessage consoleMessage) {
        if (this.f132078a == null) {
            return;
        }
        com.tencent.luggage.wxa.e5.i.a(consoleMessage, "Luggage.AppBrandWebViewClient" + String.format(Locale.ENGLISH, ":page[%s %s]", this.f132078a.getAppId(), this.f132078a.A0()), true);
    }

    public boolean a(SslCertificate sslCertificate) {
        if (this.f132078a.getRuntime() == null) {
            return false;
        }
        if (this.f132079b == null) {
            this.f132079b = com.tencent.luggage.wxa.yi.q.b((com.tencent.luggage.wxa.yi.a) this.f132078a.getRuntime().a(com.tencent.luggage.wxa.yi.a.class));
        }
        if (this.f132079b == null) {
            return false;
        }
        com.tencent.luggage.wxa.tn.w.a("Luggage.AppBrandWebViewClient", "subjectDN: " + sslCertificate.getIssuedTo().getDName());
        try {
            Field declaredField = sslCertificate.getClass().getDeclaredField("mX509Certificate");
            declaredField.setAccessible(true);
            try {
                this.f132079b.checkServerTrusted(new X509Certificate[]{(X509Certificate) declaredField.get(sslCertificate)}, "generic");
                return true;
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandWebViewClient", "Certificate check failed: " + e16);
                return false;
            }
        } catch (Exception e17) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandWebViewClient", "Certificate check failed: ", e17);
            return false;
        }
    }

    public WebResourceResponse a(String str) {
        WebResourceResponse webResourceResponse = null;
        if (str == null || !this.f132078a.isRunning()) {
            return null;
        }
        String str2 = this.f132080c;
        if (TextUtils.isEmpty(str2)) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandWebViewClient", "getAppResourceResponse with reqURL[%s], hostURL isEmpty", str);
            return null;
        }
        if (str.startsWith(str2)) {
            webResourceResponse = a(str, str2);
        } else {
            if (!URLUtil.isAboutUrl(str) && !URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str) && !URLUtil.isDataUrl(str)) {
                com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
                this.f132078a.getRuntime().P().readFile(str, iVar);
                if (iVar.f141499a != null) {
                    String extension = FilenameUtils.getExtension(str);
                    WebResourceResponse webResourceResponse2 = new WebResourceResponse(!TextUtils.isEmpty(extension) ? com.tencent.luggage.wxa.bo.e.c(extension) : "", "", new com.tencent.luggage.wxa.h6.a((ByteBuffer) iVar.f141499a));
                    webResourceResponse2.setStatusCodeAndReasonPhrase(200, "OK");
                    webResourceResponse = webResourceResponse2;
                }
            }
            return webResourceResponse;
        }
        com.tencent.luggage.wxa.tn.w.d("Luggage.AppBrandWebViewClient", "tryInterceptWebViewRequest, reqURL = %s", str);
        return webResourceResponse;
    }

    public void b(String str) {
    }

    public void c(String str) {
    }

    public final WebResourceResponse a(String str, String str2) {
        WebResourceResponse e16;
        String replaceFirst = str.replaceFirst(str2, "");
        WebResourceResponse a16 = this.f132081d.a(this.f132078a, replaceFirst);
        if (a16 != null) {
            return a16;
        }
        WebResourceResponse e17 = com.tencent.luggage.wxa.mc.k0.e(this.f132078a.getRuntime(), replaceFirst);
        if (e17 != null) {
            e17.setStatusCodeAndReasonPhrase(200, "OK");
            return e17;
        }
        if (replaceFirst.contains("%") && (e16 = com.tencent.luggage.wxa.mc.k0.e(this.f132078a.getRuntime(), Uri.decode(replaceFirst))) != null) {
            e16.setStatusCodeAndReasonPhrase(200, "OK");
            return e16;
        }
        com.tencent.luggage.wxa.tn.w.b("Luggage.AppBrandWebViewClient", "getAppResourceResponse %s not found", str);
        WebResourceResponse webResourceResponse = new WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
        webResourceResponse.setStatusCodeAndReasonPhrase(404, "NotFound");
        return webResourceResponse;
    }
}
