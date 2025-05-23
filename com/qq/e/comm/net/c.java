package com.qq.e.comm.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.StringUtil;
import com.tencent.av.so.ResInfo;
import com.tencent.av.ui.an;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Integer, String> f38300a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f38301b = new Object();

    public static Map<Integer, String> a() {
        Map<Integer, String> map;
        synchronized (f38301b) {
            map = f38300a;
        }
        return map;
    }

    private static String b() {
        Context appContext = GDTADManager.getInstance().getAppContext();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) appContext.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && NetworkMonitor.getType(activeNetworkInfo) == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) appContext.getSystemService("phone");
                StringBuilder sb5 = new StringBuilder();
                sb5.append(NetworkMonitor.getNetworkType(telephonyManager));
                return sb5.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static JSONObject a(PM pm5) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("sdkv", SDKStatus.getSDKVersion());
        if (pm5 != null) {
            jSONObject.putOpt("pv", Integer.valueOf(pm5.getPluginVersion()));
        }
        jSONObject.putOpt("sdk_st", 1);
        return jSONObject;
    }

    public static JSONObject b(DeviceStatus deviceStatus) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (deviceStatus != null) {
            jSONObject.putOpt(ResInfo.RES_TYPE_SO, deviceStatus.getScreenOrientation());
            jSONObject.putOpt("dn", deviceStatus.getDataNet());
            String b16 = b();
            if (!StringUtil.isEmpty(b16)) {
                jSONObject.putOpt("cell_native", b16);
            }
        }
        return jSONObject;
    }

    public static JSONObject a(SM sm5) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (sm5 != null) {
            jSONObject.putOpt("seq", Integer.valueOf(sm5.loadWujiSeqConfig()));
        }
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

    public static JSONObject a(DeviceStatus deviceStatus) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (deviceStatus != null) {
            String did = deviceStatus.getDid();
            jSONObject.putOpt(MessageForRichState.SIGN_MSG_DATA_ID_KEY, did);
            String buildModel = deviceStatus.getBuildModel();
            jSONObject.putOpt("md", buildModel);
            jSONObject.putOpt("apil", Integer.valueOf(deviceStatus.getVersion()));
            jSONObject.putOpt("os", "android");
            String str = Build.VERSION.RELEASE;
            jSONObject.putOpt("osv", str);
            String experimentIdSync = deviceStatus.getExperimentIdSync();
            if (!TextUtils.isEmpty(experimentIdSync)) {
                jSONObject.putOpt(DeviceStatus.EXPERIMENT_ID, experimentIdSync);
            }
            synchronized (f38301b) {
                f38300a.put(110, String.valueOf(did));
                f38300a.put(117, String.valueOf(buildModel));
                f38300a.put(403, String.valueOf(str));
            }
        }
        return jSONObject;
    }
}
