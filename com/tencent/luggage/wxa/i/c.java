package com.tencent.luggage.wxa.i;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.wxa.i.d;
import java.io.BufferedInputStream;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements d {

    /* renamed from: c, reason: collision with root package name */
    private static final String f129185c = "NativeImageHttpFetcher";

    /* renamed from: d, reason: collision with root package name */
    private static final int f129186d = 60000;

    /* renamed from: a, reason: collision with root package name */
    private int f129187a = 60000;

    /* renamed from: b, reason: collision with root package name */
    private int f129188b = 60000;

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
        d.a aVar = new d.a();
        try {
            URLConnection openConnection = new URL((String) obj).openConnection();
            openConnection.setReadTimeout(this.f129188b);
            openConnection.setConnectTimeout(this.f129187a);
            aVar.f129189a = new BufferedInputStream(openConnection.getInputStream());
        } catch (SocketTimeoutException e16) {
            aVar.f129190b = "http\u8bf7\u6c42\u8d85\u65f6";
            com.tencent.luggage.wxa.h.b.b(f129185c, "ImageFetch Timeout! path[%s] connectionTimeout[%d] readTimeout[%d] error[%s]", obj, Integer.valueOf(this.f129187a), Integer.valueOf(this.f129188b), e16.toString());
        } catch (Exception e17) {
            aVar.f129190b = "http\u8bf7\u6c42\u51fa\u73b0\u9519\u8bef";
            com.tencent.luggage.wxa.h.b.b(f129185c, "fetch error. path = [%s], error = [%s]", obj, e17.toString());
        }
        return aVar;
    }

    public void a(int i3, int i16) {
        if (i3 <= 0 || i16 <= 0) {
            return;
        }
        this.f129187a = i3;
        this.f129188b = i16;
        com.tencent.luggage.wxa.h.b.c(f129185c, "Http Timeout Set: connection[%d] read[%d]", Integer.valueOf(i3), Integer.valueOf(i16));
    }
}
