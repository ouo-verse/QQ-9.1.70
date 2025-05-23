package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc02216 implements LpReportInfo {
    public static final int ACTION_TYPE_HOME_PAGE_FOOTER_BANNER = 17;
    public static final int SUB_ACTION_FOOTER_BANNER_CLICK = 1;
    public static final int SUB_ACTION_FOOTER_BANNER_CLOSE = 2;
    public static final int SUB_ACTION_FOOTER_BANNER_EXPOSE = 3;
    public int actiontype;
    public String platform;
    public String qua;
    public int subactiontype;
    public long uin;

    public LpReportInfo_dc02216(int i3, int i16) {
        this.actiontype = i3;
        this.subactiontype = i16;
    }

    public static void reportExit() {
        LpReportManager.getInstance().reportToDC02216(new LpReportInfo_dc02216(9, 4), false, true);
    }

    public static void reportSend() {
        LpReportManager.getInstance().reportToDC02216(new LpReportInfo_dc02216(9, 2), false, true);
    }

    public static void reportShare() {
        LpReportManager.getInstance().reportToDC02216(new LpReportInfo_dc02216(9, 1), false, true);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc02216:actiontype:" + this.actiontype + " subactiontype:" + this.subactiontype;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        long j3 = this.uin;
        if (j3 != 0) {
            hashMap.put("uin", String.valueOf(j3));
        } else {
            hashMap.put("uin", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount());
        }
        hashMap.put("qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        LpReportUtils.safePut(hashMap, "platform", this.platform);
        hashMap.put("actiontype", String.valueOf(this.actiontype));
        hashMap.put("subactiontype", String.valueOf(this.subactiontype));
        return hashMap;
    }
}
