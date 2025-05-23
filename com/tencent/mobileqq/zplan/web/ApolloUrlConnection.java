package com.tencent.mobileqq.zplan.web;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.mobileqq.zplan.web.ApolloSSOConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import kotlin.text.Typography;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ApolloUrlConnection {

    /* renamed from: a, reason: collision with root package name */
    private HttpURLConnection f335988a;

    /* renamed from: b, reason: collision with root package name */
    private BufferedInputStream f335989b;

    /* renamed from: c, reason: collision with root package name */
    private String f335990c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f335991d;

    /* renamed from: e, reason: collision with root package name */
    private ApolloSSOConfig.c f335992e;

    /* renamed from: f, reason: collision with root package name */
    private String f335993f;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f335994a;

        /* renamed from: b, reason: collision with root package name */
        BufferedInputStream f335995b;

        /* renamed from: c, reason: collision with root package name */
        ByteArrayOutputStream f335996c;

        a() {
        }
    }

    public ApolloUrlConnection(String str, boolean z16, ApolloSSOConfig.c cVar, String str2) {
        this.f335990c = str;
        this.f335991d = z16;
        this.f335992e = cVar;
        this.f335993f = str2;
    }

    private synchronized BufferedInputStream g() {
        HttpURLConnection httpURLConnection;
        if (this.f335989b == null && (httpURLConnection = this.f335988a) != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if ("gzip".equalsIgnoreCase(this.f335988a.getContentEncoding())) {
                    this.f335989b = new BufferedInputStream(new GZIPInputStream(inputStream));
                } else {
                    this.f335989b = new BufferedInputStream(inputStream);
                }
            } catch (Throwable th5) {
                QLog.e("[zplan]apollo_client_ApolloUrlConnection", 2, "getResponseStream error:" + th5.getMessage() + ".");
            }
        }
        return this.f335989b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:71:0x022d A[Catch: all -> 0x0234, IOException -> 0x0255, TRY_LEAVE, TryCatch #3 {IOException -> 0x0255, all -> 0x0234, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0012, B:10:0x001e, B:11:0x003b, B:13:0x0041, B:15:0x0047, B:16:0x0050, B:18:0x0057, B:20:0x005d, B:22:0x0065, B:24:0x0075, B:25:0x008d, B:27:0x0093, B:29:0x00a4, B:33:0x00bb, B:34:0x00eb, B:35:0x00cd, B:38:0x0102, B:40:0x0108, B:41:0x0122, B:43:0x0133, B:48:0x0140, B:50:0x017c, B:51:0x0186, B:53:0x018c, B:55:0x01a2, B:57:0x01aa, B:58:0x01be, B:60:0x01c2, B:62:0x01c8, B:64:0x01d9, B:65:0x01ec, B:67:0x01fd, B:69:0x0215, B:71:0x022d), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int b() {
        try {
            if (this.f335988a == null) {
                long currentTimeMillis = System.currentTimeMillis();
                String str = "";
                if (this.f335991d) {
                    str = com.tencent.mobileqq.zplan.web.a.b(this.f335990c);
                    if (QLog.isColorLevel()) {
                        QLog.d("[zplan]apollo_client_ApolloUrlConnection", 2, "get cookie cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    if (TextUtils.isEmpty(str) && QLog.isColorLevel()) {
                        QLog.w("[zplan]apollo_client_ApolloUrlConnection", 2, " cookie is null!");
                    }
                }
                ApolloSSOConfig.c cVar = this.f335992e;
                String str2 = null;
                boolean z16 = true;
                if (cVar != null && cVar.a() && !TextUtils.isEmpty(this.f335990c)) {
                    ApolloSSOConfig.c cVar2 = this.f335992e;
                    this.f335990c = cVar2.f335974a;
                    String b16 = cVar2.b(true);
                    if (QLog.isColorLevel()) {
                        QLog.d("[zplan]apollo_client_ApolloUrlConnection", 2, "getUrlConnection mCgiConfig.parameterStr:" + b16);
                    }
                    if (TextUtils.isEmpty(b16) || !"get".equals(this.f335992e.f335975b.toLowerCase())) {
                        str2 = b16;
                    } else {
                        char c16 = '?';
                        int indexOf = this.f335990c.indexOf(63);
                        int indexOf2 = this.f335990c.indexOf(35);
                        if (indexOf != -1) {
                            c16 = Typography.amp;
                        }
                        this.f335990c = indexOf2 == -1 ? this.f335990c + c16 : this.f335990c.substring(0, indexOf2) + c16 + this.f335990c.substring(indexOf2);
                        this.f335990c += b16;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("[zplan]apollo_client_ApolloUrlConnection", 2, " getUrlConnection mCurrentUrl:" + this.f335990c);
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f335990c).openConnection();
                this.f335988a = httpURLConnection;
                if (httpURLConnection == null) {
                    QLog.e("[zplan]apollo_client_ApolloUrlConnection", 1, "getUrlConnection HttpURLConnection is null!");
                    return -1;
                }
                httpURLConnection.setConnectTimeout(5000);
                this.f335988a.setReadTimeout(15000);
                this.f335988a.setInstanceFollowRedirects(false);
                this.f335988a.setRequestProperty("Cookie", str);
                this.f335988a.setRequestProperty("Accept-Encoding", "gzip");
                this.f335988a.setRequestProperty("User-Agent", i.n(i.i("httpAsync 1.0"), "", false));
                ApolloSSOConfig.c cVar3 = this.f335992e;
                if (cVar3 != null) {
                    for (String str3 : cVar3.f335976c.keySet()) {
                        this.f335988a.setRequestProperty(str3, this.f335992e.f335976c.get(str3));
                    }
                }
                if (!TextUtils.isEmpty(this.f335993f)) {
                    this.f335988a.setRequestProperty("Origin", this.f335993f);
                    this.f335988a.setRequestProperty("Referer", this.f335993f);
                }
                ApolloSSOConfig.c cVar4 = this.f335992e;
                if (cVar4 != null && cVar4.a()) {
                    if ("get".equals(this.f335992e.f335975b.toLowerCase())) {
                        this.f335988a.setDoOutput(false);
                        this.f335988a.setDoInput(true);
                        this.f335988a.setRequestMethod("GET");
                    } else if (Method.POST.equals(this.f335992e.f335975b.toLowerCase())) {
                        this.f335988a.setDoOutput(true);
                        this.f335988a.setDoInput(true);
                        this.f335988a.setRequestMethod("POST");
                        if (!TextUtils.isEmpty(str2)) {
                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f335988a.getOutputStream());
                            outputStreamWriter.write(str2);
                            outputStreamWriter.flush();
                            outputStreamWriter.close();
                            if (!z16) {
                                this.f335988a.connect();
                            }
                            return 0;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
                return 0;
            }
        } catch (IOException e16) {
            QLog.e("[zplan]apollo_client_ApolloUrlConnection", 2, "getUrlConnection connect http exception !!!!" + e16);
            HttpURLConnection httpURLConnection2 = this.f335988a;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return -1;
        } catch (Throwable th5) {
            QLog.e("[zplan]apollo_client_ApolloUrlConnection", 2, "getUrlConnection connect http exception !!!!" + th5);
            HttpURLConnection httpURLConnection3 = this.f335988a;
            if (httpURLConnection3 != null) {
                httpURLConnection3.disconnect();
            }
            return -1;
        }
        return -1;
    }

    public void c() {
        if (this.f335988a == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.web.ApolloUrlConnection.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ApolloUrlConnection.this.f335988a.disconnect();
                    } catch (Throwable th5) {
                        QLog.e("[zplan]apollo_client_ApolloUrlConnection", 2, "disconnect error:" + th5.getMessage());
                    }
                }
            }, 128, null, true);
            return;
        }
        try {
            this.f335988a.disconnect();
        } catch (Exception e16) {
            QLog.e("[zplan]apollo_client_ApolloUrlConnection", 2, "disconnect error:" + e16.getMessage());
        }
    }

    public int d() {
        HttpURLConnection httpURLConnection = this.f335988a;
        if (httpURLConnection == null) {
            return -1;
        }
        try {
            return httpURLConnection.getResponseCode();
        } catch (Throwable th5) {
            QLog.e("[zplan]apollo_client_ApolloUrlConnection", 2, "getResponseCode error:" + th5.getMessage());
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized a e(AtomicBoolean atomicBoolean, ByteArrayOutputStream byteArrayOutputStream) {
        BufferedInputStream g16 = g();
        if (g16 != null) {
            if (byteArrayOutputStream == null) {
                byteArrayOutputStream = new ByteArrayOutputStream();
            }
            byte[] bArr = new byte[10240];
            int i3 = 0;
            while (!atomicBoolean.get() && -1 != (i3 = g16.read(bArr))) {
                try {
                    byteArrayOutputStream.write(bArr, 0, i3);
                } catch (Throwable th5) {
                    QLog.e("[zplan]apollo_client_ApolloUrlConnection", 2, " getResponseData error:" + th5.getMessage());
                }
            }
            a aVar = new a();
            aVar.f335995b = g16;
            aVar.f335996c = byteArrayOutputStream;
            aVar.f335994a = -1 == i3;
            return aVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, List<String>> f() {
        try {
            HttpURLConnection httpURLConnection = this.f335988a;
            if (httpURLConnection != null) {
                return httpURLConnection.getHeaderFields();
            }
            return null;
        } catch (Exception e16) {
            QLog.e("[zplan]apollo_client_ApolloUrlConnection", 1, e16, new Object[0]);
            return null;
        }
    }
}
