package org.apache.http.protocol;

import java.util.List;
import org.apache.http.HttpResponseInterceptor;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public interface HttpResponseInterceptorList {
    void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor);

    void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor, int i3);

    void clearResponseInterceptors();

    HttpResponseInterceptor getResponseInterceptor(int i3);

    int getResponseInterceptorCount();

    void removeResponseInterceptorByClass(Class cls);

    void setInterceptors(List list);
}
