package com.tencent.qmethod.pandoraex.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;

/* compiled from: P */
/* loaded from: classes22.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f344154a = false;

    static String a() {
        String j3 = com.tencent.qmethod.pandoraex.api.r.j(com.tencent.qmethod.pandoraex.api.q.b(), PrivacyPolicyHelper.PRIVACYPOLICY_KEY);
        if (TextUtils.isEmpty(j3) || "data is null".equals(j3)) {
            return "0";
        }
        return j3;
    }

    public static boolean b() {
        if (!f344154a && "1".equals(a())) {
            f344154a = true;
        }
        return f344154a;
    }

    public static void c(boolean z16) {
        String str;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        com.tencent.qmethod.pandoraex.api.r.p(com.tencent.qmethod.pandoraex.api.q.b(), PrivacyPolicyHelper.PRIVACYPOLICY_KEY, str);
        f344154a = z16;
        o.a(com.tencent.mobileqq.app.PrivacyPolicyHelper.TAG, "setPrivacyPolicyStatus, state=" + str);
    }
}
