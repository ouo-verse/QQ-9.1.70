package org.apache.httpcore.impl.bootstrap;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.httpcore.ExceptionLogger;
import org.apache.httpcore.HttpConnectionFactory;
import org.apache.httpcore.HttpServerConnection;
import org.apache.httpcore.config.SocketConfig;
import org.apache.httpcore.protocol.HttpService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class RequestListener implements Runnable {
    private final HttpConnectionFactory<? extends HttpServerConnection> connectionFactory;
    private final ExceptionLogger exceptionLogger;
    private final ExecutorService executorService;
    private final HttpService httpService;
    private final ServerSocket serversocket;
    private final SocketConfig socketConfig;
    private final AtomicBoolean terminated = new AtomicBoolean(false);

    public RequestListener(SocketConfig socketConfig, ServerSocket serverSocket, HttpService httpService, HttpConnectionFactory<? extends HttpServerConnection> httpConnectionFactory, ExceptionLogger exceptionLogger, ExecutorService executorService) {
        this.socketConfig = socketConfig;
        this.serversocket = serverSocket;
        this.connectionFactory = httpConnectionFactory;
        this.httpService = httpService;
        this.exceptionLogger = exceptionLogger;
        this.executorService = executorService;
    }

    public boolean isTerminated() {
        return this.terminated.get();
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!isTerminated() && !Thread.interrupted()) {
            try {
                Socket accept = this.serversocket.accept();
                accept.setSoTimeout(this.socketConfig.getSoTimeout());
                accept.setKeepAlive(this.socketConfig.isSoKeepAlive());
                accept.setTcpNoDelay(this.socketConfig.isTcpNoDelay());
                if (this.socketConfig.getRcvBufSize() > 0) {
                    accept.setReceiveBufferSize(this.socketConfig.getRcvBufSize());
                }
                if (this.socketConfig.getSndBufSize() > 0) {
                    accept.setSendBufferSize(this.socketConfig.getSndBufSize());
                }
                if (this.socketConfig.getSoLinger() >= 0) {
                    accept.setSoLinger(true, this.socketConfig.getSoLinger());
                }
                this.executorService.execute(new Worker(this.httpService, this.connectionFactory.createConnection(accept), this.exceptionLogger));
            } catch (Exception e16) {
                this.exceptionLogger.log(e16);
                return;
            }
        }
    }

    public void terminate() throws IOException {
        if (this.terminated.compareAndSet(false, true)) {
            this.serversocket.close();
        }
    }
}
