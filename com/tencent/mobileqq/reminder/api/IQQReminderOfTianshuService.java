package com.tencent.mobileqq.reminder.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"", "tool"})
/* loaded from: classes18.dex */
public interface IQQReminderOfTianshuService extends IRuntimeService {
    public static final int REQUEST_TIME_INTERVAL = 300;

    void getReminderDataFromTianshu(int i3);

    void report2Tianshu(int i3, String str, String str2);

    void updateRequestInterval(int i3, int i16);
}
