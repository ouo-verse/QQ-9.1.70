package com.tencent.luggage.wxa.nn;

import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f135889a = false;

    public static void a(String str, String str2) {
        String[] strArr = {"================ reportRawMessage BEGIN ================", "raw:" + str, "type:" + str2, "================ reportRawMessage  END  ================"};
        for (int i3 = 0; i3 < 4; i3++) {
            w.d("Luggage.CrashReportFactory", strArr[i3]);
        }
    }
}
