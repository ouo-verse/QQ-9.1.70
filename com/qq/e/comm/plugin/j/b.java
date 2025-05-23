package com.qq.e.comm.plugin.j;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.av.ui.an;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Integer, String> f39587a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f39588b = new Object();

    public static JSONObject a(SM sm5) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (sm5 != null && SDKStatus.getSDKVersionCode() >= 140) {
            jSONObject.putOpt("seq", Integer.valueOf(sm5.loadWujiSeqConfig()));
        }
        return jSONObject;
    }

    public static JSONObject a(PM pm5) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("sdkv", SDKStatus.getSDKVersion());
        if (pm5 != null) {
            jSONObject.putOpt("pv", Integer.valueOf(pm5.getPluginVersion()));
        }
        jSONObject.putOpt("sdk_st", 1);
        jSONObject.putOpt("sdk_pt", 1);
        return jSONObject;
    }

    public static JSONObject a(SM sm5, PM pm5) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (sm5 != null) {
            jSONObject.putOpt("app", sm5.getDevCloudSettingSig());
            jSONObject.putOpt("sdk", sm5.getSdkCloudSettingSig());
        }
        if (pm5 != null) {
            jSONObject.putOpt(HttpMsg.FILE_JAR, pm5.getLocalSig());
            jSONObject.putOpt("plugin_version", Integer.valueOf(pm5.getPluginVersion()));
        }
        return jSONObject;
    }

    public static JSONObject a(DeviceStatus deviceStatus, Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (deviceStatus != null) {
            String hashDeviceId = ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getHashDeviceId();
            jSONObject.putOpt(MessageForRichState.SIGN_MSG_DATA_ID_KEY, hashDeviceId == null ? "" : hashDeviceId);
            String buildModel = ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getBuildModel();
            jSONObject.putOpt("md", buildModel);
            jSONObject.putOpt("apil", Integer.valueOf(deviceStatus.getVersion()));
            jSONObject.putOpt("os", "android");
            String str = Build.VERSION.RELEASE;
            jSONObject.putOpt("osv", str);
            if (SDKStatus.getSDKVersionCode() >= 290) {
                String experimentIdSync = deviceStatus.getExperimentIdSync();
                if (!TextUtils.isEmpty(experimentIdSync)) {
                    jSONObject.putOpt(DeviceStatus.EXPERIMENT_ID, experimentIdSync);
                }
            }
            Pair<String, String> taidAndOaidTicket = ((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getTaidAndOaidTicket();
            if (taidAndOaidTicket != null) {
                jSONObject.putOpt("td", taidAndOaidTicket.first);
                jSONObject.putOpt("od", taidAndOaidTicket.second);
            }
            synchronized (f39588b) {
                Map<Integer, String> map = f39587a;
                map.put(110, String.valueOf(hashDeviceId));
                map.put(117, String.valueOf(buildModel));
                map.put(403, String.valueOf(str));
                if (taidAndOaidTicket != null) {
                    map.put(2, String.valueOf(taidAndOaidTicket.first));
                    map.put(1, String.valueOf(taidAndOaidTicket.second));
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject a(APPStatus aPPStatus) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (aPPStatus != null) {
            jSONObject.putOpt(an.f75362j, aPPStatus.getAPPName());
            jSONObject.putOpt("appkey", aPPStatus.getAPPID());
            jSONObject.putOpt("appv", aPPStatus.getAPPVersion());
            jSONObject.putOpt("appn", aPPStatus.getAPPRealName());
        }
        return jSONObject;
    }

    public static String a(SM sm5, PM pm5, DeviceStatus deviceStatus, APPStatus aPPStatus, Context context, boolean z16) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = a(sm5);
            jSONObject.put(PreloadTRTCPlayerParams.KEY_SIG, a(sm5, pm5));
            jSONObject.put(APMidasPayAPI.ENV_DEV, a(deviceStatus, context));
            jSONObject.put("app", a(aPPStatus));
            jSONObject.put("sdk", a(pm5));
            jSONObject.put("requireUpdate", z16 ? 1 : 0);
        } catch (JSONException e16) {
            GDTLogger.e("JSONException while build init req", e16);
        }
        return jSONObject.toString();
    }

    public static Map<Integer, String> a() {
        Map<Integer, String> map;
        synchronized (f39588b) {
            map = f39587a;
        }
        return map;
    }
}
