package com.tencent.mobileqq.guild.message.data;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.aj;
import com.tencent.mobileqq.activity.aio.u;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;

/* loaded from: classes33.dex */
class GuildSystemMessageProcessorCallback$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AppInterface f230367d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ MessageRecord f230368e;
    final /* synthetic */ k this$0;

    @Override // java.lang.Runnable
    public void run() {
        IMessageFacade iMessageFacade = (IMessageFacade) this.f230367d.getRuntimeService(IMessageFacade.class, "");
        aj ajVar = new aj();
        ajVar.f116523a = new u(this.f230368e.frienduin);
        ajVar.f116542t = 10014;
        iMessageFacade.setChangeAndNotify(ajVar);
        iMessageFacade.cancelNotificationWhenRevokeMessage(this.f230368e);
    }
}
