package com.tencent.halley.downloader.a.a;

import android.net.Network;
import android.net.http.Headers;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.halley.common.a.g;
import com.tencent.halley.common.utils.j;
import com.tencent.halley.downloader.c.c;
import com.tencent.halley.downloader.c.i;
import com.tencent.halley.downloader.task.d.a;
import com.tencent.halley.downloader.task.section.DataSection;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f113585a;
    public String A;
    public volatile boolean B;
    public long C;
    private List<String> D;
    private String E;
    private int F;
    private int G;
    private URL H;
    private HttpURLConnection I;
    private InputStream J;
    private boolean K;
    private volatile int L;

    /* renamed from: b, reason: collision with root package name */
    public boolean f113586b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.halley.downloader.a.c f113587c;

    /* renamed from: d, reason: collision with root package name */
    protected int f113588d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.halley.downloader.task.d.a f113589e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f113590f;

    /* renamed from: g, reason: collision with root package name */
    protected Map<String, String> f113591g;

    /* renamed from: h, reason: collision with root package name */
    protected int f113592h;

    /* renamed from: i, reason: collision with root package name */
    protected String f113593i;

    /* renamed from: j, reason: collision with root package name */
    protected String f113594j;

    /* renamed from: k, reason: collision with root package name */
    protected Map<String, String> f113595k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f113596l;

    /* renamed from: m, reason: collision with root package name */
    DataSection.b f113597m;

    /* renamed from: n, reason: collision with root package name */
    public String f113598n;

    /* renamed from: o, reason: collision with root package name */
    public long f113599o;

    /* renamed from: p, reason: collision with root package name */
    public String f113600p;

    /* renamed from: q, reason: collision with root package name */
    public String f113601q;

    /* renamed from: r, reason: collision with root package name */
    public String f113602r;

    /* renamed from: s, reason: collision with root package name */
    public String f113603s;

    /* renamed from: t, reason: collision with root package name */
    public String f113604t;

    /* renamed from: u, reason: collision with root package name */
    public String f113605u;

    /* renamed from: v, reason: collision with root package name */
    public Map<String, List<String>> f113606v;

    /* renamed from: w, reason: collision with root package name */
    public String f113607w;

    /* renamed from: x, reason: collision with root package name */
    public String f113608x;

    /* renamed from: y, reason: collision with root package name */
    public long f113609y;

    /* renamed from: z, reason: collision with root package name */
    public List<String> f113610z;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15553);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f113585a = "CommReq";
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f113586b = false;
        this.f113591g = null;
        this.f113592h = 0;
        this.f113593i = "";
        this.f113596l = false;
        this.D = null;
        this.f113597m = new DataSection.b();
        this.F = 8192;
        this.G = 8;
        this.f113598n = "";
        this.f113599o = -1L;
        this.H = null;
        this.I = null;
        this.J = null;
        this.f113600p = "";
        this.f113601q = "";
        this.f113602r = "";
        this.f113603s = "";
        this.f113604t = "";
        this.f113605u = "";
        this.f113606v = new HashMap();
        this.f113607w = "";
        this.f113608x = "";
        this.f113609y = -1L;
        this.f113610z = null;
        this.A = null;
        this.B = false;
        this.K = false;
        this.L = 0;
        this.C = 0L;
    }

    private static int a(Throwable th5) {
        try {
            if (th5.getMessage().contains("Permission")) {
                return -71;
            }
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
        if (!(th5 instanceof Exception)) {
            return -70;
        }
        if (th5 == null) {
            return -48;
        }
        int i3 = th5 instanceof SocketTimeoutException ? -25 : -48;
        if (th5 instanceof UnknownHostException) {
            i3 = -29;
        }
        if (th5 instanceof ConnectException) {
            i3 = -24;
        }
        if (th5 instanceof SocketException) {
            i3 = -26;
        }
        if (th5 instanceof IOException) {
            return -27;
        }
        return i3;
    }

    private static long b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return -1L;
        }
    }

    private void c(String str) {
        int indexOf;
        HttpURLConnection httpURLConnection = this.I;
        String headerField = httpURLConnection != null ? httpURLConnection.getHeaderField("X-Extra-Servers") : "";
        if (TextUtils.isEmpty(headerField)) {
            return;
        }
        try {
            if ("http".equals(new URL(str).getProtocol()) && str.startsWith("http://") && (indexOf = str.indexOf("/", 7)) != -1) {
                String substring = str.substring(indexOf);
                String[] split = headerField.split(";");
                if (split == null || split.length <= 0) {
                    return;
                }
                this.f113610z = new ArrayList();
                for (String str2 : split) {
                    this.f113610z.add("http://" + str2 + substring);
                }
            }
        } catch (Exception unused) {
        }
    }

    private String d(String str) {
        try {
            if (str.startsWith("/")) {
                URL url = new URL(this.f113589e.f113890c);
                return url.getProtocol() + QzoneWebViewOfflinePlugin.STR_DEVIDER + url.getHost() + str;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return str;
    }

    private HttpURLConnection l() {
        if (this.H.getProtocol().equals("https")) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) this.H.openConnection();
            httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.tencent.halley.downloader.a.a.a.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                    }
                }

                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) sSLSession)).booleanValue();
                    }
                    a aVar = a.this;
                    return a.a(aVar, sSLSession, aVar.f113594j);
                }
            });
            return httpsURLConnection;
        }
        return (HttpURLConnection) this.H.openConnection();
    }

    private void m() {
        try {
            i.a().a(this.J);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (this.B) {
            this.f113592h = -66;
        }
        d();
    }

    private void n() {
        boolean z16;
        boolean z17;
        a.EnumC1249a enumC1249a;
        if (this.f113597m.f113944a.size() > 0) {
            this.I.addRequestProperty("Range", this.f113597m.toString());
        }
        this.I.addRequestProperty("Connection", "Keep-Alive");
        Map<String, String> map = this.f113591g;
        boolean z18 = true;
        if (map != null) {
            z16 = false;
            z17 = false;
            for (String str : map.keySet()) {
                this.I.addRequestProperty(str, this.f113591g.get(str));
                if ("User-Agent".equalsIgnoreCase(str)) {
                    z16 = true;
                }
                if (str.equalsIgnoreCase("host")) {
                    z17 = true;
                }
            }
        } else {
            z16 = false;
            z17 = false;
        }
        if (!z16) {
            this.I.addRequestProperty("User-Agent", "HalleyService/3.0");
        }
        Map<String, String> map2 = this.f113595k;
        if (map2 != null && map2.size() > 0) {
            for (String str2 : this.f113595k.keySet()) {
                if (str2.equalsIgnoreCase("host")) {
                    z17 = true;
                }
                if (!str2.equalsIgnoreCase(DownloaderConstant.KEY_RANGE) && !this.I.getURL().getPath().contains(this.f113594j)) {
                    this.I.addRequestProperty(str2, this.f113595k.get(str2));
                }
            }
        }
        if (z17 || TextUtils.isEmpty(this.f113594j) || ((enumC1249a = this.f113589e.f113891d) != a.EnumC1249a.f113901f && enumC1249a != a.EnumC1249a.f113908m && enumC1249a != a.EnumC1249a.f113907l)) {
            z18 = false;
        }
        if (z18 && !this.I.getURL().getPath().contains(this.f113594j)) {
            this.I.addRequestProperty("Host", this.f113594j);
        }
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f113592h;
    }

    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f113593i;
    }

    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return j.a(this.E, false);
    }

    public final String h() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            obj = iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            List<String> list = this.D;
            if (list != null && list.size() > 0) {
                obj = this.D.get(r0.size() - 1);
            } else {
                return null;
            }
        }
        return (String) obj;
    }

    public final String i() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        List<String> list = this.D;
        if (list != null && list.size() > 0) {
            str = this.D.get(r0.size() - 1);
        } else {
            str = "";
        }
        return j.a(str, false);
    }

    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        List<String> list = this.D;
        if (list != null && list.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            int size = this.D.size() - 1;
            for (int i3 = 0; i3 < size; i3++) {
                sb5.append(j.a(this.D.get(i3), false));
                sb5.append("-");
            }
            return sb5.toString();
        }
        return "";
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (this.f113597m.a() > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005f A[Catch: all -> 0x00b8, TRY_LEAVE, TryCatch #1 {all -> 0x00b8, blocks: (B:10:0x0018, B:14:0x0045, B:15:0x0055, B:18:0x005f, B:21:0x0071, B:32:0x0084, B:23:0x00a6, B:25:0x00ae, B:45:0x0048, B:48:0x003b), top: B:9:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long a(c cVar) {
        DataSection.a aVar;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar)).longValue();
        }
        long j16 = 0;
        try {
            i a16 = i.a();
            i.a aVar2 = new i.a(this.I.getInputStream(), this.L);
            a16.f113705a.add(aVar2);
            this.J = aVar2;
            DataSection.b bVar = this.f113597m;
            aVar = bVar.a() == 0 ? null : bVar.f113944a.get(0);
        } finally {
            try {
                return j16;
            } finally {
            }
        }
        if (aVar != null) {
            long j17 = aVar.f113943b;
            j3 = j17 - aVar.f113942a;
            if (j17 == -1) {
            }
            byte[] bArr = new byte[this.F];
            boolean z16 = true;
            boolean z17 = true;
            while (j16 < j3) {
                if (this.f113587c.a()) {
                    return j16;
                }
                if (!z16) {
                    return j16;
                }
                int read = this.J.read(bArr, 0, (int) Math.min(this.F, j3 - j16));
                if (read == -1) {
                    this.f113592h = -62;
                    this.f113593i = "readLen:" + j16 + ",dataLen:" + j3;
                    return j16;
                }
                if (!this.f113587c.a()) {
                    z16 = cVar.a(bArr, read, z17);
                }
                if (z17) {
                    z17 = false;
                }
                j16 += read;
            }
            return j16;
        }
        j3 = this.f113609y;
        byte[] bArr2 = new byte[this.F];
        boolean z162 = true;
        boolean z172 = true;
        while (j16 < j3) {
        }
        return j16;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:35|36|37|39|40|(1:161)(1:44)|(14:46|(1:48)(1:159)|49|(1:157)|52|(1:56)|57|58|59|(4:126|(2:128|(2:134|(1:136)(3:137|138|(2:140|(4:142|(2:74|75)|79|(1:107)(2:81|(2:84|85)(1:83)))(6:143|(1:145)|146|(3:72|74|75)|79|(0)(0)))(2:147|(4:149|(0)|79|(0)(0))(6:150|(1:152)|146|(0)|79|(0)(0))))))|153|(0)(0))(4:63|(6:65|(3:108|(1:117)(1:114)|(4:116|(0)|79|(0)(0)))(1:69)|70|(0)|79|(0)(0))|118|(1:120)(6:122|(1:124)|125|(0)|79|(0)(0)))|121|(0)|79|(0)(0))(1:160)|158|52|(2:54|56)|57|58|59|(1:61)|126|(0)|153|(0)(0)|121|(0)|79|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0388, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0389, code lost:
    
        b(r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0280 A[Catch: all -> 0x0388, TryCatch #2 {all -> 0x0388, blocks: (B:59:0x01f3, B:69:0x020f, B:70:0x0212, B:108:0x0216, B:110:0x021c, B:112:0x0220, B:116:0x022b, B:118:0x0231, B:120:0x0240, B:121:0x024c, B:122:0x0250, B:124:0x025a, B:125:0x0261, B:126:0x026f, B:128:0x0280, B:130:0x028d, B:132:0x0296, B:136:0x02a4, B:137:0x02c5, B:140:0x02e6, B:142:0x02ee, B:143:0x02f4, B:145:0x0300, B:146:0x0342, B:147:0x0314, B:149:0x031c, B:150:0x0322, B:152:0x032e), top: B:58:0x01f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02a4 A[Catch: all -> 0x0388, TryCatch #2 {all -> 0x0388, blocks: (B:59:0x01f3, B:69:0x020f, B:70:0x0212, B:108:0x0216, B:110:0x021c, B:112:0x0220, B:116:0x022b, B:118:0x0231, B:120:0x0240, B:121:0x024c, B:122:0x0250, B:124:0x025a, B:125:0x0261, B:126:0x026f, B:128:0x0280, B:130:0x028d, B:132:0x0296, B:136:0x02a4, B:137:0x02c5, B:140:0x02e6, B:142:0x02ee, B:143:0x02f4, B:145:0x0300, B:146:0x0342, B:147:0x0314, B:149:0x031c, B:150:0x0322, B:152:0x032e), top: B:58:0x01f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02c5 A[Catch: all -> 0x0388, TRY_LEAVE, TryCatch #2 {all -> 0x0388, blocks: (B:59:0x01f3, B:69:0x020f, B:70:0x0212, B:108:0x0216, B:110:0x021c, B:112:0x0220, B:116:0x022b, B:118:0x0231, B:120:0x0240, B:121:0x024c, B:122:0x0250, B:124:0x025a, B:125:0x0261, B:126:0x026f, B:128:0x0280, B:130:0x028d, B:132:0x0296, B:136:0x02a4, B:137:0x02c5, B:140:0x02e6, B:142:0x02ee, B:143:0x02f4, B:145:0x0300, B:146:0x0342, B:147:0x0314, B:149:0x031c, B:150:0x0322, B:152:0x032e), top: B:58:0x01f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0097 A[Catch: Exception -> 0x00df, TryCatch #0 {Exception -> 0x00df, blocks: (B:20:0x0039, B:22:0x004e, B:25:0x0082, B:27:0x0088, B:28:0x0094, B:29:0x009c, B:172:0x0097, B:173:0x0073), top: B:19:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0088 A[Catch: Exception -> 0x00df, TryCatch #0 {Exception -> 0x00df, blocks: (B:20:0x0039, B:22:0x004e, B:25:0x0082, B:27:0x0088, B:28:0x0094, B:29:0x009c, B:172:0x0097, B:173:0x0073), top: B:19:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        int i3;
        HttpURLConnection l3;
        String str;
        int responseCode;
        String headerField;
        boolean z16;
        String str2;
        HttpURLConnection httpURLConnection;
        URL url;
        long currentTimeMillis;
        String host;
        String str3;
        com.tencent.halley.downloader.task.d.a aVar;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (TextUtils.isEmpty(this.E)) {
            if (this.f113588d == 2) {
                aVar = this.f113589e;
            } else {
                aVar = this.f113589e;
                if (!aVar.f113893f) {
                    str4 = aVar.f113890c;
                    this.E = str4;
                }
            }
            str4 = aVar.a();
            this.E = str4;
        }
        d();
        try {
            url = new URL(this.E);
            currentTimeMillis = System.currentTimeMillis();
            host = url.getHost();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (!TextUtils.isEmpty(host)) {
            Pattern compile = Pattern.compile("^((([0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){1,7}:)|(([0-9A-Fa-f]{1,4}:){6}:[0-9A-Fa-f]{1,4})|(([0-9A-Fa-f]{1,4}:){5}(:[0-9A-Fa-f]{1,4}){1,2})|(([0-9A-Fa-f]{1,4}:){4}(:[0-9A-Fa-f]{1,4}){1,3})|(([0-9A-Fa-f]{1,4}:){3}(:[0-9A-Fa-f]{1,4}){1,4})|(([0-9A-Fa-f]{1,4}:){2}(:[0-9A-Fa-f]{1,4}){1,5})|([0-9A-Fa-f]{1,4}:(:[0-9A-Fa-f]{1,4}){1,6})|(:(:[0-9A-Fa-f]{1,4}){1,7})|(([0-9A-Fa-f]{1,4}:){6}(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){5}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){4}(:[0-9A-Fa-f]{1,4}){0,1}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){3}(:[0-9A-Fa-f]{1,4}){0,2}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(([0-9A-Fa-f]{1,4}:){2}(:[0-9A-Fa-f]{1,4}){0,3}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|([0-9A-Fa-f]{1,4}:(:[0-9A-Fa-f]{1,4}){0,4}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})|(:(:[0-9A-Fa-f]{1,4}){0,5}:(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}))$");
            Pattern compile2 = Pattern.compile("^(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}$");
            if (compile.matcher(host.substring(1, host.length() - 1)).matches()) {
                str3 = "ipv6";
            } else if (compile2.matcher(host).matches()) {
                str3 = "ipv4";
            }
            this.f113598n = !TextUtils.isEmpty(str3) ? InetAddress.getByName(url.getHost()).getHostAddress() : url.getHost();
            this.f113599o = System.currentTimeMillis() - currentTimeMillis;
            com.tencent.halley.common.utils.d.b(f113585a, "thread name=" + Thread.currentThread().getName() + "; dns ip=" + this.f113598n + "; origin url=" + url + " dnstime: " + this.f113599o);
            i3 = 0;
            while (true) {
                if (i3 < this.G) {
                    if (this.f113587c.a()) {
                        return;
                    }
                    this.f113592h = 0;
                    this.f113593i = "";
                    try {
                        this.H = new URL(this.E);
                        try {
                            com.tencent.halley.common.utils.d.c("DualNetworkManager", "canDownloadByDual, isThreadOpenDual=" + this.f113596l + "; isDualOpen=" + com.tencent.halley.downloader.c.b.a().f113681a + "; isSDKVersionMatch=true");
                        } catch (IOException e17) {
                            e = e17;
                            b(e);
                            e.printStackTrace();
                            if (i3 == 0) {
                            }
                            if (this.f113592h == -57) {
                            }
                            if (i3 >= this.G && this.f113592h == -57) {
                                this.f113592h = -1;
                            }
                            if (this.f113592h == 0) {
                                try {
                                    if (TextUtils.isEmpty(this.f113589e.f113894g)) {
                                        String h16 = h();
                                        if (!TextUtils.isEmpty(h16)) {
                                            this.f113589e.f113894g = h16;
                                            return;
                                        } else {
                                            com.tencent.halley.downloader.task.d.a aVar2 = this.f113589e;
                                            aVar2.f113894g = aVar2.f113890c;
                                            return;
                                        }
                                    }
                                    return;
                                } catch (Exception e18) {
                                    e18.printStackTrace();
                                    return;
                                }
                            }
                            return;
                        }
                    } catch (MalformedURLException e19) {
                        e = e19;
                        this.f113592h = -51;
                        this.f113593i = com.tencent.halley.downloader.a.b.a(e);
                    }
                    if (this.f113596l && com.tencent.halley.downloader.c.b.a().f113681a) {
                        com.tencent.halley.common.utils.d.b(f113585a, "canDownloadByDual: true");
                        Network network = com.tencent.halley.downloader.c.b.a().f113682b;
                        URL url2 = new URL(this.E);
                        if (url2.getProtocol().equals("https")) {
                            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) network.openConnection(url2);
                            httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.tencent.halley.downloader.a.a.a.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) a.this);
                                    }
                                }

                                @Override // javax.net.ssl.HostnameVerifier
                                public final boolean verify(String str5, SSLSession sSLSession) {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str5, (Object) sSLSession)).booleanValue();
                                    }
                                    a aVar3 = a.this;
                                    return a.a(aVar3, sSLSession, aVar3.f113594j);
                                }
                            });
                            httpURLConnection = httpsURLConnection;
                        } else {
                            httpURLConnection = (HttpURLConnection) network.openConnection(url2);
                        }
                        this.I = httpURLConnection;
                        if (network == null || httpURLConnection == null) {
                            com.tencent.halley.common.utils.d.b(f113585a, "canDownloadByDual: false; getCellularNetwork==null");
                            l3 = l();
                        }
                        str = this.A;
                        if (str != null && str.length() > 0) {
                            this.I.setRequestProperty("Cookie", "jn=" + this.A);
                        }
                        this.I.setConnectTimeout(com.tencent.halley.downloader.a.a.a());
                        this.I.setReadTimeout(com.tencent.halley.downloader.a.a.b());
                        this.I.setUseCaches(false);
                        this.I.setDoInput(true);
                        this.I.setInstanceFollowRedirects(false);
                        n();
                        responseCode = this.I.getResponseCode();
                        this.K = true;
                        if (responseCode != 200 || responseCode == 206) {
                            headerField = this.I.getHeaderField("Content-Type");
                            this.f113600p = headerField;
                            if (!TextUtils.isEmpty(headerField)) {
                                String lowerCase = headerField.toLowerCase();
                                if (lowerCase.startsWith("text/html") || lowerCase.startsWith("text/vnd.wap.wml") || lowerCase.startsWith("text/webviewhtml")) {
                                    z16 = true;
                                    if (z16) {
                                        this.f113592h = -11;
                                        str2 = "Content-Type error: " + this.f113600p + ", lastUrl= " + this.E;
                                    } else {
                                        this.f113601q = this.I.getHeaderField("Content-Range");
                                        this.f113602r = this.I.getHeaderField("Content-Length");
                                        if (k()) {
                                            if (TextUtils.isEmpty(this.f113601q)) {
                                                this.f113592h = -53;
                                                if (i3 == 0 && this.K) {
                                                    try {
                                                        this.f113598n = InetAddress.getByName(this.H.getHost()).getHostAddress();
                                                    } catch (Exception e26) {
                                                        e26.printStackTrace();
                                                    }
                                                }
                                                if (this.f113592h == -57) {
                                                    if (this.f113590f) {
                                                        this.f113592h = -74;
                                                        this.f113593i = "location:" + this.E;
                                                    } else {
                                                        i3++;
                                                    }
                                                }
                                            } else {
                                                long a16 = a(this.f113601q);
                                                this.f113609y = a16;
                                                if (a16 == -1) {
                                                    this.f113592h = -54;
                                                    str2 = "content-range header:" + this.f113601q;
                                                }
                                                this.f113604t = this.I.getHeaderField(Headers.ETAG);
                                                this.f113605u = this.I.getHeaderField("x-cos-hash-crc64ecma");
                                                this.f113607w = this.I.getHeaderField("Last-Modified");
                                                this.f113603s = this.I.getHeaderField(HttpHeader.RSP.CONTENT_DISPOSITION);
                                                this.f113608x = this.I.getHeaderField(HttpMsg.CDN_LOG_UUID);
                                                this.f113606v = this.I.getHeaderFields();
                                                this.C = SystemClock.elapsedRealtime();
                                                if (i3 == 0) {
                                                    this.f113598n = InetAddress.getByName(this.H.getHost()).getHostAddress();
                                                }
                                                if (this.f113592h == -57) {
                                                }
                                            }
                                        } else if (TextUtils.isEmpty(this.f113602r)) {
                                            this.f113592h = -55;
                                            if (i3 == 0) {
                                            }
                                            if (this.f113592h == -57) {
                                            }
                                        } else {
                                            long b16 = b(this.f113602r);
                                            this.f113609y = b16;
                                            if (b16 == -1) {
                                                this.f113592h = -56;
                                                str2 = "content-range header:" + this.f113602r;
                                            }
                                            this.f113604t = this.I.getHeaderField(Headers.ETAG);
                                            this.f113605u = this.I.getHeaderField("x-cos-hash-crc64ecma");
                                            this.f113607w = this.I.getHeaderField("Last-Modified");
                                            this.f113603s = this.I.getHeaderField(HttpHeader.RSP.CONTENT_DISPOSITION);
                                            this.f113608x = this.I.getHeaderField(HttpMsg.CDN_LOG_UUID);
                                            this.f113606v = this.I.getHeaderFields();
                                            this.C = SystemClock.elapsedRealtime();
                                            if (i3 == 0) {
                                            }
                                            if (this.f113592h == -57) {
                                            }
                                        }
                                    }
                                }
                            }
                            z16 = false;
                            if (z16) {
                            }
                        } else {
                            if (responseCode != 307) {
                                if (responseCode == 413 || responseCode == 500) {
                                    if (com.tencent.halley.common.a.c.k() && !this.f113586b && k()) {
                                        this.f113592h = -59;
                                        if (i3 == 0) {
                                        }
                                        if (this.f113592h == -57) {
                                        }
                                    }
                                } else {
                                    switch (responseCode) {
                                    }
                                }
                                this.f113592h = responseCode;
                                if (i3 == 0) {
                                }
                                if (this.f113592h == -57) {
                                }
                            }
                            String headerField2 = this.I.getHeaderField("location");
                            if (TextUtils.isEmpty(headerField2)) {
                                this.f113592h = -58;
                                str2 = "location:".concat(String.valueOf(headerField2));
                            } else {
                                String d16 = d(headerField2);
                                this.E = d16;
                                if (this.D == null) {
                                    this.D = new ArrayList();
                                }
                                this.D.add(d16);
                                this.E = d16;
                                c(d16);
                                this.f113592h = -57;
                                if (i3 == 0) {
                                }
                                if (this.f113592h == -57) {
                                }
                            }
                        }
                        this.f113593i = str2;
                        if (i3 == 0) {
                        }
                        if (this.f113592h == -57) {
                        }
                    } else {
                        com.tencent.halley.common.utils.d.b(f113585a, "canDownloadByDual: false protocol = " + this.H.getProtocol());
                        l3 = l();
                    }
                    this.I = l3;
                    str = this.A;
                    if (str != null) {
                        this.I.setRequestProperty("Cookie", "jn=" + this.A);
                    }
                    this.I.setConnectTimeout(com.tencent.halley.downloader.a.a.a());
                    this.I.setReadTimeout(com.tencent.halley.downloader.a.a.b());
                    this.I.setUseCaches(false);
                    this.I.setDoInput(true);
                    this.I.setInstanceFollowRedirects(false);
                    n();
                    responseCode = this.I.getResponseCode();
                    this.K = true;
                    if (responseCode != 200) {
                    }
                    headerField = this.I.getHeaderField("Content-Type");
                    this.f113600p = headerField;
                    if (!TextUtils.isEmpty(headerField)) {
                    }
                    z16 = false;
                    if (z16) {
                    }
                    this.f113593i = str2;
                    if (i3 == 0) {
                    }
                    if (this.f113592h == -57) {
                    }
                }
            }
        }
        str3 = "";
        this.f113598n = !TextUtils.isEmpty(str3) ? InetAddress.getByName(url.getHost()).getHostAddress() : url.getHost();
        this.f113599o = System.currentTimeMillis() - currentTimeMillis;
        com.tencent.halley.common.utils.d.b(f113585a, "thread name=" + Thread.currentThread().getName() + "; dns ip=" + this.f113598n + "; origin url=" + url + " dnstime: " + this.f113599o);
        i3 = 0;
        while (true) {
            if (i3 < this.G) {
            }
            i3++;
        }
    }

    public final byte[] c() {
        ByteArrayOutputStream byteArrayOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        byte[] bArr = null;
        try {
            try {
                this.J = this.I.getInputStream();
                byte[] bArr2 = new byte[256];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = this.J.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            b(th);
                            d();
                            if (byteArrayOutputStream == null) {
                                return null;
                            }
                            byteArrayOutputStream.close();
                            return bArr;
                        } catch (Throwable th6) {
                            d();
                            if (byteArrayOutputStream == null) {
                                return null;
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                            throw th6;
                        }
                    }
                }
                bArr = byteArrayOutputStream.toByteArray();
                d();
                byteArrayOutputStream.close();
            } catch (Throwable th7) {
                th = th7;
                byteArrayOutputStream = null;
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        return bArr;
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (this.I != null) {
            b.a();
            b.a(this.I);
        }
    }

    private static long a(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split("/")) != null && split.length == 2) {
            try {
                return Long.valueOf(split[1]).longValue();
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        return -1L;
    }

    private void b(Throwable th5) {
        boolean z16;
        String str;
        th5.printStackTrace();
        com.tencent.halley.common.utils.d.b(f113585a, "handleException:", th5);
        this.f113593i = com.tencent.halley.downloader.a.b.a(th5);
        boolean z17 = true;
        if (this.B) {
            this.f113592h = -66;
            str = "isAbort";
            z16 = true;
        } else {
            z16 = false;
            str = "";
        }
        if (com.tencent.halley.common.a.c.n()) {
            this.f113592h = -77;
            str = "isDozeMode";
            z16 = true;
        }
        if (!com.tencent.halley.common.a.c.j()) {
            this.f113592h = -15;
            str = "NoNetwork";
            z16 = true;
        }
        if (g.a()) {
            z17 = z16;
        } else {
            this.f113592h = -16;
            str = "PingFail";
        }
        if (!z17) {
            this.f113592h = a(th5);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f113593i = str + " - " + this.f113593i;
    }

    @Override // com.tencent.halley.downloader.a.a.d
    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.B = true;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public final void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        this.L = i3;
        if (this.J != null) {
            i.a();
            i.a(this.J, i3);
        }
    }

    static /* synthetic */ boolean a(a aVar, SSLSession sSLSession, String str) {
        List<String> list = aVar.D;
        String host = (list == null || !list.contains(aVar.H.toString())) ? str : aVar.H.getHost();
        boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSession);
        com.tencent.halley.common.utils.d.c(f113585a + "_qqq", "onHttpsVerify, bizHost = " + str + ", host = " + host + ", ret = " + verify);
        if (verify || !c.a.a().f113687a.contains(host)) {
            return verify;
        }
        com.tencent.halley.common.utils.d.e(f113585a + "_qqq", "DEBUG onHttpsVerify, force true - " + c.a.a().f113687a);
        return true;
    }
}
