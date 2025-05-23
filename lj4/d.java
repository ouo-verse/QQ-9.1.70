package lj4;

import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.liveroom.impl.room.followguide.FollowGuideConfigModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import lj4.c;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\rR\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001e\u00a8\u0006\""}, d2 = {"Llj4/d;", "", "", h.F, "", "roomId", "curTime", "Llj4/c;", "a", DownloadInfo.spKey_Config, "g", "c", "b", "", "d", "i", "", "j", "f", "e", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "getMDateFormatter", "()Ljava/text/SimpleDateFormat;", "setMDateFormatter", "(Ljava/text/SimpleDateFormat;)V", "mDateFormatter", "getMTimeFormat", "mTimeFormat", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "mAegisLog", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f414903a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static SimpleDateFormat mDateFormatter = new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.getDefault());

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SimpleDateFormat mTimeFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final IAegisLogApi mAegisLog;

    static {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        mAegisLog = (IAegisLogApi) api;
    }

    d() {
    }

    private final c a(long roomId, long curTime) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(roomId));
        c cVar = new c();
        cVar.k(arrayList);
        cVar.i(curTime);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Long.valueOf(roomId));
        cVar.j(arrayList2);
        cVar.h(curTime);
        mAegisLog.i("FollowGuideStrategy", 1, "getDefaultData =" + cVar);
        return cVar;
    }

    private final c b() {
        c c16 = c();
        if (c16 != null) {
            Date date = new Date(System.currentTimeMillis());
            String format = mDateFormatter.format(date);
            String format2 = mDateFormatter.format(Long.valueOf(c16.getRefreshTodayDataTimestamp()));
            if (!TextUtils.equals(format2, format)) {
                QLog.d("FollowGuideStrategy", 1, "getFilterdFollowGuideModel new day, last:" + format2 + ", today:" + format);
                c16.j(new ArrayList());
            }
            Date parse = mTimeFormat.parse(b.f414893a.a(date) + " 00:00:00");
            if (parse != null && c16.getRefreshWeeklyDataTimestamp() < parse.getTime()) {
                QLog.d("FollowGuideStrategy", 1, "getFilterdFollowGuideModel new week:" + parse);
                c16.k(new ArrayList());
            }
        }
        return c16;
    }

    private final c c() {
        boolean z16;
        String config = rm4.a.f("key_dialog_show", "");
        IAegisLogApi iAegisLogApi = mAegisLog;
        iAegisLogApi.i("FollowGuideStrategy", 1, "getFollowGuideModel sp config=" + config);
        if (config != null && config.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        c.Companion companion = c.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(config, "config");
        c a16 = companion.a(config);
        iAegisLogApi.i("FollowGuideStrategy", 1, "followGuideModel=" + a16);
        return a16;
    }

    private final int d(c config, long roomId) {
        boolean z16;
        List<Long> e16 = config.e();
        int i3 = 0;
        if (e16 != null && !e16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return 0;
        }
        Iterator<T> it = config.e().iterator();
        while (it.hasNext()) {
            if (((Number) it.next()).longValue() == roomId) {
                i3++;
            }
        }
        return i3;
    }

    private final boolean g(c config, long roomId) {
        boolean contains = config.d().contains(Long.valueOf(roomId));
        mAegisLog.i("FollowGuideStrategy", 1, "hasShowTimesDaily hasShow=" + contains + ",roomId=" + roomId);
        return contains;
    }

    private final boolean h() {
        boolean z16;
        c c16 = c();
        if (c16 == null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long lastDialogShowTimestamp = c16.getLastDialogShowTimestamp() + (FollowGuideConfigModel.INSTANCE.a().getShowInterval() * 60 * 1000);
        if (lastDialogShowTimestamp < currentTimeMillis) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("FollowGuideStrategy", 1, "isIntervalValid isSatisfy=" + z16 + ", nextShowTime=" + lastDialogShowTimestamp + ", curTime=" + currentTimeMillis);
        return z16;
    }

    public final int e() {
        int random;
        random = RangesKt___RangesKt.random(new IntRange(5, 10), Random.INSTANCE);
        mAegisLog.i("FollowGuideStrategy", 1, "getPushRandomTime randomNum=" + random);
        return random;
    }

    public final int f() {
        int random;
        random = RangesKt___RangesKt.random(new IntRange(30, 50), Random.INSTANCE);
        mAegisLog.i("FollowGuideStrategy", 1, "getRandomStayTime randomNum=" + random);
        return random;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i(long roomId) {
        boolean z16;
        boolean z17;
        FollowGuideConfigModel a16 = FollowGuideConfigModel.INSTANCE.a();
        if (!a16.getFeatureOn()) {
            QLog.d("FollowGuideStrategy", 1, "shouldShowGuide feature off");
            return false;
        }
        c b16 = b();
        if (b16 != null && (!b16.e().isEmpty() || a16.getMaxCountDailyRoom() <= 0 || a16.getMaxCountWeekly() <= 0)) {
            if (!g(b16, roomId)) {
                if (b16.d().size() >= a16.getMaxCountDailyRoom()) {
                    QLog.d("FollowGuideStrategy", 1, "shouldShowGuide todayRoomIds.size=" + b16.d().size() + ", maxCountDailyRoom=" + a16.getMaxCountDailyRoom());
                } else if (d(b16, roomId) >= a16.getMaxCountWeekly()) {
                    QLog.d("FollowGuideStrategy", 1, "shouldShowGuide getHasShowTimesWeek=" + d(b16, roomId) + ", maxCountWeekly=" + a16.getMaxCountWeekly());
                } else {
                    z16 = true;
                    if (!z16) {
                        z17 = h();
                    } else {
                        z17 = false;
                    }
                    QLog.d("FollowGuideStrategy", 1, "shouldShowGuide isMayShow=" + z16 + ", isIntervalValid=" + z17);
                    if (!z16 && z17) {
                        return true;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
            QLog.d("FollowGuideStrategy", 1, "shouldShowGuide isMayShow=" + z16 + ", isIntervalValid=" + z17);
            return !z16 ? false : false;
        }
        QLog.d("FollowGuideStrategy", 1, "shouldShowGuide weeklyRoomIds empty");
        return true;
    }

    public final void j(long roomId) {
        Long l3;
        c c16 = c();
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        String format = mDateFormatter.format(date);
        QLog.d("FollowGuideStrategy", 1, "updateAfterShow curTime=" + currentTimeMillis + ",date=" + date + ",today=" + format + ",followGuideModel=" + c16 + ",roomId:" + roomId);
        if (c16 == null) {
            c16 = a(roomId, currentTimeMillis);
        } else if (TextUtils.equals(mDateFormatter.format(Long.valueOf(c16.getRefreshTodayDataTimestamp())), format)) {
            c16.e().add(Long.valueOf(roomId));
            if (!c16.d().contains(Long.valueOf(roomId))) {
                c16.d().add(Long.valueOf(roomId));
            }
        } else {
            Date parse = mTimeFormat.parse(b.f414893a.a(date) + " 00:00:00");
            if (parse != null) {
                l3 = Long.valueOf(parse.getTime());
            } else {
                l3 = null;
            }
            QLog.d("FollowGuideStrategy", 1, "updateAfterShow startWeekTimeDate=" + l3);
            if (parse != null && c16.getRefreshWeeklyDataTimestamp() < parse.getTime()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(roomId));
                c16.k(arrayList);
                c16.i(currentTimeMillis);
            } else {
                c16.e().add(Long.valueOf(roomId));
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Long.valueOf(roomId));
            c16.j(arrayList2);
            c16.h(currentTimeMillis);
        }
        c16.g(currentTimeMillis);
        rm4.a.k("key_dialog_show", c16.f());
        QLog.d("FollowGuideStrategy", 1, "updateAfterShow result followGuideModel=" + c16);
    }
}
