package com.tencent.mobileqq.guild.message.lastmsg.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.guild.message.m;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends e {
    public a(AppRuntime appRuntime) {
        super(appRuntime);
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.impl.e
    public void a(Message message) {
        try {
            ((m) ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface) this.f230640a).F(10014)).h(message);
        } catch (Throwable unused) {
        }
    }
}
