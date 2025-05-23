package com.tencent.biz.richframework.video.rfw.player.datacollect.action;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerBufferRecode;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerCollectParams;
import com.tencent.biz.richframework.video.rfw.player.datacollect.RFWPlayerSeekRecode;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqmini.sdk.task.MiniAppSoLoader;
import com.tencent.weiyun.poi.PoiDbManager;
import java.util.Iterator;
import qe0.a;

/* loaded from: classes5.dex */
public class RFWPlayerFlushAction implements RFWPlayerCollectBaseAction {
    private void fillBufferAction(JsonObject jsonObject, RFWPlayerCollectParams rFWPlayerCollectParams) {
        int size = rFWPlayerCollectParams.getSeekRecodeList().size();
        jsonObject.addProperty("seekCount", Integer.valueOf(size));
        Iterator<RFWPlayerSeekRecode> it = rFWPlayerCollectParams.getSeekRecodeList().iterator();
        float f16 = -1.0f;
        while (it.hasNext()) {
            f16 = Math.max(f16, it.next().getSeekCostS());
        }
        if (size > 0) {
            jsonObject.addProperty("seekCostMaxS", Float.valueOf(f16));
        }
    }

    private void fillSeekAction(JsonObject jsonObject, RFWPlayerCollectParams rFWPlayerCollectParams) {
        int size = rFWPlayerCollectParams.getSecondBufferRecodeList().size();
        jsonObject.addProperty("bfCount", Integer.valueOf(size));
        float f16 = -1.0f;
        boolean z16 = false;
        boolean z17 = true;
        float f17 = -1.0f;
        float f18 = 1.0f;
        float f19 = -1.0f;
        for (RFWPlayerBufferRecode rFWPlayerBufferRecode : rFWPlayerCollectParams.getSecondBufferRecodeList()) {
            if (!z16 && !rFWPlayerBufferRecode.getIsTriggerBySeek()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z17 && rFWPlayerBufferRecode.hasNetWorkWhenBuffStart()) {
                z17 = true;
            } else {
                z17 = false;
            }
            f16 = Math.max(f16, rFWPlayerBufferRecode.getPredictNetKBS());
            f19 = Math.max(f19, rFWPlayerBufferRecode.getBufferCostTimeS());
            f17 = Math.max(f17, rFWPlayerBufferRecode.getFeedTimeCostS());
            f18 = Math.max(f18, rFWPlayerBufferRecode.getPicKBS());
        }
        if (size > 0) {
            jsonObject.addProperty("bfMaySeek", Boolean.valueOf(z16));
            jsonObject.addProperty("bfHasNet", Boolean.valueOf(z17));
            jsonObject.addProperty("bfNetKMaxBS", Float.valueOf(f16));
            jsonObject.addProperty("bfCostMaxS", Float.valueOf(f19));
            jsonObject.addProperty("bfFeedCostMaxS", Float.valueOf(f17));
            jsonObject.addProperty("bfPicKBS", Float.valueOf(f18));
        }
    }

    private void fillTimeS(RFWPlayerCollectParams rFWPlayerCollectParams, long j3) {
        float floatValue = Float.valueOf(a(rFWPlayerCollectParams.getPlayRequestStartTime(), j3)).floatValue();
        if (rFWPlayerCollectParams.getProcessCostTimeS() < 0.0f) {
            rFWPlayerCollectParams.setProcessCostTimeS(floatValue);
        }
        if (rFWPlayerCollectParams.getPrepareCostTimeS() < 0.0f) {
            rFWPlayerCollectParams.setPrepareCostTimeS(floatValue);
        }
        if (rFWPlayerCollectParams.getFirstRenderCostTimeS() < 0.0f) {
            rFWPlayerCollectParams.setFirstRenderCostTimeS(floatValue);
            rFWPlayerCollectParams.setNotStart(true);
        }
    }

    private boolean forceReport(RFWPlayerCollectParams rFWPlayerCollectParams) {
        if (rFWPlayerCollectParams.getWeakNetTipsStatus() > 0) {
            return true;
        }
        return false;
    }

