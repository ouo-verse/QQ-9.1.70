package com.qq.e.comm.plugin.k;

import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class f {
    public static void a(Runnable runnable, String str, String str2) {
        try {
            runnable.run();
        } catch (Throwable th5) {
            StringBuilder sb5 = new StringBuilder();
            if (TextUtils.isEmpty(str)) {
                str = "AdSafeUtil";
            }
            sb5.append(str);
            sb5.append(",safeRun");
            sb5.append(str2);
            GDTLogger.e(sb5.toString(), th5);
        }
    }
}
