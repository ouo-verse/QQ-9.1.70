package com.tencent.mobileqq.aio.panel.ptt;

import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.panel.ptt.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/ptt/c;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/panel/ptt/a;", "Lcom/tencent/mobileqq/aio/panel/ptt/PttUIState;", "", DomainData.DOMAIN_NAME, "l", "", "o", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c extends com.tencent.qqnt.aio.baseVM.a<a, PttUIState> {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l() {
        if (o()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new InputEvent.ClearInputStatusEvent(com.tencent.mobileqq.aio.utils.inputstatus.a.INSTANCE.a(), ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n() {
        if (o()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new InputEvent.SendVoiceInputStatusEvent(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean o() {
        if (((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            a.b bVar = (a.b) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgSendEvent.PttSendEvent(bVar.d(), bVar.c(), bVar.b(), bVar.a(), false, false, 0, null, 240, null));
        } else if (intent instanceof a.c) {
            n();
        } else if (intent instanceof a.C7340a) {
            l();
        }
    }
}
