package com.tencent.mobileqq.qqlive.api.reminder;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H&J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/reminder/IQQLiveReminderApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createReportParams", "", "", "qqLiveNoticeInfo", "Lcom/tencent/mobileqq/qqlive/api/reminder/QQLiveNoticeInfo;", "destroy", "", "isQQLiveReminder", "", "busId", "msgId", "parseQQLiveNoticeInfo", "extendField", "unsubscribeReminder", "reminderInfo", "Lcom/tencent/mobileqq/qqlive/api/reminder/ReminderInfo;", "qq-live-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQLiveReminderApi extends QRouteApi {
    @NotNull
    Map<String, String> createReportParams(@NotNull QQLiveNoticeInfo qqLiveNoticeInfo);

    void destroy();

    boolean isQQLiveReminder(@Nullable String busId, @Nullable String msgId);

    @NotNull
    QQLiveNoticeInfo parseQQLiveNoticeInfo(@Nullable String extendField);

    void unsubscribeReminder(@NotNull ReminderInfo reminderInfo);
}
