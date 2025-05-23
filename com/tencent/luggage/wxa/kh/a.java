package com.tencent.luggage.wxa.kh;

import com.tencent.luggage.wxa.gl.h;
import com.tencent.luggage.wxa.kh.d;
import com.tencent.luggage.wxa.kh.e;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uk.d0;
import com.tencent.luggage.wxa.yi.q;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.websocket.WssConfig;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements d {

    /* renamed from: b, reason: collision with root package name */
    public final String f131983b;

    /* renamed from: c, reason: collision with root package name */
    public int f131984c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.yi.a f131985d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f131991a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.a f131992b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Timer f131993c;

        public b(e eVar, d.a aVar, Timer timer) {
            this.f131991a = eVar;
            this.f131992b = aVar;
            this.f131993c = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            w.b("MicroMsg.AppBrandNetworkWcWssSocket", "connect response time out taskid:%s", this.f131991a.b());
            this.f131992b.b("connect response time out");
            this.f131991a.close();
            a.this.e(this.f131991a);
            cancel();
            this.f131993c.cancel();
        }
    }

    public a(com.tencent.luggage.wxa.yi.a aVar) {
        this.f131983b = aVar.K;
        this.f131984c = aVar.f145798h;
        this.f131985d = aVar;
    }

    public final void c(e eVar) {
        if (eVar == null) {
            return;
        }
        ArrayList arrayList = d.f132015a;
        synchronized (arrayList) {
            if ("0".equals(eVar.b())) {
                arrayList.clear();
            }
            arrayList.add(eVar);
        }
    }

    public void d(e eVar) {
        a(eVar);
    }

    public final synchronized void e(e eVar) {
        if (eVar == null) {
            return;
        }
        ArrayList arrayList = d.f132015a;
        synchronized (arrayList) {
            arrayList.remove(eVar);
        }
    }

    public final void f(e eVar) {
        if (eVar == null) {
            return;
        }
        Timer d16 = eVar.d();
        w.d("MicroMsg.AppBrandNetworkWcWssSocket", "try to stop connectTimer");
        if (d16 != null) {
            d16.cancel();
            eVar.a((Timer) null);
        }
    }

    @Override // com.tencent.luggage.wxa.kh.d
    public void release() {
        d(a("0"));
    }

    @Override // com.tencent.luggage.wxa.kh.d
    public void a(String str, String str2, int i3, int i16, JSONObject jSONObject, Map map, d.a aVar) {
        String str3;
        d.a aVar2;
        char c16;
        int i17;
        ArrayList arrayList = d.f132015a;
        synchronized (arrayList) {
            if (arrayList.size() >= this.f131984c) {
                aVar.c("max connected");
                w.d("MicroMsg.AppBrandNetworkWcWssSocket", "max connected mTaskList.size():%d,mMaxWebsocketConnect:%d", Integer.valueOf(arrayList.size()), Integer.valueOf(this.f131984c));
                return;
            }
            String optString = jSONObject.optString("url");
            try {
                URI uri = new URI(optString);
                boolean optBoolean = jSONObject.optBoolean("tcpNoDelay", false);
                boolean optBoolean2 = jSONObject.optBoolean("perMessageDeflate", false);
                map.put("User-Agent", this.f131983b);
                String c17 = q.c(jSONObject);
                if (!w0.c(c17)) {
                    w.d("MicroMsg.AppBrandNetworkWcWssSocket", "protocols %s", c17);
                    map.put("Sec-WebSocket-Protocol", c17);
                }
                String a16 = q.a(uri);
                if (!w0.c(a16)) {
                    w.d("MicroMsg.AppBrandNetworkWcWssSocket", "Origin %s", a16);
                    map.put("Origin", a16);
                }
                boolean a17 = d0.a(optString, "ws://");
                w.d("MicroMsg.AppBrandNetworkWcWssSocket", "connectSocket, taskId=%s, url= %s, appType = %d, timeout = %d, tcpNoDelay = %b, skipDimain = %b, perMessageDeflate = %b", str2, optString, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(optBoolean), Boolean.valueOf(a17), Boolean.valueOf(optBoolean2));
                try {
                    try {
                        com.tencent.luggage.wxa.kh.b bVar = new com.tencent.luggage.wxa.kh.b(str, optString, uri, map, new WssConfig(i16, i16, optBoolean, a17, i3, optBoolean2), new ArrayList(), this.f131985d);
                        i17 = 1;
                        c16 = 0;
                        str3 = optString;
                        aVar2 = aVar;
                        try {
                            bVar.a(new C6385a(str2, bVar, aVar, str3));
                            bVar.a(str2);
                            if (!d0.a(str3, "ws://") && !d0.a(str3, "wss://")) {
                                w.h("MicroMsg.AppBrandNetworkWcWssSocket", "url error: %s not ws:// or wss://", str3);
                                aVar2.c("url not ws or wss");
                            }
                            BaseTimer baseTimer = new BaseTimer("AppWcSocket");
                            b bVar2 = new b(bVar, aVar2, baseTimer);
                            c(bVar);
                            bVar.a(baseTimer);
                            baseTimer.schedule(bVar2, i16);
                            bVar.a();
                        } catch (Exception e16) {
                            e = e16;
                            Object[] objArr = new Object[i17];
                            objArr[c16] = str3;
                            w.a("MicroMsg.AppBrandNetworkWcWssSocket", e, "Exception: url %s", objArr);
                            aVar2.b(e.getMessage());
                        }
                    } catch (Exception e17) {
                        e = e17;
                        i17 = 1;
                        c16 = 0;
                        str3 = optString;
                        aVar2 = aVar;
                    }
                } catch (Exception e18) {
                    e = e18;
                    str3 = optString;
                    aVar2 = aVar;
                    c16 = 0;
                    i17 = 1;
                }
            } catch (Exception e19) {
                w.a("MicroMsg.AppBrandNetworkWcWssSocket", e19, "connect fail Exception", new Object[0]);
                aVar.c("url not well format");
            }
        }
    }

    @Override // com.tencent.luggage.wxa.kh.d
    public boolean b(e eVar) {
        if (eVar != null) {
            return eVar.isOpen();
        }
        return false;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.kh.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6385a implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f131986a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f131987b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d.a f131988c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f131989d;

        public C6385a(String str, e eVar, d.a aVar, String str2) {
            this.f131986a = str;
            this.f131987b = eVar;
            this.f131988c = aVar;
            this.f131989d = str2;
        }

        @Override // com.tencent.luggage.wxa.kh.e.a
        public void a(h hVar, Map map) {
            w.d("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketOpen taskId=%s", this.f131986a);
            a.this.f(this.f131987b);
            this.f131988c.a(hVar, map);
        }

        @Override // com.tencent.luggage.wxa.kh.e.a
        public void b(String str) {
            w.b("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketError url is %s ,error is %s,taskId=%s", this.f131989d, str, this.f131986a);
            a.this.f(this.f131987b);
            a.this.e(this.f131987b);
            this.f131988c.b("exception " + str);
        }

        @Override // com.tencent.luggage.wxa.kh.e.a
        public void a(com.tencent.luggage.wxa.gl.a aVar) {
            w.d("MicroMsg.AppBrandNetworkWcWssSocket", "onWebsocketHandshakeSentAsClient");
            this.f131988c.a(aVar);
        }

        @Override // com.tencent.luggage.wxa.kh.e.a
        public void a(String str) {
            Object[] objArr = new Object[3];
            objArr[0] = this.f131989d;
            objArr[1] = Integer.valueOf(str != null ? str.length() : -1);
            objArr[2] = this.f131986a;
            w.a("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketMessage url is %s ,socket onmessage length :%d,taskId=%s", objArr);
            this.f131988c.a(str);
        }

        @Override // com.tencent.luggage.wxa.kh.e.a
        public void a(ByteBuffer byteBuffer) {
            Object[] objArr = new Object[3];
            objArr[0] = this.f131989d;
            objArr[1] = Integer.valueOf(byteBuffer != null ? byteBuffer.capacity() : -1);
            objArr[2] = this.f131986a;
            w.a("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketMessage url is %s , socket onMessage buffer length : %d,taskId=%s", objArr);
            this.f131988c.a(byteBuffer);
        }

        @Override // com.tencent.luggage.wxa.kh.e.a
        public void a(int i3, String str) {
            w.d("MicroMsg.AppBrandNetworkWcWssSocket", "onSocketClose url is %s ,state: closed ,reason: %s, errCode = %d,taskId=%s", this.f131989d, str, Integer.valueOf(i3), this.f131986a);
            a.this.f(this.f131987b);
            a.this.e(this.f131987b);
            if (i3 == -1) {
                if (!h0.j(z.c())) {
                    this.f131988c.b("network is down");
                } else {
                    this.f131988c.b(w0.c(str) ? "abnormal closure" : str);
                }
                this.f131988c.a(1006, str);
                return;
            }
            this.f131988c.a(i3, str);
        }
    }

    @Override // com.tencent.luggage.wxa.kh.d
    public void a(e eVar) {
        if (eVar != null) {
            try {
                w.d("MicroMsg.AppBrandNetworkWcWssSocket", "try to close socket");
                eVar.close();
            } catch (Exception e16) {
                w.a("MicroMsg.AppBrandNetworkWcWssSocket", e16, "send error Exception", new Object[0]);
                f(eVar);
            }
            e(eVar);
        }
    }

    @Override // com.tencent.luggage.wxa.kh.d
    public void a(e eVar, int i3, String str) {
        if (eVar != null) {
            try {
                w.d("MicroMsg.AppBrandNetworkWcWssSocket", "try to close socket code:%d,reason:%s", Integer.valueOf(i3), str);
                eVar.a(str, i3);
            } catch (Exception e16) {
                w.a("MicroMsg.AppBrandNetworkWcWssSocket", e16, "send error Exception", new Object[0]);
            }
            e(eVar);
        }
    }

    @Override // com.tencent.luggage.wxa.kh.d
    public void a(e eVar, String str) {
        if (eVar != null) {
            eVar.send(str);
        }
    }

    @Override // com.tencent.luggage.wxa.kh.d
    public void a(e eVar, ByteBuffer byteBuffer) {
        if (eVar != null) {
            eVar.a(byteBuffer);
        }
    }

    @Override // com.tencent.luggage.wxa.kh.d
    public e a(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = d.f132015a;
        synchronized (arrayList) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (str.equals(eVar.b())) {
                    return eVar;
                }
            }
            return null;
        }
    }
}
