package com.tencent.mobileqq.login;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.collection.ArrayMap;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class bq {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ArrayMap<String, Long> f242022a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f242023d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f242024e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AppInterface f242025f;

        a(String str, Activity activity, AppInterface appInterface) {
            this.f242023d = str;
            this.f242024e = activity;
            this.f242025f = appInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, activity, appInterface);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            try {
                dialogInterface.dismiss();
            } catch (Exception e16) {
                QLog.e("PwdSetUtil", 1, "gotoPwdSetWebsite: dismiss exception. " + e16.getMessage());
            }
            bq.b(this.f242023d, this.f242024e, this.f242025f);
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
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            try {
                dialogInterface.dismiss();
            } catch (Exception e16) {
                QLog.e("PwdSetUtil", 1, "gotoPwdSetWebsite: dismiss exception. " + e16.getMessage());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72778);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f242022a = new ArrayMap<>();
        }
    }

    public static boolean a(AppInterface appInterface, Activity activity) {
        String currentAccountUin = appInterface.getCurrentAccountUin();
        if (com.tencent.mobileqq.phonelogin.a.a().b(appInterface, currentAccountUin)) {
            return false;
        }
        QLog.d("PwdSetUtil", 1, "checkHasSetPwd: not set");
        if (activity == null) {
            QLog.e("PwdSetUtil", 1, "gotoPwdSetWebsite: activity is null");
            return false;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        createCustomDialog.setTitle(R.string.g1i);
        createCustomDialog.setMessage(R.string.g1h);
        a aVar = new a(currentAccountUin, activity, appInterface);
        b bVar = new b();
        createCustomDialog.setPositiveButton(R.string.g1g, aVar);
        createCustomDialog.setNegativeButton(R.string.f171185d01, bVar);
        createCustomDialog.show();
        return true;
    }

    public static void b(String str, Activity activity, AppInterface appInterface) {
        c("https://accounts.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw", str, activity, appInterface);
    }

    public static void c(String str, String str2, Activity activity, AppInterface appInterface) {
        String str3;
        if (activity == null) {
            QLog.e("PwdSetUtil", 1, "gotoPwdSetWebsite: activity is null");
            return;
        }
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str3 = str + ContainerUtils.FIELD_DELIMITER;
        } else {
            str3 = str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        }
        String str4 = str3 + "uin=" + str2 + "&plat=1&app=1&version=" + AppSetting.f99554n + "&device=" + URLEncoder.encode(Build.DEVICE) + "&system=" + Build.VERSION.RELEASE + "&systemInt=" + Build.VERSION.SDK_INT;
        Intent intent = new Intent();
        intent.putExtra("url", str4);
        intent.putExtra("portraitOnly", true);
        intent.putExtra("uin", str2);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("hide_more_button", true);
        VasWebviewUtil.openQQBrowserActivity(activity, str4, 32768L, intent, false, -1);
        ReportController.o(appInterface, "CliOper", "", "", "Mobile_signup", "Setiing_pw_tips", 0, 0, "", "", "", "");
    }

    public static boolean d(AppRuntime appRuntime) {
        MobileQQ application;
        if (appRuntime == null || (application = appRuntime.getApplication()) == null) {
            return false;
        }
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        if (com.tencent.mobileqq.phonelogin.a.a().b(appRuntime, currentAccountUin)) {
            QLog.d("PwdSetUtil", 1, "shouldShowSetPwdBanner: current account hasSetPwd");
            return false;
        }
        Long l3 = f242022a.get(currentAccountUin);
        if (l3 == null || l3.longValue() == 0) {
            SharedPreferences sharedPreferences = application.getSharedPreferences("pwd_sharedpref", 0);
            if (sharedPreferences == null) {
                return false;
            }
            l3 = Long.valueOf(sharedPreferences.getLong("pwd_ts_key" + currentAccountUin, 0L));
            f242022a.put(currentAccountUin, l3);
        }
        if (System.currentTimeMillis() - l3.longValue() <= 86400000) {
            return false;
        }
        QLog.d("PwdSetUtil", 1, "shouldShowSetPwdBanner: interval larger than one day");
        return true;
    }

    public static void e(AppRuntime appRuntime) {
        MobileQQ application;
        if (appRuntime == null || (application = appRuntime.getApplication()) == null) {
            return;
        }
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        long currentTimeMillis = System.currentTimeMillis();
        f242022a.put(currentAccountUin, Long.valueOf(currentTimeMillis));
        SharedPreferences sharedPreferences = application.getSharedPreferences("pwd_sharedpref", 0);
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putLong("pwd_ts_key" + currentAccountUin, currentTimeMillis).apply();
    }
}
