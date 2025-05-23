package com.tencent.mobileqq.logintempapi.impl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.decoupleim.ThirdPartyLoginBlockUtilImpl;
import com.tencent.mobileqq.login.br;
import com.tencent.mobileqq.logintempapi.ILoginApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.an;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.utils.h;
import f72.b;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LoginApiImpl implements ILoginApi {
    static IPatchRedirector $redirector_ = null;
    private static final String IS_UPGRADE = "is_upgrade";
    private static final String IS_UPGRADE_SUCCESS = "is_upgrade_success";
    private static final String NT_LOGIN_UPGRADE_REPORT = "nt_login_upgrade_report";
    private static final String TAG = "LoginApiImpl";
    private static final String UNITED_CONFIG_WT_UPGRADE = "united_config_wt_upgrade";

    public LoginApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private QQAppInterface getAppInterface(AppRuntime appRuntime) {
        if (appRuntime instanceof QQAppInterface) {
            return (QQAppInterface) appRuntime;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.logintempapi.ILoginApi
    public void checkA1Error(Activity activity, AppRuntime appRuntime, String str, String str2, String str3, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, activity, appRuntime, str, str2, str3, bVar);
        } else {
            new br().a(activity, appRuntime, str, str2, str3, bVar);
        }
    }

    @Override // com.tencent.mobileqq.logintempapi.ILoginApi
    public Object getFaceBitmap(AppRuntime appRuntime, String str, byte b16, boolean z16, boolean z17) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, appRuntime, str, Byte.valueOf(b16), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        QQAppInterface appInterface = getAppInterface(appRuntime);
        if (appInterface == null) {
            QLog.e(TAG, 1, "removeHandler error, app is null");
            return null;
        }
        Bitmap faceBitmap = appInterface.getFaceBitmap(str, b16, z16);
        QLog.d(LogTag.GET_HEAD, 1, "LoginView getHead bitmap: " + faceBitmap);
        if (z17 && faceBitmap != null && an.h().loadSoLib() && (i3 = h.e(appRuntime.getApplicationContext(), str).getInt(AppConstants.Preferences.MY_STORE_FACE_ID, 0)) > 0) {
            String e16 = VasFaceManager.e(i3, NtFaceConstant.SMALL);
            if (new File(e16).exists()) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(faceBitmap);
                try {
                    URL url = new URL("vasapngdownloader", e16, "-login-face-");
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mUseApngImage = true;
                    obtain.mUseMemoryCache = true;
                    obtain.mFailedDrawable = bitmapDrawable;
                    obtain.mLoadingDrawable = bitmapDrawable;
                    obtain.mExtraInfo = VasFaceManager.c();
                    return URLDrawable.getDrawable(url, obtain);
                } catch (Exception e17) {
                    QLog.e(TAG, 1, "getApngDrawable ApngImage err, path:" + e16, e17);
                    return faceBitmap;
                }
            }
            return faceBitmap;
        }
        return faceBitmap;
    }

    @Override // com.tencent.mobileqq.logintempapi.ILoginApi
    public boolean handleLoginFailedByThirdPartyLogin(QBaseActivity qBaseActivity, byte[] bArr, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, qBaseActivity, bArr, str, str2)).booleanValue();
        }
        return ThirdPartyLoginBlockUtilImpl.b().d(bArr, qBaseActivity, str, str2, new ThirdPartyLoginBlockUtilImpl.LoginViewOpenSDKCb(qBaseActivity));
    }

    @Override // com.tencent.mobileqq.logintempapi.ILoginApi
    public boolean handleNTLoginFailByThirdPartyLogin(QBaseActivity qBaseActivity, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, qBaseActivity, Integer.valueOf(i3), str, str2)).booleanValue();
        }
        return ThirdPartyLoginBlockUtilImpl.b().c(qBaseActivity, str, str2, i3, new ThirdPartyLoginBlockUtilImpl.LoginViewOpenSDKCb(qBaseActivity));
    }

    @Override // com.tencent.mobileqq.logintempapi.ILoginApi
    public void preloadThirdService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            com.tencent.mobileqq.webprocess.b.b(1);
        }
    }

    @Override // com.tencent.mobileqq.logintempapi.ILoginApi
    public void reportWtUpgrade() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (new Random().nextInt(10) != 6) {
            return;
        }
        QLog.d(TAG, 1, "report nt upgrade");
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), "common_mmkv_configurations");
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(UNITED_CONFIG_WT_UPGRADE, false);
        boolean decodeBool = from.decodeBool(MobileQQ.NT_LOGIN_SWITCH_KEY, false);
        HashMap hashMap = new HashMap();
        String str = "true";
        if (isSwitchOn) {
            obj = "true";
        } else {
            obj = "false";
        }
        hashMap.put(IS_UPGRADE, obj);
        if (!decodeBool) {
            str = "false";
        }
        hashMap.put(IS_UPGRADE_SUCCESS, str);
        QQBeaconReport.report(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), NT_LOGIN_UPGRADE_REPORT, hashMap);
    }
}
