package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.support.log.HMSLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class i extends PushPreferences {
    public static final String TAG = "i";

    /* renamed from: b, reason: collision with root package name */
    public Context f37350b;

    public i(Context context) {
        super(context, "push_client_self_info");
        this.f37350b = context;
    }

    public static i a(Context context) {
        return new i(context);
    }

    public String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return a("token_info_v2");
            }
            return a(str);
        } catch (Exception e16) {
            HMSLog.e(TAG, "getSecureData" + e16.getMessage());
            return "";
        }
    }

    public boolean c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return removeKey("token_info_v2");
            }
            return removeKey(str);
        } catch (Exception e16) {
            HMSLog.e(TAG, "removeToken" + e16.getMessage());
            return false;
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return PushEncrypter.decrypter(this.f37350b, getString(str));
        } catch (Exception e16) {
            HMSLog.e(TAG, "getSecureData" + e16.getMessage());
            return "";
        }
    }

    public boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return saveString(str, PushEncrypter.encrypter(this.f37350b, str2));
        } catch (Exception e16) {
            HMSLog.e(TAG, "saveSecureData" + e16.getMessage());
            return false;
        }
    }

    public boolean b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return a("token_info_v2", str2);
            }
            return a(str, str2);
        } catch (Exception e16) {
            HMSLog.e(TAG, "saveSecureData" + e16.getMessage());
            return false;
        }
    }

    public void a() {
        Map<String, ?> all = getAll();
        if (all.isEmpty() || all.keySet().isEmpty()) {
            return;
        }
        for (String str : all.keySet()) {
            if (!"push_kit_auto_init_enabled".equals(str) && !"_proxy_init".equals(str)) {
                removeKey(str);
            }
        }
    }
}
