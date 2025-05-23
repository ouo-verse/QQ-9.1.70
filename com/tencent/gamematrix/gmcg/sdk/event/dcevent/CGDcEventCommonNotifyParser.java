package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CGDcEventCommonNotifyParser implements GmCgDcEventParser {
    private ResultListener mResultListener;

    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onGmCgDcEventCommonNotify(String str, String str2);
    }

    public CGDcEventCommonNotifyParser(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public void parseDcEventDataFromReceive(String str) {
        CGLog.i("parseDcEventCommonDataFromReceive: " + str);
        JSONObject jsonObjectFromJsonObject = CGJsonUtil.getJsonObjectFromJsonObject(CGJsonUtil.getJsonObjectFromString(str), "commonNotifyEvent");
        if (jsonObjectFromJsonObject != null) {
            String stringFromJsonObject = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject, "eventType");
            String stringFromJsonObject2 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject, "desc");
            ResultListener resultListener = this.mResultListener;
            if (resultListener != null) {
                resultListener.onGmCgDcEventCommonNotify(stringFromJsonObject, stringFromJsonObject2);
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_COMMON_NOTIFY_EVENT;
    }
}
