package com.tencent.luggage.wxa.yi;

import com.tencent.luggage.wxa.fl.d;
import com.tencent.luggage.wxa.kh.d;
import com.tencent.luggage.wxa.kh.e;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.uk.d0;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class r implements com.tencent.luggage.wxa.kh.d, i {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f145941b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public SSLSocketFactory f145942c;

    /* renamed from: d, reason: collision with root package name */
    public int f145943d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f145944e;

    /* renamed from: f, reason: collision with root package name */
    public final String f145945f;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends com.tencent.luggage.wxa.kh.c {
        public com.tencent.luggage.wxa.fl.d F;
        public final /* synthetic */ String G;
        public final /* synthetic */ String H;
        public final /* synthetic */ d.a I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(URI uri, com.tencent.luggage.wxa.dl.a aVar, Map map, int i3, String str, String str2, d.a aVar2) {
            super(uri, aVar, map, i3);
            this.G = str;
            this.H = str2;
            this.I = aVar2;
            this.F = null;
        }

        @Override // com.tencent.luggage.wxa.kh.e
        public void a(e.a aVar) {
        }

        @Override // com.tencent.luggage.wxa.cl.a
        public void b(String str) {
            Object[] objArr = new Object[3];
            objArr[0] = this.G;
            objArr[1] = Integer.valueOf(str != null ? str.length() : -1);
            objArr[2] = this.H;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,socket onmessage length :%d, taskId=%s", objArr);
            this.I.a(str);
        }

        @Override // com.tencent.luggage.wxa.cl.a
        public void a(com.tencent.luggage.wxa.gl.h hVar) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: opened, taskId=%s", this.G, this.H);
            r.this.f(this);
            this.I.a(hVar, (Map) null);
        }

        @Override // com.tencent.luggage.wxa.cl.a
        public void b(Exception exc) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkWebSocket", exc, "onError Exception: url %s, taskId=%s", this.G, this.H);
            r.this.f(this);
            r.this.e(this);
            this.I.b("exception " + exc.getMessage());
        }

        @Override // com.tencent.luggage.wxa.bl.b, com.tencent.luggage.wxa.bl.d
        public void a(com.tencent.luggage.wxa.bl.a aVar, com.tencent.luggage.wxa.gl.a aVar2) {
            this.I.a(aVar2);
        }

        @Override // com.tencent.luggage.wxa.cl.a
        public void a(int i3, String str, boolean z16) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: closed ,reason: %s, errCode = %d, taskId=%s", this.G, str, Integer.valueOf(i3), this.H);
            r.this.f(this);
            r.this.e(this);
            if (i3 != -1 && i3 != -2 && i3 != -3) {
                this.I.a(i3, str);
                return;
            }
            if (!h0.j(com.tencent.luggage.wxa.tn.z.c())) {
                this.I.b("network is down");
            } else {
                this.I.b(w0.c(str) ? "abnormal closure" : str);
            }
            this.I.a(1006, str);
        }

        @Override // com.tencent.luggage.wxa.cl.a
        public void b(ByteBuffer byteBuffer) {
            Object[] objArr = new Object[3];
            objArr[0] = this.G;
            objArr[1] = Integer.valueOf(byteBuffer != null ? byteBuffer.capacity() : -1);
            objArr[2] = this.H;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkWebSocket", "url is %s , socket onMessage buffer length : %d, taskId=%s", objArr);
            this.I.a(byteBuffer);
        }

        @Override // com.tencent.luggage.wxa.cl.a
        public void b(com.tencent.luggage.wxa.fl.d dVar) {
            com.tencent.luggage.wxa.fl.d dVar2;
            d.a c16 = dVar.c();
            d.a aVar = d.a.CONTINUOUS;
            if (c16 != aVar && !dVar.d()) {
                this.F = dVar;
                return;
            }
            if (dVar.c() != aVar || (dVar2 = this.F) == null) {
                return;
            }
            if (dVar2.f().position() > 10485760) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkWebSocket", "Pending Frame exploded");
                this.F = null;
                return;
            }
            try {
                this.F.a(dVar);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkWebSocket", e16, "Exception: Framedata append fail", new Object[0]);
            }
            if (dVar.d()) {
                if (this.F.c() == d.a.BINARY) {
                    b(this.F.f());
                } else if (this.F.c() == d.a.TEXT) {
                    try {
                        b(w0.d(com.tencent.luggage.wxa.hl.b.a(this.F.f())));
                    } catch (Exception e17) {
                        com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkWebSocket", e17, "Exception: stringUtf8 error", new Object[0]);
                    }
                }
                this.F = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kh.e f145946a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.a f145947b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Timer f145948c;

        public b(com.tencent.luggage.wxa.kh.e eVar, d.a aVar, Timer timer) {
            this.f145946a = eVar;
            this.f145947b = aVar;
            this.f145948c = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
            this.f145946a.close();
            r.this.e(this.f145946a);
            this.f145947b.b("connect response time out");
            cancel();
            this.f145948c.cancel();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.kh.e f145950a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.a f145951b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Timer f145952c;

        public c(com.tencent.luggage.wxa.kh.e eVar, d.a aVar, Timer timer) {
            this.f145950a = eVar;
            this.f145951b = aVar;
            this.f145952c = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
            this.f145950a.close();
            r.this.e(this.f145950a);
            this.f145951b.b("connect response time out");
            cancel();
            this.f145952c.cancel();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface d {
        void a(com.tencent.luggage.wxa.xd.d dVar, String str, com.tencent.luggage.wxa.nf.f fVar);

        void b(com.tencent.luggage.wxa.xd.d dVar, String str, com.tencent.luggage.wxa.nf.f fVar);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {
        void a(int i3, String str);

        void a(com.tencent.luggage.wxa.gl.h hVar);

        void a(String str);

        void a(ByteBuffer byteBuffer);

        void b(String str);

        void c(String str);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface f {
        boolean a(String str);

        boolean b(String str);
    }

    public r(com.tencent.luggage.wxa.yi.a aVar) {
        SSLContext a16 = q.a(aVar);
        if (a16 != null) {
            this.f145942c = a16.getSocketFactory();
        }
        this.f145945f = aVar.K;
        this.f145943d = aVar.f145798h;
        boolean z16 = aVar.P;
        this.f145944e = z16;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkWebSocket", "mTLSSkipHostnameCheck is %b", Boolean.valueOf(z16));
    }

    public final void c(com.tencent.luggage.wxa.kh.e eVar) {
        if (eVar == null) {
            return;
        }
        synchronized (this.f145941b) {
            if ("0".equals(eVar.b())) {
                this.f145941b.clear();
            }
            this.f145941b.add(eVar);
        }
    }

    public void d(com.tencent.luggage.wxa.kh.e eVar) {
        a(eVar);
    }

    public final synchronized void e(com.tencent.luggage.wxa.kh.e eVar) {
        if (eVar == null) {
            return;
        }
        synchronized (this.f145941b) {
            this.f145941b.remove(eVar);
        }
    }

    public final void f(com.tencent.luggage.wxa.kh.e eVar) {
        if (eVar == null) {
            return;
        }
        Timer d16 = eVar.d();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkWebSocket", "try to stop connectTimer");
        if (d16 != null) {
            d16.cancel();
            eVar.a((Timer) null);
        }
    }

    @Override // com.tencent.luggage.wxa.kh.d
    public void release() {
        d(a("0"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8 */
    @Override // com.tencent.luggage.wxa.kh.d
    public void a(String str, String str2, int i3, int i16, JSONObject jSONObject, Map map, d.a aVar) {
        String str3;
        int i17;
        String str4;
        int i18;
        SSLSocket sSLSocket;
        String[] supportedCipherSuites;
        synchronized (this.f145941b) {
            if (this.f145941b.size() >= this.f145943d) {
                aVar.c("max connected");
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkWebSocket", "max connected mTaskList.size():%d,mMaxWebsocketConnect:%d", Integer.valueOf(this.f145941b.size()), Integer.valueOf(this.f145943d));
                return;
            }
            String optString = jSONObject.optString("url");
            try {
                URI uri = new URI(optString);
                boolean optBoolean = jSONObject.optBoolean("tcpNoDelay", false);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkWebSocket", "connectSocket, url= %s, timeout = %d, tcpNoDelay = %b, taskId=%s", optString, Integer.valueOf(i16), Boolean.valueOf(optBoolean), str2);
                map.put("User-Agent", this.f145945f);
                String c16 = q.c(jSONObject);
                if (!w0.c(c16)) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkWebSocket", "protocols %s", c16);
                    map.put("Sec-WebSocket-Protocol", c16);
                }
                String a16 = q.a(uri);
                if (!w0.c(a16)) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkWebSocket", "Origin %s", a16);
                    map.put("Origin", a16);
                }
                try {
                    try {
                        a aVar2 = new a(uri, new com.tencent.luggage.wxa.dl.d(), map, i16, optString, str2, aVar);
                        aVar2.a(str2);
                        aVar2.b(optBoolean);
                        try {
                            if (d0.a(optString, "ws://")) {
                                i18 = 1;
                                try {
                                    Object[] objArr = new Object[1];
                                    objArr[0] = optString;
                                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user ws connect", objArr);
                                    aVar2.a(new Socket(Proxy.NO_PROXY));
                                    aVar2.a();
                                    c(aVar2);
                                    BaseTimer baseTimer = new BaseTimer("AppNetSocket");
                                    b bVar = new b(aVar2, aVar, baseTimer);
                                    aVar2.a(baseTimer);
                                    baseTimer.schedule(bVar, i16);
                                    return;
                                } catch (Exception e16) {
                                    e = e16;
                                    str4 = optString;
                                }
                            } else {
                                str4 = optString;
                                if (d0.a(str4, "wss://")) {
                                    try {
                                        Object[] objArr2 = new Object[1];
                                        objArr2[0] = str4;
                                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user wss connect", objArr2);
                                        SSLSocketFactory sSLSocketFactory = this.f145942c;
                                        if (sSLSocketFactory == null) {
                                            sSLSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                                        }
                                        aVar2.a(sSLSocketFactory.createSocket());
                                        if ((str.equals("wx577c74fb940daaea") || str.equals("wx850d691fd02de8a1")) && (supportedCipherSuites = (sSLSocket = (SSLSocket) aVar2.c()).getSupportedCipherSuites()) != null) {
                                            sSLSocket.setEnabledCipherSuites(supportedCipherSuites);
                                        }
                                        aVar2.a();
                                        c(aVar2);
                                        BaseTimer baseTimer2 = new BaseTimer("AppTestSocket");
                                        c cVar = new c(aVar2, aVar, baseTimer2);
                                        aVar2.a(baseTimer2);
                                        baseTimer2.schedule(cVar, i16);
                                        return;
                                    } catch (Exception e17) {
                                        e = e17;
                                        i17 = 1;
                                        str3 = str4;
                                    }
                                } else {
                                    i18 = 1;
                                    try {
                                        Object[] objArr3 = new Object[1];
                                        objArr3[0] = str4;
                                        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkWebSocket", "url error: %s not ws:// or wss://", objArr3);
                                        aVar.c("url not ws or wss");
                                        return;
                                    } catch (Exception e18) {
                                        e = e18;
                                    }
                                }
                            }
                            i17 = i18;
                            str3 = str4;
                        } catch (Exception e19) {
                            e = e19;
                            i17 = 1;
                            str3 = uri;
                            Object[] objArr4 = new Object[i17];
                            objArr4[0] = str3;
                            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkWebSocket", e, "Exception: url %s", objArr4);
                            aVar.b(e.getMessage());
                        }
                    } catch (Exception e26) {
                        e = e26;
                        uri = optString;
                    }
                } catch (Exception e27) {
                    e = e27;
                    str3 = optString;
                    i17 = 1;
                }
                Object[] objArr42 = new Object[i17];
                objArr42[0] = str3;
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkWebSocket", e, "Exception: url %s", objArr42);
                aVar.b(e.getMessage());
            } catch (Exception e28) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkWebSocket", e28, "Exception: connect fail", new Object[0]);
                aVar.c("url not well format");
            }
        }
    }

    @Override // com.tencent.luggage.wxa.kh.d
    public boolean b(com.tencent.luggage.wxa.kh.e eVar) {
        if (eVar != null) {
            return eVar.isOpen();
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.kh.d
    public void a(com.tencent.luggage.wxa.kh.e eVar) {
        if (eVar != null) {
            try {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
                eVar.close();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkWebSocket", e16, "Exception: send error", new Object[0]);
                f(eVar);
            }
            e(eVar);
        }
    }

    @Override // com.tencent.luggage.wxa.kh.d
    public void a(com.tencent.luggage.wxa.kh.e eVar, int i3, String str) {
        if (eVar != null) {
            try {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
                eVar.a(str, i3);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandNetworkWebSocket", e16, "Exception: send error", new Object[0]);
            }
            e(eVar);
        }
    }

    @Override // com.tencent.luggage.wxa.kh.d
    public void a(com.tencent.luggage.wxa.kh.e eVar, String str) {
        if (eVar != null) {
            eVar.send(str);
        }
    }

    @Override // com.tencent.luggage.wxa.kh.d
    public void a(com.tencent.luggage.wxa.kh.e eVar, ByteBuffer byteBuffer) {
        eVar.a(byteBuffer);
    }

    @Override // com.tencent.luggage.wxa.kh.d
    public com.tencent.luggage.wxa.kh.e a(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.f145941b) {
            Iterator it = this.f145941b.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.kh.e eVar = (com.tencent.luggage.wxa.kh.e) it.next();
                if (str.equals(eVar.b())) {
                    return eVar;
                }
            }
            return null;
        }
    }
}
