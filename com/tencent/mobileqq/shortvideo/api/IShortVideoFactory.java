package com.tencent.mobileqq.shortvideo.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import xq2.b;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes18.dex */
public interface IShortVideoFactory extends QRouteApi {
    b getAioShortVideoSendOperator(BaseQQAppInterface baseQQAppInterface);

    BaseTransProcessor getProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest);

    Class getShortVideoForwardProcessorClass();

    Class getShortVideoUploadProcessorClass();
}
