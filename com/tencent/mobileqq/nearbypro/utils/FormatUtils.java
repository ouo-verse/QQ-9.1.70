package com.tencent.mobileqq.nearbypro.utils;

import androidx.annotation.Keep;
import com.heytap.databaseengine.utils.DateUtil;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002R\u001c\u0010\u0010\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0011R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/utils/FormatUtils;", "", "", "time", "", "a", "", "d", "publishedTime", "Lcom/tencent/mobileqq/nearbypro/utils/FormatUtils$StateTagTime;", "c", "timestamp", "b", "Ljava/text/NumberFormat;", "kotlin.jvm.PlatformType", "Ljava/text/NumberFormat;", "sNumberFormat", "J", "mYesterdayTime", "mTwoDayAgoTime", "e", "mThreeDayAgoTime", "f", "mOneWeekTime", "g", "mOneMonthTime", tl.h.F, "mOneYearTime", "<init>", "()V", "StateTagTime", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class FormatUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FormatUtils f253930a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final NumberFormat sNumberFormat;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long mYesterdayTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long mTwoDayAgoTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long mThreeDayAgoTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long mOneWeekTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static long mOneMonthTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long mOneYearTime;

    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/utils/FormatUtils$StateTagTime;", "", "tagTime", "", "isAnotherYear", "", "(Ljava/lang/String;Z)V", "()Z", "getTagTime", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final /* data */ class StateTagTime {
        private final boolean isAnotherYear;

        @NotNull
        private final String tagTime;

        public StateTagTime(@NotNull String tagTime, boolean z16) {
            Intrinsics.checkNotNullParameter(tagTime, "tagTime");
            this.tagTime = tagTime;
            this.isAnotherYear = z16;
        }

        public static /* synthetic */ StateTagTime copy$default(StateTagTime stateTagTime, String str, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = stateTagTime.tagTime;
            }
            if ((i3 & 2) != 0) {
                z16 = stateTagTime.isAnotherYear;
            }
            return stateTagTime.copy(str, z16);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getTagTime() {
            return this.tagTime;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsAnotherYear() {
            return this.isAnotherYear;
        }

        @NotNull
        public final StateTagTime copy(@NotNull String tagTime, boolean isAnotherYear) {
            Intrinsics.checkNotNullParameter(tagTime, "tagTime");
            return new StateTagTime(tagTime, isAnotherYear);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StateTagTime)) {
                return false;
            }
            StateTagTime stateTagTime = (StateTagTime) other;
            if (Intrinsics.areEqual(this.tagTime, stateTagTime.tagTime) && this.isAnotherYear == stateTagTime.isAnotherYear) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getTagTime() {
            return this.tagTime;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.tagTime.hashCode() * 31;
            boolean z16 = this.isAnotherYear;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        public final boolean isAnotherYear() {
            return this.isAnotherYear;
        }

        @NotNull
        public String toString() {
            return "StateTagTime(tagTime=" + this.tagTime + ", isAnotherYear=" + this.isAnotherYear + ")";
        }
    }

    static {
        FormatUtils formatUtils = new FormatUtils();
        f253930a = formatUtils;
        sNumberFormat = NumberFormat.getNumberInstance();
        formatUtils.d();
    }

    FormatUtils() {
    }

    private final String a(long time) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time));
        Intrinsics.checkNotNullExpressionValue(format, "f.format(Date(time))");
        return format;
    }

    @NotNull
    public final String b(long timestamp) {
        com.tencent.mobileqq.nearbypro.base.j.c().c("FormatUtils", "mYesterdayTime = " + mYesterdayTime + " timestamp = " + timestamp);
        if (timestamp >= mYesterdayTime) {
            String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR).format(new Date(timestamp));
            Intrinsics.checkNotNullExpressionValue(format, "{\n            SimpleDate\u2026ate(timestamp))\n        }");
            return format;
        }
        if (timestamp >= mTwoDayAgoTime) {
            String format2 = new SimpleDateFormat("\u6628\u5929 HH:mm").format(new Date(timestamp));
            Intrinsics.checkNotNullExpressionValue(format2, "{\n            SimpleDate\u2026ate(timestamp))\n        }");
            return format2;
        }
        if (timestamp >= mThreeDayAgoTime) {
            String format3 = new SimpleDateFormat("\u524d\u5929 HH:mm").format(new Date(timestamp));
            Intrinsics.checkNotNullExpressionValue(format3, "{\n            SimpleDate\u2026ate(timestamp))\n        }");
            return format3;
        }
        if (timestamp >= mOneYearTime) {
            String format4 = new SimpleDateFormat("M-dd HH:mm").format(new Date(timestamp));
            Intrinsics.checkNotNullExpressionValue(format4, "SimpleDateFormat(\"M-dd H\u2026).format(Date(timestamp))");
            return format4;
        }
        String format5 = new SimpleDateFormat("yy-MM-dd HH:mm").format(new Date(timestamp));
        Intrinsics.checkNotNullExpressionValue(format5, "{\n            SimpleDate\u2026ate(timestamp))\n        }");
        return format5;
    }

    @NotNull
    public final StateTagTime c(long publishedTime) {
        StateTagTime stateTagTime;
        if (publishedTime >= mYesterdayTime) {
            return new StateTagTime("\u4eca\u5929", false);
        }
        if (publishedTime >= mTwoDayAgoTime) {
            return new StateTagTime("\u6628\u5929", false);
        }
        if (publishedTime >= mThreeDayAgoTime) {
            return new StateTagTime("\u524d\u5929", false);
        }
        if (publishedTime >= mOneYearTime) {
            String format = new SimpleDateFormat("M\u6708dd\u65e5").format(new Date(publishedTime));
            Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"M\u6708dd\u65e5\"\u2026rmat(Date(publishedTime))");
            stateTagTime = new StateTagTime(format, false);
        } else {
            Calendar calendar = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
            calendar.setTime(new Date(publishedTime));
            String format2 = new SimpleDateFormat("yyyy\u5e74\nM\u6708dd\u65e5").format(new Date(publishedTime));
            Intrinsics.checkNotNullExpressionValue(format2, "SimpleDateFormat(\"yyyy\u5e74\\\u2026rmat(Date(publishedTime))");
            stateTagTime = new StateTagTime(format2, true);
        }
        return stateTagTime;
    }

    public final void d() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(5, 0);
        mYesterdayTime = calendar.getTimeInMillis();
        com.tencent.mobileqq.nearbypro.base.j.c().c("FormatUtils", "mYesterdayTime = " + a(mYesterdayTime));
        calendar.add(5, -1);
        mTwoDayAgoTime = calendar.getTimeInMillis();
        com.tencent.mobileqq.nearbypro.base.j.c().c("FormatUtils", "mTwoDayAgoTime = " + a(mTwoDayAgoTime));
        calendar.add(5, -1);
        mThreeDayAgoTime = calendar.getTimeInMillis();
        com.tencent.mobileqq.nearbypro.base.j.c().c("FormatUtils", "mThreeDayAgoTime = " + a(mThreeDayAgoTime));
        calendar.add(5, -5);
        mOneWeekTime = calendar.getTimeInMillis();
        com.tencent.mobileqq.nearbypro.base.j.c().c("FormatUtils", "mOneWeekTime = " + a(mOneWeekTime));
        calendar.add(5, 7);
        calendar.add(2, -1);
        mOneMonthTime = calendar.getTimeInMillis();
        com.tencent.mobileqq.nearbypro.base.j.c().c("FormatUtils", "mOneMonthTime = " + a(mOneMonthTime));
        calendar.set(5, 1);
        calendar.set(2, 12);
        calendar.add(1, -1);
        mOneYearTime = calendar.getTimeInMillis();
        com.tencent.mobileqq.nearbypro.base.j.c().c("FormatUtils", "mOneYearTime = " + a(mOneYearTime));
        NumberFormat numberFormat = sNumberFormat;
        numberFormat.setMaximumFractionDigits(1);
        numberFormat.setMinimumFractionDigits(1);
        numberFormat.setRoundingMode(RoundingMode.FLOOR);
    }
}
