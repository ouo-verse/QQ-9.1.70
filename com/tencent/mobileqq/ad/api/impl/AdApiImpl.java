package com.tencent.mobileqq.ad.api.impl;

import android.app.Activity;
import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.ad.api.IAdApi;
import com.tencent.mobileqq.ad.debug.AdH5DebugFragment;
import com.tencent.mobileqq.ad.debug.AlphaVideoAdDebugFragment;
import com.tencent.mobileqq.ad.debug.LoadingAdDebugFragment;
import com.tencent.mobileqq.ad.debug.RewardAdDebugFragment;
import com.tencent.mobileqq.ad.redpoint.LebaShoppingRedTouchAdRequestManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdReportHelper;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.HashMap;
import java.util.Map;
import s71.a;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AdApiImpl implements IAdApi {
    static IPatchRedirector $redirector_ = null;
    private static final String APP_KEY = "0DOU0J4CUI43WCQ1";
    private static final String PHONE_BRANDS = "phone_brands";
    private static final String PHONE_MODEL = "phone_model";
    private static final String PLATFORM = "platform_id";
    private static final String QQ_VERSION = "qq_version";
    private static final String SYS_TYPE = "sys_type";
    private static final String UIN = "uin";

    public AdApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ad.api.IAdApi
    public void clearLebaShoppingRedTouchAd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            LebaShoppingRedTouchAdRequestManager.f186905a.b();
        }
    }

    @Override // com.tencent.mobileqq.ad.api.IAdApi
    public void doMaskAdValidExpo(GdtAd gdtAd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) gdtAd);
        } else {
            MaskAdReportHelper.INSTANCE.doValidExpo(gdtAd);
        }
    }

    @Override // com.tencent.mobileqq.ad.api.IAdApi
    public GdtAd getLebaShoppingRedTouchAd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (GdtAd) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        return LebaShoppingRedTouchAdRequestManager.f186905a.d(str);
    }

    @Override // com.tencent.mobileqq.ad.api.IAdApi
    public String getLebaShoppingRedTouchLastExpoAd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return LebaShoppingRedTouchAdRequestManager.f186905a.i();
    }

    @Override // com.tencent.mobileqq.ad.api.IAdApi
    public Map<String, String> getReportParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uin", VasUtil.getCurrentUin());
        hashMap.put("platform_id", "2");
        hashMap.put(PHONE_MODEL, DeviceInfoMonitor.getModel());
        hashMap.put(PHONE_BRANDS, Build.BRAND);
        hashMap.put("qq_version", AppSetting.f99551k);
        hashMap.put(SYS_TYPE, "Android");
        return hashMap;
    }

    @Override // com.tencent.mobileqq.ad.api.IAdApi
    public void report(String str, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) map);
        } else {
            QQBeaconReport.reportWithAppKey("0DOU0J4CUI43WCQ1", VasUtil.getCurrentUin(), str, map);
        }
    }

    @Override // com.tencent.mobileqq.ad.api.IAdApi
    public void requestLebaShoppingRedTouchAd(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
        } else {
            LebaShoppingRedTouchAdRequestManager.f186905a.m(aVar);
        }
    }

    @Override // com.tencent.mobileqq.ad.api.IAdApi
    public void startAdH5DebugFragment(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity);
        } else {
            AdH5DebugFragment.INSTANCE.a(activity);
        }
    }

    @Override // com.tencent.mobileqq.ad.api.IAdApi
    public void startAlphaVideoAdDebugFragment(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            AlphaVideoAdDebugFragment.INSTANCE.a(activity);
        }
    }

    @Override // com.tencent.mobileqq.ad.api.IAdApi
    public void startLoadingAdDebugFragment(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            LoadingAdDebugFragment.INSTANCE.a(activity);
        }
    }

    @Override // com.tencent.mobileqq.ad.api.IAdApi
    public void startRewardAdDebugFragment(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            RewardAdDebugFragment.INSTANCE.a(activity);
        }
    }

    @Override // com.tencent.mobileqq.ad.api.IAdApi
    public void updateLebaShoppingRedTouchLastExpoAd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            LebaShoppingRedTouchAdRequestManager.f186905a.o(str);
        }
    }
}
