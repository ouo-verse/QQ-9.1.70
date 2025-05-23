package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cj {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f307532a;

    public static String a() {
        BaseApplication context = BaseApplication.getContext();
        MMKVOptionEntity from = QMMKV.from(context, "common_mmkv_configurations");
        String decodeString = from.decodeString(PrivacyPolicyHelper.PRIVACYPOLICY_KEY, "");
        if (TextUtils.isEmpty(decodeString)) {
            String d16 = com.tencent.mobileqq.util.cl.d(context, PrivacyPolicyHelper.PRIVACYPOLICY_KEY);
            if (TextUtils.isEmpty(d16)) {
                d16 = "0";
            } else {
                from.encodeString(PrivacyPolicyHelper.PRIVACYPOLICY_KEY, d16);
                QLog.d(com.tencent.mobileqq.app.PrivacyPolicyHelper.TAG, 1, "migration privacy state: " + d16);
            }
            return d16;
        }
        return decodeString;
    }

    public static boolean b() {
        if (!f307532a && a().equals("1")) {
            f307532a = true;
        }
        return f307532a;
    }
}
