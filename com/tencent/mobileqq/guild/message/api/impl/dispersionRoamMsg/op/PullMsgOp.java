package com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import st1.b;
import st1.o;

/* loaded from: classes14.dex */
public class PullMsgOp extends com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.a {

    /* renamed from: f, reason: collision with root package name */
    private final List<Long> f230171f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public class a implements o {
        a() {
        }

        @Override // st1.o
        public void onResult(int i3, String str) {
            PullMsgOp.this.h(i3, str);
        }
    }

    public PullMsgOp(AppRuntime appRuntime, tt1.a aVar, List<Long> list, a.AbstractC7847a abstractC7847a) {
        super(appRuntime, aVar, abstractC7847a);
        this.f230171f = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final int i3, final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.PullMsgOp.2
            @Override // java.lang.Runnable
            public void run() {
                if (PullMsgOp.this.f230177b == null) {
                    QLog.i("FetchDispersionRoamMsgOp", 1, "reqPullMsg channelId = " + PullMsgOp.this.f230179d + " size = " + PullMsgOp.this.f230171f.size() + " mOpCallback null!");
                    return;
                }
                QLog.i("FetchDispersionRoamMsgOp", 1, "reqPullMsg channelId = " + PullMsgOp.this.f230179d + " size = " + PullMsgOp.this.f230171f.size() + " callback " + str + " " + i3);
                a.b bVar = new a.b();
                bVar.c(i3);
                bVar.d(str);
                PullMsgOp.this.f230177b.a(bVar);
            }
        });
    }

    private void i() {
        QLog.i("FetchDispersionRoamMsgOp", 1, "reqPullMsg channelId = " + this.f230179d + " size = " + this.f230171f.size());
        if (!((b) ((AppInterface) this.f230176a).getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildDispersionRoamMsgHandlerName())).J0(this.f230178c, this.f230179d, this.f230171f, new a())) {
            QLog.i("FetchDispersionRoamMsgOp", 1, "reqPullMsg getDispersionRoamMsg return false  doCallback channelId = " + this.f230179d);
            h(1001, "");
        }
    }

    @Override // com.tencent.mobileqq.guild.message.api.impl.dispersionRoamMsg.op.a
    protected int a() {
        i();
        return 0;
    }
}
