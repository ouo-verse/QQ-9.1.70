package com.tencent.biz.webviewplugin;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;

/* loaded from: classes5.dex */
public class PubAccountWebViewHttpBridge {

    /* renamed from: c, reason: collision with root package name */
    public Thread f97386c;

    /* renamed from: n, reason: collision with root package name */
    String f97397n;

    /* renamed from: a, reason: collision with root package name */
    public boolean f97384a = false;

    /* renamed from: b, reason: collision with root package name */
    public String f97385b = "";

    /* renamed from: d, reason: collision with root package name */
    public final int f97387d = 1;

    /* renamed from: e, reason: collision with root package name */
    public final int f97388e = 2;

    /* renamed from: f, reason: collision with root package name */
    public final int f97389f = 3;

    /* renamed from: g, reason: collision with root package name */
    public final int f97390g = 4;

    /* renamed from: h, reason: collision with root package name */
    public final int f97391h = -1;

    /* renamed from: i, reason: collision with root package name */
    AtomicInteger f97392i = new AtomicInteger(1);

    /* renamed from: j, reason: collision with root package name */
    AtomicBoolean f97393j = new AtomicBoolean(false);

    /* renamed from: k, reason: collision with root package name */
    public AtomicBoolean f97394k = new AtomicBoolean(false);

    /* renamed from: l, reason: collision with root package name */
    volatile WebResourceResponse f97395l = null;

    /* renamed from: m, reason: collision with root package name */
    boolean f97396m = false;

    /* renamed from: o, reason: collision with root package name */
    public volatile long f97398o = 0;

    /* renamed from: p, reason: collision with root package name */
    public volatile long f97399p = 0;

    /* renamed from: q, reason: collision with root package name */
    public volatile long f97400q = 0;

    /* renamed from: r, reason: collision with root package name */
    public volatile boolean f97401r = false;

    /* renamed from: s, reason: collision with root package name */
    public volatile long f97402s = 0;

    /* renamed from: t, reason: collision with root package name */
    public volatile String f97403t = "null";

    /* renamed from: u, reason: collision with root package name */
    private long f97404u = 0;

