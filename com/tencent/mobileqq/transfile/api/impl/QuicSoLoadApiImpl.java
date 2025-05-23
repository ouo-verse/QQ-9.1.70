package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoLoaderService;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.transfile.api.IQuicSoLoadApi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QuicSoLoadApiImpl implements IQuicSoLoadApi {
    static IPatchRedirector $redirector_;

    public QuicSoLoadApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.api.IQuicSoLoadApi
    public boolean loadQuicSo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        LoadExtResult loadSequentiallySync = ((ISoLoaderService) QRoute.api(ISoLoaderService.class)).loadSequentiallySync(new String[]{"andromeda", "quic_engine"}, null);
        if (QLog.isColorLevel()) {
            QLog.d("QuicSoLoad", 2, "quic load code: " + loadSequentiallySync.getResultCode());
        }
        return loadSequentiallySync.isSucc();
    }
}
