package com.tencent.mobileqq.tianshu.api.impl;

import NS_USER_ACTION_REPORT.ItemInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import cooperation.qzone.mobilereport.MobileReportManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MobileReportManagerImpl implements IMobileReportManager {
    static IPatchRedirector $redirector_;

    public MobileReportManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public String getNewDefaultReportInfo(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? MobileReportManager.getNewDefaultReportInfo(str, str2, str3) : (String) iPatchRedirector.redirect((short) 5, this, str, str2, str3);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public String getNewReportInfo(BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? MobileReportManager.getNewReportInfo(appInfo) : (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInfo);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public String getNewTraceDetail(String str, String str2, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, this, str, str2, str3, str4);
        }
        return MobileReportManager.getNewTraceDetail(str, str2, str3, str4);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    @NonNull
    public String getStringQboos2H5(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, str, str2, str3);
        }
        return MobileReportManager.getStringQboos2H5(str, str2, str3);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    @Nullable
    public String getStringReport2H5(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInfo);
        }
        return MobileReportManager.getStringReport2H5(appInfo);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public String getStringWithQbossTrace(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
        }
        return MobileReportManager.getStringWithQbossTrace(str, str2);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public String getStringWithRedAppinfo(String str, BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) appInfo);
        }
        return MobileReportManager.getStringWithRedAppinfo(str, appInfo);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public void qqSetingMeReport(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
        } else {
            MobileReportManager.getInstance().qqSetingMeReport(i3, i16, str);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public void reportAction(String str, String str2, String str3, String str4, String str5, int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            MobileReportManager.getInstance().reportAction(str, str2, str3, str4, str5, i3, i16, j3);
        } else {
            iPatchRedirector.redirect((short) 12, this, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public void reportActionLive(String str, String str2, String str3, String str4, String str5, int i3, int i16, long j3, String str6) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            MobileReportManager.getInstance().reportActionLive(str, str2, str3, str4, str5, i3, i16, j3, str6);
        } else {
            iPatchRedirector.redirect((short) 13, this, str, str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), str6);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public void reportActionOfNotice(String str, String str2, String str3, int i3, String str4, String str5, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, str2, str3, Integer.valueOf(i3), str4, str5, Integer.valueOf(i16));
        } else {
            MobileReportManager.getInstance().reportActionOfNotice(str, str2, str3, i3, str4, str5, i16);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public void reportH5DomainClick(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, (Object) str2);
        } else {
            MobileReportManager.getInstance().reportH5DomainClick(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public void reportH5Trace(String str, int i3, long j3, String str2, int i16, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2, Integer.valueOf(i16), str3);
        } else {
            MobileReportManager.getInstance().reportH5Trace(str, i3, j3, str2, i16, str3);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public void reportRedpoint(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) appInfo, i3);
        } else {
            MobileReportManager.getInstance().reportRedpoint(appInfo, i3);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public void reportSchemaInfo(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) str2);
        } else {
            MobileReportManager.getInstance().reportSchemaInfo(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public String getNewDefaultReportInfo(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? MobileReportManager.getNewDefaultReportInfo(str, str2) : (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public String getNewReportInfo(String str, BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? MobileReportManager.getNewReportInfo(str, appInfo) : (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) appInfo);
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public void reportAction(String str, String str2, String str3, String str4, String str5, String str6, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            MobileReportManager.getInstance().reportAction(str, str2, str3, str4, str5, str6, i3, i16);
        } else {
            iPatchRedirector.redirect((short) 15, this, str, str2, str3, str4, str5, str6, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public void reportActionLive(String str, String str2, ItemInfo itemInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            MobileReportManager.getInstance().reportActionLive(str, str2, itemInfo);
        } else {
            iPatchRedirector.redirect((short) 14, this, str, str2, itemInfo);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public void reportAction(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, int i16, int i17, String str8, String str9, String str10) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            MobileReportManager.getInstance().reportAction(str, str2, str3, str4, str5, str6, str7, i3, i16, i17, str8, str9, str10);
        } else {
            iPatchRedirector.redirect((short) 16, this, str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str8, str9, str10);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public void reportAction(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, int i16, int i17, String str8, String str9, String str10, String str11) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            MobileReportManager.getInstance().reportAction(str, str2, str3, str4, str5, str6, str7, i3, i16, i17, str8, str9, str10, str11);
        } else {
            iPatchRedirector.redirect((short) 17, this, str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str8, str9, str10, str11);
        }
    }

    @Override // com.tencent.mobileqq.tianshu.api.IMobileReportManager
    public void reportAction(String str, String str2, String str3, int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            MobileReportManager.getInstance().reportAction(str, str2, str3, i3, i16, j3);
        } else {
            iPatchRedirector.redirect((short) 19, this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
        }
    }
}
