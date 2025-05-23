package com.tencent.mobileqq.guild.config;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes13.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private int f216169a = 7;

    /* renamed from: b, reason: collision with root package name */
    private int f216170b = 7;

    /* renamed from: c, reason: collision with root package name */
    private int f216171c = 7;

    /* renamed from: d, reason: collision with root package name */
    private int f216172d = 5;

    /* renamed from: e, reason: collision with root package name */
    private int f216173e = 2;

    /* renamed from: f, reason: collision with root package name */
    private int f216174f = 3;

    /* renamed from: g, reason: collision with root package name */
    private int f216175g = 3;

    /* renamed from: h, reason: collision with root package name */
    private int f216176h = 7;

    /* renamed from: i, reason: collision with root package name */
    private int f216177i = 5;

    /* renamed from: j, reason: collision with root package name */
    private int f216178j = 3;

    /* renamed from: k, reason: collision with root package name */
    private int f216179k = 7;

    /* renamed from: l, reason: collision with root package name */
    private int f216180l = 7;

    /* renamed from: m, reason: collision with root package name */
    private int f216181m = 28;

    /* renamed from: n, reason: collision with root package name */
    private int f216182n = 7;

    /* renamed from: o, reason: collision with root package name */
    private int f216183o = 7;

    /* renamed from: p, reason: collision with root package name */
    private int f216184p = 28;

    public static boolean h(JSONObject jSONObject) {
        return jSONObject.has("recentMsgListTipAlreadyAddedThreshold");
    }

    public static void i(s sVar, JSONObject jSONObject) {
        if (QLog.isDebugVersion()) {
            QLog.d("Guild.config.GuildSubscribeChannelGrayConfig", 2, "jsonObject : " + jSONObject);
        }
        if (jSONObject == null) {
            QLog.d("Guild.config.GuildSubscribeChannelGrayConfig", 2, "jsonObject is null");
        } else {
            k(sVar, jSONObject);
            j(sVar, jSONObject);
        }
    }

    private static void j(s sVar, JSONObject jSONObject) {
        sVar.f216180l = jSONObject.optInt("subscribeChannelGuideDelayPeriod");
        sVar.f216181m = jSONObject.optInt("subscribeChannelGuideMaxDelayDay");
        sVar.f216179k = jSONObject.optInt("subscribeChannelGuideMinDelayDay");
    }

    private static void k(s sVar, JSONObject jSONObject) {
        sVar.f216169a = jSONObject.optInt("recentMsgListTipOpensCycle");
        sVar.f216170b = jSONObject.optInt("recentMsgListTipSpeakingCycle");
        sVar.f216171c = jSONObject.optInt("recentMsgListTipGrayShowCycle");
        sVar.f216172d = jSONObject.optInt("recentMsgListTipOpensThreshold");
        sVar.f216173e = jSONObject.optInt("recentMsgListTipSpeakingThreshold");
        sVar.f216174f = jSONObject.optInt("recentMsgListTipAlreadyAddedThreshold");
        sVar.f216175g = jSONObject.optInt("subscribeChannelGuideShowCycle");
        sVar.f216176h = jSONObject.optInt("subscribeChannelGuideJudgeCycle");
        sVar.f216177i = jSONObject.optInt("subscribeChannelBubbleOpensThreshold");
        sVar.f216178j = jSONObject.optInt("subscribeChannelGrayTipOpensThreshold");
    }

    public int a() {
        return this.f216174f;
    }

    public int b() {
        return this.f216175g;
    }

    public int c() {
        return this.f216176h;
    }

    public int d() {
        return this.f216171c;
    }

    public int e() {
        return this.f216169a;
    }

    public int f() {
        return this.f216172d;
    }

    public int g() {
        return this.f216173e;
    }
}
