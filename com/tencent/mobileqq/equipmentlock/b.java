package com.tencent.mobileqq.equipmentlock;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static int f205364a;

    /* renamed from: b, reason: collision with root package name */
    public static int f205365b;

    /* renamed from: c, reason: collision with root package name */
    public static int f205366c;

    /* renamed from: d, reason: collision with root package name */
    public static int f205367d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71764);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f205364a = 1;
        f205365b = 2;
        f205366c = 3;
        f205367d = 4;
    }

    public static void a(Activity activity, AppInterface appInterface, int i3, int i16, String str) {
        if (activity == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("EquipLockWebEntrance", 4, "enterForResult actCaller is null");
            }
        } else if (appInterface == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("EquipLockWebEntrance", 4, "enterForResult app is null");
            }
        } else {
            Intent b16 = b(activity, appInterface, i3);
            if (str != null) {
                b16.putExtra("tag", str);
            }
            b16.putExtra("needResult", true);
            try {
                VasWebviewUtil.openQQBrowserActivity(activity, "", 16384L, b16, true, i16);
            } catch (SecurityException unused) {
            }
        }
    }

    private static Intent b(Activity activity, AppInterface appInterface, int i3) {
        if (activity == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("EquipLockWebEntrance", 4, "getEntranceIntent actCaller is null");
            }
            return null;
        }
        if (appInterface == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("EquipLockWebEntrance", 4, "getEntranceIntent app is null");
            }
            return null;
        }
        String currentAccountUin = appInterface.getCurrentAccountUin();
        String e16 = e(c(i3), appInterface);
        if (QLog.isColorLevel()) {
            QLog.d("EquipLockWebEntrance", 2, "AuthDevUgAct url=" + e16);
        }
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("portraitOnly", true);
        intent.putExtra("url", e16);
        intent.putExtra("uin", currentAccountUin);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("hide_more_button", true);
        return intent;
    }

    private static String c(int i3) {
        String t16 = EquipmentLockImpl.o().t();
        if (t16 != null && t16.length() > 0) {
            if (!t16.startsWith("https") && !t16.startsWith("http")) {
                t16 = "https://" + t16;
            }
        } else {
            t16 = "https://accounts.qq.com/cn2/manage/mobile_h5/mobile_index";
        }
        StringBuilder sb5 = new StringBuilder(t16);
        if (t16.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
        } else {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        }
        sb5.append("type=" + Integer.toString(i3));
        sb5.append("&plat=1");
        sb5.append("&app=1");
        sb5.append("&version=" + AppSetting.f99554n);
        sb5.append("&device=" + URLEncoder.encode(Build.DEVICE));
        sb5.append("&system=" + Build.VERSION.RELEASE);
        sb5.append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
        return sb5.toString();
    }

    public static void d(Activity activity, String str, String str2, int i3, int i16, String str3) {
        boolean z16;
        if (activity == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("EquipLockWebEntrance", 4, "subaccountEnter actCaller is null");
                return;
            }
            return;
        }
        String c16 = c(i3);
        if (QLog.isColorLevel()) {
            QLog.d("EquipLockWebEntrance", 2, "AuthDevUgAct url=" + c16);
        }
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("portraitOnly", true);
        intent.putExtra("url", c16);
        intent.putExtra("subAccountUin", str2);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("hide_more_button", true);
        if (str != null && !str.equals(str2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EquipLockWebEntrance", 2, "globalEnter currentUin=" + str + " reqUin=" + str2 + " isSubaccount=" + z16);
        }
        intent.putExtra("isSubaccount", z16);
        intent.putExtra("avoidLoginWeb", z16);
        if (str3 != null) {
            intent.putExtra("tag", str3);
        }
        intent.putExtra("needResult", true);
        try {
            VasWebviewUtil.openQQBrowserActivity(activity, "", 16384L, intent, true, i16);
        } catch (SecurityException unused) {
        }
    }

    private static String e(String str, AppInterface appInterface) {
        String str2;
        if (str == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("EquipLockWebEntrance", 4, "handlePhoneContact url is null");
            }
            return str;
        }
        String str3 = null;
        if (appInterface != null) {
            IPhoneContactService iPhoneContactService = (IPhoneContactService) appInterface.getRuntimeService(IPhoneContactService.class, "");
            if (iPhoneContactService != null) {
                RespondQueryQQBindingStat selfBindInfo = iPhoneContactService.getSelfBindInfo();
                if (selfBindInfo == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("EquipLockWebEntrance", 2, "mgr can't find stat");
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("EquipLockWebEntrance", 2, "mgr find stat, nationCode=" + selfBindInfo.nationCode + " no.=" + selfBindInfo.mobileNo);
                    }
                    str3 = selfBindInfo.nationCode;
                    str2 = selfBindInfo.mobileNo;
                    if (str3 == null && str3.length() > 0 && str2 != null && str2.length() > 0) {
                        StringBuilder sb5 = new StringBuilder(str);
                        sb5.append("&area=" + str3);
                        sb5.append("&mob=" + str2);
                        return sb5.toString();
                    }
                    return str;
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("EquipLockWebEntrance", 2, "mgr is null");
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("EquipLockWebEntrance", 2, "getEntranceIntent:app is null");
        }
        str2 = null;
        return str3 == null ? str : str;
    }
}
