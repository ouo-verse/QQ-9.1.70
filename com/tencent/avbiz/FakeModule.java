package com.tencent.avbiz;

import com.tencent.avbiz.IModule;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public class FakeModule implements IModule {
    static IPatchRedirector $redirector_;
    private static String TAG;
    private final HashMap<Long, String> mFakeFocusBusiness;
    private final HashSet<String> mFakeInQueueBusiness;
    private final String mName;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38365);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            TAG = FakeModule.class.getSimpleName();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FakeModule(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.mFakeFocusBusiness = new HashMap<>();
        this.mFakeInQueueBusiness = new HashSet<>();
        TAG += "_" + str;
        this.mName = str;
    }

    @Override // com.tencent.avbiz.IModule
    public void abandonAVFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.e(TAG, 1, "fake module abandonAVFocus, name[" + this.mName + "]");
    }

    @Override // com.tencent.avbiz.IModule
    public void asyncAbandonAVFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.avbiz.IModule
    public void asyncCheckAVFocus(IModule.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.avbiz.IModule
    public void asyncRequestAVFocus(IModule.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.avbiz.IModule
    public String checkAVFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        QLog.e(TAG, 1, "fake module checkAVFocus, name[" + this.mName + "]");
        return "";
    }

    @Override // com.tencent.avbiz.IModule
    public HashMap<Long, String> getFocusBusiness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashMap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        QLog.e(TAG, 1, "fake module getFocusBusiness, name[" + this.mName + "]");
        return this.mFakeFocusBusiness;
    }

    @Override // com.tencent.avbiz.IModule
    public HashSet<String> getInQueueBusiness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (HashSet) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        QLog.e(TAG, 1, "fake module getInQueueBusiness, name[" + this.mName + "]");
        return this.mFakeInQueueBusiness;
    }

    @Override // com.tencent.avbiz.IModule
    public String requestAVFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        QLog.e(TAG, 1, "fake module requestAVFocus, name[" + this.mName + "]");
        return "";
    }

    @Override // com.tencent.avbiz.IModule
    public void setListener(IModule.FocusChangeListener focusChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) focusChangeListener);
            return;
        }
        QLog.e(TAG, 1, "fake module setListener, name[" + this.mName + "]");
    }
}
