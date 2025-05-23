package com.tencent.mobileqq.gamecenter.yungame;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.api.GmCgLogger;
import com.tencent.gamematrix.gmcg.sdk.GmCgSdk;
import com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi;
import com.tencent.mobileqq.gamecenter.api.IYunGameConstant;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import eipc.EIPCResult;
import mqq.app.AppService;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class YunGameService extends AppService {
    public static final int APP_BIZ_NO = 9;
    public static final String TAG = "YunGameService";
    public a ipcModule;
    private b mLogger;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a extends QIPCModule {
        public a(String str) {
            super(str);
        }

        @Override // eipc.EIPCModule
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            QLog.i(YunGameService.TAG, 1, "[onCall] action\uff1a" + str);
            EIPCResult P = YunGameManager.F().P(str, bundle, i3);
            callbackResult(i3, P);
            return P;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements GmCgLogger {
        b() {
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

    private void initSDK() {
        b bVar = new b();
        this.mLogger = bVar;
        GmCgSdk.init(this, true, bVar, 9, "");
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

    @Override // mqq.app.AppService, android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        super.onCreate();
        initSDK();
        YunGameManager.F().I(this);
        QLog.i(TAG, 1, "[onCreate] service create!");
        this.ipcModule = new a(IYunGameConstant.IPC_NAME);
        QIPCClientHelper.getInstance().register(this.ipcModule);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i16) {
        QLog.i(TAG, 1, "[onStartCommand] onStartCommand!");
        if (intent != null) {
            YunGameManager.F().M(intent.getStringExtra(IYunGameConstant.KEY_USER_ID), intent.getStringExtra(IYunGameConstant.KEY_AUTH_KEY));
            return 2;
        }
        QLog.e(TAG, 1, "[onStartCommand] intent is null!");
        return 2;
    }
}
