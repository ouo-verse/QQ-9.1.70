package com.tencent.mobileqq.soso.location.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.soso.location.SosoInterface;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.util.bn;
import com.tencent.qmethod.pandoraex.api.p;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SosoInterfaceApiImpl implements ISosoInterfaceApi {
    static IPatchRedirector $redirector_;

    public SosoInterfaceApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public SosoLbsInfo getCanUsedLbsInfoCache(long j3, boolean z16, int i3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SosoLbsInfo) iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17));
        }
        return SosoInterface.getCanUsedLbsInfoCache(j3, z16, i3, z17);
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public String getCityCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return SosoInterface.getCityCode();
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public SosoLbsInfo getRawSosoInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (SosoLbsInfo) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return SosoInterface.getRawSosoInfo();
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public SosoLbsInfo getSosoInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SosoLbsInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return SosoInterface.getSosoInfo();
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public String getSosoInterfaceBlackClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return SosoInterface.class.getPackage().getName();
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public ClassLoader getSosoInterfaceClassLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ClassLoader) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return SosoInterface.class.getClassLoader();
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            SosoInterface.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public void removeOnLocationListener(SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sosoInterfaceOnLocationListener);
        } else {
            SosoInterface.removeOnLocationListener(sosoInterfaceOnLocationListener);
        }
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public void reqRawLbsData(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), str);
        } else {
            SosoInterface.reqRawLbsData(j3, str);
        }
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public void saveNormalEnterConversationTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            SosoInterface.saveNormalEnterConversationTime(j3);
        }
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public boolean saveSosoInterfaceConfig(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        return SosoInterface.saveSosoInterfaceConfig(str);
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public void setResumeFlagFromConversation(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            SosoInterface.sResumeFlagFromConversation = j3;
        }
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public void startLocation(SosoInterfaceOnLocationListener sosoInterfaceOnLocationListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) sosoInterfaceOnLocationListener);
        } else {
            bn.d(new p.a().c(bn.b()).a());
            SosoInterface.startLocation(sosoInterfaceOnLocationListener);
        }
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public void startOfficialLocation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            SosoInterface.startOfficialLocation();
        }
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public void updateMainProcessCachedLocation(int i3, SosoLbsInfo sosoLbsInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) sosoLbsInfo);
        } else {
            SosoInterface.updateMainProcessCachedLocation(i3, sosoLbsInfo);
        }
    }

    @Override // com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
    public void updateRawData(String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) bArr);
        } else {
            SosoInterface.updateRawData(str, bArr);
        }
    }
}
