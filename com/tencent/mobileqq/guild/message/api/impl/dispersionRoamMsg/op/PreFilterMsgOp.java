package com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* loaded from: classes14.dex */
public class PreFilterMsgOp extends a {

    /* renamed from: f, reason: collision with root package name */
    private final List<Long> f230170f;

    public PreFilterMsgOp(AppRuntime appRuntime, tt1.a aVar, a.AbstractC7847a abstractC7847a) {
        super(appRuntime, aVar, abstractC7847a);
        this.f230170f = new ArrayList();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.PreFilterMsgOp.2
            @Override // java.lang.Runnable
            public void run() {
                if (PreFilterMsgOp.this.f230177b == null) {
                    QLog.i("PreFilterMsgOp", 1, "preFilterMsg callback channelId = " + PreFilterMsgOp.this.f230179d + " size = " + PreFilterMsgOp.this.f230170f.size() + " mOpCallback null !");
                    return;
                }
                QLog.i("PreFilterMsgOp", 1, "preFilterMsg callback channelId = " + PreFilterMsgOp.this.f230179d + " size = " + PreFilterMsgOp.this.f230170f.size() + " mOpCallback onOpResult");
                a.b bVar = new a.b();
                bVar.c(1000);
                bVar.d("");
                PreFilterMsgOp.this.f230177b.a(bVar);
            }
        });
    }

    private void k() {
        this.f230170f.addAll(this.f230180e.j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        QLog.i("PreFilterMsgOp", 1, "preFilterMsg begin channelId = " + this.f230179d + " size = " + this.f230170f.size());
        List<MessageRecord> l06 = b().l0(this.f230179d, 10014, this.f230170f);
        if (l06 != null && !l06.isEmpty()) {
            for (int i3 = 0; i3 < l06.size(); i3++) {
                MessageRecord messageRecord = l06.get(i3);
                d(messageRecord);
                Iterator<Long> it = this.f230170f.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().longValue() == messageRecord.shmsgseq) {
                            it.remove();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            QLog.i("PreFilterMsgOp", 1, "preFilterMsg Succ, needPullMsgSeqList size = " + this.f230170f.size() + "curHasSize = " + c());
            return;
        }
        QLog.i("PreFilterMsgOp", 1, "preFilterMsg error size 0");
    }

    @Override // com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.a
    protected int a() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.PreFilterMsgOp.1
            @Override // java.lang.Runnable
            public void run() {
                PreFilterMsgOp.this.l();
                PreFilterMsgOp.this.i();
            }
        }, 32, null, false);
        return 0;
    }

    public List<Long> j() {
        return this.f230170f;
    }
}
