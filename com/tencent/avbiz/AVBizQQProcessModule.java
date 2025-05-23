package com.tencent.avbiz;

import com.tencent.avbiz.IModule;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import mqq.util.WeakReference;

/* loaded from: classes3.dex */
class AVBizQQProcessModule implements IModule, IModule.FocusChangeListener {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private WeakReference<IModule.FocusChangeListener> mListenerWeakRef;
    private final String mName;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37805);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            TAG = AVBizQQProcessModule.class.getSimpleName();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AVBizQQProcessModule(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.mListenerWeakRef = new WeakReference<>(null);
            this.mName = str;
        }
    }

    @Override // com.tencent.avbiz.IModule
    public void abandonAVFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module abandonAVFocus, name[" + this.mName + "]");
        }
        AVBizPriorityManager.getInstance().abandonAVFocus(this.mName);
    }

    @Override // com.tencent.avbiz.IModule
    public void asyncAbandonAVFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            abandonAVFocus();
        }
    }

    @Override // com.tencent.avbiz.IModule
    public void asyncCheckAVFocus(IModule.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
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
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module asyncRequestAVFocus, name[" + this.mName + "], processName[com.tencent.mobileqq]");
        }
        String requestAVFocus = requestAVFocus();
        if (aVar != null) {
            aVar.onResponse(requestAVFocus);
        }
    }

    @Override // com.tencent.avbiz.IModule
    public String checkAVFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module checkAVFocus, name[" + this.mName + "]");
        }
        return AVBizPriorityManager.getInstance().checkAVFocus(this.mName);
    }

    @Override // com.tencent.avbiz.IModule
    public HashMap<Long, String> getFocusBusiness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (HashMap) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module getFocusBusiness, name[" + this.mName + "]");
        }
        return AVBizPriorityManager.getInstance().getFocusBusiness();
    }

    @Override // com.tencent.avbiz.IModule
    public HashSet<String> getInQueueBusiness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (HashSet) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module getFocusBusiness, name[" + this.mName + "]");
        }
        return AVBizPriorityManager.getInstance().getInQueueBusiness();
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusGain() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        IModule.FocusChangeListener focusChangeListener = this.mListenerWeakRef.get();
        if (focusChangeListener != null) {
            focusChangeListener.onFocusGain();
        }
    }

    @Override // com.tencent.avbiz.IModule.FocusChangeListener
    public void onFocusLoss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        IModule.FocusChangeListener focusChangeListener = this.mListenerWeakRef.get();
        if (focusChangeListener != null) {
            focusChangeListener.onFocusLoss();
        }
    }

    @Override // com.tencent.avbiz.IModule
    public String requestAVFocus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "module requestAVFocus, name[" + this.mName + "], processName[com.tencent.mobileqq]");
        }
        return AVBizPriorityManager.getInstance().requestAVFocus(this.mName, "com.tencent.mobileqq");
    }

    @Override // com.tencent.avbiz.IModule
    public void setListener(IModule.FocusChangeListener focusChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) focusChangeListener);
        } else {
            this.mListenerWeakRef = new WeakReference<>(focusChangeListener);
        }
    }
}
