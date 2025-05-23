package com.tencent.mobileqq.qqlive.base.room.service.lifecycle;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.framework.eventbroadcaster.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/a;", "", "Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/c;", "Landroid/content/Context;", "context", "", "g", "a", "e", "d", "c", "f", "b", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/h;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/h;", "trigger", "Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/ActivityLifecycle;", "Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/ActivityLifecycle;", "currentLifecycle", "Landroid/content/Context;", "<init>", "(Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/h;)V", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h trigger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ActivityLifecycle currentLifecycle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context context;

    public a(@NotNull h trigger) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) trigger);
        } else {
            this.trigger = trigger;
            this.currentLifecycle = ActivityLifecycle.NONE;
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ActivityLifecycle activityLifecycle = ActivityLifecycle.ON_CREATE;
        this.currentLifecycle = activityLifecycle;
        this.trigger.C0(new com.tencent.mobileqq.qqlive.base.room.service.event.a(activityLifecycle));
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ActivityLifecycle activityLifecycle = ActivityLifecycle.ON_DESTROY;
        this.currentLifecycle = activityLifecycle;
        this.trigger.C0(new com.tencent.mobileqq.qqlive.base.room.service.event.a(activityLifecycle));
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ActivityLifecycle activityLifecycle = ActivityLifecycle.ON_PAUSE;
        this.currentLifecycle = activityLifecycle;
        this.trigger.C0(new com.tencent.mobileqq.qqlive.base.room.service.event.a(activityLifecycle));
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        ActivityLifecycle activityLifecycle = ActivityLifecycle.ON_RESUME;
        this.currentLifecycle = activityLifecycle;
        this.trigger.C0(new com.tencent.mobileqq.qqlive.base.room.service.event.a(activityLifecycle));
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        ActivityLifecycle activityLifecycle = ActivityLifecycle.ON_START;
        this.currentLifecycle = activityLifecycle;
        this.trigger.C0(new com.tencent.mobileqq.qqlive.base.room.service.event.a(activityLifecycle));
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ActivityLifecycle activityLifecycle = ActivityLifecycle.ON_STOP;
        this.currentLifecycle = activityLifecycle;
        this.trigger.C0(new com.tencent.mobileqq.qqlive.base.room.service.event.a(activityLifecycle));
    }

    public void g(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }
    }
}
