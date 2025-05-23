package com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/a;", "", "", "scene", "business", "", "a", "b", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f99004a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10984);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f99004a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String scene, @NotNull String business) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) scene, (Object) business);
            return;
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(business, "business");
        Iterator<com.tencent.cachedrawable.dynamicdrawable.cachedrawable.d> it = com.tencent.cachedrawable.dynamicdrawable.cachedrawable.e.f98943a.b(scene, business).iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    public final void b(@NotNull String scene, @NotNull String business) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) scene, (Object) business);
            return;
        }
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(business, "business");
        Iterator<com.tencent.cachedrawable.dynamicdrawable.cachedrawable.d> it = com.tencent.cachedrawable.dynamicdrawable.cachedrawable.e.f98943a.b(scene, business).iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }
}
