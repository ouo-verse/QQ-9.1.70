package cooperation.qzone.mobilereport;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ReportKey {
    final String adId;
    final int appId;
    final String itemId;
    final String moduleId;
    final String pageAppId;
    final String pageId;
    final String schemaUrl;
    final String traceId;
    final String traceInfo;
    final int traceNum;

    public ReportKey(String str, int i3, String str2, int i16, String str3, String str4) {
        this(str, i3, str2, i16, str3, str4, "", "");
    }

    public static ReportKey build(@NonNull BusinessInfoCheckUpdate.AppInfo appInfo) {
        String str;
        int i3;
        String str2;
        String str3;
        int i16;
        int i17;
        String str4 = appInfo.buffer.get();
        String str5 = "0";
        int i18 = 0;
        if (TextUtils.isEmpty(str4)) {
            str3 = "0";
            str2 = str3;
            i17 = 0;
            i16 = 0;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str4);
                String string = jSONObject.getString("trace_id");
                try {
                    i3 = jSONObject.getInt("trace_num") + 1;
                    try {
                        str5 = jSONObject.getString("ad_id");
                        i18 = appInfo.uiAppId.get();
                        str3 = string;
                        str2 = str5;
                    } catch (Exception e16) {
                        e = e16;
                        String str6 = str5;
                        str5 = string;
                        str = str6;
                        e.printStackTrace();
                        str2 = str;
                        str3 = str5;
                        i16 = i18;
                        i17 = i3;
                        return new ReportKey(str3, i17, str2, i16, "vab_red", "vab_red");
                    }
                } catch (Exception e17) {
                    e = e17;
                    i3 = 0;
                }
            } catch (Exception e18) {
                e = e18;
                str = "0";
                i3 = 0;
            }
            i16 = i18;
            i17 = i3;
        }
        return new ReportKey(str3, i17, str2, i16, "vab_red", "vab_red");
    }

    public String buildTraceDetail() {
        return "trace_detail_ad_id=" + this.adId + "&trace_detail_app_id=" + this.appId;
    }

    public String buildTraceDetail2() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.pageAppId);
            jSONObject.put("page_id", this.pageId);
            jSONObject.put("module_id", this.moduleId);
            jSONObject.put("item_id", this.itemId);
        } catch (JSONException e16) {
            QLog.e("ReportKey", 1, "buildTraceDetail2 exception", e16);
        }
        return jSONObject.toString();
    }

    public String buildTraceDetail3() {
        try {
            String optString = new JSONObject(this.traceInfo).optString("trace_detail");
            if (!TextUtils.isEmpty(optString)) {
                return optString;
            }
            return "";
        } catch (Exception e16) {
            QLog.i("UserActionReportBuilder", 1, "trace_info exception", e16);
            return "";
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ReportKey reportKey = (ReportKey) obj;
        if (this.traceNum == reportKey.traceNum && this.traceId.equals(reportKey.traceId) && this.adId.equals(reportKey.adId) && this.appId == reportKey.appId && this.pageAppId.equals(reportKey.pageAppId) && this.pageId.equals(reportKey.pageId) && this.schemaUrl.equals(reportKey.schemaUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.traceId.hashCode();
    }

    public String toString() {
        return "ReportKey{traceId='" + this.traceId + ", traceNum=" + this.traceNum + ", adId=" + this.adId + ", appId=" + this.appId + ", schemaUrl=" + this.schemaUrl + '}';
    }

    public ReportKey(String str, int i3, String str2, int i16, String str3, String str4, String str5, String str6) {
        this(str, i3, str2, i16, str3, str4, str5, str6, "");
    }

    public ReportKey(String str, int i3, String str2, int i16, String str3, String str4, String str5, String str6, String str7) {
        this.traceId = str;
        this.traceNum = i3;
        this.adId = str2;
        this.appId = i16;
        this.pageAppId = str3;
        this.pageId = str4;
        this.schemaUrl = "";
        this.moduleId = str5;
        this.itemId = str6;
        this.traceInfo = str7;
    }

    public ReportKey(String str, String str2) {
        this.appId = 0;
        this.schemaUrl = str2;
        this.traceId = "";
        this.traceNum = 0;
        this.adId = "";
        this.pageAppId = str;
        this.pageId = "";
        this.moduleId = "";
        this.itemId = "";
        this.traceInfo = "";
    }
}
