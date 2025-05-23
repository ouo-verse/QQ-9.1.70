package com.tencent.mobileqq.mini.out.nativePlugins;

import android.text.TextUtils;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class QzonePublishPlugin implements NativePlugin {
    public static final String API_NAVIGATE_TO_PUBLISH_PROGRAM = "checkin_qzoneUploadAndPublish";
    private static final String TAG = "[mini] QzonePublishPlugin";

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onInvoke(JSONObject jSONObject, JSContext jSContext) {
        JSONObject jSONObject2;
        String str;
        try {
            jSONObject2 = jSONObject.optJSONObject("data");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            jSONObject2 = null;
        }
        if (jSONObject2 != null) {
            try {
                String str2 = (String) jSONObject2.opt("uin");
                String str3 = (String) jSONObject2.opt("content");
                String str4 = (String) jSONObject2.opt("filePath");
                if (!TextUtils.isEmpty(str4)) {
                    str4 = MiniAppFileManager.getInstance().getAbsolutePath(str4);
                }
                int optInt = jSONObject2.optInt("issynctoweibo");
                JSONObject jSONObject3 = jSONObject2.getJSONObject("lbsinfo");
                LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
                if (jSONObject3 != null) {
                    double optDouble = jSONObject3.optDouble("lbs_x");
                    double optDouble2 = jSONObject3.optDouble("lbs_y");
                    jSONObject3.optInt("lbs_type");
                    String optString = jSONObject3.optString("lbs_nm");
                    LbsDataV2.GpsInfo gpsInfo = poiInfo.gpsInfo;
                    gpsInfo.lon = (int) (optDouble * 1000000.0d);
                    gpsInfo.lat = (int) (optDouble2 * 1000000.0d);
                    poiInfo.poiName = optString;
                }
                JSONObject jSONObject4 = jSONObject2.getJSONObject("source");
                String optString2 = jSONObject4 != null ? jSONObject4.optString("subtype") : null;
                HashMap hashMap = new HashMap();
                JSONObject jSONObject5 = jSONObject2.getJSONObject(ReportDataBuilder.KEY_EXTEND_INFO);
                if (jSONObject5 != null) {
                    Iterator keys = jSONObject5.keys();
                    while (keys.hasNext()) {
                        String str5 = (String) keys.next();
                        hashMap.put(str5, jSONObject5.optString(str5));
                    }
                }
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject6 = jSONObject2.getJSONObject("right_info");
                if (jSONObject6 == null) {
                    str = "";
                } else {
                    str = jSONObject6.optString("ugc_right");
                    JSONArray optJSONArray = jSONObject6.optJSONArray("allow_uins");
                    if (optJSONArray != null) {
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            arrayList.add((String) optJSONArray.get(i3));
                        }
                    }
                }
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject7 = jSONObject2.getJSONObject("stored_extend_info");
                if (jSONObject7 != null) {
                    for (Iterator keys2 = jSONObject7.keys(); keys2.hasNext(); keys2 = keys2) {
                        String str6 = (String) keys2.next();
                        hashMap2.put(str6, jSONObject7.optString(str6));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str4);
                QZoneHelper.UserInfo.getInstance().qzone_uin = str2;
                QZoneHelper.publishPictureMoodSilently(str3, (ArrayList<String>) arrayList2, optInt, poiInfo, optString2, str, (ArrayList<String>) arrayList, (HashMap<String, String>) hashMap2, (HashMap<String, String>) hashMap, RemoteHandleConst.VALUE_SOURCE_FROM_VIDEO_SIGN, 2);
                jSContext.evaluateCallback(true, null, "");
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "QzonePublishPlugin onInvoke error:", e16);
                    return;
                }
                return;
            }
        }
        jSContext.evaluateCallback(false, null, "data == null");
    }

    @Override // com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePlugin
    public void onDestroy() {
    }
}
