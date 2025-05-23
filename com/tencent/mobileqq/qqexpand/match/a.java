package com.tencent.mobileqq.qqexpand.match;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.qqexpand.network.e;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a extends BaseStateHandler {

    /* renamed from: h, reason: collision with root package name */
    public final String f263922h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, int i3) {
        super(bVar, i3);
        this.f263922h = "ExtendFriendLimitChatIdleStateHandler";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.qqexpand.match.BaseStateHandler
    public void c(boolean z16) {
        QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCancelMatchMsg \u53d6\u6d88\u5339\u914d: " + z16);
    }

    @Override // com.tencent.mobileqq.qqexpand.match.BaseStateHandler
    public void f(int i3) {
        QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "requestMatch id" + i3);
        vg2.d dVar = new vg2.d();
        dVar.f441613i = i3;
        this.f263914d.h(101, dVar);
        e eVar = (e) this.f263914d.f263925f.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
        if (eVar != null) {
            eVar.T1(this.f263914d.f263925f.getCurrentAccountUin(), com.tencent.mobileqq.qqexpand.manager.c.r(this.f263914d.f263925f), i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.qqexpand.match.BaseStateHandler
    public void d(boolean z16, vg2.d dVar) {
        if (dVar == null) {
            QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg null indo");
            return;
        }
        QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
        if (z16) {
            h(dVar.f441607c, dVar.f441605a, dVar.f441606b);
            g(dVar.f441607c, dVar.f441612h);
        } else {
            QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onPushMsg ");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.qqexpand.match.BaseStateHandler
    public void e(boolean z16, int i3, vg2.d dVar, String str) {
        if (z16 && dVar != null) {
            QLog.i("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg \u8bf7\u6c42\u5339\u914d " + i3 + dVar.toString());
            return;
        }
        if (str == null) {
            str = "";
        }
        QLog.e("ExtendFriendLimitChatIdleStateHandler", 2, "onCSRequestMsg \u8bf7\u6c42\u5339\u914d\u5931\u8d25 suc:" + z16 + " ret:" + i3 + " errMsg : " + str);
    }
}
