package com.tencent.mobileqq.transfile.quic.internal;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.IQuicSoLoadApi;
import com.tencent.mobileqq.transfile.quic.open.ILoadSo;
import com.tencent.mobileqq.transfile.quic.open.ILoadSoCallback;

/* compiled from: P */
/* loaded from: classes19.dex */
public class LoadSoImp implements ILoadSo {
    static IPatchRedirector $redirector_;

    public LoadSoImp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static /* bridge */ /* synthetic */ boolean a() {
        return realLoadQuicSo();
    }

    public static void asyncLoadSo(ILoadSoCallback iLoadSoCallback) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.transfile.quic.internal.LoadSoImp.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ILoadSoCallback.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ILoadSoCallback.this.onLoad(LoadSoImp.a());
                }
            }
        });
    }

    private static boolean realLoadQuicSo() {
        return ((IQuicSoLoadApi) QRoute.api(IQuicSoLoadApi.class)).loadQuicSo();
    }

    @Override // com.tencent.mobileqq.transfile.quic.open.ILoadSo
    public void loadSo(ILoadSoCallback iLoadSoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iLoadSoCallback);
        } else {
            asyncLoadSo(iLoadSoCallback);
        }
    }
}
