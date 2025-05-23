package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopEnterEffectApi;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class TroopEnterEffectsStep extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    hs2.a f195376d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements hs2.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopEnterEffectsStep.this);
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            } else if (i3 == 26) {
                if (!z16) {
                    TroopEnterEffectsStep.this.setResult(6);
                } else {
                    TroopEnterEffectsStep.this.setResult(7);
                }
            }
        }
    }

    public TroopEnterEffectsStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f195376d = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("IAutomator", 2, "TroopEnterEffectsStep: doStep");
        }
        long r06 = ea.r0(((Automator) this.mAutomator).E.getApplication(), ((Automator) this.mAutomator).E.getCurrentAccountUin());
        com.tencent.mobileqq.troop.entereffect.e troopEnterEffectConfig = ((ITroopEnterEffectService) ((Automator) this.mAutomator).E.getRuntimeService(ITroopEnterEffectService.class, "all")).getTroopEnterEffectConfig();
        if (r06 != 0 && troopEnterEffectConfig.f295227b != null && (System.currentTimeMillis() - r06) / 1000 <= troopEnterEffectConfig.f295227b.f295232a) {
            return 7;
        }
        ((ITroopEnterEffectApi) QRoute.api(ITroopEnterEffectApi.class)).sendTroopEnterEffectCMD(((Automator) this.mAutomator).E, 2L, 0L);
        return 2;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ((Automator) this.mAutomator).E.addObserver(this.f195376d, true);
        }
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ((Automator) this.mAutomator).E.removeObserver(this.f195376d);
        }
    }
}
