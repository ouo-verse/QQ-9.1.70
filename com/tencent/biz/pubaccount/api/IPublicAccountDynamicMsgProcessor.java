package com.tencent.biz.pubaccount.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountDynamicMsgProcessor extends QRouteApi {
    IPublicAccountDynamicMsgProcessor init(AppInterface appInterface, BusinessHandler businessHandler);

    void processHistoryMsg(long j3, List<msg_comm$Msg> list);
}
