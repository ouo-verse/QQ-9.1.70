package com.tencent.qqnt.emotion.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qqnt.emotion.api.INTEmoticonPanelIpcService;

/* loaded from: classes24.dex */
public class NTEmoticonPanelIpcServiceImpl implements INTEmoticonPanelIpcService {
    static IPatchRedirector $redirector_;

    public NTEmoticonPanelIpcServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.api.INTEmoticonPanelIpcService
    public QIPCModule onCreateModule(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (INTEmoticonPanelIpcService.NT_EMOTICON_MAINPANEL_IPC_NAME.equals(str)) {
            return com.tencent.qqnt.emotion.ipc.a.b();
        }
        return null;
    }
}
