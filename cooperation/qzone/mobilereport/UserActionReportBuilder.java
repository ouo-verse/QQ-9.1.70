package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.ItemInfo;
import NS_USER_ACTION_REPORT.PageInfo;
import NS_USER_ACTION_REPORT.TraceInfo;
import NS_USER_ACTION_REPORT.UserActionReport;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class UserActionReportBuilder {
    public static boolean IS_SUPPORT_JSON_TRACE = ar.b("rizzhuang", "2024-08-27", "vas_04586_support_json_trace").isEnable(true);
    private ArrayList<ItemInfo> itemInfos = new ArrayList<>();
    private ReportKey reportKey;

    public UserActionReportBuilder addItemInfo(ItemInfo itemInfo) {
        this.itemInfos.add(itemInfo);
        return this;
    }

    public UserActionReport build() {
        UserActionReport userActionReport = new UserActionReport();
        PageInfo pageInfo = new PageInfo();
        ReportKey reportKey = this.reportKey;
        pageInfo.appid = reportKey.pageAppId;
        pageInfo.page_id = reportKey.pageId;
        pageInfo.item_infos = this.itemInfos;
        userActionReport.page_info = pageInfo;
        TraceInfo traceInfo = new TraceInfo();
        traceInfo.trace_id = this.reportKey.traceId;
        traceInfo.trace_num = r5.traceNum;
        try {
            JSONObject jSONObject = new JSONObject(this.reportKey.traceInfo);
            String optString = jSONObject.optString("traceDetail", jSONObject.optString("trace_detail", jSONObject.optString("tracedetail", "")));
            if (TextUtils.isEmpty(optString)) {
                JSONObject optJSONObject = jSONObject.optJSONObject("traceDetail");
                if (optJSONObject == null) {
                    optJSONObject = jSONObject.optJSONObject("trace_detail");
                }
                if (optJSONObject == null) {
                    optJSONObject = jSONObject.optJSONObject("tracedetail");
                }
                if (optJSONObject != null) {
                    optString = optJSONObject.toString();
                }
            }
            if (!TextUtils.isEmpty(optString)) {
                traceInfo.trace_id = jSONObject.optString("traceId", jSONObject.optString("trace_id", jSONObject.optString("traceid")));
                traceInfo.trace_num = jSONObject.optInt("traceNum", jSONObject.optInt("trace_num", jSONObject.optInt("tracenum")));
                traceInfo.trace_index = jSONObject.optString("traceIndex", jSONObject.optString("trace_index", jSONObject.optString("traceindex")));
                traceInfo.trace_detail = optString;
            }
        } catch (Exception e16) {
            QLog.i("UserActionReportBuilder", 1, "trace_info exception", e16);
        }
        if (TextUtils.isEmpty(traceInfo.trace_detail)) {
            if (IS_SUPPORT_JSON_TRACE) {
                traceInfo.trace_detail = this.reportKey.buildTraceDetail2();
            } else {
                traceInfo.trace_detail = this.reportKey.buildTraceDetail();
            }
        }
        userActionReport.trace_info = traceInfo;
        return userActionReport;
    }

    public UserActionReportBuilder setReportKey(ReportKey reportKey) {
        this.reportKey = reportKey;
        return this;
    }
}
