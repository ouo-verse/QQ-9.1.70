package com.tencent.mobileqq.soso.location.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soso.location.BGLocateMonitor;
import com.tencent.mobileqq.soso.location.LbsManagerService;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.SosoInterface;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.util.bn;
import com.tencent.qmethod.pandoraex.api.p;

/* compiled from: P */
/* loaded from: classes18.dex */
public class LbsManagerServiceApiImpl implements ILbsManagerServiceApi {
    static IPatchRedirector $redirector_;

    public LbsManagerServiceApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi
    public String getBGLocateMonitorClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return BGLocateMonitor.class.getName();
    }

    @Override // com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi
    public SosoLbsInfo getCachedLbsInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SosoLbsInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return LbsManagerService.getCachedLbsInfo(str);
    }

    @Override // com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi
    public String getCity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? LbsManagerService.getCity() : (String) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @Override // com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi
    public String getCityCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? LbsManagerService.getCityCode() : (String) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    @Override // com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi
    public String getProvince() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? LbsManagerService.getProvince() : (String) iPatchRedirector.redirect((short) 10, (Object) this);
    }

    @Override // com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi
    public void initLocationManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            LbsManagerService.initLocationManager();
        }
    }

    @Override // com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi
    public boolean isLastLocationSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return SosoInterface.isLastLocationSuccess();
    }

    @Override // com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            LbsManagerService.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi
    public void pushBGLocateMonitorStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            BGLocateMonitor.start();
        }
    }

    @Override // com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi
    public void removeListener(LbsManagerServiceOnLocationChangeListener lbsManagerServiceOnLocationChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) lbsManagerServiceOnLocationChangeListener);
        } else {
            LbsManagerService.removeListener(lbsManagerServiceOnLocationChangeListener);
        }
    }

    @Override // com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi
    public void startLocation(LbsManagerServiceOnLocationChangeListener lbsManagerServiceOnLocationChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) lbsManagerServiceOnLocationChangeListener);
        } else {
            bn.d(new p.a().c(bn.b()).a());
            LbsManagerService.startLocation(lbsManagerServiceOnLocationChangeListener);
        }
    }

    public String getCity(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? LbsManagerService.getCityCode(str) : (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
    }

    public String getCityCode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? LbsManagerService.getCityCode(str) : (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
    }

    public String getProvince(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? LbsManagerService.getCityCode(str) : (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
    }
}
