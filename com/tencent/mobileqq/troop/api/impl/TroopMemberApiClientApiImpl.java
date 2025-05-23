package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopMemberApiClientApiImpl implements ITroopMemberApiClientApi {
    static IPatchRedirector $redirector_;
    private com.tencent.biz.troop.b mClient;

    public TroopMemberApiClientApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mClient = null;
            this.mClient = com.tencent.biz.troop.b.A();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi
    public void clearHomeworkTroopRedPoint(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        } else {
            this.mClient.n(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi
    public void doBindService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mClient.p();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi
    public void doUnbindService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mClient.p();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi
    public void getTroopFileStatusInfo(long j3, String str, String str2, long j16, int i3, ITroopMemberApiClientApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), str, str2, Long.valueOf(j16), Integer.valueOf(i3), aVar);
        } else {
            this.mClient.J(j3, str, str2, j16, i3, aVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi
    public void openLocalFilePreview(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        } else {
            this.mClient.b0(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi
    public void studyRoomPicUpload(String str, ITroopMemberApiClientApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) aVar);
        } else {
            this.mClient.K0(str, aVar);
        }
    }
}
