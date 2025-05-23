package com.tencent.mobileqq.transfile.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;

@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface ITransProcessorCreater extends QRouteApi {
    BaseTransProcessor createProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest);

    Class<?> getProcessorClazz();
}
