package com.tencent.mobileqq.guild.message.lastmsg.api.impl;

import com.tencent.imcore.message.Message;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class f extends e {

    /* renamed from: b, reason: collision with root package name */
    protected static String f230641b = "SendingMsgProcessor";

    public f(AppRuntime appRuntime) {
        super(appRuntime);
    }

    @Override // com.tencent.mobileqq.guild.message.lastmsg.api.impl.e
    public void a(Message message) {
        if (message != null && message.isSendFromLocal() && message.extraflag == 32772 && !((com.tencent.mobileqq.service.message.e) this.f230640a.getMsgCache()).t1(message)) {
            QLog.e(f230641b, 1, "set sending message FAILED: ", message);
            message.setExtraFlag(32768);
        }
    }
}
