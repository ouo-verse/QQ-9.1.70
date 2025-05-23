package com.tencent.rfix.lib.entity;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.loader.utils.RFixConstants;

@Keep
/* loaded from: classes25.dex */
public class RFixPatchResult {
    static IPatchRedirector $redirector_;
    public int configId;
    public int configType;
    public boolean effectImmediate;
    public boolean enableAssertDex;
    public boolean enableAssertLib;
    public boolean enableAssertRes;
    public Exception exception;
    public int installResult;
    public boolean oatGenerated;
    public String patchFilePath;
    public String patchId;
    public int patchIndex;
    public String patchProcess;
    public String patchType;
    public String patchVersion;
    public RFixConstants.PatchError result;
    public int retryCount;
    public long timeCost;

    public RFixPatchResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean isPatchSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        RFixConstants.PatchError patchError = this.result;
        if (patchError != RFixConstants.PatchError.PATCH_ERROR_OK && patchError != RFixConstants.PatchError.PATCH_ERROR_ALREADY_APPLY) {
            return false;
        }
        return true;
    }

    public boolean isPatchSuccessFirstTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.result == RFixConstants.PatchError.PATCH_ERROR_OK) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "RFixPatchResult{result=" + this.result + ", timeCost=" + this.timeCost + ", patchFilePath=" + this.patchFilePath + ", patchVersion=" + this.patchVersion + ", patchType=" + this.patchType + ", patchId=" + this.patchId + ", patchIndex=" + this.patchIndex + ", installResult=" + this.installResult + ", configId=" + this.configId + ", configType=" + this.configType + ", patchProcess=" + this.patchProcess + '}';
    }
}
