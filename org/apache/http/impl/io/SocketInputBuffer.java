package org.apache.http.impl.io;

import java.io.IOException;
import java.net.Socket;
import org.apache.http.params.HttpParams;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class SocketInputBuffer extends AbstractSessionInputBuffer {
    public SocketInputBuffer(Socket socket, int i3, HttpParams httpParams) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.io.SessionInputBuffer
    public boolean isDataAvailable(int i3) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public boolean isStale() throws IOException {
        throw new RuntimeException("Stub!");
    }
}
