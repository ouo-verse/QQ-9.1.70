package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CGDcEventGameScreenRotateParser implements GmCgDcEventParser {
    private ResultListener mResultListener;

    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onGmCgDcEventAppStatus(int i3);
    }

    public CGDcEventGameScreenRotateParser(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public void parseDcEventDataFromReceive(String str) {
        CGLog.i("CGDcEventGameScreenRotateParser data: " + str);
        JSONObject jsonObjectFromJsonObject = CGJsonUtil.getJsonObjectFromJsonObject(CGJsonUtil.getJsonObjectFromString(str), "screenRotateReq");
        if (jsonObjectFromJsonObject != null) {
            String stringFromJsonObject = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject, "orientation");
            int i3 = 1;
            if (!stringFromJsonObject.equals("VERTICAL") && stringFromJsonObject.equals("HORIZONTAL")) {
                i3 = 2;
            }
            ResultListener resultListener = this.mResultListener;
            if (resultListener != null) {
                resultListener.onGmCgDcEventAppStatus(i3);
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_SCREEN_ROTATE;
    }
}
