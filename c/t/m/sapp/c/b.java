package c.t.m.sapp.c;

import android.content.Context;
import android.os.Build;
import cooperation.qzone.patch.QZonePatchService;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static b f30134a;

    /* renamed from: b, reason: collision with root package name */
    public Context f30135b;

    /* renamed from: c, reason: collision with root package name */
    public List<a> f30136c;

    /* renamed from: d, reason: collision with root package name */
    public String f30137d = "";

    public b(Context context) {
        this.f30136c = null;
        this.f30135b = context;
        this.f30136c = new ArrayList();
    }

    public static b a(Context context) {
        if (f30134a == null) {
            f30134a = new b(context);
        }
        return f30134a;
    }

    public final synchronized DexClassLoader a() {
        DexClassLoader dexClassLoader;
        File[] listFiles;
        k.a(this.f30135b);
        List<a> list = this.f30136c;
        if (list != null && list.size() > 0) {
            q.f30191d = q.a(this.f30136c);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f30135b.getFilesDir().getAbsolutePath());
            String str = File.separator;
            sb5.append(str);
            sb5.append(this.f30137d);
            String sb6 = sb5.toString();
            String str2 = this.f30135b.getFilesDir().getAbsolutePath() + str + q.f30190c;
            StringBuilder sb7 = new StringBuilder();
            String str3 = "";
            for (a aVar : this.f30136c) {
                if (aVar != null) {
                    sb7.append(sb6);
                    String str4 = File.separator;
                    sb7.append(str4);
                    sb7.append(aVar.f30130c);
                    sb7.append(File.pathSeparator);
                    if (aVar.f30130c.contains(QZonePatchService.PATCH_SUFFIX_DEX)) {
                        str3 = sb6 + str4 + aVar.f30130c;
                    }
                }
            }
            try {
                if (Build.VERSION.SDK_INT >= 34) {
                    try {
                        new File(str3).setReadOnly();
                    } catch (Throwable th5) {
                        i.a("setReadOnly", th5);
                    }
                }
                System.currentTimeMillis();
                dexClassLoader = new DexClassLoader(sb7.toString(), str2, null, getClass().getClassLoader());
                String str5 = "";
                try {
                    File file = new File(sb6);
                    if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            str5 = str5 + (file2.getName() + "," + file2.length() + "," + q.a(file2)) + ";";
                        }
                    }
                    i.a("before load ,private dir files:" + str5);
                    e.a(this.f30135b).a("CPL", "suc:" + q.f30191d);
                    return dexClassLoader;
                } catch (Exception e16) {
                    e = e16;
                    i.a("try once", e);
                    e.a(this.f30135b).a("CPL", "fail:" + q.f30191d + ",exc:" + e.toString());
                    k.a(this.f30135b);
                    try {
                        System.currentTimeMillis();
                        DexClassLoader dexClassLoader2 = new DexClassLoader(sb7.toString(), str2, null, getClass().getClassLoader());
                        try {
                            e.a(this.f30135b).a("CPL", "suc:c" + q.f30191d);
                            return dexClassLoader2;
                        } catch (Throwable unused) {
                            dexClassLoader = dexClassLoader2;
                            i.a("try once failed", e);
                            return dexClassLoader;
                        }
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Exception e17) {
                e = e17;
                dexClassLoader = null;
            }
        }
        return null;
    }

    public DexClassLoader a(List<a> list, String str) {
        this.f30136c = list;
        this.f30137d = str;
        int i3 = 0;
        DexClassLoader dexClassLoader = null;
        while (true) {
            int i16 = i3 + 1;
            if (i3 >= 3) {
                break;
            }
            try {
                dexClassLoader = a();
                e.b().a("CPL", "lcn:" + i16);
                if (dexClassLoader != null) {
                    k.f(this.f30135b);
                    return dexClassLoader;
                }
                i3 = i16;
            } catch (Throwable th5) {
                e.b().a("CPL", "fail:" + th5.toString());
            }
        }
        k.f(this.f30135b);
        return dexClassLoader;
    }
}
