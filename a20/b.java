package a20;

import com.qzone.widget.u;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {
    private static WSStatisticsReporter.Builder a(String str) {
        return new WSStatisticsReporter.Builder().setSopName(str).setTestId(bb.x(1)).setPushId(v.b().c()).setFlush(true);
    }

    private static void b(WSStatisticsReporter.Builder builder, String str) {
        builder.build(str).report();
    }

    public static void c(int i3, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("position", "feeds_tab");
        hashMap.put("feed_id", "");
        hashMap.put("owner_id", "");
        hashMap.put("action_id", String.valueOf(1000001));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("index", String.valueOf(i3 + 1));
        hashMap2.put(u.COLUMN_TAB_ID, str);
        b(a("feeds").addParams(hashMap).addExtParams(hashMap2), "gzh_click");
    }

    public static void d(boolean z16, List<c> list) {
        String str;
        if (list == null) {
            list = new ArrayList<>();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("position", "feeds_tab");
        hashMap.put("feed_id", "");
        hashMap.put("owner_id", "");
        HashMap hashMap2 = new HashMap();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap2.put("is_show", str);
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        while (i3 < list.size()) {
            int i16 = i3 + 1;
            sb5.append(i16);
            sb5.append("_");
            sb5.append(list.get(i3).b());
            if (i3 != list.size() - 1) {
                sb5.append(",");
            }
            i3 = i16;
        }
        hashMap2.put("feeds_tab_list", sb5.toString());
        b(a("feeds").addParams(hashMap).addExtParams(hashMap2), "gzh_exposure");
    }
}
