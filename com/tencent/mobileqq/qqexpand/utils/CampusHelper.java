package com.tencent.mobileqq.qqexpand.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes35.dex */
public class CampusHelper {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes35.dex */
    public @interface CertificateType {
    }

    public static boolean a(QQAppInterface qQAppInterface) {
        boolean z16 = b(qQAppInterface).getBoolean("need_show_campus_certi_banner", false);
        if (QLog.isColorLevel()) {
            QLog.d("CampusHelper", 2, "getCampusCertificateBannerShowFlag result = " + z16);
        }
        return z16;
    }

    public static SharedPreferences b(BaseQQAppInterface baseQQAppInterface) {
        return baseQQAppInterface.getApp().getSharedPreferences(baseQQAppInterface.getCurrentUin() + "extend_friend_campus_file", 0);
    }

    public static boolean c(QQAppInterface qQAppInterface) {
        boolean z16 = b(qQAppInterface).getBoolean("has_shown_fill_birthday_dialog_before", false);
        if (QLog.isColorLevel()) {
            QLog.d("CampusHelper", 2, "hasShownFillBirthdayDialogBefore result = " + z16);
        }
        return z16;
    }

    public static void d(Activity activity, int i3, int i16, String str, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str)) {
            str3 = "https://ti.qq.com/hybrid-h5/school_relation/extendeducation?fromid=2&_wv=16777220&_wwv=128&category=" + i16 + "&schoolname=" + str + "&schoolid=" + str2 + "&idx=" + i3;
        } else {
            str3 = "https://ti.qq.com/hybrid-h5/school_relation/extendeducation?fromid=2&_wv=16777220&_wwv=128";
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusHelper", 2, String.format("jumpToEditSchoolInfoWebPage url=%s", str3));
        }
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str3);
        activity.startActivity(intent);
    }

    public static void e(Activity activity, int i3, String str, String str2) {
        String str3 = "https://h5.qzone.qq.com/v2/wezone/schoolauth?busitype=2&_wv=3&_proxy=1&idx=" + i3 + "&schoolname=" + str + "&schoolid=" + str2;
        if (QLog.isColorLevel()) {
            QLog.d("CampusHelper", 2, String.format("jumpToSchoolCertificateWebPage url=%s", str3));
        }
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str3);
        activity.startActivity(intent);
    }

    public static void f(Activity activity, String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            str2 = "https://ti.qq.com/hybrid-h5/school_relation/selectschool?fromid=2&_wv=16777222&_wwv=128&schoolname=" + str;
        } else {
            str2 = "https://ti.qq.com/hybrid-h5/school_relation/selectschool?fromid=2&_wv=16777222&_wwv=128";
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusHelper", 2, String.format("jumpToSchoolFillInWebPage url=%s", str2));
        }
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str2);
        activity.startActivity(intent);
    }

    public static void g(QQAppInterface qQAppInterface) {
        b(qQAppInterface).edit().putBoolean("has_shown_fill_birthday_dialog_before", true).commit();
        if (QLog.isColorLevel()) {
            QLog.d("CampusHelper", 2, "markHasShownFillBirthdayDialog ");
        }
    }

    public static void i(BaseQQAppInterface baseQQAppInterface, boolean z16) {
        b(baseQQAppInterface).edit().putBoolean("need_show_campus_certi_banner", z16).commit();
        if (QLog.isColorLevel()) {
            QLog.d("CampusHelper", 2, "updateCampusCertificateBannerShowFlag result = " + z16);
        }
    }

    public static void j(QQAppInterface qQAppInterface, int i3, int i16) {
        SharedPreferences b16 = b(qQAppInterface);
        int i17 = b16.getInt("campus_certi_status", -1);
        if (i3 != i17) {
            b16.edit().putInt("campus_certi_status", i3).commit();
            if (i3 == 0) {
                i(qQAppInterface, true);
            } else if (i16 == 2) {
                i(qQAppInterface, true);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusHelper", 2, "updateCertificateBannerShowFlag  oldStatus = " + i17 + ",newStatus = " + i3 + ",certificateType = " + i16);
        }
    }

    public static void k(QQAppInterface qQAppInterface, boolean z16) {
        if (qQAppInterface == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CampusHelper", 2, "updateShowSchoolBeginnerTip " + z16);
        }
        b(qQAppInterface).edit().putBoolean("extend_friend_school_beginner_guide", z16).commit();
    }

    public static boolean h(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            return false;
        }
        return b(qQAppInterface).getBoolean("extend_friend_school_beginner_guide", true);
    }
}
