package com.tencent.mobileqq.aio.msgbox.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/aio/msgbox/event/MsgBoxEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "HideMsgBoxEvent", "ShowMsgBoxEvent", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public class MsgBoxEvent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/msgbox/event/MsgBoxEvent$HideMsgBoxEvent;", "Lcom/tencent/mobileqq/aio/msgbox/event/MsgBoxEvent;", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class HideMsgBoxEvent extends MsgBoxEvent {
        static IPatchRedirector $redirector_;

        public HideMsgBoxEvent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "com.tencent.mobileqq.aio.msgbox.event.MsgBoxEvent.HideMsgBoxEvent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msgbox/event/MsgBoxEvent$ShowMsgBoxEvent;", "Lcom/tencent/mobileqq/aio/msgbox/event/MsgBoxEvent;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class ShowMsgBoxEvent extends MsgBoxEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final RecentContactInfo info;

        public ShowMsgBoxEvent(@Nullable RecentContactInfo recentContactInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentContactInfo);
            } else {
                this.info = recentContactInfo;
            }
        }

        @Nullable
        public final RecentContactInfo a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RecentContactInfo) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.info;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.mobileqq.aio.msgbox.event.MsgBoxEvent.ShowMsgBoxEvent";
        }
    }

    public MsgBoxEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }
}
