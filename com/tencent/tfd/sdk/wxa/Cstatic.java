package com.tencent.tfd.sdk.wxa;

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
/* renamed from: com.tencent.tfd.sdk.wxa.static, reason: invalid class name */
/* loaded from: classes26.dex */
public final class Cstatic {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f375772a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f375773b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f375774c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f375775d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f375776e;

    /* renamed from: f, reason: collision with root package name */
    public static long f375777f;

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f375778g;

    /* compiled from: P */
    /* renamed from: com.tencent.tfd.sdk.wxa.static$do, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static class Cdo {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f375779a;

        /* renamed from: b, reason: collision with root package name */
        public final String f375780b;

        public Cdo(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), str);
            } else {
                this.f375779a = z16;
                this.f375780b = str;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62888);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f375772a = Cswitch.a(Cswitch.f375784b);
        f375773b = Cswitch.a(Cswitch.f375787c);
        f375774c = Cswitch.a(Cswitch.f375789d);
        f375775d = Cswitch.a(Cswitch.f375791e);
        f375776e = Cswitch.a(Cswitch.f375793f);
        f375777f = 0L;
        f375778g = new String[]{"^/data/user/\\d+$", "^/data/data$"};
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
            sb5.append((String) ((ArrayList) Lyra.a(new File(str2))).get(0));
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

    /* JADX WARN: Can't wrap try/catch for region: R(30:1|(1:3)(2:153|(1:155)(5:156|(1:(2:158|(2:161|162)(1:160))(2:182|183))|163|(2:175|(1:181))(1:169)|(1:174)(1:173)))|4|(1:152)(1:8)|9|(1:11)(11:85|86|87|88|89|(3:90|91|(3:93|(3:133|134|135)(3:95|96|(3:101|102|(1:107)(2:104|105)))|106)(2:136|137))|109|110|(2:114|(4:116|(1:124)|120|(1:122)(1:123)))|125|(0)(0))|12|(1:14)|15|(1:16)|(19:18|(1:22)|54|25|(1:27)|28|29|30|(1:32)|33|(1:35)(1:49)|36|(1:38)|(1:40)|41|(2:44|42)|45|46|47)(2:55|(19:57|(18:59|24|25|(0)|28|29|30|(0)|33|(0)(0)|36|(0)|(0)|41|(1:42)|45|46|47)|54|25|(0)|28|29|30|(0)|33|(0)(0)|36|(0)|(0)|41|(1:42)|45|46|47)(2:60|(19:62|(18:64|24|25|(0)|28|29|30|(0)|33|(0)(0)|36|(0)|(0)|41|(1:42)|45|46|47)|54|25|(0)|28|29|30|(0)|33|(0)(0)|36|(0)|(0)|41|(1:42)|45|46|47)(2:65|(19:67|(18:69|24|25|(0)|28|29|30|(0)|33|(0)(0)|36|(0)|(0)|41|(1:42)|45|46|47)|54|25|(0)|28|29|30|(0)|33|(0)(0)|36|(0)|(0)|41|(1:42)|45|46|47)(2:70|(2:72|(18:74|24|25|(0)|28|29|30|(0)|33|(0)(0)|36|(0)|(0)|41|(1:42)|45|46|47)(19:75|(1:77)|54|25|(0)|28|29|30|(0)|33|(0)(0)|36|(0)|(0)|41|(1:42)|45|46|47))(19:78|(18:82|24|25|(0)|28|29|30|(0)|33|(0)(0)|36|(0)|(0)|41|(1:42)|45|46|47)|54|25|(0)|28|29|30|(0)|33|(0)(0)|36|(0)|(0)|41|(1:42)|45|46|47)))))|23|24|25|(0)|28|29|30|(0)|33|(0)(0)|36|(0)|(0)|41|(1:42)|45|46|47|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x013b, code lost:
    
        r13 = r0[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0318, code lost:
    
        r11 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01f4 A[Catch: all -> 0x02c2, TRY_ENTER, TryCatch #0 {all -> 0x02c2, blocks: (B:18:0x01f4, B:20:0x020b, B:75:0x0272), top: B:16:0x01f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0396 A[LOOP:0: B:42:0x0390->B:44:0x0396, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0218  */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v41, types: [int] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v9, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x02c2 -> B:25:0x02c3). Please report as a decompilation issue!!! */
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
        ?? a17;
        String str2;
        boolean z19;
        int i3;
        StringBuilder sb5;
        int i16;
        Cdo cdo3;
        int a18;
        Iterator it;
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
                String[] strArr = f375778g;
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
        if (cdo.f375779a && !TextUtils.isEmpty(cdo.f375780b)) {
            a16 = Ccatch.a(0, true, 0);
            Cpublic cpublic = new Cpublic();
            cpublic.f375769a = f375772a + f375774c;
            cpublic.f375770b = cdo.f375780b;
            arrayList.add(cpublic);
            z17 = false;
        } else {
            z17 = false;
            a16 = Ccatch.a(0, false, 0);
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
                            Cvolatile.a(fileReader);
                            Cvolatile.a(bufferedReader);
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
                            a17 = Ccatch.a(a16, cdo2.f375779a, 1);
                            if (cdo2.f375779a) {
                            }
                            ?? sb7 = new StringBuilder();
                            str2 = Build.BRAND;
                            try {
                                if ("HUAWEI".equalsIgnoreCase(str2)) {
                                }
                            } catch (Throwable unused) {
                            }
                            z19 = true;
                            sb5 = sb7;
                            i3 = a17;
                            Cdo cdo4 = new Cdo(z19, sb5.toString());
                            sb7 = Ccatch.a(i3, cdo4.f375779a, 2);
                            a17 = cdo4.f375779a;
                            if (a17 != 0) {
                            }
                            new SparseArray();
                            str3 = (String) Equuleus.a(TNative$aa.d77(new SparseArray(), context, 206), 206, String.class);
                            if (str3 == null) {
                            }
                            i16 = Integer.parseInt(str3);
                            if (i16 <= 0) {
                            }
                            a18 = Ccatch.a(sb7, cdo3.f375779a, 4);
                            if (cdo3.f375779a) {
                            }
                            if (a18 > 0) {
                            }
                            f375777f = System.currentTimeMillis() - currentTimeMillis;
                            it = arrayList.iterator();
                            while (it.hasNext()) {
                            }
                            return sb6.toString();
                        } finally {
                            Cvolatile.a(fileReader);
                            Cvolatile.a(bufferedReader);
                        }
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedReader = null;
                th.printStackTrace();
                Cvolatile.a(fileReader);
                Cvolatile.a(bufferedReader);
                str = null;
                String packageName22 = applicationContext.getPackageName();
                if (!TextUtils.isEmpty(str)) {
                }
                z18 = false;
                if (!z18) {
                }
                a17 = Ccatch.a(a16, cdo2.f375779a, 1);
                if (cdo2.f375779a) {
                }
                ?? sb72 = new StringBuilder();
                str2 = Build.BRAND;
                if ("HUAWEI".equalsIgnoreCase(str2)) {
                }
                z19 = true;
                sb5 = sb72;
                i3 = a17;
                Cdo cdo42 = new Cdo(z19, sb5.toString());
                sb72 = Ccatch.a(i3, cdo42.f375779a, 2);
                a17 = cdo42.f375779a;
                if (a17 != 0) {
                }
                new SparseArray();
                str3 = (String) Equuleus.a(TNative$aa.d77(new SparseArray(), context, 206), 206, String.class);
                if (str3 == null) {
                }
                i16 = Integer.parseInt(str3);
                if (i16 <= 0) {
                }
                a18 = Ccatch.a(sb72, cdo3.f375779a, 4);
                if (cdo3.f375779a) {
                }
                if (a18 > 0) {
                }
                f375777f = System.currentTimeMillis() - currentTimeMillis;
                it = arrayList.iterator();
                while (it.hasNext()) {
                }
                return sb6.toString();
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
        a17 = Ccatch.a(a16, cdo2.f375779a, 1);
        if (cdo2.f375779a) {
            Cpublic cpublic2 = new Cpublic();
            cpublic2.f375769a = f375772a + f375775d;
            cpublic2.f375770b = cdo2.f375780b;
            arrayList.add(cpublic2);
        }
        ?? sb722 = new StringBuilder();
        str2 = Build.BRAND;
        if ("HUAWEI".equalsIgnoreCase(str2)) {
            String b16 = b(context);
            String str4 = new String(Base64.decode("5YiG6Lqr5bqU55So", 0));
            if (!TextUtils.isEmpty(b16) && str4.equals(b16)) {
                sb722.append("HuaWei");
            }
            z19 = false;
            sb5 = sb722;
            i3 = a17;
            Cdo cdo422 = new Cdo(z19, sb5.toString());
            sb722 = Ccatch.a(i3, cdo422.f375779a, 2);
            a17 = cdo422.f375779a;
            if (a17 != 0) {
                Cpublic cpublic3 = new Cpublic();
                cpublic3.f375769a = f375772a + f375776e;
                cpublic3.f375770b = cdo422.f375780b;
                arrayList.add(cpublic3);
            }
            new SparseArray();
            str3 = (String) Equuleus.a(TNative$aa.d77(new SparseArray(), context, 206), 206, String.class);
            if (str3 == null) {
                str3 = "";
            }
            i16 = Integer.parseInt(str3);
            if (i16 <= 0) {
                cdo3 = new Cdo(true, "");
            } else {
                cdo3 = new Cdo(false, "");
            }
            a18 = Ccatch.a(sb722, cdo3.f375779a, 4);
            if (cdo3.f375779a) {
                Cpublic cpublic4 = new Cpublic();
                cpublic4.f375769a = f375772a + "dual_e";
                cpublic4.f375770b = cdo422.f375780b;
                arrayList.add(cpublic4);
            }
            if (a18 > 0) {
                Cpublic cpublic5 = new Cpublic();
                cpublic5.f375769a = f375772a + f375773b;
                cpublic5.f375770b = "" + a18;
                arrayList.add(cpublic5);
            }
            f375777f = System.currentTimeMillis() - currentTimeMillis;
            it = arrayList.iterator();
            while (it.hasNext()) {
                Cpublic cpublic6 = (Cpublic) it.next();
                sb6.append(cpublic6.f375769a);
                sb6.append(":");
                sb6.append(cpublic6.f375770b);
                sb6.append(",");
            }
            return sb6.toString();
        }
        if ("xiaomi".equalsIgnoreCase(str2)) {
            if (a()) {
                sb722.append("XiaoMi");
                z19 = true;
                sb5 = sb722;
                i3 = a17;
                Cdo cdo4222 = new Cdo(z19, sb5.toString());
                sb722 = Ccatch.a(i3, cdo4222.f375779a, 2);
                a17 = cdo4222.f375779a;
                if (a17 != 0) {
                }
                new SparseArray();
                str3 = (String) Equuleus.a(TNative$aa.d77(new SparseArray(), context, 206), 206, String.class);
                if (str3 == null) {
                }
                i16 = Integer.parseInt(str3);
                if (i16 <= 0) {
                }
                a18 = Ccatch.a(sb722, cdo3.f375779a, 4);
                if (cdo3.f375779a) {
                }
                if (a18 > 0) {
                }
                f375777f = System.currentTimeMillis() - currentTimeMillis;
                it = arrayList.iterator();
                while (it.hasNext()) {
                }
                return sb6.toString();
            }
            z19 = false;
            sb5 = sb722;
            i3 = a17;
            Cdo cdo42222 = new Cdo(z19, sb5.toString());
            sb722 = Ccatch.a(i3, cdo42222.f375779a, 2);
            a17 = cdo42222.f375779a;
            if (a17 != 0) {
            }
            new SparseArray();
            str3 = (String) Equuleus.a(TNative$aa.d77(new SparseArray(), context, 206), 206, String.class);
            if (str3 == null) {
            }
            i16 = Integer.parseInt(str3);
            if (i16 <= 0) {
            }
            a18 = Ccatch.a(sb722, cdo3.f375779a, 4);
            if (cdo3.f375779a) {
            }
            if (a18 > 0) {
            }
            f375777f = System.currentTimeMillis() - currentTimeMillis;
            it = arrayList.iterator();
            while (it.hasNext()) {
            }
            return sb6.toString();
        }
        if ("redmi".equalsIgnoreCase(str2)) {
            if (a()) {
                sb722.append("Redmi");
                z19 = true;
                sb5 = sb722;
                i3 = a17;
                Cdo cdo422222 = new Cdo(z19, sb5.toString());
                sb722 = Ccatch.a(i3, cdo422222.f375779a, 2);
                a17 = cdo422222.f375779a;
                if (a17 != 0) {
                }
                new SparseArray();
                str3 = (String) Equuleus.a(TNative$aa.d77(new SparseArray(), context, 206), 206, String.class);
                if (str3 == null) {
                }
                i16 = Integer.parseInt(str3);
                if (i16 <= 0) {
                }
                a18 = Ccatch.a(sb722, cdo3.f375779a, 4);
                if (cdo3.f375779a) {
                }
                if (a18 > 0) {
                }
                f375777f = System.currentTimeMillis() - currentTimeMillis;
                it = arrayList.iterator();
                while (it.hasNext()) {
                }
                return sb6.toString();
            }
            z19 = false;
            sb5 = sb722;
            i3 = a17;
            Cdo cdo4222222 = new Cdo(z19, sb5.toString());
            sb722 = Ccatch.a(i3, cdo4222222.f375779a, 2);
            a17 = cdo4222222.f375779a;
            if (a17 != 0) {
            }
            new SparseArray();
            str3 = (String) Equuleus.a(TNative$aa.d77(new SparseArray(), context, 206), 206, String.class);
            if (str3 == null) {
            }
            i16 = Integer.parseInt(str3);
            if (i16 <= 0) {
            }
            a18 = Ccatch.a(sb722, cdo3.f375779a, 4);
            if (cdo3.f375779a) {
            }
            if (a18 > 0) {
            }
            f375777f = System.currentTimeMillis() - currentTimeMillis;
            it = arrayList.iterator();
            while (it.hasNext()) {
            }
            return sb6.toString();
        }
        if ("oppo".equalsIgnoreCase(str2)) {
            if (a()) {
                sb722.append("OPPO");
                z19 = true;
                sb5 = sb722;
                i3 = a17;
                Cdo cdo42222222 = new Cdo(z19, sb5.toString());
                sb722 = Ccatch.a(i3, cdo42222222.f375779a, 2);
                a17 = cdo42222222.f375779a;
                if (a17 != 0) {
                }
                new SparseArray();
                str3 = (String) Equuleus.a(TNative$aa.d77(new SparseArray(), context, 206), 206, String.class);
                if (str3 == null) {
                }
                i16 = Integer.parseInt(str3);
                if (i16 <= 0) {
                }
                a18 = Ccatch.a(sb722, cdo3.f375779a, 4);
                if (cdo3.f375779a) {
                }
                if (a18 > 0) {
                }
                f375777f = System.currentTimeMillis() - currentTimeMillis;
                it = arrayList.iterator();
                while (it.hasNext()) {
                }
                return sb6.toString();
            }
            z19 = false;
            sb5 = sb722;
            i3 = a17;
            Cdo cdo422222222 = new Cdo(z19, sb5.toString());
            sb722 = Ccatch.a(i3, cdo422222222.f375779a, 2);
            a17 = cdo422222222.f375779a;
            if (a17 != 0) {
            }
            new SparseArray();
            str3 = (String) Equuleus.a(TNative$aa.d77(new SparseArray(), context, 206), 206, String.class);
            if (str3 == null) {
            }
            i16 = Integer.parseInt(str3);
            if (i16 <= 0) {
            }
            a18 = Ccatch.a(sb722, cdo3.f375779a, 4);
            if (cdo3.f375779a) {
            }
            if (a18 > 0) {
            }
            f375777f = System.currentTimeMillis() - currentTimeMillis;
            it = arrayList.iterator();
            while (it.hasNext()) {
            }
            return sb6.toString();
        }
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(str2)) {
            if (a()) {
                sb722.append("VIVO_A");
                z19 = true;
                sb5 = sb722;
                i3 = a17;
                Cdo cdo4222222222 = new Cdo(z19, sb5.toString());
                sb722 = Ccatch.a(i3, cdo4222222222.f375779a, 2);
                a17 = cdo4222222222.f375779a;
                if (a17 != 0) {
                }
                new SparseArray();
                str3 = (String) Equuleus.a(TNative$aa.d77(new SparseArray(), context, 206), 206, String.class);
                if (str3 == null) {
                }
                i16 = Integer.parseInt(str3);
                if (i16 <= 0) {
                }
                a18 = Ccatch.a(sb722, cdo3.f375779a, 4);
                if (cdo3.f375779a) {
                }
                if (a18 > 0) {
                }
                f375777f = System.currentTimeMillis() - currentTimeMillis;
                it = arrayList.iterator();
                while (it.hasNext()) {
                }
                return sb6.toString();
            }
            if (new String(Cextends.a("/proc/self/mountinfo")).contains(context.getApplicationContext().getPackageName() + "_cloned")) {
                sb722.append("VIVO_B");
            }
            z19 = false;
            sb5 = sb722;
            i3 = a17;
            Cdo cdo42222222222 = new Cdo(z19, sb5.toString());
            sb722 = Ccatch.a(i3, cdo42222222222.f375779a, 2);
            a17 = cdo42222222222.f375779a;
            if (a17 != 0) {
            }
            new SparseArray();
            str3 = (String) Equuleus.a(TNative$aa.d77(new SparseArray(), context, 206), 206, String.class);
            if (str3 == null) {
            }
            i16 = Integer.parseInt(str3);
            if (i16 <= 0) {
            }
            a18 = Ccatch.a(sb722, cdo3.f375779a, 4);
            if (cdo3.f375779a) {
            }
            if (a18 > 0) {
            }
            f375777f = System.currentTimeMillis() - currentTimeMillis;
            it = arrayList.iterator();
            while (it.hasNext()) {
            }
            return sb6.toString();
        }
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING.equalsIgnoreCase(str2) && (myUid = Process.myUid() / 100000) > 50) {
            sb722.append(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING);
            sb722.append(myUid);
            z19 = true;
            sb5 = sb722;
            i3 = a17;
            Cdo cdo422222222222 = new Cdo(z19, sb5.toString());
            sb722 = Ccatch.a(i3, cdo422222222222.f375779a, 2);
            a17 = cdo422222222222.f375779a;
            if (a17 != 0) {
            }
            new SparseArray();
            str3 = (String) Equuleus.a(TNative$aa.d77(new SparseArray(), context, 206), 206, String.class);
            if (str3 == null) {
            }
            i16 = Integer.parseInt(str3);
            if (i16 <= 0) {
            }
            a18 = Ccatch.a(sb722, cdo3.f375779a, 4);
            if (cdo3.f375779a) {
            }
            if (a18 > 0) {
            }
            f375777f = System.currentTimeMillis() - currentTimeMillis;
            it = arrayList.iterator();
            while (it.hasNext()) {
            }
            return sb6.toString();
        }
        z19 = false;
        sb5 = sb722;
        i3 = a17;
        Cdo cdo4222222222222 = new Cdo(z19, sb5.toString());
        sb722 = Ccatch.a(i3, cdo4222222222222.f375779a, 2);
        a17 = cdo4222222222222.f375779a;
        if (a17 != 0) {
        }
        new SparseArray();
        str3 = (String) Equuleus.a(TNative$aa.d77(new SparseArray(), context, 206), 206, String.class);
        if (str3 == null) {
        }
        i16 = Integer.parseInt(str3);
        if (i16 <= 0) {
        }
        a18 = Ccatch.a(sb722, cdo3.f375779a, 4);
        if (cdo3.f375779a) {
        }
        if (a18 > 0) {
        }
        f375777f = System.currentTimeMillis() - currentTimeMillis;
        it = arrayList.iterator();
        while (it.hasNext()) {
        }
        return sb6.toString();
        z19 = true;
        sb5 = sb722;
        i3 = a17;
        Cdo cdo42222222222222 = new Cdo(z19, sb5.toString());
        sb722 = Ccatch.a(i3, cdo42222222222222.f375779a, 2);
        a17 = cdo42222222222222.f375779a;
        if (a17 != 0) {
        }
        new SparseArray();
        str3 = (String) Equuleus.a(TNative$aa.d77(new SparseArray(), context, 206), 206, String.class);
        if (str3 == null) {
        }
        i16 = Integer.parseInt(str3);
        if (i16 <= 0) {
        }
        a18 = Ccatch.a(sb722, cdo3.f375779a, 4);
        if (cdo3.f375779a) {
        }
        if (a18 > 0) {
        }
        f375777f = System.currentTimeMillis() - currentTimeMillis;
        it = arrayList.iterator();
        while (it.hasNext()) {
        }
        return sb6.toString();
    }
}
