package com.tencent.mobileqq.reminder.api;

import Wallet.AcsMsg;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"", "tool"})
/* loaded from: classes18.dex */
public interface IQQReminderAlarmService extends IRuntimeService {
    void cancelAlarmById(int i3);

    void clearAllAlarm();

    void setAlarmTimer(AcsMsg acsMsg);
}
