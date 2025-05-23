package com.tencent.mobileqq.kandian.biz.pts.util;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class f {

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private JSONObject f239403a = new JSONObject();

        public a() {
            c();
        }

        private void c() {
            try {
                this.f239403a.put("os", "1");
                this.f239403a.put("version", AppSetting.f99551k);
                this.f239403a.put("sdk_version", String.valueOf(Build.VERSION.SDK_INT));
                JSONObject jSONObject = this.f239403a;
                String str = Build.BRAND;
                String str2 = "";
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                jSONObject.put("device_brand", str);
                JSONObject jSONObject2 = this.f239403a;
                if (!TextUtils.isEmpty(DeviceInfoMonitor.getModel())) {
                    str2 = DeviceInfoMonitor.getModel();
                }
                jSONObject2.put("device_model", str2);
                this.f239403a.put("is_debug", "0");
            } catch (JSONException e16) {
                QLog.e("PTSReport", 1, "[initCommonField], e = " + e16);
            }
        }

        public a a(String str, String str2) {
            try {
                this.f239403a.put(str, str2);
            } catch (JSONException e16) {
                QLog.e("PTSReport", 1, "[addString], e = " + e16);
            }
            return this;
        }

        public String b() {
            return this.f239403a.toString();
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        QLog.i("PTSReport", 1, "[reportData], actionName = " + str + ", r2 = " + str2 + ", r3 = " + str3 + ", r4 = " + str4 + ", r5 = " + str5);
        PublicAccountReportUtils.l(null, "", str, str, 0, 0, str2, str3, str4, str5, false);
    }
}
