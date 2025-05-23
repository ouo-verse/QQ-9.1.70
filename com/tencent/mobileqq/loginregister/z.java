package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.bean.AccountInfo;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.NumberUtil;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes15.dex */
public class z {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f243061a;

    public static void A(View view) {
        if (view == null) {
            QLog.e("LoginRegister.LoginUtils", 4, "unsetPadCompatMaxWidth view == null");
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (view instanceof QUSHalfScreenFloatingView) {
            ((QUSHalfScreenFloatingView) view).setMaxWidthDp(0);
        } else {
            layoutParams.width = -1;
        }
        view.setLayoutParams(layoutParams);
    }

    public static Dialog a(Activity activity, int i3) {
        return DialogUtil.createWaitingDialog(activity, i3);
    }

    public static boolean b(Context context) {
        if (context == null) {
            if (QLog.isDevelopLevel() && QLog.isDebugVersion()) {
                QLog.d("LoginRegister.LoginUtils", 4, "enablePadCompat context == null");
            }
            return false;
        }
        if (!AppSetting.o(context)) {
            if (QLog.isDevelopLevel() && QLog.isDebugVersion()) {
                QLog.d("LoginRegister.LoginUtils", 4, "isAllowLandscape == false");
            }
            return false;
        }
        if (context.getResources().getConfiguration().orientation != 2) {
            if (QLog.isDevelopLevel() && QLog.isDebugVersion()) {
                QLog.d("LoginRegister.LoginUtils", 4, "Configuration.orientation != ORIENTATION_LANDSCAPE");
            }
            return false;
        }
        return true;
    }

    public static boolean c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("login_enable_show_hide_keyboard", false);
    }

