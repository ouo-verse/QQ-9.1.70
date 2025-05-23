package com.facebook.soloader;

import android.annotation.TargetApi;
import android.os.Trace;
import javax.annotation.Nullable;

/* compiled from: P */
@DoNotOptimize
@TargetApi(18)
/* loaded from: classes2.dex */
class a {
    public static void a(String str, @Nullable String str2, String str3) {
        String str4 = str + str2 + str3;
        if (str4.length() > 127 && str2 != null) {
            str4 = str + str2.substring(0, (127 - str.length()) - str3.length()) + str3;
        }
        Trace.beginSection(str4);
    }

    public static void b() {
        Trace.endSection();
    }
}
