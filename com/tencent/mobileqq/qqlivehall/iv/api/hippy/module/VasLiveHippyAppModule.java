package com.tencent.mobileqq.qqlivehall.iv.api.hippy.module;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDImageView;
import com.tencent.mobileqq.newnearby.hippy.INearbyHippyBridge;
import com.tencent.mobileqq.qqlive.api.room.IQQLiveHuYaRoomApi;
import com.tencent.mobileqq.qqlive.api.room.IQQLiveRoomDataPreloadApi;
import com.tencent.mobileqq.qqlive.huya.QQLiveHuYa;
import com.tencent.mobileqq.qqlive.huya.QQLiveHuYaUrlManager;
import com.tencent.mobileqq.qqlivehall.iv.api.hippy.module.VasLiveHippyAppModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.util.NumberUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = VasLiveHippyAppModule.TAG)
/* loaded from: classes17.dex */
public class VasLiveHippyAppModule extends HippyNativeModuleBase {
    private static final String TAG = "VasLiveHippyAppModule";

    public VasLiveHippyAppModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private static Map<String, String> getArguments(String str) {
        HashMap hashMap = new HashMap();
        try {
            String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
            boolean z16 = false;
            for (String str2 : split) {
                String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length == 2) {
                    String str3 = split2[0];
                    if (str3 != null && str3.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        str3 = str3.substring(str3.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1);
                    }
                    if ("roomid".equals(str3) || "vid".equals(str3)) {
                        z16 = true;
                    }
                }
            }
            if (!z16) {
                split = URLDecoder.decode(str, "UTF-8").split(ContainerUtils.FIELD_DELIMITER);
            }
            for (String str4 : split) {
                String[] split3 = str4.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3 != null && split3.length == 2) {
                    String str5 = split3[0];
                    if (str5 != null && str5.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        str5 = str5.substring(str5.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1);
                    }
                    if (str5 != null && str5.equalsIgnoreCase("pagetype")) {
                        str5 = "pagetype";
                    }
                    hashMap.put(str5, URLDecoder.decode(split3[1]));
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parse mqq schema error " + e16);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$fetchHuyaUrl$0(HippyMap hippyMap, Promise promise, String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        try {
            jSONObject = new JSONObject();
            jSONObject2 = new JSONObject();
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "fetchHuyaUrl put result throw:", e16);
        }
        if (str != null && !str.isEmpty()) {
            jSONObject2.put("retCode", 0);
            jSONObject2.put("urlWithToken", str);
            hippyMap.pushJSONObject(jSONObject);
            promise.resolve(hippyMap);
            return null;
        }
        jSONObject2.put("retCode", -1);
        jSONObject2.put("urlWithToken", str);
        hippyMap.pushJSONObject(jSONObject);
        promise.resolve(hippyMap);
        return null;
    }

    private static void preloadRoomData(String str, String str2) {
        ((IQQLiveRoomDataPreloadApi) QRoute.api(IQQLiveRoomDataPreloadApi.class)).preloadData(NumberUtil.stringToLong(str, 0L), NumberUtil.stringToInt(str2, 0));
    }

    @HippyMethod(name = "clearHuyaUrl")
    public void clearHuyaUrl(HippyMap hippyMap, Promise promise) {
        QLog.d(TAG, 2, "clearHuyaUrl");
        QQLiveHuYaUrlManager.f271340a.a();
        promise.resolve(new HippyMap());
    }

    @HippyMethod(name = "fetchHuyaUrl")
    public void fetchHuyaUrl(HippyMap hippyMap, final Promise promise) {
        final HippyMap hippyMap2 = new HippyMap();
        try {
            long parseLong = Long.parseLong(hippyMap.getString("roomID"));
            QLog.d(TAG, 2, "fetchHuyaUrl room:" + parseLong);
            ((IQQLiveHuYaRoomApi) QRoute.api(IQQLiveHuYaRoomApi.class)).getHuYaRoomPreviewUrl(parseLong, new Function1() { // from class: yi2.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Void lambda$fetchHuyaUrl$0;
                    lambda$fetchHuyaUrl$0 = VasLiveHippyAppModule.lambda$fetchHuyaUrl$0(HippyMap.this, promise, (String) obj);
                    return lambda$fetchHuyaUrl$0;
                }
            });
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, "fetchHuyaUrl parseLong e:", e16);
            promise.reject(hippyMap2);
        }
    }

    @HippyMethod(name = "openAppSetting")
    public void openAppSetting(HippyMap hippyMap, Promise promise) {
        QLog.i(TAG, 1, "openAppSetting");
        ((INearbyHippyBridge) QRoute.api(INearbyHippyBridge.class)).openAppSetting();
    }

    @HippyMethod(name = "openMqqUrl")
    public void openMqqUrl(HippyMap hippyMap, Promise promise) {
        QLog.i(TAG, 1, "openMqqUrl url=" + hippyMap.getString("url"));
        String str = hippyMap.getString("url") + "&jump_start_time=" + System.currentTimeMillis();
        Map<String, String> arguments = getArguments(str);
        String str2 = arguments.get("roomid");
        String generateTraceId = ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).generateTraceId();
        ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder().traceId(generateTraceId).roomId(str2).eventId(QQLiveReportConstants.Event.E_ENTER_ROOM_CLICKED).ext6(QQLiveReportConstants.Scene.SCENE_LIVE_HALL_ENTRANCE).ext7(String.valueOf(System.currentTimeMillis())).ext8("true"));
        preloadRoomData(str2, arguments.get("room_type"));
        ((INearbyHippyBridge) QRoute.api(INearbyHippyBridge.class)).openMqqUrl(str + "&live_traceid=" + generateTraceId);
    }

    @HippyMethod(name = HippyTKDImageView.EXTRA_REPORTDATA_NAME)
    public void reportData(HippyMap hippyMap, Promise promise) {
        QLog.d(TAG, 2, HippyTKDImageView.EXTRA_REPORTDATA_NAME);
        String string = hippyMap.getString(AdMetricTag.EVENT_NAME);
        HippyMap hippyMap2 = new HippyMap();
        if (TextUtils.isEmpty(string)) {
            hippyMap2.pushString("retCode", "eventNameIsNull");
            promise.reject(hippyMap2);
            QLog.e(TAG, 1, "eventName is null");
            return;
        }
        HashMap hashMap = new HashMap();
        HippyMap map = hippyMap.getMap("params");
        if (map == null) {
            hippyMap2.pushString("retCode", "paramsIsNull");
            promise.reject(hippyMap2);
            QLog.e(TAG, 1, "params is null");
            return;
        }
        for (String str : map.keySet()) {
            hashMap.put(str, map.getString(str));
        }
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent(string, hashMap);
        hippyMap2.pushString("retCode", "success");
        promise.resolve(hippyMap2);
    }

    @HippyMethod(name = "reportHuyaLivePreviewBegin")
    public void reportHuyaLivePreviewBegin(HippyMap hippyMap, Promise promise) {
        QLog.d(TAG, 2, "reportHuyaLivePreviewBegin");
        String string = hippyMap.getString("presenterUid");
        int i3 = hippyMap.getInt("gameTypeID");
        HippyMap hippyMap2 = new HippyMap();
        try {
            QQLiveHuYa.f271333a.m(Long.parseLong(string), i3);
            promise.resolve(hippyMap2);
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, "reportHuyaLivePreviewBegin throw ", e16);
            promise.reject(hippyMap2);
        }
    }

    @HippyMethod(name = "reportHuyaLivePreviewEnd")
    public void reportHuyaLivePreviewEnd(HippyMap hippyMap, Promise promise) {
        QLog.d(TAG, 2, "reportHuyaLivePreviewEnd");
        String string = hippyMap.getString("presenterUid");
        HippyMap hippyMap2 = new HippyMap();
        try {
            QQLiveHuYa.f271333a.n(Long.parseLong(string));
            promise.resolve(hippyMap2);
        } catch (NumberFormatException e16) {
            QLog.e(TAG, 1, "reportHuyaLivePreviewEnd throw ", e16);
            promise.reject(hippyMap2);
        }
    }

    @HippyMethod(name = "requestLBS")
    public void requestLBS(HippyMap hippyMap, Promise promise) {
        QLog.i(TAG, 1, "requestLBS");
        ((INearbyHippyBridge) QRoute.api(INearbyHippyBridge.class)).requestLBS(promise);
    }

    @HippyMethod(name = "selectAndUploadPicture")
    public void selectAndUploadPicture(HippyMap hippyMap, Promise promise) {
        QLog.i(TAG, 1, "selectAndUploadPicture");
        ((INearbyHippyBridge) QRoute.api(INearbyHippyBridge.class)).selectAndUploadPicture(hippyMap.getInt("type"), promise);
    }

    @HippyMethod(name = "uploadProfilePicture")
    public void uploadProfilePicture(HippyMap hippyMap, Promise promise) {
        QLog.i(TAG, 1, "uploadProfilePicture");
        ((INearbyHippyBridge) QRoute.api(INearbyHippyBridge.class)).uploadProfilePicture(promise);
    }
}
