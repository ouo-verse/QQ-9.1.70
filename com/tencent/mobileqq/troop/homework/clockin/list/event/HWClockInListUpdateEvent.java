package com.tencent.mobileqq.troop.homework.clockin.list.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolTaskReq;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolTaskRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/list/event/HWClockInListUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "ClockInDeleted", "ClockInPublished", "Lcom/tencent/mobileqq/troop/homework/clockin/list/event/HWClockInListUpdateEvent$ClockInDeleted;", "Lcom/tencent/mobileqq/troop/homework/clockin/list/event/HWClockInListUpdateEvent$ClockInPublished;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public abstract class HWClockInListUpdateEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/list/event/HWClockInListUpdateEvent$ClockInDeleted;", "Lcom/tencent/mobileqq/troop/homework/clockin/list/event/HWClockInListUpdateEvent;", "clockInId", "", "(Ljava/lang/String;)V", "getClockInId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final /* data */ class ClockInDeleted extends HWClockInListUpdateEvent {
        static IPatchRedirector $redirector_;

        @NotNull
        private final String clockInId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClockInDeleted(@NotNull String clockInId) {
            super(null);
            Intrinsics.checkNotNullParameter(clockInId, "clockInId");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) clockInId);
            } else {
                this.clockInId = clockInId;
            }
        }

        public static /* synthetic */ ClockInDeleted copy$default(ClockInDeleted clockInDeleted, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = clockInDeleted.clockInId;
            }
            return clockInDeleted.copy(str);
        }

        @NotNull
        public final String component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.clockInId;
        }

        @NotNull
        public final ClockInDeleted copy(@NotNull String clockInId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ClockInDeleted) iPatchRedirector.redirect((short) 4, (Object) this, (Object) clockInId);
            }
            Intrinsics.checkNotNullParameter(clockInId, "clockInId");
            return new ClockInDeleted(clockInId);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof ClockInDeleted) && Intrinsics.areEqual(this.clockInId, ((ClockInDeleted) other).clockInId)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getClockInId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.clockInId;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.clockInId.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "ClockInDeleted(clockInId=" + this.clockInId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0007H\u00c6\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/list/event/HWClockInListUpdateEvent$ClockInPublished;", "Lcom/tencent/mobileqq/troop/homework/clockin/list/event/HWClockInListUpdateEvent;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskReq;", "rsp", "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskRsp;", "troopNameListStr", "", "(Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskReq;Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskRsp;Ljava/lang/String;)V", "getReq", "()Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskReq;", "getRsp", "()Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskRsp;", "getTroopNameListStr", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final /* data */ class ClockInPublished extends HWClockInListUpdateEvent {
        static IPatchRedirector $redirector_;

        @NotNull
        private final PublishGroupSchoolTaskReq req;

        @NotNull
        private final PublishGroupSchoolTaskRsp rsp;

        @NotNull
        private final String troopNameListStr;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClockInPublished(@NotNull PublishGroupSchoolTaskReq req, @NotNull PublishGroupSchoolTaskRsp rsp, @NotNull String troopNameListStr) {
            super(null);
            Intrinsics.checkNotNullParameter(req, "req");
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Intrinsics.checkNotNullParameter(troopNameListStr, "troopNameListStr");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, req, rsp, troopNameListStr);
                return;
            }
            this.req = req;
            this.rsp = rsp;
            this.troopNameListStr = troopNameListStr;
        }

        public static /* synthetic */ ClockInPublished copy$default(ClockInPublished clockInPublished, PublishGroupSchoolTaskReq publishGroupSchoolTaskReq, PublishGroupSchoolTaskRsp publishGroupSchoolTaskRsp, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                publishGroupSchoolTaskReq = clockInPublished.req;
            }
            if ((i3 & 2) != 0) {
                publishGroupSchoolTaskRsp = clockInPublished.rsp;
            }
            if ((i3 & 4) != 0) {
                str = clockInPublished.troopNameListStr;
            }
            return clockInPublished.copy(publishGroupSchoolTaskReq, publishGroupSchoolTaskRsp, str);
        }

        @NotNull
        public final PublishGroupSchoolTaskReq component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (PublishGroupSchoolTaskReq) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.req;
        }

        @NotNull
        public final PublishGroupSchoolTaskRsp component2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (PublishGroupSchoolTaskRsp) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.rsp;
        }

        @NotNull
        public final String component3() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.troopNameListStr;
        }

        @NotNull
        public final ClockInPublished copy(@NotNull PublishGroupSchoolTaskReq req, @NotNull PublishGroupSchoolTaskRsp rsp, @NotNull String troopNameListStr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (ClockInPublished) iPatchRedirector.redirect((short) 8, this, req, rsp, troopNameListStr);
            }
            Intrinsics.checkNotNullParameter(req, "req");
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Intrinsics.checkNotNullParameter(troopNameListStr, "troopNameListStr");
            return new ClockInPublished(req, rsp, troopNameListStr);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClockInPublished)) {
                return false;
            }
            ClockInPublished clockInPublished = (ClockInPublished) other;
            if (Intrinsics.areEqual(this.req, clockInPublished.req) && Intrinsics.areEqual(this.rsp, clockInPublished.rsp) && Intrinsics.areEqual(this.troopNameListStr, clockInPublished.troopNameListStr)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final PublishGroupSchoolTaskReq getReq() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PublishGroupSchoolTaskReq) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.req;
        }

        @NotNull
        public final PublishGroupSchoolTaskRsp getRsp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PublishGroupSchoolTaskRsp) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.rsp;
        }

        @NotNull
        public final String getTroopNameListStr() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.troopNameListStr;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.req.hashCode() * 31) + this.rsp.hashCode()) * 31) + this.troopNameListStr.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "ClockInPublished(req=" + this.req + ", rsp=" + this.rsp + ", troopNameListStr=" + this.troopNameListStr + ")";
        }
    }

    public /* synthetic */ HWClockInListUpdateEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    HWClockInListUpdateEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
