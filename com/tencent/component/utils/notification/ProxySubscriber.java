package com.tencent.component.utils.notification;

/* loaded from: classes5.dex */
public interface ProxySubscriber {
    Object getProxiedSubscriber();

    ReferenceStrength getReferenceStrength();

    void proxyUnsubscribed();
}
