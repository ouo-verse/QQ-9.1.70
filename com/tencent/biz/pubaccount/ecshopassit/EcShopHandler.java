package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes4.dex */
public class EcShopHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f79577d;

    public EcShopHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f79577d = qQAppInterface;
    }

    public void D2() {
        notifyUI(4, true, null);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }
}
