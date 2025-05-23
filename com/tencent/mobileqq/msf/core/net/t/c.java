package com.tencent.mobileqq.msf.core.net.t;

import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.album.GuildFeedPreviewCustomization;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.k;
import com.tencent.mobileqq.msf.core.net.t.a;
import com.tencent.mobileqq.msf.core.net.t.e;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msfcore.quic.QuicSocket;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c implements Runnable {
    static IPatchRedirector $redirector_ = null;
    private static final String L = "HTTP/1.";
    private static final String M = "Cookie:";
    private static final String N = "Set-Cookie:";
    private static final String O = "Content-Length:";
    private static final String P = "md5=";
    private static final String Q = "gateway=";
    private static final String R = ";";
    private static final String S = "\r\n";
    private static final String T = "\r\n\r\n";
    private static final String U = "200";
    private static final int V = 10240;
    private static final int W = 5;
    long A;
    long B;
    long C;
    long D;
    long E;
    long F;
    long G;
    long H;
    long I;
    long J;
    long K;

    /* renamed from: a, reason: collision with root package name */
    private HostnameVerifier f249146a;

    /* renamed from: b, reason: collision with root package name */
    d f249147b;

    /* renamed from: c, reason: collision with root package name */
    com.tencent.msf.service.protocol.push.h.d f249148c;

    /* renamed from: d, reason: collision with root package name */
    com.tencent.msf.service.protocol.push.h.b f249149d;

    /* renamed from: e, reason: collision with root package name */
    int f249150e;

    /* renamed from: f, reason: collision with root package name */
    int f249151f;

    /* renamed from: g, reason: collision with root package name */
    boolean f249152g;

    /* renamed from: h, reason: collision with root package name */
    DatagramSocket f249153h;

    /* renamed from: i, reason: collision with root package name */
    Socket f249154i;

    /* renamed from: j, reason: collision with root package name */
    OutputStream f249155j;

    /* renamed from: k, reason: collision with root package name */
    URL f249156k;

    /* renamed from: l, reason: collision with root package name */
    HttpURLConnection f249157l;

    /* renamed from: m, reason: collision with root package name */
    int f249158m;

    /* renamed from: n, reason: collision with root package name */
    int f249159n;

    /* renamed from: o, reason: collision with root package name */
    InetAddress f249160o;

    /* renamed from: p, reason: collision with root package name */
    int f249161p;

    /* renamed from: q, reason: collision with root package name */
    private String f249162q;

    /* renamed from: r, reason: collision with root package name */
    QuicSocket f249163r;

    /* renamed from: s, reason: collision with root package name */
    g f249164s;

    /* renamed from: t, reason: collision with root package name */
    f f249165t;

    /* renamed from: u, reason: collision with root package name */
    private int f249166u;

    /* renamed from: v, reason: collision with root package name */
    private int f249167v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f249168w;

    /* renamed from: x, reason: collision with root package name */
    long f249169x;

    /* renamed from: y, reason: collision with root package name */
    long f249170y;

    /* renamed from: z, reason: collision with root package name */
    long f249171z;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements HostnameVerifier {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) sSLSession)).booleanValue();
            }
            if (c.this.f249156k == null) {
                return false;
            }
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            String host = c.this.f249156k.getHost();
            boolean verify = defaultHostnameVerifier.verify(host, sSLSession);
            if (!verify) {
                QLog.d("MSF.C.QualityTestManager", 1, "QualityMtuTestClient.HostnameVerifier.host:", host, ",address:", sSLSession.getPeerHost(), ",isVerify:", Boolean.FALSE);
            } else if (QLog.isColorLevel()) {
                QLog.e("MSF.C.QualityTestManager", 2, "QualityMtuTestClient.HostnameVerifier.host:", host, ",address:", sSLSession.getPeerHost(), ",isVerify:", Boolean.TRUE);
            }
            return verify;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f249173a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19400);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[d.values().length];
            f249173a = iArr;
            try {
                iArr[d.f249175a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f249173a[d.f249176b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f249173a[d.f249177c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f249173a[d.f249180f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f249173a[d.f249178d.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f249173a[d.f249179e.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.net.t.c$c, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C8090c implements X509TrustManager {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private X509TrustManager f249174a;

        C8090c() throws Exception {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("trustedCerts"), "passphrase".toCharArray());
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (TrustManager trustManager : trustManagers) {
                if (trustManager instanceof X509TrustManager) {
                    this.f249174a = (X509TrustManager) trustManager;
                    return;
                }
            }
            throw new Exception("Couldn't initialize");
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) x509CertificateArr, (Object) str);
                return;
            }
            X509TrustManager x509TrustManager = this.f249174a;
            if (x509TrustManager != null) {
                x509TrustManager.checkClientTrusted(x509CertificateArr, str);
            }
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.QualityTestManager", 2, "checkClientTrusted");
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) x509CertificateArr, (Object) str);
                return;
            }
            X509TrustManager x509TrustManager = this.f249174a;
            if (x509TrustManager != null) {
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
            }
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.QualityTestManager", 2, "checkServerTrusted");
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (X509Certificate[]) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            X509TrustManager x509TrustManager = this.f249174a;
            if (x509TrustManager != null) {
                return x509TrustManager.getAcceptedIssuers();
            }
            return new X509Certificate[0];
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final d f249175a;

        /* renamed from: b, reason: collision with root package name */
        public static final d f249176b;

        /* renamed from: c, reason: collision with root package name */
        public static final d f249177c;

        /* renamed from: d, reason: collision with root package name */
        public static final d f249178d;

        /* renamed from: e, reason: collision with root package name */
        public static final d f249179e;

        /* renamed from: f, reason: collision with root package name */
        public static final d f249180f;

        /* renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ d[] f249181g;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16789);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            d dVar = new d("UdpTest", 0);
            f249175a = dVar;
            d dVar2 = new d("TcpTest", 1);
            f249176b = dVar2;
            d dVar3 = new d("HttpTest", 2);
            f249177c = dVar3;
            d dVar4 = new d("PingTest", 3);
            f249178d = dVar4;
            d dVar5 = new d("TracerouteTest", 4);
            f249179e = dVar5;
            d dVar6 = new d("QuicTest", 5);
            f249180f = dVar6;
            f249181g = new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6};
        }

        d(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static d a(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f249181g.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public a f249184a;

        /* renamed from: b, reason: collision with root package name */
        public String f249185b;

        /* renamed from: c, reason: collision with root package name */
        public int f249186c;

        /* renamed from: d, reason: collision with root package name */
        public long f249187d;

        /* renamed from: e, reason: collision with root package name */
        public long f249188e;

        /* renamed from: f, reason: collision with root package name */
        public long f249189f;

        /* renamed from: g, reason: collision with root package name */
        public long f249190g;

        /* renamed from: h, reason: collision with root package name */
        public long f249191h;

        /* renamed from: i, reason: collision with root package name */
        public String f249192i;

        /* renamed from: j, reason: collision with root package name */
        public String f249193j;

        /* renamed from: k, reason: collision with root package name */
        public String f249194k;

        /* renamed from: l, reason: collision with root package name */
        public long f249195l;

        /* renamed from: m, reason: collision with root package name */
        public String f249196m;

        /* renamed from: n, reason: collision with root package name */
        public String f249197n;

        /* renamed from: o, reason: collision with root package name */
        public String f249198o;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* compiled from: P */
        /* loaded from: classes15.dex */
        public static final class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final a f249199a;

            /* renamed from: b, reason: collision with root package name */
            private static final /* synthetic */ a[] f249200b;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28897);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                    return;
                }
                a aVar = new a("QualityTest", 0);
                f249199a = aVar;
                f249200b = new a[]{aVar};
            }

            a(String str, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
                }
            }

            public static a a(String str) {
                return (a) Enum.valueOf(a.class, str);
            }

            public static a[] values() {
                return (a[]) f249200b.clone();
            }
        }

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f249184a = a.f249199a;
            this.f249185b = c.b() + "," + c.e() + "," + Build.VERSION.RELEASE.replaceAll("|", "_").replaceAll("#", "_").replace("*", "_");
            this.f249186c = 0;
            this.f249187d = 0L;
            this.f249188e = 0L;
            this.f249189f = 0L;
            this.f249190g = 0L;
            this.f249191h = 0L;
            this.f249192i = "";
            this.f249193j = "0.0.0.0";
            this.f249194k = o.f();
            this.f249195l = 0L;
            this.f249196m = "0,0";
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "" + this.f249184a + ":5|" + this.f249192i + "|" + this.f249193j + "|" + this.f249194k + "|" + this.f249195l + "|" + this.f249196m + "|" + this.f249188e + "|" + this.f249187d + "|" + this.f249189f + "|" + this.f249186c + "|" + this.f249185b + "|" + this.f249190g + "|" + this.f249191h + "|" + this.f249197n + "|" + this.f249198o + "#";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class g {
        static IPatchRedirector $redirector_;
        public String A;
        public long B;
        public String C;
        public long D;
        public int E;
        public int F;
        public int G;
        public int H;
        public ArrayList<Long> I;
        public ArrayList<Long> J;
        public String K;
        public String L;
        public long M;
        public long N;
        public int O;
        public String P;
        public int Q;
        public String R;

        /* renamed from: a, reason: collision with root package name */
        public b f249201a;

        /* renamed from: b, reason: collision with root package name */
        public a f249202b;

        /* renamed from: c, reason: collision with root package name */
        public Map<a, Integer> f249203c;

        /* renamed from: d, reason: collision with root package name */
        public InetAddress f249204d;

        /* renamed from: e, reason: collision with root package name */
        public InetAddress f249205e;

        /* renamed from: f, reason: collision with root package name */
        public int f249206f;

        /* renamed from: g, reason: collision with root package name */
        public int f249207g;

        /* renamed from: h, reason: collision with root package name */
        public int f249208h;

        /* renamed from: i, reason: collision with root package name */
        public int f249209i;

        /* renamed from: j, reason: collision with root package name */
        public int f249210j;

        /* renamed from: k, reason: collision with root package name */
        public int f249211k;

        /* renamed from: l, reason: collision with root package name */
        public int f249212l;

        /* renamed from: m, reason: collision with root package name */
        public int f249213m;

        /* renamed from: n, reason: collision with root package name */
        public int f249214n;

        /* renamed from: o, reason: collision with root package name */
        public int f249215o;

        /* renamed from: p, reason: collision with root package name */
        public int f249216p;

        /* renamed from: q, reason: collision with root package name */
        public int f249217q;

        /* renamed from: r, reason: collision with root package name */
        public int f249218r;

        /* renamed from: s, reason: collision with root package name */
        public long f249219s;

        /* renamed from: t, reason: collision with root package name */
        public long f249220t;

        /* renamed from: u, reason: collision with root package name */
        ArrayList f249221u;

        /* renamed from: v, reason: collision with root package name */
        ArrayList f249222v;

        /* renamed from: w, reason: collision with root package name */
        public long f249223w;

        /* renamed from: x, reason: collision with root package name */
        public boolean f249224x;

        /* renamed from: y, reason: collision with root package name */
        ArrayList f249225y;

        /* renamed from: z, reason: collision with root package name */
        public long f249226z;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* compiled from: P */
        /* loaded from: classes15.dex */
        public static final class a {
            static IPatchRedirector $redirector_;
            public static final a A;
            private static final /* synthetic */ a[] B;

            /* renamed from: a, reason: collision with root package name */
            public static final a f249227a;

            /* renamed from: b, reason: collision with root package name */
            public static final a f249228b;

            /* renamed from: c, reason: collision with root package name */
            public static final a f249229c;

            /* renamed from: d, reason: collision with root package name */
            public static final a f249230d;

            /* renamed from: e, reason: collision with root package name */
            public static final a f249231e;

            /* renamed from: f, reason: collision with root package name */
            public static final a f249232f;

            /* renamed from: g, reason: collision with root package name */
            public static final a f249233g;

            /* renamed from: h, reason: collision with root package name */
            public static final a f249234h;

            /* renamed from: i, reason: collision with root package name */
            public static final a f249235i;

            /* renamed from: j, reason: collision with root package name */
            public static final a f249236j;

            /* renamed from: k, reason: collision with root package name */
            public static final a f249237k;

            /* renamed from: l, reason: collision with root package name */
            public static final a f249238l;

            /* renamed from: m, reason: collision with root package name */
            public static final a f249239m;

            /* renamed from: n, reason: collision with root package name */
            public static final a f249240n;

            /* renamed from: o, reason: collision with root package name */
            public static final a f249241o;

            /* renamed from: p, reason: collision with root package name */
            public static final a f249242p;

            /* renamed from: q, reason: collision with root package name */
            public static final a f249243q;

            /* renamed from: r, reason: collision with root package name */
            public static final a f249244r;

            /* renamed from: s, reason: collision with root package name */
            public static final a f249245s;

            /* renamed from: t, reason: collision with root package name */
            public static final a f249246t;

            /* renamed from: u, reason: collision with root package name */
            public static final a f249247u;

            /* renamed from: v, reason: collision with root package name */
            public static final a f249248v;

            /* renamed from: w, reason: collision with root package name */
            public static final a f249249w;

            /* renamed from: x, reason: collision with root package name */
            public static final a f249250x;

            /* renamed from: y, reason: collision with root package name */
            public static final a f249251y;

            /* renamed from: z, reason: collision with root package name */
            public static final a f249252z;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16954);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                    return;
                }
                a aVar = new a("Success", 0);
                f249227a = aVar;
                a aVar2 = new a("Failed", 1);
                f249228b = aVar2;
                a aVar3 = new a("ConnectToServerFail", 2);
                f249229c = aVar3;
                a aVar4 = new a("SendPackageError", 3);
                f249230d = aVar4;
                a aVar5 = new a("RecvPackageError", 4);
                f249231e = aVar5;
                a aVar6 = new a("HeadDataLengthError", 5);
                f249232f = aVar6;
                a aVar7 = new a("IntervalTooSmall", 6);
                f249233g = aVar7;
                a aVar8 = new a("DataTooMuch", 7);
                f249234h = aVar8;
                a aVar9 = new a("DataTooShort", 8);
                f249235i = aVar9;
                a aVar10 = new a("TimeExpired", 9);
                f249236j = aVar10;
                a aVar11 = new a("QualityTestMsgNull", 10);
                f249237k = aVar11;
                a aVar12 = new a("PkgNumTooMuch", 11);
                f249238l = aVar12;
                a aVar13 = new a("IPPortTooMuch", 12);
                f249239m = aVar13;
                a aVar14 = new a("IPPortTooSmall", 13);
                f249240n = aVar14;
                a aVar15 = new a("MtuTestMsgNull", 14);
                f249241o = aVar15;
                a aVar16 = new a("MD5ValidFailed", 15);
                f249242p = aVar16;
                a aVar17 = new a("DWRepeatTimeWrong", 16);
                f249243q = aVar17;
                a aVar18 = new a("HTTPResponError", 17);
                f249244r = aVar18;
                a aVar19 = new a("NoHTTPHead", 18);
                f249245s = aVar19;
                a aVar20 = new a("HTTPContentLengthError", 19);
                f249246t = aVar20;
                a aVar21 = new a("HTTPAckDataTooLarge", 20);
                f249247u = aVar21;
                a aVar22 = new a("RecvPackageInvalid", 21);
                f249248v = aVar22;
                a aVar23 = new a("TestTypeNoSupported", 22);
                f249249w = aVar23;
                a aVar24 = new a("RecvTimeout", 23);
                f249250x = aVar24;
                a aVar25 = new a("RecvNetworkBroken", 24);
                f249251y = aVar25;
                a aVar26 = new a("OnlyDomainValid", 25);
                f249252z = aVar26;
                a aVar27 = new a("RecvDataTooMuch", 26);
                A = aVar27;
                B = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12, aVar13, aVar14, aVar15, aVar16, aVar17, aVar18, aVar19, aVar20, aVar21, aVar22, aVar23, aVar24, aVar25, aVar26, aVar27};
            }

            a(String str, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
                }
            }

            public static a a(String str) {
                return (a) Enum.valueOf(a.class, str);
            }

            public static a[] values() {
                return (a[]) B.clone();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* compiled from: P */
        /* loaded from: classes15.dex */
        public static final class b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final b f249253a;

            /* renamed from: b, reason: collision with root package name */
            public static final b f249254b;

            /* renamed from: c, reason: collision with root package name */
            private static final /* synthetic */ b[] f249255c;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19654);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                    return;
                }
                b bVar = new b("QualityTest", 0);
                f249253a = bVar;
                b bVar2 = new b("MtuTest", 1);
                f249254b = bVar2;
                f249255c = new b[]{bVar, bVar2};
            }

            b(String str, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
                }
            }

            public static b a(String str) {
                return (b) Enum.valueOf(b.class, str);
            }

            public static b[] values() {
                return (b[]) f249255c.clone();
            }
        }

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f249201a = b.f249253a;
            this.f249202b = a.f249227a;
            this.f249203c = new HashMap();
            this.I = new ArrayList<>();
            this.J = new ArrayList<>();
            this.f249206f = 0;
            this.f249211k = 0;
            this.f249212l = 0;
            this.f249213m = 0;
            this.f249214n = 0;
            this.f249215o = 0;
            this.f249216p = 0;
            this.f249217q = 0;
            this.f249218r = 0;
            this.f249219s = 0L;
            this.f249220t = 0L;
            this.f249223w = 0L;
            this.f249224x = false;
            this.B = 0L;
            this.D = 0L;
            this.E = 0;
            this.F = 0;
            this.G = 0;
            this.L = "0.0.0.0";
            this.M = 0L;
            this.N = 0L;
            this.O = 0;
            this.P = "";
            this.Q = 0;
            this.R = "";
        }

        public String toString() {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            a aVar = this.f249202b;
            a aVar2 = a.f249227a;
            if (aVar == aVar2 && this.f249203c.isEmpty()) {
                str = aVar2.toString();
            } else {
                Map<a, Integer> map = this.f249203c;
                if (map != null && !map.isEmpty()) {
                    String str9 = "";
                    for (Map.Entry<a, Integer> entry : this.f249203c.entrySet()) {
                        a key = entry.getKey();
                        str9 = str9 + key.toString() + ":" + entry.getValue().intValue() + ";";
                    }
                    str = str9;
                } else {
                    str = a.f249228b.toString();
                }
            }
            int i3 = this.f249218r;
            if (i3 != 5 && i3 != 6) {
                if (this.f249204d == null) {
                    str8 = "0.0.0.0|";
                } else {
                    str8 = this.f249204d.getHostAddress() + "|";
                }
                if (this.f249205e == null) {
                    str2 = str8 + "0.0.0.0|";
                } else {
                    str2 = str8 + this.f249205e.getHostAddress() + "|";
                }
                String str10 = this.C;
                if (str10 == null || str10.isEmpty()) {
                    InetAddress inetAddress = this.f249205e;
                    if (inetAddress == null) {
                        this.C = "0.0.0.0";
                    } else {
                        this.C = inetAddress.getHostAddress();
                    }
                }
            } else {
                if (this.K == null) {
                    str2 = "0|0.0.0.0|";
                } else {
                    str2 = "0|" + this.K + "|";
                }
                String str11 = this.C;
                if (str11 == null || str11.isEmpty()) {
                    this.C = this.K;
                }
            }
            ArrayList arrayList = this.f249225y;
            if (arrayList == null || arrayList.size() == 0) {
                str3 = "";
            } else {
                str3 = "";
                for (int i16 = 0; i16 < this.f249225y.size(); i16++) {
                    if (i16 != this.f249225y.size() - 1) {
                        str3 = str3 + this.f249225y.get(i16) + ",";
                    } else {
                        str3 = str3 + this.f249225y.get(i16);
                    }
                }
            }
            ArrayList arrayList2 = this.f249221u;
            if (arrayList2 == null || arrayList2.size() == 0) {
                str4 = "";
            } else {
                str4 = "";
                for (int i17 = 0; i17 < this.f249221u.size(); i17++) {
                    if (i17 != this.f249221u.size() - 1) {
                        str4 = str4 + this.f249221u.get(i17) + ",";
                    } else {
                        str4 = str4 + this.f249221u.get(i17);
                    }
                }
            }
            if (this.f249224x) {
                str5 = this.A;
            } else {
                str5 = "false";
            }
            if (this.f249201a == b.f249253a) {
                return "" + str + "|" + str2 + this.f249206f + "|" + this.L + "|" + this.M + "|" + this.N + "|" + this.O + "|" + this.P + "|" + this.Q + "|" + this.R + "|" + this.C + "|" + this.D + "|" + this.E + "|" + this.F + "|" + this.G + "|" + this.f249207g + "|" + this.f249212l + "|" + this.f249213m + "|" + this.I.toString().replace("[", "").replace("]", "") + "|" + this.J.toString().replace("[", "").replace("]", "") + "|" + this.f249214n + "|" + this.f249215o + "|" + this.f249216p + "|" + this.f249217q + "|" + this.f249218r + "|" + this.f249219s + "|" + this.f249220t + "|" + str4 + "|" + this.f249223w + "|" + str5 + "|" + str3 + "|" + this.f249226z + "|" + this.f249208h + "," + this.f249209i + "," + this.f249210j;
            }
            int min = Math.min(this.f249212l, this.f249213m);
            if (min > 0) {
                str6 = Integer.toString(this.f249211k / min);
            } else {
                str6 = "0";
            }
            ArrayList arrayList3 = this.f249222v;
            if (arrayList3 == null || arrayList3.size() == 0) {
                str7 = "";
            } else {
                str7 = "";
                for (int i18 = 0; i18 < this.f249222v.size(); i18++) {
                    if (i18 != this.f249222v.size() - 1) {
                        str7 = str7 + this.f249222v.get(i18) + ",";
                    } else {
                        str7 = str7 + this.f249222v.get(i18);
                    }
                }
            }
            return "" + this.f249201a + "|" + str + "|" + str2 + this.f249206f + "|" + this.f249207g + "|" + str6 + "|" + this.f249212l + "|" + this.f249213m + "|" + this.f249214n + "|" + this.f249215o + "|" + str7 + "|" + this.f249216p + "|" + this.f249217q + "|" + this.f249218r + "|" + this.f249219s + "|" + this.f249220t + "|" + str4 + "|" + this.f249223w + "|" + str5 + "|" + str3 + "|" + this.f249226z + "|" + this.f249208h + "," + this.f249209i + "," + this.f249210j;
        }
    }

    public c(com.tencent.msf.service.protocol.push.h.d dVar, com.tencent.msf.service.protocol.push.h.b bVar, d dVar2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, dVar, bVar, dVar2, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f249146a = new a();
        this.f249152g = false;
        this.f249153h = null;
        this.f249154i = null;
        this.f249155j = null;
        this.f249156k = null;
        this.f249158m = 0;
        this.f249159n = 10000;
        this.f249160o = null;
        this.f249162q = "";
        this.f249163r = null;
        this.f249164s = new g();
        this.f249165t = new f();
        this.f249168w = true;
        this.f249169x = 0L;
        this.f249170y = 0L;
        this.f249171z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0L;
        this.H = 0L;
        this.I = 0L;
        this.J = 0L;
        this.K = 0L;
        this.f249148c = dVar;
        this.f249149d = bVar;
        this.f249147b = dVar2;
        this.f249150e = i3;
        this.f249151f = i16;
    }

    private boolean a(com.tencent.msf.service.protocol.push.h.a aVar) {
        int i3;
        int i16;
        String str;
        String str2 = "close";
        String str3 = "Connection";
        com.tencent.msf.service.protocol.push.h.d dVar = this.f249148c;
        if (dVar != null) {
            g gVar = this.f249164s;
            long j3 = dVar.f336599i;
            gVar.f249226z = j3;
            if (j3 > 0 && j3 < 600) {
                this.f249159n = ((int) j3) * 1000;
            }
        } else {
            com.tencent.msf.service.protocol.push.h.b bVar = this.f249149d;
            if (bVar != null) {
                g gVar2 = this.f249164s;
                long j16 = bVar.f336588i;
                gVar2.f249226z = j16;
                if (j16 > 0 && j16 < 600) {
                    this.f249159n = ((int) j16) * 1000;
                }
            }
        }
        try {
            i3 = 4;
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: Start connecting: " + this.f249160o + ", port:" + this.f249161p + ", strDomain:" + aVar.f336574c + ", mTestType:" + this.f249147b);
            }
            i16 = b.f249173a[this.f249147b.ordinal()];
        } catch (Exception e16) {
            this.f249164s.I.add(-1L);
            e16.printStackTrace();
            return false;
        }
        if (i16 == 1) {
            DatagramSocket datagramSocket = new DatagramSocket();
            this.f249153h = datagramSocket;
            datagramSocket.setSoTimeout(this.f249159n);
            this.f249164s.I.add(-1L);
        } else {
            if (i16 == 2) {
                try {
                    InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f249160o, this.f249161p);
                    Socket socket = new Socket();
                    this.f249154i = socket;
                    socket.setSoTimeout(this.f249159n);
                    this.f249154i.setTcpNoDelay(true);
                    this.f249154i.setKeepAlive(true);
                    this.f249171z = System.currentTimeMillis();
                    this.f249154i.connect(inetSocketAddress, this.f249159n);
                    long currentTimeMillis = System.currentTimeMillis();
                    this.A = currentTimeMillis;
                    long j17 = currentTimeMillis - this.f249171z;
                    this.F = j17;
                    this.f249164s.I.add(Long.valueOf(j17));
                    this.f249155j = this.f249154i.getOutputStream();
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: TCP end connect: " + this.f249160o + ", port:" + this.f249161p + ", readTimeout:" + this.f249159n);
                    }
                } catch (Throwable th5) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: TCP end connect: " + this.f249160o + ", port:" + this.f249161p + ", mTestType:" + this.f249147b + " failed", th5);
                    }
                    g gVar3 = this.f249164s;
                    gVar3.f249215o++;
                    gVar3.I.add(-1L);
                    return false;
                }
            } else {
                if (i16 != 3) {
                    if (i16 != 4) {
                        return false;
                    }
                    try {
                        QuicSocket quicSocket = new QuicSocket();
                        this.f249163r = quicSocket;
                        if (quicSocket.getSocketFd() == -1) {
                            QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: create Quic Socket failed, not connect " + this.f249160o + ", port:" + this.f249161p + ", mTestType:" + this.f249147b);
                            g gVar4 = this.f249164s;
                            gVar4.f249215o = gVar4.f249215o + 1;
                            gVar4.I.add(-1L);
                            return false;
                        }
                        this.f249171z = System.currentTimeMillis();
                        this.f249163r.connect(this.f249160o.getHostAddress(), this.f249161p, this.f249159n);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        this.A = currentTimeMillis2;
                        long j18 = currentTimeMillis2 - this.f249171z;
                        this.F = j18;
                        this.f249164s.I.add(Long.valueOf(j18));
                        QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: Quic end connect: " + this.f249160o + ", port:" + this.f249161p + ", readTimeout:" + this.f249159n + " success, costTime:" + this.F);
                        return true;
                    } catch (Throwable th6) {
                        QLog.e("MSF.C.QualityTestManager", 1, "QualityTest: Quic end connect: " + this.f249160o + ", port:" + this.f249161p + ", mTestType:" + this.f249147b + " failed", th6);
                        g gVar5 = this.f249164s;
                        gVar5.f249215o = gVar5.f249215o + 1;
                        gVar5.I.add(-1L);
                        return false;
                    }
                }
                try {
                    if (this.f249148c.f336615y == 1) {
                        str = "https://" + this.f249160o.getHostAddress() + ":" + this.f249161p + "/" + this.f249148c.f336607q;
                    } else {
                        str = "http://" + this.f249160o.getHostAddress() + ":" + this.f249161p + "/" + this.f249148c.f336607q;
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: connecting http url:" + str);
                    }
                    this.f249171z = System.currentTimeMillis();
                    URL url = new URL(str);
                    this.f249156k = url;
                    this.f249157l = (HttpURLConnection) url.openConnection();
                    if (this.f249148c.f336615y == 1) {
                        j();
                        ((HttpsURLConnection) this.f249157l).setHostnameVerifier(this.f249146a);
                    }
                    this.f249157l.setConnectTimeout(this.f249159n);
                    this.f249157l.setDoInput(true);
                    this.f249157l.setUseCaches(false);
                    this.f249157l.setReadTimeout(this.f249159n);
                    this.f249157l.setRequestProperty("Connection", "close");
                    int i17 = this.f249158m;
                    if (i17 == 0) {
                        this.f249157l.setDoOutput(true);
                        this.f249157l.setRequestMethod("POST");
                        this.f249157l.setRequestProperty("Content-Type", "application/octet-stream");
                    } else if (i17 == 1) {
                        this.f249157l.setInstanceFollowRedirects(false);
                        this.f249157l.setRequestMethod("GET");
                    }
                    this.f249157l.setRequestProperty("Host", aVar.f336574c);
                    ArrayList<com.tencent.msf.service.protocol.push.h.e> arrayList = this.f249148c.f336609s;
                    if (arrayList != null && arrayList.size() > 0) {
                        Iterator<com.tencent.msf.service.protocol.push.h.e> it = this.f249148c.f336609s.iterator();
                        while (it.hasNext()) {
                            com.tencent.msf.service.protocol.push.h.e next = it.next();
                            if (next != null) {
                                this.f249157l.setRequestProperty(next.f336617a, next.f336618b);
                                if (QLog.isColorLevel()) {
                                    QLog.d("MSF.C.QualityTestManager", 4, "reqHead.strKey:" + next.f336617a + ",reqHead.strValue:" + next.f336618b);
                                }
                            }
                        }
                    }
                    this.f249157l.connect();
                    long currentTimeMillis3 = System.currentTimeMillis();
                    this.A = currentTimeMillis3;
                    this.B = currentTimeMillis3;
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: end connect: mRequestMethod:" + this.f249158m + ", readTimeout:" + this.f249159n);
                    }
                    String str4 = "";
                    if (this.f249158m == 1) {
                        int responseCode = this.f249157l.getResponseCode();
                        boolean z16 = (this.f249148c.f336608r & 4) != 4;
                        int i18 = 0;
                        while (true) {
                            if (!z16 || (responseCode != 301 && responseCode != 302 && responseCode != 307)) {
                                break;
                            }
                            int i19 = i18 + 1;
                            if (i19 > 10) {
                                QLog.d("MSF.C.QualityTestManager", i3, "Redirect too much!");
                                break;
                            }
                            str4 = this.f249157l.getHeaderField("Location");
                            this.f249157l.disconnect();
                            URL url2 = new URL(str4);
                            this.f249156k = url2;
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url2.openConnection();
                            this.f249157l = httpURLConnection;
                            httpURLConnection.setConnectTimeout(this.f249159n);
                            this.f249157l.setDoInput(true);
                            this.f249157l.setUseCaches(false);
                            this.f249157l.setInstanceFollowRedirects(false);
                            this.f249157l.setReadTimeout(this.f249159n);
                            this.f249157l.setRequestProperty(str3, str2);
                            this.f249157l.setRequestMethod("GET");
                            ArrayList<com.tencent.msf.service.protocol.push.h.e> arrayList2 = this.f249148c.f336609s;
                            if (arrayList2 != null && arrayList2.size() > 0) {
                                Iterator<com.tencent.msf.service.protocol.push.h.e> it5 = this.f249148c.f336609s.iterator();
                                while (it5.hasNext()) {
                                    com.tencent.msf.service.protocol.push.h.e next2 = it5.next();
                                    if (next2 != null) {
                                        String str5 = str2;
                                        String str6 = str3;
                                        this.f249157l.setRequestProperty(next2.f336617a, next2.f336618b);
                                        if (QLog.isColorLevel()) {
                                            QLog.d("MSF.C.QualityTestManager", 4, "reqHead.strKey:" + next2.f336617a + ",reqHead.strValue:" + next2.f336618b);
                                        }
                                        str2 = str5;
                                        str3 = str6;
                                    }
                                }
                            }
                            String str7 = str2;
                            String str8 = str3;
                            this.f249157l.connect();
                            long currentTimeMillis4 = System.currentTimeMillis();
                            this.A = currentTimeMillis4;
                            this.B = currentTimeMillis4;
                            if (QLog.isColorLevel()) {
                                QLog.d("MSF.C.QualityTestManager", 4, "Redirect responseCode:" + responseCode + ",lastRedirectUrl:" + str4);
                            }
                            responseCode = this.f249157l.getResponseCode();
                            i18 = i19;
                            str2 = str7;
                            str3 = str8;
                            i3 = 4;
                        }
                    }
                    long j19 = this.A - this.f249171z;
                    this.F = j19;
                    this.f249164s.I.add(Long.valueOf(j19));
                    if (!TextUtils.isEmpty(str4)) {
                        try {
                            String substring = str4.substring(str4.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER) + 3);
                            this.f249164s.L = InetAddress.getByName(substring.substring(0, substring.indexOf("/"))).getHostAddress();
                        } catch (Exception e17) {
                            if (QLog.isColorLevel()) {
                                QLog.d("MSF.C.QualityTestManager", 4, "DNSParse for lastUrl error!", e17);
                            }
                        }
                    }
                } catch (Throwable th7) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: connecting " + this.f249160o + " port:" + this.f249161p + " mTestType:" + this.f249147b + " failed", th7);
                    }
                    g gVar6 = this.f249164s;
                    gVar6.f249215o++;
                    gVar6.I.add(-1L);
                    return false;
                }
            }
            this.f249164s.I.add(-1L);
            e16.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean b(byte[] bArr) {
        try {
            int i3 = b.f249173a[this.f249147b.ordinal()];
            if (i3 == 1) {
                DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, this.f249160o, this.f249161p);
                try {
                    this.B = System.currentTimeMillis();
                    this.f249153h.send(datagramPacket);
                    long currentTimeMillis = System.currentTimeMillis();
                    this.C = currentTimeMillis;
                    this.G += currentTimeMillis - this.B;
                    this.H += bArr.length;
                    this.f249166u += bArr.length;
                    QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send udp packet length:" + datagramPacket.getLength() + " sendEndTime:" + this.C + " sendTime:" + this.B);
                    g gVar = this.f249164s;
                    gVar.f249212l = gVar.f249212l + 1;
                    return true;
                } catch (Exception e16) {
                    a(g.a.f249230d);
                    QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send udp packet error:", e16);
                    return false;
                }
            }
            if (i3 == 2) {
                try {
                    this.B = System.currentTimeMillis();
                    com.tencent.mobileqq.msf.core.net.t.g.f249399g.add(this.f249155j.toString());
                    this.f249155j.write(bArr);
                    this.f249155j.flush();
                    com.tencent.mobileqq.msf.core.net.t.g.f249399g.remove(this.f249155j.toString());
                    this.H += bArr.length;
                    this.f249166u += bArr.length;
                    this.f249164s.f249212l++;
                    return true;
                } catch (Exception e17) {
                    OutputStream outputStream = this.f249155j;
                    if (outputStream != null) {
                        com.tencent.mobileqq.msf.core.net.t.g.f249399g.remove(outputStream.toString());
                    }
                    a(g.a.f249230d);
                    QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send tcp error:", e17);
                    return false;
                }
            }
            if (i3 == 3) {
                try {
                    OutputStream outputStream2 = this.f249157l.getOutputStream();
                    this.f249155j = outputStream2;
                    com.tencent.mobileqq.msf.core.net.t.g.f249399g.add(outputStream2.toString());
                    this.f249155j.write(bArr);
                    this.f249155j.flush();
                    com.tencent.mobileqq.msf.core.net.t.g.f249399g.remove(this.f249155j.toString());
                    this.H += bArr.length;
                    this.f249166u += bArr.length;
                    this.f249164s.f249212l++;
                    return true;
                } catch (Exception e18) {
                    OutputStream outputStream3 = this.f249155j;
                    if (outputStream3 != null) {
                        com.tencent.mobileqq.msf.core.net.t.g.f249399g.remove(outputStream3.toString());
                    }
                    a(g.a.f249230d);
                    QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send http error:", e18);
                    return false;
                }
            }
            if (i3 != 4) {
                return false;
            }
            try {
                this.B = System.currentTimeMillis();
                this.f249163r.write(bArr);
                this.H += bArr.length;
                this.f249166u += bArr.length;
                this.f249164s.f249212l++;
                QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send Quic packet length:" + bArr.length + " sendTime:" + this.B);
                return true;
            } catch (Exception e19) {
                a(g.a.f249230d);
                QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send Quic packet error:", e19);
                return false;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    private void c() {
        a.C8089a b16 = com.tencent.mobileqq.msf.core.net.t.a.b();
        f fVar = this.f249165t;
        fVar.f249197n = b16.f249135a;
        fVar.f249198o = b16.f249136b;
        com.tencent.msf.service.protocol.push.h.d dVar = this.f249148c;
        fVar.f249187d = dVar.f336600j;
        fVar.f249188e = dVar.f336605o;
        fVar.f249189f = dVar.f336601k;
        fVar.f249190g = dVar.f336602l;
        fVar.f249191h = dVar.f336603m;
        fVar.f249184a = f.a.f249199a;
        fVar.f249192i = dVar.f336611u;
        ArrayList<InetAddress> b17 = k.b();
        if (b17 != null && b17.size() > 0) {
            this.f249165t.f249193j = b17.get(0).getHostAddress();
        } else if (QLog.isColorLevel()) {
            QLog.d("MSF.C.QualityTestManager", 2, "mDnses is null");
        }
        long j3 = o.f249568k;
        if (0 != j3) {
            f fVar2 = this.f249165t;
            fVar2.f249195l = j3;
            fVar2.f249196m = o.f249569l + "," + o.f249570m;
        }
    }

    public static String e() {
        Throwable th5;
        BufferedReader bufferedReader;
        Exception e16;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
        } catch (Exception e17) {
            e16 = e17;
            bufferedReader = null;
        } catch (Throwable th6) {
            th5 = th6;
            bufferedReader = null;
            try {
                bufferedReader.close();
            } catch (Exception e18) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "Close BufferReader failed.");
                }
                e18.printStackTrace();
            }
            throw th5;
        }
        try {
            try {
                String[] split = bufferedReader.readLine().replaceAll(" ", "").split(":");
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "memory: " + split[1]);
                }
                try {
                    bufferedReader.close();
                } catch (Exception e19) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "Close BufferReader failed.");
                    }
                    e19.printStackTrace();
                }
                return split[1];
            } catch (Throwable th7) {
                th5 = th7;
                bufferedReader.close();
                throw th5;
            }
        } catch (Exception e26) {
            e16 = e26;
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "QualityTest wrong: cannot read mem size.");
            }
            e16.printStackTrace();
            try {
                bufferedReader.close();
                return "cannot read memory size";
            } catch (Exception e27) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "Close BufferReader failed.");
                }
                e27.printStackTrace();
                return "cannot read memory size";
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:(2:109|(5:111|(1:113)|114|115|116)(2:117|118))(1:157)|119|120|(1:124)|125|(2:128|126)|129|130|(4:147|148|(1:150)|151)(5:132|(7:137|(1:139)|140|141|142|143|116)(1:134)|135|136|116)) */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0408, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0409, code lost:
    
        com.tencent.qphone.base.util.QLog.d("MSF.C.QualityTestManager", 1, "QualityClient:  error:", r0);
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f() {
        boolean z16;
        int i3;
        boolean z17;
        if (this.f249149d == null) {
            a(g.a.f249241o, true);
            return;
        }
        g gVar = this.f249164s;
        gVar.f249201a = g.b.f249254b;
        gVar.f249207g = NetConnInfoCenter.getSystemNetworkType();
        g gVar2 = this.f249164s;
        com.tencent.msf.service.protocol.push.h.b bVar = this.f249149d;
        gVar2.f249218r = bVar.f336580a;
        gVar2.f249219s = bVar.f336586g;
        gVar2.f249220t = bVar.f336585f;
        gVar2.f249221u = new ArrayList();
        for (int i16 = 0; i16 < this.f249149d.f336583d.size(); i16++) {
            this.f249164s.f249221u.add(this.f249149d.f336583d.get(i16));
        }
        g gVar3 = this.f249164s;
        gVar3.f249223w = this.f249149d.f336587h;
        gVar3.f249222v = new ArrayList();
        QLog.d("MSF.C.QualityTestManager", 1, "PkgInterval :" + this.f249149d.f336585f + " IpPort.size():" + this.f249149d.f336581b.size() + " PkgData.length " + this.f249149d.f336582c.size() + " PkgNum:" + this.f249149d.f336586g);
        if (this.f249149d.f336581b.size() > 75) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
            }
            this.f249168w = false;
            a(g.a.f249239m, true);
            return;
        }
        if (this.f249149d.f336581b.size() <= 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
            }
            a(g.a.f249240n, true);
            return;
        }
        com.tencent.msf.service.protocol.push.h.b bVar2 = this.f249149d;
        if (bVar2.f336586g > 20) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
            }
            this.f249168w = false;
            a(g.a.f249238l, true);
            return;
        }
        if (bVar2.f336587h * 1000 < System.currentTimeMillis()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "mtuTest expired, stop test mtuTest.dwExpirTime:" + this.f249149d.f336587h + "System.currentTimeMillis():" + System.currentTimeMillis());
            }
            a(g.a.f249236j, true);
            return;
        }
        if (this.f249149d.f336584e.size() == this.f249149d.f336583d.size() && this.f249149d.f336582c.size() == this.f249149d.f336583d.size()) {
            long j3 = this.f249149d.f336586g;
            if (j3 <= 0) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "mtuTest dwPkgNum too short, stop test mtuTest.dwPkgNum:" + this.f249149d.f336586g);
                }
                a(g.a.f249235i, true);
                return;
            }
            if (j3 * r0.f336582c.size() > 20) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
                }
                this.f249168w = false;
                a(g.a.f249238l, true);
                return;
            }
            for (int i17 = 0; i17 < this.f249149d.f336581b.size(); i17++) {
                try {
                    try {
                        this.f249164s.f249225y = new ArrayList();
                        g gVar4 = this.f249164s;
                        gVar4.f249211k = 0;
                        gVar4.f249214n = 0;
                        gVar4.f249212l = 0;
                        gVar4.f249213m = 0;
                        gVar4.f249215o = 0;
                        gVar4.f249203c.clear();
                        this.f249164s.f249222v.clear();
                        try {
                            this.f249164s.f249208h = NetConnInfoCenter.getWifiStrength();
                            this.f249164s.f249210j = NetConnInfoCenter.getCdmaStrength();
                            this.f249164s.f249209i = NetConnInfoCenter.getGsmStrength();
                        } catch (Exception unused) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d("MSF.C.QualityTestManager", 4, "failed to get network strength");
                            }
                        }
                        boolean z18 = false;
                        for (int i18 = 0; i18 < this.f249149d.f336582c.size(); i18++) {
                            if (this.f249149d.f336582c.get(i18).length < 8) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, stop test qualityTestMsg.sPkgData.length");
                                }
                                a(g.a.f249235i);
                            } else {
                                if (this.f249149d.f336584e.get(i18) != null && this.f249149d.f336584e.get(i18).length > 0) {
                                    i3 = this.f249149d.f336584e.get(i18).length;
                                } else {
                                    i3 = 0;
                                }
                                long j16 = i3;
                                long length = this.f249149d.f336582c.get(i18).length;
                                long longValue = this.f249149d.f336583d.get(i18).longValue();
                                Long.signum(length);
                                int i19 = (int) (j16 + (length * longValue));
                                QLog.d("MSF.C.QualityTestManager", 1, "mtu allbodylength " + i19);
                                if (i19 > 262144 && this.f249147b == d.f249175a) {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i19 + " return ");
                                    }
                                    a(g.a.f249234h);
                                } else if (i19 > 262144) {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i19 + " return ");
                                    }
                                    this.f249168w = false;
                                    a(g.a.f249234h);
                                } else if (this.f249149d.f336585f < 10) {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgInterval too small " + this.f249149d.f336585f + " return ");
                                    }
                                    a(g.a.f249233g);
                                } else {
                                    int i26 = 0;
                                    while (true) {
                                        long j17 = i26;
                                        com.tencent.msf.service.protocol.push.h.b bVar3 = this.f249149d;
                                        if (j17 >= bVar3.f336586g) {
                                            break;
                                        }
                                        if (!z18) {
                                            if (!a(bVar3.f336581b.get(i17))) {
                                                if (QLog.isDevelopLevel()) {
                                                    QLog.d("MSF.C.QualityTestManager", 4, "connectToServer error, return ");
                                                }
                                                a(g.a.f249229c);
                                                i26++;
                                            } else {
                                                this.G = 0L;
                                                this.I = 0L;
                                                this.H = 0L;
                                                this.J = 0L;
                                                z17 = true;
                                            }
                                        } else {
                                            z17 = z18;
                                        }
                                        ByteBuffer allocate = ByteBuffer.allocate(i19);
                                        byte[] bArr = new byte[i19];
                                        if (this.f249149d.f336584e.get(i18) != null && this.f249149d.f336584e.get(i18).length > 0) {
                                            allocate.put(this.f249149d.f336584e.get(i18));
                                        }
                                        for (int i27 = 0; i27 < this.f249149d.f336583d.get(i18).longValue(); i27++) {
                                            allocate.put(this.f249149d.f336582c.get(i18));
                                        }
                                        allocate.flip();
                                        allocate.get(bArr);
                                        int a16 = com.tencent.mobileqq.msf.core.c.a(bArr, 0);
                                        if (a16 != i19) {
                                            if (QLog.isDevelopLevel()) {
                                                QLog.d("MSF.C.QualityTestManager", 4, "testdata length error stop dataTotalLen:" + a16 + " receBodySize:" + i19);
                                            }
                                            a(g.a.f249232f);
                                            z18 = z17;
                                        } else {
                                            if (b(bArr)) {
                                                if (!a(i19, bArr)) {
                                                    this.f249164s.f249222v.add(Integer.valueOf(i19));
                                                }
                                                try {
                                                    LockMethodProxy.sleep(this.f249149d.f336585f);
                                                } catch (Exception e16) {
                                                    QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: Thread sleep error " + e16);
                                                }
                                                z18 = z17;
                                                i26++;
                                            }
                                            z18 = false;
                                            i26++;
                                        }
                                    }
                                    this.f249164s.f249225y.add(Integer.valueOf(i19));
                                }
                            }
                        }
                        a();
                        if (i17 == this.f249149d.f336581b.size() - 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        a(g.a.f249227a, z16);
                    } finally {
                        com.tencent.mobileqq.msf.core.net.t.g.a();
                    }
                } catch (Exception e17) {
                    QLog.d("MSF.C.QualityTestManager", 1, "QualityClient  error ", e17);
                }
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData size error, stop test");
        }
        a(g.a.f249235i, true);
    }

    private void g() {
        int i3;
        boolean z16;
        boolean z17;
        if (this.f249148c == null) {
            a(g.a.f249237k, true);
            return;
        }
        c();
        this.f249164s.f249218r = this.f249148c.f336591a;
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.QualityTestManager", 2, "cProtoType:" + ((int) this.f249148c.f336591a) + " IpPort.size():" + this.f249148c.f336592b.size() + " cDomainToIpMode:" + ((int) this.f249148c.f336608r) + " strRspMatchPattern" + this.f249148c.f336610t + " strUserInfo:" + this.f249148c.f336611u + " dwRecvCopyStart" + this.f249148c.f336613w + " dwRecvCopyLen" + this.f249148c.f336614x + " strDnsSrvIp:" + this.f249165t.f249193j + " dwLocationTime:" + this.f249165t.f249195l + " strAxis:" + this.f249165t.f249196m);
        }
        if (this.f249148c.f336592b.size() > 10) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
            }
            this.f249168w = false;
            a(g.a.f249239m, true);
            return;
        }
        if (this.f249148c.f336592b.size() <= 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
            }
            this.f249168w = false;
            a(g.a.f249240n, true);
            return;
        }
        if (this.f249148c.f336598h * 1000 < System.currentTimeMillis()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg expired, stop test qualityTestMsg.dwExpirTime:" + this.f249148c.f336598h + "System.currentTimeMillis():" + System.currentTimeMillis());
            }
            a(g.a.f249236j, true);
            return;
        }
        long j3 = this.f249148c.f336599i;
        if (j3 > 0 && j3 < JoinTimeType.THIRTY_MINUTES) {
            i3 = ((int) j3) * 1000;
        } else {
            i3 = GuildFeedPreviewCustomization.DEFAULT_CHOOSE_VIDEO_DURATION;
        }
        for (int i16 = 0; i16 < this.f249148c.f336592b.size(); i16++) {
            try {
                try {
                    try {
                        this.f249164s.f249207g = NetConnInfoCenter.getSystemNetworkType();
                        this.f249164s.f249208h = NetConnInfoCenter.getWifiStrength();
                        this.f249164s.f249210j = NetConnInfoCenter.getCdmaStrength();
                        this.f249164s.f249209i = NetConnInfoCenter.getGsmStrength();
                        this.f249160o = com.tencent.qphone.base.util.e.a(this.f249148c.f336592b.get(i16).f336572a);
                    } catch (Exception e16) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("MSF.C.QualityTestManager", 4, "failed to get network info", e16);
                        }
                    }
                    this.f249164s.K = this.f249160o.getHostAddress();
                    this.f249164s.C = this.f249148c.f336592b.get(i16).f336574c;
                    String str = this.f249164s.C;
                    if (str == null || str.isEmpty()) {
                        g gVar = this.f249164s;
                        gVar.C = gVar.K;
                    }
                    this.f249164s.f249203c.clear();
                    g gVar2 = this.f249164s;
                    String str2 = gVar2.C;
                    gVar2.M = System.currentTimeMillis();
                    com.tencent.mobileqq.msf.core.net.t.e eVar = new com.tencent.mobileqq.msf.core.net.t.e(str2, true, i3);
                    int i17 = b.f249173a[this.f249147b.ordinal()];
                    String str3 = "";
                    if (i17 != 5) {
                        if (i17 == 6) {
                            e.a d16 = eVar.d();
                            if (d16 != null && d16.f249380b) {
                                str3 = d16.f249382d;
                                if (!TextUtils.isEmpty(d16.f249381c)) {
                                    this.f249164s.K = d16.f249381c;
                                }
                            }
                            z16 = false;
                        }
                        z16 = true;
                    } else {
                        ArrayList<com.tencent.msf.service.protocol.push.h.c> arrayList = this.f249148c.f336612v;
                        if (arrayList != null && arrayList.size() > 0) {
                            Iterator<com.tencent.msf.service.protocol.push.h.c> it = this.f249148c.f336612v.iterator();
                            String str4 = "";
                            while (it.hasNext()) {
                                com.tencent.msf.service.protocol.push.h.c next = it.next();
                                if (next != null) {
                                    str4 = str4 + next.f336589a + " " + next.f336590b + " ";
                                    if (QLog.isColorLevel()) {
                                        QLog.d("MSF.C.QualityTestManager", 4, "pingOptions.strKey:" + next.f336589a + ",pingOptions.strValue:" + next.f336590b);
                                    }
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("MSF.C.QualityTestManager", 2, "pingParamStr : " + str4);
                            }
                            eVar.c(str4);
                        }
                        e.a c16 = eVar.c();
                        if (c16 != null && c16.f249380b) {
                            str3 = c16.f249382d;
                            if (!TextUtils.isEmpty(c16.f249381c)) {
                                this.f249164s.K = c16.f249381c;
                            }
                            z16 = true;
                        }
                        z16 = false;
                    }
                    this.f249164s.R = com.tencent.qphone.base.util.e.b(str3);
                    g gVar3 = this.f249164s;
                    gVar3.Q = gVar3.R.length();
                    this.f249164s.N = System.currentTimeMillis();
                    if (i16 == this.f249148c.f336592b.size() - 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 2, "testsuccess: " + z16 + ",isUpload:" + z17);
                    }
                    if (z16) {
                        a(g.a.f249227a, z17);
                    } else {
                        a(g.a.f249228b, z17);
                    }
                } catch (Exception e17) {
                    QLog.d("MSF.C.QualityTestManager", 1, "networkDetectRun: error ", e17);
                }
            } finally {
                com.tencent.mobileqq.msf.core.net.t.g.a();
            }
        }
    }

    private static void j() {
        try {
            TrustManager[] trustManagerArr = {new C8090c()};
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e16) {
            QLog.e("MSF.C.QualityTestManager", 1, "trustallhost error! ", e16);
        }
    }

    private boolean k() {
        int i3;
        byte[] bArr = this.f249148c.f336597g;
        if (bArr == null && bArr.length <= 0) {
            return false;
        }
        String str = "";
        String str2 = "";
        for (String str3 : new String(bArr).split("\r\n")) {
            if ((str3.startsWith(M) && str3.contains(P)) || (str3.startsWith(N) && str3.contains(P))) {
                int indexOf = str3.indexOf(P);
                int indexOf2 = str3.indexOf(";", indexOf);
                if (indexOf != -1 && indexOf2 > (i3 = indexOf + 4)) {
                    str = str3.substring(i3, indexOf2);
                }
            } else {
                str2 = str2 + str3 + "\r\n";
            }
        }
        if (!str.equals(MD5.toMD5(str2 + "\r\n"))) {
            return false;
        }
        return true;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f249162q;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:327|(3:344|345|(6:347|348|350|(1:352)|353|310))|329|330|(2:331|332)|(2:334|(1:336)(12:338|239|161|162|163|164|(4:166|167|168|169)(2:187|(4:189|(1:191)(1:197)|192|193)(2:198|(2:201|(1:220)(5:205|(4:210|(1:212)(1:216)|213|(6:215|180|181|172|173|174))|217|213|(0)))))|170|171|172|173|174))(1:339)|337|161|162|163|164|(0)(0)|170|171|172|173|174) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:150|151|(3:324|325|(18:327|(3:344|345|(6:347|348|350|(1:352)|353|310))|329|330|331|332|(2:334|(1:336)(12:338|239|161|162|163|164|(4:166|167|168|169)(2:187|(4:189|(1:191)(1:197)|192|193)(2:198|(2:201|(1:220)(5:205|(4:210|(1:212)(1:216)|213|(6:215|180|181|172|173|174))|217|213|(0)))))|170|171|172|173|174))(1:339)|337|161|162|163|164|(0)(0)|170|171|172|173|174))|153|154|155|156|(4:234|235|236|(3:240|241|(6:303|304|306|(1:308)|309|310)(5:243|244|245|246|(9:248|249|(1:251)|252|(1:254)|255|257|258|259)(4:263|264|(5:266|267|268|269|271)(2:295|296)|272)))(12:238|239|161|162|163|164|(0)(0)|170|171|172|173|174))(13:158|159|160|161|162|163|164|(0)(0)|170|171|172|173|174)|147) */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x085b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x085c, code lost:
    
        r7 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0770, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:145:0x05d2 A[Catch: all -> 0x08f9, Exception -> 0x08fc, TRY_LEAVE, TryCatch #21 {Exception -> 0x08fc, blocks: (B:83:0x03a2, B:85:0x03a6, B:87:0x03a9, B:88:0x03ac, B:90:0x03b9, B:92:0x03bd, B:94:0x03c0, B:95:0x03c2, B:98:0x03e0, B:99:0x03e3, B:100:0x03e6, B:102:0x03f0, B:104:0x03f6, B:105:0x0416, B:109:0x0425, B:112:0x0433, B:115:0x049d, B:273:0x089e, B:278:0x08ae, B:281:0x08be, B:283:0x08c4, B:285:0x08de, B:287:0x08eb, B:290:0x08e4, B:231:0x077e, B:233:0x0784, B:170:0x084f, B:174:0x088b, B:179:0x0868, B:185:0x0875, B:215:0x084b, B:226:0x0890, B:227:0x0893, B:143:0x05cc, B:145:0x05d2, B:426:0x0490, B:428:0x0496), top: B:82:0x03a2, outer: #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x05e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0763  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x07b4 A[Catch: all -> 0x0858, Exception -> 0x085b, TRY_LEAVE, TryCatch #12 {Exception -> 0x085b, blocks: (B:164:0x078f, B:166:0x07b4), top: B:163:0x078f }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x07c2 A[Catch: Exception -> 0x0856, all -> 0x0858, TryCatch #17 {Exception -> 0x0856, blocks: (B:169:0x07be, B:187:0x07c2, B:189:0x07e3, B:191:0x07e9, B:201:0x0810, B:203:0x0816, B:205:0x082e, B:212:0x083c, B:213:0x0844, B:217:0x0843, B:218:0x081a), top: B:168:0x07be }] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x084b A[Catch: all -> 0x08f9, Exception -> 0x08fc, TRY_ENTER, TryCatch #21 {Exception -> 0x08fc, blocks: (B:83:0x03a2, B:85:0x03a6, B:87:0x03a9, B:88:0x03ac, B:90:0x03b9, B:92:0x03bd, B:94:0x03c0, B:95:0x03c2, B:98:0x03e0, B:99:0x03e3, B:100:0x03e6, B:102:0x03f0, B:104:0x03f6, B:105:0x0416, B:109:0x0425, B:112:0x0433, B:115:0x049d, B:273:0x089e, B:278:0x08ae, B:281:0x08be, B:283:0x08c4, B:285:0x08de, B:287:0x08eb, B:290:0x08e4, B:231:0x077e, B:233:0x0784, B:170:0x084f, B:174:0x088b, B:179:0x0868, B:185:0x0875, B:215:0x084b, B:226:0x0890, B:227:0x0893, B:143:0x05cc, B:145:0x05d2, B:426:0x0490, B:428:0x0496), top: B:82:0x03a2, outer: #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0784 A[Catch: all -> 0x08f9, Exception -> 0x08fc, TRY_LEAVE, TryCatch #21 {Exception -> 0x08fc, blocks: (B:83:0x03a2, B:85:0x03a6, B:87:0x03a9, B:88:0x03ac, B:90:0x03b9, B:92:0x03bd, B:94:0x03c0, B:95:0x03c2, B:98:0x03e0, B:99:0x03e3, B:100:0x03e6, B:102:0x03f0, B:104:0x03f6, B:105:0x0416, B:109:0x0425, B:112:0x0433, B:115:0x049d, B:273:0x089e, B:278:0x08ae, B:281:0x08be, B:283:0x08c4, B:285:0x08de, B:287:0x08eb, B:290:0x08e4, B:231:0x077e, B:233:0x0784, B:170:0x084f, B:174:0x088b, B:179:0x0868, B:185:0x0875, B:215:0x084b, B:226:0x0890, B:227:0x0893, B:143:0x05cc, B:145:0x05d2, B:426:0x0490, B:428:0x0496), top: B:82:0x03a2, outer: #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0694 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x08ac  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x08ae A[Catch: all -> 0x08f9, Exception -> 0x08fc, TryCatch #21 {Exception -> 0x08fc, blocks: (B:83:0x03a2, B:85:0x03a6, B:87:0x03a9, B:88:0x03ac, B:90:0x03b9, B:92:0x03bd, B:94:0x03c0, B:95:0x03c2, B:98:0x03e0, B:99:0x03e3, B:100:0x03e6, B:102:0x03f0, B:104:0x03f6, B:105:0x0416, B:109:0x0425, B:112:0x0433, B:115:0x049d, B:273:0x089e, B:278:0x08ae, B:281:0x08be, B:283:0x08c4, B:285:0x08de, B:287:0x08eb, B:290:0x08e4, B:231:0x077e, B:233:0x0784, B:170:0x084f, B:174:0x088b, B:179:0x0868, B:185:0x0875, B:215:0x084b, B:226:0x0890, B:227:0x0893, B:143:0x05cc, B:145:0x05d2, B:426:0x0490, B:428:0x0496), top: B:82:0x03a2, outer: #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x05ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h() {
        int i3;
        String str;
        Exception exc;
        long j3;
        boolean z16;
        long j16;
        int i16;
        int i17;
        boolean z17;
        char c16;
        boolean z18;
        int i18;
        Exception exc2;
        boolean z19;
        int i19;
        int i26;
        int i27;
        Exception exc3;
        int length;
        long j17;
        long j18;
        char c17;
        char c18;
        boolean z26;
        long j19;
        long j26;
        long j27;
        char c19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f249152g = false;
        if (this.f249148c == null) {
            a(g.a.f249237k, true);
            com.tencent.mobileqq.msf.core.net.t.g.a();
            return;
        }
        c();
        g gVar = this.f249164s;
        gVar.f249201a = g.b.f249253a;
        com.tencent.msf.service.protocol.push.h.d dVar = this.f249148c;
        gVar.f249218r = dVar.f336591a;
        gVar.f249219s = dVar.f336593c;
        gVar.f249220t = dVar.f336594d;
        gVar.f249221u = new ArrayList();
        this.f249164s.f249221u.add(Long.valueOf(this.f249148c.f336596f));
        g gVar2 = this.f249164s;
        gVar2.f249223w = this.f249148c.f336598h;
        gVar2.B = r8.f336605o;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" cProtoType:");
            sb5.append((int) this.f249148c.f336591a);
            sb5.append(" PkgInterval:");
            sb5.append(this.f249148c.f336594d);
            sb5.append(" IpPort.size():");
            sb5.append(this.f249148c.f336592b.size());
            sb5.append(" PkgNum:");
            sb5.append(this.f249148c.f336593c);
            sb5.append(" HeadData.length:");
            byte[] bArr = this.f249148c.f336597g;
            sb5.append(bArr != null ? Integer.valueOf(bArr.length) : "null");
            sb5.append(" TailData.length:");
            byte[] bArr2 = this.f249148c.f336606p;
            sb5.append(bArr2 != null ? Integer.valueOf(bArr2.length) : "null");
            sb5.append(" RepeatTimes:");
            sb5.append(this.f249148c.f336596f);
            sb5.append(" PkgData.length:");
            byte[] bArr3 = this.f249148c.f336595e;
            sb5.append(bArr3 != null ? Integer.valueOf(bArr3.length) : "null");
            sb5.append(" cDomainToIpMode:");
            sb5.append((int) this.f249148c.f336608r);
            sb5.append(" dwTaskType:");
            sb5.append(this.f249148c.f336600j);
            sb5.append(" dwTaskTime:");
            sb5.append(this.f249148c.f336601k);
            sb5.append(" dwReserved1:");
            sb5.append(this.f249148c.f336602l);
            sb5.append(" dwReserved2:");
            sb5.append(this.f249148c.f336603m);
            sb5.append(" dwRecvLen:");
            sb5.append(this.f249148c.f336604n);
            sb5.append(" cTestType:");
            sb5.append((int) this.f249148c.f336605o);
            sb5.append(" strUserInfo:");
            sb5.append(this.f249148c.f336611u);
            sb5.append(" strDnsSrvIp:");
            sb5.append(this.f249165t.f249193j);
            sb5.append(" dwLocationTime:");
            sb5.append(this.f249165t.f249195l);
            sb5.append(" strAxis:");
            sb5.append(this.f249165t.f249196m);
            sb5.append(" sPkgData:");
            sb5.append(Arrays.toString(this.f249148c.f336595e));
            sb5.append(" cHttpsFunction");
            sb5.append((int) this.f249148c.f336615y);
            QLog.d("MSF.C.QualityTestManager", 2, sb5.toString());
        }
        int i28 = this.f249150e;
        if (i28 <= 1) {
            if (i28 == 1) {
                com.tencent.msf.service.protocol.push.h.d dVar2 = this.f249148c;
                if ((dVar2.f336603m & 255) == 1) {
                    i3 = i28;
                } else if (dVar2.f336592b.size() > 75) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
                    }
                    this.f249168w = false;
                    a(g.a.f249239m, true);
                    com.tencent.mobileqq.msf.core.net.t.g.a();
                    return;
                }
            } else {
                i3 = i28;
            }
            if (i3 == 1) {
                com.tencent.msf.service.protocol.push.h.d dVar3 = this.f249148c;
                if ((dVar3.f336603m & 255) == 1 && dVar3.f336592b.size() > 200) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much for WiFi test, return ");
                    }
                    this.f249168w = false;
                    a(g.a.f249239m, true);
                    com.tencent.mobileqq.msf.core.net.t.g.a();
                    return;
                }
            }
        } else if (this.f249148c.f336592b.size() > 200) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much for WiFi test, return ");
            }
            this.f249168w = false;
            a(g.a.f249239m, true);
            com.tencent.mobileqq.msf.core.net.t.g.a();
            return;
        }
        if (this.f249148c.f336592b.size() <= 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
            }
            a(g.a.f249240n, true);
            com.tencent.mobileqq.msf.core.net.t.g.a();
            return;
        }
        com.tencent.msf.service.protocol.push.h.d dVar4 = this.f249148c;
        String str2 = "IPPort size too much, return ";
        if (dVar4.f336596f <= 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "dwRepeatTimes must > 0");
            }
            a(g.a.f249243q, true);
            com.tencent.mobileqq.msf.core.net.t.g.a();
            return;
        }
        int i29 = 1;
        int i36 = this.f249150e;
        if (i36 <= 1) {
            if (i36 == 1) {
                if ((dVar4.f336603m & 255) == 1) {
                    i29 = 1;
                } else if (dVar4.f336593c > 20) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
                    }
                    this.f249168w = false;
                    a(g.a.f249238l, true);
                    com.tencent.mobileqq.msf.core.net.t.g.a();
                    return;
                }
            }
            if (i36 == i29 && (dVar4.f336603m & 255) == 1 && dVar4.f336593c > 50) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much for WiFi test, return ");
                }
                this.f249168w = false;
                a(g.a.f249238l, true);
                com.tencent.mobileqq.msf.core.net.t.g.a();
                return;
            }
        } else if (dVar4.f336593c > 50) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much for WiFi test, return ");
            }
            this.f249168w = false;
            a(g.a.f249238l, true);
            com.tencent.mobileqq.msf.core.net.t.g.a();
            return;
        }
        char c26 = '\b';
        if (((dVar4.f336603m >> 8) & 255) > 20) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "dwReserved2>>8 &0xFF too much, return ");
            }
            this.f249168w = false;
            a(g.a.f249238l, true);
            com.tencent.mobileqq.msf.core.net.t.g.a();
            return;
        }
        if (dVar4.f336598h * 1000 < System.currentTimeMillis()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg expired, stop test qualityTestMsg.dwExpirTime:" + this.f249148c.f336598h + "System.currentTimeMillis():" + System.currentTimeMillis());
            }
            a(g.a.f249236j, true);
            com.tencent.mobileqq.msf.core.net.t.g.a();
            return;
        }
        com.tencent.msf.service.protocol.push.h.d dVar5 = this.f249148c;
        short s16 = dVar5.f336605o;
        if (s16 != 0 && 1 != s16 && 2 != s16) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.QualityTestManager", 2, "qualityTestMsg.cTestType " + ((int) this.f249148c.f336605o) + " NoSupport");
            }
            a(g.a.f249249w, true);
            com.tencent.mobileqq.msf.core.net.t.g.a();
            return;
        }
        try {
            try {
                byte[] bArr4 = dVar5.f336597g;
                long length2 = (bArr4 == null || bArr4.length <= 0) ? 0 : bArr4.length;
                long length3 = dVar5.f336595e.length;
                long j28 = dVar5.f336596f;
                Long.signum(length3);
                int i37 = (int) (length2 + (length3 * j28));
                byte[] bArr5 = dVar5.f336606p;
                if (bArr5 != null && bArr5.length > 0) {
                    i37 += bArr5.length;
                }
                QLog.d("MSF.C.QualityTestManager", 1, "allbodylength " + i37);
                if (this.f249147b == d.f249177c) {
                    if (i37 == 0) {
                        this.f249158m = 1;
                    } else {
                        this.f249158m = 0;
                    }
                }
                if (this.f249148c.f336594d >= 10) {
                    int i38 = 0;
                    boolean z27 = false;
                    while (true) {
                        if (i38 >= this.f249148c.f336592b.size() || z27) {
                            break;
                        }
                        this.f249164s.f249225y = new ArrayList();
                        g gVar3 = this.f249164s;
                        gVar3.f249211k = 0;
                        gVar3.f249214n = 0;
                        gVar3.f249212l = 0;
                        gVar3.f249213m = 0;
                        gVar3.f249215o = 0;
                        gVar3.f249203c.clear();
                        g gVar4 = this.f249164s;
                        gVar4.f249224x = false;
                        gVar4.A = null;
                        gVar4.I.clear();
                        this.f249164s.J.clear();
                        g gVar5 = this.f249164s;
                        gVar5.f249204d = null;
                        gVar5.D = 0L;
                        gVar5.E = 0;
                        gVar5.F = 0;
                        gVar5.G = 0;
                        try {
                            gVar5.f249207g = NetConnInfoCenter.getSystemNetworkType();
                            this.f249164s.f249208h = NetConnInfoCenter.getWifiStrength();
                            this.f249164s.f249210j = NetConnInfoCenter.getCdmaStrength();
                            this.f249164s.f249209i = NetConnInfoCenter.getGsmStrength();
                        } catch (Exception unused) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d("MSF.C.QualityTestManager", 4, "failed to get network strength");
                            }
                        }
                        this.G = 0L;
                        this.I = 0L;
                        this.H = 0L;
                        this.J = 0L;
                        int i39 = -1;
                        try {
                        } catch (Exception e16) {
                            e = e16;
                            str = str2;
                        }
                        if (NetConnInfoCenter.isWifiConn()) {
                            try {
                            } catch (Exception e17) {
                                exc = e17;
                                str = str2;
                            }
                            if (NetConnInfoCenter.getWifiStrength() > 10) {
                                if (com.tencent.mobileqq.msf.core.net.t.g.f249397e.equals("NotWiFi") && this.f249151f != 0) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + Thread.currentThread().getName());
                                    }
                                } else {
                                    com.tencent.msf.service.protocol.push.h.d dVar6 = this.f249148c;
                                    j19 = dVar6.f336603m;
                                    if ((j19 & 255) == 1) {
                                        int i46 = this.f249150e;
                                        if (i46 > 1) {
                                            j26 = dVar6.f336593c / i46;
                                        } else {
                                            c19 = c26;
                                            str = str2;
                                            j3 = (j19 >> c19) & 255;
                                            z16 = z27;
                                            j16 = j3;
                                            boolean z28 = 1;
                                            String str3 = str;
                                            i16 = i38;
                                            i17 = 0;
                                            while (i17 < j16 && i16 != i39) {
                                                try {
                                                } catch (Exception e18) {
                                                    e = e18;
                                                    z17 = z16;
                                                }
                                                if (NetConnInfoCenter.isWifiConn()) {
                                                    try {
                                                    } catch (Exception e19) {
                                                        e = e19;
                                                        z17 = z16;
                                                    }
                                                    if (NetConnInfoCenter.getWifiStrength() > 10) {
                                                        if (com.tencent.mobileqq.msf.core.net.t.g.f249397e.equals("NotWiFi")) {
                                                            try {
                                                                if (this.f249151f != 0) {
                                                                    try {
                                                                        i16 = this.f249148c.f336592b.size();
                                                                        if (QLog.isColorLevel()) {
                                                                            QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + this.f249151f);
                                                                        }
                                                                        c16 = '\b';
                                                                        z18 = false;
                                                                        z17 = true;
                                                                    } catch (Exception e26) {
                                                                        exc2 = e26;
                                                                        i18 = 0;
                                                                        z17 = true;
                                                                        if (QLog.isDevelopLevel()) {
                                                                        }
                                                                        boolean z29 = z17;
                                                                        this.f249169x = 0L;
                                                                        this.f249170y = 0L;
                                                                        this.f249171z = 0L;
                                                                        this.A = 0L;
                                                                        this.B = 0L;
                                                                        this.C = 0L;
                                                                        this.D = 0L;
                                                                        this.E = 0L;
                                                                        b(this.f249148c.f336592b.get(i16));
                                                                        if ((this.f249148c.f336608r & 2) != 2) {
                                                                        }
                                                                        a();
                                                                        i19 = i18;
                                                                        i26 = 1;
                                                                        i17 += i26;
                                                                        z16 = z19;
                                                                        i39 = -1;
                                                                        z28 = i19;
                                                                    }
                                                                }
                                                            } catch (Exception e27) {
                                                                exc2 = e27;
                                                                z17 = z16;
                                                                i18 = 0;
                                                                if (QLog.isDevelopLevel()) {
                                                                }
                                                                boolean z292 = z17;
                                                                this.f249169x = 0L;
                                                                this.f249170y = 0L;
                                                                this.f249171z = 0L;
                                                                this.A = 0L;
                                                                this.B = 0L;
                                                                this.C = 0L;
                                                                this.D = 0L;
                                                                this.E = 0L;
                                                                b(this.f249148c.f336592b.get(i16));
                                                                if ((this.f249148c.f336608r & 2) != 2) {
                                                                }
                                                                a();
                                                                i19 = i18;
                                                                i26 = 1;
                                                                i17 += i26;
                                                                z16 = z19;
                                                                i39 = -1;
                                                                z28 = i19;
                                                            }
                                                        }
                                                        com.tencent.msf.service.protocol.push.h.d dVar7 = this.f249148c;
                                                        z17 = z16;
                                                        try {
                                                            try {
                                                                j17 = dVar7.f336603m;
                                                            } catch (Exception e28) {
                                                                e = e28;
                                                                exc2 = e;
                                                                i18 = 0;
                                                                if (QLog.isDevelopLevel()) {
                                                                }
                                                                boolean z2922 = z17;
                                                                this.f249169x = 0L;
                                                                this.f249170y = 0L;
                                                                this.f249171z = 0L;
                                                                this.A = 0L;
                                                                this.B = 0L;
                                                                this.C = 0L;
                                                                this.D = 0L;
                                                                this.E = 0L;
                                                                b(this.f249148c.f336592b.get(i16));
                                                                if ((this.f249148c.f336608r & 2) != 2) {
                                                                }
                                                                a();
                                                                i19 = i18;
                                                                i26 = 1;
                                                                i17 += i26;
                                                                z16 = z19;
                                                                i39 = -1;
                                                                z28 = i19;
                                                            }
                                                            if ((j17 & 255) == 1) {
                                                                int i47 = this.f249150e;
                                                                if (i47 > 1) {
                                                                    j18 = dVar7.f336593c / i47;
                                                                } else {
                                                                    c17 = '\b';
                                                                    i18 = 0;
                                                                    j18 = (j17 >> c17) & 255;
                                                                    j16 = j18;
                                                                    boolean z29222 = z17;
                                                                    this.f249169x = 0L;
                                                                    this.f249170y = 0L;
                                                                    this.f249171z = 0L;
                                                                    this.A = 0L;
                                                                    this.B = 0L;
                                                                    this.C = 0L;
                                                                    this.D = 0L;
                                                                    this.E = 0L;
                                                                    b(this.f249148c.f336592b.get(i16));
                                                                    if ((this.f249148c.f336608r & 2) != 2) {
                                                                        a(g.a.f249252z);
                                                                        z19 = z29222;
                                                                        try {
                                                                            this.f249164s.f249219s = 0L;
                                                                        } catch (Exception e29) {
                                                                            e = e29;
                                                                            exc3 = e;
                                                                            i27 = z28;
                                                                            QLog.d("MSF.C.QualityTestManager", 1, "QualityClient:  error:", exc3);
                                                                            exc3.printStackTrace();
                                                                            a();
                                                                            i19 = i27;
                                                                            try {
                                                                                LockMethodProxy.sleep(this.f249148c.f336594d);
                                                                                i19 = i19;
                                                                                i26 = 1;
                                                                            } catch (Exception e36) {
                                                                                i26 = 1;
                                                                                QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: Thread sleep error " + e36);
                                                                            }
                                                                            i17 += i26;
                                                                            z16 = z19;
                                                                            i39 = -1;
                                                                            z28 = i19;
                                                                        }
                                                                    } else {
                                                                        z19 = z29222;
                                                                        boolean a16 = a(i37);
                                                                        com.tencent.msf.service.protocol.push.h.d dVar8 = this.f249148c;
                                                                        byte[] a17 = a(i37, dVar8.f336597g, dVar8.f336606p);
                                                                        if (!a(this.f249148c.f336592b.get(i16))) {
                                                                            if (QLog.isDevelopLevel()) {
                                                                                QLog.d("MSF.C.QualityTestManager", 4, "connectToServer error, return ");
                                                                            }
                                                                            try {
                                                                                this.f249164s.J.add(-1L);
                                                                                a(g.a.f249229c);
                                                                            } catch (Exception e37) {
                                                                                exc3 = e37;
                                                                                i27 = i18;
                                                                                QLog.d("MSF.C.QualityTestManager", 1, "QualityClient:  error:", exc3);
                                                                                exc3.printStackTrace();
                                                                                a();
                                                                                i19 = i27;
                                                                                LockMethodProxy.sleep(this.f249148c.f336594d);
                                                                                i19 = i19;
                                                                                i26 = 1;
                                                                                i17 += i26;
                                                                                z16 = z19;
                                                                                i39 = -1;
                                                                                z28 = i19;
                                                                            }
                                                                        } else if (a16 && a17 != null) {
                                                                            if ((this.f249147b != d.f249177c || this.f249158m == 0) && !b(a17)) {
                                                                                this.f249164s.J.add(-1L);
                                                                            } else {
                                                                                com.tencent.msf.service.protocol.push.h.d dVar9 = this.f249148c;
                                                                                short s17 = dVar9.f336605o;
                                                                                if (s17 != 0 && 1 != s17) {
                                                                                    length = 2 == s17 ? (int) dVar9.f336604n : i18;
                                                                                    if (a(length, a17)) {
                                                                                        a();
                                                                                        i19 = z28;
                                                                                        LockMethodProxy.sleep(this.f249148c.f336594d);
                                                                                        i19 = i19;
                                                                                        i26 = 1;
                                                                                        i17 += i26;
                                                                                        z16 = z19;
                                                                                        i39 = -1;
                                                                                        z28 = i19;
                                                                                    }
                                                                                }
                                                                                length = a17.length;
                                                                                if (a(length, a17)) {
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    a();
                                                                    i19 = i18;
                                                                    i26 = 1;
                                                                    i17 += i26;
                                                                    z16 = z19;
                                                                    i39 = -1;
                                                                    z28 = i19;
                                                                }
                                                            } else {
                                                                j18 = dVar7.f336593c;
                                                            }
                                                            this.f249169x = 0L;
                                                            this.f249170y = 0L;
                                                            this.f249171z = 0L;
                                                            this.A = 0L;
                                                            this.B = 0L;
                                                            this.C = 0L;
                                                            this.D = 0L;
                                                            this.E = 0L;
                                                            b(this.f249148c.f336592b.get(i16));
                                                            if ((this.f249148c.f336608r & 2) != 2) {
                                                            }
                                                            a();
                                                            i19 = i18;
                                                            i26 = 1;
                                                            i17 += i26;
                                                            z16 = z19;
                                                            i39 = -1;
                                                            z28 = i19;
                                                        } catch (Throwable th5) {
                                                            a();
                                                            throw th5;
                                                        }
                                                        i18 = 0;
                                                        j16 = j18;
                                                        boolean z292222 = z17;
                                                    }
                                                }
                                                z17 = z16;
                                                com.tencent.mobileqq.msf.core.net.t.g.f249397e = "NotWiFi";
                                                com.tencent.msf.service.protocol.push.h.d dVar10 = this.f249148c;
                                                j17 = dVar10.f336603m;
                                                if ((j17 & 255) == 1) {
                                                    i18 = 0;
                                                    try {
                                                        j18 = dVar10.f336593c;
                                                        j16 = j18;
                                                    } catch (Exception e38) {
                                                        e = e38;
                                                        exc2 = e;
                                                        if (QLog.isDevelopLevel()) {
                                                        }
                                                        boolean z2922222 = z17;
                                                        this.f249169x = 0L;
                                                        this.f249170y = 0L;
                                                        this.f249171z = 0L;
                                                        this.A = 0L;
                                                        this.B = 0L;
                                                        this.C = 0L;
                                                        this.D = 0L;
                                                        this.E = 0L;
                                                        b(this.f249148c.f336592b.get(i16));
                                                        if ((this.f249148c.f336608r & 2) != 2) {
                                                        }
                                                        a();
                                                        i19 = i18;
                                                        i26 = 1;
                                                        i17 += i26;
                                                        z16 = z19;
                                                        i39 = -1;
                                                        z28 = i19;
                                                    }
                                                    boolean z29222222 = z17;
                                                    this.f249169x = 0L;
                                                    this.f249170y = 0L;
                                                    this.f249171z = 0L;
                                                    this.A = 0L;
                                                    this.B = 0L;
                                                    this.C = 0L;
                                                    this.D = 0L;
                                                    this.E = 0L;
                                                    b(this.f249148c.f336592b.get(i16));
                                                    if ((this.f249148c.f336608r & 2) != 2) {
                                                    }
                                                    a();
                                                    i19 = i18;
                                                    i26 = 1;
                                                    i17 += i26;
                                                    z16 = z19;
                                                    i39 = -1;
                                                    z28 = i19;
                                                } else {
                                                    try {
                                                    } catch (Exception e39) {
                                                        e = e39;
                                                        i18 = 0;
                                                        exc2 = e;
                                                        if (QLog.isDevelopLevel()) {
                                                        }
                                                        boolean z292222222 = z17;
                                                        this.f249169x = 0L;
                                                        this.f249170y = 0L;
                                                        this.f249171z = 0L;
                                                        this.A = 0L;
                                                        this.B = 0L;
                                                        this.C = 0L;
                                                        this.D = 0L;
                                                        this.E = 0L;
                                                        b(this.f249148c.f336592b.get(i16));
                                                        if ((this.f249148c.f336608r & 2) != 2) {
                                                        }
                                                        a();
                                                        i19 = i18;
                                                        i26 = 1;
                                                        i17 += i26;
                                                        z16 = z19;
                                                        i39 = -1;
                                                        z28 = i19;
                                                    }
                                                    if (this.f249150e > 1) {
                                                        try {
                                                            if (this.f249151f != 0) {
                                                                try {
                                                                    i16 = dVar10.f336592b.size();
                                                                    if (QLog.isColorLevel()) {
                                                                        QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + this.f249151f);
                                                                    }
                                                                    c16 = '\b';
                                                                    z18 = false;
                                                                    z17 = true;
                                                                } catch (Exception e46) {
                                                                    exc2 = e46;
                                                                    i18 = 0;
                                                                    z17 = true;
                                                                    if (QLog.isDevelopLevel()) {
                                                                    }
                                                                    boolean z2922222222 = z17;
                                                                    this.f249169x = 0L;
                                                                    this.f249170y = 0L;
                                                                    this.f249171z = 0L;
                                                                    this.A = 0L;
                                                                    this.B = 0L;
                                                                    this.C = 0L;
                                                                    this.D = 0L;
                                                                    this.E = 0L;
                                                                    b(this.f249148c.f336592b.get(i16));
                                                                    if ((this.f249148c.f336608r & 2) != 2) {
                                                                    }
                                                                    a();
                                                                    i19 = i18;
                                                                    i26 = 1;
                                                                    i17 += i26;
                                                                    z16 = z19;
                                                                    i39 = -1;
                                                                    z28 = i19;
                                                                }
                                                            } else {
                                                                try {
                                                                    this.f249150e = 1;
                                                                    c18 = 'K';
                                                                    if (dVar10.f336592b.size() > 75) {
                                                                        try {
                                                                            if (QLog.isDevelopLevel()) {
                                                                                QLog.d("MSF.C.QualityTestManager", 4, str3);
                                                                            }
                                                                            int indexOf = this.f249162q.indexOf("#");
                                                                            if (indexOf != -1) {
                                                                                this.f249162q = this.f249162q.substring(0, indexOf + 1);
                                                                            }
                                                                            this.f249164s.f249203c.clear();
                                                                            this.f249168w = false;
                                                                            a(g.a.f249239m, true);
                                                                            com.tencent.mobileqq.msf.core.net.t.g.a();
                                                                            com.tencent.mobileqq.msf.core.net.t.g.a();
                                                                            return;
                                                                        } catch (Exception e47) {
                                                                            exc2 = e47;
                                                                            i17 = 0;
                                                                            i16 = -1;
                                                                            i18 = 0;
                                                                            if (QLog.isDevelopLevel()) {
                                                                            }
                                                                            boolean z29222222222 = z17;
                                                                            this.f249169x = 0L;
                                                                            this.f249170y = 0L;
                                                                            this.f249171z = 0L;
                                                                            this.A = 0L;
                                                                            this.B = 0L;
                                                                            this.C = 0L;
                                                                            this.D = 0L;
                                                                            this.E = 0L;
                                                                            b(this.f249148c.f336592b.get(i16));
                                                                            if ((this.f249148c.f336608r & 2) != 2) {
                                                                            }
                                                                            a();
                                                                            i19 = i18;
                                                                            i26 = 1;
                                                                            i17 += i26;
                                                                            z16 = z19;
                                                                            i39 = -1;
                                                                            z28 = i19;
                                                                        }
                                                                    } else {
                                                                        try {
                                                                            j16 = (this.f249148c.f336603m >> 8) & 255;
                                                                            int indexOf2 = this.f249162q.indexOf("#");
                                                                            if (indexOf2 != -1) {
                                                                                z26 = false;
                                                                                try {
                                                                                    this.f249162q = this.f249162q.substring(0, indexOf2 + 1);
                                                                                } catch (Exception e48) {
                                                                                    e = e48;
                                                                                    exc2 = e;
                                                                                    i17 = z26;
                                                                                    i18 = i17;
                                                                                    i16 = -1;
                                                                                    if (QLog.isDevelopLevel()) {
                                                                                        QLog.d("MSF.C.QualityTestManager", 4, "net change caused quality test error", exc2);
                                                                                    }
                                                                                    boolean z292222222222 = z17;
                                                                                    this.f249169x = 0L;
                                                                                    this.f249170y = 0L;
                                                                                    this.f249171z = 0L;
                                                                                    this.A = 0L;
                                                                                    this.B = 0L;
                                                                                    this.C = 0L;
                                                                                    this.D = 0L;
                                                                                    this.E = 0L;
                                                                                    b(this.f249148c.f336592b.get(i16));
                                                                                    if ((this.f249148c.f336608r & 2) != 2) {
                                                                                    }
                                                                                    a();
                                                                                    i19 = i18;
                                                                                    i26 = 1;
                                                                                    i17 += i26;
                                                                                    z16 = z19;
                                                                                    i39 = -1;
                                                                                    z28 = i19;
                                                                                }
                                                                            } else {
                                                                                z26 = false;
                                                                            }
                                                                            z18 = z26;
                                                                            i16 = -1;
                                                                            c16 = '\b';
                                                                            break;
                                                                        } catch (Exception e49) {
                                                                            e = e49;
                                                                            z26 = false;
                                                                            exc2 = e;
                                                                            i17 = z26;
                                                                            i18 = i17;
                                                                            i16 = -1;
                                                                            if (QLog.isDevelopLevel()) {
                                                                            }
                                                                            boolean z2922222222222 = z17;
                                                                            this.f249169x = 0L;
                                                                            this.f249170y = 0L;
                                                                            this.f249171z = 0L;
                                                                            this.A = 0L;
                                                                            this.B = 0L;
                                                                            this.C = 0L;
                                                                            this.D = 0L;
                                                                            this.E = 0L;
                                                                            b(this.f249148c.f336592b.get(i16));
                                                                            if ((this.f249148c.f336608r & 2) != 2) {
                                                                            }
                                                                            a();
                                                                            i19 = i18;
                                                                            i26 = 1;
                                                                            i17 += i26;
                                                                            z16 = z19;
                                                                            i39 = -1;
                                                                            z28 = i19;
                                                                        }
                                                                    }
                                                                } catch (Exception e56) {
                                                                    e = e56;
                                                                    c18 = 'K';
                                                                }
                                                            }
                                                        } catch (Exception e57) {
                                                            exc2 = e57;
                                                        }
                                                    } else {
                                                        i18 = 0;
                                                        c17 = '\b';
                                                        j18 = (j17 >> c17) & 255;
                                                        j16 = j18;
                                                        boolean z29222222222222 = z17;
                                                        this.f249169x = 0L;
                                                        this.f249170y = 0L;
                                                        this.f249171z = 0L;
                                                        this.A = 0L;
                                                        this.B = 0L;
                                                        this.C = 0L;
                                                        this.D = 0L;
                                                        this.E = 0L;
                                                        b(this.f249148c.f336592b.get(i16));
                                                        if ((this.f249148c.f336608r & 2) != 2) {
                                                        }
                                                        a();
                                                        i19 = i18;
                                                        i26 = 1;
                                                        i17 += i26;
                                                        z16 = z19;
                                                        i39 = -1;
                                                        z28 = i19;
                                                    }
                                                }
                                            }
                                            z17 = z16;
                                            c16 = '\b';
                                            z18 = false;
                                            this.f249164s.f249225y.add(Integer.valueOf(i37));
                                            if (i16 != -1) {
                                                boolean z36 = i16 == this.f249148c.f336592b.size() - 1 ? true : z18;
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("MSF.C.QualityTestManager", 2, "testsuccess: " + z28);
                                                }
                                                if (z28 != 0) {
                                                    a(g.a.f249227a, z36);
                                                } else {
                                                    a(g.a.f249228b, z36);
                                                }
                                                if (z36) {
                                                    this.f249152g = true;
                                                }
                                            }
                                            i38 = i16 + 1;
                                            str2 = str3;
                                            c26 = c16;
                                            z27 = z17;
                                        }
                                    } else {
                                        j26 = dVar6.f336593c;
                                    }
                                    j27 = j26;
                                    str = str2;
                                    j3 = j27;
                                    z16 = z27;
                                    j16 = j3;
                                    boolean z282 = 1;
                                    String str32 = str;
                                    i16 = i38;
                                    i17 = 0;
                                    while (i17 < j16) {
                                        if (NetConnInfoCenter.isWifiConn()) {
                                        }
                                        z17 = z16;
                                        com.tencent.mobileqq.msf.core.net.t.g.f249397e = "NotWiFi";
                                        com.tencent.msf.service.protocol.push.h.d dVar102 = this.f249148c;
                                        j17 = dVar102.f336603m;
                                        if ((j17 & 255) == 1) {
                                        }
                                    }
                                    z17 = z16;
                                    c16 = '\b';
                                    z18 = false;
                                    this.f249164s.f249225y.add(Integer.valueOf(i37));
                                    if (i16 != -1) {
                                    }
                                    i38 = i16 + 1;
                                    str2 = str32;
                                    c26 = c16;
                                    z27 = z17;
                                }
                            }
                        }
                        com.tencent.mobileqq.msf.core.net.t.g.f249397e = "NotWiFi";
                        com.tencent.msf.service.protocol.push.h.d dVar11 = this.f249148c;
                        j19 = dVar11.f336603m;
                        if ((j19 & 255) == 1) {
                            if (this.f249150e > 1) {
                                if (this.f249151f != 0) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + Thread.currentThread().getName());
                                    }
                                } else {
                                    try {
                                        this.f249150e = 1;
                                    } catch (Exception e58) {
                                        e = e58;
                                        str = str2;
                                    }
                                    if (dVar11.f336592b.size() > 75) {
                                        str = str2;
                                        if (QLog.isDevelopLevel()) {
                                            QLog.d("MSF.C.QualityTestManager", 4, str);
                                        }
                                        int indexOf3 = this.f249162q.indexOf("#");
                                        if (indexOf3 != -1) {
                                            this.f249162q = this.f249162q.substring(0, indexOf3 + 1);
                                        }
                                        this.f249164s.f249203c.clear();
                                        this.f249168w = false;
                                        a(g.a.f249239m, true);
                                        com.tencent.mobileqq.msf.core.net.t.g.a();
                                        com.tencent.mobileqq.msf.core.net.t.g.a();
                                        return;
                                    }
                                    str = str2;
                                    try {
                                        j3 = (this.f249148c.f336603m >> 8) & 255;
                                        try {
                                            int indexOf4 = this.f249162q.indexOf("#");
                                            if (indexOf4 != -1) {
                                                this.f249162q = this.f249162q.substring(0, indexOf4 + 1);
                                            }
                                            i38 = -1;
                                        } catch (Exception e59) {
                                            exc = e59;
                                            i38 = -1;
                                        }
                                    } catch (Exception e65) {
                                        e = e65;
                                    }
                                    z16 = z27;
                                    j16 = j3;
                                    boolean z2822 = 1;
                                    String str322 = str;
                                    i16 = i38;
                                    i17 = 0;
                                    while (i17 < j16) {
                                    }
                                    z17 = z16;
                                    c16 = '\b';
                                    z18 = false;
                                    this.f249164s.f249225y.add(Integer.valueOf(i37));
                                    if (i16 != -1) {
                                    }
                                    i38 = i16 + 1;
                                    str2 = str322;
                                    c26 = c16;
                                    z27 = z17;
                                    e = e65;
                                    exc = e;
                                    i38 = -1;
                                    j3 = 1;
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("MSF.C.QualityTestManager", 4, "net change caused quality test error", exc);
                                    }
                                    z16 = z27;
                                    j16 = j3;
                                    boolean z28222 = 1;
                                    String str3222 = str;
                                    i16 = i38;
                                    i17 = 0;
                                    while (i17 < j16) {
                                    }
                                    z17 = z16;
                                    c16 = '\b';
                                    z18 = false;
                                    this.f249164s.f249225y.add(Integer.valueOf(i37));
                                    if (i16 != -1) {
                                    }
                                    i38 = i16 + 1;
                                    str2 = str3222;
                                    c26 = c16;
                                    z27 = z17;
                                }
                            } else {
                                str = str2;
                                c19 = '\b';
                                j3 = (j19 >> c19) & 255;
                                z16 = z27;
                                j16 = j3;
                                boolean z282222 = 1;
                                String str32222 = str;
                                i16 = i38;
                                i17 = 0;
                                while (i17 < j16) {
                                }
                                z17 = z16;
                                c16 = '\b';
                                z18 = false;
                                this.f249164s.f249225y.add(Integer.valueOf(i37));
                                if (i16 != -1) {
                                }
                                i38 = i16 + 1;
                                str2 = str32222;
                                c26 = c16;
                                z27 = z17;
                            }
                        } else {
                            str = str2;
                            try {
                                j27 = dVar11.f336593c;
                                j3 = j27;
                            } catch (Exception e66) {
                                e = e66;
                                exc = e;
                                j3 = 1;
                                if (QLog.isDevelopLevel()) {
                                }
                                z16 = z27;
                                j16 = j3;
                                boolean z2822222 = 1;
                                String str322222 = str;
                                i16 = i38;
                                i17 = 0;
                                while (i17 < j16) {
                                }
                                z17 = z16;
                                c16 = '\b';
                                z18 = false;
                                this.f249164s.f249225y.add(Integer.valueOf(i37));
                                if (i16 != -1) {
                                }
                                i38 = i16 + 1;
                                str2 = str322222;
                                c26 = c16;
                                z27 = z17;
                            }
                            z16 = z27;
                            j16 = j3;
                            boolean z28222222 = 1;
                            String str3222222 = str;
                            i16 = i38;
                            i17 = 0;
                            while (i17 < j16) {
                            }
                            z17 = z16;
                            c16 = '\b';
                            z18 = false;
                            this.f249164s.f249225y.add(Integer.valueOf(i37));
                            if (i16 != -1) {
                            }
                            i38 = i16 + 1;
                            str2 = str3222222;
                            c26 = c16;
                            z27 = z17;
                        }
                    }
                } else {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgInterval too small " + this.f249148c.f336594d + " return ");
                    }
                    a(g.a.f249233g, true);
                    com.tencent.mobileqq.msf.core.net.t.g.a();
                    com.tencent.mobileqq.msf.core.net.t.g.a();
                    return;
                }
            } catch (Exception e67) {
                QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: error ", e67);
            }
        } catch (Throwable th6) {
            com.tencent.mobileqq.msf.core.net.t.g.a();
            throw th6;
        }
        com.tencent.mobileqq.msf.core.net.t.g.a();
    }

    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        h();
        if (this.f249152g) {
            return this.f249162q;
        }
        return "";
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        try {
            if (this.f249148c != null) {
                switch (b.f249173a[this.f249147b.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        h();
                        return;
                    case 5:
                    case 6:
                        g();
                        return;
                    default:
                        return;
                }
            }
            if (this.f249149d != null) {
                f();
            }
        } catch (Exception e16) {
            QLog.d("MSF.C.QualityTestManager", 1, "QualityClient start failed, Exception :", e16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String[] f249182a;

        /* renamed from: b, reason: collision with root package name */
        public String f249183b;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f249183b = "";
            }
        }

        public static e a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            e eVar = new e();
            int indexOf = str.indexOf("\r\n\r\n");
            if (indexOf == -1) {
                indexOf = str.length();
            }
            eVar.f249182a = str.substring(0, indexOf).split("\r\n");
            return eVar;
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            String[] strArr = this.f249182a;
            if (strArr == null || strArr.length <= 0) {
                return -1;
            }
            try {
                for (String str : strArr) {
                    if (str.startsWith(c.O)) {
                        return Integer.parseInt(str.substring(15, str.length()).trim());
                    }
                }
                return -1;
            } catch (Exception unused) {
                return -1;
            }
        }

        public String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            String[] strArr = this.f249182a;
            if (strArr == null || strArr.length == 0) {
                return "";
            }
            for (String str : strArr) {
                if ((str.startsWith(c.N) && str.contains(c.Q)) || (str.startsWith(c.M) && str.contains(c.Q))) {
                    int indexOf = str.indexOf(c.Q);
                    int indexOf2 = str.indexOf(";", indexOf);
                    if (indexOf2 == -1) {
                        indexOf2 = str.length();
                    }
                    if (indexOf != -1 && indexOf2 > indexOf) {
                        return str.substring(indexOf + 8, indexOf2);
                    }
                }
            }
            return "";
        }

        public String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            String[] strArr = this.f249182a;
            String str = "";
            if (strArr == null || strArr.length == 0) {
                return "";
            }
            for (String str2 : strArr) {
                str = str + str2 + "\r\n";
            }
            return str + "\r\n";
        }

        public String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            String[] strArr = this.f249182a;
            if (strArr == null || strArr.length == 0) {
                return "";
            }
            for (String str : strArr) {
                if ((str.startsWith(c.N) && str.contains(c.P)) || (str.startsWith(c.M) && str.contains(c.P))) {
                    int indexOf = str.indexOf(c.P);
                    int indexOf2 = str.indexOf(";", indexOf);
                    if (indexOf2 == -1) {
                        indexOf2 = str.length();
                    }
                    if (indexOf != -1 && indexOf2 > indexOf) {
                        return str.substring(indexOf + 4, indexOf2);
                    }
                }
            }
            return "";
        }

        public boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            String[] strArr = this.f249182a;
            if (strArr != null && strArr.length > 0) {
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    String str = strArr[i3];
                    if (str.startsWith(c.L)) {
                        if (str.contains("200")) {
                            return true;
                        }
                    } else {
                        i3++;
                    }
                }
            }
            return false;
        }

        public boolean g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            if (f() && !TextUtils.isEmpty(e())) {
                return true;
            }
            return false;
        }

        public String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            String[] strArr = this.f249182a;
            if (strArr != null && strArr.length != 0) {
                String str = "";
                for (String str2 : strArr) {
                    if ((!str2.startsWith(c.N) || !str2.contains(c.P)) && (!str2.startsWith(c.M) || !str2.contains(c.P))) {
                        str = str + str2 + "\r\n";
                    }
                }
                return str + "\r\n";
            }
            return this.f249183b;
        }
    }

    public c(com.tencent.msf.service.protocol.push.h.d dVar, d dVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar, (Object) dVar2);
            return;
        }
        this.f249146a = new a();
        this.f249152g = false;
        this.f249153h = null;
        this.f249154i = null;
        this.f249155j = null;
        this.f249156k = null;
        this.f249158m = 0;
        this.f249159n = 10000;
        this.f249160o = null;
        this.f249162q = "";
        this.f249163r = null;
        this.f249164s = new g();
        this.f249165t = new f();
        this.f249168w = true;
        this.f249169x = 0L;
        this.f249170y = 0L;
        this.f249171z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0L;
        this.H = 0L;
        this.I = 0L;
        this.J = 0L;
        this.K = 0L;
        this.f249148c = dVar;
        this.f249147b = dVar2;
        this.f249149d = null;
        this.f249150e = 1;
        this.f249151f = 0;
    }

    public void b(g.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, aVar, Boolean.valueOf(z16));
            return;
        }
        if (aVar == g.a.f249227a) {
            this.f249164s.f249202b = aVar;
        } else {
            g gVar = this.f249164s;
            g.a aVar2 = g.a.f249228b;
            gVar.f249202b = aVar2;
            if (aVar != aVar2) {
                a(aVar);
            }
        }
        d dVar = this.f249147b;
        if ((dVar == d.f249177c && this.f249158m == 1) || dVar == d.f249175a) {
            this.f249164s.f249216p = 0;
        } else {
            long j3 = this.G;
            if (j3 != 0) {
                this.f249164s.f249216p = (int) (((float) this.H) / ((float) j3));
            }
        }
        if (dVar == d.f249175a) {
            this.f249164s.f249217q = 0;
        } else {
            long j16 = this.I;
            if (j16 != 0) {
                this.f249164s.f249217q = (int) (((float) this.J) / ((float) j16));
            }
        }
        String gVar2 = this.f249164s.toString();
        if (TextUtils.isEmpty(this.f249162q)) {
            this.f249162q += "(";
            if (this.f249148c != null && this.f249149d == null && this.f249165t.f249184a == f.a.f249199a && this.f249164s.f249201a == g.b.f249253a) {
                this.f249162q += this.f249165t.toString();
            }
        } else if (!this.f249162q.endsWith("#") && !this.f249162q.endsWith("(")) {
            this.f249162q += "*";
        }
        this.f249162q += gVar2;
        if (z16) {
            try {
                this.f249162q += ")";
                CRC32 crc32 = new CRC32();
                crc32.update(this.f249162q.getBytes());
                this.f249162q += crc32.getValue();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void b(com.tencent.msf.service.protocol.push.h.a aVar) {
        long j3 = aVar.f336572a;
        int i3 = aVar.f336573b;
        try {
            this.f249160o = com.tencent.qphone.base.util.e.a(j3);
            this.f249161p = com.tencent.qphone.base.util.e.a(i3);
        } catch (UnknownHostException e16) {
            e16.printStackTrace();
        }
        g gVar = this.f249164s;
        gVar.f249205e = this.f249160o;
        gVar.f249206f = this.f249161p;
        String str = aVar.f336574c;
        gVar.C = str;
        if (str != null && str.length() > 0 && 2 == this.f249148c.f336605o) {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f249169x = System.currentTimeMillis();
                InetAddress[] allByName = InetAddress.getAllByName(str);
                this.f249164s.D = SystemClock.elapsedRealtime() - elapsedRealtime;
                this.f249170y = System.currentTimeMillis();
                if (allByName != null && allByName.length > 0) {
                    this.f249164s.E = 0;
                    if ((this.f249148c.f336608r & 1) == 1) {
                        this.f249160o = allByName[0];
                    } else {
                        this.f249160o = allByName[new Random().nextInt(allByName.length)];
                    }
                    this.f249164s.f249205e = this.f249160o;
                    StringBuilder sb5 = new StringBuilder();
                    for (int i16 = 0; i16 < allByName.length; i16++) {
                        sb5.append(allByName[i16].getHostAddress());
                        sb5.append("|");
                        sb5.append(allByName[i16].getHostName());
                        sb5.append("**");
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "dns addrs " + sb5.toString());
                        return;
                    }
                    return;
                }
                this.f249164s.E = 1;
                return;
            } catch (UnknownHostException e17) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "dns parse error! ", e17);
                }
                this.f249164s.E = 1;
                return;
            }
        }
        this.f249164s.E = 0;
    }

    public static String b() {
        Throwable th5;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
        } catch (Exception e16) {
            e = e16;
        } catch (Throwable th6) {
            th = th6;
            try {
                bufferedReader2.close();
            } catch (Exception e17) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "Close BufferReader failed.");
                }
                e17.printStackTrace();
            }
            throw th;
        }
        try {
            String[] split = bufferedReader.readLine().split("\\s+");
            String str = "";
            for (int i3 = 2; i3 < split.length; i3++) {
                str = str + split[i3] + "_";
            }
            try {
                bufferedReader.close();
            } catch (Exception e18) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "Close BufferReader failed.");
                }
                e18.printStackTrace();
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "CPU info: " + str);
            }
            return str;
        } catch (Exception e19) {
            bufferedReader2 = bufferedReader;
            e = e19;
            try {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "QualityTest wrong: cannot read cpu info ");
                }
                e.printStackTrace();
                try {
                    bufferedReader2.close();
                    return "cannot read cpu info";
                } catch (Exception e26) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "Close BufferReader failed.");
                    }
                    e26.printStackTrace();
                    return "cannot read cpu info";
                }
            } catch (Throwable th7) {
                BufferedReader bufferedReader3 = bufferedReader2;
                th5 = th7;
                bufferedReader = bufferedReader3;
                Throwable th8 = th5;
                bufferedReader2 = bufferedReader;
                th = th8;
                bufferedReader2.close();
                throw th;
            }
        } catch (Throwable th9) {
            th5 = th9;
            Throwable th82 = th5;
            bufferedReader2 = bufferedReader;
            th = th82;
            bufferedReader2.close();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x04f5 A[Catch: all -> 0x04ee, TRY_ENTER, TryCatch #8 {all -> 0x04ee, blocks: (B:58:0x027f, B:60:0x02a4, B:61:0x02d1, B:140:0x04f5, B:141:0x04fe, B:143:0x050f, B:144:0x0516), top: B:57:0x027f }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x050f A[Catch: all -> 0x04ee, TryCatch #8 {all -> 0x04ee, blocks: (B:58:0x027f, B:60:0x02a4, B:61:0x02d1, B:140:0x04f5, B:141:0x04fe, B:143:0x050f, B:144:0x0516), top: B:57:0x027f }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x052e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0545 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[Catch: Exception -> 0x0a5e, SYNTHETIC, TRY_LEAVE, TryCatch #12 {Exception -> 0x0a5e, blocks: (B:7:0x0038, B:10:0x0046, B:54:0x0256, B:82:0x033e, B:84:0x0347, B:130:0x04ce, B:132:0x04d7, B:171:0x0558, B:168:0x054b, B:170:0x0554, B:152:0x0534, B:154:0x053d, B:215:0x0625, B:217:0x062e, B:246:0x076c, B:248:0x0775, B:290:0x081d, B:287:0x0810, B:289:0x0819, B:271:0x07f9, B:273:0x0802, B:309:0x081e, B:345:0x0a38, B:210:0x061e, B:311:0x082c, B:313:0x0883, B:314:0x08bd, B:321:0x08cb, B:324:0x08dd, B:327:0x08e6, B:329:0x0936, B:330:0x093e, B:335:0x09d5, B:338:0x0993, B:340:0x09b5, B:341:0x0a0e, B:342:0x0a35, B:241:0x0765, B:147:0x052e, B:266:0x07f3, B:77:0x0337, B:163:0x0545, B:125:0x04c7, B:282:0x080a, B:21:0x0084, B:25:0x00dd, B:27:0x00ea, B:31:0x00f6, B:33:0x0126, B:39:0x01a6, B:42:0x01f3, B:45:0x01b5, B:47:0x01d3, B:48:0x022c, B:49:0x0253), top: B:5:0x0036, inners: #2, #5, #6, #11, #15, #18, #19, #20, #23, #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0725 A[Catch: all -> 0x07a3, Exception -> 0x07a5, TRY_LEAVE, TryCatch #26 {Exception -> 0x07a5, all -> 0x07a3, blocks: (B:224:0x066f, B:226:0x0686, B:227:0x06c4, B:234:0x06d1, B:236:0x06de, B:239:0x0725, B:251:0x06e7, B:253:0x0705, B:254:0x077b, B:255:0x07a2), top: B:223:0x066f }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x07ba A[Catch: all -> 0x07b3, TRY_ENTER, TryCatch #13 {all -> 0x07b3, blocks: (B:189:0x055d, B:259:0x07ba, B:260:0x07c3, B:262:0x07d4, B:263:0x07db), top: B:188:0x055d }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x07d4 A[Catch: all -> 0x07b3, TryCatch #13 {all -> 0x07b3, blocks: (B:189:0x055d, B:259:0x07ba, B:260:0x07c3, B:262:0x07d4, B:263:0x07db), top: B:188:0x055d }] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x07f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x080a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:292:? A[Catch: Exception -> 0x0a5e, SYNTHETIC, TryCatch #12 {Exception -> 0x0a5e, blocks: (B:7:0x0038, B:10:0x0046, B:54:0x0256, B:82:0x033e, B:84:0x0347, B:130:0x04ce, B:132:0x04d7, B:171:0x0558, B:168:0x054b, B:170:0x0554, B:152:0x0534, B:154:0x053d, B:215:0x0625, B:217:0x062e, B:246:0x076c, B:248:0x0775, B:290:0x081d, B:287:0x0810, B:289:0x0819, B:271:0x07f9, B:273:0x0802, B:309:0x081e, B:345:0x0a38, B:210:0x061e, B:311:0x082c, B:313:0x0883, B:314:0x08bd, B:321:0x08cb, B:324:0x08dd, B:327:0x08e6, B:329:0x0936, B:330:0x093e, B:335:0x09d5, B:338:0x0993, B:340:0x09b5, B:341:0x0a0e, B:342:0x0a35, B:241:0x0765, B:147:0x052e, B:266:0x07f3, B:77:0x0337, B:163:0x0545, B:125:0x04c7, B:282:0x080a, B:21:0x0084, B:25:0x00dd, B:27:0x00ea, B:31:0x00f6, B:33:0x0126, B:39:0x01a6, B:42:0x01f3, B:45:0x01b5, B:47:0x01d3, B:48:0x022c, B:49:0x0253), top: B:5:0x0036, inners: #2, #5, #6, #11, #15, #18, #19, #20, #23, #24 }] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x09d5 A[Catch: Exception -> 0x0a36, TryCatch #5 {Exception -> 0x0a36, blocks: (B:311:0x082c, B:313:0x0883, B:314:0x08bd, B:321:0x08cb, B:324:0x08dd, B:327:0x08e6, B:329:0x0936, B:330:0x093e, B:335:0x09d5, B:338:0x0993, B:340:0x09b5, B:341:0x0a0e, B:342:0x0a35), top: B:310:0x082c, outer: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:337:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01f3 A[Catch: all -> 0x0254, TryCatch #24 {all -> 0x0254, blocks: (B:21:0x0084, B:25:0x00dd, B:27:0x00ea, B:31:0x00f6, B:33:0x0126, B:39:0x01a6, B:42:0x01f3, B:45:0x01b5, B:47:0x01d3, B:48:0x022c, B:49:0x0253), top: B:20:0x0084, outer: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(int i3, byte[] bArr) {
        int i16;
        Throwable th5;
        Exception exc;
        InputStream inputStream;
        byte[] bArr2;
        int i17;
        Exception exc2;
        Throwable th6;
        BufferedInputStream bufferedInputStream;
        int i18;
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.QualityTestManager", 2, "start receive: receBodySize len:" + i3 + ", cTestType:" + ((int) this.f249148c.f336605o));
        }
        try {
        } catch (Exception unused) {
            g gVar = this.f249164s;
            gVar.f249214n++;
            gVar.J.add(-1L);
            QLog.d("MSF.C.QualityTestManager", 1, "Error recvTestData");
            return false;
        }
        if (i3 > 524288) {
            this.f249168w = false;
            a(g.a.A);
            QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: Recvbodysize too large, stop it");
            return false;
        }
        int i19 = b.f249173a[this.f249147b.ordinal()];
        if (i19 != 1) {
            InputStream inputStream2 = null;
            if (i19 == 2) {
                try {
                    try {
                        InputStream inputStream3 = this.f249154i.getInputStream();
                        try {
                            com.tencent.mobileqq.msf.core.net.t.g.f249398f.add(inputStream3.toString());
                            byte[] bArr3 = new byte[i3];
                            int read = inputStream3.read(bArr3);
                            long currentTimeMillis = System.currentTimeMillis();
                            this.C = currentTimeMillis;
                            byte[] bArr4 = bArr3;
                            this.G += currentTimeMillis - this.B;
                            QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send tcp packet length:" + bArr.length + " sendEndTime:" + this.C + " sendTime:" + this.B);
                            long j3 = this.C;
                            this.D = j3;
                            this.E = j3;
                            int i26 = -1;
                            if (read != -1) {
                                i17 = read;
                                while (true) {
                                    if (i17 >= i3) {
                                        bArr2 = bArr4;
                                        break;
                                    }
                                    bArr2 = bArr4;
                                    try {
                                        read = inputStream3.read(bArr2, i17, i3 - i17);
                                        if (i26 == read) {
                                            break;
                                        }
                                        i17 += read;
                                        this.E = System.currentTimeMillis();
                                        bArr4 = bArr2;
                                        i26 = -1;
                                    } catch (Exception e16) {
                                        exc = e16;
                                        inputStream2 = inputStream3;
                                        if (inputStream2 != null) {
                                        }
                                        b(exc.toString().toLowerCase());
                                        if (QLog.isDevelopLevel()) {
                                        }
                                        g gVar2 = this.f249164s;
                                        gVar2.f249214n++;
                                        gVar2.J.add(-1L);
                                        exc.printStackTrace();
                                        if (inputStream2 != null) {
                                        }
                                    } catch (Throwable th7) {
                                        th5 = th7;
                                        inputStream2 = inputStream3;
                                        if (inputStream2 == null) {
                                        }
                                    }
                                }
                            } else {
                                bArr2 = bArr4;
                                i17 = 0;
                            }
                            if (i26 == read) {
                                com.tencent.mobileqq.msf.core.net.t.g.f249398f.remove(inputStream3.toString());
                                a(g.a.f249231e);
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("MSF.C.QualityTestManager", 4, "QualityClient: receive TCP resp failed by read return -1, count:" + i17 + ", receBodySize:" + i3);
                                }
                                this.f249164s.J.add(-1L);
                                try {
                                    inputStream3.close();
                                    return false;
                                } catch (Throwable th8) {
                                    th8.printStackTrace();
                                    if (!QLog.isDevelopLevel()) {
                                        return false;
                                    }
                                    QLog.d("MSF.C.QualityTestManager", 4, "Http Close InputStream failed ", th8);
                                    return false;
                                }
                            }
                            com.tencent.mobileqq.msf.core.net.t.g.f249398f.remove(inputStream3.toString());
                            g gVar3 = this.f249164s;
                            long j16 = this.B;
                            gVar3.M = j16;
                            long j17 = this.E;
                            gVar3.N = j17;
                            long j18 = j17 - j16;
                            this.K = j18;
                            gVar3.J.add(Long.valueOf(j18));
                            this.f249164s.f249211k = (int) (r4.f249211k + this.K);
                            inputStream = inputStream3;
                            try {
                                this.I += this.E - this.D;
                                this.J += i3;
                                this.f249167v += i3;
                                if (QLog.isColorLevel()) {
                                    QLog.d("MSF.C.QualityTestManager", 2, "TCP recv done, actual recv len:" + i17 + ", receiveDelay:" + this.K + ", receiveTotalTime:" + this.I + ", receiveTotalBytes:" + this.J + ", testPacketRecved:" + this.f249167v);
                                }
                                short s16 = this.f249148c.f336605o;
                                if (s16 != 0 && 1 != s16) {
                                    if (2 == s16) {
                                        this.f249164s.f249213m++;
                                        if (QLog.isColorLevel()) {
                                            QLog.d("MSF.C.QualityTestManager", 2, "tcp speed test rsp cTestType 2, **NOT**, check RspBody");
                                        }
                                    }
                                    if (i3 >= 4) {
                                        int a16 = com.tencent.mobileqq.msf.core.c.a(bArr2, i3 - 4);
                                        InetAddress a17 = com.tencent.qphone.base.util.e.a(a16);
                                        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: tcp split respBodySize " + i3 + " receiveDelay:" + this.K + " gateWayIp:" + a17 + " gateWayIpInt:" + a16);
                                        this.f249164s.f249204d = a17;
                                    }
                                    try {
                                        inputStream.close();
                                        return true;
                                    } catch (Throwable th9) {
                                        th9.printStackTrace();
                                        if (!QLog.isDevelopLevel()) {
                                            return true;
                                        }
                                        QLog.d("MSF.C.QualityTestManager", 4, "Http Close InputStream failed ", th9);
                                        return true;
                                    }
                                }
                                int length = bArr.length - 8;
                                byte[] bArr5 = new byte[length];
                                System.arraycopy(bArr, 0, bArr5, 0, length);
                                int i27 = i3 - 8;
                                byte[] bArr6 = new byte[i27];
                                System.arraycopy(bArr2, 0, bArr6, 0, i27);
                                if (MD5.toMD5(bArr5).equals(MD5.toMD5(bArr6))) {
                                    QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: tcp recv packet size " + i3);
                                    g gVar4 = this.f249164s;
                                    gVar4.f249213m = gVar4.f249213m + 1;
                                    if (i3 >= 4) {
                                    }
                                    inputStream.close();
                                    return true;
                                }
                                this.f249164s.J.remove(Long.valueOf(this.K));
                                throw new Exception("recv package error. " + MD5.toMD5(bArr6));
                            } catch (Exception e17) {
                                e = e17;
                                exc = e;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    com.tencent.mobileqq.msf.core.net.t.g.f249398f.remove(inputStream2.toString());
                                }
                                b(exc.toString().toLowerCase());
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("MSF.C.QualityTestManager", 4, "QualityClient: receive TCP resp failed", exc);
                                }
                                g gVar22 = this.f249164s;
                                gVar22.f249214n++;
                                gVar22.J.add(-1L);
                                exc.printStackTrace();
                                if (inputStream2 != null) {
                                    return false;
                                }
                                try {
                                    inputStream2.close();
                                    return false;
                                } catch (Throwable th10) {
                                    th10.printStackTrace();
                                    if (!QLog.isDevelopLevel()) {
                                        return false;
                                    }
                                    QLog.d("MSF.C.QualityTestManager", 4, "Http Close InputStream failed ", th10);
                                    return false;
                                }
                            } catch (Throwable th11) {
                                th = th11;
                                th5 = th;
                                inputStream2 = inputStream;
                                if (inputStream2 == null) {
                                    try {
                                        inputStream2.close();
                                        throw th5;
                                    } catch (Throwable th12) {
                                        th12.printStackTrace();
                                        if (QLog.isDevelopLevel()) {
                                            QLog.d("MSF.C.QualityTestManager", 4, "Http Close InputStream failed ", th12);
                                            throw th5;
                                        }
                                        throw th5;
                                    }
                                }
                                throw th5;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            inputStream = inputStream3;
                        } catch (Throwable th13) {
                            th = th13;
                            inputStream = inputStream3;
                        }
                    } catch (Throwable th14) {
                        th5 = th14;
                    }
                } catch (Exception e19) {
                    exc = e19;
                }
            } else if (i19 == 3) {
                try {
                    try {
                        this.f249164s.G = this.f249157l.getResponseCode();
                        this.f249164s.H = this.f249157l.getContentLength();
                        long currentTimeMillis2 = System.currentTimeMillis();
                        this.C = currentTimeMillis2;
                        this.G = currentTimeMillis2 - this.B;
                        if (QLog.isDevelopLevel()) {
                            QLog.d("MSF.C.QualityTestManager", 4, "HTTP getResponseCode: status code:" + this.f249164s.G + ", receBodySize:" + i3 + ", ContentLength:" + this.f249164s.H);
                        }
                        long j19 = this.C;
                        this.D = j19;
                        this.E = j19;
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(this.f249157l.getInputStream());
                        try {
                            com.tencent.mobileqq.msf.core.net.t.g.f249398f.add(bufferedInputStream2.toString());
                            byte[] bArr7 = new byte[1024];
                            byte[] bArr8 = new byte[i3];
                            int i28 = 0;
                            while (i28 < i3) {
                                try {
                                    int read2 = bufferedInputStream2.read(bArr7);
                                    if (read2 == -1) {
                                        break;
                                    }
                                    if (read2 > i3) {
                                        System.arraycopy(bArr7, 0, bArr8, i28, i3);
                                    } else if (read2 + i28 > i3) {
                                        System.arraycopy(bArr7, 0, bArr8, i28, i3 - i28);
                                    } else {
                                        System.arraycopy(bArr7, 0, bArr8, i28, read2);
                                    }
                                    i28 += read2;
                                    this.E = System.currentTimeMillis();
                                    if (i28 > 1048576) {
                                        com.tencent.mobileqq.msf.core.net.t.g.f249398f.remove(bufferedInputStream2.toString());
                                        this.J += i28;
                                        this.f249167v += i28;
                                        this.f249168w = false;
                                        a(g.a.f249247u);
                                        try {
                                            bufferedInputStream2.close();
                                            return false;
                                        } catch (Throwable th15) {
                                            th15.printStackTrace();
                                            if (!QLog.isDevelopLevel()) {
                                                return false;
                                            }
                                            QLog.d("MSF.C.QualityTestManager", 4, "Http Close InputStream failed ", th15);
                                            return false;
                                        }
                                    }
                                } catch (Exception e26) {
                                    exc2 = e26;
                                    bufferedInputStream = bufferedInputStream2;
                                    inputStream2 = bufferedInputStream;
                                    if (inputStream2 != null) {
                                    }
                                    b(exc2.toString().toLowerCase());
                                    if (QLog.isDevelopLevel()) {
                                    }
                                    g gVar5 = this.f249164s;
                                    gVar5.f249214n++;
                                    gVar5.J.add(-1L);
                                    exc2.printStackTrace();
                                    if (inputStream2 != null) {
                                    }
                                } catch (Throwable th16) {
                                    th6 = th16;
                                    inputStream2 = bufferedInputStream2;
                                    if (inputStream2 == null) {
                                    }
                                }
                            }
                            com.tencent.mobileqq.msf.core.net.t.g.f249398f.remove(bufferedInputStream2.toString());
                            g gVar6 = this.f249164s;
                            long j26 = this.B;
                            gVar6.M = j26;
                            long j27 = this.E;
                            gVar6.N = j27;
                            long j28 = j27 - j26;
                            this.K = j28;
                            gVar6.J.add(Long.valueOf(j28));
                            this.f249164s.f249211k = (int) (r4.f249211k + this.K);
                            bufferedInputStream = bufferedInputStream2;
                            try {
                                this.I += this.E - this.D;
                                this.J += i28;
                                this.f249167v += i28;
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("MSF.C.QualityTestManager", 4, "HTTP recv done, receiveDelay: " + this.K + ", receiveTotalTime:" + this.I + ", receiveTotalBytes:" + this.J + ", testPacketRecved:" + this.f249167v);
                                }
                                com.tencent.msf.service.protocol.push.h.d dVar = this.f249148c;
                                long j29 = dVar.f336614x;
                                if (j29 > 0) {
                                    int i29 = (int) j29;
                                    int i36 = (int) dVar.f336613w;
                                    if (i29 > 32768) {
                                        i29 = 32768;
                                    }
                                    int min = Math.min(i28, i3);
                                    if (i36 < min) {
                                        if (i29 + i36 > min) {
                                            int i37 = min - i36;
                                            this.f249164s.P = new String(bArr8, i36, i37);
                                            this.f249164s.O = i37;
                                        } else {
                                            this.f249164s.P = new String(bArr8, i36, i29);
                                            this.f249164s.O = i29;
                                        }
                                        g gVar7 = this.f249164s;
                                        gVar7.P = com.tencent.qphone.base.util.e.b(gVar7.P);
                                        g gVar8 = this.f249164s;
                                        gVar8.O = gVar8.P.length();
                                    }
                                }
                                String str = new String(bArr8, 0, Math.min(i28, i3));
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("MSF.C.QualityTestManager", 4, "HTTP receBody: " + str);
                                }
                                if (!str.contains(this.f249148c.f336610t)) {
                                    this.f249164s.F = 1;
                                }
                                String a18 = a(this.f249157l.getHeaderField("Set-Cookie"));
                                if (a18 != null) {
                                    this.f249164s.f249204d = InetAddress.getByName(a18);
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("MSF.C.QualityTestManager", 4, "Http gateWayIp: " + a18);
                                    }
                                }
                                this.f249164s.f249213m++;
                                QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: http recv packet size " + i28 + ",server limit receBodySize:" + i3 + ",receiveDelay:" + this.K + ",strRspMatchPattern:" + this.f249148c.f336610t);
                                try {
                                    bufferedInputStream.close();
                                    return true;
                                } catch (Throwable th17) {
                                    th17.printStackTrace();
                                    if (!QLog.isDevelopLevel()) {
                                        return true;
                                    }
                                    QLog.d("MSF.C.QualityTestManager", 4, "Http Close InputStream failed ", th17);
                                    return true;
                                }
                            } catch (Exception e27) {
                                e = e27;
                                exc2 = e;
                                inputStream2 = bufferedInputStream;
                                if (inputStream2 != null) {
                                    com.tencent.mobileqq.msf.core.net.t.g.f249398f.remove(inputStream2.toString());
                                }
                                b(exc2.toString().toLowerCase());
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("MSF.C.QualityTestManager", 4, "QualityClient: http receive resp failed ", exc2);
                                }
                                g gVar52 = this.f249164s;
                                gVar52.f249214n++;
                                gVar52.J.add(-1L);
                                exc2.printStackTrace();
                                if (inputStream2 != null) {
                                    return false;
                                }
                                try {
                                    inputStream2.close();
                                    return false;
                                } catch (Throwable th18) {
                                    th18.printStackTrace();
                                    if (!QLog.isDevelopLevel()) {
                                        return false;
                                    }
                                    QLog.d("MSF.C.QualityTestManager", 4, "Http Close InputStream failed ", th18);
                                    return false;
                                }
                            } catch (Throwable th19) {
                                th = th19;
                                inputStream2 = bufferedInputStream;
                                th6 = th;
                                if (inputStream2 == null) {
                                    try {
                                        inputStream2.close();
                                        throw th6;
                                    } catch (Throwable th20) {
                                        th20.printStackTrace();
                                        if (QLog.isDevelopLevel()) {
                                            QLog.d("MSF.C.QualityTestManager", 4, "Http Close InputStream failed ", th20);
                                            throw th6;
                                        }
                                        throw th6;
                                    }
                                }
                                throw th6;
                            }
                        } catch (Exception e28) {
                            e = e28;
                            bufferedInputStream = bufferedInputStream2;
                        } catch (Throwable th21) {
                            th = th21;
                            bufferedInputStream = bufferedInputStream2;
                        }
                    } catch (Exception e29) {
                        exc2 = e29;
                    }
                } catch (Throwable th22) {
                    th = th22;
                }
            } else {
                if (i19 != 4) {
                    return false;
                }
                try {
                    byte[] bArr9 = new byte[i3];
                    this.D = System.currentTimeMillis();
                    int read3 = this.f249163r.read(bArr9, this.f249159n);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    this.C = currentTimeMillis3;
                    this.G += currentTimeMillis3 - this.B;
                    QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send Quic packet length:" + bArr.length + " sendEndTime:" + this.C + " sendTime:" + this.B);
                    this.E = this.C;
                    int i38 = -1;
                    if (read3 != -1) {
                        i18 = read3;
                        while (i18 < i3) {
                            read3 = this.f249163r.read(bArr9, i18, i3 - i18, this.f249159n);
                            if (read3 == i38) {
                                break;
                            }
                            i18 += read3;
                            this.E = System.currentTimeMillis();
                            i38 = -1;
                        }
                    } else {
                        i18 = 0;
                    }
                    if (read3 == i38) {
                        a(g.a.f249231e);
                        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: receive Quic resp failed by read return -1, count:" + i18 + ", receBodySize:" + i3);
                        this.f249164s.J.add(-1L);
                        return false;
                    }
                    g gVar9 = this.f249164s;
                    long j36 = this.B;
                    gVar9.M = j36;
                    long j37 = this.E;
                    gVar9.N = j37;
                    long j38 = j37 - j36;
                    this.K = j38;
                    gVar9.J.add(Long.valueOf(j38));
                    this.f249164s.f249211k = (int) (r5.f249211k + this.K);
                    this.I += this.E - this.D;
                    this.J += i3;
                    this.f249167v += i3;
                    QLog.d("MSF.C.QualityTestManager", 1, "Quic recv done, actual recv len:" + i18 + ", receiveDelay:" + this.K + ", receiveTotalTime:" + this.I + ", receiveTotalBytes:" + this.J + ", testPacketRecved:" + this.f249167v);
                    short s17 = this.f249148c.f336605o;
                    if (s17 != 0 && 1 != s17) {
                        if (2 == s17) {
                            this.f249164s.f249213m++;
                            QLog.d("MSF.C.QualityTestManager", 1, "quic speed test rsp cTestType 2, **NOT**, check RspBody");
                        }
                        if (i3 >= 4) {
                            return true;
                        }
                        int a19 = com.tencent.mobileqq.msf.core.c.a(bArr9, i3 - 4);
                        InetAddress a26 = com.tencent.qphone.base.util.e.a(a19);
                        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: Quic split respBodySize " + i3 + ",gateWayIp:" + a26 + ",gateWayIpInt:" + a19);
                        this.f249164s.f249204d = a26;
                        return true;
                    }
                    int length2 = bArr.length - 8;
                    byte[] bArr10 = new byte[length2];
                    System.arraycopy(bArr, 0, bArr10, 0, length2);
                    int i39 = i3 - 8;
                    byte[] bArr11 = new byte[i39];
                    System.arraycopy(bArr9, 0, bArr11, 0, i39);
                    if (MD5.toMD5(bArr10).equals(MD5.toMD5(bArr11))) {
                        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: quic recv packet size " + i3);
                        g gVar10 = this.f249164s;
                        gVar10.f249213m = gVar10.f249213m + 1;
                        if (i3 >= 4) {
                        }
                    } else {
                        this.f249164s.J.remove(Long.valueOf(this.K));
                        throw new Exception("recv package error. " + MD5.toMD5(bArr11));
                    }
                } catch (Throwable th23) {
                    QLog.e("MSF.C.QualityTestManager", 1, "QualityClient: receive Quic resp failed", th23);
                    b(th23.toString().toLowerCase());
                    g gVar11 = this.f249164s;
                    gVar11.f249214n++;
                    gVar11.J.add(-1L);
                    return false;
                }
            }
        } else {
            byte[] bArr12 = new byte[i3];
            DatagramPacket datagramPacket = new DatagramPacket(bArr12, i3);
            try {
                this.D = System.currentTimeMillis();
                this.f249153h.receive(datagramPacket);
                long currentTimeMillis4 = System.currentTimeMillis();
                this.E = currentTimeMillis4;
                g gVar12 = this.f249164s;
                long j39 = this.B;
                gVar12.M = j39;
                gVar12.N = currentTimeMillis4;
                long j46 = currentTimeMillis4 - j39;
                this.K = j46;
                gVar12.J.add(Long.valueOf(j46));
                this.I += this.E - this.D;
                this.J += datagramPacket.getLength();
                this.f249167v += datagramPacket.getLength();
                this.f249164s.f249211k = (int) (r2.f249211k + this.K);
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 2, "UDP recv done, recvPacket len:" + datagramPacket.getLength() + ", receiveDelay:" + this.K + ", receiveTotalTime:" + this.I + ", receiveTotalBytes:" + this.J + ", testPacketRecved:" + this.f249167v);
                }
                short s18 = this.f249148c.f336605o;
                if (s18 != 0 && 1 != s18) {
                    if (2 == s18) {
                        if (datagramPacket.getAddress().equals(this.f249160o) && datagramPacket.getPort() == this.f249161p) {
                            QLog.d("MSF.C.QualityTestManager", 2, "send_svninfo:(" + this.f249160o.toString() + ", port " + this.f249161p + "), recv_svrinfo:(" + datagramPacket.getAddress().toString() + ", port " + datagramPacket.getPort() + ")");
                            g gVar13 = this.f249164s;
                            gVar13.f249213m = gVar13.f249213m + 1;
                            if (QLog.isColorLevel()) {
                                QLog.d("MSF.C.QualityTestManager", 2, "udp speed test rsp cTestType 2, **NOT**, check RspBody");
                            }
                        }
                        this.f249164s.f249213m++;
                        a(g.a.f249248v);
                        QLog.d("MSF.C.QualityTestManager", 2, "Warning: send_recv_server_info_mismatch send_svninfo:(" + this.f249160o.toString() + ", port " + this.f249161p + "), recv_svrinfo:(" + datagramPacket.getAddress().toString() + ", port " + datagramPacket.getPort() + ")");
                        return false;
                    }
                    i16 = i3;
                    if (i16 >= 4) {
                        return true;
                    }
                    int a27 = com.tencent.mobileqq.msf.core.c.a(bArr12, 0);
                    int a28 = com.tencent.mobileqq.msf.core.c.a(bArr12, i16 - 4);
                    InetAddress a29 = com.tencent.qphone.base.util.e.a(a28);
                    QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: udp split respBodySize " + a27 + " gateWayIp:" + a29 + " gateWayIpInt:" + a28);
                    this.f249164s.f249204d = a29;
                    return true;
                }
                int length3 = bArr.length - 8;
                byte[] bArr13 = new byte[length3];
                System.arraycopy(bArr, 0, bArr13, 0, length3);
                i16 = i3;
                int i46 = i16 - 8;
                byte[] bArr14 = new byte[i46];
                System.arraycopy(bArr12, 0, bArr14, 0, i46);
                if (MD5.toMD5(bArr13).equals(MD5.toMD5(bArr14))) {
                    QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: udp recv packet size " + i16);
                    g gVar14 = this.f249164s;
                    gVar14.f249213m = gVar14.f249213m + 1;
                    if (i16 >= 4) {
                    }
                } else {
                    this.f249164s.J.remove(Long.valueOf(this.K));
                    throw new Exception("recv package error. " + MD5.toMD5(bArr14));
                }
            } catch (Exception e36) {
                b(e36.toString().toLowerCase());
                QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: udp read packet error:", e36);
                g gVar15 = this.f249164s;
                gVar15.f249214n++;
                gVar15.J.add(-1L);
                return false;
            }
        }
        g gVar16 = this.f249164s;
        gVar16.f249214n++;
        gVar16.J.add(-1L);
        QLog.d("MSF.C.QualityTestManager", 1, "Error recvTestData");
        return false;
    }

    private void b(String str) {
        if (NetConnInfoCenter.getSystemNetworkType() == 0) {
            a(g.a.f249251y);
        } else if (str.indexOf("timeout") > -1) {
            a(g.a.f249250x);
        } else {
            a(g.a.f249231e);
        }
    }

    private boolean a(byte[] bArr) {
        return bArr != null && bArr.length > 0 && new String(bArr).endsWith("\r\n\r\n");
    }

    private void a(g.a aVar) {
        if (this.f249164s.f249203c.containsKey(aVar)) {
            this.f249164s.f249203c.put(aVar, Integer.valueOf(this.f249164s.f249203c.get(aVar).intValue() + 1));
        } else {
            this.f249164s.f249203c.put(aVar, 1);
        }
    }

    private void a(g.a aVar, boolean z16) {
        b(aVar, z16);
        if (z16) {
            ArrayList<byte[]> arrayList = new ArrayList<>();
            try {
                arrayList.add(this.f249162q.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
            HashMap<String, ArrayList<byte[]>> hashMap = new HashMap<>();
            hashMap.put("QualTest", arrayList);
            try {
                com.tencent.mobileqq.msf.core.net.t.g.a(this.f249168w, this.f249148c, this.f249149d, this.f249167v, this.f249166u, this.f249164s.f249207g);
                com.tencent.mobileqq.msf.core.net.t.g.f249396d.configManager.a(hashMap, "");
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            QLog.d("MSF.C.QualityTestManager", 1, "QualityClient finish, succ: " + this.f249162q);
        }
    }

    private void a() {
        try {
            int i3 = b.f249173a[this.f249147b.ordinal()];
            if (i3 == 1) {
                DatagramSocket datagramSocket = this.f249153h;
                if (datagramSocket != null) {
                    datagramSocket.close();
                    this.f249153h = null;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Udp socket");
                    return;
                }
                return;
            }
            if (i3 == 2) {
                OutputStream outputStream = this.f249155j;
                if (outputStream != null) {
                    outputStream.close();
                    this.f249155j = null;
                }
                Socket socket = this.f249154i;
                if (socket != null) {
                    socket.close();
                    this.f249154i = null;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Tcp socket");
                    return;
                }
                return;
            }
            if (i3 != 3) {
                if (i3 != 4) {
                    return;
                }
                try {
                    QuicSocket quicSocket = this.f249163r;
                    if (quicSocket != null) {
                        quicSocket.close();
                        this.f249163r = null;
                        QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: close Quic socket");
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    QLog.e("MSF.C.QualityTestManager", 1, "QualityTest: close quic socket error", th5);
                    return;
                }
            }
            OutputStream outputStream2 = this.f249155j;
            if (outputStream2 != null) {
                outputStream2.close();
                this.f249155j = null;
            }
            HttpURLConnection httpURLConnection = this.f249157l;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                this.f249157l = null;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Http socket");
            }
        } catch (Exception unused) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close socket excep!");
            }
        }
    }

    private boolean a(int i3) {
        if (this.f249147b != d.f249177c) {
            if (i3 > 524288) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i3 + " return not http");
                }
                this.f249168w = false;
                a(g.a.f249234h);
                return false;
            }
            if (i3 >= 1) {
                return true;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, not http qualityTestMsg.sPkgData.length:" + this.f249148c.f336595e.length);
            }
            a(g.a.f249235i);
            return false;
        }
        if (i3 == 0) {
            return true;
        }
        if (i3 > 524288) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i3 + " return http");
            }
            this.f249168w = false;
            a(g.a.f249234h);
            return false;
        }
        if (i3 >= 1) {
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, http qualityTestMsg.sPkgData.length:" + this.f249148c.f336595e.length);
        }
        a(g.a.f249235i);
        return false;
    }

    private byte[] a(int i3, byte[] bArr, byte[] bArr2) {
        if (this.f249148c == null) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        byte[] bArr3 = new byte[i3];
        if (bArr != null && bArr.length > 0) {
            allocate.put(bArr);
        }
        int i16 = 0;
        while (true) {
            long j3 = i16;
            com.tencent.msf.service.protocol.push.h.d dVar = this.f249148c;
            if (j3 >= dVar.f336596f) {
                break;
            }
            allocate.put(dVar.f336595e);
            i16++;
        }
        if (bArr2 != null && bArr2.length > 0) {
            allocate.put(bArr2);
        }
        allocate.flip();
        allocate.get(bArr3);
        if (this.f249147b != d.f249177c) {
            short s16 = this.f249148c.f336605o;
            if (s16 == 0 || 1 == s16) {
                int a16 = com.tencent.mobileqq.msf.core.c.a(bArr3, 0);
                if (a16 != i3) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "testdata length error stop dataTotalLen:" + a16 + " receBodySize:" + i3);
                    }
                    a(g.a.f249232f, true);
                    com.tencent.mobileqq.msf.core.net.t.g.a();
                    return null;
                }
            } else if (2 == s16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 2, "qualityTestMsg.cTestType=2, Should*NOT* check head len");
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 2, "qualityTestMsg.cTestType" + ((int) this.f249148c.f336605o) + "NotSupport, giveup speed_test");
                }
                return null;
            }
        }
        return bArr3;
    }

    private String a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Matcher matcher = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
