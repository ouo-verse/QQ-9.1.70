package com.tencent.mobileqq.troop.homework.notice.list.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolNoticeReq;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolNoticeRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/list/event/HWNoticeListUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "NoticeConfirmed", "NoticeDeleted", "NoticePublished", "Lcom/tencent/mobileqq/troop/homework/notice/list/event/HWNoticeListUpdateEvent$NoticeConfirmed;", "Lcom/tencent/mobileqq/troop/homework/notice/list/event/HWNoticeListUpdateEvent$NoticeDeleted;", "Lcom/tencent/mobileqq/troop/homework/notice/list/event/HWNoticeListUpdateEvent$NoticePublished;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public abstract class HWNoticeListUpdateEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/list/event/HWNoticeListUpdateEvent$NoticeConfirmed;", "Lcom/tencent/mobileqq/troop/homework/notice/list/event/HWNoticeListUpdateEvent;", "noticeId", "", "(Ljava/lang/String;)V", "getNoticeId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final /* data */ class NoticeConfirmed extends HWNoticeListUpdateEvent {
        static IPatchRedirector $redirector_;

        @NotNull
        private final String noticeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoticeConfirmed(@NotNull String noticeId) {
            super(null);
            Intrinsics.checkNotNullParameter(noticeId, "noticeId");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) noticeId);
            } else {
                this.noticeId = noticeId;
            }
        }

        public static /* synthetic */ NoticeConfirmed copy$default(NoticeConfirmed noticeConfirmed, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = noticeConfirmed.noticeId;
            }
            return noticeConfirmed.copy(str);
        }

        @NotNull
        public final String component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.noticeId;
        }

        @NotNull
        public final NoticeConfirmed copy(@NotNull String noticeId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (NoticeConfirmed) iPatchRedirector.redirect((short) 4, (Object) this, (Object) noticeId);
            }
            Intrinsics.checkNotNullParameter(noticeId, "noticeId");
            return new NoticeConfirmed(noticeId);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof NoticeConfirmed) && Intrinsics.areEqual(this.noticeId, ((NoticeConfirmed) other).noticeId)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getNoticeId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.noticeId;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.noticeId.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "NoticeConfirmed(noticeId=" + this.noticeId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/list/event/HWNoticeListUpdateEvent$NoticeDeleted;", "Lcom/tencent/mobileqq/troop/homework/notice/list/event/HWNoticeListUpdateEvent;", "noticeId", "", "(Ljava/lang/String;)V", "getNoticeId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final /* data */ class NoticeDeleted extends HWNoticeListUpdateEvent {
        static IPatchRedirector $redirector_;

        @NotNull
        private final String noticeId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoticeDeleted(@NotNull String noticeId) {
            super(null);
            Intrinsics.checkNotNullParameter(noticeId, "noticeId");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) noticeId);
            } else {
                this.noticeId = noticeId;
            }
        }

        public static /* synthetic */ NoticeDeleted copy$default(NoticeDeleted noticeDeleted, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = noticeDeleted.noticeId;
            }
            return noticeDeleted.copy(str);
        }

        @NotNull
        public final String component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.noticeId;
        }

        @NotNull
        public final NoticeDeleted copy(@NotNull String noticeId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (NoticeDeleted) iPatchRedirector.redirect((short) 4, (Object) this, (Object) noticeId);
            }
            Intrinsics.checkNotNullParameter(noticeId, "noticeId");
            return new NoticeDeleted(noticeId);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof NoticeDeleted) && Intrinsics.areEqual(this.noticeId, ((NoticeDeleted) other).noticeId)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getNoticeId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.noticeId;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.noticeId.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "NoticeDeleted(noticeId=" + this.noticeId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/list/event/HWNoticeListUpdateEvent$NoticePublished;", "Lcom/tencent/mobileqq/troop/homework/notice/list/event/HWNoticeListUpdateEvent;", "publishReq", "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolNoticeReq;", "publishRsp", "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolNoticeRsp;", "(Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolNoticeReq;Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolNoticeRsp;)V", "getPublishReq", "()Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolNoticeReq;", "getPublishRsp", "()Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolNoticeRsp;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final /* data */ class NoticePublished extends HWNoticeListUpdateEvent {
        static IPatchRedirector $redirector_;

        @NotNull
        private final PublishGroupSchoolNoticeReq publishReq;

        @NotNull
        private final PublishGroupSchoolNoticeRsp publishRsp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoticePublished(@NotNull PublishGroupSchoolNoticeReq publishReq, @NotNull PublishGroupSchoolNoticeRsp publishRsp) {
            super(null);
            Intrinsics.checkNotNullParameter(publishReq, "publishReq");
            Intrinsics.checkNotNullParameter(publishRsp, "publishRsp");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) publishReq, (Object) publishRsp);
            } else {
                this.publishReq = publishReq;
                this.publishRsp = publishRsp;
            }
        }

        public static /* synthetic */ NoticePublished copy$default(NoticePublished noticePublished, PublishGroupSchoolNoticeReq publishGroupSchoolNoticeReq, PublishGroupSchoolNoticeRsp publishGroupSchoolNoticeRsp, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                publishGroupSchoolNoticeReq = noticePublished.publishReq;
            }
            if ((i3 & 2) != 0) {
                publishGroupSchoolNoticeRsp = noticePublished.publishRsp;
            }
            return noticePublished.copy(publishGroupSchoolNoticeReq, publishGroupSchoolNoticeRsp);
        }

        @NotNull
        public final PublishGroupSchoolNoticeReq component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (PublishGroupSchoolNoticeReq) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.publishReq;
        }

        @NotNull
        public final PublishGroupSchoolNoticeRsp component2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (PublishGroupSchoolNoticeRsp) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.publishRsp;
        }

        @NotNull
        public final NoticePublished copy(@NotNull PublishGroupSchoolNoticeReq publishReq, @NotNull PublishGroupSchoolNoticeRsp publishRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (NoticePublished) iPatchRedirector.redirect((short) 6, (Object) this, (Object) publishReq, (Object) publishRsp);
            }
            Intrinsics.checkNotNullParameter(publishReq, "publishReq");
            Intrinsics.checkNotNullParameter(publishRsp, "publishRsp");
            return new NoticePublished(publishReq, publishRsp);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof NoticePublished)) {
                return false;
            }
            NoticePublished noticePublished = (NoticePublished) other;
            if (Intrinsics.areEqual(this.publishReq, noticePublished.publishReq) && Intrinsics.areEqual(this.publishRsp, noticePublished.publishRsp)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final PublishGroupSchoolNoticeReq getPublishReq() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PublishGroupSchoolNoticeReq) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.publishReq;
        }

        @NotNull
        public final PublishGroupSchoolNoticeRsp getPublishRsp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PublishGroupSchoolNoticeRsp) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.publishRsp;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.publishReq.hashCode() * 31) + this.publishRsp.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "NoticePublished(publishReq=" + this.publishReq + ", publishRsp=" + this.publishRsp + ")";
        }
    }

    public /* synthetic */ HWNoticeListUpdateEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    HWNoticeListUpdateEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
