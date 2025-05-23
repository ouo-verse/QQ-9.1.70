package com.tencent.mobileqq.activity.troop.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorHandler;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class n extends com.tencent.mobileqq.troop.api.config.j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f186614a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69444);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f186614a = "TroopHornorTroopListProcessor";
        }
    }

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.j
    public void a(@NonNull AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f186614a, 2, "onGetTroopListFinish");
        }
        ITroopHonorHandler iTroopHonorHandler = (ITroopHonorHandler) appInterface.getRuntimeService(ITroopHonorHandler.class, "");
        if (iTroopHonorHandler != null) {
            iTroopHonorHandler.getHostTroopHonorList();
        }
    }
}
