package com.tencent.luggage.wxa.qg;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.tencent.luggage.wxa.qg.l;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j implements l {

    /* renamed from: v, reason: collision with root package name */
    public static final Pattern f138727v = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: w, reason: collision with root package name */
    public static final AtomicReference f138728w = new AtomicReference();

    /* renamed from: a, reason: collision with root package name */
    public String f138729a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f138730b;

    /* renamed from: c, reason: collision with root package name */
    public final int f138731c;

    /* renamed from: d, reason: collision with root package name */
    public final int f138732d;

    /* renamed from: e, reason: collision with root package name */
    public final String f138733e;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.luggage.wxa.tg.i f138734f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f138735g;

    /* renamed from: h, reason: collision with root package name */
    public final s f138736h;

    /* renamed from: i, reason: collision with root package name */
    public final com.tencent.luggage.wxa.tg.e f138737i;

    /* renamed from: j, reason: collision with root package name */
    public g f138738j;

    /* renamed from: k, reason: collision with root package name */
    public HttpURLConnection f138739k;

    /* renamed from: l, reason: collision with root package name */
    public InputStream f138740l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f138741m;

    /* renamed from: n, reason: collision with root package name */
    public long f138742n;

    /* renamed from: o, reason: collision with root package name */
    public long f138743o;

    /* renamed from: p, reason: collision with root package name */
    public long f138744p;

    /* renamed from: q, reason: collision with root package name */
    public long f138745q;

    /* renamed from: r, reason: collision with root package name */
    public long f138746r;

    /* renamed from: s, reason: collision with root package name */
    public String f138747s;

    /* renamed from: t, reason: collision with root package name */
    public long f138748t;

    /* renamed from: u, reason: collision with root package name */
    public String f138749u;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements Callable {

        /* renamed from: a, reason: collision with root package name */
        public HttpURLConnection f138750a;

        public a(HttpURLConnection httpURLConnection) {
            this.f138750a = httpURLConnection;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call() {
            return Integer.valueOf(this.f138750a.getResponseCode());
        }
    }

    public j(String str, com.tencent.luggage.wxa.tg.i iVar, com.tencent.luggage.wxa.tg.e eVar) {
        this(str, iVar, null, eVar);
    }

    @Override // com.tencent.luggage.wxa.qg.l
    public Map a() {
        HttpURLConnection httpURLConnection = this.f138739k;
        Map<String, List<String>> headerFields = httpURLConnection == null ? null : httpURLConnection.getHeaderFields();
        com.tencent.luggage.wxa.tg.e eVar = this.f138737i;
        return eVar != null ? (Map) eVar.a(headerFields) : headerFields;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long available() {
        return this.f138746r;
    }

    public final HttpURLConnection b(g gVar) {
        ArrayList arrayList;
        URL url = new URL(gVar.f138703a.toString());
        long j3 = gVar.f138705c;
        long j16 = gVar.f138706d;
        boolean z16 = true;
        boolean z17 = (gVar.f138708f & 1) != 0;
        if (!this.f138730b) {
            return a(url, j3, j16, z17);
        }
        url.toExternalForm();
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList2 = new ArrayList();
        URL url2 = url;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            int i17 = i3 + 1;
            if (i3 <= 20) {
                URL url3 = url2;
                int i18 = i16;
                ArrayList arrayList3 = arrayList2;
                HttpURLConnection a16 = a(url2, j3, j16, z17);
                a16.setInstanceFollowRedirects(false);
                a16.connect();
                try {
                    Object a17 = com.tencent.luggage.wxa.tg.m.a(new a(a16), this.f138732d, z16, "GetResponseCodeCallable", i());
                    if (a17 != null) {
                        int intValue = ((Integer) a17).intValue();
                        if (intValue != 300 && intValue != 301 && intValue != 302 && intValue != 303 && intValue != 307 && intValue != 308) {
                            if (i18 > 0 && com.tencent.luggage.wxa.og.a.a().m() != null) {
                                com.tencent.luggage.wxa.og.a.a().m().a(gVar.f138709g, com.tencent.luggage.wxa.tg.h.a((List) arrayList3), System.currentTimeMillis() - currentTimeMillis, i18);
                            }
                            return a16;
                        }
                        i16 = i18 + 1;
                        String headerField = a16.getHeaderField("Location");
                        try {
                            arrayList = arrayList3;
                            try {
                                arrayList.add(new URL(headerField).getHost());
                            } catch (MalformedURLException unused) {
                                com.tencent.luggage.wxa.tg.h.a(5, i(), "MalformedURLException url=" + headerField);
                                a16.disconnect();
                                URL a18 = a(url3, headerField);
                                com.tencent.luggage.wxa.tg.h.a(2, i(), "redirect to url=" + a18.toString() + ", fromUrl=" + url3);
                                arrayList2 = arrayList;
                                z16 = true;
                                url2 = a18;
                                i3 = i17;
                            }
                        } catch (MalformedURLException unused2) {
                            arrayList = arrayList3;
                        }
                        a16.disconnect();
                        URL a182 = a(url3, headerField);
                        com.tencent.luggage.wxa.tg.h.a(2, i(), "redirect to url=" + a182.toString() + ", fromUrl=" + url3);
                        arrayList2 = arrayList;
                        z16 = true;
                        url2 = a182;
                        i3 = i17;
                    } else {
                        f();
                        throw new l.h("getResponseCode TimeoutException Unable to connect to " + gVar.f138703a.toString() + " within " + this.f138732d, new IOException("getResponseCode Timeout " + this.f138732d), gVar);
                    }
                } catch (InterruptedException unused3) {
                    Thread.currentThread().interrupt();
                    com.tencent.luggage.wxa.tg.h.a(4, i(), "GetResponseCodeCallable Interrupted");
                    throw new l.b("GetResponseCodeCallable interrupted", h());
                } catch (ExecutionException e16) {
                    com.tencent.luggage.wxa.tg.h.a(5, i(), "GetResponseCodeCallable ExecutionException " + com.tencent.luggage.wxa.tg.h.a((Throwable) e16));
                    throw new l.b("Failed To Execute GetResponseCodeCallable", h());
                }
            } else {
                throw new NoRouteToHostException("Too many redirects: " + i17);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long c() {
        return this.f138748t;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public void close() {
        try {
            if (this.f138740l != null) {
                com.tencent.luggage.wxa.tg.h.a(this.f138739k, e());
                try {
                    this.f138740l.close();
                    this.f138740l = null;
                } catch (IOException e16) {
                    throw new l.a(e16, this.f138738j);
                }
            }
        } finally {
            if (this.f138741m) {
                this.f138741m = false;
                s sVar = this.f138736h;
                if (sVar != null) {
                    sVar.onTransferEnd();
                }
            }
            f();
        }
    }

    public final long d() {
        return this.f138745q;
    }

    public final long e() {
        long j3 = this.f138743o;
        if (j3 != -1) {
            return j3 - this.f138745q;
        }
        return j3;
    }

    public final void f() {
        HttpURLConnection httpURLConnection = this.f138739k;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.f138739k = null;
        }
    }

    public String g() {
        return this.f138747s;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public com.tencent.luggage.wxa.rg.b getFileType() {
        return com.tencent.luggage.wxa.rg.b.d(g());
    }

    @Override // com.tencent.luggage.wxa.qg.t
    public String getUri() {
        HttpURLConnection httpURLConnection = this.f138739k;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getURL().toString();
    }

    public g h() {
        return this.f138738j;
    }

    public String i() {
        return this.f138749u + this.f138729a;
    }

    public final void j() {
        if (this.f138744p == this.f138742n) {
            return;
        }
        byte[] bArr = (byte[]) f138728w.getAndSet(null);
        if (bArr == null) {
            bArr = new byte[4096];
        }
        Log.d(i(), "bytes skipped " + this.f138744p + ", bytesToSkip " + this.f138742n);
        while (true) {
            long j3 = this.f138744p;
            long j16 = this.f138742n;
            if (j3 != j16) {
                int min = (int) Math.min(j16 - j3, bArr.length);
                Log.d(i(), "request skip " + min + " bytes");
                int read = this.f138740l.read(bArr, 0, min);
                Log.d(i(), "actual skip " + read + " bytes");
                if (!Thread.interrupted()) {
                    if (read != -1) {
                        this.f138744p += read;
                        s sVar = this.f138736h;
                        if (sVar != null) {
                            sVar.a(read);
                        }
                    } else {
                        throw new EOFException();
                    }
                } else {
                    throw new l.c("skipInternal interrupted", h());
                }
            } else {
                f138728w.set(bArr);
                return;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public int read(byte[] bArr, int i3, int i16) {
        try {
            j();
            return a(bArr, i3, i16);
        } catch (IOException e16) {
            throw new l.a(e16, this.f138738j);
        }
    }

    public j(String str, com.tencent.luggage.wxa.tg.i iVar, s sVar, com.tencent.luggage.wxa.tg.e eVar) {
        this(str, iVar, sVar, 30000, 12000, eVar);
    }

    public j(String str, com.tencent.luggage.wxa.tg.i iVar, s sVar, int i3, int i16, com.tencent.luggage.wxa.tg.e eVar) {
        this(str, iVar, sVar, i3, i16, false, eVar);
    }

    public j(String str, com.tencent.luggage.wxa.tg.i iVar, s sVar, int i3, int i16, boolean z16, com.tencent.luggage.wxa.tg.e eVar) {
        this.f138729a = "DefaultHttpDataSource";
        this.f138746r = -1L;
        this.f138748t = -1L;
        this.f138749u = "";
        this.f138733e = com.tencent.luggage.wxa.tg.a.a(str);
        this.f138734f = iVar;
        this.f138736h = sVar;
        this.f138735g = new HashMap();
        this.f138731c = i3;
        this.f138732d = i16;
        this.f138730b = z16;
        this.f138737i = eVar;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public long a(g gVar) {
        return a(gVar, (String) null);
    }

    public long a(g gVar, String str) {
        this.f138738j = gVar;
        long j3 = 0;
        this.f138745q = 0L;
        this.f138744p = 0L;
        try {
            HttpURLConnection b16 = b(gVar);
            this.f138739k = b16;
            if (str != null) {
                b16.setRequestMethod(str);
            }
            try {
                int responseCode = this.f138739k.getResponseCode();
                com.tencent.luggage.wxa.tg.h.a(4, i(), com.tencent.luggage.wxa.tg.h.c("uri=" + gVar.toString() + ", response header: \r\n" + com.tencent.luggage.wxa.tg.f.a(this.f138739k.getHeaderFields()), null));
                if (responseCode >= 200 && responseCode <= 299) {
                    String contentType = this.f138739k.getContentType();
                    Map<String, List<String>> headerFields = this.f138739k.getHeaderFields();
                    com.tencent.luggage.wxa.tg.i iVar = this.f138734f;
                    if (iVar != null && !iVar.a(contentType)) {
                        f();
                        throw new l.e(contentType, headerFields, gVar);
                    }
                    this.f138747s = contentType;
                    com.tencent.luggage.wxa.tg.e eVar = this.f138737i;
                    if (eVar != null) {
                        this.f138747s = ((com.tencent.luggage.wxa.tg.d) eVar).a(contentType);
                    }
                    if (responseCode == 200) {
                        long j16 = gVar.f138705c;
                        if (j16 != 0) {
                            j3 = j16;
                        }
                    }
                    this.f138742n = j3;
                    long j17 = -1;
                    if ((gVar.f138708f & 1) == 0) {
                        this.f138746r = a(this.f138739k, i());
                        this.f138748t = b(this.f138739k, i());
                        long j18 = gVar.f138706d;
                        if (j18 != -1) {
                            j17 = j18;
                        } else {
                            long j19 = this.f138746r;
                            if (j19 != -1) {
                                j17 = j19 - this.f138742n;
                            }
                        }
                        this.f138743o = j17;
                    } else {
                        long j26 = gVar.f138706d;
                        this.f138743o = j26;
                        this.f138746r = j26;
                        this.f138748t = -1L;
                    }
                    try {
                        this.f138740l = this.f138739k.getInputStream();
                        this.f138741m = true;
                        s sVar = this.f138736h;
                        if (sVar != null) {
                            sVar.onTransferStart();
                        }
                        return this.f138743o;
                    } catch (IOException e16) {
                        f();
                        throw new l.a(e16, gVar);
                    }
                }
                Map<String, List<String>> headerFields2 = this.f138739k.getHeaderFields();
                f();
                throw new l.f(responseCode, headerFields2, gVar);
            } catch (SocketTimeoutException e17) {
                f();
                throw new l.h("getResponseCode SocketTimeoutException Unable to connect to " + gVar.f138703a.toString(), e17, gVar);
            } catch (InterruptedIOException e18) {
                f();
                throw new l.b("getResponseCode InterruptedIOException Interrupt connection to " + gVar.f138703a.toString(), e18, gVar);
            } catch (IOException e19) {
                f();
                throw new l.h("getResponseCode IOException Unable to connect to " + gVar.f138703a.toString(), e19, gVar);
            } catch (ArrayIndexOutOfBoundsException e26) {
                f();
                com.tencent.luggage.wxa.tg.h.a(6, i(), com.tencent.luggage.wxa.tg.h.a((Throwable) e26));
                throw new l.g("getResponseCode Got malformed response when connect to " + gVar.f138703a.toString(), gVar);
            }
        } catch (InterruptedIOException e27) {
            throw new l.b("makeConnection InterruptedIOException Interrupt connection to " + gVar.f138703a.toString(), e27, gVar);
        } catch (IOException e28) {
            throw new l.h("makeConnection IOException Unable to connect to " + gVar.f138703a.toString(), e28, gVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long b(HttpURLConnection httpURLConnection, String str) {
        long parseLong;
        String headerField;
        String headerField2 = httpURLConnection.getHeaderField("Content-Length");
        long j3 = -1;
        if (!TextUtils.isEmpty(headerField2)) {
            try {
                parseLong = Long.parseLong(headerField2);
            } catch (NumberFormatException unused) {
                com.tencent.luggage.wxa.tg.h.a(6, str, "Unexpected Content-Length [" + headerField2 + "]");
            }
            headerField = httpURLConnection.getHeaderField("Content-Range");
            if (!TextUtils.isEmpty(headerField)) {
                return parseLong;
            }
            Matcher matcher = f138727v.matcher(headerField);
            if (matcher.find()) {
                try {
                    long parseLong2 = Long.parseLong(matcher.group(3));
                    if (parseLong < 0) {
                        j3 = parseLong2;
                    } else if (parseLong != -1) {
                        j3 = Math.max(parseLong, parseLong2);
                    }
                } catch (NumberFormatException unused2) {
                    com.tencent.luggage.wxa.tg.h.a(6, str, "Unexpected Content-Range [" + headerField + "]");
                }
            }
            return j3;
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
        }
    }

    @Override // com.tencent.luggage.wxa.qg.l
    public com.tencent.luggage.wxa.tg.i b() {
        return this.f138734f;
    }

    public final HttpURLConnection a(URL url, long j3, long j16, boolean z16) {
        HttpURLConnection httpURLConnection;
        if (com.tencent.luggage.wxa.tg.h.a(url)) {
            httpURLConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(this.f138731c);
        httpURLConnection.setReadTimeout(this.f138732d);
        httpURLConnection.setDoOutput(false);
        if ((httpURLConnection instanceof HttpsURLConnection) && !com.tencent.luggage.wxa.og.a.a().s()) {
            com.tencent.luggage.wxa.tg.k.a((HttpsURLConnection) httpURLConnection);
        }
        synchronized (this.f138735g) {
            for (Map.Entry entry : this.f138735g.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (j3 != 0 || j16 != -1) {
            String str = "bytes=" + j3 + "-";
            if (j16 != -1) {
                str = str + ((j3 + j16) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f138733e);
        if (!z16) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        com.tencent.luggage.wxa.tg.h.a(4, i(), com.tencent.luggage.wxa.tg.h.c("send upstream request: \r\n" + httpURLConnection.getRequestMethod() + " " + url + "\r\n" + com.tencent.luggage.wxa.tg.f.a(httpURLConnection.getRequestProperties()), null));
        return httpURLConnection;
    }

    public static URL a(URL url, String str) {
        URL url2;
        if (str != null) {
            if (URLUtil.isNetworkUrl(str)) {
                url2 = new URL(str);
            } else {
                url2 = new URL(url, str);
            }
            String protocol2 = url2.getProtocol();
            if ("https".equals(protocol2) || "http".equals(protocol2)) {
                return url2;
            }
            throw new ProtocolException("Unsupported protocol redirect: " + protocol2);
        }
        throw new ProtocolException("Null location redirect");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(HttpURLConnection httpURLConnection, String str) {
        long parseLong;
        String headerField;
        String headerField2 = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField2)) {
            try {
                parseLong = Long.parseLong(headerField2);
            } catch (NumberFormatException unused) {
                com.tencent.luggage.wxa.tg.h.a(6, str, "Unexpected Content-Length [" + headerField2 + "]");
            }
            headerField = httpURLConnection.getHeaderField("Content-Range");
            if (!TextUtils.isEmpty(headerField)) {
                return parseLong;
            }
            Matcher matcher = f138727v.matcher(headerField);
            if (!matcher.find()) {
                return parseLong;
            }
            try {
                long parseLong2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                if (parseLong < 0) {
                    return parseLong2;
                }
                if (parseLong == parseLong2) {
                    return parseLong;
                }
                com.tencent.luggage.wxa.tg.h.a(5, str, "Inconsistent headers [" + headerField2 + "] [" + headerField + "]");
                return Math.max(parseLong, parseLong2);
            } catch (NumberFormatException unused2) {
                com.tencent.luggage.wxa.tg.h.a(6, str, "Unexpected Content-Range [" + headerField + "]");
                return parseLong;
            }
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
        }
    }

    public final int a(byte[] bArr, int i3, int i16) {
        long j3 = this.f138743o;
        if (j3 != -1) {
            i16 = (int) Math.min(i16, j3 - this.f138745q);
        }
        if (i16 == 0) {
            return -1;
        }
        int read = this.f138740l.read(bArr, i3, i16);
        if (read == -1) {
            long j16 = this.f138743o;
            if (j16 == -1 || j16 == this.f138745q) {
                return -1;
            }
            throw new EOFException();
        }
        this.f138745q += read;
        s sVar = this.f138736h;
        if (sVar != null) {
            sVar.a(read);
        }
        return read;
    }

    @Override // com.tencent.luggage.wxa.qg.e
    public void a(String str) {
        this.f138749u = str;
    }
}
