package com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame;

import android.text.TextUtils;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CGDcEventKingsHonorMidResponseParser implements GmCgDcEventParser {
    private final ResultListener mResultListener;

    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onGmCgDcEventKingsHonorMidGameAbnormal(CGKingsHonorMidAbnormalResponse cGKingsHonorMidAbnormalResponse);

        void onGmCgDcEventKingsHonorMidGameAck(CGKingsHonorMidAckMessage cGKingsHonorMidAckMessage);

        void onGmCgDcEventKingsHonorMidGameEnd(CGKingsHonorMidEndResponse cGKingsHonorMidEndResponse);
    }

    public CGDcEventKingsHonorMidResponseParser(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    private void onMidGameAbnormal(String str) {
        ResultListener resultListener;
        CGKingsHonorMidAbnormalResponse cGKingsHonorMidAbnormalResponse = (CGKingsHonorMidAbnormalResponse) CGJsonUtil.fromJson(str, (Class<?>) CGKingsHonorMidAbnormalResponse.class);
        if (cGKingsHonorMidAbnormalResponse != null && (resultListener = this.mResultListener) != null) {
            resultListener.onGmCgDcEventKingsHonorMidGameAbnormal(cGKingsHonorMidAbnormalResponse);
        }
    }

    private void onMidGameAckResponse(String str) {
        ResultListener resultListener;
        CGKingsHonorMidAckMessage cGKingsHonorMidAckMessage = (CGKingsHonorMidAckMessage) CGJsonUtil.fromJson(str, (Class<?>) CGKingsHonorMidAckMessage.class);
        if (cGKingsHonorMidAckMessage != null && GmCgDcEventDefine.HK_EVENT_MIDGAME_ACK.equals(cGKingsHonorMidAckMessage.type) && (resultListener = this.mResultListener) != null) {
            resultListener.onGmCgDcEventKingsHonorMidGameAck(cGKingsHonorMidAckMessage);
        }
    }

    private void onMidGameEndResponse(String str) {
        ResultListener resultListener;
        CGKingsHonorMidEndResponse cGKingsHonorMidEndResponse = (CGKingsHonorMidEndResponse) CGJsonUtil.fromJson(str, (Class<?>) CGKingsHonorMidEndResponse.class);
        if (cGKingsHonorMidEndResponse != null && GmCgDcEventDefine.HK_EVENT_MIDGAME_END.equals(cGKingsHonorMidEndResponse.type) && (resultListener = this.mResultListener) != null) {
            resultListener.onGmCgDcEventKingsHonorMidGameEnd(cGKingsHonorMidEndResponse);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public void parseDcEventDataFromReceive(String str) {
        CGLog.i(CGStringUtil.format("CGDcEventKingsHonorMidEndParser: %s", str));
        JSONObject jsonObjectFromJsonObject = CGJsonUtil.getJsonObjectFromJsonObject(CGJsonUtil.toJSONObject(str), "androidEvent");
        if (jsonObjectFromJsonObject == null || !GmCgDcEventDefine.HK_EVENT_GAME_NOTIFY.equals(CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject, "cmd"))) {
            return;
        }
        String stringFromJsonObject = CGJsonUtil.getStringFromJsonObject(CGJsonUtil.getJsonObjectFromJsonObject(jsonObjectFromJsonObject, "data"), "event");
        if (TextUtils.isEmpty(stringFromJsonObject)) {
            return;
        }
        if (stringFromJsonObject.contains(GmCgDcEventDefine.HK_EVENT_MIDGAME_ABNORMAL)) {
            onMidGameAbnormal(stringFromJsonObject);
        } else if (stringFromJsonObject.contains(GmCgDcEventDefine.HK_EVENT_MIDGAME_END)) {
            onMidGameEndResponse(stringFromJsonObject);
        } else if (stringFromJsonObject.contains(GmCgDcEventDefine.HK_EVENT_MIDGAME_ACK)) {
            onMidGameAckResponse(stringFromJsonObject);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_ANDROID_EVENT;
    }
}
