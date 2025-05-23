package com.tencent.turingcam;

import android.content.Context;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.turingcam.F2BEC;
import cooperation.qzone.patch.QZonePatchService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes27.dex */
public class V124r {
    public static String a(Context context) {
        BufferedReader bufferedReader;
        int i3;
        System.currentTimeMillis();
        HashSet hashSet = new HashSet();
        try {
            String packageName = context.getPackageName();
            Pattern compile = Pattern.compile("^/data/user/\\d+/" + packageName);
            String str = context.getApplicationInfo().nativeLibraryDir;
            bufferedReader = new BufferedReader(new FileReader(LwgsO.a(LwgsO.f381920n)));
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
        HDnuc.a(bufferedReader);
        Pattern[] a17 = A48DB.a();
        Iterator it = hashSet.iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            int length = a17.length;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (a17[i3].matcher(str2).find()) {
                    it.remove();
                    break;
                }
                i3++;
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
            File file = new File(str5 + RFixConstants.SO_PATH);
            HashMap<String, F2BEC.spXPg> hashMap = F2BEC.f381816a;
            try {
                str4 = file.getCanonicalPath();
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
