package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsPrivacyAccess;

/* compiled from: P */
/* loaded from: classes25.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private static String f369798a = "";

    public static long a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockSize() * statFs.getAvailableBlocks();
    }

    public static String b(Context context) {
        return "removenone";
    }

    public static String a(Context context) {
        SharedPreferences sharedPreferences;
        String string;
        if (!TextUtils.isEmpty(f369798a)) {
            return f369798a;
        }
        try {
            sharedPreferences = context.getSharedPreferences("sai", 0);
            string = sharedPreferences.getString("bmo", "");
            f369798a = string;
        } catch (Throwable th5) {
            TbsLog.i("TbsUtils", "stack is " + Log.getStackTraceString(th5));
        }
        if (!TextUtils.isEmpty(string)) {
            return f369798a;
        }
        TbsPrivacyAccess.ConfigurablePrivacy configurablePrivacy = TbsPrivacyAccess.ConfigurablePrivacy.MODEL;
        f369798a = TbsPrivacyAccess.getConfigurePrivacy(context, configurablePrivacy, "");
        TbsLog.i("TbsUtils", "getBuildModel from sp is " + f369798a);
        if (!TextUtils.isEmpty(f369798a)) {
            return f369798a;
        }
        if (TextUtils.isEmpty(f369798a) && !"com.tencent.mobileqq".equals(context.getPackageName())) {
            f369798a = DeviceInfoMonitor.getModel();
        }
        TbsLog.i("TbsUtils", "getBuildModel is " + f369798a);
        if (!TextUtils.isEmpty(f369798a)) {
            TbsPrivacyAccess.configurePrivacy(context, configurablePrivacy, f369798a);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("bmo", f369798a);
            edit.commit();
        }
        return f369798a;
    }

    public static void a(Context context, Bundle bundle) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("sai", 0).edit();
            if (bundle.containsKey(QbSdk.KEY_THIRD_PARTY_TURING)) {
                boolean z16 = bundle.getBoolean(QbSdk.KEY_THIRD_PARTY_TURING);
                edit.putBoolean("itge", z16);
                TbsLog.e("TbsUtils", "setEnableForThirdParty key is itge value is " + z16);
            }
            edit.commit();
        } catch (Throwable unused) {
        }
    }
}
