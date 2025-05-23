package com.tencent.halley.common.d.b.a.a;

import android.net.SSLCertificateSocketFactory;
import android.net.http.Headers;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.report.UploadQualityReportBuilder;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.light.LightConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class g extends com.tencent.halley.common.d.b.a.a.a {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    int f113458j;

    /* renamed from: k, reason: collision with root package name */
    long f113459k;

    /* renamed from: l, reason: collision with root package name */
    long f113460l;

    /* renamed from: m, reason: collision with root package name */
    long f113461m;

    /* renamed from: n, reason: collision with root package name */
    long f113462n;

    /* renamed from: o, reason: collision with root package name */
    private int f113463o;

    /* renamed from: p, reason: collision with root package name */
    private byte[] f113464p;

    /* renamed from: q, reason: collision with root package name */
    private byte f113465q;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f113467a;

        /* renamed from: b, reason: collision with root package name */
        public String f113468b;

        /* renamed from: c, reason: collision with root package name */
        public long f113469c;

        /* renamed from: d, reason: collision with root package name */
        public long f113470d;

        /* renamed from: e, reason: collision with root package name */
        public long f113471e;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
                return;
            }
            this.f113467a = -1;
            this.f113469c = -1L;
            this.f113470d = -1L;
            this.f113471e = -1L;
        }

        /* synthetic */ a(g gVar, byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, gVar, Byte.valueOf(b16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(String str, byte b16, List<String> list) {
        super(str, b16, list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Byte.valueOf(b16), list);
            return;
        }
        this.f113460l = -1L;
        this.f113461m = -1L;
        this.f113462n = -1L;
    }

    private static void a(HttpURLConnection httpURLConnection, OutputStream outputStream) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.halley.common.d.b.a.a.a
    protected final void c() {
        int i3;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Map<String, byte[]> map = this.f113422c;
        if (map != null && map.containsKey("connect_timeout") && (bArr = this.f113422c.get("connect_timeout")) != null && bArr.length == 1) {
            i3 = bArr[0] * 1000;
        } else {
            i3 = 31000;
        }
        this.f113458j = i3;
        this.f113463o = f();
        this.f113464p = d();
        this.f113465q = e();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(35:9|10|11|(2:12|13)|14|(1:16)|17|(5:18|19|(2:175|176)(1:21)|22|(2:23|24))|(3:158|(2:160|(26:164|27|28|29|30|(4:139|140|141|142)(1:32)|33|34|36|37|38|39|(2:45|(13:47|48|49|50|(1:52)(1:73)|53|(1:55)|56|(2:58|(3:60|(1:62)(1:70)|63)(1:71))(1:72)|64|(1:66)(1:69)|67|68))|129|48|49|50|(0)(0)|53|(0)|56|(0)(0)|64|(0)(0)|67|68))(1:(1:168))|165)|26|27|28|29|30|(0)(0)|33|34|36|37|38|39|(4:41|43|45|(0))|129|48|49|50|(0)(0)|53|(0)|56|(0)(0)|64|(0)(0)|67|68) */
    /* JADX WARN: Can't wrap try/catch for region: R(41:8|9|10|11|12|13|14|(1:16)|17|18|19|(2:175|176)(1:21)|22|(2:23|24)|(3:158|(2:160|(26:164|27|28|29|30|(4:139|140|141|142)(1:32)|33|34|36|37|38|39|(2:45|(13:47|48|49|50|(1:52)(1:73)|53|(1:55)|56|(2:58|(3:60|(1:62)(1:70)|63)(1:71))(1:72)|64|(1:66)(1:69)|67|68))|129|48|49|50|(0)(0)|53|(0)|56|(0)(0)|64|(0)(0)|67|68))(1:(1:168))|165)|26|27|28|29|30|(0)(0)|33|34|36|37|38|39|(4:41|43|45|(0))|129|48|49|50|(0)(0)|53|(0)|56|(0)(0)|64|(0)(0)|67|68) */
    /* JADX WARN: Can't wrap try/catch for region: R(42:8|9|10|11|12|13|14|(1:16)|17|18|19|(2:175|176)(1:21)|22|23|24|(3:158|(2:160|(26:164|27|28|29|30|(4:139|140|141|142)(1:32)|33|34|36|37|38|39|(2:45|(13:47|48|49|50|(1:52)(1:73)|53|(1:55)|56|(2:58|(3:60|(1:62)(1:70)|63)(1:71))(1:72)|64|(1:66)(1:69)|67|68))|129|48|49|50|(0)(0)|53|(0)|56|(0)(0)|64|(0)(0)|67|68))(1:(1:168))|165)|26|27|28|29|30|(0)(0)|33|34|36|37|38|39|(4:41|43|45|(0))|129|48|49|50|(0)(0)|53|(0)|56|(0)(0)|64|(0)(0)|67|68) */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x01f5, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01f6, code lost:
    
        r14 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01fd, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01fe, code lost:
    
        r14 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0203, code lost:
    
        r15 = r10;
        r6 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0200, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0201, code lost:
    
        r14 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0207, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0208, code lost:
    
        r14 = -1;
        r15 = r10;
        r6 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x021a, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x020e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x020f, code lost:
    
        r14 = -1;
        r15 = r10;
        r6 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01f3, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01f7, code lost:
    
        r16 = r15;
        r6 = -1;
        r15 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0234 A[Catch: all -> 0x040a, TryCatch #4 {all -> 0x040a, blocks: (B:78:0x0225, B:80:0x0234, B:82:0x023a, B:84:0x0240, B:85:0x0246, B:87:0x0277, B:89:0x027d, B:91:0x028a, B:93:0x0297, B:97:0x02a9, B:98:0x02ae, B:100:0x02b2, B:102:0x02b6, B:103:0x02ba, B:105:0x02be, B:106:0x02c2, B:108:0x02c6, B:109:0x02ca, B:111:0x02ce, B:112:0x02d2, B:114:0x02d8, B:116:0x02e5, B:119:0x02ef, B:121:0x02f8, B:123:0x0301, B:124:0x0306), top: B:77:0x0225 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x023a A[Catch: all -> 0x040a, TryCatch #4 {all -> 0x040a, blocks: (B:78:0x0225, B:80:0x0234, B:82:0x023a, B:84:0x0240, B:85:0x0246, B:87:0x0277, B:89:0x027d, B:91:0x028a, B:93:0x0297, B:97:0x02a9, B:98:0x02ae, B:100:0x02b2, B:102:0x02b6, B:103:0x02ba, B:105:0x02be, B:106:0x02c2, B:108:0x02c6, B:109:0x02ca, B:111:0x02ce, B:112:0x02d2, B:114:0x02d8, B:116:0x02e5, B:119:0x02ef, B:121:0x02f8, B:123:0x0301, B:124:0x0306), top: B:77:0x0225 }] */
    @Override // com.tencent.halley.common.d.b.a.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final boolean a(String str) {
        String str2;
        long j3;
        int i3;
        long j16;
        boolean z16;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        String str3;
        g gVar;
        String sb5;
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3;
        byte b16;
        String headerField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            HashMap hashMap = new HashMap();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            com.tencent.halley.common.utils.d.c("halley-cloud-AbsDetectTask", "start detect urlTask:".concat(String.valueOf(str)));
            byte b17 = 0;
            try {
                URL url = new URL(str);
                String host = url.getHost();
                try {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    InetAddress byName = InetAddress.getByName(host);
                    j3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                    str2 = byName.getHostAddress();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    str2 = "";
                    j3 = -1;
                }
                hashMap.put("D11", String.valueOf(j3));
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put("D12", str2);
                }
                a aVar = new a(this, b17);
                try {
                    if (url.getProtocol().toLowerCase().startsWith("https")) {
                        try {
                            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                            httpsURLConnection.setSSLSocketFactory(new SSLSocketFactory() { // from class: com.tencent.halley.common.d.b.a.a.g.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) g.this);
                                    }
                                }

                                @Override // javax.net.SocketFactory
                                public final Socket createSocket(String str4, int i16) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 4)) {
                                        return null;
                                    }
                                    return (Socket) iPatchRedirector2.redirect((short) 4, (Object) this, (Object) str4, i16);
                                }

                                @Override // javax.net.ssl.SSLSocketFactory
                                public final String[] getDefaultCipherSuites() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        return (String[]) iPatchRedirector2.redirect((short) 2, (Object) this);
                                    }
                                    return new String[0];
                                }

                                @Override // javax.net.ssl.SSLSocketFactory
                                public final String[] getSupportedCipherSuites() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                                        return (String[]) iPatchRedirector2.redirect((short) 3, (Object) this);
                                    }
                                    return new String[0];
                                }

                                @Override // javax.net.SocketFactory
                                public final Socket createSocket(String str4, int i16, InetAddress inetAddress, int i17) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 5)) {
                                        return null;
                                    }
                                    return (Socket) iPatchRedirector2.redirect((short) 5, this, str4, Integer.valueOf(i16), inetAddress, Integer.valueOf(i17));
                                }

                                @Override // javax.net.SocketFactory
                                public final Socket createSocket(InetAddress inetAddress, int i16) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 6)) {
                                        return null;
                                    }
                                    return (Socket) iPatchRedirector2.redirect((short) 6, (Object) this, (Object) inetAddress, i16);
                                }

                                @Override // javax.net.SocketFactory
                                public final Socket createSocket(InetAddress inetAddress, int i16, InetAddress inetAddress2, int i17) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 7)) {
                                        return null;
                                    }
                                    return (Socket) iPatchRedirector2.redirect((short) 7, this, inetAddress, Integer.valueOf(i16), inetAddress2, Integer.valueOf(i17));
                                }

                                @Override // javax.net.ssl.SSLSocketFactory
                                public final Socket createSocket(Socket socket, String str4, int i16, boolean z17) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 8)) {
                                        return (Socket) iPatchRedirector2.redirect((short) 8, this, socket, str4, Integer.valueOf(i16), Boolean.valueOf(z17));
                                    }
                                    g.this.f113460l = SystemClock.elapsedRealtime();
                                    g gVar2 = g.this;
                                    int i17 = gVar2.f113458j - ((int) (gVar2.f113460l - gVar2.f113459k));
                                    if (i17 <= 0) {
                                        i17 = 0;
                                    }
                                    StringBuilder sb6 = new StringBuilder("handshakeTimeout:");
                                    sb6.append(i17);
                                    sb6.append(" and connectTime:");
                                    g gVar3 = g.this;
                                    sb6.append(gVar3.f113460l - gVar3.f113459k);
                                    com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", sb6.toString());
                                    SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(i17, null);
                                    SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, str4, i16, z17);
                                    sSLSocket.setEnabledProtocols(sSLSocket.getEnabledProtocols());
                                    sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket, false);
                                    sSLCertificateSocketFactory.setHostname(sSLSocket, str4);
                                    g.this.f113461m = SystemClock.elapsedRealtime();
                                    sSLSocket.startHandshake();
                                    g.this.f113462n = SystemClock.elapsedRealtime();
                                    return sSLSocket;
                                }
                            });
                            httpURLConnection2 = httpsURLConnection;
                        } catch (Throwable th6) {
                            th = th6;
                            z16 = false;
                            j16 = -1;
                            outputStream = null;
                            i3 = -1;
                            httpURLConnection = null;
                            String str4 = null;
                            try {
                                aVar.f113471e = j16;
                                aVar.f113469c = j16;
                                aVar.f113470d = j16;
                                th.printStackTrace();
                                if (!com.tencent.halley.common.a.c.j()) {
                                }
                                a(httpURLConnection, outputStream);
                                str3 = str4;
                                if (z16) {
                                }
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(aVar.f113471e);
                                hashMap.put("D17", sb6.toString());
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                                hashMap.put("D18", sb7.toString());
                                hashMap.put("D19", String.valueOf(i3));
                                if (!TextUtils.isEmpty(str3)) {
                                }
                                String str5 = "D13";
                                if (str.startsWith("https")) {
                                }
                                hashMap.put(str5, sb5);
                                hashMap.put("D7", j.b(str));
                                boolean z17 = gVar.f113420a;
                                a(!z17 ? "HLUrlDetectEvent" : "HLNotRealUrlDetectEvent", aVar.f113467a, aVar.f113468b, hashMap, z17);
                                return true;
                            } catch (Throwable th7) {
                                a(httpURLConnection, outputStream);
                                throw th7;
                            }
                        }
                    } else {
                        this.f113460l = -1L;
                        httpURLConnection2 = (HttpURLConnection) url.openConnection();
                    }
                    httpURLConnection3 = httpURLConnection2;
                    try {
                        httpURLConnection3.setDoInput(false);
                        httpURLConnection3.setDoOutput(false);
                        httpURLConnection3.setUseCaches(false);
                        httpURLConnection3.setInstanceFollowRedirects(false);
                        httpURLConnection3.setConnectTimeout(this.f113458j);
                        httpURLConnection3.setReadTimeout(this.f113463o);
                        httpURLConnection3.setRequestProperty("Accept-Encoding", "identity");
                        httpURLConnection3.setRequestProperty("Connection", "close");
                        b16 = this.f113465q;
                    } catch (Throwable th8) {
                        th = th8;
                        i3 = -1;
                        httpURLConnection = httpURLConnection3;
                        j16 = -1;
                        z16 = false;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    i3 = -1;
                    j16 = -1;
                    z16 = false;
                    outputStream = null;
                }
                if (b16 != 0) {
                    try {
                    } catch (Throwable th10) {
                        th = th10;
                        httpURLConnection = httpURLConnection3;
                        j16 = -1;
                        z16 = false;
                        outputStream = null;
                        i3 = -1;
                        String str42 = null;
                        aVar.f113471e = j16;
                        aVar.f113469c = j16;
                        aVar.f113470d = j16;
                        th.printStackTrace();
                        if (!com.tencent.halley.common.a.c.j()) {
                        }
                        a(httpURLConnection, outputStream);
                        str3 = str42;
                        if (z16) {
                        }
                        StringBuilder sb62 = new StringBuilder();
                        sb62.append(aVar.f113471e);
                        hashMap.put("D17", sb62.toString());
                        StringBuilder sb72 = new StringBuilder();
                        sb72.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                        hashMap.put("D18", sb72.toString());
                        hashMap.put("D19", String.valueOf(i3));
                        if (!TextUtils.isEmpty(str3)) {
                        }
                        String str52 = "D13";
                        if (str.startsWith("https")) {
                        }
                        hashMap.put(str52, sb5);
                        hashMap.put("D7", j.b(str));
                        boolean z172 = gVar.f113420a;
                        a(!z172 ? "HLUrlDetectEvent" : "HLNotRealUrlDetectEvent", aVar.f113467a, aVar.f113468b, hashMap, z172);
                        return true;
                    }
                    if (b16 == 1) {
                        httpURLConnection3.setRequestMethod("POST");
                        httpURLConnection3.setDoOutput(true);
                        byte[] bArr = this.f113464p;
                        if (bArr != null && bArr.length != 0) {
                            z16 = true;
                            this.f113424e += 128;
                            this.f113459k = SystemClock.elapsedRealtime();
                            httpURLConnection3.connect();
                            aVar.f113469c = SystemClock.elapsedRealtime() - this.f113459k;
                            com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", "connect time:" + aVar.f113469c + " SSLHandshakeTime:" + (this.f113462n - this.f113461m) + " tcp handshake:" + (this.f113460l - this.f113459k));
                            if (z16) {
                                outputStream = null;
                            } else {
                                try {
                                    this.f113424e += this.f113464p.length;
                                    aVar.f113470d = SystemClock.elapsedRealtime();
                                    outputStream = httpURLConnection3.getOutputStream();
                                } catch (Throwable th11) {
                                    th = th11;
                                    httpURLConnection = httpURLConnection3;
                                    j16 = -1;
                                    outputStream = null;
                                    i3 = -1;
                                    String str422 = null;
                                    aVar.f113471e = j16;
                                    aVar.f113469c = j16;
                                    aVar.f113470d = j16;
                                    th.printStackTrace();
                                    if (!com.tencent.halley.common.a.c.j()) {
                                    }
                                    a(httpURLConnection, outputStream);
                                    str3 = str422;
                                    if (z16) {
                                    }
                                    StringBuilder sb622 = new StringBuilder();
                                    sb622.append(aVar.f113471e);
                                    hashMap.put("D17", sb622.toString());
                                    StringBuilder sb722 = new StringBuilder();
                                    sb722.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                                    hashMap.put("D18", sb722.toString());
                                    hashMap.put("D19", String.valueOf(i3));
                                    if (!TextUtils.isEmpty(str3)) {
                                    }
                                    String str522 = "D13";
                                    if (str.startsWith("https")) {
                                    }
                                    hashMap.put(str522, sb5);
                                    hashMap.put("D7", j.b(str));
                                    boolean z1722 = gVar.f113420a;
                                    a(!z1722 ? "HLUrlDetectEvent" : "HLNotRealUrlDetectEvent", aVar.f113467a, aVar.f113468b, hashMap, z1722);
                                    return true;
                                }
                                try {
                                    outputStream.write(this.f113464p);
                                    outputStream.flush();
                                    aVar.f113470d = SystemClock.elapsedRealtime() - aVar.f113470d;
                                } catch (Throwable th12) {
                                    th = th12;
                                    httpURLConnection = httpURLConnection3;
                                    j16 = -1;
                                    i3 = -1;
                                    String str4222 = null;
                                    aVar.f113471e = j16;
                                    aVar.f113469c = j16;
                                    aVar.f113470d = j16;
                                    th.printStackTrace();
                                    if (!com.tencent.halley.common.a.c.j()) {
                                        aVar.f113467a = -505;
                                    } else if (g()) {
                                        aVar.f113467a = LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT;
                                    } else {
                                        aVar.f113467a = -515;
                                        aVar.f113468b = th.getClass().getSimpleName() + "(" + th.getLocalizedMessage() + ")";
                                        if (th instanceof SocketTimeoutException) {
                                            String localizedMessage = th.getLocalizedMessage();
                                            if (localizedMessage != null && (localizedMessage.toLowerCase().contains(UploadQualityReportBuilder.STATE_CONNECT) || localizedMessage.toLowerCase().contains(Headers.CONN_DIRECTIVE) || localizedMessage.toLowerCase().contains("ssl handshake"))) {
                                                aVar.f113467a = -509;
                                            } else {
                                                aVar.f113467a = -510;
                                            }
                                        }
                                        if (th instanceof UnknownHostException) {
                                            aVar.f113467a = -512;
                                        }
                                        if (th instanceof ConnectException) {
                                            aVar.f113467a = -511;
                                        }
                                        if (th instanceof SocketException) {
                                            aVar.f113467a = -513;
                                        }
                                        if (th instanceof IOException) {
                                            aVar.f113467a = -514;
                                        }
                                        if (th.getMessage() != null) {
                                            String message = th.getMessage();
                                            if (!message.contains("Permission denied") && !message.contains("ECONNREFUSED")) {
                                                if (message.contains("EHOSTUNREACH") || message.contains("No route to host")) {
                                                    aVar.f113467a = -506;
                                                }
                                            }
                                            aVar.f113467a = -507;
                                        }
                                    }
                                    a(httpURLConnection, outputStream);
                                    str3 = str4222;
                                    if (z16) {
                                    }
                                    StringBuilder sb6222 = new StringBuilder();
                                    sb6222.append(aVar.f113471e);
                                    hashMap.put("D17", sb6222.toString());
                                    StringBuilder sb7222 = new StringBuilder();
                                    sb7222.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                                    hashMap.put("D18", sb7222.toString());
                                    hashMap.put("D19", String.valueOf(i3));
                                    if (!TextUtils.isEmpty(str3)) {
                                    }
                                    String str5222 = "D13";
                                    if (str.startsWith("https")) {
                                    }
                                    hashMap.put(str5222, sb5);
                                    hashMap.put("D7", j.b(str));
                                    boolean z17222 = gVar.f113420a;
                                    a(!z17222 ? "HLUrlDetectEvent" : "HLNotRealUrlDetectEvent", aVar.f113467a, aVar.f113468b, hashMap, z17222);
                                    return true;
                                }
                            }
                            aVar.f113471e = SystemClock.elapsedRealtime();
                            aVar.f113467a = httpURLConnection3.getResponseCode();
                            aVar.f113471e = SystemClock.elapsedRealtime() - aVar.f113471e;
                            int contentLength = httpURLConnection3.getContentLength();
                            str3 = httpURLConnection3.getHeaderField("Content-Type");
                            if (aVar.f113467a == 200 && contentLength == -1 && (headerField = httpURLConnection3.getHeaderField("Transfer-Encoding")) != null) {
                                if (headerField.equals("chunked")) {
                                    i3 = -2;
                                    com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", "Http:errorCode:" + aVar.f113467a + " connCostTime:" + aVar.f113469c + " readTime:" + aVar.f113471e + " writeTime:" + aVar.f113470d + " contentLen:" + i3);
                                    a(httpURLConnection3, outputStream);
                                    if (z16) {
                                        gVar = this;
                                    } else {
                                        StringBuilder sb8 = new StringBuilder();
                                        sb8.append(aVar.f113470d);
                                        hashMap.put("D16", sb8.toString());
                                        StringBuilder sb9 = new StringBuilder();
                                        gVar = this;
                                        sb9.append(gVar.f113464p.length);
                                        hashMap.put("D20", sb9.toString());
                                    }
                                    StringBuilder sb62222 = new StringBuilder();
                                    sb62222.append(aVar.f113471e);
                                    hashMap.put("D17", sb62222.toString());
                                    StringBuilder sb72222 = new StringBuilder();
                                    sb72222.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                                    hashMap.put("D18", sb72222.toString());
                                    hashMap.put("D19", String.valueOf(i3));
                                    if (!TextUtils.isEmpty(str3)) {
                                        hashMap.put("D35", j.b(str3));
                                    }
                                    String str52222 = "D13";
                                    if (str.startsWith("https")) {
                                        StringBuilder sb10 = new StringBuilder();
                                        sb10.append(aVar.f113469c);
                                        sb5 = sb10.toString();
                                    } else if (gVar.f113460l != -1) {
                                        StringBuilder sb11 = new StringBuilder();
                                        sb11.append(gVar.f113460l - gVar.f113459k);
                                        hashMap.put("D13", sb11.toString());
                                        long j17 = gVar.f113462n - gVar.f113461m;
                                        StringBuilder sb12 = new StringBuilder();
                                        sb12.append(j17 >= 0 ? j17 : -1L);
                                        sb5 = sb12.toString();
                                        str52222 = "D14";
                                    } else {
                                        StringBuilder sb13 = new StringBuilder();
                                        sb13.append(aVar.f113469c);
                                        sb5 = sb13.toString();
                                        str52222 = "D15";
                                    }
                                    hashMap.put(str52222, sb5);
                                    hashMap.put("D7", j.b(str));
                                    boolean z172222 = gVar.f113420a;
                                    a(!z172222 ? "HLUrlDetectEvent" : "HLNotRealUrlDetectEvent", aVar.f113467a, aVar.f113468b, hashMap, z172222);
                                    return true;
                                }
                            }
                            i3 = contentLength;
                            com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", "Http:errorCode:" + aVar.f113467a + " connCostTime:" + aVar.f113469c + " readTime:" + aVar.f113471e + " writeTime:" + aVar.f113470d + " contentLen:" + i3);
                            a(httpURLConnection3, outputStream);
                            if (z16) {
                            }
                            StringBuilder sb622222 = new StringBuilder();
                            sb622222.append(aVar.f113471e);
                            hashMap.put("D17", sb622222.toString());
                            StringBuilder sb722222 = new StringBuilder();
                            sb722222.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                            hashMap.put("D18", sb722222.toString());
                            hashMap.put("D19", String.valueOf(i3));
                            if (!TextUtils.isEmpty(str3)) {
                            }
                            String str522222 = "D13";
                            if (str.startsWith("https")) {
                            }
                            hashMap.put(str522222, sb5);
                            hashMap.put("D7", j.b(str));
                            boolean z1722222 = gVar.f113420a;
                            a(!z1722222 ? "HLUrlDetectEvent" : "HLNotRealUrlDetectEvent", aVar.f113467a, aVar.f113468b, hashMap, z1722222);
                            return true;
                        }
                    } else if (b16 == 2) {
                        httpURLConnection3.setRequestMethod("HEAD");
                    }
                }
                z16 = false;
                this.f113424e += 128;
                this.f113459k = SystemClock.elapsedRealtime();
                httpURLConnection3.connect();
                aVar.f113469c = SystemClock.elapsedRealtime() - this.f113459k;
                com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", "connect time:" + aVar.f113469c + " SSLHandshakeTime:" + (this.f113462n - this.f113461m) + " tcp handshake:" + (this.f113460l - this.f113459k));
                if (z16) {
                }
                aVar.f113471e = SystemClock.elapsedRealtime();
                aVar.f113467a = httpURLConnection3.getResponseCode();
                aVar.f113471e = SystemClock.elapsedRealtime() - aVar.f113471e;
                int contentLength2 = httpURLConnection3.getContentLength();
                str3 = httpURLConnection3.getHeaderField("Content-Type");
                if (aVar.f113467a == 200) {
                    if (headerField.equals("chunked")) {
                    }
                }
                i3 = contentLength2;
                com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", "Http:errorCode:" + aVar.f113467a + " connCostTime:" + aVar.f113469c + " readTime:" + aVar.f113471e + " writeTime:" + aVar.f113470d + " contentLen:" + i3);
                a(httpURLConnection3, outputStream);
                if (z16) {
                }
                StringBuilder sb6222222 = new StringBuilder();
                sb6222222.append(aVar.f113471e);
                hashMap.put("D17", sb6222222.toString());
                StringBuilder sb7222222 = new StringBuilder();
                sb7222222.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                hashMap.put("D18", sb7222222.toString());
                hashMap.put("D19", String.valueOf(i3));
                if (!TextUtils.isEmpty(str3)) {
                }
                String str5222222 = "D13";
                if (str.startsWith("https")) {
                }
                hashMap.put(str5222222, sb5);
                hashMap.put("D7", j.b(str));
                boolean z17222222 = gVar.f113420a;
                a(!z17222222 ? "HLUrlDetectEvent" : "HLNotRealUrlDetectEvent", aVar.f113467a, aVar.f113468b, hashMap, z17222222);
                return true;
            } catch (MalformedURLException unused) {
                com.tencent.halley.common.utils.d.e("halley-cloud-AbsDetectTask", "MalformedURLException is called");
                return false;
            }
        }
        return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
    }
}
