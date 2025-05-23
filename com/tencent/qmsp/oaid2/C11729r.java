package com.tencent.qmsp.oaid2;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.common.PackageConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmsp.oaid2.u;

/* compiled from: P */
/* renamed from: com.tencent.qmsp.oaid2.r, reason: case insensitive filesystem */
/* loaded from: classes22.dex */
public class C11729r {

    /* compiled from: P */
    /* renamed from: com.tencent.qmsp.oaid2.r$a */
    /* loaded from: classes22.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final String f344274a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f344275b;

        a(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16));
            } else {
                this.f344274a = str;
                this.f344275b = z16;
            }
        }

        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f344274a;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.f344275b;
        }
    }

    private static boolean a(Context context, String str) {
        return b(context, str) != null;
    }

    private static String b(Context context) {
        if (a(context, "com.huawei.hwid")) {
            return "com.huawei.hwid";
        }
        String str = PackageConstants.SERVICES_PACKAGE_ALL_SCENE;
        if (!a(context, PackageConstants.SERVICES_PACKAGE_ALL_SCENE)) {
            str = "com.huawei.hwid.tv";
            if (!a(context, "com.huawei.hwid.tv")) {
                return "com.huawei.hwid";
            }
        }
        return str;
    }

    public static a a(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            t0.a("Cannot be called from the main thread");
            return null;
        }
        try {
            String b16 = b(context);
            if (InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), b16, 128) == null) {
                return null;
            }
            s sVar = new s();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(b16);
            if (context.bindService(intent, sVar, 1)) {
                t0.b("bind ok");
                try {
                    try {
                        if (sVar.f344284a) {
                            try {
                                context.unbindService(sVar);
                            } catch (Throwable unused) {
                            }
                            return null;
                        }
                        sVar.f344284a = true;
                        u a16 = u.a.a(sVar.f344285b.take());
                        a aVar = new a(a16.m(), a16.h());
                        try {
                            context.unbindService(sVar);
                        } catch (Throwable unused2) {
                        }
                        return aVar;
                    } catch (RemoteException unused3) {
                        t0.a("bind hms service RemoteException");
                        try {
                            return null;
                        } catch (Throwable unused4) {
                            return null;
                        }
                    } catch (Throwable unused5) {
                        t0.a("bind hms service InterruptedException");
                        return null;
                    }
                } finally {
                    try {
                        context.unbindService(sVar);
                    } catch (Throwable unused6) {
                    }
                }
            }
            t0.a("bind failed");
            return null;
        } catch (Throwable unused7) {
            t0.a("pkg not found");
            return null;
        }
    }

    private static PackageInfo b(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return null;
                }
                return InstalledAppListMonitor.getPackageInfo(packageManager, str, 128);
            } catch (PackageManager.NameNotFoundException unused) {
                t0.a("getPackageInfo NameNotFoundException");
            } catch (Throwable unused2) {
                t0.a("getPackageInfo Exception");
                return null;
            }
        }
        return null;
    }
}
