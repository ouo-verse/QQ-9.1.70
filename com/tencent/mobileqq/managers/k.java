package com.tencent.mobileqq.managers;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.pm.PackageUtil;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import mqq.app.WtloginPrivacyListenerImpl;
import mqq.app.WtloginReportListenerImpl;
import mqq.app.WtloginSwitchListenerImpl;
import mqq.manager.Manager;
import oicq.wlogin_sdk.listener.PrivacyListener;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k implements Manager, Handler.Callback {
    static IPatchRedirector $redirector_;
    public static String H;
    public JSONArray C;
    public JSONArray D;
    public int E;
    public int F;
    public int G;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f243731d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f243732e;

    /* renamed from: f, reason: collision with root package name */
    private long f243733f;

    /* renamed from: h, reason: collision with root package name */
    private int f243734h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f243735i;

    /* renamed from: m, reason: collision with root package name */
    public int f243736m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(AppConstants.TIM_PACKAGE_NAME, "com.tencent.mobileqq.activity.SplashActivity"));
            intent.setFlags(268435456);
            k.this.f243731d.getApp().startActivity(intent);
            dialogInterface.dismiss();
            ReportController.o(k.this.f243731d, "dc00898", "", "", "0X80085DA", "0X80085DA", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
                ReportController.o(k.this.f243731d, "dc00898", "", "", "0X80085DB", "0X80085DB", 0, 0, "", "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c extends WtloginListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQProgressDialog f243739b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WtloginHelper f243740c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f243741d;

        c(QQProgressDialog qQProgressDialog, WtloginHelper wtloginHelper, Bundle bundle) {
            this.f243739b = qQProgressDialog;
            this.f243740c = wtloginHelper;
            this.f243741d = bundle;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, k.this, qQProgressDialog, wtloginHelper, bundle);
            }
        }

        @Override // oicq.wlogin_sdk.request.WtloginListener
        public void OnException(ErrMsg errMsg, int i3, WUserSigInfo wUserSigInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, errMsg, Integer.valueOf(i3), wUserSigInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(k.H, 2, "jumpTimLogin OnException=" + errMsg + ", cmd=" + i3);
            }
            QQProgressDialog qQProgressDialog = this.f243739b;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.f243739b.dismiss();
            }
            QQToast.makeText(k.this.f243731d.getApp(), 1, R.string.i0t, 0).show();
        }

        @Override // oicq.wlogin_sdk.request.WtloginListener
        public void onGetA1WithA1(String str, long j3, int i3, long j16, byte[] bArr, long j17, long j18, long j19, byte[] bArr2, byte[] bArr3, WUserSigInfo wUserSigInfo, WFastLoginInfo wFastLoginInfo, int i16, ErrMsg errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), bArr, Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), bArr2, bArr3, wUserSigInfo, wFastLoginInfo, Integer.valueOf(i16), errMsg);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(k.H, 2, "jumpTimLogin onGetA1WithA1 ret=" + i16);
            }
            QQProgressDialog qQProgressDialog = this.f243739b;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                this.f243739b.dismiss();
            }
            if (i16 != 0) {
                QQToast.makeText(k.this.f243731d.getApp(), 1, R.string.i0t, 0).show();
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(k.H, 2, "jumpTimLogin call TIM JumpActivity");
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(AppConstants.TIM_PACKAGE_NAME, "com.tencent.mobileqq.activity.LoginJumpTeamWorkActivity"));
            intent.setFlags(268435456);
            intent.putExtras(this.f243740c.PrepareQloginResult(str, j18, j19, i16, wFastLoginInfo));
            intent.putExtras(this.f243741d);
            k.this.f243731d.getApp().startActivity(intent);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72986);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            H = "TimJumpLoginManager";
        }
    }

    public k(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f243732e = null;
        this.f243733f = -1L;
        this.f243734h = 0;
        this.f243735i = false;
        this.f243736m = 60;
        this.C = null;
        this.D = null;
        this.E = 72;
        this.F = 5;
        this.G = 24;
        this.f243731d = qQAppInterface;
        this.f243732e = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0176 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b() {
        boolean z16;
        boolean z17;
        if (!this.f243735i) {
            if (QLog.isColorLevel()) {
                QLog.d(H, 2, "switchKey false");
            }
            return false;
        }
        if (this.f243734h > this.F) {
            if (QLog.isColorLevel()) {
                QLog.d(H, 2, "showCount = " + this.f243734h + ", showTipTotalCount = " + this.F);
            }
            return false;
        }
        if (System.currentTimeMillis() - this.f243733f < this.G * 60 * 60 * 1000) {
            if (QLog.isColorLevel()) {
                QLog.d(H, 2, "lastShowTime = " + this.f243733f + ", showTipHourInterval = " + this.G);
            }
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        int i3 = calendar.get(7) - 1;
        if (this.C != null) {
            for (int i16 = 0; i16 < this.C.length(); i16++) {
                if (i3 == this.C.optInt(i16)) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (!z16) {
            return false;
        }
        int i17 = calendar.get(11);
        JSONArray jSONArray = this.D;
        if (jSONArray != null && jSONArray.length() == 2) {
            int optInt = this.D.optInt(0);
            int optInt2 = this.D.optInt(1);
            if (i17 >= optInt && i17 < optInt2) {
                if (!PackageUtil.isPackageInstalled(this.f243731d.getApp(), AppConstants.TIM_PACKAGE_NAME)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(H, 2, "tim not installed");
                    }
                    return false;
                }
                File file = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/com/tencent/tim");
                if (file.exists() && System.currentTimeMillis() - file.lastModified() < this.E * 60 * 60 * 1000) {
                    if (QLog.isColorLevel()) {
                        QLog.d(H, 2, "timLogFile.lastModified() = " + file.lastModified() + ", androidLimit = " + this.E);
                    }
                    return false;
                }
                BaseActivity baseActivity = BaseActivity.sTopActivity;
                if (baseActivity instanceof SplashActivity) {
                    if (SplashActivity.currentFragment == 1) {
                        z17 = true;
                        if (!z17) {
                            return true;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(H, 2, "is not in main tab");
                        }
                        return false;
                    }
                }
                z17 = false;
                if (!z17) {
                }
            }
        }
        return false;
    }

    private void d() {
        if (!this.f243731d.isLogin()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(H, 2, "showTimLoginDialog");
        }
        SharedPreferences sharedPreferences = this.f243731d.getApp().getSharedPreferences(AppConstants.Preferences.TIM_LOGIN_SHARED_PRE + this.f243731d.getCurrentUin(), 0);
        try {
            String string = sharedPreferences.getString(AppConstants.Preferences.TIM_LOGIN_SHOW_TIPS_DAY, "");
            if (!TextUtils.isEmpty(string)) {
                this.C = new JSONArray(string);
            }
            String string2 = sharedPreferences.getString(AppConstants.Preferences.TIM_LOGIN_SHOW_TIPS_TIME, "");
            if (!TextUtils.isEmpty(string2)) {
                this.D = new JSONArray(string2);
            }
        } catch (Exception unused) {
        }
        this.E = sharedPreferences.getInt(AppConstants.Preferences.TIM_LOGIN_ANDROID_LIMIT, 72);
        this.F = sharedPreferences.getInt(AppConstants.Preferences.TIM_LOGIN_TOTAL_COUNT, 5);
        this.G = sharedPreferences.getInt(AppConstants.Preferences.TIM_LOGIN_SHOW_TIME_INTERVAL, 24);
        this.f243733f = sharedPreferences.getLong(AppConstants.Preferences.TIM_LOGIN_LAST_SHOW_TIME, 0L);
        this.f243734h = sharedPreferences.getInt(AppConstants.Preferences.TIM_LOGIN_SHOW_COUNT, 0);
        if (!b()) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        int i3 = this.f243734h + 1;
        this.f243734h = i3;
        edit.putInt(AppConstants.Preferences.TIM_LOGIN_SHOW_COUNT, i3);
        edit.putLong(AppConstants.Preferences.TIM_LOGIN_LAST_SHOW_TIME, System.currentTimeMillis());
        edit.commit();
        String qqStr = HardCodeUtil.qqStr(R.string.u6f);
        String str = "\u767b\u5f55TIM";
        String qqStr2 = HardCodeUtil.qqStr(R.string.j6l);
        String string3 = sharedPreferences.getString(AppConstants.Preferences.TIM_LOGIN_TITLE, "QQ\u529e\u516c\u7b80\u6d01\u7248");
        String string4 = sharedPreferences.getString(AppConstants.Preferences.TIM_LOGIN_CONTENT, qqStr);
        try {
            String string5 = sharedPreferences.getString(AppConstants.Preferences.TIM_LOGIN_BTN_TEXT, "");
            if (!TextUtils.isEmpty(string5)) {
                JSONArray jSONArray = new JSONArray(string5);
                if (jSONArray.length() == 2) {
                    if (!TextUtils.isEmpty(jSONArray.optString(0))) {
                        qqStr2 = jSONArray.optString(0);
                    }
                    if (!TextUtils.isEmpty(jSONArray.optString(1))) {
                        str = jSONArray.optString(1);
                    }
                }
            }
        } catch (Exception unused2) {
        }
        DialogUtil.createCustomDialog(BaseActivity.sTopActivity, 230, string3, string4, qqStr2, str, new a(), new b()).show();
        ReportController.o(this.f243731d, "dc00898", "", "", "0X80085D9", "0X80085D9", 0, 0, "", "", "", "");
    }

    public void c(Bundle bundle) {
        int parseInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        if (!com.tencent.mobileqq.utils.PackageUtil.verifyInstalledApp(this.f243731d.getApp(), AppConstants.TIM_PACKAGE_NAME, AppConstants.TIM_SIG_MD5)) {
            QQToast.makeText(this.f243731d.getApp(), 1, R.string.i0u, 0).show();
            if (QLog.isColorLevel()) {
                QLog.d(H, 2, "jumpTimLogin tim not install ");
                return;
            }
            return;
        }
        String checkAppInstalled = com.tencent.mobileqq.utils.PackageUtil.checkAppInstalled(this.f243731d.getApp(), AppConstants.TIM_PACKAGE_NAME);
        int m3 = TencentDocConvertConfigProcessor.a().m();
        if (QLog.isColorLevel()) {
            QLog.d(H, 2, "jumpTimLogin tim timVersion=" + checkAppInstalled + "tim limit version = " + m3);
        }
        try {
            parseInt = Integer.parseInt(checkAppInstalled.replace(".", ""));
        } catch (Exception unused) {
        }
        if (parseInt == 0) {
            QQToast.makeText(this.f243731d.getApp(), 1, R.string.i0u, 0).show();
            return;
        }
        if (parseInt < m3) {
            QQToast.makeText(this.f243731d.getApp(), 1, R.string.i0v, 0).show();
            return;
        }
        QQProgressDialog qQProgressDialog = new QQProgressDialog(BaseActivity.sTopActivity, this.f243731d.getApplication().getResources().getDimensionPixelOffset(R.dimen.title_bar_height));
        qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.u6d));
        qQProgressDialog.show();
        WtloginHelper.setReportListener(WtloginReportListenerImpl.getSingleton());
        WtloginHelper.setSwitchListener(WtloginSwitchListenerImpl.getSingleton());
        WtloginHelper wtloginHelper = new WtloginHelper(this.f243731d.getApplication().getApplicationContext(), (PrivacyListener) WtloginPrivacyListenerImpl.getSingleton());
        wtloginHelper.SetTimeOut(20);
        wtloginHelper.SetMsfTransportFlag(1);
        wtloginHelper.SetListener(new c(qQProgressDialog, wtloginHelper, bundle));
        int GetA1WithA1 = wtloginHelper.GetA1WithA1(this.f243731d.getAccount(), 16L, 16L, AppConstants.TIM_PACKAGE_NAME.getBytes(), 1L, 16L, 16L, AppSetting.f99551k.getBytes(), util.getPkgSigFromApkName(this.f243731d.getApp(), AppConstants.TIM_PACKAGE_NAME), new WUserSigInfo(), new WFastLoginInfo());
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("source", "TimJumpLoginManager");
            QQBeaconReport.report(this.f243731d.getAccount(), "wtlogin_invalid_init", hashMap);
        } catch (Exception e16) {
            QLog.e(H, 1, e16, new Object[0]);
        }
        if (GetA1WithA1 != -1001) {
            if (QLog.isColorLevel()) {
                QLog.d(H, 2, "jumpTimLogin GetA1WithA1, retCode = " + GetA1WithA1);
            }
            if (qQProgressDialog.isShowing()) {
                qQProgressDialog.dismiss();
            }
            QQToast.makeText(this.f243731d.getApp(), 1, R.string.i0t, 0).show();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 10011) {
            d();
            return true;
        }
        return true;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
