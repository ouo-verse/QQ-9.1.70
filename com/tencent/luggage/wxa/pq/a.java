package com.tencent.luggage.wxa.pq;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.luggage.wxa.k.f;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f137736a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f137737b;

    public static boolean a(Context context) {
        if (f137737b != null) {
            f.c("WMPF.XwebCameraUtil", "isUseCpuCrop:" + f137736a);
            return f137737b.booleanValue();
        }
        Context applicationContext = context.getApplicationContext();
        try {
            f137737b = Boolean.valueOf(applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).metaData.getBoolean("use_cpu_crop"));
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
        }
        f.c("WMPF.XwebCameraUtil", "isUseCpuCrop:" + f137737b);
        return f137737b.booleanValue();
    }

    public static boolean b(Context context) {
        if (f137736a != null) {
            f.c("WMPF.XwebCameraUtil", "isUseXwebCamera:" + f137736a);
            return f137736a.booleanValue();
        }
        Context applicationContext = context.getApplicationContext();
        try {
            f137736a = Boolean.valueOf(applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).metaData.getBoolean("use_xweb_camera"));
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
        }
        f.c("WMPF.XwebCameraUtil", "isUseXwebCamera:" + f137736a);
        return f137736a.booleanValue();
    }
}
