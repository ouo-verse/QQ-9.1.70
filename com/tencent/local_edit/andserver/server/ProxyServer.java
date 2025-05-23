package com.tencent.local_edit.andserver.server;

import com.tencent.local_edit.andserver.util.b;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import j11.d;
import j11.e;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import org.apache.httpcore.impl.DefaultBHttpClientConnection;
import org.apache.httpcore.impl.DefaultBHttpServerConnection;
import org.apache.httpcore.protocol.HttpService;

/* loaded from: classes7.dex */
public class ProxyServer extends BasicServer<Object> {

    /* renamed from: com.tencent.local_edit.andserver.server.ProxyServer$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ProxyServer this$0;

        /* renamed from: com.tencent.local_edit.andserver.server.ProxyServer$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes7.dex */
        class RunnableC59571 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AnonymousClass1 f119857d;

            @Override // java.lang.Runnable
            public void run() {
                this.f119857d.getClass();
                if (ProxyServer.m(null) != null) {
                    this.f119857d.getClass();
                    ProxyServer.m(null).onStarted();
                }
            }
        }

        /* renamed from: com.tencent.local_edit.andserver.server.ProxyServer$1$2, reason: invalid class name */
        /* loaded from: classes7.dex */
        class AnonymousClass2 extends BaseThread {
            final /* synthetic */ AnonymousClass1 C;

            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                this.C.getClass();
                ProxyServer.g(null).e();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ProxyServer.e(null) == null) {
                if (ProxyServer.f(null) != null) {
                    ProxyServer.f(null).getServerSocketFactory();
                } else {
                    ServerSocketFactory.getDefault();
                }
            }
            ProxyServer.h(null);
            ProxyServer.i(null);
            ProxyServer.j(null);
            ProxyServer.k(null);
            throw null;
        }
    }

    /* renamed from: com.tencent.local_edit.andserver.server.ProxyServer$2, reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ProxyServer this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (ProxyServer.g(null) != null) {
                ProxyServer.g(null).e();
                ProxyServer.l(null, false);
                b.b().c(new Runnable() { // from class: com.tencent.local_edit.andserver.server.ProxyServer.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2.this.getClass();
                        if (ProxyServer.m(null) != null) {
                            AnonymousClass2.this.getClass();
                            ProxyServer.m(null).onStopped();
                        }
                    }
                });
            }
        }
    }

    /* loaded from: classes7.dex */
    private static class HttpServer implements Runnable {
        private ServerSocket C;

        /* renamed from: d, reason: collision with root package name */
        private final int f119859d;

        /* renamed from: e, reason: collision with root package name */
        private final ThreadPoolExecutor f119860e;

        /* renamed from: f, reason: collision with root package name */
        private final ThreadGroup f119861f;

        /* renamed from: h, reason: collision with root package name */
        private final ThreadPoolExecutor f119862h;

        /* renamed from: i, reason: collision with root package name */
        private final Map<Worker, Boolean> f119863i;

        /* renamed from: m, reason: collision with root package name */
        private HttpService f119864m;

        public void e() {
            this.f119860e.shutdown();
            this.f119862h.shutdown();
            try {
                this.C.close();
            } catch (IOException unused) {
            }
            this.f119861f.interrupt();
            try {
                this.f119862h.awaitTermination(3L, TimeUnit.SECONDS);
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
            }
            Iterator<Worker> it = this.f119863i.keySet().iterator();
            while (it.hasNext()) {
                try {
                    it.next().e().shutdown();
                } catch (IOException unused3) {
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!Thread.interrupted()) {
                try {
                    Socket accept = this.C.accept();
                    accept.setSoTimeout(this.f119859d);
                    accept.setKeepAlive(true);
                    accept.setTcpNoDelay(true);
                    accept.setSoLinger(true, 0);
                    DefaultBHttpServerConnection defaultBHttpServerConnection = new DefaultBHttpServerConnection(8192);
                    defaultBHttpServerConnection.bind(accept);
                    this.f119862h.execute(new Worker(this.f119864m, defaultBHttpServerConnection, new DefaultBHttpClientConnection(8192)));
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class Worker implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final HttpService f119865d;

        /* renamed from: e, reason: collision with root package name */
        private final DefaultBHttpServerConnection f119866e;

        /* renamed from: f, reason: collision with root package name */
        private final DefaultBHttpClientConnection f119867f;

        public Worker(HttpService httpService, DefaultBHttpServerConnection defaultBHttpServerConnection, DefaultBHttpClientConnection defaultBHttpClientConnection) {
            this.f119865d = httpService;
            this.f119866e = defaultBHttpServerConnection;
            this.f119867f = defaultBHttpClientConnection;
        }

        public DefaultBHttpServerConnection e() {
            return this.f119866e;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:16:0x004c
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
            */
        @Override // java.lang.Runnable
        public void run() {
            /*
                r4 = this;
                org.apache.httpcore.protocol.BasicHttpContext r0 = new org.apache.httpcore.protocol.BasicHttpContext
                r0.<init>()
                org.apache.httpcore.protocol.HttpCoreContext r0 = org.apache.httpcore.protocol.HttpCoreContext.adapt(r0)
                java.lang.String r1 = "http.proxy.conn.client"
                org.apache.httpcore.impl.DefaultBHttpClientConnection r2 = r4.f119867f
                r0.setAttribute(r1, r2)
            L11:
                boolean r1 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
                if (r1 != 0) goto L47
                org.apache.httpcore.impl.DefaultBHttpServerConnection r1 = r4.f119866e     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
                boolean r1 = r1.isOpen()     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
                if (r1 != 0) goto L25
                org.apache.httpcore.impl.DefaultBHttpClientConnection r0 = r4.f119867f     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
                r0.close()     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
                goto L47
            L25:
                org.apache.httpcore.protocol.HttpService r1 = r4.f119865d     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
                org.apache.httpcore.impl.DefaultBHttpServerConnection r2 = r4.f119866e     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
                r1.handleRequest(r2, r0)     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
                java.lang.String r1 = "http.proxy.conn.alive"
                java.lang.Object r1 = r0.getAttribute(r1)     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
                java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
                java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
                boolean r1 = r2.equals(r1)     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
                if (r1 != 0) goto L11
                org.apache.httpcore.impl.DefaultBHttpClientConnection r0 = r4.f119867f     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
                r0.close()     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
                org.apache.httpcore.impl.DefaultBHttpServerConnection r0 = r4.f119866e     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
                r0.close()     // Catch: java.lang.Throwable -> L52 org.apache.httpcore.HttpException -> L54 java.io.IOException -> L76 org.apache.httpcore.ConnectionClosedException -> L98
            L47:
                org.apache.httpcore.impl.DefaultBHttpServerConnection r0 = r4.f119866e     // Catch: java.io.IOException -> L4c
                r0.shutdown()     // Catch: java.io.IOException -> L4c
            L4c:
                org.apache.httpcore.impl.DefaultBHttpClientConnection r0 = r4.f119867f     // Catch: java.io.IOException -> La6
                r0.shutdown()     // Catch: java.io.IOException -> La6
                goto La6
            L52:
                r0 = move-exception
                goto La7
            L54:
                r0 = move-exception
                java.io.PrintStream r1 = java.lang.System.err     // Catch: java.lang.Throwable -> L52
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
                r2.<init>()     // Catch: java.lang.Throwable -> L52
                java.lang.String r3 = "Unrecoverable HTTP protocol violation: "
                r2.append(r3)     // Catch: java.lang.Throwable -> L52
                java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L52
                r2.append(r0)     // Catch: java.lang.Throwable -> L52
                java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L52
                r1.println(r0)     // Catch: java.lang.Throwable -> L52
                org.apache.httpcore.impl.DefaultBHttpServerConnection r0 = r4.f119866e     // Catch: java.io.IOException -> L4c
                r0.shutdown()     // Catch: java.io.IOException -> L4c
                goto L4c
            L76:
                r0 = move-exception
                java.io.PrintStream r1 = java.lang.System.err     // Catch: java.lang.Throwable -> L52
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
                r2.<init>()     // Catch: java.lang.Throwable -> L52
                java.lang.String r3 = "I/O error: "
                r2.append(r3)     // Catch: java.lang.Throwable -> L52
                java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L52
                r2.append(r0)     // Catch: java.lang.Throwable -> L52
                java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L52
                r1.println(r0)     // Catch: java.lang.Throwable -> L52
                org.apache.httpcore.impl.DefaultBHttpServerConnection r0 = r4.f119866e     // Catch: java.io.IOException -> L4c
                r0.shutdown()     // Catch: java.io.IOException -> L4c
                goto L4c
            L98:
                java.io.PrintStream r0 = java.lang.System.err     // Catch: java.lang.Throwable -> L52
                java.lang.String r1 = "Client closed connection."
                r0.println(r1)     // Catch: java.lang.Throwable -> L52
                org.apache.httpcore.impl.DefaultBHttpServerConnection r0 = r4.f119866e     // Catch: java.io.IOException -> L4c
                r0.shutdown()     // Catch: java.io.IOException -> L4c
                goto L4c
            La6:
                return
            La7:
                org.apache.httpcore.impl.DefaultBHttpServerConnection r1 = r4.f119866e     // Catch: java.io.IOException -> Lac
                r1.shutdown()     // Catch: java.io.IOException -> Lac
            Lac:
                org.apache.httpcore.impl.DefaultBHttpClientConnection r1 = r4.f119867f     // Catch: java.io.IOException -> Lb1
                r1.shutdown()     // Catch: java.io.IOException -> Lb1
            Lb1:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.local_edit.andserver.server.ProxyServer.Worker.run():void");
        }
    }

    static /* synthetic */ ServerSocketFactory e(ProxyServer proxyServer) {
        throw null;
    }

    static /* synthetic */ SSLContext f(ProxyServer proxyServer) {
        throw null;
    }

    static /* synthetic */ HttpServer g(ProxyServer proxyServer) {
        throw null;
    }

    static /* synthetic */ InetAddress h(ProxyServer proxyServer) {
        throw null;
    }

    static /* synthetic */ int i(ProxyServer proxyServer) {
        throw null;
    }

    static /* synthetic */ int j(ProxyServer proxyServer) {
        throw null;
    }

    static /* synthetic */ d k(ProxyServer proxyServer) {
        throw null;
    }

    static /* synthetic */ boolean l(ProxyServer proxyServer, boolean z16) {
        throw null;
    }

    static /* synthetic */ e.b m(ProxyServer proxyServer) {
        throw null;
    }
}
