package com.tencent.mobileqq.tianshu.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.tianshu.api.IQQTianshuApi;
import com.tencent.mobileqq.tianshu.api.ITianshuTempApi;
import cooperation.qzone.QUA;
import cooperation.vip.ad.i;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TianshuTempApiImpl implements ITianshuTempApi {
    static IPatchRedirector $redirector_;

    public TianshuTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.ITianshuTempApi
    public String getQua() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return QUA.getQUA3();
    }

    @Override // com.tencent.mobileqq.tianshu.api.ITianshuTempApi
    public void setHalfLayerADParams(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (MobileQQ.sProcessId == 1) {
            i.q(str, str2);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("setHalfLayerADParams", str);
        bundle.putString("from", str2);
        QIPCClientHelper.getInstance().callServer(IQQTianshuApi.NAME, "setHalfLayerADParams", bundle);
    }
}
