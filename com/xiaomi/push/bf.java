package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bf {

    /* renamed from: a, reason: collision with root package name */
    private static final List<String> f388261a = Arrays.asList(QQHealthReportApiImpl.MSG_EXPOSE_KEY, QQHealthReportApiImpl.MSG_CLICK_KEY, "003", "004", "005");

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f388262b = null;

    static void a(String str) {
        b("Push-ConnectionQualityStatsHelper", str);
    }

    public static boolean c(Context context) {
        if (f388262b == null) {
            try {
                if (!hz.j(context)) {
                    f388262b = Boolean.FALSE;
                }
                String d16 = com.xiaomi.push.service.av.d(context);
                if (!TextUtils.isEmpty(d16) && d16.length() >= 3) {
                    f388262b = Boolean.valueOf(f388261a.contains(d16.substring(d16.length() - 3)));
                } else {
                    f388262b = Boolean.FALSE;
                }
                a("Sampling statistical connection quality: " + f388262b);
            } catch (Throwable th5) {
                f388262b = Boolean.FALSE;
                jz4.c.A("Push-ConnectionQualityStatsHelper", "Determine sampling switch error: " + th5);
            }
        }
        return f388262b.booleanValue();
    }

    public static void b(String str, String str2) {
    }
}
