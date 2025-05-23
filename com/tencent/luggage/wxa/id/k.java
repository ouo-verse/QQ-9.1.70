package com.tencent.luggage.wxa.id;

import android.util.Log;
import com.tencent.luggage.wxa.fl.d;
import com.tencent.luggage.wxa.h6.o;
import com.tencent.luggage.wxa.hn.hc;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.yi.q;
import com.tencent.luggage.wxa.yi.r;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.cl.a f130084a;

    /* renamed from: b, reason: collision with root package name */
    public SSLSocketFactory f130085b;

    public k(com.tencent.luggage.wxa.yi.a aVar) {
        SSLContext a16 = q.a(aVar);
        if (a16 != null) {
            this.f130085b = a16.getSocketFactory();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends com.tencent.luggage.wxa.cl.a {
        public com.tencent.luggage.wxa.fl.d F;
        public final /* synthetic */ r.e G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(URI uri, com.tencent.luggage.wxa.dl.a aVar, Map map, int i3, r.e eVar) {
            super(uri, aVar, map, i3);
            this.G = eVar;
            this.F = null;
        }

        @Override // com.tencent.luggage.wxa.cl.a
        public void a(com.tencent.luggage.wxa.gl.h hVar) {
            w.a("MicroMsg.RemoteDebugSocket", "onSocketOpen");
            this.G.a(hVar);
        }

        @Override // com.tencent.luggage.wxa.cl.a
        public void b(String str) {
            k.this.f130084a.send(str);
            w.a("MicroMsg.RemoteDebugSocket", "onSocketMessage, message: %s", str);
            this.G.a(str);
        }

        @Override // com.tencent.luggage.wxa.cl.a
        public void a(int i3, String str, boolean z16) {
            w.d("MicroMsg.RemoteDebugSocket", "onClose,reason: %s, errCode = %d", str, Integer.valueOf(i3));
            if (i3 != -1 && i3 != -2 && i3 != -3) {
                this.G.a(i3, str);
                return;
            }
            if (!h0.j(z.c())) {
                this.G.b("network is down");
                i3 = 1006;
            } else {
                this.G.b(str);
            }
            this.G.a(i3, str);
        }

        @Override // com.tencent.luggage.wxa.cl.a
        public void b(Exception exc) {
            w.b("MicroMsg.RemoteDebugSocket", "onSocketError, ex: " + exc.toString());
        }

        @Override // com.tencent.luggage.wxa.cl.a
        public void b(ByteBuffer byteBuffer) {
            this.G.a(byteBuffer);
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
                w.b("MicroMsg.RemoteDebugSocket", "Pending Frame exploded");
                this.F = null;
                return;
            }
            try {
                this.F.a(dVar);
            } catch (Exception e16) {
                w.b("MicroMsg.RemoteDebugSocket", e16.getMessage());
            }
            if (dVar.d()) {
                if (this.F.c() == d.a.BINARY) {
                    b(this.F.f());
                } else if (this.F.c() == d.a.TEXT) {
                    try {
                        b(w0.d(com.tencent.luggage.wxa.hl.b.a(this.F.f())));
                    } catch (Exception e17) {
                        w.b("MicroMsg.RemoteDebugSocket", e17.getMessage());
                    }
                }
                this.F = null;
            }
        }
    }

    public void a(String str, r.e eVar) {
        w.d("MicroMsg.RemoteDebugSocket", "connectSocket url is %s", str);
        try {
            URI uri = new URI(str);
            HashMap hashMap = new HashMap();
            if (str.startsWith("ws://localhost:")) {
                hashMap.put("Sec-WebSocket-Protocol", "client");
            }
            try {
                this.f130084a = new a(uri, new com.tencent.luggage.wxa.dl.d(), hashMap, 60000, eVar);
                if (o.a(str, "ws://")) {
                    this.f130084a.a(new Socket(Proxy.NO_PROXY));
                    this.f130084a.a();
                    return;
                }
                SSLSocketFactory sSLSocketFactory = this.f130085b;
                if (sSLSocketFactory == null) {
                    sSLSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                }
                this.f130084a.a(sSLSocketFactory.createSocket());
                this.f130084a.a();
            } catch (Exception e16) {
                w.b("MicroMsg.RemoteDebugSocket", "onSocketMessage %s", Log.getStackTraceString(e16));
            }
        } catch (Exception e17) {
            w.b("MicroMsg.RemoteDebugSocket", "connect fail : %s ", e17.toString());
            eVar.c("url not well format");
        }
    }

    public boolean a() {
        com.tencent.luggage.wxa.cl.a aVar = this.f130084a;
        if (aVar == null) {
            return false;
        }
        return aVar.isOpen();
    }

    public boolean a(hc hcVar) {
        w.a("MicroMsg.RemoteDebugSocket", "sendSocketMsg");
        if (!a()) {
            w.f("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail, not open");
            return false;
        }
        if (hcVar == null) {
            w.f("MicroMsg.RemoteDebugSocket", "sendSocketMsg fail");
            return false;
        }
        this.f130084a.a(l.a(hcVar));
        return true;
    }

    public boolean a(int i3, String str) {
        com.tencent.luggage.wxa.cl.a aVar = this.f130084a;
        if (aVar == null) {
            w.f("MicroMsg.RemoteDebugSocket", "client is null");
            return false;
        }
        aVar.a(i3, str);
        w.a("MicroMsg.RemoteDebugSocket", "closeSocket code %d, reason %s", Integer.valueOf(i3), str);
        return true;
    }
}
