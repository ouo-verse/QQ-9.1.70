package com.tencent.gdtad.splash;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.pi.ICustomAdDataGenerator;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.splash.statistics.GdtSplashReporterForPreloader;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.turingfd.sdk.xq.ITuringDID;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f\u00a2\u0006\u0004\b.\u0010/J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\n\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u001a\u0010\u000e\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u001c\u0010\u0011\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J,\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u001c\u0010#\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010(\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010%\u001a\u0004\b)\u0010'\"\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0018\u0010%\u00a8\u00060"}, d2 = {"Lcom/tencent/gdtad/splash/t;", "Lcom/qq/e/comm/pi/ICustomAdDataGenerator;", "", "baseUrl", "", "map", "Lcom/qq/e/comm/pi/ICustomAdDataGenerator$LoadADCallback;", "callback", "", "f", "g", "input", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "responseString", "i", "Lcom/tencent/gdtad/splash/p;", "error", tl.h.F, "adRequest", "j", "uin", "postTime", "reqString", "l", "d", "Ljava/io/Closeable;", "closeable", "c", "parasMap", "", "loadAD", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/gdtad/splash/statistics/GdtSplashReporterForPreloader;", "a", "Ljava/lang/ref/WeakReference;", "mWeakReporter", "b", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "getSHA256", "setSHA256", "(Ljava/lang/String;)V", "SHA256", "HTTPS_REFERER", "<init>", "(Ljava/lang/ref/WeakReference;)V", "gdt-ad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class t implements ICustomAdDataGenerator {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final WeakReference<GdtSplashReporterForPreloader> mWeakReporter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "GdtSplashRealTimeLoader";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String SHA256 = KeyPropertiesCompact.DIGEST_SHA256;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String HTTPS_REFERER = "https://qq.com";

    public t(@Nullable WeakReference<GdtSplashReporterForPreloader> weakReference) {
        this.mWeakReporter = weakReference;
    }

    private final void c(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th5) {
            QLog.e(this.TAG, 1, th5, new Object[0]);
        }
    }

    private final String d() {
        String clientMode = GdtDeviceInfoHelper.getClientMode();
        Intrinsics.checkNotNullExpressionValue(clientMode, "getClientMode()");
        return clientMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(t this$0, String baseUrl, Map map, ICustomAdDataGenerator.LoadADCallback callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(baseUrl, "$baseUrl");
        Intrinsics.checkNotNullParameter(map, "$map");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.f(baseUrl, map, callback);
    }

    private final void f(String baseUrl, Map<String, String> map, ICustomAdDataGenerator.LoadADCallback callback) {
        GdtSplashReporterForPreloader gdtSplashReporterForPreloader;
        WeakReference<GdtSplashReporterForPreloader> weakReference = this.mWeakReporter;
        String str = null;
        if (weakReference != null) {
            gdtSplashReporterForPreloader = weakReference.get();
        } else {
            gdtSplashReporterForPreloader = null;
        }
        String g16 = g(map);
        if (g16 != null) {
            str = m(g16);
        }
        if (TextUtils.isEmpty(str)) {
            p pVar = new p(2000010);
            if (gdtSplashReporterForPreloader != null) {
                gdtSplashReporterForPreloader.m(pVar);
            } else {
                QLog.e(this.TAG, 1, "[GdtCustomAdDataGeneratorSSO][loadADImpl] error, reporter is null");
            }
            h(callback, pVar);
            return;
        }
        QLog.i(this.TAG, 1, "[GdtCustomAdDataGeneratorSSO][loadADImpl]");
        j(str, callback);
        if (gdtSplashReporterForPreloader != null) {
            gdtSplashReporterForPreloader.o(System.currentTimeMillis());
        } else {
            QLog.e(this.TAG, 1, "[GdtCustomAdDataGeneratorSSO][loadADImpl] error, reporter is null");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:38:0x0019, B:9:0x0029, B:11:0x0031, B:14:0x003a, B:17:0x0043, B:18:0x0050, B:20:0x0056, B:27:0x0068, B:23:0x0071, B:30:0x0088, B:32:0x008e, B:33:0x0092), top: B:37:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:38:0x0019, B:9:0x0029, B:11:0x0031, B:14:0x003a, B:17:0x0043, B:18:0x0050, B:20:0x0056, B:27:0x0068, B:23:0x0071, B:30:0x0088, B:32:0x008e, B:33:0x0092), top: B:37:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029 A[Catch: all -> 0x0022, TryCatch #0 {all -> 0x0022, blocks: (B:38:0x0019, B:9:0x0029, B:11:0x0031, B:14:0x003a, B:17:0x0043, B:18:0x0050, B:20:0x0056, B:27:0x0068, B:23:0x0071, B:30:0x0088, B:32:0x008e, B:33:0x0092), top: B:37:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String g(Map<String, String> map) {
        boolean z16;
        Set<Map.Entry<String, String>> set;
        try {
            new JSONObject(map).toString();
        } catch (Throwable th5) {
            QLog.e(this.TAG, 1, "[mapToUriQueryEncodedString]", th5);
        }
        boolean z17 = false;
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    z16 = false;
                    String str = null;
                    if (z16) {
                        set = map.entrySet();
                    } else {
                        set = null;
                    }
                    if (set != null || set.isEmpty()) {
                        z17 = true;
                    }
                    if (!z17) {
                        QLog.e(this.TAG, 1, "[mapToUriQueryEncodedString] error, entrySet is empty");
                        return "";
                    }
                    Uri.Builder builder = new Uri.Builder();
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (TextUtils.isEmpty(entry.getKey())) {
                            QLog.e(this.TAG, 1, "entry.getKey() is null");
                        } else {
                            builder = builder.appendQueryParameter(entry.getKey(), entry.getValue());
                            Intrinsics.checkNotNullExpressionValue(builder, "uriBuilder.appendQueryPa\u2026r(entry.key, entry.value)");
                        }
                    }
                    Uri build = builder.build();
                    if (build != null) {
                        str = build.getEncodedQuery();
                    }
                    return String.valueOf(str);
                }
            } catch (Throwable th6) {
                QLog.e(this.TAG, 1, "[mapToUriQueryEncodedString]", th6);
                return "";
            }
        }
        z16 = true;
        String str2 = null;
        if (z16) {
        }
        if (set != null) {
        }
        z17 = true;
        if (!z17) {
        }
    }

    private final void h(ICustomAdDataGenerator.LoadADCallback callback, p error) {
        int i3;
        if (callback == null) {
            QLog.e(this.TAG, 1, "[notifyFailed] error, callback is null");
            return;
        }
        if (error != null) {
            i3 = error.a();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        QLog.i(this.TAG, 1, "[notifyFailed] callback.onADLoadErr, errorCode:" + i3);
        callback.onADLoadErr(i3);
    }

    private final void i(ICustomAdDataGenerator.LoadADCallback callback, String responseString) {
        if (callback == null) {
            QLog.e(this.TAG, 1, "[notifySuccess] error, callback is null");
            return;
        }
        QLog.i(this.TAG, 1, "[notifySuccess] callback.onADLoadSucc " + responseString);
        callback.onADLoadSucc(responseString);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:1|(3:2|3|4)|(2:5|6)|(3:7|8|(2:9|10))|(3:11|12|13)|(26:73|74|75|76|(1:78)|79|80|82|83|84|16|17|18|19|20|21|22|23|24|25|26|27|(3:29|(1:31)|(2:33|34))|36|37|38)|15|16|17|18|19|20|21|22|23|24|25|26|27|(0)|36|37|38|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0234, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0238, code lost:
    
        r8 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0236, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0237, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x023a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x023b, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x023d, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0263  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j(String adRequest, ICustomAdDataGenerator.LoadADCallback callback) {
        int i3;
        OutputStream outputStream;
        OutputStreamWriter outputStreamWriter;
        boolean z16;
        p pVar;
        HttpsURLConnection httpsURLConnection;
        String valueOf;
        String uin;
        String str;
        Object[] objArr;
        String responseMessage;
        String byteArrayOutputStream;
        String str2 = "";
        boolean z17 = true;
        boolean z18 = false;
        try {
            final URL url = new URL("https://win.qq.com/business/cgi/olympic/realtime");
            HostnameVerifier hostnameVerifier = new HostnameVerifier() { // from class: com.tencent.gdtad.splash.s
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str3, SSLSession sSLSession) {
                    boolean k3;
                    k3 = t.k(url, this, str3, sSLSession);
                    return k3;
                }
            };
            URLConnection openConnection = url.openConnection();
            Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            httpsURLConnection = (HttpsURLConnection) openConnection;
            httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setReadTimeout(30000);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setRequestProperty("Connection", "Keep-Alive");
            StringBuilder sb5 = new StringBuilder("android");
            sb5.append("_");
            sb5.append(Build.VERSION.SDK);
            sb5.append("_");
            sb5.append(Build.DEVICE);
            sb5.append("_");
            sb5.append(Build.VERSION.RELEASE);
            sb5.append("_");
            String str3 = AppSetting.f99551k;
            sb5.append(str3);
            sb5.append("_");
            sb5.append("QQ/");
            sb5.append(str3 + AppSetting.f99542b);
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder(Constants.\u2026ting.buildNum).toString()");
            httpsURLConnection.setRequestProperty("User-Agent", sb6);
            httpsURLConnection.setRequestProperty("Referer", this.HTTPS_REFERER);
            httpsURLConnection.setRequestProperty("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
            valueOf = String.valueOf(System.currentTimeMillis());
            uin = ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).getSpUin();
            str = this.TAG;
            objArr = new Object[6];
            objArr[0] = "reqSplashAdByHttp response.httpcode:";
            objArr[1] = -1;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            objArr[2] = ", result:";
            objArr[3] = "";
            objArr[4] = ", errMsg:";
            objArr[5] = "";
            QLog.d(str, 1, objArr);
            httpsURLConnection.setRequestProperty("timemills", valueOf);
            httpsURLConnection.setRequestProperty("Cookie", "uin=" + uin + ";");
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            httpsURLConnection.setRequestProperty("business-key", l(uin, valueOf, adRequest));
            outputStream = httpsURLConnection.getOutputStream();
        } catch (Throwable th6) {
            th = th6;
            z18 = false;
            i3 = -1;
            outputStream = null;
            outputStreamWriter = null;
            z16 = z18;
            try {
                QLog.d(this.TAG, 1, "reqSplashAdByHttp.e:", th);
                c(outputStreamWriter);
                c(outputStream);
                if (z16) {
                }
                pVar = new p(i3);
                h(callback, pVar);
            } catch (Throwable th7) {
                c(outputStreamWriter);
                c(outputStream);
                if (z16) {
                    if (str2.length() <= 0) {
                        z17 = z18;
                    }
                    if (z17) {
                        i(callback, str2);
                        throw th7;
                    }
                }
                h(callback, new p(i3));
                throw th7;
            }
        }
        try {
            outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ad_req", adRequest);
                jSONObject.put("client_mod", d());
                outputStreamWriter.write(jSONObject.toString());
                outputStreamWriter.flush();
                httpsURLConnection.connect();
                i3 = httpsURLConnection.getResponseCode();
            } catch (Throwable th8) {
                th = th8;
                z18 = false;
                i3 = -1;
            }
        } catch (Throwable th9) {
            th = th9;
            z18 = false;
            i3 = -1;
            outputStreamWriter = null;
            z16 = z18;
            QLog.d(this.TAG, 1, "reqSplashAdByHttp.e:", th);
            c(outputStreamWriter);
            c(outputStream);
            if (z16) {
            }
            pVar = new p(i3);
            h(callback, pVar);
        }
        try {
            responseMessage = httpsURLConnection.getResponseMessage();
            Intrinsics.checkNotNullExpressionValue(responseMessage, "conn.responseMessage");
        } catch (Throwable th10) {
            th = th10;
            z18 = false;
            z16 = z18;
            QLog.d(this.TAG, 1, "reqSplashAdByHttp.e:", th);
            c(outputStreamWriter);
            c(outputStream);
            if (z16) {
                if (str2.length() <= 0) {
                    z17 = z18;
                }
                if (z17) {
                    i(callback, str2);
                    return;
                }
            }
            pVar = new p(i3);
            h(callback, pVar);
        }
        if (i3 == 200) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(httpsURLConnection.getInputStream());
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    try {
                        for (int read = bufferedInputStream.read(); read != -1; read = bufferedInputStream.read()) {
                            byteArrayOutputStream2.write((byte) read);
                        }
                        byteArrayOutputStream = byteArrayOutputStream2.toString();
                        Intrinsics.checkNotNullExpressionValue(byteArrayOutputStream, "buf.toString()");
                        try {
                            z16 = true;
                        } catch (Throwable th11) {
                            th = th11;
                            z16 = true;
                            z18 = false;
                            QLog.d(this.TAG, 1, "reqSplashAdByHttp.e:", th);
                            c(outputStreamWriter);
                            c(outputStream);
                            if (z16) {
                            }
                            pVar = new p(i3);
                            h(callback, pVar);
                        }
                    } finally {
                        c(bufferedInputStream);
                        c(byteArrayOutputStream2);
                    }
                } catch (IOException e16) {
                    QLog.d(this.TAG, 1, "reqSplashAdByHttp exception:", e16);
                    responseMessage = "handle connect result exception:" + e16.getMessage();
                    c(bufferedInputStream);
                    c(byteArrayOutputStream2);
                }
                String str4 = this.TAG;
                Object[] objArr2 = new Object[6];
                objArr2[0] = "reqSplashAdByHttp response.httpcode:";
                objArr2[1] = Integer.valueOf(i3);
                objArr2[2] = ", result:";
                objArr2[3] = byteArrayOutputStream;
                objArr2[4] = ", errMsg:";
                objArr2[5] = responseMessage;
                QLog.d(str4, 1, objArr2);
                String optString = new JSONObject(new JSONObject(byteArrayOutputStream).optString("data")).optString("ad_rsp");
                Intrinsics.checkNotNullExpressionValue(optString, "JSONObject(JSONObject(re\u2026ta\")).optString(\"ad_rsp\")");
                String str5 = this.TAG;
                Object[] objArr3 = new Object[2];
                z18 = false;
                objArr3[0] = "reqSplashAdByHttp adString:";
                objArr3[1] = optString;
                QLog.d(str5, 1, objArr3);
                c(outputStreamWriter);
                c(outputStream);
                if (z16) {
                    if (optString.length() <= 0) {
                        z17 = false;
                    }
                    if (z17) {
                        i(callback, optString);
                        return;
                    }
                }
                pVar = new p(i3);
            } catch (Throwable th12) {
                th = th12;
                z18 = false;
                z16 = false;
                QLog.d(this.TAG, 1, "reqSplashAdByHttp.e:", th);
                c(outputStreamWriter);
                c(outputStream);
                if (z16) {
                }
                pVar = new p(i3);
                h(callback, pVar);
            }
            h(callback, pVar);
        }
        byteArrayOutputStream = "";
        z16 = false;
        String str42 = this.TAG;
        Object[] objArr22 = new Object[6];
        objArr22[0] = "reqSplashAdByHttp response.httpcode:";
        objArr22[1] = Integer.valueOf(i3);
        objArr22[2] = ", result:";
        objArr22[3] = byteArrayOutputStream;
        objArr22[4] = ", errMsg:";
        objArr22[5] = responseMessage;
        QLog.d(str42, 1, objArr22);
        String optString2 = new JSONObject(new JSONObject(byteArrayOutputStream).optString("data")).optString("ad_rsp");
        Intrinsics.checkNotNullExpressionValue(optString2, "JSONObject(JSONObject(re\u2026ta\")).optString(\"ad_rsp\")");
        String str52 = this.TAG;
        Object[] objArr32 = new Object[2];
        z18 = false;
        objArr32[0] = "reqSplashAdByHttp adString:";
        objArr32[1] = optString2;
        QLog.d(str52, 1, objArr32);
        c(outputStreamWriter);
        c(outputStream);
        if (z16) {
        }
        pVar = new p(i3);
        h(callback, pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(URL url, t this$0, String str, SSLSession sSLSession) {
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify(url.getHost(), sSLSession);
        if (!verify) {
            QLog.d(this$0.TAG, 1, "reqSplashAdByHttp.HostnameVerifier.host:", url.getHost(), ",address:", sSLSession.getPeerHost(), ",is-verify:", Boolean.valueOf(verify));
        }
        return verify;
    }

    private final String l(String uin, String postTime, String reqString) {
        String str = "#?ad_req=" + reqString + "&client_mod=" + d() + "&timemills=" + postTime + "&uin=" + uin + "#";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(this.SHA256);
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            byte[] bytes = str.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return HexUtil.bytes2HexStr(messageDigest.digest(bytes));
        } catch (Exception e16) {
            QLog.e(this.TAG, 1, e16, new Object[0]);
            return "";
        }
    }

    private final String m(String input) {
        String aidTicket;
        if (TextUtils.isEmpty(input)) {
            QLog.e(this.TAG, 1, "[updateDeviceInfo] error, input is empty");
            return null;
        }
        ITuringDID c16 = com.tencent.mobileqq.turingfd.c.a().c(false);
        String taidTicket = "";
        if (c16 == null || TextUtils.isEmpty(c16.getAIDTicket())) {
            aidTicket = "";
        } else {
            aidTicket = c16.getAIDTicket();
        }
        if (c16 != null && !TextUtils.isEmpty(c16.getTAIDTicket())) {
            taidTicket = c16.getTAIDTicket();
        }
        Regex regex = new Regex("_QQ_OAID_");
        Intrinsics.checkNotNullExpressionValue(aidTicket, "aidTicket");
        String replace = regex.replace(input, aidTicket);
        Regex regex2 = new Regex("_QQ_TAID_");
        Intrinsics.checkNotNullExpressionValue(taidTicket, "taidTicket");
        String replace2 = regex2.replace(replace, taidTicket);
        if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 2, "[updateDeviceInfo] aidTicket:" + aidTicket + " taidTicket:" + taidTicket);
        }
        return replace2;
    }

    @Override // com.qq.e.comm.pi.ICustomAdDataGenerator
    public boolean loadAD(@NotNull final String baseUrl, @NotNull Map<String, String> parasMap, @NotNull final ICustomAdDataGenerator.LoadADCallback callback) {
        GdtSplashReporterForPreloader gdtSplashReporterForPreloader;
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(parasMap, "parasMap");
        Intrinsics.checkNotNullParameter(callback, "callback");
        WeakReference<GdtSplashReporterForPreloader> weakReference = this.mWeakReporter;
        if (weakReference != null) {
            gdtSplashReporterForPreloader = weakReference.get();
        } else {
            gdtSplashReporterForPreloader = null;
        }
        if (gdtSplashReporterForPreloader != null) {
            gdtSplashReporterForPreloader.k();
        } else {
            QLog.e(this.TAG, 1, "[GdtCustomAdDataGeneratorSSO][loadAD] , reporter is null");
        }
        final HashMap hashMap = new HashMap();
        hashMap.putAll(parasMap);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.r
            @Override // java.lang.Runnable
            public final void run() {
                t.e(t.this, baseUrl, hashMap, callback);
            }
        }, 128, null, true);
        return true;
    }
}
