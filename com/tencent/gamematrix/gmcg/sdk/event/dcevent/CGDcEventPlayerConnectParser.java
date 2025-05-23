package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CGDcEventPlayerConnectParser implements GmCgDcEventParser {
    private ResultListener mResultListener;

    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onGmCgDcEventPlayerConnect(int i3, int i16);
    }

    public CGDcEventPlayerConnectParser(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public void parseDcEventDataFromReceive(String str) {
        JSONObject jsonObjectFromString = CGJsonUtil.getJsonObjectFromString(str);
        int intFromJsonObject = CGJsonUtil.getIntFromJsonObject(jsonObjectFromString, "player_index");
        int intFromJsonObject2 = CGJsonUtil.getIntFromJsonObject(jsonObjectFromString, CGNonAgeReport.EVENT_TYPE);
        ResultListener resultListener = this.mResultListener;
        if (resultListener != null) {
            resultListener.onGmCgDcEventPlayerConnect(intFromJsonObject, intFromJsonObject2);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_PLAYER_CONNECT;
    }
}
