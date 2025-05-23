package com.tencent.mobileqq.uftransfer.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.api.IUFTDebugOption;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UFTDebugOptionImpl implements IUFTDebugOption {
    static IPatchRedirector $redirector_;
    boolean forceBigFileUploadProcess;
    boolean simulateForwardForbiddenFiles;

    public UFTDebugOptionImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.simulateForwardForbiddenFiles = false;
            this.forceBigFileUploadProcess = false;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.IUFTDebugOption
    public void enableForceBigFileUpload(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.forceBigFileUploadProcess = z16;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.IUFTDebugOption
    public void enableSimulateForwardForbiddenFiles(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.simulateForwardForbiddenFiles = z16;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.IUFTDebugOption
    public boolean isForceBigFileUploadEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.uftransfer.api.IUFTDebugOption
    public boolean isSimulateForwardForbiddenFilesEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }
}
