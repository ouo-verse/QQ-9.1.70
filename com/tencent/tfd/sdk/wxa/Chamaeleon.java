package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Chamaeleon {
    public static String a() {
        Iterator it = ((ArrayList) Ara.a()).iterator();
        while (it.hasNext()) {
            Cpublic cpublic = (Cpublic) it.next();
            if (cpublic.f375769a.contains(Bullace.f375486c)) {
                return cpublic.f375770b;
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
        int simState;
        try {
            StringBuilder sb5 = new StringBuilder();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            sb5.append(telephonyManager.getSimState());
            int i3 = Build.VERSION.SDK_INT;
            int phoneCount = telephonyManager.getPhoneCount();
            sb5.append(",");
            sb5.append(phoneCount);
            if (phoneCount > 0 && i3 >= 26) {
                sb5.append(",");
                for (int i16 = 0; i16 < phoneCount; i16++) {
                    if (i16 > 0) {
                        sb5.append(";");
                    }
                    simState = telephonyManager.getSimState(i16);
                    sb5.append(simState);
                }
            }
            return sb5.toString();
        } catch (Throwable unused) {
            return "";
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
            bufferedReader = new BufferedReader(new FileReader(new File(Cswitch.a(Cswitch.f375810n0))));
            try {
                str = bufferedReader.readLine();
                Cextends.a(bufferedReader);
            } catch (Throwable unused) {
                if (bufferedReader != null) {
                    Cextends.a(bufferedReader);
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

    /* JADX WARN: Removed duplicated region for block: B:5:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a1 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String f(Context context) {
        ByteArrayInputStream byteArrayInputStream;
        String str;
        Map<String, Set<String>> map = Phoenix.f375664a;
        ArrayList arrayList = new ArrayList();
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                byteArrayInputStream = new ByteArrayInputStream(InstalledAppListMonitor.getPackageInfo(packageManager, packageManager.getPackagesForUid(context.getPackageManager().getApplicationInfo(packageName, 0).uid)[0], 64).signatures[0].toByteArray());
                try {
                    str = Cepheus.a(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream)).getEncoded());
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    str = "";
                    Cpublic cpublic = new Cpublic();
                    cpublic.f375769a = Bullace.f375484a + Bullace.f375485b;
                    cpublic.f375770b = packageName + "_" + str;
                    arrayList.add(cpublic);
                    if (arrayList.size() != 0) {
                    }
                }
            } catch (Throwable unused4) {
                byteArrayInputStream = null;
            }
            Cpublic cpublic2 = new Cpublic();
            cpublic2.f375769a = Bullace.f375484a + Bullace.f375485b;
            cpublic2.f375770b = packageName + "_" + str;
            arrayList.add(cpublic2);
        }
        if (arrayList.size() != 0) {
            return "";
        }
        return ((Cpublic) arrayList.get(0)).f375770b;
    }

    public static int a(Context context) {
        boolean z16 = false;
        int a16 = Ccatch.a(Ccatch.a(0, e(context), 0), Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) > 0, 1);
        try {
            if ((context.getApplicationInfo().flags & 2) > 0) {
                z16 = true;
            }
        } catch (Throwable unused) {
        }
        return Ccatch.a(Ccatch.a(a16, z16, 2), Debug.isDebuggerConnected(), 3);
    }

    public static String b() {
        Iterator it = ((ArrayList) Ara.a()).iterator();
        while (it.hasNext()) {
            Cpublic cpublic = (Cpublic) it.next();
            if (cpublic.f375769a.contains(Bullace.f375487d)) {
                return cpublic.f375770b;
            }
        }
        return "";
    }
}
