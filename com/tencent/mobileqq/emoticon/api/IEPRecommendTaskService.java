package com.tencent.mobileqq.emoticon.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticon.IEPRecommendTask;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IEPRecommendTaskService extends QRouteApi {
    IEPRecommendTask createEPRecommendTask(BaseQQAppInterface baseQQAppInterface);
}
