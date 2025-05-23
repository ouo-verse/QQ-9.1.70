package com.tencent.qqnt.qbasealbum.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/event/PreviewExitEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class PreviewExitEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    public PreviewExitEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
