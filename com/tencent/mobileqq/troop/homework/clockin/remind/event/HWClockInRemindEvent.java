package com.tencent.mobileqq.troop.homework.clockin.remind.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/remind/event/HWClockInRemindEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "RemindListItemEvent", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/event/HWClockInRemindEvent$RemindListItemEvent;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public abstract class HWClockInRemindEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/remind/event/HWClockInRemindEvent$RemindListItemEvent;", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/event/HWClockInRemindEvent;", "studentUin", "", "isChecked", "", "(Ljava/lang/String;Z)V", "()Z", "getStudentUin", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final /* data */ class RemindListItemEvent extends HWClockInRemindEvent {
        static IPatchRedirector $redirector_;
        private final boolean isChecked;

        @NotNull
        private final String studentUin;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemindListItemEvent(@NotNull String studentUin, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(studentUin, "studentUin");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, studentUin, Boolean.valueOf(z16));
            } else {
                this.studentUin = studentUin;
                this.isChecked = z16;
            }
        }

        public static /* synthetic */ RemindListItemEvent copy$default(RemindListItemEvent remindListItemEvent, String str, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = remindListItemEvent.studentUin;
            }
            if ((i3 & 2) != 0) {
                z16 = remindListItemEvent.isChecked;
            }
            return remindListItemEvent.copy(str, z16);
        }

        @NotNull
        public final String component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.studentUin;
        }

        public final boolean component2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.isChecked;
        }

        @NotNull
        public final RemindListItemEvent copy(@NotNull String studentUin, boolean isChecked) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (RemindListItemEvent) iPatchRedirector.redirect((short) 6, this, studentUin, Boolean.valueOf(isChecked));
            }
            Intrinsics.checkNotNullParameter(studentUin, "studentUin");
            return new RemindListItemEvent(studentUin, isChecked);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof RemindListItemEvent)) {
                return false;
            }
            RemindListItemEvent remindListItemEvent = (RemindListItemEvent) other;
            if (Intrinsics.areEqual(this.studentUin, remindListItemEvent.studentUin) && this.isChecked == remindListItemEvent.isChecked) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getStudentUin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.studentUin;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            int hashCode = this.studentUin.hashCode() * 31;
            boolean z16 = this.isChecked;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        public final boolean isChecked() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isChecked;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "RemindListItemEvent(studentUin=" + this.studentUin + ", isChecked=" + this.isChecked + ")";
        }
    }

    public /* synthetic */ HWClockInRemindEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    HWClockInRemindEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
