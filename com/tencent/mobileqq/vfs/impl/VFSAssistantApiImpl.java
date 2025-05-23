package com.tencent.mobileqq.vfs.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vfs.IVFSAssistantApi;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VFSAssistantApiImpl implements IVFSAssistantApi {
    static IPatchRedirector $redirector_;

    public VFSAssistantApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.vfs.IVFSAssistantApi
    public String getCanonicalPath(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return VFSAssistantUtils.getCanonicalPath(str);
    }

    @Override // com.tencent.mobileqq.vfs.IVFSAssistantApi
    public String getSDKPrivatePath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return VFSAssistantUtils.getSDKPrivatePath(str);
    }
}
