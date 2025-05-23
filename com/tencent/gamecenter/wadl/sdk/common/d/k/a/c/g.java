package com.tencent.gamecenter.wadl.sdk.common.d.k.a.c;

import android.net.SSLCertificateSocketFactory;
import android.os.SystemClock;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: P */
/* loaded from: classes6.dex */
class g extends com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.a {

    /* renamed from: j, reason: collision with root package name */
    private int f107168j;

    /* renamed from: k, reason: collision with root package name */
    private int f107169k;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f107170l;

    /* renamed from: m, reason: collision with root package name */
    private byte f107171m;

    /* renamed from: n, reason: collision with root package name */
    private long f107172n;

    /* renamed from: o, reason: collision with root package name */
    private long f107173o;

    /* renamed from: p, reason: collision with root package name */
    private long f107174p;

    /* renamed from: q, reason: collision with root package name */
    private long f107175q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a extends SSLSocketFactory {
        a() {
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i3) {
            return null;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getDefaultCipherSuites() {
            return new String[0];
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getSupportedCipherSuites() {
            return new String[0];
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i3, InetAddress inetAddress, int i16) {
            return null;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i3) {
            return null;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i3, InetAddress inetAddress2, int i16) {
            return null;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public Socket createSocket(Socket socket, String str, int i3, boolean z16) {
            g.this.f107173o = SystemClock.elapsedRealtime();
            int i16 = g.this.f107168j - ((int) (g.this.f107173o - g.this.f107172n));
            if (i16 <= 0) {
                i16 = 0;
            }
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-AbsDetectTask", "handshakeTimeout:" + i16 + " and connectTime:" + (g.this.f107173o - g.this.f107172n));
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(i16, null);
            SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, str, i3, z16);
            sSLSocket.setEnabledProtocols(sSLSocket.getEnabledProtocols());
            sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket, false);
            sSLCertificateSocketFactory.setHostname(sSLSocket, str);
            g.this.f107174p = SystemClock.elapsedRealtime();
            sSLSocket.startHandshake();
            g.this.f107175q = SystemClock.elapsedRealtime();
            return sSLSocket;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(String str, byte b16, List<String> list) {
        super(str, b16, list);
        this.f107173o = -1L;
        this.f107174p = -1L;
        this.f107175q = -1L;
    }

    private HttpURLConnection k(URL url) {
        if (url.getProtocol().toLowerCase().startsWith("https")) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setSSLSocketFactory(new a());
            return httpsURLConnection;
        }
        this.f107173o = -1L;
        return (HttpURLConnection) url.openConnection();
    }

    private void l(HttpURLConnection httpURLConnection, OutputStream outputStream) {
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

    private int q() {
        byte[] bArr;
        Map<String, byte[]> map = this.f107147d;
        if (map != null && map.containsKey("connect_timeout") && (bArr = this.f107147d.get("connect_timeout")) != null && bArr.length == 1) {
            return bArr[0] * 1000;
        }
        return 31000;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.a
    protected boolean a(String str) {
        Throwable th5;
        OutputStream outputStream;
        long j3;
        String headerField;
        SystemClock.elapsedRealtime();
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-cloud-AbsDetectTask", "start detect urlTask:" + str);
        boolean z16 = false;
        try {
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = null;
            r14 = null;
            OutputStream outputStream2 = null;
            try {
                HttpURLConnection k3 = k(url);
                try {
                    k3.setDoInput(false);
                    k3.setDoOutput(false);
                    k3.setUseCaches(false);
                    k3.setInstanceFollowRedirects(false);
                    k3.setConnectTimeout(this.f107168j);
                    k3.setReadTimeout(this.f107169k);
                    k3.setRequestProperty("Accept-Encoding", "identity");
                    k3.setRequestProperty("Connection", "close");
                    byte b16 = this.f107171m;
                    if (b16 == 1) {
                        k3.setRequestMethod("POST");
                        k3.setDoOutput(true);
                        byte[] bArr = this.f107170l;
                        if (bArr != null && bArr.length != 0) {
                            z16 = true;
                        }
                    } else if (b16 == 2) {
                        k3.setRequestMethod("HEAD");
                    }
                    this.f107152i += 128;
                    this.f107172n = SystemClock.elapsedRealtime();
                    k3.connect();
                    long elapsedRealtime = SystemClock.elapsedRealtime() - this.f107172n;
                    com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-AbsDetectTask", "connect time:" + elapsedRealtime + " SSLHandshakeTime:" + (this.f107175q - this.f107174p) + " tcp handshake:" + (this.f107173o - this.f107172n));
                    if (z16) {
                        this.f107152i += this.f107170l.length;
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        outputStream2 = k3.getOutputStream();
                        outputStream2.write(this.f107170l);
                        outputStream2.flush();
                        j3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                    } else {
                        j3 = -1;
                    }
                    long elapsedRealtime3 = SystemClock.elapsedRealtime();
                    int responseCode = k3.getResponseCode();
                    long elapsedRealtime4 = SystemClock.elapsedRealtime() - elapsedRealtime3;
                    int contentLength = k3.getContentLength();
                    if (responseCode == 200 && contentLength == -1 && (headerField = k3.getHeaderField("Transfer-Encoding")) != null && headerField.equals("chunked")) {
                        contentLength = -2;
                    }
                    com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-AbsDetectTask", "Http:errorCode:" + responseCode + " connCostTime:" + elapsedRealtime + " readTime:" + elapsedRealtime4 + " writeTime:" + j3 + " contentLen:" + contentLength);
                    l(k3, outputStream2);
                } catch (Throwable th6) {
                    th5 = th6;
                    outputStream = outputStream2;
                    httpURLConnection = k3;
                    try {
                        th5.printStackTrace();
                        return true;
                    } finally {
                        l(httpURLConnection, outputStream);
                    }
                }
            } catch (Throwable th7) {
                th5 = th7;
                outputStream = null;
            }
            return true;
        } catch (MalformedURLException unused) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-cloud-AbsDetectTask", "MalformedURLException is called");
            return false;
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.a
    protected void c() {
        this.f107168j = q();
        this.f107169k = e();
        this.f107170l = f();
        this.f107171m = g();
    }
}
