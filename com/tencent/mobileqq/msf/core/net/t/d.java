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
import java.net.Inet6Address;
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
public class d implements Runnable {
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
    private static final int W = 6;
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
    private HostnameVerifier f249256a;

    /* renamed from: b, reason: collision with root package name */
    EnumC8091d f249257b;

    /* renamed from: c, reason: collision with root package name */
    com.tencent.msf.service.protocol.push.h.d f249258c;

    /* renamed from: d, reason: collision with root package name */
    com.tencent.msf.service.protocol.push.h.b f249259d;

    /* renamed from: e, reason: collision with root package name */
    int f249260e;

    /* renamed from: f, reason: collision with root package name */
    int f249261f;

    /* renamed from: g, reason: collision with root package name */
    boolean f249262g;

    /* renamed from: h, reason: collision with root package name */
    DatagramSocket f249263h;

    /* renamed from: i, reason: collision with root package name */
    Socket f249264i;

    /* renamed from: j, reason: collision with root package name */
    OutputStream f249265j;

    /* renamed from: k, reason: collision with root package name */
    QuicSocket f249266k;

    /* renamed from: l, reason: collision with root package name */
    URL f249267l;

    /* renamed from: m, reason: collision with root package name */
    HttpURLConnection f249268m;

    /* renamed from: n, reason: collision with root package name */
    int f249269n;

    /* renamed from: o, reason: collision with root package name */
    int f249270o;

    /* renamed from: p, reason: collision with root package name */
    InetAddress f249271p;

    /* renamed from: q, reason: collision with root package name */
    int f249272q;

    /* renamed from: r, reason: collision with root package name */
    private String f249273r;

    /* renamed from: s, reason: collision with root package name */
    g f249274s;

    /* renamed from: t, reason: collision with root package name */
    f f249275t;

    /* renamed from: u, reason: collision with root package name */
    private int f249276u;

    /* renamed from: v, reason: collision with root package name */
    private int f249277v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f249278w;

    /* renamed from: x, reason: collision with root package name */
    long f249279x;

    /* renamed from: y, reason: collision with root package name */
    long f249280y;

