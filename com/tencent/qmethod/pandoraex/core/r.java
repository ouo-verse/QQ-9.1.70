package com.tencent.qmethod.pandoraex.core;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes22.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f344153a = new Object();

    public static boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            if (context.checkSelfPermission(str) != 0) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            o.d("PermissionUtil", "CheckSelfPermission is excepiton", th5);
            return false;
        }
    }

    public static boolean b(Context context, String[] strArr) {
        boolean z16 = true;
        for (String str : strArr) {
            z16 &= a(context, str);
        }
        return z16;
    }
}