    private String f(String str) {
        String path = Uri.parse(str).getPath();
        if (path.contains(".css")) {
            return "text/css";
        }
        if (path.contains(PTSFileUtil.JS_FORMAT)) {
            return "application/x-javascript";
        }
        if (!path.contains(".jpg") && !path.contains(QzoneEmotionUtils.SIGN_ICON_URL_END) && !path.contains(".png") && !path.contains(".jpeg")) {
            return "text/html";
        }
        return "image/*";
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ef A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f0 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HttpURLConnection g(Intent intent) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        String str;
        boolean z16 = true;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.f97384a) {
                str = "";
            } else {
                str = e();
                if (QLog.isColorLevel()) {
                    QLog.d("PubAccountWebViewHttpBridge", 2, "get cookie cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                if (TextUtils.isEmpty(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.w("PubAccountWebViewHttpBridge", 2, " cookie is null!");
                    }
                    this.f97403t = "Cookie_Not_Valid";
                }
            }
            httpURLConnection2 = (HttpURLConnection) new URL(this.f97385b).openConnection();
            try {
            } catch (Exception e16) {
                httpURLConnection = httpURLConnection2;
                e = e16;
                if (QLog.isColorLevel()) {
                    QLog.e("PubAccountWebViewHttpBridge", 2, "http async get handleEvent exception !!!!", e);
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                httpURLConnection2 = httpURLConnection;
                if (!z16) {
                }
            }
        } catch (Exception e17) {
            e = e17;
            httpURLConnection = null;
        }
        if (httpURLConnection2 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("PubAccountWebViewHttpBridge", 2, "HttpURLConnection is null!");
            }
            this.f97403t = "URLConnection_NULL";
            return null;
        }
        httpURLConnection2.setConnectTimeout(15000);
        httpURLConnection2.setReadTimeout(15000);
        boolean z17 = false;
        httpURLConnection2.setInstanceFollowRedirects(false);
        httpURLConnection2.setRequestProperty("Cookie", str);
        httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
        httpURLConnection2.setRequestProperty("User-Agent", com.tencent.mobileqq.webview.swift.utils.i.n(com.tencent.mobileqq.webview.swift.utils.i.i("httpAsync 1.0"), "", false));
        int responseCode = httpURLConnection2.getResponseCode();
        this.f97403t = String.valueOf(responseCode);
        if (responseCode != 200) {
            z17 = true;
        }
        if (responseCode == 200) {
            this.f97397n = httpURLConnection2.getHeaderField("Content-Length");
            if (QLog.isColorLevel()) {
                QLog.d("PubAccountWebViewHttpBridge", 2, "length is " + this.f97397n);
            }
        }
        z16 = z17;
        if (!z16) {
            return null;
        }
        return httpURLConnection2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f97392i.compareAndSet(2, 3)) {
            synchronized (this.f97392i) {
                if (QLog.isColorLevel()) {
                    QLog.d("PubAccountWebViewHttpBridge", 2, "now notify all thread!");
                }
                this.f97392i.notify();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (!this.f97392i.compareAndSet(1, 2)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection g16 = g(null);
        if (g16 == null) {
            return;
        }
        d(currentTimeMillis, g16, true);
    }

    public void c() {
        if (this.f97392i.get() == 2) {
            if (QLog.isColorLevel()) {
                QLog.w("PubAccountWebViewHttpBridge", 2, "async http get cost too much time, now destroy!");
            }
            this.f97392i.set(-1);
            synchronized (this.f97392i) {
                this.f97392i.notify();
            }
        } else {
            this.f97392i.set(-1);
        }
        this.f97396m = true;
        this.f97386c = null;
        this.f97385b = "";
    }

    void d(long j3, HttpURLConnection httpURLConnection, boolean z16) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedInputStream bufferedInputStream3;
        try {
            this.f97402s = httpURLConnection.getContentLength();
            if (QLog.isColorLevel()) {
                QLog.d("PubAccountWebViewHttpBridge", 2, "data encoding: " + httpURLConnection.getContentEncoding() + " now read content: " + Formatter.formatFileSize(BaseApplicationImpl.getApplication().getApplicationContext(), this.f97402s) + " reportWebsiteLength: " + this.f97402s);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            if (inputStream == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("PubAccountWebViewHttpBridge", 2, "inputstream or contentType goes wrong!");
                }
                this.f97403t = "InputStream_Error";
                throw new RuntimeException("InputStream is null!");
            }
            if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                bufferedInputStream = new BufferedInputStream(new GZIPInputStream(inputStream));
            } else {
                bufferedInputStream = new BufferedInputStream(inputStream);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (z16) {
                byte[] bArr = new byte[10240];
                int i3 = 0;
                int i16 = 0;
                ByteArrayOutputStream byteArrayOutputStream = null;
                while (!this.f97393j.get() && (i16 = bufferedInputStream.read(bArr)) != -1) {
                    i3 += i16;
                    if (byteArrayOutputStream == null) {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    }
                    byteArrayOutputStream.write(bArr, 0, i16);
                    LockMethodProxy.sleep(20L);
                }
                this.f97402s = i3;
                if (QLog.isColorLevel()) {
                    QLog.d("PubAccountWebViewHttpBridge", 2, "now read data: " + i3 + ", now is ShouldIntercept: " + this.f97393j.get());
                }
                if (i16 == -1 && i3 > 0) {
                    if (QLog.isColorLevel()) {
                        QLog.i("PubAccountWebViewHttpBridge", 2, "now read all data!");
                    }
                    httpURLConnection.disconnect();
                    this.f97403t = "Read_All_Data";
                    bufferedInputStream2 = null;
                } else {
                    bufferedInputStream2 = bufferedInputStream;
                }
                if (byteArrayOutputStream != null) {
                    bufferedInputStream3 = new BufferedInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                } else {
                    bufferedInputStream3 = null;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PubAccountWebViewHttpBridge", 2, "read byte stream cost : " + (System.currentTimeMillis() - currentTimeMillis) + ", total cost: " + (System.currentTimeMillis() - j3));
                }
                this.f97395l = new WebResourceResponse(f(this.f97385b), "utf-8", new a(bufferedInputStream3, bufferedInputStream2, byteArrayOutputStream, httpURLConnection));
                if (QLog.isColorLevel()) {
                    QLog.d("PubAccountWebViewHttpBridge", 2, "swiftHttp get cost " + (System.currentTimeMillis() - j3));
                    QLog.d("QQBrowser_report", 2, "Web_qqbrowser_http_async_get, cost " + (System.currentTimeMillis() - j3));
                }
            }
        } catch (Exception e16) {
            QLog.e("PubAccountWebViewHttpBridge", 1, "swiftHttp read data exception !!!! ", e16);
        }
    }

    public String e() throws Exception {
        return SwiftBrowserCookieMonster.r(this.f97385b);
    }

    public synchronized void j(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f97394k.compareAndSet(false, true);
        this.f97404u = System.currentTimeMillis();
        this.f97385b = str;
        this.f97384a = z16;
        this.f97386c = ThreadManagerV2.newFreeThread(new Runnable() { // from class: com.tencent.biz.webviewplugin.PubAccountWebViewHttpBridge.1
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                PubAccountWebViewHttpBridge.this.i();
                PubAccountWebViewHttpBridge.this.f97398o = System.currentTimeMillis() - currentTimeMillis;
                PubAccountWebViewHttpBridge.this.h();
            }
        }, "PubAccountWebViewHttpBridge", 5);
        if (QLog.isColorLevel()) {
            QLog.i("PubAccountWebViewHttpBridge", 2, "now prepare async get " + com.tencent.biz.common.util.k.f(str, new String[0]));
        }
        this.f97386c.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends InputStream {

        /* renamed from: d, reason: collision with root package name */
        BufferedInputStream f97405d;

        /* renamed from: e, reason: collision with root package name */
        BufferedInputStream f97406e;

        /* renamed from: f, reason: collision with root package name */
        ByteArrayOutputStream f97407f;

        /* renamed from: h, reason: collision with root package name */
        HttpURLConnection f97408h;

        public a(BufferedInputStream bufferedInputStream, BufferedInputStream bufferedInputStream2, ByteArrayOutputStream byteArrayOutputStream, HttpURLConnection httpURLConnection) {
            this.f97405d = bufferedInputStream;
            this.f97406e = bufferedInputStream2;
            this.f97407f = byteArrayOutputStream == null ? new ByteArrayOutputStream() : byteArrayOutputStream;
            this.f97408h = httpURLConnection;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (QLog.isColorLevel()) {
                QLog.i("PubAccountWebViewHttpBridge", 2, "now close memory stream and socket stream!");
            }
            try {
                BufferedInputStream bufferedInputStream = this.f97405d;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                    this.f97405d = null;
                }
                BufferedInputStream bufferedInputStream2 = this.f97406e;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                    this.f97406e = null;
                }
                HttpURLConnection httpURLConnection = this.f97408h;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                PubAccountWebViewHttpBridge.this.f97395l = null;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            BufferedInputStream bufferedInputStream;
            BufferedInputStream bufferedInputStream2 = this.f97405d;
            if (bufferedInputStream2 == null && this.f97406e == null) {
                return -1;
            }
            int read = bufferedInputStream2 != null ? bufferedInputStream2.read() : -1;
            return (read != -1 || (bufferedInputStream = this.f97406e) == null) ? read : bufferedInputStream.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            int i3;
            BufferedInputStream bufferedInputStream;
            BufferedInputStream bufferedInputStream2 = this.f97405d;
            if (bufferedInputStream2 == null && this.f97406e == null) {
                return -1;
            }
            if (bufferedInputStream2 != null) {
                i3 = bufferedInputStream2.read(bArr);
                if (QLog.isColorLevel()) {
                    QLog.i("PubAccountWebViewHttpBridge", 2, "now read data from memory buffer second: " + i3);
                }
            } else {
                i3 = -1;
            }
            if (i3 == -1 && (bufferedInputStream = this.f97406e) != null) {
                i3 = bufferedInputStream.read(bArr);
                if (QLog.isColorLevel()) {
                    QLog.i("PubAccountWebViewHttpBridge", 2, "now read data from socket stream second: " + i3);
                }
            }
            return i3;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i16) throws IOException {
            BufferedInputStream bufferedInputStream;
            if (this.f97405d == null && this.f97406e == null) {
                return -1;
            }
            int length = bArr.length;
            if ((i3 | i16) < 0 || i3 > length || length - i3 < i16) {
                if (QLog.isColorLevel()) {
                    QLog.d("PubAccountWebViewHttpBridge", 2, "buffer three, error");
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            for (int i17 = 0; i17 < i16; i17++) {
                try {
                    BufferedInputStream bufferedInputStream2 = this.f97405d;
                    int read = bufferedInputStream2 != null ? bufferedInputStream2.read() : -1;
                    if (read == -1 && (bufferedInputStream = this.f97406e) != null) {
                        read = bufferedInputStream.read();
                    }
                    if (read == -1) {
                        if (i17 == 0) {
                            return -1;
                        }
                        return i17;
                    }
                    bArr[i3 + i17] = (byte) read;
                } catch (IOException e16) {
                    if (i17 != 0) {
                        return i17;
                    }
                    throw e16;
                }
            }
            return i16;
        }
    }
}
