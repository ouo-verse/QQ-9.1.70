package com.tencent.mobileqq.managers;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes15.dex */
public class l implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    public static String f243743m;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f243744d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f243745e;

    /* renamed from: f, reason: collision with root package name */
    public String f243746f;

    /* renamed from: h, reason: collision with root package name */
    public String f243747h;

    /* renamed from: i, reason: collision with root package name */
    public String f243748i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72987);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f243743m = "TimUpgradeHongdianManager";
        }
    }

    public l(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f243745e = false;
            this.f243744d = qQAppInterface;
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z16 = false;
        try {
            SharedPreferences sharedPreferences = this.f243744d.getApp().getSharedPreferences(AppConstants.Preferences.TIM_UPGRADE_HONGDIAN_PRE + this.f243744d.getCurrentUin(), 0);
            this.f243745e = sharedPreferences.getBoolean(AppConstants.Preferences.TIM_UPGRADE_HONGDIAN_SWITCH, false);
            this.f243746f = sharedPreferences.getString(AppConstants.Preferences.TIM_UPGRADE_HONGDIAN_TITLE, null);
            this.f243747h = sharedPreferences.getString(AppConstants.Preferences.TIM_UPGRADE_HONGDIAN_SUB_TITLE, null);
            this.f243748i = sharedPreferences.getString(AppConstants.Preferences.TIM_UPGRADE_HONGDIAN_URL, null);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (!TextUtils.isEmpty(this.f243746f) && !TextUtils.isEmpty(this.f243747h) && !TextUtils.isEmpty(this.f243748i)) {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.i(f243743m, 2, "checkIfShowTimHongdian , switchKey = " + this.f243745e + ", mTitle = " + this.f243746f + ", mSubTitle =" + this.f243747h + ", url=" + this.f243748i + ", sp time cost = " + (currentTimeMillis2 - currentTimeMillis) + ", ifShow= " + z16);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(f243743m, 2, "checkIfShowTimHongdian " + e16.toString());
            }
        }
        return z16;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            SharedPreferences.Editor edit = this.f243744d.getApp().getSharedPreferences(AppConstants.Preferences.TIM_UPGRADE_HONGDIAN_PRE + this.f243744d.getCurrentUin(), 0).edit();
            if (edit != null) {
                edit.putBoolean(AppConstants.Preferences.TIM_UPGRADE_HONGDIAN_SWITCH, false);
                edit.putString(AppConstants.Preferences.TIM_UPGRADE_HONGDIAN_TITLE, null);
                edit.putString(AppConstants.Preferences.TIM_UPGRADE_HONGDIAN_SUB_TITLE, null);
                edit.putString(AppConstants.Preferences.TIM_UPGRADE_HONGDIAN_URL, null);
            }
            if (QLog.isColorLevel()) {
                QLog.d(f243743m, 2, "clearHondianSP done");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(f243743m, 2, "clearHondianSP " + e16.toString());
            }
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
