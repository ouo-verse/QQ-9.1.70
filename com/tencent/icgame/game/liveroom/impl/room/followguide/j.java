package com.tencent.icgame.game.liveroom.impl.room.followguide;

import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.followguide.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
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
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bR\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/followguide/j;", "", "", "roomId", "curTime", "Lcom/tencent/icgame/game/liveroom/impl/room/followguide/i;", "a", DownloadInfo.spKey_Config, "", "f", "b", "", "c", "g", tl.h.F, "", "i", "e", "d", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "getMDateFormatter", "()Ljava/text/SimpleDateFormat;", "setMDateFormatter", "(Ljava/text/SimpleDateFormat;)V", "mDateFormatter", "getMTimeFormat", "mTimeFormat", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f115347a = new j();

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

    j() {
    }

    private final i a(long roomId, long curTime) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(roomId));
        i iVar = new i();
        iVar.k(arrayList);
        iVar.i(curTime);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Long.valueOf(roomId));
        iVar.j(arrayList2);
        iVar.h(curTime);
        mAegisLog.i("ICGameFollowGuideStrategy", 1, "getDefaultData =" + iVar);
        return iVar;
    }

    private final i b() {
        boolean z16;
        String config = rx0.a.f("key_dialog_show", "");
        IAegisLogApi iAegisLogApi = mAegisLog;
        iAegisLogApi.i("ICGameFollowGuideStrategy", 1, "getFollowGuideModel sp config=" + config);
        if (config != null && config.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        i.Companion companion = i.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(config, "config");
        i a16 = companion.a(config);
        iAegisLogApi.i("ICGameFollowGuideStrategy", 1, "followGuideModel=" + a16);
        return a16;
    }

    private final int c(i config, long roomId) {
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

    private final boolean f(i config, long roomId) {
        boolean contains = config.d().contains(Long.valueOf(roomId));
        mAegisLog.i("ICGameFollowGuideStrategy", 1, "hasShowTimesDaily hasShow=" + contains + ",roomId=" + roomId);
        return contains;
    }

    public final int d() {
        int random;
        random = RangesKt___RangesKt.random(new IntRange(5, 10), Random.INSTANCE);
        mAegisLog.i("ICGameFollowGuideStrategy", 1, "getPushRandomTime randomNum=" + random);
        return random;
    }

    public final int e() {
        int random;
        random = RangesKt___RangesKt.random(new IntRange(30, 50), Random.INSTANCE);
        mAegisLog.i("ICGameFollowGuideStrategy", 1, "getRandomStayTime randomNum=" + random);
        return random;
    }

    public final boolean g(long roomId) {
        List<Long> list;
        i b16 = b();
        String str = null;
        if (b16 != null) {
            list = b16.e();
        } else {
            list = null;
        }
        if (list == null) {
            IAegisLogApi iAegisLogApi = mAegisLog;
            if (b16 != null) {
                str = b16.toString();
            }
            iAegisLogApi.i("ICGameFollowGuideStrategy", 1, "isMayShowGuide true!followGuideModel= null followGuideModel=" + str);
            return true;
        }
        FollowGuideConfigModel a16 = FollowGuideConfigModel.INSTANCE.a();
        boolean z16 = false;
        if (!f(b16, roomId)) {
            if (b16.d().size() > a16.getMaxCountDailyRoom()) {
                mAegisLog.i("ICGameFollowGuideStrategy", 1, "isMayShowGuide isMayShow=false,\u6bcf\u4e2a\u7528\u6237\u6bcf\u5929\u6700\u591a\u6536\u5230" + a16.getMaxCountDailyRoom() + "\u4e2a\u76f4\u64ad\u95f4");
            } else if (c(b16, roomId) > a16.getMaxCountWeekly()) {
                mAegisLog.i("ICGameFollowGuideStrategy", 1, "isMayShowGuide isMayShow=false,\u6bcf\u4e2a\u7528\u6237\u6bcf\u5468\u6700\u591a\u6536\u5230" + a16.getMaxCountWeekly() + "\u6761\u540c\u4e00\u4e3b\u64ad\u7684\u5173\u6ce8\u5f15\u5bfc");
            } else {
                z16 = true;
            }
        }
        mAegisLog.i("ICGameFollowGuideStrategy", 1, "isMayShowGuide isMayShow=" + z16);
        return z16;
    }

    public final boolean h() {
        boolean z16;
        i b16 = b();
        if (b16 == null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long lastDialogShowTimestamp = b16.getLastDialogShowTimestamp() + (FollowGuideConfigModel.INSTANCE.a().getShowInterval() * 60 * 1000);
        if (lastDialogShowTimestamp < currentTimeMillis) {
            z16 = true;
        } else {
            z16 = false;
        }
        mAegisLog.i("ICGameFollowGuideStrategy", 1, "isSatisfyInterval isSatisfy=" + z16 + " ,nextShowTime=" + lastDialogShowTimestamp + ",curTime=" + currentTimeMillis);
        return z16;
    }

    public final void i(long roomId) {
        Long l3;
        i b16 = b();
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        String format = mDateFormatter.format(date);
        IAegisLogApi iAegisLogApi = mAegisLog;
        iAegisLogApi.i("ICGameFollowGuideStrategy", 1, "updateAfterShow curTime=" + currentTimeMillis + ",date=" + date + ",today=" + format + ",followGuideModel=" + b16);
        if (b16 == null) {
            b16 = a(roomId, currentTimeMillis);
        } else if (TextUtils.equals(mDateFormatter.format(Long.valueOf(b16.getRefreshTodayDataTimestamp())), format)) {
            b16.e().add(Long.valueOf(roomId));
            b16.d().add(Long.valueOf(roomId));
        } else {
            Date parse = mTimeFormat.parse(c.f115330a.a(date) + " 00:00:00");
            if (parse != null) {
                l3 = Long.valueOf(parse.getTime());
            } else {
                l3 = null;
            }
            iAegisLogApi.i("ICGameFollowGuideStrategy", 1, "updateAfterShow startWeekTimeDate=" + l3);
            if (parse != null && b16.getRefreshWeeklyDataTimestamp() < parse.getTime()) {
                iAegisLogApi.i("ICGameFollowGuideStrategy", 1, "updateAfterShow \u91cd\u7f6e\u5468\u6570\u636e");
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(roomId));
                b16.k(arrayList);
                b16.i(currentTimeMillis);
            } else {
                b16.d().add(Long.valueOf(roomId));
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Long.valueOf(roomId));
            b16.j(arrayList2);
            b16.h(currentTimeMillis);
        }
        b16.g(currentTimeMillis);
        rx0.a.k("key_dialog_show", b16.f());
        iAegisLogApi.i("ICGameFollowGuideStrategy", 1, "updateAfterShow result followGuideModel=" + b16);
    }
}
