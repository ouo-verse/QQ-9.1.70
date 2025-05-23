package com.tencent.qimei.u;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.File;
import java.net.NetworkInterface;
import java.util.Enumeration;

/* compiled from: P */
@SuppressLint({"MissingPermission"})
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: p, reason: collision with root package name */
    public static final c f343390p;

    /* renamed from: a, reason: collision with root package name */
    public final Context f343391a;

    /* renamed from: b, reason: collision with root package name */
    public long f343392b;

    /* renamed from: c, reason: collision with root package name */
    public long f343393c;

    /* renamed from: d, reason: collision with root package name */
    public String f343394d;

    /* renamed from: e, reason: collision with root package name */
    public String f343395e;

    /* renamed from: f, reason: collision with root package name */
    public String f343396f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f343397g;

    /* renamed from: h, reason: collision with root package name */
    public String f343398h;

    /* renamed from: i, reason: collision with root package name */
    public String f343399i;

    /* renamed from: j, reason: collision with root package name */
    public String f343400j;

    /* renamed from: k, reason: collision with root package name */
    public String f343401k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f343402l;

    /* renamed from: m, reason: collision with root package name */
    public String f343403m;

    /* renamed from: n, reason: collision with root package name */
    public String f343404n;

    /* renamed from: o, reason: collision with root package name */
    public Enumeration<NetworkInterface> f343405o;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14977);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f343390p = new c();
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f343393c = 0L;
        this.f343402l = new Object();
        this.f343405o = null;
        this.f343391a = com.tencent.qimei.ap.d.c().e();
    }

    public final boolean a() {
        boolean z16;
        TelephonyManager telephonyManager;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        try {
            Intent registerReceiver = this.f343391a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver.getIntExtra("status", -1) == 5) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (registerReceiver.getIntExtra("plugged", -1) == 1) {
                z19 = true;
            } else {
                z19 = false;
            }
        } catch (Throwable th5) {
            com.tencent.qimei.ad.c.a(th5);
        }
        if (z18 && z19) {
            z16 = true;
            telephonyManager = (TelephonyManager) this.f343391a.getSystemService("phone");
            if (telephonyManager == null && telephonyManager.getPhoneType() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z16 && !z17) {
                return false;
            }
        }
        z16 = false;
        telephonyManager = (TelephonyManager) this.f343391a.getSystemService("phone");
        if (telephonyManager == null) {
        }
        z17 = true;
        return z16 ? true : true;
    }

    @SuppressLint({"HardwareIds"})
    public synchronized String b() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        String str2 = this.f343394d;
        if (str2 != null) {
            return str2;
        }
        String str3 = "";
        Context context = this.f343391a;
        if (context == null) {
            return "";
        }
        try {
            str3 = DeviceInfoMonitor.getString(context.getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
        } catch (Exception e16) {
            com.tencent.qimei.ad.c.a(e16);
        }
        if (str3 != null) {
            str = str3.toLowerCase();
        } else {
            str = "";
        }
        this.f343394d = str;
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0093 A[Catch: all -> 0x00c5, TryCatch #0 {all -> 0x00c5, blocks: (B:9:0x0019, B:12:0x0057, B:16:0x008d, B:18:0x0093, B:19:0x00a9, B:21:0x00af, B:25:0x0065, B:28:0x0072, B:30:0x0082, B:33:0x0029, B:35:0x0031, B:37:0x0040, B:42:0x0047, B:47:0x004f, B:41:0x0054), top: B:8:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00af A[Catch: all -> 0x00c5, TRY_LEAVE, TryCatch #0 {all -> 0x00c5, blocks: (B:9:0x0019, B:12:0x0057, B:16:0x008d, B:18:0x0093, B:19:0x00a9, B:21:0x00af, B:25:0x0065, B:28:0x0072, B:30:0x0082, B:33:0x0029, B:35:0x0031, B:37:0x0040, B:42:0x0047, B:47:0x004f, B:41:0x0054), top: B:8:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c() {
        int indexOf;
        String substring;
        String str;
        String str2 = "";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        try {
            File file = new File("/");
            if (file.listFiles() != null) {
                for (File file2 : file.listFiles()) {
                    String name = file2.getName();
                    if (name.startsWith("init.") && name.endsWith(".environment.rc") && (indexOf = name.indexOf(".environment.rc")) > 5) {
                        substring = name.substring(5, indexOf);
                        break;
                    }
                }
            }
            substring = "";
            String c16 = com.tencent.qimei.ab.a.c("/proc/self/mountinfo");
            if (!c16.isEmpty()) {
                if (c16.contains("/lxc_container/")) {
                    str = "lxc";
                } else {
                    String c17 = com.tencent.qimei.ab.a.c("/proc/self/cpuset");
                    if (c17.contains("/docker") && c16.contains(c17)) {
                        str = "docker";
                    }
                }
                if (!substring.isEmpty()) {
                    str2 = "1#" + substring;
                }
                if (str.isEmpty()) {
                    return str2 + "2#" + str;
                }
                return str2;
            }
            str = "";
            if (!substring.isEmpty()) {
            }
            if (str.isEmpty()) {
            }
        } catch (Throwable th5) {
            com.tencent.qimei.ad.c.a(th5);
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0060, code lost:
    
        if (r6.f343391a.getPackageManager().hasSystemFeature("android.software.leanback") != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String d() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        try {
            UiModeManager uiModeManager = (UiModeManager) this.f343391a.getSystemService("uimode");
            if (uiModeManager == null && a()) {
                return "TV";
            }
            int currentModeType = uiModeManager.getCurrentModeType();
            boolean z17 = false;
            try {
                if (((UiModeManager) this.f343391a.getSystemService("uimode")).getCurrentModeType() == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 && !this.f343391a.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
                }
                z17 = true;
            } catch (Throwable th5) {
                com.tencent.qimei.ad.c.a(th5);
            }
            if (z17) {
                return "TV";
            }
            if (currentModeType == 6) {
                return "WATCH";
            }
            if (currentModeType == 3) {
                return "CAR";
            }
            if ((this.f343391a.getResources().getConfiguration().screenLayout & 15) >= 3) {
                return "Pad";
            }
            return "Phone";
        } catch (Throwable th6) {
            if (a()) {
                return "TV";
            }
            com.tencent.qimei.ad.c.a(th6);
            return "Phone";
        }
    }

    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        synchronized (this) {
            if (this.f343396f == null) {
                f();
            }
        }
        String str = this.f343396f;
        if (str == null) {
            return "";
        }
        return str;
    }

    public synchronized void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        String a16 = com.tencent.qimei.f.a.a();
        if (!a16.equals(this.f343396f)) {
            this.f343397g = true;
            this.f343396f = a16;
        } else {
            this.f343397g = false;
        }
    }
}
