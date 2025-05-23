package com.tencent.qqlive.superplayer.thirdparties.httpclient;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.qqlive.superplayer.thirdparties.httpclient.HttpDataSource;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
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
/* loaded from: classes22.dex */
public class f extends b implements HttpDataSource {

    /* renamed from: s, reason: collision with root package name */
    private static final Pattern f345437s = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: t, reason: collision with root package name */
    private static final AtomicReference<byte[]> f345438t = new AtomicReference<>();

    /* renamed from: e, reason: collision with root package name */
    private final boolean f345439e;

    /* renamed from: f, reason: collision with root package name */
    private final int f345440f;

    /* renamed from: g, reason: collision with root package name */
    private final int f345441g;

    /* renamed from: h, reason: collision with root package name */
    private final String f345442h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private final HttpDataSource.c f345443i;

    /* renamed from: j, reason: collision with root package name */
    private final HttpDataSource.c f345444j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private DataSpec f345445k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private HttpURLConnection f345446l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private InputStream f345447m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f345448n;

    /* renamed from: o, reason: collision with root package name */
    private long f345449o;

    /* renamed from: p, reason: collision with root package name */
    private long f345450p;

    /* renamed from: q, reason: collision with root package name */
    private long f345451q;

    /* renamed from: r, reason: collision with root package name */
    private long f345452r;

    public f(String str, @Nullable i<String> iVar, int i3, int i16, boolean z16, @Nullable HttpDataSource.c cVar) {
        super(true);
        this.f345442h = a.c(str);
        this.f345444j = new HttpDataSource.c();
        this.f345440f = i3;
        this.f345441g = i16;
        this.f345439e = z16;
        this.f345443i = cVar;
    }

