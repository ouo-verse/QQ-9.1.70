package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_DC02543 implements LpReportInfo {
    private static final String QUA = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3();
    private static final String TABLE_NAME = "DC02543";
    private long clientTime;
    private String envent;
    private HashMap<String, String> msgMap;
    private String retcode;
    private long serverTime;
    private long timeCost;
    private String uin;

    public LpReportInfo_DC02543(String str, String str2, String str3, long j3, HashMap<String, String> hashMap) {
        this.uin = str;
        this.envent = str2;
        this.retcode = str3;
        this.timeCost = j3;
        this.msgMap = hashMap;
        this.clientTime = System.currentTimeMillis();
        this.serverTime = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getServerTimeMillis();
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return TABLE_NAME;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        String str = "";
        if (this.msgMap != null) {
            try {
                str = new JSONObject(this.msgMap).toString();
            } catch (Exception e16) {
                QZLog.d(QZLog.TO_DEVICE_TAG, 4, "", e16);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Uin", this.uin);
        hashMap.put("Event", this.envent);
        hashMap.put("RetCode", this.retcode);
        hashMap.put("TimeCost", String.valueOf(this.timeCost));
        hashMap.put("msg", str);
        hashMap.put("QUA", QUA);
        hashMap.put("clientTime", String.valueOf(this.clientTime));
        hashMap.put("serverTime", String.valueOf(this.serverTime));
        return hashMap;
    }

    public LpReportInfo_DC02543(String str, String str2, long j3) {
        this(str, str2, "0", j3, null);
    }
}
