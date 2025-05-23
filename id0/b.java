package id0;

import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f407532a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f407533b = "";

    /* renamed from: c, reason: collision with root package name */
    public static int f407534c;

    /* renamed from: d, reason: collision with root package name */
    public static int f407535d;

    public static String a(int i3) {
        if (i3 == 2) {
            return "grp_qq_pic_base";
        }
        if (i3 != 3) {
            if (i3 != 4) {
                return "grp_qq_pic_base";
            }
            return "grp_qq_pic_kandian";
        }
        return "grp_qq_pic_qzone";
    }

    private static int b() {
        if (f407532a.equalsIgnoreCase("grp_qq_pic_qzone")) {
            return 2;
        }
        if (f407532a.equalsIgnoreCase("grp_qq_pic_kandian")) {
            return 3;
        }
        return 1;
    }

    private static int c() {
        if (f407532a.equals("grp_tribe")) {
            return 4;
        }
        if (f407532a.equals("grp_qq")) {
            return 1;
        }
        if (f407532a.equals("grp_readinjoy")) {
            return 5;
        }
        return 2;
    }

    private static boolean d() {
        if (!f407532a.equals("grp_qq_pic_base") && !f407532a.equals("grp_qq_pic_qzone") && !f407532a.equals("grp_qq_pic_kandian")) {
            return false;
        }
        return true;
    }

    private static boolean e() {
        if (!f407532a.equals("grp_qq") && !f407532a.equals("grp_qzone") && !f407532a.equals("grp_tribe") && !f407532a.equals("grp_readinjoy")) {
            return false;
        }
        return true;
    }

    public static void f(String str) {
        g(str, "");
    }

    public static void g(String str, String str2) {
        if (d()) {
            ReportController.o(null, "dc00898", "", "", str, str, b(), 0, "", "", str2, "");
        }
    }

    public static void h(String str, int i3) {
        if (d()) {
            ReportController.o(null, "dc00898", "", "", str, str, b(), 0, String.valueOf(i3), "", "", "");
        }
    }

    public static void i(String str) {
        if (!e()) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", str, str, c(), 0, "", "", "", "");
    }

    public static void j(String str, String str2, String str3, String str4, String str5) {
        if (!e()) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", str, str, c(), 0, str2, str3, str4, str5);
    }

    public static void k(String str, int i3) {
        if (!e()) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", str, str, c(), 0, String.valueOf(i3), "", "", "");
    }

    public static void l(int i3) {
        f407534c = i3;
    }

    public static void m(int i3) {
        f407535d = i3;
    }
}
