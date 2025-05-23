package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import com.tencent.rfix.loader.utils.RFixConstants;
import cooperation.qzone.patch.QZonePatchService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Andromeda {
    public static String a(Context context) {
        BufferedReader bufferedReader;
        int i3;
        Pattern[] patternArr;
        System.currentTimeMillis();
        HashSet hashSet = new HashSet();
        try {
            String packageName = context.getPackageName();
            Pattern compile = Pattern.compile("^/data/user/\\d+/" + packageName);
            String str = context.getApplicationInfo().nativeLibraryDir;
            bufferedReader = new BufferedReader(new FileReader(Cswitch.a(Cswitch.f375809n)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String a16 = a(readLine, packageName, compile, str);
                    if (a16 != null) {
                        hashSet.add(a16);
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        Cvolatile.a(bufferedReader);
        String[] strArr = Perseus.f375662a;
        synchronized (Perseus.class) {
            i3 = 0;
            if (Perseus.f375663b != null) {
                patternArr = Perseus.f375663b;
            } else {
                String[] strArr2 = Perseus.f375662a;
                Perseus.f375663b = new Pattern[strArr2.length];
                ArrayList arrayList = new ArrayList();
                for (int i16 = 0; i16 < Perseus.f375663b.length; i16++) {
                    try {
                        arrayList.add(Pattern.compile(strArr2[i16]));
                    } catch (Throwable unused3) {
                    }
                }
                Perseus.f375663b = (Pattern[]) arrayList.toArray(new Pattern[0]);
                patternArr = Perseus.f375663b;
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            int length = patternArr.length;
            int i17 = 0;
            while (true) {
                if (i17 >= length) {
                    break;
                }
                if (patternArr[i17].matcher(str2).find()) {
                    it.remove();
                    break;
                }
                i17++;
            }
        }
        if (hashSet.size() <= 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator it5 = hashSet.iterator();
        while (it5.hasNext()) {
            i3++;
            sb5.append((String) it5.next());
            if (i3 >= 8) {
                break;
            }
            if (it5.hasNext()) {
                sb5.append("_");
            }
        }
        return sb5.toString();
    }

    public static String a() {
        try {
            File file = new File("/system/lib");
            if (file.canRead()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getName().contains("rockchip")) {
                        return file2.getAbsolutePath();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String a(String str, String str2, Pattern pattern, String str3) {
        int indexOf;
        String str4;
        boolean endsWith = str.endsWith(".so");
        boolean z16 = !endsWith && str.endsWith(QZonePatchService.PATCH_SUFFIX);
        if ((!endsWith && !z16) || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        String trim = str.substring(indexOf).trim();
        if (!trim.startsWith("/data/")) {
            return null;
        }
        if (endsWith && str3 != null && trim.startsWith(str3)) {
            return null;
        }
        String str5 = "/data/data/" + str2 + "/";
        if (trim.startsWith(str5)) {
            return null;
        }
        if (trim.startsWith("/data/app/" + str2) || pattern.matcher(trim).find()) {
            return null;
        }
        if (endsWith) {
            try {
                str4 = new File(str5 + RFixConstants.SO_PATH).getCanonicalPath();
            } catch (IOException unused) {
                str4 = null;
            }
            if (str4 == null || trim.startsWith(str4)) {
                return null;
            }
        }
        return trim;
    }
}
