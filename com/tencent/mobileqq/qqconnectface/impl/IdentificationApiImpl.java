package com.tencent.mobileqq.qqconnectface.impl;

import android.content.Context;
import com.tencent.mobileqq.activity.IdentificationDeleteFaceFragment;
import com.tencent.mobileqq.identification.IdentificationIpcServer;
import com.tencent.mobileqq.identification.z;
import com.tencent.mobileqq.jsp.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqconnectface.IIdentificationApi;
import com.tencent.mobileqq.qqconnectface.b;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

/* compiled from: P */
/* loaded from: classes16.dex */
public class IdentificationApiImpl implements IIdentificationApi {
    static IPatchRedirector $redirector_;

    public IdentificationApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqconnectface.IIdentificationApi
    public WebViewPlugin createIdentificationPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (WebViewPlugin) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new k();
    }

    @Override // com.tencent.mobileqq.qqconnectface.IIdentificationApi
    public Class<?> getDeleteFaceFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return IdentificationDeleteFaceFragment.class;
    }

    @Override // com.tencent.mobileqq.qqconnectface.IIdentificationApi
    public QIPCModule getIdentityIpcServer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return IdentificationIpcServer.j();
    }

    @Override // com.tencent.mobileqq.qqconnectface.IIdentificationApi
    public void startIdentification(Context context, b bVar, com.tencent.mobileqq.qqconnectface.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, bVar, aVar);
        } else {
            z.i(context, bVar, aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqconnectface.IIdentificationApi
    public void unregisterCallback(Context context, com.tencent.mobileqq.qqconnectface.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) aVar);
        } else {
            z.j(context, aVar);
        }
    }
}
