package com.tencent.mobileqq.wifiphoto.impl;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.wifiphoto.IWifiPhotoTempApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import rd0.g;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/wifiphoto/impl/WifiPhotoTempApiImpl;", "Lcom/tencent/mobileqq/wifiphoto/IWifiPhotoTempApi;", "()V", "isPcLock", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class WifiPhotoTempApiImpl implements IWifiPhotoTempApi {
    static IPatchRedirector $redirector_;

    public WifiPhotoTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.wifiphoto.IWifiPhotoTempApi
    public boolean isPcLock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        Manager manager = MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.biz.qrcode.logindev.LoginDevicesManager");
        return ((g) manager).l();
    }
}
