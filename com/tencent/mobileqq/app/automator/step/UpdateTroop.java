package com.tencent.mobileqq.app.automator.step;

import android.os.SystemClock;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class UpdateTroop extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.troop.api.observer.e f195382d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) UpdateTroop.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onUpdateTroopList(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("IAutomator", 2, "updateTroopList:" + z16);
            }
            if (!z16) {
                UpdateTroop.this.setResult(6);
            } else {
                ((Automator) UpdateTroop.this.mAutomator).f195307f.edit().putBoolean("isTrooplistok", true).commit();
                ((Automator) UpdateTroop.this.mAutomator).notifyUI(3, true, 2);
                UpdateTroop.this.setResult(7);
            }
            UpdateTroop.this.removeObserver();
        }
    }

    public UpdateTroop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void g() {
        if (this.f195382d == null) {
            a aVar = new a();
            this.f195382d = aVar;
            ((Automator) this.mAutomator).E.addObserver(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mStepId == 4) {
            T t16 = this.mAutomator;
            ((Automator) t16).f195308h = ((Automator) t16).f195307f.getBoolean("isTrooplistok", false);
            com.tencent.mobileqq.persistence.l entityManagerFactory = ((Automator) this.mAutomator).E.getEntityManagerFactory();
            if ((entityManagerFactory instanceof com.tencent.mobileqq.persistence.l) && entityManagerFactory.e()) {
                ((Automator) this.mAutomator).f195308h = false;
            }
            if (((Automator) this.mAutomator).f195308h) {
                if (QLog.isColorLevel()) {
                    QLog.d("IAutomator", 2, "onCheckTroopList:Done");
                }
                long uptimeMillis2 = SystemClock.uptimeMillis();
                long uptimeMillis3 = SystemClock.uptimeMillis() - uptimeMillis2;
                if (TroopUtils.s()) {
                    g();
                }
                ((Automator) this.mAutomator).notifyUI(3, true, 2);
                long uptimeMillis4 = (SystemClock.uptimeMillis() - uptimeMillis) - uptimeMillis3;
                ((Automator) this.mAutomator).C.put("UpdateTroop_withoutHandlerCost", Long.valueOf(uptimeMillis4));
                if (QLog.isColorLevel()) {
                    QLog.d("IAutomator", 2, "troopHandler creation cost: " + uptimeMillis3 + ", total cost without troopHandler: " + uptimeMillis4);
                    return 7;
                }
                return 7;
            }
            g();
            return 7;
        }
        g();
        return 7;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mCountRetry = 2;
        }
    }

    public void removeObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.api.observer.e eVar = this.f195382d;
        if (eVar != null) {
            ((Automator) this.mAutomator).E.removeObserver(eVar);
            this.f195382d = null;
        }
    }
}
