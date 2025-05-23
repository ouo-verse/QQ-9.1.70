package cooperation.qzone.report.lp;

import com.tencent.mobileqq.minigame.minigamecenter.hippy.MiniGameCenterHippyFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpreportInfo_dc02910 implements LpReportInfo {
    public int index;
    public int operTimes;
    public int operType;
    public String traceInfo;
    public long uin;

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return String.format("dc02910 traceinfo:%s ,index:%d,operType:%d operTime:%d", this.traceInfo, Integer.valueOf(this.index), Integer.valueOf(this.operType), Integer.valueOf(this.operTimes));
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        hashMap.put("uin", String.valueOf(this.uin));
        hashMap.put(MiniGameCenterHippyFragment.EXTRA_KEY_AD_TRACE_INFO, String.valueOf(this.traceInfo));
        hashMap.put("idx", String.valueOf(this.index));
        hashMap.put("opt_times", String.valueOf(this.operTimes));
        hashMap.put("opt_type", String.valueOf(this.operType));
        return hashMap;
    }
}
