package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CGDcEventLoginRequestParser implements GmCgDcEventParser {
    private ResultListener mResultListener;

    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onGmCgDcEventLoginRequest(int i3);
    }

    public CGDcEventLoginRequestParser(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public void parseDcEventDataFromReceive(String str) {
        int i3;
        JSONObject jsonObjectFromJsonObject = CGJsonUtil.getJsonObjectFromJsonObject(CGJsonUtil.getJsonObjectFromString(str), "loginRequest");
        if (jsonObjectFromJsonObject != null) {
            String stringFromJsonObject = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject, MsfConstants.ATTRIBUTE_LOGIN_TYPE);
            if ("wechat".equalsIgnoreCase(stringFromJsonObject)) {
                i3 = 1;
            } else if ("qq".equalsIgnoreCase(stringFromJsonObject)) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            ResultListener resultListener = this.mResultListener;
            if (resultListener != null) {
                resultListener.onGmCgDcEventLoginRequest(i3);
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_LOGIN_REQUEST;
    }
}
