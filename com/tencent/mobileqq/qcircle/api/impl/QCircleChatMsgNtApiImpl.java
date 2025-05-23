package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCircleChatMsgNtApi;
import com.tencent.mobileqq.qcircle.api.data.IQCircleMessageFacadeListener;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleChatMsgNtApiImpl implements IQCircleChatMsgNtApi {
    @Override // com.tencent.mobileqq.qcircle.api.IQCircleChatMsgNtApi
    public void addOrRemoveMsgFacadeObserver(IQCircleMessageFacadeListener iQCircleMessageFacadeListener) {
        g20.b.d().h(iQCircleMessageFacadeListener);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleChatMsgNtApi
    public void addRecentContactListenerAndFetch() {
        g20.b.d().c();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleChatMsgNtApi
    public void removeRecentContactListener() {
        g20.b.d().g();
    }
}
