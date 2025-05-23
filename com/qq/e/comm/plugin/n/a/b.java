package com.qq.e.comm.plugin.n.a;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.PlainRequest;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.net.rr.S2SSRequest;
import com.qq.e.comm.plugin.j.e;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.k.ay;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.stat.c;
import com.qq.e.comm.plugin.webview.inner.IInnerWebView;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.splash.image.TGSplashFileUtil;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.commons.fileupload.FileUploadBase;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f39676a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static ReentrantReadWriteLock f39677b;

    /* renamed from: c, reason: collision with root package name */
    private static String f39678c;

    /* renamed from: d, reason: collision with root package name */
    private static String f39679d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f39680e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f39681f = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Pair<String, Boolean> e16 = e();
        String str = (String) e16.first;
        boolean booleanValue = ((Boolean) e16.second).booleanValue();
        this.f39681f = booleanValue;
        if (!booleanValue) {
            return;
        }
        NetworkCallBack networkCallBack = new NetworkCallBack() { // from class: com.qq.e.comm.plugin.n.a.b.2
            @Override // com.qq.e.comm.net.NetworkCallBack
            public void onException(Exception exc) {
                GDTLogger.e("PagePerformance Network exception.", exc);
            }

            @Override // com.qq.e.comm.net.NetworkCallBack
            public void onResponse(Request request, Response response) {
                if (b.f39677b != null) {
                    try {
                        try {
                            if (response.getStatusCode() != 200) {
                                GDTLogger.e("PagePerformance js url response code error, code: " + response.getStatusCode());
                                b.this.f39681f = false;
                            } else {
                                String stringContent = response.getStringContent();
                                if (StringUtil.isEmpty(stringContent)) {
                                    GDTLogger.e("PagePerformance js url response empty");
                                    b.this.f39681f = false;
                                } else {
                                    GDTLogger.d("PagePerformance js url response: " + stringContent);
                                    b.f39677b.writeLock().lock();
                                    at.a(b.this.d(), stringContent);
                                    b.this.f39681f = true;
                                }
                            }
                        } catch (IOException e17) {
                            GDTLogger.e("PagePerformance io exception.", e17);
                        }
                    } finally {
                        b.f39677b.writeLock().unlock();
                    }
                }
            }
        };
        GDTLogger.d("PagePerformance js url: " + str);
        NetworkClientImpl.getInstance().submit(new PlainRequest(str, 1, (byte[]) null), networkCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File d() {
        File file;
        IOException e16;
        File file2;
        try {
            file2 = new File(f39678c);
            file = new File(f39678c, f39679d);
            try {
            } catch (IOException e17) {
                e16 = e17;
                GDTLogger.e("PagePerformance getCacheFile exception.", e16);
                return file;
            }
        } catch (IOException e18) {
            file = null;
            e16 = e18;
        }
        if (!file2.exists() && !file2.mkdir()) {
            GDTLogger.e("PagePerformance cacheFile mkdir failed");
            return null;
        }
        if (!file.exists()) {
            GDTLogger.d("PagePerformance cacheFile createNewFile result: " + file.createNewFile());
        }
        return file;
    }

    private Pair<String, Boolean> e() {
        boolean z16;
        String b16 = e.a().b((String) null, "performance_js_url");
        if (StringUtil.isEmpty(b16)) {
            b16 = "https://i.gtimg.cn/ams-web/page-performance/page-performance-sdk.min.js";
        }
        if (!ay.a(b16)) {
            GDTLogger.d("PagePerformance js url invalid");
            z16 = false;
        } else {
            z16 = true;
        }
        return new Pair<>(b16, Boolean.valueOf(z16));
    }

    public void a() {
        if (this.f39680e) {
            return;
        }
        synchronized (this) {
            if (this.f39680e) {
                return;
            }
            this.f39680e = true;
            f39677b = new ReentrantReadWriteLock();
            f39678c = GDTADManager.getInstance().getAppContext().getDir(TGSplashFileUtil.ADNET, 0).getAbsolutePath();
            f39679d = "performance_script";
            GdtSDKThreadManager.getInstance().runOnThread(3, new Runnable() { // from class: com.qq.e.comm.plugin.n.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.c();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.qq.e.comm.plugin.stat.b bVar) {
        GDTLogger.d("PagePerformance report");
        try {
            JSONObject jSONObject = new JSONObject(str);
            GDTLogger.d("PagePerformance performanceJson: " + jSONObject);
            a(jSONObject.getJSONArray("event_report"), bVar);
            a(jSONObject.getJSONArray("rpt_report"));
        } catch (Exception e16) {
            GDTLogger.e("PagePerformance report.", e16);
        }
    }

    private void a(JSONArray jSONArray) {
        GDTLogger.d("PagePerformance rptBatchReport: " + jSONArray);
        if (y.a(jSONArray)) {
            GDTLogger.e("PagePerformance rptBatchReport data is null");
            return;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                jSONArray2.mo162put(jSONArray.get(i3));
                if (jSONArray2.length() >= 20 || i3 == length - 1) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("data", jSONArray2);
                    S2SSRequest s2SSRequest = new S2SSRequest("https://rpt.gdt.qq.com/batch_landing_page", jSONObject.toString().getBytes(Charset.forName("UTF-8")), false);
                    s2SSRequest.addHeader(FileUploadBase.CONTENT_TYPE, "application/json");
                    NetworkClientImpl.getInstance().submit(s2SSRequest, 1, (NetworkCallBack) null);
                    jSONArray2 = new JSONArray();
                }
            }
        } catch (Exception e16) {
            GDTLogger.e("PagePerformance rptBatchReport exception.", e16);
        }
    }

    private void a(JSONArray jSONArray, com.qq.e.comm.plugin.stat.b bVar) {
        GDTLogger.d("PagePerformance eventReport: " + jSONArray);
        if (y.a(jSONArray)) {
            GDTLogger.e("PagePerformance eventReport data is null");
            return;
        }
        try {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                if (bVar == null) {
                    bVar = new com.qq.e.comm.plugin.stat.b();
                }
                JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                if (y.a(jSONObject)) {
                    int i16 = jSONObject.getInt("eventId");
                    bVar.a(jSONObject.optJSONObject("biz"));
                    if (i16 != Integer.MIN_VALUE) {
                        StatTracer.trackEvent(i16, 0, bVar, (c) null);
                    }
                }
            }
        } catch (Exception e16) {
            GDTLogger.e("PagePerformance eventReport exception.", e16);
        }
    }

    private void a(final IInnerWebView iInnerWebView, final String str, final String str2, final int i3, final a aVar) {
        if (iInnerWebView != null && !StringUtil.isEmpty(str)) {
            final long currentTimeMillis = System.currentTimeMillis();
            com.qq.e.comm.plugin.n.a.a.a(gdt_analysis_event.EVENT_LANDINGPAGE_WEBVIEW_START, currentTimeMillis, str2, i3);
            GDTLogger.d("PagePerformance injectScript scene: " + i3 + " \u6ce8\u5165JS.");
            aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.n.a.b.3
                @Override // java.lang.Runnable
                public void run() {
                    iInnerWebView.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.qq.e.comm.plugin.n.a.b.3.1
                        @Override // android.webkit.ValueCallback
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str3) {
                            GDTLogger.d("PagePerformance injectScript scene: " + i3 + " \u56de\u8c03\u8017\u65f6: " + (System.currentTimeMillis() - currentTimeMillis) + " \u56de\u8c03. resp: " + str3);
                            a aVar2 = aVar;
                            if (aVar2 != null) {
                                aVar2.a(str3);
                            }
                            if (!TextUtils.isEmpty(str3) && str3.equals("true")) {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                com.qq.e.comm.plugin.n.a.a.a(gdt_analysis_event.EVENT_LANDINGPAGE_WEBVIEW_SUCCESS, currentTimeMillis, str2, i3);
                            } else {
                                AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                com.qq.e.comm.plugin.n.a.a.a(gdt_analysis_event.EVENT_LANDINGPAGE_WEBVIEW_FAILED, currentTimeMillis, str2, i3);
                            }
                        }
                    });
                }
            });
            return;
        }
        GDTLogger.d("PagePerformance injectScript webview or script is null");
    }

    public void a(IInnerWebView iInnerWebView, String str, JSONObject jSONObject) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        bVar.a(jSONObject);
        a(iInnerWebView, str, bVar);
    }

    public void a(IInnerWebView iInnerWebView, String str, final com.qq.e.comm.plugin.stat.b bVar) {
        if (com.qq.e.comm.plugin.j.c.a(str, "needReportPagePerformance", 1, 1)) {
            if (iInnerWebView == null) {
                GDTLogger.e("PagePerformance webviewGetPerformanceResult webview is null");
                StatTracer.trackEvent(4003031, 0, bVar);
            } else if (!this.f39681f) {
                GDTLogger.d("PagePerformance webviewGetPerformanceResult switch is close");
                StatTracer.trackEvent(4003031, 0, bVar);
            } else {
                a(iInnerWebView, "__TG_GET_PAGE_PERFORMANCE__()", str, 2, new a() { // from class: com.qq.e.comm.plugin.n.a.b.4
                    @Override // com.qq.e.comm.plugin.n.a.b.a
                    public void a(String str2) {
                        if (str2 != null && !str2.equals("null")) {
                            b.this.a(str2, bVar);
                        } else {
                            StatTracer.trackEvent(4003031, 0, bVar);
                        }
                    }
                });
            }
        }
    }
}
