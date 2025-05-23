package com.tencent.gamecenter.wadl.sdk.common.c.b;

import android.net.http.Headers;
import android.os.SystemClock;
import com.tencent.upload.report.UploadQualityReportBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g extends a {

    /* renamed from: j, reason: collision with root package name */
    private HttpURLConnection f107102j;

    /* renamed from: k, reason: collision with root package name */
    private DataOutputStream f107103k;

    /* renamed from: l, reason: collision with root package name */
    private DataInputStream f107104l;

    /* renamed from: m, reason: collision with root package name */
    private f f107105m;

    /* renamed from: n, reason: collision with root package name */
    private String f107106n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f107107o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f107108p;

    /* renamed from: q, reason: collision with root package name */
    private int f107109q;

    /* renamed from: s, reason: collision with root package name */
    long f107111s;

    /* renamed from: v, reason: collision with root package name */
    int f107114v;

    /* renamed from: w, reason: collision with root package name */
    boolean f107115w;

    /* renamed from: x, reason: collision with root package name */
    private h f107116x;

    /* renamed from: r, reason: collision with root package name */
    private c f107110r = new c();

    /* renamed from: t, reason: collision with root package name */
    boolean f107112t = false;

    /* renamed from: u, reason: collision with root package name */
    boolean f107113u = false;

    public g(String str, String str2, boolean z16, Map<String, String> map, byte[] bArr, int i3, String str3) {
        boolean z17 = false;
        this.f107106n = str;
        this.f107060a = str2;
        this.f107061b = z16;
        this.f107062c = map;
        this.f107063d = bArr;
        this.f107064e = a(i3);
        if (this.f107060a.length() > 8 && (this.f107060a.charAt(7) == '[' || this.f107060a.charAt(8) == '[')) {
            z17 = true;
        }
        this.f107065f = a(i3, z17);
        this.f107066g = str3;
    }

    private int a(int i3) {
        int a16 = com.tencent.gamecenter.wadl.sdk.common.b.c.d() == 2 ? com.tencent.gamecenter.wadl.sdk.common.b.g.a("direct_access_time_out", 1000, 60000, 15000) : com.tencent.gamecenter.wadl.sdk.common.b.g.a("direct_access_time_out", 1000, 60000, 10000);
        if (i3 >= a16) {
            i3 = a16;
        }
        return com.tencent.gamecenter.wadl.sdk.common.e.g.a(i3, 200, 60000, 10000);
    }

    private void b() {
        try {
            HttpURLConnection httpURLConnection = this.f107102j;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            DataOutputStream dataOutputStream = this.f107103k;
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            DataInputStream dataInputStream = this.f107104l;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
        } catch (Throwable unused) {
        }
    }

    private Map<String, String> d() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<String>> entry : this.f107102j.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), entry.getValue().get(0));
            }
        }
        return hashMap;
    }

    private boolean e() {
        if (!this.f107061b && !com.tencent.gamecenter.wadl.sdk.common.e.g.a(this.f107063d)) {
            return true;
        }
        return false;
    }

    private boolean f() {
        if (this.f107067h) {
            this.f107105m.f107097a = -20;
            this.f107111s = SystemClock.elapsedRealtime() - this.f107111s;
            this.f107110r.a();
            return true;
        }
        return false;
    }

    private void g() {
        this.f107105m.a("location");
    }

    private void h() {
        f fVar;
        StringBuilder sb5;
        this.f107109q = this.f107102j.getContentLength();
        int a16 = com.tencent.gamecenter.wadl.sdk.common.b.g.a("app_receive_pack_size", 524288, 10485760, 2097152);
        int i3 = this.f107109q;
        if (i3 < 0) {
            d(a16);
            return;
        }
        if (i3 == 0) {
            this.f107105m.f107100d = new byte[0];
            this.f107110r.f107080f = SystemClock.elapsedRealtime();
            return;
        }
        if (i3 > a16) {
            fVar = this.f107105m;
            fVar.f107097a = -303;
            sb5 = new StringBuilder();
        } else {
            try {
                byte[] bArr = new byte[i3];
                DataInputStream dataInputStream = new DataInputStream(this.f107102j.getInputStream());
                this.f107104l = dataInputStream;
                dataInputStream.readFully(bArr);
                this.f107105m.f107100d = bArr;
                this.f107110r.f107080f = SystemClock.elapsedRealtime();
                return;
            } catch (OutOfMemoryError unused) {
                fVar = this.f107105m;
                fVar.f107097a = -306;
                sb5 = new StringBuilder();
            }
        }
        sb5.append("");
        sb5.append(this.f107109q);
        fVar.f107098b = sb5.toString();
    }

    private void i() {
        Map<String, String> map = this.f107062c;
        boolean z16 = false;
        if (map != null && map.size() > 0) {
            for (String str : this.f107062c.keySet()) {
                this.f107102j.addRequestProperty(str, this.f107062c.get(str));
                if (str.toLowerCase().contains("host")) {
                    z16 = true;
                }
            }
        }
        if (!z16) {
            this.f107102j.setRequestProperty("Host", this.f107106n);
        }
        if (this.f107113u) {
            this.f107102j.setRequestProperty("Connection", "close");
        }
        if (this.f107112t) {
            this.f107102j.setRequestProperty("X-Online-Host", this.f107106n);
            this.f107102j.setRequestProperty("x-tx-host", this.f107106n);
        }
    }

    public f c() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f107111s = elapsedRealtime;
        this.f107110r.f107075a = elapsedRealtime;
        this.f107105m = new f(0, "", 0);
        try {
            try {
            } catch (MalformedURLException unused) {
                this.f107105m.f107097a = -300;
                b();
                this.f107111s = SystemClock.elapsedRealtime() - this.f107111s;
                this.f107110r.a();
                return this.f107105m;
            } catch (Throwable th5) {
                th5.printStackTrace();
                f fVar = this.f107105m;
                fVar.f107097a = -287;
                fVar.f107098b = th5.getClass().getSimpleName() + "(" + th5.getLocalizedMessage() + ")";
                if (this.f107067h) {
                    this.f107105m.f107097a = -20;
                } else if (b(th5) && !c(th5)) {
                    a(th5);
                }
                b();
                this.f107111s = SystemClock.elapsedRealtime() - this.f107111s;
                this.f107110r.a();
                return this.f107105m;
            }
            if (!f()) {
                URL url = new URL(this.f107060a);
                this.f107107o = b(url);
                this.f107108p = c(url);
                HttpURLConnection a16 = a(url);
                this.f107102j = a16;
                a16.setRequestMethod(this.f107061b ? "GET" : "POST");
                this.f107102j.setConnectTimeout(this.f107065f);
                this.f107102j.setReadTimeout(this.f107064e);
                this.f107102j.setUseCaches(false);
                this.f107102j.setDoInput(true);
                this.f107102j.setInstanceFollowRedirects(false);
                i();
                if (e()) {
                    this.f107102j.setDoOutput(true);
                }
                this.f107110r.f107076b = SystemClock.elapsedRealtime();
                this.f107102j.connect();
                this.f107110r.f107077c = SystemClock.elapsedRealtime();
                if (!f()) {
                    if (e()) {
                        DataOutputStream dataOutputStream = new DataOutputStream(this.f107102j.getOutputStream());
                        this.f107103k = dataOutputStream;
                        dataOutputStream.write(this.f107063d);
                        this.f107103k.flush();
                    }
                    this.f107110r.f107078d = SystemClock.elapsedRealtime();
                    int responseCode = this.f107102j.getResponseCode();
                    this.f107110r.f107079e = SystemClock.elapsedRealtime();
                    f fVar2 = this.f107105m;
                    fVar2.f107099c = responseCode;
                    fVar2.a(d());
                    if (c(this.f107105m.f107099c)) {
                        h();
                    } else if (b(this.f107105m.f107099c)) {
                        g();
                    }
                    b();
                    this.f107111s = SystemClock.elapsedRealtime() - this.f107111s;
                    this.f107110r.a();
                    return this.f107105m;
                }
            }
            return this.f107105m;
        } finally {
            b();
            this.f107111s = SystemClock.elapsedRealtime() - this.f107111s;
            this.f107110r.a();
        }
    }

    private int a(int i3, boolean z16) {
        int a16 = (com.tencent.gamecenter.wadl.sdk.common.b.c.c() == 2 && z16) ? com.tencent.gamecenter.wadl.sdk.common.b.g.a("direct_access_conn_time_out", 1000, 60000, 2000) : com.tencent.gamecenter.wadl.sdk.common.b.g.a("direct_access_conn_time_out", 1000, 60000, 10000);
        if (i3 >= a16) {
            i3 = a16;
        }
        return com.tencent.gamecenter.wadl.sdk.common.e.g.a(i3, 200, 60000, 10000);
    }

    private boolean b(int i3) {
        return i3 >= 300 && this.f107105m.f107099c < 400;
    }

    private boolean c(int i3) {
        return i3 >= 200 && this.f107105m.f107099c < 300;
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:96)
        */
    private void d(int r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59 java.lang.OutOfMemoryError -> L6d
            java.net.HttpURLConnection r3 = r7.f107102j     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59 java.lang.OutOfMemoryError -> L6d
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59 java.lang.OutOfMemoryError -> L6d
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59 java.lang.OutOfMemoryError -> L6d
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50 java.lang.OutOfMemoryError -> L53
            r3.<init>()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L50 java.lang.OutOfMemoryError -> L53
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L51 java.lang.OutOfMemoryError -> L54
            r4 = r0
        L17:
            int r5 = r2.read(r1)     // Catch: java.lang.OutOfMemoryError -> L4a java.lang.Throwable -> L4c java.lang.Exception -> L51
            r6 = -1
            if (r5 == r6) goto L30
            r3.write(r1, r0, r5)     // Catch: java.lang.OutOfMemoryError -> L4a java.lang.Throwable -> L4c java.lang.Exception -> L51
            int r4 = r4 + r5
            if (r4 <= r8) goto L17
            com.tencent.gamecenter.wadl.sdk.common.c.b.f r8 = r7.f107105m     // Catch: java.lang.OutOfMemoryError -> L4a java.lang.Throwable -> L4c java.lang.Exception -> L51
            r1 = -303(0xfffffffffffffed1, float:NaN)
            r8.f107097a = r1     // Catch: java.lang.OutOfMemoryError -> L4a java.lang.Throwable -> L4c java.lang.Exception -> L51
            java.lang.String r1 = "no-content-length"
            r8.f107098b = r1     // Catch: java.lang.OutOfMemoryError -> L4a java.lang.Throwable -> L4c java.lang.Exception -> L51
            goto L31
        L30:
            r0 = 1
        L31:
            if (r0 == 0) goto L43
            com.tencent.gamecenter.wadl.sdk.common.c.b.f r8 = r7.f107105m     // Catch: java.lang.OutOfMemoryError -> L4a java.lang.Throwable -> L4c java.lang.Exception -> L51
            byte[] r0 = r3.toByteArray()     // Catch: java.lang.OutOfMemoryError -> L4a java.lang.Throwable -> L4c java.lang.Exception -> L51
            r8.f107100d = r0     // Catch: java.lang.OutOfMemoryError -> L4a java.lang.Throwable -> L4c java.lang.Exception -> L51
            com.tencent.gamecenter.wadl.sdk.common.c.b.c r8 = r7.f107110r     // Catch: java.lang.OutOfMemoryError -> L4a java.lang.Throwable -> L4c java.lang.Exception -> L51
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.OutOfMemoryError -> L4a java.lang.Throwable -> L4c java.lang.Exception -> L51
            r8.f107080f = r0     // Catch: java.lang.OutOfMemoryError -> L4a java.lang.Throwable -> L4c java.lang.Exception -> L51
        L43:
            r3.close()     // Catch: java.lang.OutOfMemoryError -> L4a java.lang.Throwable -> L4c java.lang.Exception -> L51
            r2.close()     // Catch: java.lang.Exception -> L8f
            goto L8f
        L4a:
            r0 = r4
            goto L54
        L4c:
            r8 = move-exception
            goto L95
        L4e:
            r8 = move-exception
            goto L96
        L50:
            r3 = r1
        L51:
            r1 = r2
            goto L5a
        L53:
            r3 = r1
        L54:
            r1 = r2
            goto L6e
        L56:
            r8 = move-exception
            r0 = r1
            goto L98
        L59:
            r3 = r1
        L5a:
            com.tencent.gamecenter.wadl.sdk.common.c.b.f r8 = r7.f107105m     // Catch: java.lang.Throwable -> L93
            r0 = -287(0xfffffffffffffee1, float:NaN)
            r8.f107097a = r0     // Catch: java.lang.Throwable -> L93
            java.lang.String r0 = "read without content-length error"
            r8.f107098b = r0     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L6a
            r1.close()     // Catch: java.lang.Exception -> L6a
        L6a:
            if (r3 == 0) goto L92
            goto L8f
        L6d:
            r3 = r1
        L6e:
            com.tencent.gamecenter.wadl.sdk.common.c.b.f r8 = r7.f107105m     // Catch: java.lang.Throwable -> L93
            r2 = -306(0xfffffffffffffece, float:NaN)
            r8.f107097a = r2     // Catch: java.lang.Throwable -> L93
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r2.<init>()     // Catch: java.lang.Throwable -> L93
            java.lang.String r4 = "no-content-length:"
            r2.append(r4)     // Catch: java.lang.Throwable -> L93
            r2.append(r0)     // Catch: java.lang.Throwable -> L93
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L93
            r8.f107098b = r0     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L8d
            r1.close()     // Catch: java.lang.Exception -> L8d
        L8d:
            if (r3 == 0) goto L92
        L8f:
            r3.close()     // Catch: java.lang.Exception -> L92
        L92:
            return
        L93:
            r8 = move-exception
            r2 = r1
        L95:
            r1 = r3
        L96:
            r0 = r1
            r1 = r2
        L98:
            if (r1 == 0) goto L9d
            r1.close()     // Catch: java.lang.Exception -> L9d
        L9d:
            if (r0 == 0) goto La2
            r0.close()     // Catch: java.lang.Exception -> La2
        La2:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.gamecenter.wadl.sdk.common.c.b.g.d(int):void");
    }

    private HttpURLConnection a(URL url) {
        if (!this.f107107o) {
            return (HttpURLConnection) ((!this.f107112t || com.tencent.gamecenter.wadl.sdk.common.b.c.e() == null) ? url.openConnection() : url.openConnection(com.tencent.gamecenter.wadl.sdk.common.b.c.e()));
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((!this.f107112t || com.tencent.gamecenter.wadl.sdk.common.b.c.e() == null) ? url.openConnection() : url.openConnection(com.tencent.gamecenter.wadl.sdk.common.b.c.e()));
        if (this.f107108p) {
            h hVar = new h(this.f107106n);
            this.f107116x = hVar;
            httpsURLConnection.setSSLSocketFactory(hVar);
            httpsURLConnection.setHostnameVerifier(new e(this.f107106n));
        }
        return httpsURLConnection;
    }

    private boolean b(Throwable th5) {
        f fVar;
        int i3;
        boolean z16 = (this.f107107o && this.f107105m.f107098b.toLowerCase().contains("cannot verify hostname")) || (this.f107107o && this.f107105m.f107098b.toLowerCase().contains("not verified"));
        if (!com.tencent.gamecenter.wadl.sdk.common.b.c.j()) {
            fVar = this.f107105m;
            i3 = -4;
        } else if (z16) {
            fVar = this.f107105m;
            i3 = -289;
        } else if (th5 instanceof SSLHandshakeException) {
            fVar = this.f107105m;
            i3 = -290;
        } else {
            if (!(th5 instanceof SSLKeyException) && !(th5 instanceof SSLPeerUnverifiedException) && !(th5 instanceof SSLProtocolException)) {
                return false;
            }
            fVar = this.f107105m;
            i3 = -291;
        }
        fVar.f107097a = i3;
        return true;
    }

    private boolean c(Throwable th5) {
        f fVar;
        int i3;
        if (th5.getMessage() != null && th5.getMessage().toLowerCase().contains(QCircleDaTongConstant.ElementParamValue.PERMISSION)) {
            f fVar2 = this.f107105m;
            fVar2.f107097a = -281;
            fVar2.f107098b = "no permission";
            return true;
        }
        if (th5 instanceof UnknownHostException) {
            this.f107105m.f107097a = -284;
            return true;
        }
        if (th5 instanceof ConnectException) {
            this.f107105m.f107097a = -42;
            return true;
        }
        if (!(th5 instanceof SocketTimeoutException)) {
            if (!(th5 instanceof SocketException)) {
                return false;
            }
            this.f107105m.f107097a = -41;
            return true;
        }
        String localizedMessage = th5.getLocalizedMessage();
        if (localizedMessage == null || !(localizedMessage.toLowerCase().contains(UploadQualityReportBuilder.STATE_CONNECT) || localizedMessage.toLowerCase().contains(Headers.CONN_DIRECTIVE))) {
            fVar = this.f107105m;
            i3 = -13;
        } else {
            fVar = this.f107105m;
            i3 = -10;
        }
        fVar.f107097a = i3;
        return true;
    }

    private void a(Throwable th5) {
        h hVar;
        f fVar;
        int i3;
        if (th5 instanceof IOException) {
            f fVar2 = this.f107105m;
            fVar2.f107097a = -286;
            if (!this.f107107o || (hVar = this.f107116x) == null || !hVar.f107118b) {
                if (th5 instanceof InterruptedIOException) {
                    fVar2.f107097a = -292;
                    return;
                }
                return;
            }
            if (fVar2.f107098b.contains("SSLHandshakeException")) {
                fVar = this.f107105m;
                i3 = -290;
            } else if (this.f107105m.f107098b.contains("SocketTimeoutException")) {
                fVar = this.f107105m;
                i3 = -10;
            } else if (th5 instanceof InterruptedIOException) {
                this.f107105m.f107097a = -292;
                return;
            } else {
                fVar = this.f107105m;
                i3 = -293;
            }
            fVar.f107097a = i3;
        }
    }

    private boolean b(URL url) {
        return url.getProtocol().toLowerCase().startsWith("https");
    }

    private boolean c(URL url) {
        return com.tencent.gamecenter.wadl.sdk.common.e.g.f(url.getHost());
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.b.e
    public boolean a() {
        this.f107067h = true;
        return true;
    }
}
