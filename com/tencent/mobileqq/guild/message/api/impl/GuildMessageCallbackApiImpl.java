package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.guild.message.aa;
import com.tencent.mobileqq.guild.message.ab;
import com.tencent.mobileqq.guild.message.api.IGuildMessageCallbackApi;
import com.tencent.mobileqq.guild.message.base.r;
import com.tencent.mobileqq.guild.message.m;
import com.tencent.mobileqq.guild.message.p;
import com.tencent.mobileqq.guild.message.s;
import com.tencent.mobileqq.guild.message.x;
import com.tencent.mobileqq.guild.message.y;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMessageCallbackApiImpl implements IGuildMessageCallbackApi {
    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageCallbackApi
    public void setGuildDispersionRoamMsgProcessorCallback(r rVar) {
        com.tencent.mobileqq.guild.message.e.G(rVar);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageCallbackApi
    public void setGuildGuestMessageProcessorCallback(r rVar) {
        com.tencent.mobileqq.guild.message.i.P(rVar);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageCallbackApi
    public void setGuildMessageManagerCallback(r rVar) {
        m.e1(rVar);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageCallbackApi
    public void setGuildPushMessageProcessorCallback(r rVar) {
        s.O(rVar);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageCallbackApi
    public void setGuildRoamMessageEventFlowProcessorCallback(r rVar) {
        x.H(rVar);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageCallbackApi
    public void setGuildRoamMessageProcessorCallback(r rVar) {
        y.M(rVar);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageCallbackApi
    public void setGuildS2CMessageProcessorCallback(r rVar) {
        aa.T(rVar);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageCallbackApi
    public void setGuildSystemMessageProcessorCallback(r rVar) {
        ab.R(rVar);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageCallbackApi
    public void setMsgProxyCallback(ad.c cVar) {
        p.g(cVar);
    }

    @Override // com.tencent.mobileqq.guild.message.api.IGuildMessageCallbackApi
    public void setGuildOfflineMessageProcessorCallback(r rVar) {
    }
}
