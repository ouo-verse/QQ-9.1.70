package com.tencent.mobileqq.newnearby.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.report.IOkHttpClientFactory;
import com.tencent.mobileqq.newnearby.INearbyCGIReporter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyCGIReporterImpl implements INearbyCGIReporter {
    private static final String REPORT_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String REPORT_HOST = "https://ias.nearby.qq.com/";
    private static final String REPORT_URL = "https://ias.nearby.qq.com/cgi-bin/nearby/report";
    private static final String TAG = "NearbyCGIReporter";
    private Callback mCallback = new a();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements Callback {
        a() {
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            try {
                if (response.code() == 200 && QLog.isDevelopLevel()) {
                    QLog.i(NearbyCGIReporterImpl.TAG, 4, "data report success.");
                }
                response.close();
            } catch (Exception e16) {
                QLog.i(NearbyCGIReporterImpl.TAG, 1, "report response error", e16);
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            QLog.e(NearbyCGIReporterImpl.TAG, 4, iOException, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportByJson$0(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("platform", "Android");
            jSONObject.put("version", ah.P());
            SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
            if (!jSONObject.has("latitude") && cachedLbsInfo != null) {
                jSONObject.put("latitude", String.valueOf(cachedLbsInfo.mLocation.mLat02));
            }
            if (!jSONObject.has("longitude") && cachedLbsInfo != null) {
                jSONObject.put("longitude", String.valueOf(cachedLbsInfo.mLocation.mLon02));
            }
            AppInterface appInterface = HippyUtils.getAppInterface();
            if (appInterface != null && appInterface.isLogin()) {
                String currentAccountUin = appInterface.getCurrentAccountUin();
                int intValue = ((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(currentAccountUin, INearbySPUtil.SP_KEY_SELF_GENDER, (Object) (-1))).intValue() - 1;
                int intValue2 = ((Integer) ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getValue(currentAccountUin, INearbySPUtil.SP_KEY_SELF_AGE, (Object) (-1))).intValue();
                jSONObject.put("d2", String.valueOf(intValue));
                jSONObject.put("d3", String.valueOf(intValue2));
            }
            jSONObject2.put("bid_type", "1");
            jSONObject2.put(EntityManager.KEY_TABLE_NAME, "nearby_report");
            jSONObject2.put("fields_json", jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        QLog.i(TAG, 2, "report: " + jSONObject2.toString());
        ((IOkHttpClientFactory) QRoute.api(IOkHttpClientFactory.class)).getRequestClient().newCall(new Request.Builder().url(REPORT_URL).headers(new Headers.Builder().add("Content-Type", "application/x-www-form-urlencoded").add("Referer", "").build()).post(RequestBody.create(MediaType.parse("application/json"), jSONObject2.toString())).build()).enqueue(this.mCallback);
    }

    @Override // com.tencent.mobileqq.newnearby.INearbyCGIReporter
    public void reportByJson(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.newnearby.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                NearbyCGIReporterImpl.this.lambda$reportByJson$0(jSONObject);
            }
        }, 128, null, false);
    }
}
