package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class j implements d<InputStream> {

    @VisibleForTesting
    static final b C = new a();

    /* renamed from: d, reason: collision with root package name */
    private final t.g f31583d;

    /* renamed from: e, reason: collision with root package name */
    private final int f31584e;

    /* renamed from: f, reason: collision with root package name */
    private final b f31585f;

    /* renamed from: h, reason: collision with root package name */
    private HttpURLConnection f31586h;

    /* renamed from: i, reason: collision with root package name */
    private InputStream f31587i;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f31588m;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.data.j.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public j(t.g gVar, int i3) {
        this(gVar, i3, C);
    }

    private HttpURLConnection c(URL url, Map<String, String> map) throws HttpException {
        try {
            HttpURLConnection a16 = this.f31585f.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                a16.addRequestProperty(entry.getKey(), entry.getValue());
            }
            a16.setConnectTimeout(this.f31584e);
            a16.setReadTimeout(this.f31584e);
            a16.setUseCaches(false);
            a16.setDoInput(true);
            a16.setInstanceFollowRedirects(false);
            return a16;
        } catch (IOException e16) {
            throw new HttpException("URL.openConnection threw", 0, e16);
        }
    }

    private static int d(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e16) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to get a response code", e16);
                return -1;
            }
            return -1;
        }
    }

    private InputStream e(HttpURLConnection httpURLConnection) throws HttpException {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.f31587i = h0.c.b(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.f31587i = httpURLConnection.getInputStream();
            }
            return this.f31587i;
        } catch (IOException e16) {
            throw new HttpException("Failed to obtain InputStream", d(httpURLConnection), e16);
        }
    }

    private static boolean f(int i3) {
        if (i3 / 100 == 2) {
            return true;
        }
        return false;
    }

    private static boolean g(int i3) {
        if (i3 / 100 == 3) {
            return true;
        }
        return false;
    }

    private InputStream h(URL url, int i3, URL url2, Map<String, String> map) throws HttpException {
        if (i3 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop", -1);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            HttpURLConnection c16 = c(url, map);
            this.f31586h = c16;
            try {
                c16.connect();
                this.f31587i = this.f31586h.getInputStream();
                if (this.f31588m) {
                    return null;
                }
                int d16 = d(this.f31586h);
                if (f(d16)) {
                    return e(this.f31586h);
                }
                if (g(d16)) {
                    String headerField = this.f31586h.getHeaderField("Location");
                    if (!TextUtils.isEmpty(headerField)) {
                        try {
                            URL url3 = new URL(url, headerField);
                            cleanup();
                            return h(url3, i3 + 1, url, map);
                        } catch (MalformedURLException e16) {
                            throw new HttpException("Bad redirect url: " + headerField, d16, e16);
                        }
                    }
                    throw new HttpException("Received empty or null redirect url", d16);
                }
                if (d16 == -1) {
                    throw new HttpException(d16);
                }
                try {
                    throw new HttpException(this.f31586h.getResponseMessage(), d16);
                } catch (IOException e17) {
                    throw new HttpException("Failed to get a response message", d16, e17);
                }
            } catch (IOException e18) {
                throw new HttpException("Failed to connect or obtain data", d(this.f31586h), e18);
            }
        }
        throw new HttpException("Too many (> 5) redirects!", -1);
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        StringBuilder sb5;
        long b16 = h0.f.b();
        try {
            try {
                aVar.d(h(this.f31583d.h(), 0, null, this.f31583d.e()));
            } catch (IOException e16) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e16);
                }
                aVar.c(e16);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    sb5 = new StringBuilder();
                } else {
                    return;
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb5 = new StringBuilder();
                sb5.append("Finished http url fetcher fetch in ");
                sb5.append(h0.f.a(b16));
                Log.v("HttpUrlFetcher", sb5.toString());
            }
        } catch (Throwable th5) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + h0.f.a(b16));
            }
            throw th5;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
        this.f31588m = true;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cleanup() {
        InputStream inputStream = this.f31587i;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f31586h;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f31586h = null;
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    @VisibleForTesting
    j(t.g gVar, int i3, b bVar) {
        this.f31583d = gVar;
        this.f31584e = i3;
        this.f31585f = bVar;
    }
}
