package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetGeneralSettings extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private a f195348d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class a extends com.tencent.mobileqq.troop.roamsetting.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GetGeneralSettings.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.roamsetting.b
        protected void a(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (z16 && z17) {
                GetGeneralSettings getGeneralSettings = GetGeneralSettings.this;
                ((Automator) getGeneralSettings.mAutomator).f195306e = 3;
                getGeneralSettings.setResult(7);
                return;
            }
            GetGeneralSettings.this.setResult(6);
        }
    }

    public GetGeneralSettings() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (((Automator) this.mAutomator).f195306e == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.f195348d == null) {
                a aVar = new a();
                this.f195348d = aVar;
                ((Automator) this.mAutomator).E.addObserver(aVar, true);
            }
            if (QLog.isColorLevel()) {
                QLog.d("IAutomator", 2, "getAllGeneralSettings , needTroopSettings=" + z16);
            }
            ((IRoamSettingService) ((Automator) this.mAutomator).E.getRuntimeService(IRoamSettingService.class, "")).loadAllRoamSettings(z16);
        }
        return 7;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        a aVar = this.f195348d;
        if (aVar != null) {
            ((Automator) this.mAutomator).E.removeObserver(aVar);
            this.f195348d = null;
        }
    }
}
