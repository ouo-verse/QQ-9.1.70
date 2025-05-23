package com.tencent.qqnt.emotion.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.ICommercialDrainageManagerService;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes24.dex */
public class CommercialDrainageManagerServiceImpl implements ICommercialDrainageManagerService {
    static IPatchRedirector $redirector_ = null;
    private static final String COMMERCIAL_SP = "commercial_sp";
    private static long DEFAULT_INTERVAL = 0;
    private static final String TAG = "CommercialDrainageManager";
    BaseQQAppInterface app;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34808);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            DEFAULT_INTERVAL = 86400L;
        }
    }

    public CommercialDrainageManagerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.api.ICommercialDrainageManagerService
    public int getShowCount(long j3, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), str, str2, Integer.valueOf(i3))).intValue();
        }
        this.app.getApp().getSharedPreferences(COMMERCIAL_SP + this.app.getAccount(), 0).getLong("disPlayInteval", -1L);
        return 0;
    }

    @Override // com.tencent.qqnt.emotion.api.ICommercialDrainageManagerService
    public boolean isIPSite(EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) emoticonPackage)).booleanValue();
        }
        if (emoticonPackage != null) {
            return (TextUtils.isEmpty(emoticonPackage.ipUrl) && TextUtils.isEmpty(emoticonPackage.ipName) && TextUtils.isEmpty(emoticonPackage.ipDetail) && TextUtils.isEmpty(emoticonPackage.ipOpName) && TextUtils.isEmpty(emoticonPackage.ipJumpUrl)) ? false : true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.api.ICommercialDrainageManagerService
    public boolean isRichIPSite(VipIPSiteInfo vipIPSiteInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) vipIPSiteInfo)).booleanValue();
        }
        if (vipIPSiteInfo == null) {
            return false;
        }
        String str = vipIPSiteInfo.strType;
        if (!"comic".equals(str) && !"book".equals(str) && !"video".equals(str) && !"goods".equals(str) && !"game".equals(str)) {
            return false;
        }
        return true;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.app = (BaseQQAppInterface) appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.api.ICommercialDrainageManagerService
    public boolean shouldHiden(EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoticonPackage)).booleanValue();
        }
        long j3 = emoticonPackage.endTime;
        long j16 = emoticonPackage.beginTime;
        if (j3 != j16 && (j16 >= System.currentTimeMillis() || System.currentTimeMillis() >= emoticonPackage.endTime)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.emotion.api.ICommercialDrainageManagerService
    public void updateDisPlayInteval(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "updateDisPlayInteval interval = " + j3);
        }
        if (j3 <= 0) {
            j3 = DEFAULT_INTERVAL;
        }
        this.app.getApp().getSharedPreferences(COMMERCIAL_SP + this.app.getAccount(), 0).edit().putLong("disPlayInteval", j3).apply();
    }

    @Override // com.tencent.qqnt.emotion.api.ICommercialDrainageManagerService
    public boolean isIPSite(Emoticon emoticon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) emoticon)).booleanValue();
        }
        if (emoticon != null) {
            return (TextUtils.isEmpty(emoticon.ipsiteUrl) && TextUtils.isEmpty(emoticon.ipsiteName)) ? false : true;
        }
        return false;
    }
}
