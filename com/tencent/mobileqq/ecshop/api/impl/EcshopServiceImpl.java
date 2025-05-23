package com.tencent.mobileqq.ecshop.api.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.mobileqq.ecshop.api.IEcshopService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EcshopServiceImpl implements IEcshopService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "EcshopServiceImpl";

    public EcshopServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ecshop.api.IEcshopService
    public void enterGDTVideoActivity(qq_ad_get.QQAdGetRsp.AdInfo adInfo, String str, boolean z16, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, adInfo, str, Boolean.valueOf(z16), activity);
            return;
        }
        try {
            GdtAd gdtAd = new GdtAd(adInfo);
            GdtHandler.Params params = new GdtHandler.Params();
            params.processId = 1;
            params.activity = new WeakReference<>(activity);
            params.f108486ad = gdtAd;
            params.reportForClick = z16;
            params.appAutoDownload = false;
            params.videoCeilingSupportedIfNotInstalled = true;
            Bundle bundle = params.extra;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(LaunchParam.KEY_REF_ID, ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(str));
            params.extra = bundle;
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "enterGDTVideoActivity throw an exception: " + th5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005e A[Catch: Exception -> 0x0083, TryCatch #0 {Exception -> 0x0083, blocks: (B:9:0x002b, B:11:0x0039, B:15:0x0046, B:17:0x005e, B:18:0x0063), top: B:8:0x002b }] */
    @Override // com.tencent.mobileqq.ecshop.api.IEcshopService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean enterGdtCanvasActivity(qq_ad_get.QQAdGetRsp.AdInfo adInfo, String str, boolean z16, Activity activity) {
        boolean z17;
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, adInfo, str, Boolean.valueOf(z16), activity)).booleanValue();
        }
        try {
            GdtAd gdtAd = new GdtAd(adInfo);
            if (!IPublicAccountUtil.UIN_FOR_WALLET.equals(str) && !IPublicAccountUtil.UIN_FOR_SHOP.equals(str)) {
                z17 = true;
                GdtHandler.Params params = new GdtHandler.Params();
                params.processId = 1;
                params.activity = new WeakReference<>(activity);
                params.f108486ad = gdtAd;
                params.reportForClick = z16;
                params.appAutoDownload = z17;
                bundle = params.extra;
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString(LaunchParam.KEY_REF_ID, ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(str));
                params.extra = bundle;
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
                return true;
            }
            z17 = false;
            GdtHandler.Params params2 = new GdtHandler.Params();
            params2.processId = 1;
            params2.activity = new WeakReference<>(activity);
            params2.f108486ad = gdtAd;
            params2.reportForClick = z16;
            params2.appAutoDownload = z17;
            bundle = params2.extra;
            if (bundle == null) {
            }
            bundle.putString(LaunchParam.KEY_REF_ID, ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getSourceId(str));
            params2.extra = bundle;
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
