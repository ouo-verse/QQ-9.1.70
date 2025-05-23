package com.tencent.qqnt.pluspanel.processor;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.poke.IPokeSendHelper;
import com.tencent.mobileqq.poke.NTPokePanel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.msg.element.AIOElementType;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/r;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "c", "Lmqq/app/AppRuntime;", "app", "", "pokePanelInfo", "b", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "", "a", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class r implements com.tencent.qqnt.pluspanel.logic.b {
    static IPatchRedirector $redirector_;

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(AppRuntime app, String pokePanelInfo) {
        if (TextUtils.isEmpty(pokePanelInfo)) {
            return true;
        }
        if (com.tencent.mobileqq.poke.f.g(app, 1) == 0 && com.tencent.mobileqq.poke.f.g(app, 0) == 0) {
            return true;
        }
        return false;
    }

    private final boolean c(com.tencent.aio.api.runtime.a context) {
        AppRuntime app = MobileQQ.sMobileQQ.peekAppRuntime();
        String h16 = com.tencent.mobileqq.poke.f.h(app);
        Intrinsics.checkNotNullExpressionValue(app, "app");
        if (b(app, h16)) {
            return false;
        }
        com.tencent.mobileqq.poke.f.b(app, context);
        NTPokePanel.n();
        NTPokePanel.m(app);
        if (NTPokePanel.f258962a0) {
            return true;
        }
        NTPokePanel.k(app);
        return false;
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(@NotNull com.tencent.qqnt.pluspanel.data.a data, @NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        if (c(context)) {
            context.e().h(new PlusPanelEvent.ClickButtonEvent(data));
            return;
        }
        AIOElementType.b bVar = new AIOElementType.b(0, 0, null, 0, null, null, 0, 0, null, null, 0, 0, null, 0, 0, null, null, 0, 0, 0, null, 0, 0, 8388607, null);
        bVar.F(1);
        String string = MobileQQ.sMobileQQ.getResources().getString(R.string.o39);
        Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.resources.getS\u2026.qqstr_messagep_8b492309)");
        bVar.C(string);
        ((IPokeSendHelper) QRoute.api(IPokeSendHelper.class)).sendPokeMsg(context, bVar);
    }
}
