package com.tencent.aio.part.root.panel.mvx.vb;

import android.view.View;
import com.tencent.aio.part.root.panel.mvx.config.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Deprecated(message = "\u5e9f\u5f03")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/aio/part/root/panel/mvx/vb/a;", "", "Lcom/tencent/aio/part/root/panel/mvx/config/b;", "a", "Lcom/tencent/aio/part/root/panel/mvx/config/b;", "()Lcom/tencent/aio/part/root/panel/mvx/config/b;", "setProvider", "(Lcom/tencent/aio/part/root/panel/mvx/config/b;)V", "provider", "Landroid/view/View;", "b", "Landroid/view/View;", "()Landroid/view/View;", "c", "(Landroid/view/View;)V", "view", "<init>", "(Lcom/tencent/aio/part/root/panel/mvx/config/b;Landroid/view/View;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b provider;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View view;

    public a(@NotNull b provider, @NotNull View view) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) provider, (Object) view);
        } else {
            this.provider = provider;
            this.view = view;
        }
    }

    @NotNull
    public final b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (b) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.provider;
    }

    @NotNull
    public final View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.view;
    }

    public final void c(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.view = view;
        }
    }
}
