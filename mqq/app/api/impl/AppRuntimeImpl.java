package mqq.app.api.impl;

import mqq.app.MobileQQ;
import mqq.app.api.IAppRuntime;
import mqq.app.api.SSORequest;
import mqq.app.api.SSOResultCallback;

/* compiled from: P */
/* loaded from: classes28.dex */
public class AppRuntimeImpl implements IAppRuntime {
    @Override // mqq.app.api.IAppRuntime
    public String getAccount() {
        return MobileQQ.sMobileQQ.waitAppRuntime().getAccount();
    }

    @Override // mqq.app.api.IAppRuntime
    public void sendReq(SSORequest sSORequest, SSOResultCallback sSOResultCallback) {
        new SSOChannel().doSendRequest(sSORequest, sSOResultCallback);
    }
}
