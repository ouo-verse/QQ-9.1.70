package com.tencent.mobileqq.now.netchannel.websso;

import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WebServiceSSO {

    /* renamed from: a, reason: collision with root package name */
    private final String f254360a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f254362c;

    /* renamed from: d, reason: collision with root package name */
    private Dispatcher f254363d;

    /* renamed from: f, reason: collision with root package name */
    private OkHttpClient f254365f;

    /* renamed from: b, reason: collision with root package name */
    private final WebServiceSSOSender f254361b = new WebServiceSSOSender();

    /* renamed from: e, reason: collision with root package name */
    private ConnectionPool f254364e = new ConnectionPool(5, 20, TimeUnit.SECONDS);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class WebServiceSSOSender {

        /* renamed from: a, reason: collision with root package name */
        final AtomicInteger f254366a = new AtomicInteger(0);

        /* renamed from: b, reason: collision with root package name */
        final AtomicInteger f254367b = new AtomicInteger(0);

        /* renamed from: c, reason: collision with root package name */
        final int f254368c = 10;

        /* renamed from: d, reason: collision with root package name */
        final ExecutorService f254369d = ProxyExecutors.newFixedThreadPool(10);

        /* renamed from: e, reason: collision with root package name */
        final ExecutorService f254370e = ProxyExecutors.newFixedThreadPool(10);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class SSOException extends Exception {
            final int errorCode;
            final String errorMessage;

            SSOException(int i3, String str) {
                super("errorCode==" + i3 + " errorMessage==" + str);
                this.errorCode = i3;
                this.errorMessage = str;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Callable<byte[]> {

            /* renamed from: d, reason: collision with root package name */
            final int f254376d;

            /* renamed from: e, reason: collision with root package name */
            final String f254377e;

            /* renamed from: f, reason: collision with root package name */
            final byte[] f254378f;

            public a(int i3, String str, byte[] bArr) {
                this.f254376d = i3;
                this.f254377e = str;
                this.f254378f = bArr;
            }

            private byte[] b(URL url, byte[] bArr) throws Exception {
                try {
                    Response execute = WebServiceSSO.this.f254365f.newCall(new Request.Builder().url(url).post(RequestBody.create((MediaType) null, bArr)).build()).execute();
                    try {
                        if (!execute.isSuccessful()) {
                            execute.close();
                            return null;
                        }
                        execute.body().getContentLength();
                        byte[] bytes = execute.body().bytes();
                        try {
                            JSONObject jSONObject = new JSONObject(new String(bytes));
                            try {
                                throw new SSOException(jSONObject.getInt("ErrorCode"), jSONObject.getString("ErrorInfo"));
                            } catch (JSONException unused) {
                                throw new SSOException(-3, "SSO\u901a\u4fe1\u5f02\u5e38\uff0c\u5f02\u5e38\u4fe1\u606f\u89e3\u6790\u9519\u8bef\u3002\u539f\u59cb\u5185\u5bb9\uff1a" + new String(bytes));
                            }
                        } catch (Exception unused2) {
                            execute.close();
                            return bytes;
                        }
                    } finally {
                    }
                } catch (IOException e16) {
                    Log.d("RequestCallable", "WebServiceSSO--request IOException=" + e16.toString());
                    e16.printStackTrace();
                    return null;
                }
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public byte[] call() throws Exception {
                String str;
                if (WebServiceSSO.this.f254362c) {
                    str = "https://test.tim.qq.com/v4/";
                } else {
                    str = "https://open.tim.qq.com/v4/";
                }
                URL url = new URL(str + "NowSSOSvcProxy/" + this.f254377e + WebServiceSSO.this.f254360a);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("WebServiceSSO--send url=");
                sb5.append(url.toString());
                Log.d("RequestCallable", sb5.toString());
                return b(url, this.f254378f);
            }
        }

        public WebServiceSSOSender() {
        }

        public void a(String str, byte[] bArr, final d dVar) {
            final Future submit = this.f254369d.submit(new a(this.f254366a.incrementAndGet(), str, bArr));
            this.f254370e.submit(new Runnable() { // from class: com.tencent.mobileqq.now.netchannel.websso.WebServiceSSO.WebServiceSSOSender.1
                @Override // java.lang.Runnable
                public void run() {
                    Future future = submit;
                    if (dVar != null) {
                        try {
                            byte[] bArr2 = (byte[]) future.get();
                            WebServiceSSOSender.this.f254367b.incrementAndGet();
                            dVar.a(bArr2);
                        } catch (InterruptedException unused) {
                            WebServiceSSOSender.this.f254367b.incrementAndGet();
                            dVar.onFail(-1, "InterruptedException");
                        } catch (ExecutionException e16) {
                            WebServiceSSOSender.this.f254367b.incrementAndGet();
                            if (e16.getCause() instanceof SSOException) {
                                SSOException sSOException = (SSOException) e16.getCause();
                                dVar.onFail(sSOException.errorCode, sSOException.errorMessage);
                            } else {
                                dVar.onFail(-2, e16.getCause().getMessage());
                            }
                        } catch (Exception e17) {
                            dVar.onFail(-3, e17.getCause().getMessage());
                        }
                    }
                }
            });
        }

        public void b() {
            this.f254369d.shutdown();
            this.f254370e.shutdown();
            WebServiceSSO.this.f254363d.cancelAll();
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.now.netchannel.websso.WebServiceSSO.WebServiceSSOSender.2
                @Override // java.lang.Runnable
                public void run() {
                    WebServiceSSO.this.f254364e.evictAll();
                }
            });
        }
    }

    public WebServiceSSO(int i3, int i16, String str, long j3, String str2, int i17) {
        this.f254360a = "?SdkAppId=" + i3 + "&AccountType=" + i16 + "&AppIdAt3rd=" + str + "&Identifier=" + j3 + "&UserSig=" + str2 + "&Apn=" + i17 + "&ContentType=binary";
        Dispatcher dispatcher = new Dispatcher();
        this.f254363d = dispatcher;
        dispatcher.setMaxRequests(20);
        this.f254363d.setMaxRequestsPerHost(4);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f254365f = builder.connectTimeout(10000L, timeUnit).readTimeout(10000L, timeUnit).writeTimeout(10000L, timeUnit).connectionPool(this.f254364e).dispatcher(this.f254363d).build();
    }

    public boolean f() {
        return this.f254362c;
    }

    public void g(String str, byte[] bArr, d dVar) {
        this.f254361b.a(str, bArr, dVar);
    }

    public void h(boolean z16) {
        this.f254362c = z16;
    }

    public void i() {
        this.f254361b.b();
    }
}
