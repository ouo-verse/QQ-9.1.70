package com.tencent.hlyyb.downloader.a.a;

import android.net.http.Headers;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.hlyyb.common.a.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class a implements c {
    static IPatchRedirector $redirector_;
    public boolean A;

    /* renamed from: a, reason: collision with root package name */
    public int f114364a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.hlyyb.downloader.e.f.a f114365b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f114366c;

    /* renamed from: d, reason: collision with root package name */
    public List<String> f114367d;

    /* renamed from: e, reason: collision with root package name */
    public String f114368e;

    /* renamed from: f, reason: collision with root package name */
    public b f114369f;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, String> f114370g;

    /* renamed from: h, reason: collision with root package name */
    public int f114371h;

    /* renamed from: i, reason: collision with root package name */
    public String f114372i;

    /* renamed from: j, reason: collision with root package name */
    public int f114373j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f114374k;

    /* renamed from: l, reason: collision with root package name */
    public int f114375l;

    /* renamed from: m, reason: collision with root package name */
    public String f114376m;

    /* renamed from: n, reason: collision with root package name */
    public URL f114377n;

    /* renamed from: o, reason: collision with root package name */
    public HttpURLConnection f114378o;

    /* renamed from: p, reason: collision with root package name */
    public InputStream f114379p;

    /* renamed from: q, reason: collision with root package name */
    public String f114380q;

    /* renamed from: r, reason: collision with root package name */
    public String f114381r;

    /* renamed from: s, reason: collision with root package name */
    public String f114382s;

    /* renamed from: t, reason: collision with root package name */
    public String f114383t;

    /* renamed from: u, reason: collision with root package name */
    public String f114384u;

    /* renamed from: v, reason: collision with root package name */
    public String f114385v;

    /* renamed from: w, reason: collision with root package name */
    public long f114386w;

    /* renamed from: x, reason: collision with root package name */
    public List<String> f114387x;

    /* renamed from: y, reason: collision with root package name */
    public com.tencent.hlyyb.downloader.a.a f114388y;

    /* renamed from: z, reason: collision with root package name */
    public volatile boolean f114389z;

    /* compiled from: P */
    /* renamed from: com.tencent.hlyyb.downloader.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C5817a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f114390a;

        /* renamed from: b, reason: collision with root package name */
        public long f114391b;

        public C5817a(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16));
            } else {
                this.f114390a = j3;
                this.f114391b = j16;
            }
        }

        public final boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
            }
            if (obj instanceof C5817a) {
                C5817a c5817a = (C5817a) obj;
                if (this.f114390a == c5817a.f114390a && this.f114391b == c5817a.f114391b) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "[" + this.f114390a + "," + this.f114391b + "]";
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public List<C5817a> f114392a;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f114392a = new ArrayList();
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f114392a.size();
        }

        public final void c(C5817a c5817a) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) c5817a);
                return;
            }
            Iterator<C5817a> it = this.f114392a.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().equals(c5817a)) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                this.f114392a.add(c5817a);
            }
        }

        public final C5817a d() {
            Object obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                obj = iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                if (this.f114392a.size() == 0) {
                    return null;
                }
                obj = this.f114392a.get(0);
            }
            return (C5817a) obj;
        }

        public final String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder("bytes=");
            for (C5817a c5817a : this.f114392a) {
                sb5.append(c5817a.f114390a);
                sb5.append("-");
                long j3 = c5817a.f114391b;
                if (j3 != -1) {
                    sb5.append(j3);
                }
                sb5.append(",");
            }
            sb5.deleteCharAt(sb5.length() - 1);
            return sb5.toString();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f114367d = null;
        this.f114369f = new b();
        this.f114370g = null;
        this.f114371h = 0;
        this.f114372i = "";
        this.f114373j = 4096;
        this.f114374k = false;
        this.f114375l = 8;
        this.f114376m = "";
        this.f114377n = null;
        this.f114378o = null;
        this.f114379p = null;
        this.f114380q = "";
        this.f114381r = "";
        this.f114382s = "";
        this.f114383t = "";
        this.f114384u = "";
        this.f114385v = "";
        this.f114386w = -1L;
        this.f114387x = null;
        this.f114389z = false;
        this.A = false;
    }

    public static int b(Throwable th5) {
        try {
            if (th5.getMessage().contains("Permission")) {
                return -71;
            }
        } catch (Throwable unused) {
        }
        if (!(th5 instanceof Exception)) {
            return -70;
        }
        if (th5 != null) {
            if (th5 instanceof SocketTimeoutException) {
                return -25;
            }
            if (th5 instanceof UnknownHostException) {
                return -29;
            }
            if (th5 instanceof ConnectException) {
                return -24;
            }
            if (th5 instanceof SocketException) {
                return -26;
            }
            if (th5 instanceof IOException) {
                return -27;
            }
        }
        return -48;
    }

    public static long c(String str) {
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

    private void t() {
        if (this.f114369f.f114392a.size() > 0) {
            this.f114378o.addRequestProperty("Range", this.f114369f.toString());
        }
        this.f114378o.addRequestProperty("Connection", "close");
        Map<String, String> map = this.f114370g;
        boolean z16 = false;
        if (map != null) {
            for (String str : map.keySet()) {
                this.f114378o.addRequestProperty(str, this.f114370g.get(str));
                if ("User-Agent".equalsIgnoreCase(str)) {
                    z16 = true;
                }
            }
        }
        if (!z16) {
            this.f114378o.addRequestProperty("User-Agent", "HalleyService/3.0");
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f114371h : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.f114386w;
    }

    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return com.tencent.hlyyb.common.b.b.a(this.f114368e, false);
    }

    public final String f() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            obj = iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            List<String> list = this.f114367d;
            if (list != null && list.size() > 0) {
                obj = this.f114367d.get(r0.size() - 1);
            } else {
                return null;
            }
        }
        return (String) obj;
    }

    public final String g() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        List<String> list = this.f114367d;
        if (list != null && list.size() > 0) {
            str = this.f114367d.get(r0.size() - 1);
        } else {
            str = "";
        }
        return com.tencent.hlyyb.common.b.b.a(str, false);
    }

    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f114376m;
    }

    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f114380q;
    }

    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f114381r;
    }

    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f114382s;
    }

    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f114384u;
    }

    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f114385v;
    }

    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f114383t;
    }

    public final List<String> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f114387x;
    }

    public final boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        if (this.f114369f.a() > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        if (android.text.TextUtils.isEmpty(r1.f114535e) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        r1 = r1.f114535e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        if (android.text.TextUtils.isEmpty(r1.f114535e) == false) goto L19;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:44:0x00a5. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0136 A[Catch: all -> 0x01da, TryCatch #3 {all -> 0x01da, blocks: (B:34:0x0089, B:44:0x00a5, B:46:0x00c5, B:84:0x00a9, B:86:0x00af, B:88:0x00b3, B:92:0x00bf, B:94:0x00c9, B:96:0x00d8, B:97:0x00e1, B:98:0x01ac, B:99:0x01b0, B:100:0x00e6, B:102:0x00ec, B:103:0x00f3, B:104:0x0101, B:106:0x0112, B:108:0x011f, B:110:0x0128, B:114:0x0136, B:115:0x013e, B:120:0x0165, B:122:0x016d, B:124:0x0179, B:125:0x01b3, B:126:0x0186, B:127:0x018b, B:129:0x0193, B:131:0x019f, B:132:0x01d5), top: B:33:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x013e A[Catch: all -> 0x01da, TRY_LEAVE, TryCatch #3 {all -> 0x01da, blocks: (B:34:0x0089, B:44:0x00a5, B:46:0x00c5, B:84:0x00a9, B:86:0x00af, B:88:0x00b3, B:92:0x00bf, B:94:0x00c9, B:96:0x00d8, B:97:0x00e1, B:98:0x01ac, B:99:0x01b0, B:100:0x00e6, B:102:0x00ec, B:103:0x00f3, B:104:0x0101, B:106:0x0112, B:108:0x011f, B:110:0x0128, B:114:0x0136, B:115:0x013e, B:120:0x0165, B:122:0x016d, B:124:0x0179, B:125:0x01b3, B:126:0x0186, B:127:0x018b, B:129:0x0193, B:131:0x019f, B:132:0x01d5), top: B:33:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x022e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q() {
        boolean z16;
        int responseCode;
        boolean z17;
        StringBuilder sb5;
        String str;
        String str2;
        com.tencent.hlyyb.downloader.e.f.a aVar;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (TextUtils.isEmpty(this.f114368e)) {
            if (this.f114364a == 2) {
                aVar = this.f114365b;
            } else {
                aVar = this.f114365b;
                if (aVar.f114534d) {
                }
                str3 = aVar.f114531a;
            }
            this.f114368e = str3;
        }
        s();
        int i3 = 0;
        while (true) {
            if (i3 < this.f114375l) {
                if (this.f114388y.b()) {
                    return;
                }
                this.f114371h = 0;
                this.f114372i = "";
                try {
                    URL url = new URL(this.f114368e);
                    this.f114377n = url;
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        this.f114378o = httpURLConnection;
                        httpURLConnection.setConnectTimeout(20000);
                        this.f114378o.setReadTimeout(20000);
                        this.f114378o.setUseCaches(false);
                        z16 = true;
                        this.f114378o.setDoInput(true);
                        this.f114378o.setInstanceFollowRedirects(false);
                        t();
                        try {
                            responseCode = this.f114378o.getResponseCode();
                            this.A = true;
                        } catch (Throwable th5) {
                            a(th5);
                        }
                    } catch (IOException e16) {
                        e = e16;
                        a(e);
                        e.printStackTrace();
                        if (i3 == 0) {
                        }
                        if (this.f114371h == -57) {
                        }
                        if (i3 >= this.f114375l && this.f114371h == -57) {
                            this.f114371h = -1;
                        }
                        if (this.f114371h == 0) {
                            try {
                                if (TextUtils.isEmpty(this.f114365b.f114535e)) {
                                    String f16 = f();
                                    if (!TextUtils.isEmpty(f16)) {
                                        this.f114365b.f114535e = f16;
                                        return;
                                    } else {
                                        com.tencent.hlyyb.downloader.e.f.a aVar2 = this.f114365b;
                                        aVar2.f114535e = aVar2.f114531a;
                                        return;
                                    }
                                }
                                return;
                            } catch (Exception e17) {
                                e17.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                } catch (MalformedURLException e18) {
                    e = e18;
                    this.f114371h = -51;
                    this.f114372i = e.getMessage();
                }
                if (responseCode != 200 && responseCode != 206) {
                    if (responseCode != 307) {
                        if (responseCode == 413 || responseCode == 500) {
                            if (com.tencent.hlyyb.common.a.a.h() && !this.f114374k) {
                                if (this.f114369f.a() <= 0) {
                                    z16 = false;
                                }
                                if (z16) {
                                    this.f114371h = -59;
                                    if (i3 == 0) {
                                    }
                                    if (this.f114371h == -57) {
                                    }
                                }
                            }
                        } else {
                            switch (responseCode) {
                            }
                            if (i3 == 0) {
                            }
                            if (this.f114371h == -57) {
                            }
                        }
                        this.f114371h = responseCode;
                        if (i3 == 0) {
                        }
                        if (this.f114371h == -57) {
                        }
                    }
                    str = this.f114378o.getHeaderField("location");
                    if (TextUtils.isEmpty(str)) {
                        this.f114371h = -58;
                        sb5 = new StringBuilder("location:");
                    } else {
                        this.f114368e = str;
                        if (this.f114367d == null) {
                            this.f114367d = new ArrayList();
                        }
                        this.f114367d.add(str);
                        this.f114368e = str;
                        a(str);
                        this.f114371h = -57;
                        if (i3 == 0) {
                        }
                        if (this.f114371h == -57) {
                        }
                    }
                } else {
                    String headerField = this.f114378o.getHeaderField("Content-Type");
                    this.f114380q = headerField;
                    if (!TextUtils.isEmpty(headerField)) {
                        String lowerCase = headerField.toLowerCase();
                        if (lowerCase.startsWith("text/html") || lowerCase.startsWith("text/vnd.wap.wml") || lowerCase.startsWith("text/webviewhtml")) {
                            z17 = true;
                            if (!z17) {
                                this.f114371h = -11;
                                str2 = this.f114368e;
                                this.f114372i = str2;
                                if (i3 == 0 && this.A) {
                                    try {
                                        this.f114376m = InetAddress.getByName(this.f114377n.getHost()).getHostAddress();
                                    } catch (Exception e19) {
                                        e19.printStackTrace();
                                    }
                                }
                                if (this.f114371h == -57) {
                                    if (this.f114366c) {
                                        this.f114371h = -74;
                                        this.f114372i = "location:" + this.f114368e;
                                    } else {
                                        i3++;
                                    }
                                }
                            } else {
                                this.f114381r = this.f114378o.getHeaderField("Content-Range");
                                this.f114382s = this.f114378o.getHeaderField("Content-Length");
                                if (this.f114369f.a() <= 0) {
                                    z16 = false;
                                }
                                if (z16) {
                                    if (!TextUtils.isEmpty(this.f114381r)) {
                                        long b16 = b(this.f114381r);
                                        this.f114386w = b16;
                                        if (b16 == -1) {
                                            this.f114371h = -54;
                                            sb5 = new StringBuilder("content-range header:");
                                            str = this.f114381r;
                                        }
                                        this.f114384u = this.f114378o.getHeaderField(Headers.ETAG);
                                        this.f114385v = this.f114378o.getHeaderField("Last-Modified");
                                        this.f114383t = this.f114378o.getHeaderField(HttpHeader.RSP.CONTENT_DISPOSITION);
                                        if (i3 == 0) {
                                            this.f114376m = InetAddress.getByName(this.f114377n.getHost()).getHostAddress();
                                        }
                                        if (this.f114371h == -57) {
                                        }
                                    } else {
                                        this.f114371h = -53;
                                        if (i3 == 0) {
                                        }
                                        if (this.f114371h == -57) {
                                        }
                                    }
                                } else if (!TextUtils.isEmpty(this.f114382s)) {
                                    long c16 = c(this.f114382s);
                                    this.f114386w = c16;
                                    if (c16 == -1) {
                                        this.f114371h = -56;
                                        sb5 = new StringBuilder("content-range header:");
                                        str = this.f114382s;
                                    }
                                    this.f114384u = this.f114378o.getHeaderField(Headers.ETAG);
                                    this.f114385v = this.f114378o.getHeaderField("Last-Modified");
                                    this.f114383t = this.f114378o.getHeaderField(HttpHeader.RSP.CONTENT_DISPOSITION);
                                    if (i3 == 0) {
                                    }
                                    if (this.f114371h == -57) {
                                    }
                                } else {
                                    this.f114371h = -55;
                                    if (i3 == 0) {
                                    }
                                    if (this.f114371h == -57) {
                                    }
                                }
                                this.f114372i = str2;
                                if (i3 == 0) {
                                }
                                if (this.f114371h == -57) {
                                }
                            }
                        }
                    }
                    z17 = false;
                    if (!z17) {
                    }
                }
                sb5.append(str);
                str2 = sb5.toString();
                this.f114372i = str2;
                if (i3 == 0) {
                }
                if (this.f114371h == -57) {
                }
            }
        }
    }

    public final byte[] r() {
        ByteArrayOutputStream byteArrayOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (byte[]) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        byte[] bArr = null;
        try {
            this.f114379p = this.f114378o.getInputStream();
            byte[] bArr2 = new byte[256];
            byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                try {
                    int read = this.f114379p.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        a(th);
                    } finally {
                        s();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                    }
                }
            }
            bArr = byteArrayOutputStream.toByteArray();
            s();
        } catch (Throwable th6) {
            th = th6;
            byteArrayOutputStream = null;
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused2) {
            return bArr;
        }
    }

    public final void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        HttpURLConnection httpURLConnection = this.f114378o;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                this.f114379p.close();
            } catch (Throwable unused) {
            }
            this.f114378o = null;
        }
        this.f114379p = null;
    }

    public static long b(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split("/")) == null || split.length != 2) {
            return -1L;
        }
        try {
            return Long.valueOf(split[1]).longValue();
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return -1L;
        }
    }

    public final String a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this, z16);
        }
        List<String> list = this.f114367d;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int size = this.f114367d.size() - 1;
        for (int i3 = 0; i3 < size; i3++) {
            sb5.append(com.tencent.hlyyb.common.b.b.a(this.f114367d.get(i3), false));
            sb5.append("-");
        }
        return sb5.toString();
    }

    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f114372i : (String) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public final void a(C5817a c5817a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            this.f114369f.c(c5817a);
        } else {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) c5817a);
        }
    }

    @Override // com.tencent.hlyyb.downloader.a.a.c
    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            this.f114389z = true;
        } else {
            iPatchRedirector.redirect((short) 23, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0031, code lost:
    
        if (r6 == (-1)) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.tencent.hlyyb.downloader.a.a.b bVar) {
        long j3;
        long j16;
        long j17;
        int min;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            int i3 = -66;
            try {
                this.f114379p = this.f114378o.getInputStream();
                C5817a d16 = this.f114369f.d();
                if (d16 != null) {
                    long j18 = d16.f114391b;
                    j17 = j18 - d16.f114390a;
                }
                j17 = this.f114386w;
                byte[] bArr = new byte[this.f114373j];
                boolean z16 = true;
                boolean z17 = true;
                long j19 = 0;
                j3 = 0;
                j16 = 0;
                while (j19 < j17) {
                    try {
                        if (this.f114388y.b()) {
                            if (this.f114389z) {
                                this.f114371h = i3;
                            }
                            s();
                            return;
                        }
                        if (!z16) {
                            if (this.f114389z) {
                                this.f114371h = i3;
                            }
                            s();
                            return;
                        }
                        long j26 = j3;
                        try {
                            min = (int) Math.min(this.f114373j, j17 - j19);
                            j3 = j19 == 0 ? SystemClock.elapsedRealtime() : j26;
                        } catch (Throwable th5) {
                            th = th5;
                            j3 = j26;
                        }
                        try {
                            boolean z18 = z16;
                            int read = this.f114379p.read(bArr, 0, min);
                            if (j19 == 0) {
                                j16 = SystemClock.elapsedRealtime();
                            }
                            if (read == -1) {
                                this.f114371h = -62;
                                this.f114372i = "readLen:" + j19 + ",dataLen:" + j17;
                                if (this.f114389z) {
                                    this.f114371h = -66;
                                }
                                s();
                                return;
                            }
                            if (bVar != null) {
                                boolean a16 = !this.f114388y.b() ? bVar.a(bArr, read, z17) : z18;
                                if (z17) {
                                    z17 = false;
                                }
                                z16 = a16;
                            } else {
                                z16 = z18;
                            }
                            j19 += read;
                            i3 = -66;
                        } catch (Throwable th6) {
                            th = th6;
                            try {
                                a(th);
                                if (j3 != 0 && j16 == 0) {
                                    SystemClock.elapsedRealtime();
                                }
                                if (this.f114389z) {
                                    this.f114371h = -66;
                                }
                                s();
                                return;
                            } catch (Throwable th7) {
                                if (this.f114389z) {
                                    this.f114371h = -66;
                                }
                                s();
                                throw th7;
                            }
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                }
                if (this.f114389z) {
                    this.f114371h = -66;
                }
                s();
            } catch (Throwable th9) {
                th = th9;
                j3 = 0;
                j16 = 0;
            }
        } else {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) bVar);
        }
    }

    private void a(String str) {
        int indexOf;
        HttpURLConnection httpURLConnection = this.f114378o;
        String headerField = httpURLConnection != null ? httpURLConnection.getHeaderField("X-Extra-Servers") : "";
        if (TextUtils.isEmpty(headerField)) {
            return;
        }
        try {
            if ("http".equals(new URL(str).getProtocol()) && str.startsWith("http://") && (indexOf = str.indexOf("/", 7)) != -1) {
                str.substring(7, indexOf);
                String substring = str.substring(indexOf);
                String[] split = headerField.split(";");
                if (split == null || split.length <= 0) {
                    return;
                }
                this.f114387x = new ArrayList();
                for (String str2 : split) {
                    this.f114387x.add("http://" + str2 + substring);
                }
            }
        } catch (Exception unused) {
        }
    }

    private void a(Throwable th5) {
        th5.printStackTrace();
        this.f114372i = th5.getClass().getName() + "|" + th5;
        this.f114371h = this.f114389z ? -66 : com.tencent.hlyyb.common.a.a.d() ? -77 : !com.tencent.hlyyb.common.a.a.g() ? -15 : !e.a("info.3g.qq.com", 80, 5000) ? -16 : b(th5);
    }
}
