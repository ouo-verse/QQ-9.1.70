package com.tencent.mobileqq.msf.core;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_ = null;
    private static final Pattern A;
    private static final Pattern B;

    /* renamed from: s, reason: collision with root package name */
    private static final String f247916s = "EndpointKey";

    /* renamed from: t, reason: collision with root package name */
    public static final String f247917t = "http";

    /* renamed from: u, reason: collision with root package name */
    public static final String f247918u = "socket";

    /* renamed from: v, reason: collision with root package name */
    public static final String f247919v = "quic";

    /* renamed from: w, reason: collision with root package name */
    public static final String f247920w = "null";

    /* renamed from: x, reason: collision with root package name */
    public static final String f247921x = "00000";

    /* renamed from: y, reason: collision with root package name */
    public static final long f247922y = 0;

    /* renamed from: z, reason: collision with root package name */
    public static final long f247923z = 1;

    /* renamed from: a, reason: collision with root package name */
    private String f247924a;

    /* renamed from: b, reason: collision with root package name */
    private String f247925b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f247926c;

    /* renamed from: d, reason: collision with root package name */
    private int f247927d;

    /* renamed from: e, reason: collision with root package name */
    private int f247928e;

    /* renamed from: f, reason: collision with root package name */
    private int f247929f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f247930g;

    /* renamed from: h, reason: collision with root package name */
    private AtomicLong f247931h;

    /* renamed from: i, reason: collision with root package name */
    public byte f247932i;

    /* renamed from: j, reason: collision with root package name */
    public byte f247933j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f247934k;

    /* renamed from: l, reason: collision with root package name */
    public String f247935l;

    /* renamed from: m, reason: collision with root package name */
    public String f247936m;

    /* renamed from: n, reason: collision with root package name */
    public String f247937n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f247938o;

    /* renamed from: p, reason: collision with root package name */
    private AtomicInteger f247939p;

    /* renamed from: q, reason: collision with root package name */
    private long f247940q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f247941r;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23080);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            A = Pattern.compile("([a-zA-Z]+)://([a-zA-Z0-9.]+|\\[[a-zA-Z0-9:]+\\])(:([0-9]+))?(#([0-9_]*))?(:([0-9]+))?(:([0-9]+))?(:([0-9]+))?(:([a-zA-Z]+))?(:([a-zA-Z]+))?(:([a-zA-Z]+))?(:([0-9]+))?(:([a-zA-Z]+))?(:([0-9]+))?");
            B = Pattern.compile("[a-fA-F0-9:][a-fA-F0-9.:]+");
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f247924a = f247918u;
        this.f247926c = false;
        this.f247927d = 0;
        this.f247929f = 20000;
        this.f247930g = false;
        this.f247931h = new AtomicLong(0L);
        this.f247932i = (byte) 1;
        this.f247933j = (byte) 0;
        this.f247934k = false;
        this.f247935l = "";
        this.f247936m = "";
        this.f247937n = "";
        this.f247938o = false;
        this.f247939p = new AtomicInteger();
        this.f247940q = 0L;
        this.f247941r = false;
    }

    public static d a(com.tencent.msf.service.protocol.serverconfig.k kVar, String str, int i3) {
        d dVar = new d();
        a(dVar, kVar.f336860e, kVar.f336856a, i3, kVar.f336857b, kVar.f336859d, kVar.f336861f, kVar.f336862g, kVar.f336863h, kVar.f336864i, str, kVar.f336865j);
        return dVar;
    }

    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this.f247925b : (String) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.f247924a = str;
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.f247928e;
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f247924a;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj)).booleanValue();
        }
        if ((obj instanceof d) && ((d) obj).toString().equals(toString())) {
            return true;
        }
        return false;
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.f247929f;
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return this.f247938o;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.f247926c;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return toString().hashCode();
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.f247925b) && !"null".equals(this.f247925b)) {
            return true;
        }
        return false;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.f247941r;
    }

    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.f247930g;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        if (this.f247931h.get() == 1) {
            return true;
        }
        return false;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.f247940q = System.currentTimeMillis();
        }
    }

    public String n() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (2 == this.f247927d && !this.f247926c) {
            str = "[" + this.f247925b + "]";
        } else {
            str = this.f247925b;
        }
        return str + ":" + this.f247928e;
    }

    public String toString() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(this.f247924a);
        sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        if (2 == this.f247927d && !this.f247926c) {
            str = "[" + this.f247925b + "]";
        } else {
            str = this.f247925b;
        }
        sb5.append(str);
        sb5.append(":");
        sb5.append(this.f247928e);
        sb5.append("#");
        sb5.append(this.f247935l);
        sb5.append(":");
        sb5.append((int) this.f247932i);
        sb5.append(":");
        sb5.append((int) this.f247933j);
        sb5.append(":");
        sb5.append(this.f247929f / 1000);
        sb5.append(":");
        sb5.append(this.f247930g);
        sb5.append(":");
        String str3 = "null";
        if (TextUtils.isEmpty(this.f247936m)) {
            str2 = "null";
        } else {
            str2 = this.f247936m;
        }
        sb5.append(str2);
        sb5.append(":");
        if (!TextUtils.isEmpty(this.f247937n)) {
            str3 = this.f247937n;
        }
        sb5.append(str3);
        sb5.append(":");
        sb5.append(this.f247927d);
        sb5.append(":");
        sb5.append(this.f247926c);
        sb5.append(":");
        sb5.append(this.f247931h);
        return sb5.toString();
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            this.f247925b = str;
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? this.f247927d : ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
    }

    public static d a(com.tencent.msf.service.protocol.serverconfig.i iVar, String str, int i3) {
        d dVar = new d();
        a(dVar, iVar.f336826e, iVar.f336822a, i3, iVar.f336823b, iVar.f336825d, iVar.f336827f, iVar.f336828g, iVar.f336829h, iVar.f336830i, str, iVar.f336831j);
        return dVar;
    }

    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            this.f247929f = i3;
        } else {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            this.f247930g = z16;
        } else {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        }
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            this.f247938o = z16;
        } else {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        }
    }

    private static void a(d dVar, byte b16, String str, int i3, int i16, byte b17, int i17, byte b18, String str2, String str3, String str4, long j3) {
        if (b16 == 2 || b16 == 3) {
            dVar.f247924a = "http";
        } else if (b16 == 0 || b16 == 1) {
            dVar.f247924a = f247918u;
        }
        dVar.f247925b = str;
        dVar.f247927d = i3;
        dVar.f247926c = !B.matcher(str).matches();
        dVar.f247928e = i16;
        dVar.f247932i = (byte) 0;
        dVar.f247933j = b17;
        if (i17 > 20) {
            dVar.f247929f = 20000;
        } else if (i17 < 5) {
            dVar.f247929f = 5000;
        } else {
            dVar.f247929f = i17 * 1000;
        }
        if (b18 == 1) {
            dVar.f247930g = true;
        }
        dVar.f247936m = str2;
        dVar.f247937n = str3;
        dVar.f247935l = "";
        if (com.tencent.mobileqq.msf.core.x.q.f250391w.equals(str4)) {
            dVar.f247935l = f247921x;
            dVar.a(true);
        } else {
            dVar.a(false);
        }
        dVar.f247931h.set(j3);
    }

    public static d a(String str) {
        String lowerCase = str.toLowerCase();
        d dVar = new d();
        Matcher matcher = A.matcher(lowerCase);
        if (matcher.find()) {
            if (matcher.group(1) != null) {
                String group = matcher.group(1);
                dVar.f247924a = group;
                if (TextUtils.equals("https", group)) {
                    dVar.f247924a = "http";
                }
            }
            if (matcher.group(2) != null) {
                String group2 = matcher.group(2);
                dVar.f247925b = group2;
                if (group2.startsWith("[") && dVar.f247925b.endsWith("]")) {
                    String str2 = dVar.f247925b;
                    dVar.f247925b = str2.substring(1, str2.length() - 1);
                    dVar.f247927d = 2;
                    dVar.f247926c = false;
                } else if (!"msfwifiv6.3g.qq.com".equals(dVar.f247925b) && !"msfxgv6.3g.qq.com".equals(dVar.f247925b)) {
                    boolean z16 = !B.matcher(dVar.f247925b).matches();
                    dVar.f247926c = z16;
                    dVar.f247927d = 1;
                    if (!z16) {
                        try {
                            if (InetAddress.getByName(dVar.f247925b) instanceof Inet6Address) {
                                dVar.f247927d = 2;
                            }
                        } catch (UnknownHostException unused) {
                        }
                    }
                } else {
                    dVar.f247927d = 2;
                    dVar.f247926c = true;
                }
            }
            if (matcher.group(4) != null) {
                dVar.f247928e = Integer.parseInt(matcher.group(4));
            } else {
                dVar.f247928e = 80;
            }
            if (matcher.group(6) != null) {
                dVar.f247935l = matcher.group(6);
            }
            if (matcher.group(8) != null) {
                dVar.f247932i = Byte.parseByte(matcher.group(8));
            }
            if (matcher.group(10) != null) {
                dVar.f247933j = Byte.parseByte(matcher.group(10));
            }
            if (matcher.group(12) != null) {
                dVar.f247929f = Integer.parseInt(matcher.group(12)) * 1000;
            }
            if (matcher.group(14) != null) {
                dVar.f247930g = Boolean.parseBoolean(matcher.group(14));
            }
            if (matcher.group(16) != null) {
                dVar.f247936m = matcher.group(16).equals("null") ? "" : matcher.group(16);
            }
            if (matcher.group(18) != null) {
                dVar.f247937n = matcher.group(18).equals("null") ? "" : matcher.group(18);
            }
            if (matcher.group(24) != null) {
                dVar.f247931h.set(Long.parseLong(matcher.group(24)));
                QLog.d(com.tencent.mobileqq.msf.core.x.q.f250386r, 1, "[Endpoint] fromString, ability = " + dVar.f247931h);
            }
            dVar.a(dVar.f247935l.equals(f247921x));
        }
        return dVar;
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            this.f247928e = i3;
        } else {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
    }

    public boolean a(com.tencent.qphone.base.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) aVar)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar != com.tencent.qphone.base.a.writeError && aVar != com.tencent.qphone.base.a.readError) {
            if (aVar == com.tencent.qphone.base.a.continueWaitRspTimeout) {
                this.f247939p.addAndGet(com.tencent.mobileqq.msf.core.x.b.I0());
            } else if (aVar == com.tencent.qphone.base.a.closeBySSOPingTimeout) {
                this.f247939p.addAndGet(com.tencent.mobileqq.msf.core.x.b.L0());
            } else if (aVar == com.tencent.qphone.base.a.closeByNetDetectFailed) {
                this.f247939p.addAndGet(com.tencent.mobileqq.msf.core.x.b.K0());
            } else if (aVar == com.tencent.qphone.base.a.invalidData) {
                this.f247939p.addAndGet(com.tencent.mobileqq.msf.core.x.b.J0());
            } else if (aVar == com.tencent.qphone.base.a.connFull) {
                this.f247939p.addAndGet(com.tencent.mobileqq.msf.core.x.b.H0());
            }
        } else {
            long j3 = this.f247940q;
            if (j3 != 0 && currentTimeMillis - j3 <= 600000) {
                this.f247939p.addAndGet(com.tencent.mobileqq.msf.core.x.b.M0());
            } else {
                this.f247940q = currentTimeMillis;
                this.f247939p.incrementAndGet();
            }
        }
        if (this.f247939p.get() <= 19) {
            return false;
        }
        this.f247939p.set(0);
        return true;
    }

    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            this.f247941r = z16;
        } else {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        }
    }

    public void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
            this.f247931h.set(j3);
        } else {
            iPatchRedirector.redirect((short) 24, (Object) this, j3);
        }
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        if (g() && h()) {
            return 2;
        }
        if (g() && !h()) {
            return 1;
        }
        if (g() || !h()) {
            return (g() || h()) ? 0 : 3;
        }
        return 4;
    }
}