    private String getReportJson(RFWPlayerCollectParams rFWPlayerCollectParams) {
        if (rFWPlayerCollectParams == null) {
            return "";
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(WadlProxyConsts.SCENE_ID, Integer.valueOf(rFWPlayerCollectParams.getSceneId()));
        jsonObject.addProperty("tag", rFWPlayerCollectParams.getTag());
        jsonObject.addProperty("preTag", rFWPlayerCollectParams.getPreloadTag());
        jsonObject.addProperty("playScene", rFWPlayerCollectParams.getPlayScene());
        jsonObject.addProperty("isScrollNext", Boolean.valueOf(rFWPlayerCollectParams.isScrollNext()));
        jsonObject.addProperty("playByResume", Boolean.valueOf(rFWPlayerCollectParams.isPlayByONResume()));
        jsonObject.addProperty("isFloat", Boolean.valueOf(rFWPlayerCollectParams.isFloating()));
        jsonObject.addProperty(PoiDbManager.TBL_POI, Integer.valueOf(rFWPlayerCollectParams.getPoi()));
        jsonObject.addProperty("offset", Float.valueOf(rFWPlayerCollectParams.getOffsetS()));
        jsonObject.addProperty("fileId", rFWPlayerCollectParams.getFileId());
        jsonObject.addProperty("device", Integer.valueOf(rFWPlayerCollectParams.getDeviceLevel()));
        jsonObject.addProperty("netKBS", Float.valueOf(rFWPlayerCollectParams.getNetKBS()));
        jsonObject.addProperty("rate", Float.valueOf(rFWPlayerCollectParams.getRate()));
        jsonObject.addProperty("feedTimeS", Float.valueOf(rFWPlayerCollectParams.getFeedTimes()));
        jsonObject.addProperty("picKBS", Float.valueOf(rFWPlayerCollectParams.getPicTimeS()));
        jsonObject.addProperty("sdkReady", Boolean.valueOf(rFWPlayerCollectParams.isIsSdkReady()));
        jsonObject.addProperty("cacheTimeS", Float.valueOf(rFWPlayerCollectParams.getCanPlayTimeS()));
        jsonObject.addProperty("processTimeS", Float.valueOf(rFWPlayerCollectParams.getProcessCostTimeS()));
        jsonObject.addProperty("prepareTimeS", Float.valueOf(rFWPlayerCollectParams.getPrepareCostTimeS()));
        jsonObject.addProperty("notStart", Boolean.valueOf(rFWPlayerCollectParams.isNotStart()));
        jsonObject.addProperty("firstRenderTimeS", Float.valueOf(rFWPlayerCollectParams.getFirstRenderCostTimeS()));
        jsonObject.addProperty("errorCode", rFWPlayerCollectParams.getPlayerErrorCode());
        jsonObject.addProperty("errorMsg", rFWPlayerCollectParams.getErrorMsg());
        jsonObject.addProperty("msfWeakFlag", Boolean.valueOf(rFWPlayerCollectParams.isMsfWeakNet()));
        jsonObject.addProperty("msfWeakReason", Integer.valueOf(rFWPlayerCollectParams.getMsfWeakNetReason()));
        fillSeekAction(jsonObject, rFWPlayerCollectParams);
        fillBufferAction(jsonObject, rFWPlayerCollectParams);
        jsonObject.addProperty("url", rFWPlayerCollectParams.getRealPlayUrl());
        jsonObject.addProperty("weakNetTips", Integer.valueOf(rFWPlayerCollectParams.getWeakNetTipsStatus()));
        jsonObject.addProperty("userClickTime", rFWPlayerCollectParams.getWeakNetTipsUserClickTime());
        return jsonObject.toString();
    }

    private static boolean hitRate() {
        if (Math.random() <= Double.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_player_collecte_report_rate", MiniAppSoLoader.LOCAL_ENGINE_VERSION)).doubleValue()) {
            return true;
        }
        return false;
    }

    private void report(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).reportLog("play_collect_event_id", new QCircleAlphaUserReportDataBuilder().setExt2("3").setExtraInfo(str));
    }

    private boolean shouldReport(RFWPlayerCollectParams rFWPlayerCollectParams) {
        if (!TextUtils.isEmpty(rFWPlayerCollectParams.getPlayerErrorCode()) || rFWPlayerCollectParams.getSecondBufferRecodeList().size() > 0 || rFWPlayerCollectParams.getFirstRenderCostTimeS() > 1.0f) {
            return true;
        }
        return false;
    }

    public /* synthetic */ String a(long j3, long j16) {
        return a.a(this, j3, j16);
    }

    public /* synthetic */ String b(String str) {
        return a.b(this, str);
    }

    public /* synthetic */ void c(String str, String str2, String str3) {
        a.d(this, str, str2, str3);
    }

    public void onAction(String str, RFWPlayerCollectParams rFWPlayerCollectParams, Object... objArr) {
        if (!TextUtils.isEmpty(str) && rFWPlayerCollectParams != null && objArr.length != 0) {
            Object obj = objArr[0];
            if (obj instanceof Long) {
                fillTimeS(rFWPlayerCollectParams, ((Long) obj).longValue());
                String reportJson = getReportJson(rFWPlayerCollectParams);
                c(b(str), "flush-reportJson", reportJson);
                if (!forceReport(rFWPlayerCollectParams) && (!shouldReport(rFWPlayerCollectParams) || !hitRate())) {
                    return;
                }
                report(reportJson);
                c(b(str), HippyQQPagView.FunctionName.FLUSH, rFWPlayerCollectParams.toString());
            }
        }
    }
}
