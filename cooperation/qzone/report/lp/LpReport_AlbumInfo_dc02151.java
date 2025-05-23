package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReport_AlbumInfo_dc02151 implements LpReportInfo {
    public String client_time;
    public long event_id;
    public String latitude;
    public String longitude;
    public long operation_id;
    public String qua;
    public long recommend_id;
    public long recommend_index;
    public String recommend_title;
    public long uin;
    public String version;

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return null;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        String valueOf;
        String str;
        String str2;
        HashMap hashMap = new HashMap();
        long j3 = this.uin;
        if (j3 <= 1000) {
            valueOf = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount();
        } else {
            valueOf = String.valueOf(j3);
        }
        hashMap.put("uin", valueOf);
        LpReportUtils.safePut(hashMap, "qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        if (TextUtils.isEmpty(this.client_time)) {
            str = String.valueOf(System.currentTimeMillis());
        } else {
            str = this.client_time;
        }
        hashMap.put("client_time", str);
        LpReportUtils.safePut(hashMap, "longitude", this.longitude);
        LpReportUtils.safePut(hashMap, "latitude", this.latitude);
        hashMap.put("event_id", String.valueOf(this.event_id));
        hashMap.put("operation_id", String.valueOf(this.operation_id));
        LpReportUtils.safePut(hashMap, "recommend_title", this.recommend_title);
        hashMap.put("recommend_index", String.valueOf(this.recommend_index));
        hashMap.put("recommend_id", String.valueOf(this.recommend_id));
        if (TextUtils.isEmpty(this.version)) {
            str2 = AppSetting.f99551k;
        } else {
            str2 = this.version;
        }
        LpReportUtils.safePut(hashMap, "version", str2);
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
