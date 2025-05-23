package com.tencent.halley.common.b.a;

import android.net.http.Headers;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.halley.common.a.h;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.report.UploadQualityReportBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
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
public final class g extends com.tencent.halley.common.b.a.a {
    static IPatchRedirector $redirector_;
    private boolean A;
    private String B;
    private int C;
    private long D;
    private String E;
    private a F;
    private e G;

    /* renamed from: o, reason: collision with root package name */
    long f113327o;

    /* renamed from: p, reason: collision with root package name */
    boolean f113328p;

    /* renamed from: q, reason: collision with root package name */
    boolean f113329q;

    /* renamed from: r, reason: collision with root package name */
    int f113330r;

    /* renamed from: s, reason: collision with root package name */
    boolean f113331s;

    /* renamed from: t, reason: collision with root package name */
    boolean f113332t;

    /* renamed from: u, reason: collision with root package name */
    private HttpURLConnection f113333u;

    /* renamed from: v, reason: collision with root package name */
    private DataOutputStream f113334v;

    /* renamed from: w, reason: collision with root package name */
    private DataInputStream f113335w;

    /* renamed from: x, reason: collision with root package name */
    private f f113336x;

    /* renamed from: y, reason: collision with root package name */
    private String f113337y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f113338z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f113339a;

        /* renamed from: b, reason: collision with root package name */
        long f113340b;

        /* renamed from: c, reason: collision with root package name */
        long f113341c;

        /* renamed from: d, reason: collision with root package name */
        long f113342d;

        /* renamed from: e, reason: collision with root package name */
        long f113343e;

        /* renamed from: f, reason: collision with root package name */
        long f113344f;

        /* renamed from: g, reason: collision with root package name */
        long f113345g;

        /* renamed from: h, reason: collision with root package name */
        long f113346h;

        /* renamed from: i, reason: collision with root package name */
        long f113347i;

        /* renamed from: j, reason: collision with root package name */
        long f113348j;

