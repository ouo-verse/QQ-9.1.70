package com.tencent.mobileqq.tvideo.floatingwindow;

import android.text.TextUtils;
import uq3.k;
import uq3.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f304430a = false;

    /* renamed from: b, reason: collision with root package name */
    private String f304431b = "0";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.tvideo.floatingwindow.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C8861a {

        /* renamed from: a, reason: collision with root package name */
        static a f304432a = new a();
    }

    a() {
    }

    public static a a() {
        return C8861a.f304432a;
    }

    private boolean h() {
        boolean z16;
        int e16 = k.a().e("tvideo_floating_window_permission_limit_key", 1);
        int e17 = k.a().e("tvideo_floating_window_permission_count_key", 0);
        long f16 = k.a().f("tvideo_floating_window_permission_time_key", 0L);
        if (f16 > 0 && n.e(f16)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && e17 < e16) {
            return true;
        }
        return false;
    }

    public String b() {
        String h16 = k.a().h("tvideo_floating_window_auto_key", "0");
        if (!"0".equals(h16)) {
            return h16 + "";
        }
        if (d()) {
            return "1";
        }
        return "2";
    }

    public boolean c() {
        boolean g16 = j.g();
        String h16 = k.a().h("tvideo_floating_window_auto_key", "0");
        int b16 = fy2.b.f400938a.b();
        long f16 = k.a().f("tvideo_floating_window_last_time_key", 0L);
        if ("2".equals(h16)) {
            return false;
        }
        if ("1".equals(h16)) {
            if (!this.f304430a) {
                return false;
            }
            if (!g16 && !h()) {
                return false;
            }
            return true;
        }
        if (!d() || !this.f304430a) {
            return false;
        }
        if (!g16 && !h()) {
            return false;
        }
        if (b16 < 10 && f16 <= 0) {
            return false;
        }
        return true;
    }

    public boolean d() {
        return TextUtils.equals("2", this.f304431b);
    }

    public boolean e() {
        return TextUtils.equals("1", this.f304431b);
    }

    public void f(boolean z16) {
        this.f304430a = z16;
    }

    public void g(String str) {
        k.a().p("tvideo_floating_window_auto_key", str);
    }
}
