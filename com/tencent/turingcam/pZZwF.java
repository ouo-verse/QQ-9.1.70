package com.tencent.turingcam;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.av.so.ResInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingcam.oqKCa;
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
public class pZZwF {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Set<String> f382337a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f382338b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set<String> f382339c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12125);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        HashSet hashSet = new HashSet();
        f382337a = hashSet;
        f382338b = new String[0];
        hashSet.add(LwgsO.a(LwgsO.M));
        hashSet.add(LwgsO.a(LwgsO.N));
        hashSet.add(LwgsO.a(LwgsO.O));
        hashSet.add(LwgsO.a(LwgsO.P));
        hashSet.add(LwgsO.a(LwgsO.Q));
        hashSet.add(LwgsO.a(LwgsO.R));
        hashSet.add(LwgsO.a(LwgsO.S));
        hashSet.add(LwgsO.a(LwgsO.T));
        hashSet.add(LwgsO.a(LwgsO.U));
        hashSet.add(LwgsO.a(LwgsO.V));
        hashSet.add(LwgsO.a(LwgsO.W));
        hashSet.add(LwgsO.a(LwgsO.X));
        HashSet hashSet2 = new HashSet();
        f382339c = hashSet2;
        hashSet2.add(LwgsO.a(LwgsO.L));
    }

    public static List<ZwVTT> a() {
        boolean z16;
        boolean z17;
        oqKCa.spXPg b16;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String[] list = new File("/proc").list();
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        char charAt = str.charAt(0);
                        if (charAt <= '9' && charAt >= '0' && (b16 = oqKCa.b(Integer.parseInt(str))) != null) {
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
            oqKCa.spXPg spxpg = (oqKCa.spXPg) it.next();
            if (myPid == spxpg.f382330a) {
                i3 = spxpg.f382334e;
            }
        }
        if (i3 != 0 && myPid != i3) {
            Iterator it5 = arrayList2.iterator();
            String str2 = "";
            while (it5.hasNext()) {
                oqKCa.spXPg spxpg2 = (oqKCa.spXPg) it5.next();
                if (i3 == spxpg2.f382330a) {
                    str2 = spxpg2.f382333d;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                ZwVTT zwVTT = new ZwVTT();
                zwVTT.f382125a = CRchv.f381744a + CRchv.f381748e;
                zwVTT.f382126b = str2;
                arrayList3.add(zwVTT);
            }
        }
        arrayList.addAll(arrayList3);
        StringBuilder sb5 = new StringBuilder();
        ArrayList arrayList4 = new ArrayList();
        Iterator it6 = arrayList2.iterator();
        while (it6.hasNext()) {
            oqKCa.spXPg spxpg3 = (oqKCa.spXPg) it6.next();
            Iterator it7 = ((HashSet) f382337a).iterator();
            while (it7.hasNext()) {
                if (spxpg3.f382333d.contains((String) it7.next())) {
                    sb5.append(spxpg3.f382333d);
                    sb5.append("_");
                }
            }
        }
        String sb6 = sb5.toString();
        if (!TextUtils.isEmpty(sb6)) {
            ZwVTT zwVTT2 = new ZwVTT();
            zwVTT2.f382125a = CRchv.f381744a + CRchv.f381746c;
            zwVTT2.f382126b = sb6.substring(0, sb6.length() - 1);
            arrayList4.add(zwVTT2);
        }
        arrayList.addAll(arrayList4);
        ArrayList arrayList5 = new ArrayList();
        StringBuilder sb7 = new StringBuilder();
        HashSet hashSet = new HashSet();
        Iterator it8 = arrayList2.iterator();
        int i16 = 0;
        while (it8.hasNext()) {
            oqKCa.spXPg spxpg4 = (oqKCa.spXPg) it8.next();
            if (spxpg4.f382332c == 0 && spxpg4.f382333d.startsWith("/") && !spxpg4.f382333d.startsWith("/system") && !spxpg4.f382333d.startsWith("/dev") && !spxpg4.f382333d.startsWith("/sbin") && !spxpg4.f382333d.startsWith("/init") && !spxpg4.f382333d.startsWith("/vendor") && !spxpg4.f382333d.startsWith("/bin") && !spxpg4.f382333d.startsWith("/usr") && !spxpg4.f382333d.contains("kinguser") && !spxpg4.f382333d.endsWith(ResInfo.RES_TYPE_SO)) {
                Iterator it9 = ((HashSet) f382337a).iterator();
                while (true) {
                    if (!it9.hasNext()) {
                        z16 = false;
                        break;
                    }
                    if (spxpg4.f382333d.contains((String) it9.next())) {
                        z16 = true;
                        break;
                    }
                }
                if (z16) {
                    continue;
                } else {
                    Iterator it10 = ((HashSet) f382339c).iterator();
                    while (true) {
                        if (!it10.hasNext()) {
                            z17 = false;
                            break;
                        }
                        if (spxpg4.f382333d.contains((String) it10.next())) {
                            z17 = true;
                            break;
                        }
                    }
                    if (z17) {
                        continue;
                    } else {
                        hashSet.add(spxpg4.f382333d);
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
            ZwVTT zwVTT3 = new ZwVTT();
            zwVTT3.f382125a = CRchv.f381744a + CRchv.f381747d;
            zwVTT3.f382126b = sb8.substring(0, sb8.length() - 1);
            arrayList5.add(zwVTT3);
        }
        arrayList.addAll(arrayList5);
        return arrayList;
    }

    public static String b() {
        StringBuffer stringBuffer = new StringBuffer();
        String a16 = a(LwgsO.a(LwgsO.f381924o0), LwgsO.a(LwgsO.C0), "v4");
        if (!TextUtils.isEmpty(a16)) {
            stringBuffer.append(a16);
        }
        String a17 = a(LwgsO.a(LwgsO.f381926p0), "(.{32}:.{3,4})\\s(.{32}:.{3,4})\\s(.{2})\\s.{8}:.{8}\\s.{2}:.{8}\\s.{8}\\s+(.{4,5})", "v6");
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
            String str4 = new String(F2BEC.a(str));
            if (TextUtils.isEmpty(str4)) {
                strArr = f382338b;
            } else {
                strArr = str4.split("\n");
                if (strArr == null || strArr.length == 0) {
                    strArr = f382338b;
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
