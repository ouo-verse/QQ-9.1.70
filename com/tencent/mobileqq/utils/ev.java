package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.qmmkv.QMMKV;
import java.util.Random;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ev {

    /* renamed from: a, reason: collision with root package name */
    private static Random f307757a = new Random();

    public static StringBuilder a() {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < 8; i3++) {
            sb5.append(f307757a.nextInt(9) + 1);
        }
        return sb5;
    }

    public static String b(String str) {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString("uid_prefix_key_" + str, "");
    }
}
