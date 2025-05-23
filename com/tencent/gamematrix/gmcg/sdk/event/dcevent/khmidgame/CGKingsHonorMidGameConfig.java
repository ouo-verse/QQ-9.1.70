package com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGKingsHonorMidGameConfig {
    public final String bizId;
    public final String bizKey;
    public final String guid;
    public final int loginPlatform;
    public final String midGameId;
    public final String openId;
    public int retryTimes = 0;
    public final String subBizId;
    public final String tag;

    public CGKingsHonorMidGameConfig(String str, int i3, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.guid = str;
        this.loginPlatform = i3;
        this.openId = str2;
        this.midGameId = str3;
        this.tag = str4;
        this.bizId = str5;
        this.subBizId = str6;
        this.bizKey = str7;
    }
}
