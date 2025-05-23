package p00;

import UserGrowth.stSimpleMetaFeed;
import com.google.gson.Gson;
import com.qzone.widget.u;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {
    private static WSStatisticsReporter.Builder a() {
        return new WSStatisticsReporter.Builder().setFlush(true);
    }

    public static q00.c b(stSimpleMetaFeed stsimplemetafeed, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        q00.c cVar = new q00.c(str, hashMap, hashMap2);
        if (stsimplemetafeed == null) {
            return cVar;
        }
        hashMap.put("feed_id", stsimplemetafeed.f25129id);
        hashMap.put("owner_id", stsimplemetafeed.poster_id);
        hashMap.put("global_key", com.tencent.biz.pubaccount.weishi.report.c.b().c(stsimplemetafeed.traceId));
        hashMap.put("feed_pass_key", new Gson().toJson(stsimplemetafeed.map_ext));
        hashMap2.put(u.COLUMN_TAB_ID, str2);
        hashMap2.put(QCircleLpReportDc05507.KEY_PLAY_SCENE, str3);
        return cVar;
    }

    public static void c(q00.c cVar) {
        if (cVar == null) {
            return;
        }
        Map<String, String> b16 = cVar.b();
        if (b16 == null) {
            b16 = new HashMap<>();
        }
        b16.put("position", "auth_close");
        b16.put("action_id", "1000001");
        a().setSopName(cVar.c()).addParams(b16).addExtParams(cVar.a()).build("gzh_click").report();
    }

    public static void d(q00.c cVar) {
        if (cVar == null) {
            return;
        }
        Map<String, String> b16 = cVar.b();
        if (b16 == null) {
            b16 = new HashMap<>();
        }
        b16.put("position", "auth_float");
        a().setSopName(cVar.c()).addParams(b16).addExtParams(cVar.a()).build("gzh_exposure").report();
    }

    public static void e(q00.c cVar) {
        if (cVar == null) {
            return;
        }
        Map<String, String> b16 = cVar.b();
        if (b16 == null) {
            b16 = new HashMap<>();
        }
        b16.put("position", "auth_weishi");
        b16.put("action_id", "1000003");
        a().setSopName(cVar.c()).addParams(b16).addExtParams(cVar.a()).build("gzh_click").report();
    }
}
