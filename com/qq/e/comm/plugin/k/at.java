package com.qq.e.comm.plugin.k;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.SharedPreferencedUtil;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class at {
    public static File a() {
        return k.c();
    }

    public static File b() {
        return k.d();
    }

    public static File c(String str, boolean z16) {
        return k.c(str, z16);
    }

    private static void d(String str, boolean z16) {
        File[] listFiles;
        File a16 = a(str);
        if (!a16.exists() || (listFiles = a16.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        long j3 = 0;
        for (File file : listFiles) {
            if (file != null && ((z16 || !file.getName().equals("hotStart")) && !file.getName().equals("preload") && file.lastModified() > j3)) {
                j3 = file.lastModified();
            }
        }
        for (File file2 : listFiles) {
            if (file2 != null && ((z16 || !file2.getName().equals("hotStart")) && !file2.getName().equals("preload"))) {
                Date date = new Date(file2.lastModified());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
                String format = simpleDateFormat.format(date);
                if (d(format, simpleDateFormat.format(new Date(j3)))) {
                    GDTLogger.e("\u5220\u9664\u8fc7\u671f\u6587\u4ef6\uff1a" + file2.getName());
                    GDTLogger.e("\u6587\u4ef6\u4fee\u6539\u65f6\u95f4\uff1a" + format);
                    b(file2);
                }
            }
        }
    }

    public static File a(String str) {
        return k.a(str);
    }

    public static long b(String str, boolean z16) {
        return k.b(str, z16);
    }

    public static String c(String str) {
        return k.c(str);
    }

    public static File a(String str, boolean z16) {
        return k.a(str, z16);
    }

    public static File b(String str, String str2) {
        return k.b(str, str2);
    }

    public static String c(String str, String str2) {
        return k.c(str, str2);
    }

    public static File a(int i3, String str, String str2) {
        return k.a(i3, str, str2);
    }

    public static File b(String str) {
        return k.b(str);
    }

    public static boolean c() {
        return k.e();
    }

    public static File a(String str, String str2) {
        return k.a(str, str2);
    }

    public static void b(File file) {
        k.b(file);
    }

    public static String c(File file) {
        return k.c(file);
    }

    public static void a(String str, String[] strArr, boolean z16) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length != 0) {
            File a16 = a(str);
            if (a16 == null || !a16.isDirectory()) {
                return;
            }
            File[] listFiles = a16.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file : listFiles) {
                    if (file != null && ((z16 || !file.getName().equals("hotStart")) && !file.getName().equals("preload"))) {
                        if (file.isDirectory()) {
                            GDTLogger.d("\u6587\u4ef6\u5939\uff1a" + file.getName());
                            a(file, strArr);
                        } else {
                            boolean z17 = false;
                            for (String str2 : strArr) {
                                if (file.getName().equals(str2)) {
                                    z17 = true;
                                }
                            }
                            if (!z17) {
                                GDTLogger.e("\u5220\u9664\u6587\u4ef6\uff1a" + a16.getName() + " ," + file.getName());
                                file.delete();
                            }
                        }
                    }
                }
                return;
            }
            GDTLogger.e("\u78c1\u76d8\u68c0\u6d4bposId\u6587\u4ef6\u5939\u5185\u6ca1\u6709\u6587\u4ef6");
            return;
        }
        GDTLogger.e("\u78c1\u76d8\u68c0\u6d4b\u53c2\u6570\u9519\u8bef");
    }

    public static boolean b(com.qq.e.comm.plugin.base.ad.b bVar, String str, String str2, String str3, boolean z16) {
        return a(bVar, str, str2, str3, ai.c(k.c(str2, z16)), z16);
    }

    private static void d() {
        File[] listFiles;
        File b16 = b();
        if (!b16.exists() || (listFiles = b16.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        long j3 = 0;
        for (File file : listFiles) {
            if (file != null && file.lastModified() > j3) {
                j3 = file.lastModified();
            }
        }
        for (File file2 : listFiles) {
            if (file2 != null) {
                Date date = new Date(file2.lastModified());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
                String format = simpleDateFormat.format(date);
                if (d(format, simpleDateFormat.format(new Date(j3)))) {
                    GDTLogger.e("\u5220\u9664\u8fc7\u671f\u6587\u4ef6\uff1a" + file2.getName());
                    GDTLogger.e("\u6587\u4ef6\u4fee\u6539\u65f6\u95f4\uff1a" + format);
                    b(file2);
                }
            }
        }
    }

    public static void a(File file, String[] strArr) {
        File[] listFiles;
        if (file == null || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2 != null && !file2.getName().equals("preload")) {
                if (file2.isDirectory()) {
                    a(file2, strArr);
                } else {
                    boolean z16 = false;
                    for (String str : strArr) {
                        if (file2.getName().equals(str)) {
                            z16 = true;
                        }
                    }
                    if (!z16) {
                        GDTLogger.e("\u5220\u9664\u6587\u4ef6\uff1a" + file.getName() + " ," + file2.getName());
                        file2.delete();
                    }
                }
            }
        }
    }

    public static long a(File file) {
        return k.a(file);
    }

    public static boolean a(com.qq.e.comm.plugin.base.ad.b bVar, String str, String str2, String str3, boolean z16) {
        d(str2, z16);
        d();
        if (c()) {
            return b(bVar, str, str2, str3, z16);
        }
        return true;
    }

    private static boolean a(com.qq.e.comm.plugin.base.ad.b bVar, String str, String str2, String str3, String str4, boolean z16) {
        JSONArray jSONArray;
        String a16;
        if (TextUtils.isEmpty(str4)) {
            return true;
        }
        try {
            jSONArray = new JSONArray(str4);
        } catch (JSONException e16) {
            GDTLogger.e("TangramPluginFileUtil", e16);
            jSONArray = null;
        }
        if (jSONArray == null || jSONArray.length() == 0) {
            return true;
        }
        String[] strArr = new String[jSONArray.length()];
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            com.qq.e.comm.plugin.base.ad.model.r rVar = new com.qq.e.comm.plugin.base.ad.model.r(str, str2, str3, bVar);
            rVar.e(optJSONObject);
            if (SharedPreferencedUtil.getInt(rVar.bn(), -1) != -1) {
                SharedPreferencedUtil.putInt(rVar.bn(), rVar.bc());
            }
            if (TextUtils.isEmpty(rVar.bt())) {
                if (rVar.w() == 1) {
                    a16 = ai.a(rVar.x());
                } else {
                    a16 = ai.a(rVar.h());
                }
            } else {
                a16 = ai.a(rVar.bt());
            }
            if (!TextUtils.isEmpty(a16)) {
                strArr[i3] = a16;
            }
        }
        GDTLogger.d("\u4e0a\u6b21\u9884\u52a0\u8f7d\u7d20\u6750\uff1a" + str2 + Arrays.toString(strArr));
        a(str2, strArr, z16);
        return false;
    }

    private static boolean d(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.trim().split("-");
            if (split.length >= 3) {
                String[] split2 = str2.trim().split("-");
                if (split2.length >= 3) {
                    String str3 = split2[0];
                    String str4 = split2[1];
                    String str5 = split2[2];
                    String str6 = split[0];
                    String str7 = split[1];
                    String str8 = split[2];
                    if (Integer.parseInt(str3) > Integer.parseInt(str6) || Integer.parseInt(str4) > Integer.parseInt(str7)) {
                        return true;
                    }
                    if (Integer.parseInt(str5) - Integer.parseInt(str8) > GDTADManager.getInstance().getSM().getInteger("adnetDirExpiredDays", 3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean d(File file) {
        return k.e(file);
    }

    public static void a(File file, String str) {
        k.a(file, str);
    }
}
