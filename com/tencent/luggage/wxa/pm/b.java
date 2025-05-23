package com.tencent.luggage.wxa.pm;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qm.e;
import com.tencent.luggage.wxa.qm.k;
import com.tencent.luggage.wxa.rb.d;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public d f137714b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.pm.a f137715c;

    /* renamed from: d, reason: collision with root package name */
    public float f137716d;

    /* renamed from: f, reason: collision with root package name */
    public boolean f137718f;

    /* renamed from: k, reason: collision with root package name */
    public InterfaceC6611b f137723k;

    /* renamed from: a, reason: collision with root package name */
    public String f137713a = null;

    /* renamed from: e, reason: collision with root package name */
    public long f137717e = 307200;

    /* renamed from: g, reason: collision with root package name */
    public boolean f137719g = true;

    /* renamed from: h, reason: collision with root package name */
    public String f137720h = "";

    /* renamed from: i, reason: collision with root package name */
    public int f137721i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f137722j = 0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public int f137724a;

        public a(int i3) {
            this.f137724a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            InterfaceC6611b interfaceC6611b = b.this.f137723k;
            if (interfaceC6611b != null) {
                interfaceC6611b.a(this.f137724a);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.pm.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6611b {
        void a(int i3);
    }

    public b(d dVar, com.tencent.luggage.wxa.pm.a aVar) {
        this.f137714b = dVar;
        this.f137715c = aVar;
        if (aVar.a()) {
            w.b("MicroMsg.Music.MusicDownloadTask", "downloadInfo is invalid");
        } else {
            w.d("MicroMsg.Music.MusicDownloadTask", "downloadInfo is valid");
        }
        this.f137718f = h0.l(z.c());
    }

    public boolean a(float f16) {
        long j3;
        long j16;
        if (this.f137718f) {
            com.tencent.luggage.wxa.pm.a aVar = this.f137715c;
            j3 = aVar.f137711f;
            if (j3 == 0) {
                return false;
            }
            j16 = aVar.f137709d;
        } else {
            com.tencent.luggage.wxa.pm.a aVar2 = this.f137715c;
            j3 = aVar2.f137707b;
            if (j3 == 0) {
                return false;
            }
            j16 = aVar2.f137706a;
        }
        float f17 = ((float) j16) / ((float) j3);
        return f17 >= 1.0f || f17 - f16 > 0.05f;
    }

    public d b() {
        return this.f137714b;
    }

    public boolean c() {
        return this.f137719g;
    }

    public boolean d() {
        return this.f137718f;
    }

    public void e() {
        if (!c()) {
            return;
        }
        this.f137719g = false;
        com.tencent.luggage.wxa.co.a.a(this, "music_download_thread");
    }

    public void f() {
        this.f137719g = true;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 7 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 8 */
    @Override // java.lang.Runnable
    public void run() {
        /*
            Method dump skipped, instructions count: 4655
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.wxa.pm.b.run():void");
    }

    public void b(float f16) {
        long j3;
        long j16;
        this.f137716d = f16;
        boolean k3 = h0.k(z.c());
        if (c() && k3) {
            if (this.f137718f) {
                com.tencent.luggage.wxa.pm.a aVar = this.f137715c;
                j3 = aVar.f137711f;
                if (j3 == 0) {
                    return;
                } else {
                    j16 = aVar.f137709d;
                }
            } else {
                com.tencent.luggage.wxa.pm.a aVar2 = this.f137715c;
                j3 = aVar2.f137707b;
                if (j3 == 0) {
                    return;
                } else {
                    j16 = aVar2.f137706a;
                }
            }
            float f17 = ((float) j16) / ((float) j3);
            if (f17 < 1.0f && f17 - f16 <= 0.15f && k3) {
                w.g("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(k3));
                e();
            }
        }
    }

    public final HttpURLConnection a(String str, Map map) {
        boolean z16;
        if (!TextUtils.isEmpty(this.f137713a)) {
            w.d("MicroMsg.Music.MusicDownloadTask", "use previous temp redirect URL to download , avoid to request source url and than redirect to 302 resp code");
            str = this.f137713a;
        }
        int i3 = 0;
        HttpURLConnection httpURLConnection = null;
        while (true) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.getInputStream().close();
                } catch (Exception e16) {
                    w.b("MicroMsg.Music.MusicDownloadTask", e16.getMessage());
                }
                httpURLConnection.disconnect();
            }
            w.d("MicroMsg.Music.MusicDownloadTask", "getUrlConnect, downloadUrl:%s", str);
            com.tencent.luggage.wxa.qm.b h16 = k.h();
            URL url = new URL(str);
            String host = url.getHost();
            if (h16 == null || (url = h16.b(str)) == null || str.equalsIgnoreCase(url.toString())) {
                z16 = false;
            } else {
                w.d("MicroMsg.Music.MusicDownloadTask", "getRedirectURL, srcUrl:%s", url.toString());
                z16 = true;
            }
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            httpURLConnection2.setRequestMethod("GET");
            httpURLConnection2.setConnectTimeout(25000);
            httpURLConnection2.setInstanceFollowRedirects(false);
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            if (z16 && !TextUtils.isEmpty(host)) {
                httpURLConnection2.setRequestProperty("Host", host);
                w.d("MicroMsg.Music.MusicDownloadTask", "use host :%s", host);
            }
            int responseCode = httpURLConnection2.getResponseCode();
            w.d("MicroMsg.Music.MusicDownloadTask", "getUrlConnect response:%d, redirectCount:%d", Integer.valueOf(responseCode), Integer.valueOf(i3));
            if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307) {
                if (responseCode != 200 && responseCode != 206) {
                    this.f137713a = null;
                }
                return httpURLConnection2;
            }
            b(responseCode);
            String requestMethod = httpURLConnection2.getRequestMethod();
            if (responseCode == 307 && !requestMethod.equals("GET") && !requestMethod.equals("HEAD")) {
                return httpURLConnection2;
            }
            String headerField = httpURLConnection2.getHeaderField("Location");
            if (headerField == null) {
                w.b("MicroMsg.Music.MusicDownloadTask", "Invalid redirect,  response:%d", Integer.valueOf(responseCode));
                return httpURLConnection2;
            }
            URL url2 = new URL(httpURLConnection2.getURL(), headerField);
            w.d("MicroMsg.Music.MusicDownloadTask", "location:%s", headerField);
            w.d("MicroMsg.Music.MusicDownloadTask", "tempUrl:%s", url2.toString());
            if (!url2.getProtocol().equals("https") && !url2.getProtocol().equals("http")) {
                w.b("MicroMsg.Music.MusicDownloadTask", "Unsupported protocol redirect,  response:%d", Integer.valueOf(responseCode));
                return httpURLConnection2;
            }
            i3++;
            if (i3 > 5) {
                w.b("MicroMsg.Music.MusicDownloadTask", "Too many redirects: " + i3);
                return httpURLConnection2;
            }
            str = url2.toString();
            this.f137713a = str;
            httpURLConnection = httpURLConnection2;
        }
    }

    public final void b(int i3) {
        com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.tm.b.a(e.class));
    }

    public final void b(long j3, long j16) {
        w.g("MicroMsg.Music.MusicDownloadTask", "update updateCurrentDownloadLength %d %d", Long.valueOf(j3), Long.valueOf(j16));
        if (this.f137718f) {
            com.tencent.luggage.wxa.pm.a aVar = this.f137715c;
            aVar.f137709d = j3;
            aVar.f137711f = j16;
        } else {
            com.tencent.luggage.wxa.pm.a aVar2 = this.f137715c;
            aVar2.f137706a = j3;
            aVar2.f137707b = j16;
        }
    }

    public final void a(int i3) {
        this.f137713a = null;
        c0.a(new a(i3));
    }

    public final void a(long j3) {
        if (this.f137718f) {
            com.tencent.luggage.wxa.pm.a aVar = this.f137715c;
            aVar.f137709d = j3;
            aVar.f137710e = 1;
            aVar.f137711f = j3;
            com.tencent.luggage.wxa.om.e.a(this.f137714b.f139441c, aVar);
        } else {
            com.tencent.luggage.wxa.pm.a aVar2 = this.f137715c;
            aVar2.f137706a = j3;
            aVar2.f137708c = 1;
            aVar2.f137707b = j3;
            com.tencent.luggage.wxa.om.e.a(this.f137714b.f139441c, aVar2);
        }
        c0.a(new a(2));
    }

    public final void a(long j3, long j16) {
        if (this.f137718f) {
            com.tencent.luggage.wxa.pm.a aVar = this.f137715c;
            aVar.f137709d = j3;
            aVar.f137710e = 0;
            aVar.f137711f = j16;
            com.tencent.luggage.wxa.om.e.a(this.f137714b.f139441c, aVar);
        } else {
            com.tencent.luggage.wxa.pm.a aVar2 = this.f137715c;
            aVar2.f137706a = j3;
            aVar2.f137708c = 0;
            aVar2.f137707b = j16;
            com.tencent.luggage.wxa.om.e.a(this.f137714b.f139441c, aVar2);
        }
        c0.a(new a(3));
    }

    public void a(InterfaceC6611b interfaceC6611b) {
        this.f137723k = interfaceC6611b;
    }

    public final long[] a(String str) {
        if (w0.c(str)) {
            return null;
        }
        try {
            String[] split = str.replace("bytes", "").trim().split("-");
            long longValue = Long.valueOf(split[0]).longValue();
            String[] split2 = split[1].split("/");
            return new long[]{longValue, Long.valueOf(split2[0]).longValue(), Long.valueOf(split2[1]).longValue()};
        } catch (Exception unused) {
            return null;
        }
    }

    public int a() {
        long j3;
        int i3;
        if (this.f137718f) {
            w.g("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", Long.valueOf(this.f137715c.f137711f), Long.valueOf(this.f137715c.f137709d));
            com.tencent.luggage.wxa.pm.a aVar = this.f137715c;
            long j16 = aVar.f137711f;
            if (j16 != 0) {
                j3 = (aVar.f137709d * 100) / j16;
                i3 = (int) j3;
            }
            i3 = 0;
        } else {
            w.g("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", Long.valueOf(this.f137715c.f137707b), Long.valueOf(this.f137715c.f137706a));
            com.tencent.luggage.wxa.pm.a aVar2 = this.f137715c;
            long j17 = aVar2.f137707b;
            if (j17 != 0) {
                j3 = (aVar2.f137706a * 100) / j17;
                i3 = (int) j3;
            }
            i3 = 0;
        }
        if (i3 >= 1) {
            return i3;
        }
        return 0;
    }
}
