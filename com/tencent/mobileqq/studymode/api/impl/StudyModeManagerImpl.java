package com.tencent.mobileqq.studymode.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StudyModeManagerImpl implements IStudyModeManager {
    static IPatchRedirector $redirector_;

    public StudyModeManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean useMainThreadRegister() {
        return StudyModeManager.Z();
    }

    @Override // com.tencent.mobileqq.studymode.api.IStudyModeManager
    public boolean getStudyModeSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return StudyModeManager.t();
    }

    @Override // com.tencent.mobileqq.studymode.api.IStudyModeManager
    public void onAccountChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            StudyModeManager.D();
        }
    }

    @Override // com.tencent.mobileqq.studymode.api.IStudyModeManager
    public void openUrlFilterMainFragment(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) intent);
        } else {
            StudyModeManager.G(context, intent);
        }
    }

    @Override // com.tencent.mobileqq.studymode.api.IStudyModeManager
    public void registerStudyModeChangeListener(StudyModeChangeListener studyModeChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) studyModeChangeListener);
        } else if (useMainThreadRegister()) {
            StudyModeManager.E(studyModeChangeListener);
        } else {
            StudyModeManager.H(studyModeChangeListener);
        }
    }

    @Override // com.tencent.mobileqq.studymode.api.IStudyModeManager
    public void registerStudyModeSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            StudyModeManager.I();
        }
    }

    @Override // com.tencent.mobileqq.studymode.api.IStudyModeManager
    public boolean studyMode9165Switch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return StudyModeManager.S().booleanValue();
    }

    @Override // com.tencent.mobileqq.studymode.api.IStudyModeManager
    public boolean studyModeUrlFilterNeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return StudyModeManager.T();
    }

    @Override // com.tencent.mobileqq.studymode.api.IStudyModeManager
    public void unregisterStudyModeChangeListener(StudyModeChangeListener studyModeChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) studyModeChangeListener);
        } else if (useMainThreadRegister()) {
            StudyModeManager.F(studyModeChangeListener);
        } else {
            StudyModeManager.U(studyModeChangeListener);
        }
    }

    @Override // com.tencent.mobileqq.studymode.api.IStudyModeManager
    public boolean urlFilterCheckedSupportOpen(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).booleanValue();
        }
        return StudyModeManager.Y(str);
    }
}
