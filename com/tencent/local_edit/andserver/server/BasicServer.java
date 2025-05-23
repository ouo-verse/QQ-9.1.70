package com.tencent.local_edit.andserver.server;

import androidx.annotation.NonNull;
import com.tencent.local_edit.andserver.server.BasicServer.a;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import j11.d;
import j11.e;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;
import org.apache.httpcore.ExceptionLogger;
import org.apache.httpcore.config.SocketConfig;
import org.apache.httpcore.impl.bootstrap.HttpServer;
import org.apache.httpcore.impl.bootstrap.SSLServerSetupHandler;
import org.apache.httpcore.impl.bootstrap.ServerBootstrap;
import org.apache.httpcore.protocol.HttpRequestHandler;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class BasicServer<T extends a> implements e {

    /* renamed from: a, reason: collision with root package name */
    protected final InetAddress f119839a;

    /* renamed from: b, reason: collision with root package name */
    protected final int f119840b;

    /* renamed from: c, reason: collision with root package name */
    protected final int f119841c;

    /* renamed from: d, reason: collision with root package name */
    protected final ServerSocketFactory f119842d;

    /* renamed from: e, reason: collision with root package name */
    protected final SSLContext f119843e;

    /* renamed from: f, reason: collision with root package name */
    protected final e.b f119844f;

    /* renamed from: g, reason: collision with root package name */
    private HttpServer f119845g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f119846h;

    /* compiled from: P */
    /* renamed from: com.tencent.local_edit.andserver.server.BasicServer$2, reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ BasicServer this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.f119845g != null) {
                this.this$0.f119845g.shutdown(3L, TimeUnit.SECONDS);
                this.this$0.f119846h = false;
                com.tencent.local_edit.andserver.util.b.b().c(new Runnable() { // from class: com.tencent.local_edit.andserver.server.BasicServer.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        e.b bVar = AnonymousClass2.this.this$0.f119844f;
                        if (bVar != null) {
                            bVar.onStopped();
                        }
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    protected static abstract class a<T extends a, S extends BasicServer> {

        /* renamed from: a, reason: collision with root package name */
        InetAddress f119851a;

        /* renamed from: b, reason: collision with root package name */
        int f119852b;

        /* renamed from: c, reason: collision with root package name */
        int f119853c;

        /* renamed from: d, reason: collision with root package name */
        ServerSocketFactory f119854d;

        /* renamed from: e, reason: collision with root package name */
        SSLContext f119855e;

        /* renamed from: f, reason: collision with root package name */
        e.b f119856f;

        public T e(InetAddress inetAddress) {
            this.f119851a = inetAddress;
            return this;
        }

        public T f(e.b bVar) {
            this.f119856f = bVar;
            return this;
        }

        public T g(int i3) {
            this.f119852b = i3;
            return this;
        }

        public T h(int i3, TimeUnit timeUnit) {
            this.f119853c = (int) Math.min(timeUnit.toMillis(i3), TTL.MAX_VALUE);
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static final class b implements SSLServerSetupHandler {
        public b(@NonNull d dVar) {
        }

        @Override // org.apache.httpcore.impl.bootstrap.SSLServerSetupHandler
        public void initialize(SSLServerSocket sSLServerSocket) throws SSLException {
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BasicServer(T t16) {
        this.f119839a = t16.f119851a;
        this.f119840b = t16.f119852b;
        this.f119841c = t16.f119853c;
        this.f119842d = t16.f119854d;
        this.f119843e = t16.f119855e;
        this.f119844f = t16.f119856f;
    }

    @Override // j11.e
    public void a() {
        if (this.f119846h) {
            return;
        }
        com.tencent.local_edit.andserver.util.b.b().a(new Runnable() { // from class: com.tencent.local_edit.andserver.server.BasicServer.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BasicServer basicServer = BasicServer.this;
                    ServerBootstrap sslContext = ServerBootstrap.bootstrap().setServerSocketFactory(BasicServer.this.f119842d).setSocketConfig(SocketConfig.custom().setSoKeepAlive(true).setSoReuseAddress(true).setTcpNoDelay(true).setSoTimeout(BasicServer.this.f119841c).setSoLinger(0).build()).setLocalAddress(BasicServer.this.f119839a).setListenerPort(BasicServer.this.f119840b).setSslContext(BasicServer.this.f119843e);
                    BasicServer.this.getClass();
                    basicServer.f119845g = sslContext.setSslSetupHandler(new b(null)).setServerInfo(j11.a.f409077a).registerHandler("*", BasicServer.this.d()).setExceptionLogger(ExceptionLogger.NO_OP).create();
                    BasicServer.this.f119845g.start();
                    BasicServer.this.f119846h = true;
                    com.tencent.local_edit.andserver.util.b.b().c(new Runnable() { // from class: com.tencent.local_edit.andserver.server.BasicServer.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.b bVar = BasicServer.this.f119844f;
                            if (bVar != null) {
                                bVar.onStarted();
                            }
                        }
                    });
                    Runtime.getRuntime().addShutdownHook(new BaseThread() { // from class: com.tencent.local_edit.andserver.server.BasicServer.1.2
                        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                        public void run() {
                            BasicServer.this.f119845g.shutdown(3L, TimeUnit.SECONDS);
                        }
                    });
                } catch (Exception e16) {
                    com.tencent.local_edit.andserver.util.b.b().c(new Runnable() { // from class: com.tencent.local_edit.andserver.server.BasicServer.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            e.b bVar = BasicServer.this.f119844f;
                            if (bVar != null) {
                                bVar.onException(e16);
                            }
                        }
                    });
                }
            }
        });
    }

    protected abstract HttpRequestHandler d();

    @Override // j11.e
    public boolean isRunning() {
        return this.f119846h;
    }
}
