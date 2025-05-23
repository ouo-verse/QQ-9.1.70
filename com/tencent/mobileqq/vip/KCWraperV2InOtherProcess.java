package com.tencent.mobileqq.vip;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasFragment;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.util.Pair;

/* loaded from: classes20.dex */
public class KCWraperV2InOtherProcess extends l {
    static IPatchRedirector $redirector_;

    public KCWraperV2InOtherProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vip.l
    public void a(ViewGroup viewGroup) {
        g("can not call bindActivationView");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vip.l
    public boolean f() {
        g("isReady : do nothing");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vip.l
    public boolean h(Activity activity) {
        if (l.e()) {
            ((IVasFragment) QRoute.api(IVasFragment.class)).startKingCard(activity);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vip.l
    public void i(TMSManager.a aVar, boolean z16) {
        g("queryKingCard : from cache");
        Pair<Boolean, Integer> c16 = l.c();
        if (aVar != null) {
            if (z16) {
                ThreadManager.getUIHandler().post(new Runnable(aVar, c16) { // from class: com.tencent.mobileqq.vip.KCWraperV2InOtherProcess.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ TMSManager.a f312750d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Pair f312751e;

                    {
                        this.f312750d = aVar;
                        this.f312751e = c16;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, KCWraperV2InOtherProcess.this, aVar, c16);
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            this.f312750d.a(true, ((Boolean) this.f312751e.first).booleanValue(), ((Integer) this.f312751e.second).intValue());
                        }
                    }
                });
            } else {
                aVar.a(true, c16.first.booleanValue(), c16.second.intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vip.l
    public boolean l() {
        boolean e16 = l.e();
        g("supportActivationView = " + e16);
        return e16;
    }

    @Override // com.tencent.mobileqq.vip.l
    String m() {
        return "KC.KCWraper.Other";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.vip.l
    public void n(Runnable runnable) {
        g("tryLoad : do nothing");
    }
}
