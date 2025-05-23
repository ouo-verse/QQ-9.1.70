package com.qzone.video.TVK_SDK.mediaplayer.vodcgi;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webview.webso.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;

/* compiled from: P */
/* loaded from: classes37.dex */
public class f {

    /* renamed from: d, reason: collision with root package name */
    private static String f60003d = "\"vid\"";

    /* renamed from: e, reason: collision with root package name */
    private static Handler f60004e;

    /* renamed from: a, reason: collision with root package name */
    private ap.e f60005a;

    /* renamed from: b, reason: collision with root package name */
    private String f60006b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f60007c = null;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int indexOf;
            int indexOf2;
            QLog.i("WnsCgiInfo", 1, "wns cgi response");
            if (!(message.obj instanceof c.b)) {
                try {
                    QLog.e("WnsCgiInfo", 1, "response error");
                    throw new IOException("response error");
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            if (message.what == 204 && f.this.f60005a != null) {
                c.b bVar = (c.b) message.obj;
                if (bVar != null) {
                    QLog.i("WnsCgiInfo", 1, "wns cgi response code = " + bVar.f315020i);
                    if (bVar.f315015d != null && bVar.f315015d.toString().contains(f.f60003d) && bVar.f315015d.toString().length() > (indexOf2 = (indexOf = bVar.f315015d.toString().indexOf(f.f60003d)) + 18)) {
                        String substring = bVar.f315015d.toString().substring(indexOf + 7, indexOf2);
                        String obj = bVar.f315022k.toString();
                        QLog.i("WnsCgiInfo", 1, "wns cgi response vid = " + substring + ", origin vid = " + obj);
                        if (!substring.contains(obj)) {
                            QLog.e("WnsCgiInfo", 1, "wns cgi response vid error");
                        }
                    }
                    if (bVar.f315015d != null) {
                        f.this.f60007c = bVar.f315015d.getBytes();
                    } else {
                        QLog.e("WnsCgiInfo", 1, "wns cgi response html body is null");
                        f.this.f60007c = null;
                    }
                    if (bVar.f315017f <= 300) {
                        ap.e eVar = f.this.f60005a;
                        int i3 = bVar.f315017f;
                        Object obj2 = bVar.f315022k;
                        eVar.b(i3, obj2 != null ? obj2.toString() : null, new Header[0], f.this.f60007c);
                        f.this.f(true, bVar.f315017f);
                        return;
                    }
                    f.this.f60005a.j(bVar.f315017f, new Header[0], f.this.f60007c, new HttpResponseException(bVar.f315017f, bVar.f315021j));
                    f.this.f(false, bVar.f315017f);
                    return;
                }
                QLog.e("WnsCgiInfo", 1, "webSoCgiState is null");
                return;
            }
            QLog.e("WnsCgiInfo", 1, "response error code = " + message.what);
        }
    }

    public f(ap.e eVar) {
        this.f60005a = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z16, int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (i3 >= 0 && i3 < 300) {
            hashMap.put(QzoneIPCModule.RESULT_CODE, "0");
        } else if (i3 >= 300 && i3 < 400) {
            hashMap.put(QzoneIPCModule.RESULT_CODE, "1");
        } else if (i3 >= 400 && i3 < 500) {
            hashMap.put(QzoneIPCModule.RESULT_CODE, "2");
        } else if (i3 >= 500 && i3 < 600) {
            hashMap.put(QzoneIPCModule.RESULT_CODE, "3");
        } else {
            hashMap.put(QzoneIPCModule.RESULT_CODE, "4");
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(LoginData.getInstance().getUinString(), "WnsCgiSuccessRate", z16, 0L, 0L, hashMap, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
    
        r2.f315006d = r8.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
    
        if (r8.toString().contains("vid=") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
    
        r7 = r8.toString().indexOf("vid=");
        r5 = r7 + 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007f, code lost:
    
        if (r8.toString().length() <= r5) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0081, code lost:
    
        r6.f60006b = r8.toString().substring(r7 + 4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
    
        r2.f315007e = "application/x-www-form-urlencoded";
        r2.f315005c = null;
        r2.f315009g = false;
        r2.f315010h = 0;
        r2.f315011i = r6.f60006b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009e, code lost:
    
        if (com.qzone.video.TVK_SDK.mediaplayer.vodcgi.f.f60004e != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a0, code lost:
    
        com.qzone.video.TVK_SDK.mediaplayer.vodcgi.f.f60004e = new com.qzone.video.TVK_SDK.mediaplayer.vodcgi.f.a(r6, android.os.Looper.getMainLooper());
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ab, code lost:
    
        r7 = com.tencent.mobileqq.webview.webso.c.c().h(r2, com.qzone.video.TVK_SDK.mediaplayer.vodcgi.f.f60004e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b5, code lost:
    
        com.tencent.qphone.base.util.QLog.i("WnsCgiInfo", 1, "wns cgi request vid = " + r2.f315011i);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cf, code lost:
    
        if (r7 != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d1, code lost:
    
        com.tencent.qphone.base.util.QLog.i("WnsCgiInfo", 1, "send wns cgi info fail");
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00fc, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00db, code lost:
    
        r8 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00df, code lost:
    
        com.tencent.qphone.base.util.QLog.e("WnsCgiInfo", 1, "send wns cgi info exception e = " + r8.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00dd, code lost:
    
        r8 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00de, code lost:
    
        r7 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean g(HttpUriRequest httpUriRequest, ap.d dVar) throws IOException {
        if (httpUriRequest == null) {
            QLog.d("WnsCgiInfo", 1, "request is empty");
            return false;
        }
        c.a aVar = new c.a();
        try {
            String uri = httpUriRequest.getURI().toString();
            aVar.f315003a = uri;
            if (!TextUtils.isEmpty(uri)) {
                aVar.f315008f = null;
                String method = httpUriRequest.getMethod();
                aVar.f315004b = method;
                if (!"GET".equalsIgnoreCase(method) && !"POST".equalsIgnoreCase(aVar.f315004b)) {
                    QLog.e("WnsCgiInfo", 1, "no such method support");
                    throw new IOException("no such method support");
                }
                QLog.e("WnsCgiInfo", 1, "request params is null");
                throw new IOException("request params is null");
            }
            QLog.e("WnsCgiInfo", 1, "url is empty");
            throw new IOException("url is empty");
        } catch (Exception unused) {
            QLog.e("WnsCgiInfo", 1, "decode request error");
            throw new IOException("decode request error");
        }
    }
}
