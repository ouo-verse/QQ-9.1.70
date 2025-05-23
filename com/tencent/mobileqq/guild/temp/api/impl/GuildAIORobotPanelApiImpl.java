package com.tencent.mobileqq.guild.temp.api.impl;

import com.tencent.mobileqq.guild.temp.api.IGuildAIORobotPanelApi;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class GuildAIORobotPanelApiImpl implements IGuildAIORobotPanelApi {
    @Override // com.tencent.mobileqq.guild.temp.api.IGuildAIORobotPanelApi
    public void sendRobotInlineArk(JSONObject jSONObject, String str, String str2, int i3, String str3) {
        tw1.a.c(jSONObject, str, str2, i3, str3);
    }
}
