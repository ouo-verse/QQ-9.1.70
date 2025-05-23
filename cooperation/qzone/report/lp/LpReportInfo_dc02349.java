package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc02349 implements LpReportInfo {
    public int downloadType;
    public String downloadUrl;
    public String errMsg;
    public int isHttp2;
    public String qua;
    public int retCode;
    public long uin;

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return null;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        String valueOf;
        HashMap hashMap = new HashMap();
        long j3 = this.uin;
        if (j3 <= 1000) {
            valueOf = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount();
        } else {
            valueOf = String.valueOf(j3);
        }
        hashMap.put("uin", valueOf);
        LpReportUtils.safePut(hashMap, "qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        hashMap.put("downloadType", String.valueOf(this.downloadType));
        hashMap.put("isHttp2", String.valueOf(this.isHttp2));
        hashMap.put("retCode", String.valueOf(this.retCode));
        LpReportUtils.safePut(hashMap, "downloadUrl", this.downloadUrl);
        LpReportUtils.safePut(hashMap, "errMsg", this.errMsg);
        return hashMap;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        try {
            Field[] declaredFields = getClass().getDeclaredFields();
            for (int i3 = 0; i3 < declaredFields.length; i3++) {
                sb5.append(declaredFields[i3].getName());
                Object obj = declaredFields[i3].get(this);
                if (obj != null) {
                    sb5.append(":");
                    sb5.append(obj);
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
