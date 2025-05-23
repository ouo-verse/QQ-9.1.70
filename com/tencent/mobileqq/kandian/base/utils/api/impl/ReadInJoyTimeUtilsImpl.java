package com.tencent.mobileqq.kandian.base.utils.api.impl;

import com.tencent.mobileqq.kandian.base.utils.ReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096\u0001J\u0011\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0096\u0001J\u0019\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0096\u0001\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/ReadInJoyTimeUtilsImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IReadInJoyTimeUtils;", "()V", "getDateTimeString", "", "secondTime", "", "getFullTimeString", QQPermissionConstants.Permission.CALENDAR_GROUP, "Ljava/util/Calendar;", "getMMDDTimeString", "ms", "getRelativeDisplayForTime", "timeSecond", "compareToServerTime", "", "isOnTheSameDay", "time1", "time2", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ReadInJoyTimeUtilsImpl implements IReadInJoyTimeUtils {
    private final /* synthetic */ ReadInJoyTimeUtils $$delegate_0 = ReadInJoyTimeUtils.INSTANCE;

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils
    public String getDateTimeString(long secondTime) {
        return this.$$delegate_0.getDateTimeString(secondTime);
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils
    public String getFullTimeString(Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "calendar");
        return this.$$delegate_0.getFullTimeString(calendar);
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils
    public String getMMDDTimeString(long ms5) {
        return this.$$delegate_0.getMMDDTimeString(ms5);
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils
    public String getRelativeDisplayForTime(long timeSecond, boolean compareToServerTime) {
        return this.$$delegate_0.getRelativeDisplayForTime(timeSecond, compareToServerTime);
    }

    @Override // com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyTimeUtils
    public boolean isOnTheSameDay(long time1, long time2) {
        return this.$$delegate_0.isOnTheSameDay(time1, time2);
    }
}
