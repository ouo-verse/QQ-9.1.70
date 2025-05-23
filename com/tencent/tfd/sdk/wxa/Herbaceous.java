package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import cooperation.qzone.patch.QZonePatchService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Herbaceous {
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(16:3|4|5|6|7|8|9|(3:38|(2:40|(2:43|44)(1:42))|46)|12|13|89|19|20|21|22|23)|50|7|8|9|(1:11)(5:33|35|38|(0)|46)|12|13|89) */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004c A[Catch: all -> 0x0059, TRY_LEAVE, TryCatch #3 {all -> 0x0059, blocks: (B:9:0x0021, B:33:0x0037, B:35:0x0040, B:38:0x0044, B:40:0x004c), top: B:8:0x0021 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(Context context) {
        boolean z16;
        boolean z17;
        Object obj;
        String str;
        String[] split;
        System.currentTimeMillis();
        PackageManager packageManager = context.getPackageManager();
        boolean z18 = true;
        if (packageManager != null) {
            try {
                InstalledAppListMonitor.getPackageInfo(packageManager, Cswitch.a(Cswitch.f375805l), 128);
                z16 = true;
            } catch (Throwable unused) {
            }
            int a16 = Ccatch.a(0, z16, 0);
            System.currentTimeMillis();
            str = new String(Cextends.a(Cswitch.a(Cswitch.f375809n)));
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
            int a17 = Ccatch.a(a16, z17, 1);
            System.currentTimeMillis();
            obj = new Object();
            AtomicReference atomicReference = new AtomicReference();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            atomicReference.set(Boolean.FALSE);
            Handler handler = new Handler(context.getMainLooper());
            System.currentTimeMillis();
            handler.post(new Haw(atomicBoolean, atomicReference, obj));
            synchronized (obj) {
                try {
                    obj.wait(100L);
                } catch (InterruptedException unused2) {
                }
            }
            atomicBoolean.set(true);
            int a18 = Ccatch.a(a17, ((Boolean) atomicReference.get()).booleanValue(), 2);
            System.currentTimeMillis();
            try {
                ClassLoader.getSystemClassLoader().loadClass(Cswitch.a(Cswitch.E0));
            } catch (Throwable unused3) {
                z18 = false;
            }
            return Ccatch.a(a18, z18, 3);
        }
        z16 = false;
        int a162 = Ccatch.a(0, z16, 0);
        System.currentTimeMillis();
        str = new String(Cextends.a(Cswitch.a(Cswitch.f375809n)));
        if (!TextUtils.isEmpty(str)) {
            String packageName2 = context.getPackageName();
            while (r6 < r5) {
            }
        }
        z17 = false;
        int a172 = Ccatch.a(a162, z17, 1);
        System.currentTimeMillis();
        obj = new Object();
        AtomicReference atomicReference2 = new AtomicReference();
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        atomicReference2.set(Boolean.FALSE);
        Handler handler2 = new Handler(context.getMainLooper());
        System.currentTimeMillis();
        handler2.post(new Haw(atomicBoolean2, atomicReference2, obj));
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
        return (endsWith || (!endsWith && trim.endsWith(QZonePatchService.PATCH_SUFFIX))) && str2.contains(Cswitch.a(Cswitch.f375807m));
    }
}
