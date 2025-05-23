package com.tencent.luggage.wxa.vm;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.om.e;
import com.tencent.luggage.wxa.om.g;
import com.tencent.luggage.wxa.qm.k;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.upload.report.UploadQualityReportBuilder;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements IMediaHTTPConnection {

    /* renamed from: n, reason: collision with root package name */
    private static final String f143694n = "MicroMsg.Music.MMMediaHTTPConnection";

    /* renamed from: o, reason: collision with root package name */
    private static final boolean f143695o = true;

    /* renamed from: p, reason: collision with root package name */
    private static final boolean f143696p = false;

    /* renamed from: q, reason: collision with root package name */
    private static final int f143697q = 30000;

    /* renamed from: r, reason: collision with root package name */
    public static final String f143698r = "application/octet-stream";

    /* renamed from: s, reason: collision with root package name */
    private static final int f143699s = 307;

    /* renamed from: t, reason: collision with root package name */
    private static final int f143700t = 20;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.luggage.wxa.om.a f143701a;

    /* renamed from: b, reason: collision with root package name */
    private long f143702b = -1;

    /* renamed from: c, reason: collision with root package name */
    private URL f143703c = null;

    /* renamed from: d, reason: collision with root package name */
    private URL f143704d = null;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f143705e = null;

    /* renamed from: f, reason: collision with root package name */
    private HttpURLConnection f143706f = null;

    /* renamed from: g, reason: collision with root package name */
    private long f143707g = -1;

    /* renamed from: h, reason: collision with root package name */
    private String f143708h = "";

    /* renamed from: i, reason: collision with root package name */
    private InputStream f143709i = null;

    /* renamed from: j, reason: collision with root package name */
    private boolean f143710j = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f143711k = true;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f143712l = new byte[1];

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    private final Map<String, String> f143713m;

    public a(@NonNull Map<String, String> map) {
        this.f143713m = map;
    }

    private boolean a(String str) {
        try {
            return w0.a(str, 0L) != 0;
        } catch (NumberFormatException unused) {
            return "true".equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str);
        }
    }

    private void c() {
        InputStream inputStream = this.f143709i;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e16) {
                w.a(f143694n, e16, "teardownConnection", new Object[0]);
            }
            this.f143709i = null;
        }
        HttpURLConnection httpURLConnection = this.f143706f;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.getInputStream().close();
            } catch (Exception e17) {
                w.b(f143694n, e17.getMessage());
            }
            this.f143706f.disconnect();
            this.f143706f = null;
            this.f143702b = -1L;
        }
    }

    public String b() {
        return this.f143704d.toString();
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public boolean connect(URL url, Map<String, String> map) {
        Logger.i(f143694n, UploadQualityReportBuilder.STATE_CONNECT);
        Logger.i(f143694n, "connect: uri=" + url + ", headers=" + map);
        disconnect();
        this.f143710j = true;
        this.f143703c = url;
        this.f143704d = url;
        this.f143705e = map;
        if (map == null) {
            map = new HashMap<>();
            this.f143705e = map;
        }
        this.f143707g = -1L;
        this.f143708h = "";
        if (z.k()) {
            String e16 = e.e(this.f143703c.toString());
            if (!TextUtils.isEmpty(e16) && !e16.equalsIgnoreCase(this.f143703c.toString())) {
                w.d(f143694n, "use temp shake music url to play:%s", e16);
                try {
                    this.f143703c = new URL(e16);
                } catch (MalformedURLException e17) {
                    w.a(f143694n, e17, "playUrl", new Object[0]);
                }
            }
            com.tencent.luggage.wxa.qm.b h16 = k.h();
            if (h16 != null) {
                try {
                    URL b16 = h16.b(this.f143703c.toString());
                    if (b16 != null && !TextUtils.isEmpty(b16.toString())) {
                        this.f143703c = b16;
                        w.d(f143694n, "use getRedirectURL url to play:%s", b16.toString());
                    }
                } catch (MalformedURLException e18) {
                    w.a(f143694n, e18, "getRedirectURL", new Object[0]);
                }
            }
        }
        URL url2 = this.f143703c;
        if (url2 != null) {
            g.a(url2.toString(), map);
            String url3 = this.f143704d.toString();
            Logger.d(f143694n, "connect, originUrlStr: " + url3);
            String str = this.f143713m.get(url3);
            if (!"invalidReferrer".equals(str)) {
                map.remove(ISchemeApi.KEY_REFERER);
                if (!w0.c(str)) {
                    Logger.i(f143694n, "connect, add referrer: " + str);
                    try {
                        map.put("Referer", str);
                    } catch (Exception e19) {
                        Logger.i(f143694n, "connect, put referrer fail since " + e19.toString());
                        HashMap hashMap = new HashMap(map);
                        hashMap.put("Referer", str);
                        map = hashMap;
                    }
                }
            }
            Logger.i(f143694n, "headers=" + map);
        }
        com.tencent.luggage.wxa.om.a aVar = new com.tencent.luggage.wxa.om.a(this);
        this.f143701a = aVar;
        aVar.a();
        return true;
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public void disconnect() {
        Logger.i(f143694n, "disconnect");
        c();
        this.f143705e = null;
        this.f143703c = null;
        com.tencent.luggage.wxa.om.a aVar = this.f143701a;
        if (aVar != null) {
            aVar.b();
            this.f143701a = null;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public String getMIMEType() {
        String str;
        if (!TextUtils.isEmpty(this.f143708h)) {
            Logger.i(f143694n, "getMIMEType mimeType:" + this.f143708h);
            return this.f143708h;
        }
        String d16 = g.d(b());
        if (!TextUtils.isEmpty(d16)) {
            this.f143708h = d16;
            return d16;
        }
        if (this.f143706f == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                a(0L);
                str = this.f143706f.getContentType();
                w.a(f143694n, "getMIMEType cost time :%d!", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            } catch (IOException e16) {
                StringBuilder sb5 = new StringBuilder();
                str = "";
                sb5.append("");
                sb5.append(e16);
                Logger.e(f143694n, "getMIMEType exception:%s", sb5.toString());
            }
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            String contentType = this.f143706f.getContentType();
            Logger.i(f143694n, "getMIMEType mimeType:" + contentType);
            w.a(f143694n, "getMIMEType cost time2 :%d!", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            str = contentType;
        }
        this.f143708h = str;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String g16 = g.g(b());
        this.f143708h = g16;
        if (!TextUtils.isEmpty(g16)) {
            return g16;
        }
        return "application/octet-stream";
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public long getSize() {
        long j3 = this.f143707g;
        if (j3 > 0) {
            return j3;
        }
        if (g.c(b()) > 0) {
            long c16 = g.c(b());
            this.f143707g = c16;
            return c16;
        }
        if (this.f143706f == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                a(0L);
                w.a(f143694n, "getSize cost time :%d!", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            } catch (IOException e16) {
                Logger.e(f143694n, "getSize exception:%s", "" + e16);
                this.f143707g = -1L;
            }
        }
        long j16 = this.f143707g;
        if (j16 > 0) {
            return j16;
        }
        if (g.b(b()) <= 0) {
            return -1L;
        }
        long b16 = g.b(b());
        this.f143707g = b16;
        return b16;
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public String getUri() {
        return this.f143703c.toString();
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public int readAt(long j3, byte[] bArr, int i3, int i16) {
        com.tencent.luggage.wxa.om.a aVar;
        int b16;
        if (i16 > this.f143712l.length) {
            this.f143712l = new byte[i16];
        }
        byte[] bArr2 = this.f143712l;
        int i17 = 0;
        Arrays.fill(bArr2, 0, bArr2.length, (byte) 0);
        try {
            if (!g.h(this.f143704d.toString()) && (aVar = this.f143701a) != null && (b16 = aVar.b(this.f143712l, (int) j3, i16)) > 0) {
                if (b16 != i16) {
                    Logger.i(f143694n, "read from cache, n%d, size %d " + b16 + "," + i16);
                }
                System.arraycopy(this.f143712l, 0, bArr, i3, b16);
                return b16;
            }
            long j16 = this.f143707g;
            if (j16 > 0 && j3 >= j16 && i16 > 0) {
                w.b(f143694n, "offset is illegal, mTotalSize:%d, offset:%d, size:%d", Long.valueOf(j16), Long.valueOf(j3), Integer.valueOf(i16));
                return 0;
            }
            Logger.d(f143694n, "read from network");
            if (j3 != this.f143702b) {
                a(j3);
            }
            int read = this.f143709i.read(this.f143712l, 0, i16);
            if (read != -1) {
                System.arraycopy(this.f143712l, 0, bArr, i3, read);
                i17 = read;
            }
            this.f143702b += i17;
            com.tencent.luggage.wxa.om.a aVar2 = this.f143701a;
            if (aVar2 != null) {
                aVar2.c(this.f143712l, (int) j3, i17);
            }
            return i17;
        } catch (NoRouteToHostException e16) {
            Logger.e(f143694n, "readAt " + j3 + " / " + i16 + " => " + e16);
            g.a(this.f143704d.toString(), com.tencent.luggage.wxa.sm.e.O);
            a();
            return -1010;
        } catch (ProtocolException e17) {
            Logger.e(f143694n, "readAt " + j3 + " / " + i16 + " => " + e17);
            g.a(this.f143704d.toString(), 750);
            a();
            return -1010;
        } catch (UnknownServiceException e18) {
            Logger.e(f143694n, "readAt " + j3 + " / " + i16 + " => " + e18);
            g.a(this.f143704d.toString(), com.tencent.luggage.wxa.sm.e.P);
            a();
            return -1010;
        } catch (IOException e19) {
            Logger.e(f143694n, "readAt " + j3 + " / " + i16 + " => -1 " + e19);
            g.a(this.f143704d.toString(), com.tencent.luggage.wxa.sm.e.Q);
            a();
            return -1;
        } catch (Exception e26) {
            Logger.e(f143694n, "unknown exception " + e26);
            Logger.e(f143694n, "readAt " + j3 + " / " + i16 + " => -1");
            g.a(this.f143704d.toString(), 754);
            a();
            return -1;
        }
    }

    private boolean a(String str, String str2) {
        if (!"android-allow-cross-domain-redirect".equalsIgnoreCase(str)) {
            return false;
        }
        boolean a16 = a(str2);
        this.f143710j = a16;
        this.f143711k = a16;
        return true;
    }

    private static final boolean a(URL url) {
        String host;
        if (url == null || (host = url.getHost()) == null) {
            return false;
        }
        try {
        } catch (IllegalArgumentException e16) {
            Logger.e(f143694n, "isLocalHost IllegalArgumentException:%s", "" + e16);
        }
        return host.equalsIgnoreCase("localhost");
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x020b, code lost:
    
        r17.f143703c = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(long j3) throws IOException {
        int i3;
        int i16;
        boolean z16;
        int lastIndexOf;
        c();
        try {
            URL url = this.f143703c;
            boolean a16 = a(url);
            int i17 = 0;
            i3 = 0;
            while (true) {
                if (a16) {
                    try {
                        this.f143706f = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
                    } catch (IOException e16) {
                        e = e16;
                        i16 = i3;
                        this.f143707g = -1L;
                        a();
                        Logger.e(f143694n, "seekTo exception:%s", "" + e + ", response:" + i16);
                        throw e;
                    }
                } else {
                    this.f143706f = (HttpURLConnection) url.openConnection();
                }
                this.f143706f.setConnectTimeout(30000);
                this.f143706f.setInstanceFollowRedirects(this.f143710j);
                Logger.d(f143694n, "mHeaders=" + this.f143705e);
                Map<String, String> map = this.f143705e;
                if (map != null) {
                    z16 = false;
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        this.f143706f.setRequestProperty(entry.getKey(), entry.getValue());
                        if (!z16 && "Accept-Encoding".equals(entry.getKey())) {
                            z16 = true;
                        }
                    }
                } else {
                    z16 = false;
                }
                if (j3 > 0) {
                    this.f143706f.setRequestProperty("Range", "bytes=" + j3 + "-");
                }
                if (!z16) {
                    this.f143706f.setRequestProperty("Accept-Encoding", "");
                }
                i16 = this.f143706f.getResponseCode();
                g.b(this.f143704d.toString(), i16);
                if (i16 != 300 && i16 != 301 && i16 != 302 && i16 != 303 && i16 != 307) {
                    if (this.f143710j) {
                        this.f143703c = this.f143706f.getURL();
                    }
                    if (i16 == 206) {
                        String headerField = this.f143706f.getHeaderField("Content-Range");
                        this.f143707g = -1L;
                        if (headerField != null && (lastIndexOf = headerField.lastIndexOf(47)) >= 0) {
                            String substring = headerField.substring(lastIndexOf + 1);
                            if (this.f143707g <= 0) {
                                try {
                                    this.f143707g = w0.a(substring, 0L);
                                } catch (NumberFormatException unused) {
                                }
                            }
                        }
                    } else {
                        if (i16 != 200) {
                            throw new IOException();
                        }
                        if (this.f143707g <= 0) {
                            this.f143707g = this.f143706f.getContentLength();
                        }
                    }
                    if (TextUtils.isEmpty(this.f143708h)) {
                        String contentType = this.f143706f.getContentType();
                        this.f143708h = contentType;
                        w.d(f143694n, "mimeType:", contentType);
                    }
                    if (j3 > 0 && i16 != 206) {
                        throw new ProtocolException();
                    }
                    this.f143709i = new BufferedInputStream(this.f143706f.getInputStream());
                    this.f143702b = j3;
                    return;
                }
                try {
                    i17++;
                    if (i17 <= 20) {
                        String requestMethod = this.f143706f.getRequestMethod();
                        if (i16 == 307 && !requestMethod.equals("GET") && !requestMethod.equals("HEAD")) {
                            throw new NoRouteToHostException("Invalid redirect");
                        }
                        String headerField2 = this.f143706f.getHeaderField("Location");
                        if (headerField2 != null) {
                            URL url2 = new URL(this.f143703c, headerField2);
                            if (!url2.getProtocol().equals("https") && !url2.getProtocol().equals("http")) {
                                throw new NoRouteToHostException("Unsupported protocol redirect");
                            }
                            boolean equals = this.f143703c.getProtocol().equals(url2.getProtocol());
                            if (!this.f143711k && !equals) {
                                throw new NoRouteToHostException("Cross-protocol redirects are disallowed");
                            }
                            boolean equals2 = this.f143703c.getHost().equals(url2.getHost());
                            if (!this.f143710j && !equals2) {
                                throw new NoRouteToHostException("Cross-domain redirects are disallowed");
                            }
                            i3 = i16;
                            url = url2;
                        } else {
                            throw new NoRouteToHostException("Invalid redirect");
                        }
                    } else {
                        throw new NoRouteToHostException("Too many redirects: " + i17);
                    }
                } catch (IOException e17) {
                    e = e17;
                    this.f143707g = -1L;
                    a();
                    Logger.e(f143694n, "seekTo exception:%s", "" + e + ", response:" + i16);
                    throw e;
                }
            }
        } catch (IOException e18) {
            e = e18;
            i3 = 0;
        }
    }

    private void a() {
        c();
    }
}
