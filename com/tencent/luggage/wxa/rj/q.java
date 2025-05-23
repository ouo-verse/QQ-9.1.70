package com.tencent.luggage.wxa.rj;

import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.tk.h f139815a = new com.tencent.luggage.wxa.tk.h();

    public static void a(String str, ActivityCompat.OnRequestPermissionsResultCallback onRequestPermissionsResultCallback) {
        if (!TextUtils.isEmpty(str) && onRequestPermissionsResultCallback != null) {
            f139815a.b(str, onRequestPermissionsResultCallback);
        } else {
            com.tencent.luggage.wxa.tn.w.b("Luggage.RequestPermissionRegistry", "addCallback fail, invalid arguments");
        }
    }

    public static void b(String str, ActivityCompat.OnRequestPermissionsResultCallback onRequestPermissionsResultCallback) {
        if (!TextUtils.isEmpty(str) && onRequestPermissionsResultCallback != null) {
            f139815a.c(str, onRequestPermissionsResultCallback);
        } else {
            com.tencent.luggage.wxa.tn.w.b("Luggage.RequestPermissionRegistry", "removeCallback fail, invalid arguments");
        }
    }

    public static void c(String str, ActivityCompat.OnRequestPermissionsResultCallback onRequestPermissionsResultCallback) {
        a(str, onRequestPermissionsResultCallback);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.RequestPermissionRegistry", "removeCallbacks fail, invalid arguments");
        } else {
            f139815a.b(str);
        }
    }

    public static void a(String str, int i3, String[] strArr, int[] iArr, boolean z16) {
        if (str != null && str.length() != 0) {
            Set a16 = f139815a.a(str);
            if (a16 != null) {
                Iterator it = a16.iterator();
                while (it.hasNext()) {
                    ((ActivityCompat.OnRequestPermissionsResultCallback) it.next()).onRequestPermissionsResult(i3, strArr, iArr);
                }
                if (z16) {
                    a16.clear();
                    return;
                }
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.tn.w.b("Luggage.RequestPermissionRegistry", "removeCallback fail, invalid id");
    }
}
