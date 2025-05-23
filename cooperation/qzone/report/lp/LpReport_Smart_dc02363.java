package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReport_Smart_dc02363 implements LpReportInfo {
    public long batch_id;

    /* renamed from: msg, reason: collision with root package name */
    public String f390870msg;
    public String qua;
    public long uin;

    public LpReport_Smart_dc02363(long j3, String str) {
        this.batch_id = j3;
        this.f390870msg = str;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc02363:batch_id:," + this.batch_id;
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
        hashMap.put(JobDbManager.COL_UP_BATCH_ID, String.valueOf(this.batch_id));
        LpReportUtils.safePut(hashMap, "msg", this.f390870msg);
        return hashMap;
    }
}
