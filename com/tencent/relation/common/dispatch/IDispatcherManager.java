package com.tencent.relation.common.dispatch;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.relation.common.dispatch.b;
import tencent.im.s2c.msgtype0x210.submsgtype0x14e.submsgtype0x14e$MsgBody;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IDispatcherManager<LISTENER extends b> extends QRouteApi {
    void deregisterDispatchListener(int i3, LISTENER listener);

    void handleMsgBody(submsgtype0x14e$MsgBody submsgtype0x14e_msgbody);

    void registerDispatchListener(int i3, LISTENER listener);
}
