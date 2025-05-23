package kj4;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.api.ITimiGameApi;
import java.util.HashMap;
import tk4.d;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    private static boolean a() {
        c cVar = c.f272176a;
        return cVar.J(cVar.p(), 1);
    }

    private static void b(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_eid", str2);
        hashMap.put("dt_pgid", str4);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("zengzhi_moduleid", str3);
        }
        c cVar = c.f272176a;
        if (cVar.J(cVar.p(), 1)) {
            hashMap.putAll(d.f436481a.d());
        } else {
            hashMap.putAll(d.f436481a.f());
        }
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent(str, hashMap);
    }

    public static void c() {
        b("ev_qqlive_click", "em_qqlive_pops_operate_button", "", IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID);
    }

    public static void d() {
        b("ev_qqlive_imp", "em_qqlive_penguin_expire_tip_pop", "", IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID);
    }

    public static void e(boolean z16) {
        String str;
        if (z16) {
            str = "dt_imp";
        } else {
            str = "dt_imp_end";
        }
        b(str, "em_qqlive_gift_fantuan_pannel", "", "pg_qq_gift_panel");
    }

    public static void f() {
        b("dt_clck", "em_qqlive_joinfantuan_entrance", "em_qqlive_gift_fantuan_pannel", "pg_qq_gift_panel");
    }

    public static void g(boolean z16) {
        String str;
        if (z16) {
            str = "dt_imp";
        } else {
            str = "dt_imp_end";
        }
        b(str, "em_qqlive_joinfantuan_entrance", "em_qqlive_gift_fantuan_pannel", "pg_qq_gift_panel");
    }

    public static void h() {
        String str;
        if (a()) {
            str = IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID;
        } else {
            str = IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID;
        }
        b("ev_qqlive_click", "em_qqlive_top_penguin_entrance", "", str);
    }

    public static void i() {
        String str;
        if (a()) {
            str = IMultiAvChatReporter.PageId.ANCHOR_PAGE_ID;
        } else {
            str = IMultiAvChatReporter.PageId.AUDIENCE_PAGE_ID;
        }
        b("ev_qqlive_click", "em_qqlive_top_fans_entrance", "", str);
    }

    public static void j() {
        b("dt_clck", "em_qqlive_fantuan_levelup", "em_qqlive_gift_fantuan_pannel", "pg_qq_gift_panel");
    }

    public static void k(boolean z16) {
        String str;
        if (z16) {
            str = "dt_imp";
        } else {
            str = "dt_imp_end";
        }
        b(str, "em_qqlive_fantuan_levelup", "em_qqlive_gift_fantuan_pannel", "pg_qq_gift_panel");
    }
}
