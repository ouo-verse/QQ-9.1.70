package org.apache.httpcore.impl.bootstrap;

import androidx.lifecycle.c;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import org.apache.httpcore.ExceptionLogger;
import org.apache.httpcore.HttpConnectionFactory;
import org.apache.httpcore.config.SocketConfig;
import org.apache.httpcore.impl.DefaultBHttpServerConnection;
import org.apache.httpcore.protocol.HttpService;

/* compiled from: P */
/* loaded from: classes29.dex */
public class HttpServer {
    private final HttpConnectionFactory<? extends DefaultBHttpServerConnection> connectionFactory;
    private final ExceptionLogger exceptionLogger;
    private final HttpService httpService;
    private final InetAddress ifAddress;
    private final ThreadPoolExecutor listenerExecutorService;
    private final int port;
    private volatile RequestListener requestListener;
    private volatile ServerSocket serverSocket;
    private final ServerSocketFactory serverSocketFactory;
    private final SocketConfig socketConfig;
    private final SSLServerSetupHandler sslSetupHandler;
    private final AtomicReference<Status> status;
    private final WorkerPoolExecutor workerExecutorService;
    private final ThreadGroup workerThreads;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum Status {
        READY,
        ACTIVE,
        STOPPING
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpServer(int i3, InetAddress inetAddress, SocketConfig socketConfig, ServerSocketFactory serverSocketFactory, HttpService httpService, HttpConnectionFactory<? extends DefaultBHttpServerConnection> httpConnectionFactory, SSLServerSetupHandler sSLServerSetupHandler, ExceptionLogger exceptionLogger) {
        this.port = i3;
        this.ifAddress = inetAddress;
        this.socketConfig = socketConfig;
        this.serverSocketFactory = serverSocketFactory;
        this.httpService = httpService;
        this.connectionFactory = httpConnectionFactory;
        this.sslSetupHandler = sSLServerSetupHandler;
        this.exceptionLogger = exceptionLogger;
        this.listenerExecutorService = new BaseThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryImpl("HTTP-listener-" + i3));
        ThreadGroup threadGroup = new ThreadGroup("HTTP-workers");
        this.workerThreads = threadGroup;
        this.workerExecutorService = new WorkerPoolExecutor(0, Integer.MAX_VALUE, 1L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryImpl("HTTP-worker", threadGroup));
        this.status = new AtomicReference<>(Status.READY);
    }

    public void awaitTermination(long j3, TimeUnit timeUnit) throws InterruptedException {
        this.workerExecutorService.awaitTermination(j3, timeUnit);
    }

    public InetAddress getInetAddress() {
        ServerSocket serverSocket = this.serverSocket;
        if (serverSocket != null) {
            return serverSocket.getInetAddress();
        }
        return null;
    }

    public int getLocalPort() {
        ServerSocket serverSocket = this.serverSocket;
        if (serverSocket != null) {
            return serverSocket.getLocalPort();
        }
        return -1;
    }

    public void shutdown(long j3, TimeUnit timeUnit) {
        stop();
        if (j3 > 0) {
            try {
                awaitTermination(j3, timeUnit);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        Iterator<Worker> it = this.workerExecutorService.getWorkers().iterator();
        while (it.hasNext()) {
            try {
                it.next().getConnection().shutdown();
            } catch (IOException e16) {
                this.exceptionLogger.log(e16);
            }
        }
    }

    public void start() throws IOException {
        if (c.a(this.status, Status.READY, Status.ACTIVE)) {
            this.serverSocket = this.serverSocketFactory.createServerSocket();
            this.serverSocket.setReuseAddress(this.socketConfig.isSoReuseAddress());
            this.serverSocket.bind(new InetSocketAddress(this.ifAddress, this.port), this.socketConfig.getBacklogSize());
            if (this.socketConfig.getRcvBufSize() > 0) {
                this.serverSocket.setReceiveBufferSize(this.socketConfig.getRcvBufSize());
            }
            if (this.sslSetupHandler != null && (this.serverSocket instanceof SSLServerSocket)) {
                this.sslSetupHandler.initialize((SSLServerSocket) this.serverSocket);
            }
            this.requestListener = new RequestListener(this.socketConfig, this.serverSocket, this.httpService, this.connectionFactory, this.exceptionLogger, this.workerExecutorService);
            this.listenerExecutorService.execute(this.requestListener);
        }
    }

    public void stop() {
        if (c.a(this.status, Status.ACTIVE, Status.STOPPING)) {
            this.listenerExecutorService.shutdown();
            this.workerExecutorService.shutdown();
            RequestListener requestListener = this.requestListener;
            if (requestListener != null) {
                try {
                    requestListener.terminate();
                } catch (IOException e16) {
                    this.exceptionLogger.log(e16);
                }
            }
            this.workerThreads.interrupt();
        }
    }
}
