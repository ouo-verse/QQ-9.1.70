package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes23.dex */
public enum TbsPrivacyAccess {
    DeviceId(false),
    Imsi(false),
    AndroidId(false),
    MacAddress(false),
    AndroidVersion(true),
    DeviceModel(true),
    AppList(true);


    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    private static boolean f369149a = true;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f369150c = false;

    /* renamed from: d, reason: collision with root package name */
    private static String[] f369151d = null;

    /* renamed from: b, reason: collision with root package name */
    private boolean f369153b;

    /* loaded from: classes23.dex */
    public enum ConfigurablePrivacy {
        IMSI(MobileInfoUtil.IMSI),
        ANDROID_ID(SharedPreferencedUtil.SP_KEY_ANDROID_ID),
        MAC("mac"),
        ANDROID_VERSION("android_version"),
        DEVICE_MODEL("device_model"),
        APP_LIST("app_list"),
        QIMEI36("q36"),
        MODEL("model"),
        OAID("oaid"),
        SERIAL(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL),
        ACTION("action"),
        QB_INSTALLED("qb_installed");


        /* renamed from: a, reason: collision with root package name */
        String f369155a;

        ConfigurablePrivacy(String str) {
            this.f369155a = str;
        }
    }

    TbsPrivacyAccess(boolean z16) {
        this.f369153b = z16;
    }

    private static void a(Context context, SharedPreferences.Editor editor, ConfigurablePrivacy configurablePrivacy, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TbsLog.i("TbsPrivacy", "doConfigPrivacy  " + configurablePrivacy.f369155a + " is " + str);
        if (!TextUtils.isEmpty(configurablePrivacy.f369155a) && configurablePrivacy.f369155a.equals("action")) {
            a(context, str);
            return;
        }
        editor.putString(configurablePrivacy.f369155a, str);
        TbsLog.i("TbsPrivacy", "configurePrivacy " + configurablePrivacy.f369155a + " is " + str);
    }

    public static void configureAllPrivacy(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            if (bundle.containsKey("qimei36")) {
                bundle.putString(ConfigurablePrivacy.QIMEI36.f369155a, bundle.getString("qimei36"));
            }
            Iterator<String> it = bundle.keySet().iterator();
            while (it.hasNext()) {
                TbsLog.i("TbsPrivacy", "configureAllPrivacy bundle key is " + it.next());
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("uifa", 0).edit();
            for (ConfigurablePrivacy configurablePrivacy : ConfigurablePrivacy.values()) {
                if (bundle.containsKey(configurablePrivacy.f369155a)) {
                    a(context, edit, configurablePrivacy, bundle.getString(configurablePrivacy.f369155a));
                }
            }
            edit.putString("app_call", "done");
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    public static void configurePrivacy(Context context, ConfigurablePrivacy configurablePrivacy, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("uifa", 0).edit();
        a(context, edit, configurablePrivacy, str);
        edit.commit();
    }

    @Deprecated
    public static void disableSensitiveApi() {
        f369149a = false;
        HashMap hashMap = new HashMap();
        hashMap.put(TbsCoreSettings.NO_SENSITIVE_API, Boolean.TRUE);
        QbSdk.initTbsSettings(hashMap);
    }

    public static String getConfigurePrivacy(Context context, ConfigurablePrivacy configurablePrivacy, String str) {
        return context.getSharedPreferences("uifa", 0).getString(configurablePrivacy.f369155a, str);
    }

    public static String[] getItemToRmPrivacy() {
        return f369151d;
    }

    @Deprecated
    public static boolean isEnableSensitiveApi() {
        return f369149a;
    }

    public static void rmPrivacyItemIfNeeded(Context context) {
        try {
            TbsLog.i("TbsPrivacy", "mRmPrivacyItemChecked is " + f369150c);
            if (f369150c) {
                return;
            }
            f369150c = true;
            String b16 = com.tencent.smtt.utils.r.b(context);
            TbsLog.i("TbsPrivacy", "rmPrivacyItemIfNeeded state is " + b16);
            if (b16.equals("removenone")) {
                f369151d = null;
                return;
            }
            f369151d = b16.split("\\|");
            TbsLog.i("TbsPrivacy", "rmPrivacyItemIfNeeded mItemToRmPrivacy is " + f369151d);
            SharedPreferences sharedPreferences = context.getSharedPreferences("uifa", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (String str : f369151d) {
                if (sharedPreferences.contains(str)) {
                    edit.remove(str);
                }
            }
            edit.commit();
        } catch (Throwable th5) {
            TbsLog.i("TbsPrivacy", "stack is " + Log.getStackTraceString(th5));
        }
    }

    public boolean isDisabled() {
        return !this.f369153b;
    }

    public boolean isEnabled() {
        return this.f369153b;
    }

    public void setEnabled(boolean z16) {
        this.f369153b = z16;
        TbsLog.i("TbsPrivacy", name() + " is " + z16);
    }

    private static void a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && FileUtil.a(context) && str.equals("deleteQBApk")) {
                String a16 = FileUtil.a(context, 9);
                if (TextUtils.isEmpty(a16)) {
                    return;
                }
                File file = new File(a16);
                TbsLog.i("TbsPrivacy", "doActionByApp QbApkDir is " + file.getAbsolutePath());
                FileUtil.b(file);
            }
        } catch (Throwable th5) {
            TbsLog.i("TbsPrivacy", "doActionByApp stack is " + Log.getStackTraceString(th5));
        }
    }

    public static void configureAllPrivacy(Context context, String str) {
        if (str == null) {
            return;
        }
        try {
            String b16 = com.tencent.smtt.utils.r.b(context);
            TbsLog.i("TbsPrivacy", "configureAllPrivacy state is " + b16);
            if (b16.contains("app_list")) {
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("uifa", 0).edit();
            edit.putString("app_list", str);
            edit.putString("app_call", "done");
            edit.commit();
        } catch (Throwable unused) {
        }
    }
}
