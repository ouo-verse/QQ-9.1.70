package com.tencent.gdtad.basics.motivevideo.hippy.method;

import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSONArrayUtil;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.xsad.rewarded.dynamic.method.RewardAdMethodHandler;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b implements DKMethodHandler {

    /* renamed from: d, reason: collision with root package name */
    private final a f109012d;

    /* renamed from: e, reason: collision with root package name */
    private final WeakReference<om0.a> f109013e;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public b(WeakReference<om0.a> weakReference, a aVar) {
        this.f109012d = aVar;
        this.f109013e = weakReference;
    }

    private static List<String> a(JSONObject jSONObject) {
        JSONArray optJSONArray = AdJSONUtil.optJSONArray(jSONObject, "switchIds");
        if (AdJSONArrayUtil.isEmpty(optJSONArray)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            String optString = AdJSONArrayUtil.optString(optJSONArray, i3, null);
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(optString);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private void b(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        om0.a aVar;
        QLog.i("GdtMotiveAdMethodHandler", 1, "[handleCloseRewardAd] params:" + AdJSONUtil.toString(jSONObject));
        WeakReference<om0.a> weakReference = this.f109013e;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        int optInt = AdJSONUtil.optInt(jSONObject, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_TIME, 0);
        if (aVar != null) {
            aVar.f(optInt);
        }
        if (callback != null) {
            callback.onResult(null);
        }
        a aVar2 = this.f109012d;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    private void c(DKMethodHandler.Callback callback) {
        om0.a aVar;
        WeakReference<om0.a> weakReference = this.f109013e;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.c();
        }
        if (callback != null) {
            callback.onResult(null);
        }
    }

    private void d(JSONObject jSONObject, DKMethodHandler.Callback callback) {
        om0.a aVar;
        if (callback == null) {
            QLog.e("GdtMotiveAdMethodHandler", 1, "[handleSwitchAdInfo] error, callback is null");
            return;
        }
        WeakReference<om0.a> weakReference = this.f109013e;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            callback.onFailure(1, null);
        } else {
            callback.onResult(aVar.e(a(jSONObject)));
        }
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public String getModuleId() {
        return "RewardAd";
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public boolean invoke(DKEngine dKEngine, String str, JSONObject jSONObject, DKMethodHandler.Callback callback) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("GdtMotiveAdMethodHandler", 1, "[invoke] methodName is empty.");
            return false;
        }
        QLog.i("GdtMotiveAdMethodHandler", 1, "[invoke] methodName:" + str + " params:" + AdJSONUtil.toString(jSONObject));
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1388921872:
                if (str.equals(RewardAdMethodHandler.RewardAdEvent.ON_USER_EARNED_REWARD)) {
                    c16 = 0;
                    break;
                }
                break;
            case 711559109:
                if (str.equals(RewardAdMethodHandler.RewardAdEvent.SWITCH_AD_INFO)) {
                    c16 = 1;
                    break;
                }
                break;
            case 1012339146:
                if (str.equals(RewardAdMethodHandler.RewardAdEvent.CLOSE_REWARD_AD)) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                c(callback);
                return true;
            case 1:
                d(jSONObject, callback);
                return true;
            case 2:
                b(jSONObject, callback);
                return true;
            default:
                return false;
        }
    }
}
