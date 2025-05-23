package com.tencent.mobileqq.msg.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMsgBackupProxy extends QRouteApi {
    Object transToBackupEntity(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord, boolean z16);

    MessageRecord transToMessageRecord(BaseQQAppInterface baseQQAppInterface, Object obj);
}