    public static AccountInfo d(List<AccountInfo> list, String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && list != null) {
            int i3 = 0;
            AccountInfo accountInfo = null;
            for (AccountInfo accountInfo2 : list) {
                if (o(str, accountInfo2, str2)) {
                    i3++;
                    accountInfo = accountInfo2;
                }
            }
            if (i3 == 1) {
                return accountInfo;
            }
        }
        return null;
    }

    public static MqqHandler e(AppRuntime appRuntime, Class<?> cls) {
        if (!(appRuntime instanceof AppInterface)) {
            QLog.e("LoginRegister.LoginUtils", 1, "getHandler, but appRuntime is not appinterface");
            return null;
        }
        return ((AppInterface) appRuntime).getHandler(cls);
    }

    private static String f(String str) {
        com.tencent.mobileqq.login.account.a e16 = com.tencent.mobileqq.login.account.d.f241848a.e(str);
        if (e16 == null) {
            return null;
        }
        if (e16.b() != 5 && e16.b() != 4 && e16.b() != 7) {
            return null;
        }
        return e16.a();
    }

    public static String g(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String h(String str) {
        if (!AppSetting.o(BaseApplication.getContext())) {
            return str;
        }
        Map<String, String> arguments = URLUtil.getArguments("_wwv");
        long j3 = 2;
        if (arguments.containsKey("_wwv")) {
            j3 = 2 | NumberUtil.stringToLong(arguments.get("_wwv"));
        }
        return URLUtil.addParameter(URLUtil.deleteParameter(str, "_wwv"), "_wwv", String.valueOf(j3));
    }

    public static String i() {
        if (!TextUtils.isEmpty(f243061a)) {
            return f243061a;
        }
        String c16 = com.tencent.mobileqq.statistics.o.c();
        f243061a = c16;
        return c16;
    }

    public static boolean j(QBaseActivity qBaseActivity, AppRuntime appRuntime) {
        if (BaseGesturePWDUtil.getGesturePWDState(qBaseActivity, appRuntime.getAccount()) == 2 && BaseGesturePWDUtil.getGesturePWDMode(qBaseActivity, appRuntime.getAccount()) == 21) {
            return true;
        }
        return false;
    }

    public static boolean k(String str) {
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        ArrayList<SimpleAccount> arrayList = new ArrayList();
        if (allAccounts != null) {
            arrayList.addAll(allAccounts);
        }
        if (arrayList.size() < 8) {
            return false;
        }
        for (SimpleAccount simpleAccount : arrayList) {
            if (simpleAccount != null && TextUtils.equals(simpleAccount.getUin(), str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean l(Activity activity) {
        Intent intent;
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            return true;
        }
        boolean booleanExtra = intent.getBooleanExtra("is_change_account", false);
        boolean booleanExtra2 = intent.getBooleanExtra("IS_ADD_ACCOUNT", false);
        boolean booleanExtra3 = intent.getBooleanExtra("is_sub_account_login", false);
        boolean booleanExtra4 = intent.getBooleanExtra("is_open_sdk_add_account", false);
        boolean booleanExtra5 = intent.getBooleanExtra("is_need_login_with_mask", false);
        boolean booleanExtra6 = intent.getBooleanExtra("is_from_deactivate_account_page", false);
        if (booleanExtra || booleanExtra2 || booleanExtra3 || booleanExtra4 || booleanExtra5 || booleanExtra6) {
            return true;
        }
        return false;
    }

    private static boolean m(String str, String str2) {
        if (str == null || str2 == null || str.length() != str2.length()) {
            return false;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            char charAt2 = str2.charAt(i3);
            if (charAt != '*' && charAt2 != '*' && charAt != charAt2) {
                return false;
            }
        }
        return true;
    }

    private static boolean n(String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int indexOf = str.indexOf(42);
            int lastIndexOf = str.lastIndexOf(42);
            String str4 = null;
            if (indexOf > 0 && indexOf < str.length()) {
                str3 = str.substring(0, indexOf);
            } else {
                str3 = null;
            }
            if (lastIndexOf >= 0 && lastIndexOf < str.length() - 1) {
                str4 = str.substring(lastIndexOf + 1);
            }
            if (!TextUtils.isEmpty(str3) && !str2.startsWith(str3)) {
                return false;
            }
            if (!TextUtils.isEmpty(str4) && !str2.endsWith(str4)) {
                return false;
            }
        }
        return true;
    }

    public static boolean o(String str, AccountInfo accountInfo, String str2) {
        if (TextUtils.isEmpty(str) || accountInfo == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        String f16 = f(str2);
        String property = MobileQQ.sMobileQQ.getProperty(Constants.PropertiesKey.nickName.toString() + str2);
        if (!m(str, f16) || !m(accountInfo.getMaskUin(), str2) || !n(accountInfo.getMaskNick(), property)) {
            return false;
        }
        return true;
    }

    public static boolean p(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Long.parseLong(str) <= 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void q(View view, Context context) {
        if (b(context)) {
            y(view);
        } else {
            A(view);
        }
    }

    public static HashMap<String, String> r(String str) {
        String str2;
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str2 = Uri.parse(str).getEncodedQuery();
        } catch (Exception e16) {
            QLog.w("LoginRegister.LoginUtils", 1, "parseUrlParameters exception", e16);
            str2 = null;
        }
        if (str2 == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String[] split2 = str2.split("[&]");
        if (split2 != null && split2.length > 0) {
            for (String str3 : split2) {
                if (str3 != null && (split = str3.split("[=]")) != null && split.length == 2) {
                    String str4 = split[0];
                    String str5 = split[1];
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
                        hashMap.put(str4, str5);
                    }
                }
            }
        }
        return hashMap;
    }

    public static void s(AppRuntime appRuntime, Class<?> cls) {
        if (!(appRuntime instanceof AppInterface)) {
            QLog.e("LoginRegister.LoginUtils", 1, "removeHandler, but appRuntime is not appinterface");
        } else {
            ((AppInterface) appRuntime).removeHandler(cls);
        }
    }

    public static void t(Activity activity, String str) {
        String str2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && activity != null) {
            String h16 = h(AppConstants.FORGET_PWD_URL);
            if (!TextUtils.isEmpty(str)) {
                h16 = URLUtil.addParameter(h16, "account", str);
            }
            String g16 = com.tencent.mobileqq.accountbinding.d.f174609a.g();
            if (!TextUtils.isEmpty(g16)) {
                h16 = URLUtil.addParameter(h16, "wx_account", g16);
            }
            String bytes2HexStr = HexUtil.bytes2HexStr(com.tencent.mobileqq.guid.c.f213821a.c());
            if (bytes2HexStr != null) {
                str2 = bytes2HexStr.toLowerCase();
            } else {
                str2 = "";
            }
            String addParameter = URLUtil.addParameter(URLUtil.addParameter(h16, "guid", str2), "appid", String.valueOf(AppSetting.f()));
            QLog.d("LoginRegister.LoginUtils", 1, "retrievePassword url is ", addParameter);
            Intent intent = new Intent();
            intent.putExtra("uin", peekAppRuntime.getAccount());
            intent.putExtra("url", addParameter);
            intent.putExtra("reqType", 3);
            z(activity, intent, RouterConstants.UI_ROUTE_BROWSER);
            return;
        }
        QLog.e("LoginRegister.LoginUtils", 1, "retrievePassword app is null or activity is null");
    }

    private static void u(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).gravity = 1;
        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(14, -1);
        } else if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 1;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void v(AppRuntime appRuntime, Class<?> cls, MqqHandler mqqHandler) {
        if (!(appRuntime instanceof AppInterface)) {
            QLog.e("LoginRegister.LoginUtils", 1, "getHandler, but appRuntime is not appinterface");
        } else {
            ((AppInterface) appRuntime).setHandler(cls, mqqHandler);
        }
    }

    public static void w(View view) {
        x(view, 500);
    }

    public static void x(View view, int i3) {
        if (view == null) {
            QLog.e("LoginRegister.LoginUtils", 4, "setPadCompatMaxWidth view == null");
            return;
        }
        if (BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels <= ViewUtils.dpToPx(840.0f)) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (view instanceof QUSHalfScreenFloatingView) {
            ((QUSHalfScreenFloatingView) view).setMaxWidthDp(i3);
        } else {
            layoutParams.width = ViewUtils.dpToPx(i3);
        }
        view.setLayoutParams(layoutParams);
        u(view);
    }

    public static void y(View view) {
        x(view, 596);
    }

    public static void z(Context context, Intent intent, String str) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, str);
        activityURIRequest.extra().putAll(intent.getExtras());
        activityURIRequest.setFlags(intent.getFlags());
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }
}
