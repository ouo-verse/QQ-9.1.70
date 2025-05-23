package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyTransFileController extends QRouteApi {
    BaseTransProcessor getProcessor(TransferRequest transferRequest);
}
