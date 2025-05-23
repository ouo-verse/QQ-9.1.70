package com.tencent.qimei.ad;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    public static void a(String str, String str2, Object... objArr) {
        if (a.a()) {
            Log.e("qm_tag", a.a("Qm-Core-Error: " + str + " " + str2, objArr));
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (a.a()) {
            Log.i("qm_tag", a.a("Qm-Core-Info: " + str + " " + str2, objArr));
        }
    }

    public static void a(Throwable th5) {
        if (a.a()) {
            th5.printStackTrace();
        } else {
            th5.getMessage();
        }
    }
}