    /* renamed from: z, reason: collision with root package name */
    long f249281z;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements HostnameVerifier {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) sSLSession)).booleanValue();
            }
            if (d.this.f249267l == null) {
                return false;
            }
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            String host = d.this.f249267l.getHost();
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
        static final /* synthetic */ int[] f249283a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7932);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[EnumC8091d.values().length];
            f249283a = iArr;
            try {
                iArr[EnumC8091d.f249285a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f249283a[EnumC8091d.f249286b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f249283a[EnumC8091d.f249287c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f249283a[EnumC8091d.f249290f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f249283a[EnumC8091d.f249288d.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f249283a[EnumC8091d.f249289e.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c implements X509TrustManager {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private X509TrustManager f249284a;

        c() throws Exception {
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
                    this.f249284a = (X509TrustManager) trustManager;
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
            X509TrustManager x509TrustManager = this.f249284a;
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
            X509TrustManager x509TrustManager = this.f249284a;
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
            X509TrustManager x509TrustManager = this.f249284a;
            if (x509TrustManager != null) {
                return x509TrustManager.getAcceptedIssuers();
            }
            return new X509Certificate[0];
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.net.t.d$d, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class EnumC8091d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final EnumC8091d f249285a;

        /* renamed from: b, reason: collision with root package name */
        public static final EnumC8091d f249286b;

        /* renamed from: c, reason: collision with root package name */
        public static final EnumC8091d f249287c;

        /* renamed from: d, reason: collision with root package name */
        public static final EnumC8091d f249288d;

        /* renamed from: e, reason: collision with root package name */
        public static final EnumC8091d f249289e;

        /* renamed from: f, reason: collision with root package name */
        public static final EnumC8091d f249290f;

        /* renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ EnumC8091d[] f249291g;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29125);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            EnumC8091d enumC8091d = new EnumC8091d("UdpTest", 0);
            f249285a = enumC8091d;
            EnumC8091d enumC8091d2 = new EnumC8091d("TcpTest", 1);
            f249286b = enumC8091d2;
            EnumC8091d enumC8091d3 = new EnumC8091d("HttpTest", 2);
            f249287c = enumC8091d3;
            EnumC8091d enumC8091d4 = new EnumC8091d("PingTest", 3);
            f249288d = enumC8091d4;
            EnumC8091d enumC8091d5 = new EnumC8091d("TracerouteTest", 4);
            f249289e = enumC8091d5;
            EnumC8091d enumC8091d6 = new EnumC8091d("QuicTest", 5);
            f249290f = enumC8091d6;
            f249291g = new EnumC8091d[]{enumC8091d, enumC8091d2, enumC8091d3, enumC8091d4, enumC8091d5, enumC8091d6};
        }

        EnumC8091d(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static EnumC8091d a(String str) {
            return (EnumC8091d) Enum.valueOf(EnumC8091d.class, str);
        }

        public static EnumC8091d[] values() {
            return (EnumC8091d[]) f249291g.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public a f249294a;

        /* renamed from: b, reason: collision with root package name */
        public String f249295b;

        /* renamed from: c, reason: collision with root package name */
        public int f249296c;

        /* renamed from: d, reason: collision with root package name */
        public long f249297d;

        /* renamed from: e, reason: collision with root package name */
        public long f249298e;

        /* renamed from: f, reason: collision with root package name */
        public long f249299f;

        /* renamed from: g, reason: collision with root package name */
        public long f249300g;

        /* renamed from: h, reason: collision with root package name */
        public long f249301h;

        /* renamed from: i, reason: collision with root package name */
        public String f249302i;

        /* renamed from: j, reason: collision with root package name */
        public String f249303j;

        /* renamed from: k, reason: collision with root package name */
        public String f249304k;

        /* renamed from: l, reason: collision with root package name */
        public long f249305l;

        /* renamed from: m, reason: collision with root package name */
        public String f249306m;

        /* renamed from: n, reason: collision with root package name */
        public String f249307n;

        /* renamed from: o, reason: collision with root package name */
        public String f249308o;

        /* renamed from: p, reason: collision with root package name */
        public String f249309p;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* compiled from: P */
        /* loaded from: classes15.dex */
        public static final class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final a f249310a;

            /* renamed from: b, reason: collision with root package name */
            private static final /* synthetic */ a[] f249311b;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29277);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                    return;
                }
                a aVar = new a("QualityTest", 0);
                f249310a = aVar;
                f249311b = new a[]{aVar};
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
                return (a[]) f249311b.clone();
            }
        }

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f249294a = a.f249310a;
            this.f249295b = d.b() + "," + d.f() + "," + Build.VERSION.RELEASE.replaceAll("|", "_").replaceAll("#", "_").replace("*", "_");
            this.f249296c = 0;
            this.f249297d = 0L;
            this.f249298e = 0L;
            this.f249299f = 0L;
            this.f249300g = 0L;
            this.f249301h = 0L;
            this.f249302i = "";
            this.f249303j = "0.0.0.0";
            this.f249304k = o.f();
            this.f249305l = 0L;
            this.f249306m = "0,0";
            this.f249307n = "";
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "" + this.f249294a + ":6|" + this.f249302i + "|" + this.f249303j + "|" + this.f249304k + "|" + this.f249305l + "|" + this.f249306m + "|" + this.f249307n + "|" + this.f249298e + "|" + this.f249297d + "|" + this.f249299f + "|" + this.f249296c + "|" + this.f249295b + "|" + this.f249300g + "|" + this.f249301h + "|" + this.f249308o + "|" + this.f249309p + "#";
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
        public b f249312a;

        /* renamed from: b, reason: collision with root package name */
        public a f249313b;

        /* renamed from: c, reason: collision with root package name */
        public Map<a, Integer> f249314c;

        /* renamed from: d, reason: collision with root package name */
        public InetAddress f249315d;

        /* renamed from: e, reason: collision with root package name */
        public InetAddress f249316e;

        /* renamed from: f, reason: collision with root package name */
        public int f249317f;

        /* renamed from: g, reason: collision with root package name */
        public int f249318g;

        /* renamed from: h, reason: collision with root package name */
        public int f249319h;

        /* renamed from: i, reason: collision with root package name */
        public int f249320i;

        /* renamed from: j, reason: collision with root package name */
        public int f249321j;

        /* renamed from: k, reason: collision with root package name */
        public int f249322k;

        /* renamed from: l, reason: collision with root package name */
        public int f249323l;

        /* renamed from: m, reason: collision with root package name */
        public int f249324m;

        /* renamed from: n, reason: collision with root package name */
        public int f249325n;

        /* renamed from: o, reason: collision with root package name */
        public int f249326o;

        /* renamed from: p, reason: collision with root package name */
        public int f249327p;

        /* renamed from: q, reason: collision with root package name */
        public int f249328q;

        /* renamed from: r, reason: collision with root package name */
        public int f249329r;

        /* renamed from: s, reason: collision with root package name */
        public long f249330s;

        /* renamed from: t, reason: collision with root package name */
        public long f249331t;

        /* renamed from: u, reason: collision with root package name */
        ArrayList f249332u;

        /* renamed from: v, reason: collision with root package name */
        ArrayList f249333v;

        /* renamed from: w, reason: collision with root package name */
        public long f249334w;

        /* renamed from: x, reason: collision with root package name */
        public boolean f249335x;

        /* renamed from: y, reason: collision with root package name */
        ArrayList f249336y;

        /* renamed from: z, reason: collision with root package name */
        public long f249337z;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* compiled from: P */
        /* loaded from: classes15.dex */
        public static final class a {
            static IPatchRedirector $redirector_;
            public static final a A;
            public static final a B;
            private static final /* synthetic */ a[] C;

            /* renamed from: a, reason: collision with root package name */
            public static final a f249338a;

            /* renamed from: b, reason: collision with root package name */
            public static final a f249339b;

            /* renamed from: c, reason: collision with root package name */
            public static final a f249340c;

            /* renamed from: d, reason: collision with root package name */
            public static final a f249341d;

            /* renamed from: e, reason: collision with root package name */
            public static final a f249342e;

            /* renamed from: f, reason: collision with root package name */
            public static final a f249343f;

            /* renamed from: g, reason: collision with root package name */
            public static final a f249344g;

            /* renamed from: h, reason: collision with root package name */
            public static final a f249345h;

            /* renamed from: i, reason: collision with root package name */
            public static final a f249346i;

            /* renamed from: j, reason: collision with root package name */
            public static final a f249347j;

            /* renamed from: k, reason: collision with root package name */
            public static final a f249348k;

            /* renamed from: l, reason: collision with root package name */
            public static final a f249349l;

            /* renamed from: m, reason: collision with root package name */
            public static final a f249350m;

            /* renamed from: n, reason: collision with root package name */
            public static final a f249351n;

            /* renamed from: o, reason: collision with root package name */
            public static final a f249352o;

            /* renamed from: p, reason: collision with root package name */
            public static final a f249353p;

            /* renamed from: q, reason: collision with root package name */
            public static final a f249354q;

            /* renamed from: r, reason: collision with root package name */
            public static final a f249355r;

            /* renamed from: s, reason: collision with root package name */
            public static final a f249356s;

            /* renamed from: t, reason: collision with root package name */
            public static final a f249357t;

            /* renamed from: u, reason: collision with root package name */
            public static final a f249358u;

            /* renamed from: v, reason: collision with root package name */
            public static final a f249359v;

            /* renamed from: w, reason: collision with root package name */
            public static final a f249360w;

            /* renamed from: x, reason: collision with root package name */
            public static final a f249361x;

            /* renamed from: y, reason: collision with root package name */
            public static final a f249362y;

            /* renamed from: z, reason: collision with root package name */
            public static final a f249363z;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22877);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                    return;
                }
                a aVar = new a("Success", 0);
                f249338a = aVar;
                a aVar2 = new a("Failed", 1);
                f249339b = aVar2;
                a aVar3 = new a("ConnectToServerFail", 2);
                f249340c = aVar3;
                a aVar4 = new a("SendPackageError", 3);
                f249341d = aVar4;
                a aVar5 = new a("RecvPackageError", 4);
                f249342e = aVar5;
                a aVar6 = new a("HeadDataLengthError", 5);
                f249343f = aVar6;
                a aVar7 = new a("IntervalTooSmall", 6);
                f249344g = aVar7;
                a aVar8 = new a("DataTooMuch", 7);
                f249345h = aVar8;
                a aVar9 = new a("DataTooShort", 8);
                f249346i = aVar9;
                a aVar10 = new a("TimeExpired", 9);
                f249347j = aVar10;
                a aVar11 = new a("QualityTestMsgNull", 10);
                f249348k = aVar11;
                a aVar12 = new a("PkgNumTooMuch", 11);
                f249349l = aVar12;
                a aVar13 = new a("IPPortTooMuch", 12);
                f249350m = aVar13;
                a aVar14 = new a("IPPortTooSmall", 13);
                f249351n = aVar14;
                a aVar15 = new a("MtuTestMsgNull", 14);
                f249352o = aVar15;
                a aVar16 = new a("MD5ValidFailed", 15);
                f249353p = aVar16;
                a aVar17 = new a("DWRepeatTimeWrong", 16);
                f249354q = aVar17;
                a aVar18 = new a("HTTPResponError", 17);
                f249355r = aVar18;
                a aVar19 = new a("NoHTTPHead", 18);
                f249356s = aVar19;
                a aVar20 = new a("HTTPContentLengthError", 19);
                f249357t = aVar20;
                a aVar21 = new a("HTTPAckDataTooLarge", 20);
                f249358u = aVar21;
                a aVar22 = new a("RecvPackageInvalid", 21);
                f249359v = aVar22;
                a aVar23 = new a("TestTypeNoSupported", 22);
                f249360w = aVar23;
                a aVar24 = new a("RecvTimeout", 23);
                f249361x = aVar24;
                a aVar25 = new a("RecvNetworkBroken", 24);
                f249362y = aVar25;
                a aVar26 = new a("OnlyDomainValid", 25);
                f249363z = aVar26;
                a aVar27 = new a("RecvDataTooMuch", 26);
                A = aVar27;
                a aVar28 = new a("TestIPv6NoSupported", 27);
                B = aVar28;
                C = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12, aVar13, aVar14, aVar15, aVar16, aVar17, aVar18, aVar19, aVar20, aVar21, aVar22, aVar23, aVar24, aVar25, aVar26, aVar27, aVar28};
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
                return (a[]) C.clone();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* compiled from: P */
        /* loaded from: classes15.dex */
        public static final class b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final b f249364a;

            /* renamed from: b, reason: collision with root package name */
            public static final b f249365b;

            /* renamed from: c, reason: collision with root package name */
            private static final /* synthetic */ b[] f249366c;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17544);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                    return;
                }
                b bVar = new b("QualityTest", 0);
                f249364a = bVar;
                b bVar2 = new b("MtuTest", 1);
                f249365b = bVar2;
                f249366c = new b[]{bVar, bVar2};
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
                return (b[]) f249366c.clone();
            }
        }

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f249312a = b.f249364a;
            this.f249313b = a.f249338a;
            this.f249314c = new HashMap();
            this.I = new ArrayList<>();
            this.J = new ArrayList<>();
            this.f249317f = 0;
            this.f249322k = 0;
            this.f249323l = 0;
            this.f249324m = 0;
            this.f249325n = 0;
            this.f249326o = 0;
            this.f249327p = 0;
            this.f249328q = 0;
            this.f249329r = 0;
            this.f249330s = 0L;
            this.f249331t = 0L;
            this.f249334w = 0L;
            this.f249335x = false;
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
            a aVar = this.f249313b;
            a aVar2 = a.f249338a;
            if (aVar == aVar2 && this.f249314c.isEmpty()) {
                str = aVar2.toString();
            } else {
                Map<a, Integer> map = this.f249314c;
                if (map != null && !map.isEmpty()) {
                    String str9 = "";
                    for (Map.Entry<a, Integer> entry : this.f249314c.entrySet()) {
                        a key = entry.getKey();
                        str9 = str9 + key.toString() + ":" + entry.getValue().intValue() + ";";
                    }
                    str = str9;
                } else {
                    str = a.f249339b.toString();
                }
            }
            int i3 = this.f249329r;
            if (i3 != 5 && i3 != 6) {
                if (this.f249315d == null) {
                    str8 = "0.0.0.0|";
                } else {
                    str8 = this.f249315d.getHostAddress() + "|";
                }
                if (this.f249316e == null) {
                    str2 = str8 + "0.0.0.0|";
                } else {
                    str2 = str8 + this.f249316e.getHostAddress() + "|";
                }
                String str10 = this.C;
                if (str10 == null || str10.isEmpty()) {
                    InetAddress inetAddress = this.f249316e;
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
            ArrayList arrayList = this.f249336y;
            if (arrayList == null || arrayList.size() == 0) {
                str3 = "";
            } else {
                str3 = "";
                for (int i16 = 0; i16 < this.f249336y.size(); i16++) {
                    if (i16 != this.f249336y.size() - 1) {
                        str3 = str3 + this.f249336y.get(i16) + ",";
                    } else {
                        str3 = str3 + this.f249336y.get(i16);
                    }
                }
            }
            ArrayList arrayList2 = this.f249332u;
            if (arrayList2 == null || arrayList2.size() == 0) {
                str4 = "";
            } else {
                str4 = "";
                for (int i17 = 0; i17 < this.f249332u.size(); i17++) {
                    if (i17 != this.f249332u.size() - 1) {
                        str4 = str4 + this.f249332u.get(i17) + ",";
                    } else {
                        str4 = str4 + this.f249332u.get(i17);
                    }
                }
            }
            if (this.f249335x) {
                str5 = this.A;
            } else {
                str5 = "false";
            }
            if (this.f249312a == b.f249364a) {
                return "" + str + "|" + str2 + this.f249317f + "|" + this.L + "|" + this.M + "|" + this.N + "|" + this.O + "|" + this.P + "|" + this.Q + "|" + this.R + "|" + this.C + "|" + this.D + "|" + this.E + "|" + this.F + "|" + this.G + "|" + this.f249318g + "|" + this.f249323l + "|" + this.f249324m + "|" + this.I.toString().replace("[", "").replace("]", "") + "|" + this.J.toString().replace("[", "").replace("]", "") + "|" + this.f249325n + "|" + this.f249326o + "|" + this.f249327p + "|" + this.f249328q + "|" + this.f249329r + "|" + this.f249330s + "|" + this.f249331t + "|" + str4 + "|" + this.f249334w + "|" + str5 + "|" + str3 + "|" + this.f249337z + "|" + this.f249319h + "," + this.f249320i + "," + this.f249321j;
            }
            int min = Math.min(this.f249323l, this.f249324m);
            if (min > 0) {
                str6 = Integer.toString(this.f249322k / min);
            } else {
                str6 = "0";
            }
            ArrayList arrayList3 = this.f249333v;
            if (arrayList3 == null || arrayList3.size() == 0) {
                str7 = "";
            } else {
                str7 = "";
                for (int i18 = 0; i18 < this.f249333v.size(); i18++) {
                    if (i18 != this.f249333v.size() - 1) {
                        str7 = str7 + this.f249333v.get(i18) + ",";
                    } else {
                        str7 = str7 + this.f249333v.get(i18);
                    }
                }
            }
            return "" + this.f249312a + "|" + str + "|" + str2 + this.f249317f + "|" + this.f249318g + "|" + str6 + "|" + this.f249323l + "|" + this.f249324m + "|" + this.f249325n + "|" + this.f249326o + "|" + str7 + "|" + this.f249327p + "|" + this.f249328q + "|" + this.f249329r + "|" + this.f249330s + "|" + this.f249331t + "|" + str4 + "|" + this.f249334w + "|" + str5 + "|" + str3 + "|" + this.f249337z + "|" + this.f249319h + "," + this.f249320i + "," + this.f249321j;
        }
    }

    public d(com.tencent.msf.service.protocol.push.h.d dVar, com.tencent.msf.service.protocol.push.h.b bVar, EnumC8091d enumC8091d, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, dVar, bVar, enumC8091d, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f249256a = new a();
        this.f249262g = false;
        this.f249263h = null;
        this.f249264i = null;
        this.f249265j = null;
        this.f249266k = null;
        this.f249267l = null;
        this.f249269n = 0;
        this.f249270o = 10000;
        this.f249271p = null;
        this.f249273r = "";
        this.f249274s = new g();
        this.f249275t = new f();
        this.f249278w = true;
        this.f249279x = 0L;
        this.f249280y = 0L;
        this.f249281z = 0L;
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
        this.f249258c = dVar;
        this.f249259d = bVar;
        this.f249257b = enumC8091d;
        this.f249260e = i3;
        this.f249261f = i16;
    }

    private boolean a(com.tencent.msf.service.protocol.push.h.a aVar) {
        int i3;
        int i16;
        String str;
        String str2 = "close";
        String str3 = "Connection";
        com.tencent.msf.service.protocol.push.h.d dVar = this.f249258c;
        if (dVar != null) {
            g gVar = this.f249274s;
            long j3 = dVar.f336599i;
            gVar.f249337z = j3;
            if (j3 > 0 && j3 < 600) {
                this.f249270o = ((int) j3) * 1000;
            }
        } else {
            com.tencent.msf.service.protocol.push.h.b bVar = this.f249259d;
            if (bVar != null) {
                g gVar2 = this.f249274s;
                long j16 = bVar.f336588i;
                gVar2.f249337z = j16;
                if (j16 > 0 && j16 < 600) {
                    this.f249270o = ((int) j16) * 1000;
                }
            }
        }
        try {
            i3 = 4;
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: Start connecting: " + this.f249271p + ", port:" + this.f249272q + ", strDomain:" + aVar.f336574c + ", mTestType:" + this.f249257b);
            }
            i16 = b.f249283a[this.f249257b.ordinal()];
        } catch (Exception e16) {
            this.f249274s.I.add(-1L);
            e16.printStackTrace();
            return false;
        }
        if (i16 == 1) {
            DatagramSocket datagramSocket = new DatagramSocket();
            this.f249263h = datagramSocket;
            datagramSocket.setSoTimeout(this.f249270o);
            this.f249274s.I.add(-1L);
        } else if (i16 == 2) {
            try {
                InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f249271p, this.f249272q);
                Socket socket = new Socket();
                this.f249264i = socket;
                socket.setSoTimeout(this.f249270o);
                this.f249264i.setTcpNoDelay(true);
                this.f249264i.setKeepAlive(true);
                this.f249281z = System.currentTimeMillis();
                this.f249264i.connect(inetSocketAddress, this.f249270o);
                long currentTimeMillis = System.currentTimeMillis();
                this.A = currentTimeMillis;
                long j17 = currentTimeMillis - this.f249281z;
                this.F = j17;
                this.f249274s.I.add(Long.valueOf(j17));
                this.f249265j = this.f249264i.getOutputStream();
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: TCP end connect: " + this.f249271p + ", port:" + this.f249272q + ", readTimeout:" + this.f249270o);
                }
            } catch (Throwable th5) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: TCP end connect: " + this.f249271p + ", port:" + this.f249272q + ", mTestType:" + this.f249257b + " failed", th5);
                }
                g gVar3 = this.f249274s;
                gVar3.f249326o++;
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
                    this.f249266k = quicSocket;
                    if (quicSocket.getSocketFd() == -1) {
                        QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: create Quic Socket failed, not connect " + this.f249271p + ", port:" + this.f249272q + ", mTestType:" + this.f249257b);
                        g gVar4 = this.f249274s;
                        gVar4.f249326o = gVar4.f249326o + 1;
                        gVar4.I.add(-1L);
                        return false;
                    }
                    this.f249281z = System.currentTimeMillis();
                    this.f249266k.connect(this.f249271p.getHostAddress(), this.f249272q, this.f249270o);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    this.A = currentTimeMillis2;
                    long j18 = currentTimeMillis2 - this.f249281z;
                    this.F = j18;
                    this.f249274s.I.add(Long.valueOf(j18));
                    QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: Quic end connect: " + this.f249271p + ", port:" + this.f249272q + ", readTimeout:" + this.f249270o + " success, costTime:" + this.F);
                    return true;
                } catch (Throwable th6) {
                    QLog.e("MSF.C.QualityTestManager", 1, "QualityTest: Quic end connect: " + this.f249271p + ", port:" + this.f249272q + ", mTestType:" + this.f249257b + " failed", th6);
                    g gVar5 = this.f249274s;
                    gVar5.f249326o = gVar5.f249326o + 1;
                    gVar5.I.add(-1L);
                    return false;
                }
            }
            try {
                String hostAddress = this.f249271p.getHostAddress();
                if (this.f249271p instanceof Inet6Address) {
                    hostAddress = "[" + hostAddress + "]";
                }
                if (this.f249258c.f336615y == 1) {
                    str = "https://" + hostAddress + ":" + this.f249272q + "/" + this.f249258c.f336607q;
                } else {
                    str = "http://" + hostAddress + ":" + this.f249272q + "/" + this.f249258c.f336607q;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: connecting http url:" + str);
                }
                this.f249281z = System.currentTimeMillis();
                URL url = new URL(str);
                this.f249267l = url;
                this.f249268m = (HttpURLConnection) url.openConnection();
                if (this.f249258c.f336615y == 1) {
                    k();
                    ((HttpsURLConnection) this.f249268m).setHostnameVerifier(this.f249256a);
                }
                this.f249268m.setConnectTimeout(this.f249270o);
                this.f249268m.setDoInput(true);
                this.f249268m.setUseCaches(false);
                this.f249268m.setReadTimeout(this.f249270o);
                this.f249268m.setRequestProperty("Connection", "close");
                int i17 = this.f249269n;
                if (i17 == 0) {
                    this.f249268m.setDoOutput(true);
                    this.f249268m.setRequestMethod("POST");
                    this.f249268m.setRequestProperty("Content-Type", "application/octet-stream");
                } else if (i17 == 1) {
                    this.f249268m.setInstanceFollowRedirects(false);
                    this.f249268m.setRequestMethod("GET");
                }
                this.f249268m.setRequestProperty("Host", aVar.f336574c);
                ArrayList<com.tencent.msf.service.protocol.push.h.e> arrayList = this.f249258c.f336609s;
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator<com.tencent.msf.service.protocol.push.h.e> it = this.f249258c.f336609s.iterator();
                    while (it.hasNext()) {
                        com.tencent.msf.service.protocol.push.h.e next = it.next();
                        if (next != null) {
                            this.f249268m.setRequestProperty(next.f336617a, next.f336618b);
                            if (QLog.isColorLevel()) {
                                QLog.d("MSF.C.QualityTestManager", 4, "reqHead.strKey:" + next.f336617a + ",reqHead.strValue:" + next.f336618b);
                            }
                        }
                    }
                }
                this.f249268m.connect();
                long currentTimeMillis3 = System.currentTimeMillis();
                this.A = currentTimeMillis3;
                this.B = currentTimeMillis3;
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: end connect: mRequestMethod:" + this.f249269n + ", readTimeout:" + this.f249270o);
                }
                String str4 = "";
                if (this.f249269n == 1) {
                    int responseCode = this.f249268m.getResponseCode();
                    boolean z16 = (this.f249258c.f336608r & 4) != 4;
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
                        str4 = this.f249268m.getHeaderField("Location");
                        this.f249268m.disconnect();
                        URL url2 = new URL(str4);
                        this.f249267l = url2;
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url2.openConnection();
                        this.f249268m = httpURLConnection;
                        httpURLConnection.setConnectTimeout(this.f249270o);
                        this.f249268m.setDoInput(true);
                        this.f249268m.setUseCaches(false);
                        this.f249268m.setInstanceFollowRedirects(false);
                        this.f249268m.setReadTimeout(this.f249270o);
                        this.f249268m.setRequestProperty(str3, str2);
                        this.f249268m.setRequestMethod("GET");
                        ArrayList<com.tencent.msf.service.protocol.push.h.e> arrayList2 = this.f249258c.f336609s;
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            Iterator<com.tencent.msf.service.protocol.push.h.e> it5 = this.f249258c.f336609s.iterator();
                            while (it5.hasNext()) {
                                com.tencent.msf.service.protocol.push.h.e next2 = it5.next();
                                if (next2 != null) {
                                    String str5 = str2;
                                    String str6 = str3;
                                    this.f249268m.setRequestProperty(next2.f336617a, next2.f336618b);
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
                        this.f249268m.connect();
                        long currentTimeMillis4 = System.currentTimeMillis();
                        this.A = currentTimeMillis4;
                        this.B = currentTimeMillis4;
                        if (QLog.isColorLevel()) {
                            QLog.d("MSF.C.QualityTestManager", 4, "Redirect responseCode:" + responseCode + ",lastRedirectUrl:" + str4);
                        }
                        responseCode = this.f249268m.getResponseCode();
                        i18 = i19;
                        str2 = str7;
                        str3 = str8;
                        i3 = 4;
                    }
                }
                long j19 = this.A - this.f249281z;
                this.F = j19;
                this.f249274s.I.add(Long.valueOf(j19));
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        String substring = str4.substring(str4.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER) + 3);
                        this.f249274s.L = InetAddress.getByName(substring.substring(0, substring.indexOf("/"))).getHostAddress();
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.d("MSF.C.QualityTestManager", 4, "DNSParse for lastUrl error!", e17);
                        }
                    }
                }
            } catch (Throwable th7) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: connecting " + this.f249271p + " port:" + this.f249272q + " mTestType:" + this.f249257b + " failed", th7);
                }
                g gVar6 = this.f249274s;
                gVar6.f249326o++;
                gVar6.I.add(-1L);
                return false;
            }
            this.f249274s.I.add(-1L);
            e16.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean b(byte[] bArr) {
        try {
            int i3 = b.f249283a[this.f249257b.ordinal()];
            if (i3 == 1) {
                DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, this.f249271p, this.f249272q);
                try {
                    this.B = System.currentTimeMillis();
                    this.f249263h.send(datagramPacket);
                    long currentTimeMillis = System.currentTimeMillis();
                    this.C = currentTimeMillis;
                    this.G += currentTimeMillis - this.B;
                    this.H += bArr.length;
                    this.f249276u += bArr.length;
                    QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send udp packet length:" + datagramPacket.getLength() + " sendEndTime:" + this.C + " sendTime:" + this.B);
                    g gVar = this.f249274s;
                    gVar.f249323l = gVar.f249323l + 1;
                    return true;
                } catch (Exception e16) {
                    a(g.a.f249341d);
                    QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send udp packet error:", e16);
                    return false;
                }
            }
            if (i3 == 2) {
                try {
                    this.B = System.currentTimeMillis();
                    com.tencent.mobileqq.msf.core.net.t.g.f249399g.add(this.f249265j.toString());
                    this.f249265j.write(bArr);
                    this.f249265j.flush();
                    com.tencent.mobileqq.msf.core.net.t.g.f249399g.remove(this.f249265j.toString());
                    this.H += bArr.length;
                    this.f249276u += bArr.length;
                    this.f249274s.f249323l++;
                    return true;
                } catch (Exception e17) {
                    OutputStream outputStream = this.f249265j;
                    if (outputStream != null) {
                        com.tencent.mobileqq.msf.core.net.t.g.f249399g.remove(outputStream.toString());
                    }
                    a(g.a.f249341d);
                    QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send tcp error:", e17);
                    return false;
                }
            }
            if (i3 == 3) {
                try {
                    OutputStream outputStream2 = this.f249268m.getOutputStream();
                    this.f249265j = outputStream2;
                    com.tencent.mobileqq.msf.core.net.t.g.f249399g.add(outputStream2.toString());
                    this.f249265j.write(bArr);
                    this.f249265j.flush();
                    com.tencent.mobileqq.msf.core.net.t.g.f249399g.remove(this.f249265j.toString());
                    this.H += bArr.length;
                    this.f249276u += bArr.length;
                    this.f249274s.f249323l++;
                    return true;
                } catch (Exception e18) {
                    OutputStream outputStream3 = this.f249265j;
                    if (outputStream3 != null) {
                        com.tencent.mobileqq.msf.core.net.t.g.f249399g.remove(outputStream3.toString());
                    }
                    a(g.a.f249341d);
                    QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send http error:", e18);
                    return false;
                }
            }
            if (i3 != 4) {
                return false;
            }
            try {
                this.B = System.currentTimeMillis();
                this.f249266k.write(bArr);
                this.H += bArr.length;
                this.f249276u += bArr.length;
                this.f249274s.f249323l++;
                QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send Quic packet length:" + bArr.length + " sendTime:" + this.B);
                return true;
            } catch (Exception e19) {
                a(g.a.f249341d);
                QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send Quic packet error:", e19);
                return false;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    private void c() {
        a.C8089a b16 = com.tencent.mobileqq.msf.core.net.t.a.b();
        f fVar = this.f249275t;
        fVar.f249308o = b16.f249135a;
        fVar.f249309p = b16.f249136b;
        com.tencent.msf.service.protocol.push.h.d dVar = this.f249258c;
        fVar.f249297d = dVar.f336600j;
        fVar.f249298e = dVar.f336605o;
        fVar.f249299f = dVar.f336601k;
        fVar.f249300g = dVar.f336602l;
        fVar.f249301h = dVar.f336603m;
        fVar.f249294a = f.a.f249310a;
        fVar.f249302i = dVar.f336611u;
        fVar.f249307n = d();
        ArrayList<InetAddress> b17 = k.b();
        if (b17 != null && b17.size() > 0) {
            int min = Math.min(b17.size(), 3);
            StringBuilder sb5 = new StringBuilder("");
            for (int i3 = 0; i3 < min; i3++) {
                sb5.append(b17.get(i3).getHostAddress());
                if (min > 1 && i3 < min - 1) {
                    sb5.append(",");
                }
            }
            this.f249275t.f249303j = sb5.toString();
        } else if (QLog.isColorLevel()) {
            QLog.d("MSF.C.QualityTestManager", 2, "mDnses is null");
        }
        long j3 = o.f249568k;
        if (0 != j3) {
            f fVar2 = this.f249275t;
            fVar2.f249305l = j3;
            fVar2.f249306m = o.f249569l + "," + o.f249570m;
        }
    }

    private String d() {
        StringBuilder sb5 = new StringBuilder("");
        sb5.append(NetConnInfoCenter.getActiveNetIpFamily(false));
        sb5.append("_");
        if (NetConnInfoCenter.isWifiConn()) {
            sb5.append("wifi");
            sb5.append("_");
        } else if (NetConnInfoCenter.isMobileConn()) {
            sb5.append(NetConnInfoCenter.getCurrentAPN());
            sb5.append("_");
        } else {
            sb5.append("other");
            sb5.append("_");
        }
        sb5.append(Build.VERSION.SDK_INT);
        sb5.append("_");
        sb5.append(Build.BRAND);
        return sb5.substring(0, Math.min(32, sb5.length()));
    }

    public static String f() {
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
    private void g() {
        boolean z16;
        int i3;
        boolean z17;
        if (this.f249259d == null) {
            a(g.a.f249352o, true);
            return;
        }
        g gVar = this.f249274s;
        gVar.f249312a = g.b.f249365b;
        gVar.f249318g = NetConnInfoCenter.getSystemNetworkType();
        g gVar2 = this.f249274s;
        com.tencent.msf.service.protocol.push.h.b bVar = this.f249259d;
        gVar2.f249329r = bVar.f336580a;
        gVar2.f249330s = bVar.f336586g;
        gVar2.f249331t = bVar.f336585f;
        gVar2.f249332u = new ArrayList();
        for (int i16 = 0; i16 < this.f249259d.f336583d.size(); i16++) {
            this.f249274s.f249332u.add(this.f249259d.f336583d.get(i16));
        }
        g gVar3 = this.f249274s;
        gVar3.f249334w = this.f249259d.f336587h;
        gVar3.f249333v = new ArrayList();
        QLog.d("MSF.C.QualityTestManager", 1, "PkgInterval :" + this.f249259d.f336585f + " IpPort.size():" + this.f249259d.f336581b.size() + " PkgData.length " + this.f249259d.f336582c.size() + " PkgNum:" + this.f249259d.f336586g);
        if (this.f249259d.f336581b.size() > 75) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
            }
            this.f249278w = false;
            a(g.a.f249350m, true);
            return;
        }
        if (this.f249259d.f336581b.size() <= 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
            }
            a(g.a.f249351n, true);
            return;
        }
        com.tencent.msf.service.protocol.push.h.b bVar2 = this.f249259d;
        if (bVar2.f336586g > 20) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
            }
            this.f249278w = false;
            a(g.a.f249349l, true);
            return;
        }
        if (bVar2.f336587h * 1000 < System.currentTimeMillis()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "mtuTest expired, stop test mtuTest.dwExpirTime:" + this.f249259d.f336587h + "System.currentTimeMillis():" + System.currentTimeMillis());
            }
            a(g.a.f249347j, true);
            return;
        }
        if (this.f249259d.f336584e.size() == this.f249259d.f336583d.size() && this.f249259d.f336582c.size() == this.f249259d.f336583d.size()) {
            long j3 = this.f249259d.f336586g;
            if (j3 <= 0) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "mtuTest dwPkgNum too short, stop test mtuTest.dwPkgNum:" + this.f249259d.f336586g);
                }
                a(g.a.f249346i, true);
                return;
            }
            if (j3 * r0.f336582c.size() > 20) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
                }
                this.f249278w = false;
                a(g.a.f249349l, true);
                return;
            }
            for (int i17 = 0; i17 < this.f249259d.f336581b.size(); i17++) {
                try {
                    try {
                        this.f249274s.f249336y = new ArrayList();
                        g gVar4 = this.f249274s;
                        gVar4.f249322k = 0;
                        gVar4.f249325n = 0;
                        gVar4.f249323l = 0;
                        gVar4.f249324m = 0;
                        gVar4.f249326o = 0;
                        gVar4.f249314c.clear();
                        this.f249274s.f249333v.clear();
                        try {
                            this.f249274s.f249319h = NetConnInfoCenter.getWifiStrength();
                            this.f249274s.f249321j = NetConnInfoCenter.getCdmaStrength();
                            this.f249274s.f249320i = NetConnInfoCenter.getGsmStrength();
                        } catch (Exception unused) {
                            if (QLog.isDevelopLevel()) {
                                QLog.d("MSF.C.QualityTestManager", 4, "failed to get network strength");
                            }
                        }
                        boolean z18 = false;
                        for (int i18 = 0; i18 < this.f249259d.f336582c.size(); i18++) {
                            if (this.f249259d.f336582c.get(i18).length < 8) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, stop test qualityTestMsg.sPkgData.length");
                                }
                                a(g.a.f249346i);
                            } else {
                                if (this.f249259d.f336584e.get(i18) != null && this.f249259d.f336584e.get(i18).length > 0) {
                                    i3 = this.f249259d.f336584e.get(i18).length;
                                } else {
                                    i3 = 0;
                                }
                                long j16 = i3;
                                long length = this.f249259d.f336582c.get(i18).length;
                                long longValue = this.f249259d.f336583d.get(i18).longValue();
                                Long.signum(length);
                                int i19 = (int) (j16 + (length * longValue));
                                QLog.d("MSF.C.QualityTestManager", 1, "mtu allbodylength " + i19);
                                if (i19 > 262144 && this.f249257b == EnumC8091d.f249285a) {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i19 + " return ");
                                    }
                                    a(g.a.f249345h);
                                } else if (i19 > 262144) {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i19 + " return ");
                                    }
                                    this.f249278w = false;
                                    a(g.a.f249345h);
                                } else if (this.f249259d.f336585f < 10) {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgInterval too small " + this.f249259d.f336585f + " return ");
                                    }
                                    a(g.a.f249344g);
                                } else {
                                    int i26 = 0;
                                    while (true) {
                                        long j17 = i26;
                                        com.tencent.msf.service.protocol.push.h.b bVar3 = this.f249259d;
                                        if (j17 >= bVar3.f336586g) {
                                            break;
                                        }
                                        if (!z18) {
                                            if (!a(bVar3.f336581b.get(i17))) {
                                                if (QLog.isDevelopLevel()) {
                                                    QLog.d("MSF.C.QualityTestManager", 4, "connectToServer error, return ");
                                                }
                                                a(g.a.f249340c);
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
                                        if (this.f249259d.f336584e.get(i18) != null && this.f249259d.f336584e.get(i18).length > 0) {
                                            allocate.put(this.f249259d.f336584e.get(i18));
                                        }
                                        for (int i27 = 0; i27 < this.f249259d.f336583d.get(i18).longValue(); i27++) {
                                            allocate.put(this.f249259d.f336582c.get(i18));
                                        }
                                        allocate.flip();
                                        allocate.get(bArr);
                                        int a16 = com.tencent.mobileqq.msf.core.c.a(bArr, 0);
                                        if (a16 != i19) {
                                            if (QLog.isDevelopLevel()) {
                                                QLog.d("MSF.C.QualityTestManager", 4, "testdata length error stop dataTotalLen:" + a16 + " receBodySize:" + i19);
                                            }
                                            a(g.a.f249343f);
                                            z18 = z17;
                                        } else {
                                            if (b(bArr)) {
                                                if (!a(i19, bArr)) {
                                                    this.f249274s.f249333v.add(Integer.valueOf(i19));
                                                }
                                                try {
                                                    LockMethodProxy.sleep(this.f249259d.f336585f);
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
                                    this.f249274s.f249336y.add(Integer.valueOf(i19));
                                }
                            }
                        }
                        a();
                        if (i17 == this.f249259d.f336581b.size() - 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        a(g.a.f249338a, z16);
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
        a(g.a.f249346i, true);
    }

    private void h() {
        int i3;
        boolean z16;
        boolean z17;
        if (this.f249258c == null) {
            a(g.a.f249348k, true);
            return;
        }
        c();
        this.f249274s.f249329r = this.f249258c.f336591a;
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.QualityTestManager", 2, "cProtoType:" + ((int) this.f249258c.f336591a) + " IpPort.size():" + this.f249258c.f336592b.size() + " cDomainToIpMode:" + ((int) this.f249258c.f336608r) + " strRspMatchPattern" + this.f249258c.f336610t + " strUserInfo:" + this.f249258c.f336611u + " dwRecvCopyStart" + this.f249258c.f336613w + " dwRecvCopyLen" + this.f249258c.f336614x + " strDnsSrvInfo:" + this.f249275t.f249303j + " dwLocationTime:" + this.f249275t.f249305l + " strAxis:" + this.f249275t.f249306m);
        }
        if (this.f249258c.f336592b.size() > 10) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
            }
            this.f249278w = false;
            a(g.a.f249350m, true);
            return;
        }
        if (this.f249258c.f336592b.size() <= 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
            }
            this.f249278w = false;
            a(g.a.f249351n, true);
            return;
        }
        if (this.f249258c.f336598h * 1000 < System.currentTimeMillis()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg expired, stop test qualityTestMsg.dwExpirTime:" + this.f249258c.f336598h + "System.currentTimeMillis():" + System.currentTimeMillis());
            }
            a(g.a.f249347j, true);
            return;
        }
        long j3 = this.f249258c.f336599i;
        if (j3 > 0 && j3 < JoinTimeType.THIRTY_MINUTES) {
            i3 = ((int) j3) * 1000;
        } else {
            i3 = GuildFeedPreviewCustomization.DEFAULT_CHOOSE_VIDEO_DURATION;
        }
        for (int i16 = 0; i16 < this.f249258c.f336592b.size(); i16++) {
            try {
                try {
                    try {
                        this.f249274s.f249318g = NetConnInfoCenter.getSystemNetworkType();
                        this.f249274s.f249319h = NetConnInfoCenter.getWifiStrength();
                        this.f249274s.f249321j = NetConnInfoCenter.getCdmaStrength();
                        this.f249274s.f249320i = NetConnInfoCenter.getGsmStrength();
                        this.f249271p = com.tencent.qphone.base.util.e.a(this.f249258c.f336592b.get(i16));
                    } catch (Exception e16) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("MSF.C.QualityTestManager", 4, "failed to get network info", e16);
                        }
                    }
                    this.f249274s.K = this.f249271p.getHostAddress();
                    this.f249274s.C = this.f249258c.f336592b.get(i16).f336574c;
                    String str = this.f249274s.C;
                    if (str == null || str.isEmpty()) {
                        g gVar = this.f249274s;
                        gVar.C = gVar.K;
                    }
                    this.f249274s.f249314c.clear();
                    g gVar2 = this.f249274s;
                    String str2 = gVar2.C;
                    gVar2.M = System.currentTimeMillis();
                    com.tencent.mobileqq.msf.core.net.t.e eVar = new com.tencent.mobileqq.msf.core.net.t.e(str2, true, i3);
                    int i17 = b.f249283a[this.f249257b.ordinal()];
                    String str3 = "";
                    if (i17 != 5) {
                        if (i17 == 6) {
                            e.a d16 = eVar.d();
                            if (d16 != null && d16.f249380b) {
                                str3 = d16.f249382d;
                                if (!TextUtils.isEmpty(d16.f249381c)) {
                                    this.f249274s.K = d16.f249381c;
                                }
                            }
                            z16 = false;
                        }
                        z16 = true;
                    } else {
                        ArrayList<com.tencent.msf.service.protocol.push.h.c> arrayList = this.f249258c.f336612v;
                        if (arrayList != null && arrayList.size() > 0) {
                            Iterator<com.tencent.msf.service.protocol.push.h.c> it = this.f249258c.f336612v.iterator();
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
                                this.f249274s.K = c16.f249381c;
                            }
                            z16 = true;
                        }
                        z16 = false;
                    }
                    this.f249274s.R = com.tencent.qphone.base.util.e.b(str3);
                    g gVar3 = this.f249274s;
                    gVar3.Q = gVar3.R.length();
                    this.f249274s.N = System.currentTimeMillis();
                    if (i16 == this.f249258c.f336592b.size() - 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 2, "testsuccess: " + z16 + ",isUpload:" + z17);
                    }
                    if (z16) {
                        a(g.a.f249338a, z17);
                    } else {
                        a(g.a.f249339b, z17);
                    }
                } catch (Exception e17) {
                    QLog.d("MSF.C.QualityTestManager", 1, "networkDetectRun: error ", e17);
                }
            } finally {
                com.tencent.mobileqq.msf.core.net.t.g.a();
            }
        }
    }

    private static void k() {
        try {
            TrustManager[] trustManagerArr = {new c()};
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e16) {
            QLog.e("MSF.C.QualityTestManager", 1, "trustallhost error! ", e16);
        }
    }

    private boolean l() {
        int i3;
        byte[] bArr = this.f249258c.f336597g;
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

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f249273r;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:413|(3:430|431|(9:433|434|436|(1:438)|439|397|367|(6:372|(1:374)(1:386)|375|(1:377)(1:385)|(1:379)(1:384)|(2:381|382)(1:383))(2:369|370)|371))|415|416|417|418|(2:420|(1:422)(22:424|339|161|162|163|164|165|166|167|(1:169)(1:317)|170|(6:248|249|250|(6:252|253|254|255|256|257)(1:313)|258|(1:306)(6:262|263|(4:267|268|(5:270|271|272|(2:274|(2:276|(1:278)(1:288))(1:290))(2:291|292)|289)|299)|300|279|(2:281|282)))(1:172)|173|174|175|176|(1:178)(2:184|(3:188|189|(4:191|(1:193)(1:211)|194|195)(2:212|(2:215|(1:244)(4:219|(1:241)(2:223|(3:225|226|227)(1:240))|228|(6:232|233|180|181|182|183)(9:230|231|201|202|203|204|205|206|183)))))(1:187))|179|180|181|182|183))(1:425)|423|161|162|163|164|165|166|167|(0)(0)|170|(0)(0)|173|174|175|176|(0)(0)|179|180|181|182|183) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:(2:150|151)|(3:410|411|(28:413|(3:430|431|(9:433|434|436|(1:438)|439|397|367|(6:372|(1:374)(1:386)|375|(1:377)(1:385)|(1:379)(1:384)|(2:381|382)(1:383))(2:369|370)|371))|415|416|417|418|(2:420|(1:422)(22:424|339|161|162|163|164|165|166|167|(1:169)(1:317)|170|(6:248|249|250|(6:252|253|254|255|256|257)(1:313)|258|(1:306)(6:262|263|(4:267|268|(5:270|271|272|(2:274|(2:276|(1:278)(1:288))(1:290))(2:291|292)|289)|299)|300|279|(2:281|282)))(1:172)|173|174|175|176|(1:178)(2:184|(3:188|189|(4:191|(1:193)(1:211)|194|195)(2:212|(2:215|(1:244)(4:219|(1:241)(2:223|(3:225|226|227)(1:240))|228|(6:232|233|180|181|182|183)(9:230|231|201|202|203|204|205|206|183)))))(1:187))|179|180|181|182|183))(1:425)|423|161|162|163|164|165|166|167|(0)(0)|170|(0)(0)|173|174|175|176|(0)(0)|179|180|181|182|183))|153|154|155|156|(4:334|335|336|(3:340|341|(9:390|391|393|(1:395)|396|397|367|(0)(0)|371)(29:343|344|345|346|(8:348|(1:350)|351|(1:353)|354|359|360|361)(7:362|363|(1:365)|366|367|(0)(0)|371)|356|357|358|331|(1:333)|162|163|164|165|166|167|(0)(0)|170|(0)(0)|173|174|175|176|(0)(0)|179|180|181|182|183))(22:338|339|161|162|163|164|165|166|167|(0)(0)|170|(0)(0)|173|174|175|176|(0)(0)|179|180|181|182|183))(23:158|159|160|161|162|163|164|165|166|167|(0)(0)|170|(0)(0)|173|174|175|176|(0)(0)|179|180|181|182|183)|147) */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x09a9, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x09aa, code lost:
    
        r35 = r2;
        r37 = r3;
        r36 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x09b6, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x09b7, code lost:
    
        r35 = r2;
        r37 = r3;
        r36 = r4;
        r38 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:408:0x0762, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:145:0x05d2 A[Catch: all -> 0x0a72, Exception -> 0x0a75, TRY_LEAVE, TryCatch #11 {Exception -> 0x0a75, blocks: (B:83:0x03a2, B:85:0x03a6, B:87:0x03a9, B:88:0x03ac, B:90:0x03b9, B:92:0x03bd, B:94:0x03c0, B:95:0x03c2, B:98:0x03e0, B:99:0x03e3, B:100:0x03e6, B:102:0x03f0, B:104:0x03f6, B:105:0x0416, B:109:0x0425, B:112:0x0433, B:115:0x049d, B:367:0x0a12, B:372:0x0a22, B:375:0x0a32, B:377:0x0a38, B:379:0x0a52, B:381:0x0a5f, B:384:0x0a58, B:331:0x076e, B:333:0x0774, B:180:0x09a0, B:183:0x09f2, B:201:0x09cd, B:210:0x09db, B:326:0x09fe, B:327:0x0a01, B:143:0x05cc, B:145:0x05d2, B:512:0x0490, B:514:0x0496), top: B:82:0x03a2, outer: #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x05e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x07a9  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0872  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0883 A[Catch: Exception -> 0x0892, all -> 0x09b3, TRY_ENTER, TryCatch #17 {all -> 0x09b3, blocks: (B:164:0x077f, B:167:0x079f, B:249:0x07b2, B:254:0x07bc, B:257:0x07ca, B:279:0x083e, B:282:0x0844, B:175:0x087b, B:178:0x0883, B:187:0x0899, B:189:0x08a7, B:191:0x08bb, B:193:0x08c1, B:195:0x08ca, B:200:0x09c3, B:215:0x0906, B:217:0x090c, B:219:0x0940, B:227:0x094f, B:228:0x095b, B:233:0x0961, B:230:0x0981, B:241:0x0958, B:242:0x0910, B:244:0x0916, B:298:0x082b, B:295:0x0836), top: B:163:0x077f }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0894  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x07b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0844 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x07ab  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0774 A[Catch: all -> 0x0a72, Exception -> 0x0a75, TRY_LEAVE, TryCatch #11 {Exception -> 0x0a75, blocks: (B:83:0x03a2, B:85:0x03a6, B:87:0x03a9, B:88:0x03ac, B:90:0x03b9, B:92:0x03bd, B:94:0x03c0, B:95:0x03c2, B:98:0x03e0, B:99:0x03e3, B:100:0x03e6, B:102:0x03f0, B:104:0x03f6, B:105:0x0416, B:109:0x0425, B:112:0x0433, B:115:0x049d, B:367:0x0a12, B:372:0x0a22, B:375:0x0a32, B:377:0x0a38, B:379:0x0a52, B:381:0x0a5f, B:384:0x0a58, B:331:0x076e, B:333:0x0774, B:180:0x09a0, B:183:0x09f2, B:201:0x09cd, B:210:0x09db, B:326:0x09fe, B:327:0x0a01, B:143:0x05cc, B:145:0x05d2, B:512:0x0490, B:514:0x0496), top: B:82:0x03a2, outer: #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0692 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0a20  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0a22 A[Catch: all -> 0x0a72, Exception -> 0x0a75, TryCatch #11 {Exception -> 0x0a75, blocks: (B:83:0x03a2, B:85:0x03a6, B:87:0x03a9, B:88:0x03ac, B:90:0x03b9, B:92:0x03bd, B:94:0x03c0, B:95:0x03c2, B:98:0x03e0, B:99:0x03e3, B:100:0x03e6, B:102:0x03f0, B:104:0x03f6, B:105:0x0416, B:109:0x0425, B:112:0x0433, B:115:0x049d, B:367:0x0a12, B:372:0x0a22, B:375:0x0a32, B:377:0x0a38, B:379:0x0a52, B:381:0x0a5f, B:384:0x0a58, B:331:0x076e, B:333:0x0774, B:180:0x09a0, B:183:0x09f2, B:201:0x09cd, B:210:0x09db, B:326:0x09fe, B:327:0x0a01, B:143:0x05cc, B:145:0x05d2, B:512:0x0490, B:514:0x0496), top: B:82:0x03a2, outer: #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:410:0x05ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i() {
        int i3;
        String str;
        Exception exc;
        long j3;
        boolean z16;
        long j16;
        int i16;
        int i17;
        String str2;
        String str3;
        String str4;
        boolean z17;
        boolean z18;
        char c16;
        Exception exc2;
        boolean z19;
        String str5;
        String str6;
        String str7;
        boolean z26;
        Exception exc3;
        boolean z27;
        int i18;
        int activeNetIpFamily;
        int i19;
        InetAddress[] inetAddressArr;
        int length;
        long j17;
        long j18;
        char c17;
        char c18;
        long j19;
        long j26;
        long j27;
        char c19;
        String str8 = "#";
        String str9 = "lost wifi connection, give up qualitytest run_thread";
        String str10 = "NotWiFi";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f249262g = false;
        if (this.f249258c == null) {
            a(g.a.f249348k, true);
            com.tencent.mobileqq.msf.core.net.t.g.a();
            return;
        }
        c();
        g gVar = this.f249274s;
        gVar.f249312a = g.b.f249364a;
        com.tencent.msf.service.protocol.push.h.d dVar = this.f249258c;
        gVar.f249329r = dVar.f336591a;
        gVar.f249330s = dVar.f336593c;
        gVar.f249331t = dVar.f336594d;
        gVar.f249332u = new ArrayList();
        this.f249274s.f249332u.add(Long.valueOf(this.f249258c.f336596f));
        g gVar2 = this.f249274s;
        gVar2.f249334w = this.f249258c.f336598h;
        gVar2.B = r8.f336605o;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" cProtoType:");
            sb5.append(this.f249258c.f336594d);
            sb5.append(" PkgInterval:");
            sb5.append(this.f249258c.f336594d);
            sb5.append(" IpPort.size():");
            sb5.append(this.f249258c.f336592b.size());
            sb5.append(" PkgNum:");
            sb5.append(this.f249258c.f336593c);
            sb5.append(" HeadData.length:");
            byte[] bArr = this.f249258c.f336597g;
            sb5.append(bArr != null ? Integer.valueOf(bArr.length) : "null");
            sb5.append(" TailData.length:");
            byte[] bArr2 = this.f249258c.f336606p;
            sb5.append(bArr2 != null ? Integer.valueOf(bArr2.length) : "null");
            sb5.append(" RepeatTimes:");
            sb5.append(this.f249258c.f336596f);
            sb5.append(" PkgData.length:");
            byte[] bArr3 = this.f249258c.f336595e;
            sb5.append(bArr3 != null ? Integer.valueOf(bArr3.length) : "null");
            sb5.append(" cDomainToIpMode:");
            sb5.append((int) this.f249258c.f336608r);
            sb5.append(" dwTaskType:");
            sb5.append(this.f249258c.f336600j);
            sb5.append(" dwTaskTime:");
            sb5.append(this.f249258c.f336601k);
            sb5.append(" dwReserved1:");
            sb5.append(this.f249258c.f336602l);
            sb5.append(" dwReserved2:");
            sb5.append(this.f249258c.f336603m);
            sb5.append(" dwRecvLen:");
            sb5.append(this.f249258c.f336604n);
            sb5.append(" cTestType:");
            sb5.append((int) this.f249258c.f336605o);
            sb5.append(" strUserInfo:");
            sb5.append(this.f249258c.f336611u);
            sb5.append(" strDnsSrvInfo:");
            sb5.append(this.f249275t.f249303j);
            sb5.append(" dwLocationTime:");
            sb5.append(this.f249275t.f249305l);
            sb5.append(" strAxis:");
            sb5.append(this.f249275t.f249306m);
            sb5.append(" sPkgData:");
            sb5.append(Arrays.toString(this.f249258c.f336595e));
            sb5.append(" cHttpsFunction");
            sb5.append((int) this.f249258c.f336615y);
            QLog.d("MSF.C.QualityTestManager", 2, sb5.toString());
        }
        int i26 = this.f249260e;
        if (i26 <= 1) {
            if (i26 == 1) {
                com.tencent.msf.service.protocol.push.h.d dVar2 = this.f249258c;
                if ((dVar2.f336603m & 255) == 1) {
                    i3 = i26;
                } else if (dVar2.f336592b.size() > 75) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
                    }
                    this.f249278w = false;
                    a(g.a.f249350m, true);
                    com.tencent.mobileqq.msf.core.net.t.g.a();
                    return;
                }
            } else {
                i3 = i26;
            }
            if (i3 == 1) {
                com.tencent.msf.service.protocol.push.h.d dVar3 = this.f249258c;
                if ((dVar3.f336603m & 255) == 1 && dVar3.f336592b.size() > 200) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much for WiFi test, return ");
                    }
                    this.f249278w = false;
                    a(g.a.f249350m, true);
                    com.tencent.mobileqq.msf.core.net.t.g.a();
                    return;
                }
            }
        } else if (this.f249258c.f336592b.size() > 200) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much for WiFi test, return ");
            }
            this.f249278w = false;
            a(g.a.f249350m, true);
            com.tencent.mobileqq.msf.core.net.t.g.a();
            return;
        }
        if (this.f249258c.f336592b.size() <= 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
            }
            a(g.a.f249351n, true);
            com.tencent.mobileqq.msf.core.net.t.g.a();
            return;
        }
        com.tencent.msf.service.protocol.push.h.d dVar4 = this.f249258c;
        String str11 = "IPPort size too much, return ";
        if (dVar4.f336596f <= 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "dwRepeatTimes must > 0");
            }
            a(g.a.f249354q, true);
            com.tencent.mobileqq.msf.core.net.t.g.a();
            return;
        }
        int i27 = 1;
        int i28 = this.f249260e;
        if (i28 <= 1) {
            if (i28 == 1) {
                if ((dVar4.f336603m & 255) == 1) {
                    i27 = 1;
                } else if (dVar4.f336593c > 20) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
                    }
                    this.f249278w = false;
                    a(g.a.f249349l, true);
                    com.tencent.mobileqq.msf.core.net.t.g.a();
                    return;
                }
            }
            if (i28 == i27 && (dVar4.f336603m & 255) == 1 && dVar4.f336593c > 50) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much for WiFi test, return ");
                }
                this.f249278w = false;
                a(g.a.f249349l, true);
                com.tencent.mobileqq.msf.core.net.t.g.a();
                return;
            }
        } else if (dVar4.f336593c > 50) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much for WiFi test, return ");
            }
            this.f249278w = false;
            a(g.a.f249349l, true);
            com.tencent.mobileqq.msf.core.net.t.g.a();
            return;
        }
        char c26 = '\b';
        if (((dVar4.f336603m >> 8) & 255) > 20) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "dwReserved2>>8 &0xFF too much, return ");
            }
            this.f249278w = false;
            a(g.a.f249349l, true);
            com.tencent.mobileqq.msf.core.net.t.g.a();
            return;
        }
        if (dVar4.f336598h * 1000 < System.currentTimeMillis()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg expired, stop test qualityTestMsg.dwExpirTime:" + this.f249258c.f336598h + "System.currentTimeMillis():" + System.currentTimeMillis());
            }
            a(g.a.f249347j, true);
            com.tencent.mobileqq.msf.core.net.t.g.a();
            return;
        }
        com.tencent.msf.service.protocol.push.h.d dVar5 = this.f249258c;
        short s16 = dVar5.f336605o;
        if (s16 != 0 && 1 != s16 && 2 != s16) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.QualityTestManager", 2, "qualityTestMsg.cTestType " + ((int) this.f249258c.f336605o) + " NoSupport");
            }
            a(g.a.f249360w, true);
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
                int i29 = (int) (length2 + (length3 * j28));
                byte[] bArr5 = dVar5.f336606p;
                if (bArr5 != null && bArr5.length > 0) {
                    i29 += bArr5.length;
                }
                QLog.d("MSF.C.QualityTestManager", 1, "allbodylength " + i29);
                if (this.f249257b == EnumC8091d.f249287c) {
                    if (i29 == 0) {
                        this.f249269n = 1;
                    } else {
                        this.f249269n = 0;
                    }
                }
                if (this.f249258c.f336594d < 10) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgInterval too small " + this.f249258c.f336594d + " return ");
                    }
                    a(g.a.f249344g, true);
                    com.tencent.mobileqq.msf.core.net.t.g.a();
                    com.tencent.mobileqq.msf.core.net.t.g.a();
                    return;
                }
                int i36 = 0;
                boolean z28 = false;
                while (true) {
                    if (i36 >= this.f249258c.f336592b.size() || z28) {
                        break;
                    }
                    this.f249274s.f249336y = new ArrayList();
                    g gVar3 = this.f249274s;
                    gVar3.f249322k = 0;
                    gVar3.f249325n = 0;
                    gVar3.f249323l = 0;
                    gVar3.f249324m = 0;
                    gVar3.f249326o = 0;
                    gVar3.f249314c.clear();
                    g gVar4 = this.f249274s;
                    gVar4.f249335x = false;
                    gVar4.A = null;
                    gVar4.I.clear();
                    this.f249274s.J.clear();
                    g gVar5 = this.f249274s;
                    gVar5.f249315d = null;
                    gVar5.D = 0L;
                    gVar5.E = 0;
                    gVar5.F = 0;
                    gVar5.G = 0;
                    try {
                        gVar5.f249318g = NetConnInfoCenter.getSystemNetworkType();
                        this.f249274s.f249319h = NetConnInfoCenter.getWifiStrength();
                        this.f249274s.f249321j = NetConnInfoCenter.getCdmaStrength();
                        this.f249274s.f249320i = NetConnInfoCenter.getGsmStrength();
                    } catch (Exception unused) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("MSF.C.QualityTestManager", 4, "failed to get network strength");
                        }
                    }
                    this.G = 0L;
                    this.I = 0L;
                    this.H = 0L;
                    this.J = 0L;
                    try {
                    } catch (Exception e16) {
                        e = e16;
                        str = str11;
                    }
                    if (NetConnInfoCenter.isWifiConn()) {
                        try {
                        } catch (Exception e17) {
                            exc = e17;
                            str = str11;
                        }
                        if (NetConnInfoCenter.getWifiStrength() > 10) {
                            if (com.tencent.mobileqq.msf.core.net.t.g.f249397e.equals(str10) && this.f249261f != 0) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("MSF.C.QualityTestManager", 2, str9 + Thread.currentThread().getName());
                                }
                            } else {
                                com.tencent.msf.service.protocol.push.h.d dVar6 = this.f249258c;
                                j19 = dVar6.f336603m;
                                if ((j19 & 255) == 1) {
                                    int i37 = this.f249260e;
                                    if (i37 > 1) {
                                        j26 = dVar6.f336593c / i37;
                                    } else {
                                        c19 = c26;
                                        str = str11;
                                        j3 = (j19 >> c19) & 255;
                                        z16 = z28;
                                        j16 = j3;
                                        boolean z29 = true;
                                        String str12 = str;
                                        i16 = i36;
                                        i17 = 0;
                                        for (int i38 = -1; i17 < j16 && i16 != i38; i38 = -1) {
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
                                                    if (com.tencent.mobileqq.msf.core.net.t.g.f249397e.equals(str10)) {
                                                        try {
                                                            if (this.f249261f != 0) {
                                                                try {
                                                                    i16 = this.f249258c.f336592b.size();
                                                                    if (QLog.isColorLevel()) {
                                                                        QLog.d("MSF.C.QualityTestManager", 2, str9 + this.f249261f);
                                                                    }
                                                                    str2 = str8;
                                                                    str3 = str9;
                                                                    str4 = str10;
                                                                    z18 = false;
                                                                    c16 = '\b';
                                                                    z17 = true;
                                                                    this.f249274s.f249336y.add(Integer.valueOf(i29));
                                                                    if (i16 != -1) {
                                                                        boolean z36 = i16 == this.f249258c.f336592b.size() - 1 ? true : z18;
                                                                        if (QLog.isColorLevel()) {
                                                                            QLog.d("MSF.C.QualityTestManager", 2, "testsuccess: " + z29);
                                                                        }
                                                                        if (z29) {
                                                                            a(g.a.f249338a, z36);
                                                                        } else {
                                                                            a(g.a.f249339b, z36);
                                                                        }
                                                                        if (z36) {
                                                                            this.f249262g = true;
                                                                        }
                                                                    }
                                                                    i36 = i16 + 1;
                                                                    str11 = str12;
                                                                    c26 = c16;
                                                                    z28 = z17;
                                                                    str8 = str2;
                                                                    str10 = str4;
                                                                    str9 = str3;
                                                                } catch (Exception e26) {
                                                                    exc2 = e26;
                                                                    z17 = true;
                                                                    if (QLog.isDevelopLevel()) {
                                                                    }
                                                                    z19 = z17;
                                                                    this.f249279x = 0L;
                                                                    this.f249280y = 0L;
                                                                    this.f249281z = 0L;
                                                                    this.A = 0L;
                                                                    this.B = 0L;
                                                                    this.C = 0L;
                                                                    this.D = 0L;
                                                                    this.E = 0L;
                                                                    com.tencent.msf.service.protocol.push.h.a aVar = this.f249258c.f336592b.get(i16);
                                                                    b(aVar);
                                                                    activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(false);
                                                                    if (!(this.f249271p instanceof Inet6Address)) {
                                                                    }
                                                                    String str13 = "";
                                                                    if (activeNetIpFamily < 2) {
                                                                    }
                                                                    String str14 = str13;
                                                                    try {
                                                                        if ((this.f249258c.f336608r & 2) != 2) {
                                                                        }
                                                                        z26 = z19;
                                                                        z29 = false;
                                                                        i18 = 1;
                                                                    } catch (Exception e27) {
                                                                        e = e27;
                                                                        z26 = z19;
                                                                        exc3 = e;
                                                                        z27 = z29;
                                                                        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient:  error:", exc3);
                                                                        exc3.printStackTrace();
                                                                        a();
                                                                        try {
                                                                            LockMethodProxy.sleep(this.f249258c.f336594d);
                                                                            i18 = 1;
                                                                        } catch (Exception e28) {
                                                                            i18 = 1;
                                                                            QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: Thread sleep error " + e28);
                                                                        }
                                                                        z29 = z27;
                                                                        i17 += i18;
                                                                        str8 = str5;
                                                                        str10 = str7;
                                                                        str9 = str6;
                                                                        z16 = z26;
                                                                    }
                                                                    i17 += i18;
                                                                    str8 = str5;
                                                                    str10 = str7;
                                                                    str9 = str6;
                                                                    z16 = z26;
                                                                }
                                                            }
                                                        } catch (Exception e29) {
                                                            exc2 = e29;
                                                            z17 = z16;
                                                            if (QLog.isDevelopLevel()) {
                                                            }
                                                            z19 = z17;
                                                            this.f249279x = 0L;
                                                            this.f249280y = 0L;
                                                            this.f249281z = 0L;
                                                            this.A = 0L;
                                                            this.B = 0L;
                                                            this.C = 0L;
                                                            this.D = 0L;
                                                            this.E = 0L;
                                                            com.tencent.msf.service.protocol.push.h.a aVar2 = this.f249258c.f336592b.get(i16);
                                                            b(aVar2);
                                                            activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(false);
                                                            if (!(this.f249271p instanceof Inet6Address)) {
                                                            }
                                                            String str132 = "";
                                                            if (activeNetIpFamily < 2) {
                                                            }
                                                            String str142 = str132;
                                                            if ((this.f249258c.f336608r & 2) != 2) {
                                                            }
                                                            z26 = z19;
                                                            z29 = false;
                                                            i18 = 1;
                                                            i17 += i18;
                                                            str8 = str5;
                                                            str10 = str7;
                                                            str9 = str6;
                                                            z16 = z26;
                                                        }
                                                    }
                                                    com.tencent.msf.service.protocol.push.h.d dVar7 = this.f249258c;
                                                    z17 = z16;
                                                    try {
                                                        try {
                                                            j17 = dVar7.f336603m;
                                                        } catch (Exception e36) {
                                                            e = e36;
                                                            exc2 = e;
                                                            if (QLog.isDevelopLevel()) {
                                                            }
                                                            z19 = z17;
                                                            this.f249279x = 0L;
                                                            this.f249280y = 0L;
                                                            this.f249281z = 0L;
                                                            this.A = 0L;
                                                            this.B = 0L;
                                                            this.C = 0L;
                                                            this.D = 0L;
                                                            this.E = 0L;
                                                            com.tencent.msf.service.protocol.push.h.a aVar22 = this.f249258c.f336592b.get(i16);
                                                            b(aVar22);
                                                            activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(false);
                                                            if (!(this.f249271p instanceof Inet6Address)) {
                                                            }
                                                            String str1322 = "";
                                                            if (activeNetIpFamily < 2) {
                                                            }
                                                            String str1422 = str1322;
                                                            if ((this.f249258c.f336608r & 2) != 2) {
                                                            }
                                                            z26 = z19;
                                                            z29 = false;
                                                            i18 = 1;
                                                            i17 += i18;
                                                            str8 = str5;
                                                            str10 = str7;
                                                            str9 = str6;
                                                            z16 = z26;
                                                        }
                                                        if ((j17 & 255) == 1) {
                                                            int i39 = this.f249260e;
                                                            if (i39 > 1) {
                                                                j18 = dVar7.f336593c / i39;
                                                            } else {
                                                                c17 = '\b';
                                                                j18 = (j17 >> c17) & 255;
                                                                j16 = j18;
                                                                z19 = z17;
                                                                this.f249279x = 0L;
                                                                this.f249280y = 0L;
                                                                this.f249281z = 0L;
                                                                this.A = 0L;
                                                                this.B = 0L;
                                                                this.C = 0L;
                                                                this.D = 0L;
                                                                this.E = 0L;
                                                                com.tencent.msf.service.protocol.push.h.a aVar222 = this.f249258c.f336592b.get(i16);
                                                                b(aVar222);
                                                                activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(false);
                                                                int i46 = !(this.f249271p instanceof Inet6Address) ? 2 : 1;
                                                                String str13222 = "";
                                                                if (activeNetIpFamily < 2) {
                                                                    try {
                                                                        str5 = str8;
                                                                        if (this.f249274s.E == 1) {
                                                                            i19 = activeNetIpFamily;
                                                                            try {
                                                                                str6 = str9;
                                                                                try {
                                                                                    com.tencent.mobileqq.msf.core.net.t.b.a().a(1, i19, this.f249274s.f249318g, i46, this.f249257b, aVar222.f336574c, "");
                                                                                } catch (Exception e37) {
                                                                                    e = e37;
                                                                                    exc3 = e;
                                                                                    str7 = str10;
                                                                                    z27 = z29;
                                                                                    z26 = z19;
                                                                                    QLog.d("MSF.C.QualityTestManager", 1, "QualityClient:  error:", exc3);
                                                                                    exc3.printStackTrace();
                                                                                    a();
                                                                                    LockMethodProxy.sleep(this.f249258c.f336594d);
                                                                                    i18 = 1;
                                                                                    z29 = z27;
                                                                                    i17 += i18;
                                                                                    str8 = str5;
                                                                                    str10 = str7;
                                                                                    str9 = str6;
                                                                                    z16 = z26;
                                                                                }
                                                                            } catch (Exception e38) {
                                                                                e = e38;
                                                                                str6 = str9;
                                                                            }
                                                                        } else {
                                                                            str6 = str9;
                                                                            i19 = activeNetIpFamily;
                                                                        }
                                                                        if (i19 == 2 && i46 == 1) {
                                                                            try {
                                                                                InetAddress[] allByName = InetAddress.getAllByName("ipv4only.arpa");
                                                                                if (allByName != null && allByName.length > 0) {
                                                                                    int length4 = allByName.length;
                                                                                    int i47 = 0;
                                                                                    while (i47 < length4) {
                                                                                        str7 = str10;
                                                                                        try {
                                                                                            InetAddress inetAddress = allByName[i47];
                                                                                            if (inetAddress != null) {
                                                                                                inetAddressArr = allByName;
                                                                                                if (inetAddress instanceof Inet6Address) {
                                                                                                    str13222 = inetAddress.getHostAddress();
                                                                                                    if (!TextUtils.isEmpty(str13222)) {
                                                                                                        break;
                                                                                                    }
                                                                                                } else {
                                                                                                    continue;
                                                                                                }
                                                                                            } else {
                                                                                                inetAddressArr = allByName;
                                                                                            }
                                                                                            i47++;
                                                                                            allByName = inetAddressArr;
                                                                                            str10 = str7;
                                                                                        } catch (UnknownHostException e39) {
                                                                                            e = e39;
                                                                                            QLog.d("MSF.C.QualityTestManager", 1, "nat64 detect error", e);
                                                                                            if (TextUtils.isEmpty(str13222)) {
                                                                                            }
                                                                                            String str14222 = str13222;
                                                                                            if ((this.f249258c.f336608r & 2) != 2) {
                                                                                            }
                                                                                            z26 = z19;
                                                                                            z29 = false;
                                                                                            i18 = 1;
                                                                                            i17 += i18;
                                                                                            str8 = str5;
                                                                                            str10 = str7;
                                                                                            str9 = str6;
                                                                                            z16 = z26;
                                                                                        } catch (Throwable th5) {
                                                                                            th = th5;
                                                                                            QLog.d("MSF.C.QualityTestManager", 1, "get nat64 address error", th);
                                                                                            if (TextUtils.isEmpty(str13222)) {
                                                                                            }
                                                                                            String str142222 = str13222;
                                                                                            if ((this.f249258c.f336608r & 2) != 2) {
                                                                                            }
                                                                                            z26 = z19;
                                                                                            z29 = false;
                                                                                            i18 = 1;
                                                                                            i17 += i18;
                                                                                            str8 = str5;
                                                                                            str10 = str7;
                                                                                            str9 = str6;
                                                                                            z16 = z26;
                                                                                        }
                                                                                    }
                                                                                }
                                                                                str7 = str10;
                                                                            } catch (UnknownHostException e46) {
                                                                                e = e46;
                                                                                str7 = str10;
                                                                            } catch (Throwable th6) {
                                                                                th = th6;
                                                                                str7 = str10;
                                                                            }
                                                                            if (TextUtils.isEmpty(str13222)) {
                                                                                try {
                                                                                    com.tencent.mobileqq.msf.core.net.t.b.a().a(2, i19, this.f249274s.f249318g, i46, this.f249257b, aVar222.f336574c, str13222);
                                                                                } catch (Exception e47) {
                                                                                    e = e47;
                                                                                    exc3 = e;
                                                                                    z27 = z29;
                                                                                    z26 = z19;
                                                                                    QLog.d("MSF.C.QualityTestManager", 1, "QualityClient:  error:", exc3);
                                                                                    exc3.printStackTrace();
                                                                                    a();
                                                                                    LockMethodProxy.sleep(this.f249258c.f336594d);
                                                                                    i18 = 1;
                                                                                    z29 = z27;
                                                                                    i17 += i18;
                                                                                    str8 = str5;
                                                                                    str10 = str7;
                                                                                    str9 = str6;
                                                                                    z16 = z26;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            str7 = str10;
                                                                        }
                                                                    } catch (Exception e48) {
                                                                        e = e48;
                                                                        str5 = str8;
                                                                        str6 = str9;
                                                                        str7 = str10;
                                                                    }
                                                                } else {
                                                                    str5 = str8;
                                                                    str6 = str9;
                                                                    str7 = str10;
                                                                    i19 = activeNetIpFamily;
                                                                }
                                                                String str1422222 = str13222;
                                                                if ((this.f249258c.f336608r & 2) != 2) {
                                                                    a(g.a.f249363z);
                                                                    this.f249274s.f249330s = 0L;
                                                                } else if (i46 == 2 && i19 < 2) {
                                                                    a(g.a.B);
                                                                    this.f249274s.f249330s = 0L;
                                                                } else {
                                                                    boolean a16 = a(i29);
                                                                    com.tencent.msf.service.protocol.push.h.d dVar8 = this.f249258c;
                                                                    byte[] a17 = a(i29, dVar8.f336597g, dVar8.f336606p);
                                                                    if (!a(aVar222)) {
                                                                        if (QLog.isDevelopLevel()) {
                                                                            QLog.d("MSF.C.QualityTestManager", 4, "connectToServer error, return ");
                                                                        }
                                                                        try {
                                                                            this.f249274s.J.add(-1L);
                                                                            a(g.a.f249340c);
                                                                            com.tencent.mobileqq.msf.core.net.t.b.a().a(3, i19, this.f249274s.f249318g, i46, this.f249257b, aVar222.f336574c, str1422222);
                                                                        } catch (Exception e49) {
                                                                            exc3 = e49;
                                                                            z26 = z19;
                                                                            z27 = false;
                                                                            QLog.d("MSF.C.QualityTestManager", 1, "QualityClient:  error:", exc3);
                                                                            exc3.printStackTrace();
                                                                            a();
                                                                            LockMethodProxy.sleep(this.f249258c.f336594d);
                                                                            i18 = 1;
                                                                            z29 = z27;
                                                                            i17 += i18;
                                                                            str8 = str5;
                                                                            str10 = str7;
                                                                            str9 = str6;
                                                                            z16 = z26;
                                                                        }
                                                                    } else if (a16 && a17 != null) {
                                                                        if ((this.f249257b != EnumC8091d.f249287c || this.f249269n == 0) && !b(a17)) {
                                                                            this.f249274s.J.add(-1L);
                                                                            com.tencent.mobileqq.msf.core.net.t.b.a().a(4, i19, this.f249274s.f249318g, i46, this.f249257b, aVar222.f336574c, str1422222);
                                                                        } else {
                                                                            com.tencent.msf.service.protocol.push.h.d dVar9 = this.f249258c;
                                                                            short s17 = dVar9.f336605o;
                                                                            if (s17 == 0 || 1 == s17) {
                                                                                z26 = z19;
                                                                                length = a17.length;
                                                                            } else if (2 == s17) {
                                                                                z26 = z19;
                                                                                try {
                                                                                    length = (int) dVar9.f336604n;
                                                                                } catch (Exception e56) {
                                                                                    e = e56;
                                                                                    exc3 = e;
                                                                                    z27 = z29;
                                                                                    QLog.d("MSF.C.QualityTestManager", 1, "QualityClient:  error:", exc3);
                                                                                    exc3.printStackTrace();
                                                                                    a();
                                                                                    LockMethodProxy.sleep(this.f249258c.f336594d);
                                                                                    i18 = 1;
                                                                                    z29 = z27;
                                                                                    i17 += i18;
                                                                                    str8 = str5;
                                                                                    str10 = str7;
                                                                                    str9 = str6;
                                                                                    z16 = z26;
                                                                                }
                                                                            } else {
                                                                                z26 = z19;
                                                                                length = 0;
                                                                            }
                                                                            if (!a(length, a17)) {
                                                                                try {
                                                                                    com.tencent.mobileqq.msf.core.net.t.b.a().a(5, i19, this.f249274s.f249318g, i46, this.f249257b, aVar222.f336574c, str1422222);
                                                                                    z29 = false;
                                                                                    i18 = 1;
                                                                                } catch (Exception e57) {
                                                                                    exc3 = e57;
                                                                                    z27 = false;
                                                                                    QLog.d("MSF.C.QualityTestManager", 1, "QualityClient:  error:", exc3);
                                                                                    exc3.printStackTrace();
                                                                                    a();
                                                                                    LockMethodProxy.sleep(this.f249258c.f336594d);
                                                                                    i18 = 1;
                                                                                    z29 = z27;
                                                                                    i17 += i18;
                                                                                    str8 = str5;
                                                                                    str10 = str7;
                                                                                    str9 = str6;
                                                                                    z16 = z26;
                                                                                }
                                                                                i17 += i18;
                                                                                str8 = str5;
                                                                                str10 = str7;
                                                                                str9 = str6;
                                                                                z16 = z26;
                                                                            } else {
                                                                                com.tencent.mobileqq.msf.core.net.t.b.a().a(0, i19, this.f249274s.f249318g, i46, this.f249257b, aVar222.f336574c, str1422222);
                                                                                z27 = z29;
                                                                                a();
                                                                                LockMethodProxy.sleep(this.f249258c.f336594d);
                                                                                i18 = 1;
                                                                                z29 = z27;
                                                                                i17 += i18;
                                                                                str8 = str5;
                                                                                str10 = str7;
                                                                                str9 = str6;
                                                                                z16 = z26;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                z26 = z19;
                                                                z29 = false;
                                                                i18 = 1;
                                                                i17 += i18;
                                                                str8 = str5;
                                                                str10 = str7;
                                                                str9 = str6;
                                                                z16 = z26;
                                                            }
                                                        } else {
                                                            j18 = dVar7.f336593c;
                                                        }
                                                        this.f249279x = 0L;
                                                        this.f249280y = 0L;
                                                        this.f249281z = 0L;
                                                        this.A = 0L;
                                                        this.B = 0L;
                                                        this.C = 0L;
                                                        this.D = 0L;
                                                        this.E = 0L;
                                                        com.tencent.msf.service.protocol.push.h.a aVar2222 = this.f249258c.f336592b.get(i16);
                                                        b(aVar2222);
                                                        activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(false);
                                                        if (!(this.f249271p instanceof Inet6Address)) {
                                                        }
                                                        String str132222 = "";
                                                        if (activeNetIpFamily < 2) {
                                                        }
                                                        String str14222222 = str132222;
                                                        if ((this.f249258c.f336608r & 2) != 2) {
                                                        }
                                                        z26 = z19;
                                                        z29 = false;
                                                        i18 = 1;
                                                        i17 += i18;
                                                        str8 = str5;
                                                        str10 = str7;
                                                        str9 = str6;
                                                        z16 = z26;
                                                    } finally {
                                                        a();
                                                    }
                                                    j16 = j18;
                                                    z19 = z17;
                                                }
                                            }
                                            z17 = z16;
                                            com.tencent.mobileqq.msf.core.net.t.g.f249397e = str10;
                                            com.tencent.msf.service.protocol.push.h.d dVar10 = this.f249258c;
                                            j17 = dVar10.f336603m;
                                            if ((j17 & 255) == 1) {
                                                try {
                                                    j18 = dVar10.f336593c;
                                                    j16 = j18;
                                                } catch (Exception e58) {
                                                    e = e58;
                                                    exc2 = e;
                                                    if (QLog.isDevelopLevel()) {
                                                    }
                                                    z19 = z17;
                                                    this.f249279x = 0L;
                                                    this.f249280y = 0L;
                                                    this.f249281z = 0L;
                                                    this.A = 0L;
                                                    this.B = 0L;
                                                    this.C = 0L;
                                                    this.D = 0L;
                                                    this.E = 0L;
                                                    com.tencent.msf.service.protocol.push.h.a aVar22222 = this.f249258c.f336592b.get(i16);
                                                    b(aVar22222);
                                                    activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(false);
                                                    if (!(this.f249271p instanceof Inet6Address)) {
                                                    }
                                                    String str1322222 = "";
                                                    if (activeNetIpFamily < 2) {
                                                    }
                                                    String str142222222 = str1322222;
                                                    if ((this.f249258c.f336608r & 2) != 2) {
                                                    }
                                                    z26 = z19;
                                                    z29 = false;
                                                    i18 = 1;
                                                    i17 += i18;
                                                    str8 = str5;
                                                    str10 = str7;
                                                    str9 = str6;
                                                    z16 = z26;
                                                }
                                                z19 = z17;
                                                this.f249279x = 0L;
                                                this.f249280y = 0L;
                                                this.f249281z = 0L;
                                                this.A = 0L;
                                                this.B = 0L;
                                                this.C = 0L;
                                                this.D = 0L;
                                                this.E = 0L;
                                                com.tencent.msf.service.protocol.push.h.a aVar222222 = this.f249258c.f336592b.get(i16);
                                                b(aVar222222);
                                                activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(false);
                                                if (!(this.f249271p instanceof Inet6Address)) {
                                                }
                                                String str13222222 = "";
                                                if (activeNetIpFamily < 2) {
                                                }
                                                String str1422222222 = str13222222;
                                                if ((this.f249258c.f336608r & 2) != 2) {
                                                }
                                                z26 = z19;
                                                z29 = false;
                                                i18 = 1;
                                                i17 += i18;
                                                str8 = str5;
                                                str10 = str7;
                                                str9 = str6;
                                                z16 = z26;
                                            } else {
                                                try {
                                                } catch (Exception e59) {
                                                    e = e59;
                                                    exc2 = e;
                                                    if (QLog.isDevelopLevel()) {
                                                    }
                                                    z19 = z17;
                                                    this.f249279x = 0L;
                                                    this.f249280y = 0L;
                                                    this.f249281z = 0L;
                                                    this.A = 0L;
                                                    this.B = 0L;
                                                    this.C = 0L;
                                                    this.D = 0L;
                                                    this.E = 0L;
                                                    com.tencent.msf.service.protocol.push.h.a aVar2222222 = this.f249258c.f336592b.get(i16);
                                                    b(aVar2222222);
                                                    activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(false);
                                                    if (!(this.f249271p instanceof Inet6Address)) {
                                                    }
                                                    String str132222222 = "";
                                                    if (activeNetIpFamily < 2) {
                                                    }
                                                    String str14222222222 = str132222222;
                                                    if ((this.f249258c.f336608r & 2) != 2) {
                                                    }
                                                    z26 = z19;
                                                    z29 = false;
                                                    i18 = 1;
                                                    i17 += i18;
                                                    str8 = str5;
                                                    str10 = str7;
                                                    str9 = str6;
                                                    z16 = z26;
                                                }
                                                if (this.f249260e > 1) {
                                                    try {
                                                    } catch (Exception e65) {
                                                        exc2 = e65;
                                                    }
                                                    if (this.f249261f != 0) {
                                                        try {
                                                            i16 = dVar10.f336592b.size();
                                                            if (QLog.isColorLevel()) {
                                                                QLog.d("MSF.C.QualityTestManager", 2, str9 + this.f249261f);
                                                            }
                                                            str2 = str8;
                                                            str3 = str9;
                                                            str4 = str10;
                                                            z18 = false;
                                                            c16 = '\b';
                                                            z17 = true;
                                                            this.f249274s.f249336y.add(Integer.valueOf(i29));
                                                            if (i16 != -1) {
                                                            }
                                                            i36 = i16 + 1;
                                                            str11 = str12;
                                                            c26 = c16;
                                                            z28 = z17;
                                                            str8 = str2;
                                                            str10 = str4;
                                                            str9 = str3;
                                                        } catch (Exception e66) {
                                                            exc2 = e66;
                                                            z17 = true;
                                                            if (QLog.isDevelopLevel()) {
                                                            }
                                                            z19 = z17;
                                                            this.f249279x = 0L;
                                                            this.f249280y = 0L;
                                                            this.f249281z = 0L;
                                                            this.A = 0L;
                                                            this.B = 0L;
                                                            this.C = 0L;
                                                            this.D = 0L;
                                                            this.E = 0L;
                                                            com.tencent.msf.service.protocol.push.h.a aVar22222222 = this.f249258c.f336592b.get(i16);
                                                            b(aVar22222222);
                                                            activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(false);
                                                            if (!(this.f249271p instanceof Inet6Address)) {
                                                            }
                                                            String str1322222222 = "";
                                                            if (activeNetIpFamily < 2) {
                                                            }
                                                            String str142222222222 = str1322222222;
                                                            if ((this.f249258c.f336608r & 2) != 2) {
                                                            }
                                                            z26 = z19;
                                                            z29 = false;
                                                            i18 = 1;
                                                            i17 += i18;
                                                            str8 = str5;
                                                            str10 = str7;
                                                            str9 = str6;
                                                            z16 = z26;
                                                        }
                                                    } else {
                                                        try {
                                                            this.f249260e = 1;
                                                            c18 = 'K';
                                                            if (dVar10.f336592b.size() > 75) {
                                                                if (QLog.isDevelopLevel()) {
                                                                    QLog.d("MSF.C.QualityTestManager", 4, str12);
                                                                }
                                                                int indexOf = this.f249273r.indexOf(str8);
                                                                if (indexOf != -1) {
                                                                    this.f249273r = this.f249273r.substring(0, indexOf + 1);
                                                                }
                                                                this.f249274s.f249314c.clear();
                                                                this.f249278w = false;
                                                                a(g.a.f249350m, true);
                                                                com.tencent.mobileqq.msf.core.net.t.g.a();
                                                                com.tencent.mobileqq.msf.core.net.t.g.a();
                                                                return;
                                                            }
                                                            try {
                                                                long j29 = (this.f249258c.f336603m >> 8) & 255;
                                                                int indexOf2 = this.f249273r.indexOf(str8);
                                                                if (indexOf2 != -1) {
                                                                    this.f249273r = this.f249273r.substring(0, indexOf2 + 1);
                                                                }
                                                                str2 = str8;
                                                                str3 = str9;
                                                                str4 = str10;
                                                                i16 = -1;
                                                                z18 = false;
                                                                c16 = '\b';
                                                                this.f249274s.f249336y.add(Integer.valueOf(i29));
                                                                if (i16 != -1) {
                                                                }
                                                                i36 = i16 + 1;
                                                                str11 = str12;
                                                                c26 = c16;
                                                                z28 = z17;
                                                                str8 = str2;
                                                                str10 = str4;
                                                                str9 = str3;
                                                            } catch (Exception e67) {
                                                                e = e67;
                                                            }
                                                            e = e67;
                                                        } catch (Exception e68) {
                                                            e = e68;
                                                            c18 = 'K';
                                                        }
                                                        exc2 = e;
                                                        i17 = 0;
                                                        i16 = -1;
                                                        if (QLog.isDevelopLevel()) {
                                                            QLog.d("MSF.C.QualityTestManager", 4, "net change caused quality test error", exc2);
                                                        }
                                                        z19 = z17;
                                                        this.f249279x = 0L;
                                                        this.f249280y = 0L;
                                                        this.f249281z = 0L;
                                                        this.A = 0L;
                                                        this.B = 0L;
                                                        this.C = 0L;
                                                        this.D = 0L;
                                                        this.E = 0L;
                                                        com.tencent.msf.service.protocol.push.h.a aVar222222222 = this.f249258c.f336592b.get(i16);
                                                        b(aVar222222222);
                                                        activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(false);
                                                        if (!(this.f249271p instanceof Inet6Address)) {
                                                        }
                                                        String str13222222222 = "";
                                                        if (activeNetIpFamily < 2) {
                                                        }
                                                        String str1422222222222 = str13222222222;
                                                        if ((this.f249258c.f336608r & 2) != 2) {
                                                        }
                                                        z26 = z19;
                                                        z29 = false;
                                                        i18 = 1;
                                                        i17 += i18;
                                                        str8 = str5;
                                                        str10 = str7;
                                                        str9 = str6;
                                                        z16 = z26;
                                                    }
                                                } else {
                                                    c17 = '\b';
                                                    j18 = (j17 >> c17) & 255;
                                                    j16 = j18;
                                                    z19 = z17;
                                                    this.f249279x = 0L;
                                                    this.f249280y = 0L;
                                                    this.f249281z = 0L;
                                                    this.A = 0L;
                                                    this.B = 0L;
                                                    this.C = 0L;
                                                    this.D = 0L;
                                                    this.E = 0L;
                                                    com.tencent.msf.service.protocol.push.h.a aVar2222222222 = this.f249258c.f336592b.get(i16);
                                                    b(aVar2222222222);
                                                    activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(false);
                                                    if (!(this.f249271p instanceof Inet6Address)) {
                                                    }
                                                    String str132222222222 = "";
                                                    if (activeNetIpFamily < 2) {
                                                    }
                                                    String str14222222222222 = str132222222222;
                                                    if ((this.f249258c.f336608r & 2) != 2) {
                                                    }
                                                    z26 = z19;
                                                    z29 = false;
                                                    i18 = 1;
                                                    i17 += i18;
                                                    str8 = str5;
                                                    str10 = str7;
                                                    str9 = str6;
                                                    z16 = z26;
                                                }
                                            }
                                        }
                                        str2 = str8;
                                        str3 = str9;
                                        str4 = str10;
                                        z17 = z16;
                                        z18 = false;
                                        c16 = '\b';
                                        this.f249274s.f249336y.add(Integer.valueOf(i29));
                                        if (i16 != -1) {
                                        }
                                        i36 = i16 + 1;
                                        str11 = str12;
                                        c26 = c16;
                                        z28 = z17;
                                        str8 = str2;
                                        str10 = str4;
                                        str9 = str3;
                                    }
                                } else {
                                    j26 = dVar6.f336593c;
                                }
                                j27 = j26;
                                str = str11;
                                j3 = j27;
                                z16 = z28;
                                j16 = j3;
                                boolean z292 = true;
                                String str122 = str;
                                i16 = i36;
                                i17 = 0;
                                while (i17 < j16) {
                                    if (NetConnInfoCenter.isWifiConn()) {
                                    }
                                    z17 = z16;
                                    com.tencent.mobileqq.msf.core.net.t.g.f249397e = str10;
                                    com.tencent.msf.service.protocol.push.h.d dVar102 = this.f249258c;
                                    j17 = dVar102.f336603m;
                                    if ((j17 & 255) == 1) {
                                    }
                                }
                                str2 = str8;
                                str3 = str9;
                                str4 = str10;
                                z17 = z16;
                                z18 = false;
                                c16 = '\b';
                                this.f249274s.f249336y.add(Integer.valueOf(i29));
                                if (i16 != -1) {
                                }
                                i36 = i16 + 1;
                                str11 = str122;
                                c26 = c16;
                                z28 = z17;
                                str8 = str2;
                                str10 = str4;
                                str9 = str3;
                            }
                        }
                    }
                    com.tencent.mobileqq.msf.core.net.t.g.f249397e = str10;
                    com.tencent.msf.service.protocol.push.h.d dVar11 = this.f249258c;
                    j19 = dVar11.f336603m;
                    if ((j19 & 255) == 1) {
                        if (this.f249260e > 1) {
                            if (this.f249261f != 0) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("MSF.C.QualityTestManager", 2, str9 + Thread.currentThread().getName());
                                }
                            } else {
                                try {
                                    this.f249260e = 1;
                                } catch (Exception e69) {
                                    e = e69;
                                    str = str11;
                                }
                                if (dVar11.f336592b.size() > 75) {
                                    str = str11;
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("MSF.C.QualityTestManager", 4, str);
                                    }
                                    int indexOf3 = this.f249273r.indexOf(str8);
                                    if (indexOf3 != -1) {
                                        this.f249273r = this.f249273r.substring(0, indexOf3 + 1);
                                    }
                                    this.f249274s.f249314c.clear();
                                    this.f249278w = false;
                                    a(g.a.f249350m, true);
                                    com.tencent.mobileqq.msf.core.net.t.g.a();
                                    com.tencent.mobileqq.msf.core.net.t.g.a();
                                    return;
                                }
                                str = str11;
                                try {
                                    j3 = (this.f249258c.f336603m >> 8) & 255;
                                    try {
                                        int indexOf4 = this.f249273r.indexOf(str8);
                                        if (indexOf4 != -1) {
                                            this.f249273r = this.f249273r.substring(0, indexOf4 + 1);
                                        }
                                        i36 = -1;
                                    } catch (Exception e75) {
                                        exc = e75;
                                        i36 = -1;
                                    }
                                } catch (Exception e76) {
                                    e = e76;
                                }
                                z16 = z28;
                                j16 = j3;
                                boolean z2922 = true;
                                String str1222 = str;
                                i16 = i36;
                                i17 = 0;
                                while (i17 < j16) {
                                }
                                str2 = str8;
                                str3 = str9;
                                str4 = str10;
                                z17 = z16;
                                z18 = false;
                                c16 = '\b';
                                this.f249274s.f249336y.add(Integer.valueOf(i29));
                                if (i16 != -1) {
                                }
                                i36 = i16 + 1;
                                str11 = str1222;
                                c26 = c16;
                                z28 = z17;
                                str8 = str2;
                                str10 = str4;
                                str9 = str3;
                                e = e76;
                                exc = e;
                                i36 = -1;
                                j3 = 1;
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("MSF.C.QualityTestManager", 4, "net change caused quality test error", exc);
                                }
                                z16 = z28;
                                j16 = j3;
                                boolean z29222 = true;
                                String str12222 = str;
                                i16 = i36;
                                i17 = 0;
                                while (i17 < j16) {
                                }
                                str2 = str8;
                                str3 = str9;
                                str4 = str10;
                                z17 = z16;
                                z18 = false;
                                c16 = '\b';
                                this.f249274s.f249336y.add(Integer.valueOf(i29));
                                if (i16 != -1) {
                                }
                                i36 = i16 + 1;
                                str11 = str12222;
                                c26 = c16;
                                z28 = z17;
                                str8 = str2;
                                str10 = str4;
                                str9 = str3;
                            }
                        } else {
                            str = str11;
                            c19 = '\b';
                            j3 = (j19 >> c19) & 255;
                            z16 = z28;
                            j16 = j3;
                            boolean z292222 = true;
                            String str122222 = str;
                            i16 = i36;
                            i17 = 0;
                            while (i17 < j16) {
                            }
                            str2 = str8;
                            str3 = str9;
                            str4 = str10;
                            z17 = z16;
                            z18 = false;
                            c16 = '\b';
                            this.f249274s.f249336y.add(Integer.valueOf(i29));
                            if (i16 != -1) {
                            }
                            i36 = i16 + 1;
                            str11 = str122222;
                            c26 = c16;
                            z28 = z17;
                            str8 = str2;
                            str10 = str4;
                            str9 = str3;
                        }
                    } else {
                        str = str11;
                        try {
                            j27 = dVar11.f336593c;
                            j3 = j27;
                        } catch (Exception e77) {
                            e = e77;
                            exc = e;
                            j3 = 1;
                            if (QLog.isDevelopLevel()) {
                            }
                            z16 = z28;
                            j16 = j3;
                            boolean z2922222 = true;
                            String str1222222 = str;
                            i16 = i36;
                            i17 = 0;
                            while (i17 < j16) {
                            }
                            str2 = str8;
                            str3 = str9;
                            str4 = str10;
                            z17 = z16;
                            z18 = false;
                            c16 = '\b';
                            this.f249274s.f249336y.add(Integer.valueOf(i29));
                            if (i16 != -1) {
                            }
                            i36 = i16 + 1;
                            str11 = str1222222;
                            c26 = c16;
                            z28 = z17;
                            str8 = str2;
                            str10 = str4;
                            str9 = str3;
                        }
                        z16 = z28;
                        j16 = j3;
                        boolean z29222222 = true;
                        String str12222222 = str;
                        i16 = i36;
                        i17 = 0;
                        while (i17 < j16) {
                        }
                        str2 = str8;
                        str3 = str9;
                        str4 = str10;
                        z17 = z16;
                        z18 = false;
                        c16 = '\b';
                        this.f249274s.f249336y.add(Integer.valueOf(i29));
                        if (i16 != -1) {
                        }
                        i36 = i16 + 1;
                        str11 = str12222222;
                        c26 = c16;
                        z28 = z17;
                        str8 = str2;
                        str10 = str4;
                        str9 = str3;
                    }
                }
            } catch (Throwable th7) {
                com.tencent.mobileqq.msf.core.net.t.g.a();
                throw th7;
            }
        } catch (Exception e78) {
            QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: error ", e78);
        }
        com.tencent.mobileqq.msf.core.net.t.g.a();
    }

    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        i();
        if (this.f249262g) {
            return this.f249273r;
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
            if (this.f249258c != null) {
                switch (b.f249283a[this.f249257b.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        i();
                        return;
                    case 5:
                    case 6:
                        h();
                        return;
                    default:
                        return;
                }
            }
            if (this.f249259d != null) {
                g();
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
        public String[] f249292a;

        /* renamed from: b, reason: collision with root package name */
        public String f249293b;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f249293b = "";
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
            eVar.f249292a = str.substring(0, indexOf).split("\r\n");
            return eVar;
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            String[] strArr = this.f249292a;
            if (strArr == null || strArr.length <= 0) {
                return -1;
            }
            try {
                for (String str : strArr) {
                    if (str.startsWith(d.O)) {
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
            String[] strArr = this.f249292a;
            if (strArr == null || strArr.length == 0) {
                return "";
            }
            for (String str : strArr) {
                if ((str.startsWith(d.N) && str.contains(d.Q)) || (str.startsWith(d.M) && str.contains(d.Q))) {
                    int indexOf = str.indexOf(d.Q);
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
            String[] strArr = this.f249292a;
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
            String[] strArr = this.f249292a;
            if (strArr == null || strArr.length == 0) {
                return "";
            }
            for (String str : strArr) {
                if ((str.startsWith(d.N) && str.contains(d.P)) || (str.startsWith(d.M) && str.contains(d.P))) {
                    int indexOf = str.indexOf(d.P);
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
            String[] strArr = this.f249292a;
            if (strArr != null && strArr.length > 0) {
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    String str = strArr[i3];
                    if (str.startsWith(d.L)) {
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
            String[] strArr = this.f249292a;
            if (strArr != null && strArr.length != 0) {
                String str = "";
                for (String str2 : strArr) {
                    if ((!str2.startsWith(d.N) || !str2.contains(d.P)) && (!str2.startsWith(d.M) || !str2.contains(d.P))) {
                        str = str + str2 + "\r\n";
                    }
                }
                return str + "\r\n";
            }
            return this.f249293b;
        }
    }

    public d(com.tencent.msf.service.protocol.push.h.d dVar, EnumC8091d enumC8091d) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar, (Object) enumC8091d);
            return;
        }
        this.f249256a = new a();
        this.f249262g = false;
        this.f249263h = null;
        this.f249264i = null;
        this.f249265j = null;
        this.f249266k = null;
        this.f249267l = null;
        this.f249269n = 0;
        this.f249270o = 10000;
        this.f249271p = null;
        this.f249273r = "";
        this.f249274s = new g();
        this.f249275t = new f();
        this.f249278w = true;
        this.f249279x = 0L;
        this.f249280y = 0L;
        this.f249281z = 0L;
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
        this.f249258c = dVar;
        this.f249257b = enumC8091d;
        this.f249259d = null;
        this.f249260e = 1;
        this.f249261f = 0;
    }

    public void b(g.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, aVar, Boolean.valueOf(z16));
            return;
        }
        if (aVar == g.a.f249338a) {
            this.f249274s.f249313b = aVar;
        } else {
            g gVar = this.f249274s;
            g.a aVar2 = g.a.f249339b;
            gVar.f249313b = aVar2;
            if (aVar != aVar2) {
                a(aVar);
            }
        }
        EnumC8091d enumC8091d = this.f249257b;
        if ((enumC8091d == EnumC8091d.f249287c && this.f249269n == 1) || enumC8091d == EnumC8091d.f249285a) {
            this.f249274s.f249327p = 0;
        } else {
            long j3 = this.G;
            if (j3 != 0) {
                this.f249274s.f249327p = (int) (((float) this.H) / ((float) j3));
            }
        }
        if (enumC8091d == EnumC8091d.f249285a) {
            this.f249274s.f249328q = 0;
        } else {
            long j16 = this.I;
            if (j16 != 0) {
                this.f249274s.f249328q = (int) (((float) this.J) / ((float) j16));
            }
        }
        String gVar2 = this.f249274s.toString();
        if (TextUtils.isEmpty(this.f249273r)) {
            this.f249273r += "(";
            if (this.f249258c != null && this.f249259d == null && this.f249275t.f249294a == f.a.f249310a && this.f249274s.f249312a == g.b.f249364a) {
                String str = this.f249273r + this.f249275t.toString();
                this.f249273r = str;
                QLog.d("MSF.C.QualityTestManager", 1, "[mResultStr] ", str);
            }
        } else if (!this.f249273r.endsWith("#") && !this.f249273r.endsWith("(")) {
            this.f249273r += "*";
        }
        this.f249273r += gVar2;
        if (z16) {
            try {
                this.f249273r += ")";
                CRC32 crc32 = new CRC32();
                crc32.update(this.f249273r.getBytes());
                this.f249273r += crc32.getValue();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void b(com.tencent.msf.service.protocol.push.h.a aVar) {
        long j3 = aVar.f336572a;
        int i3 = aVar.f336573b;
        try {
            this.f249271p = com.tencent.qphone.base.util.e.a(aVar);
            this.f249272q = com.tencent.qphone.base.util.e.a(i3);
        } catch (UnknownHostException e16) {
            e16.printStackTrace();
        }
        g gVar = this.f249274s;
        gVar.f249316e = this.f249271p;
        gVar.f249317f = this.f249272q;
        String str = aVar.f336574c;
        gVar.C = str;
        if (str != null && str.length() > 0 && 2 == this.f249258c.f336605o) {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f249279x = System.currentTimeMillis();
                InetAddress[] allByName = InetAddress.getAllByName(str);
                this.f249274s.D = SystemClock.elapsedRealtime() - elapsedRealtime;
                this.f249280y = System.currentTimeMillis();
                if (allByName != null && allByName.length > 0) {
                    this.f249274s.E = 0;
                    if ((this.f249258c.f336608r & 1) == 1) {
                        this.f249271p = allByName[0];
                    } else {
                        this.f249271p = allByName[new Random().nextInt(allByName.length)];
                    }
                    this.f249274s.f249316e = this.f249271p;
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
                this.f249274s.E = 1;
                return;
            } catch (UnknownHostException e17) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "dns parse error! ", e17);
                }
                this.f249274s.E = 1;
                return;
            }
        }
        this.f249274s.E = 0;
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

    /* JADX WARN: Removed duplicated region for block: B:148:0x054a A[Catch: all -> 0x0543, TRY_ENTER, TryCatch #14 {all -> 0x0543, blocks: (B:65:0x02ce, B:67:0x02f3, B:68:0x0320, B:148:0x054a, B:149:0x0553, B:151:0x0564, B:152:0x056b), top: B:64:0x02ce }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0564 A[Catch: all -> 0x0543, TryCatch #14 {all -> 0x0543, blocks: (B:65:0x02ce, B:67:0x02f3, B:68:0x0320, B:148:0x054a, B:149:0x0553, B:151:0x0564, B:152:0x056b), top: B:64:0x02ce }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0583 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x059a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:? A[Catch: Exception -> 0x0b6c, SYNTHETIC, TRY_LEAVE, TryCatch #3 {Exception -> 0x0b6c, blocks: (B:7:0x0038, B:10:0x0046, B:61:0x02a4, B:89:0x038d, B:91:0x0396, B:137:0x0523, B:139:0x052c, B:179:0x05ad, B:176:0x05a0, B:178:0x05a9, B:160:0x0589, B:162:0x0592, B:307:0x08cd, B:304:0x08c0, B:306:0x08c9, B:288:0x08a7, B:290:0x08b0, B:228:0x068a, B:230:0x0693, B:263:0x0812, B:265:0x081b, B:334:0x08ce, B:132:0x051c, B:21:0x007e, B:25:0x00db, B:27:0x00e8, B:31:0x00f4, B:33:0x0124, B:39:0x01a4, B:42:0x01f1, B:46:0x0224, B:49:0x024d, B:52:0x01b3, B:54:0x01d1, B:55:0x027a, B:56:0x02a1, B:283:0x08a1, B:299:0x08ba, B:155:0x0583, B:223:0x0683, B:84:0x0386, B:258:0x080b, B:171:0x059a), top: B:5:0x0036, inners: #0, #1, #4, #12, #16, #17, #19, #22, #31 }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0781 A[Catch: all -> 0x0849, Exception -> 0x084b, TryCatch #27 {Exception -> 0x084b, all -> 0x0849, blocks: (B:236:0x069d, B:238:0x06e2, B:239:0x0720, B:246:0x072d, B:248:0x073a, B:251:0x0781, B:255:0x07b4, B:256:0x07dd, B:268:0x0743, B:270:0x0761, B:271:0x0821, B:272:0x0848), top: B:235:0x069d }] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0882 A[Catch: all -> 0x08b6, TryCatch #8 {all -> 0x08b6, blocks: (B:311:0x0868, B:277:0x0871, B:279:0x0882, B:280:0x0889), top: B:310:0x0868 }] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x08a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:293:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x08ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:309:? A[Catch: Exception -> 0x0b6c, SYNTHETIC, TryCatch #3 {Exception -> 0x0b6c, blocks: (B:7:0x0038, B:10:0x0046, B:61:0x02a4, B:89:0x038d, B:91:0x0396, B:137:0x0523, B:139:0x052c, B:179:0x05ad, B:176:0x05a0, B:178:0x05a9, B:160:0x0589, B:162:0x0592, B:307:0x08cd, B:304:0x08c0, B:306:0x08c9, B:288:0x08a7, B:290:0x08b0, B:228:0x068a, B:230:0x0693, B:263:0x0812, B:265:0x081b, B:334:0x08ce, B:132:0x051c, B:21:0x007e, B:25:0x00db, B:27:0x00e8, B:31:0x00f4, B:33:0x0124, B:39:0x01a4, B:42:0x01f1, B:46:0x0224, B:49:0x024d, B:52:0x01b3, B:54:0x01d1, B:55:0x027a, B:56:0x02a1, B:283:0x08a1, B:299:0x08ba, B:155:0x0583, B:223:0x0683, B:84:0x0386, B:258:0x080b, B:171:0x059a), top: B:5:0x0036, inners: #0, #1, #4, #12, #16, #17, #19, #22, #31 }] */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0868 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0a93 A[Catch: Exception -> 0x0b3d, TryCatch #24 {Exception -> 0x0b3d, blocks: (B:345:0x0972, B:346:0x0978, B:353:0x0986, B:356:0x0995, B:359:0x099e, B:361:0x09f1, B:362:0x09f9, B:367:0x0a93, B:371:0x0abe, B:374:0x0ae7, B:377:0x0a51, B:379:0x0a73, B:380:0x0b15, B:381:0x0b3c), top: B:344:0x0972 }] */
    /* JADX WARN: Removed duplicated region for block: B:376:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01f1 A[Catch: all -> 0x02a2, TryCatch #1 {all -> 0x02a2, blocks: (B:21:0x007e, B:25:0x00db, B:27:0x00e8, B:31:0x00f4, B:33:0x0124, B:39:0x01a4, B:42:0x01f1, B:46:0x0224, B:49:0x024d, B:52:0x01b3, B:54:0x01d1, B:55:0x027a, B:56:0x02a1), top: B:20:0x007e, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(int i3, byte[] bArr) {
        String str;
        byte[] bArr2;
        String str2;
        int i16;
        Exception exc;
        Throwable th5;
        BufferedInputStream bufferedInputStream;
        byte[] bArr3;
        int i17;
        g gVar;
        long j3;
        int i18;
        int i19;
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.QualityTestManager", 2, "start receive: receBodySize len:" + i3 + ", cTestType:" + ((int) this.f249258c.f336605o));
        }
        try {
        } catch (Exception unused) {
            str = "MSF.C.QualityTestManager";
        }
        if (i3 > 524288) {
            this.f249278w = false;
            a(g.a.A);
            QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: Recvbodysize too large, stop it");
            return false;
        }
        int i26 = b.f249283a[this.f249257b.ordinal()];
        if (i26 == 1) {
            byte[] bArr4 = new byte[i3];
            DatagramPacket datagramPacket = new DatagramPacket(bArr4, i3);
            try {
                this.D = System.currentTimeMillis();
                this.f249263h.receive(datagramPacket);
                long currentTimeMillis = System.currentTimeMillis();
                this.E = currentTimeMillis;
                g gVar2 = this.f249274s;
                long j16 = this.B;
                gVar2.M = j16;
                gVar2.N = currentTimeMillis;
                long j17 = currentTimeMillis - j16;
                this.K = j17;
                gVar2.J.add(Long.valueOf(j17));
                try {
                    this.I += this.E - this.D;
                    this.J += datagramPacket.getLength();
                    this.f249277v += datagramPacket.getLength();
                    this.f249274s.f249322k = (int) (r2.f249322k + this.K);
                    if (QLog.isColorLevel()) {
                        str = "MSF.C.QualityTestManager";
                        try {
                            QLog.d(str, 2, "UDP recv done, recvPacket len:" + datagramPacket.getLength() + ", receiveDelay:" + this.K + ", receiveTotalTime:" + this.I + ", receiveTotalBytes:" + this.J + ", testPacketRecved:" + this.f249277v);
                        } catch (Exception e16) {
                            e = e16;
                            Exception exc2 = e;
                            try {
                                b(exc2.toString().toLowerCase());
                                QLog.d(str, 1, "QualityClient: udp read packet error:", exc2);
                                g gVar3 = this.f249274s;
                                gVar3.f249325n++;
                                gVar3.J.add(-1L);
                                return false;
                            } catch (Exception unused2) {
                            }
                        }
                    } else {
                        str = "MSF.C.QualityTestManager";
                    }
                    short s16 = this.f249258c.f336605o;
                    if (s16 != 0 && 1 != s16) {
                        if (2 == s16) {
                            if (datagramPacket.getAddress().equals(this.f249271p) && datagramPacket.getPort() == this.f249272q) {
                                QLog.d(str, 2, "send_svninfo:(" + this.f249271p.toString() + ", port " + this.f249272q + "), recv_svrinfo:(" + datagramPacket.getAddress().toString() + ", port " + datagramPacket.getPort() + ")");
                                g gVar4 = this.f249274s;
                                gVar4.f249324m = gVar4.f249324m + 1;
                                if (QLog.isColorLevel()) {
                                    QLog.d(str, 2, "udp speed test rsp cTestType 2, **NOT**, check RspBody");
                                }
                            }
                            this.f249274s.f249324m++;
                            a(g.a.f249359v);
                            QLog.d(str, 2, "Warning: send_recv_server_info_mismatch send_svninfo:(" + this.f249271p.toString() + ", port " + this.f249272q + "), recv_svrinfo:(" + datagramPacket.getAddress().toString() + ", port " + datagramPacket.getPort() + ")");
                            return false;
                        }
                        bArr2 = bArr4;
                        if (i3 >= 4) {
                            return true;
                        }
                        QLog.d(str, 1, "QualityClient: udp split respBodySize " + com.tencent.mobileqq.msf.core.c.a(bArr2, 0) + " receData.length " + i3);
                        if (!(this.f249271p instanceof Inet6Address)) {
                            int a16 = com.tencent.mobileqq.msf.core.c.a(bArr2, i3 - 4);
                            InetAddress a17 = com.tencent.qphone.base.util.e.a(a16);
                            QLog.d(str, 1, "QualityClient: udp split gateWayIp:" + a17 + " gateWayIpInt:" + a16);
                            this.f249274s.f249315d = a17;
                            return true;
                        }
                        if (i3 < 20) {
                            return true;
                        }
                        byte[] bArr5 = new byte[16];
                        System.arraycopy(bArr2, i3 - 16, bArr5, 0, 16);
                        InetAddress byAddress = InetAddress.getByAddress(bArr5);
                        QLog.d(str, 1, "QualityClient: udp split gateWayIp:" + byAddress);
                        this.f249274s.f249315d = byAddress;
                        return true;
                    }
                    int length = bArr.length - 8;
                    byte[] bArr6 = new byte[length];
                    System.arraycopy(bArr, 0, bArr6, 0, length);
                    int i27 = i3 - 8;
                    byte[] bArr7 = new byte[i27];
                    bArr2 = bArr4;
                    System.arraycopy(bArr2, 0, bArr7, 0, i27);
                    if (MD5.toMD5(bArr6).equals(MD5.toMD5(bArr7))) {
                        QLog.d(str, 1, "QualityClient: udp recv packet size " + i3);
                        g gVar5 = this.f249274s;
                        gVar5.f249324m = gVar5.f249324m + 1;
                        if (i3 >= 4) {
                        }
                    } else {
                        this.f249274s.J.remove(Long.valueOf(this.K));
                        throw new Exception("recv package error. " + MD5.toMD5(bArr7));
                    }
                } catch (Exception e17) {
                    e = e17;
                    str = "MSF.C.QualityTestManager";
                }
            } catch (Exception e18) {
                e = e18;
                str = "MSF.C.QualityTestManager";
            }
        } else {
            InputStream inputStream = null;
            if (i26 == 2) {
                try {
                    InputStream inputStream2 = this.f249264i.getInputStream();
                    try {
                        com.tencent.mobileqq.msf.core.net.t.g.f249398f.add(inputStream2.toString());
                        byte[] bArr8 = new byte[i3];
                        int read = inputStream2.read(bArr8);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        this.C = currentTimeMillis2;
                        try {
                            this.G += currentTimeMillis2 - this.B;
                            QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send tcp packet length:" + bArr.length + " sendEndTime:" + this.C + " sendTime:" + this.B);
                            long j18 = this.C;
                            this.D = j18;
                            this.E = j18;
                            int i28 = -1;
                            if (read != -1) {
                                i16 = read;
                                while (i16 < i3) {
                                    try {
                                        read = inputStream2.read(bArr8, i16, i3 - i16);
                                        if (i28 == read) {
                                            break;
                                        }
                                        i16 += read;
                                        this.E = System.currentTimeMillis();
                                        i28 = -1;
                                    } catch (Exception e19) {
                                        e = e19;
                                        inputStream = inputStream2;
                                        str2 = "Http Close InputStream failed ";
                                        Exception exc3 = e;
                                        if (inputStream != null) {
                                            try {
                                                com.tencent.mobileqq.msf.core.net.t.g.f249398f.remove(inputStream.toString());
                                            } catch (Throwable th6) {
                                                th = th6;
                                                Throwable th7 = th;
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                        throw th7;
                                                    } catch (Throwable th8) {
                                                        th8.printStackTrace();
                                                        if (QLog.isDevelopLevel()) {
                                                            QLog.d("MSF.C.QualityTestManager", 4, str2, th8);
                                                            throw th7;
                                                        }
                                                        throw th7;
                                                    }
                                                }
                                                throw th7;
                                            }
                                        }
                                        b(exc3.toString().toLowerCase());
                                        if (QLog.isDevelopLevel()) {
                                            QLog.d("MSF.C.QualityTestManager", 4, "QualityClient: receive TCP resp failed", exc3);
                                        }
                                        g gVar6 = this.f249274s;
                                        gVar6.f249325n++;
                                        gVar6.J.add(-1L);
                                        exc3.printStackTrace();
                                        if (inputStream != null) {
                                            return false;
                                        }
                                        try {
                                            inputStream.close();
                                            return false;
                                        } catch (Throwable th9) {
                                            th9.printStackTrace();
                                            if (!QLog.isDevelopLevel()) {
                                                return false;
                                            }
                                            QLog.d("MSF.C.QualityTestManager", 4, str2, th9);
                                            return false;
                                        }
                                    } catch (Throwable th10) {
                                        th = th10;
                                        inputStream = inputStream2;
                                        str2 = "Http Close InputStream failed ";
                                        Throwable th72 = th;
                                        if (inputStream != null) {
                                        }
                                    }
                                }
                            } else {
                                i16 = 0;
                            }
                            if (i28 == read) {
                                com.tencent.mobileqq.msf.core.net.t.g.f249398f.remove(inputStream2.toString());
                                a(g.a.f249342e);
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("MSF.C.QualityTestManager", 4, "QualityClient: receive TCP resp failed by read return -1, count:" + i16 + ", receBodySize:" + i3);
                                }
                                this.f249274s.J.add(-1L);
                                try {
                                    inputStream2.close();
                                    return false;
                                } catch (Throwable th11) {
                                    th11.printStackTrace();
                                    if (!QLog.isDevelopLevel()) {
                                        return false;
                                    }
                                    QLog.d("MSF.C.QualityTestManager", 4, "Http Close InputStream failed ", th11);
                                    return false;
                                }
                            }
                            str2 = "Http Close InputStream failed ";
                            try {
                                com.tencent.mobileqq.msf.core.net.t.g.f249398f.remove(inputStream2.toString());
                                g gVar7 = this.f249274s;
                                long j19 = this.B;
                                gVar7.M = j19;
                                long j26 = this.E;
                                gVar7.N = j26;
                                long j27 = j26 - j19;
                                this.K = j27;
                                gVar7.J.add(Long.valueOf(j27));
                                this.f249274s.f249322k = (int) (r7.f249322k + this.K);
                                this.I += this.E - this.D;
                                this.J += i3;
                                this.f249277v += i3;
                                if (QLog.isColorLevel()) {
                                    QLog.d("MSF.C.QualityTestManager", 2, "TCP recv done, actual recv len:" + i16 + ", receiveDelay:" + this.K + ", receiveTotalTime:" + this.I + ", receiveTotalBytes:" + this.J + ", testPacketRecved:" + this.f249277v);
                                }
                                short s17 = this.f249258c.f336605o;
                                if (s17 != 0 && 1 != s17) {
                                    if (2 == s17) {
                                        this.f249274s.f249324m++;
                                        if (QLog.isColorLevel()) {
                                            QLog.d("MSF.C.QualityTestManager", 2, "tcp speed test rsp cTestType 2, **NOT**, check RspBody");
                                        }
                                    }
                                    if (i3 >= 4) {
                                        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: tcp split respBodySize " + i3 + " receiveDelay " + this.K + " receData.length " + i3);
                                        if (!(this.f249271p instanceof Inet6Address)) {
                                            int a18 = com.tencent.mobileqq.msf.core.c.a(bArr8, i3 - 4);
                                            InetAddress a19 = com.tencent.qphone.base.util.e.a(a18);
                                            QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: tcp split gateWayIp:" + a19 + " gateWayIpInt:" + a18);
                                            this.f249274s.f249315d = a19;
                                        } else if (i3 >= 20) {
                                            byte[] bArr9 = new byte[16];
                                            System.arraycopy(bArr8, i3 - 16, bArr9, 0, 16);
                                            InetAddress byAddress2 = InetAddress.getByAddress(bArr9);
                                            QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: tcp split gateWayIp:" + byAddress2);
                                            this.f249274s.f249315d = byAddress2;
                                        }
                                    }
                                    try {
                                        inputStream2.close();
                                        return true;
                                    } catch (Throwable th12) {
                                        th12.printStackTrace();
                                        if (!QLog.isDevelopLevel()) {
                                            return true;
                                        }
                                        QLog.d("MSF.C.QualityTestManager", 4, str2, th12);
                                        return true;
                                    }
                                }
                                int length2 = bArr.length - 8;
                                byte[] bArr10 = new byte[length2];
                                System.arraycopy(bArr, 0, bArr10, 0, length2);
                                int i29 = i3 - 8;
                                byte[] bArr11 = new byte[i29];
                                System.arraycopy(bArr8, 0, bArr11, 0, i29);
                                if (MD5.toMD5(bArr10).equals(MD5.toMD5(bArr11))) {
                                    QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: tcp recv packet size " + i3);
                                    g gVar8 = this.f249274s;
                                    gVar8.f249324m = gVar8.f249324m + 1;
                                    if (i3 >= 4) {
                                    }
                                    inputStream2.close();
                                    return true;
                                }
                                this.f249274s.J.remove(Long.valueOf(this.K));
                                throw new Exception("recv package error. " + MD5.toMD5(bArr11));
                            } catch (Exception e26) {
                                e = e26;
                                inputStream = inputStream2;
                                Exception exc32 = e;
                                if (inputStream != null) {
                                }
                                b(exc32.toString().toLowerCase());
                                if (QLog.isDevelopLevel()) {
                                }
                                g gVar62 = this.f249274s;
                                gVar62.f249325n++;
                                gVar62.J.add(-1L);
                                exc32.printStackTrace();
                                if (inputStream != null) {
                                }
                            } catch (Throwable th13) {
                                th = th13;
                                inputStream = inputStream2;
                                Throwable th722 = th;
                                if (inputStream != null) {
                                }
                            }
                        } catch (Exception e27) {
                            e = e27;
                            str2 = "Http Close InputStream failed ";
                        } catch (Throwable th14) {
                            th = th14;
                            str2 = "Http Close InputStream failed ";
                        }
                    } catch (Exception e28) {
                        e = e28;
                        str2 = "Http Close InputStream failed ";
                    } catch (Throwable th15) {
                        th = th15;
                        str2 = "Http Close InputStream failed ";
                    }
                } catch (Exception e29) {
                    e = e29;
                    str2 = "Http Close InputStream failed ";
                } catch (Throwable th16) {
                    th = th16;
                    str2 = "Http Close InputStream failed ";
                }
            } else if (i26 == 3) {
                try {
                    try {
                        this.f249274s.G = this.f249268m.getResponseCode();
                        this.f249274s.H = this.f249268m.getContentLength();
                        long currentTimeMillis3 = System.currentTimeMillis();
                        this.C = currentTimeMillis3;
                        this.G = currentTimeMillis3 - this.B;
                        if (QLog.isDevelopLevel()) {
                            QLog.d("MSF.C.QualityTestManager", 4, "HTTP getResponseCode: status code:" + this.f249274s.G + ", receBodySize:" + i3 + ", ContentLength:" + this.f249274s.H);
                        }
                        long j28 = this.C;
                        this.D = j28;
                        this.E = j28;
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(this.f249268m.getInputStream());
                        try {
                            com.tencent.mobileqq.msf.core.net.t.g.f249398f.add(bufferedInputStream2.toString());
                            byte[] bArr12 = new byte[1024];
                            bArr3 = new byte[i3];
                            i17 = 0;
                            while (i17 < i3) {
                                try {
                                    int read2 = bufferedInputStream2.read(bArr12);
                                    if (read2 == -1) {
                                        break;
                                    }
                                    if (read2 > i3) {
                                        System.arraycopy(bArr12, 0, bArr3, i17, i3);
                                    } else if (read2 + i17 > i3) {
                                        System.arraycopy(bArr12, 0, bArr3, i17, i3 - i17);
                                    } else {
                                        System.arraycopy(bArr12, 0, bArr3, i17, read2);
                                    }
                                    i17 += read2;
                                    this.E = System.currentTimeMillis();
                                    if (i17 > 1048576) {
                                        com.tencent.mobileqq.msf.core.net.t.g.f249398f.remove(bufferedInputStream2.toString());
                                        this.J += i17;
                                        this.f249277v += i17;
                                        this.f249278w = false;
                                        a(g.a.f249358u);
                                        try {
                                            bufferedInputStream2.close();
                                            return false;
                                        } catch (Throwable th17) {
                                            th17.printStackTrace();
                                            if (!QLog.isDevelopLevel()) {
                                                return false;
                                            }
                                            QLog.d("MSF.C.QualityTestManager", 4, "Http Close InputStream failed ", th17);
                                            return false;
                                        }
                                    }
                                } catch (Exception e36) {
                                    exc = e36;
                                    bufferedInputStream = bufferedInputStream2;
                                    inputStream = bufferedInputStream;
                                    if (inputStream != null) {
                                    }
                                    b(exc.toString().toLowerCase());
                                    if (QLog.isDevelopLevel()) {
                                    }
                                    g gVar9 = this.f249274s;
                                    gVar9.f249325n++;
                                    gVar9.J.add(-1L);
                                    exc.printStackTrace();
                                    if (inputStream != null) {
                                    }
                                } catch (Throwable th18) {
                                    th5 = th18;
                                    inputStream = bufferedInputStream2;
                                    if (inputStream == null) {
                                    }
                                }
                            }
                            com.tencent.mobileqq.msf.core.net.t.g.f249398f.remove(bufferedInputStream2.toString());
                            gVar = this.f249274s;
                            j3 = this.B;
                            gVar.M = j3;
                            bufferedInputStream = bufferedInputStream2;
                        } catch (Exception e37) {
                            e = e37;
                            bufferedInputStream = bufferedInputStream2;
                        } catch (Throwable th19) {
                            th = th19;
                            bufferedInputStream = bufferedInputStream2;
                        }
                        try {
                            long j29 = this.E;
                            gVar.N = j29;
                            long j36 = j29 - j3;
                            this.K = j36;
                            gVar.J.add(Long.valueOf(j36));
                            this.f249274s.f249322k = (int) (r2.f249322k + this.K);
                            this.I += this.E - this.D;
                            this.J += i17;
                            this.f249277v += i17;
                            if (QLog.isDevelopLevel()) {
                                QLog.d("MSF.C.QualityTestManager", 4, "HTTP recv done, receiveDelay: " + this.K + ", receiveTotalTime:" + this.I + ", receiveTotalBytes:" + this.J + ", testPacketRecved:" + this.f249277v);
                            }
                            com.tencent.msf.service.protocol.push.h.d dVar = this.f249258c;
                            long j37 = dVar.f336614x;
                            if (j37 > 0) {
                                int i36 = (int) j37;
                                int i37 = (int) dVar.f336613w;
                                if (i36 > 32768) {
                                    i36 = 32768;
                                }
                                i18 = i3;
                                int min = Math.min(i17, i18);
                                if (i37 < min) {
                                    if (i36 + i37 > min) {
                                        int i38 = min - i37;
                                        this.f249274s.P = new String(bArr3, i37, i38);
                                        this.f249274s.O = i38;
                                    } else {
                                        this.f249274s.P = new String(bArr3, i37, i36);
                                        this.f249274s.O = i36;
                                    }
                                    g gVar10 = this.f249274s;
                                    gVar10.P = com.tencent.qphone.base.util.e.b(gVar10.P);
                                    g gVar11 = this.f249274s;
                                    gVar11.O = gVar11.P.length();
                                }
                            } else {
                                i18 = i3;
                            }
                            String str3 = new String(bArr3, 0, Math.min(i17, i18));
                            if (QLog.isDevelopLevel()) {
                                QLog.d("MSF.C.QualityTestManager", 4, "HTTP receBody: " + str3);
                            }
                            if (!str3.contains(this.f249258c.f336610t)) {
                                this.f249274s.F = 1;
                            }
                            String a26 = a(this.f249268m.getHeaderField("Set-Cookie"));
                            if (a26 != null) {
                                this.f249274s.f249315d = InetAddress.getByName(a26);
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("MSF.C.QualityTestManager", 4, "Http gateWayIp: " + a26);
                                }
                            }
                            this.f249274s.f249324m++;
                            QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: http recv packet size " + i17 + ",server limit receBodySize:" + i18 + ",receiveDelay:" + this.K + ",strRspMatchPattern:" + this.f249258c.f336610t);
                            try {
                                bufferedInputStream.close();
                                return true;
                            } catch (Throwable th20) {
                                th20.printStackTrace();
                                if (!QLog.isDevelopLevel()) {
                                    return true;
                                }
                                QLog.d("MSF.C.QualityTestManager", 4, "Http Close InputStream failed ", th20);
                                return true;
                            }
                        } catch (Exception e38) {
                            e = e38;
                            exc = e;
                            inputStream = bufferedInputStream;
                            if (inputStream != null) {
                                com.tencent.mobileqq.msf.core.net.t.g.f249398f.remove(inputStream.toString());
                            }
                            b(exc.toString().toLowerCase());
                            if (QLog.isDevelopLevel()) {
                                QLog.d("MSF.C.QualityTestManager", 4, "QualityClient: http receive resp failed ", exc);
                            }
                            g gVar92 = this.f249274s;
                            gVar92.f249325n++;
                            gVar92.J.add(-1L);
                            exc.printStackTrace();
                            if (inputStream != null) {
                                return false;
                            }
                            try {
                                inputStream.close();
                                return false;
                            } catch (Throwable th21) {
                                th21.printStackTrace();
                                if (!QLog.isDevelopLevel()) {
                                    return false;
                                }
                                QLog.d("MSF.C.QualityTestManager", 4, "Http Close InputStream failed ", th21);
                                return false;
                            }
                        } catch (Throwable th22) {
                            th = th22;
                            inputStream = bufferedInputStream;
                            th5 = th;
                            if (inputStream == null) {
                                try {
                                    inputStream.close();
                                    throw th5;
                                } catch (Throwable th23) {
                                    th23.printStackTrace();
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("MSF.C.QualityTestManager", 4, "Http Close InputStream failed ", th23);
                                        throw th5;
                                    }
                                    throw th5;
                                }
                            }
                            throw th5;
                        }
                    } catch (Exception e39) {
                        exc = e39;
                    }
                } catch (Throwable th24) {
                    th = th24;
                }
            } else {
                if (i26 != 4) {
                    return false;
                }
                try {
                    byte[] bArr13 = new byte[i3];
                    this.D = System.currentTimeMillis();
                    int read3 = this.f249266k.read(bArr13, this.f249270o);
                    long currentTimeMillis4 = System.currentTimeMillis();
                    this.C = currentTimeMillis4;
                    this.G += currentTimeMillis4 - this.B;
                    QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send Quic packet length:" + bArr.length + " sendEndTime:" + this.C + " sendTime:" + this.B);
                    this.E = this.C;
                    int i39 = -1;
                    if (read3 != -1) {
                        i19 = read3;
                        while (i19 < i3) {
                            read3 = this.f249266k.read(bArr13, i19, i3 - i19, this.f249270o);
                            if (read3 == i39) {
                                break;
                            }
                            i19 += read3;
                            this.E = System.currentTimeMillis();
                            i39 = -1;
                        }
                    } else {
                        i19 = 0;
                    }
                    if (read3 == i39) {
                        a(g.a.f249342e);
                        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: receive Quic resp failed by read return -1, count:" + i19 + ", receBodySize:" + i3);
                        this.f249274s.J.add(-1L);
                        return false;
                    }
                    g gVar12 = this.f249274s;
                    long j38 = this.B;
                    gVar12.M = j38;
                    long j39 = this.E;
                    gVar12.N = j39;
                    long j46 = j39 - j38;
                    this.K = j46;
                    gVar12.J.add(Long.valueOf(j46));
                    this.f249274s.f249322k = (int) (r7.f249322k + this.K);
                    this.I += this.E - this.D;
                    this.J += i3;
                    this.f249277v += i3;
                    QLog.d("MSF.C.QualityTestManager", 1, "Quic recv done, actual recv len:" + i19 + ", receiveDelay:" + this.K + ", receiveTotalTime:" + this.I + ", receiveTotalBytes:" + this.J + ", testPacketRecved:" + this.f249277v);
                    short s18 = this.f249258c.f336605o;
                    if (s18 != 0 && 1 != s18) {
                        if (2 == s18) {
                            this.f249274s.f249324m++;
                            QLog.d("MSF.C.QualityTestManager", 1, "quic speed test rsp cTestType 2, **NOT**, check RspBody");
                        }
                        if (i3 >= 4) {
                            return true;
                        }
                        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: quic split respBodySize " + i3 + " receiveDelay " + this.K + " receData.length " + i3);
                        if (!(this.f249271p instanceof Inet6Address)) {
                            int a27 = com.tencent.mobileqq.msf.core.c.a(bArr13, i3 - 4);
                            InetAddress a28 = com.tencent.qphone.base.util.e.a(a27);
                            QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: Quic split gateWayIp:" + a28 + " gateWayIpInt:" + a27);
                            this.f249274s.f249315d = a28;
                            return true;
                        }
                        if (i3 < 20) {
                            return true;
                        }
                        byte[] bArr14 = new byte[16];
                        System.arraycopy(bArr13, i3 - 16, bArr14, 0, 16);
                        InetAddress byAddress3 = InetAddress.getByAddress(bArr14);
                        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: Quic split gateWayIp:" + byAddress3);
                        this.f249274s.f249315d = byAddress3;
                        return true;
                    }
                    int length3 = bArr.length - 8;
                    byte[] bArr15 = new byte[length3];
                    System.arraycopy(bArr, 0, bArr15, 0, length3);
                    int i46 = i3 - 8;
                    byte[] bArr16 = new byte[i46];
                    System.arraycopy(bArr13, 0, bArr16, 0, i46);
                    if (MD5.toMD5(bArr15).equals(MD5.toMD5(bArr16))) {
                        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: quic recv packet size " + i3);
                        g gVar13 = this.f249274s;
                        gVar13.f249324m = gVar13.f249324m + 1;
                        if (i3 >= 4) {
                        }
                    } else {
                        this.f249274s.J.remove(Long.valueOf(this.K));
                        throw new Exception("recv package error. " + MD5.toMD5(bArr16));
                    }
                } catch (Throwable th25) {
                    QLog.e("MSF.C.QualityTestManager", 1, "QualityClient: receive Quic resp failed", th25);
                    b(th25.toString().toLowerCase());
                    g gVar14 = this.f249274s;
                    gVar14.f249325n++;
                    gVar14.J.add(-1L);
                    return false;
                }
            }
            str = "MSF.C.QualityTestManager";
            g gVar15 = this.f249274s;
            gVar15.f249325n++;
            gVar15.J.add(-1L);
            QLog.d(str, 1, "Error recvTestData");
            return false;
        }
    }

    private void b(String str) {
        if (NetConnInfoCenter.getSystemNetworkType() == 0) {
            a(g.a.f249362y);
        } else if (str.indexOf("timeout") > -1) {
            a(g.a.f249361x);
        } else {
            a(g.a.f249342e);
        }
    }

    private boolean a(byte[] bArr) {
        return bArr != null && bArr.length > 0 && new String(bArr).endsWith("\r\n\r\n");
    }

    private void a(g.a aVar) {
        if (this.f249274s.f249314c.containsKey(aVar)) {
            this.f249274s.f249314c.put(aVar, Integer.valueOf(this.f249274s.f249314c.get(aVar).intValue() + 1));
        } else {
            this.f249274s.f249314c.put(aVar, 1);
        }
    }

    private void a(g.a aVar, boolean z16) {
        b(aVar, z16);
        if (z16) {
            ArrayList<byte[]> arrayList = new ArrayList<>();
            try {
                arrayList.add(this.f249273r.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
            HashMap<String, ArrayList<byte[]>> hashMap = new HashMap<>();
            hashMap.put("QualTest", arrayList);
            try {
                com.tencent.mobileqq.msf.core.net.t.g.a(this.f249278w, this.f249258c, this.f249259d, this.f249277v, this.f249276u, this.f249274s.f249318g);
                com.tencent.mobileqq.msf.core.net.t.g.f249396d.configManager.a(hashMap, "");
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            QLog.d("MSF.C.QualityTestManager", 1, "QualityClient finish, succ: " + this.f249273r);
        }
    }

    private void a() {
        QuicSocket quicSocket;
        try {
            int i3 = b.f249283a[this.f249257b.ordinal()];
            if (i3 == 1) {
                DatagramSocket datagramSocket = this.f249263h;
                if (datagramSocket != null) {
                    datagramSocket.close();
                    this.f249263h = null;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Udp socket");
                    return;
                }
                return;
            }
            if (i3 == 2) {
                OutputStream outputStream = this.f249265j;
                if (outputStream != null) {
                    outputStream.close();
                    this.f249265j = null;
                }
                Socket socket = this.f249264i;
                if (socket != null) {
                    socket.close();
                    this.f249264i = null;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Tcp socket");
                    return;
                }
                return;
            }
            if (i3 != 3) {
                if (i3 == 4 && (quicSocket = this.f249266k) != null) {
                    quicSocket.close();
                    this.f249266k = null;
                    QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: close Quic socket");
                    return;
                }
                return;
            }
            OutputStream outputStream2 = this.f249265j;
            if (outputStream2 != null) {
                outputStream2.close();
                this.f249265j = null;
            }
            HttpURLConnection httpURLConnection = this.f249268m;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
                this.f249268m = null;
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
        if (this.f249257b != EnumC8091d.f249287c) {
            if (i3 > 524288) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i3 + " return not http");
                }
                this.f249278w = false;
                a(g.a.f249345h);
                return false;
            }
            if (i3 >= 1) {
                return true;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, not http qualityTestMsg.sPkgData.length:" + this.f249258c.f336595e.length);
            }
            a(g.a.f249346i);
            return false;
        }
        if (i3 == 0) {
            return true;
        }
        if (i3 > 524288) {
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i3 + " return http");
            }
            this.f249278w = false;
            a(g.a.f249345h);
            return false;
        }
        if (i3 >= 1) {
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, http qualityTestMsg.sPkgData.length:" + this.f249258c.f336595e.length);
        }
        a(g.a.f249346i);
        return false;
    }

    private byte[] a(int i3, byte[] bArr, byte[] bArr2) {
        if (this.f249258c == null) {
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
            com.tencent.msf.service.protocol.push.h.d dVar = this.f249258c;
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
        if (this.f249257b != EnumC8091d.f249287c) {
            short s16 = this.f249258c.f336605o;
            if (s16 == 0 || 1 == s16) {
                int a16 = com.tencent.mobileqq.msf.core.c.a(bArr3, 0);
                if (a16 != i3) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.QualityTestManager", 4, "testdata length error stop dataTotalLen:" + a16 + " receBodySize:" + i3);
                    }
                    a(g.a.f249343f, true);
                    com.tencent.mobileqq.msf.core.net.t.g.a();
                    return null;
                }
            } else if (2 == s16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 2, "qualityTestMsg.cTestType=2, Should*NOT* check head len");
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.QualityTestManager", 2, "qualityTestMsg.cTestType" + ((int) this.f249258c.f336605o) + "NotSupport, giveup speed_test");
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
        Matcher matcher2 = Pattern.compile("([a-f0-9]{1,4}(:[a-f0-9]{1,4}){7}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){0,7}::[a-f0-9]{0,4}(:[a-f0-9]{1,4}){0,7})").matcher(str);
        if (matcher2.find()) {
            return matcher2.group();
        }
        return null;
    }
}
