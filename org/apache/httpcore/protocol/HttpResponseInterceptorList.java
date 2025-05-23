package org.apache.httpcore.protocol;

import java.util.List;
import org.apache.httpcore.HttpResponseInterceptor;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HttpResponseInterceptorList {
    void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor);

    void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor, int i3);

    void clearResponseInterceptors();

    HttpResponseInterceptor getResponseInterceptor(int i3);

    int getResponseInterceptorCount();

    void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> cls);

    void setInterceptors(List<?> list);
}
