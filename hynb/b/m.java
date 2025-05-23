package hynb.b;

import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.huya.huyasdk.data.BaseLongResponse;
import com.huya.huyasdk.data.HYNSPushMessageItems;
import com.huya.huyasdk.data.LongRequest;
import com.huya.huyasdk.data.LongRequestInfo;
import com.huya.huyasdk.data.WSHistoryMsgRsp;
import com.huya.huyasdk.data.WSPushMessage;
import com.huya.huyasdk.data.WSVerifyHuyaTokenRsp;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import hynb.b.m;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* compiled from: P */
/* loaded from: classes28.dex */
public class m {

    /* renamed from: b, reason: collision with root package name */
    public WebSocket f406672b;

    /* renamed from: c, reason: collision with root package name */
    public e f406673c;

    /* renamed from: d, reason: collision with root package name */
    public ScheduledExecutorService f406674d;

    /* renamed from: f, reason: collision with root package name */
    public String f406676f;

    /* renamed from: g, reason: collision with root package name */
    public TimerTask f406677g;

    /* renamed from: h, reason: collision with root package name */
    public Timer f406678h;

    /* renamed from: e, reason: collision with root package name */
    public final Map<Integer, LongRequestInfo> f406675e = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public OkHttpClient f406671a = new OkHttpClient.Builder().addInterceptor(new Interceptor() { // from class: p15.d
        @Override // okhttp3.Interceptor
        public final Response intercept(Interceptor.Chain chain) {
            Response proceed;
            proceed = chain.proceed(chain.request().newBuilder().removeHeader("Sec-WebSocket-Extensions").build());
            return proceed;
        }
    }).build();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            m.this.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LongRequest f406681a;

