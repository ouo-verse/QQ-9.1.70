package com.tencent.mobileqq.qwallet.ipc;

import Wallet.AcsMsg;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IComIPCUtils extends QRouteApi {
    void cancelAlarmNotifaction(AcsMsg acsMsg);

    String ipcGetGuid();

    boolean isQQReminderOpen();

    void removeMessageRecord(AcsMsg acsMsg);

    void setAlarmNotifaction(AcsMsg acsMsg);

    void setQQReminderSwitch(boolean z16);
}
