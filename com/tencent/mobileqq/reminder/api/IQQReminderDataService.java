package com.tencent.mobileqq.reminder.api;

import Wallet.AcsMsg;
import bm2.b;
import bm2.c;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.reminder.OnDeleteReminderFailListener;
import com.tencent.mobileqq.reminder.biz.entity.a;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"", "tool"})
/* loaded from: classes18.dex */
public interface IQQReminderDataService extends IRuntimeService {
    public static final String QQ_REMINDER_MSG_ID_NOW_LIVE = "e64b180ff8054a594ae306955aee70c7";

    void checkTodayReminder();

    void deleteReminderByMsgId(String str, OnDeleteReminderFailListener onDeleteReminderFailListener);

    void doNotifaction(String str, String str2);

    void doNotifyByPush(AcsMsg acsMsg);

    List<String> getCacheKeyList();

    a getEntityByKey(String str);

    void getReminderListByday(String str, b bVar);

    boolean getSwitchHideNowReminder();

    void getTodayReminderMsgAsync(bm2.a aVar, boolean z16);

    void saveReminderMsg(AcsMsg acsMsg);

    void setMsgRead();

    void setQQNotifyListener(c cVar);
}
