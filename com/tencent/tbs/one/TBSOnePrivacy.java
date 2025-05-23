package com.tencent.tbs.one;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.open.business.base.MobileInfoUtil;

/* loaded from: classes26.dex */
public enum TBSOnePrivacy {
    Imei(false, "imei"),
    Imsi(false, MobileInfoUtil.IMSI),
    AndroidId(false, SharedPreferencedUtil.SP_KEY_ANDROID_ID),
    DeviceModel(true, "device_model"),
    SN(true, ReportConstant.COSTREPORT_SN),
    Qimei36(true, "qimei36");

    public static final String PREFERENCES_FILENAME = "com.tencent.tbs.one.privacy";

    /* renamed from: a, reason: collision with root package name */
    private final boolean f374516a;

    /* renamed from: b, reason: collision with root package name */
    private String f374517b;

    TBSOnePrivacy(boolean z16, String str) {
        this.f374516a = z16;
        this.f374517b = str;
    }

    private static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(PREFERENCES_FILENAME, 4);
    }

    public final String get(Context context) {
        return get(context, "");
    }

    public final boolean isDisabled() {
        if (!this.f374516a) {
            return true;
        }
        return false;
    }

    public final boolean isEnabled() {
        return this.f374516a;
    }

    public final synchronized void set(Context context, String str) {
        try {
            SharedPreferences a16 = a(context);
            if (a16 == null) {
                return;
            }
            SharedPreferences.Editor edit = a16.edit();
            edit.putString(this.f374517b, str);
            edit.apply();
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    public final String get(Context context, String str) {
        SharedPreferences a16;
        try {
            return (isDisabled() || (a16 = a(context)) == null) ? str : a16.getString(this.f374517b, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
