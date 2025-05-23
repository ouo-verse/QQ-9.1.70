package com.qwallet.temp;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IStructmsgApi extends QRouteApi {
    String getBirthdayReminder(MessageRecord messageRecord);

    void handleStructMsgElement(MessageRecord messageRecord);

    boolean instanceofMessageForStructing(Object obj);

    void notifyAdExposureCheckersDestroy();

    void notifyAdExposureCheckersPause();

    void notifyAdExposureCheckersResume();
}
