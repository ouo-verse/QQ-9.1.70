package com.tencent.mobileqq.qwallet.transaction;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface INotifyMsgApi extends QRouteApi {
    boolean checkBusinessType(int i3);

    int getAAPayState(String str, MessageRecord messageRecord);

    String getAAPayState(MessageRecord messageRecord);

    boolean isBusinessTypeAAPay(int i3);

    void onActiveAccount();

    void onReceiveAAPaySysNotify(int i3, Object obj, Object obj2);
}
