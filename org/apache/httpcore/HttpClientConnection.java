package org.apache.httpcore;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface HttpClientConnection extends HttpConnection {
    void flush() throws IOException;

    boolean isResponseAvailable(int i3) throws IOException;

    void receiveResponseEntity(HttpResponse httpResponse) throws HttpException, IOException;

    HttpResponse receiveResponseHeader() throws HttpException, IOException;

    void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException;

    void sendRequestHeader(HttpRequest httpRequest) throws HttpException, IOException;
}
