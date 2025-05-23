package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_lbs;
import NS_MOBILE_FEEDS.s_gps;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ProgressTracer;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellLbsInfo implements SmartParcelable {
    public static final String LBS_TAB = "lbs_tab";

    @NeedParcel
    public s_gps gps;

    @NeedParcel
    public GpsInfo gpsInfo;
    public Integer integerUniKey;

    @NeedParcel
    public String location;
    public String uniKey;

    @NeedParcel
    public Map<String, String> extendinfo = null;

    @NeedParcel
    public boolean showlbs = true;

    @NeedParcel
    public String iconToken = "";

    public String getLBSString() {
        return this.location;
    }

    public boolean isGpsValid() {
        int i3;
        s_gps s_gpsVar = this.gps;
        return (s_gpsVar == null || ((i3 = s_gpsVar.altitude) == 0 && s_gpsVar.longitude == 0 && i3 == 0)) ? false : true;
    }

    public boolean needShowLbs() {
        return this.showlbs;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellLbsInfo {\n");
        if (!TextUtils.isEmpty(this.location)) {
            sb5.append("location: ");
            sb5.append(this.location);
            sb5.append(", ");
        }
        if (this.gpsInfo != null) {
            sb5.append("gpsInfo: ");
            sb5.append(this.gpsInfo.toString());
            sb5.append("\n");
        }
        Map<String, String> map = this.extendinfo;
        if (map != null) {
            sb5.append("extendinfo: {\n");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb5.append((Object) entry.getKey());
                sb5.append(ProgressTracer.SEPARATOR);
                sb5.append((Object) entry.getValue());
                sb5.append("\n");
            }
            sb5.append("}");
            sb5.append("\n");
        }
        return sb5.toString();
    }

    public static CellLbsInfo create(l lVar) {
        if (lVar == null || lVar.f50358j == null) {
            return null;
        }
        CellLbsInfo cellLbsInfo = new CellLbsInfo();
        s_gps s_gpsVar = lVar.f50358j.gps;
        cellLbsInfo.gpsInfo = new GpsInfo((int) (s_gpsVar.longitude / 1000.0f), (int) (s_gpsVar.latitude / 1000.0f), (int) (s_gpsVar.altitude / 1000.0f), 0);
        cell_lbs cell_lbsVar = lVar.f50358j;
        cellLbsInfo.location = cell_lbsVar.location;
        cellLbsInfo.extendinfo = cell_lbsVar.extendinfo;
        cellLbsInfo.gps = cell_lbsVar.gps;
        cellLbsInfo.iconToken = cell_lbsVar.icon_token;
        return cellLbsInfo;
    }

    String getLbsJumpInfo(CellLbsInfo cellLbsInfo) {
        String str;
        if (cellLbsInfo != null && cellLbsInfo.extendinfo != null && !TextUtils.isEmpty(cellLbsInfo.location)) {
            String str2 = cellLbsInfo.extendinfo.get("jump_type");
            String str3 = cellLbsInfo.extendinfo.get("jump_id");
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                str = null;
            } else {
                str = "https://m.qzone.com/urljump/urljump?jump_type=" + str2 + "&jump_id=" + str3;
            }
            if (!TextUtils.isEmpty(str)) {
                return "{url:" + str + ",text:" + cellLbsInfo.location + "}";
            }
        }
        return null;
    }
}
