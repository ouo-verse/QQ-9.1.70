package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.ecommerce.richtext.annotation.JSMethod;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.f;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.BridgeModuleHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class e extends gk0.a implements f {
    private HashMap c() {
        HashMap hashMap = new HashMap();
        QQAppInterface qQAppInterface = (QQAppInterface) com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a.x();
        if (qQAppInterface != null) {
            String account = qQAppInterface.getAccount();
            if (TextUtils.isEmpty(account)) {
                hashMap.put("open_id", account);
            }
        }
        hashMap.put("app", "qq");
        hashMap.put("av", AppSetting.f99551k);
        hashMap.put("imei", ah.z());
        hashMap.put("oper_time", Long.toString(System.currentTimeMillis()));
        hashMap.put("domain", "1");
        hashMap.put("md", DeviceInfoMonitor.getModel());
        hashMap.put("net_type", Integer.toString(HttpUtil.getNetWorkType()));
        if (BaseApplication.getContext() != null) {
            DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
            hashMap.put("sr", displayMetrics.widthPixels + "*" + displayMetrics.widthPixels);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.f
    @JSMethod(uiThread = false)
    public void b(String str, JSONObject jSONObject) {
        d(BaseApplication.getContext(), str, jSONObject);
    }

    private void d(Context context, String str, JSONObject jSONObject) {
        if (context != null) {
            HashMap<String, String> c16 = c();
            try {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    String str3 = "'undefined'";
                    Object obj = jSONObject.get(str2);
                    if (obj instanceof String) {
                        str3 = (String) obj;
                    } else {
                        if (!(obj instanceof Number) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Double) && !(obj instanceof Float)) {
                            if (obj instanceof Boolean) {
                                str3 = obj.toString();
                            }
                        }
                        str3 = obj.toString();
                    }
                    c16.put(str2, str3);
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QReportModule", 2, "reportDTImpl JSONException  e: " + e16.getMessage());
                }
            }
            StatisticCollector.getInstance(context).collectPerformance(null, str, true, -1L, 0L, c16, null);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.f
    @JSMethod(uiThread = false)
    public void a(String str, JSONObject jSONObject) {
        String str2 = "";
        String optString = jSONObject.optString("r2", "");
        String optString2 = jSONObject.optString("r3", "");
        String optString3 = jSONObject.optString("r4", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("r5");
        IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
        String u16 = BridgeModuleHelper.u(jSONObject, optJSONObject);
        if (optJSONObject != null) {
            str2 = optJSONObject.toString();
        }
        iPublicAccountReportUtils.publicAccountReportClickEvent(null, u16, str, str, 0, 0, optString, optString2, optString3, str2, false);
    }
}
