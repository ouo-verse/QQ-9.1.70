package com.tencent.turingfd.sdk.xq;

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
public class s {
    public static boolean a(Context context) {
        Context context2;
        PackageInfo packageInfo;
        if (context.getPackageManager() == null) {
            return false;
        }
        String a16 = Ccontinue.a(Ccontinue.f383282l);
        try {
            if (TextUtils.isEmpty(a16)) {
                return false;
            }
            synchronized (Celse.class) {
                context2 = Celse.f383328a;
            }
            if (context2 != null && (packageInfo = InstalledAppListMonitor.getPackageInfo(context2.getPackageManager(), a16, 0)) != null && a16.equals(packageInfo.packageName)) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int b(Context context) {
        boolean z16;
        String[] split;
        System.currentTimeMillis();
        boolean z17 = false;
        int a16 = Cbreak.a(0, a(context), 0);
        System.currentTimeMillis();
        try {
            String str = new String(Csynchronized.a(Ccontinue.a(Ccontinue.f383288n)));
            if (!TextUtils.isEmpty(str) && (split = str.split(RedTouch.NEWLINE_CHAR)) != null && split.length != 0) {
                String packageName = context.getPackageName();
                for (String str2 : split) {
                    if (a(packageName, str2)) {
                        z16 = true;
                        break;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        z16 = false;
        int a17 = Cbreak.a(a16, z16, 1);
        System.currentTimeMillis();
        Object obj = new Object();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        atomicReference.set(Boolean.FALSE);
        Handler handler = new Handler(context.getMainLooper());
        System.currentTimeMillis();
        handler.post(new r(atomicBoolean, atomicReference, obj));
        synchronized (obj) {
            try {
                obj.wait(100L);
            } catch (InterruptedException unused2) {
            }
        }
        atomicBoolean.set(true);
        int a18 = Cbreak.a(a17, ((Boolean) atomicReference.get()).booleanValue(), 2);
        System.currentTimeMillis();
        try {
            ClassLoader.getSystemClassLoader().loadClass(Ccontinue.a(Ccontinue.F0));
            z17 = true;
        } catch (Throwable unused3) {
        }
        return Cbreak.a(a18, z17, 3);
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
        return (endsWith || (!endsWith && trim.endsWith(QZonePatchService.PATCH_SUFFIX))) && str2.contains(Ccontinue.a(Ccontinue.f383285m));
    }
}
