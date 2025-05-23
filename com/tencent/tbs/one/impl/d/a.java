package com.tencent.tbs.one.impl.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tbs.one.impl.a.b;
import com.tencent.tbs.one.impl.a.d;
import com.tencent.tbs.one.impl.a.e;
import com.tencent.tbs.one.impl.a.g;
import com.tencent.tbs.one.impl.a.o;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class a extends b<Integer> {

    /* renamed from: b, reason: collision with root package name */
    String f374885b;

    /* renamed from: c, reason: collision with root package name */
    String f374886c;

    /* renamed from: d, reason: collision with root package name */
    Map<String, String> f374887d;

    /* renamed from: e, reason: collision with root package name */
    byte[] f374888e;

    /* renamed from: f, reason: collision with root package name */
    public InterfaceC9892a f374889f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f374890g;

    /* renamed from: h, reason: collision with root package name */
    private Context f374891h;

    /* renamed from: i, reason: collision with root package name */
    private int f374892i;

    /* renamed from: j, reason: collision with root package name */
    private int f374893j;

    /* compiled from: P */
    /* renamed from: com.tencent.tbs.one.impl.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public interface InterfaceC9892a {
        void a(int i3, Map<String, List<String>> map, InputStream inputStream);
    }

    public a(Context context, String str) {
        this(context, str, "GET");
    }

    private boolean b(final String str) {
        int i3 = this.f374892i + 1;
        this.f374892i = i3;
        if (i3 > 3) {
            return false;
        }
        o.f(new Runnable() { // from class: com.tencent.tbs.one.impl.d.a.3
            @Override // java.lang.Runnable
            public final void run() {
                a aVar = a.this;
                a.a(aVar, str, aVar.f374886c, aVar.f374887d, aVar.f374888e);
            }
        });
        return true;
    }

    private boolean c() {
        if (this.f374550a) {
            a(104, "Aborted", null);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.b
    public final void a() {
        o.f(new Runnable() { // from class: com.tencent.tbs.one.impl.d.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a aVar = a.this;
                a.a(aVar, aVar.f374885b, aVar.f374886c, aVar.f374887d, aVar.f374888e);
            }
        });
    }

    a(Context context, String str, String str2) {
        this(context, str, str2, (byte) 0);
    }

    private HttpURLConnection a(String str) {
        a(5);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.setRequestProperty("Connection", "close");
            return httpURLConnection;
        } catch (MalformedURLException e16) {
            a(202, "Failed to parse url " + str, e16);
            return null;
        } catch (IOException e17) {
            a(203, "Failed to open connection, url: " + str, e17);
            return null;
        }
    }

    a(Context context, String str, String str2, byte b16) {
        this(context, str, str2, null, null);
    }

    public a(Context context, String str, String str2, Map<String, String> map, byte[] bArr) {
        this.f374891h = context;
        this.f374885b = str;
        this.f374886c = str2;
        this.f374887d = map;
        this.f374888e = bArr;
    }

    private boolean a(HttpURLConnection httpURLConnection, String str, String str2, Map<String, String> map, byte[] bArr) {
        a(10);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        OutputStream outputStream = null;
        try {
            try {
                httpURLConnection.setRequestMethod(str2);
                if (str2.equals("POST") && bArr != null) {
                    outputStream = httpURLConnection.getOutputStream();
                    if (map != null) {
                        String str3 = map.get("Content-Encoding");
                        if (!TextUtils.isEmpty(str3) && str3.equals("gzip")) {
                            outputStream = new GZIPOutputStream(new BufferedOutputStream(outputStream, 204800));
                        }
                    }
                    outputStream.write(bArr);
                    outputStream.flush();
                }
                d.a(outputStream);
                return true;
            } catch (ProtocolException e16) {
                a(204, "Failed to parse http method " + str2 + ", url: " + str, e16);
                d.a(outputStream);
                return false;
            } catch (Exception e17) {
                if (!b(str)) {
                    a(205, "Failed to send request, url: " + str, e17);
                }
                d.a(outputStream);
                return false;
            }
        } catch (Throwable th5) {
            d.a(outputStream);
            throw th5;
        }
    }

    static /* synthetic */ void a(a aVar, String str, String str2, Map map, byte[] bArr) {
        InputStream inflaterInputStream;
        InputStream inputStream = null;
        if (aVar.f374890g && !e.g(aVar.f374891h)) {
            aVar.a(201, "Network unavailable, current network is not wifi", null);
            return;
        }
        HttpURLConnection a16 = aVar.a(str);
        if (a16 != null) {
            if (aVar.c() && aVar.a(a16, str, str2, (Map<String, String>) map, bArr) && aVar.c()) {
                aVar.a(50);
                try {
                    int responseCode = a16.getResponseCode();
                    Map<String, List<String>> headerFields = a16.getHeaderFields();
                    if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303) {
                        if (responseCode < 400) {
                            try {
                                inputStream = a16.getInputStream();
                                if (inputStream != null) {
                                    String contentEncoding = a16.getContentEncoding();
                                    if (contentEncoding != null && contentEncoding.equalsIgnoreCase("gzip")) {
                                        inflaterInputStream = new GZIPInputStream(inputStream);
                                    } else if (contentEncoding != null && contentEncoding.equalsIgnoreCase("deflate")) {
                                        inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(true));
                                    }
                                    inputStream = inflaterInputStream;
                                } else {
                                    g.a("No response stream from %s, statusCode: %d", str, Integer.valueOf(responseCode));
                                }
                            } catch (IOException e16) {
                                d.a((Closeable) null);
                                aVar.a(208, "Failed to read response data, url: " + str + ", statusCode: " + responseCode, e16);
                            }
                        }
                        InterfaceC9892a interfaceC9892a = aVar.f374889f;
                        if (interfaceC9892a != null) {
                            interfaceC9892a.a(responseCode, headerFields, inputStream);
                        }
                        d.a(inputStream);
                        aVar.a((a) Integer.valueOf(responseCode));
                    } else {
                        final String headerField = a16.getHeaderField("Location");
                        int i3 = aVar.f374893j + 1;
                        aVar.f374893j = i3;
                        if (i3 > 5) {
                            aVar.a(207, "Too many redirects, url: " + str + ", statusCode: " + responseCode + ", location: " + headerField, null);
                        } else {
                            g.a("Redirecting from %s to %s", str, headerField);
                            o.f(new Runnable() { // from class: com.tencent.tbs.one.impl.d.a.2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    a aVar2 = a.this;
                                    a.a(aVar2, headerField, aVar2.f374886c, aVar2.f374887d, aVar2.f374888e);
                                }
                            });
                        }
                    }
                } catch (Exception e17) {
                    if (!aVar.b(str)) {
                        aVar.a(206, "Failed to read response code, url: " + str, e17);
                    }
                }
            }
            a16.disconnect();
        }
    }
}
