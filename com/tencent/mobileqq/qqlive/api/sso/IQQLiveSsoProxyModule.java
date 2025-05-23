package com.tencent.mobileqq.qqlive.api.sso;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver;

/* loaded from: classes17.dex */
public interface IQQLiveSsoProxyModule extends IQQLiveModule {
    void sendQQLiveProxyReq(String str, String str2, byte[] bArr, IQQLiveProxySsoObserver iQQLiveProxySsoObserver);

    void sendQQLiveQuickProxyReq(String str, String str2, byte[] bArr, IQQLiveProxySsoObserver iQQLiveProxySsoObserver);
}
