package com.tencent.mobileqq.model.api.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.model.api.ICommercialDrainageManagerService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class CommercialDrainageManagerServiceImpl implements ICommercialDrainageManagerService {
    static IPatchRedirector $redirector_ = null;
    private static final String COMMERCIAL_SP = "commercial_sp";
    private static long DEFAULT_INTERVAL = 0;
    private static final String TAG = "CommercialDrainageManager";
    BaseQQAppInterface app;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52049);
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

    @Override // com.tencent.mobileqq.model.api.ICommercialDrainageManagerService
    public int getShowCount(long j3, String str, String str2, int i3) {
        long j16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), str, str2, Integer.valueOf(i3))).intValue();
        }
        SharedPreferences sharedPreferences = this.app.getApp().getSharedPreferences(COMMERCIAL_SP + this.app.getAccount(), 0);
        long j17 = sharedPreferences.getLong("disPlayInteval", -1L);
        if (j17 == -1) {
            try {
                JSONObject jSONObject = null;
                JSONObject jSONFromLocal = VasUpdateUtil.getJSONFromLocal(this.app, VasUpdateConstants.SCID_PERSONAL_CONFIG, false, null);
                if (jSONFromLocal != null) {
                    if (jSONFromLocal.has("ipStackConfigDic")) {
                        jSONObject = jSONFromLocal.getJSONObject("ipStackConfigDic");
                    }
                    if (jSONObject != null && jSONObject.has("ipStackTimeInterval")) {
                        j16 = jSONObject.getInt("ipStackTimeInterval");
                    } else {
                        j16 = -1;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getJson interval = " + j16);
                    }
                    if (j16 <= 0) {
                        j16 = DEFAULT_INTERVAL;
                    }
                    sharedPreferences.edit().putLong("disPlayInteval", j16).apply();
                } else {
                    QLog.e(TAG, 1, "getShowCount json not exist");
                    j16 = DEFAULT_INTERVAL;
                }
                j17 = j16;
            } catch (Exception e16) {
                j17 = DEFAULT_INTERVAL;
                QLog.e(TAG, 1, "getShowCount error = " + e16);
            }
        }
        if (sharedPreferences.getLong(str + "_lastDisPlayTime", Long.MAX_VALUE) + j17 > j3) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i17 = sharedPreferences.getInt(str + "_count", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (!z16) {
            edit.putLong(str + "_lastDisPlayTime", j3);
        } else {
            i16 = i17;
        }
        edit.putInt(str + "_count", i16 + 1);
        edit.apply();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getShowCount, haveShown = " + z16 + " count = " + i16 + " epId = " + str + " timestamp = " + j3 + "interval = " + j17 + " name = " + str2 + " type = " + i3);
        }
        return i16;
    }

    @Override // com.tencent.mobileqq.model.api.ICommercialDrainageManagerService
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

    @Override // com.tencent.mobileqq.model.api.ICommercialDrainageManagerService
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

    @Override // com.tencent.mobileqq.model.api.ICommercialDrainageManagerService
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

    @Override // com.tencent.mobileqq.model.api.ICommercialDrainageManagerService
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

    @Override // com.tencent.mobileqq.model.api.ICommercialDrainageManagerService
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
