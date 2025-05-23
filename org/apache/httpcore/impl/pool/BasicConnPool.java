package org.apache.httpcore.impl.pool;

import java.util.concurrent.atomic.AtomicLong;
import org.apache.httpcore.HttpClientConnection;
import org.apache.httpcore.HttpHost;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.config.ConnectionConfig;
import org.apache.httpcore.config.SocketConfig;
import org.apache.httpcore.params.HttpParams;
import org.apache.httpcore.pool.AbstractConnPool;
import org.apache.httpcore.pool.ConnFactory;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: classes29.dex */
public class BasicConnPool extends AbstractConnPool<HttpHost, HttpClientConnection, BasicPoolEntry> {
    private static final AtomicLong COUNTER = new AtomicLong();

    public BasicConnPool(ConnFactory<HttpHost, HttpClientConnection> connFactory) {
        super(connFactory, 2, 20);
    }

    @Deprecated
    public BasicConnPool(HttpParams httpParams) {
        super(new BasicConnFactory(httpParams), 2, 20);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.httpcore.pool.AbstractConnPool
    public BasicPoolEntry createEntry(HttpHost httpHost, HttpClientConnection httpClientConnection) {
        return new BasicPoolEntry(Long.toString(COUNTER.getAndIncrement()), httpHost, httpClientConnection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.httpcore.pool.AbstractConnPool
    public boolean validate(BasicPoolEntry basicPoolEntry) {
        return !basicPoolEntry.getConnection().isStale();
    }

    public BasicConnPool(SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        super(new BasicConnFactory(socketConfig, connectionConfig), 2, 20);
    }

    public BasicConnPool() {
        super(new BasicConnFactory(SocketConfig.DEFAULT, ConnectionConfig.DEFAULT), 2, 20);
    }
}
