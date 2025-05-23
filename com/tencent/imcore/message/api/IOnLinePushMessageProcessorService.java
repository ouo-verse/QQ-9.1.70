package com.tencent.imcore.message.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IOnLinePushMessageProcessorService extends QRouteApi {
    void changeBuddyOnline(AppInterface appInterface, long j3);

    String getPhoneNumByUin(AppInterface appInterface, String str);
}
