package com.tencent.soter.wrapper.wrap_callback;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.model.SoterCoreResult;
import com.tencent.soter.core.model.SoterCoreUtil;
import com.tencent.soter.wrapper.wrap_core.SoterProcessErrCode;

/* loaded from: classes25.dex */
public abstract class SoterProcessResultBase<T> extends SoterCoreResult implements SoterProcessErrCode {
    static IPatchRedirector $redirector_;
    private T extData;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SoterProcessResultBase() {
        super(-1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.extData = null;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public T getExtData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.extData;
    }

    @Override // com.tencent.soter.core.model.SoterCoreResult
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (getExtData() == null) {
            return super.toString();
        }
        return String.format("total: %s, extData: %s", super.toString(), getExtData().toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SoterProcessResultBase(int i3, String str) {
        this(i3, str, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SoterProcessResultBase(int i3, String str, T t16) {
        super(i3, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, t16);
            return;
        }
        this.extData = null;
        if (i3 == 1008) {
            this.errMsg = "not initialized yet. please make sure you've already called SoterWrapperApi.init(...) and call backed";
        } else if (i3 == 1011) {
            this.errMsg = "context instance already released. should not happen normally, you can try to call again";
        } else if (i3 == 1019) {
            this.errMsg = "upload or verify signature in server side failed";
        } else if (i3 == 1013) {
            this.errMsg = "there must be at least 1 biometric enrolled in system to complete this process. please check it previously";
        } else if (i3 != 1014) {
            switch (i3) {
                case 1002:
                    this.errMsg = "get support soter failed remotely";
                    break;
                case 1003:
                    this.errMsg = "upload app secure key";
                    break;
                case 1004:
                    this.errMsg = "upload auth key failed";
                    break;
            }
        } else {
            this.errMsg = "get challenge failed";
        }
        if (!SoterCoreUtil.isNullOrNil(str)) {
            this.errMsg = str;
        }
        this.extData = t16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SoterProcessResultBase(int i3) {
        this(i3, "", null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SoterProcessResultBase(int i3, T t16) {
        this(i3, "", t16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) t16);
    }
}
