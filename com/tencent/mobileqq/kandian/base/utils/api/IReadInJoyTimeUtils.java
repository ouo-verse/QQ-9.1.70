package com.tencent.mobileqq.kandian.base.utils.api;

import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Calendar;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyTimeUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDateTimeString", "", "secondTime", "", "getFullTimeString", QQPermissionConstants.Permission.CALENDAR_GROUP, "Ljava/util/Calendar;", "getMMDDTimeString", "ms", "getRelativeDisplayForTime", "timeSecond", "compareToServerTime", "", "isOnTheSameDay", "time1", "time2", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IReadInJoyTimeUtils extends QRouteApi {
    @NotNull
    String getDateTimeString(long secondTime);

    @NotNull
    String getFullTimeString(@NotNull Calendar calendar);

    @NotNull
    String getMMDDTimeString(long ms5);

    @NotNull
    String getRelativeDisplayForTime(long timeSecond, boolean compareToServerTime);

    boolean isOnTheSameDay(long time1, long time2);
}
