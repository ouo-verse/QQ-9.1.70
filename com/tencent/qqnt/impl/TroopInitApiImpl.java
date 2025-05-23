package com.tencent.qqnt.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.ITroopInitApi;
import com.tencent.qqnt.f;
import com.tencent.qqnt.inner.ITroopInfoInnerService;
import com.tencent.qqnt.notification.ITroopNotificationInnerService;
import com.tencent.qqnt.push.ITroopPushInnerService;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/impl/TroopInitApiImpl;", "Lcom/tencent/qqnt/ITroopInitApi;", "()V", "onNTKernelSessionCreated", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class TroopInitApiImpl implements ITroopInitApi {
    static IPatchRedirector $redirector_;

    public TroopInitApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.ITroopInitApi
    public void onNTKernelSessionCreated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        f fVar = f.f356721a;
        ITroopInfoInnerService e16 = fVar.e();
        if (e16 != null) {
            e16.initAfterNTCreated();
        }
        ITroopPushInnerService g16 = fVar.g();
        if (g16 != null) {
            g16.initAfterNTCreated();
        }
        ITroopNotificationInnerService f16 = fVar.f();
        if (f16 != null) {
            f16.initAfterNTCreated();
        }
    }
}
