package com.tencent.mobileqq.leba.business.impl;

import android.view.View;
import com.tencent.mobileqq.leba.business.ILebaRichApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import mqq.app.AppRuntime;
import uq3.c;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LebaRichApiImpl implements ILebaRichApi {
    static IPatchRedirector $redirector_;

    public LebaRichApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.leba.business.ILebaRichApi
    public void applyThemeBg(AppRuntime appRuntime, View view, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, view, Integer.valueOf(i3), str);
        } else {
            ThemeBackground.applyThemeBg(appRuntime, view, 4, i3, str);
        }
    }

    @Override // com.tencent.mobileqq.leba.business.ILebaRichApi
    public boolean isShowQCircleEnter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return c.L6(StudyModeManager.t());
    }
}
