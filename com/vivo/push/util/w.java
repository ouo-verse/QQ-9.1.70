package com.vivo.push.util;

import android.os.UserHandle;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private static int f387933a = -1;

    public static int a() {
        int i3 = f387933a;
        if (i3 != -1) {
            return i3;
        }
        try {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
            declaredMethod.setAccessible(true);
            f387933a = ((Integer) declaredMethod.invoke(null, null)).intValue();
            u.d("MultiUserManager", "getMyUserId = " + f387933a);
            return f387933a;
        } catch (Exception e16) {
            u.a("MultiUserManager", "getMyUserId error " + e16.getMessage());
            return 0;
        }
    }
}
