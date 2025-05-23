package com.tencent.mobileqq.aio.title;

import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.title.n;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qqnt.aio.api.IAIOContactApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/title/k;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/title/n;", "Lcom/tencent/mobileqq/aio/title/AIOTitleUIState;", "Lcom/tencent/mobileqq/aio/title/n$f;", "intent", "", DomainData.DOMAIN_NAME, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "o", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public final class k extends com.tencent.qqnt.aio.baseVM.a<n, AIOTitleUIState> {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent(FrameworkVM.TAG, false, 2, null));
        FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m() {
        if (com.tencent.mobileqq.aio.utils.am.f194110a.j((com.tencent.aio.api.runtime.a) getMContext())) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new LongShotMsgIntent.SetShotMode(false));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.LongShotModeChangeEvent(FrameworkVM.TAG, false));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new LongShotMsgIntent.ShotMosaic(false));
            return;
        }
        l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n(n.f intent) {
        intent.d(((com.tencent.aio.api.runtime.a) getMContext()).g().l().getBoolean("key_is_scale_chat"));
        intent.c(((IAIOContactApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOContactApi.class)).isRobot(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(LongShotMsgIntent.RemoveAllSelectMsg.f188613d);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.RefreshLongShotView.f188368d);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull n intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof n.C7362n) {
            m();
        } else if (intent instanceof n.l) {
            p();
        } else if (intent instanceof n.f) {
            n((n.f) intent);
        }
    }
}
