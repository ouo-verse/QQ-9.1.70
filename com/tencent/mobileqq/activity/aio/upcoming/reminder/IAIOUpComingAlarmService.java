package com.tencent.mobileqq.activity.aio.upcoming.reminder;

import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qroute.annotation.Service;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/upcoming/reminder/IAIOUpComingAlarmService;", "Lmqq/app/api/IRuntimeService;", "cancelAlarm", "", "colorNote", "Lcom/tencent/mobileqq/colornote/data/ColorNote;", "notifyAlarm", QCircleLpReportDc010001.KEY_SUBTYPE, "", "setAlarm", "time", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public interface IAIOUpComingAlarmService extends IRuntimeService {
    void cancelAlarm(@NotNull ColorNote colorNote);

    void notifyAlarm(@NotNull String subType);

    void setAlarm(long time, @NotNull ColorNote colorNote);
}
