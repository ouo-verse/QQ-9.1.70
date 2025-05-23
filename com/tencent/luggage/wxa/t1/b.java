package com.tencent.luggage.wxa.t1;

import android.text.TextUtils;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.wxa.i.d;
import com.tencent.luggage.wxa.t1.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;
import java.io.BufferedInputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends d {

    /* renamed from: a, reason: collision with root package name */
    public int f140830a;

    /* renamed from: b, reason: collision with root package name */
    public int f140831b;

    /* renamed from: c, reason: collision with root package name */
    public final String f140832c;

    /* renamed from: d, reason: collision with root package name */
    public d.c f140833d;

    public b(d.c cVar) {
        super(cVar);
        this.f140830a = 60000;
        this.f140831b = 60000;
        this.f140833d = cVar;
        a(cVar.a(), cVar.d());
        this.f140832c = cVar.getUserAgentString();
    }

    @Override // com.tencent.luggage.wxa.i.d
    public String a() {
        return "http";
    }

    @Override // com.tencent.luggage.wxa.i.d
    public boolean accept(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String str = (String) obj;
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.i.d
    public d.a a(Object obj, ImageDecodeConfig imageDecodeConfig) {
        BufferedInputStream bufferedInputStream;
        HttpURLConnection a16;
        d.a aVar = new d.a();
        try {
            a16 = a((String) obj, this.f140833d.a(imageDecodeConfig.mReferrerPolicy), imageDecodeConfig, aVar);
        } catch (SocketTimeoutException e16) {
            w.b("AppBrandImageHttpFetcher", "ImageFetch Timeout! path[%s] connectionTimeout[%d] readTimeout[%d] error[%s]", obj, Integer.valueOf(this.f140830a), Integer.valueOf(this.f140831b), e16.toString());
            aVar.f129190b = z.c().getString(R.string.z3_);
        } catch (Exception e17) {
            w.b("AppBrandImageHttpFetcher", "fetch error. path = [%s], error = [%s]", obj, e17.toString());
            aVar.f129190b = String.format(z.c().getString(R.string.z38), e17.toString());
        }
        if (a16 != null && TextUtils.isEmpty(aVar.f129190b)) {
            bufferedInputStream = new BufferedInputStream(a16.getInputStream());
            aVar.f129189a = bufferedInputStream;
            return aVar;
        }
        bufferedInputStream = null;
        aVar.f129189a = bufferedInputStream;
        return aVar;
    }

    public final HttpURLConnection a(String str, String str2, ImageDecodeConfig imageDecodeConfig, d.a aVar) {
        int i3 = 0;
        while (true) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (imageDecodeConfig != null && !TextUtils.isEmpty(str2)) {
                httpURLConnection.addRequestProperty("Referer", str2);
            }
            httpURLConnection.setRequestProperty("User-Agent", this.f140832c);
            httpURLConnection.setReadTimeout(this.f140831b);
            httpURLConnection.setConnectTimeout(this.f140830a);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 301 && responseCode != 302) {
                if (responseCode < 200 || responseCode >= 300) {
                    aVar.f129190b = String.format(z.c().getString(R.string.z37), Integer.valueOf(responseCode));
                }
                return httpURLConnection;
            }
            String headerField = httpURLConnection.getHeaderField("location");
            w.d("AppBrandImageHttpFetcher", "redirect from[%s] to[%s]", str, headerField);
            httpURLConnection.disconnect();
            if (headerField == null) {
                return null;
            }
            int i16 = i3 + 1;
            if (i3 >= 3) {
                w.b("AppBrandImageHttpFetcher", "too much redirection!");
                aVar.f129190b = z.c().getString(R.string.z39);
                return null;
            }
            i3 = i16;
            str = headerField;
        }
    }

    public void a(int i3, int i16) {
        if (i3 <= 0 || i16 <= 0) {
            return;
        }
        this.f140830a = i3;
        this.f140831b = i16;
        w.d("AppBrandImageHttpFetcher", "Http Timeout Set: connection[%d] read[%d]", Integer.valueOf(i3), Integer.valueOf(i16));
    }
}
