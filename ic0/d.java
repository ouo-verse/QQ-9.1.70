package ic0;

import com.tencent.biz.qqcircle.rerank.util.QFSRankEdgeReportHelper;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {
    public static boolean a() {
        if (uq3.c.X0("qqcircle", "qqcircle_enable_rerank_give_up_when_remove_expose", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        if (uq3.c.X0("qqcircle", "qqcircle_enable_tedgers_rerank_result_report", 1).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static void c(String str) {
        if (!b()) {
            return;
        }
        QFSRankEdgeReportHelper.g(new QFSRankEdgeReportHelper.a().n("tedgeRSV2_result_data_check_error").m(str));
    }

    public static void d(String str) {
        if (!b()) {
            return;
        }
        if (str == null) {
            str = "";
        }
        QFSRankEdgeReportHelper.g(new QFSRankEdgeReportHelper.a().n("tedgeRSV2_remove_expose_feed").l(str));
    }

    public static void e() {
        if (!b()) {
            return;
        }
        QFSRankEdgeReportHelper.g(new QFSRankEdgeReportHelper.a().n("tedgeRSV2_result_data_succeed"));
    }
}
