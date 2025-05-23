package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoIpcServer;
import com.tencent.mobileqq.emosm.favroaming.EmoticonIPCModule;
import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService;
import com.tencent.mobileqq.emoticonview.ipc.EmoticonMainPanelIpcModule;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;

/* loaded from: classes12.dex */
public class EmoticonPanelIpcServiceImpl implements IEmoticonPanelIpcService {
    static IPatchRedirector $redirector_;

    public EmoticonPanelIpcServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService
    public QIPCModule onCreateModule(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (IEmoticonPanelIpcService.EMOTICON_IPC_NAME.equals(str)) {
            return EmoticonIPCModule.b();
        }
        if (IEmoticonPanelIpcService.CAMERAEMOIPC_SERVER_NAME.equals(str)) {
            return CameraEmoIpcServer.b();
        }
        if ("module_emoticon_mainpanel".equals(str)) {
            return EmoticonMainPanelIpcModule.getInstance();
        }
        return null;
    }
}
