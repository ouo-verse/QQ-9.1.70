package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_DC02293 implements LpReportInfo {
    private static String TAG = "LpReport.LpReportInfo_DC02293";
    private String mMsg;
    private String mQzoneCmd;
    private int mRetCode;
    private long mTimeCost;

    public LpReportInfo_DC02293(String str, int i3, String str2, long j3) {
        this.mQzoneCmd = str;
        this.mRetCode = i3;
        this.mMsg = str2;
        if (j3 > 0) {
            this.mTimeCost = System.currentTimeMillis() - j3;
        }
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "DC02293";
    }

    public String getStringDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("Uin", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount());
        hashMap.put("tabletype", String.valueOf(21));
        LpReportUtils.safePut(hashMap, "LogTime", getStringDate());
        hashMap.put("Event", this.mQzoneCmd);
        hashMap.put("RetCode", String.valueOf(this.mRetCode));
        String str = this.mMsg;
        if (str == null) {
            str = "";
        }
        hashMap.put("CmdMsg", str);
        hashMap.put("TimeCost", String.valueOf(this.mTimeCost));
        hashMap.put("AppId", "Android-QzoneInQQ");
        hashMap.put("network", String.valueOf(((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getnetworkType()));
        hashMap.put("qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        hashMap.put("deviceinfo", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        return hashMap;
    }
}
