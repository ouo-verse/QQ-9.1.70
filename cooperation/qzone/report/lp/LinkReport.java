package cooperation.qzone.report.lp;

import cooperation.qzone.util.TimeCostTrace;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LinkReport {
    public static void reportClickQZoneEntry(String str) {
        LpReportManager.getInstance().reportToDC02543(new LpReportInfo_DC02543(str, "LebaClickQZoneEntry", 0L));
    }

    public static void reportEvent(String str, String str2, long j3) {
        LpReportManager.getInstance().reportToDC02543(new LpReportInfo_DC02543(str, str2, j3));
    }

    public static void reportMoreFeedEnd(String str, long j3) {
        LpReportManager.getInstance().reportToDC02543(new LpReportInfo_DC02543(str, "MoreFeedEnd", j3));
    }

    public static void reportMoreFeedStart(String str) {
        LpReportManager.getInstance().reportToDC02543(new LpReportInfo_DC02543(str, "MoreFeedStart", 0L));
    }

    public static void reportQZoneLaunch(String str, long j3, HashMap<String, String> hashMap) {
        LpReportManager.getInstance().reportToDC02543(new LpReportInfo_DC02543(str, TimeCostTrace.TAG_QZONE_LAUNCH, "0", j3, hashMap));
    }

    public static void reportRefreshFeedEnd(String str, long j3) {
        LpReportManager.getInstance().reportToDC02543(new LpReportInfo_DC02543(str, "RefreshFeedEnd", j3));
    }

    public static void reportRefreshFeedStart(String str) {
        LpReportManager.getInstance().reportToDC02543(new LpReportInfo_DC02543(str, "RefreshFeedStart", 0L));
    }
}
