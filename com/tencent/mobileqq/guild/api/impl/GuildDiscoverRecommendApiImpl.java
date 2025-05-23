package com.tencent.mobileqq.guild.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.api.IGuildDiscoverRecommendApi;
import com.tencent.mobileqq.guild.config.GuildDiscoverBannerConfBean;
import com.tencent.mobileqq.guild.util.bs;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildDiscoverRecommendApiImpl implements IGuildDiscoverRecommendApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildDiscoverRecommendApi
    public JSONObject getBannerData() {
        GuildDiscoverBannerConfBean guildDiscoverBannerConfBean = bs.f235483a.h("100582").getGuildDiscoverBannerConfBean();
        JSONObject jSONObject = new JSONObject();
        try {
            if (guildDiscoverBannerConfBean != null) {
                jSONObject.put("enable", guildDiscoverBannerConfBean.getEnable());
                String picUrl = guildDiscoverBannerConfBean.getPicUrl();
                String jumpWebUrl = guildDiscoverBannerConfBean.getJumpWebUrl();
                if (!TextUtils.isEmpty(picUrl)) {
                    jSONObject.put("pic_url", picUrl);
                }
                if (!TextUtils.isEmpty(jumpWebUrl)) {
                    jSONObject.put("jump_url", jumpWebUrl);
                }
            } else {
                jSONObject.put("enable", false);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildDiscoverRecommendApi
    public com.tencent.qqperf.monitor.crash.safemode.a getDiscoverSafeModeStartUpRunner() {
        return fi1.a.f398762a;
    }
}
