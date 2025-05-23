package com.tencent.mobileqq.guild.message.api.impl.onlinepush;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes14.dex */
class GuildMsgPushProducer$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ FromServiceMsg f230220d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Object f230221e;
    final /* synthetic */ c this$0;

    @Override // java.lang.Runnable
    public void run() {
        boolean q16;
        f fVar;
        long currentTimeMillis = System.currentTimeMillis();
        this.this$0.f230228a.J2().b();
        if (!this.this$0.f230228a.I2()) {
            q16 = this.this$0.q(this.f230220d, this.f230221e);
            if (!q16) {
                this.this$0.m(this.f230220d, this.f230221e);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    fVar = this.this$0.f230235h;
                    if (fVar.a("handleOnlinePush")) {
                        QLog.i("GuildMsgPushProducer", 1, "handleOnlinePush, startProcessTime = " + currentTimeMillis + ", spend = " + (currentTimeMillis2 - currentTimeMillis));
                    }
                }
            }
        }
    }
}
