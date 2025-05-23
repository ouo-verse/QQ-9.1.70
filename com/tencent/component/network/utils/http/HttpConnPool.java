package com.tencent.component.network.utils.http;

import com.tencent.component.network.utils.http.pool.AbstractConnPool;
import com.tencent.component.network.utils.http.pool.ConnFactory;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.logging.Log;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.DefaultClientConnection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class HttpConnPool extends AbstractConnPool<HttpRoute, OperatedClientConnection, HttpPoolEntry> {
    private static AtomicLong COUNTER = new AtomicLong();
    private final Log log;
    private final long timeToLive;
    private final TimeUnit tunit;

    /* loaded from: classes5.dex */
    static class InternalConnFactory implements ConnFactory<HttpRoute, OperatedClientConnection> {
        InternalConnFactory() {
        }

        @Override // com.tencent.component.network.utils.http.pool.ConnFactory
        public OperatedClientConnection create(HttpRoute httpRoute) throws IOException {
            return new DefaultClientConnection();
        }
    }

    public HttpConnPool(Log log, int i3, int i16, long j3, TimeUnit timeUnit) {
        super(new InternalConnFactory(), i3, i16);
        this.log = log;
        this.timeToLive = j3;
        this.tunit = timeUnit;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.network.utils.http.pool.AbstractConnPool
    public HttpPoolEntry createEntry(HttpRoute httpRoute, OperatedClientConnection operatedClientConnection) {
        return new HttpPoolEntry(this.log, Long.toString(COUNTER.getAndIncrement()), httpRoute, operatedClientConnection, this.timeToLive, this.tunit);
    }
}
