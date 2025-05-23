package com.tencent.qqnt.forwardaio.title;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.aio.forward.api.IForwardAIOApi;
import com.tencent.qqnt.forwardaio.title.ForwardShareAIOTitleUIState;
import com.tencent.qqnt.forwardaio.title.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/forwardaio/title/j;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/qqnt/forwardaio/title/h;", "Lcom/tencent/qqnt/forwardaio/title/ForwardShareAIOTitleUIState;", "", "l", "Lcom/tencent/qqnt/forwardaio/title/h$b;", "intent", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class j extends com.tencent.qqnt.aio.baseVM.a<h, ForwardShareAIOTitleUIState> {
    static IPatchRedirector $redirector_;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l() {
        updateUI(new ForwardShareAIOTitleUIState.UpdateTitle(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().g()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n(h.b intent) {
        FragmentActivity activity;
        if (!((IForwardAIOApi) QRoute.api(IForwardAIOApi.class)).dispatchOnBack(intent.a()) && (activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity()) != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull h intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof h.a) {
            l();
        } else if (intent instanceof h.b) {
            n((h.b) intent);
        }
    }
}
