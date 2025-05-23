package com.tencent.qqnt.aio.refresher;

import android.graphics.drawable.GradientDrawable;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/ab;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", Const.BUNDLE_KEY_REQUEST, "", "a", "", "b", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ab extends com.tencent.mobileqq.aio.msglist.holder.external.d {
    static IPatchRedirector $redirector_;

    public ab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.d
    public void a(@NotNull com.tencent.mobileqq.aio.msglist.holder.external.h request) {
        int[] b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        if (!(request instanceof ac)) {
            return;
        }
        ac acVar = (ac) request;
        com.tencent.qqnt.aio.nick.f M = acVar.a().M();
        if (M != null) {
            if (M.m()) {
                b16 = M.e();
            } else {
                b16 = M.b();
            }
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, b16);
            gradientDrawable.setCornerRadius(ViewUtils.dpToPx(4.0f));
            if (M.l() || M.m()) {
                acVar.c(new ad(new com.tencent.qqnt.aio.nick.e(null, null, gradientDrawable)));
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.d
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
