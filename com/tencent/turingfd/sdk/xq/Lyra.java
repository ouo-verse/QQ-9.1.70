package com.tencent.turingfd.sdk.xq;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.av.so.ResInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingfd.sdk.xq.Casaba;
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
/* loaded from: classes27.dex */
public class Lyra {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Set<String> f382885a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f382886b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set<String> f382887c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12040);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        HashSet hashSet = new HashSet();
        f382885a = hashSet;
        f382886b = new String[0];
        hashSet.add(Ccontinue.a(Ccontinue.M));
        hashSet.add(Ccontinue.a(Ccontinue.N));
        hashSet.add(Ccontinue.a(Ccontinue.O));
        hashSet.add(Ccontinue.a(Ccontinue.P));
        hashSet.add(Ccontinue.a(Ccontinue.Q));
        hashSet.add(Ccontinue.a(Ccontinue.R));
        hashSet.add(Ccontinue.a(Ccontinue.S));
        hashSet.add(Ccontinue.a(Ccontinue.T));
        hashSet.add(Ccontinue.a(Ccontinue.U));
        hashSet.add(Ccontinue.a(Ccontinue.V));
        hashSet.add(Ccontinue.a(Ccontinue.W));
        hashSet.add(Ccontinue.a(Ccontinue.X));
        HashSet hashSet2 = new HashSet();
        f382887c = hashSet2;
        hashSet2.add(Ccontinue.a(Ccontinue.L));
    }

    public static List<Cpackage> a() {
        boolean z16;
        boolean z17;
        Casaba.Cdo b16;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String[] list = new File("/proc").list();
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        char charAt = str.charAt(0);
                        if (charAt <= '9' && charAt >= '0' && (b16 = Casaba.b(Integer.parseInt(str))) != null) {
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
            Casaba.Cdo cdo = (Casaba.Cdo) it.next();
            if (myPid == cdo.f382637a) {
                i3 = cdo.f382641e;
            }
        }
        if (i3 != 0 && myPid != i3) {
            Iterator it5 = arrayList2.iterator();
            String str2 = "";
            while (it5.hasNext()) {
                Casaba.Cdo cdo2 = (Casaba.Cdo) it5.next();
                if (i3 == cdo2.f382637a) {
                    str2 = cdo2.f382640d;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                Cpackage cpackage = new Cpackage();
                cpackage.f383413a = Sugarcane.f383105a + Sugarcane.f383109e;
                cpackage.f383414b = str2;
                arrayList3.add(cpackage);
            }
        }
        arrayList.addAll(arrayList3);
        StringBuilder sb5 = new StringBuilder();
        ArrayList arrayList4 = new ArrayList();
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            Casaba.Cdo cdo3 = (Casaba.Cdo) it6.next();
            Iterator it7 = ((HashSet) f382885a).iterator();
            while (it7.hasNext()) {
                if (cdo3.f382640d.contains((String) it7.next())) {
                    sb5.append(cdo3.f382640d);
                    sb5.append("_");
                }
            }
        }
        String sb6 = sb5.toString();
        if (!TextUtils.isEmpty(sb6)) {
            Cpackage cpackage2 = new Cpackage();
            cpackage2.f383413a = Sugarcane.f383105a + Sugarcane.f383107c;
            cpackage2.f383414b = sb6.substring(0, sb6.length() - 1);
            arrayList4.add(cpackage2);
        }
        arrayList.addAll(arrayList4);
        ArrayList arrayList5 = new ArrayList();
        StringBuilder sb7 = new StringBuilder();
        HashSet hashSet = new HashSet();
        Iterator it8 = arrayList2.iterator();
        int i16 = 0;
        while (it8.hasNext()) {
            Casaba.Cdo cdo4 = (Casaba.Cdo) it8.next();
            if (cdo4.f382639c == 0 && cdo4.f382640d.startsWith("/") && !cdo4.f382640d.startsWith("/system") && !cdo4.f382640d.startsWith("/dev") && !cdo4.f382640d.startsWith("/sbin") && !cdo4.f382640d.startsWith("/init") && !cdo4.f382640d.startsWith("/vendor") && !cdo4.f382640d.startsWith("/bin") && !cdo4.f382640d.startsWith("/usr") && !cdo4.f382640d.contains("kinguser") && !cdo4.f382640d.endsWith(ResInfo.RES_TYPE_SO)) {
                Iterator it9 = ((HashSet) f382885a).iterator();
                while (true) {
                    if (!it9.hasNext()) {
                        z16 = false;
                        break;
                    }
                    if (cdo4.f382640d.contains((String) it9.next())) {
                        z16 = true;
                        break;
                    }
                }
                if (z16) {
                    continue;
                } else {
                    Iterator it10 = ((HashSet) f382887c).iterator();
                    while (true) {
                        if (!it10.hasNext()) {
                            z17 = false;
                            break;
                        }
                        if (cdo4.f382640d.contains((String) it10.next())) {
                            z17 = true;
                            break;
                        }
                    }
                    if (z17) {
                        continue;
                    } else {
                        hashSet.add(cdo4.f382640d);
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
            Cpackage cpackage3 = new Cpackage();
            cpackage3.f383413a = Sugarcane.f383105a + Sugarcane.f383108d;
            cpackage3.f383414b = sb8.substring(0, sb8.length() - 1);
            arrayList5.add(cpackage3);
        }
        arrayList.addAll(arrayList5);
        return arrayList;
    }

    public static String b() {
        StringBuffer stringBuffer = new StringBuffer();
        String a16 = a(Ccontinue.a(Ccontinue.f383291o0), Ccontinue.a(Ccontinue.C0), "v4");
        if (!TextUtils.isEmpty(a16)) {
            stringBuffer.append(a16);
        }
        String a17 = a(Ccontinue.a(Ccontinue.f383293p0), "(.{32}:.{3,4})\\s(.{32}:.{3,4})\\s(.{2})\\s.{8}:.{8}\\s.{2}:.{8}\\s.{8}\\s+(.{4,5})", "v6");
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
            String str4 = new String(Csynchronized.a(str));
            if (TextUtils.isEmpty(str4)) {
                strArr = f382886b;
            } else {
                strArr = str4.split("\n");
                if (strArr == null || strArr.length == 0) {
                    strArr = f382886b;
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
