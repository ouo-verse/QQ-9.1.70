package com.tencent.mobileqq.Doraemon.impl;

import android.os.Bundle;
import com.tencent.mobileqq.Doraemon.IDoraemonClient;
import com.tencent.mobileqq.Doraemon.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DoraemonClientImpl implements IDoraemonClient {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements ITroopMemberApiClientApi.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f154124d;

        a(d dVar) {
            this.f154124d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DoraemonClientImpl.this, (Object) dVar);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.a
        public void callback(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                return;
            }
            d dVar = this.f154124d;
            if (dVar != null) {
                dVar.a(bundle);
            }
        }
    }

    public DoraemonClientImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.IDoraemonClient
    public void sendToServer(int i3, Bundle bundle, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bundle, dVar);
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("key_sub_cmd", i3);
        com.tencent.biz.troop.b.A().x0(116, bundle, new a(dVar));
    }
}
