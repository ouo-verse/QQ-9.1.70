package com.tencent.mobileqq.gamecenter.qa.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IQQGameQARobotTemp extends QRouteApi {
    void reportMessageReach(MessageRecord messageRecord);
}
