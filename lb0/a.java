package lb0;

import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lb0.b;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static void a(b.a aVar, String str) {
        if (aVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : d(aVar, str)) {
            arrayList.add(QCircleReportHelper.newEntry(entry.getKey(), entry.getValue()));
        }
        QCircleReporter.getInstance().addQualityReportData(QCircleReportHelper.newSingleDcData(b(), arrayList, null, null));
    }

    private static int b() {
        return 11009;
    }

    private static int c(b.a aVar) {
        return (("1".equals(aVar.f414271a.get("client_down_level")) ? 1 : 0) * 2) + ("1".equals(aVar.f414271a.get("server_down_level")) ? 1 : 0);
    }

    private static Set<Map.Entry<String, String>> d(b.a aVar, String str) {
        String str2;
        HashMap hashMap = new HashMap();
        hashMap.put("uin", aVar.f414271a.get("host_uin"));
        hashMap.put("qua", aVar.f414271a.get("qua"));
        hashMap.put("plateform", aVar.f414271a.get("plateform"));
        hashMap.put("network_type", aVar.f414271a.get("network_type"));
        if (QCirclePluginGlobalInfo.k() != null) {
            str2 = QCirclePluginGlobalInfo.k().exptSubSceneID;
        } else {
            str2 = "0";
        }
        hashMap.put("pool_id", str2);
        hashMap.put("item_id", aVar.f414271a.get("feed_id"));
        hashMap.put("traceid", aVar.f414275e.mTraceId);
        hashMap.put("action", str);
        hashMap.put("clarity_score", String.valueOf(aVar.f414275e.mScore));
        hashMap.put("play_width", aVar.f414271a.get("video_player_width"));
        hashMap.put("play_height", aVar.f414271a.get("video_player_height"));
        hashMap.put("reduce_level", String.valueOf(c(aVar)));
        return hashMap.entrySet();
    }
}