        public c(LongRequest longRequest) {
            this.f406681a = longRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            hynb.p.g.f406799a.debug("HuyaWebSocketClient", "sendHeartbeat :" + this.f406681a.toJsonString());
            m.this.f406672b.send(this.f406681a.toJsonString());
        }
    }

    public m(String str) {
        this.f406674d = null;
        this.f406676f = str;
        this.f406674d = ProxyExecutors.newScheduledThreadPool(4);
    }

    public final void c() {
        this.f406677g = new a();
    }

    public final void d() {
        this.f406674d.scheduleAtFixedRate(new c(new LongRequest.Builder().iCmdType(20).sData("").build()), 0L, 60L, TimeUnit.SECONDS);
    }

    public final void e() {
        if (!this.f406675e.keySet().isEmpty()) {
            for (Integer num : this.f406675e.keySet()) {
                LongRequestInfo longRequestInfo = this.f406675e.get(num);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - longRequestInfo.start_send_time >= 20000) {
                    int i3 = longRequestInfo.retryCount + 1;
                    longRequestInfo.retryCount = i3;
                    if (i3 < 3) {
                        longRequestInfo.start_send_time = currentTimeMillis;
                        b(longRequestInfo.longRequest);
                    } else {
                        this.f406675e.remove(num);
                        a(longRequestInfo.longRequest);
                    }
                }
            }
            StringBuilder sb5 = new StringBuilder();
            Iterator<Integer> it = this.f406675e.keySet().iterator();
            while (it.hasNext()) {
                LongRequestInfo longRequestInfo2 = this.f406675e.get(it.next());
                sb5.append("--- lRequestId:");
                sb5.append(longRequestInfo2.longRequest.getLRequestId());
                sb5.append(",retryCount:");
                sb5.append(longRequestInfo2.retryCount);
                sb5.append(",start_send_time:");
                sb5.append(longRequestInfo2.start_send_time);
            }
            hynb.p.g.f406799a.debug("HuyaWebSocketClient", "startLoopTask mLongRequestMap " + sb5.toString());
        }
        hynb.p.g.f406799a.debug("HuyaWebSocketClient", "startLoopTask ,newWebSocket:" + this.f406672b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        this.f406672b.send(str);
    }

    public void b() {
        WebSocket webSocket = this.f406672b;
        if (webSocket != null) {
            webSocket.close(1000, "closeConnect");
        }
    }

    public final String b(String str) {
        String str2;
        byte[] b16;
        try {
            b16 = hynb.q.a.b(null, d.a(), str.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e16) {
            hynb.p.g.f406799a.error("HuyaWebSocketClient", String.format("encrypt error. json str: %s, e: %s", str, e16.getMessage()));
            str2 = "";
        }
        if (b16 == null) {
            return str;
        }
        str2 = hynb.o.a.b(b16);
        hynb.p.g.f406799a.a("HuyaWebSocketClient", String.format("encrypt message: %s, req json : %s, ", str2, str));
        return str2;
    }

    public void b(LongRequest longRequest) {
        if (longRequest.getIEncryptType() == 1) {
            longRequest.setSData(b(longRequest.getSData()));
        }
        StringBuilder sb5 = new StringBuilder();
        if (longRequest.getLRequestId() > 0 && !this.f406675e.containsKey(Integer.valueOf(longRequest.getLRequestId()))) {
            this.f406675e.put(Integer.valueOf(longRequest.getLRequestId()), new LongRequestInfo(longRequest, System.currentTimeMillis()));
        }
        LongRequestInfo longRequestInfo = this.f406675e.get(Integer.valueOf(longRequest.getLRequestId()));
        if (longRequestInfo != null) {
            sb5.append("retryCount=");
            sb5.append(longRequestInfo.retryCount);
            sb5.append(",start_send_time=");
            sb5.append(longRequestInfo.start_send_time);
        }
        final String jsonString = longRequest.toJsonString();
        hynb.p.g.f406799a.a("HuyaWebSocketClient", "sendLongRequest :" + jsonString + ", longRequestInfo:" + sb5.toString());
        if (this.f406672b != null) {
            this.f406674d.execute(new Runnable() { // from class: p15.c
                @Override // java.lang.Runnable
                public final void run() {
                    m.this.c(jsonString);
                }
            });
        }
    }

    public final void a(LongRequest longRequest) {
        e eVar;
        hynb.p.g.f406799a.a("HuyaWebSocketClient", "runOnTimeout LongRequest:" + longRequest.toJsonString());
        int iCmdType = longRequest.getICmdType();
        if (iCmdType != 16) {
            if (iCmdType == 18 && (eVar = this.f406673c) != null) {
                eVar.a(longRequest.getLRequestId());
                return;
            }
            return;
        }
        e eVar2 = this.f406673c;
        if (eVar2 != null) {
            eVar2.c(longRequest.getLRequestId());
        }
    }

    public final synchronized void a() {
        Timer timer = this.f406678h;
        if (timer != null) {
            timer.cancel();
            this.f406678h = null;
        }
    }

    public final synchronized void a(long j3, long j16) {
        if (this.f406678h == null) {
            this.f406678h = new BaseTimer("HuyaWebSocketClient");
        }
        c();
        this.f406678h.schedule(this.f406677g, j3, j16);
    }

    public void a(String str, e eVar) {
        hynb.p.g.f406799a.debug("HuyaWebSocketClient", "startConnect");
        final Request build = new Request.Builder().url(str).build();
        this.f406673c = eVar;
        final b bVar = new b();
        this.f406674d.execute(new Runnable() { // from class: p15.b
            @Override // java.lang.Runnable
            public final void run() {
                m.this.a(build, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Request request, WebSocketListener webSocketListener) {
        this.f406672b = this.f406671a.newWebSocket(request, webSocketListener);
        hynb.p.g.f406799a.a("HuyaWebSocketClient", "request:" + this.f406672b.request() + ",newWebSocket:" + this.f406672b);
    }

    public final String a(String str) {
        byte[] a16;
        String str2 = "";
        if (str == null) {
            return "";
        }
        try {
            a16 = hynb.q.a.a(null, d.a(), hynb.o.a.a(str));
        } catch (UnsupportedEncodingException e16) {
            hynb.p.g.f406799a.error("HuyaWebSocketClient", String.format("decrypt error. rsp str: %s, e: %s", str, e16.getMessage()));
        }
        if (a16 == null) {
            return "";
        }
        str2 = new String(a16, "utf-8");
        hynb.p.g.f406799a.a("HuyaWebSocketClient", String.format(" decrypt message: %s, rsp str: %s", str2, str));
        return str2;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b extends WebSocketListener {
        public b() {
        }

        @Override // okhttp3.WebSocketListener
        public void onClosed(@NonNull WebSocket webSocket, int i3, @NonNull String str) {
            super.onClosed(webSocket, i3, str);
            hynb.p.g.f406799a.a("HuyaWebSocketClient", "onClosed code: " + i3 + ",reason:" + str + ",newWebSocket:" + webSocket);
            if (m.this.f406673c != null) {
                m.this.f406673c.a(m.this.f406676f);
            }
            m.this.a();
        }

        @Override // okhttp3.WebSocketListener
        public void onClosing(WebSocket webSocket, int i3, String str) {
            super.onClosing(webSocket, i3, str);
            hynb.p.g.f406799a.a("HuyaWebSocketClient", "onClosing reason: " + str + ",newWebSocket:" + webSocket);
        }

        @Override // okhttp3.WebSocketListener
        public void onFailure(@NonNull WebSocket webSocket, Throwable th5, Response response) {
            super.onFailure(webSocket, th5, response);
            hynb.p.g.f406799a.error("HuyaWebSocketClient", "onFailure response: " + response + ",Throwable:" + th5.getCause() + ",newWebSocket:" + webSocket);
            if (m.this.f406673c != null) {
                if (response != null) {
                    m.this.f406673c.a(response.message(), m.this.f406676f);
                } else {
                    m.this.f406673c.a((String) null, m.this.f406676f);
                }
            }
            m.this.a();
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket webSocket, String str) {
            WSHistoryMsgRsp wSHistoryMsgRsp;
            ArrayList<HYNSPushMessageItems> arrayList;
            List<WSPushMessage> list;
            super.onMessage(webSocket, str);
            hynb.p.e eVar = hynb.p.g.f406799a;
            eVar.a("HuyaWebSocketClient", "onMessage resJson: " + str);
            Gson gson = new Gson();
            try {
                BaseLongResponse baseLongResponse = (BaseLongResponse) gson.fromJson(str, BaseLongResponse.class);
                if (m.this.f406675e.containsKey(baseLongResponse.lRequestId)) {
                    m.this.f406675e.remove(baseLongResponse.lRequestId);
                }
                String str2 = baseLongResponse.sData;
                if (baseLongResponse.iEncryptType.intValue() == 1) {
                    str2 = m.this.a(baseLongResponse.sData);
                }
                eVar.a("HuyaWebSocketClient", "onMessage sData: " + str2 + ", traceId: " + baseLongResponse.traceId + "iCmdType: " + baseLongResponse.iCmdType);
                if (baseLongResponse.iCmdType.intValue() == 21) {
                    eVar.debug("HuyaWebSocketClient", "onMessage is heartbeat ");
                    return;
                }
                try {
                    JsonObject jsonObject = (JsonObject) gson.fromJson(str2, JsonObject.class);
                    if (m.this.f406673c != null) {
                        m.this.f406673c.b(str2);
                    }
                    if (baseLongResponse.iCmdType.intValue() == 17) {
                        int asInt = jsonObject.get("iResCode").getAsInt();
                        eVar.a("HuyaWebSocketClient", "iResCode: " + asInt);
                        if (m.this.f406673c != null) {
                            if (asInt == 0) {
                                m.this.f406673c.d(baseLongResponse.lRequestId.intValue());
                                return;
                            } else {
                                m.this.f406673c.c(baseLongResponse.lRequestId.intValue());
                                return;
                            }
                        }
                        return;
                    }
                    if (baseLongResponse.iCmdType.intValue() == 19) {
                        int asInt2 = jsonObject.get("iResCode").getAsInt();
                        eVar.a("HuyaWebSocketClient", "iResCode: " + asInt2);
                        if (m.this.f406673c != null) {
                            if (asInt2 == 0) {
                                m.this.f406673c.b(baseLongResponse.lRequestId.intValue());
                                return;
                            } else {
                                m.this.f406673c.a(baseLongResponse.lRequestId.intValue());
                                return;
                            }
                        }
                        return;
                    }
                    if (baseLongResponse.iCmdType.intValue() == 22) {
                        if (m.this.f406673c == null || (list = ((HYNSPushMessageItems) gson.fromJson(str2, HYNSPushMessageItems.class)).vMsgItem) == null) {
                            return;
                        }
                        for (WSPushMessage wSPushMessage : list) {
                            hynb.p.g.f406799a.info("HuyaWebSocketClient", "onMessage()  msgItem = [" + wSPushMessage + "]");
                            m.this.f406673c.a(wSPushMessage);
                        }
                        return;
                    }
                    if (baseLongResponse.iCmdType.intValue() == 13) {
                        if (m.this.f406673c != null && ((WSVerifyHuyaTokenRsp) gson.fromJson(str2, WSVerifyHuyaTokenRsp.class)).iValidate.intValue() == 0) {
                            m.this.f406673c.a();
                        }
                        eVar.a("HuyaWebSocketClient", "verify back: " + str2);
                        return;
                    }
                    if (baseLongResponse.iCmdType.intValue() == 15) {
                        eVar.a("HuyaWebSocketClient", "unVerify back: " + str2);
                        return;
                    }
                    if (baseLongResponse.iCmdType.intValue() != 26 || (arrayList = (wSHistoryMsgRsp = (WSHistoryMsgRsp) gson.fromJson(str2, WSHistoryMsgRsp.class)).vMsg) == null) {
                        return;
                    }
                    Iterator<HYNSPushMessageItems> it = arrayList.iterator();
                    while (it.hasNext()) {
                        List<WSPushMessage> list2 = it.next().vMsgItem;
                        if (list2 != null) {
                            for (WSPushMessage wSPushMessage2 : list2) {
                                hynb.p.g.f406799a.a("HuyaWebSocketClient", "requestHistory()  msgItem = [" + wSPushMessage2 + "]");
                                m.this.f406673c.a(wSPushMessage2);
                            }
                        }
                    }
                    hynb.p.g.f406799a.info("HuyaWebSocketClient", "requestHistory back: " + wSHistoryMsgRsp.vMsg.size());
                } catch (Exception e16) {
                    if (webSocket != null) {
                        webSocket.close(1000, "onMessage Error");
                    }
                    hynb.p.g.f406799a.error("HuyaWebSocketClient", "onMessage Error: " + e16.getMessage() + ",newWebSocket:" + webSocket);
                    if (m.this.f406673c != null) {
                        m.this.f406673c.a("onMessage Error: " + e16.getMessage(), m.this.f406676f);
                    }
                }
            } catch (Throwable th5) {
                hynb.p.g.f406799a.a("HuyaWebSocketClient", "onMessage error: ", th5);
            }
        }

        @Override // okhttp3.WebSocketListener
        public void onOpen(@NonNull WebSocket webSocket, @NonNull Response response) {
            super.onOpen(webSocket, response);
            if (m.this.f406673c != null) {
                e eVar = m.this.f406673c;
                m mVar = m.this;
                eVar.a(mVar, mVar.f406676f);
            }
            m.this.d();
            m.this.a(1000L, 1000L);
            hynb.p.g.f406799a.a("HuyaWebSocketClient", "onOpen responseBody: " + response.body());
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(@NonNull WebSocket webSocket, @NonNull ByteString byteString) {
            super.onMessage(webSocket, byteString);
            hynb.p.g.f406799a.a("HuyaWebSocketClient", "onMessage bytes str:" + byteString.toString() + ",newWebSocket:" + webSocket);
        }
    }
}
