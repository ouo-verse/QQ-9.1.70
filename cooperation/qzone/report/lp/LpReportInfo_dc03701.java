package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc03701 implements LpReportInfo {
    public static String TAG = "LpReport.LpReportInfo_dc03701";
    public String actiontype;
    public HashMap<String, String> extraInfoMap;
    private boolean isNeedSample;
    private boolean isReportNow;
    public String qua;
    public String reserves;
    public String subactiontype;
    public long uin;

    public LpReportInfo_dc03701(String str, String str2) {
        this.actiontype = str;
        this.subactiontype = str2;
        this.isNeedSample = false;
        this.isReportNow = false;
    }

    public static void report(LpReportInfo_dc03701 lpReportInfo_dc03701) {
        LpReportManager.getInstance().reportToDC03701(lpReportInfo_dc03701, lpReportInfo_dc03701.isNeedSample, lpReportInfo_dc03701.isReportNow);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc03701:" + this.actiontype + "," + this.subactiontype + "," + this.reserves;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        String valueOf;
        HashMap hashMap = new HashMap();
        LpReportUtils.safePut(hashMap, "qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        long j3 = this.uin;
        if (j3 == 0) {
            valueOf = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount();
        } else {
            valueOf = String.valueOf(j3);
        }
        LpReportUtils.safePut(hashMap, "uin", valueOf);
        LpReportUtils.safePut(hashMap, "actiontype", this.actiontype);
        LpReportUtils.safePut(hashMap, "subactiontype", this.subactiontype);
        LpReportUtils.safePut(hashMap, "reserves", this.reserves);
        HashMap<String, String> hashMap2 = this.extraInfoMap;
        if (hashMap2 != null && hashMap2.size() > 0) {
            hashMap.putAll(this.extraInfoMap);
        }
        return hashMap;
    }

    public LpReportInfo_dc03701(String str, String str2, String str3) {
        this(str, str2);
        this.reserves = str3;
    }

    public LpReportInfo_dc03701(String str, String str2, String str3, HashMap<String, String> hashMap) {
        this(str, str2, str3);
        this.extraInfoMap = hashMap;
    }
}
