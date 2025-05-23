package com.tencent.mobileqq.gamecenter.yungame;

import android.app.Application;
import com.tencent.gamematrix.gmcg.api.GmCgLogger;
import com.tencent.gamematrix.gmcg.sdk.GmCgSdk;
import com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi;
import com.tencent.mobileqq.qqui.tempapi.IQQUITempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class YunGameApplication extends Application {
    public static final int APP_BIZ_NO = 9;
    private static final String TAG = "YunGameApplication";
    private a mLogger;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements GmCgLogger {
        a() {
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgLogger
        public void d(String str, String str2) {
            if (QLog.isColorLevel()) {
                QLog.d("YunGame", 1, "[" + str + "] " + str2);
            }
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgLogger
        public void e(String str, String str2) {
            QLog.e("YunGame", 1, "[" + str + "] " + str2);
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgLogger
        public void i(String str, String str2) {
            if (QLog.isColorLevel()) {
                QLog.i("YunGame", 1, "[" + str + "] " + str2);
            }
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgLogger
        public void v(String str, String str2) {
            if (QLog.isColorLevel()) {
                QLog.i("YunGame", 1, "[" + str + "] " + str2);
            }
        }

        @Override // com.tencent.gamematrix.gmcg.api.GmCgLogger
        public void w(String str, String str2) {
            QLog.w("YunGame", 1, "[" + str + "] " + str2);
        }
    }

    private void initURLDrawable() {
        try {
            ((IQQUITempApi) QRoute.api(IQQUITempApi.class)).initUrlDrawable();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        QLog.i(TAG, 1, "[onCreate] onCreate: invoke!!");
        super.onCreate();
        initURLDrawable();
        a aVar = new a();
        this.mLogger = aVar;
        GmCgSdk.init(this, true, aVar, 9, "");
        try {
            String deviceInfo = ((IYunGameChannelApi) QRoute.api(IYunGameChannelApi.class)).getDeviceInfo();
            JSONObject jSONObject = new JSONObject(deviceInfo);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, deviceInfo);
            }
            GmCgSdk.setPrivacyDeviceInfo(jSONObject.optString("imei"), jSONObject.optString("androidId"), jSONObject.optString("xid"), jSONObject.optString("oaid"), jSONObject.optString(TVKLiveRequestBuilder.RequestParamKey.QIMEI36), jSONObject.optString("qimei36"), jSONObject.optString("model"), jSONObject.optString("brand"), jSONObject.optString("manufacturer"), jSONObject.optString("hardware"), jSONObject.optString("board"));
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }
}
