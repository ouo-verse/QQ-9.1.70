package bc2;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    public static void a(String str) {
        new c().h("now_qq_gzh").g("homepage_view").i(str).f();
    }

    public static void b(String str, int i3) {
        new c().h("now_qq_gzh").g("follow_anchor_click").b("anchor", str).c(i3).f();
    }

    public static void c(String str) {
        new c().h("now_qq_gzh").g("follow_anchor_exp").b("anchor", str).f();
    }

    public static void d(int i3, String str, String str2) {
        new c().h("now_qq_gzh").g("msg_click").c(i3).d(str).e(str2).f();
    }

    public static void e(int i3, String str, String str2) {
        new c().h("now_qq_gzh").g("msg_exp").c(i3).d(str).e(str2).f();
    }

    public static void f() {
        new c().h("now_qq_gzh").g("notice_click").f();
    }

    public static void g() {
        new c().h("now_qq_gzh").g("notice_page_view").f();
    }

    public static void h(String str, int i3) {
        new c().h("now_qq_gzh").g("rec_anchor_click").b("anchor", str).c(i3).f();
    }

    public static void i(String str) {
        new c().h("now_qq_gzh").g("rec_anchor_exp").b("anchor", str).f();
    }
}
