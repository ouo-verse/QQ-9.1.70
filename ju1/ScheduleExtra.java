package ju1;

import com.tencent.qqnt.kernelpublic.nativeinterface.CalendarElement;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lju1/b;", "Lju1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/CalendarElement;", "a", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/CalendarElement;", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/CalendarElement;", "calendarElement", "b", "I", "()I", QCircleLpReportDc010001.KEY_SUBTYPE, "<init>", "(Lcom/tencent/qqnt/kernelpublic/nativeinterface/CalendarElement;I)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ju1.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class ScheduleExtra implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final CalendarElement calendarElement;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int subType;

    public ScheduleExtra(@NotNull CalendarElement calendarElement, int i3) {
        Intrinsics.checkNotNullParameter(calendarElement, "calendarElement");
        this.calendarElement = calendarElement;
        this.subType = i3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final CalendarElement getCalendarElement() {
        return this.calendarElement;
    }

    /* renamed from: b, reason: from getter */
    public final int getSubType() {
        return this.subType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScheduleExtra)) {
            return false;
        }
        ScheduleExtra scheduleExtra = (ScheduleExtra) other;
        if (Intrinsics.areEqual(this.calendarElement, scheduleExtra.calendarElement) && this.subType == scheduleExtra.subType) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.calendarElement.hashCode() * 31) + this.subType;
    }

    @NotNull
    public String toString() {
        return "ScheduleExtra(calendarElement=" + this.calendarElement + ", subType=" + this.subType + ')';
    }
}
