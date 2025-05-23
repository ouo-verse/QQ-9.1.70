package com.tencent.mobileqq.msg.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IConfessMsgUtil extends QRouteApi {
    void bindC2CFirstMsgConfessInfo(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord, String str);

    void bindConfessInfo(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord, String str, int i3, int i16);

    void bindGroupFirstMsgConfessInfo(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord, String str);
}
