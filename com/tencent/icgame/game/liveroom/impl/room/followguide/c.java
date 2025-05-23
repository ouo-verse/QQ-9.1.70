package com.tencent.icgame.game.liveroom.impl.room.followguide;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/followguide/c;", "", "Ljava/util/Date;", "date", "", "a", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "b", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "Ljava/text/SimpleDateFormat;", "c", "Ljava/text/SimpleDateFormat;", "getMDateFormatter", "()Ljava/text/SimpleDateFormat;", "setMDateFormatter", "(Ljava/text/SimpleDateFormat;)V", "mDateFormatter", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f115330a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IAegisLogApi mAegisLog;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static SimpleDateFormat mDateFormatter;

    static {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        mAegisLog = (IAegisLogApi) api;
        mDateFormatter = new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.getDefault());
    }

    c() {
    }

    @NotNull
    public final String a(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (1 == calendar.get(7)) {
            calendar.add(5, -1);
        }
        calendar.setFirstDayOfWeek(2);
        calendar.add(5, calendar.getFirstDayOfWeek() - calendar.get(7));
        String result = mDateFormatter.format(calendar.getTime());
        mAegisLog.i("ICGameFollowGuideDateUtil", 1, "getWeekStartDate date=" + date + ",result=" + result);
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }
}
