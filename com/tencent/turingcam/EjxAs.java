package com.tencent.turingcam;

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
import com.tencent.turingcam.F2BEC;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class EjxAs {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final b6bfM<String> f381797a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10724);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f381797a = new b6bfM<>();
        }
    }

    public static int a(Context context) {
        boolean z16 = false;
        int a16 = CEO0r.a(CEO0r.a(0, Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0, 0), Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) > 0, 1);
        try {
            if ((context.getApplicationInfo().flags & 2) > 0) {
                z16 = true;
            }
        } catch (Throwable unused) {
        }
        return CEO0r.a(CEO0r.a(a16, z16, 2), Debug.isDebuggerConnected(), 3);
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

    /* JADX WARN: Type inference failed for: r5v3, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static String c(Context context) {
        b6bfM<String> b6bfm;
        ?? r56;
        int simState;
        b6bfM<String> b6bfm2 = f381797a;
        synchronized (b6bfm2) {
            String a16 = b6bfm2.a();
            if (a16 != null) {
                return a16;
            }
            StringBuilder sb5 = new StringBuilder();
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                sb5.append(telephonyManager.getSimState());
                int i3 = Build.VERSION.SDK_INT;
                int phoneCount = telephonyManager.getPhoneCount();
                sb5.append(",");
                sb5.append(phoneCount);
                if (phoneCount > 1 && i3 >= 26) {
                    sb5.append(",");
                    for (int i16 = 0; i16 < phoneCount; i16++) {
                        if (i16 > 0) {
                            sb5.append(";");
                        }
                        simState = telephonyManager.getSimState(i16);
                        sb5.append(simState);
                    }
                }
                String sb6 = sb5.toString();
                b6bfm = f381797a;
                r56 = sb6;
            } catch (Throwable unused) {
                String sb7 = sb5.toString();
                b6bfm = f381797a;
                r56 = sb7;
            }
            synchronized (b6bfm) {
                if (r56 != 0) {
                    b6bfm.f382155a = r56;
                    b6bfm.f382156b = System.currentTimeMillis();
                    b6bfm.f382157c = 0L;
                }
            }
            return r56;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.CharSequence, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int d(Context context) {
        BufferedReader bufferedReader;
        boolean z16 = false;
        if (Build.VERSION.SDK_INT >= 24) {
            return 0;
        }
        ?? file = new File(LwgsO.a(LwgsO.f381921n0));
        HashMap<String, F2BEC.spXPg> hashMap = F2BEC.f381816a;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader((File) file));
                try {
                    String readLine = bufferedReader.readLine();
                    bufferedReader.close();
                    file = readLine;
                } catch (Throwable unused) {
                    file = "";
                    if (bufferedReader != null) {
                        bufferedReader.close();
                        file = file;
                    }
                    if (!TextUtils.isEmpty(file)) {
                    }
                }
            } catch (Throwable unused2) {
                bufferedReader = null;
            }
        } catch (Throwable unused3) {
        }
        if (!TextUtils.isEmpty(file)) {
            return 0;
        }
        if ("CONFIGURED".equals(file)) {
            try {
                if (Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0) {
                    z16 = true;
                }
            } catch (Throwable unused4) {
            }
            if (!z16) {
                return 3;
            }
            return 1;
        }
        if ("DISCONNECTED".equals(file)) {
            return 2;
        }
        if (!"CONNECTED".equals(file)) {
            return 0;
        }
        return 3;
    }

    public static String e(Context context) {
        Map<String, Set<String>> map = CXNbL.f381751a;
        ArrayList arrayList = new ArrayList();
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            String a16 = pZo7n.a(context, packageName);
            ZwVTT zwVTT = new ZwVTT();
            zwVTT.f382125a = CRchv.f381744a + CRchv.f381745b;
            zwVTT.f382126b = packageName + "_" + a16;
            arrayList.add(zwVTT);
        }
        if (arrayList.size() != 0) {
            return ((ZwVTT) arrayList.get(0)).f382126b;
        }
        return "";
    }

    public static String b() {
        Iterator it = ((ArrayList) pZZwF.a()).iterator();
        while (it.hasNext()) {
            ZwVTT zwVTT = (ZwVTT) it.next();
            if (zwVTT.f382125a.contains(CRchv.f381747d)) {
                return zwVTT.f382126b;
            }
        }
        return "";
    }

    public static String a() {
        Iterator it = ((ArrayList) pZZwF.a()).iterator();
        while (it.hasNext()) {
            ZwVTT zwVTT = (ZwVTT) it.next();
            if (zwVTT.f382125a.contains(CRchv.f381746c)) {
                return zwVTT.f382126b;
            }
        }
        return "";
    }

    public static String c() {
        Context context;
        StringBuilder sb5 = new StringBuilder();
        try {
            synchronized (eh5ma.class) {
                context = eh5ma.f382207a;
            }
            lkZFD a16 = JUeK5.a(context);
            for (int i3 = 0; i3 < a16.f382306a.a(); i3++) {
                if (sb5.length() > 0) {
                    sb5.append(",");
                }
                Locale a17 = a16.f382306a.a(i3);
                if (a17 != null) {
                    sb5.append(a17.getLanguage());
                    sb5.append("-");
                    sb5.append(a17.getCountry());
                }
            }
        } catch (Throwable unused) {
        }
        return sb5.toString();
    }
}
