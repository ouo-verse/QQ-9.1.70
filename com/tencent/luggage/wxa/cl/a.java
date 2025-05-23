package com.tencent.luggage.wxa.cl;

import com.tencent.luggage.wxa.bl.c;
import com.tencent.luggage.wxa.gl.h;
import com.tencent.luggage.wxa.jq.d;
import com.tencent.luggage.wxa.jq.f;
import com.tencent.luggage.wxa.jq.g;
import com.tencent.luggage.wxa.tn.w;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends com.tencent.luggage.wxa.bl.b implements Runnable, d, f, com.tencent.luggage.wxa.bl.a {
    public String C;
    public Future E;

    /* renamed from: b, reason: collision with root package name */
    public URI f123695b;

    /* renamed from: c, reason: collision with root package name */
    public c f123696c;

    /* renamed from: e, reason: collision with root package name */
    public InputStream f123698e;

    /* renamed from: f, reason: collision with root package name */
    public OutputStream f123699f;

    /* renamed from: h, reason: collision with root package name */
    public Runnable f123701h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.dl.a f123702i;

    /* renamed from: j, reason: collision with root package name */
    public Map f123703j;

    /* renamed from: m, reason: collision with root package name */
    public int f123706m;

    /* renamed from: d, reason: collision with root package name */
    public Socket f123697d = null;

    /* renamed from: g, reason: collision with root package name */
    public Proxy f123700g = Proxy.NO_PROXY;

    /* renamed from: k, reason: collision with root package name */
    public CountDownLatch f123704k = new CountDownLatch(1);

    /* renamed from: l, reason: collision with root package name */
    public CountDownLatch f123705l = new CountDownLatch(1);
    public Timer D = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements g {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f123707a;

        public b() {
            this.f123707a = false;
        }

        public void b(boolean z16) {
            this.f123707a = z16;
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return "WebsocketWriteThread";
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer byteBuffer;
            while (!this.f123707a && !Thread.interrupted()) {
                try {
                    try {
                        try {
                            try {
                                if (a.this.f123696c.c() && (byteBuffer = (ByteBuffer) a.this.f123696c.f123042c.poll(1000L, TimeUnit.MILLISECONDS)) != null) {
                                    a.this.f123699f.write(byteBuffer.array(), 0, byteBuffer.limit());
                                    a.this.f123699f.flush();
                                }
                            } catch (IOException e16) {
                                a.this.a(e16);
                                w.a("MicroMsg.AppBrandNetWork.WebSocketClient", e16, "[WebsocketWriteThread] run IOException", new Object[0]);
                                w.f("MicroMsg.AppBrandNetWork.WebSocketClient", "[WebsocketWriteThread] closeSocket");
                                a.this.f123699f.close();
                            } catch (Exception e17) {
                                a.this.a(e17);
                                w.a("MicroMsg.AppBrandNetWork.WebSocketClient", e17, "[WebsocketWriteThread] run Exception", new Object[0]);
                                w.f("MicroMsg.AppBrandNetWork.WebSocketClient", "[WebsocketWriteThread] closeSocket");
                                a.this.f123699f.close();
                            }
                        } catch (Throwable th5) {
                            w.f("MicroMsg.AppBrandNetWork.WebSocketClient", "[WebsocketWriteThread] closeSocket");
                            try {
                                a.this.f123699f.close();
                            } catch (IOException unused) {
                            }
                            a.this.f();
                            throw th5;
                        }
                    } catch (IOException unused2) {
                    }
                } catch (InterruptedException unused3) {
                    for (ByteBuffer byteBuffer2 : a.this.f123696c.f123042c) {
                        a.this.f123699f.write(byteBuffer2.array(), 0, byteBuffer2.limit());
                        a.this.f123699f.flush();
                    }
                }
            }
            w.f("MicroMsg.AppBrandNetWork.WebSocketClient", "[WebsocketWriteThread] closeSocket");
            a.this.f123699f.close();
            a.this.f();
        }
    }

    public a(URI uri, com.tencent.luggage.wxa.dl.a aVar, Map map, int i3) {
        this.f123695b = null;
        this.f123696c = null;
        this.f123706m = 0;
        if (uri != null) {
            if (aVar != null) {
                this.f123695b = uri;
                this.f123702i = aVar;
                this.f123703j = map;
                this.f123706m = i3;
                this.f123696c = new c(this, aVar);
                b(false);
                return;
            }
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
        throw new IllegalArgumentException();
    }

    private int g() {
        int port = this.f123695b.getPort();
        if (port == -1) {
            String scheme = this.f123695b.getScheme();
            if (scheme.equals("wss")) {
                return WebSocketImpl.DEFAULT_WSS_PORT;
            }
            if (scheme.equals("ws")) {
                return 80;
            }
            throw new RuntimeException("unkonow scheme" + scheme);
        }
        return port;
    }

    public abstract void a(int i3, String str, boolean z16);

    @Override // com.tencent.luggage.wxa.bl.d
    public final void a(com.tencent.luggage.wxa.bl.a aVar) {
    }

    public abstract void a(h hVar);

    public void b(int i3, String str) {
    }

    public abstract void b(com.tencent.luggage.wxa.fl.d dVar);

    public abstract void b(Exception exc);

    public abstract void b(String str);

    public abstract void b(ByteBuffer byteBuffer);

    public void close() {
        if (this.f123701h != null) {
            this.f123696c.a(1000);
        }
    }

    public Timer d() {
        return this.D;
    }

    public final void f() {
        try {
            Socket socket = this.f123697d;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e16) {
            a((com.tencent.luggage.wxa.bl.a) this, (Exception) e16);
        }
    }

    @Override // com.tencent.luggage.wxa.jq.f
    public String getKey() {
        return "WebsocketWriteThread";
    }

    public boolean h() {
        return this.f123696c.d();
    }

    public boolean i() {
        return this.f123696c.e();
    }

    public boolean isOpen() {
        return this.f123696c.f();
    }

    public final void j() {
        String str;
        String rawPath = this.f123695b.getRawPath();
        String rawQuery = this.f123695b.getRawQuery();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        if (rawQuery != null) {
            rawPath = rawPath + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + rawQuery;
        }
        int g16 = g();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f123695b.getHost());
        if (g16 != 80) {
            str = ":" + g16;
        } else {
            str = "";
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        com.tencent.luggage.wxa.gl.d dVar = new com.tencent.luggage.wxa.gl.d();
        dVar.b(rawPath);
        dVar.a("Host", sb6);
        Map map = this.f123703j;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                dVar.a((String) entry.getKey(), (String) entry.getValue());
            }
        }
        this.f123696c.a((com.tencent.luggage.wxa.gl.b) dVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        int read;
        try {
            Socket socket = this.f123697d;
            if (socket == null) {
                this.f123697d = new Socket(this.f123700g);
            } else if (socket.isClosed()) {
                throw new IOException();
            }
            this.f123697d.setTcpNoDelay(e());
            if (!this.f123697d.isBound()) {
                this.f123697d.connect(new InetSocketAddress(this.f123695b.getHost(), g()), this.f123706m);
            }
            this.f123698e = this.f123697d.getInputStream();
            this.f123699f = this.f123697d.getOutputStream();
            j();
            b bVar = new b();
            this.f123701h = bVar;
            com.tencent.luggage.wxa.zp.h.f146825d.execute(bVar);
            byte[] bArr = new byte[c.G];
            while (!i() && !h() && (read = this.f123698e.read(bArr)) != -1) {
                try {
                    this.f123696c.a(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException unused) {
                    this.f123696c.a();
                    return;
                } catch (RuntimeException e16) {
                    b(e16);
                    this.f123696c.b(1006, e16.getMessage());
                    return;
                }
            }
            this.f123696c.a();
        } catch (Exception e17) {
            this.f123696c.b(-1, e17.getMessage());
        }
    }

    public void send(String str) {
        this.f123696c.a(str);
    }

    public void b(int i3, String str, boolean z16) {
    }

    public Socket c() {
        return this.f123697d;
    }

    public void a() {
        if (this.f123701h != null) {
            w.d("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
        } else {
            this.f123701h = this;
            com.tencent.luggage.wxa.zp.h.f146825d.execute(this);
        }
    }

    @Override // com.tencent.luggage.wxa.bl.d
    public void b(com.tencent.luggage.wxa.bl.a aVar, com.tencent.luggage.wxa.fl.d dVar) {
        b(dVar);
    }

    @Override // com.tencent.luggage.wxa.bl.d
    public void b(com.tencent.luggage.wxa.bl.a aVar, int i3, String str, boolean z16) {
        b(i3, str, z16);
    }

    public String b() {
        return this.C;
    }

    public void a(String str, int i3) {
        if (this.f123701h != null) {
            a(i3, str);
        }
    }

    @Override // com.tencent.luggage.wxa.jq.d
    public void a(Future future) {
        this.E = future;
    }

    @Override // com.tencent.luggage.wxa.bl.d
    public final void a(com.tencent.luggage.wxa.bl.a aVar, String str) {
        b(str);
    }

    @Override // com.tencent.luggage.wxa.bl.d
    public final void a(com.tencent.luggage.wxa.bl.a aVar, ByteBuffer byteBuffer) {
        b(byteBuffer);
    }

    @Override // com.tencent.luggage.wxa.bl.d
    public final void a(com.tencent.luggage.wxa.bl.a aVar, com.tencent.luggage.wxa.gl.f fVar) {
        this.f123704k.countDown();
        a((h) fVar);
    }

    @Override // com.tencent.luggage.wxa.bl.d
    public final void a(com.tencent.luggage.wxa.bl.a aVar, int i3, String str, boolean z16) {
        this.f123704k.countDown();
        this.f123705l.countDown();
        Future future = this.E;
        if (future != null) {
            future.cancel(false);
        }
        Runnable runnable = this.f123701h;
        if (runnable != null && (runnable instanceof b)) {
            ((b) runnable).b(true);
        }
        try {
            Socket socket = this.f123697d;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e16) {
            a((com.tencent.luggage.wxa.bl.a) this, (Exception) e16);
        }
        a(i3, str, z16);
    }

    @Override // com.tencent.luggage.wxa.bl.d
    public final void a(com.tencent.luggage.wxa.bl.a aVar, Exception exc) {
        b(exc);
    }

    @Override // com.tencent.luggage.wxa.bl.d
    public void a(com.tencent.luggage.wxa.bl.a aVar, int i3, String str) {
        b(i3, str);
    }

    public void a(Socket socket) {
        if (this.f123697d != null) {
            w.d("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
        } else {
            this.f123697d = socket;
        }
    }

    public void a(int i3, String str) {
        this.f123696c.a(i3, str);
    }

    public void a(ByteBuffer byteBuffer) {
        this.f123696c.d(byteBuffer);
    }

    @Override // com.tencent.luggage.wxa.bl.a
    public void a(com.tencent.luggage.wxa.fl.d dVar) {
        this.f123696c.a(dVar);
    }

    public void a(String str) {
        this.C = str;
    }

    public void a(Timer timer) {
        this.D = timer;
    }

    public final void a(Exception exc) {
        if (exc instanceof SSLException) {
            b(exc);
        }
        this.f123696c.a();
    }
}
