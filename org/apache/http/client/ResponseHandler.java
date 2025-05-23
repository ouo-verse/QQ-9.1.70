package org.apache.http.client;

import java.io.IOException;
import org.apache.http.HttpResponse;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface ResponseHandler<T> {
    T handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException;
}
