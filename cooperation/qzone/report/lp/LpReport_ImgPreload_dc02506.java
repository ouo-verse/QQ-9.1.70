package cooperation.qzone.report.lp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes28.dex */
public class LpReport_ImgPreload_dc02506 implements LpReportInfo {
    private static String TAG = "LpReport_ImgPreload_dc02506";
    private ConcurrentHashMap<String, String> reportMap;

    public LpReport_ImgPreload_dc02506(ConcurrentHashMap<String, String> concurrentHashMap) {
        this.reportMap = concurrentHashMap;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return null;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        return this.reportMap;
    }

    public String toString() {
        if (this.reportMap == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        try {
            for (String str : this.reportMap.keySet()) {
                String str2 = this.reportMap.get(str);
                sb5.append(str);
                if (str2 != null) {
                    sb5.append(":");
                    sb5.append(str2);
                    sb5.append("\n");
                } else {
                    sb5.append(":null \n");
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return sb5.toString();
    }
}
