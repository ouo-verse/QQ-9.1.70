package com.tencent.qqnt.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/event/TroopNotificationEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "OnDismissEvent", "OnShowEvent", "Lcom/tencent/qqnt/event/TroopNotificationEvent$OnDismissEvent;", "Lcom/tencent/qqnt/event/TroopNotificationEvent$OnShowEvent;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public abstract class TroopNotificationEvent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/event/TroopNotificationEvent$OnDismissEvent;", "Lcom/tencent/qqnt/event/TroopNotificationEvent;", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class OnDismissEvent extends TroopNotificationEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnDismissEvent f356710d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63957);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f356710d = new OnDismissEvent();
            }
        }

        OnDismissEvent() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.event.TroopNotificationEvent.OnDismissEvent";
        }
    }

    /* compiled from: P */
    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/event/TroopNotificationEvent$OnShowEvent;", "Lcom/tencent/qqnt/event/TroopNotificationEvent;", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class OnShowEvent extends TroopNotificationEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnShowEvent f356711d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63959);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f356711d = new OnShowEvent();
            }
        }

        OnShowEvent() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.event.TroopNotificationEvent.OnShowEvent";
        }
    }

    public /* synthetic */ TroopNotificationEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }

    TroopNotificationEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
