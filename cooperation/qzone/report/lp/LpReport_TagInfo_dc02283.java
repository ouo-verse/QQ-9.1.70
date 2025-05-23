package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReport_TagInfo_dc02283 implements LpReportInfo {
    public int data_version;
    public long operation_id;
    public long operation_type;
    public String photo_id;
    public String photo_tag;
    public String qua;
    public long uin;
    public int version_code;

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
        hashMap.put("operation_id", String.valueOf(this.operation_id));
        hashMap.put("operation_type", String.valueOf(this.operation_type));
        LpReportUtils.safePut(hashMap, "photo_id", this.photo_id);
        LpReportUtils.safePut(hashMap, QCircleLpReportDc05494.KEY_PHOTO_TAG, this.photo_tag);
        LpReportUtils.safePut(hashMap, "qua", this.qua);
        hashMap.put("version_code", String.valueOf(this.version_code));
        hashMap.put("data_version", String.valueOf(this.data_version));
        return hashMap;
    }
}
