package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.peak.PeakConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc04021 implements LpReportInfo {
    public long delayCallback;
    public long flingCallback;
    public long idleCallback;
    public long intimeCallback;
    public long noCallback;
    private String qua = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3();
    public long totalDuration;
    public long touchScrollCallback;

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc04021: total_duration=" + this.totalDuration + " intime_callback=" + this.intimeCallback + " delay_callback=" + this.delayCallback + " no_callback=" + this.noCallback + " idle_callback=" + this.idleCallback + " touch_scroll_callback=" + this.touchScrollCallback + " fling_callback=" + this.flingCallback;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put(PeakConstants.VIDEO_TOTAL_DURATION, String.valueOf(this.totalDuration));
        hashMap.put("intime_callback", String.valueOf(this.intimeCallback));
        hashMap.put("delay_callback", String.valueOf(this.delayCallback));
        hashMap.put("no_callback", String.valueOf(this.noCallback));
        hashMap.put("idle_callback", String.valueOf(this.idleCallback));
        hashMap.put("touch_scroll_callback", String.valueOf(this.touchScrollCallback));
        hashMap.put("fling_callback", String.valueOf(this.flingCallback));
        hashMap.put("qua", this.qua);
        return hashMap;
    }
}
