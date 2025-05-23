package kw2;

import com.tencent.qqlive.ona.protocol.jce.AdReport;
import com.tencent.tvideo.protocol.pb.AdOrderItem;
import com.tencent.tvideo.protocol.pb.AdReportList;
import com.tencent.tvideo.protocol.pb.AdReportType;
import java.util.Map;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    public static AdReport a(AdOrderItem adOrderItem, AdReportType adReportType) {
        AdReportList adReportList;
        com.tencent.tvideo.protocol.pb.AdReport adReport;
        if (adOrderItem == null || adReportType == null || y.i(adOrderItem.report_dict) || (adReportList = adOrderItem.report_dict.get(Integer.valueOf(adReportType.getValue()))) == null || y.h(adReportList.report_list) || (adReport = adReportList.report_list.get(0)) == null) {
            return null;
        }
        return (AdReport) a.b().a(adReport);
    }

    public static com.tencent.tvideo.protocol.pb.AdReport b(AdOrderItem adOrderItem, AdReportType adReportType) {
        AdReportList adReportList;
        com.tencent.tvideo.protocol.pb.AdReport adReport;
        if (adOrderItem == null || adReportType == null || y.i(adOrderItem.report_dict) || (adReportList = adOrderItem.report_dict.get(Integer.valueOf(adReportType.getValue()))) == null || y.h(adReportList.report_list) || (adReport = adReportList.report_list.get(0)) == null) {
            return null;
        }
        return adReport;
    }

    public static Map<String, String> c(AdOrderItem adOrderItem, AdReportType adReportType) {
        AdReportList adReportList;
        if (adOrderItem == null || adReportType == null || y.i(adOrderItem.report_dict) || (adReportList = adOrderItem.report_dict.get(Integer.valueOf(adReportType.getValue()))) == null) {
            return null;
        }
        return adReportList.reporter_dict;
    }
}
