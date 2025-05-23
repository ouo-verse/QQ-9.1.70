package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CGDcEventAppLaunchParser implements GmCgDcEventParser {
    private String mPackageName;
    private ResultListener mResultListener;

    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onGmCgDcEventAppLaunch();
    }

    public CGDcEventAppLaunchParser(String str, ResultListener resultListener) {
        this.mPackageName = str;
        this.mResultListener = resultListener;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public void parseDcEventDataFromReceive(String str) {
        ResultListener resultListener;
        JSONObject jsonObjectFromJsonObject = CGJsonUtil.getJsonObjectFromJsonObject(CGJsonUtil.getJsonObjectFromString(str), "launchEvent");
        if (jsonObjectFromJsonObject != null && CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject, "packageName").equals(this.mPackageName) && (resultListener = this.mResultListener) != null) {
            resultListener.onGmCgDcEventAppLaunch();
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_APP_LAUNCH_EVENT;
    }
}
