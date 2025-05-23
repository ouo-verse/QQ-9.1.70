package com.tencent.mobileqq.ecshop.ad;

import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EcshopAdHandler extends BusinessHandler implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public long f203939d;

    public EcshopAdHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ecshop.ad.b
                @Override // java.lang.Runnable
                public final void run() {
                    EcshopAdHandler.E2();
                }
            }, 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E2() {
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(BaseApplication.getContext(), new InitGdtContextParams());
    }

    @Override // com.tencent.mobileqq.ecshop.ad.d
    public void doOnRunningForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (Math.abs(serverTimeMillis - this.f203939d) > 3600000) {
            this.f203939d = serverTimeMillis;
            com.tencent.mobileqq.qqshop.message.a.f274473a.v();
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return c.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
        }
    }
}
