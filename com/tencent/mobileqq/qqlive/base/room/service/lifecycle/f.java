package com.tencent.mobileqq.qqlive.base.room.service.lifecycle;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/f;", "", "Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/d;", "Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/e;", "", "b", "Landroid/os/Bundle;", "arguments", h.F, "a", "f", "e", "d", "g", "c", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/h;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/h;", "trigger", "Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/PageLifecycle;", "Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/PageLifecycle;", "curPageLifecycle", "pageVisible", "<init>", "(Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/h;Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/e;)V", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class f implements d, e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.framework.eventbroadcaster.h trigger;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ e f271140b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PageLifecycle curPageLifecycle;

    public f(@NotNull com.tencent.mobileqq.qqlive.framework.eventbroadcaster.h trigger, @NotNull e pageVisible) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Intrinsics.checkNotNullParameter(pageVisible, "pageVisible");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) trigger, (Object) pageVisible);
            return;
        }
        this.trigger = trigger;
        this.f271140b = pageVisible;
        this.curPageLifecycle = PageLifecycle.NONE;
    }

    public void a(@Nullable Bundle arguments) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) arguments);
        } else {
            this.trigger.C0(new com.tencent.mobileqq.qqlive.base.room.service.event.f(PageLifecycle.PAGE_ON_NEW_INTENT, arguments));
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        PageLifecycle pageLifecycle = PageLifecycle.PAGE_CREATE;
        this.curPageLifecycle = pageLifecycle;
        this.trigger.C0(new com.tencent.mobileqq.qqlive.base.room.service.event.f(pageLifecycle, null, 2, null));
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        PageLifecycle pageLifecycle = PageLifecycle.PAGE_DESTROY;
        this.curPageLifecycle = pageLifecycle;
        this.trigger.C0(new com.tencent.mobileqq.qqlive.base.room.service.event.f(pageLifecycle, null, 2, null));
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        PageLifecycle pageLifecycle = PageLifecycle.PAGE_PAUSE;
        this.curPageLifecycle = pageLifecycle;
        this.trigger.C0(new com.tencent.mobileqq.qqlive.base.room.service.event.f(pageLifecycle, null, 2, null));
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        PageLifecycle pageLifecycle = PageLifecycle.PAGE_RESUME;
        this.curPageLifecycle = pageLifecycle;
        this.trigger.C0(new com.tencent.mobileqq.qqlive.base.room.service.event.f(pageLifecycle, null, 2, null));
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        PageLifecycle pageLifecycle = PageLifecycle.PAGE_START;
        this.curPageLifecycle = pageLifecycle;
        this.trigger.C0(new com.tencent.mobileqq.qqlive.base.room.service.event.f(pageLifecycle, null, 2, null));
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        PageLifecycle pageLifecycle = PageLifecycle.PAGE_STOP;
        this.curPageLifecycle = pageLifecycle;
        this.trigger.C0(new com.tencent.mobileqq.qqlive.base.room.service.event.f(pageLifecycle, null, 2, null));
    }

    public void h(@Nullable Bundle arguments) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) arguments);
        } else {
            this.trigger.C0(new com.tencent.mobileqq.qqlive.base.room.service.event.f(PageLifecycle.PAGE_VIEW_CREATED, arguments));
        }
    }
}
