package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class QVipPubAccountConfig {
    private static int animationStartTime = 1000;
    private static String gameHomeUrl = "https://club.vip.qq.com/game?_proxy=1&_wv=16777221&_wvx=10&g_ch=gzh";
    private static String nativeBarUrl = "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_alpha=0&pay_src=10&_wvx=10&_proxy=1";
    private static String pubAccountH5Url = "https://club.vip.qq.com/official?_wv=16778247&_wwv=68&_nav_alpha=0&pay_src=10&_wvx=10&_proxy=1";
    private boolean isEnable = false;

    @NonNull
    public static QVipPubAccountConfig fromJson(String str) {
        QVipPubAccountConfig qVipPubAccountConfig = new QVipPubAccountConfig();
        if (TextUtils.isEmpty(str)) {
            qVipPubAccountConfig.isEnable = false;
            return qVipPubAccountConfig;
        }
        getDataFromJson(str);
        qVipPubAccountConfig.isEnable = true;
        return qVipPubAccountConfig;
    }

    public static int getAnimationStartTime() {
        return animationStartTime;
    }

    private static void getDataFromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            pubAccountH5Url = jSONObject.getString("qqvip_vip_account");
            nativeBarUrl = jSONObject.getString("nativebar_url");
            gameHomeUrl = jSONObject.getString("game_home_url");
            animationStartTime = jSONObject.getInt("ani_start_time");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public static String getGameHomeUrl() {
        return gameHomeUrl;
    }

    public static String getNativeBarUrl() {
        return nativeBarUrl;
    }

    public static String getPubAccountH5Url() {
        return pubAccountH5Url;
    }

    public Boolean isPubAccountEnable() {
        return Boolean.valueOf(this.isEnable);
    }
}
