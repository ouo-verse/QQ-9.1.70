package com.tencent.luggage.wxa.tn;

import android.content.Context;
import android.os.Process;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static String f141659a;

    public static String a(Context context, int i3) {
        w.d("ProcessCache", "getProcessNameByPidFromCache");
        if (i3 != Process.myPid()) {
            return w0.c(context, i3);
        }
        String str = f141659a;
        if (str == null || str.isEmpty()) {
            f141659a = w0.c(context, i3);
        }
        return f141659a;
    }
}
