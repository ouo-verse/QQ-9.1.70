package com.tencent.mobileqq.reminder.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;
import mqq.observer.BusinessObserver;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes18.dex */
public interface IQQReminderService extends IRuntimeService {
    void queryNotifyIsSubscribed(String str, BusinessObserver businessObserver);

    void sendAckMsgs(ArrayList<String> arrayList, BusinessObserver businessObserver);

    void sendBatchSubscribeReminder(ArrayList<String> arrayList, String str, BusinessObserver businessObserver);

    void sendDelReminderListById(String str, long j3, int i3, BusinessObserver businessObserver);

    void sendGetMsgs(String str, String str2, BusinessObserver businessObserver);

    void sendReminderList(int i3, int i16, BusinessObserver businessObserver);

    void sendReminderListByDay(String str, BusinessObserver businessObserver);

    void sendSubscribeReminder(String str, String str2, BusinessObserver businessObserver);
}
