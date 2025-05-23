package com.tencent.mobileqq.wxmini.api.impl;

import com.tencent.luggage.wxaapi.WxaExtendApiJSBridge;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.wxmini.api.IWxMiniLibApi;
import com.tencent.mobileqq.wxmini.impl.plugin.h;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WxMiniLibApiImpl implements IWxMiniLibApi {
    static IPatchRedirector $redirector_;

    public WxMiniLibApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniLibApi
    public WxaExtendApiJSBridge.b getHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (WxaExtendApiJSBridge.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return h.b();
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniLibApi
    public QIPCModule getWxQIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.mobileqq.wxmini.impl.plugin.ipc.c.f327751d;
    }
}