    private void h() {
        HttpURLConnection httpURLConnection = this.f345446l;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e16) {
                com.tencent.qqlive.superplayer.tools.utils.d.c("DefaultHttpDataSource", e16, "Unexpected error while disconnecting");
            }
            this.f345446l = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long i(HttpURLConnection httpURLConnection) {
        long parseLong;
        String headerField;
        String headerField2 = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField2)) {
            try {
                parseLong = Long.parseLong(headerField2);
            } catch (NumberFormatException unused) {
                com.tencent.qqlive.superplayer.tools.utils.d.a("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField2 + "]");
            }
            headerField = httpURLConnection.getHeaderField("Content-Range");
            if (TextUtils.isEmpty(headerField)) {
                Matcher matcher = f345437s.matcher(headerField);
                if (matcher.find()) {
                    try {
                        long parseLong2 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                        if (parseLong < 0) {
                            return parseLong2;
                        }
                        if (parseLong != parseLong2) {
                            com.tencent.qqlive.superplayer.tools.utils.d.i("DefaultHttpDataSource", "Inconsistent headers [" + headerField2 + "] [" + headerField + "]");
                            return Math.max(parseLong, parseLong2);
                        }
                        return parseLong;
                    } catch (NumberFormatException unused2) {
                        com.tencent.qqlive.superplayer.tools.utils.d.a("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField + "]");
                        return parseLong;
                    }
                }
                return parseLong;
            }
            return parseLong;
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField)) {
        }
    }

    private static URL j(URL url, String str) throws IOException {
        if (str != null) {
            URL url2 = new URL(url, str);
            String protocol2 = url2.getProtocol();
            if (!"https".equals(protocol2) && !"http".equals(protocol2)) {
                throw new ProtocolException("Unsupported protocol redirect: " + protocol2);
            }
            return url2;
        }
        throw new ProtocolException("Null location redirect");
    }

    private HttpURLConnection k(DataSpec dataSpec) throws IOException {
        HttpURLConnection l3;
        URL j3;
        URL url = new URL(dataSpec.f345404a.toString());
        int i3 = dataSpec.f345405b;
        byte[] bArr = dataSpec.f345406c;
        long j16 = dataSpec.f345408e;
        long j17 = dataSpec.f345409f;
        boolean c16 = dataSpec.c(1);
        boolean c17 = dataSpec.c(2);
        if (!this.f345439e) {
            return l(url, i3, bArr, j16, j17, c16, c17, true);
        }
        int i16 = 0;
        while (true) {
            int i17 = i16 + 1;
            if (i16 <= 20) {
                long j18 = j17;
                long j19 = j16;
                l3 = l(url, i3, bArr, j16, j17, c16, c17, false);
                int responseCode = l3.getResponseCode();
                String headerField = l3.getHeaderField("Location");
                if ((i3 != 1 && i3 != 3) || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308)) {
                    if (i3 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                        break;
                    }
                    l3.disconnect();
                    j3 = j(url, headerField);
                    bArr = null;
                    i3 = 1;
                } else {
                    l3.disconnect();
                    j3 = j(url, headerField);
                }
                url = j3;
                i16 = i17;
                j17 = j18;
                j16 = j19;
            } else {
                throw new NoRouteToHostException("Too many redirects: " + i17);
            }
        }
        return l3;
    }

    private HttpURLConnection l(URL url, int i3, byte[] bArr, long j3, long j16, boolean z16, boolean z17, boolean z18) throws IOException {
        boolean z19;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f345440f);
        httpURLConnection.setReadTimeout(this.f345441g);
        HttpDataSource.c cVar = this.f345443i;
        if (cVar != null) {
            for (Map.Entry<String, String> entry : cVar.a().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.f345444j.a().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (j3 != 0 || j16 != -1) {
            String str = "bytes=" + j3 + "-";
            if (j16 != -1) {
                str = str + ((j3 + j16) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f345442h);
        if (!z16) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        if (z17) {
            httpURLConnection.setRequestProperty("Icy-MetaData", "1");
        }
        httpURLConnection.setInstanceFollowRedirects(z18);
        if (bArr != null) {
            z19 = true;
        } else {
            z19 = false;
        }
        httpURLConnection.setDoOutput(z19);
        httpURLConnection.setRequestMethod(DataSpec.b(i3));
        if (bArr != null) {
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    private int n(byte[] bArr, int i3, int i16) throws IOException {
        if (i16 == 0) {
            return 0;
        }
        long j3 = this.f345450p;
        if (j3 != -1) {
            long j16 = j3 - this.f345452r;
            if (j16 == 0) {
                return -1;
            }
            i16 = (int) Math.min(i16, j16);
        }
        int read = this.f345447m.read(bArr, i3, i16);
        if (read == -1) {
            if (this.f345450p == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.f345452r += read;
        c(read);
        return read;
    }

    private void o() throws IOException {
        if (this.f345451q == this.f345449o) {
            return;
        }
        byte[] andSet = f345438t.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j3 = this.f345451q;
            long j16 = this.f345449o;
            if (j3 != j16) {
                int read = this.f345447m.read(andSet, 0, (int) Math.min(j16 - j3, andSet.length));
                if (!Thread.currentThread().isInterrupted()) {
                    if (read != -1) {
                        this.f345451q += read;
                        c(read);
                    } else {
                        throw new EOFException();
                    }
                } else {
                    throw new InterruptedIOException();
                }
            } else {
                f345438t.set(andSet);
                return;
            }
        }
    }

    @Override // com.tencent.qqlive.superplayer.thirdparties.httpclient.d
    public long a(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        this.f345445k = dataSpec;
        long j3 = 0;
        this.f345452r = 0L;
        this.f345451q = 0L;
        e(dataSpec);
        try {
            HttpURLConnection k3 = k(dataSpec);
            this.f345446l = k3;
            try {
                int responseCode = k3.getResponseCode();
                String responseMessage = this.f345446l.getResponseMessage();
                if (responseCode >= 200 && responseCode <= 299) {
                    this.f345446l.getContentType();
                    if (responseCode == 200) {
                        long j16 = dataSpec.f345408e;
                        if (j16 != 0) {
                            j3 = j16;
                        }
                    }
                    this.f345449o = j3;
                    if (!dataSpec.c(1)) {
                        long j17 = dataSpec.f345409f;
                        long j18 = -1;
                        if (j17 != -1) {
                            this.f345450p = j17;
                        } else {
                            long i3 = i(this.f345446l);
                            if (i3 != -1) {
                                j18 = i3 - this.f345449o;
                            }
                            this.f345450p = j18;
                        }
                    } else {
                        this.f345450p = dataSpec.f345409f;
                    }
                    try {
                        this.f345447m = this.f345446l.getInputStream();
                        this.f345448n = true;
                        f(dataSpec);
                        return this.f345450p;
                    } catch (IOException e16) {
                        h();
                        throw new HttpDataSource.HttpDataSourceException(e16, dataSpec, 1);
                    }
                }
                Map<String, List<String>> headerFields = this.f345446l.getHeaderFields();
                h();
                HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new HttpDataSource.InvalidResponseCodeException(responseCode, responseMessage, headerFields, dataSpec);
                if (responseCode == 416) {
                    invalidResponseCodeException.initCause(new DataSourceException(0));
                    throw invalidResponseCodeException;
                }
                throw invalidResponseCodeException;
            } catch (IOException e17) {
                h();
                throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + dataSpec.f345404a.toString(), e17, dataSpec, 1);
            } catch (Exception unused) {
                h();
                throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + dataSpec.f345404a.toString(), dataSpec, 1);
            }
        } catch (IOException e18) {
            throw new HttpDataSource.HttpDataSourceException("Unable to connect to " + dataSpec.f345404a.toString(), e18, dataSpec, 1);
        }
    }

    @Override // com.tencent.qqlive.superplayer.thirdparties.httpclient.d
    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            if (this.f345447m != null) {
                m(this.f345446l, g());
                try {
                    this.f345447m.close();
                } catch (IOException e16) {
                    throw new HttpDataSource.HttpDataSourceException(e16, this.f345445k, 3);
                }
            }
        } finally {
            this.f345447m = null;
            h();
            if (this.f345448n) {
                this.f345448n = false;
                d();
            }
        }
    }

    protected final long g() {
        long j3 = this.f345450p;
        if (j3 != -1) {
            return j3 - this.f345452r;
        }
        return j3;
    }

    @Override // com.tencent.qqlive.superplayer.thirdparties.httpclient.HttpDataSource
    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.f345446l;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    @Override // com.tencent.qqlive.superplayer.thirdparties.httpclient.d
    public int read(byte[] bArr, int i3, int i16) throws HttpDataSource.HttpDataSourceException {
        try {
            o();
            return n(bArr, i3, i16);
        } catch (IOException e16) {
            throw new HttpDataSource.HttpDataSourceException(e16, this.f345445k, 2);
        }
    }

    @Override // com.tencent.qqlive.superplayer.thirdparties.httpclient.HttpDataSource
    public void setRequestProperty(String str, String str2) {
        a.d(str);
        a.d(str2);
        this.f345444j.b(str, str2);
    }

    private static void m(HttpURLConnection httpURLConnection, long j3) {
    }
}
