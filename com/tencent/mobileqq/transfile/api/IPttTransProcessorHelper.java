package com.tencent.mobileqq.transfile.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IPttTransProcessorHelper extends QRouteApi {
    boolean checkIsJsPttClass(IHttpCommunicatorListener iHttpCommunicatorListener);

    BaseTransProcessor createPttTransProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest);

    Class getC2CPttDownloadProcessorClass();

    Class getC2CPttUpProcessorClass();

    Class getGroupPttDownloadProcessorClass();

    Class getGroupPttUpProcessorClass();

    Class getJSPttDownloadProcessorClass();

    Class getJSPttUpProcessorClass();

    Class getPAAudioDownloadProcessorClass();

    String getPAAudioPttPath(AppRuntime appRuntime, String str);

    Class getSlicePttUpProcessorClass();
}
