package com.tencent.mobileqq.guild.message.api;

import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.guild.message.base.r;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildMessageCallbackApi extends QRouteApi {
    void setGuildDispersionRoamMsgProcessorCallback(r rVar);

    void setGuildGuestMessageProcessorCallback(r rVar);

    void setGuildMessageManagerCallback(r rVar);

    void setGuildOfflineMessageProcessorCallback(r rVar);

    void setGuildPushMessageProcessorCallback(r rVar);

    void setGuildRoamMessageEventFlowProcessorCallback(r rVar);

    void setGuildRoamMessageProcessorCallback(r rVar);

    void setGuildS2CMessageProcessorCallback(r rVar);

    void setGuildSystemMessageProcessorCallback(r rVar);

    void setMsgProxyCallback(ad.c cVar);
}
