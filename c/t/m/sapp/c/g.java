package c.t.m.sapp.c;

import android.content.Context;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static String f30163a = "6.11.18";

    /* renamed from: b, reason: collision with root package name */
    public static g f30164b;

    /* renamed from: c, reason: collision with root package name */
    public Context f30165c;

    /* renamed from: d, reason: collision with root package name */
    public List<a> f30166d = new ArrayList();

    public g(Context context) {
        this.f30165c = context;
    }

    public static g a(Context context) {
        if (f30164b == null) {
            synchronized (g.class) {
                if (f30164b == null) {
                    f30164b = new g(context);
                }
            }
        }
        return f30164b;
    }

    public DexClassLoader b() {
        a();
        int b16 = k.b(this.f30165c);
        if (b16 != 6 && b16 != 2) {
            System.currentTimeMillis();
            if (!k.d(this.f30165c)) {
                i.a("copy to private dir failed");
            }
        } else if (!k.c(this.f30165c)) {
            d();
        }
        if (!a(true, a("__SP_Tencent_Loc_COMP_INFO__sapp_"), q.f30189b)) {
            d();
        }
        return b.a(this.f30165c).a(a("__SP_Tencent_Loc_COMP_INFO__sapp_"), q.f30189b);
    }

    public final void c() {
        File file = new File(this.f30165c.getFilesDir(), q.f30189b);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(this.f30165c.getFilesDir(), q.f30190c);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        k.a(this.f30165c);
    }

    public void d() {
        e.a(this.f30165c).a("DCR", QCircleDaTongConstant.ElementParamValue.GOBACK);
        if (!k.d(this.f30165c)) {
            e.a(this.f30165c).a("DCR", "copy from asset failed");
        }
    }

    public boolean a() {
        c();
        String str = f30163a;
        String c16 = q.c(this.f30165c, "__Tencent_Cover_SDK_Version__sapp_", "");
        i.a("cv:" + c16 + "_" + str);
        e.a(this.f30165c).a("DCV", c16 + "_" + str);
        if (str.equals(c16)) {
            return false;
        }
        q.d(this.f30165c, "__Tencent_Cover_SDK_Version__sapp_", str);
        q.d(this.f30165c, "__pro_dex_load_info___sapp", "default");
        q.d(this.f30165c, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
        q.a(this.f30165c.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation_sapp/UpCp");
        return false;
    }

    public boolean a(boolean z16, List<a> list, String str) {
        boolean z17;
        List<String> a16 = q.a(this.f30165c, new File(this.f30165c.getFilesDir(), str));
        if (a16 != null && a16.size() != 0 && list.size() != 0) {
            String c16 = q.c(this.f30165c, "__bad_dex_info___sapp", "preference_default_sapp");
            List<a> d16 = q.d(c16);
            if (!c16.equals("preference_default_sapp") && !d16.isEmpty() && k.a(list, d16)) {
                return false;
            }
            boolean z18 = true;
            for (a aVar : list) {
                Iterator<String> it = a16.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z17 = false;
                        break;
                    }
                    String[] split = it.next().split(",");
                    if (split.length == 3 && aVar.f30130c.equals(split[0]) && String.valueOf(aVar.f30131d).equals(split[1]) && aVar.f30132e.equals(split[2])) {
                        z17 = true;
                        break;
                    }
                }
                if (!z17) {
                    z18 = false;
                }
            }
            return z18;
        }
        i.a("private dir files is empty");
        e.a(this.f30165c).a("DLC", "localComp file error");
        return false;
    }

    public List<a> a(String str) {
        List<a> d16 = q.d(q.c(this.f30165c, str, ""));
        if (d16.size() == 0) {
            e.a(this.f30165c).a("DLC", "localComp parse error");
        }
        return d16;
    }
}
