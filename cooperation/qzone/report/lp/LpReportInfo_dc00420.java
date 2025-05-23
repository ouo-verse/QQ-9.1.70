package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc00420 implements LpReportInfo {
    public int Active;
    public int actionid;
    public int actiontype;
    public String apilevel;
    public int clientid;
    public String display;
    public String gateway_ip;
    public String imei;
    public int interact_type;
    public int is_online;
    public int isbreak;
    public int mainid;
    public int mergenum;
    public int mergetype;
    public String mobile_type;
    int mubanid;
    public String network_type;
    public String os_version;
    public String pushstatkey;
    public String qua;
    public String reserves;
    public int subactiontype;
    public String system_rom_type;
    public int type;
    public long uin;

    public LpReportInfo_dc00420(int i3, int i16, String str, String str2, int i17) {
        this.actiontype = i3;
        this.subactiontype = i16;
        this.reserves = str;
        this.pushstatkey = str2;
        this.mergenum = i17;
    }

    public static void report(int i3, int i16, String str, String str2, int i17) {
        LpReportManager.getInstance().reportToDC00420(new LpReportInfo_dc00420(i3, i16, str, str2, i17), false, true);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc00420:" + this.actiontype + "," + this.subactiontype + "," + this.reserves;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("uin", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount());
        hashMap.put("actiontype", String.valueOf(this.actiontype));
        hashMap.put("subactiontype", String.valueOf(this.subactiontype));
        LpReportUtils.safePut(hashMap, "reserves", this.reserves);
        LpReportUtils.safePut(hashMap, "pushstatkey", this.pushstatkey);
        hashMap.put("qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        hashMap.put("mergenum", String.valueOf(this.mergenum));
        return hashMap;
    }
}
