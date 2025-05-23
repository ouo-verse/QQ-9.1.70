package com.tencent.mobileqq.qqlive.framework.page.manager.handler;

import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.framework.pagefacotry.ComponentNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/framework/page/manager/handler/a;", "Lcom/tencent/mobileqq/qqlive/framework/page/manager/handler/c;", "Lcom/tencent/mobileqq/qqlive/framework/pagefacotry/ComponentNode;", "node", "", "b", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/qqlive/framework/page/manager/c;", "extInterfaceManager", "", "a", "<init>", "()V", "qq-live-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a extends c {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.page.manager.handler.c
    public void a(@NotNull ComponentNode node, @NotNull ViewGroup rootView, @NotNull com.tencent.mobileqq.qqlive.framework.page.manager.c extInterfaceManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, node, rootView, extInterfaceManager);
            return;
        }
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(extInterfaceManager, "extInterfaceManager");
        com.tencent.mobileqq.qqlive.framework.page.manager.d.f271300a.a(extInterfaceManager, node.g().d());
    }

    @Override // com.tencent.mobileqq.qqlive.framework.page.manager.handler.c
    public boolean b(@NotNull ComponentNode node) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) node)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(node, "node");
        return true;
    }
}
