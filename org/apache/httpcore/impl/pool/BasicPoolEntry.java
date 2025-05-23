package org.apache.httpcore.impl.pool;

import java.io.IOException;
import org.apache.httpcore.HttpClientConnection;
import org.apache.httpcore.HttpHost;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.pool.PoolEntry;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: classes29.dex */
public class BasicPoolEntry extends PoolEntry<HttpHost, HttpClientConnection> {
    public BasicPoolEntry(String str, HttpHost httpHost, HttpClientConnection httpClientConnection) {
        super(str, httpHost, httpClientConnection);
    }

    @Override // org.apache.httpcore.pool.PoolEntry
    public void close() {
        try {
            HttpClientConnection connection = getConnection();
            try {
                int socketTimeout = connection.getSocketTimeout();
                if (socketTimeout <= 0 || socketTimeout > 1000) {
                    connection.setSocketTimeout(1000);
                }
                connection.close();
            } catch (IOException unused) {
                connection.shutdown();
            }
        } catch (IOException unused2) {
        }
    }

    @Override // org.apache.httpcore.pool.PoolEntry
    public boolean isClosed() {
        return !getConnection().isOpen();
    }
}
