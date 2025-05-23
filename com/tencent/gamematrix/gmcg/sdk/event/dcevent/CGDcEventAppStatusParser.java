package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CGDcEventAppStatusParser implements GmCgDcEventParser {
    private ResultListener mResultListener;

    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onGmCgDcEventAppStatus(String str);
    }

    public CGDcEventAppStatusParser(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public void parseDcEventDataFromReceive(String str) {
        JSONObject jsonObjectFromJsonObject = CGJsonUtil.getJsonObjectFromJsonObject(CGJsonUtil.getJsonObjectFromString(str), "appStatus");
        if (jsonObjectFromJsonObject != null) {
            String stringFromJsonObject = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject, "eventType");
            ResultListener resultListener = this.mResultListener;
            if (resultListener != null) {
                resultListener.onGmCgDcEventAppStatus(stringFromJsonObject);
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_APP_STATUS_EVENT;
    }
}
