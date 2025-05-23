package com.tencent.mobileqq.qqcommon.api.impl;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqcommon.api.INetworkUtilApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class NetworkUtilApiImpl implements INetworkUtilApi {
    static IPatchRedirector $redirector_;

    public NetworkUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqcommon.api.INetworkUtilApi
    public int getConnRetryTimes(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        return NetworkUtil.getConnRetryTimes(i3);
    }

    @Override // com.tencent.mobileqq.qqcommon.api.INetworkUtilApi
    public boolean is4G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (AppNetConnInfo.getMobileInfo() == 3) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqcommon.api.INetworkUtilApi
    public boolean is5G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (AppNetConnInfo.getMobileInfo() == 4) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqcommon.api.INetworkUtilApi
    public boolean isNetworkAvailable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return NetworkUtil.isNetworkAvailable();
    }

    @Override // com.tencent.mobileqq.qqcommon.api.INetworkUtilApi
    public boolean isWifi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return NetworkUtil.isWifiConnected(MobileQQ.sMobileQQ);
    }
}
