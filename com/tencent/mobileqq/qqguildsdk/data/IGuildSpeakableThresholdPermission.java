package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGuildSpeakableThresholdPermission extends Serializable {
    long getDirectMsgLimitTime();

    int getDirectMsgLimitType();

    long getGuildLimitTime();

    int getGuildLimitType();

    long getJoinTime();

    String getVerifyUrl();
}
