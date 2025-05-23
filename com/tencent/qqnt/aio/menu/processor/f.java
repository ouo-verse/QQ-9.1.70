package com.tencent.qqnt.aio.menu.processor;

import android.os.Bundle;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.api.IAIOContactApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/menu/processor/f;", "Lcom/tencent/qqnt/aio/menu/processor/a;", "Lcom/tencent/qqnt/aio/menu/ui/c;", "menu", "Lcom/tencent/qqnt/aio/menu/ui/d;", "menuItem", "Landroid/os/Bundle;", "bundle", "", "a", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class f implements a {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.menu.processor.a
    public void a(@NotNull com.tencent.qqnt.aio.menu.ui.c menu, @NotNull com.tencent.qqnt.aio.menu.ui.d menuItem, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, menu, menuItem, bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        AIOMsgItem d16 = menuItem.d();
        Intrinsics.checkNotNullExpressionValue(d16, "menuItem.msgItem");
        if (com.tencent.qqnt.aio.msg.d.i(d16)) {
            return;
        }
        boolean z16 = bundle.getBoolean("isInvokeMenuShow");
        boolean isTroopOwnerOrAdmin = ((IAIOContactApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOContactApi.class)).isTroopOwnerOrAdmin(String.valueOf(menuItem.d().getMsgRecord().peerUin));
        if ((!z16 || isTroopOwnerOrAdmin) && Intrinsics.areEqual(q.f351469a.a(bundle), Boolean.FALSE)) {
            menu.a(menuItem);
        }
    }
}
