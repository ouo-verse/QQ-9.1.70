package com.tencent.mobileqq.troop.troopnotification.render;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationListVM;
import com.tencent.qqnt.notification.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/b;", "", "Lcom/tencent/qqnt/notification/f;", "notification", "", "c", "viewType", "b", "style", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationListVM;", "vm", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/a;", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f300733a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59203);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f300733a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final com.tencent.mobileqq.troop.troopnotification.render.vh.list.a a(int style, @NotNull Context context, @NotNull TroopNotificationListVM vm5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.troop.troopnotification.render.vh.list.a) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(style), context, vm5);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        if (style == 1) {
            return new com.tencent.mobileqq.troop.troopnotification.render.vh.list.b(context, vm5, null, 4, null);
        }
        return new com.tencent.mobileqq.troop.troopnotification.render.vh.list.b(context, vm5, null, 4, null);
    }

    public final int b(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, viewType)).intValue();
        }
        return viewType;
    }

    public final int c(@NotNull f notification) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) notification)).intValue();
        }
        Intrinsics.checkNotNullParameter(notification, "notification");
        return notification.i().c();
    }
}
