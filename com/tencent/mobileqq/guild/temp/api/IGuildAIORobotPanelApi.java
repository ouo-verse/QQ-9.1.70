package com.tencent.mobileqq.guild.temp.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildAIORobotPanelApi extends QRouteApi {
    void sendRobotInlineArk(JSONObject jSONObject, String str, String str2, int i3, String str3);
}
