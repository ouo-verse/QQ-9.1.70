package com.tencent.qmethod.pandoraex.core;

import android.app.ActivityManager;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.api.ConstantModel;
import com.tencent.qmethod.pandoraex.monitor.SilentCallMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.jf.dexlib2.analysis.RegisterType;
import vr3.b;

/* compiled from: P */
/* loaded from: classes22.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public static String[] f344168a = {""};

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f344169b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static boolean A(com.tencent.qmethod.pandoraex.api.d dVar) {
        return B(dVar.f343900a);
    }

    public static boolean B(String str) {
        if (!"memory".equals(str) && !"cache_only".equals(str) && !QQPermissionConstants.Permission.STORAGE_GROUP.equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean C(com.tencent.qmethod.pandoraex.api.d dVar) {
        if (!dVar.f343901b && !"normal".equals(dVar.f343900a)) {
            return false;
        }
        return true;
    }

    private static boolean D(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        if (runningAppProcessInfo != null && runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.startsWith(com.tencent.qmethod.pandoraex.api.q.f())) {
            return true;
        }
        return false;
    }

    private static boolean E() {
        return !u();
    }

    private static boolean F(vr3.a aVar) {
        if (aVar != null && com.tencent.qmethod.pandoraex.api.q.d()) {
            return !e(aVar);
        }
        return false;
    }

    private static boolean G(String str, String str2, String[] strArr) {
        if (m(str, str2, strArr, "high_freq") != null) {
            return true;
        }
        return false;
    }

    private static boolean H(String str, String str2, String[] strArr) {
        com.tencent.qmethod.pandoraex.api.v m3 = m(str, str2, strArr, "illegal_scene");
        if (m3 == null) {
            return false;
        }
        if (m3.f343997h.isEmpty() && m3.f343996g.isEmpty()) {
            return true;
        }
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        if (!m3.f343997h.isEmpty() && m3.f343996g.isEmpty()) {
            return z(m3.f343997h, strArr);
        }
        if (m3.f343997h.isEmpty() && !m3.f343996g.isEmpty()) {
            return !z(m3.f343996g, strArr);
        }
        if (z(m3.f343997h, strArr)) {
            return true;
        }
        return !z(m3.f343996g, strArr);
    }

    private static boolean I(String str, String str2, String[] strArr, vr3.b bVar) {
        com.tencent.qmethod.pandoraex.api.v m3;
        if (SilentCallMonitor.ENABLE && SilentCallMonitor.isHookEnable() && (m3 = m(str, str2, strArr, "silence")) != null && m3.f343994e != 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long lastUserInteractionTime = SilentCallMonitor.getLastUserInteractionTime();
            if (lastUserInteractionTime != 0) {
                long j3 = uptimeMillis - lastUserInteractionTime;
                if (Math.abs(j3) >= m3.f343994e) {
                    o.a("Utils", "SilentCallMonitor currentTime - lastUserInteractionTime:" + j3 + " silenceTime:" + m3.f343994e);
                    bVar.f443253l = j3;
                    bVar.f443252k = m3.f343994e;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean J(vr3.b bVar) {
        boolean z16;
        yr3.e c16 = yr3.e.c();
        if (bVar.f443266y == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = bVar.f443265x;
        if (i3 != 0) {
            if (2 != i3 && (1 != i3 || z16)) {
                return false;
            }
            return true;
        }
        int i16 = c16.f451083l;
        if (2 != i16 && (1 != i16 || z16)) {
            return false;
        }
        return true;
    }

    public static boolean K(String str, String str2, com.tencent.qmethod.pandoraex.api.v vVar) {
        if (com.tencent.qmethod.pandoraex.api.q.h() != null) {
            return com.tencent.qmethod.pandoraex.api.q.h().b(str, str2, vVar);
        }
        if (vVar.f343995f <= 0 || new Random().nextInt(vVar.f343995f) >= 1) {
            return false;
        }
        return true;
    }

    public static vr3.b L(vr3.b bVar, com.tencent.qmethod.pandoraex.api.v vVar, vr3.a aVar, HashMap<String, String> hashMap) {
        vr3.b b16 = vr3.b.b(bVar);
        if (vVar != null) {
            if (aVar != null && !aVar.f443218c.contains(vVar.f343991b)) {
                b16.f443245d = "normal";
            } else {
                b16.f443245d = vVar.f343991b;
            }
            if (b16.f443245d.equals("ban")) {
                return b16;
            }
            if (b16.f443245d.equals("cache_only")) {
                return b16;
            }
            String str = null;
            if (b16.f443245d.equals("memory")) {
                b16.f443251j = vVar.f343993d;
                if (hashMap != null && hashMap.containsKey("index")) {
                    str = hashMap.get("index");
                }
                if (e.b(b16.f443242a, b16.f443243b, b16.f443251j, str)) {
                    if (com.tencent.qmethod.pandoraex.api.q.m()) {
                        o.e("Utils", "isCacheExceed toSysCall");
                    }
                    b16.f443246e = true;
                    e.e(b16.f443242a, b16.f443243b, str);
                }
                return b16;
            }
            if (b16.f443245d.equals(QQPermissionConstants.Permission.STORAGE_GROUP)) {
                b16.f443251j = vVar.f343993d;
                if (hashMap != null && hashMap.containsKey("index")) {
                    str = hashMap.get("index");
                }
                if (O(b16.f443243b, b16.f443251j, str)) {
                    if (com.tencent.qmethod.pandoraex.api.q.m()) {
                        o.e("Utils", "storageIsSystemCall toSysCall");
                    }
                    b16.f443246e = true;
                }
                return b16;
            }
        }
        if (com.tencent.qmethod.pandoraex.api.q.m()) {
            o.e("Utils", "noRule toSysCall");
        }
        b16.f443246e = true;
        return b16;
    }

    public static String M(Throwable th5, int i3, int i16) {
        if (th5 == null) {
            return "";
        }
        StackTraceElement[] stackTrace = th5.getStackTrace();
        StringBuilder sb5 = new StringBuilder();
        for (int i17 = i3; i17 < stackTrace.length && i17 < i3 + i16; i17++) {
            sb5.append(stackTrace[i17]);
            sb5.append("\n");
        }
        return sb5.toString();
    }

    public static String N(Throwable th5, int i3, int i16) {
        if (th5 == null) {
            return "";
        }
        StackTraceElement[] stackTrace = th5.getStackTrace();
        StringBuilder sb5 = new StringBuilder();
        for (int i17 = i3; i17 < stackTrace.length && i17 < i3 + i16; i17++) {
            StackTraceElement stackTraceElement = stackTrace[i17];
            sb5.append(stackTraceElement.getClassName());
            sb5.append(".");
            sb5.append(stackTraceElement.getMethodName());
            if (stackTraceElement.isNativeMethod()) {
                sb5.append("(Native Method)");
            } else if (stackTraceElement.getFileName() != null) {
                sb5.append("(");
                sb5.append(stackTraceElement.getFileName());
                sb5.append(")");
            } else {
                sb5.append("(Unknown Source)");
            }
            sb5.append("\n");
        }
        return sb5.toString();
    }

    public static boolean O(String str, long j3, String str2) {
        if (e.c(str, j3)) {
            return true;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str + str2;
        }
        if (!com.tencent.qmethod.pandoraex.api.r.c(com.tencent.qmethod.pandoraex.api.q.b(), str).booleanValue()) {
            return true;
        }
        return false;
    }

    public static String a(boolean z16) {
        if (z16) {
            return "1";
        }
        return "0";
    }

    public static String b(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return "";
        }
        char[] cArr = new char[length << 1];
        int i3 = 0;
        for (byte b16 : bArr) {
            int i16 = i3 + 1;
            char[] cArr2 = f344169b;
            cArr[i3] = cArr2[(b16 >> 4) & 15];
            i3 = i16 + 1;
            cArr[i16] = cArr2[b16 & RegisterType.DOUBLE_HI];
        }
        return new String(cArr);
    }

    public static boolean c() {
        com.tencent.qmethod.pandoraex.api.m h16 = com.tencent.qmethod.pandoraex.api.q.h();
        if (h16 != null) {
            return h16.a();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void d(vr3.b bVar) {
        boolean z16;
        yr3.e c16 = yr3.e.c();
        bVar.f443266y = 0;
        if (!c16.l()) {
            return;
        }
        List<String> g16 = c16.g(bVar.f443242a, bVar.f443243b);
        if (g16.isEmpty()) {
            return;
        }
        String str = g16.get(0);
        bVar.f443265x = c16.f(str);
        LinkedHashSet<yr3.c> h16 = c16.h();
        bVar.f443262u = h16;
        bVar.f443260s = g16;
        if (h16.isEmpty()) {
            bVar.f443266y = 2;
            return;
        }
        Iterator<yr3.c> it = h16.iterator();
        boolean z17 = false;
        while (it.hasNext()) {
            yr3.c next = it.next();
            int indexOf = next.f451062d.indexOf(str);
            if (indexOf >= 0) {
                int intValue = next.f451068j.get(indexOf).intValue();
                if (next.f451062d.contains(str)) {
                    if (next.f451065g) {
                        Iterator<yr3.f> it5 = next.f451064f.iterator();
                        while (it5.hasNext()) {
                            if (it5.next().e(str)) {
                                if (next.c() && !next.b()) {
                                    bVar.f443266y = Math.max(bVar.f443266y, 5);
                                }
                                z16 = true;
                                break;
                            }
                            bVar.f443266y = Math.max(bVar.f443266y, 4);
                        }
                    } else {
                        if (next.g().contains(str)) {
                            if (next.c() && !next.b()) {
                                bVar.f443266y = Math.max(bVar.f443266y, 5);
                            }
                            z16 = true;
                            break;
                        }
                        bVar.f443266y = Math.max(bVar.f443266y, 4);
                    }
                    if (!z16) {
                        bVar.f443261t = Math.min(bVar.f443261t, intValue);
                        z17 = true;
                    } else {
                        bVar.f443266y = Math.max(bVar.f443266y, 1);
                    }
                } else {
                    bVar.f443266y = Math.max(bVar.f443266y, 3);
                }
                z16 = false;
                if (!z16) {
                }
            }
        }
        if (z17) {
            bVar.f443266y = 0;
        }
    }

    private static boolean e(vr3.a aVar) {
        Set<String> set = aVar.f443219d;
        if (set != null && set.size() != 0) {
            return r.b(com.tencent.qmethod.pandoraex.api.q.b(), (String[]) aVar.f443219d.toArray(new String[0]));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean f(Map<String, com.tencent.qmethod.pandoraex.api.b> map, com.tencent.qmethod.pandoraex.api.b bVar) {
        return g(map, bVar, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean g(Map<String, com.tencent.qmethod.pandoraex.api.b> map, com.tencent.qmethod.pandoraex.api.b bVar, boolean z16) {
        if (bVar == null || bVar.f343878a == null) {
            return false;
        }
        if (!z16) {
            o.a("Utils", "convertAndUpdateConfig: " + bVar);
        }
        if (!ConstantModel.f343876a.containsKey(bVar.f343878a)) {
            return false;
        }
        String c16 = com.tencent.qmethod.pandoraex.api.b.c(bVar.f343878a, bVar.f343879b, bVar.f343881d);
        com.tencent.qmethod.pandoraex.api.b bVar2 = map.get(c16);
        if (bVar2 == null) {
            if (z16) {
                map.put(c16, bVar);
            } else {
                map.put(c16, com.tencent.qmethod.pandoraex.api.b.a(bVar));
            }
            return false;
        }
        bVar2.d(com.tencent.qmethod.pandoraex.api.b.a(bVar));
        return true;
    }

    public static byte[] h(String str) {
        byte[] bArr = new byte[6];
        if (TextUtils.isEmpty(str)) {
            str = GlobalUtil.DEFAULT_MAC_ADDRESS;
        }
        try {
            String replaceAll = str.replaceAll(":", "");
            for (int i3 = 0; i3 < 6; i3++) {
                int i16 = i3 * 2;
                bArr[i3] = Integer.valueOf(replaceAll.substring(i16, i16 + 2), 16).byteValue();
            }
        } catch (Exception e16) {
            o.d("Utils", "convertMacStringToHex error:", e16);
        }
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.tencent.qmethod.pandoraex.api.v i(vr3.a aVar, vr3.b bVar, com.tencent.qmethod.pandoraex.api.v vVar) {
        boolean z16;
        com.tencent.qmethod.pandoraex.api.v t16;
        boolean K;
        boolean z17 = true;
        if (c() && "high_freq".equals(bVar.f443244c)) {
            if (j.f(vVar, bVar)) {
                bVar.f443257p.add(r(bVar));
                z16 = true;
                t16 = t(bVar.f443242a, bVar.f443243b, bVar, vVar);
                if (aVar != null && !aVar.f443218c.contains(vVar.f343991b)) {
                    t16.f343991b = "normal";
                }
                if (!d.a(bVar.f443243b)) {
                    t16.f343991b = "ban";
                }
                K = K(bVar.f443242a, bVar.f443243b, t16);
                bVar.f443249h = K;
                if (!K && t16.f343990a != "high_freq" && !z16) {
                    bVar.f443257p.clear();
                    bVar.f443257p.add(r(bVar));
                } else {
                    z17 = z16;
                }
                if (com.tencent.qmethod.pandoraex.api.q.f343925a && !z17) {
                    bVar.f443257p.add(r(bVar));
                }
                return t16;
            }
            if (!com.tencent.qmethod.pandoraex.api.q.f343925a) {
                bVar.f443257p.add(new com.tencent.qmethod.pandoraex.api.t(null, "", 1));
            }
        }
        z16 = false;
        t16 = t(bVar.f443242a, bVar.f443243b, bVar, vVar);
        if (aVar != null) {
            t16.f343991b = "normal";
        }
        if (!d.a(bVar.f443243b)) {
        }
        K = K(bVar.f443242a, bVar.f443243b, t16);
        bVar.f443249h = K;
        if (!K) {
        }
        z17 = z16;
        if (com.tencent.qmethod.pandoraex.api.q.f343925a) {
            bVar.f443257p.add(r(bVar));
        }
        return t16;
    }

    public static void j(Runnable runnable, long j3) {
        com.tencent.qmethod.pandoraex.api.o k3 = com.tencent.qmethod.pandoraex.api.q.k();
        if (k3 != null) {
            k3.a(runnable, j3);
        } else if (j3 > 0) {
            h.a().postDelayed(runnable, j3);
        } else {
            h.a().post(runnable);
        }
    }

    public static vr3.b k(String str, String str2, vr3.a aVar, HashMap<String, String> hashMap) {
        boolean w3 = w();
        vr3.b a16 = new b.a().g(str).h(str2).c(p()).f(w3).e(u()).b(1).d(hashMap).a();
        if (E()) {
            a16.f443244c = "before";
        } else if (F(aVar)) {
            a16.f443244c = "deny_retry";
        } else {
            d(a16);
            boolean J = J(a16);
            if (!v(a16)) {
                yr3.e.c().o(a16.f443266y, a16.f443242a, a16.f443243b, a16.f443260s, yr3.e.c().h());
                if (J) {
                    a16.f443244c = "mod_no_perm";
                }
            }
            if (!J) {
                a16.f443261t = 100;
            }
            if (H(str, str2, a16.f443256o)) {
                a16.f443244c = "illegal_scene";
            } else if (!w3) {
                a16.f443244c = "back";
            } else if (I(str, str2, a16.f443256o, a16)) {
                a16.f443244c = "silence";
            } else if (G(str, str2, a16.f443256o)) {
                a16.f443244c = "high_freq";
            } else {
                a16.f443244c = "normal";
            }
        }
        return a16;
    }

    public static com.tencent.qmethod.pandoraex.api.u l(vr3.b bVar) {
        if (bVar == null) {
            return null;
        }
        com.tencent.qmethod.pandoraex.api.u uVar = new com.tencent.qmethod.pandoraex.api.u(bVar.f443242a, bVar.f443243b);
        uVar.f343967d = bVar.f443244c;
        uVar.f343968e = bVar.f443245d;
        uVar.f343966c = null;
        uVar.f343969f = bVar.f443246e;
        uVar.f343970g = bVar.f443247f;
        uVar.f343971h = bVar.f443248g;
        uVar.f343983t = bVar.f443250i;
        uVar.f343972i = bVar.f443251j;
        uVar.f343973j = bVar.f443252k;
        uVar.f343974k = bVar.f443253l;
        uVar.f343975l = bVar.f443254m;
        uVar.f343976m = bVar.f443255n;
        uVar.f343980q = bVar.f443257p;
        uVar.f343977n = System.currentTimeMillis();
        uVar.f343978o = "0.9.15-rc2+build.1";
        uVar.f343979p = com.tencent.qmethod.pandoraex.core.collector.utils.a.a();
        uVar.f343982s = bVar.f443256o;
        uVar.f343981r = a.c();
        uVar.f343986w = bVar.c();
        uVar.A = bVar.f443258q.get("ShiplyKey");
        uVar.C = bVar.f443262u;
        uVar.D = bVar.f443260s;
        uVar.E = bVar.f443261t;
        return uVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tencent.qmethod.pandoraex.api.v m(String str, String str2, String[] strArr, String str3) {
        if (str3 == null || !com.tencent.qmethod.pandoraex.api.w.f344006a.contains(str3)) {
            return null;
        }
        com.tencent.qmethod.pandoraex.api.v o16 = o(str, str2, strArr, str3);
        if (o16 != null) {
            return o16;
        }
        com.tencent.qmethod.pandoraex.api.v o17 = o(str, null, strArr, str3);
        if (o17 != null) {
            return o17;
        }
        com.tencent.qmethod.pandoraex.api.v o18 = o(str, str2, null, str3);
        if (o18 != null) {
            return o18;
        }
        com.tencent.qmethod.pandoraex.api.v o19 = o(str, null, null, str3);
        if (o19 != null) {
            return o19;
        }
        return o("default_module", null, null, str3);
    }

    public static com.tencent.qmethod.pandoraex.api.b n(String str, String str2, String[] strArr) {
        com.tencent.qmethod.pandoraex.api.b a16;
        if (strArr == null || strArr.length == 0) {
            strArr = new String[]{""};
        }
        for (int length = strArr.length - 1; length >= 0; length--) {
            com.tencent.qmethod.pandoraex.api.b a17 = f.a(str, str2, strArr[length]);
            if (a17 != null) {
                return a17;
            }
        }
        int length2 = strArr.length;
        do {
            length2--;
            if (length2 >= 0) {
                a16 = f.a(str, null, strArr[length2]);
            } else {
                com.tencent.qmethod.pandoraex.api.b a18 = f.a(str, str2, null);
                if (a18 != null) {
                    return a18;
                }
                com.tencent.qmethod.pandoraex.api.b a19 = f.a(str, null, null);
                if (a19 != null) {
                    return a19;
                }
                return f.a("default_module", null, null);
            }
        } while (a16 == null);
        return a16;
    }

    private static com.tencent.qmethod.pandoraex.api.v o(String str, String str2, String[] strArr, String str3) {
        com.tencent.qmethod.pandoraex.api.v vVar;
        if (strArr == null || strArr.length == 0) {
            strArr = f344168a;
        }
        for (int length = strArr.length - 1; length >= 0; length--) {
            com.tencent.qmethod.pandoraex.api.b a16 = f.a(str, str2, strArr[length]);
            if (a16 != null && (vVar = a16.f343880c.get(str3)) != null) {
                com.tencent.qmethod.pandoraex.api.v a17 = com.tencent.qmethod.pandoraex.api.v.a(vVar);
                if (a17.f343995f == 0) {
                    a17.f343995f = a16.f343885h;
                }
                return a17;
            }
        }
        return null;
    }

    public static String[] p() {
        String[] a16 = q.a();
        if (a16 == null || a16.length == 0) {
            String d16 = a.d();
            if (d16 == null) {
                d16 = "";
            }
            return new String[]{d16};
        }
        return a16;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String q(File file) {
        if (file == null) {
            return "";
        }
        DigestInputStream digestInputStream = null;
        try {
            try {
                DigestInputStream digestInputStream2 = new DigestInputStream(new FileInputStream(file), MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5));
                try {
                    do {
                    } while (digestInputStream2.read(new byte[262144]) > 0);
                    String b16 = b(digestInputStream2.getMessageDigest().digest());
                    try {
                        digestInputStream2.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    return b16;
                } catch (IOException e17) {
                    e = e17;
                    digestInputStream = digestInputStream2;
                    e.printStackTrace();
                    if (digestInputStream != null) {
                        try {
                            digestInputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    return "";
                } catch (NoSuchAlgorithmException e19) {
                    e = e19;
                    digestInputStream = digestInputStream2;
                    e.printStackTrace();
                    if (digestInputStream != null) {
                    }
                    return "";
                } catch (Throwable th5) {
                    th = th5;
                    digestInputStream = digestInputStream2;
                    if (digestInputStream != null) {
                        try {
                            digestInputStream.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e27) {
                e = e27;
            } catch (NoSuchAlgorithmException e28) {
                e = e28;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static com.tencent.qmethod.pandoraex.api.t r(vr3.b bVar) {
        Throwable th5 = new Throwable(bVar.f443242a + ":" + bVar.f443243b);
        return new com.tencent.qmethod.pandoraex.api.t(th5, M(th5, 4, 25), 1);
    }

    public static com.tencent.qmethod.pandoraex.api.v s(vr3.b bVar) {
        com.tencent.qmethod.pandoraex.api.v m3 = m(bVar.f443242a, bVar.f443243b, bVar.f443256o, bVar.f443244c);
        if (m3 != null) {
            return m3;
        }
        com.tencent.qmethod.pandoraex.api.b n3 = n(bVar.f443242a, bVar.f443243b, bVar.f443256o);
        com.tencent.qmethod.pandoraex.api.v vVar = new com.tencent.qmethod.pandoraex.api.v(bVar.f443244c, "normal");
        if (n3 != null) {
            vVar.f343995f = n3.f343885h;
        }
        return vVar;
    }

    private static com.tencent.qmethod.pandoraex.api.v t(String str, String str2, vr3.b bVar, com.tencent.qmethod.pandoraex.api.v vVar) {
        if ("high_freq".equals(bVar.f443244c) && !j.e(vVar, bVar)) {
            bVar.f443244c = "normal";
            return s(bVar);
        }
        return vVar;
    }

    public static boolean u() {
        return s.b();
    }

    public static boolean v(vr3.b bVar) {
        if (bVar.f443266y == 0) {
            return true;
        }
        return false;
    }

    public static boolean w() {
        List<ActivityManager.RunningAppProcessInfo> list;
        com.tencent.qmethod.pandoraex.api.f a16 = com.tencent.qmethod.pandoraex.api.q.a();
        if (a16 != null) {
            return a16.d();
        }
        Context b16 = com.tencent.qmethod.pandoraex.api.q.b();
        boolean z16 = false;
        if (b16 == null) {
            o.c("Utils", "[isAppOnForeground] = false, context is null!");
            return false;
        }
        try {
            list = SystemMethodProxy.getRunningAppProcesses((ActivityManager) b16.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        } catch (Throwable th5) {
            o.d("Utils", "[isAppOnForeground] err: ", th5);
            list = null;
        }
        if (list == null) {
            o.c("Utils", "[isAppOnForeground] = false");
            return false;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (D(it.next())) {
                z16 = true;
                break;
            }
        }
        o.c("Utils", "[isAppOnForeground] = " + z16);
        return z16;
    }

    public static boolean x(String str) {
        if (!QQPermissionConstants.Permission.STORAGE_GROUP.equals(str) && !"memory".equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean y(com.tencent.qmethod.pandoraex.api.d dVar) {
        if (("memory".equals(dVar.f343900a) && dVar.f343901b) || "normal".equals(dVar.f343900a)) {
            return true;
        }
        return false;
    }

    private static boolean z(Set<String> set, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && set.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
