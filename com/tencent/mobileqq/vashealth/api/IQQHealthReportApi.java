package com.tencent.mobileqq.vashealth.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IQQHealthReportApi extends QRouteApi {
    void reportHealthMessageArrive(MessageRecord messageRecord);

    void reportHealthMessageClick(AppInterface appInterface, MessageRecord messageRecord);

    void reportHealthMessageExpose(AppInterface appInterface, MessageRecord messageRecord);
}
