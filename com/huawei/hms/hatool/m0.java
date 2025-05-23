package com.huawei.hms.hatool;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class m0 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f37177a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f37178b = 4;

    private static String a() {
        return "FormalHASDK_2.2.0.313" + p.a();
    }

    public void b(int i3, String str, String str2) {
        a(i3, "FormalHASDK", str + "=> " + str2);
    }

    public void a(int i3) {
        Log.i("FormalHASDK", System.lineSeparator() + "======================================= " + System.lineSeparator() + a() + "" + System.lineSeparator() + "=======================================");
        this.f37178b = i3;
        this.f37177a = true;
    }

    public boolean b(int i3) {
        return this.f37177a && i3 >= this.f37178b;
    }

    public void a(int i3, String str, String str2) {
        if (i3 == 3) {
            Log.d(str, str2);
            return;
        }
        if (i3 == 5) {
            Log.w(str, str2);
        } else if (i3 != 6) {
            Log.i(str, str2);
        } else {
            Log.e(str, str2);
        }
    }
}
