package org.apache.httpcore;

import java.io.IOException;
import java.net.Socket;
import org.apache.httpcore.HttpConnection;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface HttpConnectionFactory<T extends HttpConnection> {
    T createConnection(Socket socket) throws IOException;
}
