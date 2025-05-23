package com.tencent.mobileqq.icgame.api.sso;

import com.tencent.mobileqq.icgame.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver;

/* loaded from: classes15.dex */
public interface IQQLiveSsoProxyModule extends IQQLiveModule {
    void sendQQLiveProxyReq(String str, String str2, byte[] bArr, IQQLiveProxySsoObserver iQQLiveProxySsoObserver);

    void sendQQLiveQuickProxyReq(String str, String str2, byte[] bArr, IQQLiveProxySsoObserver iQQLiveProxySsoObserver);
}
