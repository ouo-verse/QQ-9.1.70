package com.tencent.aio.part.root.panel.mvx.service;

import com.tencent.aio.runtime.emitter.AIOFunctionEmitter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/part/root/panel/mvx/service/PanelStateServiceEmitter;", "Lcom/tencent/aio/runtime/emitter/AIOFunctionEmitter;", "Lcom/tencent/aio/part/root/panel/mvx/service/a;", "", "f", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class PanelStateServiceEmitter extends AIOFunctionEmitter<a> implements a {
    static IPatchRedirector $redirector_;

    public PanelStateServiceEmitter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.aio.part.root.panel.mvx.service.a
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            d(PanelStateServiceEmitter$onPanelShow$1.INSTANCE);
        }
    }
}
