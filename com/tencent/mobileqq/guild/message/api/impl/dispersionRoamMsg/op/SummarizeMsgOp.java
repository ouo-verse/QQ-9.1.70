package com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op;

import com.tencent.imcore.message.f;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class SummarizeMsgOp extends a {

    /* renamed from: f, reason: collision with root package name */
    private List<Long> f230175f;

    public SummarizeMsgOp(AppRuntime appRuntime, tt1.a aVar, List<Long> list, a.AbstractC7847a abstractC7847a) {
        super(appRuntime, aVar, abstractC7847a);
        this.f230175f = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        QLog.i("SummarizeMsgOp", 1, "preFilterMsg Succ, needPullMsgSeqList size = " + this.f230175f.size() + "curHasSize = " + c());
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.SummarizeMsgOp.2
            @Override // java.lang.Runnable
            public void run() {
                if (SummarizeMsgOp.this.f230177b == null) {
                    QLog.i("SummarizeMsgOp", 1, "SummarizeMsgOp channelId = " + SummarizeMsgOp.this.f230179d + "callback null");
                    return;
                }
                QLog.i("SummarizeMsgOp", 1, "SummarizeMsgOp channelId = " + SummarizeMsgOp.this.f230179d + "callback " + SummarizeMsgOp.this.f230175f.size());
                a.b bVar = new a.b();
                bVar.c(1000);
                bVar.d("");
                SummarizeMsgOp.this.f230177b.a(bVar);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.a
    protected int a() {
        QLog.i("SummarizeMsgOp", 1, "SummarizeMsgOp channelId = " + this.f230179d + "mNeedPullMsgSeqList size = " + this.f230175f.size());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.SummarizeMsgOp.1
            @Override // java.lang.Runnable
            public void run() {
                f b16 = SummarizeMsgOp.this.b();
                SummarizeMsgOp summarizeMsgOp = SummarizeMsgOp.this;
                List<MessageRecord> m06 = b16.m0(summarizeMsgOp.f230179d, 10014, summarizeMsgOp.f230175f);
                if (m06 != null) {
                    Iterator<MessageRecord> it = m06.iterator();
                    while (it.hasNext()) {
                        SummarizeMsgOp.this.d(it.next());
                    }
                }
                SummarizeMsgOp.this.h();
            }
        }, 32, null, true);
        return 0;
    }
}
