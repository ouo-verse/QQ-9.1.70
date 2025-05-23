package com.vivo.push.listener;

/* loaded from: classes13.dex */
interface IPushRequestListener<T, V> {
    void onFail(V v3);

    void onSuccess(T t16);
}
