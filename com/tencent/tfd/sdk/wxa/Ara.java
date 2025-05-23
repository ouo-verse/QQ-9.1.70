package com.tencent.tfd.sdk.wxa;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.av.so.ResInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tfd.sdk.wxa.Norma;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Ara {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Set<String> f375402a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f375403b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set<String> f375404c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62370);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        HashSet hashSet = new HashSet();
        f375402a = hashSet;
        f375403b = new String[0];
        hashSet.add(Cswitch.a(Cswitch.M));
        hashSet.add(Cswitch.a(Cswitch.N));
        hashSet.add(Cswitch.a(Cswitch.O));
        hashSet.add(Cswitch.a(Cswitch.P));
        hashSet.add(Cswitch.a(Cswitch.Q));
        hashSet.add(Cswitch.a(Cswitch.R));
        hashSet.add(Cswitch.a(Cswitch.S));
        hashSet.add(Cswitch.a(Cswitch.T));
        hashSet.add(Cswitch.a(Cswitch.U));
        hashSet.add(Cswitch.a(Cswitch.V));
        hashSet.add(Cswitch.a(Cswitch.W));
        hashSet.add(Cswitch.a(Cswitch.X));
        HashSet hashSet2 = new HashSet();
        f375404c = hashSet2;
        hashSet2.add(Cswitch.a(Cswitch.L));
    }

    /* JADX WARN: Type inference failed for: r7v11, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r9v21, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r9v25, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
    public static List<Cpublic> a() {
        boolean z16;
        boolean z17;
        Norma.Cdo b16;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String[] list = new File("/proc").list();
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        char charAt = str.charAt(0);
                        if (charAt <= '9' && charAt >= '0' && (b16 = Norma.b(Integer.parseInt(str))) != null) {
                            arrayList2.add(b16);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int myPid = Process.myPid();
        Iterator it = arrayList2.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Norma.Cdo cdo = (Norma.Cdo) it.next();
            if (myPid == cdo.f375655a) {
                i3 = cdo.f375659e;
            }
        }
        if (i3 != 0 && myPid != i3) {
            Iterator it5 = arrayList2.iterator();
            String str2 = "";
            while (it5.hasNext()) {
                Norma.Cdo cdo2 = (Norma.Cdo) it5.next();
                if (i3 == cdo2.f375655a) {
                    str2 = cdo2.f375658d;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                Cpublic cpublic = new Cpublic();
                cpublic.f375769a = Bullace.f375484a + Bullace.f375488e;
                cpublic.f375770b = str2;
                arrayList3.add(cpublic);
            }
        }
        arrayList.addAll(arrayList3);
        StringBuilder sb5 = new StringBuilder();
        ArrayList arrayList4 = new ArrayList();
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            Norma.Cdo cdo3 = (Norma.Cdo) it6.next();
            Iterator it7 = f375402a.iterator();
            while (it7.hasNext()) {
                if (cdo3.f375658d.contains((String) it7.next())) {
                    sb5.append(cdo3.f375658d);
                    sb5.append("_");
                }
            }
        }
        String sb6 = sb5.toString();
        if (!TextUtils.isEmpty(sb6)) {
            Cpublic cpublic2 = new Cpublic();
            cpublic2.f375769a = Bullace.f375484a + Bullace.f375486c;
            cpublic2.f375770b = sb6.substring(0, sb6.length() - 1);
            arrayList4.add(cpublic2);
        }
        arrayList.addAll(arrayList4);
        ArrayList arrayList5 = new ArrayList();
        StringBuilder sb7 = new StringBuilder();
        HashSet hashSet = new HashSet();
        Iterator it8 = arrayList2.iterator();
        int i16 = 0;
        while (it8.hasNext()) {
            Norma.Cdo cdo4 = (Norma.Cdo) it8.next();
            if (cdo4.f375657c == 0 && cdo4.f375658d.startsWith("/") && !cdo4.f375658d.startsWith("/system") && !cdo4.f375658d.startsWith("/dev") && !cdo4.f375658d.startsWith("/sbin") && !cdo4.f375658d.startsWith("/init") && !cdo4.f375658d.startsWith("/vendor") && !cdo4.f375658d.startsWith("/bin") && !cdo4.f375658d.startsWith("/usr") && !cdo4.f375658d.contains("kinguser") && !cdo4.f375658d.endsWith(ResInfo.RES_TYPE_SO)) {
                Iterator it9 = f375402a.iterator();
                while (true) {
                    if (!it9.hasNext()) {
                        z16 = false;
                        break;
                    }
                    if (cdo4.f375658d.contains((String) it9.next())) {
                        z16 = true;
                        break;
                    }
                }
                if (z16) {
                    continue;
                } else {
                    Iterator it10 = f375404c.iterator();
                    while (true) {
                        if (!it10.hasNext()) {
                            z17 = false;
                            break;
                        }
                        if (cdo4.f375658d.contains((String) it10.next())) {
                            z17 = true;
                            break;
                        }
                    }
                    if (z17) {
                        continue;
                    } else {
                        hashSet.add(cdo4.f375658d);
                        int i17 = i16 + 1;
                        if (i16 >= 8) {
                            break;
                        }
                        i16 = i17;
                    }
                }
            }
        }
        if (hashSet.size() > 0) {
            Iterator it11 = hashSet.iterator();
            while (it11.hasNext()) {
                sb7.append((String) it11.next());
                sb7.append("%3B");
            }
            String sb8 = sb7.toString();
            Cpublic cpublic3 = new Cpublic();
            cpublic3.f375769a = Bullace.f375484a + Bullace.f375487d;
            cpublic3.f375770b = sb8.substring(0, sb8.length() - 1);
            arrayList5.add(cpublic3);
        }
        arrayList.addAll(arrayList5);
        return arrayList;
    }

    public static String b() {
        StringBuffer stringBuffer = new StringBuffer();
        String a16 = a(Cswitch.a(Cswitch.f375812o0), Cswitch.a(Cswitch.C0), "v4");
        if (!TextUtils.isEmpty(a16)) {
            stringBuffer.append(a16);
        }
        String a17 = a(Cswitch.a(Cswitch.f375814p0), "(.{32}:.{3,4})\\s(.{32}:.{3,4})\\s(.{2})\\s.{8}:.{8}\\s.{2}:.{8}\\s.{8}\\s+(.{4,5})", "v6");
        if (!TextUtils.isEmpty(a17)) {
            if (!TextUtils.isEmpty(a16)) {
                stringBuffer.append("_");
            }
            stringBuffer.append(a17);
        }
        return stringBuffer.toString();
    }

    public static String a(String str, String str2, String str3) {
        String[] strArr;
        String[] split;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String str4 = new String(Cextends.a(str));
            if (TextUtils.isEmpty(str4)) {
                strArr = f375403b;
            } else {
                strArr = str4.split("\n");
                if (strArr == null || strArr.length == 0) {
                    strArr = f375403b;
                }
            }
        } catch (Throwable unused) {
            strArr = null;
        }
        if (strArr == null) {
            stringBuffer.append(str3 + ";-1");
            return stringBuffer.toString();
        }
        stringBuffer.append(str3 + ";0");
        new HashMap();
        HashMap hashMap = new HashMap();
        Pattern compile = Pattern.compile(str2);
        for (String str5 : strArr) {
            Matcher matcher = compile.matcher(str5);
            if (matcher.find()) {
                String trim = matcher.group(4).trim();
                if ("0A".equals(matcher.group(3)) && (split = matcher.group(1).split(":")) != null && split.length >= 2) {
                    hashMap.put(split[1], trim);
                }
            }
        }
        if (!hashMap.isEmpty()) {
            stringBuffer.append(";");
            Iterator it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                String str6 = (String) it.next();
                stringBuffer.append((String) hashMap.get(str6));
                stringBuffer.append(":");
                stringBuffer.append(str6);
                if (it.hasNext()) {
                    stringBuffer.append(",");
                }
            }
        }
        return stringBuffer.toString();
    }
}
