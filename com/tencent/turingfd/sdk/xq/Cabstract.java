package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.abstract, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cabstract {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f383220a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f383221b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f383222c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f383223d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f383224e;

    /* renamed from: f, reason: collision with root package name */
    public static long f383225f;

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f383226g;

    /* compiled from: P */
    /* renamed from: com.tencent.turingfd.sdk.xq.abstract$do, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static class Cdo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f383227a;

        /* renamed from: b, reason: collision with root package name */
        public final String f383228b;

        public Cdo(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), str);
            } else {
                this.f383227a = z16;
                this.f383228b = str;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13409);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f383220a = Ccontinue.a(Ccontinue.f383252b);
        f383221b = Ccontinue.a(Ccontinue.f383255c);
        f383222c = Ccontinue.a(Ccontinue.f383258d);
        f383223d = Ccontinue.a(Ccontinue.f383261e);
        f383224e = Ccontinue.a(Ccontinue.f383264f);
        f383225f = 0L;
        f383226g = new String[]{"^/data/user/\\d+$", "^/data/data$"};
    }

    public static String a(Context context, String str) {
        String str2;
        long j3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("_");
        try {
            str2 = context.getPackageManager().getApplicationInfo(str, 0).sourceDir;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "";
        }
        try {
            sb5.append((String) ((ArrayList) Carambola.a(new File(str2))).get(0));
        } catch (Throwable unused2) {
            sb5.append("");
        }
        sb5.append("_");
        if (!TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (file.exists()) {
                j3 = file.length();
                sb5.append(j3);
                sb5.append("_");
                sb5.append(Process.myUid());
                return sb5.toString();
            }
        }
        j3 = -1;
        sb5.append(j3);
        sb5.append("_");
        sb5.append(Process.myUid());
        return sb5.toString();
    }

    public static String b(Context context) {
        Method method;
        try {
            Class<?> cls = Class.forName("android.os.UserManager");
            Field field = context.getClass().getField("USER_SERVICE");
            field.setAccessible(true);
            Object systemService = context.getSystemService((String) field.get(context));
            if (systemService == null || (method = cls.getMethod("getUserName", new Class[0])) == null) {
                return "";
            }
            method.setAccessible(true);
            return (String) method.invoke(systemService, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a() {
        try {
            return 999 == Process.myUid() / 100000;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(30:1|(1:3)(2:158|(1:160)(5:161|(1:(2:163|(2:166|167)(1:165))(2:187|188))|168|(2:180|(1:186))(1:174)|(1:179)(1:178)))|4|(1:157)(1:8)|9|(1:11)(11:90|91|92|93|94|(3:95|96|(3:98|(3:138|139|140)(3:100|101|(3:106|107|(1:112)(2:109|110)))|111)(2:141|142))|114|115|(2:119|(4:121|(1:129)|125|(1:127)(1:128)))|130|(0)(0))|12|(1:14)|15|(1:16)|(2:60|(19:62|(18:64|28|29|(1:31)|32|33|34|(1:36)|37|(1:39)(1:53)|40|(1:42)|(1:44)|45|(2:48|46)|49|50|51)|59|29|(0)|32|33|34|(0)|37|(0)(0)|40|(0)|(0)|45|(1:46)|49|50|51)(2:65|(19:67|(18:69|28|29|(0)|32|33|34|(0)|37|(0)(0)|40|(0)|(0)|45|(1:46)|49|50|51)|59|29|(0)|32|33|34|(0)|37|(0)(0)|40|(0)|(0)|45|(1:46)|49|50|51)(2:70|(19:72|(18:74|28|29|(0)|32|33|34|(0)|37|(0)(0)|40|(0)|(0)|45|(1:46)|49|50|51)|59|29|(0)|32|33|34|(0)|37|(0)(0)|40|(0)|(0)|45|(1:46)|49|50|51)(2:75|(2:77|(18:79|28|29|(0)|32|33|34|(0)|37|(0)(0)|40|(0)|(0)|45|(1:46)|49|50|51)(19:80|(1:82)|59|29|(0)|32|33|34|(0)|37|(0)(0)|40|(0)|(0)|45|(1:46)|49|50|51))(19:83|(18:87|28|29|(0)|32|33|34|(0)|37|(0)(0)|40|(0)|(0)|45|(1:46)|49|50|51)|59|29|(0)|32|33|34|(0)|37|(0)(0)|40|(0)|(0)|45|(1:46)|49|50|51)))))(19:20|(2:24|(1:26)(1:58))|59|29|(0)|32|33|34|(0)|37|(0)(0)|40|(0)|(0)|45|(1:46)|49|50|51)|27|28|29|(0)|32|33|34|(0)|37|(0)(0)|40|(0)|(0)|45|(1:46)|49|50|51|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x013b, code lost:
    
        r13 = r0[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x032d, code lost:
    
        r11 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x03a0 A[LOOP:0: B:46:0x039a->B:48:0x03a0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0243  */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v41, types: [int] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v9, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x02d5 -> B:29:0x02d6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        boolean z16;
        Cdo cdo;
        boolean z17;
        int a16;
        FileReader fileReader;
        BufferedReader bufferedReader;
        String str;
        boolean z18;
        Cdo cdo2;
        int indexOf;
        String substring;
        String a17;
        boolean z19;
        int i3;
        StringBuilder sb5;
        int i16;
        Cdo cdo3;
        int a18;
        Iterator it;
        String str2;
        String str3;
        int myUid;
        StringBuilder sb6 = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        File parentFile = context.getApplicationContext().getFilesDir().getParentFile();
        if (parentFile == null) {
            cdo = new Cdo(false, "");
        } else {
            File parentFile2 = parentFile.getParentFile();
            if (parentFile2 == null) {
                cdo = new Cdo(false, "");
            } else {
                String[] strArr = f383226g;
                int length = strArr.length;
                int i17 = 0;
                while (true) {
                    if (i17 >= length) {
                        z16 = true;
                        break;
                    }
                    if (Pattern.compile(strArr[i17]).matcher(parentFile2.getAbsolutePath()).find()) {
                        z16 = false;
                        break;
                    }
                    i17++;
                }
                String absolutePath = parentFile.getAbsolutePath();
                String packageName = context.getPackageName();
                String[] split = absolutePath.split("/", 6);
                if (absolutePath.startsWith("/data/data/") && split.length >= 4 && !TextUtils.isEmpty(split[3])) {
                    packageName = split[3];
                } else if (absolutePath.startsWith("/data/user/") && split.length >= 5 && !TextUtils.isEmpty(split[4])) {
                    packageName = split[4];
                }
                if (z16 && !packageName.equals(context.getPackageName())) {
                    cdo = new Cdo(z16, a(context, packageName));
                } else {
                    cdo = new Cdo(z16, "");
                }
            }
        }
        if (cdo.f383227a && !TextUtils.isEmpty(cdo.f383228b)) {
            a16 = Cbreak.a(0, true, 0);
            Cpackage cpackage = new Cpackage();
            cpackage.f383413a = f383220a + f383222c;
            cpackage.f383414b = cdo.f383228b;
            arrayList.add(cpackage);
            z17 = false;
        } else {
            z17 = false;
            a16 = Cbreak.a(0, false, 0);
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            cdo2 = new Cdo(z17, "");
        } else {
            try {
                fileReader = new FileReader("/proc/self/maps");
            } catch (Throwable th5) {
                th = th5;
                fileReader = null;
            }
            try {
                bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            str = null;
                            break;
                        }
                        int indexOf2 = readLine.indexOf(47);
                        if (indexOf2 != -1) {
                            String trim = readLine.substring(indexOf2).trim();
                            if (trim.startsWith("/data/app/") && trim.endsWith("/base.odex")) {
                                String[] split2 = trim.split("/");
                                if (split2.length >= 7) {
                                    break;
                                }
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        try {
                            th.printStackTrace();
                            Eridanus.a(fileReader);
                            Eridanus.a(bufferedReader);
                            str = null;
                            String packageName2 = applicationContext.getPackageName();
                            if (!TextUtils.isEmpty(str)) {
                                substring = str.substring(0, indexOf);
                                if (!TextUtils.isEmpty(substring)) {
                                }
                            }
                            z18 = false;
                            if (!z18) {
                            }
                            ?? a19 = Cbreak.a(a16, cdo2.f383227a, 1);
                            if (cdo2.f383227a) {
                            }
                            ?? sb7 = new StringBuilder();
                            a17 = Ccontinue.a(Ccontinue.f383266f1);
                            try {
                                if (a17 == null) {
                                }
                                str3 = Build.BRAND;
                                if ("xiaomi".equalsIgnoreCase(str3)) {
                                }
                            } catch (Throwable unused) {
                            }
                        } finally {
                            Eridanus.a(fileReader);
                            Eridanus.a(bufferedReader);
                        }
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedReader = null;
                th.printStackTrace();
                Eridanus.a(fileReader);
                Eridanus.a(bufferedReader);
                str = null;
                String packageName22 = applicationContext.getPackageName();
                if (!TextUtils.isEmpty(str)) {
                }
                z18 = false;
                if (!z18) {
                }
                ?? a192 = Cbreak.a(a16, cdo2.f383227a, 1);
                if (cdo2.f383227a) {
                }
                ?? sb72 = new StringBuilder();
                a17 = Ccontinue.a(Ccontinue.f383266f1);
                if (a17 == null) {
                }
                str3 = Build.BRAND;
                if ("xiaomi".equalsIgnoreCase(str3)) {
                }
            }
            String packageName222 = applicationContext.getPackageName();
            if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf("-")) != -1) {
                substring = str.substring(0, indexOf);
                if (!TextUtils.isEmpty(substring)) {
                    File file = new File("/data/data/" + substring);
                    if (!file.exists() || !file.canWrite()) {
                        substring = packageName222;
                    }
                    z18 = !TextUtils.equals(packageName222, substring);
                    packageName222 = substring;
                    if (!z18) {
                        cdo2 = new Cdo(z18, a(context, packageName222));
                    } else {
                        cdo2 = new Cdo(z18, "");
                    }
                }
            }
            z18 = false;
            if (!z18) {
            }
        }
        ?? a1922 = Cbreak.a(a16, cdo2.f383227a, 1);
        if (cdo2.f383227a) {
            Cpackage cpackage2 = new Cpackage();
            cpackage2.f383413a = f383220a + f383223d;
            cpackage2.f383414b = cdo2.f383228b;
            arrayList.add(cpackage2);
        }
        ?? sb722 = new StringBuilder();
        a17 = Ccontinue.a(Ccontinue.f383266f1);
        if (a17 == null && a17.equalsIgnoreCase(Build.BRAND)) {
            String b16 = b(context);
            String str4 = new String(Base64.decode("5YiG6Lqr5bqU55So", 0));
            if (!TextUtils.isEmpty(b16) && str4.equals(b16)) {
                String a26 = Ccontinue.a(Ccontinue.f383269g1);
                if (a26 != null) {
                    sb722.append(a26);
                } else {
                    sb722.append("H");
                }
            }
            z19 = false;
            sb5 = sb722;
            i3 = a1922;
            Cdo cdo4 = new Cdo(z19, sb5.toString());
            sb722 = Cbreak.a(i3, cdo4.f383227a, 2);
            a1922 = cdo4.f383227a;
            if (a1922 != 0) {
            }
            new SparseArray();
            str2 = (String) Bagasse.a(TNative$aa.d89_A931D6BEC30CD812(new SparseArray(), context, 206), 206, String.class);
            int i18 = Plum.f383026a;
            if (str2 == null) {
            }
            i16 = Integer.parseInt(str2);
            if (i16 <= 0) {
            }
            a18 = Cbreak.a(sb722, cdo3.f383227a, 4);
            if (cdo3.f383227a) {
            }
            if (a18 > 0) {
            }
            f383225f = System.currentTimeMillis() - currentTimeMillis;
            it = arrayList.iterator();
            while (it.hasNext()) {
            }
            return sb6.toString();
        }
        str3 = Build.BRAND;
        if ("xiaomi".equalsIgnoreCase(str3)) {
            if (a()) {
                sb722.append("XiaoMi");
                z19 = true;
                sb5 = sb722;
                i3 = a1922;
                Cdo cdo42 = new Cdo(z19, sb5.toString());
                sb722 = Cbreak.a(i3, cdo42.f383227a, 2);
                a1922 = cdo42.f383227a;
                if (a1922 != 0) {
                    Cpackage cpackage3 = new Cpackage();
                    cpackage3.f383413a = f383220a + f383224e;
                    cpackage3.f383414b = cdo42.f383228b;
                    arrayList.add(cpackage3);
                }
                new SparseArray();
                str2 = (String) Bagasse.a(TNative$aa.d89_A931D6BEC30CD812(new SparseArray(), context, 206), 206, String.class);
                int i182 = Plum.f383026a;
                if (str2 == null) {
                    str2 = "";
                }
                i16 = Integer.parseInt(str2);
                if (i16 <= 0) {
                    cdo3 = new Cdo(true, "");
                } else {
                    cdo3 = new Cdo(false, "");
                }
                a18 = Cbreak.a(sb722, cdo3.f383227a, 4);
                if (cdo3.f383227a) {
                    Cpackage cpackage4 = new Cpackage();
                    cpackage4.f383413a = f383220a + "dual_e";
                    cpackage4.f383414b = cdo42.f383228b;
                    arrayList.add(cpackage4);
                }
                if (a18 > 0) {
                    Cpackage cpackage5 = new Cpackage();
                    cpackage5.f383413a = f383220a + f383221b;
                    cpackage5.f383414b = Sculptor.a("", a18);
                    arrayList.add(cpackage5);
                }
                f383225f = System.currentTimeMillis() - currentTimeMillis;
                it = arrayList.iterator();
                while (it.hasNext()) {
                    Cpackage cpackage6 = (Cpackage) it.next();
                    sb6.append(cpackage6.f383413a);
                    sb6.append(":");
                    sb6.append(cpackage6.f383414b);
                    sb6.append(",");
                }
                return sb6.toString();
            }
            z19 = false;
            sb5 = sb722;
            i3 = a1922;
            Cdo cdo422 = new Cdo(z19, sb5.toString());
            sb722 = Cbreak.a(i3, cdo422.f383227a, 2);
            a1922 = cdo422.f383227a;
            if (a1922 != 0) {
            }
            new SparseArray();
            str2 = (String) Bagasse.a(TNative$aa.d89_A931D6BEC30CD812(new SparseArray(), context, 206), 206, String.class);
            int i1822 = Plum.f383026a;
            if (str2 == null) {
            }
            i16 = Integer.parseInt(str2);
            if (i16 <= 0) {
            }
            a18 = Cbreak.a(sb722, cdo3.f383227a, 4);
            if (cdo3.f383227a) {
            }
            if (a18 > 0) {
            }
            f383225f = System.currentTimeMillis() - currentTimeMillis;
            it = arrayList.iterator();
            while (it.hasNext()) {
            }
            return sb6.toString();
        }
        if ("redmi".equalsIgnoreCase(str3)) {
            if (a()) {
                sb722.append("Redmi");
                z19 = true;
                sb5 = sb722;
                i3 = a1922;
                Cdo cdo4222 = new Cdo(z19, sb5.toString());
                sb722 = Cbreak.a(i3, cdo4222.f383227a, 2);
                a1922 = cdo4222.f383227a;
                if (a1922 != 0) {
                }
                new SparseArray();
                str2 = (String) Bagasse.a(TNative$aa.d89_A931D6BEC30CD812(new SparseArray(), context, 206), 206, String.class);
                int i18222 = Plum.f383026a;
                if (str2 == null) {
                }
                i16 = Integer.parseInt(str2);
                if (i16 <= 0) {
                }
                a18 = Cbreak.a(sb722, cdo3.f383227a, 4);
                if (cdo3.f383227a) {
                }
                if (a18 > 0) {
                }
                f383225f = System.currentTimeMillis() - currentTimeMillis;
                it = arrayList.iterator();
                while (it.hasNext()) {
                }
                return sb6.toString();
            }
            z19 = false;
            sb5 = sb722;
            i3 = a1922;
            Cdo cdo42222 = new Cdo(z19, sb5.toString());
            sb722 = Cbreak.a(i3, cdo42222.f383227a, 2);
            a1922 = cdo42222.f383227a;
            if (a1922 != 0) {
            }
            new SparseArray();
            str2 = (String) Bagasse.a(TNative$aa.d89_A931D6BEC30CD812(new SparseArray(), context, 206), 206, String.class);
            int i182222 = Plum.f383026a;
            if (str2 == null) {
            }
            i16 = Integer.parseInt(str2);
            if (i16 <= 0) {
            }
            a18 = Cbreak.a(sb722, cdo3.f383227a, 4);
            if (cdo3.f383227a) {
            }
            if (a18 > 0) {
            }
            f383225f = System.currentTimeMillis() - currentTimeMillis;
            it = arrayList.iterator();
            while (it.hasNext()) {
            }
            return sb6.toString();
        }
        if ("oppo".equalsIgnoreCase(str3)) {
            if (a()) {
                sb722.append("OPPO");
                z19 = true;
                sb5 = sb722;
                i3 = a1922;
                Cdo cdo422222 = new Cdo(z19, sb5.toString());
                sb722 = Cbreak.a(i3, cdo422222.f383227a, 2);
                a1922 = cdo422222.f383227a;
                if (a1922 != 0) {
                }
                new SparseArray();
                str2 = (String) Bagasse.a(TNative$aa.d89_A931D6BEC30CD812(new SparseArray(), context, 206), 206, String.class);
                int i1822222 = Plum.f383026a;
                if (str2 == null) {
                }
                i16 = Integer.parseInt(str2);
                if (i16 <= 0) {
                }
                a18 = Cbreak.a(sb722, cdo3.f383227a, 4);
                if (cdo3.f383227a) {
                }
                if (a18 > 0) {
                }
                f383225f = System.currentTimeMillis() - currentTimeMillis;
                it = arrayList.iterator();
                while (it.hasNext()) {
                }
                return sb6.toString();
            }
            z19 = false;
            sb5 = sb722;
            i3 = a1922;
            Cdo cdo4222222 = new Cdo(z19, sb5.toString());
            sb722 = Cbreak.a(i3, cdo4222222.f383227a, 2);
            a1922 = cdo4222222.f383227a;
            if (a1922 != 0) {
            }
            new SparseArray();
            str2 = (String) Bagasse.a(TNative$aa.d89_A931D6BEC30CD812(new SparseArray(), context, 206), 206, String.class);
            int i18222222 = Plum.f383026a;
            if (str2 == null) {
            }
            i16 = Integer.parseInt(str2);
            if (i16 <= 0) {
            }
            a18 = Cbreak.a(sb722, cdo3.f383227a, 4);
            if (cdo3.f383227a) {
            }
            if (a18 > 0) {
            }
            f383225f = System.currentTimeMillis() - currentTimeMillis;
            it = arrayList.iterator();
            while (it.hasNext()) {
            }
            return sb6.toString();
        }
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(str3)) {
            if (a()) {
                sb722.append("VIVO_A");
                z19 = true;
                sb5 = sb722;
                i3 = a1922;
                Cdo cdo42222222 = new Cdo(z19, sb5.toString());
                sb722 = Cbreak.a(i3, cdo42222222.f383227a, 2);
                a1922 = cdo42222222.f383227a;
                if (a1922 != 0) {
                }
                new SparseArray();
                str2 = (String) Bagasse.a(TNative$aa.d89_A931D6BEC30CD812(new SparseArray(), context, 206), 206, String.class);
                int i182222222 = Plum.f383026a;
                if (str2 == null) {
                }
                i16 = Integer.parseInt(str2);
                if (i16 <= 0) {
                }
                a18 = Cbreak.a(sb722, cdo3.f383227a, 4);
                if (cdo3.f383227a) {
                }
                if (a18 > 0) {
                }
                f383225f = System.currentTimeMillis() - currentTimeMillis;
                it = arrayList.iterator();
                while (it.hasNext()) {
                }
                return sb6.toString();
            }
            if (new String(Csynchronized.a("/proc/self/mountinfo")).contains(context.getApplicationContext().getPackageName() + "_cloned")) {
                sb722.append("VIVO_B");
            }
            z19 = false;
            sb5 = sb722;
            i3 = a1922;
            Cdo cdo422222222 = new Cdo(z19, sb5.toString());
            sb722 = Cbreak.a(i3, cdo422222222.f383227a, 2);
            a1922 = cdo422222222.f383227a;
            if (a1922 != 0) {
            }
            new SparseArray();
            str2 = (String) Bagasse.a(TNative$aa.d89_A931D6BEC30CD812(new SparseArray(), context, 206), 206, String.class);
            int i1822222222 = Plum.f383026a;
            if (str2 == null) {
            }
            i16 = Integer.parseInt(str2);
            if (i16 <= 0) {
            }
            a18 = Cbreak.a(sb722, cdo3.f383227a, 4);
            if (cdo3.f383227a) {
            }
            if (a18 > 0) {
            }
            f383225f = System.currentTimeMillis() - currentTimeMillis;
            it = arrayList.iterator();
            while (it.hasNext()) {
            }
            return sb6.toString();
        }
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(str3) && (myUid = Process.myUid() / 100000) > 50) {
            sb722.append(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING);
            sb722.append(myUid);
            z19 = true;
            sb5 = sb722;
            i3 = a1922;
            Cdo cdo4222222222 = new Cdo(z19, sb5.toString());
            sb722 = Cbreak.a(i3, cdo4222222222.f383227a, 2);
            a1922 = cdo4222222222.f383227a;
            if (a1922 != 0) {
            }
            new SparseArray();
            str2 = (String) Bagasse.a(TNative$aa.d89_A931D6BEC30CD812(new SparseArray(), context, 206), 206, String.class);
            int i18222222222 = Plum.f383026a;
            if (str2 == null) {
            }
            i16 = Integer.parseInt(str2);
            if (i16 <= 0) {
            }
            a18 = Cbreak.a(sb722, cdo3.f383227a, 4);
            if (cdo3.f383227a) {
            }
            if (a18 > 0) {
            }
            f383225f = System.currentTimeMillis() - currentTimeMillis;
            it = arrayList.iterator();
            while (it.hasNext()) {
            }
            return sb6.toString();
        }
        z19 = false;
        sb5 = sb722;
        i3 = a1922;
        Cdo cdo42222222222 = new Cdo(z19, sb5.toString());
        sb722 = Cbreak.a(i3, cdo42222222222.f383227a, 2);
        a1922 = cdo42222222222.f383227a;
        if (a1922 != 0) {
        }
        new SparseArray();
        str2 = (String) Bagasse.a(TNative$aa.d89_A931D6BEC30CD812(new SparseArray(), context, 206), 206, String.class);
        int i182222222222 = Plum.f383026a;
        if (str2 == null) {
        }
        i16 = Integer.parseInt(str2);
        if (i16 <= 0) {
        }
        a18 = Cbreak.a(sb722, cdo3.f383227a, 4);
        if (cdo3.f383227a) {
        }
        if (a18 > 0) {
        }
        f383225f = System.currentTimeMillis() - currentTimeMillis;
        it = arrayList.iterator();
        while (it.hasNext()) {
        }
        return sb6.toString();
        z19 = true;
        sb5 = sb722;
        i3 = a1922;
        Cdo cdo422222222222 = new Cdo(z19, sb5.toString());
        sb722 = Cbreak.a(i3, cdo422222222222.f383227a, 2);
        a1922 = cdo422222222222.f383227a;
        if (a1922 != 0) {
        }
        new SparseArray();
        str2 = (String) Bagasse.a(TNative$aa.d89_A931D6BEC30CD812(new SparseArray(), context, 206), 206, String.class);
        int i1822222222222 = Plum.f383026a;
        if (str2 == null) {
        }
        i16 = Integer.parseInt(str2);
        if (i16 <= 0) {
        }
        a18 = Cbreak.a(sb722, cdo3.f383227a, 4);
        if (cdo3.f383227a) {
        }
        if (a18 > 0) {
        }
        f383225f = System.currentTimeMillis() - currentTimeMillis;
        it = arrayList.iterator();
        while (it.hasNext()) {
        }
        return sb6.toString();
    }
}
