package cooperation.qzone.report.lp;

import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc02795 implements LpReportInfo {
    private JSONObject reportInfo;

    public LpReportInfo_dc02795(JSONObject jSONObject) {
        this.reportInfo = jSONObject;
    }

    public static void report(JSONObject jSONObject, boolean z16) {
        if (jSONObject == null) {
            return;
        }
        QZLog.i("PublishQueue:report", jSONObject.toString());
        LpReportManager.getInstance().reportToDC02795(new LpReportInfo_dc02795(jSONObject), z16, false);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        if (this.reportInfo == null) {
            return "dc02795";
        }
        return "dc02795: task_type=" + this.reportInfo.optString("task_type") + ", task_time:" + this.reportInfo.optString("task_time") + ", media_num:" + this.reportInfo.optString("media_num");
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = this.reportInfo;
        if (jSONObject != null) {
            hashMap.put("uin", jSONObject.optString("uin"));
            hashMap.put("model", this.reportInfo.optString("model"));
            hashMap.put("qua", this.reportInfo.optString("qua"));
            hashMap.put("task_type", this.reportInfo.optString("task_type"));
            hashMap.put("task_subtype", this.reportInfo.optString("task_subtype"));
            hashMap.put("task_time", this.reportInfo.optString("task_time"));
            hashMap.put("retry_count", this.reportInfo.optString("retry_count"));
            hashMap.put("media_num", this.reportInfo.optString("media_num"));
            hashMap.put("video_num", this.reportInfo.optString("video_num"));
            hashMap.put("video_origin_size", this.reportInfo.optString("video_origin_size"));
            hashMap.put("video_compressed_size", this.reportInfo.optString("video_compressed_size"));
            hashMap.put("video_compress_time", this.reportInfo.optString("video_compress_time"));
            hashMap.put("video_extend", this.reportInfo.optString("video_extend"));
            hashMap.put("photo_num", this.reportInfo.optString("photo_num"));
            hashMap.put("photo_origin_size", this.reportInfo.optString("photo_origin_size"));
            hashMap.put("photo_compressed_size", this.reportInfo.optString("photo_compressed_size"));
            hashMap.put("photo_compress_time", this.reportInfo.optString("photo_compress_time"));
            hashMap.put("photo_extend", this.reportInfo.optString("photo_extend"));
        }
        return hashMap;
    }
}
