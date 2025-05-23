package cw0;

import android.text.TextUtils;
import com.tencent.icgame.api.ITimiGameApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {
    private static void a(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_eid", str2);
        hashMap.put("dt_pgid", "pg_qq_gift_panel");
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("zengzhi_moduleid", str3);
        }
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent(str, hashMap);
    }

    public static void b(boolean z16) {
        String str;
        if (z16) {
            str = "dt_imp";
        } else {
            str = "dt_imp_end";
        }
        a(str, "em_icgame_gift_fantuan_pannel", "");
    }

    public static void c() {
        a("dt_clck", "em_icgame_joinfantuan_entrance", "em_icgame_gift_fantuan_pannel");
    }

    public static void d(boolean z16) {
        String str;
        if (z16) {
            str = "dt_imp";
        } else {
            str = "dt_imp_end";
        }
        a(str, "em_icgame_joinfantuan_entrance", "em_icgame_gift_fantuan_pannel");
    }

    public static void e() {
        a("dt_clck", "em_icgame_fantuan_levelup", "em_icgame_gift_fantuan_pannel");
    }

    public static void f(boolean z16) {
        String str;
        if (z16) {
            str = "dt_imp";
        } else {
            str = "dt_imp_end";
        }
        a(str, "em_icgame_fantuan_levelup", "em_icgame_gift_fantuan_pannel");
    }
}
