package com.tencent.mobileqq.qrscan.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qrscan.api.IQRScanIpcApi;
import com.tencent.mobileqq.qrscan.ipc.b;
import com.tencent.mobileqq.qrscan.ipc.d;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QRScanIpcApiImpl implements IQRScanIpcApi {
    static IPatchRedirector $redirector_;

    public QRScanIpcApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRScanIpcApi
    public QIPCModule getModule(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        str.hashCode();
        if (!str.equals(IQRScanIpcApi.MODULUE_SUB)) {
            if (!str.equals(IQRScanIpcApi.MODULUE_MAIN)) {
                return null;
            }
            return b.d();
        }
        return d.c();
    }
}
