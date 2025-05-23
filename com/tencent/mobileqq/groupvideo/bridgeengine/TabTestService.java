package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public class TabTestService implements ITabTestService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TabTestService";

    public TabTestService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITabTestService
    public boolean isTabContrast(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        QLog.d(TAG, 1, "[loadExperiment] expTagName: ", str, " | expInfo Exp: ", expEntity.getExpName(), " | assignment: " + expEntity.getAssignment());
        return expEntity.isContrast();
    }

    @Override // com.tencent.mobileqq.groupvideo.bridgeengine.ITabTestService
    public boolean isTabExperiment(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        QLog.d(TAG, 1, "[loadExperiment] expTagName: ", str, " | expInfo Exp: ", expEntity.getExpName(), " | assignment: " + expEntity.getAssignment());
        return expEntity.isExperiment();
    }
}
