package com.tencent.avbiz;

import com.tencent.avbiz.Constants;
import com.tencent.avbiz.IModule;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
class DefaultModule implements IModule {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    IModule mIPCProxy;
    String mName;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38321);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            TAG = DefaultModule.class.getSimpleName();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultModule(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.mName = str;
        if (!"com.tencent.mobileqq".equals(str2)) {
            this.mIPCProxy = new AVBizClientQIPCModule(str, str2);
        }
    }

    @Override // com.tencent.avbiz.IModule
    public void abandonAVFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            QLog.e(TAG, 1, "default module abandonAVFocus");
        }
    }

    @Override // com.tencent.avbiz.IModule
    public void asyncAbandonAVFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module asyncAbandonAVFocus");
        }
    }

    @Override // com.tencent.avbiz.IModule
    public void asyncCheckAVFocus(IModule.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module asyncCheckAVFocus");
        }
        String checkAVFocus = checkAVFocus();
        if (aVar != null) {
            aVar.onResponse(checkAVFocus);
        }
    }

    @Override // com.tencent.avbiz.IModule
    public void asyncRequestAVFocus(IModule.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            QLog.e(TAG, 1, "asyncRequestAVFocus");
        }
    }

    @Override // com.tencent.avbiz.IModule
    public String checkAVFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashMap<Long, String> focusBusiness = getFocusBusiness();
        Iterator<Long> it = focusBusiness.keySet().iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            if (Constants.Business.DEFAULT.equals(this.mName) || ((longValue == 1 && Constants.Business.DEFAULT_AUDIO.equals(this.mName)) || (longValue == 2 && Constants.Business.DEFAULT_CAMERA.equals(this.mName)))) {
                return focusBusiness.get(Long.valueOf(longValue));
            }
        }
        return "true";
    }

    @Override // com.tencent.avbiz.IModule
    public HashMap<Long, String> getFocusBusiness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashMap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        IModule iModule = this.mIPCProxy;
        if (iModule != null) {
            return iModule.getFocusBusiness();
        }
        return AVBizPriorityManager.getInstance().getFocusBusiness();
    }

    @Override // com.tencent.avbiz.IModule
    public HashSet<String> getInQueueBusiness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (HashSet) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        IModule iModule = this.mIPCProxy;
        if (iModule != null) {
            return iModule.getInQueueBusiness();
        }
        return AVBizPriorityManager.getInstance().getInQueueBusiness();
    }

    @Override // com.tencent.avbiz.IModule
    public String requestAVFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        QLog.e(TAG, 1, "default module requestAVFocus");
        return "";
    }

    @Override // com.tencent.avbiz.IModule
    public void setListener(IModule.FocusChangeListener focusChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) focusChangeListener);
        } else {
            QLog.e(TAG, 1, "default module setListener");
        }
    }
}
