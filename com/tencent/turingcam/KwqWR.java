package com.tencent.turingcam;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import cooperation.qzone.patch.QZonePatchService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class KwqWR {
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(4:3|4|5|(1:7)(3:8|1b|(13:20|21|22|23|(3:52|(2:54|(2:57|58)(1:56))|60)|26|27|aa|33|34|35|36|37)))|67|21|22|23|(1:25)(5:47|49|52|(0)|60)|26|27|aa) */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x006d A[Catch: all -> 0x007a, TRY_LEAVE, TryCatch #4 {all -> 0x007a, blocks: (B:23:0x0042, B:47:0x0058, B:49:0x0061, B:52:0x0065, B:54:0x006d), top: B:22:0x0042 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context) {
        boolean z16;
        boolean z17;
        Object obj;
        String str;
        String[] split;
        Context context2;
        PackageInfo packageInfo;
        System.currentTimeMillis();
        boolean z18 = true;
        if (context.getPackageManager() != null) {
            String a16 = LwgsO.a(LwgsO.f381914l);
            if (!TextUtils.isEmpty(a16)) {
                synchronized (eh5ma.class) {
                    context2 = eh5ma.f382207a;
                }
                if (context2 != null && (packageInfo = InstalledAppListMonitor.getPackageInfo(context2.getPackageManager(), a16, 0)) != null && a16.equals(packageInfo.packageName)) {
                    z16 = true;
                    int a17 = CEO0r.a(0, z16, 0);
                    System.currentTimeMillis();
                    str = new String(F2BEC.a(LwgsO.a(LwgsO.f381920n)));
                    if (!TextUtils.isEmpty(str) && (split = str.split(RedTouch.NEWLINE_CHAR)) != null && split.length != 0) {
                        String packageName = context.getPackageName();
                        for (String str2 : split) {
                            if (a(packageName, str2)) {
                                z17 = true;
                                break;
                            }
                        }
                    }
                    z17 = false;
                    int a18 = CEO0r.a(a17, z17, 1);
                    System.currentTimeMillis();
                    obj = new Object();
                    AtomicReference atomicReference = new AtomicReference();
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    atomicReference.set(Boolean.FALSE);
                    Handler handler = new Handler(context.getMainLooper());
                    System.currentTimeMillis();
                    handler.post(new ku5hj(atomicBoolean, atomicReference, obj));
                    synchronized (obj) {
                        try {
                            obj.wait(100L);
                        } catch (InterruptedException unused) {
                        }
                    }
                    atomicBoolean.set(true);
                    int a19 = CEO0r.a(a18, ((Boolean) atomicReference.get()).booleanValue(), 2);
                    System.currentTimeMillis();
                    try {
                        ClassLoader.getSystemClassLoader().loadClass(LwgsO.a(LwgsO.F0));
                    } catch (Throwable unused2) {
                        z18 = false;
                    }
                    return CEO0r.a(a19, z18, 3);
                }
            }
        }
        z16 = false;
        int a172 = CEO0r.a(0, z16, 0);
        System.currentTimeMillis();
        str = new String(F2BEC.a(LwgsO.a(LwgsO.f381920n)));
        if (!TextUtils.isEmpty(str)) {
            String packageName2 = context.getPackageName();
            while (r6 < r5) {
            }
        }
        z17 = false;
        int a182 = CEO0r.a(a172, z17, 1);
        System.currentTimeMillis();
        obj = new Object();
        AtomicReference atomicReference2 = new AtomicReference();
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        atomicReference2.set(Boolean.FALSE);
        Handler handler2 = new Handler(context.getMainLooper());
        System.currentTimeMillis();
        handler2.post(new ku5hj(atomicBoolean2, atomicReference2, obj));
        synchronized (obj) {
        }
    }

    public static boolean a(String str, String str2) {
        int indexOf;
        if (str2 == null || (indexOf = str2.indexOf(47)) == -1) {
            return false;
        }
        String trim = str2.substring(indexOf).trim();
        if (!trim.startsWith("/data/")) {
            return false;
        }
        if (trim.startsWith("/data/data/" + str + "/")) {
            return false;
        }
        boolean endsWith = trim.endsWith(".so");
        return (endsWith || (!endsWith && trim.endsWith(QZonePatchService.PATCH_SUFFIX))) && str2.contains(LwgsO.a(LwgsO.f381917m));
    }
}
