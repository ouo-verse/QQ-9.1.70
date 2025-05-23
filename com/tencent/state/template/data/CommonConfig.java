package com.tencent.state.template.data;

import com.tencent.mobileqq.vas.banner.c;
import com.tencent.state.library.calendar.CalendarEntryConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003H\u00c2\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/template/data/CommonConfig;", "", "reconnectTime", "", "calendarConfig", "Lcom/tencent/state/library/calendar/CalendarEntryConfig;", "(JLcom/tencent/state/library/calendar/CalendarEntryConfig;)V", "getCalendarConfig", "()Lcom/tencent/state/library/calendar/CalendarEntryConfig;", "reconnectInterval", "getReconnectInterval", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class CommonConfig {
    private final CalendarEntryConfig calendarConfig;
    private final long reconnectInterval;
    private final long reconnectTime;

    public CommonConfig() {
        this(0L, null, 3, null);
    }

    /* renamed from: component1, reason: from getter */
    private final long getReconnectTime() {
        return this.reconnectTime;
    }

    /* renamed from: component2, reason: from getter */
    public final CalendarEntryConfig getCalendarConfig() {
        return this.calendarConfig;
    }

    public final CommonConfig copy(long reconnectTime, CalendarEntryConfig calendarConfig) {
        Intrinsics.checkNotNullParameter(calendarConfig, "calendarConfig");
        return new CommonConfig(reconnectTime, calendarConfig);
    }

    public final CalendarEntryConfig getCalendarConfig() {
        return this.calendarConfig;
    }

    public final long getReconnectInterval() {
        return this.reconnectInterval;
    }

    public int hashCode() {
        int a16 = c.a(this.reconnectTime) * 31;
        CalendarEntryConfig calendarEntryConfig = this.calendarConfig;
        return a16 + (calendarEntryConfig != null ? calendarEntryConfig.hashCode() : 0);
    }

    public String toString() {
        return "CommonConfig(reconnectTime=" + this.reconnectTime + ", calendarConfig=" + this.calendarConfig + ")";
    }

    public CommonConfig(long j3, CalendarEntryConfig calendarConfig) {
        Intrinsics.checkNotNullParameter(calendarConfig, "calendarConfig");
        this.reconnectTime = j3;
        this.calendarConfig = calendarConfig;
        this.reconnectInterval = j3 * 1000;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonConfig)) {
            return false;
        }
        CommonConfig commonConfig = (CommonConfig) other;
        return this.reconnectTime == commonConfig.reconnectTime && Intrinsics.areEqual(this.calendarConfig, commonConfig.calendarConfig);
    }

    public /* synthetic */ CommonConfig(long j3, CalendarEntryConfig calendarEntryConfig, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 86400L : j3, (i3 & 2) != 0 ? new CalendarEntryConfig(false, null, null, 7, null) : calendarEntryConfig);
    }

    public static /* synthetic */ CommonConfig copy$default(CommonConfig commonConfig, long j3, CalendarEntryConfig calendarEntryConfig, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = commonConfig.reconnectTime;
        }
        if ((i3 & 2) != 0) {
            calendarEntryConfig = commonConfig.calendarConfig;
        }
        return commonConfig.copy(j3, calendarEntryConfig);
    }
}
