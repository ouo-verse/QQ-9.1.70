package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Almond {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Raspberry<String> f382546a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9813);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f382546a = new Raspberry<>();
        }
    }

    public static String a() {
        Iterator it = ((ArrayList) Lyra.a()).iterator();
        while (it.hasNext()) {
            Cpackage cpackage = (Cpackage) it.next();
            if (cpackage.f383413a.contains(Sugarcane.f383107c)) {
                return cpackage.f383414b;
            }
        }
        return "";
    }

    public static int b(Context context) {
        Intent intent = null;
        try {
            intent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Throwable unused) {
        }
        if (intent == null) {
            return 0;
        }
        int intExtra = intent.getIntExtra("status", -1);
        if (!(intExtra == 2 || intExtra == 5)) {
            return 1;
        }
        int intExtra2 = intent.getIntExtra("plugged", -1);
        if (intExtra2 == 2) {
            return 3;
        }
        return intExtra2 == 1 ? 2 : 0;
    }

    public static String c(Context context) {
        String sb5;
        Raspberry<String> raspberry;
        int simState;
        Raspberry<String> raspberry2 = f382546a;
        synchronized (raspberry2) {
            String a16 = raspberry2.a();
            if (a16 != null) {
                return a16;
            }
            StringBuilder sb6 = new StringBuilder();
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                sb6.append(telephonyManager.getSimState());
                int i3 = Build.VERSION.SDK_INT;
                int phoneCount = telephonyManager.getPhoneCount();
                sb6.append(",");
                sb6.append(phoneCount);
                if (phoneCount > 1 && i3 >= 26) {
                    sb6.append(",");
                    for (int i16 = 0; i16 < phoneCount; i16++) {
                        if (i16 > 0) {
                            sb6.append(";");
                        }
                        simState = telephonyManager.getSimState(i16);
                        sb6.append(simState);
                    }
                }
                sb5 = sb6.toString();
                raspberry = f382546a;
            } catch (Throwable unused) {
                sb5 = sb6.toString();
                raspberry = f382546a;
            }
            raspberry.a(sb5, 0L);
            return sb5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d(Context context) {
        BufferedReader bufferedReader;
        String str;
        boolean z16 = false;
        if (Build.VERSION.SDK_INT >= 24) {
            return 0;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(Ccontinue.a(Ccontinue.f383289n0))));
            try {
                str = bufferedReader.readLine();
                Csynchronized.a(bufferedReader);
            } catch (Throwable unused) {
                if (bufferedReader != null) {
                    Csynchronized.a(bufferedReader);
                }
                str = "";
                if (!TextUtils.isEmpty(str)) {
                }
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("CONFIGURED".equals(str)) {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0) {
                    z16 = true;
                }
            } catch (Throwable unused3) {
            }
            if (!z16) {
                return 3;
            }
            return 1;
        }
        if ("DISCONNECTED".equals(str)) {
            return 2;
        }
        if (!"CONNECTED".equals(str)) {
            return 0;
        }
        return 3;
    }

    public static boolean e(Context context) {
        if (Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) <= 0) {
            return false;
        }
        return true;
    }

    public static String f(Context context) {
        Map<String, Set<String>> map = Cranberry.f382658a;
        ArrayList arrayList = new ArrayList();
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            String a16 = Carambola.a(context, packageName);
            Cpackage cpackage = new Cpackage();
            cpackage.f383413a = Sugarcane.f383105a + Sugarcane.f383106b;
            cpackage.f383414b = packageName + "_" + a16;
            arrayList.add(cpackage);
        }
        if (arrayList.size() != 0) {
            return ((Cpackage) arrayList.get(0)).f383414b;
        }
        return "";
    }

    public static int a(Context context) {
        boolean z16 = false;
        int a16 = Cbreak.a(Cbreak.a(0, e(context), 0), Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) > 0, 1);
        try {
            if ((context.getApplicationInfo().flags & 2) > 0) {
                z16 = true;
            }
        } catch (Throwable unused) {
        }
        return Cbreak.a(Cbreak.a(a16, z16, 2), Debug.isDebuggerConnected(), 3);
    }

    public static String b() {
        Iterator it = ((ArrayList) Lyra.a()).iterator();
        while (it.hasNext()) {
            Cpackage cpackage = (Cpackage) it.next();
            if (cpackage.f383413a.contains(Sugarcane.f383108d)) {
                return cpackage.f383414b;
            }
        }
        return "";
    }
}
