package com.tencent.mobileqq.qqlive.sso;

import androidx.annotation.NonNull;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class g extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final a f273200d;

    public g(@NonNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f273200d = aVar;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sso.f
    public void onReceive(int i3, boolean z16, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), hVar);
            return;
        }
        if (this.f273200d == null) {
            QLog.e("BaseSsoCallback", 1, "the callback is null");
            return;
        }
        if (z16) {
            if (hVar != null && hVar.e() != null) {
                if (hVar.b() != 0) {
                    this.f273200d.onBusinessFailed(hVar.b(), hVar.c());
                    return;
                }
                if (hVar.g() != 0) {
                    this.f273200d.onFailed(hVar.g(), "business error " + hVar.c());
                    return;
                }
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("BaseSsoCallback", 2, "onProxyRequestSuccess method:" + hVar.h().getServiceCmd());
                    }
                    this.f273200d.onProxyRequestSuccess(i3, hVar);
                    return;
                } catch (InvalidProtocolBufferNanoException unused) {
                    this.f273200d.onFailed(-1, " transform error: InvalidProtocolBufferNanoException ");
                    return;
                }
            }
            this.f273200d.onFailed(-1, "the data is null");
            return;
        }
        if (hVar.h() != null) {
            this.f273200d.onFailed(hVar.h().getResultCode(), "sso fail request: " + hVar.h().getServiceCmd());
        }
    }
}