        /* renamed from: k, reason: collision with root package name */
        long f113349k;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f113345g = -1L;
            this.f113346h = -1L;
            this.f113347i = -1L;
            this.f113348j = -1L;
            this.f113349k = -1L;
        }

        private static long a(long j3) {
            if (j3 >= 0) {
                return j3;
            }
            return -1L;
        }

        public final String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "Stat{startToTryConnect=" + this.f113345g + ", connectCost=" + this.f113346h + ", connectToPost=" + this.f113347i + ", postToRsp=" + this.f113348j + ", rspToRead=" + this.f113349k + '}';
        }

        /* synthetic */ a(byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, this, Byte.valueOf(b16));
        }

        public final void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long j3 = this.f113340b;
            long j16 = j3 - this.f113339a;
            this.f113345g = j16;
            long j17 = this.f113341c;
            this.f113346h = j17 - j3;
            long j18 = this.f113342d;
            this.f113347i = j18 - j17;
            long j19 = this.f113343e;
            this.f113348j = j19 - j18;
            this.f113349k = this.f113344f - j19;
            this.f113345g = a(j16);
            this.f113346h = a(this.f113346h);
            this.f113347i = a(this.f113347i);
            this.f113348j = a(this.f113348j);
            this.f113349k = a(this.f113349k);
        }
    }

    public g(String str, String str2, boolean z16, Map<String, String> map, byte[] bArr, int i3, String str3) {
        int a16;
        int a17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        byte b16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Boolean.valueOf(z16), map, bArr, Integer.valueOf(i3), str3);
            return;
        }
        this.f113328p = false;
        this.f113329q = false;
        this.f113330r = 0;
        this.f113331s = true;
        this.f113332t = false;
        this.B = "";
        this.D = 0L;
        this.F = new a(b16);
        this.f113337y = str;
        this.f113286b = str2;
        this.f113287c = z16;
        this.f113288d = map;
        this.f113289e = bArr;
        if (com.tencent.halley.common.a.c.h() == 2) {
            a16 = h.a("direct_access_time_out", 1000, 60000, 15000);
        } else {
            a16 = h.a("direct_access_time_out", 1000, 60000, 10000);
        }
        this.f113290f = j.a(i3 < a16 ? i3 : a16, 200, 60000, 10000);
        if (this.f113286b.length() > 8) {
            if (this.f113286b.charAt(7) != '[' && this.f113286b.charAt(8) != '[') {
                z17 = false;
            }
            a17 = a(i3, z17);
        } else {
            a17 = a(i3, false);
        }
        this.f113291g = a17;
        this.f113292h = str3;
    }

    private static int a(int i3, boolean z16) {
        int a16 = (com.tencent.halley.common.a.c.i() == 2 && z16) ? h.a("direct_access_conn_time_out", 1000, 60000, 2000) : h.a("direct_access_conn_time_out", 1000, 60000, 10000);
        if (i3 >= a16) {
            i3 = a16;
        }
        return j.a(i3, 200, 60000, 10000);
    }

    private void c() {
        f();
        this.f113327o = SystemClock.elapsedRealtime() - this.f113327o;
        this.F.a();
        if (this.f113336x.f113322a != 0 && com.tencent.halley.common.a.c.j() && this.f113336x.f113322a != -20) {
            boolean z16 = false;
            if (h.a("direct_fail_to_report_dns_ip", 0, 1, 0) == 1) {
                z16 = true;
            }
            if (z16) {
                this.E = j.c(this.f113337y);
            }
        }
    }

    private void d() {
        Map<String, String> map = this.f113288d;
        boolean z16 = false;
        if (map != null && map.size() > 0) {
            for (String str : this.f113288d.keySet()) {
                this.f113333u.addRequestProperty(str, this.f113288d.get(str));
                if (str.toLowerCase().contains("host")) {
                    z16 = true;
                }
            }
        }
        if (!z16) {
            this.f113333u.setRequestProperty("Host", this.f113337y);
        }
        this.f113333u.setRequestProperty("Halley", this.f113292h + "-" + this.f113330r + "-" + System.currentTimeMillis());
        if (this.f113329q) {
            this.f113333u.setRequestProperty("Connection", "close");
        }
        if (this.f113328p) {
            this.f113333u.setRequestProperty("X-Online-Host", this.f113337y);
            this.f113333u.setRequestProperty("x-tx-host", this.f113337y);
        }
    }

    private boolean e() {
        if (this.f113297m) {
            this.f113336x.f113322a = -20;
            this.f113327o = SystemClock.elapsedRealtime() - this.f113327o;
            this.F.a();
            return true;
        }
        return false;
    }

    private void f() {
        try {
            HttpURLConnection httpURLConnection = this.f113333u;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            DataOutputStream dataOutputStream = this.f113334v;
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            DataInputStream dataInputStream = this.f113335w;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
        } catch (Throwable unused) {
        }
    }

    public final f b() {
        e eVar;
        f fVar;
        HttpURLConnection httpURLConnection;
        f fVar2;
        String sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f113327o = elapsedRealtime;
        this.F.f113339a = elapsedRealtime;
        String str = "";
        this.f113336x = new f("");
        try {
            try {
                try {
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    f fVar3 = this.f113336x;
                    fVar3.f113322a = -287;
                    fVar3.f113323b = th5.getClass().getSimpleName() + "(" + th5.getLocalizedMessage() + ")";
                    boolean z16 = (this.f113338z && this.f113336x.f113323b.toLowerCase().contains("cannot verify hostname")) || (this.f113338z && this.f113336x.f113323b.toLowerCase().contains("not verified"));
                    if (!com.tencent.halley.common.a.c.j()) {
                        this.f113336x.f113322a = -4;
                    } else if (this.f113297m) {
                        this.f113336x.f113322a = -20;
                    } else if (z16) {
                        this.f113336x.f113322a = -289;
                    } else {
                        if (th5 instanceof SSLHandshakeException) {
                            fVar = this.f113336x;
                        } else {
                            if (!(th5 instanceof SSLKeyException) && !(th5 instanceof SSLPeerUnverifiedException) && !(th5 instanceof SSLProtocolException)) {
                                this.f113294j = true;
                                if (th5.getMessage() != null && th5.getMessage().toLowerCase().contains(QCircleDaTongConstant.ElementParamValue.PERMISSION)) {
                                    f fVar4 = this.f113336x;
                                    fVar4.f113322a = -281;
                                    fVar4.f113323b = "no permission";
                                } else if (th5 instanceof UnknownHostException) {
                                    this.f113336x.f113322a = -284;
                                } else if (th5 instanceof ConnectException) {
                                    this.f113336x.f113322a = -42;
                                } else if (th5 instanceof SocketTimeoutException) {
                                    String localizedMessage = th5.getLocalizedMessage();
                                    if (localizedMessage == null || !(localizedMessage.toLowerCase().contains(UploadQualityReportBuilder.STATE_CONNECT) || localizedMessage.toLowerCase().contains(Headers.CONN_DIRECTIVE))) {
                                        this.f113336x.f113322a = -13;
                                    } else {
                                        this.f113336x.f113322a = -10;
                                    }
                                } else if (th5 instanceof SocketException) {
                                    this.f113336x.f113322a = -41;
                                }
                                if (th5 instanceof IOException) {
                                    f fVar5 = this.f113336x;
                                    fVar5.f113322a = -286;
                                    if (this.f113338z && (eVar = this.G) != null && eVar.f113320a) {
                                        if (fVar5.f113323b.contains("SSLHandshakeException")) {
                                            fVar = this.f113336x;
                                        } else if (this.f113336x.f113323b.contains("SocketTimeoutException")) {
                                            this.f113336x.f113322a = -10;
                                        } else if (th5 instanceof InterruptedIOException) {
                                            this.f113336x.f113322a = -292;
                                        } else {
                                            this.f113336x.f113322a = -293;
                                        }
                                    } else if (th5 instanceof InterruptedIOException) {
                                        fVar5.f113322a = -292;
                                    }
                                    this.f113294j = false;
                                }
                            }
                            this.f113336x.f113322a = -291;
                        }
                        fVar.f113322a = -290;
                    }
                }
            } catch (MalformedURLException unused) {
                this.f113336x.f113322a = -300;
            }
            if (e()) {
                f fVar6 = this.f113336x;
                c();
                return fVar6;
            }
            URL url = new URL(this.f113286b);
            this.f113338z = url.getProtocol().toLowerCase().startsWith("https");
            this.A = j.d(url.getHost());
            if (this.f113338z) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((!this.f113328p || com.tencent.halley.common.a.c.m() == null) ? url.openConnection() : url.openConnection(com.tencent.halley.common.a.c.m()));
                httpURLConnection = httpsURLConnection;
                if (this.A) {
                    e eVar2 = new e(this.f113337y);
                    this.G = eVar2;
                    httpsURLConnection.setSSLSocketFactory(eVar2);
                    httpsURLConnection.setHostnameVerifier(new d(this.f113337y));
                    httpURLConnection = httpsURLConnection;
                }
            } else {
                httpURLConnection = (HttpURLConnection) ((!this.f113328p || com.tencent.halley.common.a.c.m() == null) ? url.openConnection() : url.openConnection(com.tencent.halley.common.a.c.m()));
            }
            this.f113333u = httpURLConnection;
            httpURLConnection.setRequestMethod(this.f113287c ? "GET" : "POST");
            this.f113333u.setConnectTimeout(this.f113291g);
            this.f113333u.setReadTimeout(this.f113290f);
            this.f113333u.setUseCaches(false);
            this.f113333u.setDoInput(true);
            this.f113333u.setInstanceFollowRedirects(false);
            d();
            if (!this.f113287c && !j.a(this.f113289e)) {
                this.f113333u.setDoOutput(true);
                this.D = this.f113289e.length;
            }
            this.F.f113340b = SystemClock.elapsedRealtime();
            this.f113333u.connect();
            this.F.f113341c = SystemClock.elapsedRealtime();
            if (e()) {
                f fVar7 = this.f113336x;
                c();
                return fVar7;
            }
            if (!this.f113287c && !j.a(this.f113289e)) {
                DataOutputStream dataOutputStream = new DataOutputStream(this.f113333u.getOutputStream());
                this.f113334v = dataOutputStream;
                dataOutputStream.write(this.f113289e);
                this.f113334v.flush();
            }
            this.F.f113342d = SystemClock.elapsedRealtime();
            int responseCode = this.f113333u.getResponseCode();
            this.F.f113343e = SystemClock.elapsedRealtime();
            this.f113336x.f113324c = responseCode;
            this.B = this.f113333u.getContentType();
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, List<String>> entry : this.f113333u.getHeaderFields().entrySet()) {
                if (entry.getKey() != null) {
                    hashMap.put(entry.getKey(), entry.getValue().get(0));
                }
            }
            this.f113336x.a(hashMap);
            f fVar8 = this.f113336x;
            int i3 = fVar8.f113324c;
            if (i3 >= 200 && i3 < 300) {
                this.C = this.f113333u.getContentLength();
                int a16 = h.a("app_receive_pack_size", 524288, 10485760, 2097152);
                int i16 = this.C;
                if (i16 < 0) {
                    a(a16);
                } else if (i16 == 0) {
                    this.f113336x.f113325d = new byte[0];
                    this.F.f113344f = SystemClock.elapsedRealtime();
                } else {
                    if (i16 > a16) {
                        fVar2 = this.f113336x;
                        fVar2.f113322a = -303;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(this.C);
                        sb5 = sb6.toString();
                    } else {
                        try {
                            byte[] bArr = new byte[i16];
                            DataInputStream dataInputStream = new DataInputStream(this.f113333u.getInputStream());
                            this.f113335w = dataInputStream;
                            dataInputStream.readFully(bArr);
                            this.f113336x.f113325d = bArr;
                            this.F.f113344f = SystemClock.elapsedRealtime();
                        } catch (OutOfMemoryError unused2) {
                            fVar2 = this.f113336x;
                            fVar2.f113322a = -306;
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(this.C);
                            sb5 = sb7.toString();
                        }
                    }
                    fVar2.f113323b = sb5;
                }
            } else if (i3 >= 300 && i3 < 400) {
                if (fVar8.f113326e != null && !TextUtils.isEmpty("location")) {
                    String str2 = fVar8.f113326e.get("location".toLowerCase());
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2;
                    }
                }
                this.f113293i = str;
            }
            c();
            return this.f113336x;
        } catch (Throwable th6) {
            c();
            throw th6;
        }
    }

    private void a(int i3) {
        f fVar;
        String str;
        int i16 = 0;
        try {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f113333u.getInputStream());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                int i17 = 0;
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            i16 = 1;
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                        i17 += read;
                        if (i17 > i3) {
                            f fVar2 = this.f113336x;
                            fVar2.f113322a = -303;
                            fVar2.f113323b = "no-content-length";
                            break;
                        }
                    } catch (OutOfMemoryError unused) {
                        i16 = i17;
                        fVar = this.f113336x;
                        fVar.f113322a = -306;
                        str = "no-content-length:".concat(String.valueOf(i16));
                        fVar.f113323b = str;
                    }
                }
                if (i16 != 0) {
                    this.f113336x.f113325d = byteArrayOutputStream.toByteArray();
                    this.F.f113344f = SystemClock.elapsedRealtime();
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                fVar = this.f113336x;
                fVar.f113322a = -287;
                str = "read without content-length error";
                fVar.f113323b = str;
            }
        } catch (OutOfMemoryError unused4) {
        }
    }

    public final void a(Map<String, String> map, Map<String, String> map2) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) map, (Object) map2);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f113327o);
        hashMap.put("B59", sb5.toString());
        if (this.f113338z) {
            hashMap.put("B85", "1");
        }
        if (this.f113287c) {
            hashMap.put("B95", "1");
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(this.D);
            hashMap.put("B96", sb6.toString());
        }
        if (!this.A) {
            hashMap.put("B23", "1");
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append((int) com.tencent.halley.common.a.c.i());
        hashMap.put("B220", sb7.toString());
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(map2);
        StringBuilder sb8 = new StringBuilder();
        sb8.append(this.C);
        hashMap2.put("B88", sb8.toString());
        StringBuilder sb9 = new StringBuilder();
        sb9.append(this.F.f113345g);
        hashMap2.put("B90", sb9.toString());
        StringBuilder sb10 = new StringBuilder();
        sb10.append(this.F.f113346h);
        hashMap2.put("B91", sb10.toString());
        StringBuilder sb11 = new StringBuilder();
        sb11.append(this.F.f113347i);
        hashMap2.put("B92", sb11.toString());
        StringBuilder sb12 = new StringBuilder();
        sb12.append(this.F.f113348j);
        hashMap2.put("B93", sb12.toString());
        StringBuilder sb13 = new StringBuilder();
        sb13.append(this.F.f113349k);
        hashMap2.put("B94", sb13.toString());
        if (!TextUtils.isEmpty(this.f113293i)) {
            hashMap2.put("B47", this.f113293i);
        }
        if (!TextUtils.isEmpty(this.E)) {
            hashMap2.put("B41", this.E);
        }
        f fVar = this.f113336x;
        int i16 = fVar.f113322a;
        if (i16 != 0) {
            i3 = i16;
        } else {
            int i17 = fVar.f113324c;
            if (i17 == 200) {
                i17 = 0;
            }
            i3 = i17;
        }
        if (!this.f113332t || i3 == -4) {
            com.tencent.halley.common.f.a.b("HLHttpDirect", com.tencent.halley.common.a.c(), i3, this.f113336x.f113323b, hashMap, hashMap2, this.f113294j);
        } else {
            com.tencent.halley.common.f.a.a("HLHttpDirect", com.tencent.halley.common.a.c(), i3, this.f113336x.f113323b, hashMap, hashMap2, this.f113294j);
        }
    }

    @Override // com.tencent.halley.common.a.f
    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        this.f113297m = true;
        return true;
    }
}
