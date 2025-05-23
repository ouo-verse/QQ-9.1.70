package com.tencent.mobileqq.ptt.temp.api;

import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.IC2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.IGroupPttUploadProcessor;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPttTransferTempApi extends QRouteApi {
    BaseMessageObserver getC2CPttUploadProcessorMsgObserver(IC2CPttUploadProcessor iC2CPttUploadProcessor);

    BaseMessageObserver getGroupPttUploadProcessorMsgObserver(IGroupPttUploadProcessor iGroupPttUploadProcessor);
}
