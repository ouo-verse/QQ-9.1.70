package com.tencent.state.library.calendar;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/library/calendar/CalendarGuideMessage;", "", "focusTips", "", "seatTips", "(Ljava/lang/String;Ljava/lang/String;)V", "getFocusTips", "()Ljava/lang/String;", "getSeatTips", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final /* data */ class CalendarGuideMessage {
    private final String focusTips;
    private final String seatTips;

    public CalendarGuideMessage() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFocusTips() {
        return this.focusTips;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSeatTips() {
        return this.seatTips;
    }

    public final CalendarGuideMessage copy(String focusTips, String seatTips) {
        return new CalendarGuideMessage(focusTips, seatTips);
    }

    public final String getFocusTips() {
        return this.focusTips;
    }

    public final String getSeatTips() {
        return this.seatTips;
    }

    public int hashCode() {
        String str = this.focusTips;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.seatTips;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "CalendarGuideMessage(focusTips=" + this.focusTips + ", seatTips=" + this.seatTips + ")";
    }

    public CalendarGuideMessage(String str, String str2) {
        this.focusTips = str;
        this.seatTips = str2;
    }

    public /* synthetic */ CalendarGuideMessage(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalendarGuideMessage)) {
            return false;
        }
        CalendarGuideMessage calendarGuideMessage = (CalendarGuideMessage) other;
        return Intrinsics.areEqual(this.focusTips, calendarGuideMessage.focusTips) && Intrinsics.areEqual(this.seatTips, calendarGuideMessage.seatTips);
    }

    public static /* synthetic */ CalendarGuideMessage copy$default(CalendarGuideMessage calendarGuideMessage, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = calendarGuideMessage.focusTips;
        }
        if ((i3 & 2) != 0) {
            str2 = calendarGuideMessage.seatTips;
        }
        return calendarGuideMessage.copy(str, str2);
    }
}
