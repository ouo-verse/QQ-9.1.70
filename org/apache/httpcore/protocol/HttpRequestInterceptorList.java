package org.apache.httpcore.protocol;

import java.util.List;
import org.apache.httpcore.HttpRequestInterceptor;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HttpRequestInterceptorList {
    void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor);

    void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor, int i3);

    void clearRequestInterceptors();

    HttpRequestInterceptor getRequestInterceptor(int i3);

    int getRequestInterceptorCount();

    void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> cls);

    void setInterceptors(List<?> list);
}
