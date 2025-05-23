package com.tencent.mobileqq.onlinestatus;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\bR0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/aa;", "", "", DetailMeFragmentConfig.CURRENT_STATUS_ID, "", "b", "", "time", "", "e", WidgetCacheConstellationData.INTERVAL, "d", "c", "a", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/onlinestatus/bz;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "statusIdTimePairMap", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class aa {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, TimePair> statusIdTimePairMap = new HashMap<>();

    public final void a() {
        this.statusIdTimePairMap.clear();
    }

    public final boolean b(int statusId) {
        boolean z16;
        TimePair timePair = this.statusIdTimePairMap.get(Integer.valueOf(statusId));
        if (timePair == null) {
            if (QLog.isColorLevel()) {
                QLog.d("IntervalChecker", 2, "expired: called. not stored \uff08\u5982\u679c\u672a\u5b58\u50a8\u65f6\u95f4\u95f4\u9694\uff0c\u9ed8\u8ba4\u653e\u884c\uff0c\u4e0d\u8fc7\u671f\uff09 ", "statusId: " + statusId);
            }
            return true;
        }
        if (timePair.getInterval() <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("IntervalChecker", 2, "expired: called. interval not set.\uff08\u5982\u679c\u672a\u5b58\u50a8\u65f6\u95f4\u95f4\u9694\uff0c\u9ed8\u8ba4\u653e\u884c\uff0c\u4e0d\u8fc7\u671f\uff09 ", "statusId: " + statusId);
            }
            return true;
        }
        if (NetConnInfoCenter.getServerTime() - timePair.getUpdateTimeSec() > timePair.getInterval()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IntervalChecker", 2, "expired: called. ", "expired: " + z16 + "  statusId: " + statusId + "  timePair: " + timePair);
        }
        return z16;
    }

    public final long c(int statusId) {
        TimePair timePair = this.statusIdTimePairMap.get(Integer.valueOf(statusId));
        if (timePair == null) {
            return 0L;
        }
        return timePair.getInterval();
    }

    public final void d(int statusId, long interval) {
        TimePair timePair = this.statusIdTimePairMap.get(Integer.valueOf(statusId));
        if (timePair == null) {
            TimePair timePair2 = new TimePair(interval, 0L);
            this.statusIdTimePairMap.put(Integer.valueOf(statusId), timePair2);
        } else {
            timePair.c(interval);
            this.statusIdTimePairMap.put(Integer.valueOf(statusId), timePair);
        }
    }

    public final void e(int statusId, long time) {
        TimePair timePair = this.statusIdTimePairMap.get(Integer.valueOf(statusId));
        if (timePair == null) {
            TimePair timePair2 = new TimePair(0L, time);
            this.statusIdTimePairMap.put(Integer.valueOf(statusId), timePair2);
            if (QLog.isColorLevel()) {
                QLog.d("IntervalChecker", 2, "updateTime: called. ", "newTimePair: " + timePair2);
                return;
            }
            return;
        }
        timePair.d(time);
        this.statusIdTimePairMap.put(Integer.valueOf(statusId), timePair);
        if (QLog.isColorLevel()) {
            QLog.d("IntervalChecker", 2, "updateTime: called. ", "timePair: " + timePair);
        }
    }
}
