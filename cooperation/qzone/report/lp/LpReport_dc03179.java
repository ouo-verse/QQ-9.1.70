package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReport_dc03179 implements LpReportInfo {
    String appid;
    String attach_info;
    String client_time;
    String device_model;
    float exif_avg_cost;
    int exif_error_count;
    float face_avg_cost;
    int face_error_count;
    int pause_reason;
    String qua;
    int scan_photo_count;
    int scanned_exif_count;
    int scanned_face_count;
    int scanned_tag_count;
    float tag_avg_cost;
    int tag_error_count;
    int total_photo_count;
    int total_scanned_exif_count;
    int total_scanned_face_count;
    int total_scanned_tag_count;
    String uin;

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc03179:, total_photo_count" + this.total_photo_count + ", scan_photo_count=" + this.scan_photo_count;
    }

    public void report(int i3, int i16, int i17, int i18, float f16, int i19, int i26, int i27, float f17, int i28, int i29, int i36, float f18, int i37, int i38, String str) {
        LpReport_dc03179 lpReport_dc03179 = new LpReport_dc03179();
        lpReport_dc03179.total_photo_count = i3;
        lpReport_dc03179.scan_photo_count = i16;
        lpReport_dc03179.scanned_exif_count = i17;
        lpReport_dc03179.total_scanned_exif_count = i18;
        lpReport_dc03179.exif_avg_cost = f16;
        lpReport_dc03179.exif_error_count = i19;
        lpReport_dc03179.scanned_tag_count = i26;
        lpReport_dc03179.total_scanned_tag_count = i27;
        lpReport_dc03179.tag_avg_cost = f17;
        lpReport_dc03179.tag_error_count = i28;
        lpReport_dc03179.scanned_face_count = i29;
        lpReport_dc03179.total_scanned_face_count = i36;
        lpReport_dc03179.face_avg_cost = f18;
        lpReport_dc03179.face_error_count = i37;
        lpReport_dc03179.pause_reason = i38;
        lpReport_dc03179.client_time = str;
        LpReportManager.getInstance().reportToDC03179(lpReport_dc03179, false, true);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount())) {
            LpReportUtils.safePut(hashMap, "uin", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount());
        }
        LpReportUtils.safePut(hashMap, "qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        LpReportUtils.safePut(hashMap, "total_photo_count", this.total_photo_count);
        LpReportUtils.safePut(hashMap, "scan_photo_count", this.scan_photo_count);
        LpReportUtils.safePut(hashMap, "scanned_exif_count", this.scanned_exif_count);
        LpReportUtils.safePut(hashMap, "total_scanned_exif_count", this.total_scanned_exif_count);
        LpReportUtils.safePut(hashMap, "exif_avg_cost", String.format("%.2f", Float.valueOf(this.exif_avg_cost)));
        LpReportUtils.safePut(hashMap, "exif_error_count", this.exif_error_count);
        LpReportUtils.safePut(hashMap, "scanned_tag_count", this.scanned_tag_count);
        LpReportUtils.safePut(hashMap, "total_scanned_tag_count", this.total_scanned_tag_count);
        LpReportUtils.safePut(hashMap, "tag_avg_cost", String.format("%.2f", Float.valueOf(this.tag_avg_cost)));
        LpReportUtils.safePut(hashMap, "tag_error_count", this.tag_error_count);
        LpReportUtils.safePut(hashMap, "scanned_face_count", this.scanned_face_count);
        LpReportUtils.safePut(hashMap, "total_scanned_face_count", this.total_scanned_face_count);
        LpReportUtils.safePut(hashMap, "face_avg_cost", String.format("%.2f", Float.valueOf(this.face_avg_cost)));
        LpReportUtils.safePut(hashMap, "face_error_count", this.face_error_count);
        LpReportUtils.safePut(hashMap, "pause_reason", this.pause_reason);
        LpReportUtils.safePut(hashMap, "device_model", DeviceInfoMonitor.getModel());
        LpReportUtils.safePut(hashMap, "appid", String.valueOf(1000027));
        LpReportUtils.safePut(hashMap, "attach_info", this.attach_info);
        LpReportUtils.safePut(hashMap, "client_time", this.client_time);
        return hashMap;
    }
}
