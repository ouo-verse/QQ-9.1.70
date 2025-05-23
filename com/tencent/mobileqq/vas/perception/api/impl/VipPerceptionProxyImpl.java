package com.tencent.mobileqq.vas.perception.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.perception.api.IVipPerception;
import com.tencent.mobileqq.vas.perception.api.IVipPerceptionProxy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/perception/api/impl/VipPerceptionProxyImpl;", "Lcom/tencent/mobileqq/vas/perception/api/IVipPerceptionProxy;", "()V", "groupKeyWord", "", "chatType", "", "peerUin", "", "sVipExpiredCheck", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VipPerceptionProxyImpl implements IVipPerceptionProxy {
    @Override // com.tencent.mobileqq.vas.perception.api.IVipPerceptionProxy
    public void groupKeyWord(int chatType, long peerUin) {
        ((IVipPerception) QRoute.api(IVipPerception.class)).groupKeyWord(chatType, peerUin);
    }

    @Override // com.tencent.mobileqq.vas.perception.api.IVipPerceptionProxy
    public void sVipExpiredCheck(int chatType, long peerUin) {
        ((IVipPerception) QRoute.api(IVipPerception.class)).sVipExpiredCheck(chatType, peerUin);
    }
}
