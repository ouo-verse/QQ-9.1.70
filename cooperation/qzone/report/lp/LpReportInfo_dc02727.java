package cooperation.qzone.report.lp;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc02727 implements LpReportInfo {
    private static final String TAG = "LpReportInfo_dc02727";
    private String appId;
    private long batchCtrlElapse;
    private long ctrlElapse;
    private long dataElapse;
    private long elapse;
    private long endTime;
    private String entry = "";
    private String errMsg;
    private String extend;
    private long fileSize;
    private int flow;
    private int ipType;
    private int networkType;
    private String qua;
    private String refer;
    private int reportType;
    private int retCode;
    private int retCode2;
    private String serverIp;
    private String terminal;
    private String terminalVersion;
    private long uin;

    public LpReportInfo_dc02727(JSONObject jSONObject) {
        init(jSONObject);
        this.qua = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3();
    }

    private void init(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fileSize = jSONObject.optLong("size");
            this.elapse = jSONObject.optLong("delay");
            this.networkType = jSONObject.optInt("network");
            this.terminal = jSONObject.optString("terminal");
            this.terminalVersion = jSONObject.optString("terminalver");
            this.refer = jSONObject.optString("refer");
            this.retCode = jSONObject.optInt("errcode");
            this.uin = jSONObject.optLong("uin");
            this.endTime = jSONObject.optLong("time");
            this.flow = jSONObject.optInt("flow");
            this.serverIp = jSONObject.optString(TPReportKeys.LiveExKeys.LIVE_EX_S_IP);
            this.appId = jSONObject.optString("appid");
            this.errMsg = jSONObject.optString("msg");
            this.extend = jSONObject.optString(QFSEdgeItem.KEY_EXTEND);
            this.entry = jSONObject.optString("entry");
            this.ctrlElapse = jSONObject.optLong("ctrlDelay");
            this.dataElapse = jSONObject.optLong("dataDelay");
            this.batchCtrlElapse = jSONObject.optLong("batchCtrlDelayPer");
            this.reportType = jSONObject.optInt(AdMetricTag.Report.TYPE);
            this.ipType = jSONObject.optInt("ipType");
            this.retCode2 = jSONObject.optInt("errcode");
        }
    }

    public static void report(LpReportInfo_dc02727 lpReportInfo_dc02727, boolean z16, boolean z17) {
        LpReportManager.getInstance().reportToDC02727(lpReportInfo_dc02727, z16, z17);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc02727: flowId=" + this.flow + ", file size=" + this.fileSize + ", cost time=" + this.elapse;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("size", String.valueOf(this.fileSize));
        hashMap.put("delay", String.valueOf(this.elapse));
        hashMap.put("network", String.valueOf(this.networkType));
        hashMap.put("terminal", this.terminal);
        hashMap.put("terminalver", this.terminalVersion);
        hashMap.put("refer", this.refer);
        hashMap.put("errcode", String.valueOf(this.retCode));
        hashMap.put("uin", String.valueOf(this.uin));
        hashMap.put("time", String.valueOf(this.endTime));
        hashMap.put("flow", String.valueOf(this.flow));
        hashMap.put(TPReportKeys.LiveExKeys.LIVE_EX_S_IP, this.serverIp);
        hashMap.put("appid", this.appId);
        hashMap.put("msg", this.errMsg);
        hashMap.put(QFSEdgeItem.KEY_EXTEND, this.extend);
        hashMap.put("entry", this.entry);
        hashMap.put("ctrlDelay", String.valueOf(this.ctrlElapse));
        hashMap.put("dataDelay", String.valueOf(this.dataElapse));
        hashMap.put("batchCtrlDelayPer", String.valueOf(this.batchCtrlElapse));
        hashMap.put(AdMetricTag.Report.TYPE, String.valueOf(this.reportType));
        hashMap.put("qua", this.qua);
        hashMap.put("ipType", String.valueOf(this.ipType));
        hashMap.put("errcode2", String.valueOf(this.retCode2));
        return hashMap;
    }

    public static void report(JSONArray jSONArray, boolean z16, boolean z17) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                report(new LpReportInfo_dc02727(jSONArray.getJSONObject(i3)), z16, z17);
            } catch (Throwable th5) {
                th5.printStackTrace();
                return;
            }
        }
        QZLog.i(TAG, "upload2: report to lp dc02727");
    }
}
