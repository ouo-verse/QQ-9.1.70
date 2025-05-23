package com.tencent.mobileqq.doc;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends a {
    static IPatchRedirector $redirector_;

    public static long f(Context context, String str) {
        return a.b(context, "TencentDocGrayTips_LastShowTime_" + str, 0L);
    }

    public static int g(Context context, String str) {
        return a.a(context, "TencentDocGrayTips_ShowTimes_" + str, 0);
    }

    public static void h(Context context, String str, long j3) {
        a.e(context, "TencentDocGrayTips_LastShowTime_" + str, j3);
    }

    public static void i(Context context, String str, int i3) {
        a.d(context, "TencentDocGrayTips_ShowTimes_" + str, i3);
    }
}
