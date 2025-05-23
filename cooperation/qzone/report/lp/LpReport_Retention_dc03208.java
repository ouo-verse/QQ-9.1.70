package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReport_Retention_dc03208 implements LpReportInfo {
    public static final String TAG = "LpReport.LpReport_Retention_dc03208";
    public int device;
    public String function;
    public String mobile_type;
    public int network_type;
    public String qua;
    public String reserves;
    public String reserves2;
    public String reserves3;
    public long uin;
    public String version;

    public LpReport_Retention_dc03208(String str, String str2) {
        this.function = str;
        this.reserves = str2;
    }

    public static void report(String str, HashMap<String, String> hashMap) {
        String str2;
        if (hashMap != null) {
            str2 = hashMap.toString();
        } else {
            str2 = null;
        }
        LpReportManager.getInstance().reportToDC03208(new LpReport_Retention_dc03208(str, str2), false, false);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "function:" + this.function;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        LpReportUtils.safePut(hashMap, "uin", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount());
        LpReportUtils.safePut(hashMap, "qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        hashMap.put("network_type", String.valueOf(((ILpReportUtils) QRoute.api(ILpReportUtils.class)).convertNetworkTypeToFitInDc00518(((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getNetworkType())));
        LpReportUtils.safePut(hashMap, "mobile_type", DeviceInfoMonitor.getModel());
        hashMap.put("device", "2");
        LpReportUtils.safePut(hashMap, "function", this.function);
        LpReportUtils.safePut(hashMap, "version", this.version);
        LpReportUtils.safePut(hashMap, "reserves", this.reserves);
        LpReportUtils.safePut(hashMap, "reserves2", this.reserves2);
        LpReportUtils.safePut(hashMap, "reserves3", this.reserves3);
        return hashMap;
    }
}
