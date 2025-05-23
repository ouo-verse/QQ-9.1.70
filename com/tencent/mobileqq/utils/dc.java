package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.config.business.QQKouBeiYunYingConfProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class dc {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f307616a = true;

    public static void A(final QQAppInterface qQAppInterface, final QBaseActivity qBaseActivity) {
        JSONObject i3;
        if (qQAppInterface != null && qBaseActivity != null) {
            String str = Build.MANUFACTURER;
            final boolean equalsIgnoreCase = str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI);
            final boolean equalsIgnoreCase2 = str.equalsIgnoreCase("OPPO");
            final boolean equalsIgnoreCase3 = str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO);
            if ((!equalsIgnoreCase && !equalsIgnoreCase2 && !equalsIgnoreCase3) || (i3 = i()) == null) {
                return;
            }
            String optString = i3.optString("MESSAGE_TEXT");
            String optString2 = i3.optString("CANCEL_TEXT");
            String optString3 = i3.optString("NEGATIVE_TEXT");
            String optString4 = i3.optString("POSITIVE_TEXT");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                QQCustomDialog createVerticalThreeBtnDialog = DialogUtil.createVerticalThreeBtnDialog(qBaseActivity, 0, "", optString, optString2, optString3, optString4, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.utils.db
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        dc.w(equalsIgnoreCase, qQAppInterface, equalsIgnoreCase2, equalsIgnoreCase3, dialogInterface, i16);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.utils.cz
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        dc.u(QQAppInterface.this, equalsIgnoreCase, equalsIgnoreCase2, equalsIgnoreCase3, dialogInterface, i16);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.utils.da
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        dc.v(equalsIgnoreCase, qBaseActivity, qQAppInterface, equalsIgnoreCase2, equalsIgnoreCase3, dialogInterface, i16);
                    }
                });
                z(createVerticalThreeBtnDialog);
                createVerticalThreeBtnDialog.show();
                if (equalsIgnoreCase) {
                    B(qQAppInterface, "0X800C094");
                } else if (equalsIgnoreCase2) {
                    B(qQAppInterface, "0X800C098");
                } else if (equalsIgnoreCase3) {
                    B(qQAppInterface, "0X800C09C");
                }
                C(qBaseActivity.getApplicationContext());
            }
        }
    }

    public static void B(QQAppInterface qQAppInterface, String str) {
        ReportController.o(qQAppInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }

    public static void C(Context context) {
        int f16 = f(context);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        long currentTimeMillis = System.currentTimeMillis();
        if (f16 == 0) {
            edit.putLong("KouBeiOpenDialogFirst", currentTimeMillis);
        }
        edit.putLong("KouBeiOpenDialogRefresh", currentTimeMillis);
        int i3 = f16 + 1;
        edit.putInt("KouBeiOpenDialogTimes", i3);
        edit.apply();
        if (QLog.isColorLevel()) {
            QLog.d("QQKouBeiYunYingUtils", 2, "updateOpenDialogTimes: " + i3);
        }
    }

    public static void D(Context context) {
        if (!f307616a) {
            return;
        }
        int k3 = k(context);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (o(context)) {
            k3 = 0;
        }
        if (k3 == 0) {
            edit.putLong("KouBeiOpenQQFirst", Calendar.getInstance().get(6));
        }
        int i3 = k3 + 1;
        edit.putInt("KouBeiSwitchBackGround", i3);
        edit.apply();
        if (QLog.isColorLevel()) {
            QLog.d("QQKouBeiYunYingUtils", 2, "updateSwitchTimes: " + i3);
        }
        f307616a = false;
    }

    public static void d(Context context) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("KouBeiOpenDialogTimes", 0);
        edit.apply();
    }

    public static boolean e() {
        return QQKouBeiYunYingConfProcessor.a().a();
    }

    public static int f(Context context) {
        int i3 = PreferenceManager.getDefaultSharedPreferences(context).getInt("KouBeiOpenDialogTimes", 0);
        if (QLog.isColorLevel()) {
            QLog.d("QQKouBeiYunYingUtils", 2, "getOpenDialogTimes: " + i3);
        }
        return i3;
    }

    public static int g() {
        return QQKouBeiYunYingConfProcessor.a().e();
    }

    public static int h() {
        return QQKouBeiYunYingConfProcessor.a().d();
    }

    public static JSONObject i() {
        return QQKouBeiYunYingConfProcessor.a().f();
    }

    public static long j() {
        return QQKouBeiYunYingConfProcessor.a().g();
    }

    public static int k(Context context) {
        int i3 = PreferenceManager.getDefaultSharedPreferences(context).getInt("KouBeiSwitchBackGround", 0);
        if (QLog.isColorLevel()) {
            QLog.d("QQKouBeiYunYingUtils", 2, "getSwitchTimes: " + i3);
        }
        return i3;
    }

    private static long l(Activity activity, String str) {
        long j3;
        try {
            PackageInfo packageInfo = com.tencent.util.pm.PackageUtil.getPackageInfo(activity, str);
            if (packageInfo == null) {
                return -1L;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                j3 = packageInfo.getLongVersionCode();
            } else {
                j3 = packageInfo.versionCode;
            }
            return j3;
        } catch (PackageManager.NameNotFoundException e16) {
            QLog.e("QQKouBeiYunYingUtils", 1, e16, new Object[0]);
            return -1L;
        }
    }

    public static boolean m(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (j3 == 0) {
            return false;
        }
        int c16 = QQKouBeiYunYingConfProcessor.a().c();
        if (c16 <= 0) {
            c16 = 14;
        }
        if ((currentTimeMillis - j3) / 86400000 < c16) {
            return false;
        }
        return true;
    }

    public static boolean n(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (j3 == 0) {
            return false;
        }
        int b16 = QQKouBeiYunYingConfProcessor.a().b();
        if (b16 <= 0) {
            b16 = 365;
        }
        if ((currentTimeMillis - j3) / 86400000 < b16) {
            return false;
        }
        return true;
    }

    public static boolean o(Context context) {
        if (PreferenceManager.getDefaultSharedPreferences(context).getLong("KouBeiOpenQQFirst", 0L) != Calendar.getInstance().get(6)) {
            return true;
        }
        return false;
    }

    public static boolean p(Context context) {
        boolean m3;
        if (context == null || !e()) {
            return false;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (n(defaultSharedPreferences.getLong("KouBeiOpenDialogFirst", 0L))) {
            d(context);
        } else if (f(context) != 0) {
            m3 = m(defaultSharedPreferences.getLong("KouBeiOpenDialogRefresh", 0L));
            if (m3 || k(context) < g() || f(context) >= h()) {
                return false;
            }
            return true;
        }
        m3 = true;
        if (m3) {
            return false;
        }
        return true;
    }

    private static boolean q(Activity activity, Uri uri, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(str);
            intent.setData(uri);
            intent.setFlags(335544320);
            intent.putExtra("big_brother_source_key", "biz_src_jc_appstore");
            activity.startActivityForResult(intent, 100);
            return true;
        } catch (Exception e16) {
            QLog.e("QQKouBeiYunYingUtils", 1, e16, new Object[0]);
            return false;
        }
    }

    public static void r(Context context) {
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("hiapplink://com.huawei.appmarket?appId=C9319&channelId=channelid&referrer=referrer&detailType=0&callType=AGDLINK"));
        intent.setPackage("com.huawei.appmarket");
        intent.setFlags(335544320);
        intent.putExtra("big_brother_source_key", "biz_src_jc_appstore");
        context.startActivity(intent);
    }

    public static boolean s(Activity activity) {
        String str = "oaps://mk/developer/comment?pkg=" + activity.getPackageName();
        if (l(activity, "com.heytap.market") >= 84000) {
            return q(activity, Uri.parse(str), "com.heytap.market");
        }
        if (l(activity, "com.oppo.market") >= 84000) {
            return q(activity, Uri.parse(str), "com.oppo.market");
        }
        return false;
    }

    public static void t(Context context) {
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("market://details?id=com.tencent.mobileqq&&th_name=need_comment"));
        intent.setPackage("com.bbk.appstore");
        intent.setFlags(335544320);
        intent.putExtra("big_brother_source_key", "biz_src_jc_appstore");
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(QQAppInterface qQAppInterface, boolean z16, boolean z17, boolean z18, DialogInterface dialogInterface, int i3) {
        x(qQAppInterface, qQAppInterface.getApplicationContext());
        if (z16) {
            B(qQAppInterface, "0X800C096");
        } else if (z17) {
            B(qQAppInterface, "0X800C09A");
        } else if (z18) {
            B(qQAppInterface, "0X800C09E");
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(boolean z16, QBaseActivity qBaseActivity, QQAppInterface qQAppInterface, boolean z17, boolean z18, DialogInterface dialogInterface, int i3) {
        if (z16) {
            r(qBaseActivity.getApplicationContext());
            B(qQAppInterface, "0X800C097");
        } else if (z17) {
            s(qBaseActivity);
            B(qQAppInterface, "0X800C09B");
        } else if (z18) {
            t(qBaseActivity.getApplicationContext());
            B(qQAppInterface, "0X800C09F");
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(boolean z16, QQAppInterface qQAppInterface, boolean z17, boolean z18, DialogInterface dialogInterface, int i3) {
        if (z16) {
            B(qQAppInterface, "0X800C095");
        } else if (z17) {
            B(qQAppInterface, "0X800C099");
        } else if (z18) {
            B(qQAppInterface, "0X800C09D");
        }
        dialogInterface.dismiss();
    }

    public static void x(QQAppInterface qQAppInterface, Context context) {
        AboutConfig.o(qQAppInterface, context, qQAppInterface.getAboutConfig().k("com.tencent.Feedback_5_8"));
        if (QLog.isColorLevel()) {
            QLog.d("QQKouBeiYunYingUtils", 2, "jumpToFeedBackH5");
        }
    }

    private static void y(int i3, TextView... textViewArr) {
        for (TextView textView : textViewArr) {
            if (textView != null) {
                textView.setTextColor(i3);
            }
        }
    }

    public static void z(QQCustomDialog qQCustomDialog) {
        if (!QQTheme.isNowThemeIsNight()) {
            return;
        }
        y(-1, qQCustomDialog.getTitleTextView(), qQCustomDialog.getMessageTextView(), qQCustomDialog.getBtnLeft(), qQCustomDialog.getBtnight(), (TextView) qQCustomDialog.findViewById(R.id.biv));
    }
}
