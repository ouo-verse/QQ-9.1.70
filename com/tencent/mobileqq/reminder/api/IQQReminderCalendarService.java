package com.tencent.mobileqq.reminder.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {"", "tool"})
/* loaded from: classes18.dex */
public interface IQQReminderCalendarService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void onResult(Bundle bundle);
    }

    void addCalendarEntity(CalendarEntity calendarEntity);

    void deleteCalendarAlarm(AppActivity appActivity, CalendarEntity calendarEntity);

    void deleteCalendarEntity(CalendarEntity calendarEntity);

    boolean isCalendarOpen(Context context);

    List<CalendarEntity> queryCalendarEntity(String str);

    void setCalendarAlarm(AppActivity appActivity, CalendarEntity calendarEntity);

    void subCalendarNotify(AppActivity appActivity, String str, String str2, String str3, boolean z16, a aVar);
}
