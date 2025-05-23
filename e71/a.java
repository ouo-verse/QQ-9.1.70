package e71;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    public static void a(String str, int i3, int i16) {
        ReportController.o(null, "dc00898", "", "", str, str, i3, i16, "", "", "", "");
    }

    public static void b(int i3, int i16) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("issuccess", String.valueOf(i3));
        hashMap.put("errorcode", String.valueOf(i16));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.PTT_SLICE_TO_TEXT, true, 0L, 0L, hashMap, "");
    }
}
