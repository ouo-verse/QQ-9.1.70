package com.tencent.gamecenter.wadl.distribute.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.distribute.api.IQQGameDistributeApi;
import com.tencent.gamecenter.wadl.distribute.api.IQQGuildDistributeApi;
import com.tencent.gamecenter.wadl.distribute.data.ButtonDataBuilder;
import com.tencent.gamecenter.wadl.distribute.data.ButtonUiBuilder;
import com.tencent.gamecenter.wadl.distribute.data.GameDistributeExtraInfo;
import com.tencent.gamecenter.wadl.distribute.data.GameDistributeInfo;
import com.tencent.gamecenter.wadl.distribute.data.a;
import com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGuildDistributeApiImpl implements IQQGuildDistributeApi {
    private static final String TAG = "QQGuildDistributeApiImpl";

    private static String getAttaReportDataForGuildPage() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("show_operId", "2000959");
            jSONObject.put("click_operId", "2000960");
            jSONObject.put("page_name", "page_sgrp_channel");
            jSONObject.put("module_name", "module_top_area");
            jSONObject.put("element_name", "em_action_button");
            jSONObject.put("element_level", "em_action_button,module_top_area");
            jSONObject.put("ext2", "1");
            jSONObject.put("ext23", "2");
            jSONObject.put("ext24", "1");
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    private void mergeJsonObj(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            try {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    jSONObject2.put(str, jSONObject.get(str));
                }
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        }
    }

    private void updateDistributeButton(IDistributeButton iDistributeButton, GameDistributeInfo gameDistributeInfo, GameDistributeExtraInfo gameDistributeExtraInfo, String str) {
        String attaReportDataForGuildPage;
        int i3;
        String str2;
        if (iDistributeButton != null && gameDistributeInfo != null) {
            String str3 = "";
            if (gameDistributeExtraInfo != null && gameDistributeExtraInfo.isFromGameCenter()) {
                attaReportDataForGuildPage = gameDistributeExtraInfo.getAttaReportData();
                String gameChannelId = gameDistributeExtraInfo.getGameChannelId();
                if (!TextUtils.isEmpty(gameChannelId)) {
                    QLog.i(TAG, 2, "[updateDistributeButton] replace channel,old:" + str + ",new:" + gameChannelId);
                    str = gameChannelId;
                }
                i3 = gameDistributeExtraInfo.isSupportSpark();
                if (i3 == 1) {
                    str3 = gameDistributeExtraInfo.getSparkTaskKey();
                }
                String str4 = str3;
                str3 = gameDistributeExtraInfo.getExtraParams();
                str2 = str4;
            } else {
                attaReportDataForGuildPage = getAttaReportDataForGuildPage();
                i3 = 0;
                str2 = "";
            }
            JSONObject extraParams = gameDistributeInfo.getExtraParams();
            if (extraParams != null) {
                if (!TextUtils.isEmpty(str3)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        mergeJsonObj(new JSONObject(str3), jSONObject);
                    } catch (Throwable th5) {
                        QLog.e(TAG, 1, th5, new Object[0]);
                    }
                    mergeJsonObj(extraParams, jSONObject);
                    str3 = jSONObject.toString();
                } else {
                    str3 = extraParams.toString();
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[updateDistributeButton] attaReportData=" + attaReportDataForGuildPage + ",data:" + gameDistributeInfo + ",taskKey:" + str2 + ",isSupportSpark:" + i3);
            }
            iDistributeButton.setDataBuilder(new ButtonDataBuilder().setApkChannel(str).setIsSupportSpark(i3).setSparkTaskKey(str2).setExtraParams(str3).setAttaReportData(attaReportDataForGuildPage).setBufferFromCache(gameDistributeInfo.getBufferFromCache()).setAggregatedBuffer(new String(gameDistributeInfo.getBuffer(), StandardCharsets.UTF_8)).setGuildID(gameDistributeInfo.getGuildId()));
            iDistributeButton.setUiBuilder(new ButtonUiBuilder().setUiStyle(3).setGuildUIColor(gameDistributeInfo.getGuildUIColor()));
            iDistributeButton.update();
            VideoReport.setElementId(iDistributeButton, "em_sgrp_enter_game");
        }
    }

    @Override // com.tencent.gamecenter.wadl.distribute.api.IQQGuildDistributeApi
    public IDistributeButton getGuildDistributeView(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        IDistributeButton createKuiklyButton = ((IQQGameDistributeApi) QRoute.api(IQQGameDistributeApi.class)).createKuiklyButton(context);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getGuildDistributeView cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return createKuiklyButton;
    }

    @Override // com.tencent.gamecenter.wadl.distribute.api.IQQGuildDistributeApi
    public a updateGuildDistributeView(IDistributeButton iDistributeButton, GameDistributeInfo gameDistributeInfo, GameDistributeExtraInfo gameDistributeExtraInfo) {
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a();
        if (gameDistributeInfo != null && gameDistributeInfo.getBuffer().length != 0) {
            try {
                JSONObject optJSONObject = new JSONObject(new String(gameDistributeInfo.getBuffer(), StandardCharsets.UTF_8)).optJSONObject("distribute_data");
                if (optJSONObject != null && optJSONObject.optBoolean("is_show_distribute")) {
                    updateDistributeButton(iDistributeButton, gameDistributeInfo, gameDistributeExtraInfo, optJSONObject.optString("channel_id"));
                    aVar.b(true);
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 1, "updateGuildDistributeView cost:" + (System.currentTimeMillis() - currentTimeMillis) + ",data:" + gameDistributeInfo + ",distributeView:" + iDistributeButton);
                    }
                    return aVar;
                }
                QLog.e(TAG, 1, "updateGuildDistributeView not show");
                return aVar;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
                return aVar;
            }
        }
        QLog.e(TAG, 1, "updateGuildDistributeView data or buffer is null,data:" + gameDistributeInfo + ",distributeView:" + iDistributeButton);
        return aVar;
    }
}
