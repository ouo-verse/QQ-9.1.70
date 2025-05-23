package com.tencent.map.tools.net.http;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface HttpResponseListener<T> {
    void onFailure(int i3, String str, Throwable th5);

    void onSuccess(int i3, T t16);
}
