package com.tencent.mobileqq.qqlive.base.room.service.event;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.base.room.service.lifecycle.PageLifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/service/event/f;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/PageLifecycle;", "c", "Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/PageLifecycle;", "d", "()Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/PageLifecycle;", "pageLifecycle", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "arguments", "<init>", "(Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/PageLifecycle;Landroid/os/Bundle;)V", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class f extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PageLifecycle pageLifecycle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bundle arguments;

    public /* synthetic */ f(PageLifecycle pageLifecycle, Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(pageLifecycle, (i3 & 2) != 0 ? null : bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, pageLifecycle, bundle, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Nullable
    public final Bundle c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.arguments;
    }

    @NotNull
    public final PageLifecycle d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PageLifecycle) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.pageLifecycle;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        if (this.pageLifecycle == fVar.pageLifecycle && Intrinsics.areEqual(this.arguments, fVar.arguments)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        int hashCode2 = this.pageLifecycle.hashCode() * 31;
        Bundle bundle = this.arguments;
        if (bundle == null) {
            hashCode = 0;
        } else {
            hashCode = bundle.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "PageLifecycleEvent(pageLifecycle=" + this.pageLifecycle + ", arguments=" + this.arguments + ')';
    }

    public f(@NotNull PageLifecycle pageLifecycle, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(pageLifecycle, "pageLifecycle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pageLifecycle, (Object) bundle);
        } else {
            this.pageLifecycle = pageLifecycle;
            this.arguments = bundle;
        }
    }
}
