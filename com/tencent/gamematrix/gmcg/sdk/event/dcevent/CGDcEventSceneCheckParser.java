package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGTimeUtil;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CGDcEventSceneCheckParser implements GmCgDcEventParser {
    private ResultListener mResultListener;

    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onGmCgDcEventSceneCheck(boolean z16, int i3, long j3);
    }

    public CGDcEventSceneCheckParser(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public void parseDcEventDataFromReceive(String str) {
        JSONObject jsonObjectFromJsonObject = CGJsonUtil.getJsonObjectFromJsonObject(CGJsonUtil.getJsonObjectFromString(str), "sceneCheckEvent");
        if (jsonObjectFromJsonObject != null) {
            int i3 = 1;
            if ("false".equals(CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject, "exitGame"))) {
                JSONObject jsonObjectFromJsonObject2 = CGJsonUtil.getJsonObjectFromJsonObject(jsonObjectFromJsonObject, "gameOver");
                if (jsonObjectFromJsonObject2 != null) {
                    String stringFromJsonObject = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "gameWin");
                    String stringFromJsonObject2 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "gameDuration");
                    if (!"true".equals(stringFromJsonObject)) {
                        if ("false".equals(stringFromJsonObject)) {
                            i3 = 0;
                        } else {
                            i3 = 2;
                        }
                    }
                    long secondsFromFormatString = CGTimeUtil.getSecondsFromFormatString(stringFromJsonObject2);
                    ResultListener resultListener = this.mResultListener;
                    if (resultListener != null) {
                        resultListener.onGmCgDcEventSceneCheck(false, i3, secondsFromFormatString);
                        return;
                    }
                    return;
                }
                ResultListener resultListener2 = this.mResultListener;
                if (resultListener2 != null) {
                    resultListener2.onGmCgDcEventSceneCheck(false, 2, 0L);
                    return;
                }
                return;
            }
            ResultListener resultListener3 = this.mResultListener;
            if (resultListener3 != null) {
                resultListener3.onGmCgDcEventSceneCheck(true, 0, 0L);
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_SCENE_CHECK_EVENT;
    }
}
