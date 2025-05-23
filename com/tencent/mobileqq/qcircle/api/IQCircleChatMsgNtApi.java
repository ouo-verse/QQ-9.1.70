package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qcircle.api.data.IQCircleMessageFacadeListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleChatMsgNtApi extends QRouteApi {
    void addOrRemoveMsgFacadeObserver(IQCircleMessageFacadeListener iQCircleMessageFacadeListener);

    void addRecentContactListenerAndFetch();

    void removeRecentContactListener();
}
