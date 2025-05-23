package com.tencent.mobileqq.filebrowser;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tbstool.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/ClickProxy;", "", "Landroid/view/View;", "view", "Landroid/view/View$OnClickListener;", "proxyListener", "", "a", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ClickProxy {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ClickProxy f205870a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19763);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f205870a = new ClickProxy();
        }
    }

    ClickProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull View view, @NotNull View.OnClickListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) proxyListener);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(proxyListener, "proxyListener");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(i.b(16)), null, null, new ClickProxy$hookClickListener$1(view, proxyListener, null), 3, null);
    }
}
