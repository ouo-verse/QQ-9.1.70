package com.tencent.qqmini.nativePlugins;

import android.text.TextUtils;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.mini.out.nativePlugins.QzonePublishPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@JsPlugin(secondary = true)
/* loaded from: classes34.dex */
public class ag extends BaseJsPlugin {
    private JSONObject b(RequestEvent requestEvent) {
        try {
            return new JSONObject(requestEvent.jsonParams);
        } catch (JSONException unused) {
            QLog.e("[mini] QzonePublishPlugin", 1, "Failed to parse jsonParams=" + requestEvent.jsonParams);
            return null;
        }
    }

    @JsEvent({QzonePublishPlugin.API_NAVIGATE_TO_PUBLISH_PROGRAM})
    public void checkinQzoneUploadAndPublish(RequestEvent requestEvent) {
        JSONObject jSONObject;
        String str = null;
        try {
            jSONObject = b(requestEvent).optJSONObject("data");
        } catch (Throwable th5) {
            QLog.e("[mini] QzonePublishPlugin", 1, th5, new Object[0]);
            jSONObject = null;
        }
        if (jSONObject != null) {
            try {
                String str2 = (String) jSONObject.opt("uin");
                String str3 = (String) jSONObject.opt("content");
                String str4 = (String) jSONObject.opt("filePath");
                if (!TextUtils.isEmpty(str4)) {
                    str4 = ((IMiniAppFileManager) this.mMiniAppContext.getManager(IMiniAppFileManager.class)).getAbsolutePath(str4);
                }
                int optInt = jSONObject.optInt("issynctoweibo");
                JSONObject jSONObject2 = jSONObject.getJSONObject("lbsinfo");
                LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
                if (jSONObject2 != null) {
                    double optDouble = jSONObject2.optDouble("lbs_x");
                    double optDouble2 = jSONObject2.optDouble("lbs_y");
                    jSONObject2.optInt("lbs_type");
                    String optString = jSONObject2.optString("lbs_nm");
                    LbsDataV2.GpsInfo gpsInfo = poiInfo.gpsInfo;
                    gpsInfo.lon = (int) (optDouble * 1000000.0d);
                    gpsInfo.lat = (int) (optDouble2 * 1000000.0d);
                    poiInfo.poiName = optString;
                }
                JSONObject jSONObject3 = jSONObject.getJSONObject("source");
                String optString2 = jSONObject3 != null ? jSONObject3.optString("subtype") : null;
                HashMap hashMap = new HashMap();
                JSONObject jSONObject4 = jSONObject.getJSONObject(ReportDataBuilder.KEY_EXTEND_INFO);
                if (jSONObject4 != null) {
                    Iterator keys = jSONObject4.keys();
                    while (keys.hasNext()) {
                        String str5 = (String) keys.next();
                        hashMap.put(str5, jSONObject4.optString(str5));
                    }
                }
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject5 = jSONObject.getJSONObject("right_info");
                if (jSONObject5 != null) {
                    str = jSONObject5.optString("ugc_right");
                    JSONArray optJSONArray = jSONObject5.optJSONArray("allow_uins");
                    if (optJSONArray != null) {
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            arrayList.add((String) optJSONArray.get(i3));
                        }
                    }
                }
                String str6 = str;
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject6 = jSONObject.getJSONObject("stored_extend_info");
                if (jSONObject6 != null) {
                    Iterator keys2 = jSONObject6.keys();
                    while (keys2.hasNext()) {
                        String str7 = (String) keys2.next();
                        hashMap2.put(str7, jSONObject6.optString(str7));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str4);
                QZoneHelper.UserInfo.getInstance().qzone_uin = str2;
                QZoneHelper.publishPictureMoodSilently(str3, (ArrayList<String>) arrayList2, optInt, poiInfo, optString2, str6, (ArrayList<String>) arrayList, (HashMap<String, String>) hashMap2, (HashMap<String, String>) hashMap, RemoteHandleConst.VALUE_SOURCE_FROM_VIDEO_SIGN, 2);
                requestEvent.ok();
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("[mini] QzonePublishPlugin", 2, "QzonePublishPlugin onInvoke error:", e16);
                    return;
                }
                return;
            }
        }
        requestEvent.fail("data == null");
    }
}
