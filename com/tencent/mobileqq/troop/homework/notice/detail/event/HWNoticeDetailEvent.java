package com.tencent.mobileqq.troop.homework.notice.detail.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSchoolNoticeDetailRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/event/HWNoticeDetailEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "NoticeDetailError", "NoticeDetailUpdate", "Lcom/tencent/mobileqq/troop/homework/notice/detail/event/HWNoticeDetailEvent$NoticeDetailError;", "Lcom/tencent/mobileqq/troop/homework/notice/detail/event/HWNoticeDetailEvent$NoticeDetailUpdate;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public abstract class HWNoticeDetailEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/event/HWNoticeDetailEvent$NoticeDetailError;", "Lcom/tencent/mobileqq/troop/homework/notice/detail/event/HWNoticeDetailEvent;", "errorCode", "", "(I)V", "getErrorCode", "()I", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class NoticeDetailError extends HWNoticeDetailEvent {
        static IPatchRedirector $redirector_;
        private final int errorCode;

        public NoticeDetailError(int i3) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.errorCode = i3;
            }
        }

        public final int getErrorCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.errorCode;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/event/HWNoticeDetailEvent$NoticeDetailUpdate;", "Lcom/tencent/mobileqq/troop/homework/notice/detail/event/HWNoticeDetailEvent;", "detail", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSchoolNoticeDetailRsp;", "(Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSchoolNoticeDetailRsp;)V", "getDetail", "()Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSchoolNoticeDetailRsp;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class NoticeDetailUpdate extends HWNoticeDetailEvent {
        static IPatchRedirector $redirector_;

        @NotNull
        private final GetGroupSchoolNoticeDetailRsp detail;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoticeDetailUpdate(@NotNull GetGroupSchoolNoticeDetailRsp detail) {
            super(null);
            Intrinsics.checkNotNullParameter(detail, "detail");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) detail);
            } else {
                this.detail = detail;
            }
        }

        @NotNull
        public final GetGroupSchoolNoticeDetailRsp getDetail() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (GetGroupSchoolNoticeDetailRsp) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.detail;
        }
    }

    public /* synthetic */ HWNoticeDetailEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    HWNoticeDetailEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
