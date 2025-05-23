package com.tencent.mobileqq.msg.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.data.c;
import java.util.ArrayList;
import java.util.HashMap;

@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMultiMsgProxy extends QRouteApi {
    byte[] packPbFromMultiMsgWithNest(BaseQQAppInterface baseQQAppInterface, HashMap<String, ArrayList<MessageRecord>> hashMap, HashMap<String, String> hashMap2, boolean z16);

    HashMap<String, ArrayList<MessageRecord>> queryMultiMsgWithNest(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord);

    HashMap<String, ArrayList<MessageRecord>> unpackPbToMultiMsgWithNest(BaseQQAppInterface baseQQAppInterface, byte[] bArr, HashMap<String, String> hashMap, MessageRecord messageRecord, c cVar);

    void updateMultiMsg(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord);
}
