package com.tencent.mobileqq.troop.halfscreennotification.api.impl;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.halfscreennotification.TroopHalfScreenNotificationHelper;
import com.tencent.mobileqq.troop.halfscreennotification.api.ITroopHalfScreenNotificationApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/halfscreennotification/api/impl/TroopHalfScreenNotificationApiImpl;", "Lcom/tencent/mobileqq/troop/halfscreennotification/api/ITroopHalfScreenNotificationApi;", "", "notifyHalfScreenNotificationAvailable", "Lcom/tencent/aio/main/businesshelper/h;", "createHelper", "<init>", "()V", "HalfScreenNotificationEvent", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopHalfScreenNotificationApiImpl implements ITroopHalfScreenNotificationApi {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/troop/halfscreennotification/api/impl/TroopHalfScreenNotificationApiImpl$HalfScreenNotificationEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class HalfScreenNotificationEvent extends SimpleBaseEvent {
        static IPatchRedirector $redirector_;

        public HalfScreenNotificationEvent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public TroopHalfScreenNotificationApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.halfscreennotification.api.ITroopHalfScreenNotificationApi
    @NotNull
    public h createHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (h) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new TroopHalfScreenNotificationHelper();
    }

    @Override // com.tencent.mobileqq.troop.halfscreennotification.api.ITroopHalfScreenNotificationApi
    public void notifyHalfScreenNotificationAvailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new HalfScreenNotificationEvent());
        }
    }
}
