package com.tencent.state.library.calendar;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/library/calendar/CalendarEntryConfig;", "Ljava/io/Serializable;", "isShowEntry", "", "entryUrl", "", "guideConfig", "Lcom/tencent/state/library/calendar/CalendarGuideConfig;", "(ZLjava/lang/String;Lcom/tencent/state/library/calendar/CalendarGuideConfig;)V", "getEntryUrl", "()Ljava/lang/String;", "getGuideConfig", "()Lcom/tencent/state/library/calendar/CalendarGuideConfig;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final /* data */ class CalendarEntryConfig implements Serializable {
    private final String entryUrl;
    private final CalendarGuideConfig guideConfig;
    private final boolean isShowEntry;

    public CalendarEntryConfig() {
        this(false, null, null, 7, null);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsShowEntry() {
        return this.isShowEntry;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEntryUrl() {
        return this.entryUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final CalendarGuideConfig getGuideConfig() {
        return this.guideConfig;
    }

    public final CalendarEntryConfig copy(boolean isShowEntry, String entryUrl, CalendarGuideConfig guideConfig) {
        Intrinsics.checkNotNullParameter(entryUrl, "entryUrl");
        Intrinsics.checkNotNullParameter(guideConfig, "guideConfig");
        return new CalendarEntryConfig(isShowEntry, entryUrl, guideConfig);
    }

    public final String getEntryUrl() {
        return this.entryUrl;
    }

    public final CalendarGuideConfig getGuideConfig() {
        return this.guideConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isShowEntry;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        String str = this.entryUrl;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        CalendarGuideConfig calendarGuideConfig = this.guideConfig;
        return hashCode + (calendarGuideConfig != null ? calendarGuideConfig.hashCode() : 0);
    }

    public final boolean isShowEntry() {
        return this.isShowEntry;
    }

    public String toString() {
        return "CalendarEntryConfig(isShowEntry=" + this.isShowEntry + ", entryUrl=" + this.entryUrl + ", guideConfig=" + this.guideConfig + ")";
    }

    public CalendarEntryConfig(boolean z16, String entryUrl, CalendarGuideConfig guideConfig) {
        Intrinsics.checkNotNullParameter(entryUrl, "entryUrl");
        Intrinsics.checkNotNullParameter(guideConfig, "guideConfig");
        this.isShowEntry = z16;
        this.entryUrl = entryUrl;
        this.guideConfig = guideConfig;
    }

    public /* synthetic */ CalendarEntryConfig(boolean z16, String str, CalendarGuideConfig calendarGuideConfig, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? new CalendarGuideConfig(false, null, null, null, 15, null) : calendarGuideConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalendarEntryConfig)) {
            return false;
        }
        CalendarEntryConfig calendarEntryConfig = (CalendarEntryConfig) other;
        return this.isShowEntry == calendarEntryConfig.isShowEntry && Intrinsics.areEqual(this.entryUrl, calendarEntryConfig.entryUrl) && Intrinsics.areEqual(this.guideConfig, calendarEntryConfig.guideConfig);
    }

    public static /* synthetic */ CalendarEntryConfig copy$default(CalendarEntryConfig calendarEntryConfig, boolean z16, String str, CalendarGuideConfig calendarGuideConfig, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = calendarEntryConfig.isShowEntry;
        }
        if ((i3 & 2) != 0) {
            str = calendarEntryConfig.entryUrl;
        }
        if ((i3 & 4) != 0) {
            calendarGuideConfig = calendarEntryConfig.guideConfig;
        }
        return calendarEntryConfig.copy(z16, str, calendarGuideConfig);
    }
}
