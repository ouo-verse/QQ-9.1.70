package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.HttpRequest;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HttpUriRequest extends HttpRequest {
    void abort() throws UnsupportedOperationException;

    String getMethod();

    URI getURI();

    boolean isAborted();
}
