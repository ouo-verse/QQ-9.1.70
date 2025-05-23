package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelConfig;
import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProHeartbeatRsq extends Serializable {
    IGProAVChannelConfig getAVChannelConfig();

    long getChannelId();

    int getForceExit();

    long getGuildId();

    long getNextHeartBeatInterval();

    long getNoStreamDisconnectTrtcSecond();

    String getShowTips();
}
