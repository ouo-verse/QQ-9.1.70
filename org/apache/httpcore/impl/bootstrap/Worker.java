package org.apache.httpcore.impl.bootstrap;

import java.io.IOException;
import org.apache.httpcore.ExceptionLogger;
import org.apache.httpcore.HttpServerConnection;
import org.apache.httpcore.protocol.BasicHttpContext;
import org.apache.httpcore.protocol.HttpCoreContext;
import org.apache.httpcore.protocol.HttpService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class Worker implements Runnable {
    private final HttpServerConnection conn;
    private final ExceptionLogger exceptionLogger;
    private final HttpService httpservice;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Worker(HttpService httpService, HttpServerConnection httpServerConnection, ExceptionLogger exceptionLogger) {
        this.httpservice = httpService;
        this.conn = httpServerConnection;
        this.exceptionLogger = exceptionLogger;
    }

    public HttpServerConnection getConnection() {
        return this.conn;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    BasicHttpContext basicHttpContext = new BasicHttpContext();
                    HttpCoreContext adapt = HttpCoreContext.adapt(basicHttpContext);
                    while (!Thread.interrupted() && this.conn.isOpen()) {
                        this.httpservice.handleRequest(this.conn, adapt);
                        basicHttpContext.clear();
                    }
                    this.conn.close();
                    this.conn.shutdown();
                } catch (Throwable th5) {
                    try {
                        this.conn.shutdown();
                    } catch (IOException e16) {
                        this.exceptionLogger.log(e16);
                    }
                    throw th5;
                }
            } catch (Exception e17) {
                this.exceptionLogger.log(e17);
                this.conn.shutdown();
            }
        } catch (IOException e18) {
            this.exceptionLogger.log(e18);
        }
    }
}
