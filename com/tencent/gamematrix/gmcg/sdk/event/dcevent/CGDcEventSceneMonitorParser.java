package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import android.content.Intent;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CGDcEventSceneMonitorParser implements GmCgDcEventParser {
    private final String mPackageName;

    public CGDcEventSceneMonitorParser(String str) {
        this.mPackageName = str;
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public void parseDcEventDataFromReceive(String str) {
        String stringFromJsonObject = CGJsonUtil.getStringFromJsonObject(CGJsonUtil.getJsonObjectFromString(str), "androidEvent");
        if (stringFromJsonObject != null) {
            JSONObject jsonObjectFromString = CGJsonUtil.getJsonObjectFromString(stringFromJsonObject);
            int intFromJsonObject = CGJsonUtil.getIntFromJsonObject(jsonObjectFromString, "scene", -1);
            boolean boolFromJsonObject = CGJsonUtil.getBoolFromJsonObject(jsonObjectFromString, "isSceneLeft");
            String stringFromJsonObject2 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromString, "sceneElements");
            CGLog.i("CGDcEventSceneMonitorParser parseDcEventDataFromReceive: scene gpu");
            Intent intent = new Intent("com.tencent.gamematrix.ACTION_SCENE_FORWARD");
            intent.putExtra("com.tencent.gamematrix.extra.PACKAGE_NAME", this.mPackageName);
            intent.putExtra("com.tencent.gamematrix.extra.SCENE", intFromJsonObject);
            intent.putExtra("com.tencent.gamematrix.extra.SCENEELEMENTS", stringFromJsonObject2);
            intent.putExtra("com.tencent.gamematrix.extra.ISSCENELEFT", boolFromJsonObject);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_SCENE_MONITOR;
    }
}
