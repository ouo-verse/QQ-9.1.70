package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CGDcEventLoginResultParser implements GmCgDcEventParser {
    private ResultListener mResultListener;

    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onGmCgDcEventLoginResult(String str, int i3, boolean z16);
    }

    public CGDcEventLoginResultParser(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public void parseDcEventDataFromReceive(String str) {
        boolean z16;
        JSONObject jsonObjectFromJsonObject = CGJsonUtil.getJsonObjectFromJsonObject(CGJsonUtil.getJsonObjectFromString(str), "loginRet");
        if (jsonObjectFromJsonObject != null) {
            String stringFromJsonObject = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject, "login_result");
            String stringFromJsonObject2 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject, "open_id");
            String stringFromJsonObject3 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject, "login_channel");
            int i3 = 0;
            if ("true".equalsIgnoreCase(stringFromJsonObject)) {
                z16 = true;
            } else {
                "false".equalsIgnoreCase(stringFromJsonObject);
                z16 = false;
            }
            if ("qq".equalsIgnoreCase(stringFromJsonObject3)) {
                i3 = 2;
            } else if ("wechat".equalsIgnoreCase(stringFromJsonObject3)) {
                i3 = 1;
            }
            ResultListener resultListener = this.mResultListener;
            if (resultListener != null) {
                resultListener.onGmCgDcEventLoginResult(stringFromJsonObject2, i3, z16);
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_LOGIN_RESULT;
    }
}
