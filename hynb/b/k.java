package hynb.b;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.huya.huyasdk.data.BaseShortResponse;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import hynb.b.k;
import java.nio.charset.StandardCharsets;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class k {

    /* renamed from: d, reason: collision with root package name */
    public TimerTask f406630d;

    /* renamed from: e, reason: collision with root package name */
    public Timer f406631e;

    /* renamed from: f, reason: collision with root package name */
    public String f406632f;

    /* renamed from: g, reason: collision with root package name */
    public String f406633g;

    /* renamed from: h, reason: collision with root package name */
    public h f406634h;

    /* renamed from: i, reason: collision with root package name */
    public int f406635i;

    /* renamed from: b, reason: collision with root package name */
    public OkHttpClient f406628b = new OkHttpClient.Builder().addInterceptor(new b()).build();

    /* renamed from: c, reason: collision with root package name */
    public int f406629c = 0;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f406636j = false;

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f406627a = ProxyExecutors.newCachedThreadPool();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            k.this.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements Interceptor {

        /* renamed from: a, reason: collision with root package name */
        public long f406638a = 0;

        /* renamed from: b, reason: collision with root package name */
        public Request f406639b;

        /* renamed from: c, reason: collision with root package name */
        public Call f406640c;

        public b() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) {
            long nanoTime = System.nanoTime();
            this.f406640c = chain.call();
            Request request = chain.request();
            this.f406639b = request;
            Response proceed = chain.proceed(request);
            k.this.a();
            this.f406638a = (System.nanoTime() - nanoTime) / 1000000;
            hynb.p.g.f406799a.debug("HuyaHttpClient", "\u8bf7\u6c42\u8017\u65f6\uff1a" + this.f406638a + "ms, request=" + this.f406639b + ",call=" + this.f406640c);
            return proceed;
        }
    }

    public final void c() {
        for (Interceptor interceptor : this.f406628b.interceptors()) {
            if (interceptor instanceof b) {
                hynb.p.e eVar = hynb.p.g.f406799a;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("TimingInterceptor requestBody: ");
                b bVar = (b) interceptor;
                sb5.append(bVar.f406639b.body().toString());
                sb5.append(" ,call\uff1a");
                sb5.append(bVar.f406640c);
                eVar.debug("HuyaHttpClient", sb5.toString());
                bVar.f406640c.cancel();
                int i3 = this.f406629c + 1;
                this.f406629c = i3;
                if (i3 < 3) {
                    a(this.f406632f, this.f406633g, this.f406634h, this.f406635i);
                    a();
                }
            }
        }
    }

    public final void b() {
        this.f406630d = new a();
    }

    public final synchronized void a() {
        Timer timer = this.f406631e;
        if (timer != null) {
            timer.cancel();
            this.f406631e = null;
            hynb.p.g.f406799a.debug("HuyaHttpClient", String.format("retry : %s, cancelAllTask", Integer.valueOf(this.f406629c)));
        }
    }

    public final synchronized void a(long j3) {
        if (this.f406631e == null) {
            this.f406631e = new BaseTimer("HuyaHttpClient");
        }
        b();
        hynb.p.g.f406799a.debug("HuyaHttpClient", String.format("retry : %s, scheduleLoopTask", Integer.valueOf(this.f406629c)));
        this.f406631e.schedule(this.f406630d, j3);
    }

    public void a(final String str, final String str2, final h hVar, final int i3) {
        this.f406632f = str;
        this.f406633g = str2;
        this.f406634h = hVar;
        this.f406635i = i3;
        this.f406627a.execute(new Runnable() { // from class: p15.a
            @Override // java.lang.Runnable
            public final void run() {
                k.this.a(str2, str, i3, hVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0122 A[Catch: all -> 0x01c4, TryCatch #2 {all -> 0x01c4, blocks: (B:19:0x009f, B:22:0x00a9, B:24:0x00b7, B:27:0x00be, B:28:0x00d3, B:30:0x0122, B:32:0x0135, B:33:0x013c, B:36:0x0142, B:38:0x018f, B:39:0x0193, B:42:0x0171, B:45:0x00c7, B:9:0x01c8, B:11:0x01cd, B:12:0x01e0), top: B:18:0x009f, outer: #4, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void a(String str, String str2, int i3, h hVar) {
        int i16;
        String a16;
        BaseShortResponse baseShortResponse;
        Object obj;
        Request build = new Request.Builder().url(str2).post(RequestBody.create(MediaType.parse("application/json"), str)).build();
        if (i3 == 1) {
            build = new Request.Builder().url(str2).post(RequestBody.create(MediaType.parse("application/json"), a(str))).addHeader("Content-Encrypt", "yyencrypt").addHeader("Accept-Encrypt", "yyencrypt").build();
        }
        hynb.p.e eVar = hynb.p.g.f406799a;
        eVar.a("HuyaHttpClient", "sendShortRequest requestBody json: " + str + ", request:" + build + ", requestBody:" + build.body().toString() + " ,retry:" + this.f406629c);
        a(20000L);
        try {
            Response execute = this.f406628b.newCall(build).execute();
            if (execute != null) {
                try {
                    if (execute.code() == 200) {
                        String header = execute.header("Accept-Encrypt");
                        String header2 = execute.header("Content-Encrypt");
                        if (!"yyencrypt".equals(header) && !"yyencrypt".equals(header2)) {
                            a16 = execute.body().string();
                            eVar.a("HuyaHttpClient", "sendShortRequest responseBody: " + a16 + ", response:" + execute + ", traceId:" + execute.header("X-Huya-Trace-Id") + ", acceptEncryptVal:" + header + ", contentEncryptVal:" + header2);
                            Gson gson = new Gson();
                            baseShortResponse = (BaseShortResponse) gson.fromJson(a16, BaseShortResponse.class);
                            if (baseShortResponse != null) {
                                String str3 = baseShortResponse.sBuffer;
                                JsonObject jsonObject = (JsonObject) gson.fromJson(str3, JsonObject.class);
                                JsonElement jsonElement = jsonObject.get("@ret");
                                if (jsonElement == null) {
                                    jsonElement = jsonObject.get("taf_ret");
                                }
                                int asInt = jsonElement.getAsInt();
                                if (hVar != null) {
                                    try {
                                        String jSONObject = new JSONObject(str3).getJSONObject("tRsp").toString();
                                        eVar.a("HuyaHttpClient", "callback.onResponse tRspJson: " + jSONObject);
                                        obj = gson.fromJson(jSONObject, (Class<Object>) hVar.getResponseClass());
                                    } catch (Exception e16) {
                                        hynb.p.g.f406799a.error("HuyaHttpClient", "callback.onResponse error: " + e16.getMessage());
                                        obj = null;
                                    }
                                    if (asInt == 0) {
                                        hVar.onResponse(obj);
                                    } else {
                                        hVar.onError(asInt, "retValue is " + asInt, obj);
                                        hynb.p.g.f406799a.error("HuyaHttpClient", "callback.onError error code:" + asInt);
                                    }
                                }
                            }
                            execute.close();
                            return;
                        }
                        a16 = a(execute.body().bytes());
                        eVar.a("HuyaHttpClient", "sendShortRequest responseBody: " + a16 + ", response:" + execute + ", traceId:" + execute.header("X-Huya-Trace-Id") + ", acceptEncryptVal:" + header + ", contentEncryptVal:" + header2);
                        Gson gson2 = new Gson();
                        baseShortResponse = (BaseShortResponse) gson2.fromJson(a16, BaseShortResponse.class);
                        if (baseShortResponse != null) {
                        }
                        execute.close();
                        return;
                    }
                } catch (Throwable th5) {
                    try {
                        throw th5;
                    } finally {
                    }
                }
            }
            if (hVar != null) {
                this.f406636j = true;
                hVar.onError(-9997, String.format("retry: %s, error message: http statusCode != 200", Integer.valueOf(this.f406629c)), null);
            }
            a();
            if (execute != null) {
                execute.close();
            }
        } catch (Exception e17) {
            hynb.p.e eVar2 = hynb.p.g.f406799a;
            eVar2.error("HuyaHttpClient", String.format("retry : %s, error message: %s", Integer.valueOf(this.f406629c), e17.getMessage()));
            if (this.f406636j) {
                return;
            }
            if (hVar != null && this.f406629c >= 3) {
                this.f406636j = true;
                hVar.onError(-9999, String.format("retry: %s, error message: %s", Integer.valueOf(this.f406629c), e17.getMessage()), null);
            } else {
                if ("Canceled".equals(e17.getMessage()) && (i16 = this.f406629c) < 3) {
                    eVar2.error("HuyaHttpClient", String.format("retry : %s, Canceled task timeout error message: %s", Integer.valueOf(i16), e17.getMessage()));
                    return;
                }
                if (hVar != null) {
                    this.f406636j = true;
                    hVar.onError(-9998, String.format("retry: %s, error message: %s", Integer.valueOf(this.f406629c), e17.getMessage()), null);
                }
                a();
                e17.printStackTrace();
            }
        }
    }

    public final byte[] a(String str) {
        byte[] b16;
        byte[] bArr = new byte[0];
        try {
            b16 = hynb.q.a.b(null, d.a(), str.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e16) {
            hynb.p.g.f406799a.error("HuyaHttpClient", String.format("encrypt error. req json: %s, e: %s", str, e16.getMessage()));
        }
        if (b16 == null) {
            return bArr;
        }
        bArr = b16;
        hynb.p.g.f406799a.a("HuyaHttpClient", String.format("encrypt message : %s, req json: %s", bArr, str));
        return bArr;
    }

    public final String a(byte[] bArr) {
        byte[] a16;
        String str = "";
        if (bArr == null) {
            return "";
        }
        try {
            a16 = hynb.q.a.a(null, d.a(), bArr);
        } catch (Exception e16) {
            hynb.p.g.f406799a.error("HuyaHttpClient", String.format("decrypt error. rsp byte[]: %s, e: %s", bArr, e16.getMessage()));
        }
        if (a16 == null) {
            return "";
        }
        str = new String(a16, "utf-8");
        hynb.p.g.f406799a.a("HuyaHttpClient", String.format("decrypt message : %s, rsp byte[]: %s", str, bArr));
        return str;
    }
}
