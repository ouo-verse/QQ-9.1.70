package com.tencent.mobileqq.reminder.api;

import Wallet.AcsMsg;
import Wallet.a;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes18.dex */
public interface IQQReminderMsgService extends IRuntimeService {
    AcsMsg getLastNoticeMsg(MessageRecord messageRecord);

    void onClickNoticeReport(AcsMsg acsMsg);

    void onShowNoticeReport(AcsMsg acsMsg);

    void onSystemNotificationShow();

    void onSystemNotificationShow(Message message);

    void registerNtSysMsgNotification();

    void showRemindDialog(a aVar);
}
