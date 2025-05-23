package a10;

import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.report.d;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Long> f25330a = new HashMap();

    private static WSStatisticsReporter.Builder a(String str) {
        return new WSStatisticsReporter.Builder().setSopName(str).setFlush(true);
    }

    private static void b(WSStatisticsReporter.Builder builder, String str) {
        builder.build(str).report();
    }

    public static void d(boolean z16, String str) {
        String str2;
        WSStatisticsReporter.Builder a16 = a(c(z16));
        if (z16) {
            str2 = "my_weishi";
        } else {
            str2 = "owner_weishi";
        }
        b(a16.addParams("position", str2).addParams("feed_id", "").addParams("owner_id", str), "gzh_exposure");
    }

    public static void e(boolean z16) {
        String str;
        WSStatisticsReporter.Builder addParams = a("privacy_settings").addParams("position", "weishi_switch").addParams("action_id", d.f81489a).addParams("feed_id", "").addParams("owner_id", "");
        HashMap hashMap = new HashMap();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, str);
        addParams.addExtParams(hashMap);
        b(addParams, "gzh_click");
    }

    public static void g(boolean z16, String str, boolean z17, boolean z18) {
        String str2;
        String str3;
        String str4;
        WSStatisticsReporter.Builder a16 = a(c(z16));
        if (z16) {
            str2 = "my_weishi_jump";
        } else {
            str2 = "owner_weishi_jump";
        }
        WSStatisticsReporter.Builder addParams = a16.addParams("position", str2);
        if (z17) {
            str3 = d.f81491c;
        } else {
            str3 = d.f81490b;
        }
        WSStatisticsReporter.Builder addParams2 = addParams.addParams("action_id", str3).addParams("feed_id", "").addParams("owner_id", str);
        HashMap hashMap = new HashMap();
        if (z16) {
            if (z18) {
                str4 = "0";
            } else {
                str4 = "1";
            }
            hashMap.put("click_status", str4);
        }
        addParams2.addExtParams(hashMap);
        b(addParams2, "gzh_click");
    }

    private static String c(boolean z16) {
        if (z16) {
            return "profile_main";
        }
        return "profile_guest";
    }

    public static void f(boolean z16) {
        if (z16) {
            b(a("privacy_settings").addParams("position", "weishi_switch").addParams("feed_id", "").addParams("owner_id", ""), "gzh_exposure");
        }
    }
}
