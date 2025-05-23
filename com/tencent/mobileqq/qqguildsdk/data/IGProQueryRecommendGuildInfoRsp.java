package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProQueryRecommendGuildInfoRsp extends Serializable {
    byte[] getCookie();

    IGProGuildData getGuildData();

    long getNewDefaultChannelId();

    long getReqInterval();

    IGProRecommendGuildPersonalSetting getSetting();
}
