package com.tencent.luggage.wxa.l0;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.l0.q;
import com.tencent.luggage.wxa.n0.v;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n implements q {

    /* renamed from: p, reason: collision with root package name */
    public static final Pattern f132808p = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: q, reason: collision with root package name */
    public static final AtomicReference f132809q = new AtomicReference();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f132810a;

    /* renamed from: b, reason: collision with root package name */
    public final int f132811b;

    /* renamed from: c, reason: collision with root package name */
    public final int f132812c;

    /* renamed from: d, reason: collision with root package name */
    public final String f132813d;

    /* renamed from: e, reason: collision with root package name */
    public final q.e f132814e;

    /* renamed from: f, reason: collision with root package name */
    public final q.e f132815f = new q.e();

    /* renamed from: g, reason: collision with root package name */
    public final u f132816g;

    /* renamed from: h, reason: collision with root package name */
    public j f132817h;

    /* renamed from: i, reason: collision with root package name */
    public HttpURLConnection f132818i;

    /* renamed from: j, reason: collision with root package name */
    public InputStream f132819j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f132820k;

    /* renamed from: l, reason: collision with root package name */
    public long f132821l;

    /* renamed from: m, reason: collision with root package name */
    public long f132822m;

    /* renamed from: n, reason: collision with root package name */
    public long f132823n;

    /* renamed from: o, reason: collision with root package name */
    public long f132824o;

    public n(String str, com.tencent.luggage.wxa.n0.n nVar, u uVar, int i3, int i16, boolean z16, q.e eVar) {
        this.f132813d = com.tencent.luggage.wxa.n0.a.a(str);
        this.f132816g = uVar;
        this.f132811b = i3;
        this.f132812c = i16;
        this.f132810a = z16;
        this.f132814e = eVar;
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public long a(j jVar) {
        this.f132817h = jVar;
        long j3 = 0;
        this.f132824o = 0L;
        this.f132823n = 0L;
        try {
            HttpURLConnection b16 = b(jVar);
            this.f132818i = b16;
            try {
                int responseCode = b16.getResponseCode();
                com.tencent.luggage.wxa.y.a.b("DefaultHttpDataSource", "open, responseCode:%d", Integer.valueOf(responseCode));
                if (responseCode >= 200 && responseCode <= 299) {
                    this.f132818i.getContentType();
                    if (responseCode == 200) {
                        long j16 = jVar.f132785d;
                        if (j16 != 0) {
                            j3 = j16;
                        }
                    }
                    this.f132821l = j3;
                    if (!jVar.a(1)) {
                        long j17 = jVar.f132786e;
                        if (j17 != -1) {
                            this.f132822m = j17;
                        } else {
                            long a16 = a(this.f132818i);
                            this.f132822m = a16 != -1 ? a16 - this.f132821l : -1L;
                        }
                    } else {
                        this.f132822m = jVar.f132786e;
                    }
                    try {
                        this.f132819j = this.f132818i.getInputStream();
                        this.f132820k = true;
                        u uVar = this.f132816g;
                        if (uVar != null) {
                            uVar.a(this, jVar);
                        }
                        return this.f132822m;
                    } catch (IOException e16) {
                        b();
                        throw new q.c(e16, jVar, 1);
                    }
                }
                Map<String, List<String>> headerFields = this.f132818i.getHeaderFields();
                b();
                q.d dVar = new q.d(responseCode, headerFields, jVar);
                if (responseCode == 416) {
                    dVar.initCause(new h(0));
                    throw dVar;
                }
                throw dVar;
            } catch (IOException e17) {
                b();
                throw new q.c("Unable to connect to " + jVar.f132782a.toString(), e17, jVar, 1);
            }
        } catch (IOException e18) {
            throw new q.c("Unable to connect to " + jVar.f132782a.toString(), e18, jVar, 1);
        }
    }

    public final HttpURLConnection b(j jVar) {
        HttpURLConnection a16;
        URL url = new URL(jVar.f132782a.toString());
        byte[] bArr = jVar.f132783b;
        long j3 = jVar.f132785d;
        long j16 = jVar.f132786e;
        boolean a17 = jVar.a(1);
        if (!this.f132810a) {
            return a(url, bArr, j3, j16, a17, true);
        }
        int i3 = 0;
        while (true) {
            int i16 = i3 + 1;
            if (i3 <= 20) {
                long j17 = j3;
                a16 = a(url, bArr, j3, j16, a17, false);
                int responseCode = a16.getResponseCode();
                if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                    String headerField = a16.getHeaderField("Location");
                    a16.disconnect();
                    url = a(url, headerField);
                    bArr = null;
                    i3 = i16;
                    j3 = j17;
                }
            } else {
                throw new NoRouteToHostException("Too many redirects: " + i16);
            }
        }
        return a16;
    }

    public final HttpURLConnection c() {
        return this.f132818i;
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public void close() {
        try {
            if (this.f132819j != null) {
                a(this.f132818i, a());
                try {
                    this.f132819j.close();
                } catch (IOException e16) {
                    throw new q.c(e16, this.f132817h, 3);
                }
            }
        } finally {
            this.f132819j = null;
            b();
            if (this.f132820k) {
                this.f132820k = false;
                u uVar = this.f132816g;
                if (uVar != null) {
                    uVar.a(this);
                }
            }
        }
    }

    public final void d() {
        if (this.f132823n == this.f132821l) {
            return;
        }
        byte[] bArr = (byte[]) f132809q.getAndSet(null);
        if (bArr == null) {
            bArr = new byte[4096];
        }
        while (true) {
            long j3 = this.f132823n;
            long j16 = this.f132821l;
            if (j3 != j16) {
                int read = this.f132819j.read(bArr, 0, (int) Math.min(j16 - j3, bArr.length));
                if (!Thread.interrupted()) {
                    if (read != -1) {
                        this.f132823n += read;
                        u uVar = this.f132816g;
                        if (uVar != null) {
                            uVar.a(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                } else {
                    throw new InterruptedIOException();
                }
            } else {
                f132809q.set(bArr);
                return;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.f132818i;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.tencent.luggage.wxa.l0.g
    public int read(byte[] bArr, int i3, int i16) {
        try {
            d();
            return a(bArr, i3, i16);
        } catch (IOException e16) {
            throw new q.c(e16, this.f132817h, 2);
        }
    }

    public final void b() {
        HttpURLConnection httpURLConnection = this.f132818i;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.y.a.a("DefaultHttpDataSource", "Unexpected error while disconnecting", e16);
            }
            this.f132818i = null;
        }
    }

    public final long a() {
        long j3 = this.f132822m;
        return j3 == -1 ? j3 : j3 - this.f132824o;
    }

    public final HttpURLConnection a(URL url, byte[] bArr, long j3, long j16, boolean z16, boolean z17) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f132811b);
        httpURLConnection.setReadTimeout(this.f132812c);
        q.e eVar = this.f132814e;
        if (eVar != null) {
            for (Map.Entry entry : eVar.a().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        for (Map.Entry entry2 : this.f132815f.a().entrySet()) {
            httpURLConnection.setRequestProperty((String) entry2.getKey(), (String) entry2.getValue());
        }
        if (j3 != 0 || j16 != -1) {
            String str = "bytes=" + j3 + "-";
            if (j16 != -1) {
                str = str + ((j3 + j16) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f132813d);
        if (!z16) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z17);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length == 0) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    public static URL a(URL url, String str) {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol2 = url2.getProtocol();
            if ("https".equals(protocol2) || "http".equals(protocol2)) {
                return url2;
            }
            throw new ProtocolException("Unsupported protocol redirect: " + protocol2);
        }
        throw new ProtocolException("Null location redirect");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(HttpURLConnection httpURLConnection) {
        long parseLong;
        String headerField;
        String headerField2 = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField2)) {
            try {
                parseLong = Long.parseLong(headerField2);
            } catch (NumberFormatException unused) {
                com.tencent.luggage.wxa.y.a.a("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField2 + "]", new Object[0]);
            }
            headerField = httpURLConnection.getHeaderField("Content-Range");
            if (!TextUtils.isEmpty(headerField)) {
                return parseLong;
            }
            Matcher matcher = f132808p.matcher(headerField);
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
                com.tencent.luggage.wxa.y.a.c("DefaultHttpDataSource", "Inconsistent headers [" + headerField2 + "] [" + headerField + "]", new Object[0]);
                return Math.max(parseLong, parseLong2);
            } catch (NumberFormatException unused2) {
                com.tencent.luggage.wxa.y.a.a("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField + "]", new Object[0]);
                return parseLong;
            }
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
        }
    }

    public final int a(byte[] bArr, int i3, int i16) {
        if (i16 == 0) {
            return 0;
        }
        long j3 = this.f132822m;
        if (j3 != -1) {
            long j16 = j3 - this.f132824o;
            if (j16 == 0) {
                return -1;
            }
            i16 = (int) Math.min(i16, j16);
        }
        int read = this.f132819j.read(bArr, i3, i16);
        if (read == -1) {
            if (this.f132822m == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.f132824o += read;
        u uVar = this.f132816g;
        if (uVar != null) {
            uVar.a(this, read);
        }
        return read;
    }

    public static void a(HttpURLConnection httpURLConnection, long j3) {
        int i3 = v.f135103a;
        if (i3 == 19 || i3 == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j3 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j3 <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }
}
