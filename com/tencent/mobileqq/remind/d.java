package com.tencent.mobileqq.remind;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.l;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d extends WebViewPlugin implements l {

    /* renamed from: e, reason: collision with root package name */
    private static String f280881e = "remind";

    /* renamed from: d, reason: collision with root package name */
    protected Activity f280882d;

    @Override // com.tencent.mobileqq.webview.swift.l
    public String[] getMultiNameSpace() {
        return new String[]{"REMIND", QQPermissionConstants.Permission.CALENDAR_GROUP};
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.f280882d = this.mRuntime.a();
    }

    public void q(String str, JsBridgeListener jsBridgeListener) {
        c.c(this.f280882d, c.e(c.f(str, "currentDate")).longValue() * 1000, new a(), jsBridgeListener);
    }

    public void r(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f280881e, 2, "remindSuccess : " + str);
        }
        boolean d16 = c.d(c.f(str, "isNew"));
        boolean d17 = c.d(c.f(str, "isInsert"));
        c.f(str, "title");
        c.e(c.f(str, "startDate")).longValue();
        c.e(c.f(str, "endDate")).longValue();
        if (d16) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        if (d17) {
            str3 = "0";
        } else {
            str3 = "1";
        }
        if (QLog.isColorLevel()) {
            QLog.d(f280881e, 2, "createAndAddReport  r2: " + str3 + " r3: " + str2);
        }
        ReportController.o(null, "CliOper", "", "", "Time_reminder", "Updata_clock", 0, 0, str3, str2, "", "");
    }

    public void p(String str) {
        String str2;
        int[] iArr;
        CustomWebView e16 = this.mRuntime.e();
        if (e16 != null) {
            str2 = e16.getUrl();
        } else {
            str2 = "";
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                URLEncoder.encode(str2, "utf-8");
            }
            if (!TextUtils.isEmpty(str)) {
                URLEncoder.encode(str, "utf-8");
            }
        } catch (Exception e17) {
            if (QLog.isDevelopLevel()) {
                e17.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f280881e, 2, "createCalendar : " + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("title");
            long optLong = jSONObject.optLong("startDate");
            long optLong2 = jSONObject.optLong("endDate");
            String optString2 = jSONObject.optString("remark");
            String optString3 = jSONObject.optString("address");
            String optString4 = jSONObject.optString("callback");
            JSONArray optJSONArray = jSONObject.optJSONArray("reminds");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                iArr = null;
            } else {
                int[] iArr2 = new int[optJSONArray.length()];
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    iArr2[i3] = optJSONArray.getInt(i3);
                }
                iArr = iArr2;
            }
            if (!TextUtils.isEmpty(optString) && optLong >= 1 && optLong2 >= 1) {
                if (QLog.isColorLevel()) {
                    QLog.d(f280881e, 2, "startTime : " + e.a(optLong * 1000) + " endTime : " + e.a(optLong2 * 1000));
                }
                int b16 = c.b(this.f280882d, optString, optLong * 1000, optLong2 * 1000, optString2, optString3, iArr);
                if (!TextUtils.isEmpty(optString4)) {
                    super.callJs(optString4, "{\"retCode\":" + b16 + "}");
                }
                if (b16 == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(f280881e, 2, "addByRecevierReport");
                    }
                    ReportController.o(null, "CliOper", "", "", "Time_reminder", "Rec_ckl_add", 0, 0, "", "", "", "");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(f280881e, 2, "params error.");
            }
        } catch (JSONException e18) {
            if (QLog.isColorLevel()) {
                QLog.d(f280881e, 2, "JSONException " + e18.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("REMIND".equals(str2) && "createTimePicker".equals(str3)) {
            q(strArr[0], jsBridgeListener);
            return true;
        }
        if (QQPermissionConstants.Permission.CALENDAR_GROUP.equals(str2) && "addEvent".equals(str3)) {
            p(strArr[0]);
            return true;
        }
        if (QQPermissionConstants.Permission.CALENDAR_GROUP.equals(str2) && "remindSuccess".equals(str3)) {
            r(strArr[0]);
            return true;
        }
        if (QQPermissionConstants.Permission.CALENDAR_GROUP.equals(str2) && "remindDelete".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d(f280881e, 2, "deleteRemindSuccess");
            }
            ReportController.o(null, "CliOper", "", "", "Time_reminder", "Delete_clock", 0, 0, "", "", "", "");
            return true;
        }
        if (QQPermissionConstants.Permission.CALENDAR_GROUP.equals(str2) && "remindMsgReport".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d(f280881e, 2, "remindMsgReport : " + strArr[0]);
            }
            ReportController.o(null, "CliOper", "", "", "Time_reminder", "Obj_clock", 0, 0, c.f(strArr[0], "entranceType"), c.f(strArr[0], "role"), "", "");
            return true;
        }
        if (!QQPermissionConstants.Permission.CALENDAR_GROUP.equals(str2) || !"remindAioReport".equals(str3)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f280881e, 2, "remindAioReport");
        }
        ReportController.o(null, "CliOper", "", "", "Time_reminder", "Clock_card_clk", 0, 0, "", "", "", "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements IosTimepicker.f {
        a() {
        }

        @Override // com.tencent.mobileqq.remind.widget.IosTimepicker.f
        public void a(long j3) {
        }
    }
}
