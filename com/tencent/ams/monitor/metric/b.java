package com.tencent.ams.monitor.metric;

import android.text.TextUtils;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes3.dex */
class b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<j> f70566a;

        /* renamed from: b, reason: collision with root package name */
        private URL f70567b;

        /* renamed from: c, reason: collision with root package name */
        public String f70568c;

        /* renamed from: d, reason: collision with root package name */
        public String f70569d;

        /* renamed from: e, reason: collision with root package name */
        public String f70570e;

        /* renamed from: f, reason: collision with root package name */
        public int f70571f;

        /* renamed from: g, reason: collision with root package name */
        public int f70572g;

        /* renamed from: h, reason: collision with root package name */
        public byte[] f70573h;

        /* renamed from: i, reason: collision with root package name */
        public byte[] f70574i;

        /* renamed from: j, reason: collision with root package name */
        public int f70575j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f70576k;

        /* renamed from: l, reason: collision with root package name */
        public long f70577l;

        /* renamed from: m, reason: collision with root package name */
        public Throwable f70578m;

        public a(WeakReference<j> weakReference) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference);
                return;
            }
            this.f70571f = 10000;
            this.f70572g = 10000;
            this.f70575j = Integer.MIN_VALUE;
            this.f70576k = false;
            this.f70577l = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            this.f70566a = weakReference;
        }

        public boolean c() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.f70567b != null && !TextUtils.isEmpty(this.f70568c)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (TextUtils.equals(this.f70568c, "POST")) {
                if (z16 && this.f70573h != null) {
                    return true;
                }
                return false;
            }
            return z16;
        }

        public WeakReference<j> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (WeakReference) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f70566a;
        }

        public boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            if (c() && this.f70575j == 200) {
                return true;
            }
            return false;
        }

        public void f(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
                return;
            }
            try {
                this.f70567b = new URL(str);
            } catch (Throwable unused) {
                new d(this.f70566a).c("AdMetricHttp", "[setUrl]" + str);
            }
        }
    }

    private static byte[] a(WeakReference<j> weakReference, InputStream inputStream) {
        d dVar = new d(weakReference);
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                byte[] bArr = new byte[1024];
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Throwable th5) {
                dVar.d("AdMetricHttp", com.tencent.mobileqq.msf.core.auth.k.f247491e, th5);
            }
        }
        try {
            byteArrayOutputStream.close();
        } catch (Throwable th6) {
            dVar.d("AdMetricHttp", com.tencent.mobileqq.msf.core.auth.k.f247491e, th6);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void b(a aVar) {
        WeakReference weakReference;
        HttpURLConnection httpURLConnection;
        Throwable th5;
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar != null) {
            weakReference = aVar.f70566a;
        } else {
            weakReference = null;
        }
        d dVar = new d(weakReference);
        if (aVar != null && aVar.c()) {
            try {
                httpURLConnection = (HttpURLConnection) aVar.f70567b.openConnection();
            } catch (Throwable th6) {
                httpURLConnection = null;
                th5 = th6;
            }
            try {
                httpURLConnection.setConnectTimeout(aVar.f70571f);
                httpURLConnection.setReadTimeout(aVar.f70572g);
                httpURLConnection.setDoInput(true);
                if (TextUtils.equals(aVar.f70568c, "GET")) {
                    httpURLConnection.setDoOutput(false);
                } else if (TextUtils.equals(aVar.f70568c, "POST")) {
                    httpURLConnection.setDoOutput(true);
                }
                httpURLConnection.setRequestMethod(aVar.f70568c);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(aVar.f70576k);
                if (!TextUtils.isEmpty(aVar.f70569d)) {
                    httpURLConnection.setRequestProperty("Content-Type", aVar.f70569d);
                }
                if (!TextUtils.isEmpty(aVar.f70570e)) {
                    httpURLConnection.setRequestProperty("Referer", aVar.f70570e);
                }
                if (httpURLConnection.getDoOutput() && aVar.f70573h != null) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    byte[] bArr = aVar.f70573h;
                    dataOutputStream.write(bArr, 0, bArr.length);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                aVar.f70575j = responseCode;
                if (responseCode == 200 && httpURLConnection.getDoInput()) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    aVar.f70574i = a(aVar.d(), inputStream);
                    inputStream.close();
                }
            } catch (Throwable th7) {
                th5 = th7;
                try {
                    aVar.f70578m = th5;
                    dVar.d("AdMetricHttp", "send", th5);
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    aVar.f70577l = System.currentTimeMillis() - currentTimeMillis;
                }
            }
        }
    }
}
