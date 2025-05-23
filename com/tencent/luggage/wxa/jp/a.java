package com.tencent.luggage.wxa.jp;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.tencent.luggage.wxa.np.b;
import com.tencent.luggage.wxa.np.e;
import com.tencent.luggage.wxa.np.h;
import com.tencent.luggage.wxa.np.i;
import com.tencent.luggage.wxa.np.j;
import com.tencent.luggage.wxa.np.k;
import com.tencent.luggage.wxa.np.l;
import com.tencent.luggage.wxa.op.c;
import com.tencent.luggage.wxa.op.d;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.soter.core.model.ConstantsSoter;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements b {

    /* renamed from: b, reason: collision with root package name */
    public static com.tencent.luggage.wxa.op.b f131219b;

    static {
        e.c("Soter.SoterCore", "soter: SoterCore is call static block to init SoterCore IMPL", new Object[0]);
        com.tencent.luggage.wxa.op.b d16 = d();
        f131219b = d16;
        boolean z16 = true;
        Object[] objArr = new Object[1];
        if (d16 != null) {
            z16 = false;
        }
        objArr[0] = Boolean.valueOf(z16);
        e.c("Soter.SoterCore", "soter: SoterCore is call static block to init SoterCore IMPL, IMPL is null[%b]", objArr);
    }

    public static h a() {
        com.tencent.luggage.wxa.op.b bVar = f131219b;
        if (bVar == null) {
            e.b("Soter.SoterCore", "soter: generateAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
            return new h(2);
        }
        return bVar.a();
    }

    public static h b(String str, boolean z16) {
        com.tencent.luggage.wxa.op.b bVar = f131219b;
        if (bVar == null) {
            e.b("Soter.SoterCore", "soter: removeAuthKey IMPL is null, not support soter", new Object[0]);
            return new h(2);
        }
        return bVar.b(str, z16);
    }

    public static k c() {
        com.tencent.luggage.wxa.op.b bVar = f131219b;
        if (bVar == null) {
            e.b("Soter.SoterCore", "soter: getAppGlobalSecureKeyModel IMPL is null, not support soter", new Object[0]);
            return null;
        }
        return bVar.b();
    }

    public static synchronized void d(Context context) {
        synchronized (a.class) {
            if (f131219b == null) {
                e.c("Soter.SoterCore", "soter: SoterCore IMPL is null then call tryToInitSoterTreble to init", new Object[0]);
                if (!d.n()) {
                    d dVar = new d();
                    f131219b = dVar;
                    dVar.a((com.tencent.luggage.wxa.op.e) null);
                    if (!f131219b.a(context)) {
                        f131219b = null;
                        e.c("Soter.SoterCore", "soter: SoterCore IMPL is null after call tryToInitSoterTreble to init", new Object[0]);
                    }
                } else {
                    e.c("Soter.SoterCore", "soter: treble is initializing", new Object[0]);
                }
            }
        }
    }

    public static int e() {
        com.tencent.luggage.wxa.op.b bVar = f131219b;
        if (bVar == null) {
            return 0;
        }
        if (bVar instanceof d) {
            e.a("Soter.SoterCore", "getSoterCoreType is TREBLE", new Object[0]);
            return 1;
        }
        e.a("Soter.SoterCore", "getSoterCoreType is not TREBLE", new Object[0]);
        return 0;
    }

    public static boolean f() {
        com.tencent.luggage.wxa.op.b bVar = f131219b;
        if (bVar == null) {
            e.b("Soter.SoterCore", "soter: hasAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
            return false;
        }
        return bVar.c();
    }

    public static boolean g() {
        com.tencent.luggage.wxa.op.b bVar = f131219b;
        if (bVar == null) {
            e.b("Soter.SoterCore", "soter: isAppGlobalSecureKeyValid IMPL is null, not support soter", new Object[0]);
            return false;
        }
        return bVar.d();
    }

    public static boolean h() {
        com.tencent.luggage.wxa.op.b bVar = f131219b;
        if (bVar == null) {
            e.b("Soter.SoterCore", "soter: isNativeSupportSoter IMPL is null, not support soter", new Object[0]);
            return false;
        }
        boolean e16 = bVar.e();
        e.b("Soter.SoterCore", "soter: isNativeSupportSoter return[" + e16 + "]", new Object[0]);
        return e16;
    }

    public static h i() {
        com.tencent.luggage.wxa.op.b bVar = f131219b;
        if (bVar == null) {
            e.b("Soter.SoterCore", "soter: removeAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
            return new h(2);
        }
        return bVar.f();
    }

    public static void j() {
        c.g();
    }

    public static void k() {
        if (f131219b == null) {
            e.c("Soter.SoterCore", "soter: SoterCore IMPL is null then call getProviderSoterCore to init", new Object[0]);
            com.tencent.luggage.wxa.op.b d16 = d();
            f131219b = d16;
            boolean z16 = true;
            Object[] objArr = new Object[1];
            if (d16 != null) {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            e.c("Soter.SoterCore", "soter: SoterCore IMPL is null[%b], after call getProviderSoterCore to init", objArr);
        }
    }

    public static k c(String str) {
        com.tencent.luggage.wxa.op.b bVar = f131219b;
        if (bVar == null) {
            e.b("Soter.SoterCore", "soter: getAuthKeyModel IMPL is null, not support soter", new Object[0]);
            return null;
        }
        return bVar.c(str);
    }

    public static h a(String str) {
        com.tencent.luggage.wxa.op.b bVar = f131219b;
        if (bVar == null) {
            e.b("Soter.SoterCore", "soter: generateAuthKey IMPL is null, not support soter", new Object[0]);
            return new h(2);
        }
        return bVar.a(str);
    }

    public static Signature b(String str) {
        com.tencent.luggage.wxa.op.b bVar = f131219b;
        if (bVar == null) {
            e.b("Soter.SoterCore", "soter: getAuthInitAndSign IMPL is null, not support soter", new Object[0]);
            return null;
        }
        return bVar.b(str);
    }

    public static boolean c(Context context) {
        return com.tencent.luggage.wxa.kp.a.a(context, 1).a();
    }

    public static int b(byte[] bArr) {
        int i3 = 0;
        for (int i16 = 0; i16 < bArr.length; i16++) {
            i3 += (bArr[i16] & 255) << (i16 * 8);
        }
        return i3;
    }

    public static boolean a(String str, boolean z16) {
        com.tencent.luggage.wxa.op.b bVar = f131219b;
        if (bVar == null) {
            e.b("Soter.SoterCore", "soter: isAuthKeyValid IMPL is null, not support soter", new Object[0]);
            return false;
        }
        return bVar.a(str, z16);
    }

    public static boolean b(Context context) {
        boolean c16 = com.tencent.luggage.wxa.kp.a.a(context, 1).c();
        e.b("Soter.SoterCore", "soter: isSupportFingerprint return[" + c16 + "]", new Object[0]);
        return c16;
    }

    public static com.tencent.luggage.wxa.op.b d() {
        Provider[] providers;
        c.g();
        if (j.a() || (providers = Security.getProviders()) == null) {
            return null;
        }
        for (Provider provider : providers) {
            String name = provider.getName();
            if (name != null && name.startsWith(ConstantsSoter.SOTER_PROVIDER_NAME)) {
                if (name.split("\\.").length > 1) {
                    return new com.tencent.luggage.wxa.op.a(name);
                }
                return new c(name);
            }
        }
        return null;
    }

    public static com.tencent.luggage.wxa.pp.c a(String str, String str2) {
        com.tencent.luggage.wxa.op.b bVar = f131219b;
        if (bVar == null) {
            e.b("Soter.SoterCore", "soter: initSigh IMPL is null, not support soter", new Object[0]);
            return null;
        }
        return bVar.a(str, str2);
    }

    public static boolean b(Context context, int i3) {
        boolean c16 = com.tencent.luggage.wxa.kp.a.a(context, Integer.valueOf(i3)).c();
        e.b("Soter.SoterCore", "soter: isSupportBiometric type[" + i3 + "] return[" + c16 + "]", new Object[0]);
        return c16;
    }

    public static String b() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("<deviceinfo>");
        sb5.append("<MANUFACTURER name=\"");
        sb5.append(Build.MANUFACTURER);
        sb5.append("\">");
        sb5.append("<MODEL name=\"");
        sb5.append(DeviceInfoMonitor.getModel());
        sb5.append("\">");
        sb5.append("<VERSION_RELEASE name=\"");
        sb5.append(Build.VERSION.RELEASE);
        sb5.append("\">");
        sb5.append("<VERSION_INCREMENTAL name=\"");
        sb5.append(Build.VERSION.INCREMENTAL);
        sb5.append("\">");
        sb5.append("<DISPLAY name=\"");
        sb5.append(Build.DISPLAY);
        sb5.append("\">");
        sb5.append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
        e.a("Soter.SoterCore", "soter: getFingerprint  " + sb5.toString(), new Object[0]);
        return sb5.toString();
    }

    public static byte[] a(long j3) {
        com.tencent.luggage.wxa.op.b bVar = f131219b;
        if (bVar == null) {
            e.b("Soter.SoterCore", "soter: finishSign IMPL is null, not support soter", new Object[0]);
            return new byte[0];
        }
        return bVar.a(j3);
    }

    public static l a(byte[] bArr) {
        if (i.b(bArr)) {
            e.b("Soter.SoterCore", "origin is null or nil. abort", new Object[0]);
            return null;
        }
        if (bArr.length < 4) {
            e.b("Soter.SoterCore", "soter: length not correct 1", new Object[0]);
            return null;
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        int b16 = b(bArr2);
        e.a("Soter", "parsed raw length: " + b16, new Object[0]);
        if (b16 > 1048576) {
            e.b("Soter.SoterCore", "soter: too large signature result!", new Object[0]);
            return null;
        }
        byte[] bArr3 = new byte[b16];
        int i3 = b16 + 4;
        if (bArr.length <= i3) {
            e.b("Soter.SoterCore", "soter: length not correct 2", new Object[0]);
            return null;
        }
        System.arraycopy(bArr, 4, bArr3, 0, b16);
        l a16 = l.a(new String(bArr3));
        int length = bArr.length - i3;
        e.a("Soter.SoterCore", "soter: signature length: " + length, new Object[0]);
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr, i3, bArr4, 0, length);
        if (a16 != null) {
            a16.h(Base64.encodeToString(bArr4, 2));
        }
        return a16;
    }

    public static boolean d(String str) {
        com.tencent.luggage.wxa.op.b bVar = f131219b;
        if (bVar == null) {
            e.b("Soter.SoterCore", "soter: hasAuthKey IMPL is null, not support soter", new Object[0]);
            return false;
        }
        return bVar.d(str);
    }

    public static boolean a(Context context) {
        return (com.tencent.luggage.wxa.kp.a.a(context, 1).b() || com.tencent.luggage.wxa.kp.a.a(context, 1).a(context)) ? false : true;
    }

    public static boolean a(Context context, int i3) {
        return (com.tencent.luggage.wxa.kp.a.a(context, Integer.valueOf(i3)).b() || com.tencent.luggage.wxa.kp.a.a(context, Integer.valueOf(i3)).a(context)) ? false : true;
    }
}
