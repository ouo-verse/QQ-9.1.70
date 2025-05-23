package com.tencent.mobileqq.qqlive.framework.pageevent.handler;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.e;
import com.tencent.mobileqq.qqlive.framework.page.Page;
import com.tencent.mobileqq.qqlive.framework.page.manager.PageManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/pageevent/handler/a;", "Lcom/tencent/mobileqq/qqlive/framework/pageevent/handler/b;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;", "event", "", "a", "<init>", "()V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.pageevent.handler.b
    public boolean a(@NotNull com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof e) {
            Iterator<Page> it = PageManager.f271291a.b().iterator();
            while (it.hasNext()) {
                it.next().C0(event);
            }
            return true;
        }
        return false;
    }
}
