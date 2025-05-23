package com.tencent.qmethod.pandoraex.core.ext.netcap;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g<T> implements ResponseHandler<T> {

    /* renamed from: a, reason: collision with root package name */
    private final ResponseHandler<T> f344090a;

    /* renamed from: b, reason: collision with root package name */
    private final d f344091b;

    g(ResponseHandler<T> responseHandler, d dVar) {
        this.f344090a = responseHandler;
        this.f344091b = dVar;
    }

    public static <T> ResponseHandler<? extends T> a(ResponseHandler<? extends T> responseHandler, d dVar) {
        return new g(responseHandler, dVar);
    }

    @Override // org.apache.http.client.ResponseHandler
    public T handleResponse(HttpResponse httpResponse) throws IOException {
        Header[] headers = httpResponse.getHeaders("Content-Length");
        if (headers != null && headers.length > 0) {
            try {
                Long.parseLong(headers[0].getValue());
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        } else if (httpResponse.getEntity() != null) {
            httpResponse.setEntity(new f(httpResponse.getEntity(), this.f344091b));
        }
        return this.f344090a.handleResponse(httpResponse);
    }
}
