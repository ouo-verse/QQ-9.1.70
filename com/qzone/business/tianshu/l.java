package com.qzone.business.tianshu;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi;
import com.tencent.mobileqq.minigame.utils.EntryConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class l {
    public static void a(Context context, BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return;
        }
        String str = appInfo.buffer.get();
        String str2 = appInfo.extend.get();
        QLog.d("QZoneMiniGameTianshuRedPointHelper", 2, "[handleMiniGameRedPointWithAppInfo] buffer:", str);
        QLog.d("QZoneMiniGameTianshuRedPointHelper", 2, "[handleMiniGameRedPointWithAppInfo] traceInfo:", str2);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("msg");
            String optString = jSONObject.optString("_show_mission");
            if (optJSONObject != null && TextUtils.isEmpty(optString)) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(optString);
                if (optJSONObject2 != null) {
                    String optString2 = optJSONObject2.optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
                    QLog.d("QZoneMiniGameTianshuRedPointHelper", 2, "[handleMiniGameRedPointWithAppInfo] schemeLink:", optString2);
                    if (!TextUtils.isEmpty(optString2)) {
                        yo.d.d(optString2, context, null);
                        return;
                    }
                } else {
                    QLog.w("QZoneMiniGameTianshuRedPointHelper", 2, "[handleMiniGameRedPointWithAppInfo] msgContent is null");
                }
            } else {
                QLog.w("QZoneMiniGameTianshuRedPointHelper", 2, "[handleMiniGameRedPointWithAppInfo] msg:" + optJSONObject + ", showMission:" + optString);
            }
            ((IMiniGameCenterHippyApi) QRoute.api(IMiniGameCenterHippyApi.class)).setAppInfoBuffer(str);
            ((IMiniGameCenterHippyApi) QRoute.api(IMiniGameCenterHippyApi.class)).setAppInfoTraceInfo(str2);
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniGameCenter(context, EntryConstants.LEBA_ENTRY);
        } catch (JSONException e16) {
            QLog.d("QZoneMiniGameTianshuRedPointHelper", 1, "[handleMiniGameRedPointWithAppInfo] exception:", e16);
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniGameCenter(context, EntryConstants.LEBA_ENTRY);
        }
    }

    public static boolean b(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            QLog.d("QZoneMiniGameTianshuRedPointHelper", 2, "[needShowRedPoint] show:false app not found");
            return false;
        }
        if (appInfo.iNewFlag.get() != 0 && appInfo.exposure_max.get() >= 0) {
            if (appInfo.red_display_info.get() != null && appInfo.red_display_info.red_type_info.get() != null) {
                if (appInfo.red_display_info.red_type_info.get().size() == 0) {
                    QLog.d("QZoneMiniGameTianshuRedPointHelper", 2, "[needShowRedPoint] show:false redTypeInfo size is 0");
                    return false;
                }
                QLog.e("QZoneMiniGameTianshuRedPointHelper", 2, "[needShowRedPoint] show:true");
                return true;
            }
            QLog.d("QZoneMiniGameTianshuRedPointHelper", 2, "[needShowRedPoint] show:false redDisplayInfo is null or redTypeInfo is null");
            return false;
        }
        QLog.d("QZoneMiniGameTianshuRedPointHelper", 2, "[needShowRedPoint] show:false iNewFlags:" + appInfo.iNewFlag.get() + "exposureMax:" + appInfo.exposure_max.get());
        return false;
    }
}
